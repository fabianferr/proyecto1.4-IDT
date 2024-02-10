package org.apache.http.protocol;

import java.io.IOException;
import org.apache.http.ConnectionReuseStrategy;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseFactory;
import org.apache.http.HttpServerConnection;
import org.apache.http.HttpVersion;
import org.apache.http.MethodNotSupportedException;
import org.apache.http.ProtocolException;
import org.apache.http.ProtocolVersion;
import org.apache.http.UnsupportedHttpVersionException;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.params.DefaultedHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EncodingUtils;
import org.apache.http.util.EntityUtils;

public class HttpService {
    private volatile ConnectionReuseStrategy connStrategy;
    private volatile HttpExpectationVerifier expectationVerifier;
    private volatile HttpRequestHandlerResolver handlerResolver;
    private volatile HttpParams params;
    private volatile HttpProcessor processor;
    private volatile HttpResponseFactory responseFactory;

    public HttpService(HttpProcessor httpProcessor, ConnectionReuseStrategy connectionReuseStrategy, HttpResponseFactory httpResponseFactory, HttpRequestHandlerResolver httpRequestHandlerResolver, HttpExpectationVerifier httpExpectationVerifier, HttpParams httpParams) {
        this.params = null;
        this.processor = null;
        this.handlerResolver = null;
        this.connStrategy = null;
        this.responseFactory = null;
        this.expectationVerifier = null;
        if (httpProcessor == null) {
            throw new IllegalArgumentException("HTTP processor may not be null");
        } else if (connectionReuseStrategy == null) {
            throw new IllegalArgumentException("Connection reuse strategy may not be null");
        } else if (httpResponseFactory == null) {
            throw new IllegalArgumentException("Response factory may not be null");
        } else if (httpParams != null) {
            this.processor = httpProcessor;
            this.connStrategy = connectionReuseStrategy;
            this.responseFactory = httpResponseFactory;
            this.handlerResolver = httpRequestHandlerResolver;
            this.expectationVerifier = httpExpectationVerifier;
            this.params = httpParams;
        } else {
            throw new IllegalArgumentException("HTTP parameters may not be null");
        }
    }

    public HttpService(HttpProcessor httpProcessor, ConnectionReuseStrategy connectionReuseStrategy, HttpResponseFactory httpResponseFactory, HttpRequestHandlerResolver httpRequestHandlerResolver, HttpParams httpParams) {
        this(httpProcessor, connectionReuseStrategy, httpResponseFactory, httpRequestHandlerResolver, (HttpExpectationVerifier) null, httpParams);
    }

    public HttpService(HttpProcessor httpProcessor, ConnectionReuseStrategy connectionReuseStrategy, HttpResponseFactory httpResponseFactory) {
        this.params = null;
        this.processor = null;
        this.handlerResolver = null;
        this.connStrategy = null;
        this.responseFactory = null;
        this.expectationVerifier = null;
        setHttpProcessor(httpProcessor);
        setConnReuseStrategy(connectionReuseStrategy);
        setResponseFactory(httpResponseFactory);
    }

    public void setHttpProcessor(HttpProcessor httpProcessor) {
        if (httpProcessor != null) {
            this.processor = httpProcessor;
            return;
        }
        throw new IllegalArgumentException("HTTP processor may not be null");
    }

    public void setConnReuseStrategy(ConnectionReuseStrategy connectionReuseStrategy) {
        if (connectionReuseStrategy != null) {
            this.connStrategy = connectionReuseStrategy;
            return;
        }
        throw new IllegalArgumentException("Connection reuse strategy may not be null");
    }

    public void setResponseFactory(HttpResponseFactory httpResponseFactory) {
        if (httpResponseFactory != null) {
            this.responseFactory = httpResponseFactory;
            return;
        }
        throw new IllegalArgumentException("Response factory may not be null");
    }

    public void setParams(HttpParams httpParams) {
        this.params = httpParams;
    }

    public void setHandlerResolver(HttpRequestHandlerResolver httpRequestHandlerResolver) {
        this.handlerResolver = httpRequestHandlerResolver;
    }

    public void setExpectationVerifier(HttpExpectationVerifier httpExpectationVerifier) {
        this.expectationVerifier = httpExpectationVerifier;
    }

    public HttpParams getParams() {
        return this.params;
    }

    public void handleRequest(HttpServerConnection httpServerConnection, HttpContext httpContext) throws IOException, HttpException {
        HttpResponse httpResponse;
        httpContext.setAttribute(ExecutionContext.HTTP_CONNECTION, httpServerConnection);
        try {
            HttpRequest receiveRequestHeader = httpServerConnection.receiveRequestHeader();
            receiveRequestHeader.setParams(new DefaultedHttpParams(receiveRequestHeader.getParams(), this.params));
            ProtocolVersion protocolVersion = receiveRequestHeader.getRequestLine().getProtocolVersion();
            if (!protocolVersion.lessEquals(HttpVersion.HTTP_1_1)) {
                protocolVersion = HttpVersion.HTTP_1_1;
            }
            httpResponse = null;
            if (receiveRequestHeader instanceof HttpEntityEnclosingRequest) {
                if (((HttpEntityEnclosingRequest) receiveRequestHeader).expectContinue()) {
                    HttpResponse newHttpResponse = this.responseFactory.newHttpResponse(protocolVersion, 100, httpContext);
                    newHttpResponse.setParams(new DefaultedHttpParams(newHttpResponse.getParams(), this.params));
                    if (this.expectationVerifier != null) {
                        try {
                            this.expectationVerifier.verify(receiveRequestHeader, newHttpResponse, httpContext);
                        } catch (HttpException e) {
                            HttpResponse newHttpResponse2 = this.responseFactory.newHttpResponse(HttpVersion.HTTP_1_0, 500, httpContext);
                            newHttpResponse2.setParams(new DefaultedHttpParams(newHttpResponse2.getParams(), this.params));
                            handleException(e, newHttpResponse2);
                            newHttpResponse = newHttpResponse2;
                        }
                    }
                    if (newHttpResponse.getStatusLine().getStatusCode() < 200) {
                        httpServerConnection.sendResponseHeader(newHttpResponse);
                        httpServerConnection.flush();
                        httpServerConnection.receiveRequestEntity((HttpEntityEnclosingRequest) receiveRequestHeader);
                    } else {
                        httpResponse = newHttpResponse;
                    }
                } else {
                    httpServerConnection.receiveRequestEntity((HttpEntityEnclosingRequest) receiveRequestHeader);
                }
            }
            if (httpResponse == null) {
                httpResponse = this.responseFactory.newHttpResponse(protocolVersion, 200, httpContext);
                httpResponse.setParams(new DefaultedHttpParams(httpResponse.getParams(), this.params));
                httpContext.setAttribute(ExecutionContext.HTTP_REQUEST, receiveRequestHeader);
                httpContext.setAttribute(ExecutionContext.HTTP_RESPONSE, httpResponse);
                this.processor.process(receiveRequestHeader, httpContext);
                doService(receiveRequestHeader, httpResponse, httpContext);
            }
            if (receiveRequestHeader instanceof HttpEntityEnclosingRequest) {
                EntityUtils.consume(((HttpEntityEnclosingRequest) receiveRequestHeader).getEntity());
            }
        } catch (HttpException e2) {
            httpResponse = this.responseFactory.newHttpResponse(HttpVersion.HTTP_1_0, 500, httpContext);
            httpResponse.setParams(new DefaultedHttpParams(httpResponse.getParams(), this.params));
            handleException(e2, httpResponse);
        }
        this.processor.process(httpResponse, httpContext);
        httpServerConnection.sendResponseHeader(httpResponse);
        httpServerConnection.sendResponseEntity(httpResponse);
        httpServerConnection.flush();
        if (!this.connStrategy.keepAlive(httpResponse, httpContext)) {
            httpServerConnection.close();
        }
    }

    /* access modifiers changed from: protected */
    public void handleException(HttpException httpException, HttpResponse httpResponse) {
        if (httpException instanceof MethodNotSupportedException) {
            httpResponse.setStatusCode(501);
        } else if (httpException instanceof UnsupportedHttpVersionException) {
            httpResponse.setStatusCode(505);
        } else if (httpException instanceof ProtocolException) {
            httpResponse.setStatusCode(400);
        } else {
            httpResponse.setStatusCode(500);
        }
        ByteArrayEntity byteArrayEntity = new ByteArrayEntity(EncodingUtils.getAsciiBytes(httpException.getMessage()));
        byteArrayEntity.setContentType("text/plain; charset=US-ASCII");
        httpResponse.setEntity(byteArrayEntity);
    }

    /* access modifiers changed from: protected */
    public void doService(HttpRequest httpRequest, HttpResponse httpResponse, HttpContext httpContext) throws HttpException, IOException {
        HttpRequestHandler httpRequestHandler;
        if (this.handlerResolver != null) {
            httpRequestHandler = this.handlerResolver.lookup(httpRequest.getRequestLine().getUri());
        } else {
            httpRequestHandler = null;
        }
        if (httpRequestHandler != null) {
            httpRequestHandler.handle(httpRequest, httpResponse, httpContext);
        } else {
            httpResponse.setStatusCode(501);
        }
    }
}

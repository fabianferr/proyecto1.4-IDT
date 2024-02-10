package org.apache.http.protocol;

import java.io.IOException;
import java.net.ProtocolException;
import org.apache.http.HttpClientConnection;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.ProtocolVersion;
import org.apache.http.params.CoreProtocolPNames;

public class HttpRequestExecutor {
    /* access modifiers changed from: protected */
    public boolean canResponseHaveBody(HttpRequest httpRequest, HttpResponse httpResponse) {
        int statusCode;
        if ("HEAD".equalsIgnoreCase(httpRequest.getRequestLine().getMethod()) || (statusCode = httpResponse.getStatusLine().getStatusCode()) < 200 || statusCode == 204 || statusCode == 304 || statusCode == 205) {
            return false;
        }
        return true;
    }

    public HttpResponse execute(HttpRequest httpRequest, HttpClientConnection httpClientConnection, HttpContext httpContext) throws IOException, HttpException {
        if (httpRequest == null) {
            throw new IllegalArgumentException("HTTP request may not be null");
        } else if (httpClientConnection == null) {
            throw new IllegalArgumentException("Client connection may not be null");
        } else if (httpContext != null) {
            try {
                HttpResponse doSendRequest = doSendRequest(httpRequest, httpClientConnection, httpContext);
                return doSendRequest == null ? doReceiveResponse(httpRequest, httpClientConnection, httpContext) : doSendRequest;
            } catch (IOException e) {
                closeConnection(httpClientConnection);
                throw e;
            } catch (HttpException e2) {
                closeConnection(httpClientConnection);
                throw e2;
            } catch (RuntimeException e3) {
                closeConnection(httpClientConnection);
                throw e3;
            }
        } else {
            throw new IllegalArgumentException("HTTP context may not be null");
        }
    }

    private static final void closeConnection(HttpClientConnection httpClientConnection) {
        try {
            httpClientConnection.close();
        } catch (IOException unused) {
        }
    }

    public void preProcess(HttpRequest httpRequest, HttpProcessor httpProcessor, HttpContext httpContext) throws HttpException, IOException {
        if (httpRequest == null) {
            throw new IllegalArgumentException("HTTP request may not be null");
        } else if (httpProcessor == null) {
            throw new IllegalArgumentException("HTTP processor may not be null");
        } else if (httpContext != null) {
            httpContext.setAttribute(ExecutionContext.HTTP_REQUEST, httpRequest);
            httpProcessor.process(httpRequest, httpContext);
        } else {
            throw new IllegalArgumentException("HTTP context may not be null");
        }
    }

    /* access modifiers changed from: protected */
    public HttpResponse doSendRequest(HttpRequest httpRequest, HttpClientConnection httpClientConnection, HttpContext httpContext) throws IOException, HttpException {
        if (httpRequest == null) {
            throw new IllegalArgumentException("HTTP request may not be null");
        } else if (httpClientConnection == null) {
            throw new IllegalArgumentException("HTTP connection may not be null");
        } else if (httpContext != null) {
            httpContext.setAttribute(ExecutionContext.HTTP_CONNECTION, httpClientConnection);
            httpContext.setAttribute(ExecutionContext.HTTP_REQ_SENT, Boolean.FALSE);
            httpClientConnection.sendRequestHeader(httpRequest);
            HttpResponse httpResponse = null;
            if (httpRequest instanceof HttpEntityEnclosingRequest) {
                ProtocolVersion protocolVersion = httpRequest.getRequestLine().getProtocolVersion();
                HttpEntityEnclosingRequest httpEntityEnclosingRequest = (HttpEntityEnclosingRequest) httpRequest;
                boolean z = true;
                if (httpEntityEnclosingRequest.expectContinue() && !protocolVersion.lessEquals(HttpVersion.HTTP_1_0)) {
                    httpClientConnection.flush();
                    if (httpClientConnection.isResponseAvailable(httpRequest.getParams().getIntParameter(CoreProtocolPNames.WAIT_FOR_CONTINUE, 2000))) {
                        HttpResponse receiveResponseHeader = httpClientConnection.receiveResponseHeader();
                        if (canResponseHaveBody(httpRequest, receiveResponseHeader)) {
                            httpClientConnection.receiveResponseEntity(receiveResponseHeader);
                        }
                        int statusCode = receiveResponseHeader.getStatusLine().getStatusCode();
                        if (statusCode >= 200) {
                            z = false;
                            httpResponse = receiveResponseHeader;
                        } else if (statusCode != 100) {
                            throw new ProtocolException(new StringBuffer("Unexpected response: ").append(receiveResponseHeader.getStatusLine()).toString());
                        }
                    }
                }
                if (z) {
                    httpClientConnection.sendRequestEntity(httpEntityEnclosingRequest);
                }
            }
            httpClientConnection.flush();
            httpContext.setAttribute(ExecutionContext.HTTP_REQ_SENT, Boolean.TRUE);
            return httpResponse;
        } else {
            throw new IllegalArgumentException("HTTP context may not be null");
        }
    }

    /* access modifiers changed from: protected */
    public HttpResponse doReceiveResponse(HttpRequest httpRequest, HttpClientConnection httpClientConnection, HttpContext httpContext) throws HttpException, IOException {
        if (httpRequest == null) {
            throw new IllegalArgumentException("HTTP request may not be null");
        } else if (httpClientConnection == null) {
            throw new IllegalArgumentException("HTTP connection may not be null");
        } else if (httpContext != null) {
            HttpResponse httpResponse = null;
            int i = 0;
            while (true) {
                if (httpResponse != null && i >= 200) {
                    return httpResponse;
                }
                httpResponse = httpClientConnection.receiveResponseHeader();
                if (canResponseHaveBody(httpRequest, httpResponse)) {
                    httpClientConnection.receiveResponseEntity(httpResponse);
                }
                i = httpResponse.getStatusLine().getStatusCode();
            }
        } else {
            throw new IllegalArgumentException("HTTP context may not be null");
        }
    }

    public void postProcess(HttpResponse httpResponse, HttpProcessor httpProcessor, HttpContext httpContext) throws HttpException, IOException {
        if (httpResponse == null) {
            throw new IllegalArgumentException("HTTP response may not be null");
        } else if (httpProcessor == null) {
            throw new IllegalArgumentException("HTTP processor may not be null");
        } else if (httpContext != null) {
            httpContext.setAttribute(ExecutionContext.HTTP_RESPONSE, httpResponse);
            httpProcessor.process(httpResponse, httpContext);
        } else {
            throw new IllegalArgumentException("HTTP context may not be null");
        }
    }
}

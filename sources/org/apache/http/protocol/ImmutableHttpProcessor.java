package org.apache.http.protocol;

import java.io.IOException;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;

public final class ImmutableHttpProcessor implements HttpProcessor {
    private final HttpRequestInterceptor[] requestInterceptors;
    private final HttpResponseInterceptor[] responseInterceptors;

    public ImmutableHttpProcessor(HttpRequestInterceptor[] httpRequestInterceptorArr, HttpResponseInterceptor[] httpResponseInterceptorArr) {
        if (httpRequestInterceptorArr != null) {
            int length = httpRequestInterceptorArr.length;
            this.requestInterceptors = new HttpRequestInterceptor[length];
            for (int i = 0; i < length; i++) {
                this.requestInterceptors[i] = httpRequestInterceptorArr[i];
            }
        } else {
            this.requestInterceptors = new HttpRequestInterceptor[0];
        }
        if (httpResponseInterceptorArr != null) {
            int length2 = httpResponseInterceptorArr.length;
            this.responseInterceptors = new HttpResponseInterceptor[length2];
            for (int i2 = 0; i2 < length2; i2++) {
                this.responseInterceptors[i2] = httpResponseInterceptorArr[i2];
            }
            return;
        }
        this.responseInterceptors = new HttpResponseInterceptor[0];
    }

    public ImmutableHttpProcessor(HttpRequestInterceptorList httpRequestInterceptorList, HttpResponseInterceptorList httpResponseInterceptorList) {
        if (httpRequestInterceptorList != null) {
            int requestInterceptorCount = httpRequestInterceptorList.getRequestInterceptorCount();
            this.requestInterceptors = new HttpRequestInterceptor[requestInterceptorCount];
            for (int i = 0; i < requestInterceptorCount; i++) {
                this.requestInterceptors[i] = httpRequestInterceptorList.getRequestInterceptor(i);
            }
        } else {
            this.requestInterceptors = new HttpRequestInterceptor[0];
        }
        if (httpResponseInterceptorList != null) {
            int responseInterceptorCount = httpResponseInterceptorList.getResponseInterceptorCount();
            this.responseInterceptors = new HttpResponseInterceptor[responseInterceptorCount];
            for (int i2 = 0; i2 < responseInterceptorCount; i2++) {
                this.responseInterceptors[i2] = httpResponseInterceptorList.getResponseInterceptor(i2);
            }
            return;
        }
        this.responseInterceptors = new HttpResponseInterceptor[0];
    }

    public ImmutableHttpProcessor(HttpRequestInterceptor[] httpRequestInterceptorArr) {
        this(httpRequestInterceptorArr, (HttpResponseInterceptor[]) null);
    }

    public ImmutableHttpProcessor(HttpResponseInterceptor[] httpResponseInterceptorArr) {
        this((HttpRequestInterceptor[]) null, httpResponseInterceptorArr);
    }

    public void process(HttpRequest httpRequest, HttpContext httpContext) throws IOException, HttpException {
        int i = 0;
        while (true) {
            HttpRequestInterceptor[] httpRequestInterceptorArr = this.requestInterceptors;
            if (i < httpRequestInterceptorArr.length) {
                httpRequestInterceptorArr[i].process(httpRequest, httpContext);
                i++;
            } else {
                return;
            }
        }
    }

    public void process(HttpResponse httpResponse, HttpContext httpContext) throws IOException, HttpException {
        int i = 0;
        while (true) {
            HttpResponseInterceptor[] httpResponseInterceptorArr = this.responseInterceptors;
            if (i < httpResponseInterceptorArr.length) {
                httpResponseInterceptorArr[i].process(httpResponse, httpContext);
                i++;
            } else {
                return;
            }
        }
    }
}

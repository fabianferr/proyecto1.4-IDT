package com.cellrebel.sdk;

import okhttp3.Interceptor;
import okhttp3.Response;

public class InterceptRequest implements Interceptor {
    public Response intercept(Interceptor.Chain chain) {
        return chain.proceed(chain.request());
    }
}

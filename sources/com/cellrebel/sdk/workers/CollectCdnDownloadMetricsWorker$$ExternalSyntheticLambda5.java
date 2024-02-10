package com.cellrebel.sdk.workers;

import okhttp3.Interceptor;
import okhttp3.Response;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class CollectCdnDownloadMetricsWorker$$ExternalSyntheticLambda5 implements Interceptor {
    public final Response intercept(Interceptor.Chain chain) {
        return chain.proceed(chain.request());
    }
}

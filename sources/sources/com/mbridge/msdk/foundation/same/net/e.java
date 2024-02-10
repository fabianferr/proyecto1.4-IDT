package com.mbridge.msdk.foundation.same.net;

import com.mbridge.msdk.foundation.same.net.b.a;

/* compiled from: IListener */
public interface e<T> {
    void onCancel();

    void onError(a aVar);

    void onFinish();

    void onNetworking();

    void onPreExecute();

    void onProgressChange(long j, long j2);

    void onRetry();

    void onSuccess(l<T> lVar);
}

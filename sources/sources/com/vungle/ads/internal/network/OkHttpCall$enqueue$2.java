package com.vungle.ads.internal.network;

import androidx.core.app.NotificationCompat;
import com.ironsource.sdk.c.e;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

@Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"com/vungle/ads/internal/network/OkHttpCall$enqueue$2", "Lokhttp3/Callback;", "callFailure", "", "e", "", "onFailure", "call", "Lokhttp3/Call;", "Ljava/io/IOException;", "onResponse", "response", "Lokhttp3/Response;", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: OkHttpCall.kt */
public final class OkHttpCall$enqueue$2 implements Callback {
    final /* synthetic */ Callback<T> $callback;
    final /* synthetic */ OkHttpCall<T> this$0;

    OkHttpCall$enqueue$2(OkHttpCall<T> okHttpCall, Callback<T> callback) {
        this.this$0 = okHttpCall;
        this.$callback = callback;
    }

    public void onResponse(Call call, Response response) {
        Intrinsics.checkNotNullParameter(call, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(response, "response");
        try {
            try {
                this.$callback.onResponse(this.this$0, this.this$0.parseResponse(response));
            } catch (Throwable th) {
                OkHttpCall.Companion.throwIfFatal(th);
                th.printStackTrace();
            }
        } catch (Throwable th2) {
            OkHttpCall.Companion.throwIfFatal(th2);
            callFailure(th2);
        }
    }

    public void onFailure(Call call, IOException iOException) {
        Intrinsics.checkNotNullParameter(call, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(iOException, e.a);
        callFailure(iOException);
    }

    private final void callFailure(Throwable th) {
        try {
            this.$callback.onFailure(this.this$0, th);
        } catch (Throwable th2) {
            OkHttpCall.Companion.throwIfFatal(th2);
            th2.printStackTrace();
        }
    }
}

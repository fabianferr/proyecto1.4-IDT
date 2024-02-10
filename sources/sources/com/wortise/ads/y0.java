package com.wortise.ads;

import androidx.core.app.NotificationCompat;
import com.ironsource.sdk.c.e;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0019\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H@ø\u0001\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u0002\u0004\n\u0002\b\u0019¨\u0006\u0004"}, d2 = {"Lokhttp3/Call;", "Lokhttp3/Response;", "a", "(Lokhttp3/Call;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sdk_productionRelease"}, k = 2, mv = {1, 5, 1})
/* compiled from: Call.kt */
public final class y0 {

    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n"}, d2 = {"", "it", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: Call.kt */
    static final class a extends Lambda implements Function1<Throwable, Unit> {
        final /* synthetic */ Call a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(Call call) {
            super(1);
            this.a = call;
        }

        public final void a(Throwable th) {
            try {
                this.a.cancel();
            } catch (Throwable unused) {
            }
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Throwable) obj);
            return Unit.INSTANCE;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016¨\u0006\u000b"}, d2 = {"com/wortise/ads/y0$b", "Lokhttp3/Callback;", "Lokhttp3/Call;", "call", "Ljava/io/IOException;", "e", "", "onFailure", "Lokhttp3/Response;", "response", "onResponse", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Call.kt */
    public static final class b implements Callback {
        final /* synthetic */ CancellableContinuation<Response> a;

        b(CancellableContinuation<? super Response> cancellableContinuation) {
            this.a = cancellableContinuation;
        }

        public void onFailure(Call call, IOException iOException) {
            Intrinsics.checkNotNullParameter(call, NotificationCompat.CATEGORY_CALL);
            Intrinsics.checkNotNullParameter(iOException, e.a);
            if (!this.a.isCancelled()) {
                CancellableContinuation<Response> cancellableContinuation = this.a;
                Result.Companion companion = Result.Companion;
                cancellableContinuation.resumeWith(Result.m2344constructorimpl(ResultKt.createFailure(iOException)));
            }
        }

        public void onResponse(Call call, Response response) {
            Intrinsics.checkNotNullParameter(call, NotificationCompat.CATEGORY_CALL);
            Intrinsics.checkNotNullParameter(response, "response");
            CancellableContinuation<Response> cancellableContinuation = this.a;
            Result.Companion companion = Result.Companion;
            cancellableContinuation.resumeWith(Result.m2344constructorimpl(response));
        }
    }

    public static final Object a(Call call, Continuation<? super Response> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        call.enqueue(new b(cancellableContinuationImpl));
        cancellableContinuationImpl.invokeOnCancellation(new a(call));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}

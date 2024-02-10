package com.wortise.ads.fullscreen.modules;

import android.content.Context;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.wortise.ads.AdError;
import com.wortise.ads.AdResponse;
import com.wortise.ads.WortiseLog;
import com.wortise.ads.fullscreen.modules.BaseFullscreenModule.Listener;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0001&B\u001f\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00028\u0000¢\u0006\u0002\u0010\tJ\b\u0010\u0017\u001a\u00020\u0018H\u0004J\b\u0010\u0019\u001a\u00020\u0018H\u0004J\u0010\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001cH\u0004J\b\u0010\u001d\u001a\u00020\u0018H\u0004J\b\u0010\u001e\u001a\u00020\u0018H\u0004J\u0006\u0010\u001f\u001a\u00020\u0018J\u0011\u0010 \u001a\u00020\u0018H@ø\u0001\u0000¢\u0006\u0002\u0010!J\b\u0010\"\u001a\u00020\u0018H\u0014J\u0011\u0010#\u001a\u00020\u0018H¤@ø\u0001\u0000¢\u0006\u0002\u0010!J\u0011\u0010$\u001a\u00020\u0011H¤@ø\u0001\u0000¢\u0006\u0002\u0010!J\u0011\u0010%\u001a\u00020\u0011H@ø\u0001\u0000¢\u0006\u0002\u0010!R\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\b\u001a\u00028\u0000X\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015\u0002\u0004\n\u0002\b\u0019¨\u0006'"}, d2 = {"Lcom/wortise/ads/fullscreen/modules/BaseFullscreenModule;", "T", "Lcom/wortise/ads/fullscreen/modules/BaseFullscreenModule$Listener;", "", "context", "Landroid/content/Context;", "adResponse", "Lcom/wortise/ads/AdResponse;", "listener", "(Landroid/content/Context;Lcom/wortise/ads/AdResponse;Lcom/wortise/ads/fullscreen/modules/BaseFullscreenModule$Listener;)V", "getAdResponse", "()Lcom/wortise/ads/AdResponse;", "getContext", "()Landroid/content/Context;", "delivered", "Ljava/util/concurrent/atomic/AtomicBoolean;", "<set-?>", "", "isDestroyed", "()Z", "getListener", "()Lcom/wortise/ads/fullscreen/modules/BaseFullscreenModule$Listener;", "Lcom/wortise/ads/fullscreen/modules/BaseFullscreenModule$Listener;", "deliverClick", "", "deliverDismiss", "deliverError", "error", "Lcom/wortise/ads/AdError;", "deliverLoad", "deliverShow", "destroy", "load", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onDestroy", "onLoad", "onShow", "show", "Listener", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: BaseFullscreenModule.kt */
public abstract class BaseFullscreenModule<T extends Listener> {
    private final AdResponse adResponse;
    private final Context context;
    private final AtomicBoolean delivered = new AtomicBoolean(false);
    private boolean isDestroyed;
    private final T listener;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0003H&¨\u0006\n"}, d2 = {"Lcom/wortise/ads/fullscreen/modules/BaseFullscreenModule$Listener;", "", "onAdClicked", "", "onAdDismissed", "onAdError", "error", "Lcom/wortise/ads/AdError;", "onAdLoaded", "onAdShown", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: BaseFullscreenModule.kt */
    public interface Listener {
        void onAdClicked();

        void onAdDismissed();

        void onAdError(AdError adError);

        void onAdLoaded();

        void onAdShown();
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.wortise.ads.fullscreen.modules.BaseFullscreenModule", f = "BaseFullscreenModule.kt", i = {0, 0, 0}, l = {64}, m = "load", n = {"this", "defaultValue$iv$iv", "log$iv"}, s = {"L$0", "L$1", "I$0"})
    /* compiled from: BaseFullscreenModule.kt */
    static final class a extends ContinuationImpl {
        Object a;
        Object b;
        int c;
        /* synthetic */ Object d;
        final /* synthetic */ BaseFullscreenModule<T> e;
        int f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(BaseFullscreenModule<T> baseFullscreenModule, Continuation<? super a> continuation) {
            super(continuation);
            this.e = baseFullscreenModule;
        }

        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= Integer.MIN_VALUE;
            return this.e.load(this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.wortise.ads.fullscreen.modules.BaseFullscreenModule", f = "BaseFullscreenModule.kt", i = {0, 0}, l = {78}, m = "show", n = {"defaultValue$iv", "log$iv"}, s = {"L$0", "I$0"})
    /* compiled from: BaseFullscreenModule.kt */
    static final class b extends ContinuationImpl {
        Object a;
        int b;
        /* synthetic */ Object c;
        final /* synthetic */ BaseFullscreenModule<T> d;
        int e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(BaseFullscreenModule<T> baseFullscreenModule, Continuation<? super b> continuation) {
            super(continuation);
            this.d = baseFullscreenModule;
        }

        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            return this.d.show(this);
        }
    }

    public BaseFullscreenModule(Context context2, AdResponse adResponse2, T t) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(adResponse2, "adResponse");
        Intrinsics.checkNotNullParameter(t, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.context = context2;
        this.adResponse = adResponse2;
        this.listener = t;
    }

    /* access modifiers changed from: protected */
    public final void deliverClick() {
        if (!this.isDestroyed) {
            this.listener.onAdClicked();
        }
    }

    /* access modifiers changed from: protected */
    public final void deliverDismiss() {
        if (!this.isDestroyed) {
            this.listener.onAdDismissed();
        }
    }

    /* access modifiers changed from: protected */
    public final void deliverError(AdError adError) {
        Intrinsics.checkNotNullParameter(adError, "error");
        if (!this.isDestroyed && this.delivered.compareAndSet(false, true)) {
            this.listener.onAdError(adError);
        }
    }

    /* access modifiers changed from: protected */
    public final void deliverLoad() {
        if (!this.isDestroyed && this.delivered.compareAndSet(false, true)) {
            this.listener.onAdLoaded();
        }
    }

    /* access modifiers changed from: protected */
    public final void deliverShow() {
        if (!this.isDestroyed) {
            this.listener.onAdShown();
        }
    }

    public final void destroy() {
        if (!this.isDestroyed) {
            try {
                onDestroy();
            } catch (Throwable th) {
                String message = th.getMessage();
                if (message == null) {
                    message = "Caught an exception";
                }
                WortiseLog.e(message, th);
            }
            this.isDestroyed = true;
        }
    }

    /* access modifiers changed from: protected */
    public final AdResponse getAdResponse() {
        return this.adResponse;
    }

    /* access modifiers changed from: protected */
    public final Context getContext() {
        return this.context;
    }

    /* access modifiers changed from: protected */
    public final T getListener() {
        return this.listener;
    }

    public final boolean isDestroyed() {
        return this.isDestroyed;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object load(kotlin.coroutines.Continuation<? super kotlin.Unit> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.wortise.ads.fullscreen.modules.BaseFullscreenModule.a
            if (r0 == 0) goto L_0x0013
            r0 = r5
            com.wortise.ads.fullscreen.modules.BaseFullscreenModule$a r0 = (com.wortise.ads.fullscreen.modules.BaseFullscreenModule.a) r0
            int r1 = r0.f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f = r1
            goto L_0x0018
        L_0x0013:
            com.wortise.ads.fullscreen.modules.BaseFullscreenModule$a r0 = new com.wortise.ads.fullscreen.modules.BaseFullscreenModule$a
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f
            r3 = 1
            if (r2 == 0) goto L_0x003d
            if (r2 != r3) goto L_0x0035
            int r1 = r0.c
            java.lang.Object r2 = r0.b
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            java.lang.Object r0 = r0.a
            com.wortise.ads.fullscreen.modules.BaseFullscreenModule r0 = (com.wortise.ads.fullscreen.modules.BaseFullscreenModule) r0
            kotlin.ResultKt.throwOnFailure(r5)     // Catch:{ all -> 0x0033 }
            goto L_0x005f
        L_0x0033:
            r5 = move-exception
            goto L_0x006a
        L_0x0035:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r5)
            boolean r5 = r4.isDestroyed()
            if (r5 == 0) goto L_0x0049
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L_0x0049:
            r5 = 0
            java.lang.Boolean r2 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
            r0.a = r4     // Catch:{ all -> 0x0067 }
            r0.b = r2     // Catch:{ all -> 0x0067 }
            r0.c = r3     // Catch:{ all -> 0x0067 }
            r0.f = r3     // Catch:{ all -> 0x0067 }
            java.lang.Object r5 = r4.onLoad(r0)     // Catch:{ all -> 0x0067 }
            if (r5 != r1) goto L_0x005d
            return r1
        L_0x005d:
            r1 = 1
            r0 = r4
        L_0x005f:
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)     // Catch:{ all -> 0x0064 }
            goto L_0x0078
        L_0x0064:
            r5 = move-exception
            r3 = r1
            goto L_0x0069
        L_0x0067:
            r5 = move-exception
            r0 = r4
        L_0x0069:
            r1 = r3
        L_0x006a:
            if (r1 == 0) goto L_0x0077
            java.lang.String r1 = r5.getMessage()
            if (r1 != 0) goto L_0x0074
            java.lang.String r1 = "Caught an exception"
        L_0x0074:
            com.wortise.ads.WortiseLog.e((java.lang.String) r1, (java.lang.Throwable) r5)
        L_0x0077:
            r5 = r2
        L_0x0078:
            boolean r5 = r5.booleanValue()
            if (r5 != 0) goto L_0x0083
            com.wortise.ads.AdError r5 = com.wortise.ads.AdError.UNSPECIFIED
            r0.deliverError(r5)
        L_0x0083:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wortise.ads.fullscreen.modules.BaseFullscreenModule.load(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
    }

    /* access modifiers changed from: protected */
    public abstract Object onLoad(Continuation<? super Unit> continuation);

    /* access modifiers changed from: protected */
    public abstract Object onShow(Continuation<? super Boolean> continuation);

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object show(kotlin.coroutines.Continuation<? super java.lang.Boolean> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.wortise.ads.fullscreen.modules.BaseFullscreenModule.b
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.wortise.ads.fullscreen.modules.BaseFullscreenModule$b r0 = (com.wortise.ads.fullscreen.modules.BaseFullscreenModule.b) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.e = r1
            goto L_0x0018
        L_0x0013:
            com.wortise.ads.fullscreen.modules.BaseFullscreenModule$b r0 = new com.wortise.ads.fullscreen.modules.BaseFullscreenModule$b
            r0.<init>(r5, r6)
        L_0x0018:
            java.lang.Object r6 = r0.c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.e
            r3 = 1
            if (r2 == 0) goto L_0x0039
            if (r2 != r3) goto L_0x0031
            int r3 = r0.b
            java.lang.Object r0 = r0.a
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            kotlin.ResultKt.throwOnFailure(r6)     // Catch:{ all -> 0x002f }
            goto L_0x005c
        L_0x002f:
            r6 = move-exception
            goto L_0x006b
        L_0x0031:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x0039:
            kotlin.ResultKt.throwOnFailure(r6)
            boolean r6 = r5.isDestroyed()
            r2 = 0
            if (r6 == 0) goto L_0x0048
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r2)
            return r6
        L_0x0048:
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r2)
            r0.a = r6     // Catch:{ all -> 0x0067 }
            r0.b = r3     // Catch:{ all -> 0x0067 }
            r0.e = r3     // Catch:{ all -> 0x0067 }
            java.lang.Object r0 = r5.onShow(r0)     // Catch:{ all -> 0x0067 }
            if (r0 != r1) goto L_0x0059
            return r1
        L_0x0059:
            r4 = r0
            r0 = r6
            r6 = r4
        L_0x005c:
            java.lang.Boolean r6 = (java.lang.Boolean) r6     // Catch:{ all -> 0x002f }
            boolean r6 = r6.booleanValue()     // Catch:{ all -> 0x002f }
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r6)     // Catch:{ all -> 0x002f }
            goto L_0x0079
        L_0x0067:
            r0 = move-exception
            r4 = r0
            r0 = r6
            r6 = r4
        L_0x006b:
            if (r3 == 0) goto L_0x0078
            java.lang.String r1 = r6.getMessage()
            if (r1 != 0) goto L_0x0075
            java.lang.String r1 = "Caught an exception"
        L_0x0075:
            com.wortise.ads.WortiseLog.e((java.lang.String) r1, (java.lang.Throwable) r6)
        L_0x0078:
            r6 = r0
        L_0x0079:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wortise.ads.fullscreen.modules.BaseFullscreenModule.show(kotlin.coroutines.Continuation):java.lang.Object");
    }
}

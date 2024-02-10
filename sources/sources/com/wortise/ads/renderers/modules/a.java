package com.wortise.ads.renderers.modules;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.wortise.ads.AdError;
import com.wortise.ads.AdEvent;
import com.wortise.ads.AdResponse;
import com.wortise.ads.AdSize;
import com.wortise.ads.WortiseLog;
import com.wortise.ads.device.Dimensions;
import com.wortise.ads.i3;
import com.wortise.ads.s2;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

@Metadata(bv = {}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0015\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003:\u0001GB!\b\u0000\u0012\u0006\u0010 \u001a\u00020\u0001\u0012\u0006\u0010#\u001a\u00020\"\u0012\u0006\u0010(\u001a\u00020'¢\u0006\u0004\bE\u0010FJ\b\u0010\u0005\u001a\u00020\u0004H\u0014J\b\u0010\u0006\u001a\u00020\u0004H\u0014J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H$J\b\u0010\n\u001a\u00020\u0004H\u0014J\u0006\u0010\u000b\u001a\u00020\u0004J\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010\u000e\u001a\u00020\u0004J\u0006\u0010\u000f\u001a\u00020\fJ\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0001H\u0004J\u001c\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\f2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0004J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H\u0004J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0019H\u0004J#\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00028\u00002\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0004¢\u0006\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020\u00018\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u001a\u0010#\u001a\u00020\"8\u0004X\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0014\u0010(\u001a\u00020'8\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010+\u001a\u00020*8\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u001b\u00102\u001a\u00020-8DX\u0002¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R$\u00104\u001a\u0004\u0018\u0001038\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R$\u0010;\u001a\u00020\f2\u0006\u0010:\u001a\u00020\f8\u0006@BX\u000e¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b;\u0010=R$\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u0014\u0010\b\u001a\u00020\u00078DX\u0004¢\u0006\u0006\u001a\u0004\bC\u0010D¨\u0006H"}, d2 = {"Lcom/wortise/ads/renderers/modules/a;", "Landroid/view/View;", "T", "", "", "onDestroy", "onPause", "Landroid/content/Context;", "context", "onRender", "onResume", "destroy", "", "pause", "render", "resume", "view", "attachClickListener", "open", "Landroid/os/Bundle;", "adExtras", "deliverClick", "Lcom/wortise/ads/AdError;", "error", "deliverError", "Lcom/wortise/ads/AdEvent;", "event", "deliverEvent", "Lcom/wortise/ads/device/Dimensions;", "size", "deliverView", "(Landroid/view/View;Lcom/wortise/ads/device/Dimensions;)V", "adView", "Landroid/view/View;", "Lcom/wortise/ads/AdResponse;", "adResponse", "Lcom/wortise/ads/AdResponse;", "getAdResponse", "()Lcom/wortise/ads/AdResponse;", "Lcom/wortise/ads/renderers/modules/a$a;", "listener", "Lcom/wortise/ads/renderers/modules/a$a;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "delivered", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope$delegate", "Lkotlin/Lazy;", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "Lcom/wortise/ads/AdSize;", "adSize", "Lcom/wortise/ads/AdSize;", "getAdSize", "()Lcom/wortise/ads/AdSize;", "setAdSize", "(Lcom/wortise/ads/AdSize;)V", "<set-?>", "isDestroyed", "Z", "()Z", "Lcom/wortise/ads/device/Dimensions;", "getSize", "()Lcom/wortise/ads/device/Dimensions;", "setSize", "(Lcom/wortise/ads/device/Dimensions;)V", "getContext", "()Landroid/content/Context;", "<init>", "(Landroid/view/View;Lcom/wortise/ads/AdResponse;Lcom/wortise/ads/renderers/modules/a$a;)V", "a", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: BaseAdRenderer.kt */
public abstract class a<T extends View> {
    private final AdResponse adResponse;
    private AdSize adSize;
    private final View adView;
    private final Lazy coroutineScope$delegate = LazyKt.lazy(d.a);
    private final AtomicBoolean delivered = new AtomicBoolean(false);
    private boolean isDestroyed;
    private final C0192a listener;
    private Dimensions size;

    @Metadata(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u001a\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH&J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH&¨\u0006\u000f"}, d2 = {"Lcom/wortise/ads/renderers/modules/a$a;", "", "", "onAdClicked", "Lcom/wortise/ads/AdEvent;", "event", "onAdEvent", "Landroid/view/View;", "view", "Lcom/wortise/ads/device/Dimensions;", "size", "onAdRendered", "Lcom/wortise/ads/AdError;", "error", "onAdRenderFailed", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* renamed from: com.wortise.ads.renderers.modules.a$a  reason: collision with other inner class name */
    /* compiled from: BaseAdRenderer.kt */
    public interface C0192a {
        void onAdClicked();

        void onAdEvent(AdEvent adEvent);

        void onAdRenderFailed(AdError adError);

        void onAdRendered(View view, Dimensions dimensions);
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* compiled from: BaseAdRenderer.kt */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[AdEvent.values().length];
            iArr[AdEvent.LOAD_FAIL.ordinal()] = 1;
            a = iArr;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0004\u001a\u00020\u0003\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\n"}, d2 = {"Landroid/view/View;", "T", "it", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: BaseAdRenderer.kt */
    static final class c extends Lambda implements Function1<View, Boolean> {
        final /* synthetic */ a<T> a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(a<T> aVar) {
            super(1);
            this.a = aVar;
        }

        /* renamed from: a */
        public final Boolean invoke(View view) {
            Intrinsics.checkNotNullParameter(view, "it");
            a.deliverClick$default(this.a, true, (Bundle) null, 2, (Object) null);
            return Boolean.TRUE;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000H\n"}, d2 = {"Landroid/view/View;", "T", "Lkotlinx/coroutines/CoroutineScope;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: BaseAdRenderer.kt */
    static final class d extends Lambda implements Function0<CoroutineScope> {
        public static final d a = new d();

        d() {
            super(0);
        }

        /* renamed from: a */
        public final CoroutineScope invoke() {
            return CoroutineScopeKt.MainScope();
        }
    }

    public a(View view, AdResponse adResponse2, C0192a aVar) {
        Intrinsics.checkNotNullParameter(view, "adView");
        Intrinsics.checkNotNullParameter(adResponse2, "adResponse");
        Intrinsics.checkNotNullParameter(aVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.adView = view;
        this.adResponse = adResponse2;
        this.listener = aVar;
    }

    public static /* synthetic */ void deliverClick$default(a aVar, boolean z, Bundle bundle, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                bundle = null;
            }
            aVar.deliverClick(z, bundle);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: deliverClick");
    }

    public static /* synthetic */ void deliverView$default(a aVar, View view, Dimensions dimensions, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                dimensions = null;
            }
            aVar.deliverView(view, dimensions);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: deliverView");
    }

    /* access modifiers changed from: protected */
    public final void attachClickListener(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        i3.a(view, new c(this));
    }

    /* access modifiers changed from: protected */
    public final void deliverClick(boolean z, Bundle bundle) {
        if (!this.isDestroyed && s2.a.a(getContext(), this.adResponse, bundle, z)) {
            this.listener.onAdClicked();
        }
    }

    /* access modifiers changed from: protected */
    public final void deliverError(AdError adError) {
        Intrinsics.checkNotNullParameter(adError, "error");
        if (!this.isDestroyed && this.delivered.compareAndSet(false, true)) {
            this.listener.onAdRenderFailed(adError);
        }
    }

    /* access modifiers changed from: protected */
    public final void deliverEvent(AdEvent adEvent) {
        Intrinsics.checkNotNullParameter(adEvent, "event");
        if (!this.isDestroyed) {
            if (b.a[adEvent.ordinal()] == 1) {
                deliverError(AdError.LOAD_FAILED);
            } else {
                this.listener.onAdEvent(adEvent);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void deliverView(T t, Dimensions dimensions) {
        Intrinsics.checkNotNullParameter(t, "view");
        if (!this.isDestroyed && this.delivered.compareAndSet(false, true)) {
            this.listener.onAdRendered(t, dimensions);
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
            CoroutineScopeKt.cancel$default(getCoroutineScope(), (CancellationException) null, 1, (Object) null);
            this.isDestroyed = true;
        }
    }

    /* access modifiers changed from: protected */
    public final AdResponse getAdResponse() {
        return this.adResponse;
    }

    public final AdSize getAdSize() {
        return this.adSize;
    }

    /* access modifiers changed from: protected */
    public final Context getContext() {
        Context context = this.adView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "adView.context");
        return context;
    }

    /* access modifiers changed from: protected */
    public final CoroutineScope getCoroutineScope() {
        return (CoroutineScope) this.coroutineScope$delegate.getValue();
    }

    public final Dimensions getSize() {
        return this.size;
    }

    public final boolean isDestroyed() {
        return this.isDestroyed;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
    }

    /* access modifiers changed from: protected */
    public void onPause() {
    }

    /* access modifiers changed from: protected */
    public abstract void onRender(Context context);

    /* access modifiers changed from: protected */
    public void onResume() {
    }

    public final boolean pause() {
        try {
            if (!isDestroyed()) {
                onPause();
                return true;
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        } catch (Throwable th) {
            String message = th.getMessage();
            if (message == null) {
                message = "Caught an exception";
            }
            WortiseLog.e(message, th);
            return false;
        }
    }

    public final void render() {
        boolean z;
        if (!this.isDestroyed) {
            try {
                onRender(getContext());
                z = true;
            } catch (Throwable th) {
                String message = th.getMessage();
                if (message == null) {
                    message = "Caught an exception";
                }
                WortiseLog.e(message, th);
                z = false;
            }
            if (!z) {
                deliverError(AdError.RENDER_ERROR);
            }
        }
    }

    public final boolean resume() {
        try {
            if (!isDestroyed()) {
                onResume();
                return true;
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        } catch (Throwable th) {
            String message = th.getMessage();
            if (message == null) {
                message = "Caught an exception";
            }
            WortiseLog.e(message, th);
            return false;
        }
    }

    public final void setAdSize(AdSize adSize2) {
        this.adSize = adSize2;
    }

    public final void setSize(Dimensions dimensions) {
        this.size = dimensions;
    }
}

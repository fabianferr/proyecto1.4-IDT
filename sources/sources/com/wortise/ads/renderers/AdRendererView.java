package com.wortise.ads.renderers;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.wortise.ads.AdError;
import com.wortise.ads.AdEvent;
import com.wortise.ads.AdResponse;
import com.wortise.ads.AdSettings;
import com.wortise.ads.AdSize;
import com.wortise.ads.WortiseLog;
import com.wortise.ads.a7;
import com.wortise.ads.device.Dimensions;
import com.wortise.ads.i;
import com.wortise.ads.renderers.modules.a;
import com.wortise.ads.renderers.modules.c;
import com.wortise.ads.s2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0011\b\u0016\u0012\u0006\u0010B\u001a\u00020A¢\u0006\u0004\bC\u0010DB\u001b\b\u0016\u0012\u0006\u0010B\u001a\u00020A\u0012\b\u0010F\u001a\u0004\u0018\u00010E¢\u0006\u0004\bC\u0010GB#\b\u0016\u0012\u0006\u0010B\u001a\u00020A\u0012\b\u0010F\u001a\u0004\u0018\u00010E\u0012\u0006\u0010I\u001a\u00020H¢\u0006\u0004\bC\u0010JJ\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\u001a\u0010\u0005\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\n\u001a\u00020\bJ\u000e\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\u000e\u001a\u00020\bJ\b\u0010\u000f\u001a\u00020\bH\u0016J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u001a\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016R\u001c\u0010\u0019\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00178\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0018R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR$\u0010$\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010,\u001a\u0004\u0018\u00010%8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R(\u00102\u001a\u0004\u0018\u00010\u00032\b\u0010-\u001a\u0004\u0018\u00010\u00038\u0006@BX\u000e¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\"\u0010:\u001a\u0002038\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b;\u0010/\u001a\u0004\b<\u00101\"\u0004\b=\u0010>R\u0014\u0010@\u001a\u0002038BX\u0004¢\u0006\u0006\u001a\u0004\b?\u00107¨\u0006K"}, d2 = {"Lcom/wortise/ads/renderers/AdRendererView;", "Landroid/widget/FrameLayout;", "Lcom/wortise/ads/renderers/modules/a$a;", "Lcom/wortise/ads/device/Dimensions;", "size", "a", "Landroid/view/View;", "view", "", "destroy", "pause", "Lcom/wortise/ads/AdResponse;", "response", "renderAd", "resume", "onAdClicked", "Lcom/wortise/ads/AdEvent;", "event", "onAdEvent", "onAdRendered", "Lcom/wortise/ads/AdError;", "error", "onAdRenderFailed", "Lcom/wortise/ads/renderers/modules/a;", "Lcom/wortise/ads/renderers/modules/a;", "adRenderer", "b", "Lcom/wortise/ads/AdResponse;", "adResponse", "Lcom/wortise/ads/AdSize;", "c", "Lcom/wortise/ads/AdSize;", "getAdSize", "()Lcom/wortise/ads/AdSize;", "setAdSize", "(Lcom/wortise/ads/AdSize;)V", "adSize", "Lcom/wortise/ads/renderers/AdRendererView$a;", "d", "Lcom/wortise/ads/renderers/AdRendererView$a;", "getListener", "()Lcom/wortise/ads/renderers/AdRendererView$a;", "setListener", "(Lcom/wortise/ads/renderers/AdRendererView$a;)V", "listener", "<set-?>", "e", "Lcom/wortise/ads/device/Dimensions;", "getRenderSize", "()Lcom/wortise/ads/device/Dimensions;", "renderSize", "", "f", "Z", "getShouldHonorServerSize", "()Z", "setShouldHonorServerSize", "(Z)V", "shouldHonorServerSize", "g", "getSize", "setSize", "(Lcom/wortise/ads/device/Dimensions;)V", "getMustRenderWatermark", "mustRenderWatermark", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: AdRendererView.kt */
public class AdRendererView extends FrameLayout implements a.C0192a {
    private com.wortise.ads.renderers.modules.a<?> a;
    private AdResponse b;
    private AdSize c;
    private a d;
    private Dimensions e;
    private boolean f;
    private Dimensions g;

    @Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000b"}, d2 = {"Lcom/wortise/ads/renderers/AdRendererView$a;", "", "Lcom/wortise/ads/renderers/AdRendererView;", "view", "", "a", "Lcom/wortise/ads/AdEvent;", "event", "b", "Lcom/wortise/ads/AdError;", "error", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* compiled from: AdRendererView.kt */
    public interface a {

        @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
        /* renamed from: com.wortise.ads.renderers.AdRendererView$a$a  reason: collision with other inner class name */
        /* compiled from: AdRendererView.kt */
        public static final class C0191a {
            public static void a(a aVar, AdRendererView adRendererView) {
                Intrinsics.checkNotNullParameter(aVar, "this");
                Intrinsics.checkNotNullParameter(adRendererView, "view");
            }

            public static void a(a aVar, AdRendererView adRendererView, AdEvent adEvent) {
                Intrinsics.checkNotNullParameter(aVar, "this");
                Intrinsics.checkNotNullParameter(adRendererView, "view");
                Intrinsics.checkNotNullParameter(adEvent, "event");
            }
        }

        void a(AdRendererView adRendererView);

        void a(AdRendererView adRendererView, AdError adError);

        void a(AdRendererView adRendererView, AdEvent adEvent);

        void b(AdRendererView adRendererView);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AdRendererView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final Dimensions a(Dimensions dimensions) {
        AdResponse adResponse = this.b;
        int i = -1;
        int j = adResponse == null ? -1 : adResponse.j();
        AdResponse adResponse2 = this.b;
        if (adResponse2 != null) {
            i = adResponse2.p();
        }
        if (!this.f || j <= 0 || i <= 0) {
            return dimensions;
        }
        Dimensions.a aVar = Dimensions.Companion;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        return aVar.a(context, i, j);
    }

    private final boolean getMustRenderWatermark() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        return AdSettings.isChildDirected(context) && !(this.a instanceof c);
    }

    public final void destroy() {
        com.wortise.ads.renderers.modules.a<?> aVar = this.a;
        if (aVar != null) {
            aVar.destroy();
        }
    }

    public final AdSize getAdSize() {
        return this.c;
    }

    public final a getListener() {
        return this.d;
    }

    public final Dimensions getRenderSize() {
        return this.e;
    }

    public final boolean getShouldHonorServerSize() {
        return this.f;
    }

    public final Dimensions getSize() {
        return this.g;
    }

    public void onAdClicked() {
        WortiseLog.i$default("Ad clicked", (Throwable) null, 2, (Object) null);
        a aVar = this.d;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    public void onAdEvent(AdEvent adEvent) {
        Intrinsics.checkNotNullParameter(adEvent, "event");
        WortiseLog.i$default(Intrinsics.stringPlus("Ad event received: ", adEvent.name()), (Throwable) null, 2, (Object) null);
        a aVar = this.d;
        if (aVar != null) {
            aVar.a(this, adEvent);
        }
    }

    public void onAdRenderFailed(AdError adError) {
        Intrinsics.checkNotNullParameter(adError, "error");
        WortiseLog.i$default(Intrinsics.stringPlus("Ad failed to render: ", adError.name()), (Throwable) null, 2, (Object) null);
        a aVar = this.d;
        if (aVar != null) {
            aVar.a(this, adError);
        }
    }

    public void onAdRendered(View view, Dimensions dimensions) {
        Intrinsics.checkNotNullParameter(view, "view");
        a(view, dimensions);
        WortiseLog.i$default("Ad rendered", (Throwable) null, 2, (Object) null);
        AdResponse adResponse = this.b;
        if (adResponse != null) {
            s2 s2Var = s2.a;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            s2.a(s2Var, context, adResponse, (Bundle) null, 4, (Object) null);
        }
        a aVar = this.d;
        if (aVar != null) {
            aVar.b(this);
        }
    }

    public final void pause() {
        com.wortise.ads.renderers.modules.a<?> aVar = this.a;
        if (aVar != null) {
            aVar.pause();
        }
    }

    public final void renderAd(AdResponse adResponse) {
        Intrinsics.checkNotNullParameter(adResponse, "response");
        if (this.a == null) {
            com.wortise.ads.renderers.modules.a<?> a2 = i.a.a(this, adResponse, this);
            if (a2 == null) {
                onAdRenderFailed(AdError.NO_FILL);
                return;
            }
            this.a = a2;
            this.b = adResponse;
            a2.setAdSize(getAdSize());
            a2.setSize(getSize());
            a2.render();
        }
    }

    public final void resume() {
        com.wortise.ads.renderers.modules.a<?> aVar = this.a;
        if (aVar != null) {
            aVar.resume();
        }
    }

    public final void setAdSize(AdSize adSize) {
        this.c = adSize;
    }

    public final void setListener(a aVar) {
        this.d = aVar;
    }

    public final void setShouldHonorServerSize(boolean z) {
        this.f = z;
    }

    public final void setSize(Dimensions dimensions) {
        this.g = dimensions;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AdRendererView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AdRendererView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void a(View view, Dimensions dimensions) {
        FrameLayout.LayoutParams layoutParams;
        removeAllViews();
        Dimensions a2 = a(dimensions);
        if (a2 != null) {
            layoutParams = new FrameLayout.LayoutParams(a2.c(), a2.a(), 17);
        } else {
            layoutParams = new FrameLayout.LayoutParams(-1, -1);
        }
        this.e = a2;
        addView(view, layoutParams);
        if (getMustRenderWatermark()) {
            a7.Companion.a(this);
        }
    }
}

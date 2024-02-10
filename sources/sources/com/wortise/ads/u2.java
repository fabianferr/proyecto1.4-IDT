package com.wortise.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.wortise.ads.device.ScreenOrientation;
import com.wortise.ads.renderers.AdRendererView;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KClass;

@Metadata(bv = {}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b&\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0004B\u0007¢\u0006\u0004\b+\u0010,J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\u0012\u0010\n\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014J\b\u0010\u000b\u001a\u00020\u0005H\u0014J\b\u0010\f\u001a\u00020\u0005H\u0014J\b\u0010\r\u001a\u00020\u0005H\u0014J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\bH\u0014J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0003H\u0016J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u001c\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\bH\u0004J\b\u0010\u0017\u001a\u00020\u0005H\u0004J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0013H\u0004J\b\u0010\u0018\u001a\u00020\u0005H\u0004R\u001b\u0010\u001e\u001a\u00020\u00198BX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\"\u001a\u00020\u001f8BX\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u001b\u0010'\u001a\u00020#8BX\u0002¢\u0006\f\n\u0004\b$\u0010\u001b\u001a\u0004\b%\u0010&R\u001a\u0010(\u001a\u00020\u001f8\u0014X\u0004¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010!¨\u0006-"}, d2 = {"Lcom/wortise/ads/u2;", "Landroid/app/Activity;", "Lcom/wortise/ads/renderers/AdRendererView$a;", "Lcom/wortise/ads/renderers/AdRendererView;", "a", "", "g", "onBackPressed", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "onDestroy", "onPause", "onResume", "outState", "onSaveInstanceState", "view", "Lcom/wortise/ads/AdEvent;", "event", "Lcom/wortise/ads/AdError;", "error", "", "extras", "b", "h", "Lcom/wortise/ads/f7;", "binding$delegate", "Lkotlin/Lazy;", "c", "()Lcom/wortise/ads/f7;", "binding", "", "d", "()J", "closeDelay", "Landroid/os/Handler;", "uiHandler$delegate", "f", "()Landroid/os/Handler;", "uiHandler", "defaultCloseDelay", "J", "e", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: FullscreenActivity.kt */
public abstract class u2 extends Activity implements AdRendererView.a {
    public static final a Companion = new a((DefaultConstructorMarker) null);
    private AdResponse a;
    private AdRendererView b;
    private final Lazy c = LazyKt.lazy(new c(this));
    private boolean d;
    private long e;
    private final Lazy f = LazyKt.lazy(d.a);
    private final long g = TimeUnit.SECONDS.toMillis(3);
    private final Runnable h = new u2$$ExternalSyntheticLambda1(this);

    @Metadata(bv = {}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012J*\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bR\u0014\u0010\r\u001a\u00020\f8\u0006XT¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\f8\u0006XT¢\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\f8\u0002XT¢\u0006\u0006\n\u0004\b\u0010\u0010\u000e¨\u0006\u0013"}, d2 = {"Lcom/wortise/ads/u2$a;", "", "Landroid/content/Context;", "context", "Lkotlin/reflect/KClass;", "clazz", "Lcom/wortise/ads/AdResponse;", "response", "", "identifier", "Landroid/content/Intent;", "a", "", "EXTRA_AD_RESPONSE", "Ljava/lang/String;", "EXTRA_IDENTIFIER", "KEY_CAN_CLOSE", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* compiled from: FullscreenActivity.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Intent a(Context context, KClass<?> kClass, AdResponse adResponse, long j) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(kClass, "clazz");
            Intrinsics.checkNotNullParameter(adResponse, "response");
            Intent putExtra = new Intent(context, JvmClassMappingKt.getJavaClass(kClass)).putExtra("adResponse", adResponse).putExtra("identifier", j);
            Intrinsics.checkNotNullExpressionValue(putExtra, "Intent(context, clazz.ja…_IDENTIFIER,  identifier)");
            return putExtra;
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* compiled from: FullscreenActivity.kt */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[AdEvent.values().length];
            iArr[AdEvent.CLOSE.ordinal()] = 1;
            iArr[AdEvent.SHOW_CLOSE.ordinal()] = 2;
            a = iArr;
            int[] iArr2 = new int[AdError.values().length];
            iArr2[AdError.RENDER_PROCESS_GONE.ordinal()] = 1;
            b = iArr2;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcom/wortise/ads/f7;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: FullscreenActivity.kt */
    static final class c extends Lambda implements Function0<f7> {
        final /* synthetic */ u2 a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(u2 u2Var) {
            super(0);
            this.a = u2Var;
        }

        /* renamed from: a */
        public final f7 invoke() {
            return f7.a(this.a.getLayoutInflater());
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Landroid/os/Handler;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: FullscreenActivity.kt */
    static final class d extends Lambda implements Function0<Handler> {
        public static final d a = new d();

        d() {
            super(0);
        }

        /* renamed from: a */
        public final Handler invoke() {
            return new Handler(Looper.getMainLooper());
        }
    }

    private final f7 c() {
        return (f7) this.c.getValue();
    }

    private final long d() {
        AdResponse adResponse = this.a;
        if (adResponse == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adResponse");
            adResponse = null;
        }
        Long c2 = adResponse.c();
        return c2 == null ? e() : c2.longValue();
    }

    private final Handler f() {
        return (Handler) this.f.getValue();
    }

    private final void g() {
        AdRendererView a2 = a();
        this.b = a2;
        c().b.addView(a2, new FrameLayout.LayoutParams(-1, -1));
        AdResponse adResponse = this.a;
        if (adResponse == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adResponse");
            adResponse = null;
        }
        a2.renderAd(adResponse);
        Button button = c().c;
        Intrinsics.checkNotNullExpressionValue(button, "it");
        button.setVisibility(this.d ? 0 : 8);
        button.setOnClickListener(new u2$$ExternalSyntheticLambda0(this));
        if (!this.d && d() >= 0) {
            f().postDelayed(this.h, d());
        }
    }

    public void a(AdRendererView adRendererView) {
        Intrinsics.checkNotNullParameter(adRendererView, "view");
        a(this, CampaignEx.JSON_NATIVE_VIDEO_CLICK, (Bundle) null, 2, (Object) null);
    }

    public void b(AdRendererView adRendererView) {
        AdRendererView.a.C0191a.a(this, adRendererView);
    }

    /* access modifiers changed from: protected */
    public long e() {
        return this.g;
    }

    /* access modifiers changed from: protected */
    public final void h() {
        f().removeCallbacks(this.h);
        this.d = true;
        Button button = c().c;
        Intrinsics.checkNotNullExpressionValue(button, "binding.buttonClose");
        button.setVisibility(0);
    }

    public void onBackPressed() {
        if (this.d) {
            b();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        AdResponse adResponse = (AdResponse) getIntent().getParcelableExtra("adResponse");
        if (adResponse == null) {
            finish();
            return;
        }
        this.a = adResponse;
        this.e = getIntent().getLongExtra("identifier", -1);
        if (bundle != null) {
            this.d = bundle.getBoolean("canClose", false);
        }
        AdResponse adResponse2 = this.a;
        if (adResponse2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adResponse");
            adResponse2 = null;
        }
        ScreenOrientation n = adResponse2.n();
        if (n != null) {
            q2.a.a((Activity) this, n);
        }
        setContentView(c().getRoot());
        g();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        AdRendererView adRendererView = this.b;
        if (adRendererView != null) {
            adRendererView.destroy();
        }
        f().removeCallbacks(this.h);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        AdRendererView adRendererView = this.b;
        if (adRendererView != null) {
            adRendererView.pause();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        Window window = getWindow();
        if (window != null) {
            t2.a.a(window);
        }
        AdRendererView adRendererView = this.b;
        if (adRendererView != null) {
            adRendererView.resume();
        }
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("canClose", this.d);
    }

    public void a(AdRendererView adRendererView, AdEvent adEvent) {
        Intrinsics.checkNotNullParameter(adRendererView, "view");
        Intrinsics.checkNotNullParameter(adEvent, "event");
        int i = b.a[adEvent.ordinal()];
        if (i == 1) {
            b();
        } else if (i == 2) {
            h();
        }
    }

    /* access modifiers changed from: protected */
    public final void b() {
        finish();
        a(this, "dismiss", (Bundle) null, 2, (Object) null);
    }

    public void a(AdRendererView adRendererView, AdError adError) {
        Intrinsics.checkNotNullParameter(adRendererView, "view");
        Intrinsics.checkNotNullParameter(adError, "error");
        if (b.b[adError.ordinal()] == 1) {
            a(adError);
        }
    }

    private final AdRendererView a() {
        AdRendererView adRendererView = new AdRendererView(this);
        adRendererView.setListener(this);
        return adRendererView;
    }

    /* access modifiers changed from: private */
    public static final void a(u2 u2Var, View view) {
        Intrinsics.checkNotNullParameter(u2Var, "this$0");
        u2Var.b();
    }

    public static /* synthetic */ void a(u2 u2Var, String str, Bundle bundle, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                bundle = null;
            }
            u2Var.a(str, bundle);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: broadcastAction");
    }

    /* access modifiers changed from: protected */
    public final void a(String str, Bundle bundle) {
        Intrinsics.checkNotNullParameter(str, "event");
        a.Companion.a(this, this.e, str, bundle);
    }

    /* access modifiers changed from: protected */
    public final void a(AdError adError) {
        Intrinsics.checkNotNullParameter(adError, "error");
        Bundle bundle = new Bundle();
        bundle.putParcelable("error", adError);
        a("error", bundle);
        b();
    }

    /* access modifiers changed from: private */
    public static final void a(u2 u2Var) {
        Intrinsics.checkNotNullParameter(u2Var, "this$0");
        u2Var.h();
    }
}

package com.wortise.ads;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import com.google.android.material.badge.BadgeDrawable;
import com.wortise.ads.device.Dimensions;
import com.wortise.ads.renderers.AdRendererView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.math.MathKt;

@Metadata(bv = {}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0005B\u000f\u0012\u0006\u0010#\u001a\u00020\"¢\u0006\u0004\b$\u0010%J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0006\u001a\u00020\u0004R\u0014\u0010\t\u001a\u00020\u00078BX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\bR\u0014\u0010\r\u001a\u00020\n8BX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0013\u001a\u00020\u000e8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0016\u001a\u00020\u000e8BX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0015\u0010\u0012R\u0014\u0010\u0018\u001a\u00020\u000e8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0012R\u0014\u0010\u001a\u001a\u00020\u000e8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0012R\u0014\u0010\u001c\u001a\u00020\u000e8BX\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0012R\u0014\u0010\u001e\u001a\u00020\u000e8BX\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0012R\u001b\u0010\u0003\u001a\u00020\u00028BX\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0010\u001a\u0004\b \u0010!¨\u0006&"}, d2 = {"Lcom/wortise/ads/a7;", "", "Landroidx/appcompat/widget/AppCompatImageView;", "view", "", "a", "j", "Landroid/content/Context;", "()Landroid/content/Context;", "context", "Lcom/wortise/ads/device/Dimensions;", "b", "()Lcom/wortise/ads/device/Dimensions;", "dimensions", "", "minPadding$delegate", "Lkotlin/Lazy;", "c", "()I", "minPadding", "minSize$delegate", "d", "minSize", "e", "padding", "f", "rawPadding", "g", "rawSize", "h", "size", "view$delegate", "i", "()Landroidx/appcompat/widget/AppCompatImageView;", "Lcom/wortise/ads/renderers/AdRendererView;", "adRendererView", "<init>", "(Lcom/wortise/ads/renderers/AdRendererView;)V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: Watermark.kt */
public final class a7 {
    public static final a Companion = new a((DefaultConstructorMarker) null);
    private final AdRendererView a;
    private final Lazy b = LazyKt.lazy(new b(this));
    private final Lazy c = LazyKt.lazy(new c(this));
    private final Lazy d = LazyKt.lazy(new d(this));

    @Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002XT¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002XT¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8\u0002XT¢\u0006\u0006\n\u0004\b\f\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/wortise/ads/a7$a;", "", "Lcom/wortise/ads/renderers/AdRendererView;", "adRendererView", "Lcom/wortise/ads/a7;", "a", "", "GRAVITY", "I", "", "PADDING_FACTOR", "D", "SIZE_FACTOR", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Watermark.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final a7 a(AdRendererView adRendererView) {
            Intrinsics.checkNotNullParameter(adRendererView, "adRendererView");
            a7 a7Var = new a7(adRendererView);
            a7Var.j();
            return a7Var;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0010\b\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: Watermark.kt */
    static final class b extends Lambda implements Function0<Integer> {
        final /* synthetic */ a7 a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(a7 a7Var) {
            super(0);
            this.a = a7Var;
        }

        /* renamed from: a */
        public final Integer invoke() {
            return Integer.valueOf(r2.b(this.a.a(), 4));
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0010\b\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: Watermark.kt */
    static final class c extends Lambda implements Function0<Integer> {
        final /* synthetic */ a7 a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(a7 a7Var) {
            super(0);
            this.a = a7Var;
        }

        /* renamed from: a */
        public final Integer invoke() {
            return Integer.valueOf(r2.b(this.a.a(), 16));
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Landroidx/appcompat/widget/AppCompatImageView;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: Watermark.kt */
    static final class d extends Lambda implements Function0<AppCompatImageView> {
        final /* synthetic */ a7 a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(a7 a7Var) {
            super(0);
            this.a = a7Var;
        }

        /* renamed from: a */
        public final AppCompatImageView invoke() {
            AppCompatImageView appCompatImageView = new AppCompatImageView(this.a.a());
            this.a.a(appCompatImageView);
            return appCompatImageView;
        }
    }

    public a7(AdRendererView adRendererView) {
        Intrinsics.checkNotNullParameter(adRendererView, "adRendererView");
        this.a = adRendererView;
    }

    private final Dimensions b() {
        Dimensions renderSize = this.a.getRenderSize();
        if (renderSize != null) {
            return renderSize;
        }
        Dimensions size = this.a.getSize();
        if (size != null) {
            return size;
        }
        Dimensions a2 = o2.a.a(a());
        return a2 == null ? new Dimensions(0, 0) : a2;
    }

    private final int c() {
        return ((Number) this.b.getValue()).intValue();
    }

    private final int d() {
        return ((Number) this.c.getValue()).intValue();
    }

    private final int e() {
        return Math.max(c(), f());
    }

    private final int f() {
        double b2 = (double) b().b();
        Double.isNaN(b2);
        return MathKt.roundToInt(b2 * 0.03d);
    }

    private final int g() {
        double b2 = (double) b().b();
        Double.isNaN(b2);
        return MathKt.roundToInt(b2 * 0.06d);
    }

    private final int h() {
        return Math.max(d(), g());
    }

    private final AppCompatImageView i() {
        return (AppCompatImageView) this.d.getValue();
    }

    public final void j() {
        y6.a(i());
        int e = e();
        int h = h() + (e * 2);
        i().setPadding(e, e, e, e);
        this.a.addView(i(), new FrameLayout.LayoutParams(h, h, BadgeDrawable.BOTTOM_START));
    }

    /* access modifiers changed from: private */
    public final Context a() {
        Context context = this.a.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "adRendererView.context");
        return context;
    }

    /* access modifiers changed from: private */
    public final void a(AppCompatImageView appCompatImageView) {
        appCompatImageView.setClickable(false);
        appCompatImageView.setFocusable(false);
        appCompatImageView.setImageResource(R.drawable.wortise_watermark);
    }
}

package com.wortise.ads.banner;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.TypedArray;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.wortise.ads.AdError;
import com.wortise.ads.AdEvent;
import com.wortise.ads.AdResponse;
import com.wortise.ads.AdResult;
import com.wortise.ads.AdSize;
import com.wortise.ads.AdType;
import com.wortise.ads.R;
import com.wortise.ads.RequestParameters;
import com.wortise.ads.WortiseLog;
import com.wortise.ads.b0;
import com.wortise.ads.device.Dimensions;
import com.wortise.ads.e;
import com.wortise.ads.n6;
import com.wortise.ads.renderers.AdRendererView;
import com.wortise.ads.v0;
import com.wortise.ads.y6;
import com.wortise.ads.z6;
import java.util.Iterator;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(bv = {}, d1 = {"\u0000±\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0017*\u0001l\b\u0016\u0018\u0000 \u00012\u00020\u0001:\u0003\u0003\u0001B\u0013\b\u0016\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0006\b\u0001\u0010\u0001B\u001d\b\u0016\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0006\b\u0001\u0010\u0001B&\b\u0016\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\u0007\u0010\u0001\u001a\u00020/¢\u0006\u0006\b\u0001\u0010\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0003\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u001a\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J%\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH@ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0010J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0013\u001a\u00020\u0002H\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0002J\u0010\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\b\u0010\u0019\u001a\u00020\u0002H\u0002J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0011H\u0002J\b\u0010\u001b\u001a\u00020\u0011H\u0002J\b\u0010\u001c\u001a\u00020\u0011H\u0002J\b\u0010\u001d\u001a\u00020\u0002H\u0002J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u001eH\u0002J\u001c\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u001e2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010!\u001a\u00020 H\u0002J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\"H\u0002J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010!\u001a\u00020 H\u0002J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010%\u001a\u00020$H\u0002J\u0006\u0010&\u001a\u00020\u0002J\u0014\u0010'\u001a\u00020\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0007J\u0006\u0010(\u001a\u00020\u0002J\u0006\u0010)\u001a\u00020\u0002J\u0016\u0010.\u001a\u00020\u00022\u0006\u0010+\u001a\u00020*2\u0006\u0010-\u001a\u00020,J\u0010\u00101\u001a\u00020\u00022\u0006\u00100\u001a\u00020/H\u0014R\u0018\u00103\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0003\u00102R\u0018\u00105\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0004\u00104R\u001b\u0010:\u001a\u0002068BX\u0002¢\u0006\f\n\u0004\b\u0012\u00107\u001a\u0004\b8\u00109R\u0018\u0010=\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010<R\u0016\u0010?\u001a\u00020\u00118\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010>R\u0016\u0010A\u001a\u00020/8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010@R\u0018\u0010B\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0019\u00102R\u0018\u0010D\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010CR\u001b\u0010H\u001a\u00020E8BX\u0002¢\u0006\f\n\u0004\b\u001c\u00107\u001a\u0004\bF\u0010GR\"\u0010O\u001a\u00020\u00078\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\"\u0010[\u001a\u00020*8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bV\u0010W\u001a\u0004\bX\u0010Y\"\u0004\b.\u0010ZR*\u0010]\u001a\u00020\u00112\u0006\u0010+\u001a\u00020\u00118\u0006@FX\u000e¢\u0006\u0012\n\u0004\b\\\u0010>\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R$\u0010c\u001a\u00020\u00112\u0006\u0010a\u001a\u00020\u00118\u0006@BX\u000e¢\u0006\f\n\u0004\bb\u0010>\u001a\u0004\bc\u0010^R$\u0010k\u001a\u0004\u0018\u00010d8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\be\u0010f\u001a\u0004\bg\u0010h\"\u0004\bi\u0010jR\u0014\u0010o\u001a\u00020l8\u0002X\u0004¢\u0006\u0006\n\u0004\bm\u0010nR\u0014\u0010s\u001a\u00020p8\u0002X\u0004¢\u0006\u0006\n\u0004\bq\u0010rR\u0014\u0010w\u001a\u00020t8\u0002X\u0004¢\u0006\u0006\n\u0004\bu\u0010vR\u0016\u0010z\u001a\u0004\u0018\u00010\u00148BX\u0004¢\u0006\u0006\u001a\u0004\bx\u0010yR\u0011\u0010}\u001a\u00020/8F¢\u0006\u0006\u001a\u0004\b{\u0010|R\u0011\u0010\u001a\u00020/8F¢\u0006\u0006\u001a\u0004\b~\u0010|R\u0013\u0010\u0001\u001a\u00020/8F¢\u0006\u0007\u001a\u0005\b\u0001\u0010|R\u0013\u0010\u0001\u001a\u00020/8F¢\u0006\u0007\u001a\u0005\b\u0001\u0010|\u0002\u0004\n\u0002\b\u0019¨\u0006\u0001"}, d2 = {"Lcom/wortise/ads/banner/BannerAd;", "Landroid/widget/FrameLayout;", "", "a", "b", "Landroid/content/res/TypedArray;", "array", "Lcom/wortise/ads/AdSize;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "adUnitId", "Lcom/wortise/ads/RequestParameters;", "parameters", "(Ljava/lang/String;Lcom/wortise/ads/RequestParameters;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "c", "e", "Lcom/wortise/ads/device/Dimensions;", "f", "Lcom/wortise/ads/AdResult;", "result", "setParameters", "g", "start", "h", "i", "d", "Lcom/wortise/ads/AdError;", "error", "Lcom/wortise/ads/AdResponse;", "response", "Lcom/wortise/ads/renderers/AdRendererView;", "view", "Landroid/content/Intent;", "intent", "destroy", "loadAd", "pause", "resume", "", "value", "Ljava/util/concurrent/TimeUnit;", "tu", "setAutoRefreshTime", "", "visibility", "onWindowVisibilityChanged", "Lcom/wortise/ads/renderers/AdRendererView;", "adRendererView", "Lcom/wortise/ads/AdResult;", "adResult", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/Lazy;", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/Job;", "job", "Z", "isLoadRequested", "I", "latestVisibility", "newRendererView", "Ljava/lang/Long;", "remoteAutoRefreshTime", "Landroid/os/Handler;", "getUiHandler", "()Landroid/os/Handler;", "uiHandler", "j", "Lcom/wortise/ads/AdSize;", "getAdSize", "()Lcom/wortise/ads/AdSize;", "setAdSize", "(Lcom/wortise/ads/AdSize;)V", "adSize", "k", "Ljava/lang/String;", "getAdUnitId", "()Ljava/lang/String;", "setAdUnitId", "(Ljava/lang/String;)V", "l", "J", "getAutoRefreshTime", "()J", "(J)V", "autoRefreshTime", "m", "isAutoRefresh", "()Z", "setAutoRefresh", "(Z)V", "<set-?>", "n", "isDestroyed", "Lcom/wortise/ads/banner/BannerAd$Listener;", "o", "Lcom/wortise/ads/banner/BannerAd$Listener;", "getListener", "()Lcom/wortise/ads/banner/BannerAd$Listener;", "setListener", "(Lcom/wortise/ads/banner/BannerAd$Listener;)V", "listener", "com/wortise/ads/banner/BannerAd$b", "p", "Lcom/wortise/ads/banner/BannerAd$b;", "adRendererListener", "Ljava/lang/Runnable;", "q", "Ljava/lang/Runnable;", "refreshTimer", "Landroid/content/BroadcastReceiver;", "r", "Landroid/content/BroadcastReceiver;", "screenReceiver", "getRenderSize", "()Lcom/wortise/ads/device/Dimensions;", "renderSize", "getAdHeight", "()I", "adHeight", "getAdHeightPx", "adHeightPx", "getAdWidth", "adWidth", "getAdWidthPx", "adWidthPx", "<init>", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion", "Listener", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: BannerAd.kt */
public class BannerAd extends FrameLayout {
    public static final a Companion = new a((DefaultConstructorMarker) null);
    private static final long s;
    private static final long t;
    private AdRendererView a;
    private AdResult b;
    private final Lazy c = LazyKt.lazy(c.a);
    private Job d;
    private boolean e;
    private int f;
    private AdRendererView g;
    private Long h;
    private final Lazy i = LazyKt.lazy(i.a);
    private AdSize j = AdSize.MATCH_VIEW;
    private String k;
    private long l;
    private boolean m = true;
    private boolean n;
    private Listener o;
    private final b p = new b(this);
    private final Runnable q = new BannerAd$$ExternalSyntheticLambda0(this);
    private final BroadcastReceiver r = v0.a(new h(this));

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\n"}, d2 = {"Lcom/wortise/ads/banner/BannerAd$Listener;", "", "onBannerClicked", "", "ad", "Lcom/wortise/ads/banner/BannerAd;", "onBannerFailed", "error", "Lcom/wortise/ads/AdError;", "onBannerLoaded", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: BannerAd.kt */
    public interface Listener {
        void onBannerClicked(BannerAd bannerAd);

        void onBannerFailed(BannerAd bannerAd, AdError adError);

        void onBannerLoaded(BannerAd bannerAd);
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0004¨\u0006\u000b"}, d2 = {"Lcom/wortise/ads/banner/BannerAd$a;", "", "", "DEFAULT_REFRESH_MILLISECONDS", "J", "", "DEFAULT_REFRESH_SECONDS", "I", "MIN_REFRESH_MILLISECONDS", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* compiled from: BannerAd.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"com/wortise/ads/banner/BannerAd$b", "Lcom/wortise/ads/renderers/AdRendererView$a;", "Lcom/wortise/ads/renderers/AdRendererView;", "view", "", "a", "b", "Lcom/wortise/ads/AdError;", "error", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* compiled from: BannerAd.kt */
    public static final class b implements AdRendererView.a {
        final /* synthetic */ BannerAd a;

        b(BannerAd bannerAd) {
            this.a = bannerAd;
        }

        public void a(AdRendererView adRendererView, AdEvent adEvent) {
            AdRendererView.a.C0191a.a(this, adRendererView, adEvent);
        }

        public void b(AdRendererView adRendererView) {
            Intrinsics.checkNotNullParameter(adRendererView, "view");
            this.a.a(adRendererView);
        }

        public void a(AdRendererView adRendererView) {
            Intrinsics.checkNotNullParameter(adRendererView, "view");
            this.a.d();
        }

        public void a(AdRendererView adRendererView, AdError adError) {
            Intrinsics.checkNotNullParameter(adRendererView, "view");
            Intrinsics.checkNotNullParameter(adError, "error");
            this.a.a(adError);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: BannerAd.kt */
    static final class c extends Lambda implements Function0<CoroutineScope> {
        public static final c a = new c();

        c() {
            super(0);
        }

        /* renamed from: a */
        public final CoroutineScope invoke() {
            return CoroutineScopeKt.MainScope();
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n"}, d2 = {"Landroid/content/res/TypedArray;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: BannerAd.kt */
    static final class d extends Lambda implements Function1<TypedArray, Unit> {
        final /* synthetic */ BannerAd a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(BannerAd bannerAd) {
            super(1);
            this.a = bannerAd;
        }

        public final void a(TypedArray typedArray) {
            Intrinsics.checkNotNullParameter(typedArray, "$this$use");
            BannerAd bannerAd = this.a;
            bannerAd.setAdSize(bannerAd.a(typedArray));
            this.a.setAdUnitId(typedArray.getString(R.styleable.AdView_adUnitId));
            int i = typedArray.getInt(R.styleable.AdView_autoRefreshTime, 0);
            if (i > 0) {
                this.a.setAutoRefreshTime((long) i, TimeUnit.SECONDS);
            }
            boolean unused = this.a.c();
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((TypedArray) obj);
            return Unit.INSTANCE;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.wortise.ads.banner.BannerAd$loadAd$1", f = "BannerAd.kt", i = {}, l = {140}, m = "invokeSuspend", n = {}, s = {})
    /* compiled from: BannerAd.kt */
    static final class e extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int a;
        final /* synthetic */ BannerAd b;
        final /* synthetic */ String c;
        final /* synthetic */ RequestParameters d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(BannerAd bannerAd, String str, RequestParameters requestParameters, Continuation<? super e> continuation) {
            super(2, continuation);
            this.b = bannerAd;
            this.c = str;
            this.d = requestParameters;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((e) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new e(this.b, this.c, this.d, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                BannerAd bannerAd = this.b;
                String str = this.c;
                RequestParameters requestParameters = this.d;
                this.a = 1;
                if (bannerAd.a(str, requestParameters, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.wortise.ads.banner.BannerAd", f = "BannerAd.kt", i = {0}, l = {204}, m = "loadAd", n = {"this"}, s = {"L$0"})
    /* compiled from: BannerAd.kt */
    static final class f extends ContinuationImpl {
        Object a;
        /* synthetic */ Object b;
        final /* synthetic */ BannerAd c;
        int d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(BannerAd bannerAd, Continuation<? super f> continuation) {
            super(continuation);
            this.c = bannerAd;
        }

        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return this.c.a((String) null, (RequestParameters) null, this);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/wortise/ads/e$b;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.wortise.ads.banner.BannerAd$loadAd$result$1", f = "BannerAd.kt", i = {}, l = {205}, m = "invokeSuspend", n = {}, s = {})
    /* compiled from: BannerAd.kt */
    static final class g extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super e.b>, Object> {
        int a;
        final /* synthetic */ com.wortise.ads.e b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(com.wortise.ads.e eVar, Continuation<? super g> continuation) {
            super(2, continuation);
            this.b = eVar;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super e.b> continuation) {
            return ((g) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new g(this.b, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                com.wortise.ads.e eVar = this.b;
                this.a = 1;
                obj = eVar.a((Continuation<? super e.b>) this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return obj;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n"}, d2 = {"Landroid/content/Context;", "<anonymous parameter 0>", "Landroid/content/Intent;", "intent", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: BannerAd.kt */
    static final class h extends Lambda implements Function2<Context, Intent, Unit> {
        final /* synthetic */ BannerAd a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(BannerAd bannerAd) {
            super(2);
            this.a = bannerAd;
        }

        public final void a(Context context, Intent intent) {
            Intrinsics.checkNotNullParameter(context, "$noName_0");
            Intrinsics.checkNotNullParameter(intent, "intent");
            this.a.a(intent);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((Context) obj, (Intent) obj2);
            return Unit.INSTANCE;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Landroid/os/Handler;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: BannerAd.kt */
    static final class i extends Lambda implements Function0<Handler> {
        public static final i a = new i();

        i() {
            super(0);
        }

        /* renamed from: a */
        public final Handler invoke() {
            return new Handler(Looper.getMainLooper());
        }
    }

    static {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        s = timeUnit.toMillis(60);
        t = timeUnit.toMillis(15);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BannerAd(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        a(context, (AttributeSet) null);
    }

    private final void a() {
        Job job = this.d;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        AdRendererView adRendererView = this.g;
        if (adRendererView != null) {
            adRendererView.destroy();
        }
    }

    private final void b() {
        getUiHandler().removeCallbacks(this.q);
    }

    /* access modifiers changed from: private */
    public final boolean c() {
        if (!this.n) {
            String str = this.k;
            if (!(str == null || str.length() == 0)) {
                loadAd$default(this, (RequestParameters) null, 1, (Object) null);
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public final void d() {
        Listener listener = this.o;
        if (listener != null) {
            listener.onBannerClicked(this);
        }
    }

    private final void e() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        getContext().registerReceiver(this.r, intentFilter);
    }

    private final Dimensions f() {
        int i2;
        int i3;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        ViewParent parent = getParent();
        View view = parent instanceof View ? (View) parent : null;
        if (this.j.getWidth() > 0) {
            AdSize adSize = this.j;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            i2 = adSize.getWidthPixelSize(context);
        } else if (view == null || layoutParams == null || layoutParams.width >= 0) {
            i2 = getWidth();
        } else {
            i2 = view.getWidth();
        }
        if (this.j.getHeight() > 0) {
            AdSize adSize2 = this.j;
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            i3 = adSize2.getHeightPixelSize(context2);
        } else if (view == null || layoutParams == null || layoutParams.height >= 0) {
            i3 = getHeight();
        } else {
            i3 = view.getHeight();
        }
        return new Dimensions(i2, i3);
    }

    private final void g() {
        Object obj;
        boolean z;
        if (!this.n && this.e && this.m) {
            Iterator it = CollectionsKt.listOfNotNull((T[]) new Long[]{Long.valueOf(this.l), this.h}).iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (((Number) obj).longValue() > 0) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    break;
                }
            }
            Long l2 = (Long) obj;
            long longValue = l2 == null ? s : l2.longValue();
            b();
            getUiHandler().postDelayed(this.q, Math.max(t, longValue));
        }
    }

    private final CoroutineScope getCoroutineScope() {
        return (CoroutineScope) this.c.getValue();
    }

    private final Dimensions getRenderSize() {
        AdRendererView adRendererView = this.a;
        if (adRendererView == null) {
            return null;
        }
        return adRendererView.getRenderSize();
    }

    private final Handler getUiHandler() {
        return (Handler) this.i.getValue();
    }

    private final boolean h() {
        AdResult adResult = this.b;
        AdResponse nextAd = adResult == null ? null : adResult.nextAd();
        if (nextAd == null) {
            return false;
        }
        b(nextAd);
        return true;
    }

    private final boolean i() {
        try {
            getContext().unregisterReceiver(this.r);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static /* synthetic */ void loadAd$default(BannerAd bannerAd, RequestParameters requestParameters, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                requestParameters = null;
            }
            bannerAd.loadAd(requestParameters);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadAd");
    }

    static /* synthetic */ void onBannerFailed$default(BannerAd bannerAd, AdError adError, AdResult adResult, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                adResult = null;
            }
            bannerAd.a(adError, adResult);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onBannerFailed");
    }

    private final void setParameters(AdResult adResult) {
        Long refreshTime = adResult.getRefreshTime();
        if (refreshTime != null) {
            this.h = Long.valueOf(refreshTime.longValue());
        }
    }

    public final void destroy() {
        if (!this.n) {
            i();
            CoroutineScopeKt.cancel$default(getCoroutineScope(), (CancellationException) null, 1, (Object) null);
            AdRendererView adRendererView = this.a;
            if (adRendererView != null) {
                adRendererView.destroy();
            }
            AdRendererView adRendererView2 = this.g;
            if (adRendererView2 != null) {
                adRendererView2.destroy();
            }
            this.n = true;
        }
    }

    public final int getAdHeight() {
        Dimensions renderSize = getRenderSize();
        if (renderSize == null) {
            return -1;
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        return renderSize.a(context);
    }

    public final int getAdHeightPx() {
        Dimensions renderSize;
        AdRendererView adRendererView = this.a;
        if (adRendererView == null || (renderSize = adRendererView.getRenderSize()) == null) {
            return -1;
        }
        return renderSize.a();
    }

    public final AdSize getAdSize() {
        return this.j;
    }

    public final String getAdUnitId() {
        return this.k;
    }

    public final int getAdWidth() {
        Dimensions renderSize = getRenderSize();
        if (renderSize == null) {
            return -1;
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        return renderSize.b(context);
    }

    public final int getAdWidthPx() {
        Dimensions renderSize = getRenderSize();
        if (renderSize == null) {
            return -1;
        }
        return renderSize.c();
    }

    public final long getAutoRefreshTime() {
        return this.l;
    }

    public final Listener getListener() {
        return this.o;
    }

    public final boolean isAutoRefresh() {
        return this.m;
    }

    public final boolean isDestroyed() {
        return this.n;
    }

    public final void loadAd() {
        loadAd$default(this, (RequestParameters) null, 1, (Object) null);
    }

    public final void loadAd(RequestParameters requestParameters) {
        if (!this.n) {
            String str = this.k;
            if (str == null) {
                onBannerFailed$default(this, AdError.INVALID_PARAMS, (AdResult) null, 2, (Object) null);
                return;
            }
            this.e = true;
            b();
            a();
            this.d = BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), (CoroutineContext) null, (CoroutineStart) null, new e(this, str, requestParameters, (Continuation<? super e>) null), 3, (Object) null);
        }
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        z6 z6Var = z6.a;
        if (z6Var.a(this.f, i2)) {
            this.f = i2;
            a(z6Var.a(i2));
        }
    }

    public final void pause() {
        AdRendererView adRendererView = this.a;
        if (adRendererView != null) {
            adRendererView.pause();
        }
    }

    public final void resume() {
        AdRendererView adRendererView = this.a;
        if (adRendererView != null) {
            adRendererView.resume();
        }
    }

    public final void setAdSize(AdSize adSize) {
        Intrinsics.checkNotNullParameter(adSize, "<set-?>");
        this.j = adSize;
    }

    public final void setAdUnitId(String str) {
        this.k = str;
    }

    public final void setAutoRefresh(boolean z) {
        this.m = z;
        a(z);
    }

    public final void setAutoRefreshTime(long j2) {
        this.l = j2;
    }

    public final void setListener(Listener listener) {
        this.o = listener;
    }

    private final void b(AdResponse adResponse) {
        if (!adResponse.a(AdType.BANNER)) {
            a(AdError.INVALID_PARAMS);
        } else {
            a(adResponse);
        }
    }

    public final void setAutoRefreshTime(long j2, TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter(timeUnit, "tu");
        this.l = timeUnit.toMillis(j2);
    }

    /* access modifiers changed from: private */
    public final AdSize a(TypedArray typedArray) {
        try {
            AdSize from = AdSize.Companion.from(typedArray.getString(R.styleable.AdView_adSize));
            if (from != null) {
                return from;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        } catch (Throwable unused) {
            return AdSize.MATCH_VIEW;
        }
    }

    private final void a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            int[] iArr = R.styleable.AdView;
            Intrinsics.checkNotNullExpressionValue(iArr, "AdView");
            TypedArray a2 = b0.a(attributeSet, context, iArr);
            if (a2 != null) {
                n6.a(a2, new d(this));
            }
        }
        this.f = getWindowVisibility();
        e();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(java.lang.String r11, com.wortise.ads.RequestParameters r12, kotlin.coroutines.Continuation<? super kotlin.Unit> r13) {
        /*
            r10 = this;
            boolean r0 = r13 instanceof com.wortise.ads.banner.BannerAd.f
            if (r0 == 0) goto L_0x0013
            r0 = r13
            com.wortise.ads.banner.BannerAd$f r0 = (com.wortise.ads.banner.BannerAd.f) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.d = r1
            goto L_0x0018
        L_0x0013:
            com.wortise.ads.banner.BannerAd$f r0 = new com.wortise.ads.banner.BannerAd$f
            r0.<init>(r10, r13)
        L_0x0018:
            java.lang.Object r13 = r0.b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r11 = r0.a
            com.wortise.ads.banner.BannerAd r11 = (com.wortise.ads.banner.BannerAd) r11
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x0065
        L_0x002d:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r13)
            com.wortise.ads.e r13 = new com.wortise.ads.e
            android.content.Context r5 = r10.getContext()
            java.lang.String r2 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r2)
            com.wortise.ads.device.Dimensions r8 = r10.f()
            com.wortise.ads.AdType r9 = com.wortise.ads.AdType.BANNER
            r4 = r13
            r6 = r11
            r7 = r12
            r4.<init>(r5, r6, r7, r8, r9)
            kotlinx.coroutines.CoroutineDispatcher r11 = kotlinx.coroutines.Dispatchers.getIO()
            com.wortise.ads.banner.BannerAd$g r12 = new com.wortise.ads.banner.BannerAd$g
            r2 = 0
            r12.<init>(r13, r2)
            r0.a = r10
            r0.d = r3
            java.lang.Object r13 = kotlinx.coroutines.BuildersKt.withContext(r11, r12, r0)
            if (r13 != r1) goto L_0x0064
            return r1
        L_0x0064:
            r11 = r10
        L_0x0065:
            com.wortise.ads.e$b r13 = (com.wortise.ads.e.b) r13
            boolean r12 = r13 instanceof com.wortise.ads.e.b.a
            if (r12 == 0) goto L_0x0079
            com.wortise.ads.e$b$a r13 = (com.wortise.ads.e.b.a) r13
            com.wortise.ads.AdError r12 = r13.b()
            com.wortise.ads.AdResult r13 = r13.a()
            r11.a((com.wortise.ads.AdError) r12, (com.wortise.ads.AdResult) r13)
            goto L_0x0086
        L_0x0079:
            boolean r12 = r13 instanceof com.wortise.ads.e.b.C0001b
            if (r12 == 0) goto L_0x0086
            com.wortise.ads.e$b$b r13 = (com.wortise.ads.e.b.C0001b) r13
            com.wortise.ads.AdResult r12 = r13.a()
            r11.a((com.wortise.ads.AdResult) r12)
        L_0x0086:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wortise.ads.banner.BannerAd.a(java.lang.String, com.wortise.ads.RequestParameters, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void a(boolean z) {
        if (z) {
            g();
        } else {
            b();
        }
    }

    /* access modifiers changed from: private */
    public final void a(AdError adError) {
        if (!h()) {
            onBannerFailed$default(this, adError, (AdResult) null, 2, (Object) null);
        }
    }

    private final void a(AdError adError, AdResult adResult) {
        if (adResult != null) {
            setParameters(adResult);
        }
        g();
        WortiseLog.i$default(Intrinsics.stringPlus("Ad load failed: ", adError.name()), (Throwable) null, 2, (Object) null);
        Listener listener = this.o;
        if (listener != null) {
            listener.onBannerFailed(this, adError);
        }
    }

    private final void a(AdResult adResult) {
        this.b = adResult;
        setParameters(adResult);
        if (!h()) {
            onBannerFailed$default(this, AdError.NO_FILL, (AdResult) null, 2, (Object) null);
        }
    }

    private final void a(AdResponse adResponse) {
        WortiseLog.i$default(Intrinsics.stringPlus("Ad loaded for ad unit ", this.k), (Throwable) null, 2, (Object) null);
        AdRendererView adRendererView = this.g;
        if (adRendererView != null) {
            adRendererView.destroy();
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        AdRendererView adRendererView2 = new AdRendererView(context);
        adRendererView2.setAdSize(getAdSize());
        adRendererView2.setListener(this.p);
        adRendererView2.setSize(f());
        adRendererView2.setShouldHonorServerSize(true);
        adRendererView2.renderAd(adResponse);
        Unit unit = Unit.INSTANCE;
        this.g = adRendererView2;
    }

    /* access modifiers changed from: private */
    public final void a(AdRendererView adRendererView) {
        if (Intrinsics.areEqual((Object) adRendererView, (Object) this.g)) {
            AdRendererView adRendererView2 = this.a;
            if (adRendererView2 != null) {
                adRendererView2.destroy();
                y6.a(adRendererView2);
            }
            this.a = adRendererView;
            this.g = null;
            addView(adRendererView);
            g();
            Listener listener = this.o;
            if (listener != null) {
                listener.onBannerLoaded(this);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void a(Intent intent) {
        String action = intent.getAction();
        if (action != null) {
            int hashCode = action.hashCode();
            if (hashCode != -2128145023) {
                if (hashCode == 823795052 && action.equals("android.intent.action.USER_PRESENT")) {
                    WortiseLog.d$default("Screen went on, starting ad refreshing.", (Throwable) null, 2, (Object) null);
                    g();
                }
            } else if (action.equals("android.intent.action.SCREEN_OFF")) {
                WortiseLog.d$default("Screen went off, stopping ad refreshing.", (Throwable) null, 2, (Object) null);
                b();
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void a(BannerAd bannerAd) {
        Intrinsics.checkNotNullParameter(bannerAd, "this$0");
        bannerAd.c();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BannerAd(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        a(context, attributeSet);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BannerAd(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        a(context, attributeSet);
    }
}

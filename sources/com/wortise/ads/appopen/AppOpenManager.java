package com.wortise.ads.appopen;

import android.app.Activity;
import android.app.Application;
import androidx.lifecycle.ProcessLifecycleOwner;
import com.wortise.ads.RequestParameters;
import com.wortise.ads.appopen.AppOpenAd;
import com.wortise.ads.b;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000[\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000*\u0001)\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0015\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\b\u0010+\u001a\u00020,H\u0002J\u0006\u0010-\u001a\u00020,J\b\u0010.\u001a\u00020,H\u0002J\u0014\u0010/\u001a\u00020,2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'H\u0007J\u0014\u00100\u001a\u00020\u00112\n\b\u0002\u00101\u001a\u0004\u0018\u000102H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R$\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u00118F@FX\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0014R\u0011\u0010\u0018\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0014R\u0011\u0010\u0019\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0014R(\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0010\u001a\u0004\u0018\u00010\u001a8F@FX\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010!\u001a\u00020 2\u0006\u0010\u0010\u001a\u00020 8F@FX\u000e¢\u0006\f\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u00020)X\u0004¢\u0006\u0004\n\u0002\u0010*¨\u00063"}, d2 = {"Lcom/wortise/ads/appopen/AppOpenManager;", "", "context", "Landroid/content/Context;", "adUnitId", "", "(Landroid/content/Context;Ljava/lang/String;)V", "application", "Landroid/app/Application;", "(Landroid/app/Application;Ljava/lang/String;)V", "appOpenAd", "Lcom/wortise/ads/appopen/AppOpenAd;", "getAppOpenAd", "()Lcom/wortise/ads/appopen/AppOpenAd;", "appOpenAd$delegate", "Lkotlin/Lazy;", "value", "", "autoReload", "getAutoReload", "()Z", "setAutoReload", "(Z)V", "isAvailable", "isDestroyed", "isShowing", "Lcom/wortise/ads/appopen/AppOpenAd$Listener;", "listener", "getListener", "()Lcom/wortise/ads/appopen/AppOpenAd$Listener;", "setListener", "(Lcom/wortise/ads/appopen/AppOpenAd$Listener;)V", "Lcom/wortise/ads/appopen/AppOpenAd$Orientation;", "orientation", "getOrientation", "()Lcom/wortise/ads/appopen/AppOpenAd$Orientation;", "setOrientation", "(Lcom/wortise/ads/appopen/AppOpenAd$Orientation;)V", "parameters", "Lcom/wortise/ads/RequestParameters;", "processLifecycleObserver", "com/wortise/ads/appopen/AppOpenManager$processLifecycleObserver$1", "Lcom/wortise/ads/appopen/AppOpenManager$processLifecycleObserver$1;", "cleanUp", "", "destroy", "initialize", "loadAd", "showAd", "activity", "Landroid/app/Activity;", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: AppOpenManager.kt */
public final class AppOpenManager {
    /* access modifiers changed from: private */
    public final String adUnitId;
    private final Lazy appOpenAd$delegate;
    /* access modifiers changed from: private */
    public final Application application;
    private RequestParameters parameters;
    private final AppOpenManager$processLifecycleObserver$1 processLifecycleObserver;

    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcom/wortise/ads/appopen/AppOpenAd;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: AppOpenManager.kt */
    static final class a extends Lambda implements Function0<AppOpenAd> {
        final /* synthetic */ AppOpenManager a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(AppOpenManager appOpenManager) {
            super(0);
            this.a = appOpenManager;
        }

        /* renamed from: a */
        public final AppOpenAd invoke() {
            return new AppOpenAd(this.a.application, this.a.adUnitId);
        }
    }

    public AppOpenManager(Application application2, String str) {
        Intrinsics.checkNotNullParameter(application2, "application");
        Intrinsics.checkNotNullParameter(str, "adUnitId");
        this.application = application2;
        this.adUnitId = str;
        this.appOpenAd$delegate = LazyKt.lazy(new a(this));
        this.processLifecycleObserver = new AppOpenManager$processLifecycleObserver$1(this);
        initialize();
    }

    private final void cleanUp() {
        ProcessLifecycleOwner.get().getLifecycle().removeObserver(this.processLifecycleObserver);
    }

    private final AppOpenAd getAppOpenAd() {
        return (AppOpenAd) this.appOpenAd$delegate.getValue();
    }

    private final void initialize() {
        ProcessLifecycleOwner.get().getLifecycle().addObserver(this.processLifecycleObserver);
    }

    public static /* synthetic */ void loadAd$default(AppOpenManager appOpenManager, RequestParameters requestParameters, int i, Object obj) {
        if ((i & 1) != 0) {
            requestParameters = appOpenManager.parameters;
        }
        appOpenManager.loadAd(requestParameters);
    }

    public static /* synthetic */ boolean showAd$default(AppOpenManager appOpenManager, Activity activity, int i, Object obj) {
        if ((i & 1) != 0) {
            activity = b.a.a();
        }
        return appOpenManager.showAd(activity);
    }

    public final void destroy() {
        getAppOpenAd().destroy();
        cleanUp();
    }

    public final boolean getAutoReload() {
        return getAppOpenAd().getAutoReload();
    }

    public final AppOpenAd.Listener getListener() {
        return getAppOpenAd().getListener();
    }

    public final AppOpenAd.Orientation getOrientation() {
        return getAppOpenAd().getOrientation();
    }

    public final boolean isAvailable() {
        return getAppOpenAd().isAvailable();
    }

    public final boolean isDestroyed() {
        return getAppOpenAd().isDestroyed();
    }

    public final boolean isShowing() {
        return getAppOpenAd().isShowing();
    }

    public final void loadAd() {
        loadAd$default(this, (RequestParameters) null, 1, (Object) null);
    }

    public final void loadAd(RequestParameters requestParameters) {
        getAppOpenAd().loadAd(requestParameters);
    }

    public final void setAutoReload(boolean z) {
        getAppOpenAd().setAutoReload(z);
    }

    public final void setListener(AppOpenAd.Listener listener) {
        getAppOpenAd().setListener(listener);
    }

    public final void setOrientation(AppOpenAd.Orientation orientation) {
        Intrinsics.checkNotNullParameter(orientation, "value");
        getAppOpenAd().setOrientation(orientation);
    }

    public final boolean showAd() {
        return showAd$default(this, (Activity) null, 1, (Object) null);
    }

    public final boolean showAd(Activity activity) {
        return getAppOpenAd().tryToShowAd(activity);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AppOpenManager(android.content.Context r2, java.lang.String r3) {
        /*
            r1 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "adUnitId"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            android.content.Context r2 = r2.getApplicationContext()
            if (r2 == 0) goto L_0x0016
            android.app.Application r2 = (android.app.Application) r2
            r1.<init>((android.app.Application) r2, (java.lang.String) r3)
            return
        L_0x0016:
            java.lang.NullPointerException r2 = new java.lang.NullPointerException
            java.lang.String r3 = "null cannot be cast to non-null type android.app.Application"
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wortise.ads.appopen.AppOpenManager.<init>(android.content.Context, java.lang.String):void");
    }
}

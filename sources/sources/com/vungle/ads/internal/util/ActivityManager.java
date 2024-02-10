package com.vungle.ads.internal.util;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.media3.common.C;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vungle.ads.AnalyticsClient;
import com.vungle.ads.internal.ui.PresenterAdOpenCallback;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 .2\u00020\u0001:\u0003./0B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0006J\u0010\u0010\u0019\u001a\u00020\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001dH\u0007J\b\u0010\u001e\u001a\u00020\u000eH\u0005J\u000e\u0010\u001f\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001dJ\u001a\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u0010\u0010%\u001a\u00020\u00172\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010&\u001a\u00020\u00172\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010'\u001a\u00020\u00172\u0006\u0010!\u001a\u00020\"H\u0016J\u0018\u0010(\u001a\u00020\u00172\u0006\u0010!\u001a\u00020\"2\u0006\u0010)\u001a\u00020$H\u0016J\u0010\u0010*\u001a\u00020\u00172\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010+\u001a\u00020\u00172\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010,\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0006H\u0002J\u0012\u0010-\u001a\u00020\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u0005H\u0002R\u001c\u0010\u0003\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/vungle/ads/internal/util/ActivityManager;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "()V", "adLeftCallbacks", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/vungle/ads/internal/util/ActivityManager$LeftApplicationCallback;", "Lcom/vungle/ads/internal/util/ActivityManager$LifeCycleCallback;", "callbacks", "Ljava/util/concurrent/CopyOnWriteArraySet;", "configChangeRunnable", "Ljava/lang/Runnable;", "handler", "Landroid/os/Handler;", "<set-?>", "", "isInitialized", "()Z", "paused", "resumed", "", "started", "stopped", "addListener", "", "callback", "addOnNextAppLeftCallback", "leftCallback", "deInit", "context", "Landroid/content/Context;", "inForeground", "init", "onActivityCreated", "activity", "Landroid/app/Activity;", "savedInstanceState", "Landroid/os/Bundle;", "onActivityDestroyed", "onActivityPaused", "onActivityResumed", "onActivitySaveInstanceState", "outState", "onActivityStarted", "onActivityStopped", "removeListener", "removeOnNextAppLeftCallback", "Companion", "LeftApplicationCallback", "LifeCycleCallback", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ActivityManager.kt */
public final class ActivityManager implements Application.ActivityLifecycleCallbacks {
    /* access modifiers changed from: private */
    public static final long CONFIG_CHANGE_DELAY = 700;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final String TAG = "ActivityManager";
    /* access modifiers changed from: private */
    public static final long TIMEOUT = C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS;
    /* access modifiers changed from: private */
    public static final ActivityManager instance = new ActivityManager();
    /* access modifiers changed from: private */
    public final ConcurrentHashMap<LeftApplicationCallback, LifeCycleCallback> adLeftCallbacks = new ConcurrentHashMap<>();
    private final CopyOnWriteArraySet<LifeCycleCallback> callbacks = new CopyOnWriteArraySet<>();
    private final Runnable configChangeRunnable = new ActivityManager$$ExternalSyntheticLambda0(this);
    /* access modifiers changed from: private */
    public Handler handler;
    private boolean isInitialized;
    private boolean paused = true;
    private int resumed;
    private int started;
    private boolean stopped = true;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/vungle/ads/internal/util/ActivityManager$LeftApplicationCallback;", "", "onLeftApplication", "", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ActivityManager.kt */
    public interface LeftApplicationCallback {
        void onLeftApplication();
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016¨\u0006\b"}, d2 = {"Lcom/vungle/ads/internal/util/ActivityManager$LifeCycleCallback;", "", "()V", "onPause", "", "onResume", "onStart", "onStop", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ActivityManager.kt */
    public static class LifeCycleCallback {
        public void onPause() {
        }

        public void onResume() {
        }

        public void onStart() {
        }

        public void onStop() {
        }
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    public void onActivityDestroyed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(bundle, "outState");
    }

    private ActivityManager() {
    }

    public final boolean isInitialized() {
        return this.isInitialized;
    }

    /* access modifiers changed from: private */
    /* renamed from: configChangeRunnable$lambda-0  reason: not valid java name */
    public static final void m2331configChangeRunnable$lambda0(ActivityManager activityManager) {
        Intrinsics.checkNotNullParameter(activityManager, "this$0");
        if (activityManager.resumed == 0 && !activityManager.paused) {
            activityManager.paused = true;
            Iterator<LifeCycleCallback> it = activityManager.callbacks.iterator();
            while (it.hasNext()) {
                it.next().onPause();
            }
        }
        if (activityManager.started == 0 && activityManager.paused && !activityManager.stopped) {
            activityManager.stopped = true;
            Iterator<LifeCycleCallback> it2 = activityManager.callbacks.iterator();
            while (it2.hasNext()) {
                it2.next().onStop();
            }
        }
    }

    public final void init(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (!this.isInitialized) {
            this.handler = new Handler(Looper.getMainLooper());
            Context applicationContext = context.getApplicationContext();
            Intrinsics.checkNotNull(applicationContext, "null cannot be cast to non-null type android.app.Application");
            ((Application) applicationContext).registerActivityLifecycleCallbacks(this);
            this.isInitialized = true;
        }
    }

    public final void deInit(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNull(applicationContext, "null cannot be cast to non-null type android.app.Application");
        ((Application) applicationContext).unregisterActivityLifecycleCallbacks(this);
        this.started = 0;
        this.resumed = 0;
        this.paused = true;
        this.stopped = true;
        this.isInitialized = false;
        this.callbacks.clear();
        this.adLeftCallbacks.clear();
    }

    /* access modifiers changed from: protected */
    public final boolean inForeground() {
        return !this.isInitialized || this.started > 0;
    }

    public final void addListener(LifeCycleCallback lifeCycleCallback) {
        Intrinsics.checkNotNullParameter(lifeCycleCallback, "callback");
        this.callbacks.add(lifeCycleCallback);
    }

    /* access modifiers changed from: private */
    public final void removeListener(LifeCycleCallback lifeCycleCallback) {
        this.callbacks.remove(lifeCycleCallback);
    }

    public void onActivityStarted(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        int i = this.started + 1;
        this.started = i;
        if (i == 1 && this.stopped) {
            this.stopped = false;
            Iterator<LifeCycleCallback> it = this.callbacks.iterator();
            while (it.hasNext()) {
                it.next().onStart();
            }
        }
    }

    public void onActivityStopped(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.started = Math.max(0, this.started - 1);
        Handler handler2 = this.handler;
        if (handler2 != null) {
            handler2.postDelayed(this.configChangeRunnable, CONFIG_CHANGE_DELAY);
        }
    }

    public void onActivityResumed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        int i = this.resumed + 1;
        this.resumed = i;
        if (i != 1) {
            return;
        }
        if (this.paused) {
            this.paused = false;
            Iterator<LifeCycleCallback> it = this.callbacks.iterator();
            while (it.hasNext()) {
                it.next().onResume();
            }
            return;
        }
        Handler handler2 = this.handler;
        if (handler2 != null) {
            handler2.removeCallbacks(this.configChangeRunnable);
        }
    }

    public void onActivityPaused(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.resumed = Math.max(0, this.resumed - 1);
        Handler handler2 = this.handler;
        if (handler2 != null) {
            handler2.postDelayed(this.configChangeRunnable, CONFIG_CHANGE_DELAY);
        }
    }

    public final void addOnNextAppLeftCallback(LeftApplicationCallback leftApplicationCallback) {
        if (leftApplicationCallback != null) {
            if (!this.isInitialized) {
                leftApplicationCallback.onLeftApplication();
                return;
            }
            WeakReference weakReference = new WeakReference(leftApplicationCallback);
            Runnable activityManager$addOnNextAppLeftCallback$cancelRunnable$1 = new ActivityManager$addOnNextAppLeftCallback$cancelRunnable$1(this, weakReference);
            LifeCycleCallback activityManager$addOnNextAppLeftCallback$callback$1 = new ActivityManager$addOnNextAppLeftCallback$callback$1(weakReference, this, activityManager$addOnNextAppLeftCallback$cancelRunnable$1);
            this.adLeftCallbacks.put(leftApplicationCallback, activityManager$addOnNextAppLeftCallback$callback$1);
            if (inForeground()) {
                Handler handler2 = this.handler;
                if (handler2 != null) {
                    handler2.postDelayed(activityManager$addOnNextAppLeftCallback$cancelRunnable$1, TIMEOUT);
                }
                addListener(activityManager$addOnNextAppLeftCallback$callback$1);
                return;
            }
            instance.addListener(new ActivityManager$addOnNextAppLeftCallback$1(this, weakReference, activityManager$addOnNextAppLeftCallback$cancelRunnable$1));
        }
    }

    /* access modifiers changed from: private */
    public final void removeOnNextAppLeftCallback(LeftApplicationCallback leftApplicationCallback) {
        LifeCycleCallback remove;
        if (leftApplicationCallback != null && (remove = this.adLeftCallbacks.remove(leftApplicationCallback)) != null) {
            removeListener(remove);
        }
    }

    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J.\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0002J,\u0010!\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\"\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010#\u001a\u0004\u0018\u00010$J6\u0010!\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010\u001f\u001a\u0004\u0018\u00010 R\u001c\u0010\u0003\u001a\u00020\u00048\u0006XD¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R\u0019\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u00020\u00048\u0006XD¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u0002\u001a\u0004\b\u000f\u0010\u0007R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006%"}, d2 = {"Lcom/vungle/ads/internal/util/ActivityManager$Companion;", "", "()V", "CONFIG_CHANGE_DELAY", "", "getCONFIG_CHANGE_DELAY$annotations", "getCONFIG_CHANGE_DELAY", "()J", "TAG", "", "kotlin.jvm.PlatformType", "getTAG", "()Ljava/lang/String;", "TIMEOUT", "getTIMEOUT$annotations", "getTIMEOUT", "instance", "Lcom/vungle/ads/internal/util/ActivityManager;", "getInstance", "()Lcom/vungle/ads/internal/util/ActivityManager;", "addLifecycleListener", "", "listener", "Lcom/vungle/ads/internal/util/ActivityManager$LifeCycleCallback;", "startActivityHandleException", "", "context", "Landroid/content/Context;", "deepLinkOverrideIntent", "Landroid/content/Intent;", "defaultIntent", "adOpenCallback", "Lcom/vungle/ads/internal/ui/PresenterAdOpenCallback;", "startWhenForeground", "deeplinkOverrideIntent", "leftCallback", "Lcom/vungle/ads/internal/util/ActivityManager$LeftApplicationCallback;", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ActivityManager.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getCONFIG_CHANGE_DELAY$annotations() {
        }

        public static /* synthetic */ void getTIMEOUT$annotations() {
        }

        private Companion() {
        }

        public final String getTAG() {
            return ActivityManager.TAG;
        }

        public final ActivityManager getInstance() {
            return ActivityManager.instance;
        }

        public final long getTIMEOUT() {
            return ActivityManager.TIMEOUT;
        }

        public final long getCONFIG_CHANGE_DELAY() {
            return ActivityManager.CONFIG_CHANGE_DELAY;
        }

        public final void startWhenForeground(Context context, Intent intent, Intent intent2, LeftApplicationCallback leftApplicationCallback, PresenterAdOpenCallback presenterAdOpenCallback) {
            Intrinsics.checkNotNullParameter(context, "context");
            WeakReference weakReference = new WeakReference(context);
            if (!getInstance().inForeground()) {
                getInstance().addListener(new ActivityManager$Companion$startWhenForeground$1(weakReference, intent, intent2, presenterAdOpenCallback, leftApplicationCallback));
            } else if (startActivityHandleException(context, intent, intent2, presenterAdOpenCallback)) {
                getInstance().addOnNextAppLeftCallback(leftApplicationCallback);
            }
        }

        public final void startWhenForeground(Context context, Intent intent, Intent intent2, LeftApplicationCallback leftApplicationCallback) {
            Intrinsics.checkNotNullParameter(context, "context");
            startWhenForeground(context, intent, intent2, leftApplicationCallback, (PresenterAdOpenCallback) null);
        }

        /* access modifiers changed from: private */
        public final boolean startActivityHandleException(Context context, Intent intent, Intent intent2, PresenterAdOpenCallback presenterAdOpenCallback) {
            Context context2 = context;
            Intent intent3 = intent2;
            PresenterAdOpenCallback presenterAdOpenCallback2 = presenterAdOpenCallback;
            if (intent == null && intent3 == null) {
                return false;
            }
            if (intent != null) {
                try {
                    context.startActivity(intent);
                    if (presenterAdOpenCallback2 != null) {
                        presenterAdOpenCallback2.onDeeplinkClick(true);
                    }
                } catch (Exception e) {
                    String tag = getTAG();
                    Log.e(tag, "Cannot launch/find activity to handle the Implicit intent: " + e);
                    if (intent != null) {
                        try {
                            AnalyticsClient analyticsClient = AnalyticsClient.INSTANCE;
                            AnalyticsClient.logError$vungle_ads_release$default(analyticsClient, 312, "Fail to open " + intent.getDataString(), "", (String) null, (String) null, 24, (Object) null);
                            if (presenterAdOpenCallback2 != null) {
                                presenterAdOpenCallback2.onDeeplinkClick(false);
                            }
                        } catch (Exception unused) {
                            return false;
                        }
                    }
                    if (intent != null) {
                        if (intent3 != null) {
                            context2.startActivity(intent3);
                            return true;
                        }
                    }
                    return false;
                }
            } else {
                context2.startActivity(intent3);
            }
            return true;
        }

        public final void addLifecycleListener(LifeCycleCallback lifeCycleCallback) {
            Intrinsics.checkNotNullParameter(lifeCycleCallback, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            getInstance().addListener(lifeCycleCallback);
        }
    }
}

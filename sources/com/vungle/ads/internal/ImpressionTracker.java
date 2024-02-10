package com.vungle.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.core.view.ViewCompat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 /2\u00020\u0001:\u0004/012B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B+\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0018\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00072\b\u0010$\u001a\u0004\u0018\u00010%J\u0006\u0010&\u001a\u00020\"J\u0006\u0010'\u001a\u00020\"J\u001e\u0010(\u001a\u0004\u0018\u00010\u00072\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010#\u001a\u0004\u0018\u00010\u0007H\u0002J\u001a\u0010)\u001a\u00020\u000f2\b\u0010#\u001a\u0004\u0018\u00010\u00072\u0006\u0010*\u001a\u00020+H\u0002J\u0010\u0010,\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0007H\u0007J\b\u0010-\u001a\u00020\"H\u0002J\u001c\u0010.\u001a\u00020\u000f2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010#\u001a\u0004\u0018\u00010\u0007H\u0002R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u00020\u00118\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001a\u00060\u0018R\u00020\u0000X\u0004¢\u0006\u0002\n\u0000R,\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u001a8\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001c\u0010\u0013\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u00063"}, d2 = {"Lcom/vungle/ads/internal/ImpressionTracker;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "trackedViews", "", "Landroid/view/View;", "Lcom/vungle/ads/internal/ImpressionTracker$TrackingInfo;", "visibilityHandler", "Landroid/os/Handler;", "(Landroid/content/Context;Ljava/util/Map;Landroid/os/Handler;)V", "clipRect", "Landroid/graphics/Rect;", "isVisibilityScheduled", "", "onPreDrawListener", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "getOnPreDrawListener$annotations", "()V", "getOnPreDrawListener", "()Landroid/view/ViewTreeObserver$OnPreDrawListener;", "setViewTreeObserverSucceed", "visibilityRunnable", "Lcom/vungle/ads/internal/ImpressionTracker$VisibilityRunnable;", "weakViewTreeObserver", "Ljava/lang/ref/WeakReference;", "Landroid/view/ViewTreeObserver;", "getWeakViewTreeObserver$annotations", "getWeakViewTreeObserver", "()Ljava/lang/ref/WeakReference;", "setWeakViewTreeObserver", "(Ljava/lang/ref/WeakReference;)V", "addView", "", "view", "listener", "Lcom/vungle/ads/internal/ImpressionTracker$ImpressionListener;", "clear", "destroy", "getTopView", "isVisible", "minPercentageViewed", "", "removeView", "scheduleVisibilityCheck", "setViewTreeObserver", "Companion", "ImpressionListener", "TrackingInfo", "VisibilityRunnable", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ImpressionTracker.kt */
public final class ImpressionTracker {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int MIN_VISIBILITY_PERCENTAGE = 1;
    private static final String TAG = "ImpressionTracker";
    private static final int VISIBILITY_THROTTLE_MILLIS = 100;
    private final Rect clipRect;
    /* access modifiers changed from: private */
    public boolean isVisibilityScheduled;
    private final ViewTreeObserver.OnPreDrawListener onPreDrawListener;
    /* access modifiers changed from: private */
    public boolean setViewTreeObserverSucceed;
    /* access modifiers changed from: private */
    public final Map<View, TrackingInfo> trackedViews;
    private final Handler visibilityHandler;
    private final VisibilityRunnable visibilityRunnable;
    private WeakReference<ViewTreeObserver> weakViewTreeObserver;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0001\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/vungle/ads/internal/ImpressionTracker$ImpressionListener;", "", "onImpression", "", "view", "Landroid/view/View;", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ImpressionTracker.kt */
    public interface ImpressionListener {
        void onImpression(View view);
    }

    public static /* synthetic */ void getOnPreDrawListener$annotations() {
    }

    public static /* synthetic */ void getWeakViewTreeObserver$annotations() {
    }

    public ImpressionTracker(Context context, Map<View, TrackingInfo> map, Handler handler) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(map, "trackedViews");
        Intrinsics.checkNotNullParameter(handler, "visibilityHandler");
        this.trackedViews = map;
        this.visibilityHandler = handler;
        this.clipRect = new Rect();
        this.visibilityRunnable = new VisibilityRunnable();
        this.onPreDrawListener = new ImpressionTracker$$ExternalSyntheticLambda0(this);
        this.weakViewTreeObserver = new WeakReference<>((Object) null);
        this.setViewTreeObserverSucceed = setViewTreeObserver(context, (View) null);
    }

    public final ViewTreeObserver.OnPreDrawListener getOnPreDrawListener() {
        return this.onPreDrawListener;
    }

    public final WeakReference<ViewTreeObserver> getWeakViewTreeObserver() {
        return this.weakViewTreeObserver;
    }

    public final void setWeakViewTreeObserver(WeakReference<ViewTreeObserver> weakReference) {
        Intrinsics.checkNotNullParameter(weakReference, "<set-?>");
        this.weakViewTreeObserver = weakReference;
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/vungle/ads/internal/ImpressionTracker$TrackingInfo;", "", "()V", "impressionListener", "Lcom/vungle/ads/internal/ImpressionTracker$ImpressionListener;", "getImpressionListener", "()Lcom/vungle/ads/internal/ImpressionTracker$ImpressionListener;", "setImpressionListener", "(Lcom/vungle/ads/internal/ImpressionTracker$ImpressionListener;)V", "minViewablePercent", "", "getMinViewablePercent", "()I", "setMinViewablePercent", "(I)V", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ImpressionTracker.kt */
    public static final class TrackingInfo {
        private ImpressionListener impressionListener;
        private int minViewablePercent;

        public final int getMinViewablePercent() {
            return this.minViewablePercent;
        }

        public final void setMinViewablePercent(int i) {
            this.minViewablePercent = i;
        }

        public final ImpressionListener getImpressionListener() {
            return this.impressionListener;
        }

        public final void setImpressionListener(ImpressionListener impressionListener2) {
            this.impressionListener = impressionListener2;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ImpressionTracker(Context context) {
        this(context, new WeakHashMap(10), new Handler());
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final boolean setViewTreeObserver(Context context, View view) {
        ViewTreeObserver viewTreeObserver = (ViewTreeObserver) this.weakViewTreeObserver.get();
        if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
            return true;
        }
        View topView = getTopView(context, view);
        if (topView == null) {
            Log.d(TAG, "Unable to set ViewTreeObserver due to no available root view.");
            return false;
        }
        ViewTreeObserver viewTreeObserver2 = topView.getViewTreeObserver();
        if (!viewTreeObserver2.isAlive()) {
            Log.d(TAG, "The root view tree observer was not alive");
            return false;
        }
        this.weakViewTreeObserver = new WeakReference<>(viewTreeObserver2);
        viewTreeObserver2.addOnPreDrawListener(this.onPreDrawListener);
        return true;
    }

    public final void addView(View view, ImpressionListener impressionListener) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.setViewTreeObserverSucceed = setViewTreeObserver(view.getContext(), view);
        TrackingInfo trackingInfo = this.trackedViews.get(view);
        if (trackingInfo == null) {
            trackingInfo = new TrackingInfo();
            this.trackedViews.put(view, trackingInfo);
            scheduleVisibilityCheck();
        }
        trackingInfo.setMinViewablePercent(1);
        trackingInfo.setImpressionListener(impressionListener);
    }

    public final void removeView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.trackedViews.remove(view);
    }

    public final void clear() {
        this.trackedViews.clear();
        this.visibilityHandler.removeMessages(0);
        this.isVisibilityScheduled = false;
    }

    public final void destroy() {
        clear();
        ViewTreeObserver viewTreeObserver = (ViewTreeObserver) this.weakViewTreeObserver.get();
        if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnPreDrawListener(this.onPreDrawListener);
        }
        this.weakViewTreeObserver.clear();
    }

    private final View getTopView(Context context, View view) {
        View findViewById = context instanceof Activity ? ((Activity) context).getWindow().getDecorView().findViewById(16908290) : null;
        if (findViewById != null || view == null) {
            return findViewById;
        }
        if (!ViewCompat.isAttachedToWindow(view)) {
            Log.w(TAG, "Trying to call View#rootView() on an unattached View.");
        }
        View rootView = view.getRootView();
        if (rootView != null) {
            findViewById = rootView.findViewById(16908290);
        }
        return findViewById == null ? rootView : findViewById;
    }

    /* access modifiers changed from: private */
    public final void scheduleVisibilityCheck() {
        if (!this.isVisibilityScheduled) {
            this.isVisibilityScheduled = true;
            this.visibilityHandler.postDelayed(this.visibilityRunnable, 100);
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001a\u00020\u0007H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/vungle/ads/internal/ImpressionTracker$VisibilityRunnable;", "Ljava/lang/Runnable;", "(Lcom/vungle/ads/internal/ImpressionTracker;)V", "visibleViews", "Ljava/util/ArrayList;", "Landroid/view/View;", "run", "", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ImpressionTracker.kt */
    public final class VisibilityRunnable implements Runnable {
        private final ArrayList<View> visibleViews = new ArrayList<>();

        public VisibilityRunnable() {
        }

        public void run() {
            ImpressionListener impressionListener;
            ImpressionTracker.this.isVisibilityScheduled = false;
            for (Map.Entry entry : ImpressionTracker.this.trackedViews.entrySet()) {
                View view = (View) entry.getKey();
                if (ImpressionTracker.this.isVisible(view, ((TrackingInfo) entry.getValue()).getMinViewablePercent())) {
                    this.visibleViews.add(view);
                }
            }
            Iterator<View> it = this.visibleViews.iterator();
            while (it.hasNext()) {
                View next = it.next();
                TrackingInfo trackingInfo = (TrackingInfo) ImpressionTracker.this.trackedViews.get(next);
                if (!(trackingInfo == null || (impressionListener = trackingInfo.getImpressionListener()) == null)) {
                    impressionListener.onImpression(next);
                }
                ImpressionTracker impressionTracker = ImpressionTracker.this;
                Intrinsics.checkNotNullExpressionValue(next, "view");
                impressionTracker.removeView(next);
            }
            this.visibleViews.clear();
            if ((!ImpressionTracker.this.trackedViews.isEmpty()) && !ImpressionTracker.this.setViewTreeObserverSucceed) {
                ImpressionTracker.this.scheduleVisibilityCheck();
            }
        }
    }

    /* access modifiers changed from: private */
    public final boolean isVisible(View view, int i) {
        if (view == null || view.getVisibility() != 0 || view.getParent() == null || !view.getGlobalVisibleRect(this.clipRect)) {
            return false;
        }
        long height = ((long) this.clipRect.height()) * ((long) this.clipRect.width());
        long height2 = ((long) view.getHeight()) * ((long) view.getWidth());
        if (height2 > 0 && ((long) 100) * height >= ((long) i) * height2) {
            return true;
        }
        return false;
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/vungle/ads/internal/ImpressionTracker$Companion;", "", "()V", "MIN_VISIBILITY_PERCENTAGE", "", "TAG", "", "kotlin.jvm.PlatformType", "VISIBILITY_THROTTLE_MILLIS", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ImpressionTracker.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final boolean m2273_init_$lambda0(ImpressionTracker impressionTracker) {
        Intrinsics.checkNotNullParameter(impressionTracker, "this$0");
        impressionTracker.scheduleVisibilityCheck();
        return true;
    }
}

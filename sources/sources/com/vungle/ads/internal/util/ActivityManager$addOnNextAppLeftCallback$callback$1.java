package com.vungle.ads.internal.util;

import android.os.Handler;
import com.vungle.ads.internal.util.ActivityManager;
import java.lang.ref.WeakReference;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"com/vungle/ads/internal/util/ActivityManager$addOnNextAppLeftCallback$callback$1", "Lcom/vungle/ads/internal/util/ActivityManager$LifeCycleCallback;", "wasPaused", "", "getWasPaused", "()Z", "setWasPaused", "(Z)V", "onPause", "", "onResume", "onStop", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ActivityManager.kt */
public final class ActivityManager$addOnNextAppLeftCallback$callback$1 extends ActivityManager.LifeCycleCallback {
    final /* synthetic */ Runnable $cancelRunnable;
    final /* synthetic */ WeakReference<ActivityManager.LeftApplicationCallback> $weakCallback;
    final /* synthetic */ ActivityManager this$0;
    private boolean wasPaused;

    ActivityManager$addOnNextAppLeftCallback$callback$1(WeakReference<ActivityManager.LeftApplicationCallback> weakReference, ActivityManager activityManager, Runnable runnable) {
        this.$weakCallback = weakReference;
        this.this$0 = activityManager;
        this.$cancelRunnable = runnable;
    }

    public final boolean getWasPaused() {
        return this.wasPaused;
    }

    public final void setWasPaused(boolean z) {
        this.wasPaused = z;
    }

    public void onStop() {
        super.onStop();
        ActivityManager.LeftApplicationCallback leftApplicationCallback = (ActivityManager.LeftApplicationCallback) this.$weakCallback.get();
        if (this.wasPaused && leftApplicationCallback != null && this.this$0.adLeftCallbacks.containsKey(leftApplicationCallback)) {
            leftApplicationCallback.onLeftApplication();
        }
        this.this$0.removeOnNextAppLeftCallback(leftApplicationCallback);
        Handler access$getHandler$p = this.this$0.handler;
        if (access$getHandler$p != null) {
            access$getHandler$p.removeCallbacks(this.$cancelRunnable);
        }
    }

    public void onResume() {
        super.onResume();
        Handler access$getHandler$p = this.this$0.handler;
        if (access$getHandler$p != null) {
            access$getHandler$p.postDelayed(this.$cancelRunnable, ActivityManager.Companion.getCONFIG_CHANGE_DELAY() * ((long) 2));
        }
    }

    public void onPause() {
        super.onPause();
        this.wasPaused = true;
        Handler access$getHandler$p = this.this$0.handler;
        if (access$getHandler$p != null) {
            access$getHandler$p.removeCallbacks(this.$cancelRunnable);
        }
    }
}

package com.vungle.ads.internal.util;

import android.os.Handler;
import com.vungle.ads.internal.util.ActivityManager;
import java.lang.ref.WeakReference;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/vungle/ads/internal/util/ActivityManager$addOnNextAppLeftCallback$cancelRunnable$1", "Ljava/lang/Runnable;", "run", "", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ActivityManager.kt */
public final class ActivityManager$addOnNextAppLeftCallback$cancelRunnable$1 implements Runnable {
    final /* synthetic */ WeakReference<ActivityManager.LeftApplicationCallback> $weakCallback;
    final /* synthetic */ ActivityManager this$0;

    ActivityManager$addOnNextAppLeftCallback$cancelRunnable$1(ActivityManager activityManager, WeakReference<ActivityManager.LeftApplicationCallback> weakReference) {
        this.this$0 = activityManager;
        this.$weakCallback = weakReference;
    }

    public void run() {
        Handler access$getHandler$p = this.this$0.handler;
        if (access$getHandler$p != null) {
            access$getHandler$p.removeCallbacks(this);
        }
        this.this$0.removeOnNextAppLeftCallback((ActivityManager.LeftApplicationCallback) this.$weakCallback.get());
    }
}

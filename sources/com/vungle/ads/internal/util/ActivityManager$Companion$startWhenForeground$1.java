package com.vungle.ads.internal.util;

import android.content.Context;
import android.content.Intent;
import com.vungle.ads.internal.ui.PresenterAdOpenCallback;
import com.vungle.ads.internal.util.ActivityManager;
import java.lang.ref.WeakReference;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/vungle/ads/internal/util/ActivityManager$Companion$startWhenForeground$1", "Lcom/vungle/ads/internal/util/ActivityManager$LifeCycleCallback;", "onStart", "", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ActivityManager.kt */
public final class ActivityManager$Companion$startWhenForeground$1 extends ActivityManager.LifeCycleCallback {
    final /* synthetic */ PresenterAdOpenCallback $adOpenCallback;
    final /* synthetic */ Intent $deepLinkOverrideIntent;
    final /* synthetic */ Intent $defaultIntent;
    final /* synthetic */ ActivityManager.LeftApplicationCallback $leftCallback;
    final /* synthetic */ WeakReference<Context> $weakContext;

    ActivityManager$Companion$startWhenForeground$1(WeakReference<Context> weakReference, Intent intent, Intent intent2, PresenterAdOpenCallback presenterAdOpenCallback, ActivityManager.LeftApplicationCallback leftApplicationCallback) {
        this.$weakContext = weakReference;
        this.$deepLinkOverrideIntent = intent;
        this.$defaultIntent = intent2;
        this.$adOpenCallback = presenterAdOpenCallback;
        this.$leftCallback = leftApplicationCallback;
    }

    public void onStart() {
        super.onStart();
        ActivityManager.Companion.getInstance().removeListener(this);
        Context context = (Context) this.$weakContext.get();
        if (context != null && ActivityManager.Companion.startActivityHandleException(context, this.$deepLinkOverrideIntent, this.$defaultIntent, this.$adOpenCallback)) {
            ActivityManager.Companion.getInstance().addOnNextAppLeftCallback(this.$leftCallback);
        }
    }
}

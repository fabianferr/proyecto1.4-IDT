package com.wortise.ads.appopen;

import android.app.Activity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0007¨\u0006\u0004"}, d2 = {"com/wortise/ads/appopen/AppOpenManager$processLifecycleObserver$1", "Landroidx/lifecycle/LifecycleObserver;", "onStart", "", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: AppOpenManager.kt */
public final class AppOpenManager$processLifecycleObserver$1 implements LifecycleObserver {
    final /* synthetic */ AppOpenManager a;

    AppOpenManager$processLifecycleObserver$1(AppOpenManager appOpenManager) {
        this.a = appOpenManager;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public final void onStart() {
        AppOpenManager.showAd$default(this.a, (Activity) null, 1, (Object) null);
    }
}

package com.applovin.adview;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.applovin.impl.adview.activity.b.a;
import com.applovin.impl.adview.o;
import com.applovin.impl.sdk.m;
import java.util.concurrent.atomic.AtomicBoolean;

public class AppLovinFullscreenAdViewObserver implements LifecycleObserver {
    private final m a;
    private final AtomicBoolean b = new AtomicBoolean(true);
    private a c;
    private o d;

    public AppLovinFullscreenAdViewObserver(Lifecycle lifecycle, o oVar, m mVar) {
        this.d = oVar;
        this.a = mVar;
        lifecycle.addObserver(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        o oVar = this.d;
        if (oVar != null) {
            oVar.e();
            this.d = null;
        }
        a aVar = this.c;
        if (aVar != null) {
            aVar.h();
            this.c.k();
            this.c = null;
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {
        a aVar = this.c;
        if (aVar != null) {
            aVar.g();
            this.c.e();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
        a aVar;
        if (!this.b.getAndSet(false) && (aVar = this.c) != null) {
            aVar.f();
            this.c.a(0);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop() {
        a aVar = this.c;
        if (aVar != null) {
            aVar.j();
        }
    }

    public void setPresenter(a aVar) {
        this.c = aVar;
    }
}

package com.applovin.impl.sdk;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class a implements Application.ActivityLifecycleCallbacks {
    private final List<com.applovin.impl.sdk.utils.a> a = Collections.synchronizedList(new ArrayList());
    private WeakReference<Activity> b = new WeakReference<>((Object) null);
    private WeakReference<Activity> c = new WeakReference<>((Object) null);

    public a(Context context) {
        if (u.a()) {
            u.f("AppLovinSdk", "Attaching Activity lifecycle manager...");
        }
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            this.b = new WeakReference<>(activity);
            if (activity.hasWindowFocus()) {
                this.c = this.b;
            }
        }
        ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(this);
    }

    public Activity a() {
        return (Activity) this.b.get();
    }

    public void a(com.applovin.impl.sdk.utils.a aVar) {
        this.a.add(aVar);
    }

    public Activity b() {
        return (Activity) this.c.get();
    }

    public void b(com.applovin.impl.sdk.utils.a aVar) {
        this.a.remove(aVar);
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        for (com.applovin.impl.sdk.utils.a onActivityCreated : new ArrayList(this.a)) {
            onActivityCreated.onActivityCreated(activity, bundle);
        }
    }

    public void onActivityDestroyed(Activity activity) {
        for (com.applovin.impl.sdk.utils.a onActivityDestroyed : new ArrayList(this.a)) {
            onActivityDestroyed.onActivityDestroyed(activity);
        }
    }

    public void onActivityPaused(Activity activity) {
        this.c = new WeakReference<>((Object) null);
        for (com.applovin.impl.sdk.utils.a onActivityPaused : new ArrayList(this.a)) {
            onActivityPaused.onActivityPaused(activity);
        }
    }

    public void onActivityResumed(Activity activity) {
        WeakReference<Activity> weakReference = new WeakReference<>(activity);
        this.b = weakReference;
        this.c = weakReference;
        for (com.applovin.impl.sdk.utils.a onActivityResumed : new ArrayList(this.a)) {
            onActivityResumed.onActivityResumed(activity);
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        for (com.applovin.impl.sdk.utils.a onActivitySaveInstanceState : new ArrayList(this.a)) {
            onActivitySaveInstanceState.onActivitySaveInstanceState(activity, bundle);
        }
    }

    public void onActivityStarted(Activity activity) {
        for (com.applovin.impl.sdk.utils.a onActivityStarted : new ArrayList(this.a)) {
            onActivityStarted.onActivityStarted(activity);
        }
    }

    public void onActivityStopped(Activity activity) {
        for (com.applovin.impl.sdk.utils.a onActivityStopped : new ArrayList(this.a)) {
            onActivityStopped.onActivityStopped(activity);
        }
    }
}

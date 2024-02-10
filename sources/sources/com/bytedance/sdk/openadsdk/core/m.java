package com.bytedance.sdk.openadsdk.core;

import android.app.Application;
import android.content.Context;
import com.bytedance.sdk.openadsdk.ApmHelper;

/* compiled from: InitLifecycleHelper */
public class m {
    private final com.bytedance.sdk.openadsdk.utils.a a = new com.bytedance.sdk.openadsdk.utils.a();
    private boolean b;

    /* compiled from: InitLifecycleHelper */
    private static class a {
        /* access modifiers changed from: private */
        public static final m a = new m();
    }

    public static m a() {
        return a.a;
    }

    public boolean a(boolean z) {
        return this.a.a(z);
    }

    public void b() {
        try {
            Context a2 = o.a();
            if (a2 instanceof Application) {
                ((Application) a2).registerActivityLifecycleCallbacks(this.a);
            } else if (a2 != null && a2.getApplicationContext() != null) {
                ((Application) a2.getApplicationContext()).registerActivityLifecycleCallbacks(this.a);
            } else {
                return;
            }
            this.b = true;
        } catch (Throwable th) {
            ApmHelper.reportCustomError("registerActivityLifecycleError", "registerActivityLifecycle", th);
        }
    }

    public boolean c() {
        return this.b;
    }

    public String d() {
        return this.a.c();
    }

    public void e() {
        this.a.b();
    }

    public boolean f() {
        return this.a.a();
    }

    public com.bytedance.sdk.openadsdk.utils.a g() {
        return this.a;
    }
}

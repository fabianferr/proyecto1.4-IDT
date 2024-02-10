package com.applovin.impl.mediation;

import android.app.Activity;
import android.os.Bundle;
import com.applovin.impl.mediation.a.c;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.u;

public class a extends com.applovin.impl.sdk.utils.a {
    private final com.applovin.impl.sdk.a a;
    private final u b;
    private C0010a c;
    private c d;
    private int e;
    private boolean f;

    /* renamed from: com.applovin.impl.mediation.a$a  reason: collision with other inner class name */
    public interface C0010a {
        void a(c cVar);
    }

    a(m mVar) {
        this.b = mVar.A();
        this.a = mVar.af();
    }

    public void a() {
        if (u.a()) {
            this.b.b("AdActivityObserver", "Cancelling...");
        }
        this.a.b(this);
        this.c = null;
        this.d = null;
        this.e = 0;
        this.f = false;
    }

    public void a(c cVar, C0010a aVar) {
        if (u.a()) {
            u uVar = this.b;
            uVar.b("AdActivityObserver", "Starting for ad " + cVar.getAdUnitId() + "...");
        }
        a();
        this.c = aVar;
        this.d = cVar;
        this.a.a(this);
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (!this.f) {
            this.f = true;
        }
        this.e++;
        if (u.a()) {
            this.b.b("AdActivityObserver", "Created Activity: " + activity + ", counter is " + this.e);
        }
    }

    public void onActivityDestroyed(Activity activity) {
        if (this.f) {
            this.e--;
            if (u.a()) {
                this.b.b("AdActivityObserver", "Destroyed Activity: " + activity + ", counter is " + this.e);
            }
            if (this.e <= 0) {
                if (u.a()) {
                    this.b.b("AdActivityObserver", "Last ad Activity destroyed");
                }
                if (this.c != null) {
                    if (u.a()) {
                        this.b.b("AdActivityObserver", "Invoking callback...");
                    }
                    this.c.a(this.d);
                }
                a();
            }
        }
    }
}

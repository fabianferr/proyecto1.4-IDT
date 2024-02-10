package com.applovin.impl.mediation.c;

import android.app.Activity;
import android.text.TextUtils;
import com.applovin.impl.mediation.a.f;
import com.applovin.impl.sdk.f.o;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.u;
import com.applovin.sdk.AppLovinMediationProvider;
import java.util.List;

public class a extends com.applovin.impl.sdk.f.a {
    private final List<f> a;
    /* access modifiers changed from: private */
    public final Activity c;

    /* renamed from: com.applovin.impl.mediation.c.a$a  reason: collision with other inner class name */
    public static class C0012a extends com.applovin.impl.sdk.f.a {
        /* access modifiers changed from: private */
        public final f a;
        /* access modifiers changed from: private */
        public final List<f> c;
        /* access modifiers changed from: private */
        public final Activity d;

        private C0012a(f fVar, List<f> list, m mVar, Activity activity) {
            super("TaskSequentialInitAdapter:" + fVar.M(), mVar, true);
            this.d = activity;
            this.a = fVar;
            this.c = list;
        }

        public void run() {
            if (u.a()) {
                a("Auto-initing " + this.a + "...");
            }
            this.b.D().a(this.a, this.d, new Runnable() {
                public void run() {
                    if (u.a()) {
                        C0012a aVar = C0012a.this;
                        aVar.a("Initialization task for adapter '" + C0012a.this.a.N() + "' finished");
                    }
                    int indexOf = C0012a.this.c.indexOf(C0012a.this.a);
                    if (indexOf < C0012a.this.c.size() - 1) {
                        f fVar = (f) C0012a.this.c.get(indexOf + 1);
                        C0012a.this.b.S().a((com.applovin.impl.sdk.f.a) new C0012a(fVar, C0012a.this.c, C0012a.this.b, C0012a.this.d), o.a.MAIN, fVar.aa());
                    } else if (u.a()) {
                        C0012a.this.a("Finished initializing adapters");
                    }
                }
            });
        }
    }

    public a(List<f> list, Activity activity, m mVar) {
        super("TaskAutoInitAdapters", mVar, true);
        this.a = list;
        this.c = activity;
    }

    public void run() {
        try {
            if (this.a.size() > 0) {
                if (u.a()) {
                    StringBuilder sb = new StringBuilder("Auto-initing ");
                    sb.append(this.a.size());
                    sb.append(" adapters");
                    sb.append(this.b.J().a() ? " in test mode" : "");
                    sb.append("...");
                    a(sb.toString());
                }
                if (TextUtils.isEmpty(this.b.t())) {
                    this.b.c(AppLovinMediationProvider.MAX);
                } else if (!this.b.f() && u.a()) {
                    u.i("AppLovinSdk", "Auto-initing adapters for non-MAX mediation provider: " + this.b.t());
                }
                if (u.a() && this.c == null) {
                    u.i("AppLovinSdk", "\n**********\nAttempting to init 3rd-party SDKs without an Activity instance.\n**********\n");
                }
                if (((Boolean) this.b.a(com.applovin.impl.sdk.d.a.O)).booleanValue()) {
                    f fVar = this.a.get(0);
                    this.b.S().a((com.applovin.impl.sdk.f.a) new C0012a(fVar, this.a, this.b, this.c), o.a.MAIN, fVar.aa());
                    return;
                }
                for (final f next : this.a) {
                    this.b.S().a((Runnable) new Runnable() {
                        public void run() {
                            if (u.a()) {
                                a aVar = a.this;
                                aVar.a("Auto-initing adapter: " + next);
                            }
                            a.this.b.D().a(next, a.this.c);
                        }
                    });
                }
            }
        } catch (Throwable th) {
            if (u.a()) {
                a("Failed to auto-init adapters", th);
            }
        }
    }
}

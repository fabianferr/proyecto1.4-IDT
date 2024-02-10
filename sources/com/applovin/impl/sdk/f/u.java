package com.applovin.impl.sdk.f;

import android.text.TextUtils;
import com.applovin.impl.sdk.f.o;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.network.b;
import com.applovin.impl.sdk.network.c;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinErrorCodes;
import java.util.concurrent.TimeUnit;

public abstract class u<T> extends a implements b.c<T> {
    /* access modifiers changed from: private */
    public final c<T> a;
    private final b.c<T> c;
    protected b.a d;
    /* access modifiers changed from: private */
    public o.a e;
    /* access modifiers changed from: private */
    public com.applovin.impl.sdk.d.b<String> f;
    /* access modifiers changed from: private */
    public com.applovin.impl.sdk.d.b<String> g;

    public u(c<T> cVar, m mVar) {
        this(cVar, mVar, false);
    }

    public u(c<T> cVar, final m mVar, boolean z) {
        super("TaskRepeatRequest", mVar, z);
        this.e = o.a.BACKGROUND;
        this.f = null;
        this.g = null;
        if (cVar != null) {
            this.a = cVar;
            this.d = new b.a();
            this.c = new b.c<T>() {
                public void a(int i, String str, T t) {
                    com.applovin.impl.sdk.d.b bVar;
                    u uVar;
                    boolean z = false;
                    boolean z2 = i < 200 || i >= 500;
                    boolean z3 = i == 429;
                    if ((i != -1009) && (z2 || z3 || u.this.a.m())) {
                        String f = u.this.a.f();
                        if (u.this.a.h() > 0) {
                            if (com.applovin.impl.sdk.u.a()) {
                                u uVar2 = u.this;
                                uVar2.c("Unable to send request due to server failure (code " + i + "). " + u.this.a.h() + " attempts left, retrying in " + TimeUnit.MILLISECONDS.toSeconds((long) u.this.a.k()) + " seconds...");
                            }
                            int h = u.this.a.h() - 1;
                            u.this.a.a(h);
                            if (h == 0) {
                                u uVar3 = u.this;
                                uVar3.c(uVar3.f);
                                if (StringUtils.isValidString(f) && f.length() >= 4) {
                                    if (com.applovin.impl.sdk.u.a()) {
                                        u uVar4 = u.this;
                                        uVar4.b("Switching to backup endpoint " + f);
                                    }
                                    u.this.a.a(f);
                                    z = true;
                                }
                            }
                            long millis = (!((Boolean) mVar.a(com.applovin.impl.sdk.d.b.de)).booleanValue() || !z) ? u.this.a.l() ? TimeUnit.SECONDS.toMillis((long) Math.pow(2.0d, (double) u.this.a.i())) : (long) u.this.a.k() : 0;
                            o S = mVar.S();
                            u uVar5 = u.this;
                            S.a((a) uVar5, uVar5.e, millis);
                            return;
                        }
                        if (f == null || !f.equals(u.this.a.a())) {
                            uVar = u.this;
                            bVar = uVar.f;
                        } else {
                            uVar = u.this;
                            bVar = uVar.g;
                        }
                        uVar.c(bVar);
                    }
                    u.this.a(i, str, t);
                }

                public void a(T t, int i) {
                    u.this.a.a(0);
                    u.this.a(t, i);
                }
            };
            return;
        }
        throw new IllegalArgumentException("No request specified");
    }

    /* access modifiers changed from: private */
    public <ST> void c(com.applovin.impl.sdk.d.b<ST> bVar) {
        if (bVar != null) {
            d().K().a((com.applovin.impl.sdk.d.b<?>) bVar, (Object) bVar.b());
        }
    }

    public abstract void a(int i, String str, T t);

    public void a(com.applovin.impl.sdk.d.b<String> bVar) {
        this.f = bVar;
    }

    public void a(o.a aVar) {
        this.e = aVar;
    }

    public abstract void a(T t, int i);

    public void b(com.applovin.impl.sdk.d.b<String> bVar) {
        this.g = bVar;
    }

    public void run() {
        int i;
        b R = d().R();
        if (!d().c() && !d().d()) {
            if (com.applovin.impl.sdk.u.a()) {
                com.applovin.impl.sdk.u.i("AppLovinSdk", "AppLovin SDK is disabled");
            }
            i = -22;
        } else if (!StringUtils.isValidString(this.a.a()) || this.a.a().length() < 4) {
            if (com.applovin.impl.sdk.u.a()) {
                d("Task has an invalid or null request endpoint.");
            }
            i = AppLovinErrorCodes.INVALID_URL;
        } else {
            if (TextUtils.isEmpty(this.a.b())) {
                this.a.b(this.a.e() != null ? "POST" : "GET");
            }
            R.a(this.a, this.d, this.c);
            return;
        }
        a(i, (String) null, (Object) null);
    }
}

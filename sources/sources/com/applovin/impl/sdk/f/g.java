package com.applovin.impl.sdk.f;

import android.text.TextUtils;
import com.applovin.impl.adview.d;
import com.applovin.impl.sdk.d.b;
import com.applovin.impl.sdk.f.o;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.network.i;
import com.applovin.impl.sdk.u;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.h;
import com.applovin.sdk.AppLovinErrorCodes;
import com.applovin.sdk.AppLovinPostbackListener;
import org.json.JSONException;
import org.json.JSONObject;

public class g extends a {
    /* access modifiers changed from: private */
    public final i a;
    /* access modifiers changed from: private */
    public final AppLovinPostbackListener c;
    private final o.a d;

    public g(i iVar, o.a aVar, m mVar, AppLovinPostbackListener appLovinPostbackListener) {
        super("TaskDispatchPostback", mVar);
        if (iVar != null) {
            this.a = iVar;
            this.c = appLovinPostbackListener;
            this.d = aVar;
            return;
        }
        throw new IllegalArgumentException("No request specified");
    }

    /* access modifiers changed from: private */
    public void a() {
        AnonymousClass2 r0 = new u<Object>(this.a, d()) {
            final String a;

            {
                this.a = g.this.a.a();
            }

            public void a(int i, String str, Object obj) {
                if (u.a()) {
                    d("Failed to dispatch postback. Error code: " + i + " URL: " + this.a);
                }
                if (g.this.c != null) {
                    g.this.c.onPostbackFailure(this.a, i);
                }
                if (g.this.a.p()) {
                    this.b.ag().a(g.this.a.q(), this.a, i, obj, str, false);
                }
            }

            public void a(Object obj, int i) {
                if (obj instanceof String) {
                    for (String next : this.b.b(b.aQ)) {
                        if (next.startsWith(next)) {
                            String str = (String) obj;
                            if (!TextUtils.isEmpty(str)) {
                                try {
                                    JSONObject jSONObject = new JSONObject(str);
                                    h.d(jSONObject, this.b);
                                    h.c(jSONObject, this.b);
                                    h.e(jSONObject, this.b);
                                    break;
                                } catch (JSONException unused) {
                                    continue;
                                }
                            } else {
                                continue;
                            }
                        }
                    }
                }
                if (g.this.c != null) {
                    g.this.c.onPostbackSuccess(this.a);
                }
                if (g.this.a.p()) {
                    this.b.ag().a(g.this.a.q(), this.a, i, obj, (String) null, true);
                }
            }
        };
        r0.a(this.d);
        d().S().a((a) r0);
    }

    public void run() {
        if (!StringUtils.isValidString(this.a.a())) {
            if (u.a()) {
                b("Requested URL is not valid; nothing to do...");
            }
            AppLovinPostbackListener appLovinPostbackListener = this.c;
            if (appLovinPostbackListener != null) {
                appLovinPostbackListener.onPostbackFailure(this.a.a(), AppLovinErrorCodes.INVALID_URL);
            }
        } else if (this.a.r()) {
            d.a(this.a, d(), new AppLovinPostbackListener() {
                public void onPostbackFailure(String str, int i) {
                    g.this.a();
                }

                public void onPostbackSuccess(String str) {
                    if (g.this.c != null) {
                        g.this.c.onPostbackSuccess(g.this.a.a());
                    }
                }
            });
        } else {
            a();
        }
    }
}

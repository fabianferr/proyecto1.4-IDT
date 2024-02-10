package com.ironsource.sdk.controller;

import android.app.Activity;
import android.content.Context;
import com.ironsource.environment.thread.a;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.sdk.controller.h;
import com.ironsource.sdk.controller.n;
import com.ironsource.sdk.g.c;
import com.ironsource.sdk.g.d;
import com.ironsource.sdk.j.a.b;
import com.ironsource.sdk.j.e;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class s implements n {
    final String a;
    private final a b;

    s(String str, a aVar) {
        this.b = aVar;
        this.a = str;
    }

    private void a(Runnable runnable) {
        a aVar = this.b;
        if (aVar != null) {
            aVar.c(runnable);
        }
    }

    public final void a(Activity activity) {
    }

    public final void a(Context context) {
    }

    public final void a(final h.b bVar, final n.a aVar) {
        a((Runnable) new Runnable() {
            public final void run() {
                try {
                    if (aVar != null) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("success", false);
                        jSONObject.put(IronSourceConstants.EVENTS_ERROR_REASON, s.this.a);
                        aVar.onReceive(new h.a(bVar.b(), jSONObject));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public final void a(c cVar) {
    }

    public final void a(c cVar, final Map<String, String> map, final b bVar) {
        if (bVar != null) {
            a((Runnable) new Runnable() {
                public final void run() {
                    bVar.d((String) map.get("demandSourceName"), s.this.a);
                }
            });
        }
    }

    public final void a(final c cVar, Map<String, String> map, final com.ironsource.sdk.j.a.c cVar2) {
        if (cVar2 != null) {
            a((Runnable) new Runnable() {
                public final void run() {
                    cVar2.b(cVar.b, s.this.a);
                }
            });
        }
    }

    public final void a(String str, String str2, c cVar, b bVar) {
        if (bVar != null) {
            bVar.a(d.e.a, cVar.b, this.a);
        }
    }

    public final void a(String str, String str2, final c cVar, final com.ironsource.sdk.j.a.c cVar2) {
        if (cVar2 != null) {
            a((Runnable) new Runnable() {
                public final void run() {
                    cVar2.a(d.e.c, cVar.b, s.this.a);
                }
            });
        }
    }

    public final void a(String str, String str2, final e eVar) {
        if (eVar != null) {
            a((Runnable) new Runnable() {
                public final void run() {
                    eVar.onGetOWCreditsFailed(s.this.a);
                }
            });
        }
    }

    public final void a(String str, String str2, Map<String, String> map, final e eVar) {
        if (eVar != null) {
            a((Runnable) new Runnable() {
                public final void run() {
                    eVar.onOfferwallInitFail(s.this.a);
                }
            });
        }
    }

    public final void a(Map<String, String> map, final e eVar) {
        if (eVar != null) {
            a((Runnable) new Runnable() {
                public final void run() {
                    eVar.onOWShowFail(s.this.a);
                    eVar.onOfferwallInitFail(s.this.a);
                }
            });
        }
    }

    public final void a(JSONObject jSONObject) {
    }

    public final void b(Context context) {
    }

    public final void b(final c cVar, Map<String, String> map, final com.ironsource.sdk.j.a.c cVar2) {
        if (cVar2 != null) {
            a((Runnable) new Runnable() {
                public final void run() {
                    cVar2.c(cVar.b, s.this.a);
                }
            });
        }
    }

    public final void b(JSONObject jSONObject) {
    }

    public final d.c c() {
        return d.c.Native;
    }

    public final void d() {
    }

    public final void destroy() {
    }

    public final void e() {
    }

    public final void f() {
    }

    public final void g() {
    }
}

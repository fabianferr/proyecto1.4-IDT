package com.bytedance.sdk.openadsdk.b;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.component.utils.h;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.b.c.e;
import com.bytedance.sdk.openadsdk.core.model.q;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: WebviewTimeTrack */
public class o implements e {
    /* access modifiers changed from: private */
    public String a = "embeded_ad";
    /* access modifiers changed from: private */
    public q b;
    private Boolean c = false;
    /* access modifiers changed from: private */
    public Boolean d = false;
    private Boolean e = false;
    /* access modifiers changed from: private */
    public JSONObject f;
    /* access modifiers changed from: private */
    public JSONArray g;
    /* access modifiers changed from: private */
    public JSONArray h;

    public o(int i, String str, q qVar) {
        this.a = str;
        this.b = qVar;
        this.f = new JSONObject();
        this.g = new JSONArray();
        this.h = new JSONArray();
        a(this.f, "webview_source", (Object) Integer.valueOf(i));
    }

    protected o() {
    }

    public void a() {
        h.a().post(new Runnable() {
            public void run() {
                long currentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                o.this.a(jSONObject, "ts", (Object) Long.valueOf(currentTimeMillis));
                o oVar = o.this;
                oVar.a(jSONObject, "render_sequence", (Object) Integer.valueOf(oVar.b.x()));
                o.this.a(jSONObject, "webview_count", (Object) Integer.valueOf(com.bytedance.sdk.component.adexpress.d.e.a().d()));
                o.this.a(jSONObject, "available_cache_count", (Object) Integer.valueOf(com.bytedance.sdk.component.adexpress.d.e.a().c()));
                o oVar2 = o.this;
                oVar2.a(oVar2.f, "render_start", (Object) jSONObject);
            }
        });
    }

    public void b() {
        h.a().post(new Runnable() {
            public void run() {
                long currentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                o.this.a(jSONObject, "ts", (Object) Long.valueOf(currentTimeMillis));
                o oVar = o.this;
                oVar.a(oVar.f, "render_success", (Object) jSONObject);
            }
        });
    }

    public void a(final int i, final String str) {
        h.a().post(new Runnable() {
            public void run() {
                long currentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                o.this.a(jSONObject, "ts", (Object) Long.valueOf(currentTimeMillis));
                o.this.a(jSONObject, "code", (Object) Integer.valueOf(i));
                String str = str;
                if (str != null) {
                    o.this.a(jSONObject, NotificationCompat.CATEGORY_MESSAGE, (Object) str);
                }
                o oVar = o.this;
                oVar.a(oVar.f, "render_error", (Object) jSONObject);
            }
        });
    }

    public void c() {
        h.a().post(new Runnable() {
            public void run() {
                long currentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                o.this.a(jSONObject, "ts", (Object) Long.valueOf(currentTimeMillis));
                o oVar = o.this;
                oVar.a(oVar.f, "native_render_start", (Object) jSONObject);
            }
        });
    }

    public void d() {
        h.a().post(new Runnable() {
            public void run() {
                long currentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                o.this.a(jSONObject, "ts", (Object) Long.valueOf(currentTimeMillis));
                o oVar = o.this;
                oVar.a(oVar.f, "native_render_end", (Object) jSONObject);
            }
        });
    }

    public void e() {
        h.a().post(new Runnable() {
            public void run() {
                long currentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                o.this.a(jSONObject, "ts", (Object) Long.valueOf(currentTimeMillis));
                o oVar = o.this;
                oVar.a(oVar.f, "webview_load_start", (Object) jSONObject, false);
            }
        });
    }

    public void f() {
        h.a().post(new Runnable() {
            public void run() {
                long currentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                o.this.a(jSONObject, "ts", (Object) Long.valueOf(currentTimeMillis));
                o oVar = o.this;
                oVar.a(oVar.f, "webview_load_success", (Object) jSONObject);
            }
        });
    }

    public void a(final JSONObject jSONObject) {
        h.a().post(new Runnable() {
            public void run() {
                JSONObject jSONObject = jSONObject;
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                o.this.a(jSONObject, "ts", (Object) Long.valueOf(System.currentTimeMillis()));
                o oVar = o.this;
                oVar.a(oVar.f, "webview_load_error", (Object) jSONObject);
            }
        });
    }

    public void g() {
        h.a().post(new Runnable() {
            public void run() {
                long currentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                o.this.a(jSONObject, "ts", (Object) Long.valueOf(currentTimeMillis));
                o oVar = o.this;
                oVar.a(oVar.f, "native_endcard_show", (Object) jSONObject);
            }
        });
    }

    public void h() {
        h.a().post(new Runnable() {
            public void run() {
                long currentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                o.this.a(jSONObject, "ts", (Object) Long.valueOf(currentTimeMillis));
                o oVar = o.this;
                oVar.a(oVar.f, "native_endcard_close", (Object) jSONObject);
            }
        });
    }

    public void i() {
        h.a().post(new Runnable() {
            public void run() {
                long currentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                o.this.a(jSONObject, "ts", (Object) Long.valueOf(currentTimeMillis));
                o.this.a(jSONObject, "type", (Object) "native_enterBackground");
                o oVar = o.this;
                oVar.a(oVar.g, (Object) jSONObject);
            }
        });
    }

    public void j() {
        h.a().post(new Runnable() {
            public void run() {
                long currentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                o.this.a(jSONObject, "ts", (Object) Long.valueOf(currentTimeMillis));
                o.this.a(jSONObject, "type", (Object) "native_enterForeground");
                o oVar = o.this;
                oVar.a(oVar.g, (Object) jSONObject);
            }
        });
    }

    public void a(String str, long j, long j2, int i) {
        final String str2 = str;
        final long j3 = j2;
        final long j4 = j;
        final int i2 = i;
        h.a().post(new Runnable() {
            public void run() {
                if (!TextUtils.isEmpty(str2) && j3 >= j4) {
                    JSONObject jSONObject = new JSONObject();
                    o.this.a(jSONObject, "start_ts", (Object) Long.valueOf(j4));
                    o.this.a(jSONObject, "end_ts", (Object) Long.valueOf(j3));
                    o.this.a(jSONObject, "intercept_type", (Object) Integer.valueOf(i2));
                    o.this.a(jSONObject, "type", (Object) "intercept_html");
                    o.this.a(jSONObject, "url", (Object) str2);
                    o.this.a(jSONObject, "duration", (Object) Long.valueOf(j3 - j4));
                    o oVar = o.this;
                    oVar.a(oVar.h, (Object) jSONObject);
                }
            }
        });
    }

    public void b(String str, long j, long j2, int i) {
        final String str2 = str;
        final long j3 = j2;
        final long j4 = j;
        final int i2 = i;
        h.a().post(new Runnable() {
            public void run() {
                if (!TextUtils.isEmpty(str2) && j3 >= j4) {
                    JSONObject jSONObject = new JSONObject();
                    o.this.a(jSONObject, "start_ts", (Object) Long.valueOf(j4));
                    o.this.a(jSONObject, "end_ts", (Object) Long.valueOf(j3));
                    o.this.a(jSONObject, "intercept_type", (Object) Integer.valueOf(i2));
                    o.this.a(jSONObject, "type", (Object) "intercept_js");
                    o.this.a(jSONObject, "url", (Object) str2);
                    o.this.a(jSONObject, "duration", (Object) Long.valueOf(j3 - j4));
                    o oVar = o.this;
                    oVar.a(oVar.h, (Object) jSONObject);
                }
            }
        });
    }

    public void a(final String str) {
        h.a().post(new Runnable() {
            public void run() {
                if (!TextUtils.isEmpty(str)) {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    o.this.a(jSONObject, "ts", (Object) Long.valueOf(currentTimeMillis));
                    o.this.a(jSONObject, "jsb", (Object) str);
                    o oVar = o.this;
                    oVar.a(oVar.f, "webview_jsb_start", (Object) jSONObject);
                }
            }
        });
    }

    public void b(final String str) {
        h.a().post(new Runnable() {
            public void run() {
                if (!TextUtils.isEmpty(str)) {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    o.this.a(jSONObject, "ts", (Object) Long.valueOf(currentTimeMillis));
                    o.this.a(jSONObject, "jsb", (Object) str);
                    o oVar = o.this;
                    oVar.a(oVar.f, "webview_jsb_end", (Object) jSONObject);
                }
            }
        });
    }

    public void b(final JSONObject jSONObject) {
        h.a().post(new Runnable() {
            public void run() {
                JSONObject jSONObject;
                if (o.this.f != null && (jSONObject = jSONObject) != null) {
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        o oVar = o.this;
                        oVar.a(oVar.f, next, jSONObject.opt(next));
                    }
                    Boolean unused = o.this.d = true;
                    o.this.l();
                }
            }
        });
    }

    public void k() {
        this.c = true;
    }

    public void a(boolean z) {
        this.e = Boolean.valueOf(z);
    }

    public void l() {
        h.a().post(new Runnable() {
            public void run() {
                if (o.this.p()) {
                    if (!(o.this.g == null || o.this.g.length() == 0)) {
                        try {
                            o.this.f.put("native_switchBackgroundAndForeground", o.this.g);
                        } catch (Exception unused) {
                        }
                    }
                    if (!(o.this.h == null || o.this.h.length() == 0)) {
                        try {
                            o.this.f.put("intercept_source", o.this.h);
                        } catch (Exception unused2) {
                        }
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("webview_time_track", o.this.f);
                    } catch (JSONException e) {
                        l.c("WebviewTimeTrack", "trySendTrackInfo json error", e);
                    }
                    if (com.bytedance.sdk.openadsdk.core.h.b().q() && o.this.f != null) {
                        l.b("WebviewTimeTrack", o.this.f.toString());
                    }
                    c.b(o.this.b, o.this.a, "webview_time_track", jSONObject);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public boolean p() {
        return this.e.booleanValue() || (this.d.booleanValue() && this.c.booleanValue());
    }

    /* access modifiers changed from: private */
    public void a(JSONObject jSONObject, String str, Object obj, boolean z) {
        if (jSONObject != null && !TextUtils.isEmpty(str)) {
            if (!z) {
                try {
                    if (jSONObject.has(str)) {
                        return;
                    }
                } catch (Exception unused) {
                    return;
                }
            }
            jSONObject.put(str, obj);
        }
    }

    /* access modifiers changed from: private */
    public void a(JSONObject jSONObject, String str, Object obj) {
        a(jSONObject, str, obj, true);
    }

    /* access modifiers changed from: private */
    public void a(JSONArray jSONArray, Object obj) {
        if (jSONArray != null && jSONArray.length() < 10) {
            try {
                jSONArray.put(obj);
            } catch (Exception unused) {
            }
        }
    }

    public void c(final String str) {
        h.a().post(new Runnable() {
            public void run() {
                long currentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                o.this.a(jSONObject, "ts", (Object) Long.valueOf(currentTimeMillis));
                o oVar = o.this;
                oVar.a(oVar.f, str, (Object) jSONObject);
            }
        });
    }

    public void b(final int i, final String str) {
        h.a().post(new Runnable() {
            public void run() {
                long currentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                o.this.a(jSONObject, "ts", (Object) Long.valueOf(currentTimeMillis));
                o.this.a(jSONObject, "code", (Object) Integer.valueOf(i));
                o oVar = o.this;
                oVar.a(oVar.f, str, (Object) jSONObject);
            }
        });
    }

    public void m() {
        h.a().post(new Runnable() {
            public void run() {
                long currentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                o.this.a(jSONObject, "ts", (Object) Long.valueOf(currentTimeMillis));
                o oVar = o.this;
                oVar.a(oVar.f, "native_render_end", (Object) jSONObject);
                long currentTimeMillis2 = System.currentTimeMillis();
                JSONObject jSONObject2 = new JSONObject();
                o.this.a(jSONObject2, "ts", (Object) Long.valueOf(currentTimeMillis2));
                o oVar2 = o.this;
                oVar2.a(oVar2.f, "render_success", (Object) jSONObject2);
            }
        });
    }

    public void n() {
        h.a().post(new Runnable() {
            public void run() {
                long currentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                o.this.a(jSONObject, "ts", (Object) Long.valueOf(currentTimeMillis));
                o oVar = o.this;
                oVar.a(oVar.f, "no_native_render", (Object) jSONObject);
            }
        });
    }

    public void o() {
        h.a().post(new Runnable() {
            public void run() {
                long currentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                o.this.a(jSONObject, "ts", (Object) Long.valueOf(currentTimeMillis));
                o oVar = o.this;
                oVar.a(oVar.f, "render_failed", (Object) jSONObject);
            }
        });
    }

    public void d(final String str) {
        h.a().post(new Runnable() {
            public void run() {
                long currentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                o.this.a(jSONObject, "ts", (Object) Long.valueOf(currentTimeMillis));
                o oVar = o.this;
                oVar.a(oVar.f, str, (Object) jSONObject);
            }
        });
    }

    public void e(final String str) {
        h.a().post(new Runnable() {
            public void run() {
                long currentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                o.this.a(jSONObject, "ts", (Object) Long.valueOf(currentTimeMillis));
                o oVar = o.this;
                oVar.a(oVar.f, str, (Object) jSONObject);
            }
        });
    }

    public void a(final int i) {
        h.a().post(new Runnable() {
            public void run() {
                long currentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                o.this.a(jSONObject, "ts", (Object) Long.valueOf(currentTimeMillis));
                o.this.a(jSONObject, "isWebViewCache", (Object) Integer.valueOf(i));
                o oVar = o.this;
                oVar.a(oVar.f, "before_webview_request", (Object) jSONObject);
            }
        });
    }
}

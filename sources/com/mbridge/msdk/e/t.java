package com.mbridge.msdk.e;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: ReportMonitor */
public class t {
    private static volatile t d;
    Handler a = new Handler(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 1) {
                try {
                    t.this.c();
                    t.this.a.removeMessages(1);
                    t.this.d();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    };
    private m b;
    private w c;
    private volatile boolean e = false;
    private int f = 30000;
    private final HashMap<String, String> g = new HashMap<>();

    private t() {
    }

    public final void a(Context context, w wVar, int i, JSONObject jSONObject) {
        this.c = wVar;
        this.f = i;
        m a2 = m.a("monitor", context, wVar);
        this.b = a2;
        if (a2 != null) {
            a2.a(jSONObject);
            this.b.a();
        }
        b();
    }

    public static t a() {
        if (d == null) {
            synchronized (t.class) {
                if (d == null) {
                    d = new t();
                }
            }
        }
        return d;
    }

    public final synchronized void b() {
        if (!this.e) {
            this.e = true;
            d();
        }
    }

    /* access modifiers changed from: private */
    public void d() {
        try {
            this.a.sendEmptyMessageDelayed(1, (long) this.f);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void c() {
        m[] d2 = m.d();
        if (d2.length != 0) {
            try {
                for (m mVar : d2) {
                    String c2 = mVar.c();
                    if (!"monitor".equals(c2)) {
                        String b2 = mVar.b();
                        long[] f2 = mVar.f();
                        long j = f2[1];
                        if (j != 0) {
                            long j2 = f2[0];
                            if (this.g.containsKey(c2)) {
                                if ((j2 + "").equals(this.g.get(c2))) {
                                }
                            }
                            this.g.put(c2, j2 + "");
                            if (this.b != null) {
                                try {
                                    e eVar = new e("event_lib_monitor");
                                    eVar.b(1);
                                    JSONObject jSONObject = new JSONObject();
                                    jSONObject.put("key", "m_report_rate");
                                    jSONObject.put("task_name", c2);
                                    jSONObject.put("task_count", j);
                                    jSONObject.put("task_session_id", b2);
                                    jSONObject.put("task_ts", j2);
                                    eVar.a(jSONObject);
                                    this.b.a(eVar);
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                }
                            }
                        }
                    }
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }
}

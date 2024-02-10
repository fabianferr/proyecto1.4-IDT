package com.mbridge.msdk.click.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.mbridge.msdk.c.e;
import com.mbridge.msdk.c.f;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.db.h;
import com.mbridge.msdk.foundation.db.n;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.l;
import com.mbridge.msdk.foundation.same.net.g.d;
import com.mbridge.msdk.foundation.same.report.k;
import com.mbridge.msdk.foundation.same.report.m;
import com.mbridge.msdk.foundation.same.report.q;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.ac;
import com.mbridge.msdk.foundation.tools.al;
import java.net.URLEncoder;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: RetryReportControl */
public final class a {
    public static String a = "mtg_retry_report=1";
    public static int b = 10000;
    public static int c = 3;
    public static int d = 50;
    public static int e = 600000;
    public static int f = 0;
    public static int g = 1;
    public static int h = 2;
    public static int i = 3;
    public static int j = 4;
    public static int k = 5;
    /* access modifiers changed from: private */
    public static String l = "RetryReportControl";
    private static int o;
    private static int p;
    private ConcurrentHashMap<String, b> m;
    private c n;
    private BroadcastReceiver q;
    /* access modifiers changed from: private */
    public final Handler r;

    /* renamed from: com.mbridge.msdk.click.a.a$a  reason: collision with other inner class name */
    /* compiled from: RetryReportControl */
    private static class C0129a {
        /* access modifiers changed from: private */
        public static a a = new a();
    }

    private a() {
        this.m = new ConcurrentHashMap<>();
        this.n = new c(d);
        this.r = new b(Looper.getMainLooper());
        e g2 = f.a().g(com.mbridge.msdk.foundation.controller.b.d().h());
        c = g2.s();
        b = g2.u() * 1000;
        e = g2.t() * 1000;
        o = g2.r();
        p = g2.q();
        try {
            if (this.q == null) {
                this.q = new BroadcastReceiver() {
                    public final void onReceive(Context context, Intent intent) {
                        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                            a.this.r.sendEmptyMessage(2);
                        }
                    }
                };
                Context g3 = com.mbridge.msdk.foundation.controller.b.d().g();
                if (g3 != null) {
                    g3.registerReceiver(this.q, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static a a() {
        return C0129a.a;
    }

    /* compiled from: RetryReportControl */
    private static class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                Object obj = message.obj;
                if (obj instanceof String) {
                    a.a().a((String) obj, b.a);
                }
            } else if (i == 2) {
                a.a(a.a());
            }
        }
    }

    private void a(b bVar) {
        String str;
        String str2;
        try {
            CampaignEx f2 = bVar.f();
            if (f2 != null) {
                String requestId = f2.getRequestId();
                str = f2.getRequestIdNotice();
                str2 = requestId;
            } else {
                str2 = "";
                str = str2;
            }
            a(com.mbridge.msdk.foundation.controller.b.d().g(), bVar.i().toString(), bVar.g(), str2, str, bVar.d());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private static void a(Context context, String str, String str2, String str3, String str4, int i2) {
        Context context2 = context;
        boolean z = false;
        if (ac.a().a("metrics", "e_t_l", ac.a().a("e_t_l", 0)) == 1) {
            z = true;
        }
        if (z) {
            m.a().a(context, str, str2, str3, str4, i2);
        } else if (context2 != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    StringBuffer stringBuffer = new StringBuffer("key=2000105&");
                    stringBuffer.append("url=" + URLEncoder.encode(str2, "utf-8") + "&");
                    stringBuffer.append("type=" + i2 + "&");
                    if (!TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.l)) {
                        stringBuffer.append("b=" + com.mbridge.msdk.foundation.same.a.l + "&");
                    }
                    if (!TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.m)) {
                        stringBuffer.append("c=" + com.mbridge.msdk.foundation.same.a.m + "&");
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        stringBuffer.append("rid=").append(str3).append("&");
                    } else {
                        String str5 = str3;
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        stringBuffer.append("rid_n=").append(str4).append("&");
                    }
                    StringBuilder sb = new StringBuilder("reason=");
                    String str6 = str;
                    sb.append(URLEncoder.encode(str, "utf-8"));
                    stringBuffer.append(sb.toString());
                    if (k.a().c()) {
                        k.a().a(stringBuffer.toString());
                    } else {
                        a(context, stringBuffer.toString());
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private static void a(final Context context, final String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                new com.mbridge.msdk.foundation.same.report.d.a(context).post(0, d.a().a, q.a(str, context), new com.mbridge.msdk.foundation.same.report.d.b() {
                    public final void onSuccess(String str) {
                        aa.d(a.l, str);
                    }

                    public final void onFailed(String str) {
                        l lVar = new l();
                        lVar.c(str);
                        lVar.a(System.currentTimeMillis());
                        lVar.a(0);
                        lVar.b("POST");
                        lVar.a(d.a().a);
                        n.a((g) h.a(context)).a(lVar);
                    }
                });
            } catch (Exception e2) {
                e2.printStackTrace();
                aa.d(l, e2.getMessage());
            }
        }
    }

    private void a(String str) {
        Message obtainMessage = this.r.obtainMessage();
        obtainMessage.what = 1;
        obtainMessage.obj = str;
        this.r.sendMessageDelayed(obtainMessage, (long) b);
    }

    /* access modifiers changed from: private */
    public void a(String str, int i2) {
        String str2;
        c cVar = this.n;
        if (cVar != null) {
            b a2 = cVar.b(str);
            this.n.a(str);
            if (a2 == null) {
                b bVar = this.m.get(str);
                if (bVar != null && System.currentTimeMillis() <= bVar.j() + ((long) e) && bVar.h() < c && i2 != b.b) {
                    a(str);
                }
            } else if (System.currentTimeMillis() <= a2.j() + ((long) e)) {
                a2.a(i2);
                this.m.put(str, a2);
                if (al.c(str) == 0) {
                    str2 = str + "?" + a;
                } else {
                    str2 = str + "&" + a;
                }
                com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.controller.b.d().g(), a2.f(), a2.e(), str2, a2.a(), a2.b(), a2.d());
            } else if (i2 != b.b) {
                a(a2);
            }
        }
    }

    private boolean a(int i2) {
        return i2 == j || i2 == i;
    }

    private boolean b(int i2) {
        return i2 == g || i2 == h;
    }

    public final void a(String str, String str2, CampaignEx campaignEx, String str3, boolean z, boolean z2, int i2) {
        boolean z3 = false;
        if ((a(i2) || b(i2) || i2 == k) && !TextUtils.isEmpty(str)) {
            String replace = str.replace("?" + a, "");
            String replace2 = replace.replace("&" + a, "");
            if (this.m == null) {
                this.m = new ConcurrentHashMap<>();
            }
            b remove = this.m.remove(replace2);
            if (remove == null) {
                remove = new b(str, str2);
                remove.b(i2);
                remove.a(z);
                remove.b(z2);
                remove.a(campaignEx);
                remove.a(str3);
            } else if (remove.c() != b.b) {
                remove.b(str2);
            }
            if ((a(i2) && o != 0) || ((b(i2) && p != 0) || i2 == k)) {
                z3 = true;
            }
            if (!z3) {
                a(remove);
            } else if (System.currentTimeMillis() < remove.j() + ((long) e)) {
                if (this.n == null) {
                    this.n = new c(d);
                }
                this.n.a(replace2, remove);
                if (remove.c() != b.a) {
                    return;
                }
                if (remove.h() <= c) {
                    a(replace2);
                } else {
                    a(remove);
                }
            } else if (remove.c() == b.a) {
                a(remove);
            }
        }
    }

    static /* synthetic */ void a(a aVar) {
        c cVar = aVar.n;
        if (cVar != null) {
            for (String a2 : cVar.a()) {
                aVar.a(a2, b.b);
            }
        }
    }
}

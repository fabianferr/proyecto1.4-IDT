package com.mbridge.msdk.foundation.same.report;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.e;
import com.mbridge.msdk.c.f;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.db.h;
import com.mbridge.msdk.foundation.db.n;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.entity.l;
import com.mbridge.msdk.foundation.same.net.g.d;
import com.mbridge.msdk.foundation.same.report.d.a;
import com.mbridge.msdk.foundation.same.report.d.b;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.w;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.out.Frame;
import java.io.File;
import java.net.URLEncoder;

/* compiled from: ReportController */
public class p {
    public static final String a = "p";
    /* access modifiers changed from: private */
    public final Context b;
    private int c;

    public p(Context context, int i) {
        this.b = context;
        this.c = i;
    }

    public p(Context context) {
        this.c = 0;
        this.b = context.getApplicationContext();
    }

    public final void a(int i, String str) {
        new a(this.b).post(0, d.a().a, q.a("event", q.a((Campaign) null, i, "request"), this.b, str), new b() {
            public final void onFailed(String str) {
            }

            public final void onSuccess(String str) {
            }
        });
    }

    public final void a(final l lVar, final Boolean bool) {
        if (lVar == null) {
            return;
        }
        if (lVar.c().equals("GET")) {
            new a(this.b).get(0, lVar.b(), (com.mbridge.msdk.foundation.same.net.h.d) null, new b() {
                public final void onFailed(String str) {
                }

                public final void onSuccess(String str) {
                    com.mbridge.msdk.foundation.same.f.b.b().execute(new Runnable() {
                        public final void run() {
                            try {
                                if (p.this.b == null) {
                                    return;
                                }
                                if (lVar != null) {
                                    n.a((g) h.a(p.this.b)).a(lVar.b());
                                    if (bool.booleanValue() && n.a((g) h.a(p.this.b)).b() > 20) {
                                        c.a().c();
                                    }
                                }
                            } catch (Exception e) {
                                if (MBridgeConstans.DEBUG) {
                                    aa.b(p.a, "reportNetError", e);
                                }
                            }
                        }
                    });
                }
            });
        } else if (lVar.c().equals("POST")) {
            a aVar = new a(this.b);
            if (!TextUtils.isEmpty(lVar.d())) {
                com.mbridge.msdk.foundation.same.net.h.d a2 = q.a(lVar.d(), this.b, lVar.a());
                if (lVar.e() > 0) {
                    a2.a("retry", lVar.e() + "");
                }
                aVar.post(0, lVar.b(), a2, new b() {
                    public final void onSuccess(String str) {
                        com.mbridge.msdk.foundation.same.f.b.b().execute(new Runnable() {
                            public final void run() {
                                if (p.this.b != null && lVar != null) {
                                    try {
                                        n.a((g) h.a(p.this.b)).a(lVar.d(), lVar.b(), lVar.f());
                                        if (bool.booleanValue() && n.a((g) h.a(p.this.b)).a() > 0) {
                                            c.a().c();
                                        }
                                    } catch (Exception e) {
                                        if (MBridgeConstans.DEBUG) {
                                            aa.b(p.a, "reportNetError", e);
                                        }
                                    }
                                }
                            }
                        });
                    }

                    public final void onFailed(String str) {
                        com.mbridge.msdk.foundation.same.f.b.b().execute(new Runnable() {
                            public final void run() {
                                if (p.this.b != null && lVar != null) {
                                    n.a((g) h.a(p.this.b)).a(lVar);
                                }
                            }
                        });
                    }
                });
            }
        }
    }

    public final void a(String str, String str2, String str3) {
        try {
            a aVar = new a(this.b);
            String str4 = "click_type=" + URLEncoder.encode("1", "utf-8") + "&cid=" + URLEncoder.encode(str, "utf-8") + "&unit_id=" + URLEncoder.encode(str2, "utf-8") + "&key=" + URLEncoder.encode("2000027", "utf-8") + "&http_url=" + URLEncoder.encode(str3, "utf-8");
            if (k.a().c()) {
                k.a().a(str4);
                return;
            }
            aVar.post(0, d.a().a, q.a(str4, this.b, str2), new b() {
                public final void onFailed(String str) {
                }

                public final void onSuccess(String str) {
                }
            });
        } catch (Exception e) {
            aa.d(a, e.getMessage());
        }
    }

    public final void a(String str, final File file) {
        new a(this.b).post(0, d.a().a, q.a(this.b, str), new b() {
            public final void onFailed(String str) {
            }

            public final void onSuccess(String str) {
                File file = file;
                if (file != null) {
                    file.delete();
                }
            }
        });
    }

    public final void a(final String str, String str2, String str3, Frame frame) {
        a aVar = new a(this.b);
        com.mbridge.msdk.foundation.same.net.h.d a2 = q.a(str2, this.b, str3);
        if (frame != null) {
            a2.a("session_id", frame.getSessionId());
            a2.a(CampaignUnit.JSON_KEY_PARENT_SESSION_ID, frame.getParentSessionId());
        }
        aVar.post(0, d.a().a, a2, new b() {
            public final void onFailed(String str) {
            }

            public final void onSuccess(String str) {
                if ("click_duration".equals(str) || "load_duration".equals(str)) {
                    com.mbridge.msdk.foundation.same.f.b.b().execute(new Runnable() {
                        public final void run() {
                            c.a().c();
                        }
                    });
                }
            }
        });
    }

    public final void a(String str, com.mbridge.msdk.foundation.entity.d dVar, String str2) {
        a aVar = new a(this.b);
        String a2 = com.mbridge.msdk.foundation.entity.d.a(dVar);
        if (!TextUtils.isEmpty(a2)) {
            if (k.a().c()) {
                k.a().a(a2);
                return;
            }
            aVar.post(0, d.a().a, q.a(a2, this.b, str2), new b() {
                public final void onFailed(String str) {
                }

                public final void onSuccess(String str) {
                }
            });
        }
    }

    public final void a() {
        try {
            if (q.a()) {
                a aVar = new a(this.b);
                String h = com.mbridge.msdk.foundation.controller.b.d().h();
                e b2 = f.a().b(h);
                if (b2 == null) {
                    b2 = f.a().b();
                }
                int L = b2.L();
                String str = "key=2000053&Appid=" + h + "&uptips2=" + b2.K() + "&info_status=" + com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().c() + "&iseu=" + L;
                String a2 = w.a();
                if (!TextUtils.isEmpty(a2)) {
                    str = str + "&gaid=" + a2;
                }
                String str2 = str + "&GDPR_area=" + b2.aB() + "&GDPR_consent=" + com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().f();
                if (k.a().c()) {
                    k.a().a(str2);
                    return;
                }
                aVar.post(0, d.a().a, q.a(str2, this.b, ""), new b() {
                    public final void onFailed(String str) {
                    }

                    public final void onSuccess(String str) {
                    }
                });
                q.b();
            }
        } catch (Throwable th) {
            aa.d(a, th.getMessage());
        }
    }

    public final void a(int i, int i2, String str, String str2, String str3) {
        try {
            a aVar = new a(this.b);
            StringBuilder sb = new StringBuilder("key=");
            sb.append(URLEncoder.encode("2000058", "utf-8"));
            sb.append("&appid=");
            sb.append(URLEncoder.encode(com.mbridge.msdk.foundation.controller.b.d().h(), "utf-8"));
            sb.append("&dl_type=");
            sb.append(URLEncoder.encode(i + "", "utf-8"));
            sb.append("&dl_link_type=");
            sb.append(URLEncoder.encode(i2 + "", "utf-8"));
            sb.append("&rid=");
            sb.append(URLEncoder.encode(str, "utf-8"));
            sb.append("&rid_n=");
            sb.append(URLEncoder.encode(str2, "utf-8"));
            sb.append("&cid=");
            sb.append(URLEncoder.encode(str3, "utf-8"));
            sb.append("&tgt_v=");
            sb.append(URLEncoder.encode(w.k(this.b) + "", "utf-8"));
            sb.append("&app_v_n=");
            sb.append(URLEncoder.encode(w.j(this.b) + "", "utf-8"));
            sb.append("&app_v_c=");
            sb.append(URLEncoder.encode(w.i(this.b) + "", "utf-8"));
            if (k.a().c()) {
                k.a().a(sb.toString());
                return;
            }
            aVar.post(0, d.a().a, q.a(sb.toString(), this.b, ""), new b() {
                public final void onFailed(String str) {
                }

                public final void onSuccess(String str) {
                }
            });
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public final void a(String str, String str2, String str3, String str4, String str5, boolean z) {
        String str6 = str4;
        try {
            if (!TextUtils.isEmpty(str5)) {
                a aVar = new a(this.b);
                StringBuilder sb = new StringBuilder();
                if (z) {
                    sb.append("hb=1&");
                }
                sb.append("key=");
                sb.append(URLEncoder.encode("2000066", "utf-8"));
                sb.append("&rid=");
                String str7 = str;
                sb.append(URLEncoder.encode(str, "utf-8"));
                sb.append("&rid_n=");
                String str8 = str2;
                sb.append(URLEncoder.encode(str2, "utf-8"));
                sb.append("&cid=");
                String str9 = str3;
                sb.append(URLEncoder.encode(str3, "utf-8"));
                sb.append("&unit_id=");
                sb.append(URLEncoder.encode(str6, "utf-8"));
                sb.append("&err_method=");
                sb.append(str5);
                if (k.a().c()) {
                    k.a().a(sb.toString());
                    return;
                }
                aVar.post(0, d.a().a, q.a(sb.toString(), this.b, str6), new b() {
                    public final void onFailed(String str) {
                    }

                    public final void onSuccess(String str) {
                    }
                });
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public final void b(String str, String str2, String str3, String str4, String str5, boolean z) {
        String str6 = str4;
        try {
            a aVar = new a(this.b);
            StringBuilder sb = new StringBuilder();
            if (z) {
                sb.append("hb=1&");
            }
            sb.append("key=");
            sb.append(URLEncoder.encode("2000065", "utf-8"));
            sb.append("&rid=");
            String str7 = str;
            sb.append(URLEncoder.encode(str, "utf-8"));
            sb.append("&rid_n=");
            String str8 = str2;
            sb.append(URLEncoder.encode(str2, "utf-8"));
            sb.append("&cid=");
            String str9 = str3;
            sb.append(URLEncoder.encode(str3, "utf-8"));
            sb.append("&unit_id=");
            sb.append(URLEncoder.encode(str6, "utf-8"));
            sb.append("&click_url=");
            sb.append(URLEncoder.encode(str5, "utf-8"));
            if (k.a().c()) {
                k.a().a(sb.toString());
                return;
            }
            aVar.post(0, d.a().a, q.a(sb.toString(), this.b, str6), new b() {
                public final void onFailed(String str) {
                }

                public final void onSuccess(String str) {
                }
            });
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public final void a(String str, String str2, String str3, String str4, String str5) {
        String str6 = str4;
        try {
            a aVar = new a(this.b);
            StringBuilder sb = new StringBuilder("key=");
            int r = w.r(this.b);
            sb.append(URLEncoder.encode("2000071", "utf-8"));
            sb.append("&rid=");
            String str7 = str;
            sb.append(URLEncoder.encode(str, "utf-8"));
            sb.append("&rid_n=");
            sb.append(URLEncoder.encode(str2, "utf-8"));
            sb.append("&cid=");
            sb.append(URLEncoder.encode(str3, "utf-8"));
            sb.append("&unit_id=");
            sb.append(URLEncoder.encode(str6, "utf-8"));
            sb.append("&reason=");
            sb.append(URLEncoder.encode(str5, "utf-8"));
            sb.append("&network_type=");
            sb.append(URLEncoder.encode(r + "", "utf-8"));
            sb.append("&result=");
            sb.append(URLEncoder.encode("0", "utf-8"));
            if (k.a().c()) {
                k.a().a(sb.toString());
                return;
            }
            aVar.post(0, d.a().a, q.a(sb.toString(), this.b, str6), new b() {
                public final void onFailed(String str) {
                }

                public final void onSuccess(String str) {
                }
            });
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public final void a(int i, int i2, int i3, String str, String str2) {
        try {
            a aVar = new a(this.b);
            StringBuilder sb = new StringBuilder("key=2000112&st_net=");
            sb.append(i2);
            sb.append("&result=");
            sb.append(i);
            sb.append("&type=");
            sb.append(i3);
            sb.append("&url=");
            sb.append(str2);
            sb.append("&reason=");
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            sb.append(str);
            if (k.a().c()) {
                k.a().a(sb.toString());
                return;
            }
            aVar.post(0, d.a().a, q.a(sb.toString(), this.b, ""), new b() {
                public final void onSuccess(String str) {
                    aa.a("", "reportSettingLoadFailed onSuccess");
                }

                public final void onFailed(String str) {
                    aa.a("", "reportSettingLoadFailed onFailed:" + str);
                }
            });
        } catch (Throwable unused) {
            aa.d(a, "reportSettingLoadFailed onFailed");
        }
    }
}

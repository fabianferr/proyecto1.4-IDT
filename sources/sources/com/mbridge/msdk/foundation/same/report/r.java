package com.mbridge.msdk.foundation.same.report;

import android.text.TextUtils;
import com.facebook.share.internal.ShareConstants;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.b;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.s;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.ac;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: RewardVideoReportManager */
public final class r {
    private static AtomicBoolean c;
    private final Executor a;
    private Boolean b;

    /* compiled from: RewardVideoReportManager */
    private static final class a {
        /* access modifiers changed from: private */
        public static final r a = new r();
    }

    private r() {
        this.a = Executors.newSingleThreadExecutor();
    }

    public static r a() {
        return a.a;
    }

    private boolean b() {
        if (this.b == null) {
            try {
                this.b = Boolean.valueOf(ac.a().a("r_v_r_i_a", false));
            } catch (Throwable th) {
                if (MBridgeConstans.DEBUG) {
                    aa.d("RewardVideoReportManager", th.getMessage());
                }
                this.b = false;
            }
        }
        if (this.b == null) {
            this.b = false;
        }
        return this.b.booleanValue();
    }

    public final void a(String str, String str2, boolean z) {
        if (b() && !TextUtils.isEmpty(str) && this.a != null) {
            this.a.execute(c("load", "", str2, z, str));
        }
    }

    public final void b(String str, String str2, boolean z) {
        if (b() && !TextUtils.isEmpty(str) && this.a != null) {
            this.a.execute(c("campaign_success", "", str2, z, str));
        }
    }

    public final void c(String str, String str2, boolean z) {
        if (b() && !TextUtils.isEmpty(str) && this.a != null) {
            this.a.execute(c("load_success", "", str2, z, str));
        }
    }

    public final void d(String str, String str2, boolean z) {
        if (b() && !TextUtils.isEmpty(str) && this.a != null) {
            this.a.execute(c("is_ready_true", "", str2, z, str));
        }
    }

    public final void e(String str, String str2, boolean z) {
        if (b() && !TextUtils.isEmpty(str) && this.a != null) {
            this.a.execute(c("is_ready_false", "", str2, z, str));
        }
    }

    public final void a(String str, String str2, String str3, boolean z) {
        if (b() && !TextUtils.isEmpty(str) && this.a != null) {
            this.a.execute(c("load_failed", str2, str3, z, str));
        }
    }

    public final void f(String str, String str2, boolean z) {
        if (b() && !TextUtils.isEmpty(str) && this.a != null) {
            this.a.execute(c("show", "", str2, z, str));
        }
    }

    public final void g(String str, String str2, boolean z) {
        if (b() && !TextUtils.isEmpty(str) && this.a != null) {
            this.a.execute(c("show_success", "", str2, z, str));
        }
    }

    public final void b(String str, String str2, String str3, boolean z) {
        if (b() && !TextUtils.isEmpty(str) && this.a != null) {
            this.a.execute(c("show_failed", str2, str3, z, str));
        }
    }

    /* access modifiers changed from: private */
    public static s b(String str, String str2, String str3, boolean z, String str4) {
        try {
            if (c == null) {
                boolean z2 = false;
                if (ac.a().a("c_r_a_l_c", 0) == 0) {
                    z2 = true;
                }
                c = new AtomicBoolean(z2);
            }
            s.a a2 = new s.a("2000119").a("event", str);
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            String str5 = "1";
            s.a a3 = a2.a(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, str2).a("background", c.get() ? b.d().e() >= 1 ? str5 : "0" : "-1");
            if (TextUtils.isEmpty(str3)) {
                str3 = "";
            }
            s.a a4 = a3.a("ad_type", str3);
            if (!z) {
                str5 = "0";
            }
            s.a a5 = a4.a(CampaignEx.JSON_KEY_HB, str5);
            if (TextUtils.isEmpty(str4)) {
                str4 = "";
            }
            return a5.a(MBridgeConstans.PROPERTIES_UNIT_ID, str4).a();
        } catch (Throwable th) {
            if (MBridgeConstans.DEBUG) {
                aa.d("RewardVideoReportManager", th.getMessage());
            }
            return null;
        }
    }

    private Runnable c(String str, String str2, String str3, boolean z, String str4) {
        final String str5 = str;
        final String str6 = str2;
        final String str7 = str3;
        final boolean z2 = z;
        final String str8 = str4;
        return new Runnable() {
            public final void run() {
                s a2 = r.b(str5, str6, str7, z2, str8);
                if (a2 != null) {
                    try {
                        a2.a(str8);
                    } catch (Throwable th) {
                        if (MBridgeConstans.DEBUG) {
                            aa.d("RewardVideoReportManager", th.getMessage());
                        }
                    }
                }
            }
        };
    }

    public static void a(String str, String str2, String str3, String str4, int i) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put(CampaignEx.JSON_KEY_HB, "0");
            m a2 = m.a();
            a2.a(str, str3, str4, str2, i + "", (Map<String, String>) hashMap);
        } catch (Exception e) {
            aa.d("RewardVideoReportManager", e.getMessage());
        }
    }

    public static void a(String str, String str2, String str3, String str4, String str5, int i) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("bid_tk", str);
            hashMap.put(CampaignEx.JSON_KEY_HB, "1");
            m a2 = m.a();
            a2.a(str2, str4, str5, str3, i + "", (Map<String, String>) hashMap);
        } catch (Exception e) {
            aa.d("RewardVideoReportManager", e.getMessage());
        }
    }
}

package com.mbridge.msdk.foundation.same.report;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.same.net.h.d;
import com.mbridge.msdk.foundation.tools.aa;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/* compiled from: SameCommonReporter */
public final class s {
    private final String a;
    private final Map<String, String> b;

    private s(a aVar) {
        this.a = aVar.a;
        this.b = aVar.b;
    }

    public final void a(String str) {
        String str2;
        if (!TextUtils.isEmpty(this.a)) {
            StringBuilder sb = new StringBuilder("key=");
            sb.append(this.a);
            d dVar = null;
            try {
                str2 = a(this.b);
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    aa.d("SameCommonReporter", e.getMessage());
                }
                str2 = null;
            }
            if (!TextUtils.isEmpty(str2)) {
                sb.append(str2);
            }
            if (k.a().c()) {
                k.a().a(sb.toString());
                return;
            }
            try {
                dVar = q.a(sb.toString(), com.mbridge.msdk.foundation.controller.b.d().g(), str);
            } catch (Exception e2) {
                if (MBridgeConstans.DEBUG) {
                    aa.d("SameCommonReporter", e2.getMessage());
                }
            }
            if (dVar != null && dVar != null) {
                try {
                    new com.mbridge.msdk.foundation.same.report.d.a(com.mbridge.msdk.foundation.controller.b.d().g()).post(0, com.mbridge.msdk.foundation.same.net.g.d.a().a, dVar, new b());
                } catch (Exception e3) {
                    if (MBridgeConstans.DEBUG) {
                        aa.d("SameCommonReporter", e3.getMessage());
                    }
                }
            }
        }
    }

    private String a(Map<String, String> map) {
        if (!(map == null || map.size() == 0)) {
            StringBuilder sb = new StringBuilder();
            try {
                for (String next : map.keySet()) {
                    if (!TextUtils.isEmpty(next)) {
                        String str = map.get(next);
                        if (!TextUtils.isEmpty(str)) {
                            try {
                                str = URLEncoder.encode(str, "utf-8");
                            } catch (Exception e) {
                                if (MBridgeConstans.DEBUG) {
                                    aa.d("SameCommonReporter", e.getMessage());
                                }
                            }
                            sb.append("&");
                            sb.append(next);
                            sb.append("=");
                            sb.append(str);
                        }
                    }
                }
            } catch (Exception e2) {
                if (MBridgeConstans.DEBUG) {
                    aa.d("SameCommonReporter", e2.getMessage());
                }
                sb = null;
            }
            if (sb != null && sb.length() > 0) {
                return sb.toString();
            }
        }
        return null;
    }

    /* compiled from: SameCommonReporter */
    public static class a {
        /* access modifiers changed from: private */
        public final String a;
        /* access modifiers changed from: private */
        public final Map<String, String> b = new HashMap();

        public a(String str) {
            this.a = str;
        }

        public final a a(String str, String str2) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    this.b.put(str, str2);
                } catch (Exception e) {
                    if (MBridgeConstans.DEBUG) {
                        aa.d("SameCommonReporter", e.getMessage());
                    }
                }
            }
            return this;
        }

        public final s a() {
            return new s(this);
        }
    }

    /* compiled from: SameCommonReporter */
    private static final class b extends com.mbridge.msdk.foundation.same.report.d.b {
        public final void onSuccess(String str) {
            if (MBridgeConstans.DEBUG) {
                aa.a("SameCommonReporter", "report success for： " + str);
            }
        }

        public final void onFailed(String str) {
            if (MBridgeConstans.DEBUG) {
                aa.a("SameCommonReporter", "report failed for： " + str);
            }
        }
    }
}

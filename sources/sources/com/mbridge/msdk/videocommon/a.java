package com.mbridge.msdk.videocommon;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: TemplateWebviewCache */
public final class a {
    private static ConcurrentHashMap<String, C0158a> a = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, C0158a> b = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, C0158a> c = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, C0158a> d = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, C0158a> e = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, C0158a> f = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, C0158a> g = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, C0158a> h = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, C0158a> i = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, C0158a> j = new ConcurrentHashMap<>();

    /* renamed from: com.mbridge.msdk.videocommon.a$a  reason: collision with other inner class name */
    /* compiled from: TemplateWebviewCache */
    public static class C0158a {
        private WindVaneWebView a;
        private boolean b;

        public final WindVaneWebView a() {
            return this.a;
        }

        public final void a(WindVaneWebView windVaneWebView) {
            this.a = windVaneWebView;
        }

        public final void a(String str) {
            WindVaneWebView windVaneWebView = this.a;
            if (windVaneWebView != null) {
                windVaneWebView.setTag(str);
            }
        }

        public final String b() {
            WindVaneWebView windVaneWebView = this.a;
            return windVaneWebView != null ? (String) windVaneWebView.getTag() : "";
        }

        public final boolean c() {
            return this.b;
        }

        public final void a(boolean z) {
            this.b = z;
        }
    }

    public static C0158a a(String str) {
        if (g.containsKey(str)) {
            return g.get(str);
        }
        if (h.containsKey(str)) {
            return h.get(str);
        }
        if (i.containsKey(str)) {
            return i.get(str);
        }
        if (j.containsKey(str)) {
            return j.get(str);
        }
        return null;
    }

    public static void a(String str, C0158a aVar, boolean z, boolean z2) {
        if (z) {
            if (z2) {
                h.put(str, aVar);
            } else {
                g.put(str, aVar);
            }
        } else if (z2) {
            j.put(str, aVar);
        } else {
            i.put(str, aVar);
        }
    }

    public static void b(String str) {
        if (g.containsKey(str)) {
            g.remove(str);
        }
        if (i.containsKey(str)) {
            i.remove(str);
        }
        if (h.containsKey(str)) {
            h.remove(str);
        }
        if (j.containsKey(str)) {
            j.remove(str);
        }
    }

    public static void c(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (String next : g.keySet()) {
                if (!TextUtils.isEmpty(next) && next.startsWith(str)) {
                    g.remove(next);
                }
            }
        } else {
            g.clear();
        }
        h.clear();
    }

    public static void a() {
        i.clear();
        j.clear();
    }

    public static void d(String str) {
        for (Map.Entry next : g.entrySet()) {
            if (((String) next.getKey()).contains(str)) {
                g.remove(next.getKey());
            }
        }
    }

    public static void e(String str) {
        for (Map.Entry next : h.entrySet()) {
            if (((String) next.getKey()).contains(str)) {
                h.remove(next.getKey());
            }
        }
    }

    public static C0158a a(int i2, CampaignEx campaignEx) {
        if (campaignEx == null) {
            return null;
        }
        try {
            String requestIdNotice = campaignEx.getRequestIdNotice();
            if (i2 == 288) {
                requestIdNotice = campaignEx.getKeyIaUrl();
            }
            if (i2 != 94) {
                if (i2 != 287) {
                    if (i2 != 288) {
                        ConcurrentHashMap<String, C0158a> concurrentHashMap = a;
                        if (concurrentHashMap != null && concurrentHashMap.size() > 0) {
                            return a.get(requestIdNotice);
                        }
                    } else {
                        ConcurrentHashMap<String, C0158a> concurrentHashMap2 = d;
                        if (concurrentHashMap2 != null && concurrentHashMap2.size() > 0) {
                            return d.get(requestIdNotice);
                        }
                    }
                } else if (campaignEx.isBidCampaign()) {
                    ConcurrentHashMap<String, C0158a> concurrentHashMap3 = c;
                    if (concurrentHashMap3 != null && concurrentHashMap3.size() > 0) {
                        return c.get(requestIdNotice);
                    }
                } else {
                    ConcurrentHashMap<String, C0158a> concurrentHashMap4 = f;
                    if (concurrentHashMap4 != null && concurrentHashMap4.size() > 0) {
                        return f.get(requestIdNotice);
                    }
                }
            } else if (campaignEx.isBidCampaign()) {
                ConcurrentHashMap<String, C0158a> concurrentHashMap5 = b;
                if (concurrentHashMap5 != null && concurrentHashMap5.size() > 0) {
                    return b.get(requestIdNotice);
                }
            } else {
                ConcurrentHashMap<String, C0158a> concurrentHashMap6 = e;
                if (concurrentHashMap6 != null && concurrentHashMap6.size() > 0) {
                    return e.get(requestIdNotice);
                }
            }
        } catch (Exception e2) {
            if (MBridgeConstans.DEBUG) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    public static void b(int i2, CampaignEx campaignEx) {
        if (campaignEx != null) {
            try {
                String requestIdNotice = campaignEx.getRequestIdNotice();
                if (i2 == 288) {
                    requestIdNotice = campaignEx.getKeyIaUrl();
                }
                if (i2 != 94) {
                    if (i2 != 287) {
                        if (i2 != 288) {
                            ConcurrentHashMap<String, C0158a> concurrentHashMap = a;
                            if (concurrentHashMap != null) {
                                concurrentHashMap.remove(requestIdNotice);
                                return;
                            }
                            return;
                        }
                        ConcurrentHashMap<String, C0158a> concurrentHashMap2 = d;
                        if (concurrentHashMap2 != null) {
                            concurrentHashMap2.remove(requestIdNotice);
                        }
                    } else if (campaignEx.isBidCampaign()) {
                        ConcurrentHashMap<String, C0158a> concurrentHashMap3 = c;
                        if (concurrentHashMap3 != null) {
                            concurrentHashMap3.remove(requestIdNotice);
                        }
                    } else {
                        ConcurrentHashMap<String, C0158a> concurrentHashMap4 = f;
                        if (concurrentHashMap4 != null) {
                            concurrentHashMap4.remove(requestIdNotice);
                        }
                    }
                } else if (campaignEx.isBidCampaign()) {
                    ConcurrentHashMap<String, C0158a> concurrentHashMap5 = b;
                    if (concurrentHashMap5 != null) {
                        concurrentHashMap5.remove(requestIdNotice);
                    }
                } else {
                    ConcurrentHashMap<String, C0158a> concurrentHashMap6 = e;
                    if (concurrentHashMap6 != null) {
                        concurrentHashMap6.remove(requestIdNotice);
                    }
                }
            } catch (Exception e2) {
                if (MBridgeConstans.DEBUG) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public static void a(int i2, String str, C0158a aVar) {
        if (i2 == 94) {
            if (b == null) {
                b = new ConcurrentHashMap<>();
            }
            b.put(str, aVar);
        } else if (i2 == 287) {
            try {
                if (c == null) {
                    c = new ConcurrentHashMap<>();
                }
                c.put(str, aVar);
            } catch (Exception e2) {
                if (MBridgeConstans.DEBUG) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public static void b(int i2, String str, C0158a aVar) {
        if (i2 == 94) {
            if (e == null) {
                e = new ConcurrentHashMap<>();
            }
            e.put(str, aVar);
        } else if (i2 == 287) {
            if (f == null) {
                f = new ConcurrentHashMap<>();
            }
            f.put(str, aVar);
        } else if (i2 != 288) {
            try {
                if (a == null) {
                    a = new ConcurrentHashMap<>();
                }
                a.put(str, aVar);
            } catch (Exception e2) {
                if (MBridgeConstans.DEBUG) {
                    e2.printStackTrace();
                }
            }
        } else {
            if (d == null) {
                d = new ConcurrentHashMap<>();
            }
            d.put(str, aVar);
        }
    }
}

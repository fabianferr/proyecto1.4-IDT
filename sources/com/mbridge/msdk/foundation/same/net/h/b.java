package com.mbridge.msdk.foundation.same.net.h;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.cast.MediaTrack;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.f;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.foundation.same.DomainNameUtils;
import com.mbridge.msdk.foundation.same.a;
import com.mbridge.msdk.foundation.same.net.Aa;
import com.mbridge.msdk.foundation.same.net.e;
import com.mbridge.msdk.foundation.same.net.g.d;
import com.mbridge.msdk.foundation.same.net.m;
import com.mbridge.msdk.foundation.same.net.o;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.out.CustomInfoManager;
import java.io.File;
import java.util.Map;
import org.json.JSONArray;

/* compiled from: CommonAsyncHttpRequest */
public class b {
    private static final String TAG = "b";
    protected Context mContext;

    public b(Context context) {
        if (context == null) {
            this.mContext = com.mbridge.msdk.foundation.controller.b.d().g();
        } else {
            this.mContext = context.getApplicationContext();
        }
    }

    public void addExtraParams(String str, d dVar) {
        if (dVar != null) {
            dVar.a("open", a.v);
            String a = Aa.a();
            if (a == null) {
                a = "";
            }
            dVar.a("channel", a);
            dVar.a("band_width", com.mbridge.msdk.foundation.same.net.a.a().e() + "");
            String str2 = dVar.c().get(MBridgeConstans.PROPERTIES_UNIT_ID);
            if (str2 != null) {
                String customInfoByUnitId = CustomInfoManager.getInstance().getCustomInfoByUnitId(str2, str);
                if (!TextUtils.isEmpty(customInfoByUnitId)) {
                    dVar.a("ch_info", customInfoByUnitId);
                }
                h e = f.a().e(com.mbridge.msdk.foundation.controller.b.d().h(), str2);
                if (e != null && !TextUtils.isEmpty(e.a())) {
                    dVar.a("u_stid", e.a());
                }
            }
            if (!com.mbridge.msdk.foundation.controller.authoritycontroller.a.g()) {
                dVar.a("dev_source", "2");
            }
            if (DomainNameUtils.getInstance().isExcludeCNDomain()) {
                dVar.a("re_domain", "1");
            }
        }
    }

    public void get(int i, String str, d dVar, e eVar) {
        get(i, str, dVar, new com.mbridge.msdk.foundation.same.net.b(), eVar, false, false);
    }

    public void getLoadOrSetting(int i, String str, d dVar, e eVar) {
        getLoadOrSetting(i, str, dVar, new com.mbridge.msdk.foundation.same.net.b(), eVar, true);
    }

    public void getLoadOrSetting(int i, String str, d dVar, m mVar, e eVar, boolean z) {
        get(i, str, dVar, mVar, eVar, z, false);
    }

    public void getCampaign(int i, String str, d dVar, m mVar, e eVar) {
        int i2;
        d dVar2;
        try {
            com.mbridge.msdk.c.e g = f.a().g(com.mbridge.msdk.foundation.controller.b.d().h());
            if (TextUtils.isEmpty(str)) {
                i2 = g.aJ();
            } else {
                i2 = g.aI();
            }
            String a = d.a().a(str, i2);
            if (mVar == null) {
                mVar = new com.mbridge.msdk.foundation.same.net.b();
            }
            if (i2 < 2) {
                postV5(i, a, dVar, eVar, mVar, true);
                return;
            }
            if (i2 % 2 == 0) {
                if (dVar == null) {
                    dVar = new d();
                }
                dVar2 = dVar;
                JSONArray b = com.mbridge.msdk.foundation.db.a.a.a().b();
                if (b != null) {
                    String jSONArray = b.toString();
                    int b2 = d.a().b();
                    if (b2 <= 0 || jSONArray.length() <= b2) {
                        dVar2.a(d.e, jSONArray);
                    } else {
                        post(i, a, dVar2, mVar, eVar, true, false);
                        return;
                    }
                }
            } else {
                dVar2 = dVar;
            }
            get(i, a, dVar2, mVar, eVar, true, true);
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                aa.d(TAG, e.getMessage());
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:60:0x0186  */
    /* JADX WARNING: Removed duplicated region for block: B:65:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void get(int r14, java.lang.String r15, com.mbridge.msdk.foundation.same.net.h.d r16, com.mbridge.msdk.foundation.same.net.m r17, com.mbridge.msdk.foundation.same.net.e r18, boolean r19, boolean r20) {
        /*
            r13 = this;
            r2 = r14
            r3 = r15
            r10 = r18
            if (r16 != 0) goto L_0x0013
            com.mbridge.msdk.foundation.same.net.h.d r0 = new com.mbridge.msdk.foundation.same.net.h.d     // Catch:{ Exception -> 0x000e }
            r0.<init>()     // Catch:{ Exception -> 0x000e }
            r11 = r13
            r1 = r0
            goto L_0x0016
        L_0x000e:
            r0 = move-exception
            r11 = r13
            r1 = r16
            goto L_0x0070
        L_0x0013:
            r11 = r13
            r1 = r16
        L_0x0016:
            r13.addExtraParams(r15, r1)     // Catch:{ Exception -> 0x006f }
            com.mbridge.msdk.foundation.same.net.h.e.e(r1)     // Catch:{ Exception -> 0x006f }
            java.util.Map r0 = r1.c()     // Catch:{ Exception -> 0x006f }
            java.lang.String r4 = "sign"
            java.lang.Object r0 = r0.get(r4)     // Catch:{ Exception -> 0x006f }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x006f }
            java.lang.String r4 = ""
            if (r0 != 0) goto L_0x002d
            r0 = r4
        L_0x002d:
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x006f }
            java.lang.String r7 = "ts"
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x006f }
            r8.<init>()     // Catch:{ Exception -> 0x006f }
            r8.append(r5)     // Catch:{ Exception -> 0x006f }
            r8.append(r4)     // Catch:{ Exception -> 0x006f }
            java.lang.String r4 = r8.toString()     // Catch:{ Exception -> 0x006f }
            r1.a(r7, r4)     // Catch:{ Exception -> 0x006f }
            java.lang.String r4 = "st"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x006f }
            r7.<init>()     // Catch:{ Exception -> 0x006f }
            r7.append(r5)     // Catch:{ Exception -> 0x006f }
            r7.append(r0)     // Catch:{ Exception -> 0x006f }
            java.lang.String r0 = r7.toString()     // Catch:{ Exception -> 0x006f }
            java.lang.String r0 = com.mbridge.msdk.foundation.tools.SameMD5.getMD5(r0)     // Catch:{ Exception -> 0x006f }
            r1.a(r4, r0)     // Catch:{ Exception -> 0x006f }
            com.mbridge.msdk.foundation.same.net.g.c r0 = com.mbridge.msdk.foundation.same.net.g.c.a()     // Catch:{ Exception -> 0x006f }
            com.mbridge.msdk.foundation.same.net.l r0 = r0.a((com.mbridge.msdk.foundation.same.net.h.d) r1)     // Catch:{ Exception -> 0x006f }
            if (r0 == 0) goto L_0x0079
            if (r10 == 0) goto L_0x0079
            r10.onSuccess(r0)     // Catch:{ Exception -> 0x006f }
            return
        L_0x006f:
            r0 = move-exception
        L_0x0070:
            java.lang.String r4 = TAG
            java.lang.String r0 = r0.getMessage()
            com.mbridge.msdk.foundation.tools.aa.a((java.lang.String) r4, (java.lang.String) r0)
        L_0x0079:
            r12 = r1
            com.mbridge.msdk.foundation.same.net.g.d r0 = com.mbridge.msdk.foundation.same.net.g.d.a()
            java.lang.String r0 = r0.e
            boolean r0 = r15.contains(r0)
            if (r0 == 0) goto L_0x00ef
            com.mbridge.msdk.foundation.same.net.g.d r0 = com.mbridge.msdk.foundation.same.net.g.d.a()
            boolean r0 = r0.p
            if (r0 == 0) goto L_0x00ef
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ all -> 0x00e5 }
            r1.<init>()     // Catch:{ all -> 0x00e5 }
            com.mbridge.msdk.foundation.same.net.g.d r0 = com.mbridge.msdk.foundation.same.net.g.d.a()     // Catch:{ all -> 0x00c0 }
            java.lang.String r0 = r0.f     // Catch:{ all -> 0x00c0 }
            android.net.Uri r4 = android.net.Uri.parse(r15)     // Catch:{ all -> 0x00c0 }
            java.lang.String r4 = r4.getPath()     // Catch:{ all -> 0x00c0 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c0 }
            r5.<init>()     // Catch:{ all -> 0x00c0 }
            r5.append(r0)     // Catch:{ all -> 0x00c0 }
            r5.append(r4)     // Catch:{ all -> 0x00c0 }
            java.lang.String r0 = r5.toString()     // Catch:{ all -> 0x00c0 }
            java.lang.String r4 = "uri"
            r1.put(r4, r0)     // Catch:{ all -> 0x00c0 }
            java.lang.String r0 = "data"
            java.lang.String r4 = r12.a()     // Catch:{ all -> 0x00c0 }
            r1.put(r0, r4)     // Catch:{ all -> 0x00c0 }
            goto L_0x00ca
        L_0x00c0:
            r0 = move-exception
            java.lang.String r4 = TAG     // Catch:{ all -> 0x00e5 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x00e5 }
            com.mbridge.msdk.foundation.tools.aa.d(r4, r0)     // Catch:{ all -> 0x00e5 }
        L_0x00ca:
            com.mbridge.msdk.foundation.same.net.n r4 = com.mbridge.msdk.foundation.same.net.n.a()     // Catch:{ all -> 0x00e5 }
            com.mbridge.msdk.foundation.same.net.g.d r0 = com.mbridge.msdk.foundation.same.net.g.d.a()     // Catch:{ all -> 0x00e5 }
            java.lang.String r5 = r0.f     // Catch:{ all -> 0x00e5 }
            com.mbridge.msdk.foundation.same.net.g.d r0 = com.mbridge.msdk.foundation.same.net.g.d.a()     // Catch:{ all -> 0x00e5 }
            int r6 = r0.n     // Catch:{ all -> 0x00e5 }
            java.lang.String r7 = r1.toString()     // Catch:{ all -> 0x00e5 }
            r8 = 1
            r9 = r18
            r4.a(r5, r6, r7, r8, r9)     // Catch:{ all -> 0x00e5 }
            return
        L_0x00e5:
            r0 = move-exception
            java.lang.String r1 = TAG
            java.lang.String r0 = r0.getMessage()
            com.mbridge.msdk.foundation.tools.aa.d(r1, r0)
        L_0x00ef:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r15)
            java.lang.String r1 = "?"
            r0.append(r1)
            java.lang.String r1 = r12.toString()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.mbridge.msdk.c.f r1 = com.mbridge.msdk.c.f.a()
            com.mbridge.msdk.foundation.controller.b r4 = com.mbridge.msdk.foundation.controller.b.d()
            java.lang.String r4 = r4.h()
            com.mbridge.msdk.c.e r1 = r1.g(r4)
            int r4 = r0.length()
            int r5 = r1.n()
            if (r4 < r5) goto L_0x013c
            com.mbridge.msdk.foundation.same.net.g.d r4 = com.mbridge.msdk.foundation.same.net.g.d.a()
            java.lang.String r4 = r4.e
            boolean r4 = r0.contains(r4)
            if (r4 == 0) goto L_0x013c
            r8 = 0
            r1 = r13
            r2 = r14
            r3 = r15
            r4 = r12
            r5 = r17
            r6 = r18
            r7 = r20
            r1.post(r2, r3, r4, r5, r6, r7, r8)
            return
        L_0x013c:
            int r4 = r0.length()
            int r1 = r1.o()
            if (r4 < r1) goto L_0x0157
            if (r19 == 0) goto L_0x0157
            r8 = 0
            r1 = r13
            r2 = r14
            r3 = r15
            r4 = r12
            r5 = r17
            r6 = r18
            r7 = r20
            r1.post(r2, r3, r4, r5, r6, r7, r8)
            return
        L_0x0157:
            r1 = 0
            r3 = 0
            if (r2 == 0) goto L_0x017e
            r4 = 1
            if (r2 == r4) goto L_0x0168
            r4 = 2
            if (r2 == r4) goto L_0x0162
            goto L_0x0184
        L_0x0162:
            com.mbridge.msdk.foundation.same.net.e.c r2 = new com.mbridge.msdk.foundation.same.net.e.c
            r2.<init>(r1, r0, r3, r10)
            goto L_0x0183
        L_0x0168:
            if (r20 == 0) goto L_0x0178
            com.mbridge.msdk.foundation.same.net.e.d r7 = new com.mbridge.msdk.foundation.same.net.e.d
            r2 = 0
            r4 = 0
            r6 = 1
            r1 = r7
            r3 = r0
            r5 = r18
            r1.<init>(r2, r3, r4, r5, r6)
            r3 = r7
            goto L_0x0184
        L_0x0178:
            com.mbridge.msdk.foundation.same.net.e.d r2 = new com.mbridge.msdk.foundation.same.net.e.d
            r2.<init>(r1, r0, r3, r10)
            goto L_0x0183
        L_0x017e:
            com.mbridge.msdk.foundation.same.net.e.f r2 = new com.mbridge.msdk.foundation.same.net.e.f
            r2.<init>(r1, r0, r3, r10)
        L_0x0183:
            r3 = r2
        L_0x0184:
            if (r3 == 0) goto L_0x019b
            r1 = r17
            r3.a((com.mbridge.msdk.foundation.same.net.m) r1)
            int r0 = r3.h()
            r3.b(r0)
            if (r20 == 0) goto L_0x0198
            com.mbridge.msdk.foundation.same.net.o.a((com.mbridge.msdk.foundation.same.net.j) r3)
            goto L_0x019b
        L_0x0198:
            com.mbridge.msdk.foundation.same.net.o.b(r3)
        L_0x019b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.same.net.h.b.get(int, java.lang.String, com.mbridge.msdk.foundation.same.net.h.d, com.mbridge.msdk.foundation.same.net.m, com.mbridge.msdk.foundation.same.net.e, boolean, boolean):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0078 A[SYNTHETIC, Splitter:B:22:0x0078] */
    /* JADX WARNING: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void get(int r3, java.lang.String r4, java.util.Map<java.lang.String, java.lang.String> r5, com.mbridge.msdk.foundation.same.net.m r6, com.mbridge.msdk.foundation.same.net.e r7) {
        /*
            r2 = this;
            if (r5 != 0) goto L_0x0007
            java.util.HashMap r5 = new java.util.HashMap
            r5.<init>()
        L_0x0007:
            com.mbridge.msdk.foundation.controller.b r0 = com.mbridge.msdk.foundation.controller.b.d()
            java.lang.String r0 = r0.h()
            java.lang.String r1 = "app_id"
            r5.put(r1, r0)
            java.lang.String r0 = "sdk_version"
            java.lang.String r1 = "MAL_16.5.91"
            r5.put(r0, r1)
            java.lang.String r0 = "platform"
            java.lang.String r1 = "1"
            r5.put(r0, r1)
            java.lang.String r5 = r2.asUrlParams(r5)
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            if (r0 != 0) goto L_0x0040
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r4)
            java.lang.String r4 = "?"
            r0.append(r4)
            r0.append(r5)
            java.lang.String r4 = r0.toString()
        L_0x0040:
            boolean r5 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r5 == 0) goto L_0x0057
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r0 = "get wx scheme url = "
            r5.<init>(r0)
            r5.append(r4)
            java.lang.String r5 = r5.toString()
            java.lang.String r0 = "AppletsModel"
            com.mbridge.msdk.foundation.tools.aa.a((java.lang.String) r0, (java.lang.String) r5)
        L_0x0057:
            r5 = 0
            r0 = 0
            if (r3 == 0) goto L_0x0070
            r1 = 1
            if (r3 == r1) goto L_0x006a
            r1 = 2
            if (r3 == r1) goto L_0x0062
            goto L_0x0076
        L_0x0062:
            com.mbridge.msdk.foundation.same.net.e.c r3 = new com.mbridge.msdk.foundation.same.net.e.c     // Catch:{ Exception -> 0x0068 }
            r3.<init>(r5, r4, r0, r7)     // Catch:{ Exception -> 0x0068 }
            goto L_0x0075
        L_0x0068:
            goto L_0x0076
        L_0x006a:
            com.mbridge.msdk.foundation.same.net.e.d r3 = new com.mbridge.msdk.foundation.same.net.e.d     // Catch:{ Exception -> 0x0068 }
            r3.<init>(r5, r4, r0, r7)     // Catch:{ Exception -> 0x0068 }
            goto L_0x0075
        L_0x0070:
            com.mbridge.msdk.foundation.same.net.e.f r3 = new com.mbridge.msdk.foundation.same.net.e.f     // Catch:{ Exception -> 0x0068 }
            r3.<init>(r5, r4, r0, r7)     // Catch:{ Exception -> 0x0068 }
        L_0x0075:
            r0 = r3
        L_0x0076:
            if (r0 == 0) goto L_0x0085
            r0.a((com.mbridge.msdk.foundation.same.net.m) r6)     // Catch:{ Exception -> 0x0085 }
            int r3 = r0.h()     // Catch:{ Exception -> 0x0085 }
            r0.b(r3)     // Catch:{ Exception -> 0x0085 }
            com.mbridge.msdk.foundation.same.net.o.b(r0)     // Catch:{ Exception -> 0x0085 }
        L_0x0085:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.same.net.h.b.get(int, java.lang.String, java.util.Map, com.mbridge.msdk.foundation.same.net.m, com.mbridge.msdk.foundation.same.net.e):void");
    }

    private String asUrlParams(Map<String, String> map) {
        if (!(map == null || map.size() == 0)) {
            StringBuilder sb = new StringBuilder();
            try {
                for (String next : map.keySet()) {
                    if (!TextUtils.isEmpty(next)) {
                        String str = map.get(next);
                        if (TextUtils.isEmpty(str)) {
                            str = "";
                        }
                        sb.append("&");
                        sb.append(next);
                        sb.append("=");
                        sb.append(str);
                    }
                }
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    aa.d(TAG, e.getMessage());
                }
                sb = null;
            }
            if (sb != null && sb.length() > 0) {
                return sb.toString();
            }
        }
        return null;
    }

    public static void downloadFile(File file, String str, e eVar) {
        o.a().a(file, str, eVar);
    }

    public void choiceV3OrV5BySetting(int i, d dVar, e eVar, String str) {
        choiceV3OrV5BySetting(i, dVar, eVar, str, new com.mbridge.msdk.foundation.same.net.b());
    }

    public void choiceV3OrV5BySetting(int i, d dVar, e eVar, String str, m mVar) {
        int i2;
        com.mbridge.msdk.c.e g = f.a().g(com.mbridge.msdk.foundation.controller.b.d().h());
        if (TextUtils.isEmpty(str)) {
            i2 = g.aJ();
        } else {
            i2 = g.aI();
        }
        String a = d.a().a(str, i2);
        if (i2 >= 2) {
            if (i2 % 2 == 0) {
                if (dVar == null) {
                    dVar = new d();
                }
                JSONArray b = com.mbridge.msdk.foundation.db.a.a.a().b();
                if (b != null) {
                    String jSONArray = b.toString();
                    int b2 = d.a().b();
                    if (b2 <= 0 || jSONArray.length() <= b2) {
                        dVar.a(d.e, jSONArray);
                    } else {
                        post(i, a, dVar, eVar);
                        return;
                    }
                }
            }
            d dVar2 = dVar;
            if (mVar == null) {
                getLoadOrSetting(i, a, dVar2, eVar);
            } else {
                getLoadOrSetting(i, a, dVar2, mVar, eVar, true);
            }
        } else if (mVar == null) {
            postV5(i, a, dVar, eVar);
        } else {
            postV5(i, a, dVar, eVar, mVar, false);
        }
    }

    public void postV5(int i, String str, d dVar, e eVar) {
        String str2 = dVar.c().get(MediaTrack.ROLE_SIGN);
        if (str2 == null) {
            str2 = "";
        }
        long currentTimeMillis = System.currentTimeMillis();
        dVar.a("ts", currentTimeMillis + "");
        dVar.a("st", SameMD5.getMD5(currentTimeMillis + str2));
        post(i, str, dVar, new com.mbridge.msdk.foundation.same.net.b(), eVar, false, false);
    }

    public void postV5(int i, String str, d dVar, e eVar, m mVar, boolean z) {
        String str2 = dVar.c().get(MediaTrack.ROLE_SIGN);
        if (str2 == null) {
            str2 = "";
        }
        long currentTimeMillis = System.currentTimeMillis();
        dVar.a("ts", currentTimeMillis + "");
        dVar.a("st", SameMD5.getMD5(currentTimeMillis + str2));
        if (mVar != null) {
            post(i, str, dVar, mVar, eVar, z, false);
            return;
        }
        post(i, str, dVar, new com.mbridge.msdk.foundation.same.net.b(), eVar, z, false);
    }

    public void post(int i, String str, d dVar, e eVar) {
        post(i, str, dVar, new com.mbridge.msdk.foundation.same.net.b(), eVar, false, false);
    }

    public void postFocusReport(int i, String str, d dVar, e eVar) {
        post(i, str, dVar, new com.mbridge.msdk.foundation.same.net.b(), eVar, false, true);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x009a A[SYNTHETIC, Splitter:B:37:0x009a] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00eb A[Catch:{ Exception -> 0x00e9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x019b  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x01ce  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x01dd  */
    /* JADX WARNING: Removed duplicated region for block: B:98:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void post(int r15, java.lang.String r16, com.mbridge.msdk.foundation.same.net.h.d r17, com.mbridge.msdk.foundation.same.net.m r18, com.mbridge.msdk.foundation.same.net.e r19, boolean r20, boolean r21) {
        /*
            r14 = this;
            r1 = r15
            r2 = r16
            r9 = r19
            if (r17 != 0) goto L_0x0014
            com.mbridge.msdk.foundation.same.net.h.d r0 = new com.mbridge.msdk.foundation.same.net.h.d     // Catch:{ Exception -> 0x000f }
            r0.<init>()     // Catch:{ Exception -> 0x000f }
            r10 = r14
            r3 = r0
            goto L_0x0017
        L_0x000f:
            r0 = move-exception
            r10 = r14
            r3 = r17
            goto L_0x002e
        L_0x0014:
            r10 = r14
            r3 = r17
        L_0x0017:
            r14.addExtraParams(r2, r3)     // Catch:{ Exception -> 0x002d }
            com.mbridge.msdk.foundation.same.net.h.e.e(r3)     // Catch:{ Exception -> 0x002d }
            com.mbridge.msdk.foundation.same.net.g.c r0 = com.mbridge.msdk.foundation.same.net.g.c.a()     // Catch:{ Exception -> 0x002d }
            com.mbridge.msdk.foundation.same.net.l r0 = r0.a((com.mbridge.msdk.foundation.same.net.h.d) r3)     // Catch:{ Exception -> 0x002d }
            if (r0 == 0) goto L_0x0037
            if (r9 == 0) goto L_0x0037
            r9.onSuccess(r0)     // Catch:{ Exception -> 0x002d }
            return
        L_0x002d:
            r0 = move-exception
        L_0x002e:
            java.lang.String r4 = TAG
            java.lang.String r0 = r0.getMessage()
            com.mbridge.msdk.foundation.tools.aa.a((java.lang.String) r4, (java.lang.String) r0)
        L_0x0037:
            r11 = r3
            com.mbridge.msdk.foundation.same.net.g.d r0 = com.mbridge.msdk.foundation.same.net.g.d.a()
            java.lang.String r0 = r0.a
            boolean r0 = r2.contains(r0)
            r12 = 2
            r13 = 1
            if (r0 == 0) goto L_0x010d
            com.mbridge.msdk.c.f r0 = com.mbridge.msdk.c.f.a()
            com.mbridge.msdk.foundation.controller.b r3 = com.mbridge.msdk.foundation.controller.b.d()
            java.lang.String r3 = r3.h()
            com.mbridge.msdk.c.e r3 = r0.b(r3)
            java.lang.String r4 = ""
            if (r3 == 0) goto L_0x008f
            int r5 = r3.aq()
            java.lang.String r6 = r3.aH()
            java.util.Map r0 = r11.c()     // Catch:{ Exception -> 0x007d }
            java.lang.String r7 = "data"
            java.lang.Object r0 = r0.get(r7)     // Catch:{ Exception -> 0x007d }
            r7 = r0
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ Exception -> 0x007d }
            if (r21 != 0) goto L_0x007b
            boolean r0 = com.mbridge.msdk.foundation.same.report.q.a(r3, r7)     // Catch:{ Exception -> 0x0078 }
            if (r0 != 0) goto L_0x007b
            return
        L_0x0078:
            r0 = move-exception
            r4 = r7
            goto L_0x007e
        L_0x007b:
            r4 = r7
            goto L_0x0081
        L_0x007d:
            r0 = move-exception
        L_0x007e:
            r0.printStackTrace()
        L_0x0081:
            int r0 = r3.v()
            java.lang.String r7 = "a_stid"
            java.lang.String r8 = r3.c()
            r11.a(r7, r8)
            goto L_0x0093
        L_0x008f:
            r5 = 0
            java.lang.String r6 = "UNKNOWN"
            r0 = 0
        L_0x0093:
            java.lang.String r7 = "country_code"
            r11.a(r7, r6)
            if (r5 != r12) goto L_0x00eb
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x00e9 }
            if (r5 != 0) goto L_0x00e8
            boolean r3 = com.mbridge.msdk.foundation.same.report.q.a(r3, r4)     // Catch:{ Exception -> 0x00e9 }
            r4 = 3
            if (r3 == 0) goto L_0x00c6
            if (r0 == r13) goto L_0x00ab
            if (r0 != r4) goto L_0x0194
        L_0x00ab:
            com.mbridge.msdk.foundation.same.net.n r3 = com.mbridge.msdk.foundation.same.net.n.a()     // Catch:{ Exception -> 0x00e9 }
            com.mbridge.msdk.foundation.same.net.g.d r0 = com.mbridge.msdk.foundation.same.net.g.d.a()     // Catch:{ Exception -> 0x00e9 }
            java.lang.String r4 = r0.h     // Catch:{ Exception -> 0x00e9 }
            com.mbridge.msdk.foundation.same.net.g.d r0 = com.mbridge.msdk.foundation.same.net.g.d.a()     // Catch:{ Exception -> 0x00e9 }
            int r5 = r0.l     // Catch:{ Exception -> 0x00e9 }
            java.lang.String r6 = r11.toString()     // Catch:{ Exception -> 0x00e9 }
            r7 = 0
            r8 = r19
            r3.a(r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x00e9 }
            return
        L_0x00c6:
            if (r21 == 0) goto L_0x0194
            if (r0 == r13) goto L_0x00ce
            if (r0 != r4) goto L_0x00cd
            goto L_0x00ce
        L_0x00cd:
            return
        L_0x00ce:
            com.mbridge.msdk.foundation.same.net.n r3 = com.mbridge.msdk.foundation.same.net.n.a()     // Catch:{ Exception -> 0x00e9 }
            com.mbridge.msdk.foundation.same.net.g.d r0 = com.mbridge.msdk.foundation.same.net.g.d.a()     // Catch:{ Exception -> 0x00e9 }
            java.lang.String r4 = r0.h     // Catch:{ Exception -> 0x00e9 }
            com.mbridge.msdk.foundation.same.net.g.d r0 = com.mbridge.msdk.foundation.same.net.g.d.a()     // Catch:{ Exception -> 0x00e9 }
            int r5 = r0.l     // Catch:{ Exception -> 0x00e9 }
            java.lang.String r6 = r11.toString()     // Catch:{ Exception -> 0x00e9 }
            r7 = 0
            r8 = r19
            r3.a(r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x00e9 }
        L_0x00e8:
            return
        L_0x00e9:
            r0 = move-exception
            goto L_0x0108
        L_0x00eb:
            if (r5 != r13) goto L_0x0194
            com.mbridge.msdk.foundation.same.net.n r3 = com.mbridge.msdk.foundation.same.net.n.a()     // Catch:{ Exception -> 0x00e9 }
            com.mbridge.msdk.foundation.same.net.g.d r0 = com.mbridge.msdk.foundation.same.net.g.d.a()     // Catch:{ Exception -> 0x00e9 }
            java.lang.String r4 = r0.h     // Catch:{ Exception -> 0x00e9 }
            com.mbridge.msdk.foundation.same.net.g.d r0 = com.mbridge.msdk.foundation.same.net.g.d.a()     // Catch:{ Exception -> 0x00e9 }
            int r5 = r0.l     // Catch:{ Exception -> 0x00e9 }
            java.lang.String r6 = r11.toString()     // Catch:{ Exception -> 0x00e9 }
            r7 = 0
            r8 = r19
            r3.a(r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x00e9 }
            return
        L_0x0108:
            r0.printStackTrace()
            goto L_0x0194
        L_0x010d:
            com.mbridge.msdk.foundation.same.net.g.d r0 = com.mbridge.msdk.foundation.same.net.g.d.a()
            java.lang.String r0 = r0.b
            boolean r0 = r2.contains(r0)
            if (r0 == 0) goto L_0x0152
            com.mbridge.msdk.c.f r0 = com.mbridge.msdk.c.f.a()
            com.mbridge.msdk.foundation.controller.b r3 = com.mbridge.msdk.foundation.controller.b.d()
            java.lang.String r3 = r3.h()
            com.mbridge.msdk.c.e r0 = r0.b(r3)
            if (r0 == 0) goto L_0x0194
            com.mbridge.msdk.c.a r0 = r0.h()
            if (r0 == 0) goto L_0x0194
            int r0 = r0.e()
            if (r0 != r13) goto L_0x0194
            com.mbridge.msdk.foundation.same.net.n r1 = com.mbridge.msdk.foundation.same.net.n.a()
            com.mbridge.msdk.foundation.same.net.g.d r0 = com.mbridge.msdk.foundation.same.net.g.d.a()
            java.lang.String r2 = r0.i
            com.mbridge.msdk.foundation.same.net.g.d r0 = com.mbridge.msdk.foundation.same.net.g.d.a()
            int r3 = r0.m
            java.lang.String r4 = r11.toString()
            r5 = 0
            r6 = r19
            r1.a(r2, r3, r4, r5, r6)
            return
        L_0x0152:
            com.mbridge.msdk.foundation.same.net.g.d r0 = com.mbridge.msdk.foundation.same.net.g.d.a()
            java.lang.String r0 = r0.v
            boolean r0 = r2.contains(r0)
            if (r0 == 0) goto L_0x0194
            if (r11 == 0) goto L_0x0179
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r2)
            java.lang.String r2 = "?"
            r0.append(r2)
            java.lang.String r2 = r11.toString()
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            goto L_0x017a
        L_0x0179:
            r0 = r2
        L_0x017a:
            com.mbridge.msdk.foundation.db.a.a r2 = com.mbridge.msdk.foundation.db.a.a.a()
            org.json.JSONArray r2 = r2.b()
            if (r2 == 0) goto L_0x0192
            java.lang.String r2 = r2.toString()
            com.mbridge.msdk.foundation.same.net.h.d r11 = new com.mbridge.msdk.foundation.same.net.h.d
            r11.<init>()
            java.lang.String r3 = com.mbridge.msdk.foundation.same.net.h.d.e
            r11.a(r3, r2)
        L_0x0192:
            r3 = r0
            goto L_0x0195
        L_0x0194:
            r3 = r2
        L_0x0195:
            java.lang.String r0 = "application/x-www-form-urlencoded"
            java.lang.String r7 = "Content-Type"
            if (r1 == 0) goto L_0x01ce
            if (r1 == r13) goto L_0x01ae
            if (r1 == r12) goto L_0x01a1
            r0 = 0
            goto L_0x01db
        L_0x01a1:
            com.mbridge.msdk.foundation.same.net.e.c r1 = new com.mbridge.msdk.foundation.same.net.e.c
            java.lang.String r2 = r11.toString()
            r1.<init>(r13, r3, r2, r9)
            r1.a((java.lang.String) r7, (java.lang.String) r0)
            goto L_0x01da
        L_0x01ae:
            if (r20 == 0) goto L_0x01bf
            com.mbridge.msdk.foundation.same.net.e.d r8 = new com.mbridge.msdk.foundation.same.net.e.d
            r2 = 1
            java.lang.String r4 = r11.toString()
            r6 = 1
            r1 = r8
            r5 = r19
            r1.<init>(r2, r3, r4, r5, r6)
            goto L_0x01c9
        L_0x01bf:
            com.mbridge.msdk.foundation.same.net.e.d r1 = new com.mbridge.msdk.foundation.same.net.e.d
            java.lang.String r2 = r11.toString()
            r1.<init>(r13, r3, r2, r9)
            r8 = r1
        L_0x01c9:
            r8.a((java.lang.String) r7, (java.lang.String) r0)
            r0 = r8
            goto L_0x01db
        L_0x01ce:
            com.mbridge.msdk.foundation.same.net.e.f r1 = new com.mbridge.msdk.foundation.same.net.e.f
            java.lang.String r2 = r11.toString()
            r1.<init>(r13, r3, r2, r9)
            r1.a((java.lang.String) r7, (java.lang.String) r0)
        L_0x01da:
            r0 = r1
        L_0x01db:
            if (r0 == 0) goto L_0x01eb
            r1 = r18
            r0.a((com.mbridge.msdk.foundation.same.net.m) r1)
            if (r20 == 0) goto L_0x01e8
            com.mbridge.msdk.foundation.same.net.o.a((com.mbridge.msdk.foundation.same.net.j) r0)
            goto L_0x01eb
        L_0x01e8:
            com.mbridge.msdk.foundation.same.net.o.b(r0)
        L_0x01eb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.same.net.h.b.post(int, java.lang.String, com.mbridge.msdk.foundation.same.net.h.d, com.mbridge.msdk.foundation.same.net.m, com.mbridge.msdk.foundation.same.net.e, boolean, boolean):void");
    }
}

package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.view.WindowManager;
import com.bytedance.JProtect;
import com.bytedance.sdk.component.d.k;
import com.bytedance.sdk.component.d.o;
import com.bytedance.sdk.component.d.t;
import com.bytedance.sdk.component.d.u;
import com.bytedance.sdk.component.f.b.d;
import com.bytedance.sdk.component.f.c.e;
import com.bytedance.sdk.component.g.h;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.b.a.f;
import com.bytedance.sdk.openadsdk.core.g.b.c;
import com.bytedance.sdk.openadsdk.core.model.g;
import com.bytedance.sdk.openadsdk.core.model.i;
import com.bytedance.sdk.openadsdk.core.model.j;
import com.bytedance.sdk.openadsdk.core.model.n;
import com.bytedance.sdk.openadsdk.core.model.s;
import com.bytedance.sdk.openadsdk.core.model.w;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.ad;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: NetApiImpl */
public class q implements p<com.bytedance.sdk.openadsdk.b.a> {
    /* access modifiers changed from: private */
    public final Context a;

    /* compiled from: NetApiImpl */
    public static class a {
        final int a;
        final long b;
        final long c;
        final int d;
        final String e;
        final int f;
        final String g;
        public final com.bytedance.sdk.openadsdk.core.model.a h;
        final String i;
        final ArrayList<Integer> j;

        private a(String str, int i2, int i3, String str2, int i4, String str3, com.bytedance.sdk.openadsdk.core.model.a aVar, long j2, long j3, ArrayList<Integer> arrayList) {
            this.a = i2;
            this.d = i3;
            this.e = str2;
            this.g = str3;
            this.h = aVar;
            this.i = str;
            this.f = i4;
            this.b = j2;
            this.c = j3;
            this.j = arrayList;
        }

        public static a a(JSONObject jSONObject, AdSlot adSlot, s sVar) {
            String str;
            JSONArray jSONArray;
            int i2;
            long j2;
            long j3;
            JSONObject jSONObject2 = jSONObject;
            String optString = jSONObject2.optString(j.j1699434667891dc("dhf"));
            int optInt = jSONObject2.optInt(j.j1699434667891dc("psm`avunfnUe`kP}b"));
            long optLong = jSONObject2.optLong(j.j1699434667891dc("s^pfg`oqmV~x"));
            long optLong2 = jSONObject2.optLong(j.j1699434667891dc("s^qfjaYs{"));
            int optInt2 = jSONObject2.optInt(j.j1699434667891dc("sucwqvYdgmo"));
            String optString2 = jSONObject2.optString(j.j1699434667891dc("ddq`"));
            String optString3 = jSONObject2.optString(j.j1699434667891dc("rdsvavrXam"));
            int optInt3 = jSONObject2.optInt(j.j1699434667891dc("rdcpkk"));
            if (adSlot == null || adSlot.getBiddingTokens() == null) {
                return new a(optString, optInt, optInt2, optString2, optInt3, optString3, (com.bytedance.sdk.openadsdk.core.model.a) null, optLong, optLong2, (ArrayList<Integer>) null);
            }
            JSONArray optJSONArray = jSONObject2.optJSONArray(j.j1699434667891dc("ael\\flbXzly~`y"));
            com.bytedance.sdk.openadsdk.core.model.a aVar = new com.bytedance.sdk.openadsdk.core.model.a();
            if (optJSONArray != null) {
                int i3 = 0;
                while (i3 < optJSONArray.length()) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                    if (optJSONObject != null) {
                        String optString4 = optJSONObject.optString(c.a.c$a1699434667851dc("n`of"));
                        String optString5 = optJSONObject.optString(c.a.c$a1699434667851dc("rdlgawYci}k"));
                        jSONArray = optJSONArray;
                        String optString6 = optJSONObject.optString(c.a.c$a1699434667851dc("psk`a"));
                        j3 = optLong2;
                        JSONArray optJSONArray2 = optJSONObject.optJSONArray(c.a.c$a1699434667851dc("whl\\jjrnkl"));
                        JSONArray optJSONArray3 = optJSONObject.optJSONArray(c.a.c$a1699434667851dc("lnqp[kisajo"));
                        j2 = optLong;
                        String optString7 = optJSONObject.optString(c.a.c$a1699434667851dc("chf"));
                        String optString8 = optJSONObject.optString(c.a.c$a1699434667851dc("cskg"));
                        str = optString3;
                        JSONArray optJSONArray4 = optJSONObject.optJSONArray(c.a.c$a1699434667851dc("aemnelh"));
                        i2 = optInt3;
                        String optString9 = optJSONObject.optString(c.a.c$a1699434667851dc("ael\\v`uwggynSdj"));
                        g gVar = new g();
                        gVar.a(optString4);
                        gVar.b(optString5);
                        gVar.c(optString6);
                        gVar.d(optString7);
                        gVar.e(optString8);
                        gVar.f(optString9);
                        if (optJSONArray4 != null) {
                            ArrayList arrayList = new ArrayList();
                            for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                                arrayList.add(optJSONArray4.optString(i4));
                            }
                            gVar.c((List<String>) arrayList);
                        }
                        if (optJSONArray2 != null) {
                            ArrayList arrayList2 = new ArrayList();
                            for (int i5 = 0; i5 < optJSONArray2.length(); i5++) {
                                arrayList2.add(optJSONArray2.optString(i5));
                            }
                            gVar.a((List<String>) arrayList2);
                        }
                        if (optJSONArray3 != null) {
                            ArrayList arrayList3 = new ArrayList();
                            for (int i6 = 0; i6 < optJSONArray3.length(); i6++) {
                                arrayList3.add(optJSONArray3.optString(i6));
                            }
                            gVar.b((List<String>) arrayList3);
                        }
                        aVar.a(gVar);
                    } else {
                        jSONArray = optJSONArray;
                        i2 = optInt3;
                        str = optString3;
                        j2 = optLong;
                        j3 = optLong2;
                    }
                    i3++;
                    optJSONArray = jSONArray;
                    optString3 = str;
                    optLong2 = j3;
                    optLong = j2;
                    optInt3 = i2;
                }
            }
            return new a(optString, optInt, optInt2, optString2, optInt3, optString3, aVar, optLong, optLong2, (ArrayList<Integer>) null);
        }

        public static a a(JSONObject jSONObject, AdSlot adSlot, s sVar, com.bytedance.sdk.openadsdk.core.model.b bVar) {
            a aVar;
            JSONObject jSONObject2 = jSONObject;
            String optString = jSONObject2.optString(j.j1699434667891dc("dhf"));
            int optInt = jSONObject2.optInt(j.j1699434667891dc("psm`avunfnUe`kP}b"));
            long optLong = jSONObject2.optLong(j.j1699434667891dc("s^pfg`oqmV~x"));
            long optLong2 = jSONObject2.optLong(j.j1699434667891dc("s^qfjaYs{"));
            int optInt2 = jSONObject2.optInt(j.j1699434667891dc("sucwqvYdgmo"));
            String optString2 = jSONObject2.optString(j.j1699434667891dc("ddq`"));
            String optString3 = jSONObject2.optString(j.j1699434667891dc("rdsvavrXam"));
            int optInt3 = jSONObject2.optInt(j.j1699434667891dc("rdcpkk"));
            Pair<com.bytedance.sdk.openadsdk.core.model.a, ArrayList<Integer>> a2 = b.a(jSONObject, adSlot, sVar, bVar);
            if (!(a2 == null || a2.first == null)) {
                ((com.bytedance.sdk.openadsdk.core.model.a) a2.first).a(jSONObject2.optLong(j.j1699434667891dc("rdsvavrXio~n~")));
            }
            if (a2 == null) {
                return aVar;
            }
            new a(optString, optInt, optInt2, optString2, optInt3, optString3, (com.bytedance.sdk.openadsdk.core.model.a) a2.first, optLong, optLong2, (ArrayList) a2.second);
            return aVar;
        }
    }

    /* compiled from: NetApiImpl */
    public static class b {
        public final int a;
        public final boolean b;
        public final w c;

        private b(int i, boolean z, w wVar) {
            this.a = i;
            this.b = z;
            this.c = wVar;
        }

        public static b a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            int optInt = jSONObject.optInt(com.bytedance.sdk.openadsdk.core.video.a.b.b1699434667886dc("cnff"));
            boolean optBoolean = jSONObject.optBoolean(com.bytedance.sdk.openadsdk.core.video.a.b.b1699434667886dc("vdpjb|"));
            JSONObject optJSONObject = jSONObject.optJSONObject(com.bytedance.sdk.openadsdk.core.video.a.b.b1699434667886dc("d`vb"));
            w wVar = new w();
            if (optJSONObject != null) {
                try {
                    wVar.a(optJSONObject.optInt(com.bytedance.sdk.openadsdk.core.video.a.b.b1699434667886dc("rdcpkk")));
                    wVar.b(optJSONObject.optInt(com.bytedance.sdk.openadsdk.core.video.a.b.b1699434667886dc("cnps[qwm")));
                    wVar.c(optJSONObject.optInt(com.bytedance.sdk.openadsdk.core.video.a.b.b1699434667886dc("rdubvaYfefex")));
                    wVar.a(optJSONObject.optString(com.bytedance.sdk.openadsdk.core.video.a.b.b1699434667886dc("rdubvaYiido")));
                } catch (Throwable th) {
                    l.e(com.bytedance.sdk.openadsdk.core.video.a.b.b1699434667886dc("NdvBtlOjxe"), th.getMessage());
                }
            }
            return new b(optInt, optBoolean, wVar);
        }
    }

    q(Context context) {
        this.a = context;
    }

    private JSONArray a(List<FilterWord> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (FilterWord id : list) {
            jSONArray.put(id.getId());
        }
        return jSONArray;
    }

    public static JSONObject a(AdSlot adSlot) {
        r rVar;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(i.i1699434667884dc("pdppkkgkasooSlj"), o.d().Q());
            jSONObject.put(i.i1699434667884dc("llv"), DeviceUtils.b());
            jSONObject.put(i.i1699434667884dc("cnrse"), h.b().i());
            jSONObject.put(i.i1699434667884dc("gerq"), h.b().h());
            jSONObject.put(i.i1699434667884dc("ir]d`utX}zoy"), o.d().N());
            jSONObject.put(i.i1699434667884dc("cbrb"), h.b().t());
            if (!(adSlot == null || !r.a.containsKey(Integer.valueOf(adSlot.getCodeId())) || (rVar = r.a.get(Integer.valueOf(adSlot.getCodeId()))) == null)) {
                jSONObject.put(i.i1699434667884dc("l`qweaiji`d"), rVar.b());
                jSONObject.put(i.i1699434667884dc("l`qwfphcdl"), rVar.c());
                jSONObject.put(i.i1699434667884dc("l`qwgiodc"), rVar.d());
                jSONObject.put(i.i1699434667884dc("l`qwwnow"), rVar.e());
            }
            a(jSONObject, i.i1699434667884dc("kd{tkwbt"), h.b().k());
            a(jSONObject, i.i1699434667884dc("d`vb"), b(adSlot));
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x0128 A[Catch:{ Exception -> 0x017f }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x012b A[Catch:{ Exception -> 0x017f }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x012c A[Catch:{ Exception -> 0x017f }] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x014a A[Catch:{ Exception -> 0x017f }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private org.json.JSONObject a(com.bytedance.sdk.openadsdk.AdSlot r8, int r9, com.bytedance.sdk.openadsdk.core.model.s r10) {
        /*
            r7 = this;
        L_0x0000:
            r0 = 2
            r1 = 2
        L_0x0002:
            r2 = 1
            if (r1 == r2) goto L_0x0000
            r3 = 3
            if (r1 == r0) goto L_0x0180
            if (r1 == r3) goto L_0x000c
            r1 = 1
            goto L_0x0002
        L_0x000c:
            org.json.JSONObject r1 = new org.json.JSONObject
            r1.<init>()
            java.lang.String r4 = "ie"
            java.lang.String r4 = com.bytedance.sdk.openadsdk.core.model.p.p1699434667886dc(r4)     // Catch:{ Exception -> 0x017f }
            java.lang.String r5 = r8.getCodeId()     // Catch:{ Exception -> 0x017f }
            r1.put(r4, r5)     // Catch:{ Exception -> 0x017f }
            java.lang.String r4 = "aevzt`"
            java.lang.String r4 = com.bytedance.sdk.openadsdk.core.model.p.p1699434667886dc(r4)     // Catch:{ Exception -> 0x017f }
            r1.put(r4, r9)     // Catch:{ Exception -> 0x017f }
            java.lang.String r4 = r8.getAdId()     // Catch:{ Exception -> 0x017f }
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4     // Catch:{ Exception -> 0x017f }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x017f }
            if (r4 == 0) goto L_0x004b
            java.lang.String r4 = r8.getCreativeId()     // Catch:{ Exception -> 0x017f }
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4     // Catch:{ Exception -> 0x017f }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x017f }
            if (r4 == 0) goto L_0x004b
            java.lang.String r4 = r8.getExt()     // Catch:{ Exception -> 0x017f }
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4     // Catch:{ Exception -> 0x017f }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x017f }
            if (r4 != 0) goto L_0x009e
        L_0x004b:
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ Exception -> 0x017f }
            r4.<init>()     // Catch:{ Exception -> 0x017f }
            java.lang.String r5 = r8.getAdId()     // Catch:{ Exception -> 0x017f }
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5     // Catch:{ Exception -> 0x017f }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x017f }
            if (r5 != 0) goto L_0x0069
            java.lang.String r5 = "ae]j`"
            java.lang.String r5 = com.bytedance.sdk.component.f.c.e.e1699434667871dc(r5)     // Catch:{ Exception -> 0x017f }
            java.lang.String r6 = r8.getAdId()     // Catch:{ Exception -> 0x017f }
            r4.put(r5, r6)     // Catch:{ Exception -> 0x017f }
        L_0x0069:
            java.lang.String r5 = r8.getCreativeId()     // Catch:{ Exception -> 0x017f }
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5     // Catch:{ Exception -> 0x017f }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x017f }
            if (r5 != 0) goto L_0x0082
            java.lang.String r5 = "csgbplpbW`n"
            java.lang.String r5 = com.bytedance.sdk.component.f.c.e.e1699434667871dc(r5)     // Catch:{ Exception -> 0x017f }
            java.lang.String r6 = r8.getCreativeId()     // Catch:{ Exception -> 0x017f }
            r4.put(r5, r6)     // Catch:{ Exception -> 0x017f }
        L_0x0082:
            java.lang.String r5 = r8.getExt()     // Catch:{ Exception -> 0x017f }
            if (r5 == 0) goto L_0x0095
            java.lang.String r5 = "eyv"
            java.lang.String r5 = com.bytedance.sdk.component.f.c.e.e1699434667871dc(r5)     // Catch:{ Exception -> 0x017f }
            java.lang.String r6 = r8.getExt()     // Catch:{ Exception -> 0x017f }
            r4.put(r5, r6)     // Catch:{ Exception -> 0x017f }
        L_0x0095:
            java.lang.String r5 = "psgum`qXimy"
            java.lang.String r5 = com.bytedance.sdk.component.f.c.e.e1699434667871dc(r5)     // Catch:{ Exception -> 0x017f }
            r1.put(r5, r4)     // Catch:{ Exception -> 0x017f }
        L_0x009e:
            java.lang.String r4 = "rdlgawYjm}bdh"
            java.lang.String r5 = "abaftqccWzcqi"
            if (r10 == 0) goto L_0x00d5
            java.lang.String r4 = com.bytedance.sdk.component.f.c.e.e1699434667871dc(r4)     // Catch:{ Exception -> 0x017f }
            int r6 = r10.f     // Catch:{ Exception -> 0x017f }
            r1.put(r4, r6)     // Catch:{ Exception -> 0x017f }
            int r4 = r10.f     // Catch:{ Exception -> 0x017f }
            if (r4 != r2) goto L_0x00c1
            java.lang.String r0 = com.bytedance.sdk.component.f.c.e.e1699434667871dc(r5)     // Catch:{ Exception -> 0x017f }
            int r4 = r8.getImgAcceptedWidth()     // Catch:{ Exception -> 0x017f }
        L_0x00b9:
            int r5 = r8.getImgAcceptedHeight()     // Catch:{ Exception -> 0x017f }
            r7.a((org.json.JSONObject) r1, (java.lang.String) r0, (int) r4, (int) r5)     // Catch:{ Exception -> 0x017f }
            goto L_0x00e5
        L_0x00c1:
            int r4 = r10.f     // Catch:{ Exception -> 0x017f }
            if (r4 != r0) goto L_0x00e5
            java.lang.String r0 = com.bytedance.sdk.component.f.c.e.e1699434667871dc(r5)     // Catch:{ Exception -> 0x017f }
            float r4 = r8.getExpressViewAcceptedWidth()     // Catch:{ Exception -> 0x017f }
            float r5 = r8.getExpressViewAcceptedHeight()     // Catch:{ Exception -> 0x017f }
            r7.a((org.json.JSONObject) r1, (java.lang.String) r0, (float) r4, (float) r5)     // Catch:{ Exception -> 0x017f }
            goto L_0x00e5
        L_0x00d5:
            java.lang.String r0 = com.bytedance.sdk.component.f.c.e.e1699434667871dc(r4)     // Catch:{ Exception -> 0x017f }
            r1.put(r0, r2)     // Catch:{ Exception -> 0x017f }
            java.lang.String r0 = com.bytedance.sdk.component.f.c.e.e1699434667871dc(r5)     // Catch:{ Exception -> 0x017f }
            int r4 = r8.getImgAcceptedWidth()     // Catch:{ Exception -> 0x017f }
            goto L_0x00b9
        L_0x00e5:
            java.lang.String r0 = "puro[lbt"
            java.lang.String r0 = com.bytedance.sdk.component.f.c.e.e1699434667871dc(r0)     // Catch:{ Exception -> 0x017f }
            java.lang.String r4 = r8.getCodeId()     // Catch:{ Exception -> 0x017f }
            org.json.JSONArray r4 = b((java.lang.String) r4)     // Catch:{ Exception -> 0x017f }
            r1.put(r0, r4)     // Catch:{ Exception -> 0x017f }
            java.lang.String r0 = "pnq"
            java.lang.String r0 = com.bytedance.sdk.component.f.c.e.e1699434667871dc(r0)     // Catch:{ Exception -> 0x017f }
            int r4 = com.bytedance.sdk.openadsdk.AdSlot.getPosition(r9)     // Catch:{ Exception -> 0x017f }
            r1.put(r0, r4)     // Catch:{ Exception -> 0x017f }
            java.lang.String r0 = "ir]pquvhz}Uo|a"
            java.lang.String r0 = com.bytedance.sdk.component.f.c.e.e1699434667871dc(r0)     // Catch:{ Exception -> 0x017f }
            boolean r4 = r8.isSupportDeepLink()     // Catch:{ Exception -> 0x017f }
            r1.put(r0, r4)     // Catch:{ Exception -> 0x017f }
            int r0 = r8.getNativeAdType()     // Catch:{ Exception -> 0x017f }
            if (r0 > 0) goto L_0x0119
            r0 = 5
            if (r9 != r0) goto L_0x0122
        L_0x0119:
            java.lang.String r0 = "ir]lvlanfVko"
            java.lang.String r0 = com.bytedance.sdk.component.f.c.e.e1699434667871dc(r0)     // Catch:{ Exception -> 0x017f }
            r1.put(r0, r2)     // Catch:{ Exception -> 0x017f }
        L_0x0122:
            int r0 = r8.getAdCount()     // Catch:{ Exception -> 0x017f }
            if (r0 >= r2) goto L_0x0129
            r0 = 1
        L_0x0129:
            if (r0 <= r3) goto L_0x012c
            goto L_0x012d
        L_0x012c:
            r3 = r0
        L_0x012d:
            r0 = 7
            if (r9 == r0) goto L_0x0134
            r0 = 8
            if (r9 != r0) goto L_0x0135
        L_0x0134:
            r3 = 1
        L_0x0135:
            if (r10 == 0) goto L_0x013f
            org.json.JSONArray r10 = r10.e     // Catch:{ Exception -> 0x017f }
            if (r10 == 0) goto L_0x013f
            int r3 = r8.getAdCount()     // Catch:{ Exception -> 0x017f }
        L_0x013f:
            java.lang.String r10 = "ae]`kphs"
            java.lang.String r10 = com.bytedance.sdk.component.f.c.e.e1699434667871dc(r10)     // Catch:{ Exception -> 0x017f }
            r1.put(r10, r3)     // Catch:{ Exception -> 0x017f }
            if (r9 != r2) goto L_0x017f
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ Exception -> 0x017f }
            r9.<init>()     // Catch:{ Exception -> 0x017f }
            java.lang.String r10 = "ir]qkqgsmVhjbck}"
            java.lang.String r10 = com.bytedance.sdk.component.f.c.e.e1699434667871dc(r10)     // Catch:{ Exception -> 0x017f }
            int r0 = r8.getIsRotateBanner()     // Catch:{ Exception -> 0x017f }
            r9.put(r10, r0)     // Catch:{ Exception -> 0x017f }
            java.lang.String r10 = "rnvbp`Ysado"
            java.lang.String r10 = com.bytedance.sdk.component.f.c.e.e1699434667871dc(r10)     // Catch:{ Exception -> 0x017f }
            int r0 = r8.getRotateTime()     // Catch:{ Exception -> 0x017f }
            r9.put(r10, r0)     // Catch:{ Exception -> 0x017f }
            java.lang.String r10 = "rnvbp`Yhzmoy"
            java.lang.String r10 = com.bytedance.sdk.component.f.c.e.e1699434667871dc(r10)     // Catch:{ Exception -> 0x017f }
            int r8 = r8.getRotateOrder()     // Catch:{ Exception -> 0x017f }
            r9.put(r10, r8)     // Catch:{ Exception -> 0x017f }
            java.lang.String r8 = "b`lmaw"
            java.lang.String r8 = com.bytedance.sdk.component.f.c.e.e1699434667871dc(r8)     // Catch:{ Exception -> 0x017f }
            r1.put(r8, r9)     // Catch:{ Exception -> 0x017f }
        L_0x017f:
            return r1
        L_0x0180:
            r1 = 3
            goto L_0x0002
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.q.a(com.bytedance.sdk.openadsdk.AdSlot, int, com.bytedance.sdk.openadsdk.core.model.s):org.json.JSONObject");
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0029  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0039 A[Catch:{ all -> 0x01a7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0093 A[SYNTHETIC, Splitter:B:36:0x0093] */
    @com.bytedance.JProtect
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private org.json.JSONObject a(com.bytedance.sdk.openadsdk.AdSlot r11, com.bytedance.sdk.openadsdk.core.model.s r12, int r13) {
        /*
            r10 = this;
            java.lang.String r0 = "aqr"
            java.lang.String r1 = "5/7-4+?"
            java.lang.String r2 = "ae]p`nYqm{ybcc"
            org.json.JSONObject r3 = new org.json.JSONObject
            r3.<init>()
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ all -> 0x01a7 }
            r4.<init>()     // Catch:{ all -> 0x01a7 }
            if (r12 == 0) goto L_0x0020
            java.lang.String r5 = r12.a     // Catch:{ all -> 0x01a7 }
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5     // Catch:{ all -> 0x01a7 }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x01a7 }
            if (r5 == 0) goto L_0x001d
            goto L_0x0020
        L_0x001d:
            java.lang.String r5 = r12.a     // Catch:{ all -> 0x01a7 }
            goto L_0x0024
        L_0x0020:
            java.lang.String r5 = com.bytedance.sdk.openadsdk.utils.ac.d()     // Catch:{ all -> 0x01a7 }
        L_0x0024:
            r6 = 7
            java.lang.String r7 = "rds\\p|vb"
            if (r13 != r6) goto L_0x0039
            if (r12 == 0) goto L_0x005a
            int r6 = r12.b     // Catch:{ all -> 0x01a7 }
            if (r6 <= 0) goto L_0x005a
            java.lang.String r6 = com.bytedance.sdk.openadsdk.core.g.b.c.b.c$b1699434667869dc(r7)     // Catch:{ all -> 0x01a7 }
            int r7 = r12.b     // Catch:{ all -> 0x01a7 }
        L_0x0035:
            r4.put(r6, r7)     // Catch:{ all -> 0x01a7 }
            goto L_0x005a
        L_0x0039:
            r6 = 8
            if (r13 != r6) goto L_0x004a
            if (r12 == 0) goto L_0x005a
            int r6 = r12.c     // Catch:{ all -> 0x01a7 }
            if (r6 <= 0) goto L_0x005a
            java.lang.String r6 = com.bytedance.sdk.openadsdk.core.g.b.c.b.c$b1699434667869dc(r7)     // Catch:{ all -> 0x01a7 }
            int r7 = r12.c     // Catch:{ all -> 0x01a7 }
            goto L_0x0035
        L_0x004a:
            r6 = 3
            if (r13 != r6) goto L_0x005a
            if (r12 == 0) goto L_0x005a
            int r6 = r12.d     // Catch:{ all -> 0x01a7 }
            if (r6 <= 0) goto L_0x005a
            java.lang.String r6 = com.bytedance.sdk.openadsdk.core.g.b.c.b.c$b1699434667869dc(r7)     // Catch:{ all -> 0x01a7 }
            int r7 = r12.d     // Catch:{ all -> 0x01a7 }
            goto L_0x0035
        L_0x005a:
            com.bytedance.sdk.openadsdk.core.settings.e r6 = com.bytedance.sdk.openadsdk.core.o.d()     // Catch:{ all -> 0x0090 }
            java.lang.String r6 = r6.j()     // Catch:{ all -> 0x0090 }
            com.bytedance.sdk.openadsdk.core.settings.e r7 = com.bytedance.sdk.openadsdk.core.o.d()     // Catch:{ all -> 0x0090 }
            java.lang.String r7 = r7.t()     // Catch:{ all -> 0x0090 }
            if (r6 == 0) goto L_0x0091
            if (r7 == 0) goto L_0x0091
            org.json.JSONObject r8 = new org.json.JSONObject     // Catch:{ all -> 0x0090 }
            r8.<init>()     // Catch:{ all -> 0x0090 }
            java.lang.String r9 = "vdppmjh"
            java.lang.String r9 = com.bytedance.sdk.openadsdk.core.g.b.c.b.c$b1699434667869dc(r9)     // Catch:{ all -> 0x0090 }
            r8.put(r9, r6)     // Catch:{ all -> 0x0090 }
            java.lang.String r6 = "p`pbi"
            java.lang.String r6 = com.bytedance.sdk.openadsdk.core.g.b.c.b.c$b1699434667869dc(r6)     // Catch:{ all -> 0x0090 }
            r8.put(r6, r7)     // Catch:{ all -> 0x0090 }
            java.lang.String r6 = "acvfwq"
            java.lang.String r6 = com.bytedance.sdk.openadsdk.core.g.b.c.b.c$b1699434667869dc(r6)     // Catch:{ all -> 0x0090 }
            r4.put(r6, r8)     // Catch:{ all -> 0x0090 }
            goto L_0x0091
        L_0x0090:
        L_0x0091:
            if (r11 == 0) goto L_0x00d7
            org.json.JSONArray r6 = r11.getBiddingTokens()     // Catch:{ all -> 0x01a7 }
            if (r6 == 0) goto L_0x00d7
            java.lang.String r6 = "bhfgmkaXxhxja"
            java.lang.String r6 = com.bytedance.sdk.openadsdk.core.g.b.c.b.c$b1699434667869dc(r6)     // Catch:{ all -> 0x01a7 }
            org.json.JSONArray r7 = r11.getBiddingTokens()     // Catch:{ all -> 0x01a7 }
            r4.put(r6, r7)     // Catch:{ all -> 0x01a7 }
            com.bytedance.sdk.openadsdk.core.settings.e r6 = com.bytedance.sdk.openadsdk.core.settings.o.ai()     // Catch:{ all -> 0x01a7 }
            java.lang.String r7 = r11.getCodeId()     // Catch:{ all -> 0x01a7 }
            com.bytedance.sdk.openadsdk.core.settings.a r6 = r6.z(r7)     // Catch:{ all -> 0x01a7 }
            java.lang.String r7 = "w`vfvcgkdVco"
            java.lang.String r7 = com.bytedance.sdk.openadsdk.core.g.b.c.b.c$b1699434667869dc(r7)     // Catch:{ all -> 0x01a7 }
            long r8 = r6.L     // Catch:{ all -> 0x01a7 }
            r4.put(r7, r8)     // Catch:{ all -> 0x01a7 }
            java.lang.String r7 = "w`vfvcgkdV|n~~g`~"
            java.lang.String r7 = com.bytedance.sdk.openadsdk.core.g.b.c.b.c$b1699434667869dc(r7)     // Catch:{ all -> 0x01a7 }
            java.lang.String r6 = r6.M     // Catch:{ all -> 0x01a7 }
            r4.put(r7, r6)     // Catch:{ all -> 0x01a7 }
            java.lang.String r6 = "lhlh[lb"
            java.lang.String r6 = com.bytedance.sdk.openadsdk.core.g.b.c.b.c$b1699434667869dc(r6)     // Catch:{ all -> 0x01a7 }
            java.lang.String r7 = r11.getLinkId()     // Catch:{ all -> 0x01a7 }
            r4.put(r6, r7)     // Catch:{ all -> 0x01a7 }
        L_0x00d7:
            java.lang.String r6 = "rdsvavrXam"
            java.lang.String r6 = com.bytedance.sdk.openadsdk.core.g.b.c.b.c$b1699434667869dc(r6)     // Catch:{ all -> 0x01a7 }
            r4.put(r6, r5)     // Catch:{ all -> 0x01a7 }
            java.lang.String r6 = com.bytedance.sdk.openadsdk.core.g.b.c.b.c$b1699434667869dc(r2)     // Catch:{ all -> 0x01a7 }
            java.lang.String r7 = com.bytedance.sdk.openadsdk.core.g.b.c.b.c$b1699434667869dc(r1)     // Catch:{ all -> 0x01a7 }
            r4.put(r6, r7)     // Catch:{ all -> 0x01a7 }
            java.lang.String r6 = "snwqg`Ysqyo"
            java.lang.String r6 = com.bytedance.sdk.openadsdk.core.g.b.c.b.c$b1699434667869dc(r6)     // Catch:{ all -> 0x01a7 }
            java.lang.String r7 = com.bytedance.sdk.openadsdk.core.g.b.c.b.c$b1699434667869dc(r0)     // Catch:{ all -> 0x01a7 }
            r4.put(r6, r7)     // Catch:{ all -> 0x01a7 }
            java.lang.String r0 = com.bytedance.sdk.openadsdk.core.g.b.c.b.c$b1699434667869dc(r0)     // Catch:{ all -> 0x01a7 }
            org.json.JSONObject r6 = r10.c()     // Catch:{ all -> 0x01a7 }
            r4.put(r0, r6)     // Catch:{ all -> 0x01a7 }
            android.content.Context r0 = r10.a     // Catch:{ all -> 0x01a7 }
            r6 = 1
            org.json.JSONObject r0 = com.bytedance.sdk.openadsdk.utils.DeviceUtils.a(r0, r6)     // Catch:{ all -> 0x01a7 }
            java.lang.String r7 = "ddtjg`"
            java.lang.String r7 = com.bytedance.sdk.openadsdk.core.g.b.c.b.c$b1699434667869dc(r7)     // Catch:{ all -> 0x01a7 }
            r4.put(r7, r0)     // Catch:{ all -> 0x01a7 }
            java.lang.String r0 = "urgq"
            java.lang.String r0 = com.bytedance.sdk.openadsdk.core.g.b.c.b.c$b1699434667869dc(r0)     // Catch:{ all -> 0x01a7 }
            org.json.JSONObject r7 = a((com.bytedance.sdk.openadsdk.AdSlot) r11)     // Catch:{ all -> 0x01a7 }
            r4.put(r0, r7)     // Catch:{ all -> 0x01a7 }
            java.lang.String r0 = "u`"
            java.lang.String r0 = com.bytedance.sdk.openadsdk.core.g.b.c.b.c$b1699434667869dc(r0)     // Catch:{ all -> 0x01a7 }
            java.lang.String r7 = com.bytedance.sdk.openadsdk.utils.ac.c()     // Catch:{ all -> 0x01a7 }
            r4.put(r0, r7)     // Catch:{ all -> 0x01a7 }
            java.lang.String r0 = "cicmj`j"
            java.lang.String r0 = com.bytedance.sdk.openadsdk.core.g.b.c.b.c$b1699434667869dc(r0)     // Catch:{ all -> 0x01a7 }
            java.lang.String r7 = "m`km"
            java.lang.String r7 = com.bytedance.sdk.openadsdk.core.g.b.c.b.c$b1699434667869dc(r7)     // Catch:{ all -> 0x01a7 }
            r4.put(r0, r7)     // Catch:{ all -> 0x01a7 }
            org.json.JSONArray r0 = new org.json.JSONArray     // Catch:{ all -> 0x01a7 }
            r0.<init>()     // Catch:{ all -> 0x01a7 }
            org.json.JSONObject r13 = r10.a((com.bytedance.sdk.openadsdk.AdSlot) r11, (int) r13, (com.bytedance.sdk.openadsdk.core.model.s) r12)     // Catch:{ all -> 0x01a7 }
            r0.put(r13)     // Catch:{ all -> 0x01a7 }
            java.lang.String r13 = "aeqokqu"
            java.lang.String r13 = com.bytedance.sdk.openadsdk.core.g.b.c.b.c$b1699434667869dc(r13)     // Catch:{ all -> 0x01a7 }
            r4.put(r13, r0)     // Catch:{ all -> 0x01a7 }
            r10.a((org.json.JSONObject) r4, (com.bytedance.sdk.openadsdk.core.model.s) r12)     // Catch:{ all -> 0x01a7 }
            long r12 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x01a7 }
            r7 = 1000(0x3e8, double:4.94E-321)
            long r12 = r12 / r7
            java.lang.String r0 = "tr"
            java.lang.String r0 = com.bytedance.sdk.openadsdk.core.g.b.c.b.c$b1699434667869dc(r0)     // Catch:{ all -> 0x01a7 }
            r4.put(r0, r12)     // Catch:{ all -> 0x01a7 }
            java.lang.String r0 = ""
            java.lang.String r7 = r11.getCodeId()     // Catch:{ all -> 0x01a7 }
            if (r7 == 0) goto L_0x0182
            if (r5 == 0) goto L_0x0182
            java.lang.String r12 = java.lang.String.valueOf(r12)     // Catch:{ all -> 0x01a7 }
            java.lang.String r11 = r11.getCodeId()     // Catch:{ all -> 0x01a7 }
            java.lang.String r11 = r12.concat(r11)     // Catch:{ all -> 0x01a7 }
            java.lang.String r0 = r11.concat(r5)     // Catch:{ all -> 0x01a7 }
        L_0x0182:
            java.lang.String r11 = "rds\\wlai"
            java.lang.String r11 = com.bytedance.sdk.openadsdk.core.g.b.c.b.c$b1699434667869dc(r11)     // Catch:{ all -> 0x01a7 }
            java.lang.String r12 = com.bytedance.sdk.component.utils.e.a((java.lang.String) r0)     // Catch:{ all -> 0x01a7 }
            r4.put(r11, r12)     // Catch:{ all -> 0x01a7 }
            org.json.JSONObject r3 = com.bytedance.sdk.component.utils.a.a((org.json.JSONObject) r4)     // Catch:{ all -> 0x01a7 }
            java.lang.String r11 = com.bytedance.sdk.openadsdk.core.g.b.c.b.c$b1699434667869dc(r2)     // Catch:{ all -> 0x01a7 }
            java.lang.String r12 = com.bytedance.sdk.openadsdk.core.g.b.c.b.c$b1699434667869dc(r1)     // Catch:{ all -> 0x01a7 }
            r3.put(r11, r12)     // Catch:{ all -> 0x01a7 }
            java.lang.String r11 = "owgqw`gX~lxxeb`Pdhbv"
            java.lang.String r11 = com.bytedance.sdk.openadsdk.core.g.b.c.b.c$b1699434667869dc(r11)     // Catch:{ all -> 0x01a7 }
            r3.put(r11, r6)     // Catch:{ all -> 0x01a7 }
        L_0x01a7:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.q.a(com.bytedance.sdk.openadsdk.AdSlot, com.bytedance.sdk.openadsdk.core.model.s, int):org.json.JSONObject");
    }

    /* access modifiers changed from: private */
    public void a(long j, String str, int i, a aVar, int i2, String str2) {
    }

    private void a(AdSlot adSlot, s sVar, d dVar, Map<String, Object> map, boolean z, ab abVar, p.a aVar) {
        final boolean z2 = z;
        final Map<String, Object> map2 = map;
        final ab abVar2 = abVar;
        final p.a aVar2 = aVar;
        final AdSlot adSlot2 = adSlot;
        final s sVar2 = sVar;
        d dVar2 = dVar;
        dVar.a((com.bytedance.sdk.component.f.a.a) new com.bytedance.sdk.component.f.a.a() {
            /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
                	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
                	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
                */
            /* JADX WARNING: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
            /* JADX WARNING: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
            public void a(com.bytedance.sdk.component.f.b.c r4, com.bytedance.sdk.component.f.b r5) {
                /*
                    r3 = this;
                    boolean r4 = r2
                    if (r4 == 0) goto L_0x0011
                    java.util.Map r4 = r3
                    java.lang.String r0 = "pfcg[`hc"
                    java.lang.String r0 = com.bytedance.sdk.openadsdk.core.model.k.k1699434667889dc(r0)
                    com.bytedance.sdk.openadsdk.utils.ab r1 = r4
                    r4.put(r0, r1)
                L_0x0011:
                    if (r5 == 0) goto L_0x00de
                    boolean r4 = r5.f()
                    if (r4 == 0) goto L_0x00de
                    r4 = -1
                    org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ all -> 0x00c5 }
                    java.lang.String r5 = r5.d()     // Catch:{ all -> 0x00c5 }
                    r0.<init>(r5)     // Catch:{ all -> 0x00c5 }
                    com.bytedance.sdk.openadsdk.core.settings.e r5 = com.bytedance.sdk.openadsdk.core.o.d()     // Catch:{ all -> 0x00c5 }
                    boolean r5 = r5.U()     // Catch:{ all -> 0x00c5 }
                    if (r5 == 0) goto L_0x004b
                    com.bytedance.sdk.openadsdk.core.u r5 = com.bytedance.sdk.openadsdk.core.v.a()     // Catch:{ all -> 0x00c5 }
                    int r5 = r5.g()     // Catch:{ all -> 0x00c5 }
                    r1 = 1
                    if (r5 != r1) goto L_0x004b
                    java.lang.String r5 = r0.toString()     // Catch:{ all -> 0x00c5 }
                    java.lang.String r1 = "P`ldh`YCmklS@aku"
                    java.lang.String r1 = com.bytedance.sdk.openadsdk.core.model.k.k1699434667889dc(r1)     // Catch:{ all -> 0x00c5 }
                    com.bytedance.sdk.openadsdk.core.q r2 = com.bytedance.sdk.openadsdk.core.q.this     // Catch:{ all -> 0x00c5 }
                    android.content.Context r2 = r2.a     // Catch:{ all -> 0x00c5 }
                    com.bytedance.sdk.openadsdk.utils.ac.a((java.lang.String) r1, (java.lang.String) r5, (android.content.Context) r2)     // Catch:{ all -> 0x00c5 }
                L_0x004b:
                    com.bytedance.sdk.openadsdk.core.q r5 = com.bytedance.sdk.openadsdk.core.q.this     // Catch:{ all -> 0x00c5 }
                    org.json.JSONObject r5 = r5.b((org.json.JSONObject) r0)     // Catch:{ all -> 0x00c5 }
                    if (r5 != 0) goto L_0x005d
                    com.bytedance.sdk.openadsdk.core.p$a r5 = r5     // Catch:{ all -> 0x00c5 }
                    java.lang.String r0 = com.bytedance.sdk.openadsdk.core.g.a(r4)     // Catch:{ all -> 0x00c5 }
                    r5.a((int) r4, (java.lang.String) r0)     // Catch:{ all -> 0x00c5 }
                    goto L_0x00c4
                L_0x005d:
                    com.bytedance.sdk.openadsdk.AdSlot r0 = r6     // Catch:{ all -> 0x00c5 }
                    com.bytedance.sdk.openadsdk.core.model.s r1 = r7     // Catch:{ all -> 0x00c5 }
                    com.bytedance.sdk.openadsdk.core.q$a r0 = com.bytedance.sdk.openadsdk.core.q.a.a(r5, r0, r1)     // Catch:{ all -> 0x00c5 }
                    int r1 = r0.d     // Catch:{ all -> 0x00c5 }
                    r2 = 20000(0x4e20, float:2.8026E-41)
                    if (r1 == r2) goto L_0x0094
                    com.bytedance.sdk.openadsdk.core.settings.e r5 = com.bytedance.sdk.openadsdk.core.o.d()     // Catch:{ all -> 0x00c5 }
                    boolean r5 = r5.F()     // Catch:{ all -> 0x00c5 }
                    if (r5 != 0) goto L_0x008a
                    int r5 = r0.d     // Catch:{ all -> 0x00c5 }
                    r1 = 40029(0x9c5d, float:5.6093E-41)
                    if (r5 != r1) goto L_0x008a
                    com.bytedance.sdk.openadsdk.core.p$a r5 = r5     // Catch:{ all -> 0x00c5 }
                    r0 = -100
                    java.lang.String r1 = com.bytedance.sdk.openadsdk.core.g.a(r0)     // Catch:{ all -> 0x00c5 }
                    r5.a((int) r0, (java.lang.String) r1)     // Catch:{ all -> 0x00c5 }
                    r4 = 67
                    goto L_0x00c0
                L_0x008a:
                    com.bytedance.sdk.openadsdk.core.p$a r5 = r5     // Catch:{ all -> 0x00c5 }
                    int r1 = r0.d     // Catch:{ all -> 0x00c5 }
                    java.lang.String r0 = r0.e     // Catch:{ all -> 0x00c5 }
                    r5.a((int) r1, (java.lang.String) r0)     // Catch:{ all -> 0x00c5 }
                    goto L_0x00c4
                L_0x0094:
                    com.bytedance.sdk.openadsdk.core.model.a r1 = r0.h     // Catch:{ all -> 0x00c5 }
                    if (r1 != 0) goto L_0x00a2
                    com.bytedance.sdk.openadsdk.core.p$a r5 = r5     // Catch:{ all -> 0x00c5 }
                    java.lang.String r0 = com.bytedance.sdk.openadsdk.core.g.a(r4)     // Catch:{ all -> 0x00c5 }
                    r5.a((int) r4, (java.lang.String) r0)     // Catch:{ all -> 0x00c5 }
                    return
                L_0x00a2:
                    com.bytedance.sdk.openadsdk.core.model.a r1 = r0.h     // Catch:{ all -> 0x00c5 }
                    java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x00c5 }
                    r1.c(r5)     // Catch:{ all -> 0x00c5 }
                    com.bytedance.sdk.openadsdk.core.p$a r5 = r5     // Catch:{ all -> 0x00c5 }
                    com.bytedance.sdk.openadsdk.core.model.a r1 = r0.h     // Catch:{ all -> 0x00c5 }
                    com.bytedance.sdk.openadsdk.core.model.b r2 = new com.bytedance.sdk.openadsdk.core.model.b     // Catch:{ all -> 0x00c5 }
                    r2.<init>()     // Catch:{ all -> 0x00c5 }
                    r5.a((com.bytedance.sdk.openadsdk.core.model.a) r1, (com.bytedance.sdk.openadsdk.core.model.b) r2)     // Catch:{ all -> 0x00c5 }
                    com.bytedance.sdk.openadsdk.core.q r5 = com.bytedance.sdk.openadsdk.core.q.this     // Catch:{ all -> 0x00c5 }
                    com.bytedance.sdk.openadsdk.core.model.a r0 = r0.h     // Catch:{ all -> 0x00c5 }
                    r5.a((com.bytedance.sdk.openadsdk.core.model.a) r0)     // Catch:{ all -> 0x00c5 }
                L_0x00be:
                    r4 = 66
                L_0x00c0:
                    switch(r4) {
                        case 65: goto L_0x00c4;
                        case 66: goto L_0x00de;
                        case 67: goto L_0x00c4;
                        default: goto L_0x00c3;
                    }
                L_0x00c3:
                    goto L_0x00be
                L_0x00c4:
                    return
                L_0x00c5:
                    r5 = move-exception
                    java.lang.String r0 = "NdvBtlOjxe"
                    java.lang.String r0 = com.bytedance.sdk.openadsdk.core.model.k.k1699434667889dc(r0)
                    java.lang.String r1 = "gdv#ea&bz{ey6-"
                    java.lang.String r1 = com.bytedance.sdk.openadsdk.core.model.k.k1699434667889dc(r1)
                    com.bytedance.sdk.component.utils.l.c(r0, r1, r5)
                    com.bytedance.sdk.openadsdk.core.p$a r5 = r5
                    java.lang.String r0 = com.bytedance.sdk.openadsdk.core.g.a(r4)
                    r5.a((int) r4, (java.lang.String) r0)
                L_0x00de:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.q.AnonymousClass3.a(com.bytedance.sdk.component.f.b.c, com.bytedance.sdk.component.f.b):void");
            }

            /* JADX WARNING: Code restructure failed: missing block: B:18:0x0063, code lost:
                switch(r6) {
                    case 37: goto L_0x0067;
                    case 38: goto L_0x0072;
                    case 39: goto L_0x0077;
                    default: goto L_0x0066;
                };
             */
            /* JADX WARNING: Code restructure failed: missing block: B:19:0x0067, code lost:
                switch(r0) {
                    case 25: goto L_0x0076;
                    case 26: goto L_0x0077;
                    case 27: goto L_0x005b;
                    default: goto L_0x006a;
                };
             */
            /* JADX WARNING: Code restructure failed: missing block: B:20:0x006a, code lost:
                r0 = 27;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:21:0x006d, code lost:
                r6 = '\'';
             */
            /* JADX WARNING: Code restructure failed: missing block: B:23:0x0072, code lost:
                if (r0 <= '=') goto L_0x0077;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:32:0x0077, code lost:
                continue;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
                return;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
                return;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void a(com.bytedance.sdk.component.f.b.c r5, java.io.IOException r6) {
                /*
                    r4 = this;
                    com.bytedance.sdk.openadsdk.utils.ab r5 = com.bytedance.sdk.openadsdk.utils.ab.a()
                    boolean r0 = r2
                    if (r0 == 0) goto L_0x0019
                    java.util.Map r0 = r3
                    java.lang.String r1 = "pfcg[`hc"
                    java.lang.String r1 = com.bykv.vk.openvk.component.video.api.c.b.b1699434667889dc(r1)
                    long r2 = r5.a
                    java.lang.Long r5 = java.lang.Long.valueOf(r2)
                    r0.put(r1, r5)
                L_0x0019:
                    com.bytedance.sdk.openadsdk.core.settings.e r5 = com.bytedance.sdk.openadsdk.core.o.d()
                    boolean r5 = r5.U()
                    if (r5 == 0) goto L_0x0045
                    com.bytedance.sdk.openadsdk.core.u r5 = com.bytedance.sdk.openadsdk.core.v.a()
                    int r5 = r5.g()
                    r0 = 1
                    if (r5 != r0) goto L_0x0045
                    if (r6 == 0) goto L_0x0035
                    java.lang.String r5 = r6.getMessage()
                    goto L_0x0036
                L_0x0035:
                    r5 = 0
                L_0x0036:
                    java.lang.String r0 = "P`ldh`YCmklS@aku"
                    java.lang.String r0 = com.bykv.vk.openvk.component.video.api.c.b.b1699434667889dc(r0)
                    com.bytedance.sdk.openadsdk.core.q r1 = com.bytedance.sdk.openadsdk.core.q.this
                    android.content.Context r1 = r1.a
                    com.bytedance.sdk.openadsdk.utils.ac.a((java.lang.String) r0, (java.lang.String) r5, (android.content.Context) r1)
                L_0x0045:
                    if (r6 == 0) goto L_0x004c
                    java.lang.String r5 = r6.getMessage()
                    goto L_0x004e
                L_0x004c:
                    java.lang.String r5 = ""
                L_0x004e:
                    com.bytedance.sdk.openadsdk.core.p$a r6 = r5
                    r0 = 601(0x259, float:8.42E-43)
                    r6.a((int) r0, (java.lang.String) r5)
                    r5 = 61
                    r6 = 29
                    r0 = 61
                L_0x005b:
                    r1 = 84
                L_0x005d:
                    r2 = 27
                    switch(r1) {
                        case 84: goto L_0x0077;
                        case 85: goto L_0x0070;
                        case 86: goto L_0x0063;
                        default: goto L_0x0062;
                    }
                L_0x0062:
                    goto L_0x005b
                L_0x0063:
                    switch(r6) {
                        case 37: goto L_0x0067;
                        case 38: goto L_0x0072;
                        case 39: goto L_0x0077;
                        default: goto L_0x0066;
                    }
                L_0x0066:
                    goto L_0x006d
                L_0x0067:
                    switch(r0) {
                        case 25: goto L_0x0076;
                        case 26: goto L_0x0077;
                        case 27: goto L_0x005b;
                        default: goto L_0x006a;
                    }
                L_0x006a:
                    r0 = 27
                    goto L_0x0067
                L_0x006d:
                    r6 = 39
                    goto L_0x0063
                L_0x0070:
                    if (r6 >= r2) goto L_0x0076
                L_0x0072:
                    if (r0 <= r5) goto L_0x0077
                L_0x0074:
                    goto L_0x0074
                L_0x0076:
                    return
                L_0x0077:
                    r1 = 85
                    r6 = 93
                    goto L_0x005d
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.q.AnonymousClass3.a(com.bytedance.sdk.component.f.b.c, java.io.IOException):void");
            }
        });
    }

    /* access modifiers changed from: private */
    public void a(com.bytedance.sdk.openadsdk.core.model.a aVar) {
        List<com.bytedance.sdk.openadsdk.core.model.q> c = aVar.c();
        if (c != null && c.size() != 0) {
            for (int i = 0; i < c.size(); i++) {
                com.bytedance.sdk.openadsdk.core.model.q qVar = c.get(i);
                if (qVar != null && qVar.j() == null) {
                    com.bytedance.sdk.openadsdk.core.model.q qVar2 = qVar;
                    a("", 0, 0, qVar.N(), qVar2);
                    a("", 0, 0, qVar.O(), qVar2);
                    List<n> Q = qVar.Q();
                    if (Q != null && Q.size() > 0) {
                        for (int i2 = 0; i2 < Q.size(); i2++) {
                            a(qVar, Q.get(i2));
                        }
                    }
                    if (qVar.K() != null) {
                        a(qVar.K().j(), qVar.K().c(), qVar.K().b(), (n) null, qVar);
                    }
                }
            }
        }
    }

    private void a(com.bytedance.sdk.openadsdk.core.model.q qVar, n nVar) {
        l.c(e.e1699434667871dc("ile@efnb"), e.e1699434667871dc("lncgMhaFfmXn|b|{*1"));
        if (nVar != null) {
            com.bytedance.sdk.openadsdk.f.d.a(nVar).a(u.BITMAP).a(new com.bytedance.sdk.openadsdk.f.b(qVar, nVar.a(), new o() {
                public void a(int i, String str, Throwable th) {
                    l.c(i.i1699434667884dc("ile@efnb"), i.i1699434667884dc("lncgMhaFfmXn|b|{*1tr}y"));
                }

                public void a(k kVar) {
                    l.c(i.i1699434667884dc("ile@efnb"), i.i1699434667884dc("lncgMhaFfmXn|b|{*1afwvsdk"));
                }
            }), t.IO);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x009a, code lost:
        switch(r8) {
            case 18: goto L_0x009e;
            case 19: goto L_0x009a;
            case 20: goto L_0x00a3;
            default: goto L_0x009d;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.bytedance.sdk.openadsdk.core.model.s r7, com.bytedance.sdk.openadsdk.utils.ab r8, com.bytedance.sdk.openadsdk.utils.ab r9, int r10, com.bytedance.sdk.openadsdk.utils.ab r11, com.bytedance.sdk.openadsdk.core.model.q r12, java.lang.String r13, boolean r14) {
        /*
            r6 = this;
            com.bytedance.sdk.openadsdk.core.settings.e r0 = com.bytedance.sdk.openadsdk.core.o.d()
            boolean r0 = r0.W()
            if (r0 != 0) goto L_0x000b
            return
        L_0x000b:
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            r1 = 0
            if (r7 == 0) goto L_0x0031
            com.bytedance.sdk.openadsdk.utils.ab r3 = r7.g     // Catch:{ Exception -> 0x00a3 }
            long r3 = r3.a     // Catch:{ Exception -> 0x00a3 }
            int r5 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r5 <= 0) goto L_0x0031
            java.lang.String r1 = "cmkfjqYt|hxSygbu"
            java.lang.String r1 = com.bykv.vk.openvk.component.video.api.c.b.b1699434667889dc(r1)     // Catch:{ Exception -> 0x00a3 }
            com.bytedance.sdk.openadsdk.utils.ab r2 = r7.g     // Catch:{ Exception -> 0x00a3 }
            long r2 = r8.a(r2)     // Catch:{ Exception -> 0x00a3 }
            r0.put(r1, r2)     // Catch:{ Exception -> 0x00a3 }
            com.bytedance.sdk.openadsdk.utils.ab r7 = r7.g     // Catch:{ Exception -> 0x00a3 }
            long r1 = r11.a(r7)     // Catch:{ Exception -> 0x00a3 }
        L_0x0031:
            java.lang.String r7 = "ndvtkwmX|`gn"
            java.lang.String r7 = com.bykv.vk.openvk.component.video.api.c.b.b1699434667889dc(r7)     // Catch:{ Exception -> 0x00a3 }
            long r3 = r9.a(r8)     // Catch:{ Exception -> 0x00a3 }
            r0.put(r7, r3)     // Catch:{ Exception -> 0x00a3 }
            java.lang.String r7 = "sdtfvZrnel"
            java.lang.String r7 = com.bykv.vk.openvk.component.video.api.c.b.b1699434667889dc(r7)     // Catch:{ Exception -> 0x00a3 }
            r0.put(r7, r10)     // Catch:{ Exception -> 0x00a3 }
            java.lang.String r7 = "cmkfjqYbfmUe`k"
            java.lang.String r7 = com.bykv.vk.openvk.component.video.api.c.b.b1699434667889dc(r7)     // Catch:{ Exception -> 0x00a3 }
            long r8 = r11.a(r9)     // Catch:{ Exception -> 0x00a3 }
            r0.put(r7, r8)     // Catch:{ Exception -> 0x00a3 }
            r7 = 1
            if (r14 == 0) goto L_0x0060
            java.lang.String r8 = "ir]`ljitmVko"
            java.lang.String r8 = com.bykv.vk.openvk.component.video.api.c.b.b1699434667889dc(r8)     // Catch:{ Exception -> 0x00a3 }
            r0.put(r8, r7)     // Catch:{ Exception -> 0x00a3 }
        L_0x0060:
            java.lang.String r8 = "oqgm[db"
            java.lang.String r8 = com.bykv.vk.openvk.component.video.api.c.b.b1699434667889dc(r8)     // Catch:{ Exception -> 0x00a3 }
            boolean r8 = r13.equals(r8)     // Catch:{ Exception -> 0x00a3 }
            if (r8 == 0) goto L_0x007d
            java.lang.String r8 = "ir]jgjhXggfr"
            java.lang.String r8 = com.bykv.vk.openvk.component.video.api.c.b.b1699434667889dc(r8)     // Catch:{ Exception -> 0x00a3 }
            boolean r9 = r12.br()     // Catch:{ Exception -> 0x00a3 }
            if (r9 == 0) goto L_0x0079
            goto L_0x007a
        L_0x0079:
            r7 = 0
        L_0x007a:
            r0.put(r8, r7)     // Catch:{ Exception -> 0x00a3 }
        L_0x007d:
            java.lang.String r7 = "lncg[dbX|`gn"
            java.lang.String r9 = com.bykv.vk.openvk.component.video.api.c.b.b1699434667889dc(r7)     // Catch:{ Exception -> 0x00a3 }
            r7 = r12
            r8 = r13
            r10 = r1
            r12 = r0
            com.bytedance.sdk.openadsdk.b.c.a((com.bytedance.sdk.openadsdk.core.model.q) r7, (java.lang.String) r8, (java.lang.String) r9, (long) r10, (org.json.JSONObject) r12)     // Catch:{ Exception -> 0x00a3 }
        L_0x008a:
            r7 = 8
        L_0x008c:
            switch(r7) {
                case 8: goto L_0x0090;
                case 9: goto L_0x0090;
                case 10: goto L_0x00a3;
                default: goto L_0x008f;
            }
        L_0x008f:
            goto L_0x008a
        L_0x0090:
            r7 = 78
            r8 = 18
        L_0x0094:
            switch(r7) {
                case 78: goto L_0x009a;
                case 79: goto L_0x008a;
                case 80: goto L_0x0098;
                default: goto L_0x0097;
            }
        L_0x0097:
            goto L_0x009e
        L_0x0098:
            r7 = r8
            goto L_0x008c
        L_0x009a:
            switch(r8) {
                case 18: goto L_0x009e;
                case 19: goto L_0x009a;
                case 20: goto L_0x00a3;
                default: goto L_0x009d;
            }
        L_0x009d:
            goto L_0x008a
        L_0x009e:
            r7 = 80
            r8 = 10
            goto L_0x0094
        L_0x00a3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.q.a(com.bytedance.sdk.openadsdk.core.model.s, com.bytedance.sdk.openadsdk.utils.ab, com.bytedance.sdk.openadsdk.utils.ab, int, com.bytedance.sdk.openadsdk.utils.ab, com.bytedance.sdk.openadsdk.core.model.q, java.lang.String, boolean):void");
    }

    /* access modifiers changed from: private */
    public void a(p.a aVar, com.bytedance.sdk.openadsdk.core.model.b bVar) {
        aVar.a(-1, g.a(-1));
        bVar.a(-1);
        com.bytedance.sdk.openadsdk.core.model.b.a(bVar);
    }

    /* access modifiers changed from: private */
    public void a(p.b bVar) {
        bVar.a(-1, g.a(-1));
    }

    private void a(String str, int i, int i2, n nVar, com.bytedance.sdk.openadsdk.core.model.q qVar) {
        if (!TextUtils.isEmpty(str)) {
            com.bytedance.sdk.openadsdk.f.d.a(str).a(i).b(i2).d(ad.d(o.a())).c(ad.c(o.a())).a(u.BITMAP).a(new com.bytedance.sdk.openadsdk.f.b(qVar, str, (o) null), t.IO);
        } else if (nVar != null) {
            com.bytedance.sdk.openadsdk.f.d.a(nVar).a(u.BITMAP).a(new com.bytedance.sdk.openadsdk.f.b(qVar, nVar.a(), (o) null), t.IO);
        }
    }

    private void a(Map<String, String> map, d dVar) {
        if (map != null) {
            for (Map.Entry next : map.entrySet()) {
                try {
                    dVar.b((String) next.getKey(), (String) next.getValue());
                } catch (Exception e) {
                    l.d(com.bytedance.sdk.component.f.c.d.d1699434667873dc("NdvBtlOjxe"), com.bytedance.sdk.component.f.c.d.d1699434667873dc("AEF#l`gcm{*ntnkd~b}"), e.getMessage());
                }
            }
        }
        try {
            dVar.b(com.bytedance.sdk.component.f.c.d.d1699434667873dc("Urgq)Dabf}"), ac.c());
        } catch (Exception e2) {
            l.d(com.bytedance.sdk.component.f.c.d.d1699434667873dc("NdvBtlOjxe"), com.bytedance.sdk.component.f.c.d.d1699434667873dc("AEF#l`gcm{*ntnkd~b}"), e2.getMessage());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0022, code lost:
        r2 = 'J';
        r3 = '7';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001e, code lost:
        switch(r3) {
            case 55: goto L_0x002a;
            case 56: goto L_0x002a;
            case 57: goto L_0x0022;
            default: goto L_0x0021;
        };
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(org.json.JSONObject r2, com.bytedance.sdk.openadsdk.core.model.s r3) {
        /*
            r1 = this;
            if (r3 == 0) goto L_0x002a
            org.json.JSONArray r0 = r3.e
            if (r0 != 0) goto L_0x0007
            goto L_0x002a
        L_0x0007:
            java.lang.String r0 = "snwqg`YsmdkbS}|`tdqgK|rd"
            java.lang.String r0 = com.bytedance.sdk.openadsdk.core.model.i.i1699434667884dc(r0)     // Catch:{ Exception -> 0x002a }
            org.json.JSONArray r3 = r3.e     // Catch:{ Exception -> 0x002a }
            r2.put(r0, r3)     // Catch:{ Exception -> 0x002a }
        L_0x0013:
            r2 = 73
            r3 = 96
        L_0x0017:
            switch(r2) {
                case 72: goto L_0x0022;
                case 73: goto L_0x001b;
                case 74: goto L_0x001e;
                default: goto L_0x001a;
            }
        L_0x001a:
            goto L_0x0027
        L_0x001b:
            switch(r3) {
                case 94: goto L_0x0013;
                case 95: goto L_0x0022;
                case 96: goto L_0x0022;
                default: goto L_0x001e;
            }
        L_0x001e:
            switch(r3) {
                case 55: goto L_0x002a;
                case 56: goto L_0x002a;
                case 57: goto L_0x0022;
                default: goto L_0x0021;
            }
        L_0x0021:
            goto L_0x0013
        L_0x0022:
            r2 = 74
            r3 = 55
            goto L_0x0017
        L_0x0027:
            r2 = 72
            goto L_0x0017
        L_0x002a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.q.a(org.json.JSONObject, com.bytedance.sdk.openadsdk.core.model.s):void");
    }

    private void a(JSONObject jSONObject, String str, float f, float f2) {
        if (f >= 0.0f && f2 >= 0.0f) {
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            try {
                jSONObject2.put(com.bytedance.sdk.component.f.c.d.d1699434667873dc("whfwl"), (int) f);
                jSONObject2.put(com.bytedance.sdk.component.f.c.d.d1699434667873dc("hdkdlq"), (int) f2);
                jSONArray.put(jSONObject2);
                jSONObject.put(str, jSONArray);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0037, code lost:
        r4 = 30;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0030, code lost:
        switch(r5) {
            case 52: goto L_0x002a;
            case 53: goto L_0x0034;
            case 54: goto L_0x003f;
            default: goto L_0x0033;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0034, code lost:
        switch(r4) {
            case 29: goto L_0x002a;
            case 30: goto L_0x002a;
            case 31: goto L_0x0030;
            default: goto L_0x0037;
        };
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(org.json.JSONObject r4, java.lang.String r5, int r6, int r7) {
        /*
            r3 = this;
            if (r6 <= 0) goto L_0x0044
            if (r7 <= 0) goto L_0x0044
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            org.json.JSONArray r1 = new org.json.JSONArray
            r1.<init>()
            java.lang.String r2 = "whfwl"
            java.lang.String r2 = com.bykv.vk.openvk.component.video.api.c.b.b1699434667889dc(r2)     // Catch:{ Exception -> 0x0044 }
            r0.put(r2, r6)     // Catch:{ Exception -> 0x0044 }
            java.lang.String r6 = "hdkdlq"
            java.lang.String r6 = com.bykv.vk.openvk.component.video.api.c.b.b1699434667889dc(r6)     // Catch:{ Exception -> 0x0044 }
            r0.put(r6, r7)     // Catch:{ Exception -> 0x0044 }
            r1.put(r0)     // Catch:{ Exception -> 0x0044 }
            r4.put(r5, r1)     // Catch:{ Exception -> 0x0044 }
            r4 = 55
            r5 = 0
        L_0x002a:
            r6 = 72
        L_0x002c:
            switch(r6) {
                case 72: goto L_0x003f;
                case 73: goto L_0x003a;
                case 74: goto L_0x0030;
                default: goto L_0x002f;
            }
        L_0x002f:
            goto L_0x002a
        L_0x0030:
            switch(r5) {
                case 52: goto L_0x002a;
                case 53: goto L_0x0034;
                case 54: goto L_0x003f;
                default: goto L_0x0033;
            }
        L_0x0033:
            goto L_0x003f
        L_0x0034:
            switch(r4) {
                case 29: goto L_0x002a;
                case 30: goto L_0x002a;
                case 31: goto L_0x0030;
                default: goto L_0x0037;
            }
        L_0x0037:
            r4 = 30
            goto L_0x0034
        L_0x003a:
            r6 = 57
            if (r5 > r6) goto L_0x003f
            goto L_0x0044
        L_0x003f:
            r6 = 73
            r5 = 16
            goto L_0x002c
        L_0x0044:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.q.a(org.json.JSONObject, java.lang.String, int, int):void");
    }

    private static void a(JSONObject jSONObject, String str, String str2) throws JSONException {
        if (!TextUtils.isEmpty(str2)) {
            jSONObject.put(str, str2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x007b, code lost:
        if (c(r8) == false) goto L_0x009b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0097, code lost:
        if (c(r8) == false) goto L_0x009b;
     */
    @com.bytedance.JProtect
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(org.json.JSONObject r7, boolean r8) {
        /*
            r6 = this;
            java.lang.String r0 = "NdvBtlOjxe"
            com.bytedance.sdk.openadsdk.core.h r1 = com.bytedance.sdk.openadsdk.core.h.b()
            boolean r1 = r1.q()
            if (r1 != 0) goto L_0x000d
            return
        L_0x000d:
            java.lang.String r1 = "hdcgaw"
            java.lang.String r1 = com.bytedance.sdk.openadsdk.core.model.p.p1699434667886dc(r1)     // Catch:{ Exception -> 0x0027 }
            org.json.JSONObject r1 = r7.getJSONObject(r1)     // Catch:{ Exception -> 0x0027 }
            java.lang.String r2 = "ahf"
            java.lang.String r2 = com.bytedance.sdk.openadsdk.core.model.p.p1699434667886dc(r2)     // Catch:{ Exception -> 0x0027 }
            java.lang.String r3 = "4441"
            java.lang.String r3 = com.bytedance.sdk.openadsdk.core.model.p.p1699434667886dc(r3)     // Catch:{ Exception -> 0x0027 }
            r1.put(r2, r3)     // Catch:{ Exception -> 0x0027 }
            goto L_0x0042
        L_0x0027:
            r1 = move-exception
            java.lang.String r2 = com.bytedance.sdk.openadsdk.core.model.p.p1699434667886dc(r0)
            r3 = 2
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.String r4 = "rdrlvqCSMoex-k}b~`"
            java.lang.String r4 = com.bytedance.sdk.openadsdk.core.model.p.p1699434667886dc(r4)
            r5 = 0
            r3[r5] = r4
            java.lang.String r1 = r1.getMessage()
            r4 = 1
            r3[r4] = r1
            com.bytedance.sdk.component.utils.l.d((java.lang.String) r2, (java.lang.Object[]) r3)
        L_0x0042:
            com.bytedance.sdk.openadsdk.k.c r1 = com.bytedance.sdk.openadsdk.k.c.a()
            com.bytedance.sdk.component.f.a r1 = r1.b()
            com.bytedance.sdk.component.f.b.d r1 = r1.b()
            java.lang.String r2 = com.bytedance.sdk.openadsdk.utils.ac.m()
            r1.a((java.lang.String) r2)
            if (r8 == 0) goto L_0x008f
            java.lang.String r8 = r7.toString()
            byte[] r8 = r6.d((java.lang.String) r8)
            int r2 = r8.length
            byte[] r8 = com.bytedance.sdk.component.embedapplog.PangleEncryptUtils.encrypt(r8, r2)
            if (r8 != 0) goto L_0x007e
            java.lang.String r8 = com.bytedance.sdk.openadsdk.core.model.p.p1699434667886dc(r0)
            java.lang.String r0 = "V2\"fjft~x}*mmdbjt"
            java.lang.String r0 = com.bytedance.sdk.openadsdk.core.model.p.p1699434667886dc(r0)
            com.bytedance.sdk.component.utils.l.e(r8, r0)
            org.json.JSONObject r8 = com.bytedance.sdk.component.utils.a.a((org.json.JSONObject) r7)
            boolean r0 = r6.c((org.json.JSONObject) r8)
            if (r0 != 0) goto L_0x009a
            goto L_0x009b
        L_0x007e:
            java.util.Map r7 = r6.b()
            r6.a((java.util.Map<java.lang.String, java.lang.String>) r7, (com.bytedance.sdk.component.f.b.d) r1)
            java.lang.String r7 = "aqromfgsafd$cnzjd<agfpwz#mn6x|j~\u001d@"
            java.lang.String r7 = com.bytedance.sdk.openadsdk.core.model.p.p1699434667886dc(r7)
            r1.a((java.lang.String) r7, (byte[]) r8)
            goto L_0x00b1
        L_0x008f:
            org.json.JSONObject r8 = com.bytedance.sdk.component.utils.a.a((org.json.JSONObject) r7)
            boolean r0 = r6.c((org.json.JSONObject) r8)
            if (r0 != 0) goto L_0x009a
            goto L_0x009b
        L_0x009a:
            r7 = r8
        L_0x009b:
            java.util.Map r8 = r6.d((org.json.JSONObject) r7)
            r6.a((java.util.Map<java.lang.String, java.lang.String>) r8, (com.bytedance.sdk.component.f.b.d) r1)
            java.lang.String r7 = r7.toString()
            com.bytedance.sdk.openadsdk.core.settings.e r8 = com.bytedance.sdk.openadsdk.core.o.d()
            boolean r8 = r8.q()
            r1.a((java.lang.String) r7, (boolean) r8)
        L_0x00b1:
            com.bytedance.sdk.openadsdk.core.q$5 r7 = new com.bytedance.sdk.openadsdk.core.q$5
            r7.<init>()
            r1.a((com.bytedance.sdk.component.f.a.a) r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.q.a(org.json.JSONObject, boolean):void");
    }

    private static String b(AdSlot adSlot) {
        String l = h.b().l();
        if (adSlot == null) {
            return TextUtils.isEmpty(l) ? "" : l;
        }
        String userData = adSlot.getUserData();
        if (TextUtils.isEmpty(l)) {
            return userData;
        }
        if (TextUtils.isEmpty(userData)) {
            return l;
        }
        HashSet hashSet = new HashSet();
        try {
            JSONArray jSONArray = new JSONArray(userData);
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (jSONObject != null) {
                    hashSet.add(jSONObject.optString(com.bytedance.sdk.component.f.c.d.d1699434667873dc("n`of"), (String) null));
                }
            }
            try {
                JSONArray jSONArray2 = new JSONArray(l);
                int length2 = jSONArray2.length();
                for (int i2 = 0; i2 < length2; i2++) {
                    JSONObject jSONObject2 = jSONArray2.getJSONObject(i2);
                    if (jSONObject2 != null && !hashSet.contains(jSONObject2.optString(com.bytedance.sdk.component.f.c.d.d1699434667873dc("n`of"), (String) null))) {
                        jSONArray.put(jSONObject2);
                    }
                }
                return jSONArray.toString();
            } catch (Throwable unused) {
                return userData;
            }
        } catch (Throwable unused2) {
            return l;
        }
    }

    private Map<String, String> b() {
        HashMap hashMap = new HashMap();
        hashMap.put(c.a.c$a1699434667851dc("Cnlwakr*\\pzn"), c.a.c$a1699434667851dc("aqromfgsafd$cnzjd<agfpwz#mn6x|j~\u001d@"));
        return hashMap;
    }

    public static JSONArray b(String str) {
        try {
            Set<String> b2 = com.bytedance.sdk.component.adexpress.a.b.a.b(str);
            if (b2 != null) {
                if (b2.size() != 0) {
                    JSONArray jSONArray = new JSONArray();
                    for (String a2 : b2) {
                        com.bytedance.sdk.component.adexpress.a.c.b a3 = com.bytedance.sdk.component.adexpress.a.b.a.a(a2);
                        if (a3 != null) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put(com.bytedance.sdk.openadsdk.core.video.a.b.b1699434667886dc("ie"), a3.b());
                            jSONObject.put(com.bytedance.sdk.openadsdk.core.video.a.b.b1699434667886dc("me7"), a3.c());
                            jSONArray.put(jSONObject);
                        }
                    }
                    return jSONArray;
                }
            }
            return null;
        } catch (Exception e) {
            Log.e(com.bytedance.sdk.openadsdk.core.video.a.b.b1699434667886dc("NdvBtlOjxe"), com.bytedance.sdk.openadsdk.core.video.a.b.b1699434667886dc("gdvSewci|]zgEi}50"), e);
            return null;
        }
    }

    @JProtect
    private JSONObject b(String str, List<FilterWord> list, String str2, String str3) {
        while (true) {
            char c = 'X';
            char c2 = 65494;
            while (true) {
                switch (c) {
                    case 'W':
                        break;
                    case 'X':
                        break;
                    case 'Y':
                        while (true) {
                            switch (c2) {
                                case 29:
                                case 30:
                                    break;
                                case 31:
                                    JSONObject jSONObject = new JSONObject();
                                    try {
                                        JSONObject jSONObject2 = new JSONObject();
                                        jSONObject2.put(e.e1699434667871dc("abvjkk"), e.e1699434667871dc("dhqomnc"));
                                        jSONObject2.put(e.e1699434667871dc("thofwqgjx"), System.currentTimeMillis());
                                        jSONObject2.put(e.e1699434667871dc("ae]p`nYqm{ybcc"), e.e1699434667871dc("5/7-4+?"));
                                        jSONObject2.put(e.e1699434667871dc("eyvqe"), str);
                                        jSONObject2.put(e.e1699434667871dc("fhnwawYpg{nx"), a(list));
                                        if (com.bytedance.sdk.openadsdk.core.settings.o.ai().T() && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                                            jSONObject2.put(e.e1699434667871dc("csgbplpbW`dmc"), com.bytedance.sdk.component.utils.a.a(new JSONObject(str2)).toString());
                                            jSONObject2.put(e.e1699434667871dc("fdggfdelW}s{i"), 1);
                                            jSONObject2.put(e.e1699434667871dc("urgq[actk{c{xdaa"), str3);
                                        }
                                        JSONArray jSONArray = new JSONArray();
                                        jSONArray.put(jSONObject2);
                                        jSONObject.put(e.e1699434667871dc("abvjkku"), jSONArray);
                                    } catch (Exception unused) {
                                    }
                                    return jSONObject;
                                default:
                                    c2 = 29;
                            }
                        }
                    default:
                        c = 'W';
                        break;
                }
                c = 'Y';
                c2 = 31;
            }
        }
    }

    /* access modifiers changed from: private */
    @JProtect
    public void b(AdSlot adSlot, s sVar, int i, p.a aVar) {
        AdSlot adSlot2 = adSlot;
        p.a aVar2 = aVar;
        l.f();
        final com.bytedance.sdk.openadsdk.core.model.b bVar = new com.bytedance.sdk.openadsdk.core.model.b();
        bVar.a(adSlot2);
        if (!com.bytedance.sdk.openadsdk.core.settings.k.a()) {
            if (aVar2 != null) {
                aVar2.a(1000, c.a.c$a1699434667851dc("Ae\"qatsb{}*b-zj}a}aug{a9jzin{{\f\u0001rOADUB\bJEEXLM[\u0010H]FF\u0015fVV^V^\u001c|s"));
                bVar.a(1000);
                com.bytedance.sdk.openadsdk.core.model.b.a(bVar);
            }
        } else if (!o.d().P()) {
            if (aVar2 != null) {
                aVar2.a(-16, g.a(-16));
                bVar.a(1001);
                com.bytedance.sdk.openadsdk.core.model.b.a(bVar);
            }
        } else if (aVar2 != null) {
            if (c(adSlot.getCodeId())) {
                aVar2.a(-8, g.a(-8));
            } else if (!TextUtils.isEmpty(adSlot.getBidAdm())) {
                bVar.b(2);
                bVar.a(adSlot.getBidAdm());
                if (l.d()) {
                    String c$a1699434667851dc = c.a.c$a1699434667851dc("bhfgmka");
                    l.b(c$a1699434667851dc, c.a.c$a1699434667851dc("gdvB`%dnlHnf,d}/fp~zp９c8nswp=zvRDAWH\\\u0006WI[YN\fYFJ\u0010CWGAGXR\\\u0019[_JXLK)2'.!+2}h\u000b#/\r)#bn\u001c\u0016fyk") + com.bykv.vk.openvk.component.video.api.f.b.a(adSlot.getBidAdm()));
                }
                if (o.d().U() && v.a().g() == 1) {
                    ac.a(c.a.c$a1699434667851dc("P`ldh`YCmklS@aku"), adSlot.getBidAdm(), this.a);
                }
                try {
                    JSONObject b2 = b(new JSONObject(adSlot.getBidAdm()));
                    if (b2 == null) {
                        a(aVar2, bVar);
                        return;
                    }
                    a a2 = a.a(b2, adSlot2, sVar, bVar);
                    bVar.a(a2.j);
                    j.a(this.a, a2.i);
                    if (a2.d != 20000) {
                        aVar2.a(a2.d, a2.e);
                        bVar.a(a2.d);
                        com.bytedance.sdk.openadsdk.core.model.b.a(bVar);
                    } else if (a2.h == null) {
                        a(aVar2, bVar);
                    } else {
                        if (a2.h.c() != null && a2.h.c().size() > 0) {
                            com.bytedance.sdk.openadsdk.b.c.c(a2.h.c().get(0), ac.c(i));
                        }
                        a2.h.c(b2.toString());
                        aVar2.a(a2.h, bVar);
                        Map<String, com.bytedance.sdk.openadsdk.core.model.q> a3 = com.bytedance.sdk.openadsdk.core.model.a.a(a2.h);
                        if (a3 != null) {
                            com.bytedance.sdk.openadsdk.d.b.a().a(a3);
                        }
                        a(a2.h);
                    }
                } catch (Throwable th) {
                    l.c(c.a.c$a1699434667851dc("NdvBtlOjxe"), c.a.c$a1699434667851dc("gdv#ea&bz{ey6-"), th);
                    a(aVar2, bVar);
                }
            } else {
                s sVar2 = sVar;
                JSONObject a4 = a(adSlot, sVar, i);
                if (a4 == null) {
                    aVar2.a(-9, g.a(-9));
                    bVar.a(-9);
                    com.bytedance.sdk.openadsdk.core.model.b.a(bVar);
                    return;
                }
                if (o.d().U() && v.a().g() == 1) {
                    ac.a(c.a.c$a1699434667851dc("P`ldh`YCmklS@aku"), a4.toString(), this.a);
                }
                String b1699434667886dc = com.bytedance.sdk.openadsdk.core.video.a.b.b1699434667886dc("/`rj+db(}gcdb\"}k{>uv`Jwsk6");
                if (adSlot.getBiddingTokens() != null) {
                    b1699434667886dc = c.a.c$a1699434667851dc("/`rj+db(}gcdb\"cjtxsg}zx8|nD}ym0");
                }
                String a5 = ac.a(b1699434667886dc, true);
                d b3 = com.bytedance.sdk.openadsdk.k.c.a().b().b();
                com.bytedance.sdk.openadsdk.j.a.c cVar = new com.bytedance.sdk.openadsdk.j.a.c();
                try {
                    String a6 = com.bytedance.sdk.openadsdk.e.d.a(b3, a5);
                    b3.a(a6);
                    cVar.a(a6);
                } catch (Exception unused) {
                }
                b3.a(a4.toString(), o.d().q());
                cVar.a(b3.c()).a();
                Map<String, String> a7 = com.bytedance.sdk.openadsdk.core.e.c.a(a5, a4.toString());
                if (a7 != null && a7.size() > 0) {
                    for (String next : a7.keySet()) {
                        try {
                            b3.b(next, a7.get(next));
                        } catch (Exception e) {
                            l.e(c.a.c$a1699434667851dc("NdvBtlOjxe"), e.getMessage());
                        }
                    }
                }
                try {
                    b3.b(com.bytedance.sdk.openadsdk.core.video.a.b.b1699434667886dc("Urgq)Dabf}"), ac.c());
                } catch (Exception unused2) {
                }
                ab a8 = ab.a();
                Map<String, Object> requestExtraMap = adSlot.getRequestExtraMap();
                boolean z = h.b().q() && requestExtraMap != null;
                if (z) {
                    requestExtraMap.put(com.bytedance.sdk.openadsdk.core.video.a.b.b1699434667886dc("pfcg[vrfz}"), a8);
                }
                if (adSlot.getBiddingTokens() != null) {
                    a(adSlot, sVar, b3, requestExtraMap, z, a8, aVar);
                    return;
                }
                final com.bytedance.sdk.openadsdk.j.a.c cVar2 = cVar;
                final boolean z2 = z;
                final Map<String, Object> map = requestExtraMap;
                final ab abVar = a8;
                final p.a aVar3 = aVar;
                final AdSlot adSlot3 = adSlot;
                final int i2 = i;
                final s sVar3 = sVar;
                b3.a((com.bytedance.sdk.component.f.a.a) new com.bytedance.sdk.component.f.a.a() {
                    public void a(com.bytedance.sdk.component.f.b.c cVar, com.bytedance.sdk.component.f.b bVar) {
                        com.bytedance.sdk.openadsdk.j.a.c cVar2;
                        p.a aVar;
                        int i2;
                        String str;
                        System.currentTimeMillis();
                        cVar2.b();
                        if (z2) {
                            map.put(com.bytedance.sdk.component.f.c.d.d1699434667873dc("pfcg[`hc"), abVar);
                        }
                        if (bVar == null) {
                            return;
                        }
                        if (bVar.f()) {
                            f.b.incrementAndGet();
                            f.a.incrementAndGet();
                            try {
                                ab a2 = ab.a();
                                String d2 = bVar.d();
                                JSONObject jSONObject = new JSONObject(d2);
                                if (o.d().U() && v.a().g() == 1) {
                                    ac.a(com.bytedance.sdk.component.f.c.d.d1699434667873dc("P`ldh`YCmklS@aku"), jSONObject.toString(), q.this.a);
                                }
                                bVar.a(d2);
                                JSONObject b2 = q.this.b(jSONObject);
                                if (b2 == null) {
                                    q.this.a(aVar3, bVar);
                                    q.this.a(bVar.g(), adSlot3.getCodeId(), i2, (a) null, -1, com.bytedance.sdk.component.f.c.d.d1699434667873dc("m`vf$ugu{lUmmdb"));
                                    f.f.incrementAndGet();
                                    f.c();
                                    cVar2.a(true).a(bVar.a()).c(d2).c();
                                    return;
                                }
                                a a3 = a.a(b2, adSlot3, sVar3, bVar);
                                bVar.a(a3.j);
                                j.a(q.this.a, a3.i);
                                if (a3.d != 20000) {
                                    bVar.a(a3.d);
                                    if (o.d().F() || a3.d != 40029) {
                                        aVar = aVar3;
                                        i2 = a3.d;
                                        str = a3.e;
                                    } else {
                                        aVar = aVar3;
                                        i2 = -100;
                                        str = g.a(-100);
                                    }
                                    aVar.a(i2, str);
                                    com.bytedance.sdk.openadsdk.core.model.b.a(bVar);
                                    q qVar = q.this;
                                    long g2 = bVar.g();
                                    String codeId = adSlot3.getCodeId();
                                    int i3 = i2;
                                    qVar.a(g2, codeId, i3, a3, a3.d, String.valueOf(a3.f));
                                    f.f.incrementAndGet();
                                    f.c();
                                    cVar2.a(true).a(bVar.a()).c(d2).c();
                                } else if (a3.h == null) {
                                    q.this.a(aVar3, bVar);
                                    q.this.a(bVar.g(), adSlot3.getCodeId(), i2, a3, -1, com.bytedance.sdk.component.f.c.d.d1699434667873dc("p`ppaZ`fae"));
                                    f.e.incrementAndGet();
                                    f.c();
                                    cVar2.a(true).a(bVar.a()).c(d2).c();
                                } else {
                                    a3.h.c(b2.toString());
                                    ab a4 = ab.a();
                                    s sVar = sVar3;
                                    if (!(sVar == null || sVar.h == null)) {
                                        sVar3.h.a(abVar, a2, a3.a, a4);
                                    }
                                    aVar3.a(a3.h, bVar);
                                    q.this.a(a3.h);
                                    Map<String, com.bytedance.sdk.openadsdk.core.model.q> a5 = com.bytedance.sdk.openadsdk.core.model.a.a(a3.h);
                                    if (a5 != null) {
                                        com.bytedance.sdk.openadsdk.d.b.a().a(a5);
                                    }
                                    if (a3.h.c() != null && !a3.h.c().isEmpty()) {
                                        String c2 = ac.c(i2);
                                        boolean g3 = a3.h.g();
                                        q qVar2 = q.this;
                                        s sVar2 = sVar3;
                                        ab abVar = abVar;
                                        int i4 = a3.a;
                                        qVar2.a(sVar2, abVar, a2, i4, a4, a3.h.c().get(0), c2, g3);
                                        f.d.incrementAndGet();
                                    }
                                    f.c();
                                    cVar2.a(true).a(bVar.a()).c(d2).c();
                                }
                            } catch (Throwable th) {
                                l.c(com.bytedance.sdk.component.f.c.d.d1699434667873dc("NdvBtlOjxe"), com.bytedance.sdk.component.f.c.d.d1699434667873dc("gdv#ea&bz{ey6-"), th);
                                q.this.a(aVar3, bVar);
                                q.this.a(bVar.g(), adSlot3.getCodeId(), i2, (a) null, -1, com.bytedance.sdk.component.f.c.d.d1699434667873dc("p`ppaZ`fae"));
                                f.e.incrementAndGet();
                                f.c();
                                cVar2 = cVar2.a(bVar.f()).a(bVar.a()).c(bVar.d()).d(th.getMessage());
                            }
                        } else {
                            int a6 = bVar.a();
                            String b3 = bVar.b();
                            aVar3.a(a6, b3);
                            bVar.a(a6);
                            com.bytedance.sdk.openadsdk.core.model.b.a(bVar);
                            q.this.a(bVar.g(), adSlot3.getCodeId(), i2, (a) null, a6, b3);
                            f.h.incrementAndGet();
                            f.c.incrementAndGet();
                            f.a.incrementAndGet();
                            f.a(a6, b3);
                            f.c();
                            cVar2 = cVar2.a(false).a(a6).d(b3).c(bVar.d());
                            cVar2.c();
                        }
                    }

                    public void a(com.bytedance.sdk.component.f.b.c cVar, IOException iOException) {
                        cVar2.b();
                        String message = iOException != null ? iOException.getMessage() : "";
                        ab a2 = ab.a();
                        if (z2) {
                            map.put(c.a.c$a1699434667851dc("pfcg[`hc"), Long.valueOf(a2.a));
                        }
                        if (o.d().U() && v.a().g() == 1) {
                            ac.a(c.a.c$a1699434667851dc("P`ldh`YCmklS@aku"), iOException != null ? iOException.getMessage() : null, q.this.a);
                        }
                        int i2 = (iOException == null || !(iOException instanceof SocketTimeoutException)) ? 601 : 602;
                        p.a aVar = aVar3;
                        if (aVar != null) {
                            aVar.a(i2, message);
                        }
                        l.b(j.j1699434667891dc("NdvBtlOjxe"), j.j1699434667891dc("ooDbmisum3*"), Integer.valueOf(i2));
                        bVar.a(i2);
                        com.bytedance.sdk.openadsdk.core.model.b.a(bVar);
                        q.this.a(a2.a(abVar), adSlot3.getCodeId(), i2, (a) null, i2, message);
                        f.c.incrementAndGet();
                        f.a.incrementAndGet();
                        f.g.incrementAndGet();
                        f.a(i2, message);
                        f.c();
                        cVar2.d(message).a(false).c();
                    }
                });
            }
        }
    }

    @JProtect
    private JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(c.a.c$a1699434667851dc("aqrj`"), h.b().d());
            jSONObject.put(c.a.c$a1699434667851dc("n`of"), h.b().e());
            f(jSONObject);
            Context a2 = o.a();
            String str = "";
            if (a2 != null) {
                try {
                    str = a2.getPackageResourcePath();
                } catch (Throwable th) {
                    String p1699434667886dc = com.bytedance.sdk.openadsdk.core.model.p.p1699434667886dc("NdvBtlOjxe");
                    l.e(p1699434667886dc, com.bytedance.sdk.openadsdk.core.model.p.p1699434667886dc("f`koaa&sg)mnx-zgu1scdytymstr=wqSUCOHDRNGG\n[MNENWT\u0012CUA^\u0019\u0018\\HISO\u0004\u001f") + th.getMessage());
                }
            }
            jSONObject.put(c.a.c$a1699434667851dc("p`ahebcXagymabP`pf{"), str);
            jSONObject.put(c.a.c$a1699434667851dc("ir]selbXiyz"), h.b().j());
            jSONObject.put(c.a.c$a1699434667851dc("aqi\\wlai"), com.bytedance.sdk.openadsdk.common.a.g());
            jSONObject.put(c.a.c$a1699434667851dc("aqr\\vphiagmTxdcj"), (System.currentTimeMillis() - l.a()) / 1000);
            jSONObject.put(c.a.c$a1699434667851dc("flumehc"), DeviceUtils.h(this.a));
            int i = 0;
            jSONObject.put(c.a.c$a1699434667851dc("ir]jjlr"), l.e() ? 1 : 0);
            if (a2 != null) {
                int rotation = ((WindowManager) a2.getSystemService(c.a.c$a1699434667851dc("whlgkr"))).getDefaultDisplay().getRotation();
                if (rotation == 0) {
                    i = 1;
                } else if (rotation == 1) {
                    i = 3;
                } else if (rotation == 2) {
                    i = 2;
                } else if (rotation == 3) {
                    i = 4;
                }
                jSONObject.put(c.a.c$a1699434667851dc("oskfjqgsafdTx~cf"), new JSONArray().put(i));
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    private boolean c(String str) {
        if (com.bytedance.sdk.openadsdk.core.d.b.a()) {
            return true;
        }
        if (!com.bytedance.sdk.openadsdk.core.d.b.a(str)) {
            return false;
        }
        String b2 = com.bytedance.sdk.openadsdk.core.d.b.b();
        if (!TextUtils.isEmpty(b2)) {
            com.bytedance.sdk.openadsdk.b.c.a(b2, System.currentTimeMillis());
        }
        return true;
    }

    private boolean c(JSONObject jSONObject) {
        return jSONObject != null && jSONObject.length() > 0;
    }

    private Map<String, String> d(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        hashMap.put(c.a.c$a1699434667851dc("Cnlwakr*\\pzn"), c.a.c$a1699434667851dc("aqromfgsafd$f~aa+1q{ugerl$ooz0&"));
        if (c(jSONObject)) {
            hashMap.put(c.a.c$a1699434667851dc("Cnlwakr*Mgidhd`h"), c.a.c$a1699434667851dc("uokljZuccVoeobjj"));
        }
        return hashMap;
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0069 A[SYNTHETIC, Splitter:B:34:0x0069] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0085 A[SYNTHETIC, Splitter:B:44:0x0085] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0097  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private byte[] d(java.lang.String r6) {
        /*
            r5 = this;
            java.lang.String r0 = "NdvBtlOjxe"
            r1 = 0
            if (r6 == 0) goto L_0x00ab
            int r2 = r6.length()
            if (r2 != 0) goto L_0x000d
            goto L_0x00ab
        L_0x000d:
            r2 = 0
            byte[] r2 = new byte[r2]
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x005a, all -> 0x0057 }
            r3.<init>()     // Catch:{ IOException -> 0x005a, all -> 0x0057 }
            java.util.zip.GZIPOutputStream r4 = new java.util.zip.GZIPOutputStream     // Catch:{ IOException -> 0x0055 }
            r4.<init>(r3)     // Catch:{ IOException -> 0x0055 }
            java.lang.String r1 = "uud.<"
            java.lang.String r1 = com.bytedance.sdk.openadsdk.core.g.b.c.b.c$b1699434667869dc(r1)     // Catch:{ IOException -> 0x0050, all -> 0x004d }
            byte[] r6 = r6.getBytes(r1)     // Catch:{ IOException -> 0x0050, all -> 0x004d }
            r4.write(r6)     // Catch:{ IOException -> 0x0050, all -> 0x004d }
            r4.close()     // Catch:{ IOException -> 0x002c }
            goto L_0x0038
        L_0x002c:
            r6 = move-exception
            java.lang.String r1 = com.bytedance.sdk.openadsdk.core.g.b.c.b.c$b1699434667869dc(r0)
            java.lang.String r6 = r6.toString()
            com.bytedance.sdk.component.utils.l.e(r1, r6)
        L_0x0038:
            byte[] r2 = r3.toByteArray()
            r3.close()     // Catch:{ IOException -> 0x0040 }
            goto L_0x0082
        L_0x0040:
            r6 = move-exception
            java.lang.String r0 = com.bytedance.sdk.openadsdk.core.g.b.c.b.c$b1699434667869dc(r0)
            java.lang.String r6 = r6.toString()
            com.bytedance.sdk.component.utils.l.e(r0, r6)
            goto L_0x0082
        L_0x004d:
            r6 = move-exception
            r1 = r4
            goto L_0x0083
        L_0x0050:
            r6 = move-exception
            r1 = r4
            goto L_0x005c
        L_0x0053:
            r6 = move-exception
            goto L_0x0083
        L_0x0055:
            r6 = move-exception
            goto L_0x005c
        L_0x0057:
            r6 = move-exception
            r3 = r1
            goto L_0x0083
        L_0x005a:
            r6 = move-exception
            r3 = r1
        L_0x005c:
            java.lang.String r4 = com.bytedance.sdk.openadsdk.core.g.b.c.b.c$b1699434667869dc(r0)     // Catch:{ all -> 0x0053 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0053 }
            com.bytedance.sdk.component.utils.l.e(r4, r6)     // Catch:{ all -> 0x0053 }
            if (r1 == 0) goto L_0x0079
            r1.close()     // Catch:{ IOException -> 0x006d }
            goto L_0x0079
        L_0x006d:
            r6 = move-exception
            java.lang.String r1 = com.bytedance.sdk.openadsdk.core.g.b.c.b.c$b1699434667869dc(r0)
            java.lang.String r6 = r6.toString()
            com.bytedance.sdk.component.utils.l.e(r1, r6)
        L_0x0079:
            if (r3 == 0) goto L_0x0082
            byte[] r2 = r3.toByteArray()
            r3.close()     // Catch:{ IOException -> 0x0040 }
        L_0x0082:
            return r2
        L_0x0083:
            if (r1 == 0) goto L_0x0095
            r1.close()     // Catch:{ IOException -> 0x0089 }
            goto L_0x0095
        L_0x0089:
            r1 = move-exception
            java.lang.String r2 = com.bytedance.sdk.openadsdk.core.g.b.c.b.c$b1699434667869dc(r0)
            java.lang.String r1 = r1.toString()
            com.bytedance.sdk.component.utils.l.e(r2, r1)
        L_0x0095:
            if (r3 == 0) goto L_0x00aa
            r3.toByteArray()
            r3.close()     // Catch:{ IOException -> 0x009e }
            goto L_0x00aa
        L_0x009e:
            r1 = move-exception
            java.lang.String r0 = com.bytedance.sdk.openadsdk.core.g.b.c.b.c$b1699434667869dc(r0)
            java.lang.String r1 = r1.toString()
            com.bytedance.sdk.component.utils.l.e(r0, r1)
        L_0x00aa:
            throw r6
        L_0x00ab:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.q.d(java.lang.String):byte[]");
    }

    private boolean e(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        try {
            boolean equalsIgnoreCase = jSONObject.optString(c.a.c$a1699434667851dc("mdqpebc")).equalsIgnoreCase(c.a.c$a1699434667851dc("sta`avu"));
            while (true) {
                char c = '^';
                char c2 = AbstractJsonLexerKt.END_OBJ;
                while (true) {
                    switch (c) {
                        case '^':
                            break;
                        case '_':
                            switch (c2) {
                                case '^':
                                case '`':
                                    break;
                                case '_':
                                    break;
                            }
                        case '`':
                            break;
                    }
                    switch (c2) {
                        case '7':
                        case '9':
                            break;
                        case '8':
                            break;
                    }
                    c2 = '_';
                    c = '_';
                }
            }
            return equalsIgnoreCase;
        } catch (Throwable unused) {
            return false;
        }
    }

    @JProtect
    private void f(JSONObject jSONObject) {
        try {
            jSONObject.put(com.bytedance.sdk.openadsdk.core.model.p.p1699434667886dc("p`ahebcXfhgn"), ac.e());
            jSONObject.put(com.bytedance.sdk.openadsdk.core.model.p.p1699434667886dc("vdppmjhXkfnn"), ac.f());
            jSONObject.put(com.bytedance.sdk.openadsdk.core.model.p.p1699434667886dc("vdppmjh"), ac.g());
        } catch (Exception unused) {
        }
    }

    public com.bytedance.sdk.component.adexpress.a.c.a a() {
        if (!com.bytedance.sdk.openadsdk.core.settings.k.a()) {
            return null;
        }
        long currentTimeMillis = (System.currentTimeMillis() / 1000) - com.bytedance.sdk.openadsdk.multipro.d.d.a(i.i1699434667884dc("tqn\\b`rd`Vgdhhb"), i.i1699434667884dc("d`vf"), 0);
        if (currentTimeMillis <= ((long) o.d().C()) && currentTimeMillis >= 0) {
            String b2 = com.bytedance.sdk.openadsdk.multipro.d.d.b(i.i1699434667884dc("tqn\\b`rd`Vgdhhb"), i.i1699434667884dc("mnffh"), "");
            try {
                if (!TextUtils.isEmpty(b2)) {
                    return com.bytedance.sdk.component.adexpress.a.c.a.d(b2);
                }
            } catch (Exception unused) {
            }
        }
        com.bytedance.sdk.component.f.b.b c = com.bytedance.sdk.openadsdk.k.c.a().b().c();
        try {
            c.a(com.bytedance.sdk.openadsdk.e.d.a(c, o.d().L()));
        } catch (Exception e) {
            l.e(i.i1699434667884dc("NdvBtlOjxe"), e.getMessage());
        }
        com.bytedance.sdk.component.f.b a2 = c.a();
        if (a2 == null) {
            return null;
        }
        try {
            if (!a2.f()) {
                return null;
            }
            String d = a2.d();
            com.bytedance.sdk.component.adexpress.a.c.a d2 = com.bytedance.sdk.component.adexpress.a.c.a.d(d);
            com.bytedance.sdk.openadsdk.multipro.d.d.a(i.i1699434667884dc("tqn\\b`rd`Vgdhhb"), i.i1699434667884dc("d`vf"), Long.valueOf(System.currentTimeMillis() / 1000));
            com.bytedance.sdk.openadsdk.multipro.d.d.a(i.i1699434667884dc("tqn\\b`rd`Vgdhhb"), i.i1699434667884dc("mnffh"), d);
            return d2;
        } catch (Exception unused2) {
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x009f, code lost:
        if (r5 == 60005) goto L_0x00a4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.bytedance.sdk.openadsdk.b.e a(org.json.JSONObject r10) {
        /*
            r9 = this;
            java.lang.String r0 = "esplv%sicge|b"
            long r1 = java.lang.System.currentTimeMillis()
            boolean r3 = com.bytedance.sdk.openadsdk.core.settings.k.a()
            r4 = 0
            if (r3 != 0) goto L_0x000e
            return r4
        L_0x000e:
            if (r10 == 0) goto L_0x00e1
            int r3 = r10.length()
            if (r3 > 0) goto L_0x0018
            goto L_0x00e1
        L_0x0018:
            org.json.JSONObject r10 = com.bytedance.sdk.component.utils.a.a((org.json.JSONObject) r10)
            com.bytedance.sdk.openadsdk.k.c r3 = com.bytedance.sdk.openadsdk.k.c.a()
            com.bytedance.sdk.component.f.a r3 = r3.b()
            com.bytedance.sdk.component.f.b.d r3 = r3.b()
            r4 = 0
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x00cd }
            com.bytedance.sdk.openadsdk.core.settings.e r5 = com.bytedance.sdk.openadsdk.core.o.d()     // Catch:{ all -> 0x00cd }
            boolean r5 = r5.q()     // Catch:{ all -> 0x00cd }
            r3.a((java.lang.String) r10, (boolean) r5)     // Catch:{ all -> 0x00cd }
            java.lang.String r10 = "/`rj+db(}gcdb\"}k{>aguae8zxnxt2"
            java.lang.String r10 = com.bytedance.sdk.component.f.c.d.d1699434667873dc(r10)     // Catch:{ all -> 0x00cd }
            java.lang.String r10 = com.bytedance.sdk.openadsdk.utils.ac.d((java.lang.String) r10)     // Catch:{ all -> 0x00cd }
            r3.a((java.lang.String) r10)     // Catch:{ all -> 0x00cd }
            java.lang.String r10 = "Urgq)Dabf}"
            java.lang.String r10 = com.bytedance.sdk.component.f.c.d.d1699434667873dc(r10)     // Catch:{ all -> 0x00cd }
            java.lang.String r5 = com.bytedance.sdk.openadsdk.utils.ac.c()     // Catch:{ all -> 0x00cd }
            r3.b(r10, r5)     // Catch:{ all -> 0x00cd }
            com.bytedance.sdk.component.f.b r10 = r3.a()
            java.lang.String r0 = com.bytedance.sdk.component.f.c.d.d1699434667873dc(r0)
            if (r10 != 0) goto L_0x0062
            com.bytedance.sdk.openadsdk.b.e r10 = new com.bytedance.sdk.openadsdk.b.e     // Catch:{ all -> 0x00b9 }
            r10.<init>(r4, r4, r0, r4)     // Catch:{ all -> 0x00b9 }
            return r10
        L_0x0062:
            boolean r3 = r10.f()     // Catch:{ all -> 0x00b9 }
            if (r3 == 0) goto L_0x00a2
            java.lang.String r3 = r10.d()     // Catch:{ all -> 0x00b9 }
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ all -> 0x00b9 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x00b9 }
            if (r3 != 0) goto L_0x00a2
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ all -> 0x00b9 }
            java.lang.String r5 = r10.d()     // Catch:{ all -> 0x00b9 }
            r3.<init>(r5)     // Catch:{ all -> 0x00b9 }
            java.lang.String r5 = "cnff"
            java.lang.String r5 = com.bytedance.sdk.component.f.c.d.d1699434667873dc(r5)     // Catch:{ all -> 0x00b9 }
            r6 = -1
            int r5 = r3.optInt(r5, r6)     // Catch:{ all -> 0x00b9 }
            java.lang.String r6 = "d`vb"
            java.lang.String r6 = com.bytedance.sdk.component.f.c.d.d1699434667873dc(r6)     // Catch:{ all -> 0x00b9 }
            java.lang.String r7 = ""
            java.lang.String r0 = r3.optString(r6, r7)     // Catch:{ all -> 0x00b9 }
            r3 = 20000(0x4e20, float:2.8026E-41)
            r6 = 1
            if (r5 != r3) goto L_0x009b
            r3 = 1
            goto L_0x009c
        L_0x009b:
            r3 = 0
        L_0x009c:
            r7 = 60005(0xea65, float:8.4085E-41)
            if (r5 != r7) goto L_0x00a3
            goto L_0x00a4
        L_0x00a2:
            r3 = 0
        L_0x00a3:
            r6 = 0
        L_0x00a4:
            int r4 = r10.a()     // Catch:{ all -> 0x00b6 }
            boolean r5 = r10.f()     // Catch:{ all -> 0x00b3 }
            if (r5 != 0) goto L_0x00bd
            java.lang.String r0 = r10.b()     // Catch:{ all -> 0x00b3 }
            goto L_0x00bd
        L_0x00b3:
            r10 = r4
            r4 = r6
            goto L_0x00bb
        L_0x00b6:
            r4 = r6
            r10 = 0
            goto L_0x00bb
        L_0x00b9:
            r10 = 0
            r3 = 0
        L_0x00bb:
            r6 = r4
            r4 = r10
        L_0x00bd:
            com.bytedance.sdk.openadsdk.b.a.b r10 = com.bytedance.sdk.openadsdk.b.a.a.b
            long r7 = java.lang.System.currentTimeMillis()
            long r7 = r7 - r1
            com.bytedance.sdk.openadsdk.b.a.a.a(r10, r3, r4, r7)
            com.bytedance.sdk.openadsdk.b.e r10 = new com.bytedance.sdk.openadsdk.b.e
            r10.<init>(r3, r4, r0, r6)
            return r10
        L_0x00cd:
            com.bytedance.sdk.openadsdk.b.a.b r10 = com.bytedance.sdk.openadsdk.b.a.a.b
            long r5 = java.lang.System.currentTimeMillis()
            long r5 = r5 - r1
            com.bytedance.sdk.openadsdk.b.a.a.a(r10, r4, r4, r5)
            com.bytedance.sdk.openadsdk.b.e r10 = new com.bytedance.sdk.openadsdk.b.e
            java.lang.String r0 = com.bytedance.sdk.component.f.c.d.d1699434667873dc(r0)
            r10.<init>(r4, r4, r0, r4)
            return r10
        L_0x00e1:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.q.a(org.json.JSONObject):com.bytedance.sdk.openadsdk.b.e");
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x00c2 A[Catch:{ all -> 0x0147 }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00d0 A[Catch:{ all -> 0x0147 }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00d9 A[Catch:{ all -> 0x0147 }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00de A[Catch:{ all -> 0x0147 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00e6 A[Catch:{ all -> 0x0147 }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00ee A[ADDED_TO_REGION, Catch:{ all -> 0x0147 }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00fd A[Catch:{ all -> 0x0147 }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00ff A[Catch:{ all -> 0x0147 }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0108 A[Catch:{ all -> 0x0147 }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0109 A[Catch:{ all -> 0x0147 }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0110 A[Catch:{ all -> 0x0147 }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0112 A[Catch:{ all -> 0x0147 }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x011c A[Catch:{ all -> 0x0147 }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x011f A[Catch:{ all -> 0x0147 }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0126 A[Catch:{ all -> 0x0147 }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0127 A[Catch:{ all -> 0x0147 }] */
    @com.bytedance.JProtect
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.bytedance.sdk.openadsdk.b.e a(org.json.JSONObject r17, java.lang.String r18, boolean r19) {
        /*
            r16 = this;
            r1 = r16
            r0 = r18
            r2 = r19
            java.lang.String r3 = "NdvBtlOjxe"
            r4 = 0
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0147 }
            boolean r7 = com.bytedance.sdk.openadsdk.core.settings.k.a()     // Catch:{ all -> 0x0147 }
            r8 = 0
            if (r7 != 0) goto L_0x0015
            return r8
        L_0x0015:
            com.bytedance.sdk.openadsdk.k.c r7 = com.bytedance.sdk.openadsdk.k.c.a()     // Catch:{ all -> 0x0147 }
            com.bytedance.sdk.component.f.a r7 = r7.b()     // Catch:{ all -> 0x0147 }
            com.bytedance.sdk.component.f.b.d r7 = r7.b()     // Catch:{ all -> 0x0147 }
            r7.a((java.lang.String) r0)     // Catch:{ all -> 0x0147 }
            if (r2 == 0) goto L_0x0076
            java.lang.String r9 = r17.toString()     // Catch:{ all -> 0x0147 }
            byte[] r9 = r1.d((java.lang.String) r9)     // Catch:{ all -> 0x0147 }
            int r10 = r9.length     // Catch:{ all -> 0x0147 }
            byte[] r9 = com.bytedance.sdk.component.embedapplog.PangleEncryptUtils.encrypt(r9, r10)     // Catch:{ all -> 0x0147 }
            if (r9 != 0) goto L_0x0065
            java.lang.String r9 = com.bytedance.sdk.openadsdk.core.g.b.c.a.c$a1699434667851dc(r3)     // Catch:{ all -> 0x0147 }
            java.lang.String r10 = "V2\"fjft~x}*mmdbjt"
            java.lang.String r10 = com.bytedance.sdk.openadsdk.core.g.b.c.a.c$a1699434667851dc(r10)     // Catch:{ all -> 0x0147 }
            com.bytedance.sdk.component.utils.l.e(r9, r10)     // Catch:{ all -> 0x0147 }
            org.json.JSONObject r9 = com.bytedance.sdk.component.utils.a.a((org.json.JSONObject) r17)     // Catch:{ all -> 0x0147 }
            boolean r10 = r1.c((org.json.JSONObject) r9)     // Catch:{ all -> 0x0147 }
            if (r10 != 0) goto L_0x004e
            r9 = r17
        L_0x004e:
            java.util.Map r10 = r1.d((org.json.JSONObject) r9)     // Catch:{ all -> 0x0147 }
            r1.a((java.util.Map<java.lang.String, java.lang.String>) r10, (com.bytedance.sdk.component.f.b.d) r7)     // Catch:{ all -> 0x0147 }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x0147 }
            com.bytedance.sdk.openadsdk.core.settings.e r10 = com.bytedance.sdk.openadsdk.core.o.d()     // Catch:{ all -> 0x0147 }
            boolean r10 = r10.q()     // Catch:{ all -> 0x0147 }
        L_0x0061:
            r7.a((java.lang.String) r9, (boolean) r10)     // Catch:{ all -> 0x0147 }
            goto L_0x0096
        L_0x0065:
            java.util.Map r10 = r16.b()     // Catch:{ all -> 0x0147 }
            r1.a((java.util.Map<java.lang.String, java.lang.String>) r10, (com.bytedance.sdk.component.f.b.d) r7)     // Catch:{ all -> 0x0147 }
            java.lang.String r10 = "aqromfgsafd$cnzjd<agfpwz#mn6x|j~\u001d@"
            java.lang.String r10 = com.bytedance.sdk.openadsdk.core.g.b.c.a.c$a1699434667851dc(r10)     // Catch:{ all -> 0x0147 }
            r7.a((java.lang.String) r10, (byte[]) r9)     // Catch:{ all -> 0x0147 }
            goto L_0x0096
        L_0x0076:
            org.json.JSONObject r9 = com.bytedance.sdk.component.utils.a.a((org.json.JSONObject) r17)     // Catch:{ all -> 0x0147 }
            boolean r10 = r1.c((org.json.JSONObject) r9)     // Catch:{ all -> 0x0147 }
            if (r10 != 0) goto L_0x0082
            r9 = r17
        L_0x0082:
            java.util.Map r10 = r1.d((org.json.JSONObject) r9)     // Catch:{ all -> 0x0147 }
            r1.a((java.util.Map<java.lang.String, java.lang.String>) r10, (com.bytedance.sdk.component.f.b.d) r7)     // Catch:{ all -> 0x0147 }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x0147 }
            com.bytedance.sdk.openadsdk.core.settings.e r10 = com.bytedance.sdk.openadsdk.core.o.d()     // Catch:{ all -> 0x0147 }
            boolean r10 = r10.q()     // Catch:{ all -> 0x0147 }
            goto L_0x0061
        L_0x0096:
            com.bytedance.sdk.openadsdk.j.a.c r9 = new com.bytedance.sdk.openadsdk.j.a.c     // Catch:{ all -> 0x0147 }
            r9.<init>()     // Catch:{ all -> 0x0147 }
            com.bytedance.sdk.openadsdk.j.a.c r0 = r9.a((java.lang.String) r0)     // Catch:{ all -> 0x0147 }
            com.bytedance.sdk.component.b.a.m r10 = r7.c()     // Catch:{ all -> 0x0147 }
            com.bytedance.sdk.openadsdk.j.a.c r0 = r0.a((com.bytedance.sdk.component.b.a.m) r10)     // Catch:{ all -> 0x0147 }
            r0.a()     // Catch:{ all -> 0x0147 }
            com.bytedance.sdk.component.f.b r0 = r7.a()     // Catch:{ all -> 0x0147 }
            if (r0 == 0) goto L_0x00d0
            boolean r7 = r0.f()     // Catch:{ all -> 0x0147 }
            if (r7 == 0) goto L_0x00d0
            java.lang.String r7 = r0.d()     // Catch:{ all -> 0x0147 }
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7     // Catch:{ all -> 0x0147 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0147 }
            if (r7 != 0) goto L_0x00d0
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch:{ all -> 0x0147 }
            java.lang.String r10 = r0.d()     // Catch:{ all -> 0x0147 }
            r7.<init>(r10)     // Catch:{ all -> 0x0147 }
            boolean r7 = r1.e(r7)     // Catch:{ all -> 0x0147 }
            goto L_0x00d1
        L_0x00d0:
            r7 = 0
        L_0x00d1:
            java.lang.String r10 = "esplv%sicge|b"
            java.lang.String r10 = com.bytedance.sdk.openadsdk.core.video.a.b.b1699434667886dc(r10)     // Catch:{ all -> 0x0147 }
            if (r0 == 0) goto L_0x00de
            int r11 = r0.a()     // Catch:{ all -> 0x0147 }
            goto L_0x00df
        L_0x00de:
            r11 = 0
        L_0x00df:
            r12 = 1
            if (r7 != 0) goto L_0x00ee
            r13 = 200(0xc8, float:2.8E-43)
            if (r11 != r13) goto L_0x00ee
            java.lang.String r10 = "sdpuaw&tip*ecy.|erqvgf"
            java.lang.String r10 = com.bytedance.sdk.openadsdk.core.video.a.b.b1699434667886dc(r10)     // Catch:{ all -> 0x0147 }
            r13 = 1
            goto L_0x00fb
        L_0x00ee:
            if (r0 == 0) goto L_0x00fa
            java.lang.String r13 = r0.b()     // Catch:{ all -> 0x0147 }
            if (r13 == 0) goto L_0x00fa
            java.lang.String r10 = r0.b()     // Catch:{ all -> 0x0147 }
        L_0x00fa:
            r13 = 0
        L_0x00fb:
            if (r0 != 0) goto L_0x00ff
            r14 = 1
            goto L_0x0100
        L_0x00ff:
            r14 = 0
        L_0x0100:
            if (r14 != 0) goto L_0x0109
            boolean r15 = r0.f()     // Catch:{ all -> 0x0147 }
            if (r15 == 0) goto L_0x0109
            goto L_0x010a
        L_0x0109:
            r12 = 0
        L_0x010a:
            com.bytedance.sdk.openadsdk.j.a.c r9 = r9.a((boolean) r12)     // Catch:{ all -> 0x0147 }
            if (r14 == 0) goto L_0x0112
            r12 = r8
            goto L_0x0116
        L_0x0112:
            java.lang.String r12 = r0.d()     // Catch:{ all -> 0x0147 }
        L_0x0116:
            com.bytedance.sdk.openadsdk.j.a.c r9 = r9.c(r12)     // Catch:{ all -> 0x0147 }
            if (r14 == 0) goto L_0x011f
            int r12 = com.bytedance.sdk.openadsdk.j.a.c.b     // Catch:{ all -> 0x0147 }
            goto L_0x0120
        L_0x011f:
            r12 = r11
        L_0x0120:
            com.bytedance.sdk.openadsdk.j.a.c r9 = r9.a((int) r12)     // Catch:{ all -> 0x0147 }
            if (r14 == 0) goto L_0x0127
            goto L_0x012b
        L_0x0127:
            java.lang.String r8 = r0.b()     // Catch:{ all -> 0x0147 }
        L_0x012b:
            com.bytedance.sdk.openadsdk.j.a.c r0 = r9.d(r8)     // Catch:{ all -> 0x0147 }
            r0.c()     // Catch:{ all -> 0x0147 }
            r0 = r17
            r1.a((org.json.JSONObject) r0, (boolean) r2)     // Catch:{ all -> 0x0147 }
            com.bytedance.sdk.openadsdk.b.a.b r0 = com.bytedance.sdk.openadsdk.b.a.a.a     // Catch:{ all -> 0x0147 }
            long r8 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0147 }
            long r8 = r8 - r5
            com.bytedance.sdk.openadsdk.b.a.a.a(r0, r7, r11, r8)     // Catch:{ all -> 0x0147 }
            com.bytedance.sdk.openadsdk.b.e r0 = new com.bytedance.sdk.openadsdk.b.e     // Catch:{ all -> 0x0147 }
            r0.<init>(r7, r11, r10, r13)     // Catch:{ all -> 0x0147 }
            return r0
        L_0x0147:
            r0 = move-exception
            java.lang.String r2 = com.bytedance.sdk.openadsdk.core.g.b.c.a.c$a1699434667851dc(r3)
            java.lang.String r3 = "uqnleaCqmg~+i|`b"
            java.lang.String r3 = com.bytedance.sdk.openadsdk.core.g.b.c.a.c$a1699434667851dc(r3)
            com.bytedance.sdk.component.utils.l.c(r2, r3, r0)
            com.bytedance.sdk.openadsdk.b.e r0 = new com.bytedance.sdk.openadsdk.b.e
            java.lang.String r2 = "sdpumfcXj|yr"
            java.lang.String r2 = com.bytedance.sdk.openadsdk.core.g.b.c.a.c$a1699434667851dc(r2)
            r3 = 509(0x1fd, float:7.13E-43)
            r0.<init>(r4, r3, r2, r4)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.q.a(org.json.JSONObject, java.lang.String, boolean):com.bytedance.sdk.openadsdk.b.e");
    }

    public void a(AdSlot adSlot, s sVar, int i, p.a aVar) {
        final com.bytedance.sdk.openadsdk.core.a.a aVar2 = new com.bytedance.sdk.openadsdk.core.a.a(aVar);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            final AdSlot adSlot2 = adSlot;
            final s sVar2 = sVar;
            final int i2 = i;
            l.b().post(new h(com.bytedance.sdk.openadsdk.core.video.a.b.b1699434667886dc("gdvB`")) {
                public void run() {
                    q.this.b(adSlot2, sVar2, i2, aVar2);
                }
            });
            return;
        }
        b(adSlot, sVar, i, (p.a) aVar2);
    }

    public void a(String str) {
        com.bytedance.sdk.component.f.b.b c = com.bytedance.sdk.openadsdk.k.c.a().b().c();
        c.a(str);
        c.a((com.bytedance.sdk.component.f.a.a) new com.bytedance.sdk.component.f.a.a() {
            public void a(com.bytedance.sdk.component.f.b.c cVar, com.bytedance.sdk.component.f.b bVar) {
                l.b(c.a.c$a1699434667851dc("cmkfjq&eamnbbj.|erqvgf"), bVar.d());
            }

            public void a(com.bytedance.sdk.component.f.b.c cVar, IOException iOException) {
                l.b(c.a.c$a1699434667851dc("cmkfjq&eamnbbj.iqx~"), iOException.toString());
            }
        });
    }

    public void a(String str, List<FilterWord> list, String str2, String str3) {
        JSONObject b2;
        if (com.bytedance.sdk.openadsdk.core.settings.k.a() && (b2 = b(str, list, str2, str3)) != null) {
            d b3 = com.bytedance.sdk.openadsdk.k.c.a().b().b();
            String d = ac.d(e.e1699434667871dc("/`rj+db(}gcdb\"jfc}{xqJsa}wn4"));
            String jSONObject = com.bytedance.sdk.component.utils.a.a(b2).toString();
            b3.a(d);
            b3.c(jSONObject);
            final com.bytedance.sdk.openadsdk.j.a.c cVar = new com.bytedance.sdk.openadsdk.j.a.c();
            cVar.a(d).b(jSONObject).a();
            b3.a((com.bytedance.sdk.component.f.a.a) new com.bytedance.sdk.component.f.a.a() {
                public void a(com.bytedance.sdk.component.f.b.c cVar, com.bytedance.sdk.component.f.b bVar) {
                    com.bytedance.sdk.openadsdk.j.a.c a2;
                    if (bVar != null) {
                        a2 = cVar.a(bVar.f()).a(bVar.a()).d(bVar.b()).c(bVar.d());
                    } else {
                        a2 = cVar.a(false).a(com.bytedance.sdk.openadsdk.j.a.c.b);
                    }
                    a2.c();
                }

                /* JADX WARNING: Code restructure failed: missing block: B:10:0x0026, code lost:
                    r2 = 'J';
                    r3 = '7';
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:8:0x0021, code lost:
                    switch(r3) {
                        case 55: goto L_0x0025;
                        case 56: goto L_0x0025;
                        case 57: goto L_0x0026;
                        default: goto L_0x0024;
                    };
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:9:0x0025, code lost:
                    return;
                 */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void a(com.bytedance.sdk.component.f.b.c r2, java.io.IOException r3) {
                    /*
                        r1 = this;
                        com.bytedance.sdk.openadsdk.j.a.c r2 = r5
                        r0 = 0
                        com.bytedance.sdk.openadsdk.j.a.c r2 = r2.a((boolean) r0)
                        if (r3 == 0) goto L_0x000e
                        java.lang.String r3 = r3.getMessage()
                        goto L_0x000f
                    L_0x000e:
                        r3 = 0
                    L_0x000f:
                        com.bytedance.sdk.openadsdk.j.a.c r2 = r2.d(r3)
                        r2.c()
                    L_0x0016:
                        r2 = 73
                        r3 = 96
                    L_0x001a:
                        switch(r2) {
                            case 72: goto L_0x0026;
                            case 73: goto L_0x001e;
                            case 74: goto L_0x0021;
                            default: goto L_0x001d;
                        }
                    L_0x001d:
                        goto L_0x002b
                    L_0x001e:
                        switch(r3) {
                            case 94: goto L_0x0016;
                            case 95: goto L_0x0026;
                            case 96: goto L_0x0026;
                            default: goto L_0x0021;
                        }
                    L_0x0021:
                        switch(r3) {
                            case 55: goto L_0x0025;
                            case 56: goto L_0x0025;
                            case 57: goto L_0x0026;
                            default: goto L_0x0024;
                        }
                    L_0x0024:
                        goto L_0x0016
                    L_0x0025:
                        return
                    L_0x0026:
                        r2 = 74
                        r3 = 55
                        goto L_0x001a
                    L_0x002b:
                        r2 = 72
                        goto L_0x001a
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.q.AnonymousClass6.a(com.bytedance.sdk.component.f.b.c, java.io.IOException):void");
                }
            });
        }
    }

    public void a(JSONObject jSONObject, final p.b bVar) {
        if (!com.bytedance.sdk.openadsdk.core.settings.k.a()) {
            if (bVar != null) {
                bVar.a(1000, com.bytedance.sdk.component.f.c.d.d1699434667873dc("Ae\"qatsb{}*b-zj}a}aug{a9jzin{{\f\u0001rOADUB\bJEEXLM[\u0010H]FF\u0015fVV^V^\u001c|s"));
            }
        } else if (jSONObject != null && bVar != null) {
            JSONObject a2 = com.bytedance.sdk.component.utils.a.a(jSONObject);
            final com.bytedance.sdk.openadsdk.j.a.c cVar = new com.bytedance.sdk.openadsdk.j.a.c();
            d b2 = com.bytedance.sdk.openadsdk.k.c.a().b().b();
            try {
                String a3 = com.bytedance.sdk.openadsdk.e.d.a(b2, ac.d(com.bytedance.sdk.component.f.c.d.d1699434667873dc("/`rj+db(}gcdb\"}k{>`vctdsGosyr1mEVCQ@\n")));
                b2.a(a3);
                cVar.a(a3);
            } catch (Exception e) {
                l.e(com.bytedance.sdk.component.f.c.d.d1699434667873dc("NdvBtlOjxe"), e.getMessage());
            }
            b2.c(a2.toString());
            cVar.a(b2.c()).a();
            b2.a((com.bytedance.sdk.component.f.a.a) new com.bytedance.sdk.component.f.a.a() {
                /* JADX WARNING: Can't wrap try/catch for region: R(9:5|6|7|(1:9)(1:10)|11|(3:13|14|15)|16|17|(2:19|20)(2:21|(2:23|24)(2:25|38))) */
                /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0064 */
                /* JADX WARNING: Removed duplicated region for block: B:19:0x006e A[Catch:{ JSONException -> 0x008e }] */
                /* JADX WARNING: Removed duplicated region for block: B:21:0x007c A[Catch:{ JSONException -> 0x008e }] */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void a(com.bytedance.sdk.component.f.b.c r3, com.bytedance.sdk.component.f.b r4) {
                    /*
                        r2 = this;
                        if (r4 == 0) goto L_0x00ea
                        boolean r3 = r4.f()
                        if (r3 == 0) goto L_0x00a0
                        java.lang.String r3 = r4.d()
                        java.lang.CharSequence r3 = (java.lang.CharSequence) r3
                        boolean r3 = android.text.TextUtils.isEmpty(r3)
                        if (r3 != 0) goto L_0x00a0
                        com.bytedance.sdk.openadsdk.j.a.c r3 = r0
                        r0 = 1
                        com.bytedance.sdk.openadsdk.j.a.c r3 = r3.a((boolean) r0)
                        int r0 = r4.a()
                        com.bytedance.sdk.openadsdk.j.a.c r3 = r3.a((int) r0)
                        java.lang.String r0 = r4.d()
                        com.bytedance.sdk.openadsdk.j.a.c r3 = r3.c(r0)
                        r3.c()
                        org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ JSONException -> 0x008e }
                        java.lang.String r4 = r4.d()     // Catch:{ JSONException -> 0x008e }
                        r3.<init>(r4)     // Catch:{ JSONException -> 0x008e }
                        java.lang.String r4 = "cxrkaw"
                        java.lang.String r4 = com.bytedance.sdk.openadsdk.core.g.b.c.a.c$a1699434667851dc(r4)     // Catch:{ JSONException -> 0x008e }
                        r0 = -1
                        int r4 = r3.optInt(r4, r0)     // Catch:{ JSONException -> 0x008e }
                        java.lang.String r0 = "mdqpebc"
                        java.lang.String r0 = com.bytedance.sdk.openadsdk.core.g.b.c.a.c$a1699434667851dc(r0)     // Catch:{ JSONException -> 0x008e }
                        java.lang.String r0 = r3.optString(r0)     // Catch:{ JSONException -> 0x008e }
                        r1 = 3
                        if (r4 != r1) goto L_0x0054
                        java.lang.String r4 = com.bytedance.sdk.component.utils.a.c(r0)     // Catch:{ JSONException -> 0x008e }
                        goto L_0x0055
                    L_0x0054:
                        r4 = 0
                    L_0x0055:
                        r0 = r4
                        java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ JSONException -> 0x008e }
                        boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ JSONException -> 0x008e }
                        if (r0 != 0) goto L_0x0064
                        org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ all -> 0x0064 }
                        r0.<init>(r4)     // Catch:{ all -> 0x0064 }
                        r3 = r0
                    L_0x0064:
                        com.bytedance.sdk.openadsdk.core.q$b r3 = com.bytedance.sdk.openadsdk.core.q.b.a(r3)     // Catch:{ JSONException -> 0x008e }
                        int r4 = r3.a     // Catch:{ JSONException -> 0x008e }
                        r0 = 20000(0x4e20, float:2.8026E-41)
                        if (r4 == r0) goto L_0x007c
                        com.bytedance.sdk.openadsdk.core.p$b r4 = r6     // Catch:{ JSONException -> 0x008e }
                        int r0 = r3.a     // Catch:{ JSONException -> 0x008e }
                        int r3 = r3.a     // Catch:{ JSONException -> 0x008e }
                        java.lang.String r3 = com.bytedance.sdk.openadsdk.core.g.a(r3)     // Catch:{ JSONException -> 0x008e }
                        r4.a(r0, r3)     // Catch:{ JSONException -> 0x008e }
                        return
                    L_0x007c:
                        com.bytedance.sdk.openadsdk.core.model.w r4 = r3.c     // Catch:{ JSONException -> 0x008e }
                        if (r4 != 0) goto L_0x0088
                        com.bytedance.sdk.openadsdk.core.q r3 = com.bytedance.sdk.openadsdk.core.q.this     // Catch:{ JSONException -> 0x008e }
                        com.bytedance.sdk.openadsdk.core.p$b r4 = r6     // Catch:{ JSONException -> 0x008e }
                        r3.a((com.bytedance.sdk.openadsdk.core.p.b) r4)     // Catch:{ JSONException -> 0x008e }
                        return
                    L_0x0088:
                        com.bytedance.sdk.openadsdk.core.p$b r4 = r6     // Catch:{ JSONException -> 0x008e }
                        r4.a(r3)     // Catch:{ JSONException -> 0x008e }
                        goto L_0x0101
                    L_0x008e:
                        r3 = move-exception
                        java.lang.String r4 = "NdvBtlOjxe"
                        java.lang.String r4 = com.bytedance.sdk.openadsdk.core.g.b.c.a.c$a1699434667851dc(r4)
                        r0 = r3
                        org.json.JSONException r0 = (org.json.JSONException) r0
                        java.lang.String r3 = r3.getMessage()
                        com.bytedance.sdk.component.utils.l.e(r4, r3)
                        goto L_0x00fa
                    L_0x00a0:
                        com.bytedance.sdk.openadsdk.j.a.c r3 = r0
                        boolean r0 = r4.f()
                        com.bytedance.sdk.openadsdk.j.a.c r3 = r3.a((boolean) r0)
                        java.lang.String r0 = r4.d()
                        com.bytedance.sdk.openadsdk.j.a.c r3 = r3.c(r0)
                        int r0 = r4.a()
                        com.bytedance.sdk.openadsdk.j.a.c r3 = r3.a((int) r0)
                        java.lang.String r0 = r4.b()
                        com.bytedance.sdk.openadsdk.j.a.c r3 = r3.d(r0)
                        r3.c()
                        r3 = -2
                        java.lang.String r3 = com.bytedance.sdk.openadsdk.core.g.a(r3)
                        int r0 = r4.a()
                        boolean r1 = r4.f()
                        if (r1 != 0) goto L_0x00e4
                        java.lang.String r1 = r4.b()
                        java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                        boolean r1 = android.text.TextUtils.isEmpty(r1)
                        if (r1 != 0) goto L_0x00e4
                        java.lang.String r3 = r4.b()
                    L_0x00e4:
                        com.bytedance.sdk.openadsdk.core.p$b r4 = r6
                        r4.a(r0, r3)
                        goto L_0x0101
                    L_0x00ea:
                        com.bytedance.sdk.openadsdk.j.a.c r3 = r0
                        r4 = 0
                        com.bytedance.sdk.openadsdk.j.a.c r3 = r3.a((boolean) r4)
                        int r4 = com.bytedance.sdk.openadsdk.j.a.c.b
                        com.bytedance.sdk.openadsdk.j.a.c r3 = r3.a((int) r4)
                        r3.c()
                    L_0x00fa:
                        com.bytedance.sdk.openadsdk.core.q r3 = com.bytedance.sdk.openadsdk.core.q.this
                        com.bytedance.sdk.openadsdk.core.p$b r4 = r6
                        r3.a((com.bytedance.sdk.openadsdk.core.p.b) r4)
                    L_0x0101:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.q.AnonymousClass7.a(com.bytedance.sdk.component.f.b.c, com.bytedance.sdk.component.f.b):void");
                }

                public void a(com.bytedance.sdk.component.f.b.c cVar, IOException iOException) {
                    String message = iOException != null ? iOException.getMessage() : "";
                    cVar.a(false).d(message).c();
                    bVar.a(-2, message);
                }
            });
        }
    }

    public void a(JSONObject jSONObject, String str) {
        d b2 = com.bytedance.sdk.openadsdk.k.c.a().b().b();
        b2.a(str);
        b2.a(jSONObject);
        b2.a((com.bytedance.sdk.component.f.a.a) new com.bytedance.sdk.component.f.a.a() {
            public void a(com.bytedance.sdk.component.f.b.c cVar, com.bytedance.sdk.component.f.b bVar) {
                l.b(com.bykv.vk.openvk.component.video.api.c.b.b1699434667889dc("eyg`TSRhIyg+xmluba"), bVar.d());
            }

            public void a(com.bytedance.sdk.component.f.b.c cVar, IOException iOException) {
                l.b(com.bykv.vk.openvk.component.video.api.c.b.b1699434667889dc("eyg`TSRhIyg+jlgc"), iOException.toString());
            }
        });
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.json.JSONObject b(org.json.JSONObject r6) {
        /*
            r5 = this;
            java.lang.String r0 = "atawmjhXx{chi"
            if (r6 != 0) goto L_0x0005
            return r6
        L_0x0005:
            java.lang.String r1 = "cxrkaw"
            java.lang.String r1 = com.bytedance.sdk.openadsdk.core.model.j.j1699434667891dc(r1)     // Catch:{ Exception -> 0x0041 }
            r2 = -1
            int r1 = r6.optInt(r1, r2)     // Catch:{ Exception -> 0x0041 }
            java.lang.String r2 = "mdqpebc"
            java.lang.String r2 = com.bytedance.sdk.openadsdk.core.model.j.j1699434667891dc(r2)     // Catch:{ Exception -> 0x0041 }
            java.lang.String r2 = r6.optString(r2)     // Catch:{ Exception -> 0x0041 }
            java.lang.String r3 = com.bytedance.sdk.openadsdk.core.model.j.j1699434667891dc(r0)     // Catch:{ Exception -> 0x0041 }
            java.lang.String r4 = ""
            java.lang.String r3 = r6.optString(r3, r4)     // Catch:{ Exception -> 0x0041 }
            r4 = 3
            if (r1 != r4) goto L_0x002b
            java.lang.String r2 = com.bytedance.sdk.component.utils.a.c(r2)     // Catch:{ Exception -> 0x0041 }
        L_0x002b:
            r1 = r2
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch:{ Exception -> 0x0041 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x0041 }
            if (r1 != 0) goto L_0x0041
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{  }
            r1.<init>(r2)     // Catch:{  }
            java.lang.String r6 = com.bytedance.sdk.openadsdk.core.model.j.j1699434667891dc(r0)     // Catch:{ all -> 0x0040 }
            r1.put(r6, r3)     // Catch:{ all -> 0x0040 }
        L_0x0040:
            r6 = r1
        L_0x0041:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.q.b(org.json.JSONObject):org.json.JSONObject");
    }
}

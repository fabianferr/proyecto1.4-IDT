package com.umlaut.crowd.internal;

import android.util.SparseArray;
import java.net.URLDecoder;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class we {
    private static final String A = "contentLength";
    private static final String B = "approxDurationMs";
    private static final String C = "bitrate";
    private static final String D = "averageBitrate";
    private static final String E = "qualityLabel";
    private static final String F = "audioSampleRate";
    private static final String G = "eotf";
    private static final String H = "primaries";
    private static final String I = "mimeType";
    private static final String J = "url";
    private static final String K = "cipher";
    private static final String L = "ip";
    private static final String M = "initcwndbps";
    private static final String j = "videoDetails";
    private static final String k = "title";
    private static final String l = "author";
    private static final String m = "isLiveContent";
    private static final String n = "liveChunkReadahead";
    private static final String o = "playerConfig";
    private static final String p = "audioConfig";
    private static final String q = "loudnessDb";
    private static final String r = "livePlayerConfig";
    private static final String s = "liveReadaheadSeconds";
    private static final String t = "requiressl=yes";
    private static final String u = "streamingData";
    private static final String v = "adaptiveFormats";
    private static final String w = "fps";
    private static final String x = "itag";
    private static final String y = "width";
    private static final String z = "height";
    private String a;
    String b = "";
    String c = "";
    boolean d = false;
    boolean e = false;
    float f = 0.0f;
    int g = -1;
    int h = -1;
    SparseArray<df> i;

    we(String str) {
        this.a = str;
        this.i = new SparseArray<>();
        a();
    }

    private void a() {
        JSONObject optJSONObject;
        JSONArray optJSONArray;
        JSONObject optJSONObject2;
        JSONObject optJSONObject3;
        JSONObject optJSONObject4;
        JSONObject optJSONObject5;
        try {
            JSONObject jSONObject = new JSONObject(this.a);
            this.d = this.a.contains(t);
            if (jSONObject.has(j) && (optJSONObject5 = jSONObject.optJSONObject(j)) != null) {
                if (optJSONObject5.has("title")) {
                    this.b = optJSONObject5.optString("title", "");
                }
                if (optJSONObject5.has(l)) {
                    this.c = optJSONObject5.optString(l, "");
                }
                if (optJSONObject5.has(m)) {
                    this.e = optJSONObject5.optBoolean(m, false);
                }
                if (optJSONObject5.has(n)) {
                    this.g = optJSONObject5.optInt(n, -1);
                }
            }
            if (jSONObject.has(o) && (optJSONObject2 = jSONObject.optJSONObject(o)) != null) {
                if (optJSONObject2.has(p) && (optJSONObject4 = optJSONObject2.optJSONObject(p)) != null && optJSONObject4.has(q)) {
                    this.f = (float) optJSONObject4.optDouble(q, 0.0d);
                }
                if (optJSONObject2.has(r) && (optJSONObject3 = optJSONObject2.optJSONObject(r)) != null && optJSONObject3.has(s)) {
                    this.h = optJSONObject3.optInt(s, -1);
                }
            }
            if (jSONObject.has(u) && (optJSONObject = jSONObject.optJSONObject(u)) != null && optJSONObject.has(v) && (optJSONArray = optJSONObject.optJSONArray(v)) != null && optJSONArray.length() > 0) {
                this.i = new SparseArray<>();
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    JSONObject optJSONObject6 = optJSONArray.optJSONObject(i2);
                    if (optJSONObject6 != null) {
                        df a2 = a(optJSONObject6);
                        this.i.append(a2.Tag, a2);
                    }
                }
            }
        } catch (JSONException unused) {
        }
    }

    private df a(JSONObject jSONObject) {
        df dfVar = new df();
        if (jSONObject.has(w)) {
            dfVar.VideoFps = jSONObject.optInt(w);
        }
        if (jSONObject.has(x)) {
            dfVar.Tag = jSONObject.optInt(x);
        }
        if (jSONObject.has("width")) {
            dfVar.VideoWidth = jSONObject.optInt("width");
        }
        if (jSONObject.has("height")) {
            dfVar.VideoHeight = jSONObject.optInt("height");
        }
        if (jSONObject.has(E)) {
            dfVar.VideoQuality = ye.getQuality(jSONObject.optString(E));
        }
        if (jSONObject.has(G)) {
            dfVar.VideoEOTF = jSONObject.optString(G, "");
        }
        if (jSONObject.has(H)) {
            dfVar.VideoPrimaries = jSONObject.optString(H, "");
        }
        if (jSONObject.has(C)) {
            dfVar.Bitrate = jSONObject.optLong(C);
        } else if (jSONObject.has(D)) {
            dfVar.Bitrate = jSONObject.optLong(D);
        }
        if (jSONObject.has(A)) {
            try {
                dfVar.TotalBytes = Long.valueOf(jSONObject.optString(A, "-1")).longValue();
            } catch (NumberFormatException unused) {
            }
        }
        if (jSONObject.has(B)) {
            try {
                dfVar.TotalDuration = Long.valueOf(jSONObject.optString(B, "-1")).longValue();
            } catch (NumberFormatException unused2) {
            }
        }
        if (jSONObject.has(F)) {
            try {
                dfVar.AudioSampleRate = Long.valueOf(jSONObject.optString(F, "-1")).longValue();
            } catch (NumberFormatException unused3) {
            }
        }
        int i2 = 0;
        if (jSONObject.has(I)) {
            try {
                String[] split = URLDecoder.decode(jSONObject.optString(I, ""), "UTF-8").replaceAll(" ", "").replaceAll("\"", "").split(";codecs=");
                if (split.length > 0) {
                    dfVar.Mime = split[0];
                }
                if (split.length > 1) {
                    dfVar.Codec = split[1];
                }
            } catch (Exception unused4) {
            }
        }
        if (jSONObject.has("url")) {
            a(dfVar, jSONObject.optString("url", ""));
        } else if (jSONObject.has(K)) {
            String optString = jSONObject.optString(K, "");
            if (!optString.isEmpty()) {
                String[] split2 = optString.split("&");
                int length = split2.length;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    String str = split2[i2];
                    if (str.startsWith("url")) {
                        a(dfVar, str.replaceAll("url=", ""));
                        break;
                    }
                    i2++;
                }
            }
        }
        return dfVar;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:17|18|19|20|50) */
    /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0042 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(com.umlaut.crowd.internal.df r11, java.lang.String r12) {
        /*
            r10 = this;
            java.lang.String r0 = "initcwndbps"
            java.lang.String r1 = "ip"
            java.lang.String r2 = "\\?"
            if (r12 == 0) goto L_0x008b
            boolean r3 = r12.isEmpty()
            if (r3 == 0) goto L_0x0010
            goto L_0x008b
        L_0x0010:
            r3 = 0
            java.lang.String r4 = "UTF-8"
            java.lang.String r12 = java.net.URLDecoder.decode(r12, r4)     // Catch:{ Exception -> 0x0022 }
            java.lang.String[] r4 = r12.split(r2)     // Catch:{ Exception -> 0x0020 }
            r4 = r4[r3]     // Catch:{ Exception -> 0x0020 }
            r11.Server = r4     // Catch:{ Exception -> 0x0020 }
            goto L_0x0023
        L_0x0020:
            goto L_0x0023
        L_0x0022:
            r12 = 0
        L_0x0023:
            if (r12 == 0) goto L_0x008b
            r4 = -1
            android.net.Uri r6 = android.net.Uri.parse(r12)     // Catch:{ Exception -> 0x0045 }
            java.lang.String r7 = r6.getQueryParameter(r1)     // Catch:{ Exception -> 0x0045 }
            r11.IP = r7     // Catch:{ Exception -> 0x0045 }
            java.lang.String r6 = r6.getQueryParameter(r0)     // Catch:{ Exception -> 0x0045 }
            if (r6 == 0) goto L_0x008b
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ Exception -> 0x0042 }
            long r6 = r6.longValue()     // Catch:{ Exception -> 0x0042 }
            r11.Initcwndbps = r6     // Catch:{ Exception -> 0x0042 }
            goto L_0x008b
        L_0x0042:
            r11.Initcwndbps = r4     // Catch:{ Exception -> 0x0045 }
            goto L_0x008b
        L_0x0045:
            java.lang.String[] r12 = r12.split(r2)
            if (r12 == 0) goto L_0x008b
            int r2 = r12.length
            r6 = 1
            if (r2 <= r6) goto L_0x008b
            r12 = r12[r6]
            java.lang.String r2 = "&"
            java.lang.String[] r12 = r12.split(r2)
            int r2 = r12.length
            r7 = 0
        L_0x005a:
            if (r7 >= r2) goto L_0x008b
            r8 = r12[r7]
            java.lang.String r9 = "="
            java.lang.String[] r8 = r8.split(r9)
            r9 = r8[r3]
            boolean r9 = r9.equalsIgnoreCase(r1)
            if (r9 == 0) goto L_0x0071
            r8 = r8[r6]
            r11.IP = r8
            goto L_0x0088
        L_0x0071:
            r9 = r8[r3]
            boolean r9 = r9.equalsIgnoreCase(r0)
            if (r9 == 0) goto L_0x0088
            r8 = r8[r6]     // Catch:{ Exception -> 0x0086 }
            java.lang.Long r8 = java.lang.Long.valueOf(r8)     // Catch:{ Exception -> 0x0086 }
            long r8 = r8.longValue()     // Catch:{ Exception -> 0x0086 }
            r11.Initcwndbps = r8     // Catch:{ Exception -> 0x0086 }
            goto L_0x0088
        L_0x0086:
            r11.Initcwndbps = r4
        L_0x0088:
            int r7 = r7 + 1
            goto L_0x005a
        L_0x008b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.we.a(com.umlaut.crowd.internal.df, java.lang.String):void");
    }
}

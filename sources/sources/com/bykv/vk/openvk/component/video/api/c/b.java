package com.bykv.vk.openvk.component.video.api.c;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import org.json.JSONObject;

/* compiled from: VideoInfo */
public class b {
    private int a;
    private int b;
    private long c;
    private double d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private double k;
    private int l;
    private int m;
    private float n = -1.0f;
    private int o = 0;
    private int p = 0;
    private int q = 0;
    private int r = 0;
    private int s = 307200;
    private int t = 1;

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0026, code lost:
        r0 = 'I';
        r1 = '`';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000b, code lost:
        switch(r1) {
            case 55: goto L_0x0026;
            case 56: goto L_0x0026;
            case 57: goto L_0x000f;
            default: goto L_0x000e;
        };
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String b1699434667889dc(java.lang.String r2) {
        /*
        L_0x0000:
            r0 = 74
            r1 = 55
        L_0x0004:
            switch(r0) {
                case 72: goto L_0x0000;
                case 73: goto L_0x0008;
                case 74: goto L_0x000b;
                default: goto L_0x0007;
            }
        L_0x0007:
            goto L_0x002b
        L_0x0008:
            switch(r1) {
                case 94: goto L_0x0026;
                case 95: goto L_0x000f;
                case 96: goto L_0x000f;
                default: goto L_0x000b;
            }
        L_0x000b:
            switch(r1) {
                case 55: goto L_0x0026;
                case 56: goto L_0x0026;
                case 57: goto L_0x000f;
                default: goto L_0x000e;
            }
        L_0x000e:
            goto L_0x0026
        L_0x000f:
            char[] r2 = r2.toCharArray()
            r0 = 0
        L_0x0014:
            int r1 = r2.length
            if (r0 >= r1) goto L_0x0020
            char r1 = r2[r0]
            r1 = r1 ^ r0
            char r1 = (char) r1
            r2[r0] = r1
            int r0 = r0 + 1
            goto L_0x0014
        L_0x0020:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r2)
            return r0
        L_0x0026:
            r0 = 73
            r1 = 96
            goto L_0x0004
        L_0x002b:
            r0 = 72
            goto L_0x0004
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.openvk.component.video.api.c.b.b1699434667889dc(java.lang.String):java.lang.String");
    }

    public int a() {
        return this.l;
    }

    public void a(double d2) {
        this.d = d2;
    }

    public void a(int i2) {
        this.l = i2;
    }

    public void a(long j2) {
        this.c = j2;
    }

    public void a(String str) {
        this.e = str;
    }

    public int b() {
        return this.a;
    }

    public void b(int i2) {
        this.a = i2;
    }

    public void b(String str) {
        this.f = str;
    }

    public int c() {
        return this.b;
    }

    public void c(int i2) {
        this.b = i2;
    }

    public void c(String str) {
        this.g = str;
    }

    public int d() {
        return this.m;
    }

    public void d(int i2) {
        this.m = i2;
    }

    public void d(String str) {
        this.h = str;
    }

    public long e() {
        return this.c;
    }

    public void e(int i2) {
        this.s = i2;
    }

    public void e(String str) {
        this.i = str;
    }

    public double f() {
        return this.d;
    }

    public void f(int i2) {
        this.q = i2;
    }

    public void f(String str) {
        this.j = str;
    }

    public double g() {
        return this.k;
    }

    public void g(int i2) {
        this.r = i2;
    }

    public float h() {
        return this.n;
    }

    public void h(int i2) {
        this.o = i2;
    }

    public String i() {
        return this.e;
    }

    public void i(int i2) {
        this.p = i2;
    }

    public String j() {
        return this.f;
    }

    public void j(int i2) {
        this.t = Math.min(4, Math.max(1, i2));
    }

    public String k() {
        return this.g;
    }

    public String l() {
        return this.h;
    }

    public String m() {
        return this.i;
    }

    public String n() {
        if (TextUtils.isEmpty(this.j)) {
            this.j = com.bykv.vk.openvk.component.video.api.f.b.a(this.g);
        }
        return this.j;
    }

    public int o() {
        if (this.s < 0) {
            this.s = 307200;
        }
        long j2 = this.c;
        if (((long) this.s) > j2) {
            this.s = (int) j2;
        }
        return this.s;
    }

    public int p() {
        return this.q;
    }

    public int q() {
        return this.r;
    }

    public JSONObject r() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cover_height", b());
            jSONObject.put("cover_url", j());
            jSONObject.put("cover_width", c());
            jSONObject.put(CampaignEx.JSON_NATIVE_VIDEO_ENDCARD, l());
            jSONObject.put("file_hash", n());
            jSONObject.put("resolution", i());
            jSONObject.put("size", e());
            jSONObject.put("video_duration", f());
            jSONObject.put(CampaignEx.JSON_KEY_VIDEO_URL, k());
            jSONObject.put("playable_download_url", m());
            jSONObject.put("if_playable_loading_show", s());
            jSONObject.put("remove_loading_page_type", t());
            jSONObject.put("fallback_endcard_judge", a());
            jSONObject.put("video_preload_size", o());
            jSONObject.put("reward_video_cached_type", p());
            jSONObject.put("execute_cached_type", q());
            jSONObject.put("endcard_render", d());
            jSONObject.put("replay_time", w());
            jSONObject.put("play_speed_ratio", (double) h());
            if (g() > 0.0d) {
                jSONObject.put("start", g());
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public int s() {
        return this.o;
    }

    public int t() {
        return this.p;
    }

    public boolean u() {
        return this.r == 1;
    }

    public boolean v() {
        return this.q == 0;
    }

    public int w() {
        return this.t;
    }
}

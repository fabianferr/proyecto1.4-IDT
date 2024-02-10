package com.m2catalyst.m2sdk;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SpeedtestConfig */
public final class k6 {
    public final double A;
    public final boolean B;
    public final String C;
    public final boolean D;
    public final String E;
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final double g;
    public final double h;
    public final int i;
    public final int j;
    public final int k;
    public final int l;
    public final int m;
    public final int n;
    public final int o;
    public final int p;
    public final int q;
    public final int r;
    public final int s;
    public final int t;
    public final String u;
    public final int v;
    public final int w;
    public final boolean x;
    public final int y;
    public String z;

    public k6() {
        this.a = 100;
        this.b = 20;
        this.c = 3;
        this.d = 3;
        this.e = 300;
        this.f = 300;
        this.g = 1.5d;
        this.h = 1.5d;
        this.i = 5000;
        this.j = 10000;
        this.k = 5000;
        this.l = 10000;
        this.m = 2000;
        this.n = 5000;
        this.o = -1;
        this.p = -1;
        this.q = -1;
        this.r = 16384;
        this.s = -1;
        this.t = -1;
        this.u = "attempt-restart";
        this.v = 15;
        this.w = 15;
        this.x = true;
        this.y = 10;
        this.z = "";
        this.A = 1.06d;
        this.B = true;
        this.C = "km";
        this.D = false;
        this.E = "IP_D_U";
        a();
    }

    public final void a() {
        if (this.a < 1) {
            throw new IllegalArgumentException("dl_ckSize must be at least 1");
        } else if (this.b < 1) {
            throw new IllegalArgumentException("ul_ckSize must be at least 1");
        } else if (this.c < 1) {
            throw new IllegalArgumentException("dl_parallelStreams must be at least 1");
        } else if (this.d < 1) {
            throw new IllegalArgumentException("ul_parallelStreams must be at least 1");
        } else if (this.e < 0) {
            throw new IllegalArgumentException("dl_streamDelay must be at least 0");
        } else if (this.f < 0) {
            throw new IllegalArgumentException("ul_streamDelay must be at least 0");
        } else if (this.g < 0.0d) {
            throw new IllegalArgumentException("dl_graceTime must be at least 0");
        } else if (this.h < 0.0d) {
            throw new IllegalArgumentException("ul_graceTime must be at least 0");
        } else if (!this.u.equals("fail") && !this.u.equals("attempt-restart") && !this.u.equals("must-restart")) {
            throw new IllegalArgumentException("errorHandlingMode must be fail, attempt-restart, or must-restart");
        } else if (this.v < 1) {
            throw new IllegalArgumentException("time_dl_max must be at least 1");
        } else if (this.w < 1) {
            throw new IllegalArgumentException("time_ul_max must be at least 1");
        } else if (this.y < 1) {
            throw new IllegalArgumentException("count_ping must be at least 1");
        } else if (this.A < 1.0d) {
            throw new IllegalArgumentException("overheadCompensationFactor must be at least 1");
        } else if (this.C.equals("no") || this.C.equals("km") || this.C.equals("mi")) {
            char[] charArray = this.E.toCharArray();
            int length = charArray.length;
            int i2 = 0;
            while (i2 < length) {
                char c2 = charArray[i2];
                if (c2 == 'I' || c2 == 'P' || c2 == 'D' || c2 == 'U' || c2 == '_') {
                    i2++;
                } else {
                    throw new IllegalArgumentException("test_order can only contain characters I, P, D, U, _");
                }
            }
        } else {
            throw new IllegalArgumentException("getIP_distance must be no, km or miles");
        }
    }

    /* renamed from: b */
    public final k6 clone() {
        return new k6(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, this.r, this.s, this.t, this.u, this.v, this.w, this.x, this.y, this.z, this.A, this.B, this.C, this.D, this.E);
    }

    public k6(int i2, int i3, int i4, int i5, int i6, int i7, double d2, double d3, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, String str, int i20, int i21, boolean z2, int i22, String str2, double d4, boolean z3, String str3, boolean z4, String str4) {
        this.a = 100;
        this.b = 20;
        this.c = 3;
        this.d = 3;
        this.e = 300;
        this.f = 300;
        this.g = 1.5d;
        this.h = 1.5d;
        this.i = 5000;
        this.j = 10000;
        this.k = 5000;
        this.l = 10000;
        this.m = 2000;
        this.n = 5000;
        this.o = -1;
        this.p = -1;
        this.q = -1;
        this.r = 16384;
        this.s = -1;
        this.t = -1;
        this.u = "attempt-restart";
        this.v = 15;
        this.w = 15;
        this.x = true;
        this.y = 10;
        this.A = 1.06d;
        this.B = true;
        this.C = "km";
        this.D = false;
        this.E = "IP_D_U";
        this.a = i2;
        this.b = i3;
        this.c = i4;
        this.d = i5;
        this.e = i6;
        this.f = i7;
        this.g = d2;
        this.h = d3;
        this.i = i8;
        this.j = i9;
        this.k = i10;
        this.l = i11;
        this.m = i12;
        this.n = i13;
        this.o = i14;
        this.p = i15;
        this.q = i16;
        this.r = i17;
        this.s = i18;
        this.t = i19;
        this.u = str;
        this.v = i20;
        this.w = i21;
        this.x = z2;
        this.y = i22;
        this.z = str2;
        this.A = d4;
        this.B = z3;
        this.C = str3;
        this.D = z4;
        this.E = str4;
        a();
    }

    public k6(JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        String str = "ping_soTimeout";
        this.a = 100;
        this.b = 20;
        this.c = 3;
        this.d = 3;
        this.e = 300;
        this.f = 300;
        String str2 = "ul_soTimeout";
        this.g = 1.5d;
        this.h = 1.5d;
        this.i = 5000;
        this.j = 10000;
        this.k = 5000;
        this.l = 10000;
        this.m = 2000;
        this.n = 5000;
        this.o = -1;
        this.p = -1;
        this.q = -1;
        this.r = 16384;
        this.s = -1;
        this.t = -1;
        this.u = "attempt-restart";
        this.v = 15;
        this.w = 15;
        this.x = true;
        this.y = 10;
        this.z = "";
        String str3 = "dl_soTimeout";
        this.A = 1.06d;
        this.B = true;
        this.C = "km";
        this.D = false;
        this.E = "IP_D_U";
        try {
            if (jSONObject2.has("dl_ckSize")) {
                this.a = jSONObject2.getInt("dl_ckSize");
            }
            if (jSONObject2.has("ul_ckSize")) {
                this.b = jSONObject2.getInt("ul_ckSize");
            }
            if (jSONObject2.has("dl_parallelStreams")) {
                this.c = jSONObject2.getInt("dl_parallelStreams");
            }
            if (jSONObject2.has("ul_parallelStreams")) {
                this.d = jSONObject2.getInt("ul_parallelStreams");
            }
            if (jSONObject2.has("dl_streamDelay")) {
                this.e = jSONObject2.getInt("dl_streamDelay");
            }
            if (jSONObject2.has("ul_streamDelay")) {
                this.f = jSONObject2.getInt("ul_streamDelay");
            }
            if (jSONObject2.has("dl_graceTime")) {
                this.g = jSONObject2.getDouble("dl_graceTime");
            }
            if (jSONObject2.has("ul_graceTime")) {
                this.h = jSONObject2.getDouble("ul_graceTime");
            }
            if (jSONObject2.has("dl_connectTimeout")) {
                this.i = jSONObject2.getInt("dl_connectTimeout");
            }
            if (jSONObject2.has("ul_connectTimeout")) {
                this.k = jSONObject2.getInt("ul_connectTimeout");
            }
            if (jSONObject2.has("ping_connectTimeout")) {
                this.m = jSONObject2.getInt("ping_connectTimeout");
            }
            String str4 = str3;
            if (jSONObject2.has(str4)) {
                this.j = jSONObject2.getInt(str4);
            }
            String str5 = str2;
            if (jSONObject2.has(str5)) {
                this.l = jSONObject2.getInt(str5);
            }
            String str6 = str;
            if (jSONObject2.has(str6)) {
                this.n = jSONObject2.getInt(str6);
            }
            if (jSONObject2.has("dl_recvBuffer")) {
                this.o = jSONObject2.getInt("dl_recvBuffer");
            }
            if (jSONObject2.has("ul_recvBuffer")) {
                this.q = jSONObject2.getInt("ul_recvBuffer");
            }
            if (jSONObject2.has("ping_recvBuffer")) {
                this.s = jSONObject2.getInt("ping_recvBuffer");
            }
            if (jSONObject2.has("dl_sendBuffer")) {
                this.p = jSONObject2.getInt("dl_sendBuffer");
            }
            if (jSONObject2.has("ul_sendBuffer")) {
                this.r = jSONObject2.getInt("ul_sendBuffer");
            }
            if (jSONObject2.has("ping_sendBuffer")) {
                this.t = jSONObject2.getInt("ping_sendBuffer");
            }
            if (jSONObject2.has("errorHandlingMode")) {
                this.u = jSONObject2.getString("errorHandlingMode");
            }
            if (jSONObject2.has("time_dl_max")) {
                this.v = jSONObject2.getInt("time_dl_max");
            }
            if (jSONObject2.has("time_ul_max")) {
                this.w = jSONObject2.getInt("time_ul_max");
            }
            if (jSONObject2.has("count_ping")) {
                this.y = jSONObject2.getInt("count_ping");
            }
            if (jSONObject2.has("telemetry_extra")) {
                this.z = jSONObject2.getString("telemetry_extra");
            }
            if (jSONObject2.has("overheadCompensationFactor")) {
                this.A = jSONObject2.getDouble("overheadCompensationFactor");
            }
            if (jSONObject2.has("getIP_isp")) {
                this.B = jSONObject2.getBoolean("getIP_isp");
            }
            if (jSONObject2.has("getIP_distance")) {
                this.C = jSONObject2.getString("getIP_distance");
            }
            if (jSONObject2.has("test_order")) {
                this.E = jSONObject2.getString("test_order");
            }
            if (jSONObject2.has("useMebibits")) {
                this.D = jSONObject2.getBoolean("useMebibits");
            }
            a();
        } catch (JSONException e2) {
            throw new IllegalArgumentException("Invalid JSON (" + e2.toString() + ")");
        }
    }
}

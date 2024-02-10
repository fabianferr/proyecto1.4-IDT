package com.mbridge.msdk.foundation.entity;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.same.a;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.w;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;

/* compiled from: VideoReportData */
public final class n {
    public static int a = 1;
    public static int b;
    private String A;
    private String B;
    private String C;
    private String D;
    private String E;
    private String F;
    private String G;
    private String H;
    private int I = 0;
    private int J;
    private int K = 0;
    private String L;
    private String M;
    private String N;
    private String c;
    private String d;
    private String e;
    private String f;
    private int g;
    private String h;
    private int i;
    private int j;
    private int k;
    private String l;
    private String m;
    private int n;
    private int o;
    private String p;
    private long q;
    private int r = 0;
    private String s;
    private String t;
    private String u;
    private String v;
    private String w;
    private String x;
    private String y;
    private String z;

    public final String a() {
        return this.c;
    }

    public final void a(String str) {
        this.c = str;
    }

    public final String b() {
        return this.d;
    }

    public final void b(String str) {
        this.d = str;
    }

    public final String c() {
        return this.e;
    }

    public final void c(String str) {
        this.e = URLEncoder.encode(str);
    }

    public final int d() {
        return this.K;
    }

    public final void a(int i2) {
        this.K = i2;
    }

    public final String e() {
        return this.G;
    }

    public final void d(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                this.G = URLEncoder.encode(str, "utf-8");
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final String f() {
        return this.F;
    }

    public final void e(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                this.F = URLEncoder.encode(str, "utf-8");
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final String g() {
        return this.E;
    }

    public final void f(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                this.E = URLEncoder.encode(str, "utf-8");
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final String h() {
        return this.D;
    }

    public final void g(String str) {
        this.D = str;
    }

    public final String i() {
        return this.H;
    }

    public final void h(String str) {
        this.H = str;
    }

    public final String j() {
        return this.x;
    }

    public final void i(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                this.x = URLEncoder.encode(str, "utf-8");
            }
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        }
    }

    public final void j(String str) {
        this.z = str;
    }

    public final int k() {
        return this.I;
    }

    public final void b(int i2) {
        this.I = i2;
    }

    public final int l() {
        return this.J;
    }

    public final void c(int i2) {
        this.J = i2;
    }

    public final String m() {
        return this.L;
    }

    public final void k(String str) {
        this.L = str;
    }

    public final String n() {
        return this.M;
    }

    public final void l(String str) {
        this.M = str;
    }

    public final String o() {
        return this.N;
    }

    public final void m(String str) {
        this.N = str;
    }

    public n(String str, int i2, int i3, int i4, int i5, String str2, String str3, int i6, String str4, int i7, String str5) {
        this.f = str;
        this.g = i2;
        this.h = str5;
        this.i = i3;
        this.j = i4;
        this.k = i5;
        try {
            if (!TextUtils.isEmpty(str2)) {
                this.l = URLEncoder.encode(str2, "utf-8");
            }
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        }
        this.m = str3;
        this.o = i6;
        this.p = str4;
        this.q = (long) i7;
    }

    public n() {
    }

    public n(String str, int i2, String str2, String str3, String str4) {
        this.f = str;
        this.h = str4;
        this.g = i2;
        try {
            if (!TextUtils.isEmpty(str2)) {
                this.l = URLEncoder.encode(str2, "utf-8");
            }
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        }
        this.m = str3;
    }

    public n(String str, int i2, int i3, String str2, int i4, String str3, int i5, String str4) {
        this.f = str;
        this.g = i2;
        this.h = str4;
        this.k = i3;
        try {
            if (!TextUtils.isEmpty(str2)) {
                this.l = URLEncoder.encode(str2, "utf-8");
            }
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        }
        this.o = i4;
        this.p = str3;
        this.q = (long) i5;
    }

    public n(Context context, CampaignEx campaignEx, int i2, String str, long j2, int i3) {
        if (i3 == 1) {
            this.f = "2000022";
        } else if (i3 == 287 || i3 == 94) {
            this.f = "2000022";
        } else if (i3 == 95) {
            this.f = "2000025";
        }
        int r2 = w.r(context);
        this.g = r2;
        this.h = w.a(context, r2);
        this.k = campaignEx.getVideoLength();
        try {
            this.l = URLEncoder.encode(campaignEx.getNoticeUrl() == null ? campaignEx.getClickURL() : campaignEx.getNoticeUrl(), "utf-8");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.o = i2;
        this.p = str;
        this.q = j2 == 0 ? (long) campaignEx.getVideoSize() : j2;
    }

    public n(String str, String str2, String str3, String str4, String str5, String str6, int i2, String str7) {
        this.f = str;
        this.A = str2;
        this.y = str3;
        this.B = str4;
        this.v = str5;
        this.w = str6;
        this.g = i2;
        this.h = str7;
    }

    public n(String str) {
        this.C = str;
    }

    public n(String str, int i2, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.f = str;
        this.o = i2;
        this.p = str2;
        try {
            if (!TextUtils.isEmpty(str3)) {
                this.E = URLEncoder.encode(str3, "utf-8");
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.w = str4;
        this.v = str5;
        this.m = str6;
        this.D = str7;
        if (Integer.valueOf(str2).intValue() > a.n) {
            this.o = 2;
        }
    }

    public n(String str, String str2, String str3, String str4, String str5, int i2) {
        this.f = str;
        this.w = str2;
        this.s = str3;
        this.u = str4;
        this.v = str5;
        this.g = i2;
    }

    public n(String str, String str2, String str3, String str4, String str5, int i2, int i3, String str6) {
        this.f = str;
        this.w = str2;
        this.s = str3;
        this.u = str4;
        this.v = str5;
        this.g = i2;
        this.m = str6;
        this.n = i3;
    }

    public final String p() {
        return this.s;
    }

    public final void n(String str) {
        this.s = str;
    }

    public final void o(String str) {
        this.t = str;
    }

    public final String q() {
        return this.u;
    }

    public final void p(String str) {
        this.u = str;
    }

    public final String r() {
        return this.v;
    }

    public final void q(String str) {
        this.v = str;
    }

    public final String s() {
        return this.w;
    }

    public final void r(String str) {
        this.w = str;
    }

    public final String t() {
        return this.f;
    }

    public final void s(String str) {
        this.f = str;
    }

    public final int u() {
        return this.j;
    }

    public final int v() {
        return this.k;
    }

    public final String w() {
        return this.l;
    }

    public final String x() {
        return TextUtils.isEmpty(this.m) ? "" : this.m;
    }

    public final void t(String str) {
        this.m = str;
    }

    public final String y() {
        return this.p;
    }

    public final void u(String str) {
        this.p = str;
    }

    public final long z() {
        return this.q;
    }

    public final int A() {
        return this.g;
    }

    public final void d(int i2) {
        this.g = i2;
    }

    public final String B() {
        return this.h;
    }

    public final void v(String str) {
        this.h = str;
    }

    public final int C() {
        return this.i;
    }

    public final int D() {
        return this.o;
    }

    public final void e(int i2) {
        this.o = i2;
    }

    public static String a(List<n> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (n next : list) {
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                StringBuffer append = stringBuffer.append("key=" + next.f + "&");
                StringBuffer append2 = append.append("network_type=" + next.g + "&");
                StringBuffer append3 = append2.append("network_str=" + next.h + "&");
                StringBuffer append4 = append3.append("reason=" + next.x() + "&");
                StringBuffer append5 = append4.append("cid=" + next.w + "&");
                StringBuffer append6 = append5.append("video_url=" + next.F + "&");
                StringBuffer append7 = append6.append("rid=" + next.s + "&");
                StringBuffer append8 = append7.append("rid_n=" + next.u + "&");
                StringBuffer append9 = append8.append("unit_id=" + next.v + "&");
                StringBuilder sb = new StringBuilder("offer_url=");
                sb.append(next.l);
                append9.append(sb.toString()).append("\n");
            } else {
                StringBuffer append10 = stringBuffer.append("key=" + next.f + "&");
                StringBuffer append11 = append10.append("reason=" + next.x() + "&");
                StringBuffer append12 = append11.append("cid=" + next.w + "&");
                StringBuffer append13 = append12.append("video_url=" + next.F + "&");
                StringBuffer append14 = append13.append("rid=" + next.s + "&");
                StringBuffer append15 = append14.append("rid_n=" + next.u + "&");
                StringBuffer append16 = append15.append("unit_id=" + next.v + "&");
                StringBuilder sb2 = new StringBuilder("offer_url=");
                sb2.append(next.l);
                append16.append(sb2.toString()).append("\n");
            }
        }
        return stringBuffer.toString();
    }

    public static String b(List<n> list) {
        StringBuffer stringBuffer;
        if (list == null || list.size() <= 0) {
            return null;
        }
        StringBuffer stringBuffer2 = new StringBuffer();
        Iterator<n> it = list.iterator();
        while (it.hasNext()) {
            n next = it.next();
            if (next.c != null) {
                stringBuffer2.append("resource_type=" + next.c + "&");
            }
            if (next.e != null) {
                stringBuffer2.append("creative=" + next.e + "&");
            }
            Iterator<n> it2 = it;
            String str = "\n";
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                StringBuffer append = stringBuffer2.append("key=" + next.f + "&");
                stringBuffer = stringBuffer2;
                StringBuffer append2 = append.append("network_type=" + next.g + "&");
                StringBuffer append3 = append2.append("network_str=" + next.h + "&");
                StringBuffer append4 = append3.append("result=" + next.o + "&");
                StringBuffer append5 = append4.append("duration=" + next.p + "&");
                StringBuffer append6 = append5.append("video_size=" + next.q + "&");
                StringBuffer append7 = append6.append("video_length=" + next.k + "&");
                StringBuffer append8 = append7.append("reason=" + next.x() + "&");
                StringBuffer append9 = append8.append("cid=" + next.w + "&");
                StringBuffer append10 = append9.append("video_url=" + next.F + "&");
                StringBuffer append11 = append10.append("rid=" + next.s + "&");
                StringBuffer append12 = append11.append("rid_n=" + next.u + "&");
                StringBuffer append13 = append12.append("unit_id=" + next.v + "&");
                StringBuilder sb = new StringBuilder("offer_url=");
                sb.append(next.l);
                append13.append(sb.toString()).append(str);
            } else {
                stringBuffer = stringBuffer2;
                StringBuffer append14 = stringBuffer.append("key=" + next.f + "&");
                StringBuffer append15 = append14.append("result=" + next.o + "&");
                StringBuffer append16 = append15.append("duration=" + next.p + "&");
                StringBuffer append17 = append16.append("video_size=" + next.q + "&");
                StringBuffer append18 = append17.append("video_length=" + next.k + "&");
                StringBuffer append19 = append18.append("reason=" + next.x() + "&");
                StringBuffer append20 = append19.append("cid=" + next.w + "&");
                StringBuffer append21 = append20.append("video_url=" + next.F + "&");
                StringBuffer append22 = append21.append("rid=" + next.s + "&");
                StringBuffer append23 = append22.append("rid_n=" + next.u + "&");
                StringBuffer append24 = append23.append("unit_id=" + next.v + "&");
                StringBuilder sb2 = new StringBuilder("offer_url=");
                sb2.append(next.l);
                append24.append(sb2.toString()).append(str);
            }
            it = it2;
            stringBuffer2 = stringBuffer;
        }
        return stringBuffer2.toString();
    }

    public static String a(n nVar) {
        if (nVar == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer append = stringBuffer.append("key=" + nVar.f + "&");
        StringBuffer append2 = append.append("cid=" + nVar.w + "&");
        StringBuffer append3 = append2.append("unit_id=" + nVar.v + "&");
        StringBuffer append4 = append3.append("network_type=" + nVar.g + "&");
        StringBuffer append5 = append4.append("rid=" + nVar.s + "&");
        StringBuffer append6 = append5.append("rid_n=" + nVar.u + "&");
        StringBuilder sb = new StringBuilder("reason=");
        sb.append(nVar.x());
        append6.append(sb.toString()).append("\n");
        return stringBuffer.toString();
    }

    public static String b(n nVar) {
        if (nVar == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer append = stringBuffer.append("key=" + nVar.f + "&");
        StringBuffer append2 = append.append("cid=" + nVar.w + "&");
        StringBuffer append3 = append2.append("unit_id=" + nVar.v + "&");
        StringBuffer append4 = append3.append("network_type=" + nVar.g + "&");
        StringBuffer append5 = append4.append("mraid_type=" + nVar.I + "&");
        StringBuffer append6 = append5.append("rid_n=" + nVar.u + "&");
        StringBuilder sb = new StringBuilder("rid=");
        sb.append(nVar.s);
        append6.append(sb.toString());
        return stringBuffer.toString();
    }

    public static String c(n nVar) {
        if (nVar == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer append = stringBuffer.append("key=" + nVar.f + "&");
        StringBuffer append2 = append.append("result=" + nVar.o + "&");
        StringBuffer append3 = append2.append("duration=" + nVar.p + "&");
        StringBuffer append4 = append3.append("cid=" + nVar.w + "&");
        StringBuffer append5 = append4.append("reason=" + nVar.x() + "&");
        StringBuffer append6 = append5.append("ad_type=" + nVar.H + "&");
        StringBuffer append7 = append6.append("unit_id=" + nVar.v + "&");
        StringBuffer append8 = append7.append("devid=" + nVar.d + "&");
        StringBuffer append9 = append8.append("mraid_type=" + nVar.I + "&");
        append9.append("network_type=" + nVar.g + "&");
        if (!TextUtils.isEmpty(nVar.E)) {
            stringBuffer.append("endcard_url=" + nVar.E + "&");
        }
        if (!TextUtils.isEmpty(nVar.D)) {
            stringBuffer.append("type=" + nVar.D + "&");
        }
        if (nVar.c != null) {
            stringBuffer.append("resource_type=" + nVar.c + "&");
        }
        stringBuffer.append("rid_n=" + nVar.u + "&");
        StringBuilder sb = new StringBuilder("rid=");
        sb.append(nVar.s);
        stringBuffer.append(sb.toString());
        stringBuffer.append("\n");
        return stringBuffer.toString();
    }

    public static String d(n nVar) {
        if (nVar == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer append = stringBuffer.append("key=" + nVar.f + "&");
        StringBuffer append2 = append.append("result=" + nVar.o + "&");
        StringBuffer append3 = append2.append("duration=" + nVar.p + "&");
        StringBuffer append4 = append3.append("cid=" + nVar.w + "&");
        StringBuffer append5 = append4.append("unit_id=" + nVar.v + "&");
        StringBuffer append6 = append5.append("reason=" + nVar.x() + "&");
        StringBuffer append7 = append6.append("ad_type=" + nVar.H + "&");
        StringBuffer append8 = append7.append("rid=" + nVar.s + "&");
        StringBuffer append9 = append8.append("rid_n=" + nVar.u + "&");
        StringBuffer append10 = append9.append("network_type=" + nVar.g + "&");
        StringBuffer append11 = append10.append("mraid_type=" + nVar.I + "&");
        append11.append("devid=" + nVar.d + "&");
        if (nVar.c != null) {
            stringBuffer.append("resource_type=" + nVar.c + "&");
        }
        if (!TextUtils.isEmpty(nVar.E)) {
            stringBuffer.append("endcard_url=" + nVar.E + "&");
        }
        stringBuffer.append("type=" + nVar.D);
        return stringBuffer.toString();
    }

    public static String c(List<n> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (n next : list) {
            StringBuffer append = stringBuffer.append("key=" + next.f + "&");
            StringBuffer append2 = append.append("result=" + next.o + "&");
            StringBuffer append3 = append2.append("duration=" + next.p + "&");
            StringBuffer append4 = append3.append("endcard_url=" + next.E + "&");
            StringBuffer append5 = append4.append("cid=" + next.w + "&");
            StringBuffer append6 = append5.append("unit_id=" + next.v + "&");
            StringBuffer append7 = append6.append("reason=" + next.x() + "&");
            StringBuffer append8 = append7.append("ad_type=" + next.H + "&");
            StringBuffer append9 = append8.append("rid=" + next.s + "&");
            StringBuffer append10 = append9.append("rid_n=" + next.u + "&");
            StringBuffer append11 = append10.append("type=" + next.D + "&");
            StringBuilder sb = new StringBuilder("adspace_t=");
            sb.append(next.J);
            append11.append(sb.toString()).append("\n");
        }
        return stringBuffer.toString();
    }

    public static String d(List<n> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (n next : list) {
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                StringBuffer append = stringBuffer.append("key=" + next.f + "&");
                StringBuffer append2 = append.append("network_type=" + next.g + "&");
                StringBuffer append3 = append2.append("result=" + next.o + "&");
                StringBuffer append4 = append3.append("cid=" + next.w + "&");
                StringBuffer append5 = append4.append("template_url=" + next.x + "&");
                StringBuffer append6 = append5.append("reason=" + next.x() + "&");
                StringBuffer append7 = append6.append("rid=" + next.s + "&");
                StringBuffer append8 = append7.append("rid_n=" + next.u + "&");
                append8.append("unit_id=" + next.v + "&").append("\n");
            } else {
                StringBuffer append9 = stringBuffer.append("key=" + next.f + "&");
                StringBuffer append10 = append9.append("result=" + next.o + "&");
                StringBuffer append11 = append10.append("cid=" + next.w + "&");
                StringBuffer append12 = append11.append("template_url=" + next.x + "&");
                StringBuffer append13 = append12.append("reason=" + next.x() + "&");
                StringBuffer append14 = append13.append("rid=" + next.s + "&");
                StringBuffer append15 = append14.append("rid_n=" + next.u + "&");
                append15.append("unit_id=" + next.v + "&").append("\n");
            }
        }
        return stringBuffer.toString();
    }

    public static String e(List<n> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (n next : list) {
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                StringBuffer append = stringBuffer.append("key=" + next.f + "&");
                StringBuffer append2 = append.append("network_type=" + next.g + "&");
                StringBuffer append3 = append2.append("cid=" + next.w + "&");
                StringBuffer append4 = append3.append("image_url=" + next.G + "&");
                StringBuffer append5 = append4.append("reason=" + next.x() + "&");
                StringBuffer append6 = append5.append("rid=" + next.s + "&");
                StringBuffer append7 = append6.append("rid_n=" + next.u + "&");
                append7.append("unit_id=" + next.v + "&").append("\n");
            } else {
                StringBuffer append8 = stringBuffer.append("key=" + next.f + "&");
                StringBuffer append9 = append8.append("cid=" + next.w + "&");
                StringBuffer append10 = append9.append("image_url=" + next.G + "&");
                StringBuffer append11 = append10.append("reason=" + next.x() + "&");
                StringBuffer append12 = append11.append("rid=" + next.s + "&");
                StringBuffer append13 = append12.append("rid_n=" + next.u + "&");
                append13.append("unit_id=" + next.v + "&").append("\n");
            }
        }
        return stringBuffer.toString();
    }

    public static String e(n nVar) {
        if (nVar == null) {
            return null;
        }
        try {
            StringBuffer stringBuffer = new StringBuffer();
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                StringBuffer append = stringBuffer.append("key=" + nVar.f + "&");
                StringBuffer append2 = append.append("error=" + af.d(nVar.z) + "&");
                StringBuffer append3 = append2.append("template_url=" + af.d(nVar.x) + "&");
                StringBuffer append4 = append3.append("unit_id=" + af.d(nVar.v) + "&");
                StringBuffer append5 = append4.append("cid=" + af.d(nVar.w) + "&");
                StringBuffer append6 = append5.append("network_str=" + nVar.h + "&");
                StringBuilder sb = new StringBuilder("network_type=");
                sb.append(nVar.g);
                append6.append(sb.toString());
            } else {
                StringBuffer append7 = stringBuffer.append("key=" + nVar.f + "&");
                StringBuffer append8 = append7.append("error=" + af.d(nVar.z) + "&");
                StringBuffer append9 = append8.append("template_url=" + af.d(nVar.x) + "&");
                StringBuffer append10 = append9.append("unit_id=" + af.d(nVar.v) + "&");
                append10.append("cid=" + af.d(nVar.w) + "&");
            }
            return stringBuffer.toString();
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String f(n nVar) {
        if (nVar == null) {
            return null;
        }
        try {
            StringBuffer stringBuffer = new StringBuffer();
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                StringBuffer append = stringBuffer.append("key=" + nVar.f + "&");
                StringBuffer append2 = append.append("event=" + af.d(nVar.A) + "&");
                StringBuffer append3 = append2.append("template=" + af.d(nVar.y) + "&");
                StringBuffer append4 = append3.append("layout=" + af.d(nVar.B) + "&");
                StringBuffer append5 = append4.append("unit_id=" + af.d(nVar.v) + "&");
                StringBuffer append6 = append5.append("cid=" + af.d(nVar.w) + "&");
                StringBuffer append7 = append6.append("network_str=" + nVar.h + "&");
                StringBuilder sb = new StringBuilder("network_type=");
                sb.append(nVar.g);
                append7.append(sb.toString());
            } else {
                StringBuffer append8 = stringBuffer.append("key=" + nVar.f + "&");
                StringBuffer append9 = append8.append("event=" + af.d(nVar.A) + "&");
                StringBuffer append10 = append9.append("template=" + af.d(nVar.y) + "&");
                StringBuffer append11 = append10.append("layout=" + af.d(nVar.B) + "&");
                StringBuffer append12 = append11.append("unit_id=" + af.d(nVar.v) + "&");
                append12.append("cid=" + af.d(nVar.w) + "&");
            }
            return stringBuffer.toString();
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String f(List<n> list) {
        if (list == null) {
            return null;
        }
        try {
            if (list.size() <= 0) {
                return null;
            }
            StringBuffer stringBuffer = new StringBuffer();
            for (n nVar : list) {
                stringBuffer.append(nVar.C).append("\n");
            }
            return stringBuffer.toString();
        } catch (Throwable th) {
            aa.b("VideoReportData", th.getMessage(), th);
            return null;
        }
    }

    public static String g(n nVar) {
        if (nVar == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer append = stringBuffer.append("key=" + nVar.f + "&");
        StringBuffer append2 = append.append("cid=" + nVar.w + "&");
        StringBuffer append3 = append2.append("rid=" + nVar.s + "&");
        StringBuffer append4 = append3.append("rid_n=" + nVar.u + "&");
        StringBuffer append5 = append4.append("unit_id=" + nVar.v + "&");
        StringBuffer append6 = append5.append("network_type=" + nVar.g + "&");
        append6.append("mraid_type=" + nVar.I + "&").append("platform=1");
        return stringBuffer.toString();
    }

    public static String h(n nVar) {
        if (nVar == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer append = stringBuffer.append("key=" + nVar.f + "&");
        StringBuffer append2 = append.append("cid=" + nVar.w + "&");
        StringBuffer append3 = append2.append("rid=" + nVar.s + "&");
        StringBuffer append4 = append3.append("rid_n=" + nVar.u + "&");
        StringBuffer append5 = append4.append("unit_id=" + nVar.v + "&");
        StringBuffer append6 = append5.append("reason=" + nVar.x() + "&");
        StringBuffer append7 = append6.append("case=" + nVar.n + "&");
        StringBuilder sb = new StringBuilder("network_type=");
        sb.append(nVar.g);
        append7.append(sb.toString());
        return stringBuffer.toString();
    }

    public final String toString() {
        return "RewardReportData [key=" + this.f + ", networkType=" + this.g + ", isCompleteView=" + this.i + ", watchedMillis=" + this.j + ", videoLength=" + this.k + ", offerUrl=" + this.l + ", reason=" + this.m + ", result=" + this.o + ", duration=" + this.p + ", videoSize=" + this.q + "]";
    }
}

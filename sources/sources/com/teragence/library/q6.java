package com.teragence.library;

import java.util.Hashtable;
import java.util.UUID;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class q6 implements h8, t5 {
    public String a;
    public int b;
    public boolean c;
    public int d;
    public boolean e;
    public int f;
    public boolean g;
    public int h;
    public boolean i;
    public int j;
    public boolean k;
    public String l;
    public int m;
    public boolean n;
    public String o;
    public int p;
    public boolean q;
    public String r;
    public boolean s;
    public boolean t;

    public q6(l8 l8Var) {
        boolean booleanValue;
        boolean booleanValue2;
        String str;
        boolean booleanValue3;
        int intValue;
        String str2;
        boolean booleanValue4;
        int intValue2;
        String str3;
        boolean booleanValue5;
        int intValue3;
        boolean booleanValue6;
        int intValue4;
        boolean booleanValue7;
        int intValue5;
        boolean booleanValue8;
        int intValue6;
        boolean booleanValue9;
        int intValue7;
        String str4;
        if (l8Var != null) {
            if (l8Var.d("DownloadServerAddress")) {
                Object c2 = l8Var.c("DownloadServerAddress");
                if (c2 == null || !c2.getClass().equals(m8.class)) {
                    str4 = (c2 != null && (c2 instanceof String)) ? (String) c2 : str4;
                } else {
                    str4 = ((m8) c2).toString();
                }
                this.a = str4;
            }
            if (l8Var.d("DownloadTestInterval")) {
                Object c3 = l8Var.c("DownloadTestInterval");
                if (c3 == null || !c3.getClass().equals(m8.class)) {
                    intValue7 = (c3 != null && (c3 instanceof Number)) ? ((Integer) c3).intValue() : intValue7;
                } else {
                    intValue7 = Integer.parseInt(((m8) c3).toString());
                }
                this.b = intValue7;
            }
            if (l8Var.d("DownloadTestIntervalSpecified")) {
                Object c4 = l8Var.c("DownloadTestIntervalSpecified");
                if (c4 == null || !c4.getClass().equals(m8.class)) {
                    booleanValue9 = (c4 != null && (c4 instanceof Boolean)) ? ((Boolean) c4).booleanValue() : booleanValue9;
                } else {
                    booleanValue9 = Boolean.parseBoolean(((m8) c4).toString());
                }
                this.c = booleanValue9;
            }
            if (l8Var.d("MaxAge")) {
                Object c5 = l8Var.c("MaxAge");
                if (c5 == null || !c5.getClass().equals(m8.class)) {
                    intValue6 = (c5 != null && (c5 instanceof Number)) ? ((Integer) c5).intValue() : intValue6;
                } else {
                    intValue6 = Integer.parseInt(((m8) c5).toString());
                }
                this.d = intValue6;
            }
            if (l8Var.d("MaxAgeSpecified")) {
                Object c6 = l8Var.c("MaxAgeSpecified");
                if (c6 == null || !c6.getClass().equals(m8.class)) {
                    booleanValue8 = (c6 != null && (c6 instanceof Boolean)) ? ((Boolean) c6).booleanValue() : booleanValue8;
                } else {
                    booleanValue8 = Boolean.parseBoolean(((m8) c6).toString());
                }
                this.e = booleanValue8;
            }
            if (l8Var.d("PacketCount")) {
                Object c7 = l8Var.c("PacketCount");
                if (c7 == null || !c7.getClass().equals(m8.class)) {
                    intValue5 = (c7 != null && (c7 instanceof Number)) ? ((Integer) c7).intValue() : intValue5;
                } else {
                    intValue5 = Integer.parseInt(((m8) c7).toString());
                }
                this.f = intValue5;
            }
            if (l8Var.d("PacketCountSpecified")) {
                Object c8 = l8Var.c("PacketCountSpecified");
                if (c8 == null || !c8.getClass().equals(m8.class)) {
                    booleanValue7 = (c8 != null && (c8 instanceof Boolean)) ? ((Boolean) c8).booleanValue() : booleanValue7;
                } else {
                    booleanValue7 = Boolean.parseBoolean(((m8) c8).toString());
                }
                this.g = booleanValue7;
            }
            if (l8Var.d("PacketInterval")) {
                Object c9 = l8Var.c("PacketInterval");
                if (c9 == null || !c9.getClass().equals(m8.class)) {
                    intValue4 = (c9 != null && (c9 instanceof Number)) ? ((Integer) c9).intValue() : intValue4;
                } else {
                    intValue4 = Integer.parseInt(((m8) c9).toString());
                }
                this.h = intValue4;
            }
            if (l8Var.d("PacketIntervalSpecified")) {
                Object c10 = l8Var.c("PacketIntervalSpecified");
                if (c10 == null || !c10.getClass().equals(m8.class)) {
                    booleanValue6 = (c10 != null && (c10 instanceof Boolean)) ? ((Boolean) c10).booleanValue() : booleanValue6;
                } else {
                    booleanValue6 = Boolean.parseBoolean(((m8) c10).toString());
                }
                this.i = booleanValue6;
            }
            if (l8Var.d("PacketSize")) {
                Object c11 = l8Var.c("PacketSize");
                if (c11 == null || !c11.getClass().equals(m8.class)) {
                    intValue3 = (c11 != null && (c11 instanceof Number)) ? ((Integer) c11).intValue() : intValue3;
                } else {
                    intValue3 = Integer.parseInt(((m8) c11).toString());
                }
                this.j = intValue3;
            }
            if (l8Var.d("PacketSizeSpecified")) {
                Object c12 = l8Var.c("PacketSizeSpecified");
                if (c12 == null || !c12.getClass().equals(m8.class)) {
                    booleanValue5 = (c12 != null && (c12 instanceof Boolean)) ? ((Boolean) c12).booleanValue() : booleanValue5;
                } else {
                    booleanValue5 = Boolean.parseBoolean(((m8) c12).toString());
                }
                this.k = booleanValue5;
            }
            if (l8Var.d("ServerAddress")) {
                Object c13 = l8Var.c("ServerAddress");
                if (c13 == null || !c13.getClass().equals(m8.class)) {
                    str3 = (c13 != null && (c13 instanceof String)) ? (String) c13 : str3;
                } else {
                    str3 = ((m8) c13).toString();
                }
                this.l = str3;
            }
            if (l8Var.d("ServerPort")) {
                Object c14 = l8Var.c("ServerPort");
                if (c14 == null || !c14.getClass().equals(m8.class)) {
                    intValue2 = (c14 != null && (c14 instanceof Number)) ? ((Integer) c14).intValue() : intValue2;
                } else {
                    intValue2 = Integer.parseInt(((m8) c14).toString());
                }
                this.m = intValue2;
            }
            if (l8Var.d("ServerPortSpecified")) {
                Object c15 = l8Var.c("ServerPortSpecified");
                if (c15 == null || !c15.getClass().equals(m8.class)) {
                    booleanValue4 = (c15 != null && (c15 instanceof Boolean)) ? ((Boolean) c15).booleanValue() : booleanValue4;
                } else {
                    booleanValue4 = Boolean.parseBoolean(((m8) c15).toString());
                }
                this.n = booleanValue4;
            }
            if (l8Var.d("TestId")) {
                Object c16 = l8Var.c("TestId");
                if (c16 == null || !c16.getClass().equals(m8.class)) {
                    str2 = (c16 != null && (c16 instanceof String)) ? (String) c16 : str2;
                } else {
                    str2 = ((m8) c16).toString();
                }
                this.o = str2;
            }
            if (l8Var.d("TestInterval")) {
                Object c17 = l8Var.c("TestInterval");
                if (c17 == null || !c17.getClass().equals(m8.class)) {
                    intValue = (c17 != null && (c17 instanceof Number)) ? ((Integer) c17).intValue() : intValue;
                } else {
                    intValue = Integer.parseInt(((m8) c17).toString());
                }
                this.p = intValue;
            }
            if (l8Var.d("TestIntervalSpecified")) {
                Object c18 = l8Var.c("TestIntervalSpecified");
                if (c18 == null || !c18.getClass().equals(m8.class)) {
                    booleanValue3 = (c18 != null && (c18 instanceof Boolean)) ? ((Boolean) c18).booleanValue() : booleanValue3;
                } else {
                    booleanValue3 = Boolean.parseBoolean(((m8) c18).toString());
                }
                this.q = booleanValue3;
            }
            if (l8Var.d("TestName")) {
                Object c19 = l8Var.c("TestName");
                if (c19 == null || !c19.getClass().equals(m8.class)) {
                    str = (c19 != null && (c19 instanceof String)) ? (String) c19 : str;
                } else {
                    str = ((m8) c19).toString();
                }
                this.r = str;
            }
            if (l8Var.d("UseFineLocation")) {
                Object c20 = l8Var.c("UseFineLocation");
                if (c20 == null || !c20.getClass().equals(m8.class)) {
                    booleanValue2 = (c20 != null && (c20 instanceof Boolean)) ? ((Boolean) c20).booleanValue() : booleanValue2;
                } else {
                    booleanValue2 = Boolean.parseBoolean(((m8) c20).toString());
                }
                this.s = booleanValue2;
            }
            if (l8Var.d("UseFineLocationSpecified")) {
                Object c21 = l8Var.c("UseFineLocationSpecified");
                if (c21 != null && c21.getClass().equals(m8.class)) {
                    booleanValue = Boolean.parseBoolean(((m8) c21).toString());
                } else if (c21 != null && (c21 instanceof Boolean)) {
                    booleanValue = ((Boolean) c21).booleanValue();
                } else {
                    return;
                }
                this.t = booleanValue;
            }
        }
    }

    public int a() {
        return this.d;
    }

    public Object a(int i2) {
        switch (i2) {
            case 0:
                return this.a;
            case 1:
                return Integer.valueOf(this.b);
            case 2:
                return Boolean.valueOf(this.c);
            case 3:
                return Integer.valueOf(this.d);
            case 4:
                return Boolean.valueOf(this.e);
            case 5:
                return Integer.valueOf(this.f);
            case 6:
                return Boolean.valueOf(this.g);
            case 7:
                return Integer.valueOf(this.h);
            case 8:
                return Boolean.valueOf(this.i);
            case 9:
                return Integer.valueOf(this.j);
            case 10:
                return Boolean.valueOf(this.k);
            case 11:
                return this.l;
            case 12:
                return Integer.valueOf(this.m);
            case 13:
                return Boolean.valueOf(this.n);
            case 14:
                return this.o;
            case 15:
                return Integer.valueOf(this.p);
            case 16:
                return Boolean.valueOf(this.q);
            case 17:
                return this.r;
            case 18:
                return Boolean.valueOf(this.s);
            case 19:
                return Boolean.valueOf(this.t);
            default:
                return null;
        }
    }

    public void a(int i2, Object obj) {
    }

    public void a(int i2, Hashtable hashtable, k8 k8Var) {
        String str;
        k8Var.c = "https://control.teragence.net/service2/data";
        switch (i2) {
            case 0:
                k8Var.f = k8.j;
                str = "DownloadServerAddress";
                break;
            case 1:
                k8Var.f = k8.k;
                str = "DownloadTestInterval";
                break;
            case 2:
                k8Var.f = k8.m;
                str = "DownloadTestIntervalSpecified";
                break;
            case 3:
                k8Var.f = k8.k;
                str = "MaxAge";
                break;
            case 4:
                k8Var.f = k8.m;
                str = "MaxAgeSpecified";
                break;
            case 5:
                k8Var.f = k8.k;
                str = "PacketCount";
                break;
            case 6:
                k8Var.f = k8.m;
                str = "PacketCountSpecified";
                break;
            case 7:
                k8Var.f = k8.k;
                str = "PacketInterval";
                break;
            case 8:
                k8Var.f = k8.m;
                str = "PacketIntervalSpecified";
                break;
            case 9:
                k8Var.f = k8.k;
                str = "PacketSize";
                break;
            case 10:
                k8Var.f = k8.m;
                str = "PacketSizeSpecified";
                break;
            case 11:
                k8Var.f = k8.j;
                str = "ServerAddress";
                break;
            case 12:
                k8Var.f = k8.k;
                str = "ServerPort";
                break;
            case 13:
                k8Var.f = k8.m;
                str = "ServerPortSpecified";
                break;
            case 14:
                k8Var.f = k8.j;
                str = "TestId";
                break;
            case 15:
                k8Var.f = k8.k;
                str = "TestInterval";
                break;
            case 16:
                k8Var.f = k8.m;
                str = "TestIntervalSpecified";
                break;
            case 17:
                k8Var.f = k8.j;
                str = "TestName";
                break;
            case 18:
                k8Var.f = k8.m;
                str = "UseFineLocation";
                break;
            case 19:
                k8Var.f = k8.m;
                str = "UseFineLocationSpecified";
                break;
            default:
                return;
        }
        k8Var.b = str;
    }

    public UUID c() {
        return UUID.fromString(this.o);
    }

    public int d() {
        return this.b;
    }

    public String e() {
        return this.a;
    }

    public int f() {
        return this.m;
    }

    public int g() {
        return this.p;
    }

    public int h() {
        return this.j;
    }

    public int i() {
        return this.h;
    }

    public int j() {
        return this.f;
    }

    public String k() {
        return this.l;
    }

    public boolean l() {
        return this.s;
    }

    public int m() {
        return 20;
    }

    public String toString() {
        return "GetTestConfigResponse{downloadServerAddress='" + this.a + "', downloadTestInterval=" + this.b + ", downloadTestIntervalSpecified=" + this.c + ", maxAge=" + this.d + ", maxAgeSpecified=" + this.e + ", packetCount=" + this.f + ", packetCountSpecified=" + this.g + ", packetInterval=" + this.h + ", packetIntervalSpecified=" + this.i + ", packetSize=" + this.j + ", packetSizeSpecified=" + this.k + ", serverAddress='" + this.l + "', serverPort=" + this.m + ", serverPortSpecified=" + this.n + ", testId='" + this.o + "', testInterval=" + this.p + ", testIntervalSpecified=" + this.q + ", testName='" + this.r + "', useFineLocation=" + this.s + ", useFineLocationSpecified=" + this.t + AbstractJsonLexerKt.END_OBJ;
    }
}

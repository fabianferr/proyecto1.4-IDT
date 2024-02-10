package com.teragence.library;

import java.util.Hashtable;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class a7 implements h8, a6 {
    public long a;
    public boolean b;
    public long c;
    public boolean d;

    public a7(l8 l8Var) {
        boolean booleanValue;
        int intValue;
        boolean booleanValue2;
        int intValue2;
        if (l8Var != null) {
            if (l8Var.d("DeviceId")) {
                Object c2 = l8Var.c("DeviceId");
                if (c2 == null || !c2.getClass().equals(m8.class)) {
                    intValue2 = (c2 != null && (c2 instanceof Number)) ? ((Integer) c2).intValue() : intValue2;
                } else {
                    intValue2 = Integer.parseInt(((m8) c2).toString());
                }
                this.a = (long) intValue2;
            }
            if (l8Var.d("DeviceIdSpecified")) {
                Object c3 = l8Var.c("DeviceIdSpecified");
                if (c3 == null || !c3.getClass().equals(m8.class)) {
                    booleanValue2 = (c3 != null && (c3 instanceof Boolean)) ? ((Boolean) c3).booleanValue() : booleanValue2;
                } else {
                    booleanValue2 = Boolean.parseBoolean(((m8) c3).toString());
                }
                this.b = booleanValue2;
            }
            if (l8Var.d("Expiration")) {
                Object c4 = l8Var.c("Expiration");
                if (c4 == null || !c4.getClass().equals(m8.class)) {
                    intValue = (c4 != null && (c4 instanceof Number)) ? ((Integer) c4).intValue() : intValue;
                } else {
                    intValue = Integer.parseInt(((m8) c4).toString());
                }
                this.c = (long) intValue;
            }
            if (l8Var.d("ExpirationSpecified")) {
                Object c5 = l8Var.c("ExpirationSpecified");
                if (c5 != null && c5.getClass().equals(m8.class)) {
                    booleanValue = Boolean.parseBoolean(((m8) c5).toString());
                } else if (c5 != null && (c5 instanceof Boolean)) {
                    booleanValue = ((Boolean) c5).booleanValue();
                } else {
                    return;
                }
                this.d = booleanValue;
            }
        }
    }

    public long a() {
        return this.c;
    }

    public Object a(int i) {
        if (i == 0) {
            return Long.valueOf(this.a);
        }
        if (i == 1) {
            return Boolean.valueOf(this.b);
        }
        if (i == 2) {
            return Long.valueOf(this.c);
        }
        if (i != 3) {
            return null;
        }
        return Boolean.valueOf(this.d);
    }

    public void a(int i, Object obj) {
    }

    public void a(int i, Hashtable hashtable, k8 k8Var) {
        String str;
        k8Var.c = "https://control.teragence.net/service2/data";
        if (i == 0) {
            k8Var.f = Long.class;
            str = "DeviceId";
        } else if (i == 1) {
            k8Var.f = k8.m;
            str = "DeviceIdSpecified";
        } else if (i == 2) {
            k8Var.f = Long.class;
            str = "Expiration";
        } else if (i == 3) {
            k8Var.f = k8.m;
            str = "ExpirationSpecified";
        } else {
            return;
        }
        k8Var.b = str;
    }

    public long e() {
        return this.a;
    }

    public int m() {
        return 4;
    }

    public String toString() {
        return "RegisterDeviceResponse{deviceId=" + this.a + ", deviceIdSpecified=" + this.b + ", expiration=" + this.c + ", expirationSpecified=" + this.d + AbstractJsonLexerKt.END_OBJ;
    }
}

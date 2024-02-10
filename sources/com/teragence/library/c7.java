package com.teragence.library;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class c7 implements h8 {
    public a a;
    public n6 b;
    public String c;
    public w6 d;

    public static class a implements h8 {
        public List<k6> a;

        public a() {
            this.a = new ArrayList();
        }

        public a(List<k6> list) {
            new ArrayList();
            this.a = list;
        }

        public Object a(int i) {
            if (i < this.a.size()) {
                return this.a.get(i);
            }
            return null;
        }

        public void a(int i, Object obj) {
            if (i == 0) {
                this.a.add((k6) obj);
            }
        }

        public void a(int i, Hashtable hashtable, k8 k8Var) {
            k8Var.c = "https://control.teragence.net/service2/data";
            if (i < this.a.size()) {
                k8Var.b = "Deadzone";
                k8Var.f = k6.class;
            }
        }

        public int m() {
            return this.a.size();
        }
    }

    public c7() {
    }

    public c7(a aVar, n6 n6Var, String str, w6 w6Var) {
        this.a = aVar;
        this.b = n6Var;
        this.c = str;
        this.d = w6Var;
    }

    public Object a(int i) {
        if (i == 0) {
            return this.a;
        }
        if (i == 1) {
            return this.b;
        }
        if (i == 2) {
            return this.c;
        }
        if (i != 3) {
            return null;
        }
        return this.d;
    }

    public void a(int i, Object obj) {
    }

    public void a(int i, Hashtable hashtable, k8 k8Var) {
        String str;
        k8Var.c = "https://control.teragence.net/service2/data";
        if (i == 0) {
            k8Var.f = a.class;
            str = "Deadzones";
        } else if (i == 1) {
            k8Var.f = n6.class;
            str = "DeviceInfo";
        } else if (i == 2) {
            k8Var.f = k8.j;
            str = "OwnerKey";
        } else if (i == 3) {
            k8Var.f = w6.class;
            str = "SimOperatorInfo";
        } else {
            return;
        }
        k8Var.b = str;
    }

    public int m() {
        return 4;
    }

    public String toString() {
        return "ReportDeadzonesRequest{deadzones=" + this.a + ", deviceInfo=" + this.b + ", ownerKey='" + this.c + "', simOperatorInfo=" + this.d + AbstractJsonLexerKt.END_OBJ;
    }
}

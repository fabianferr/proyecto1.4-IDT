package com.startapp;

import androidx.core.app.NotificationCompat;
import com.facebook.appevents.UserDataStore;
import com.startapp.k3;
import com.startapp.m3;
import com.unity3d.services.ads.gmascar.bridges.mobileads.MobileAdsBridgeBase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Sta */
public class j3 {
    public static final Map<String, j3> c = new HashMap();
    public static final j3 d;
    public static final j3 e;
    public static final j3 f;
    public static final j3 g;
    public static final j3 h;
    public static final j3 i;
    public static final j3 j;
    public static final j3 k;
    public static final j3 l;
    public static final j3 m;
    public static final j3 n;
    public static final j3 o;
    public static final j3 p;
    public static final j3 q;
    public final String a;
    public final k3 b;

    static {
        k3.a aVar = new k3.a();
        aVar.b = 23;
        aVar.c = 50;
        aVar.d = true;
        m3.a aVar2 = new m3.a();
        String[] strArr = {MobileAdsBridgeBase.initializeMethodName};
        List list = aVar2.a;
        if (list == null) {
            list = new ArrayList();
            aVar2.a = list;
        }
        m3.a a2 = aVar2.a(strArr, list).a("value");
        a2.d = "8h";
        k3.a a3 = aVar.a(new m3(a2));
        m3.a a4 = new m3.a().a("value", "details");
        a4.d = "30m";
        k3.a a5 = a3.a(new m3(a4));
        m3.a a6 = new m3.a().a("value");
        a6.d = "10s";
        k3.a a7 = a5.a(new m3(a6));
        a7.e = "2h";
        a7.f = "2s";
        d = new j3("general", new k3(a7));
        k3.a aVar3 = new k3.a();
        aVar3.b = 17;
        aVar3.c = 20;
        aVar3.d = true;
        m3.a aVar4 = new m3.a();
        String[] strArr2 = {"fake_click"};
        List list2 = aVar4.b;
        if (list2 == null) {
            list2 = new ArrayList();
            aVar4.b = list2;
        }
        m3.a a8 = aVar4.a(strArr2, list2).a("appActivity", "value", "details");
        a8.d = "30m";
        k3.a a9 = aVar3.a(new m3(a8));
        m3.a aVar5 = new m3.a();
        String[] strArr3 = {"fake_click"};
        List list3 = aVar5.b;
        if (list3 == null) {
            list3 = new ArrayList();
            aVar5.b = list3;
        }
        m3.a a10 = aVar5.a(strArr3, list3).a("appActivity", "value");
        a10.d = "10s";
        k3.a a11 = a9.a(new m3(a10));
        a11.e = "4h";
        a11.f = "5s";
        e = new j3("error", new k3(a11));
        k3.a aVar6 = new k3.a();
        aVar6.a = 0.0d;
        aVar6.b = 17;
        aVar6.c = 30;
        aVar6.d = true;
        m3.a a12 = new m3.a().a("appActivity", "value", "details");
        a12.d = "12h";
        k3.a a13 = aVar6.a(new m3(a12));
        m3.a a14 = new m3.a().a("appActivity", "value");
        a14.d = "1h";
        k3.a a15 = a13.a(new m3(a14));
        a15.e = "1d";
        a15.f = "5s";
        k3 k3Var = new k3(a15);
        f = new j3("exception", k3Var);
        new j3("exception_nt", k3Var);
        k3.a aVar7 = new k3.a();
        aVar7.b = 17;
        aVar7.c = 40;
        aVar7.d = true;
        m3.a a16 = new m3.a().a("value", "details");
        a16.d = "1h";
        k3.a a17 = aVar7.a(new m3(a16));
        a17.e = "2d";
        a17.f = "5s";
        g = new j3("exception_fatal", new k3(a17));
        h = new j3("anr", k3Var);
        k3.a aVar8 = new k3.a();
        aVar8.a = 0.0d;
        aVar8.b = 17;
        aVar8.c = 10;
        aVar8.d = false;
        aVar8.f = "10s";
        i = new j3("netdiag", new k3(aVar8));
        k3.a aVar9 = new k3.a();
        aVar9.b = 3071;
        aVar9.c = 90;
        aVar9.d = true;
        m3.a a18 = new m3.a().a(NotificationCompat.CATEGORY_SERVICE);
        a18.d = "1m";
        k3.a a19 = aVar9.a(new m3(a18));
        a19.e = "1h";
        j = new j3("periodic", new k3(a19));
        k3.a aVar10 = new k3.a();
        aVar10.c = 90;
        aVar10.d = true;
        aVar10.e = "4h";
        k = new j3("nonimpression", new k3(aVar10));
        k3.a aVar11 = new k3.a();
        aVar11.b = 17;
        aVar11.c = 10;
        aVar11.d = true;
        aVar11.e = "4h";
        l = new j3("impression_responses", new k3(aVar11));
        k3.a aVar12 = new k3.a();
        aVar12.a = 0.0d;
        aVar12.b = 17;
        aVar12.c = 60;
        aVar12.d = true;
        aVar12.e = "1d";
        aVar12.f = "5s";
        m = new j3("success_smart_redirect_hop_info", new k3(aVar12));
        k3.a aVar13 = new k3.a();
        aVar13.b = 17;
        aVar13.c = 70;
        aVar13.d = false;
        n = new j3("triggeredLink", new k3(aVar13));
        k3.a aVar14 = new k3.a();
        aVar14.b = 23;
        aVar14.c = 80;
        aVar14.d = true;
        aVar14.e = "1d";
        o = new j3(UserDataStore.CITY, new k3(aVar14));
        k3.a aVar15 = new k3.a();
        aVar15.b = 23;
        aVar15.c = 80;
        aVar15.d = true;
        aVar15.e = "1d";
        p = new j3("lt", new k3(aVar15));
        k3.a aVar16 = new k3.a();
        aVar16.b = 23;
        aVar16.c = 80;
        aVar16.d = true;
        aVar16.e = "1d";
        q = new j3("nir", new k3(aVar16));
    }

    public j3(String str, k3 k3Var) {
        this.a = str;
        this.b = k3Var;
        ((HashMap) c).put(str, this);
    }

    public String a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || j3.class != obj.getClass()) {
            return false;
        }
        return k9.a(this.a, ((j3) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return this.a;
    }

    public static j3 a(String str) {
        return (j3) ((HashMap) c).get(str);
    }
}

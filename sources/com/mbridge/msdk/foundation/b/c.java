package com.mbridge.msdk.foundation.b;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: CandidateResult */
public final class c {
    public static int a = 0;
    public static int b = 1;
    public static int c = 2;
    public static int d = 3;
    public static int e = 4;
    private String f;
    private CopyOnWriteArrayList<CampaignEx> g;
    private int h = a;
    private ArrayList<String> i = new ArrayList<>();
    private List<String> j = new ArrayList();
    private List<String> k = new ArrayList();
    private List<String> l = new ArrayList();

    public final String a() {
        ArrayList<String> arrayList = this.i;
        if (arrayList == null) {
            return "";
        }
        return arrayList.toString();
    }

    public final String b() {
        List<String> list = this.j;
        if (list == null) {
            return "";
        }
        return list.toString();
    }

    public final String c() {
        List<String> list = this.k;
        if (list == null) {
            return "";
        }
        return list.toString();
    }

    public final String d() {
        List<String> list = this.l;
        if (list == null) {
            return "";
        }
        return list.toString();
    }

    public final void a(String str) {
        try {
            ArrayList<String> arrayList = this.i;
            if (arrayList != null) {
                arrayList.add(str);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void b(String str) {
        try {
            List<String> list = this.j;
            if (list != null) {
                list.add(str);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void c(String str) {
        try {
            List<String> list = this.k;
            if (list != null) {
                list.add(str);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void d(String str) {
        try {
            List<String> list = this.l;
            if (list != null) {
                list.add(str);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final int e() {
        return this.h;
    }

    public final void a(int i2) {
        this.h = i2;
    }

    public final String f() {
        return this.f;
    }

    public final void e(String str) {
        this.f = str;
    }

    public final CopyOnWriteArrayList<CampaignEx> g() {
        return this.g;
    }

    public final void a(CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList) {
        this.g = copyOnWriteArrayList;
    }
}

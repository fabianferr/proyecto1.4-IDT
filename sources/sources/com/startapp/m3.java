package com.startapp;

import com.startapp.sdk.adsbase.remoteconfig.AnalyticsCategoryFilterConfig;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Sta */
public class m3 {
    public final List<String> a;
    public final List<String> b;
    public final List<String> c;
    public final List<String> d;
    public final List<String> e;
    public final long f;

    /* compiled from: Sta */
    public static class a {
        public List<String> a;
        public List<String> b;
        public List<String> c;
        public String d;

        public List<String> a() {
            return this.b;
        }

        public List<String> b() {
            return this.c;
        }

        public List<String> c() {
            return this.a;
        }

        public String d() {
            return this.d;
        }

        public a a(String... strArr) {
            List list = this.c;
            if (list == null) {
                list = new ArrayList();
                this.c = list;
            }
            return a(strArr, list);
        }

        public final a a(String[] strArr, List<String> list) {
            for (String str : strArr) {
                if (str != null) {
                    list.add(str);
                }
            }
            return this;
        }
    }

    public m3(a aVar) {
        this.a = k9.b(aVar.c());
        this.b = k9.b(aVar.a());
        this.c = k9.b((List) null);
        this.d = k9.b((List) null);
        this.e = k9.b(aVar.b());
        this.f = Math.max(0, k9.e(aVar.d()));
    }

    public static List<m3> a(List<AnalyticsCategoryFilterConfig> list) {
        ArrayList arrayList = null;
        if (list == null) {
            return null;
        }
        for (AnalyticsCategoryFilterConfig next : list) {
            if (next != null) {
                if (arrayList == null) {
                    arrayList = new ArrayList(list.size());
                }
                arrayList.add(new m3(next));
            }
        }
        return arrayList != null ? k9.b(arrayList) : arrayList;
    }

    public m3(AnalyticsCategoryFilterConfig analyticsCategoryFilterConfig) {
        this.a = k9.b(analyticsCategoryFilterConfig.e());
        this.b = k9.b(analyticsCategoryFilterConfig.b());
        this.c = k9.b(analyticsCategoryFilterConfig.d());
        this.d = k9.b(analyticsCategoryFilterConfig.a());
        this.e = k9.b(analyticsCategoryFilterConfig.c());
        this.f = Math.max(0, k9.e(analyticsCategoryFilterConfig.f()));
    }
}

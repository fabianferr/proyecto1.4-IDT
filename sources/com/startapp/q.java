package com.startapp;

import android.webkit.WebView;
import com.iab.omid.library.startio.adsession.AdSessionContextType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* compiled from: Sta */
public final class q {
    public final i6 a;
    public final WebView b;
    public final List<w9> c;
    public final Map<String, w9> d = new HashMap();
    public final String e;
    public final String f;
    public final String g;
    public final AdSessionContextType h;

    public q(i6 i6Var, WebView webView, String str, List<w9> list, String str2, String str3, AdSessionContextType adSessionContextType) {
        ArrayList arrayList = new ArrayList();
        this.c = arrayList;
        this.a = i6Var;
        this.b = webView;
        this.e = str;
        this.h = adSessionContextType;
        if (list != null) {
            arrayList.addAll(list);
            for (w9 put : list) {
                String uuid = UUID.randomUUID().toString();
                this.d.put(uuid, put);
            }
        }
        this.g = str2;
        this.f = str3;
    }

    public AdSessionContextType a() {
        return this.h;
    }

    public Map<String, w9> b() {
        return Collections.unmodifiableMap(this.d);
    }

    public String c() {
        return this.e;
    }

    public WebView d() {
        return this.b;
    }
}

package com.ironsource.sdk.controller;

import android.app.Activity;
import android.content.Context;
import com.ironsource.sdk.controller.h;
import com.ironsource.sdk.g.c;
import com.ironsource.sdk.g.d;
import com.ironsource.sdk.j.e;
import java.util.Map;
import org.json.JSONObject;

public interface n {

    public interface a {
        void onReceive(h.a aVar);
    }

    public interface b {
        void onReceive(r rVar);
    }

    void a(Activity activity);

    void a(Context context);

    void a(h.b bVar, a aVar);

    void a(c cVar);

    void a(c cVar, Map<String, String> map, com.ironsource.sdk.j.a.b bVar);

    void a(c cVar, Map<String, String> map, com.ironsource.sdk.j.a.c cVar2);

    void a(String str, String str2, c cVar, com.ironsource.sdk.j.a.b bVar);

    void a(String str, String str2, c cVar, com.ironsource.sdk.j.a.c cVar2);

    void a(String str, String str2, e eVar);

    void a(String str, String str2, Map<String, String> map, e eVar);

    void a(Map<String, String> map, e eVar);

    void a(JSONObject jSONObject);

    void b(Context context);

    void b(c cVar, Map<String, String> map, com.ironsource.sdk.j.a.c cVar2);

    void b(JSONObject jSONObject);

    d.c c();

    void d();

    void destroy();

    void e();

    @Deprecated
    void f();

    void g();
}

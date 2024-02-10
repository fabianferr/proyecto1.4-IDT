package com.mbridge.msdk.video.signal.a;

import android.content.res.Configuration;
import com.mbridge.msdk.foundation.tools.aa;

/* compiled from: DefaultJSActivity */
public class a implements com.mbridge.msdk.video.signal.a {
    public void a() {
        aa.a("js", "DefaultJSActivity-onPause");
    }

    public void b() {
        aa.a("js", "DefaultJSActivity-onResume");
    }

    public void f() {
        aa.a("js", "DefaultJSActivity-onDestory");
    }

    public final void c() {
        aa.a("js", "DefaultJSActivity-onStop");
    }

    public final void d() {
        aa.a("js", "DefaultJSActivity-onStart");
    }

    public final void e() {
        aa.a("js", "DefaultJSActivity-onRestart");
    }

    public void a(Configuration configuration) {
        aa.a("js", "DefaultJSActivity-onConfigurationChanged:" + configuration.orientation);
    }

    public void g() {
        aa.a("js", "DefaultJSActivity-onBackPressed");
    }

    public int h() {
        aa.a("js", "isSystemResume");
        return 0;
    }

    public void a(int i) {
        aa.a("js", "setSystemResume,isResume:" + i);
    }
}

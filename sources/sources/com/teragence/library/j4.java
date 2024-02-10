package com.teragence.library;

import android.os.Build;
import com.teragence.client.service.CoreInfo;
import com.teragence.library.h4;
import java.util.UUID;

public class j4 implements h4 {
    private final r5 a;
    private final e0 b;
    private final g4 c;
    private final w3 d;
    private final x3 e;

    public j4(r5 r5Var, e0 e0Var, g4 g4Var, w3 w3Var, x3 x3Var) {
        this.a = r5Var;
        this.b = e0Var;
        this.c = g4Var;
        this.d = w3Var;
        this.e = x3Var;
    }

    public void a(h4.a aVar) {
        r5 r5Var = this.a;
        String str = Build.PRODUCT;
        UUID a2 = this.c.a();
        String str2 = Build.MANUFACTURER;
        String str3 = Build.MODEL;
        a6 a3 = r5Var.a((z5) new q7(str, a2, new i7(str2, str3, "Android " + Build.VERSION.RELEASE, Build.VERSION.SDK_INT, CoreInfo.VERSION), new n7(this.d.e(), this.d.c(), this.d.a(), this.d.b()), new v7(this.e.a(), this.e.b())));
        if (a3 != null) {
            this.b.a(new b(a3, System.currentTimeMillis()));
            aVar.a();
            return;
        }
        this.b.a();
        aVar.a(new Exception("RegisterDeviceResponse == null"));
    }
}

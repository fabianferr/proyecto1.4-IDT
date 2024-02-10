package com.teragence.client.service;

import android.content.ContextWrapper;
import android.os.Build;
import com.teragence.client.i;
import com.teragence.library.d2;

public class j implements f {
    private final f a;
    private final ContextWrapper b;

    public j(f fVar, ContextWrapper contextWrapper) {
        this.a = fVar;
        this.b = contextWrapper;
    }

    private boolean c() {
        return Build.VERSION.SDK_INT < 23 || this.b.checkCallingOrSelfPermission("android.permission.INTERNET") == 0;
    }

    public void a() {
        this.a.a();
    }

    public void a(d2 d2Var) {
        if (!c()) {
            i.a("PermissionCheckableMSC", "Missing critical permissions");
        } else {
            this.a.a(d2Var);
        }
    }

    public void b() {
        this.a.b();
    }
}

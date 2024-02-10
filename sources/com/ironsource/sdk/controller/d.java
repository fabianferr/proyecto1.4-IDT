package com.ironsource.sdk.controller;

import android.webkit.JavascriptInterface;
import com.ironsource.sdk.controller.A;
import com.ironsource.sdk.utils.Logger;
import java.lang.reflect.Method;
import java.security.AccessControlException;

class d {
    private static final String b = "d";
    final A.d a;

    d(A.d dVar) {
        this.a = dVar;
    }

    /* access modifiers changed from: package-private */
    public final synchronized void a(String str, String str2) {
        if (this.a == null) {
            Logger.e(b, "!!! nativeAPI == null !!!");
            return;
        }
        Method declaredMethod = A.d.class.getDeclaredMethod(str, new Class[]{String.class});
        if (declaredMethod.isAnnotationPresent(JavascriptInterface.class)) {
            declaredMethod.invoke(this.a, new Object[]{str2});
            return;
        }
        throw new AccessControlException("Trying to access a private function: " + str);
    }
}

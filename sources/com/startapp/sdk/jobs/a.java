package com.startapp.sdk.jobs;

import android.content.Context;
import android.os.Bundle;
import com.startapp.h0;
import com.startapp.sdk.jobs.b;
import java.lang.reflect.Constructor;

/* compiled from: Sta */
public abstract class a {
    public abstract void a(b bVar);

    public boolean a(Context context, String[] strArr, b.a aVar, Bundle bundle) {
        Class<? extends U> cls;
        if (strArr == null || strArr.length == 0) {
            return false;
        }
        boolean z = false;
        for (String cls2 : strArr) {
            try {
                cls = Class.forName(cls2).asSubclass(b.class);
            } catch (ClassNotFoundException unused) {
                cls = null;
            }
            if (cls != null) {
                try {
                    Constructor<? extends U> declaredConstructor = cls.getDeclaredConstructor(new Class[]{Context.class, b.a.class, Bundle.class});
                    declaredConstructor.setAccessible(true);
                    Context a = h0.a(context);
                    if (a == null) {
                        a = context;
                    }
                    a((b) declaredConstructor.newInstance(new Object[]{a, aVar, bundle}));
                    z = true;
                } catch (Throwable unused2) {
                }
            }
        }
        return z;
    }
}

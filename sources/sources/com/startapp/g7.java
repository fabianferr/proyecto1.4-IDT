package com.startapp;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageInfo;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.startapp.sdk.adsbase.remoteconfig.RcdMetadata;
import com.startapp.sdk.adsbase.remoteconfig.RcdTargets;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: Sta */
public class g7 {
    public static final String[] k = {"getSupportFragmentManager", "getFragmentManager"};
    public final Context a;
    public final Executor b;
    public final Executor c;
    public final i2<RcdMetadata> d;
    public final Application.ActivityLifecycleCallbacks e;
    public final Map<String, Integer> f = new HashMap();
    public final Map<String, List<WeakReference<Activity>>> g = new HashMap();
    public Boolean h;
    public String i;
    public final Runnable j = new a();

    /* compiled from: Sta */
    public class a implements Runnable {
        public a() {
        }

        public void run() {
            try {
                g7.this.d();
            } catch (Throwable th) {
                i3.a(th);
            }
        }
    }

    /* compiled from: Sta */
    public class b extends x1 {
        public b() {
        }

        public void onActivityPostResumed(Activity activity) {
            try {
                g7.this.a(activity);
            } catch (Throwable th) {
                i3.a(th);
            }
        }
    }

    /* compiled from: Sta */
    public class c implements Runnable {
        public final /* synthetic */ Activity a;

        public c(Activity activity) {
            this.a = activity;
        }

        public void run() {
            try {
                g7.this.b(this.a);
            } catch (Throwable th) {
                i3.a(th);
            }
        }
    }

    /* compiled from: Sta */
    public class d implements Runnable {
        public final /* synthetic */ Activity a;
        public final /* synthetic */ View b;

        public d(Activity activity, View view) {
            this.a = activity;
            this.b = view;
        }

        public void run() {
            try {
                g7 g7Var = g7.this;
                Activity activity = this.a;
                View view = this.b;
                RcdTargets a2 = g7Var.a();
                if (a2 != null) {
                    if (g7Var.a(a2, activity)) {
                        return;
                    }
                    try {
                        g7Var.a(a2, view);
                    } catch (Throwable th) {
                        i3.a(th);
                    }
                    g7Var.c.execute(g7Var.j);
                }
            } catch (Throwable th2) {
                i3.a(th2);
            }
        }
    }

    /* compiled from: Sta */
    public class e implements Runnable {
        public final /* synthetic */ StackTraceElement[] a;
        public final /* synthetic */ int b;

        public e(StackTraceElement[] stackTraceElementArr, int i) {
            this.a = stackTraceElementArr;
            this.b = i;
        }

        public void run() {
            try {
                g7 g7Var = g7.this;
                StackTraceElement[] stackTraceElementArr = this.a;
                int i = this.b;
                RcdTargets a2 = g7Var.a();
                if (a2 != null) {
                    for (StackTraceElement className : stackTraceElementArr) {
                        g7Var.a(a2, className.getClassName(), i);
                    }
                    g7Var.c.execute(g7Var.j);
                }
            } catch (Throwable th) {
                i3.a(th);
            }
        }
    }

    public g7(Context context, Executor executor, i2<RcdMetadata> i2Var) {
        this.a = context;
        this.b = executor;
        this.c = new r7(executor);
        this.d = i2Var;
        this.e = new b();
    }

    public final RcdTargets a() {
        RcdMetadata a2 = this.d.a();
        if (a2 == null || !a2.c()) {
            a2 = null;
        }
        if (a2 != null) {
            return a2.b();
        }
        return null;
    }

    public final boolean b() {
        Boolean bool = this.h;
        if (bool == null) {
            RcdMetadata a2 = this.d.a();
            if (a2 == null || !a2.c()) {
                a2 = null;
            }
            bool = Boolean.valueOf(a2 == null || Math.random() >= a2.a());
            this.h = bool;
        }
        return bool.booleanValue();
    }

    public void c() {
        RcdTargets a2 = a();
        if (a2 != null) {
            for (String next : a2.a(1)) {
                try {
                    Class.forName(next, false, g7.class.getClassLoader());
                    a(next, 1);
                } catch (ClassNotFoundException unused) {
                } catch (Throwable th) {
                    i3.a(th);
                }
            }
            try {
                String packageName = this.a.getPackageName();
                PackageInfo packageInfo = this.a.getPackageManager().getPackageInfo(packageName, 15);
                if (packageInfo != null) {
                    a(a2, packageName, (T[]) packageInfo.activities);
                    a(a2, packageName, (T[]) packageInfo.receivers);
                    a(a2, packageName, (T[]) packageInfo.services);
                    a(a2, packageName, (T[]) packageInfo.providers);
                }
            } catch (Throwable th2) {
                i3.a(th2);
            }
            this.c.execute(this.j);
        }
    }

    public void d() {
        HashMap hashMap;
        RcdTargets a2 = a();
        if (a2 != null) {
            synchronized (this.f) {
                hashMap = new HashMap(this.f);
            }
            String a3 = a2.a((Map<String, Integer>) hashMap);
            if (!a3.equals(this.i)) {
                this.i = a3;
                i3 i3Var = new i3(j3.d);
                i3Var.d = "RCD.results";
                i3Var.e = a3;
                i3Var.a();
            }
        }
    }

    public void a(Activity activity) {
        Window window;
        View decorView;
        if (!b()) {
            String name = activity.getClass().getName();
            Map<Activity, Integer> map = k9.a;
            if (!name.startsWith("com.startapp.")) {
                List list = this.g.get(name);
                if (list == null) {
                    list = new ArrayList(2);
                    this.g.put(name, list);
                    this.b.execute(new c(activity));
                }
                Iterator it = list.iterator();
                boolean z = false;
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    if (weakReference.get() == null) {
                        it.remove();
                    } else if (weakReference.get() == activity) {
                        z = true;
                    }
                }
                if (!z && (window = activity.getWindow()) != null && (decorView = window.getDecorView()) != null) {
                    list.add(new WeakReference(activity));
                    this.b.execute(new d(activity, decorView));
                }
            }
        }
    }

    public void b(Activity activity) {
        RcdTargets a2 = a();
        if (a2 != null) {
            try {
                if (a(a2, activity)) {
                    return;
                }
            } catch (Throwable th) {
                i3.a(th);
            }
            try {
                a(a2, activity, 16, 32);
            } catch (Throwable th2) {
                i3.a(th2);
            }
            for (String method : k) {
                try {
                    Object invoke = activity.getClass().getMethod(method, new Class[0]).invoke(activity, new Object[0]);
                    if (invoke != null) {
                        Object invoke2 = invoke.getClass().getMethod("getFragments", new Class[0]).invoke(invoke, new Object[0]);
                        if (invoke2 instanceof Collection) {
                            for (Object next : (Collection) invoke2) {
                                if (next != null) {
                                    a(a2, next, 64, 128);
                                }
                            }
                        }
                    }
                } catch (NoSuchMethodException unused) {
                } catch (Throwable th3) {
                    i3.a(th3);
                }
            }
            this.c.execute(this.j);
        }
    }

    public final <T extends ComponentInfo> void a(RcdTargets rcdTargets, String str, T[] tArr) {
        if (tArr != null) {
            for (T t : tArr) {
                if (t != null) {
                    String str2 = t.name;
                    if (str2.startsWith(".")) {
                        a(rcdTargets, str + str2, 2);
                    } else {
                        a(rcdTargets, str2, 2);
                    }
                }
            }
        }
    }

    public void a(int i2) {
        try {
            if (!b()) {
                this.b.execute(new e(Thread.currentThread().getStackTrace(), i2));
            }
        } catch (Throwable th) {
            i3.a(th);
        }
    }

    public final void a(RcdTargets rcdTargets, View view) {
        if (view != null) {
            a(rcdTargets, view.getClass().getName(), 4);
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    a(rcdTargets, viewGroup.getChildAt(i2));
                }
            }
        }
    }

    public final boolean a(RcdTargets rcdTargets, Activity activity) {
        Collection<String> a2 = rcdTargets.a(8);
        String name = activity.getClass().getName();
        if (!a2.contains(name)) {
            return false;
        }
        a(name, 8);
        return true;
    }

    public final void a(RcdTargets rcdTargets, Object obj, int i2, int i3) {
        Class cls = obj.getClass();
        while (cls != null && !a(cls.getName())) {
            for (Field field : cls.getDeclaredFields()) {
                if (i2 != 0) {
                    a(rcdTargets, field.getType().getName(), i2);
                }
                try {
                    field.setAccessible(true);
                    if (!(field.get(obj) == null || i3 == 0)) {
                        a(rcdTargets, field.getType().getName(), i3);
                    }
                } catch (Throwable unused) {
                }
            }
            cls = cls.getSuperclass();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0065 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.startapp.sdk.adsbase.remoteconfig.RcdTargets r5, java.lang.String r6, int r7) {
        /*
            r4 = this;
            boolean r0 = a((java.lang.String) r6)
            if (r0 == 0) goto L_0x0007
            return
        L_0x0007:
            java.util.Map<android.app.Activity, java.lang.Integer> r0 = com.startapp.k9.a
            java.lang.String r0 = "com.startapp."
            boolean r0 = r6.startsWith(r0)
            if (r0 == 0) goto L_0x0012
            return
        L_0x0012:
            java.util.Collection r5 = r5.a((int) r7)
            java.util.Iterator r5 = r5.iterator()
        L_0x001a:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L_0x0065
            java.lang.Object r0 = r5.next()
            java.lang.String r0 = (java.lang.String) r0
            int r1 = r0.length()
            if (r1 <= 0) goto L_0x0062
            boolean r1 = r6.startsWith(r0)
            if (r1 == 0) goto L_0x0062
            int r1 = r0.length()
            r2 = 1
            int r1 = r1 - r2
            char r1 = r0.charAt(r1)
            r3 = 46
            if (r1 != r3) goto L_0x0044
            r4.a((java.lang.String) r0, (int) r7)
            goto L_0x0062
        L_0x0044:
            int r1 = r6.length()
            int r3 = r0.length()
            if (r1 <= r3) goto L_0x005e
            int r1 = r0.length()
            char r1 = r6.charAt(r1)
            r2 = 36
            if (r1 != r2) goto L_0x0062
            r4.a((java.lang.String) r0, (int) r7)
            goto L_0x0062
        L_0x005e:
            r4.a((java.lang.String) r0, (int) r7)
            goto L_0x0063
        L_0x0062:
            r2 = 0
        L_0x0063:
            if (r2 == 0) goto L_0x001a
        L_0x0065:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.g7.a(com.startapp.sdk.adsbase.remoteconfig.RcdTargets, java.lang.String, int):void");
    }

    public final void a(String str, int i2) {
        synchronized (this.f) {
            Integer num = this.f.get(str);
            if (num == null) {
                num = 0;
            }
            this.f.put(str, Integer.valueOf(i2 | num.intValue()));
        }
    }

    public static boolean a(String str) {
        return str.startsWith("android") || str.startsWith("java.");
    }
}

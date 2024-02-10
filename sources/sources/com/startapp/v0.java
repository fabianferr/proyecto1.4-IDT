package com.startapp;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

/* compiled from: Sta */
public abstract class v0 {
    public final Context a;
    public final g6 b;
    public final Handler c;
    public final Runnable d = new a();

    /* compiled from: Sta */
    public class a implements Runnable {
        public a() {
        }

        public void run() {
            v0.this.a();
        }
    }

    /* compiled from: Sta */
    public class b implements g6 {
        public boolean a;
        public final /* synthetic */ g6 b;

        public b(g6 g6Var) {
            this.b = g6Var;
        }

        public synchronized void a(Object obj) {
            if (!this.a) {
                this.a = true;
                v0.this.c.removeCallbacksAndMessages((Object) null);
                this.b.a(obj);
            }
        }
    }

    public v0(Context context, g6 g6Var) {
        this.a = context;
        this.b = new b(g6Var);
        this.c = new Handler(Looper.getMainLooper());
    }

    public abstract void a();
}

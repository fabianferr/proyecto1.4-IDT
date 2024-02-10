package com.startapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import com.startapp.sdk.components.ComponentLocator;

/* compiled from: Sta */
public class b1 {
    public final Context a;
    public String b;
    public b c;
    public int d;

    /* compiled from: Sta */
    public class a implements Runnable {

        /* renamed from: com.startapp.b1$a$a  reason: collision with other inner class name */
        /* compiled from: Sta */
        public class C0159a implements Runnable {
            public final /* synthetic */ Bitmap a;

            public C0159a(Bitmap bitmap) {
                this.a = bitmap;
            }

            public void run() {
                b1 b1Var = b1.this;
                b bVar = b1Var.c;
                if (bVar != null) {
                    bVar.a(this.a, b1Var.d);
                }
            }
        }

        public a() {
        }

        public void run() {
            new Handler(Looper.getMainLooper()).post(new C0159a(c1.b(b1.this.b)));
        }
    }

    /* compiled from: Sta */
    public interface b {
        void a(Bitmap bitmap, int i);
    }

    public b1(Context context, String str, b bVar, int i) {
        this.a = context;
        this.b = str;
        this.c = bVar;
        this.d = i;
    }

    public void a() {
        ComponentLocator.a(this.a).z.a().execute(new a());
    }
}

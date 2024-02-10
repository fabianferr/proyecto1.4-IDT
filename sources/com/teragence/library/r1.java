package com.teragence.library;

import android.os.Looper;
import com.teragence.client.service.k;

public class r1 implements q1 {
    /* access modifiers changed from: private */
    public final q1 a;

    class a implements Runnable {
        final /* synthetic */ com.teragence.client.a b;
        final /* synthetic */ boolean c;

        /* renamed from: com.teragence.library.r1$a$a  reason: collision with other inner class name */
        class C0171a extends com.teragence.client.a<k> {
            final /* synthetic */ Looper a;

            C0171a(Looper looper) {
                this.a = looper;
            }

            public void a(k kVar) {
                this.a.quit();
                a.this.b.a(kVar);
            }
        }

        a(com.teragence.client.a aVar, boolean z) {
            this.b = aVar;
            this.c = z;
        }

        public void run() {
            try {
                Looper.prepare();
                r1.this.a.a(new C0171a(Looper.myLooper()), this.c);
                Looper.loop();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public r1(q1 q1Var) {
        this.a = q1Var;
    }

    public void a() {
        this.a.a();
    }

    public void a(com.teragence.client.a<k> aVar, boolean z) {
        new Thread(new a(aVar, z)).start();
    }
}

package com.startapp;

import android.content.Context;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;

/* compiled from: Sta */
public class t2 extends v0 {

    /* compiled from: Sta */
    public class a implements Runnable {
        public final /* synthetic */ p7 a;

        public a(p7 p7Var) {
            this.a = p7Var;
        }

        public void run() {
            JSONArray jSONArray;
            p7 p7Var = this.a;
            p7Var.c.unregisterListener(p7Var.f);
            g6 g6Var = t2.this.b;
            p7 p7Var2 = this.a;
            p7Var2.getClass();
            try {
                jSONArray = p7Var2.b.a();
            } catch (Exception unused) {
                jSONArray = null;
            }
            g6Var.a(jSONArray);
        }
    }

    public t2(Context context, g6 g6Var) {
        super(context, g6Var);
    }

    public void a() {
        try {
            long millis = TimeUnit.SECONDS.toMillis((long) MetaData.k.I().k());
            p7 p7Var = new p7(this.a, this.b);
            this.c.postDelayed(new a(p7Var), millis);
            p7Var.b();
        } catch (Throwable th) {
            i3.a(th);
            this.b.a((Object) null);
        }
    }
}

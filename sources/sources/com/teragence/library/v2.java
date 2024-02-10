package com.teragence.library;

import android.content.Context;
import com.teragence.client.i;
import com.teragence.library.w2;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class v2 implements w2 {
    private final Context a;
    private final long b;
    private long c = 0;
    private InetAddress d = null;

    public v2(Context context, long j) {
        this.a = context;
        this.b = j;
    }

    private boolean a() {
        boolean z = System.currentTimeMillis() - this.c > this.b || System.currentTimeMillis() < this.c;
        if (z) {
            i.a("CheckNetworkUseCase", String.format("resolved controller ip expired: %d, %d, %d", new Object[]{Long.valueOf(System.currentTimeMillis()), Long.valueOf(this.c), Long.valueOf(this.b)}));
        }
        return z;
    }

    public void a(w2.a aVar, d2 d2Var) {
        if (this.d == null || a()) {
            try {
                this.d = InetAddress.getByName("control.teragence.net");
                this.c = System.currentTimeMillis();
            } catch (UnknownHostException e) {
                i.a("CheckNetworkUseCase", "execute: ", (Exception) e);
                aVar.a(e);
                return;
            } catch (Exception e2) {
                i.a("CheckNetworkUseCase", "execute: ", e2);
            }
        }
        InetAddress inetAddress = this.d;
        if (inetAddress != null && !v0.a(inetAddress)) {
            i.c("CheckNetworkUseCase", "Default network may not be available, trying to lock to cellular network");
            d2Var.a().set(true);
            v0.a(this.a, this.d);
        }
        aVar.a();
    }
}

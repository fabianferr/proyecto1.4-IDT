package com.ironsource.sdk.l;

import android.os.Handler;
import android.os.Message;
import com.ironsource.sdk.h.c;
import com.ironsource.sdk.utils.IronSourceStorageUtils;

final class g implements Runnable {
    private final Handler a;
    private final a b;

    g(a aVar, Handler handler) {
        this.b = aVar;
        this.a = handler;
    }

    public final void run() {
        int i;
        c cVar = new c(this.b.a.getParent(), this.b.a.getName());
        Message message = new Message();
        message.obj = cVar;
        String makeDir = IronSourceStorageUtils.makeDir(cVar.getParent());
        if (makeDir == null) {
            i = 1020;
        } else {
            b a2 = new e(new a(cVar, this.b.b, this.b.c, this.b.d, this.b.e), makeDir, 3).call();
            i = a2.b == 200 ? 1016 : a2.b;
        }
        message.what = i;
        this.a.sendMessage(message);
    }
}

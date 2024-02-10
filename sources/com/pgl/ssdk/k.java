package com.pgl.ssdk;

import android.os.Handler;
import android.os.Message;

class k implements Handler.Callback {
    final /* synthetic */ l a;

    k(l lVar) {
        this.a = lVar;
    }

    public boolean handleMessage(Message message) {
        if (this.a.j >= this.a.i) {
            boolean unused = this.a.k = false;
            int unused2 = this.a.j = 0;
            this.a.l.quit();
            return false;
        } else if (this.a.a()) {
            boolean unused3 = this.a.k = false;
            int unused4 = this.a.j = 0;
            this.a.l.quit();
            return true;
        } else {
            this.a.m.sendEmptyMessageDelayed(1, (long) (this.a.h * 1));
            l.b(this.a);
            return false;
        }
    }
}

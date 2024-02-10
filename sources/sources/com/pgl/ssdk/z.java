package com.pgl.ssdk;

import android.os.Handler;
import android.os.Message;

class z implements Handler.Callback {
    final /* synthetic */ A a;

    z(A a2) {
        this.a = a2;
    }

    public boolean handleMessage(Message message) {
        byte[] bArr;
        r b;
        A a2 = this.a;
        if (a2.b >= a2.a) {
            A a3 = this.a;
            a3.b = 0;
            a3.quit();
            y.a = 500;
            return false;
        }
        try {
            bArr = E.a(this.a.e, this.a.f);
        } catch (Throwable unused) {
            bArr = null;
        }
        if (bArr == null || (b = u.a().b()) == null) {
            A a4 = this.a;
            a4.g.sendEmptyMessageDelayed(1, (long) (a4.c * 1));
            this.a.b++;
            return false;
        }
        b.post(new C(bArr, this.a.d, this.a));
        return true;
    }
}

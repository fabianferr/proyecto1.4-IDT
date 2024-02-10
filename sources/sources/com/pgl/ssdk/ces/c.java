package com.pgl.ssdk.ces;

import android.util.Log;
import com.pgl.ssdk.i;
import java.util.Calendar;

class c implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ d b;

    c(d dVar, String str) {
        this.b = dVar;
        this.a = str;
    }

    public void run() {
        try {
            long j = 0;
            long timeInMillis = this.b.a ? Calendar.getInstance().getTimeInMillis() : 0;
            byte[] bArr = (byte[]) a.meta(222, this.b.b, this.a);
            if (this.b.a) {
                j = Calendar.getInstance().getTimeInMillis();
            }
            if (this.b.a) {
                Log.d("CZL_Efficient", "[Efficient] report : " + (j - timeInMillis));
            }
            if (bArr != null) {
                if (bArr.length > 0) {
                    new i(this.b.b, (String) null).a(1, 2, bArr);
                    return;
                }
            }
            d.h = false;
        } catch (Throwable unused) {
        }
    }
}

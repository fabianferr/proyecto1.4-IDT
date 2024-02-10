package com.startapp;

import android.os.Handler;
import android.os.SystemClock;
import android.widget.TextView;

/* compiled from: Sta */
public class i5 implements Runnable {
    public final /* synthetic */ h5 a;

    public i5(h5 h5Var) {
        this.a = h5Var;
    }

    public void run() {
        long j = 1000;
        long uptimeMillis = (((long) this.a.s) * 1000) - SystemClock.uptimeMillis();
        h5 h5Var = this.a;
        long j2 = uptimeMillis + h5Var.z;
        TextView textView = h5Var.O;
        if (textView != null) {
            long j3 = j2 / 1000;
            if (j3 > 0 && j2 % 1000 < 100) {
                j3--;
            }
            textView.setText(String.valueOf(j3));
        }
        if (j2 >= 1000) {
            Handler handler = this.a.S;
            long j4 = j2 % 1000;
            if (j4 != 0) {
                j = j4;
            }
            handler.postDelayed(this, j);
            return;
        }
        h5 h5Var2 = this.a;
        if (h5Var2.O != null) {
            h5Var2.P.setVisibility(8);
            this.a.O.setVisibility(8);
        }
        this.a.t();
    }
}

package com.startapp;

import android.net.Uri;
import com.startapp.sdk.adsbase.remoteconfig.NetworkDiagnosticConfig;
import com.startapp.sdk.common.SDKException;

/* compiled from: Sta */
public class y5 {
    public final v5 a;
    public final long b = k9.a();

    public y5(v5 v5Var) {
        this.a = v5Var;
    }

    public void a(String str, String str2, SDKException sDKException) {
        int i;
        String str3;
        long a2 = k9.a();
        v5 v5Var = this.a;
        long j = a2 - this.b;
        NetworkDiagnosticConfig a3 = v5Var.a();
        if (a3 != null) {
            if (sDKException == null) {
                str3 = "Success";
                i = 4;
            } else if (sDKException.getCause() != null) {
                StringBuilder a4 = p0.a("Failure: ");
                a4.append(sDKException.getCause().getClass().getName());
                str3 = a4.toString();
                i = 2;
            } else {
                StringBuilder a5 = p0.a("Error: ");
                a5.append(sDKException.a());
                str3 = a5.toString();
                i = 1;
            }
            if ((a3.d() & i) != 0) {
                Uri b2 = sDKException != null ? sDKException.b() : null;
                if (b2 == null) {
                    b2 = Uri.parse(str2).buildUpon().query((String) null).build();
                }
                v5Var.c.execute(new w5(v5Var, str + ' ' + b2, str3, j));
            }
            if (i == 4) {
                v5Var.c.execute(v5Var.e);
            }
        }
    }
}

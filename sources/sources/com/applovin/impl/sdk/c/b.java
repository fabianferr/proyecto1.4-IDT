package com.applovin.impl.sdk.c;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import com.applovin.impl.sdk.ad.e;
import com.applovin.impl.sdk.m;
import com.applovin.sdk.AppLovinSdkUtils;

public class b {
    /* access modifiers changed from: private */
    public final m a;
    /* access modifiers changed from: private */
    public final Activity b;
    /* access modifiers changed from: private */
    public AlertDialog c;
    /* access modifiers changed from: private */
    public a d;

    public interface a {
        void a();

        void b();
    }

    public b(Activity activity, m mVar) {
        this.a = mVar;
        this.b = activity;
    }

    public void a() {
        this.b.runOnUiThread(new Runnable() {
            public void run() {
                if (b.this.c != null) {
                    b.this.c.dismiss();
                }
            }
        });
    }

    public void a(final e eVar, final Runnable runnable) {
        this.b.runOnUiThread(new Runnable() {
            public void run() {
                AlertDialog.Builder builder = new AlertDialog.Builder(b.this.b);
                builder.setTitle(eVar.an());
                String ao = eVar.ao();
                if (AppLovinSdkUtils.isValidString(ao)) {
                    builder.setMessage(ao);
                }
                builder.setPositiveButton(eVar.ap(), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (runnable != null) {
                            runnable.run();
                        }
                    }
                });
                builder.setCancelable(false);
                AlertDialog unused = b.this.c = builder.show();
            }
        });
    }

    public void a(a aVar) {
        this.d = aVar;
    }

    public void b() {
        this.b.runOnUiThread(new Runnable() {
            public void run() {
                AlertDialog unused = b.this.c = new AlertDialog.Builder(b.this.b).setTitle((CharSequence) b.this.a.a(com.applovin.impl.sdk.d.b.bx)).setMessage((CharSequence) b.this.a.a(com.applovin.impl.sdk.d.b.by)).setCancelable(false).setPositiveButton((CharSequence) b.this.a.a(com.applovin.impl.sdk.d.b.bA), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        b.this.d.a();
                    }
                }).setNegativeButton((CharSequence) b.this.a.a(com.applovin.impl.sdk.d.b.bz), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        b.this.d.b();
                    }
                }).show();
            }
        });
    }

    public boolean c() {
        AlertDialog alertDialog = this.c;
        if (alertDialog != null) {
            return alertDialog.isShowing();
        }
        return false;
    }
}

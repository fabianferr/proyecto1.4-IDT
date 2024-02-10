package com.applovin.impl.sdk;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.d.b;
import com.applovin.impl.sdk.utils.h;
import com.applovin.impl.sdk.utils.o;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

class k implements AppLovinBroadcastManager.Receiver {
    /* access modifiers changed from: private */
    public static AlertDialog b;
    /* access modifiers changed from: private */
    public static final AtomicBoolean c = new AtomicBoolean();
    /* access modifiers changed from: private */
    public final l a;
    private o d;

    public interface a {
        void a();

        void b();
    }

    k(l lVar, m mVar) {
        this.a = lVar;
        mVar.aj().registerReceiver(this, new IntentFilter("com.applovin.application_paused"));
        mVar.aj().registerReceiver(this, new IntentFilter("com.applovin.application_resumed"));
    }

    public void a(long j, final m mVar, final a aVar) {
        if (j > 0) {
            AlertDialog alertDialog = b;
            if (alertDialog == null || !alertDialog.isShowing()) {
                if (c.getAndSet(true)) {
                    if (j < this.d.a()) {
                        if (u.a()) {
                            u A = mVar.A();
                            A.b("ConsentAlertManager", "Scheduling consent alert earlier (" + j + "ms) than remaining scheduled time (" + this.d.a() + "ms)");
                        }
                        this.d.d();
                    } else if (u.a()) {
                        u A2 = mVar.A();
                        A2.d("ConsentAlertManager", "Skip scheduling consent alert - one scheduled already with remaining time of " + this.d.a() + " milliseconds");
                        return;
                    } else {
                        return;
                    }
                }
                if (u.a()) {
                    u A3 = mVar.A();
                    A3.b("ConsentAlertManager", "Scheduling consent alert for " + j + " milliseconds");
                }
                this.d = o.a(j, mVar, new Runnable() {
                    public void run() {
                        String str;
                        u uVar;
                        if (!k.this.a.d()) {
                            Activity a2 = mVar.af().a();
                            if (a2 == null || !h.a(mVar.L())) {
                                if (u.a()) {
                                    if (a2 == null) {
                                        uVar = mVar.A();
                                        str = "No parent Activity found - rescheduling consent alert...";
                                    } else {
                                        uVar = mVar.A();
                                        str = "No internet available - rescheduling consent alert...";
                                    }
                                    uVar.e("ConsentAlertManager", str);
                                }
                                k.c.set(false);
                                k.this.a(((Long) mVar.a(b.aH)).longValue(), mVar, aVar);
                                return;
                            }
                            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                                public void run() {
                                    AlertDialog unused = k.b = new AlertDialog.Builder(mVar.af().a()).setTitle((CharSequence) mVar.a(b.aI)).setMessage((CharSequence) mVar.a(b.aJ)).setCancelable(false).setPositiveButton((CharSequence) mVar.a(b.aK), new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                            aVar.a();
                                            dialogInterface.dismiss();
                                            k.c.set(false);
                                        }
                                    }).setNegativeButton((CharSequence) mVar.a(b.aL), new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                            aVar.b();
                                            dialogInterface.dismiss();
                                            k.c.set(false);
                                            k.this.a(((Long) mVar.a(b.aG)).longValue(), mVar, aVar);
                                        }
                                    }).create();
                                    k.b.show();
                                }
                            });
                        } else if (u.a()) {
                            mVar.A().e("ConsentAlertManager", "Consent dialog already showing, skip showing of consent alert");
                        }
                    }
                });
            }
        }
    }

    public void onReceive(Context context, Intent intent, Map<String, Object> map) {
        if (this.d != null) {
            String action = intent.getAction();
            if ("com.applovin.application_paused".equals(action)) {
                this.d.b();
            } else if ("com.applovin.application_resumed".equals(action)) {
                this.d.c();
            }
        }
    }
}

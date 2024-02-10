package com.bytedance.sdk.openadsdk.multipro.aidl.b;

import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.IAppOpenAdInteractionListener;
import com.bytedance.sdk.openadsdk.apiImpl.c.b;
import com.bytedance.sdk.openadsdk.utils.aa;

/* compiled from: AppOpenAdListenerImpl */
public class a extends IAppOpenAdInteractionListener.Stub {
    /* access modifiers changed from: private */
    public b a;

    public a(b bVar) {
        this.a = bVar;
    }

    private void a() {
        this.a = null;
    }

    public void onDestroy() throws RemoteException {
        a();
    }

    public void onAdShow() throws RemoteException {
        if (this.a != null) {
            aa.a((Runnable) new Runnable() {
                public void run() {
                    if (a.this.a != null) {
                        a.this.a.a();
                    }
                }
            });
        }
    }

    public void onAdClicked() throws RemoteException {
        if (this.a != null) {
            aa.a((Runnable) new Runnable() {
                public void run() {
                    if (a.this.a != null) {
                        a.this.a.b();
                    }
                }
            });
        }
    }

    public void onAdSkip() throws RemoteException {
        if (this.a != null) {
            aa.a((Runnable) new Runnable() {
                public void run() {
                    if (a.this.a != null) {
                        a.this.a.c();
                    }
                }
            });
        }
    }

    public void onAdTimeOver() throws RemoteException {
        if (this.a != null) {
            aa.a((Runnable) new Runnable() {
                public void run() {
                    if (a.this.a != null) {
                        a.this.a.d();
                    }
                }
            });
        }
    }
}

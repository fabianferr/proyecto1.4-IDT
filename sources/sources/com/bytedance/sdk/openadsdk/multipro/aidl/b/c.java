package com.bytedance.sdk.openadsdk.multipro.aidl.b;

import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener;
import com.bytedance.sdk.openadsdk.apiImpl.b.b;
import com.bytedance.sdk.openadsdk.utils.aa;

/* compiled from: FullScreenVideoListenerImpl */
public class c extends IFullScreenVideoAdInteractionListener.Stub {
    /* access modifiers changed from: private */
    public b a;

    public void onDestroy() throws RemoteException {
    }

    public c(b bVar) {
        this.a = bVar;
    }

    /* access modifiers changed from: private */
    public void a() {
        this.a = null;
    }

    public void onAdShow() throws RemoteException {
        if (this.a != null) {
            aa.a((Runnable) new Runnable() {
                public void run() {
                    if (c.this.a != null) {
                        c.this.a.a();
                    }
                }
            });
        }
    }

    public void onAdVideoBarClick() throws RemoteException {
        if (this.a != null) {
            aa.a((Runnable) new Runnable() {
                public void run() {
                    if (c.this.a != null) {
                        c.this.a.b();
                    }
                }
            });
        }
    }

    public void onAdClose() throws RemoteException {
        if (this.a != null) {
            aa.a((Runnable) new Runnable() {
                public void run() {
                    if (c.this.a != null) {
                        c.this.a.c();
                    }
                    c.this.a();
                }
            });
        }
    }
}

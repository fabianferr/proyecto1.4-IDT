package com.bytedance.sdk.openadsdk.multipro.aidl.b;

import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.IRewardAdInteractionListener;
import com.bytedance.sdk.openadsdk.apiImpl.d.a;
import com.bytedance.sdk.openadsdk.utils.aa;

/* compiled from: RewardVideoListenerImpl */
public class d extends IRewardAdInteractionListener.Stub {
    /* access modifiers changed from: private */
    public a a;

    public void onDestroy() throws RemoteException {
    }

    public d(a aVar) {
        this.a = aVar;
    }

    /* access modifiers changed from: private */
    public void a() {
        this.a = null;
    }

    public void onAdShow() throws RemoteException {
        if (this.a != null) {
            aa.a((Runnable) new Runnable() {
                public void run() {
                    if (d.this.a != null) {
                        d.this.a.a();
                    }
                }
            });
        }
    }

    public void onAdVideoBarClick() throws RemoteException {
        if (this.a != null) {
            aa.a((Runnable) new Runnable() {
                public void run() {
                    if (d.this.a != null) {
                        d.this.a.b();
                    }
                }
            });
        }
    }

    public void onAdClose() throws RemoteException {
        if (this.a != null) {
            aa.a((Runnable) new Runnable() {
                public void run() {
                    if (d.this.a != null) {
                        d.this.a.c();
                    }
                    d.this.a();
                }
            });
        }
    }

    public void onRewardVerify(boolean z, int i, String str, int i2, String str2) throws RemoteException {
        if (this.a != null) {
            final boolean z2 = z;
            final int i3 = i;
            final String str3 = str;
            final int i4 = i2;
            final String str4 = str2;
            aa.a((Runnable) new Runnable() {
                public void run() {
                    if (d.this.a != null) {
                        d.this.a.a(z2, i3, str3, i4, str4);
                    }
                }
            });
        }
    }
}

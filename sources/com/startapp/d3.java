package com.startapp;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: Sta */
public interface d3 extends IInterface {

    /* compiled from: Sta */
    public static abstract class a extends Binder implements d3 {
        public static final /* synthetic */ int a = 0;

        /* renamed from: com.startapp.d3$a$a  reason: collision with other inner class name */
        /* compiled from: Sta */
        public static class C0161a implements d3 {
            public IBinder a;

            public C0161a(IBinder iBinder) {
                this.a = iBinder;
            }

            public Bundle a(Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
                    obtain.writeInt(1);
                    bundle.writeToParcel(obtain, 0);
                    if (!this.a.transact(1, obtain, obtain2, 0)) {
                        int i = a.a;
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.a;
            }
        }
    }

    Bundle a(Bundle bundle) throws RemoteException;
}

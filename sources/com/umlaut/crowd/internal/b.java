package com.umlaut.crowd.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import java.util.concurrent.LinkedBlockingQueue;

public class b {
    private static final String a = "b";

    private static final class c implements ServiceConnection {
        boolean a;
        private final LinkedBlockingQueue<IBinder> b;

        private c() {
            this.a = false;
            this.b = new LinkedBlockingQueue<>(1);
        }

        public IBinder a() throws InterruptedException {
            if (!this.a) {
                this.a = true;
                return this.b.take();
            }
            throw new IllegalStateException();
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.b.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    private static final class d implements IInterface {
        private IBinder a;

        d(IBinder iBinder) {
            this.a = iBinder;
        }

        public String a() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public IBinder asBinder() {
            return this.a;
        }
    }

    public static C0174b a(Context context) {
        C0174b bVar = new C0174b();
        if (Looper.myLooper() == Looper.getMainLooper()) {
            Log.e(a, "Cannot be called from the main thread");
            return bVar;
        }
        try {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            c cVar = new c();
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            try {
                if (context.bindService(intent, cVar, 1)) {
                    bVar = new C0174b(new d(cVar.a()).a(), true);
                }
            } catch (Exception e) {
                Log.v(a, e.toString());
            } finally {
                context.unbindService(cVar);
            }
            return bVar;
        } catch (Exception e2) {
            Log.v(a, e2.toString());
            return bVar;
        }
    }

    /* renamed from: com.umlaut.crowd.internal.b$b  reason: collision with other inner class name */
    public static final class C0174b {
        public String a;
        public boolean b;

        C0174b() {
            this.b = false;
        }

        C0174b(String str, boolean z) {
            this.a = str;
            this.b = z;
        }
    }
}

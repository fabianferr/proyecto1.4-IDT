package com.mbridge.msdk.foundation.tools;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: AdvertisingIdClient */
public final class b {

    /* compiled from: AdvertisingIdClient */
    public final class a {
        private final String b;
        private final boolean c;

        a(String str, boolean z) {
            this.b = str;
            this.c = z;
        }

        public final String a() {
            return this.b;
        }

        public final boolean b() {
            return this.c;
        }
    }

    public final a a(Context context) throws Exception {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            try {
                context.getPackageManager().getPackageInfo("com.android.vending", 0);
                C0144b bVar = new C0144b();
                Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                intent.setPackage("com.google.android.gms");
                if (context.bindService(intent, bVar, 1)) {
                    try {
                        c cVar = new c(bVar.a());
                        a aVar = new a(cVar.a(), cVar.a(true));
                        context.unbindService(bVar);
                        return aVar;
                    } catch (Exception e) {
                        throw e;
                    } catch (Throwable th) {
                        context.unbindService(bVar);
                        throw th;
                    }
                } else {
                    throw new IOException("Google Play connection failed");
                }
            } catch (Exception e2) {
                throw e2;
            }
        } else {
            throw new IllegalStateException("Cannot be called from the main thread");
        }
    }

    /* renamed from: com.mbridge.msdk.foundation.tools.b$b  reason: collision with other inner class name */
    /* compiled from: AdvertisingIdClient */
    private final class C0144b implements ServiceConnection {
        boolean a;
        private final LinkedBlockingQueue<IBinder> c;

        public final void onServiceDisconnected(ComponentName componentName) {
        }

        private C0144b() {
            this.a = false;
            this.c = new LinkedBlockingQueue<>(1);
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.c.put(iBinder);
            } catch (InterruptedException e) {
                aa.d("AdvertisingIdClient", e.getMessage());
            }
        }

        public final IBinder a() throws InterruptedException {
            if (!this.a) {
                this.a = true;
                return this.c.take();
            }
            throw new IllegalStateException();
        }
    }

    /* compiled from: AdvertisingIdClient */
    private final class c implements IInterface {
        private IBinder b;

        public c(IBinder iBinder) {
            this.b = iBinder;
        }

        public final IBinder asBinder() {
            return this.b;
        }

        /* JADX INFO: finally extract failed */
        public final String a() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.b.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                String readString = obtain2.readString();
                obtain2.recycle();
                obtain.recycle();
                return readString;
            } catch (Throwable th) {
                obtain2.recycle();
                obtain.recycle();
                throw th;
            }
        }

        public final boolean a(boolean z) throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            boolean z2 = false;
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                obtain.writeInt(z ? 1 : 0);
                this.b.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                if (obtain2.readInt() != 0) {
                    z2 = true;
                }
            } catch (Throwable th) {
                obtain2.recycle();
                obtain.recycle();
                throw th;
            }
            obtain2.recycle();
            obtain.recycle();
            return z2;
        }
    }
}

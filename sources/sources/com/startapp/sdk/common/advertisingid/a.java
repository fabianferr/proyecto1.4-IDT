package com.startapp.sdk.common.advertisingid;

import android.content.Context;
import com.startapp.i3;
import com.startapp.sdk.common.advertisingid.AdvertisingIdResolver;
import com.startapp.u;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: Sta */
public class a implements Runnable {
    public final /* synthetic */ AdvertisingIdResolver a;

    public a(AdvertisingIdResolver advertisingIdResolver) {
        this.a = advertisingIdResolver;
    }

    public void run() {
        AdvertisingIdResolver advertisingIdResolver;
        AdvertisingIdResolver advertisingIdResolver2;
        AtomicReference<u> atomicReference;
        Context context;
        u uVar;
        try {
            this.a.d.lock();
            try {
                advertisingIdResolver2 = this.a;
                atomicReference = advertisingIdResolver2.f;
                context = advertisingIdResolver2.a;
                advertisingIdResolver2.getClass();
                uVar = AdvertisingIdResolver.a(context);
            } catch (AdvertisingIdResolver.InternalException e) {
                advertisingIdResolver2.b(e.infoEventFlags);
            } catch (Throwable th) {
                try {
                    if (this.a.a(64)) {
                        i3.a(th);
                    }
                    advertisingIdResolver = this.a;
                } catch (Throwable th2) {
                    this.a.h = 2;
                    this.a.e.signalAll();
                    this.a.d.unlock();
                    throw th2;
                }
            }
            atomicReference.set(uVar);
            advertisingIdResolver = this.a;
            advertisingIdResolver.h = 2;
            this.a.e.signalAll();
            this.a.d.unlock();
            try {
                uVar = AdvertisingIdResolver.b(context);
            } catch (AdvertisingIdResolver.InternalException e2) {
                advertisingIdResolver2.b(e2.infoEventFlags);
                uVar = u.d;
                atomicReference.set(uVar);
                advertisingIdResolver = this.a;
                advertisingIdResolver.h = 2;
                this.a.e.signalAll();
                this.a.d.unlock();
            } catch (Throwable th3) {
                if (advertisingIdResolver2.a(256)) {
                    i3.a(th3);
                }
                uVar = u.d;
                atomicReference.set(uVar);
                advertisingIdResolver = this.a;
                advertisingIdResolver.h = 2;
                this.a.e.signalAll();
                this.a.d.unlock();
            }
            atomicReference.set(uVar);
            advertisingIdResolver = this.a;
            advertisingIdResolver.h = 2;
            this.a.e.signalAll();
            this.a.d.unlock();
        } catch (Throwable th4) {
            this.a.h = 2;
            if (this.a.a(16384)) {
                i3.a(th4);
            }
        }
    }
}

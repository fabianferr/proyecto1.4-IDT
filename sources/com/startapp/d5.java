package com.startapp;

import android.content.Context;
import android.hardware.SensorEvent;
import com.startapp.sdk.adsbase.remoteconfig.MotionMetadata;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: Sta */
public class d5 extends Thread {
    public final BlockingDeque<SensorEvent> a;
    public final v8 b;
    public final AtomicLong c = new AtomicLong(Double.doubleToRawLongBits(0.0d));
    public final AtomicLong d = new AtomicLong(Double.doubleToRawLongBits(0.0d));
    public final AtomicLong e = new AtomicLong(0);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d5(String str, Context context, MotionMetadata motionMetadata, int i, double d2, long j) {
        super(str);
        v8 v8Var = new v8(motionMetadata.f(), motionMetadata.g(), motionMetadata.h(), motionMetadata.i(), motionMetadata.s(), motionMetadata.t(), motionMetadata.d(), motionMetadata.e(), motionMetadata.b(), motionMetadata.a(), motionMetadata.c(), motionMetadata.o(), motionMetadata.p(), motionMetadata.m(), motionMetadata.l(), motionMetadata.n());
        this.b = v8Var;
        v8Var.a(d2, j);
        this.a = new LinkedBlockingDeque(i);
    }

    public void run() {
        while (true) {
            try {
                SensorEvent take = this.a.take();
                if (take != null) {
                    v8 v8Var = this.b;
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = take.timestamp;
                    float[] fArr = take.values;
                    v8Var.a(currentTimeMillis, j, (double) fArr[0], (double) fArr[1], (double) fArr[2]);
                    this.c.set(Double.doubleToRawLongBits(this.b.k.i));
                    this.d.set(Double.doubleToRawLongBits(this.b.k.g));
                    this.e.set(this.b.k.h);
                } else {
                    return;
                }
            } catch (InterruptedException unused) {
                return;
            } catch (Throwable th) {
                i3.a(th);
                return;
            }
        }
    }
}

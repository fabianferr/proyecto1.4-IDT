package com.startapp;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import com.startapp.sdk.adsbase.e;
import com.startapp.sdk.adsbase.remoteconfig.MotionMetadata;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Sta */
public class b5 {
    public static final AtomicInteger j = new AtomicInteger();
    public final Context a;
    public final e b;
    public final i2<MotionMetadata> c;
    public final Handler d;
    public d5 e;
    public boolean f;
    public int g;
    public Sensor h;
    public final SensorEventListener i = new a();

    /* compiled from: Sta */
    public class a implements SensorEventListener {
        public a() {
        }

        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        public void onSensorChanged(SensorEvent sensorEvent) {
            try {
                b5 b5Var = b5.this;
                d5 d5Var = b5Var.e;
                if (d5Var != null) {
                    if (!(d5Var != null && d5Var.a.offer(sensorEvent))) {
                        b5Var.a(8, (Throwable) null);
                    }
                }
            } catch (OutOfMemoryError unused) {
                b5 b5Var2 = b5.this;
                b5Var2.getClass();
                b5Var2.e();
            } catch (Throwable th) {
                i3.a(th);
            }
        }
    }

    public b5(Context context, e eVar, i2<MotionMetadata> i2Var, Handler handler) {
        this.a = context;
        this.b = eVar;
        this.c = i2Var;
        this.d = handler;
    }

    public final MotionMetadata a() {
        MotionMetadata a2 = this.c.a();
        if (a2 == null || !a2.u()) {
            return null;
        }
        return a2;
    }

    public double b() {
        MotionMetadata a2 = a();
        if (a2 == null) {
            return -1.0d;
        }
        d5 d5Var = this.e;
        if (d5Var != null) {
            return Double.longBitsToDouble(d5Var.c.get());
        }
        double d2 = (double) this.b.getFloat("e9142de3c7cc5952", 0.0f);
        double a3 = x.a(System.currentTimeMillis(), this.b.getLong("7783513af1730383", 0), a2.b(), a2.a(), a2.c(), l9.a(0.0d, a2.a(), a2.c()));
        Double.isNaN(d2);
        return d2 * a3;
    }

    public final void c() {
        if (this.e != null) {
            e.a a2 = this.b.edit();
            float longBitsToDouble = (float) Double.longBitsToDouble(this.e.d.get());
            a2.a("e9142de3c7cc5952", Float.valueOf(longBitsToDouble));
            a2.a.putFloat("e9142de3c7cc5952", longBitsToDouble);
            long j2 = this.e.e.get();
            a2.a("7783513af1730383", Long.valueOf(j2));
            a2.a.putLong("7783513af1730383", j2);
            a2.apply();
            if (a(4)) {
                i3 i3Var = new i3(j3.d);
                i3Var.d = "MP.save";
                i3Var.e = String.format(Locale.ENGLISH, "%.6f", new Object[]{Double.valueOf(b())});
                i3Var.a();
            }
        }
    }

    public final void d() {
        SensorManager sensorManager;
        MotionMetadata a2 = a();
        if (a2 != null && (sensorManager = (SensorManager) this.a.getSystemService("sensor")) != null && this.h == null) {
            Sensor defaultSensor = sensorManager.getDefaultSensor(1);
            int min = Math.min(Math.max(10000, (int) (k9.e(a2.r()) * 1000)), 100000);
            if (defaultSensor != null && sensorManager.registerListener(this.i, defaultSensor, min)) {
                this.h = defaultSensor;
                double d2 = (double) this.b.getFloat("e9142de3c7cc5952", 0.0f);
                long j2 = this.b.getLong("7783513af1730383", 0);
                d5 d5Var = this.e;
                if (d5Var != null) {
                    d5Var.interrupt();
                    this.e = null;
                }
                if (this.e == null) {
                    StringBuilder a3 = p0.a("startapp-mp-");
                    a3.append(j.incrementAndGet());
                    d5 d5Var2 = new d5(a3.toString(), this.a, a2, a2.q(), d2, j2);
                    this.e = d5Var2;
                    d5Var2.start();
                }
                if (a(1)) {
                    i3 i3Var = new i3(j3.d);
                    i3Var.d = "MP.start";
                    i3Var.e = defaultSensor.getName() + "," + defaultSensor.getMinDelay() + "," + defaultSensor.getPower();
                    i3Var.a();
                }
            }
        }
    }

    public final void e() {
        Sensor sensor;
        SensorManager sensorManager = (SensorManager) this.a.getSystemService("sensor");
        if (sensorManager != null && (sensor = this.h) != null) {
            sensorManager.unregisterListener(this.i, sensor);
            this.h = null;
            c();
            d5 d5Var = this.e;
            if (d5Var != null) {
                d5Var.interrupt();
                this.e = null;
            }
            if (a(2)) {
                i3 i3Var = new i3(j3.d);
                i3Var.d = "MP.stop";
                i3Var.a();
            }
        }
    }

    public final boolean a(int i2) {
        MotionMetadata a2;
        if (!this.f || (a2 = a()) == null || (i2 & a2.j()) == 0) {
            return false;
        }
        return true;
    }

    public final void a(int i2, Throwable th) {
        if (a(i2)) {
            int i3 = this.g;
            if (!((i3 & i2) != 0)) {
                this.g = i3 | i2;
                if (th != null) {
                    i3.a(th);
                    return;
                }
                i3 i3Var = new i3(j3.e);
                i3Var.d = "MP";
                i3Var.e = String.valueOf(i2);
                i3Var.a();
            }
        }
    }
}

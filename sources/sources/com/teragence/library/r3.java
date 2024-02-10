package com.teragence.library;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.teragence.client.i;
import com.teragence.library.o3;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class r3 implements o3 {
    /* access modifiers changed from: private */
    public final SensorManager a;
    private final Sensor b;
    private SensorEventListener c;
    /* access modifiers changed from: private */
    public b d;
    /* access modifiers changed from: private */
    public ExecutorService e;

    class a implements SensorEventListener {
        final /* synthetic */ o3.a a;

        a(o3.a aVar) {
            this.a = aVar;
        }

        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        public void onSensorChanged(SensorEvent sensorEvent) {
            try {
                r3.this.d.e = true;
                r3.this.e.shutdownNow();
            } catch (Exception unused) {
            }
            r3.this.a.unregisterListener(this);
            this.a.a(sensorEvent.values[0]);
        }
    }

    private static class b implements Runnable {
        private final r3 b;
        private final o3.a c;
        private final long d;
        boolean e;

        private b(r3 r3Var, o3.a aVar, long j) {
            this.b = r3Var;
            this.c = aVar;
            this.d = j;
        }

        /* synthetic */ b(r3 r3Var, o3.a aVar, long j, a aVar2) {
            this(r3Var, aVar, j);
        }

        public void run() {
            synchronized (this) {
                try {
                    wait(this.d);
                    if (!this.e) {
                        i.a("TimeLimitedRetrievePr", "time limit has ended - force barometer finish");
                        this.b.a();
                        this.c.a();
                    }
                } catch (Exception e2) {
                    i.a("TimeLimitedRetrievePr", "run: ", (Throwable) e2);
                }
            }
        }
    }

    public r3(SensorManager sensorManager, Sensor sensor) {
        this.a = sensorManager;
        this.b = sensor;
    }

    /* access modifiers changed from: private */
    public void a() {
        try {
            this.a.unregisterListener(this.c);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void a(o3.a aVar) {
        this.c = new a(aVar);
        this.d = new b(this, aVar, 20000, (a) null);
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        this.e = newSingleThreadExecutor;
        newSingleThreadExecutor.execute(this.d);
        if (!this.a.registerListener(this.c, this.b, 0)) {
            aVar.a();
        }
    }
}

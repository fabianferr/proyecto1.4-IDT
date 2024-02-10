package com.m2catalyst.m2sdk;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.m2catalyst.m2sdk.business.models.M2Location;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.jvm.internal.Ref;

/* compiled from: LocationCollectorManager.kt */
public final class f2 implements SensorEventListener {
    public final /* synthetic */ g2 a;
    public final /* synthetic */ Ref.ObjectRef<SensorEventListener> b;
    public final /* synthetic */ Continuation<M2Location> c;
    public final /* synthetic */ M2Location d;

    public f2(g2 g2Var, Ref.ObjectRef objectRef, SafeContinuation safeContinuation, M2Location m2Location) {
        this.a = g2Var;
        this.b = objectRef;
        this.c = safeContinuation;
        this.d = m2Location;
    }

    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        SensorManager a2 = this.a.g;
        if (a2 != null) {
            a2.unregisterListener((SensorEventListener) this.b.element);
        }
        if (sensorEvent != null) {
            M2Location m2Location = this.d;
            long j = sensorEvent.timestamp;
            long j2 = (long) 20000;
            long j3 = j + j2;
            if (j < j - j2 || j > j3) {
                float f = sensorEvent.values[0];
            } else {
                m2Location.setBarometricPressure(Float.valueOf(sensorEvent.values[0]));
            }
        }
        Continuation<M2Location> continuation = this.c;
        Result.Companion companion = Result.Companion;
        continuation.resumeWith(Result.m2344constructorimpl(this.d));
    }
}

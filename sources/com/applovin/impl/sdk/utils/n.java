package com.applovin.impl.sdk.utils;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.d.b;
import com.applovin.impl.sdk.m;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class n implements SensorEventListener, AppLovinBroadcastManager.Receiver {
    private final int a;
    private final float b;
    private final SensorManager c;
    private final Sensor d;
    private final Sensor e;
    private final m f;
    private float[] g;
    private float h;

    public n(m mVar) {
        this.f = mVar;
        SensorManager sensorManager = (SensorManager) mVar.L().getSystemService("sensor");
        this.c = sensorManager;
        this.d = sensorManager.getDefaultSensor(9);
        this.e = sensorManager.getDefaultSensor(4);
        this.a = ((Integer) mVar.a(b.dU)).intValue();
        this.b = ((Float) mVar.a(b.dT)).floatValue();
        mVar.aj().registerReceiver(this, new IntentFilter("com.applovin.application_paused"));
        mVar.aj().registerReceiver(this, new IntentFilter("com.applovin.application_resumed"));
    }

    public void a() {
        this.c.unregisterListener(this);
        if (((Boolean) this.f.K().a(b.dR)).booleanValue()) {
            this.c.registerListener(this, this.d, (int) TimeUnit.MILLISECONDS.toMicros((long) this.a));
        }
        if (((Boolean) this.f.K().a(b.dS)).booleanValue()) {
            this.c.registerListener(this, this.e, (int) TimeUnit.MILLISECONDS.toMicros((long) this.a));
        }
    }

    public float b() {
        return this.h;
    }

    public float c() {
        float[] fArr = this.g;
        if (fArr == null) {
            return 0.0f;
        }
        return (float) Math.toDegrees(Math.acos((double) (fArr[2] / 9.81f)));
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public void onReceive(Context context, Intent intent, Map<String, Object> map) {
        String action = intent.getAction();
        if ("com.applovin.application_paused".equals(action)) {
            this.c.unregisterListener(this);
        } else if ("com.applovin.application_resumed".equals(action)) {
            a();
        }
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 9) {
            this.g = sensorEvent.values;
        } else if (sensorEvent.sensor.getType() == 4) {
            float f2 = this.h * this.b;
            this.h = f2;
            this.h = f2 + Math.abs(sensorEvent.values[0]) + Math.abs(sensorEvent.values[1]) + Math.abs(sensorEvent.values[2]);
        }
    }
}

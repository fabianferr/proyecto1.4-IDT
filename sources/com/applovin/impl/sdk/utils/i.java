package com.applovin.impl.sdk.utils;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.m;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class i implements SensorEventListener, AppLovinBroadcastManager.Receiver {
    private final m a;
    private final SensorManager b;
    private final Sensor c;
    private final a d;
    private float e;

    public interface a {
        void b();

        void c();
    }

    public i(m mVar, a aVar) {
        this.a = mVar;
        SensorManager sensorManager = (SensorManager) mVar.L().getSystemService("sensor");
        this.b = sensorManager;
        this.c = sensorManager.getDefaultSensor(1);
        this.d = aVar;
    }

    public void a() {
        this.b.unregisterListener(this);
        this.b.registerListener(this, this.c, (int) TimeUnit.MILLISECONDS.toMicros(50));
        this.a.aj().unregisterReceiver(this);
        this.a.aj().registerReceiver(this, new IntentFilter("com.applovin.application_paused"));
        this.a.aj().registerReceiver(this, new IntentFilter("com.applovin.application_resumed"));
    }

    public void b() {
        this.a.aj().unregisterReceiver(this);
        this.b.unregisterListener(this);
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public void onReceive(Context context, Intent intent, Map<String, Object> map) {
        String action = intent.getAction();
        if ("com.applovin.application_paused".equals(action)) {
            this.b.unregisterListener(this);
        } else if ("com.applovin.application_resumed".equals(action)) {
            a();
        }
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 1) {
            float max = Math.max(Math.min(sensorEvent.values[2] / 9.81f, 1.0f), -1.0f);
            float f = this.e;
            float f2 = (f * 0.5f) + (max * 0.5f);
            this.e = f2;
            if (f < 0.8f && f2 > 0.8f) {
                this.d.c();
            } else if (f > -0.8f && f2 < -0.8f) {
                this.d.b();
            }
        }
    }
}

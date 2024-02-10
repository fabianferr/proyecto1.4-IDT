package com.startapp;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import com.startapp.sdk.adsbase.remoteconfig.BaseSensorConfig;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;
import com.startapp.sdk.adsbase.remoteconfig.SensorsConfig;
import java.util.HashMap;
import org.json.JSONArray;

/* compiled from: Sta */
public class p7 {
    public HashMap<Integer, b> a = null;
    public o7 b = new o7();
    public SensorManager c;
    public g6 d;
    public int e;
    public SensorEventListener f = new a();

    /* compiled from: Sta */
    public class a implements SensorEventListener {
        public a() {
        }

        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        public void onSensorChanged(SensorEvent sensorEvent) {
            int size;
            JSONArray jSONArray;
            o7 o7Var = p7.this.b;
            synchronized (o7Var) {
                int type = sensorEvent.sensor.getType();
                SensorEvent sensorEvent2 = o7Var.a.get(Integer.valueOf(type));
                if (sensorEvent2 == null || sensorEvent2.accuracy <= sensorEvent.accuracy) {
                    o7Var.a.put(Integer.valueOf(type), sensorEvent);
                }
                size = o7Var.a.size();
            }
            p7 p7Var = p7.this;
            if (size == p7Var.e) {
                p7Var.c.unregisterListener(p7Var.f);
                p7 p7Var2 = p7.this;
                g6 g6Var = p7Var2.d;
                if (g6Var != null) {
                    try {
                        jSONArray = p7Var2.b.a();
                    } catch (Exception unused) {
                        jSONArray = null;
                    }
                    g6Var.a(jSONArray);
                }
            }
        }
    }

    /* compiled from: Sta */
    public class b {
        public int a;
        public int b;

        public b(p7 p7Var, int i, int i2) {
            this.a = i;
            this.b = i2;
        }
    }

    public p7(Context context, g6 g6Var) {
        this.c = (SensorManager) context.getSystemService("sensor");
        this.d = g6Var;
        this.e = 0;
        a();
    }

    public final void a() {
        this.a = new HashMap<>();
        SensorsConfig I = MetaData.k.I();
        a(13, I.a());
        a(9, I.b());
        a(5, I.d());
        a(10, I.e());
        a(2, I.f());
        a(6, I.g());
        a(12, I.i());
        a(11, I.j());
        a(16, I.c());
    }

    public void b() {
        Sensor defaultSensor;
        for (Integer intValue : this.a.keySet()) {
            int intValue2 = intValue.intValue();
            b bVar = this.a.get(Integer.valueOf(intValue2));
            if (Build.VERSION.SDK_INT >= bVar.a && (defaultSensor = this.c.getDefaultSensor(intValue2)) != null) {
                this.c.registerListener(this.f, defaultSensor, bVar.b);
                this.e++;
            }
        }
    }

    public final void a(int i, BaseSensorConfig baseSensorConfig) {
        if (baseSensorConfig.c()) {
            this.a.put(Integer.valueOf(i), new b(this, baseSensorConfig.b(), baseSensorConfig.a()));
        }
    }
}

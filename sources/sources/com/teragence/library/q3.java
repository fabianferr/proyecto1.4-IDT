package com.teragence.library;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import com.teragence.library.o3;
import java.util.concurrent.Executors;

public class q3 {

    class a implements o3 {
        a() {
        }

        public void a(o3.a aVar) {
            aVar.a();
        }
    }

    class b implements o3 {
        b() {
        }

        public void a(o3.a aVar) {
            aVar.a();
        }
    }

    public static o3 a(Context context) {
        SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
        if (sensorManager == null) {
            return new b();
        }
        Sensor defaultSensor = sensorManager.getDefaultSensor(6);
        return defaultSensor != null ? new s3(new m3(new r3(sensorManager, defaultSensor), Executors.newCachedThreadPool())) : new a();
    }
}

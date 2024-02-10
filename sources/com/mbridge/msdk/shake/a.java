package com.mbridge.msdk.shake;

import android.content.Context;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.controller.b;
import com.mbridge.msdk.foundation.same.report.k;
import com.mbridge.msdk.foundation.same.report.q;

/* compiled from: NativeShakeManager */
public final class a {
    private SensorManager a;

    /* renamed from: com.mbridge.msdk.shake.a$a  reason: collision with other inner class name */
    /* compiled from: NativeShakeManager */
    private static class C0153a {
        static a a = new a();
    }

    private a() {
    }

    public static a a() {
        return C0153a.a;
    }

    public final void b(SensorEventListener sensorEventListener) {
        SensorManager sensorManager = this.a;
        if (sensorManager != null) {
            try {
                sensorManager.unregisterListener(sensorEventListener);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final void a(SensorEventListener sensorEventListener) {
        Context g = b.d().g();
        if (g != null) {
            try {
                if (this.a == null) {
                    this.a = (SensorManager) g.getSystemService("sensor");
                }
                this.a.registerListener(sensorEventListener, this.a.getDefaultSensor(1), 2);
            } catch (Exception e) {
                e.printStackTrace();
                String message = e.getMessage();
                if (g == null) {
                    return;
                }
                if (!TextUtils.isEmpty(message)) {
                    StringBuffer stringBuffer = new StringBuffer("key=2000106&");
                    if (!TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.l)) {
                        stringBuffer.append("b=" + com.mbridge.msdk.foundation.same.a.l + "&");
                    }
                    if (!TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.m)) {
                        stringBuffer.append("c=" + com.mbridge.msdk.foundation.same.a.m + "&");
                    }
                    stringBuffer.append("reason=" + message);
                    if (k.a().c()) {
                        k.a().a(stringBuffer.toString());
                    } else {
                        q.b(g, stringBuffer.toString());
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}

package com.startapp;

import android.content.Context;
import android.os.Build;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.telephony.TelephonyCallback;
import android.telephony.TelephonyManager;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.startapp.sdk.adsbase.e;
import com.startapp.sdk.adsbase.remoteconfig.TelephonyDataConfig;
import com.startapp.sdk.adsbase.remoteconfig.TelephonyMetadata;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: Sta */
public class k8 {
    public final Context a;
    public final v2 b;
    public final e c;
    public final u1 d;
    public final i2<TelephonyMetadata> e;
    public c f;
    public final double g = Math.random();
    public volatile String h = "e106";

    /* compiled from: Sta */
    public class a implements Runnable {
        public a() {
        }

        public void run() {
            k8 k8Var = k8.this;
            k8Var.getClass();
            try {
                if (k8Var.a() != null) {
                    c a2 = k8Var.a((Class<?>) SignalStrength.class);
                    if (a2 != null) {
                        a2.a();
                    }
                }
            } catch (Throwable th) {
                if (k8Var.a(8)) {
                    i3.a(th);
                }
            }
        }
    }

    /* compiled from: Sta */
    public class b extends c {
        public final TelephonyCallback d = new a();

        /* compiled from: Sta */
        public class a extends TelephonyCallback implements TelephonyCallback.ServiceStateListener, TelephonyCallback.SignalStrengthsListener {
            public a() {
            }

            public void onServiceStateChanged(ServiceState serviceState) {
                b.this.a(ServiceState.class, serviceState);
            }

            public void onSignalStrengthsChanged(SignalStrength signalStrength) {
                k8.this.a(signalStrength);
                b.this.a(SignalStrength.class, signalStrength);
            }
        }

        public b(TelephonyManager telephonyManager, Class<?> cls) {
            super(telephonyManager, cls);
        }

        public void a() {
            this.a.registerTelephonyCallback(k8.this.b, this.d);
        }

        public void b() {
            this.a.unregisterTelephonyCallback(this.d);
        }
    }

    /* compiled from: Sta */
    public abstract class c {
        public final TelephonyManager a;
        public final Class<?> b;

        public c(TelephonyManager telephonyManager, Class<?> cls) {
            this.a = telephonyManager;
            this.b = cls;
        }

        public abstract void a();

        public <T> void a(Class<T> cls, T t) {
            k8 k8Var = k8.this;
            k8Var.getClass();
            try {
                TelephonyMetadata a2 = k8Var.a();
                if (a2 != null) {
                    if (t != null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        String simpleName = cls.getSimpleName();
                        if (a2.a(simpleName).c()) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put(CampaignEx.JSON_KEY_TIMESTAMP, currentTimeMillis);
                            jSONObject.put("type", simpleName);
                            jSONObject.put("data", t.toString());
                            String b2 = k9.b(jSONObject.toString());
                            e.a a3 = k8Var.c.edit();
                            a3.a(simpleName, b2);
                            a3.a.putString(simpleName, b2);
                            a3.apply();
                        }
                    }
                }
            } catch (Throwable th) {
                if (k8Var.a(2)) {
                    i3.a(th);
                }
            }
            if (cls.equals(this.b)) {
                try {
                    b();
                } catch (Throwable th2) {
                    if (k8.this.a(16)) {
                        i3.a(th2);
                    }
                }
            }
        }

        public abstract void b();
    }

    /* compiled from: Sta */
    public class d extends c {
        public final PhoneStateListener d = new a();

        /* compiled from: Sta */
        public class a extends PhoneStateListener {
            public a() {
            }

            public void onServiceStateChanged(ServiceState serviceState) {
                d.this.a(ServiceState.class, serviceState);
            }

            public void onSignalStrengthsChanged(SignalStrength signalStrength) {
                k8.this.a(signalStrength);
                d.this.a(SignalStrength.class, signalStrength);
            }
        }

        public d(TelephonyManager telephonyManager, Class<?> cls) {
            super(telephonyManager, cls);
        }

        public void a() {
            this.a.listen(this.d, 257);
        }

        public void b() {
            this.a.listen(this.d, 0);
        }
    }

    public k8(Context context, v2 v2Var, e eVar, u1 u1Var, i2<TelephonyMetadata> i2Var) {
        this.a = context;
        this.b = v2Var;
        this.c = eVar;
        this.d = u1Var;
        this.e = i2Var;
    }

    public final c a(Class<?> cls) {
        TelephonyManager telephonyManager = (TelephonyManager) this.a.getSystemService("phone");
        if (telephonyManager == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT < 31) {
            return new d(telephonyManager, cls);
        }
        return new b(telephonyManager, cls);
    }

    public void b() {
        this.b.execute(new a());
    }

    public final TelephonyMetadata a() {
        TelephonyMetadata a2;
        if (!this.d.c() || (a2 = this.e.a()) == null || !a2.c()) {
            return null;
        }
        return a2;
    }

    public boolean a(int i) {
        TelephonyMetadata a2 = a();
        if (a2 == null || this.g >= a2.b() || (a2.a() & i) != i) {
            return false;
        }
        return true;
    }

    public void a(SignalStrength signalStrength) {
        if (signalStrength != null) {
            try {
                if (Build.VERSION.SDK_INT >= 23) {
                    this.h = String.valueOf(signalStrength.getLevel());
                } else {
                    this.h = String.valueOf(SignalStrength.class.getMethod("getLevel", new Class[0]).invoke(signalStrength, new Object[0]));
                }
            } catch (NoSuchMethodException unused) {
                this.h = "e104";
            } catch (Throwable unused2) {
                this.h = "e105";
            }
        }
    }

    public Map<String, String> a(j3 j3Var) {
        List<String> a2;
        TelephonyMetadata a3 = a();
        if (a3 == null) {
            return Collections.emptyMap();
        }
        HashMap hashMap = null;
        for (Map.Entry next : this.c.getAll().entrySet()) {
            Object value = next.getValue();
            if (value instanceof String) {
                String str = (String) next.getKey();
                TelephonyDataConfig a4 = a3.a(str);
                if (a4.c() && (a2 = a4.a()) != null && a2.contains(j3Var.a)) {
                    String b2 = a4.b();
                    if (b2 != null) {
                        str = b2;
                    }
                    if (hashMap == null) {
                        hashMap = new HashMap();
                    }
                    hashMap.put(str, (String) value);
                }
            }
        }
        return hashMap == null ? Collections.emptyMap() : hashMap;
    }
}

package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.StrictMode;
import androidx.collection.ArrayMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.1 */
public final class zzib implements zzhj {
    private static final Map zza = new ArrayMap();
    private final SharedPreferences zzb;
    private final SharedPreferences.OnSharedPreferenceChangeListener zzc;

    static zzib zza(Context context, String str, Runnable runnable) {
        zzib zzib;
        if (!zzha.zzb()) {
            synchronized (zzib.class) {
                zzib = (zzib) zza.get((Object) null);
                if (zzib == null) {
                    StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                    try {
                        throw null;
                    } catch (Throwable th) {
                        StrictMode.setThreadPolicy(allowThreadDiskReads);
                        throw th;
                    }
                }
            }
            return zzib;
        }
        throw null;
    }

    static synchronized void zzc() {
        synchronized (zzib.class) {
            Map map = zza;
            Iterator it = map.values().iterator();
            if (!it.hasNext()) {
                map.clear();
            } else {
                zzib zzib = (zzib) it.next();
                SharedPreferences sharedPreferences = zzib.zzb;
                SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener = zzib.zzc;
                throw null;
            }
        }
    }

    public final Object zzb(String str) {
        throw null;
    }
}

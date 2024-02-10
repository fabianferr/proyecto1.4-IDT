package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzaaf extends zzaac {
    static final Map zzb;
    private final Constructor zzc;
    private final Object[] zzd;
    private final Map zze = new HashMap();

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(Byte.TYPE, (byte) 0);
        hashMap.put(Short.TYPE, (short) 0);
        hashMap.put(Integer.TYPE, 0);
        hashMap.put(Long.TYPE, 0L);
        hashMap.put(Float.TYPE, Float.valueOf(0.0f));
        hashMap.put(Double.TYPE, Double.valueOf(0.0d));
        hashMap.put(Character.TYPE, 0);
        hashMap.put(Boolean.TYPE, false);
        zzb = hashMap;
    }

    zzaaf(Class cls, Map map, boolean z) {
        super(map);
        Constructor zzf = zzacg.zzf(cls);
        this.zzc = zzf;
        if (z) {
            zzaag.zzb((Object) null, zzf);
        } else {
            zzacg.zzh(zzf);
        }
        String[] zzj = zzacg.zzj(cls);
        for (int i = 0; i < zzj.length; i++) {
            this.zze.put(zzj[i], Integer.valueOf(i));
        }
        Class[] parameterTypes = this.zzc.getParameterTypes();
        this.zzd = new Object[parameterTypes.length];
        for (int i2 = 0; i2 < parameterTypes.length; i2++) {
            this.zzd[i2] = zzb.get(parameterTypes[i2]);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ Object zza() {
        return (Object[]) this.zzd.clone();
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ void zzc(Object obj, zzacv zzacv, zzaad zzaad) throws IllegalAccessException, IOException {
        Object[] objArr = (Object[]) obj;
        Integer num = (Integer) this.zze.get(zzaad.zzk);
        if (num != null) {
            zzaad.zza(zzacv, num.intValue(), objArr);
            return;
        }
        String zzc2 = zzacg.zzc(this.zzc);
        String str = zzaad.zzk;
        throw new IllegalStateException("Could not find the index in the constructor '" + zzc2 + "' for field with name '" + str + "', unable to determine which argument in the constructor the field corresponds to. This is unexpected behavior, as we expect the RecordComponents to have the same names as the fields in the Java class, and that the order of the RecordComponents is the same as the order of the canonical constructor parameters.");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: zzd */
    public final Object zzb(Object[] objArr) {
        try {
            return this.zzc.newInstance(objArr);
        } catch (IllegalAccessException e) {
            throw zzacg.zzb(e);
        } catch (IllegalArgumentException | InstantiationException e2) {
            String zzc2 = zzacg.zzc(this.zzc);
            String arrays = Arrays.toString(objArr);
            throw new RuntimeException("Failed to invoke constructor '" + zzc2 + "' with args " + arrays, e2);
        } catch (InvocationTargetException e3) {
            String zzc3 = zzacg.zzc(this.zzc);
            String arrays2 = Arrays.toString(objArr);
            throw new RuntimeException("Failed to invoke constructor '" + zzc3 + "' with args " + arrays2, e3.getCause());
        }
    }
}

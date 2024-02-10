package com.google.android.gms.flags;

import android.os.RemoteException;

@Deprecated
/* compiled from: com.google.android.gms:play-services-flags@@17.0.1 */
public abstract class Flag<T> {
    private final int zza;
    private final String zzb;
    private final T zzc;

    @Deprecated
    /* compiled from: com.google.android.gms:play-services-flags@@17.0.1 */
    public static class BooleanFlag extends Flag<Boolean> {
        public BooleanFlag(int i, String str, Boolean bool) {
            super(i, str, bool, (zza) null);
        }

        public final /* bridge */ /* synthetic */ Object zza(zze zze) {
            try {
                return Boolean.valueOf(zze.getBooleanFlagValue(zzd(), ((Boolean) zzc()).booleanValue(), zzb()));
            } catch (RemoteException unused) {
                return (Boolean) zzc();
            }
        }
    }

    @Deprecated
    /* compiled from: com.google.android.gms:play-services-flags@@17.0.1 */
    public static class IntegerFlag extends Flag<Integer> {
        public IntegerFlag(int i, String str, Integer num) {
            super(i, str, num, (zza) null);
        }

        public final /* bridge */ /* synthetic */ Object zza(zze zze) {
            try {
                return Integer.valueOf(zze.getIntFlagValue(zzd(), ((Integer) zzc()).intValue(), zzb()));
            } catch (RemoteException unused) {
                return (Integer) zzc();
            }
        }
    }

    @Deprecated
    /* compiled from: com.google.android.gms:play-services-flags@@17.0.1 */
    public static class LongFlag extends Flag<Long> {
        public LongFlag(int i, String str, Long l) {
            super(i, str, l, (zza) null);
        }

        public final /* bridge */ /* synthetic */ Object zza(zze zze) {
            try {
                return Long.valueOf(zze.getLongFlagValue(zzd(), ((Long) zzc()).longValue(), zzb()));
            } catch (RemoteException unused) {
                return (Long) zzc();
            }
        }
    }

    @Deprecated
    /* compiled from: com.google.android.gms:play-services-flags@@17.0.1 */
    public static class StringFlag extends Flag<String> {
        public StringFlag(int i, String str, String str2) {
            super(i, str, str2, (zza) null);
        }

        public final /* bridge */ /* synthetic */ Object zza(zze zze) {
            try {
                return zze.getStringFlagValue(zzd(), (String) zzc(), zzb());
            } catch (RemoteException unused) {
                return (String) zzc();
            }
        }
    }

    /* synthetic */ Flag(int i, String str, Object obj, zza zza2) {
        this.zza = i;
        this.zzb = str;
        this.zzc = obj;
        Singletons.flagRegistry().zza(this);
    }

    @Deprecated
    public static IntegerFlag define(int i, String str, int i2) {
        return new IntegerFlag(i, str, Integer.valueOf(i2));
    }

    public T get() {
        return Singletons.zza().zza(this);
    }

    /* access modifiers changed from: protected */
    public abstract T zza(zze zze);

    @Deprecated
    public final int zzb() {
        return this.zza;
    }

    public final T zzc() {
        return this.zzc;
    }

    public final String zzd() {
        return this.zzb;
    }

    @Deprecated
    public static LongFlag define(int i, String str, long j) {
        return new LongFlag(i, str, Long.valueOf(j));
    }

    @Deprecated
    public static BooleanFlag define(int i, String str, Boolean bool) {
        return new BooleanFlag(i, str, bool);
    }

    @Deprecated
    public static StringFlag define(int i, String str, String str2) {
        return new StringFlag(i, str, str2);
    }
}

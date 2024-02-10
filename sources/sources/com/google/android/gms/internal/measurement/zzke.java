package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzka;
import com.google.android.gms.internal.measurement.zzke;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.1.1 */
public abstract class zzke<MessageType extends zzke<MessageType, BuilderType>, BuilderType extends zzka<MessageType, BuilderType>> extends zzin<MessageType, BuilderType> {
    private static final Map zza = new ConcurrentHashMap();
    protected zzmo zzc = zzmo.zzc();
    protected int zzd = -1;

    protected static zzkj zzbA() {
        return zzkf.zzf();
    }

    protected static zzkk zzbB() {
        return zzla.zzf();
    }

    protected static zzkk zzbC(zzkk zzkk) {
        int size = zzkk.size();
        return zzkk.zze(size == 0 ? 10 : size + size);
    }

    protected static zzkl zzbD() {
        return zzlu.zze();
    }

    protected static zzkl zzbE(zzkl zzkl) {
        int size = zzkl.size();
        return zzkl.zzd(size == 0 ? 10 : size + size);
    }

    static Object zzbH(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
        }
    }

    protected static Object zzbI(zzll zzll, String str, Object[] objArr) {
        return new zzlv(zzll, str, objArr);
    }

    protected static void zzbJ(Class cls, zzke zzke) {
        zza.put(cls, zzke);
    }

    static zzke zzbz(Class cls) {
        Map map = zza;
        zzke zzke = (zzke) map.get(cls);
        if (zzke == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzke = (zzke) map.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (zzke == null) {
            zzke = (zzke) ((zzke) zzmx.zze(cls)).zzl(6, (Object) null, (Object) null);
            if (zzke != null) {
                map.put(cls, zzke);
            } else {
                throw new IllegalStateException();
            }
        }
        return zzke;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return zzlt.zza().zzb(getClass()).zzj(this, (zzke) obj);
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zzb;
        if (i != 0) {
            return i;
        }
        int zzb = zzlt.zza().zzb(getClass()).zzb(this);
        this.zzb = zzb;
        return zzb;
    }

    public final String toString() {
        return zzln.zza(this, super.toString());
    }

    public final /* synthetic */ zzlk zzbF() {
        return (zzka) zzl(5, (Object) null, (Object) null);
    }

    public final /* synthetic */ zzlk zzbG() {
        zzka zzka = (zzka) zzl(5, (Object) null, (Object) null);
        zzka.zzaC(this);
        return zzka;
    }

    public final void zzbK(zzjl zzjl) throws IOException {
        zzlt.zza().zzb(getClass()).zzi(this, zzjm.zza(zzjl));
    }

    public final /* synthetic */ zzll zzbO() {
        return (zzke) zzl(6, (Object) null, (Object) null);
    }

    /* access modifiers changed from: package-private */
    public final int zzbr() {
        return this.zzd;
    }

    /* access modifiers changed from: package-private */
    public final void zzbu(int i) {
        this.zzd = i;
    }

    public final int zzbw() {
        int i = this.zzd;
        if (i != -1) {
            return i;
        }
        int zza2 = zzlt.zza().zzb(getClass()).zza(this);
        this.zzd = zza2;
        return zza2;
    }

    /* access modifiers changed from: protected */
    public final zzka zzbx() {
        return (zzka) zzl(5, (Object) null, (Object) null);
    }

    public final zzka zzby() {
        zzka zzka = (zzka) zzl(5, (Object) null, (Object) null);
        zzka.zzaC(this);
        return zzka;
    }

    /* access modifiers changed from: protected */
    public abstract Object zzl(int i, Object obj, Object obj2);
}

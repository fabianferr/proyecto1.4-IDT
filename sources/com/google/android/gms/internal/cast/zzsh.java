package com.google.android.gms.internal.cast;

import com.google.android.gms.internal.cast.zzse;
import com.google.android.gms.internal.cast.zzsh;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
public abstract class zzsh<MessageType extends zzsh<MessageType, BuilderType>, BuilderType extends zzse<MessageType, BuilderType>> extends zzqz<MessageType, BuilderType> {
    private static final Map zzb = new ConcurrentHashMap();
    protected zzus zzc = zzus.zzc();
    private int zzd = -1;

    protected static zzsp zzA(zzsp zzsp) {
        int size = zzsp.size();
        return zzsp.zzg(size == 0 ? 10 : size + size);
    }

    static Object zzC(Method method, Object obj, Object... objArr) {
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

    protected static Object zzD(zztp zztp, String str, Object[] objArr) {
        return new zztz(zztp, str, objArr);
    }

    protected static void zzG(Class cls, zzsh zzsh) {
        zzsh.zzF();
        zzb.put(cls, zzsh);
    }

    private final int zza(zzua zzua) {
        if (zzua != null) {
            return zzua.zza(this);
        }
        return zztx.zza().zzb(getClass()).zza(this);
    }

    static zzsh zzv(Class cls) {
        Map map = zzb;
        zzsh zzsh = (zzsh) map.get(cls);
        if (zzsh == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzsh = (zzsh) map.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (zzsh == null) {
            zzsh = (zzsh) ((zzsh) zzvb.zze(cls)).zzb(6, (Object) null, (Object) null);
            if (zzsh != null) {
                map.put(cls, zzsh);
            } else {
                throw new IllegalStateException();
            }
        }
        return zzsh;
    }

    protected static zzsm zzx() {
        return zzsi.zze();
    }

    protected static zzso zzy() {
        return zzte.zze();
    }

    protected static zzsp zzz() {
        return zzty.zzd();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return zztx.zza().zzb(getClass()).zzg(this, (zzsh) obj);
    }

    public final int hashCode() {
        if (zzJ()) {
            return zzr();
        }
        int i = this.zza;
        if (i != 0) {
            return i;
        }
        int zzr = zzr();
        this.zza = zzr;
        return zzr;
    }

    public final String toString() {
        return zztr.zza(this, super.toString());
    }

    public final /* synthetic */ zzto zzB() {
        return (zzse) zzb(5, (Object) null, (Object) null);
    }

    /* access modifiers changed from: protected */
    public final void zzE() {
        zztx.zza().zzb(getClass()).zzd(this);
        zzF();
    }

    /* access modifiers changed from: package-private */
    public final void zzF() {
        this.zzd &= Integer.MAX_VALUE;
    }

    /* access modifiers changed from: package-private */
    public final void zzH(int i) {
        this.zzd = (this.zzd & Integer.MIN_VALUE) | Integer.MAX_VALUE;
    }

    public final void zzI(zzru zzru) throws IOException {
        zztx.zza().zzb(getClass()).zzf(this, zzrv.zza(zzru));
    }

    /* access modifiers changed from: package-private */
    public final boolean zzJ() {
        return (this.zzd & Integer.MIN_VALUE) != 0;
    }

    /* access modifiers changed from: protected */
    public abstract Object zzb(int i, Object obj, Object obj2);

    /* access modifiers changed from: package-private */
    public final int zzr() {
        return zztx.zza().zzb(getClass()).zzb(this);
    }

    public final /* synthetic */ zztp zzs() {
        return (zzsh) zzb(6, (Object) null, (Object) null);
    }

    /* access modifiers changed from: protected */
    public final zzse zzu() {
        return (zzse) zzb(5, (Object) null, (Object) null);
    }

    /* access modifiers changed from: package-private */
    public final zzsh zzw() {
        return (zzsh) zzb(4, (Object) null, (Object) null);
    }

    /* access modifiers changed from: package-private */
    public final int zzp(zzua zzua) {
        if (zzJ()) {
            int zza = zza(zzua);
            if (zza >= 0) {
                return zza;
            }
            throw new IllegalStateException("serialized size must be non-negative, was " + zza);
        }
        int i = this.zzd & Integer.MAX_VALUE;
        if (i != Integer.MAX_VALUE) {
            return i;
        }
        int zza2 = zza(zzua);
        if (zza2 >= 0) {
            this.zzd = (this.zzd & Integer.MIN_VALUE) | zza2;
            return zza2;
        }
        throw new IllegalStateException("serialized size must be non-negative, was " + zza2);
    }

    public final int zzt() {
        int i;
        if (zzJ()) {
            i = zza((zzua) null);
            if (i < 0) {
                throw new IllegalStateException("serialized size must be non-negative, was " + i);
            }
        } else {
            i = this.zzd & Integer.MAX_VALUE;
            if (i == Integer.MAX_VALUE) {
                i = zza((zzua) null);
                if (i >= 0) {
                    this.zzd = (this.zzd & Integer.MIN_VALUE) | i;
                } else {
                    throw new IllegalStateException("serialized size must be non-negative, was " + i);
                }
            }
        }
        return i;
    }
}

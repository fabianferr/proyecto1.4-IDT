package com.google.ads.interactivemedia.v3.internal;

import com.google.ads.interactivemedia.v3.internal.zzaep;
import com.google.ads.interactivemedia.v3.internal.zzaet;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public abstract class zzaet<MessageType extends zzaet<MessageType, BuilderType>, BuilderType extends zzaep<MessageType, BuilderType>> extends zzadb<MessageType, BuilderType> {
    private static final Map zzb = new ConcurrentHashMap();
    protected zzahk zzc = zzahk.zzc();
    private int zzd = -1;

    private final int zza(zzags zzags) {
        if (zzags != null) {
            return zzags.zza(this);
        }
        return zzagh.zza().zzb(getClass()).zza(this);
    }

    protected static zzaet zzaB(zzaet zzaet, zzadr zzadr) throws zzafc {
        zzaef zzaef = zzaef.zza;
        zzadv zzl = zzadr.zzl();
        zzaet zzaA = zzaet.zzaA();
        try {
            zzags zzb2 = zzagh.zza().zzb(zzaA.getClass());
            zzb2.zzh(zzaA, zzadw.zzq(zzl), zzaef);
            zzb2.zzf(zzaA);
            try {
                zzl.zzm(0);
                zzb(zzaA);
                zzb(zzaA);
                return zzaA;
            } catch (zzafc e) {
                e.zzh(zzaA);
                throw e;
            }
        } catch (zzafc e2) {
            e2.zzh(zzaA);
            throw e2;
        } catch (zzahi e3) {
            zzafc zza = e3.zza();
            zza.zzh(zzaA);
            throw zza;
        } catch (IOException e4) {
            if (e4.getCause() instanceof zzafc) {
                throw ((zzafc) e4.getCause());
            }
            zzafc zzafc = new zzafc(e4);
            zzafc.zzh(zzaA);
            throw zzafc;
        } catch (RuntimeException e5) {
            if (e5.getCause() instanceof zzafc) {
                throw ((zzafc) e5.getCause());
            }
            throw e5;
        }
    }

    protected static zzaet zzaC(zzaet zzaet, zzadr zzadr, zzaef zzaef) throws zzafc {
        zzadv zzl = zzadr.zzl();
        zzaet zzaA = zzaet.zzaA();
        try {
            zzags zzb2 = zzagh.zza().zzb(zzaA.getClass());
            zzb2.zzh(zzaA, zzadw.zzq(zzl), zzaef);
            zzb2.zzf(zzaA);
            try {
                zzl.zzm(0);
                zzb(zzaA);
                return zzaA;
            } catch (zzafc e) {
                e.zzh(zzaA);
                throw e;
            }
        } catch (zzafc e2) {
            e2.zzh(zzaA);
            throw e2;
        } catch (zzahi e3) {
            zzafc zza = e3.zza();
            zza.zzh(zzaA);
            throw zza;
        } catch (IOException e4) {
            if (e4.getCause() instanceof zzafc) {
                throw ((zzafc) e4.getCause());
            }
            zzafc zzafc = new zzafc(e4);
            zzafc.zzh(zzaA);
            throw zzafc;
        } catch (RuntimeException e5) {
            if (e5.getCause() instanceof zzafc) {
                throw ((zzafc) e5.getCause());
            }
            throw e5;
        }
    }

    protected static zzaet zzaD(zzaet zzaet, byte[] bArr, zzaef zzaef) throws zzafc {
        zzaet zzc2 = zzc(zzaet, bArr, 0, bArr.length, zzaef);
        zzb(zzc2);
        return zzc2;
    }

    protected static zzaey zzaE() {
        return zzaeu.zzf();
    }

    protected static zzaez zzaF() {
        return zzagi.zze();
    }

    protected static zzaez zzaG(zzaez zzaez) {
        int size = zzaez.size();
        return zzaez.zzd(size == 0 ? 10 : size + size);
    }

    static Object zzaI(Method method, Object obj, Object... objArr) {
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

    protected static Object zzaJ(zzafz zzafz, String str, Object[] objArr) {
        return new zzagj(zzafz, str, objArr);
    }

    protected static void zzaM(Class cls, zzaet zzaet) {
        zzaet.zzaL();
        zzb.put(cls, zzaet);
    }

    static zzaet zzaz(Class cls) {
        Map map = zzb;
        zzaet zzaet = (zzaet) map.get(cls);
        if (zzaet == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzaet = (zzaet) map.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (zzaet == null) {
            zzaet = (zzaet) ((zzaet) zzaht.zze(cls)).zzj(6, (Object) null, (Object) null);
            if (zzaet != null) {
                map.put(cls, zzaet);
            } else {
                throw new IllegalStateException();
            }
        }
        return zzaet;
    }

    private static zzaet zzb(zzaet zzaet) throws zzafc {
        if (zzaet == null || zzaet.zzaP()) {
            return zzaet;
        }
        zzafc zza = new zzahi(zzaet).zza();
        zza.zzh(zzaet);
        throw zza;
    }

    private static zzaet zzc(zzaet zzaet, byte[] bArr, int i, int i2, zzaef zzaef) throws zzafc {
        zzaet zzaA = zzaet.zzaA();
        try {
            zzags zzb2 = zzagh.zza().zzb(zzaA.getClass());
            zzb2.zzi(zzaA, bArr, 0, i2, new zzade(zzaef));
            zzb2.zzf(zzaA);
            return zzaA;
        } catch (zzafc e) {
            e.zzh(zzaA);
            throw e;
        } catch (zzahi e2) {
            zzafc zza = e2.zza();
            zza.zzh(zzaA);
            throw zza;
        } catch (IOException e3) {
            if (e3.getCause() instanceof zzafc) {
                throw ((zzafc) e3.getCause());
            }
            zzafc zzafc = new zzafc(e3);
            zzafc.zzh(zzaA);
            throw zzafc;
        } catch (IndexOutOfBoundsException unused) {
            zzafc zzi = zzafc.zzi();
            zzi.zzh(zzaA);
            throw zzi;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return zzagh.zza().zzb(getClass()).zzk(this, (zzaet) obj);
    }

    public final int hashCode() {
        if (zzaQ()) {
            return zzaw();
        }
        int i = this.zza;
        if (i != 0) {
            return i;
        }
        int zzaw = zzaw();
        this.zza = zzaw;
        return zzaw;
    }

    public final String toString() {
        return zzagb.zza(this, super.toString());
    }

    /* access modifiers changed from: package-private */
    public final zzaet zzaA() {
        return (zzaet) zzj(4, (Object) null, (Object) null);
    }

    public final /* synthetic */ zzafy zzaH() {
        return (zzaep) zzj(5, (Object) null, (Object) null);
    }

    /* access modifiers changed from: protected */
    public final void zzaK() {
        zzagh.zza().zzb(getClass()).zzf(this);
        zzaL();
    }

    /* access modifiers changed from: package-private */
    public final void zzaL() {
        this.zzd &= Integer.MAX_VALUE;
    }

    /* access modifiers changed from: package-private */
    public final void zzaN(int i) {
        this.zzd = (this.zzd & Integer.MIN_VALUE) | Integer.MAX_VALUE;
    }

    public final void zzaO(zzaea zzaea) throws IOException {
        zzagh.zza().zzb(getClass()).zzj(this, zzaeb.zza(zzaea));
    }

    public final boolean zzaP() {
        Boolean bool = Boolean.TRUE;
        byte byteValue = ((Byte) zzj(1, (Object) null, (Object) null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzl = zzagh.zza().zzb(getClass()).zzl(this);
        zzj(2, true != zzl ? null : this, (Object) null);
        return zzl;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzaQ() {
        return (this.zzd & Integer.MIN_VALUE) != 0;
    }

    public final /* synthetic */ zzafz zzaR() {
        return (zzaet) zzj(6, (Object) null, (Object) null);
    }

    /* access modifiers changed from: package-private */
    public final int zzaw() {
        return zzagh.zza().zzb(getClass()).zzb(this);
    }

    /* access modifiers changed from: protected */
    public final zzaep zzay() {
        return (zzaep) zzj(5, (Object) null, (Object) null);
    }

    /* access modifiers changed from: protected */
    public abstract Object zzj(int i, Object obj, Object obj2);

    /* access modifiers changed from: package-private */
    public final int zzat(zzags zzags) {
        if (zzaQ()) {
            int zza = zza(zzags);
            if (zza >= 0) {
                return zza;
            }
            throw new IllegalStateException("serialized size must be non-negative, was " + zza);
        }
        int i = this.zzd & Integer.MAX_VALUE;
        if (i != Integer.MAX_VALUE) {
            return i;
        }
        int zza2 = zza(zzags);
        if (zza2 >= 0) {
            this.zzd = (this.zzd & Integer.MIN_VALUE) | zza2;
            return zza2;
        }
        throw new IllegalStateException("serialized size must be non-negative, was " + zza2);
    }

    public final int zzax() {
        int i;
        if (zzaQ()) {
            i = zza((zzags) null);
            if (i < 0) {
                throw new IllegalStateException("serialized size must be non-negative, was " + i);
            }
        } else {
            i = this.zzd & Integer.MAX_VALUE;
            if (i == Integer.MAX_VALUE) {
                i = zza((zzags) null);
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

package com.google.ads.interactivemedia.v3.internal;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public abstract class zzzk {
    public static final zzzk zzc;

    static {
        zzzk zzzk;
        try {
            Class<?> cls = Class.forName("sun.misc.Unsafe");
            Field declaredField = cls.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            zzzk = new zzzg(cls.getMethod("allocateInstance", new Class[]{Class.class}), declaredField.get((Object) null));
        } catch (Exception unused) {
            try {
                Method declaredMethod = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", new Class[]{Class.class});
                declaredMethod.setAccessible(true);
                int intValue = ((Integer) declaredMethod.invoke((Object) null, new Object[]{Object.class})).intValue();
                Method declaredMethod2 = ObjectStreamClass.class.getDeclaredMethod("newInstance", new Class[]{Class.class, Integer.TYPE});
                declaredMethod2.setAccessible(true);
                zzzk = new zzzh(declaredMethod2, intValue);
            } catch (Exception unused2) {
                try {
                    Method declaredMethod3 = ObjectInputStream.class.getDeclaredMethod("newInstance", new Class[]{Class.class, Class.class});
                    declaredMethod3.setAccessible(true);
                    zzzk = new zzzi(declaredMethod3);
                } catch (Exception unused3) {
                    zzzk = new zzzj();
                }
            }
        }
        zzc = zzzk;
    }

    static /* bridge */ /* synthetic */ void zzb(Class cls) {
        String zzb = zzyl.zzb(cls);
        if (zzb != null) {
            throw new AssertionError("UnsafeAllocator is used for non-instantiable type: ".concat(zzb));
        }
    }

    public abstract Object zza(Class cls) throws Exception;
}

package com.google.ads.interactivemedia.v3.internal;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzacg {
    public static final /* synthetic */ int zza = 0;
    private static final zzacb zzb;

    static {
        zzacb zzacb;
        try {
            zzacb = new zzacf((zzace) null);
        } catch (NoSuchMethodException unused) {
            zzacb = new zzacd((zzacc) null);
        }
        zzb = zzacb;
    }

    static /* bridge */ /* synthetic */ RuntimeException zza(ReflectiveOperationException reflectiveOperationException) {
        throw new RuntimeException("Unexpected ReflectiveOperationException occurred (Gson ${project.version}). To support Java records, reflection is utilized to read out information about records. All these invocations happens after it is established that records exist in the JVM. This exception is unexpected behavior.", reflectiveOperationException);
    }

    public static RuntimeException zzb(IllegalAccessException illegalAccessException) {
        throw new RuntimeException("Unexpected IllegalAccessException occurred (Gson ${project.version}). Certain ReflectionAccessFilter features require Java >= 9 to work correctly. If you are not using ReflectionAccessFilter, report this to the Gson maintainers.", illegalAccessException);
    }

    public static String zzc(Constructor constructor) {
        StringBuilder sb = new StringBuilder(constructor.getDeclaringClass().getName());
        zzk(constructor, sb);
        return sb.toString();
    }

    public static String zzd(Field field) {
        String name = field.getDeclaringClass().getName();
        String name2 = field.getName();
        return name + "#" + name2;
    }

    public static String zze(AccessibleObject accessibleObject, boolean z) {
        String str;
        if (accessibleObject instanceof Field) {
            str = "field '" + zzd((Field) accessibleObject) + "'";
        } else if (accessibleObject instanceof Method) {
            Method method = (Method) accessibleObject;
            StringBuilder sb = new StringBuilder(method.getName());
            zzk(method, sb);
            String sb2 = sb.toString();
            str = "method '" + method.getDeclaringClass().getName() + "#" + sb2 + "'";
        } else if (accessibleObject instanceof Constructor) {
            str = "constructor '" + zzc((Constructor) accessibleObject) + "'";
        } else {
            str = "<unknown AccessibleObject> ".concat(String.valueOf(accessibleObject.toString()));
        }
        if (!z || !Character.isLowerCase(str.charAt(0))) {
            return str;
        }
        return Character.toUpperCase(str.charAt(0)) + str.substring(1);
    }

    public static Constructor zzf(Class cls) {
        return zzb.zza(cls);
    }

    public static Method zzg(Class cls, Field field) {
        return zzb.zzb(cls, field);
    }

    public static void zzh(AccessibleObject accessibleObject) throws zzws {
        try {
            accessibleObject.setAccessible(true);
        } catch (Exception e) {
            String zze = zze(accessibleObject, false);
            throw new zzws("Failed making " + zze + " accessible; either increase its visibility or write a custom TypeAdapter for its declaring type.", e);
        }
    }

    public static boolean zzi(Class cls) {
        return zzb.zzc(cls);
    }

    public static String[] zzj(Class cls) {
        return zzb.zzd(cls);
    }

    private static void zzk(AccessibleObject accessibleObject, StringBuilder sb) {
        Class[] clsArr;
        sb.append('(');
        if (accessibleObject instanceof Method) {
            clsArr = ((Method) accessibleObject).getParameterTypes();
        } else {
            clsArr = ((Constructor) accessibleObject).getParameterTypes();
        }
        for (int i = 0; i < clsArr.length; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(clsArr[i].getSimpleName());
        }
        sb.append(')');
    }
}

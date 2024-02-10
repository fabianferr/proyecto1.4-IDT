package com.google.ads.interactivemedia.v3.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import javax.annotation.CheckForNull;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzvi {
    private static final zzth zza = zzth.zzb().zzc(new zzve()).zza();

    static Object zza(zzvf zzvf, Future future, Class cls) throws Exception {
        zzvf.zza(cls);
        try {
            return future.get();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw zzc(cls, e);
        } catch (ExecutionException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof Error) {
                throw new zzut((Error) cause);
            } else if (cause instanceof RuntimeException) {
                throw new zzwa(cause);
            } else {
                throw zzc(cls, cause);
            }
        }
    }

    static void zzb(Class cls) {
        zzrm.zzf(!RuntimeException.class.isAssignableFrom(cls), "Futures.getChecked exception type (%s) must not be a RuntimeException", cls);
        zzrm.zzf(zze(cls), "Futures.getChecked exception type (%s) must be an accessible class with an accessible constructor whose parameters (if any) must be of type String and/or Throwable", cls);
    }

    private static Exception zzc(Class cls, Throwable th) {
        List asList = Arrays.asList(cls.getConstructors());
        zzth zzth = zza;
        if (!(asList instanceof Collection)) {
            Iterator it = asList.iterator();
            ArrayList arrayList = new ArrayList();
            it.getClass();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
            asList = arrayList;
        }
        Object[] array = asList.toArray();
        Arrays.sort(array, zzth);
        List asList2 = Arrays.asList(array);
        asList2.getClass();
        for (Constructor zzd : new ArrayList(asList2)) {
            Exception exc = (Exception) zzd(zzd, th);
            if (exc != null) {
                if (exc.getCause() == null) {
                    exc.initCause(th);
                }
                return exc;
            }
        }
        String obj = cls.toString();
        throw new IllegalArgumentException("No appropriate constructor for exception of type " + obj + " in response to chained exception", th);
    }

    @CheckForNull
    private static Object zzd(Constructor constructor, Throwable th) {
        Class[] parameterTypes = constructor.getParameterTypes();
        Object[] objArr = new Object[parameterTypes.length];
        for (int i = 0; i < parameterTypes.length; i++) {
            Class cls = parameterTypes[i];
            if (cls.equals(String.class)) {
                objArr[i] = th.toString();
            } else if (!cls.equals(Throwable.class)) {
                return null;
            } else {
                objArr[i] = th;
            }
        }
        try {
            return constructor.newInstance(objArr);
        } catch (IllegalAccessException | IllegalArgumentException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    private static boolean zze(Class cls) {
        try {
            zzc(cls, new Exception());
            return true;
        } catch (Error | RuntimeException unused) {
            return false;
        }
    }
}

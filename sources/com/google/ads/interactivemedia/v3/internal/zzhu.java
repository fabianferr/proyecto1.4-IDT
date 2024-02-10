package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import com.facebook.internal.security.CertificateUtil;
import com.google.ads.interactivemedia.v3.api.signals.SecureSignalsAdapter;
import com.google.ads.interactivemedia.v3.impl.data.zzbe;
import com.google.ads.interactivemedia.v3.impl.data.zzbf;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzhu {
    private final List zza = new ArrayList(0);
    private final TaskCompletionSource zzb = new TaskCompletionSource();
    private final TaskCompletionSource zzc = new TaskCompletionSource();
    private final Context zzd;
    private final ExecutorService zze;
    private final zzhc zzf;
    private Integer zzg;

    public zzhu(Context context, ExecutorService executorService, zzhc zzhc) {
        this.zzd = context;
        this.zze = executorService;
        this.zzf = zzhc;
    }

    public static /* synthetic */ Task zza(zzhu zzhu, Task task) {
        List list = (List) task.getResult();
        return Tasks.whenAllComplete((Collection<? extends Task<?>>) list).continueWith(zzhu.zze, new zzhl(list));
    }

    private final void zzi(zzbf zzbf, Exception exc) {
        this.zzf.zzb(zzbe.NATIVE_ESP, zzbf, exc);
    }

    private final void zzj(zzhk zzhk) {
        this.zza.remove(zzhk);
    }

    private static final Exception zzk(zzhk zzhk, Exception exc) {
        String zze2 = zzhk.zze();
        String zzf2 = zzhk.zzf();
        return new Exception("Exception with SecureSignalsAdapter " + zze2 + CertificateUtil.DELIMITER + zzf2, exc);
    }

    public final Task zzb() {
        this.zzb.getTask().continueWith(this.zze, new zzhr(this)).continueWithTask(this.zze, new zzhn(this)).continueWith(this.zze, new zzho(this)).continueWith(this.zze, new zzhs(this));
        return this.zzc.getTask();
    }

    public final Task zzc(List list, Integer num) {
        if (num.intValue() == 0) {
            this.zzb.trySetException(new Exception("No adapters to load"));
            return this.zzb.getTask();
        }
        this.zzg = num;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            zzhk zzhk = null;
            try {
                Class<?> cls = Class.forName(str, false, getClass().getClassLoader());
                Class[] interfaces = cls.getInterfaces();
                String name = SecureSignalsAdapter.class.getName();
                int length = interfaces.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    } else if (interfaces[i].getName().equals(name)) {
                        zzhk = new zzhk((SecureSignalsAdapter) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]), str, this.zzd);
                        break;
                    } else {
                        i++;
                    }
                }
            } catch (Throwable unused) {
            }
            if (zzhk != null) {
                try {
                    this.zza.add(zzhk);
                } catch (Exception e) {
                    zzi(zzbf.LOAD_ADAPTER, new Exception("Exception with SecureSignalsAdapter ".concat(String.valueOf(str)), e));
                }
            }
        }
        this.zzb.trySetResult(this.zza);
        return this.zzb.getTask();
    }

    public final List zze() {
        Task task;
        try {
            Task continueWith = this.zzc.getTask().continueWith(this.zze, new zzhm(this)).continueWithTask(this.zze, new zzhn(this)).continueWith(this.zze, new zzho(this));
            Integer num = this.zzg;
            if (num == null) {
                task = Tasks.forResult(new ArrayList());
            } else {
                task = Tasks.withTimeout(continueWith, (long) num.intValue(), TimeUnit.MILLISECONDS).addOnFailureListener(new zzhp(this));
            }
            return (List) Tasks.await(task);
        } catch (InterruptedException | ExecutionException unused) {
            return new ArrayList();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzf(Exception exc) {
        zzi(zzbf.COLLECT_SIGNALS, exc);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzg(zzhk zzhk, Exception exc) {
        zzj(zzhk);
        zzi(zzbf.COLLECT_SIGNALS, zzk(zzhk, exc));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzh(zzhk zzhk, Exception exc) {
        zzj(zzhk);
        zzi(zzbf.INIT, zzk(zzhk, exc));
    }
}

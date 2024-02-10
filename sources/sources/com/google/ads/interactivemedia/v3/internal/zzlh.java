package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.exifinterface.media.ExifInterface;
import java.io.ByteArrayInputStream;
import java.lang.reflect.InvocationTargetException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzlh extends zzmh {
    private static final zzmi zzi = new zzmi();
    private final Context zzj;

    public zzlh(zzkt zzkt, String str, String str2, zzaf zzaf, int i, int i2, Context context, zzy zzy) {
        super(zzkt, "V4y6sZwh4RdVNxpWxdt5cB3zHM/o72UxaS3FR8ryJ97Kzv92GLUKmmmoeiIEn2h0", "jF9g1ur6WV7u99T9DTRuiTzvsmxG0ZkqXVny5oCesvg=", zzaf, i, 27);
        this.zzj = context;
    }

    private final String zzc() {
        try {
            if (this.zzb.zzl() != null) {
                this.zzb.zzl().get();
            }
            zzbc zzc = this.zzb.zzc();
            if (zzc == null || !zzc.zzaj()) {
                return null;
            }
            return zzc.zzg();
        } catch (InterruptedException | ExecutionException unused) {
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        zzib zzib;
        int i;
        Boolean bool;
        AtomicReference zza = zzi.zza(this.zzj.getPackageName());
        synchronized (zza) {
            zzib zzib2 = (zzib) zza.get();
            if (zzib2 == null || zzkw.zzd(zzib2.zza) || zzib2.zza.equals(ExifInterface.LONGITUDE_EAST) || zzib2.zza.equals("0000000000000000000000000000000000000000000000000000000000000000")) {
                if (!zzkw.zzd((String) null)) {
                    i = 5;
                } else {
                    if (!zzkw.zzd((String) null)) {
                        bool = false;
                    } else {
                        bool = false;
                    }
                    bool.booleanValue();
                    i = 3;
                }
                Boolean valueOf = Boolean.valueOf(i == 3);
                Boolean bool2 = (Boolean) zznc.zzc().zzb(zznr.zzcd);
                String zzb = ((Boolean) zznc.zzc().zzb(zznr.zzcc)).booleanValue() ? zzb() : null;
                if (bool2.booleanValue() && this.zzb.zzp() && zzkw.zzd(zzb)) {
                    zzb = zzc();
                }
                zzib zzib3 = new zzib((String) this.zzf.invoke((Object) null, new Object[]{this.zzj, valueOf, zzb}));
                if (zzkw.zzd(zzib3.zza) || zzib3.zza.equals(ExifInterface.LONGITUDE_EAST)) {
                    int i2 = i - 1;
                    if (i2 == 3) {
                        String zzc = zzc();
                        if (!zzkw.zzd(zzc)) {
                            zzib3.zza = zzc;
                        }
                    } else if (i2 == 4) {
                        throw null;
                    }
                }
                zza.set(zzib3);
            }
            zzib = (zzib) zza.get();
        }
        synchronized (this.zze) {
            if (zzib != null) {
                this.zze.zzx(zzib.zza);
                this.zze.zzX(zzib.zzb);
                this.zze.zzZ(zzib.zzc);
                this.zze.zzi(zzib.zzd);
                this.zze.zzw(zzib.zze);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final String zzb() {
        try {
            CertificateFactory instance = CertificateFactory.getInstance("X.509");
            byte[] zzf = zzkw.zzf((String) zznc.zzc().zzb(zznr.zzce));
            ArrayList arrayList = new ArrayList();
            arrayList.add(instance.generateCertificate(new ByteArrayInputStream(zzf)));
            if (!Build.TYPE.equals("user")) {
                arrayList.add(instance.generateCertificate(new ByteArrayInputStream(zzkw.zzf((String) zznc.zzc().zzb(zznr.zzcf)))));
            }
            Context context = this.zzj;
            String packageName = context.getPackageName();
            this.zzb.zzk();
            if (Build.VERSION.SDK_INT <= 30 && !Build.VERSION.CODENAME.equals(ExifInterface.LATITUDE_SOUTH)) {
                return null;
            }
            zzvx zzp = zzvx.zzp();
            context.getPackageManager().requestChecksums(packageName, false, 8, arrayList, new zzmj(zzp));
            return (String) zzp.get();
        } catch (PackageManager.NameNotFoundException | InterruptedException | NoClassDefFoundError | CertificateEncodingException | CertificateException | ExecutionException unused) {
            return null;
        }
    }
}

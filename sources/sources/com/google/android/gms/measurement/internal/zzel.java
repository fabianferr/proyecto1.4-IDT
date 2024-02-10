package com.google.android.gms.measurement.internal;

import android.util.Log;
import com.facebook.internal.security.CertificateUtil;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.1 */
final class zzel implements Runnable {
    final /* synthetic */ int zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ Object zzc;
    final /* synthetic */ Object zzd;
    final /* synthetic */ Object zze;
    final /* synthetic */ zzeo zzf;

    zzel(zzeo zzeo, int i, String str, Object obj, Object obj2, Object obj3) {
        this.zzf = zzeo;
        this.zza = i;
        this.zzb = str;
        this.zzc = obj;
        this.zzd = obj2;
        this.zze = obj3;
    }

    public final void run() {
        zzfd zzm = this.zzf.zzs.zzm();
        if (zzm.zzx()) {
            zzeo zzeo = this.zzf;
            if (zzeo.zza == 0) {
                if (zzeo.zzs.zzf().zzy()) {
                    zzeo zzeo2 = this.zzf;
                    zzeo2.zzs.zzaw();
                    zzeo2.zza = 'C';
                } else {
                    zzeo zzeo3 = this.zzf;
                    zzeo3.zzs.zzaw();
                    zzeo3.zza = 'c';
                }
            }
            zzeo zzeo4 = this.zzf;
            if (zzeo4.zzb < 0) {
                zzeo4.zzs.zzf().zzh();
                zzeo4.zzb = 73000;
            }
            char charAt = "01VDIWEA?".charAt(this.zza);
            zzeo zzeo5 = this.zzf;
            String str = "2" + charAt + zzeo5.zza + zzeo5.zzb + CertificateUtil.DELIMITER + zzeo.zzo(true, this.zzb, this.zzc, this.zzd, this.zze);
            if (str.length() > 1024) {
                str = this.zzb.substring(0, 1024);
            }
            zzfb zzfb = zzm.zzb;
            if (zzfb != null) {
                zzfb.zzb(str, 1);
                return;
            }
            return;
        }
        Log.println(6, this.zzf.zzq(), "Persisted config not initialized. Not logging error/warn");
    }
}

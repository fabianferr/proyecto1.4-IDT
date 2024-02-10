package com.google.android.gms.internal.ads;

import android.util.Log;
import com.facebook.internal.security.CertificateUtil;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgwv extends zzgxa {
    final String zza;

    public zzgwv(String str) {
        this.zza = str;
    }

    public final void zza(String str) {
        String str2 = this.zza;
        StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 1 + String.valueOf(str).length());
        sb.append(str2);
        sb.append(CertificateUtil.DELIMITER);
        sb.append(str);
        Log.d("isoparser", sb.toString());
    }
}

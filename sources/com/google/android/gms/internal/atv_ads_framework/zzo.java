package com.google.android.gms.internal.atv_ads_framework;

import com.google.firebase.analytics.FirebaseAnalytics;

/* compiled from: com.google.android.tv:tv-ads@@1.0.0-alpha02 */
final class zzo extends zzq {
    final /* synthetic */ zzp zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzo(zzp zzp, zzr zzr, CharSequence charSequence) {
        super(zzr, charSequence);
        this.zza = zzp;
    }

    /* access modifiers changed from: package-private */
    public final int zzc(int i) {
        return i + 1;
    }

    /* access modifiers changed from: package-private */
    public final int zzd(int i) {
        CharSequence charSequence = this.zzb;
        int length = charSequence.length();
        zzn.zzb(i, length, FirebaseAnalytics.Param.INDEX);
        while (i < length) {
            if (charSequence.charAt(i) == ':') {
                return i;
            }
            i++;
        }
        return -1;
    }
}

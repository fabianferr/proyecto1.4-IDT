package com.google.ads.interactivemedia.v3.internal;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import javax.annotation.CheckForNull;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzsm extends zzso {
    private final transient zzso zza;

    zzsm(zzso zzso) {
        this.zza = zzso;
    }

    private final int zzo(int i) {
        return (this.zza.size() - 1) - i;
    }

    public final boolean contains(@CheckForNull Object obj) {
        return this.zza.contains(obj);
    }

    public final Object get(int i) {
        zzrm.zza(i, this.zza.size(), FirebaseAnalytics.Param.INDEX);
        return this.zza.get(zzo(i));
    }

    public final int indexOf(@CheckForNull Object obj) {
        int lastIndexOf = this.zza.lastIndexOf(obj);
        if (lastIndexOf >= 0) {
            return zzo(lastIndexOf);
        }
        return -1;
    }

    public final int lastIndexOf(@CheckForNull Object obj) {
        int indexOf = this.zza.indexOf(obj);
        if (indexOf >= 0) {
            return zzo(indexOf);
        }
        return -1;
    }

    public final int size() {
        return this.zza.size();
    }

    public final /* bridge */ /* synthetic */ List subList(int i, int i2) {
        return subList(i, i2);
    }

    /* access modifiers changed from: package-private */
    public final boolean zzf() {
        return this.zza.zzf();
    }

    public final zzso zzh() {
        return this.zza;
    }

    public final zzso zzi(int i, int i2) {
        zzrm.zzg(i, i2, this.zza.size());
        zzso zzso = this.zza;
        return zzso.subList(zzso.size() - i2, this.zza.size() - i).zzh();
    }
}

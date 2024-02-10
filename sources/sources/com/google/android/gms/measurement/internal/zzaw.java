package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.1 */
public final class zzaw extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaw> CREATOR = new zzax();
    public final String zza;
    public final zzau zzb;
    public final String zzc;
    public final long zzd;

    zzaw(zzaw zzaw, long j) {
        Preconditions.checkNotNull(zzaw);
        this.zza = zzaw.zza;
        this.zzb = zzaw.zzb;
        this.zzc = zzaw.zzc;
        this.zzd = j;
    }

    public final String toString() {
        String str = this.zzc;
        String str2 = this.zza;
        String valueOf = String.valueOf(this.zzb);
        return "origin=" + str + ",name=" + str2 + ",params=" + valueOf;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        zzax.zza(this, parcel, i);
    }

    public zzaw(String str, zzau zzau, String str2, long j) {
        this.zza = str;
        this.zzb = zzau;
        this.zzc = str2;
        this.zzd = j;
    }
}

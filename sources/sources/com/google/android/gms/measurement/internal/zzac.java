package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.1 */
public final class zzac extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzac> CREATOR = new zzad();
    public String zza;
    public String zzb;
    public zzlc zzc;
    public long zzd;
    public boolean zze;
    public String zzf;
    public final zzaw zzg;
    public long zzh;
    public zzaw zzi;
    public final long zzj;
    public final zzaw zzk;

    zzac(zzac zzac) {
        Preconditions.checkNotNull(zzac);
        this.zza = zzac.zza;
        this.zzb = zzac.zzb;
        this.zzc = zzac.zzc;
        this.zzd = zzac.zzd;
        this.zze = zzac.zze;
        this.zzf = zzac.zzf;
        this.zzg = zzac.zzg;
        this.zzh = zzac.zzh;
        this.zzi = zzac.zzi;
        this.zzj = zzac.zzj;
        this.zzk = zzac.zzk;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zza, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzb, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzc, i, false);
        SafeParcelWriter.writeLong(parcel, 5, this.zzd);
        SafeParcelWriter.writeBoolean(parcel, 6, this.zze);
        SafeParcelWriter.writeString(parcel, 7, this.zzf, false);
        SafeParcelWriter.writeParcelable(parcel, 8, this.zzg, i, false);
        SafeParcelWriter.writeLong(parcel, 9, this.zzh);
        SafeParcelWriter.writeParcelable(parcel, 10, this.zzi, i, false);
        SafeParcelWriter.writeLong(parcel, 11, this.zzj);
        SafeParcelWriter.writeParcelable(parcel, 12, this.zzk, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    zzac(String str, String str2, zzlc zzlc, long j, boolean z, String str3, zzaw zzaw, long j2, zzaw zzaw2, long j3, zzaw zzaw3) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzlc;
        this.zzd = j;
        this.zze = z;
        this.zzf = str3;
        this.zzg = zzaw;
        this.zzh = j2;
        this.zzi = zzaw2;
        this.zzj = j3;
        this.zzk = zzaw3;
    }
}

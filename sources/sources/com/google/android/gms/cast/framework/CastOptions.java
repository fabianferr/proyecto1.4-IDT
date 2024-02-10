package com.google.android.gms.cast.framework;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.cast.LaunchOptions;
import com.google.android.gms.cast.framework.media.CastMediaOptions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.cast.zzeq;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
public class CastOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<CastOptions> CREATOR = new zzf();
    private String zza;
    private final List zzb;
    private final boolean zzc;
    private LaunchOptions zzd;
    private final boolean zze;
    private final CastMediaOptions zzf;
    private final boolean zzg;
    private final double zzh;
    private final boolean zzi;
    private final boolean zzj;
    private final boolean zzk;
    private final List zzl;
    private final boolean zzm;
    private final int zzn;
    private final boolean zzo;

    /* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
    public static final class Builder {
        private String zza;
        private List zzb = new ArrayList();
        private boolean zzc;
        private LaunchOptions zzd = new LaunchOptions();
        private boolean zze = true;
        private zzeq zzf = null;
        private boolean zzg = true;
        private double zzh = 0.05000000074505806d;
        private boolean zzi = false;
        private final List zzj = new ArrayList();

        public Builder setCastMediaOptions(CastMediaOptions castMediaOptions) {
            this.zzf = zzeq.zzb(castMediaOptions);
            return this;
        }

        public Builder setEnableReconnectionService(boolean z) {
            this.zzg = z;
            return this;
        }

        public Builder setLaunchOptions(LaunchOptions launchOptions) {
            this.zzd = launchOptions;
            return this;
        }

        public Builder setReceiverApplicationId(String str) {
            this.zza = str;
            return this;
        }

        public Builder setRemoteToLocalEnabled(boolean z) {
            this.zzi = z;
            return this;
        }

        public Builder setResumeSavedSession(boolean z) {
            this.zze = z;
            return this;
        }

        public Builder setStopReceiverApplicationWhenEndingSession(boolean z) {
            this.zzc = z;
            return this;
        }

        public Builder setSupportedNamespaces(List<String> list) {
            this.zzb = list;
            return this;
        }

        @Deprecated
        public Builder setVolumeDeltaBeforeIceCreamSandwich(double d) throws IllegalArgumentException {
            if (d <= 0.0d || d > 0.5d) {
                throw new IllegalArgumentException("volumeDelta must be greater than 0 and less or equal to 0.5");
            }
            this.zzh = d;
            return this;
        }

        public CastOptions build() {
            Object obj;
            zzeq zzeq = this.zzf;
            if (zzeq != null) {
                obj = zzeq.zza();
            } else {
                obj = new CastMediaOptions.Builder().build();
            }
            return new CastOptions(this.zza, this.zzb, this.zzc, this.zzd, this.zze, (CastMediaOptions) obj, this.zzg, this.zzh, false, false, this.zzi, this.zzj, true, 0, false);
        }
    }

    CastOptions(String str, List list, boolean z, LaunchOptions launchOptions, boolean z2, CastMediaOptions castMediaOptions, boolean z3, double d, boolean z4, boolean z5, boolean z6, List list2, boolean z7, int i, boolean z8) {
        int i2;
        List list3 = list;
        this.zza = true == TextUtils.isEmpty(str) ? "" : str;
        if (list3 == null) {
            i2 = 0;
        } else {
            i2 = list.size();
        }
        ArrayList arrayList = new ArrayList(i2);
        this.zzb = arrayList;
        if (i2 > 0) {
            arrayList.addAll(list);
        }
        this.zzc = z;
        this.zzd = launchOptions == null ? new LaunchOptions() : launchOptions;
        this.zze = z2;
        this.zzf = castMediaOptions;
        this.zzg = z3;
        this.zzh = d;
        this.zzi = z4;
        this.zzj = z5;
        this.zzk = z6;
        this.zzl = list2;
        this.zzm = z7;
        this.zzn = i;
        this.zzo = z8;
    }

    public CastMediaOptions getCastMediaOptions() {
        return this.zzf;
    }

    public boolean getEnableReconnectionService() {
        return this.zzg;
    }

    public LaunchOptions getLaunchOptions() {
        return this.zzd;
    }

    public String getReceiverApplicationId() {
        return this.zza;
    }

    public boolean getResumeSavedSession() {
        return this.zze;
    }

    public boolean getStopReceiverApplicationWhenEndingSession() {
        return this.zzc;
    }

    public List<String> getSupportedNamespaces() {
        return Collections.unmodifiableList(this.zzb);
    }

    @Deprecated
    public double getVolumeDeltaBeforeIceCreamSandwich() {
        return this.zzh;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, getReceiverApplicationId(), false);
        SafeParcelWriter.writeStringList(parcel, 3, getSupportedNamespaces(), false);
        SafeParcelWriter.writeBoolean(parcel, 4, getStopReceiverApplicationWhenEndingSession());
        SafeParcelWriter.writeParcelable(parcel, 5, getLaunchOptions(), i, false);
        SafeParcelWriter.writeBoolean(parcel, 6, getResumeSavedSession());
        SafeParcelWriter.writeParcelable(parcel, 7, getCastMediaOptions(), i, false);
        SafeParcelWriter.writeBoolean(parcel, 8, getEnableReconnectionService());
        SafeParcelWriter.writeDouble(parcel, 9, getVolumeDeltaBeforeIceCreamSandwich());
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzi);
        SafeParcelWriter.writeBoolean(parcel, 11, this.zzj);
        SafeParcelWriter.writeBoolean(parcel, 12, this.zzk);
        SafeParcelWriter.writeStringList(parcel, 13, Collections.unmodifiableList(this.zzl), false);
        SafeParcelWriter.writeBoolean(parcel, 14, this.zzm);
        SafeParcelWriter.writeInt(parcel, 15, this.zzn);
        SafeParcelWriter.writeBoolean(parcel, 16, this.zzo);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final List zza() {
        return Collections.unmodifiableList(this.zzl);
    }

    public final void zzb(LaunchOptions launchOptions) {
        this.zzd = launchOptions;
    }

    public final void zzc(String str) {
        this.zza = str;
    }

    public final boolean zzd() {
        return this.zzj;
    }

    public final boolean zze() {
        return this.zzn == 1;
    }

    public final boolean zzf() {
        return this.zzk;
    }

    public final boolean zzg() {
        return this.zzo;
    }

    public final boolean zzh() {
        return this.zzm;
    }
}

package com.google.android.tv.ads;

import com.google.android.tv.ads.IconClickFallbackImage;

/* compiled from: com.google.android.tv:tv-ads@@1.0.0-alpha02 */
final class zza extends IconClickFallbackImage.Builder {
    private int zza;
    private int zzb;
    private String zzc;
    private String zzd;
    private String zze;
    private byte zzf;

    zza() {
    }

    public final IconClickFallbackImage build() {
        String str;
        String str2;
        String str3;
        if (this.zzf == 3 && (str = this.zzc) != null && (str2 = this.zzd) != null && (str3 = this.zze) != null) {
            return new zzd(this.zza, this.zzb, str, str2, str3);
        }
        StringBuilder sb = new StringBuilder();
        if ((this.zzf & 1) == 0) {
            sb.append(" width");
        }
        if ((this.zzf & 2) == 0) {
            sb.append(" height");
        }
        if (this.zzc == null) {
            sb.append(" altText");
        }
        if (this.zzd == null) {
            sb.append(" creativeType");
        }
        if (this.zze == null) {
            sb.append(" staticResourceUri");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }

    public final IconClickFallbackImage.Builder setAltText(String str) {
        if (str != null) {
            this.zzc = str;
            return this;
        }
        throw new NullPointerException("Null altText");
    }

    public final IconClickFallbackImage.Builder setCreativeType(String str) {
        if (str != null) {
            this.zzd = str;
            return this;
        }
        throw new NullPointerException("Null creativeType");
    }

    public final IconClickFallbackImage.Builder setHeight(int i) {
        this.zzb = i;
        this.zzf = (byte) (this.zzf | 2);
        return this;
    }

    public final IconClickFallbackImage.Builder setStaticResourceUri(String str) {
        if (str != null) {
            this.zze = str;
            return this;
        }
        throw new NullPointerException("Null staticResourceUri");
    }

    public final IconClickFallbackImage.Builder setWidth(int i) {
        this.zza = i;
        this.zzf = (byte) (this.zzf | 1);
        return this;
    }
}

package com.google.android.tv.ads;

/* renamed from: com.google.android.tv.ads.$AutoValue_IconClickFallbackImage  reason: invalid class name */
/* compiled from: com.google.android.tv:tv-ads@@1.0.0-alpha02 */
abstract class C$AutoValue_IconClickFallbackImage extends IconClickFallbackImage {
    private final int zza;
    private final int zzb;
    private final String zzc;
    private final String zzd;
    private final String zze;

    C$AutoValue_IconClickFallbackImage(int i, int i2, String str, String str2, String str3) {
        this.zza = i;
        this.zzb = i2;
        if (str != null) {
            this.zzc = str;
            if (str2 != null) {
                this.zzd = str2;
                if (str3 != null) {
                    this.zze = str3;
                    return;
                }
                throw new NullPointerException("Null staticResourceUri");
            }
            throw new NullPointerException("Null creativeType");
        }
        throw new NullPointerException("Null altText");
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof IconClickFallbackImage) {
            IconClickFallbackImage iconClickFallbackImage = (IconClickFallbackImage) obj;
            return this.zza == iconClickFallbackImage.getWidth() && this.zzb == iconClickFallbackImage.getHeight() && this.zzc.equals(iconClickFallbackImage.getAltText()) && this.zzd.equals(iconClickFallbackImage.getCreativeType()) && this.zze.equals(iconClickFallbackImage.getStaticResourceUri());
        }
    }

    public String getAltText() {
        return this.zzc;
    }

    public String getCreativeType() {
        return this.zzd;
    }

    public int getHeight() {
        return this.zzb;
    }

    public String getStaticResourceUri() {
        return this.zze;
    }

    public int getWidth() {
        return this.zza;
    }

    public final int hashCode() {
        return ((((((((this.zza ^ 1000003) * 1000003) ^ this.zzb) * 1000003) ^ this.zzc.hashCode()) * 1000003) ^ this.zzd.hashCode()) * 1000003) ^ this.zze.hashCode();
    }

    public final String toString() {
        int i = this.zza;
        int i2 = this.zzb;
        String str = this.zzc;
        String str2 = this.zzd;
        String str3 = this.zze;
        return "IconClickFallbackImage{width=" + i + ", height=" + i2 + ", altText=" + str + ", creativeType=" + str2 + ", staticResourceUri=" + str3 + "}";
    }
}

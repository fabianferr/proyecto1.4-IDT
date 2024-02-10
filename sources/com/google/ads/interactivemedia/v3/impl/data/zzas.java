package com.google.ads.interactivemedia.v3.impl.data;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzas extends zzbw {
    private final float volume;

    private zzas(float f) {
        this.volume = f;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof zzbw) && Float.floatToIntBits(this.volume) == Float.floatToIntBits(((zzbw) obj).volume());
    }

    public int hashCode() {
        return Float.floatToIntBits(this.volume) ^ 1000003;
    }

    public String toString() {
        float f = this.volume;
        return "VolumeUpdateData{volume=" + f + "}";
    }

    public float volume() {
        return this.volume;
    }
}

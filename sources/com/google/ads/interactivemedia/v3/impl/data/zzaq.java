package com.google.ads.interactivemedia.v3.impl.data;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzaq extends zzbv {
    private byte set$0;
    private float volume;

    zzaq() {
    }

    public zzbw build() {
        if (this.set$0 == 1) {
            return new zzas(this.volume);
        }
        throw new IllegalStateException("Missing required properties: volume");
    }

    public zzbv volume(float f) {
        this.volume = f;
        this.set$0 = (byte) (this.set$0 | 1);
        return this;
    }
}

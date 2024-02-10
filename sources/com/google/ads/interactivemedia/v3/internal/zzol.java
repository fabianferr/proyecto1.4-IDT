package com.google.ads.interactivemedia.v3.internal;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzol extends Exception {
    private final int zza;

    public zzol(int i) {
        super("Signal SDK error code: " + i);
        this.zza = i;
    }

    public final int zza() {
        return this.zza;
    }
}

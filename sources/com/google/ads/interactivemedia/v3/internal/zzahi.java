package com.google.ads.interactivemedia.v3.internal;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzahi extends RuntimeException {
    public zzahi(zzafz zzafz) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
    }

    public final zzafc zza() {
        return new zzafc(getMessage());
    }
}

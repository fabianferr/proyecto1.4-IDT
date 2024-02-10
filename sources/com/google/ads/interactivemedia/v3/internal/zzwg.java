package com.google.ads.interactivemedia.v3.internal;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzwg {
    public static final zzwg zza = new zzwg("\n", "  ");

    private zzwg(String str, String str2) {
        if (!"\n".matches("[\r\n]*")) {
            throw new IllegalArgumentException("Only combinations of \\n and \\r are allowed in newline.");
        } else if (!"  ".matches("[ \t]*")) {
            throw new IllegalArgumentException("Only combinations of spaces and tabs allowed in indent.");
        }
    }
}

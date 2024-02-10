package com.google.ads.interactivemedia.v3.internal;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public enum zzahz {
    DOUBLE(zzaia.DOUBLE, 1),
    FLOAT(zzaia.FLOAT, 5),
    INT64(zzaia.LONG, 0),
    UINT64(zzaia.LONG, 0),
    INT32(zzaia.INT, 0),
    FIXED64(zzaia.LONG, 1),
    FIXED32(zzaia.INT, 5),
    BOOL(zzaia.BOOLEAN, 0),
    STRING(zzaia.STRING, 2),
    GROUP(zzaia.MESSAGE, 3),
    MESSAGE(zzaia.MESSAGE, 2),
    BYTES(zzaia.BYTE_STRING, 2),
    UINT32(zzaia.INT, 0),
    ENUM(zzaia.ENUM, 0),
    SFIXED32(zzaia.INT, 5),
    SFIXED64(zzaia.LONG, 1),
    SINT32(zzaia.INT, 0),
    SINT64(zzaia.LONG, 0);
    
    private final zzaia zzt;

    private zzahz(zzaia zzaia, int i) {
        this.zzt = zzaia;
    }

    public final zzaia zza() {
        return this.zzt;
    }
}

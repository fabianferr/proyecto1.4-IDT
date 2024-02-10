package com.google.android.gms.internal.cast;

/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
public enum zzvg {
    DOUBLE(zzvh.DOUBLE, 1),
    FLOAT(zzvh.FLOAT, 5),
    INT64(zzvh.LONG, 0),
    UINT64(zzvh.LONG, 0),
    INT32(zzvh.INT, 0),
    FIXED64(zzvh.LONG, 1),
    FIXED32(zzvh.INT, 5),
    BOOL(zzvh.BOOLEAN, 0),
    STRING(zzvh.STRING, 2),
    GROUP(zzvh.MESSAGE, 3),
    MESSAGE(zzvh.MESSAGE, 2),
    BYTES(zzvh.BYTE_STRING, 2),
    UINT32(zzvh.INT, 0),
    ENUM(zzvh.ENUM, 0),
    SFIXED32(zzvh.INT, 5),
    SFIXED64(zzvh.LONG, 1),
    SINT32(zzvh.INT, 0),
    SINT64(zzvh.LONG, 0);
    
    private final zzvh zzt;

    private zzvg(zzvh zzvh, int i) {
        this.zzt = zzvh;
    }

    public final zzvh zza() {
        return this.zzt;
    }
}

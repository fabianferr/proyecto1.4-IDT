package com.google.ads.interactivemedia.v3.internal;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public enum zzael {
    DOUBLE(0, 1, zzafd.DOUBLE),
    FLOAT(1, 1, zzafd.FLOAT),
    INT64(2, 1, zzafd.LONG),
    UINT64(3, 1, zzafd.LONG),
    INT32(4, 1, zzafd.INT),
    FIXED64(5, 1, zzafd.LONG),
    FIXED32(6, 1, zzafd.INT),
    BOOL(7, 1, zzafd.BOOLEAN),
    STRING(8, 1, zzafd.STRING),
    MESSAGE(9, 1, zzafd.MESSAGE),
    BYTES(10, 1, zzafd.BYTE_STRING),
    UINT32(11, 1, zzafd.INT),
    ENUM(12, 1, zzafd.ENUM),
    SFIXED32(13, 1, zzafd.INT),
    SFIXED64(14, 1, zzafd.LONG),
    SINT32(15, 1, zzafd.INT),
    SINT64(16, 1, zzafd.LONG),
    GROUP(17, 1, zzafd.MESSAGE),
    DOUBLE_LIST(18, 2, zzafd.DOUBLE),
    FLOAT_LIST(19, 2, zzafd.FLOAT),
    INT64_LIST(20, 2, zzafd.LONG),
    UINT64_LIST(21, 2, zzafd.LONG),
    INT32_LIST(22, 2, zzafd.INT),
    FIXED64_LIST(23, 2, zzafd.LONG),
    FIXED32_LIST(24, 2, zzafd.INT),
    BOOL_LIST(25, 2, zzafd.BOOLEAN),
    STRING_LIST(26, 2, zzafd.STRING),
    MESSAGE_LIST(27, 2, zzafd.MESSAGE),
    BYTES_LIST(28, 2, zzafd.BYTE_STRING),
    UINT32_LIST(29, 2, zzafd.INT),
    ENUM_LIST(30, 2, zzafd.ENUM),
    SFIXED32_LIST(31, 2, zzafd.INT),
    SFIXED64_LIST(32, 2, zzafd.LONG),
    SINT32_LIST(33, 2, zzafd.INT),
    SINT64_LIST(34, 2, zzafd.LONG),
    DOUBLE_LIST_PACKED(35, 3, zzafd.DOUBLE),
    FLOAT_LIST_PACKED(36, 3, zzafd.FLOAT),
    INT64_LIST_PACKED(37, 3, zzafd.LONG),
    UINT64_LIST_PACKED(38, 3, zzafd.LONG),
    INT32_LIST_PACKED(39, 3, zzafd.INT),
    FIXED64_LIST_PACKED(40, 3, zzafd.LONG),
    FIXED32_LIST_PACKED(41, 3, zzafd.INT),
    BOOL_LIST_PACKED(42, 3, zzafd.BOOLEAN),
    UINT32_LIST_PACKED(43, 3, zzafd.INT),
    ENUM_LIST_PACKED(44, 3, zzafd.ENUM),
    SFIXED32_LIST_PACKED(45, 3, zzafd.INT),
    SFIXED64_LIST_PACKED(46, 3, zzafd.LONG),
    SINT32_LIST_PACKED(47, 3, zzafd.INT),
    SINT64_LIST_PACKED(48, 3, zzafd.LONG),
    GROUP_LIST(49, 2, zzafd.MESSAGE),
    MAP(50, 4, zzafd.VOID);
    
    private static final zzael[] zzZ = null;
    private final zzafd zzab;
    private final int zzac;
    private final Class zzad;

    static {
        zzZ = new zzael[r1];
        for (zzael zzael : values()) {
            zzZ[zzael.zzac] = zzael;
        }
    }

    private zzael(int i, int i2, zzafd zzafd) {
        this.zzac = i;
        this.zzab = zzafd;
        zzafd zzafd2 = zzafd.VOID;
        int i3 = i2 - 1;
        if (i3 == 1) {
            this.zzad = zzafd.zza();
        } else if (i3 != 3) {
            this.zzad = null;
        } else {
            this.zzad = zzafd.zza();
        }
        if (i2 == 1) {
            zzafd.ordinal();
        }
    }

    public final int zza() {
        return this.zzac;
    }
}

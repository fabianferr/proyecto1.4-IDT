package com.google.android.gms.internal.cast;

/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
public enum zzsc {
    DOUBLE(0, 1, zzst.DOUBLE),
    FLOAT(1, 1, zzst.FLOAT),
    INT64(2, 1, zzst.LONG),
    UINT64(3, 1, zzst.LONG),
    INT32(4, 1, zzst.INT),
    FIXED64(5, 1, zzst.LONG),
    FIXED32(6, 1, zzst.INT),
    BOOL(7, 1, zzst.BOOLEAN),
    STRING(8, 1, zzst.STRING),
    MESSAGE(9, 1, zzst.MESSAGE),
    BYTES(10, 1, zzst.BYTE_STRING),
    UINT32(11, 1, zzst.INT),
    ENUM(12, 1, zzst.ENUM),
    SFIXED32(13, 1, zzst.INT),
    SFIXED64(14, 1, zzst.LONG),
    SINT32(15, 1, zzst.INT),
    SINT64(16, 1, zzst.LONG),
    GROUP(17, 1, zzst.MESSAGE),
    DOUBLE_LIST(18, 2, zzst.DOUBLE),
    FLOAT_LIST(19, 2, zzst.FLOAT),
    INT64_LIST(20, 2, zzst.LONG),
    UINT64_LIST(21, 2, zzst.LONG),
    INT32_LIST(22, 2, zzst.INT),
    FIXED64_LIST(23, 2, zzst.LONG),
    FIXED32_LIST(24, 2, zzst.INT),
    BOOL_LIST(25, 2, zzst.BOOLEAN),
    STRING_LIST(26, 2, zzst.STRING),
    MESSAGE_LIST(27, 2, zzst.MESSAGE),
    BYTES_LIST(28, 2, zzst.BYTE_STRING),
    UINT32_LIST(29, 2, zzst.INT),
    ENUM_LIST(30, 2, zzst.ENUM),
    SFIXED32_LIST(31, 2, zzst.INT),
    SFIXED64_LIST(32, 2, zzst.LONG),
    SINT32_LIST(33, 2, zzst.INT),
    SINT64_LIST(34, 2, zzst.LONG),
    DOUBLE_LIST_PACKED(35, 3, zzst.DOUBLE),
    FLOAT_LIST_PACKED(36, 3, zzst.FLOAT),
    INT64_LIST_PACKED(37, 3, zzst.LONG),
    UINT64_LIST_PACKED(38, 3, zzst.LONG),
    INT32_LIST_PACKED(39, 3, zzst.INT),
    FIXED64_LIST_PACKED(40, 3, zzst.LONG),
    FIXED32_LIST_PACKED(41, 3, zzst.INT),
    BOOL_LIST_PACKED(42, 3, zzst.BOOLEAN),
    UINT32_LIST_PACKED(43, 3, zzst.INT),
    ENUM_LIST_PACKED(44, 3, zzst.ENUM),
    SFIXED32_LIST_PACKED(45, 3, zzst.INT),
    SFIXED64_LIST_PACKED(46, 3, zzst.LONG),
    SINT32_LIST_PACKED(47, 3, zzst.INT),
    SINT64_LIST_PACKED(48, 3, zzst.LONG),
    GROUP_LIST(49, 2, zzst.MESSAGE),
    MAP(50, 4, zzst.VOID);
    
    private static final zzsc[] zzZ = null;
    private final zzst zzab;
    private final int zzac;
    private final Class zzad;

    static {
        zzZ = new zzsc[r1];
        for (zzsc zzsc : values()) {
            zzZ[zzsc.zzac] = zzsc;
        }
    }

    private zzsc(int i, int i2, zzst zzst) {
        this.zzac = i;
        this.zzab = zzst;
        zzst zzst2 = zzst.VOID;
        int i3 = i2 - 1;
        if (i3 == 1) {
            this.zzad = zzst.zza();
        } else if (i3 != 3) {
            this.zzad = null;
        } else {
            this.zzad = zzst.zza();
        }
        if (i2 == 1) {
            zzst.ordinal();
        }
    }

    public final int zza() {
        return this.zzac;
    }
}

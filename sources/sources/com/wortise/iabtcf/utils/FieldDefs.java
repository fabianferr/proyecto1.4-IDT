package com.wortise.iabtcf.utils;

public enum FieldDefs {
    CORE_VERSION((String) 6, 0),
    CORE_CREATED((String) 36),
    CORE_LAST_UPDATED((String) 36),
    CORE_CMP_ID((String) 12),
    CORE_CMP_VERSION((String) 12),
    CORE_CONSENT_SCREEN((String) 6),
    CORE_CONSENT_LANGUAGE((String) 12),
    CORE_VENDOR_LIST_VERSION((String) 12),
    CORE_TCF_POLICY_VERSION((String) 6),
    CORE_IS_SERVICE_SPECIFIC((String) 1),
    CORE_USE_NON_STANDARD_STOCKS((String) 1),
    CORE_SPECIAL_FEATURE_OPT_INS((String) 12),
    CORE_PURPOSES_CONSENT((String) 24),
    CORE_PURPOSES_LI_TRANSPARENCY((String) 24),
    CORE_PURPOSE_ONE_TREATMENT((String) 1),
    CORE_PUBLISHER_CC((String) 12),
    CORE_VENDOR_MAX_VENDOR_ID((String) 16),
    CORE_VENDOR_IS_RANGE_ENCODING((String) 1),
    CORE_VENDOR_BITRANGE_FIELD((String) BitRangeFieldUtils.lengthSupplier(r11, r10)),
    CORE_VENDOR_LI_MAX_VENDOR_ID((String) 16),
    CORE_VENDOR_LI_IS_RANGE_ENCODING((String) 1),
    CORE_VENDOR_LI_BITRANGE_FIELD((String) BitRangeFieldUtils.lengthSupplier(r3, r2)),
    CORE_NUM_PUB_RESTRICTION((String) 12),
    CORE_PUB_RESTRICTION_ENTRY((String) PublisherRestrictionUtils.lengthSupplier(r3)),
    OOB_SEGMENT_TYPE((String) 3, 0),
    DV_MAX_VENDOR_ID((String) 16, (int) r3),
    DV_IS_RANGE_ENCODING((String) 1),
    DV_VENDOR_BITRANGE_FIELD((String) BitRangeFieldUtils.lengthSupplier(r5, r2)),
    AV_MAX_VENDOR_ID((String) 16, (int) r3),
    AV_IS_RANGE_ENCODING((String) 1),
    AV_VENDOR_BITRANGE_FIELD((String) BitRangeFieldUtils.lengthSupplier(r6, r5)),
    PPTC_SEGMENT_TYPE((String) 3, 0),
    PPTC_PUB_PURPOSES_CONSENT((String) 24),
    PPTC_PUB_PURPOSES_LI_TRANSPARENCY((String) 24),
    PPTC_NUM_CUSTOM_PURPOSES((String) 6),
    PPTC_CUSTOM_PURPOSES_CONSENT((String) new LengthSupplier() {
        public boolean isDynamic() {
            return true;
        }

        public Integer apply(BitReader bitReader) {
            return Integer.valueOf(bitReader.readBits6(FieldDefs.PPTC_NUM_CUSTOM_PURPOSES.getOffset(bitReader)));
        }
    }),
    PPTC_CUSTOM_PURPOSES_LI_TRANSPARENCY((String) new LengthSupplier() {
        public boolean isDynamic() {
            return true;
        }

        public Integer apply(BitReader bitReader) {
            return Integer.valueOf(FieldDefs.PPTC_CUSTOM_PURPOSES_CONSENT.getLength(bitReader));
        }
    }),
    NUM_ENTRIES((String) 12, (int) OffsetSupplier.NOT_SUPPORTED),
    IS_A_RANGE((String) 1, (int) OffsetSupplier.NOT_SUPPORTED),
    START_OR_ONLY_VENDOR_ID((String) 16, (int) OffsetSupplier.NOT_SUPPORTED),
    END_VENDOR_ID((String) 16, (int) OffsetSupplier.NOT_SUPPORTED),
    TIMESTAMP((String) 36, (int) OffsetSupplier.NOT_SUPPORTED),
    PURPOSE_ID((String) 6, (int) OffsetSupplier.NOT_SUPPORTED),
    RESTRICTION_TYPE((String) 2, (int) OffsetSupplier.NOT_SUPPORTED),
    CHAR((String) 6, (int) OffsetSupplier.NOT_SUPPORTED),
    V1_VERSION((String) 6, 0),
    V1_CREATED((String) 36),
    V1_LAST_UPDATED((String) 36),
    V1_CMP_ID((String) 12),
    V1_CMP_VERSION((String) 12),
    V1_CONSENT_SCREEN((String) 6),
    V1_CONSENT_LANGUAGE((String) 12),
    V1_VENDOR_LIST_VERSION((String) 12),
    V1_PURPOSES_ALLOW((String) 24),
    V1_VENDOR_MAX_VENDOR_ID((String) 16),
    V1_VENDOR_IS_RANGE_ENCODING((String) 1),
    V1_VENDOR_BITRANGE_FIELD((String) BitRangeFieldUtils.lengthSupplierV1()),
    V1_VENDOR_DEFAULT_CONSENT((String) 1, (int) r2),
    V1_VENDOR_NUM_ENTRIES((String) 12),
    V1_PPC_PUBLISHER_PURPOSES_VERSION((String) 12, (int) r10),
    V1_PPC_STANDARD_PURPOSES_ALLOWED((String) 24),
    V1_PPC_NUMBER_CUSTOM_PURPOSES((String) 6),
    V1_PPC_CUSTOM_PURPOSES_BITFIELD((String) new LengthSupplier() {
        public boolean isDynamic() {
            return true;
        }

        public Integer apply(BitReader bitReader) {
            return Integer.valueOf(ByteCompat.toUnsignedInt(bitReader.readBits6(FieldDefs.V1_PPC_NUMBER_CUSTOM_PURPOSES.getOffset(bitReader))));
        }
    });
    
    private boolean isDynamic;
    private boolean isDynamicInit;
    private LengthSupplier length;
    private OffsetSupplier offset;

    private interface LengthSupplier extends Function<BitReader, Integer> {
        boolean isDynamic();
    }

    private FieldDefs(int i, FieldDefs fieldDefs) {
        this.isDynamic = false;
        this.isDynamicInit = false;
        this.length = LengthSupplierFactory.constant(i);
        this.offset = OffsetSupplierFactory.from(fieldDefs);
    }

    private FieldDefs(int i, OffsetSupplier offsetSupplier) {
        this.isDynamic = false;
        this.isDynamicInit = false;
        this.length = LengthSupplierFactory.constant(i);
        this.offset = offsetSupplier;
    }

    private FieldDefs(int i, int i2) {
        this.isDynamic = false;
        this.isDynamicInit = false;
        this.length = LengthSupplierFactory.constant(i);
        this.offset = OffsetSupplierFactory.constant(i2);
    }

    private FieldDefs(LengthSupplier lengthSupplier) {
        this.isDynamic = false;
        this.isDynamicInit = false;
        this.length = lengthSupplier;
        this.offset = OffsetSupplierFactory.fromPrevious(this);
    }

    private FieldDefs(int i) {
        this.isDynamic = false;
        this.isDynamicInit = false;
        this.length = LengthSupplierFactory.constant(i);
        this.offset = OffsetSupplierFactory.fromPrevious(this);
    }

    /* access modifiers changed from: protected */
    public boolean isDynamic() {
        if (!this.isDynamicInit) {
            this.isDynamic = this.offset.isDynamic() || this.length.isDynamic();
            this.isDynamicInit = true;
        }
        return this.isDynamic;
    }

    public int getLength() {
        return ((Integer) this.length.apply(null)).intValue();
    }

    public int getLength(BitReader bitReader) {
        return bitReader.cache.getLength(this, this.length).intValue();
    }

    public int getOffset(BitReader bitReader) {
        return bitReader.cache.getOffset(this, this.offset).intValue();
    }

    public int getEnd(BitReader bitReader) {
        return getLength(bitReader) + getOffset(bitReader);
    }

    private static abstract class MemoizingFunction implements LengthSupplier, OffsetSupplier, Function<BitReader, Integer> {
        private boolean dynamicInitialized;
        private boolean isDynamic;
        private Integer value;

        public abstract Integer doCompute(BitReader bitReader);

        public abstract boolean isDynamic();

        private MemoizingFunction() {
            this.dynamicInitialized = false;
            this.isDynamic = false;
        }

        public Integer apply(BitReader bitReader) {
            if (this.value != null && !isDynamicPvt()) {
                return this.value;
            }
            Integer doCompute = doCompute(bitReader);
            this.value = doCompute;
            return doCompute;
        }

        private boolean isDynamicPvt() {
            if (!this.dynamicInitialized) {
                this.dynamicInitialized = true;
                this.isDynamic = isDynamic();
            }
            return this.isDynamic;
        }
    }

    private interface OffsetSupplier extends Function<BitReader, Integer> {
        public static final OffsetSupplier NOT_SUPPORTED = null;

        boolean isDynamic();

        static {
            NOT_SUPPORTED = new OffsetSupplier() {
                public boolean isDynamic() {
                    return false;
                }

                public Integer apply(BitReader bitReader) {
                    throw new UnsupportedOperationException();
                }
            };
        }
    }

    private static class OffsetSupplierFactory {
        private OffsetSupplierFactory() {
        }

        static OffsetSupplier constant(final int i) {
            return new OffsetSupplier() {
                public boolean isDynamic() {
                    return false;
                }

                public Integer apply(BitReader bitReader) {
                    return Integer.valueOf(i);
                }
            };
        }

        static OffsetSupplier from(final FieldDefs fieldDefs) {
            return new MemoizingFunction() {
                public boolean isDynamic() {
                    return fieldDefs.isDynamic();
                }

                public Integer doCompute(BitReader bitReader) {
                    return Integer.valueOf(fieldDefs.getLength(bitReader) + fieldDefs.getOffset(bitReader));
                }
            };
        }

        static OffsetSupplier fromPrevious(final FieldDefs fieldDefs) {
            return new MemoizingFunction() {
                public boolean isDynamic() {
                    return FieldDefs.values()[fieldDefs.ordinal() - 1].isDynamic();
                }

                public Integer doCompute(BitReader bitReader) {
                    FieldDefs fieldDefs = FieldDefs.values()[fieldDefs.ordinal() - 1];
                    return Integer.valueOf(fieldDefs.getLength(bitReader) + fieldDefs.getOffset(bitReader));
                }
            };
        }
    }

    private static class LengthSupplierFactory {
        private LengthSupplierFactory() {
        }

        static LengthSupplier constant(final int i) {
            return new LengthSupplier() {
                public boolean isDynamic() {
                    return false;
                }

                public Integer apply(BitReader bitReader) {
                    return Integer.valueOf(i);
                }
            };
        }
    }

    private static class PublisherRestrictionUtils {
        private PublisherRestrictionUtils() {
        }

        public static int calculateBitRangelength(BitReader bitReader, int i) {
            int readBits12 = bitReader.readBits12(i);
            int length = FieldDefs.CORE_NUM_PUB_RESTRICTION.getLength(bitReader) + i;
            for (int i2 = 0; i2 < readBits12; i2++) {
                int length2 = length + FieldDefs.PURPOSE_ID.getLength(bitReader) + FieldDefs.RESTRICTION_TYPE.getLength(bitReader);
                length = length2 + BitRangeFieldUtils.calculateRangeLength(bitReader, length2);
            }
            return length - i;
        }

        public static LengthSupplier lengthSupplier(final FieldDefs fieldDefs) {
            return new LengthSupplier() {
                public boolean isDynamic() {
                    return true;
                }

                public Integer apply(BitReader bitReader) {
                    return Integer.valueOf(PublisherRestrictionUtils.calculateBitRangelength(bitReader, fieldDefs.getOffset(bitReader)));
                }
            };
        }
    }

    private static class BitRangeFieldUtils {
        private BitRangeFieldUtils() {
        }

        public static int calculateRangeLength(BitReader bitReader, int i) {
            int readBits12 = bitReader.readBits12(i);
            int length = FieldDefs.NUM_ENTRIES.getLength(bitReader) + i;
            for (int i2 = 0; i2 < readBits12; i2++) {
                length += FieldDefs.IS_A_RANGE.getLength(bitReader) + FieldDefs.START_OR_ONLY_VENDOR_ID.getLength(bitReader) + (bitReader.readBits1(length) ? FieldDefs.END_VENDOR_ID.getLength(bitReader) : 0);
            }
            return length - i;
        }

        public static int calculateBitLength(BitReader bitReader, int i) {
            return bitReader.readBits16(i);
        }

        public static int calculateBitRangeLength(BitReader bitReader, int i, int i2) {
            if (!bitReader.readBits1(i)) {
                return calculateBitLength(bitReader, i2);
            }
            return calculateRangeLength(bitReader, i + 1);
        }

        public static LengthSupplier lengthSupplier(final FieldDefs fieldDefs, final FieldDefs fieldDefs2) {
            return new LengthSupplier() {
                public boolean isDynamic() {
                    return true;
                }

                public Integer apply(BitReader bitReader) {
                    return Integer.valueOf(BitRangeFieldUtils.calculateBitRangeLength(bitReader, fieldDefs.getOffset(bitReader), fieldDefs2.getOffset(bitReader)));
                }
            };
        }

        public static LengthSupplier lengthSupplierV1() {
            return new LengthSupplier() {
                public boolean isDynamic() {
                    return true;
                }

                public Integer apply(BitReader bitReader) {
                    if (!bitReader.readBits1(FieldDefs.V1_VENDOR_IS_RANGE_ENCODING.getOffset(bitReader))) {
                        return Integer.valueOf(BitRangeFieldUtils.calculateBitLength(bitReader, FieldDefs.V1_VENDOR_MAX_VENDOR_ID.getOffset(bitReader)));
                    }
                    return Integer.valueOf(BitRangeFieldUtils.calculateRangeLength(bitReader, FieldDefs.V1_VENDOR_NUM_ENTRIES.getOffset(bitReader)));
                }
            };
        }
    }
}

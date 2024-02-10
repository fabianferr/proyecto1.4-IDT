package io.monedata.iabtcf.v2;

public enum SegmentType {
    DEFAULT {
        public int value() {
            return 0;
        }
    },
    DISCLOSED_VENDOR {
        public int value() {
            return 1;
        }
    },
    ALLOWED_VENDOR {
        public int value() {
            return 2;
        }
    },
    PUBLISHER_TC {
        public int value() {
            return 3;
        }
    },
    INVALID {
        public int value() {
            return -1;
        }
    };

    public abstract int value();

    public static SegmentType from(int i) {
        if (i == 0) {
            return DEFAULT;
        }
        if (i == 1) {
            return DISCLOSED_VENDOR;
        }
        if (i == 2) {
            return ALLOWED_VENDOR;
        }
        if (i != 3) {
            return INVALID;
        }
        return PUBLISHER_TC;
    }
}

package io.monedata.iabtcf.v2;

public enum RestrictionType {
    NOT_ALLOWED,
    REQUIRE_CONSENT,
    REQUIRE_LEGITIMATE_INTEREST,
    UNDEFINED;

    public static RestrictionType from(int i) {
        if (i == 0) {
            return NOT_ALLOWED;
        }
        if (i == 1) {
            return REQUIRE_CONSENT;
        }
        if (i == 2) {
            return REQUIRE_LEGITIMATE_INTEREST;
        }
        if (i != 3) {
            return NOT_ALLOWED;
        }
        return UNDEFINED;
    }
}

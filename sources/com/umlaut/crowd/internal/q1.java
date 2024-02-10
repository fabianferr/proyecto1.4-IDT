package com.umlaut.crowd.internal;

public enum q1 {
    Unknown,
    SSLv3,
    TLSv1,
    TLSv1_1,
    TLSv1_2,
    TLSv1_3;

    public static q1 convertFromString(String str) {
        q1 q1Var = Unknown;
        if (str.equalsIgnoreCase("SSLv3")) {
            return SSLv3;
        }
        if (str.equalsIgnoreCase("TLSv1")) {
            return TLSv1;
        }
        if (str.equalsIgnoreCase("TLSv1.1")) {
            return TLSv1_1;
        }
        if (str.equalsIgnoreCase("TLSv1.2")) {
            return TLSv1_2;
        }
        return str.equalsIgnoreCase("TLSv1.3") ? TLSv1_3 : q1Var;
    }
}

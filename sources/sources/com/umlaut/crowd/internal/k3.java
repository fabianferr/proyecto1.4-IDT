package com.umlaut.crowd.internal;

import java.io.UnsupportedEncodingException;

public class k3 {
    public static String a(ub ubVar, String str) {
        byte[] bArr;
        if (ubVar == null || str == null || str.length() == 0) {
            return null;
        }
        try {
            bArr = h9.a((str + ubVar.TimestampMillis).getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            bArr = null;
        }
        if (bArr == null) {
            return null;
        }
        return i1.a(bArr);
    }

    public static String a(String str) {
        return a(str, (String) null);
    }

    public static String a(String str, String str2) {
        byte[] bArr;
        if (str2 == null) {
            try {
                bArr = h9.a(str.getBytes("UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        } else {
            bArr = h9.a(str.getBytes("UTF-8"), str2.getBytes("UTF-8"));
        }
        if (bArr != null) {
            return i1.a(bArr);
        }
        return "";
    }
}

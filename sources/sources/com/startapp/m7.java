package com.startapp;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.regex.Pattern;

/* compiled from: Sta */
public final class m7 {
    public static String a(String str, String str2) {
        Pattern pattern = pb.a;
        String str3 = "<script type=\"text/javascript\">" + str + "</script>";
        gc.a(str2, "HTML is null or empty");
        ArrayList arrayList = new ArrayList();
        int length = str2.length();
        int i = 0;
        while (i < length) {
            int indexOf = str2.indexOf("<!--", i);
            if (indexOf >= 0) {
                int indexOf2 = str2.indexOf("-->", indexOf);
                int[] iArr = new int[2];
                if (indexOf2 >= 0) {
                    iArr[0] = indexOf;
                    iArr[1] = indexOf2;
                    arrayList.add(iArr);
                    i = indexOf2 + 3;
                } else {
                    iArr[0] = indexOf;
                    iArr[1] = length;
                    arrayList.add(iArr);
                }
            }
            i = length;
        }
        int[][] iArr2 = (int[][]) arrayList.toArray((int[][]) Array.newInstance(Integer.TYPE, new int[]{0, 2}));
        StringBuilder sb = new StringBuilder(str3.length() + str2.length() + 16);
        if (pb.b(str2, sb, pb.b, str3, iArr2) || pb.a(str2, sb, pb.a, str3, iArr2) || pb.b(str2, sb, pb.d, str3, iArr2) || pb.a(str2, sb, pb.c, str3, iArr2) || pb.b(str2, sb, pb.f, str3, iArr2) || pb.a(str2, sb, pb.e, str3, iArr2) || pb.a(str2, sb, pb.g, str3, iArr2)) {
            return sb.toString();
        }
        return str3 + str2;
    }
}

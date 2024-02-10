package com.google.android.gms.internal.pal;

import com.google.common.base.Ascii;

/* compiled from: com.google.android.gms:play-services-pal@@20.0.1 */
public final class zzyj {
    public static String zza(byte[] bArr) {
        StringBuilder sb = new StringBuilder(r1 + r1);
        for (byte b : bArr) {
            byte b2 = b & 255;
            sb.append("0123456789abcdef".charAt(b2 >> 4));
            sb.append("0123456789abcdef".charAt(b2 & Ascii.SI));
        }
        return sb.toString();
    }
}

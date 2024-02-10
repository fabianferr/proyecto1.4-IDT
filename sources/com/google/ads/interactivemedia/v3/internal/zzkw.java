package com.google.ads.interactivemedia.v3.internal;

import android.os.Looper;
import android.util.DisplayMetrics;
import com.google.common.base.Ascii;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzkw {
    public static final /* synthetic */ int zza = 0;
    private static final char[] zzb = "0123456789abcdef".toCharArray();

    public static long zza(double d, int i, DisplayMetrics displayMetrics) {
        double d2 = (double) displayMetrics.density;
        Double.isNaN(d2);
        return Math.round(d / d2);
    }

    public static String zzb(byte[] bArr) {
        int length = bArr.length;
        char[] cArr = new char[(length + length)];
        for (int i = 0; i < bArr.length; i++) {
            byte b = bArr[i] & 255;
            char[] cArr2 = zzb;
            int i2 = i + i;
            cArr[i2] = cArr2[b >>> 4];
            cArr[i2 + 1] = cArr2[b & Ascii.SI];
        }
        return new String(cArr);
    }

    public static boolean zzc() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static boolean zzd(String str) {
        return str == null || str.isEmpty();
    }

    public static boolean zze(DisplayMetrics displayMetrics) {
        return (displayMetrics == null || displayMetrics.density == 0.0f) ? false : true;
    }

    public static byte[] zzf(String str) {
        int length = str.length();
        if (length % 2 == 0) {
            byte[] bArr = new byte[(length / 2)];
            for (int i = 0; i < length; i += 2) {
                bArr[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4) + Character.digit(str.charAt(i + 1), 16));
            }
            return bArr;
        }
        throw new IllegalArgumentException("String must be of even-length");
    }
}

package com.google.android.gms.internal.atv_ads_framework;

import com.google.firebase.analytics.FirebaseAnalytics;

/* compiled from: com.google.android.tv:tv-ads@@1.0.0-alpha02 */
public final class zzn {
    public static int zza(int i, int i2, String str) {
        String str2;
        if (i >= 0 && i < i2) {
            return i;
        }
        if (i < 0) {
            str2 = zzs.zza("%s (%s) must not be negative", FirebaseAnalytics.Param.INDEX, Integer.valueOf(i));
        } else if (i2 < 0) {
            throw new IllegalArgumentException("negative size: " + i2);
        } else {
            str2 = zzs.zza("%s (%s) must be less than size (%s)", FirebaseAnalytics.Param.INDEX, Integer.valueOf(i), Integer.valueOf(i2));
        }
        throw new IndexOutOfBoundsException(str2);
    }

    public static int zzb(int i, int i2, String str) {
        if (i >= 0 && i <= i2) {
            return i;
        }
        throw new IndexOutOfBoundsException(zze(i, i2, FirebaseAnalytics.Param.INDEX));
    }

    public static void zzc(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static void zzd(int i, int i2, int i3) {
        String str;
        if (i < 0 || i2 < i || i2 > i3) {
            if (i < 0 || i > i3) {
                str = zze(i, i3, "start index");
            } else if (i2 < 0 || i2 > i3) {
                str = zze(i2, i3, "end index");
            } else {
                str = zzs.zza("end index (%s) must not be less than start index (%s)", Integer.valueOf(i2), Integer.valueOf(i));
            }
            throw new IndexOutOfBoundsException(str);
        }
    }

    private static String zze(int i, int i2, String str) {
        if (i < 0) {
            return zzs.zza("%s (%s) must not be negative", str, Integer.valueOf(i));
        } else if (i2 >= 0) {
            return zzs.zza("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
        } else {
            throw new IllegalArgumentException("negative size: " + i2);
        }
    }
}

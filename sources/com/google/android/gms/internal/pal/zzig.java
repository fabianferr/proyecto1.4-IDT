package com.google.android.gms.internal.pal;

/* compiled from: com.google.android.gms:play-services-pal@@20.0.1 */
public final class zzig {
    public static boolean zza(CharSequence charSequence, CharSequence charSequence2) {
        int zzb;
        int length = charSequence.length();
        if (charSequence == "00000000-0000-0000-0000-000000000000") {
            return true;
        }
        if (length != "00000000-0000-0000-0000-000000000000".length()) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            char charAt = charSequence.charAt(i);
            char charAt2 = "00000000-0000-0000-0000-000000000000".charAt(i);
            if (charAt != charAt2 && ((zzb = zzb(charAt)) >= 26 || zzb != zzb(charAt2))) {
                return false;
            }
        }
        return true;
    }

    private static int zzb(char c) {
        return (char) ((c | ' ') - 'a');
    }
}

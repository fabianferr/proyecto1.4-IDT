package com.teragence.client.service;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import java.util.UUID;

public class e {
    public static long a(String str) {
        int length = str.length();
        long j = 1125899906842597L;
        for (int i = 0; i < length; i++) {
            j = (j * 31) + ((long) str.charAt(i));
        }
        return j;
    }

    public static UUID a(Context context) {
        String str = Build.SERIAL;
        return new UUID(a("" + Settings.Secure.getString(context.getContentResolver(), "android_id")), a(str));
    }
}

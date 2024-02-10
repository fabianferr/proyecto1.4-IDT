package com.appnext.base.b;

import android.content.Context;
import android.content.SharedPreferences;
import com.appnext.base.a;

public final class b {
    private static final b bS = new b();
    private Context aM;
    private SharedPreferences bR;

    private b() {
        Context context = a.getContext();
        this.aM = context;
        if (context != null) {
            this.bR = context.getSharedPreferences("LibrarySettings", 0);
        }
    }

    public static b N() {
        return bS;
    }

    public final void init(Context context) {
        if (context != null) {
            this.aM = context;
            this.bR = context.getSharedPreferences("lib_shared_preferences", 0);
        }
    }

    public final String c(String str, String str2) {
        try {
            SharedPreferences sharedPreferences = this.bR;
            return sharedPreferences != null ? sharedPreferences.getString(str, str2) : str2;
        } catch (Throwable th) {
            a.a("LibrarySettings$getString", th);
            return str2;
        }
    }

    public final long a(String str, long j) {
        try {
            SharedPreferences sharedPreferences = this.bR;
            if (sharedPreferences != null) {
                return sharedPreferences.getLong(str, 0);
            }
            return 0;
        } catch (Throwable th) {
            a.a("LibrarySettings$getLong", th);
            return 0;
        }
    }

    public final void b(String str, long j) {
        try {
            SharedPreferences sharedPreferences = this.bR;
            if (sharedPreferences != null) {
                sharedPreferences.edit().putLong(str, j).apply();
            }
        } catch (Throwable th) {
            a.a("LibrarySettings$putLong", th);
        }
    }

    public final void d(String str, String str2) {
        try {
            SharedPreferences sharedPreferences = this.bR;
            if (sharedPreferences != null) {
                sharedPreferences.edit().putString(str, str2).apply();
            }
        } catch (Throwable th) {
            a.a("LibrarySettings$putString", th);
        }
    }
}

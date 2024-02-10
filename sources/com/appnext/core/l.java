package com.appnext.core;

import android.content.Context;
import android.content.SharedPreferences;
import com.appnext.base.a;

public class l {
    private static final String dq = "l";
    private static volatile l dr;
    private Context aM;
    private SharedPreferences bR;

    public static l h(Context context) {
        if (dr == null) {
            synchronized (l.class) {
                if (dr == null) {
                    dr = new l(context.getApplicationContext());
                }
            }
        }
        return dr;
    }

    private l(Context context) {
        if (context != null) {
            this.aM = context;
            this.bR = context.getSharedPreferences("sp_response_preferences", 0);
        }
    }

    public final String c(String str, String str2) {
        try {
            SharedPreferences sharedPreferences = this.bR;
            return sharedPreferences != null ? sharedPreferences.getString(str, str2) : str2;
        } catch (Throwable th) {
            a.a("SPResponse$getString", th);
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
            a.a("SPResponse$getLong", th);
            return 0;
        }
    }

    public final int a(String str, int i) {
        try {
            SharedPreferences sharedPreferences = this.bR;
            if (sharedPreferences != null) {
                return sharedPreferences.getInt(str, 0);
            }
            return 0;
        } catch (Throwable th) {
            a.a("SPResponse$getInt", th);
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
            a.a("SPResponse$putLong", th);
        }
    }

    public final void b(String str, int i) {
        try {
            SharedPreferences sharedPreferences = this.bR;
            if (sharedPreferences != null) {
                sharedPreferences.edit().putInt(str, i).apply();
            }
        } catch (Throwable th) {
            a.a("SPResponse$putInt", th);
        }
    }

    public final void d(String str, String str2) {
        try {
            SharedPreferences sharedPreferences = this.bR;
            if (sharedPreferences != null) {
                sharedPreferences.edit().putString(str, str2).apply();
            }
        } catch (Throwable th) {
            a.a("SPResponse$putString", th);
        }
    }
}

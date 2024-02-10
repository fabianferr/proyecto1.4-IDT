package com.startapp;

import android.content.SharedPreferences;
import java.util.UUID;

/* compiled from: Sta */
public class y3 {
    public final SharedPreferences a;
    public volatile String b;

    public y3(SharedPreferences sharedPreferences) {
        this.a = sharedPreferences;
    }

    public String a() {
        String str = this.b;
        if (str == null) {
            synchronized (this) {
                str = this.b;
                if (str == null) {
                    str = this.a.getString("e695c6d894060903", (String) null);
                    if (str == null) {
                        str = UUID.randomUUID().toString();
                        if (!this.a.edit().putString("e695c6d894060903", str).commit()) {
                            str = "00000000-0000-0000-0000-000000000000";
                        }
                    }
                    this.b = str;
                }
            }
        }
        return str;
    }
}

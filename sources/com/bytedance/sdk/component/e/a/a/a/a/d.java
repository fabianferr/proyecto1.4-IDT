package com.bytedance.sdk.component.e.a.a.a.a;

import android.content.Context;
import com.bytedance.sdk.component.e.a.a.e;
import com.bytedance.sdk.component.e.a.d.b.a;
import com.bytedance.sdk.component.e.a.i;

/* compiled from: HighPriorityAdEventRepoImpl */
public class d extends a {
    public byte c() {
        return 1;
    }

    public byte d() {
        return 0;
    }

    public d(Context context, a aVar) {
        super(context, aVar);
    }

    public String b() {
        e b = i.e().b();
        if (b != null) {
            return b.a();
        }
        return null;
    }

    public static String g() {
        return "CREATE TABLE IF NOT EXISTS " + i.e().b().a() + " (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,value TEXT ,gen_time TEXT , retry INTEGER default 0 , encrypt INTEGER default 0)";
    }
}

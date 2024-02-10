package com.bytedance.sdk.component.e.a.a.a.a;

import android.content.Context;
import com.bytedance.sdk.component.e.a.d.b.a;
import com.bytedance.sdk.component.e.a.i;

/* compiled from: StatsBatchLogEventRepoImpl */
public class f extends g {
    public byte a() {
        return 1;
    }

    public byte c() {
        return 3;
    }

    public f(Context context, a aVar) {
        super(context, aVar);
    }

    public String b() {
        return i.e().b().e();
    }

    public static String d() {
        return "CREATE TABLE IF NOT EXISTS " + i.e().b().e() + " (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,value TEXT ,gen_time TEXT , retry INTEGER default 0 , encrypt INTEGER default 0)";
    }
}

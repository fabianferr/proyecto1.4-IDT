package com.ironsource.b;

import android.util.Pair;
import com.ironsource.d.c;
import com.ironsource.environment.c.a;
import java.util.ArrayList;

public final class b implements Runnable {
    private d a;
    private String b;
    private String c;
    private ArrayList<a> d;

    public b(d dVar, String str, String str2, ArrayList<a> arrayList) {
        this.a = dVar;
        this.b = str;
        this.c = str2;
        this.d = arrayList;
    }

    public final void run() {
        boolean z = false;
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new Pair("Content-Type", "application/json"));
            c a2 = com.ironsource.d.b.a(this.c, this.b, arrayList);
            if (a2 != null && (a2.a == 200 || a2.a == 204)) {
                z = true;
            }
        } catch (Exception unused) {
        }
        d dVar = this.a;
        if (dVar != null) {
            dVar.a(this.d, z);
        }
    }
}

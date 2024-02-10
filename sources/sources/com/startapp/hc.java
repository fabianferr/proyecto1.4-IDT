package com.startapp;

import com.startapp.sb;
import java.util.Collections;
import java.util.HashSet;
import org.json.JSONObject;

/* compiled from: Sta */
public class hc extends kb {
    public hc(sb.b bVar, HashSet<String> hashSet, JSONObject jSONObject, long j) {
        super(bVar, hashSet, jSONObject, j);
    }

    public void a(String str) {
        db dbVar = db.c;
        if (dbVar != null) {
            for (T t : Collections.unmodifiableCollection(dbVar.a)) {
                if (this.c.contains(t.h)) {
                    t.e.a(str, this.e);
                }
            }
        }
        super.onPostExecute(str);
    }

    public Object doInBackground(Object[] objArr) {
        return this.d.toString();
    }
}

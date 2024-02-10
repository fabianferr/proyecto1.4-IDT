package com.startapp;

import android.text.TextUtils;
import com.startapp.sb;
import java.util.Collections;
import java.util.HashSet;
import org.json.JSONObject;

/* compiled from: Sta */
public class kc extends kb {
    public kc(sb.b bVar, HashSet<String> hashSet, JSONObject jSONObject, long j) {
        super(bVar, hashSet, jSONObject, j);
    }

    public void a(String str) {
        db dbVar;
        if (!TextUtils.isEmpty(str) && (dbVar = db.c) != null) {
            for (T t : Collections.unmodifiableCollection(dbVar.a)) {
                if (this.c.contains(t.h)) {
                    t.e.b(str, this.e);
                }
            }
        }
        super.onPostExecute(str);
    }

    public Object doInBackground(Object[] objArr) {
        if (rb.c(this.d, ((jb) this.b).a)) {
            return null;
        }
        sb.b bVar = this.b;
        JSONObject jSONObject = this.d;
        ((jb) bVar).a = jSONObject;
        return jSONObject.toString();
    }
}

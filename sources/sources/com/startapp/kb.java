package com.startapp;

import com.startapp.sb;
import java.util.HashSet;
import org.json.JSONObject;

/* compiled from: Sta */
public abstract class kb extends sb {
    public final HashSet<String> c;
    public final JSONObject d;
    public final long e;

    public kb(sb.b bVar, HashSet<String> hashSet, JSONObject jSONObject, long j) {
        super(bVar);
        this.c = new HashSet<>(hashSet);
        this.d = jSONObject;
        this.e = j;
    }

    public /* bridge */ /* synthetic */ void onPostExecute(Object obj) {
        onPostExecute((String) obj);
    }
}

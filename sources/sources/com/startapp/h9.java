package com.startapp;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Sta */
public abstract class h9<T> implements e9<List<T>> {
    private static final String LOG_TAG = "h9";
    private final Class<T> itemClass;

    /* compiled from: Sta */
    public class a implements g2<Integer, JSONObject> {
        public final /* synthetic */ Object a;

        public a(h9 h9Var, Object obj) {
            this.a = obj;
        }

        public Object a(Object obj) {
            try {
                return ((JSONArray) this.a).getJSONObject(((Integer) obj).intValue());
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* compiled from: Sta */
    public class b implements g2<Integer, JSONObject> {
        public final /* synthetic */ Object a;

        public b(h9 h9Var, Object obj) {
            this.a = obj;
        }

        public Object a(Object obj) {
            try {
                return ((JSONObject) this.a).getJSONObject(((Integer) obj).toString());
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public h9(Class<T> cls) {
        this.itemClass = cls;
    }

    public List<T> parse(Class<List<T>> cls, Object obj) {
        int i;
        g2 g2Var;
        if (obj instanceof JSONArray) {
            i = ((JSONArray) obj).length();
            g2Var = new a(this, obj);
        } else if (!(obj instanceof JSONObject)) {
            return null;
        } else {
            i = ((JSONObject) obj).length();
            g2Var = new b(this, obj);
        }
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            try {
                arrayList.add(e4.a(this.itemClass, (JSONObject) g2Var.a(Integer.valueOf(i2))));
            } catch (Throwable unused) {
            }
        }
        return arrayList;
    }
}

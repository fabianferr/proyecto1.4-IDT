package com.ironsource.environment;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class k {
    private static final String a = "k";
    private static final ArrayList<String> b = new ArrayList<String>() {
        {
            add("com.google.market");
            add("com.android.vending");
        }
    };

    enum a {
        GOOGLE_PLAY(2, new String[]{"com.android.vending"}),
        GOOGLE_MARKET(4, new String[]{"com.google.market"}),
        SAMSUNG(5, new String[]{"com.sec.android.app.samsungapps"}),
        AMAZON(6, new String[]{"com.amazon.venezia"}),
        HUAWEI(7, new String[]{"com.huawei.appmarket"});
        
        private static final Map<String, a> h = null;
        /* access modifiers changed from: private */
        public final int f;
        /* access modifiers changed from: private */
        public final String[] g;

        static {
            h = new HashMap();
            for (a aVar : values()) {
                for (String put : aVar.g) {
                    h.put(put, aVar);
                }
            }
        }

        private a(int i2, String[] strArr) {
            this.f = i2;
            this.g = strArr;
        }
    }

    private static JSONObject a(Context context, ArrayList<String> arrayList) {
        JSONObject jSONObject = new JSONObject();
        try {
            ArrayList<String> c = c(context);
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                final boolean contains = c.contains(next.trim().toLowerCase());
                jSONObject.put(next, new JSONObject() {
                    {
                        put("isInstalled", contains);
                    }
                });
            }
        } catch (Exception unused) {
            Log.d(a, "Error while extracting packages installation data");
        }
        return jSONObject;
    }

    public static boolean a(Context context) {
        JSONObject a2 = a(context, b);
        Iterator<String> keys = a2.keys();
        while (keys.hasNext()) {
            JSONObject optJSONObject = a2.optJSONObject(keys.next());
            if (optJSONObject != null && optJSONObject.optBoolean("isInstalled")) {
                return true;
            }
        }
        return false;
    }

    public static Integer b(Context context) {
        JSONObject a2 = a(context, a.a());
        int i = 0;
        for (a aVar : a.values()) {
            String[] a3 = aVar.g;
            int length = a3.length;
            int i2 = 0;
            while (true) {
                if (i2 < length) {
                    JSONObject optJSONObject = a2.optJSONObject(a3[i2]);
                    if (optJSONObject != null && optJSONObject.optBoolean("isInstalled")) {
                        double d = (double) i;
                        double pow = Math.pow(2.0d, (double) (aVar.f - 1));
                        Double.isNaN(d);
                        i = (int) (d + pow);
                        break;
                    }
                    i2++;
                } else {
                    break;
                }
            }
        }
        return Integer.valueOf(i);
    }

    private static ArrayList<String> c(Context context) {
        List<ApplicationInfo> p = h.p(context);
        ArrayList<String> arrayList = new ArrayList<>();
        for (ApplicationInfo next : p) {
            if (next != null) {
                arrayList.add(next.packageName.toLowerCase());
            }
        }
        return arrayList;
    }
}

package com.mbridge.msdk.foundation.same.report;

import android.text.TextUtils;
import com.mbridge.msdk.c.e;
import com.mbridge.msdk.foundation.tools.aa;
import org.json.JSONArray;

/* compiled from: DomainReport */
public class g {
    private static String a = "DomainReport";

    public static boolean a(e eVar, String str) {
        if (eVar == null) {
            return true;
        }
        try {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            int aq = eVar.aq();
            JSONArray w = eVar.w();
            JSONArray x = eVar.x();
            if (x != null) {
                for (int i = 0; i < x.length(); i++) {
                    if (str.contains(x.getString(i))) {
                        return false;
                    }
                }
            }
            if (aq != 2) {
                return true;
            }
            if (w != null) {
                for (int i2 = 0; i2 < w.length(); i2++) {
                    if (str.contains(w.getString(i2))) {
                        return true;
                    }
                }
            }
            return false;
        } catch (Exception e) {
            aa.d(a, e.getMessage());
            return true;
        }
    }
}

package com.bytedance.sdk.openadsdk.n;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.core.j;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.utils.ac;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: TrackAdUrlUtils */
public class a {
    private static int a(int i) {
        int i2 = 2;
        if (i != 2) {
            i2 = 3;
            if (i != 3) {
                i2 = 4;
                if (i != 4) {
                    i2 = 5;
                    if (i == 5 || i == 15) {
                        return i2;
                    }
                    return -1;
                }
            }
        }
        return i2;
    }

    public static List<String> a(List<String> list, boolean z) {
        String a = j.a(o.a());
        if (list == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (next.contains("{TS}") || next.contains("__TS__")) {
                long currentTimeMillis = System.currentTimeMillis();
                next = next.replace("{TS}", String.valueOf(currentTimeMillis)).replace("__TS__", String.valueOf(currentTimeMillis));
            }
            if ((next.contains("{UID}") || next.contains("__UID__")) && !TextUtils.isEmpty(a)) {
                next = next.replace("{UID}", a).replace("__UID__", a);
            }
            if (z) {
                next = a(next);
            }
            arrayList.add(next);
        }
        return arrayList;
    }

    private static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            return str.replace("[ss_random]", String.valueOf(new SecureRandom().nextLong())).replace("[ss_timestamp]", String.valueOf(System.currentTimeMillis()));
        } catch (Exception e) {
            l.e("TrackAdUrlUtils", e.getMessage());
            return str;
        }
    }

    public static List<String> a(List<String> list, boolean z, q qVar) {
        String a = j.a(o.a());
        if (list == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (next.contains("{TS}") || next.contains("__TS__")) {
                long currentTimeMillis = System.currentTimeMillis();
                next = next.replace("{TS}", String.valueOf(currentTimeMillis)).replace("__TS__", String.valueOf(currentTimeMillis));
            }
            if ((next.contains("{UID}") || next.contains("__UID__")) && !TextUtils.isEmpty(a)) {
                next = next.replace("{UID}", a).replace("__UID__", a);
            }
            if (next.contains("__CID__") && qVar != null && !TextUtils.isEmpty(qVar.Y())) {
                next = next.replace("__CID__", qVar.Y());
            }
            if (next.contains("__CTYPE__") && qVar != null) {
                next = next.replace("__CTYPE__", String.valueOf(a(qVar.ad())));
            }
            if (next.contains("__GAID__")) {
                next = next.replace("__GAID__", com.com.bytedance.overseas.sdk.b.a.a().b());
            }
            if (next.contains("__OS__")) {
                next = next.replace("__OS__", "0");
            }
            if (next.contains("__UA1__")) {
                next = next.replace("__UA1__", URLEncoder.encode(ac.c()));
            }
            if (z) {
                next = a(next);
            }
            arrayList.add(next);
        }
        return arrayList;
    }
}

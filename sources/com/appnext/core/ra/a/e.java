package com.appnext.core.ra.a;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.appnext.core.ra.database.RecentAppsDatabase;
import com.appnext.core.ra.database.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import org.json.JSONArray;

public class e extends b {
    /* access modifiers changed from: protected */
    public final boolean ao() {
        return true;
    }

    public e(Context context, Bundle bundle) {
        super(context, bundle);
    }

    /* access modifiers changed from: protected */
    public final void an() {
        try {
            Bundle aq = aq();
            if (aq != null) {
                String string = aq.getString("more_data");
                if (!TextUtils.isEmpty(string)) {
                    JSONArray jSONArray = new JSONArray(string);
                    if (jSONArray.length() > 0) {
                        ArrayList arrayList = new ArrayList();
                        String format = ar().format(new Date());
                        int length = jSONArray.length();
                        for (int i = 0; i < length; i++) {
                            String string2 = jSONArray.getString(i);
                            if (string2.matches("^[a-z][a-z0-9_]*(\\.[a-z0-9_]+)+[0-9a-z_]$")) {
                                a aVar = new a();
                                aVar.eh = string2;
                                aVar.ei = format;
                                aVar.ej = false;
                                arrayList.add(aVar);
                            }
                        }
                        long[] a = RecentAppsDatabase.getInstance(getContext()).recentAppDao().a(arrayList);
                        if (a != null) {
                            Arrays.toString(a);
                        }
                        RecentAppsDatabase.getInstance(getContext()).recentAppDao().as().toString();
                    }
                }
            }
        } catch (Throwable th) {
            com.appnext.base.a.a("StoreRecentAppsAction$doUniqueAction", th);
        }
    }
}

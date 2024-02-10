package com.startapp;

import android.content.Context;
import com.startapp.sdk.adsbase.AdsCommonMetaData;
import com.startapp.sdk.adsbase.SimpleTokenUtils;
import com.startapp.sdk.adsbase.apppresence.AppPresenceDetails;
import com.startapp.sdk.adsbase.model.AdDetails;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/* compiled from: Sta */
public class d0 {
    public static List<AdDetails> a(Context context, List<AdDetails> list, int i, Set<String> set, boolean z) {
        Context context2 = context;
        int i2 = i;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        boolean z2 = false;
        for (AdDetails next : list) {
            ArrayList arrayList5 = (ArrayList) k9.a((List<String>) Arrays.asList(next.w()));
            AppPresenceDetails appPresenceDetails = new AppPresenceDetails(arrayList5.isEmpty() ? null : (String) arrayList5.get(0), next.c(), i2, next.o());
            boolean z3 = next.c() != null && next.c().startsWith("!");
            boolean a = a0.a(context, z3 ? next.c().substring(1) : next.c(), next.o());
            boolean z4 = AdsCommonMetaData.h.H() && ((a && !z3) || (!a && z3));
            arrayList3.add(appPresenceDetails);
            if (z4) {
                appPresenceDetails.a(a);
                appPresenceDetails.b(false);
                if (!z3) {
                    arrayList2.add(next);
                    arrayList4.add(appPresenceDetails);
                }
                set.add(next.p());
                z2 = true;
            } else {
                Set<String> set2 = set;
                arrayList.add(next);
            }
        }
        if (arrayList.size() < 5 && (list.size() != 1 || i2 > 0)) {
            int min = Math.min(5 - arrayList.size(), arrayList2.size());
            arrayList.addAll(arrayList2.subList(0, min));
            for (AppPresenceDetails b : arrayList4.subList(0, min)) {
                b.b(true);
            }
        }
        if (z2) {
            SimpleTokenUtils.f(context);
            if (z) {
                new c0(context, arrayList3).a();
            }
        }
        return arrayList;
    }

    public static List<AppPresenceDetails> a(String str, int i) {
        ArrayList arrayList = new ArrayList();
        String[] strArr = new String[0];
        String a = k9.a(str, "@tracking@", "@tracking@");
        if (a != null) {
            strArr = a.split(",");
        }
        String[] strArr2 = new String[0];
        String a2 = k9.a(str, "@appPresencePackage@", "@appPresencePackage@");
        if (a2 != null) {
            strArr2 = a2.split(",");
        }
        String[] strArr3 = new String[0];
        String a3 = k9.a(str, "@minAppVersion@", "@minAppVersion@");
        if (a3 != null) {
            strArr3 = a3.split(",");
        }
        int i2 = 0;
        while (i2 < strArr2.length) {
            arrayList.add(new AppPresenceDetails(strArr.length > i2 ? strArr[i2] : null, strArr2[i2], i, strArr3.length > i2 ? Integer.valueOf(strArr3[i2]).intValue() : 0));
            i2++;
        }
        while (i2 < strArr.length) {
            arrayList.add(new AppPresenceDetails(strArr[i2], "", i, strArr3.length > i2 ? Integer.valueOf(strArr3[i2]).intValue() : 0));
            i2++;
        }
        return arrayList;
    }

    public static Boolean a(Context context, List<AppPresenceDetails> list, int i, Set<String> set, List<AppPresenceDetails> list2) {
        boolean z = false;
        for (AppPresenceDetails next : list) {
            boolean startsWith = next.b().startsWith("!");
            boolean a = a0.a(context, startsWith ? next.b().substring(1) : next.b(), next.a());
            if ((!startsWith && a) || (startsWith && !a)) {
                next.a(a);
                z = i == 0;
                if (z && !startsWith) {
                    set.add(next.b());
                } else if (!z && next.c() != null) {
                    next.a(next.c() + "&isShown=" + next.e() + "&appPresence=" + next.d());
                }
            }
            list2.add(next);
        }
        if (z) {
            for (int i2 = 0; i2 < list2.size(); i2++) {
                list2.get(i2).b(false);
            }
        }
        return Boolean.valueOf(z);
    }
}

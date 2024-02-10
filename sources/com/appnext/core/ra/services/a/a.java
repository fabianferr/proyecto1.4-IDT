package com.appnext.core.ra.services.a;

import android.content.Context;
import android.os.Bundle;
import com.appnext.core.ra.services.a;
import com.facebook.internal.NativeProtocol;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

public abstract class a {
    private Context aM;

    /* access modifiers changed from: protected */
    public abstract boolean A(String str);

    /* access modifiers changed from: protected */
    public abstract void B(String str);

    /* access modifiers changed from: protected */
    public abstract void a(com.appnext.core.ra.b.a aVar);

    /* access modifiers changed from: protected */
    public abstract void c(List<com.appnext.core.ra.b.a> list);

    public a(Context context) {
        this.aM = context;
    }

    public final void b(long j) {
        a.C0026a aVar = a.C0026a.SendRA;
        a(new com.appnext.core.ra.b.a(aVar, aVar.hashCode(), a(aVar), j, 120000, true));
    }

    public final void d(ArrayList<String> arrayList) {
        try {
            a.C0026a aVar = a.C0026a.StoreRa;
            Bundle a = a(aVar);
            if (arrayList != null && !arrayList.isEmpty()) {
                JSONArray jSONArray = new JSONArray();
                Iterator<String> it = arrayList.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next());
                }
                a.putString("more_data", jSONArray.toString());
            }
            com.appnext.core.ra.b.a aVar2 = new com.appnext.core.ra.b.a(aVar, aVar.hashCode() + ((int) (System.currentTimeMillis() % 7)), a, 0, 0, false);
            if (A(a.C0026a.DownloadingConfig.name())) {
                a(aVar2);
                return;
            }
            a.C0026a aVar3 = a.C0026a.DownloadingConfig;
            com.appnext.core.ra.b.a aVar4 = new com.appnext.core.ra.b.a(aVar3, aVar3.hashCode(), a(aVar3), 0, 0, false);
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(aVar4);
            arrayList2.add(aVar2);
            c((List<com.appnext.core.ra.b.a>) arrayList2);
        } catch (Throwable th) {
            com.appnext.base.a.a("RecentAppsServiceLogic$storeRA", th);
        }
    }

    public final void ax() {
        B(a.C0026a.SendRA.name());
    }

    public final void c(long j) {
        try {
            a.C0026a aVar = a.C0026a.DownloadingConfig;
            a(new com.appnext.core.ra.b.a(aVar, aVar.hashCode(), a(aVar), j, j, true));
        } catch (Throwable th) {
            com.appnext.base.a.a("RecentAppsServiceLogic$scheduleDownloadingConfig", th);
        }
    }

    private static Bundle a(a.C0026a aVar) {
        Bundle bundle = new Bundle();
        bundle.putInt(NativeProtocol.WEB_DIALOG_ACTION, aVar.ordinal());
        return bundle;
    }

    /* access modifiers changed from: protected */
    public final Context getContext() {
        return this.aM;
    }
}

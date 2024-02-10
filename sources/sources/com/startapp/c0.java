package com.startapp;

import android.content.Context;
import android.net.Uri;
import com.facebook.internal.ServerProtocol;
import com.startapp.sdk.adsbase.apppresence.AppPresenceDetails;
import com.startapp.sdk.adsbase.commontracking.TrackingParams;
import com.startapp.sdk.components.ComponentLocator;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Sta */
public class c0 {
    public final Context a;
    public final List<AppPresenceDetails> b;
    public final Runnable c = new a();

    /* compiled from: Sta */
    public class a implements Runnable {
        public a() {
        }

        public void run() {
            c0 c0Var = c0.this;
            c0Var.getClass();
            try {
                h3.a(c0Var.a, c0Var.a(c0Var.b), new TrackingParams().a("APP_PRESENCE"));
            } catch (Throwable th) {
                i3.a(th);
            }
        }
    }

    public c0(Context context, List<AppPresenceDetails> list) {
        this.b = list;
        this.a = context;
    }

    public void a() {
        ComponentLocator.a(this.a).r().execute(this.c);
    }

    public final List<String> a(List<AppPresenceDetails> list) {
        String c2;
        String str;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (AppPresenceDetails next : list) {
            if (!next.e() && (c2 = next.c()) != null) {
                try {
                    str = Uri.parse(c2).getQueryParameter("d");
                } catch (Throwable th) {
                    i3.a(th);
                    str = null;
                }
                if (str != null) {
                    if (next.d()) {
                        arrayList2.add("d=" + str);
                    } else {
                        arrayList3.add("d=" + str);
                    }
                }
            }
        }
        if (!arrayList2.isEmpty()) {
            arrayList.addAll(com.startapp.sdk.adsbase.a.a((List<String>) arrayList2, "false", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE));
        }
        if (!arrayList3.isEmpty()) {
            arrayList.addAll(com.startapp.sdk.adsbase.a.a((List<String>) arrayList3, "false", "false"));
        }
        return arrayList;
    }
}

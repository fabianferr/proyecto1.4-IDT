package com.appnext.core.ra.services;

import android.content.Context;
import com.appnext.core.ra.services.a.b;
import java.util.ArrayList;

public class a {
    private static a ev;
    private com.appnext.core.ra.services.a.a ew;

    /* renamed from: com.appnext.core.ra.services.a$a  reason: collision with other inner class name */
    public enum C0026a {
        DownloadingConfig,
        SendRA,
        StoreRa
    }

    public static a p(Context context) {
        if (ev == null) {
            synchronized (a.class) {
                if (ev == null) {
                    ev = new a(context);
                }
            }
        }
        return ev;
    }

    private a(Context context) {
        try {
            this.ew = new b(context);
        } catch (Throwable unused) {
        }
    }

    public final void d(ArrayList<String> arrayList) {
        if (arrayList != null) {
            try {
                if (!arrayList.isEmpty()) {
                    this.ew.d(arrayList);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public final void a(long j) {
        try {
            this.ew.c(j * 60000);
        } catch (Throwable unused) {
        }
    }

    public final void b(long j) {
        try {
            this.ew.b(j * 60000);
        } catch (Throwable unused) {
        }
    }

    public final void ax() {
        try {
            this.ew.ax();
        } catch (Throwable unused) {
        }
    }
}

package com.appnext.core;

import android.os.Handler;
import android.os.Looper;
import com.appnext.core.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public final class a {
    private ArrayList<?> ads = null;
    private Long bU = 0L;
    /* access modifiers changed from: private */
    public ArrayList<d.a> bV = new ArrayList<>();
    private String bW = "";
    private int m = 0;
    private String placementID;

    public final void a(d.a aVar) {
        try {
            synchronized (this.bV) {
                ListIterator<d.a> listIterator = this.bV.listIterator();
                if (!(aVar == null || listIterator == null)) {
                    listIterator.add(aVar);
                }
            }
        } catch (Throwable th) {
            com.appnext.base.a.a("AdContainer$addListener", th);
        }
    }

    public final Long O() {
        return this.bU;
    }

    public final ArrayList<?> getAds() {
        try {
            if (this.ads == null) {
                return null;
            }
            ArrayList<?> arrayList = new ArrayList<>();
            Iterator<?> it = this.ads.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
            return arrayList;
        } catch (Throwable unused) {
            return new ArrayList<>();
        }
    }

    public final void setPlacementID(String str) {
        this.placementID = str;
    }

    public final int P() {
        return this.m;
    }

    public final String getPlacementID() {
        return this.placementID;
    }

    public final void b(int i) {
        this.m = i;
    }

    public final void c(ArrayList<?> arrayList) {
        a(arrayList, true);
    }

    public final void a(ArrayList<?> arrayList, boolean z) {
        this.ads = arrayList;
        if (z) {
            this.bU = Long.valueOf(System.currentTimeMillis());
        }
    }

    public final String w() {
        return this.bW;
    }

    public final void k(String str) {
        this.bW = str;
    }

    public final synchronized void l(final String str) {
        try {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public final void run() {
                    try {
                        synchronized (a.this.bV) {
                            ListIterator listIterator = a.this.bV.listIterator();
                            while (listIterator.hasNext()) {
                                ((d.a) listIterator.next()).error(str);
                                listIterator.remove();
                            }
                        }
                    } catch (Throwable th) {
                        com.appnext.base.a.a("AdContainer$notifyListenersError", th);
                    }
                }
            });
        } catch (Throwable th) {
            com.appnext.base.a.a("AdContainer$notifyListenersError", th);
        }
    }
}

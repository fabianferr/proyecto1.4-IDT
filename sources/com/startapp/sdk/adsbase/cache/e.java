package com.startapp.sdk.adsbase.cache;

import com.startapp.sdk.adsbase.cache.h;
import java.util.Iterator;

/* compiled from: Sta */
public class e implements h.b {
    public final /* synthetic */ d a;

    public e(d dVar) {
        this.a = dVar;
    }

    public void a(h hVar) {
        synchronized (this.a.a) {
            Iterator<h> it = this.a.a.values().iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next() == hVar) {
                        it.remove();
                        break;
                    }
                } else {
                    break;
                }
            }
        }
    }
}

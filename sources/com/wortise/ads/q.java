package com.wortise.ads;

import com.google.android.gms.ads.AdSize;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u001a$\u0010\u0005\u001a\u0004\u0018\u00010\u0001*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0000*\f\b\u0000\u0010\u0006\"\u00020\u00012\u00020\u0001¨\u0006\u0007"}, d2 = {"", "Lcom/google/android/gms/ads/AdSize;", "", "width", "height", "a", "GoogleAdSize", "sdk_productionRelease"}, k = 2, mv = {1, 5, 1})
/* compiled from: AdSize.kt */
public final class q {
    public static final AdSize a(Collection<AdSize> collection, int i, int i2) {
        T t;
        boolean z;
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Iterator<T> it = collection.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            AdSize adSize = (AdSize) t;
            if (adSize.getWidth() > i || adSize.getHeight() > i2) {
                z = false;
                continue;
            } else {
                z = true;
                continue;
            }
            if (z) {
                break;
            }
        }
        return (AdSize) t;
    }
}

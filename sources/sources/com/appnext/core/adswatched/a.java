package com.appnext.core.adswatched;

import android.content.Context;
import android.text.TextUtils;
import com.appnext.core.adswatched.database.AdWatched;
import com.appnext.core.adswatched.database.AdWatchedDatabase;
import java.util.ArrayList;
import java.util.List;

public final class a {
    private static a dL;
    private Context aM;

    public static a l(Context context) {
        if (dL == null) {
            synchronized (com.appnext.core.ra.services.a.class) {
                if (dL == null) {
                    dL = new a(context);
                }
            }
        }
        return dL;
    }

    private a(Context context) {
        try {
            this.aM = context.getApplicationContext();
        } catch (Throwable unused) {
        }
    }

    public final void j(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                AdWatched adWatched = new AdWatched();
                adWatched.bannerId = str;
                adWatched.auid = str2;
                adWatched.toString();
                AdWatchedDatabase.getInstance(this.aM).adWatchedDao().a(adWatched);
            }
        } catch (Throwable th) {
            com.appnext.base.a.a("AdsWatchedManager$setBannerWatched", th);
        }
    }

    public final List<String> w(String str) {
        try {
            List<String> x = AdWatchedDatabase.getInstance(this.aM).adWatchedDao().x(str);
            x.toString();
            return x;
        } catch (Throwable th) {
            com.appnext.base.a.a("AdsWatchedManager$getAdsWatchedIdsByPlacement", th);
            return new ArrayList();
        }
    }

    public final void k(String str, String str2) {
        try {
            AdWatchedDatabase.getInstance(this.aM).adWatchedDao().y(str2);
        } catch (Throwable unused) {
        }
    }
}

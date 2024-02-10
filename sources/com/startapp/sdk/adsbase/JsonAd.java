package com.startapp.sdk.adsbase;

import android.content.Context;
import com.startapp.sdk.adsbase.model.AdDetails;
import com.startapp.sdk.adsbase.model.AdPreferences;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* compiled from: Sta */
public abstract class JsonAd extends Ad {
    private static final long serialVersionUID = 4523075381486005923L;
    private List<AdDetails> adsDetails = null;

    public JsonAd(Context context, AdPreferences.Placement placement) {
        super(context, placement);
    }

    public void a(List<AdDetails> list) {
        boolean z;
        this.adsDetails = list;
        Long l = null;
        for (AdDetails next : list) {
            if (!(next == null || next.x() == null)) {
                if (l == null || next.x().longValue() < l.longValue()) {
                    l = next.x();
                }
            }
        }
        if (l != null) {
            this.adCacheTtl = Long.valueOf(TimeUnit.SECONDS.toMillis(l.longValue()));
        }
        Iterator<AdDetails> it = this.adsDetails.iterator();
        while (true) {
            if (it.hasNext()) {
                if (!it.next().n()) {
                    z = false;
                    break;
                }
            } else {
                z = true;
                break;
            }
        }
        this.belowMinCPM = z;
    }

    public List<AdDetails> g() {
        return this.adsDetails;
    }

    public String getAdId() {
        List<AdDetails> list = this.adsDetails;
        if (list == null || list.size() <= 0) {
            return null;
        }
        return this.adsDetails.get(0).a();
    }

    public String getBidToken() {
        List<AdDetails> list = this.adsDetails;
        if (list == null || list.size() <= 0) {
            return null;
        }
        return this.adsDetails.get(0).d();
    }

    public String getDParam() {
        List<AdDetails> list = this.adsDetails;
        if (list == null) {
            return null;
        }
        try {
            String str = null;
            for (AdDetails next : list) {
                try {
                    if (next != null) {
                        String g = next.g();
                        String[] u = next.u();
                        str = a.a(g, (u == null || u.length <= 0) ? null : u[0]);
                        if (str != null) {
                            break;
                        }
                    }
                } catch (Throwable unused) {
                }
            }
            return str;
        } catch (Throwable unused2) {
            return null;
        }
    }
}

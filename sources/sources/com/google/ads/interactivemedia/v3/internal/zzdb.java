package com.google.ads.interactivemedia.v3.internal;

import android.os.AsyncTask;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public abstract class zzdb extends AsyncTask {
    private zzdc zza;
    protected final zzct zzd;

    public zzdb(zzct zzct) {
        this.zzd = zzct;
    }

    /* access modifiers changed from: protected */
    /* renamed from: zza */
    public void onPostExecute(String str) {
        zzdc zzdc = this.zza;
        if (zzdc != null) {
            zzdc.zza(this);
        }
    }

    public final void zzb(zzdc zzdc) {
        this.zza = zzdc;
    }
}

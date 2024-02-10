package com.google.ads.interactivemedia.v3.internal;

import android.text.TextUtils;
import com.google.ads.interactivemedia.omid.library.adsession.zze;
import java.util.HashSet;
import org.json.JSONObject;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzdf extends zzda {
    public zzdf(zzct zzct, HashSet hashSet, JSONObject jSONObject, long j) {
        super(zzct, hashSet, jSONObject, j);
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ Object doInBackground(Object[] objArr) {
        if (zzcn.zzg(this.zzb, this.zzd.zza())) {
            return null;
        }
        this.zzd.zze(this.zzb);
        return this.zzb.toString();
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ void onPostExecute(Object obj) {
        onPostExecute((String) obj);
    }

    /* access modifiers changed from: protected */
    public final void zza(String str) {
        zzbx zza;
        if (!TextUtils.isEmpty(str) && (zza = zzbx.zza()) != null) {
            for (zze zze : zza.zzc()) {
                if (this.zza.contains(zze.zzi())) {
                    zze.zzh().zze(str, this.zzc);
                }
            }
        }
        super.onPostExecute(str);
    }
}

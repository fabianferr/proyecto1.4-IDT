package com.google.ads.interactivemedia.v3.internal;

import android.os.Build;
import android.webkit.WebView;
import com.google.ads.interactivemedia.omid.library.adsession.zzc;
import com.google.ads.interactivemedia.omid.library.adsession.zze;
import com.google.ads.interactivemedia.omid.library.adsession.zzj;
import com.mbridge.msdk.MBridgeConstans;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public class zzcj {
    private zzdh zza = new zzdh((WebView) null);
    private long zzb;
    private int zzc;

    public zzcj() {
        zzb();
    }

    public final WebView zza() {
        return (WebView) this.zza.get();
    }

    public final void zzb() {
        this.zzb = System.nanoTime();
        this.zzc = 1;
    }

    public void zzc() {
        this.zza.clear();
    }

    public final void zzd(String str, long j) {
        if (j >= this.zzb && this.zzc != 3) {
            this.zzc = 3;
            zzcc.zza().zzf(zza(), str);
        }
    }

    public final void zze(String str, long j) {
        if (j >= this.zzb) {
            this.zzc = 2;
            zzcc.zza().zzf(zza(), str);
        }
    }

    public void zzf(zze zze, zzc zzc2) {
        zzg(zze, zzc2, (JSONObject) null);
    }

    /* access modifiers changed from: protected */
    public final void zzg(zze zze, zzc zzc2, JSONObject jSONObject) {
        String zzi = zze.zzi();
        JSONObject jSONObject2 = new JSONObject();
        zzcn.zze(jSONObject2, "environment", MBridgeConstans.DYNAMIC_VIEW_WX_APP);
        zzcn.zze(jSONObject2, "adSessionType", zzc2.zzc());
        JSONObject jSONObject3 = new JSONObject();
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        zzcn.zze(jSONObject3, "deviceType", str + "; " + str2);
        zzcn.zze(jSONObject3, "osVersion", Integer.toString(Build.VERSION.SDK_INT));
        zzcn.zze(jSONObject3, "os", "Android");
        zzcn.zze(jSONObject2, "deviceInfo", jSONObject3);
        JSONArray jSONArray = new JSONArray();
        jSONArray.put("clid");
        jSONArray.put("vlid");
        zzcn.zze(jSONObject2, "supports", jSONArray);
        JSONObject jSONObject4 = new JSONObject();
        zzcn.zze(jSONObject4, "partnerName", zzc2.zzd().zzb());
        zzcn.zze(jSONObject4, "partnerVersion", zzc2.zzd().zzc());
        zzcn.zze(jSONObject2, "omidNativeInfo", jSONObject4);
        JSONObject jSONObject5 = new JSONObject();
        zzcn.zze(jSONObject5, "libraryVersion", "1.3.37-google_20220829");
        zzcn.zze(jSONObject5, "appId", zzca.zzb().zza().getApplicationContext().getPackageName());
        zzcn.zze(jSONObject2, MBridgeConstans.DYNAMIC_VIEW_WX_APP, jSONObject5);
        if (zzc2.zze() != null) {
            zzcn.zze(jSONObject2, "contentUrl", zzc2.zze());
        }
        zzcn.zze(jSONObject2, "customReferenceData", zzc2.zzf());
        JSONObject jSONObject6 = new JSONObject();
        Iterator it = zzc2.zzg().iterator();
        if (!it.hasNext()) {
            zzcc.zza().zzg(zza(), zzi, jSONObject2, jSONObject6, jSONObject);
        } else {
            zzj zzj = (zzj) it.next();
            throw null;
        }
    }

    public final void zzh(float f) {
        zzcc.zza().zze(zza(), f);
    }

    /* access modifiers changed from: package-private */
    public final void zzi(WebView webView) {
        this.zza = new zzdh(webView);
    }

    public void zzj() {
    }

    public final boolean zzk() {
        return this.zza.get() != null;
    }
}

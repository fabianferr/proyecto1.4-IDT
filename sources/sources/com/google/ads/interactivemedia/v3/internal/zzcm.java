package com.google.ads.interactivemedia.v3.internal;

import android.os.Handler;
import android.text.TextUtils;
import android.webkit.WebView;
import com.google.ads.interactivemedia.omid.library.adsession.zzc;
import com.google.ads.interactivemedia.omid.library.adsession.zze;
import com.google.ads.interactivemedia.omid.library.adsession.zzj;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzcm extends zzcj {
    /* access modifiers changed from: private */
    public WebView zza;
    private Long zzb = null;
    private final Map zzc;

    public zzcm(Map map, String str) {
        this.zzc = map;
    }

    public final void zzc() {
        long j;
        super.zzc();
        if (this.zzb == null) {
            j = 4000;
        } else {
            j = TimeUnit.MILLISECONDS.convert(System.nanoTime() - this.zzb.longValue(), TimeUnit.NANOSECONDS);
        }
        new Handler().postDelayed(new zzcl(this), Math.max(4000 - j, 2000));
        this.zza = null;
    }

    public final void zzf(zze zze, zzc zzc2) {
        JSONObject jSONObject = new JSONObject();
        Map zzh = zzc2.zzh();
        for (String str : zzh.keySet()) {
            zzcn.zze(jSONObject, str, (zzj) zzh.get(str));
        }
        zzg(zze, zzc2, jSONObject);
    }

    public final void zzj() {
        WebView webView = new WebView(zzca.zzb().zza());
        this.zza = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        zzi(this.zza);
        WebView webView2 = this.zza;
        if (webView2 != null && !TextUtils.isEmpty((CharSequence) null)) {
            webView2.loadUrl("javascript: null");
        }
        Iterator it = this.zzc.keySet().iterator();
        if (!it.hasNext()) {
            this.zzb = Long.valueOf(System.nanoTime());
            return;
        }
        zzj zzj = (zzj) this.zzc.get((String) it.next());
        throw null;
    }
}

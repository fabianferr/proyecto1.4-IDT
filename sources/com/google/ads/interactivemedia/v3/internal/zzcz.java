package com.google.ads.interactivemedia.v3.internal;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.google.ads.interactivemedia.omid.library.adsession.zze;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzcz implements zzce {
    private static final zzcz zza = new zzcz();
    private static final Handler zzb = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */
    public static Handler zzc = null;
    /* access modifiers changed from: private */
    public static final Runnable zzd = new zzcv();
    /* access modifiers changed from: private */
    public static final Runnable zze = new zzcw();
    private final List zzf = new ArrayList();
    private int zzg;
    private boolean zzh = false;
    private final List zzi = new ArrayList();
    private final zzcg zzj = new zzcg();
    private final zzcs zzk = new zzcs();
    /* access modifiers changed from: private */
    public final zzct zzl = new zzct(new zzdc());
    private long zzm;

    zzcz() {
    }

    public static zzcz zzd() {
        return zza;
    }

    static /* bridge */ /* synthetic */ void zzg(zzcz zzcz) {
        zzcz.zzg = 0;
        zzcz.zzi.clear();
        zzcz.zzh = false;
        for (zze zze2 : zzbx.zza().zzb()) {
        }
        zzcz.zzm = System.nanoTime();
        zzcz.zzk.zzi();
        long nanoTime = System.nanoTime();
        zzcf zza2 = zzcz.zzj.zza();
        if (zzcz.zzk.zze().size() > 0) {
            Iterator it = zzcz.zzk.zze().iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                JSONObject zza3 = zzcn.zza(0, 0, 0, 0);
                View zza4 = zzcz.zzk.zza(str);
                zzcf zzb2 = zzcz.zzj.zzb();
                String zzc2 = zzcz.zzk.zzc(str);
                if (zzc2 != null) {
                    JSONObject zza5 = zzb2.zza(zza4);
                    zzcn.zzb(zza5, str);
                    try {
                        zza5.put("notVisibleReason", zzc2);
                    } catch (JSONException e) {
                        zzco.zza("Error with setting not visible reason", e);
                    }
                    zzcn.zzc(zza3, zza5);
                }
                zzcn.zzf(zza3);
                HashSet hashSet = new HashSet();
                hashSet.add(str);
                zzcz.zzl.zzc(zza3, hashSet, nanoTime);
            }
        }
        if (zzcz.zzk.zzf().size() > 0) {
            JSONObject zza6 = zzcn.zza(0, 0, 0, 0);
            zzcz.zzk((View) null, zza2, zza6, 1, false);
            zzcn.zzf(zza6);
            zzcz.zzl.zzd(zza6, zzcz.zzk.zzf(), nanoTime);
            boolean z = zzcz.zzh;
        } else {
            zzcz.zzl.zzb();
        }
        zzcz.zzk.zzg();
        long nanoTime2 = System.nanoTime() - zzcz.zzm;
        if (zzcz.zzf.size() > 0) {
            for (zzcy zzcy : zzcz.zzf) {
                int i = zzcz.zzg;
                TimeUnit.NANOSECONDS.toMillis(nanoTime2);
                zzcy.zzb();
                if (zzcy instanceof zzcx) {
                    int i2 = zzcz.zzg;
                    ((zzcx) zzcy).zza();
                }
            }
        }
    }

    private final void zzk(View view, zzcf zzcf, JSONObject jSONObject, int i, boolean z) {
        zzcf.zzb(view, jSONObject, this, i == 1, z);
    }

    private static final void zzl() {
        Handler handler = zzc;
        if (handler != null) {
            handler.removeCallbacks(zze);
            zzc = null;
        }
    }

    public final void zza(View view, zzcf zzcf, JSONObject jSONObject, boolean z) {
        int zzk2;
        boolean z2;
        if (zzcq.zzb(view) == null && (zzk2 = this.zzk.zzk(view)) != 3) {
            JSONObject zza2 = zzcf.zza(view);
            zzcn.zzc(jSONObject, zza2);
            String zzd2 = this.zzk.zzd(view);
            if (zzd2 != null) {
                zzcn.zzb(zza2, zzd2);
                try {
                    zza2.put("hasWindowFocus", Boolean.valueOf(this.zzk.zzj(view)));
                } catch (JSONException e) {
                    zzco.zza("Error with setting not visible reason", e);
                }
                this.zzk.zzh();
            } else {
                zzcr zzb2 = this.zzk.zzb(view);
                if (zzb2 != null) {
                    zzbz zza3 = zzb2.zza();
                    JSONArray jSONArray = new JSONArray();
                    ArrayList zzb3 = zzb2.zzb();
                    int size = zzb3.size();
                    for (int i = 0; i < size; i++) {
                        jSONArray.put((String) zzb3.get(i));
                    }
                    try {
                        zza2.put("isFriendlyObstructionFor", jSONArray);
                        zza2.put("friendlyObstructionClass", zza3.zzd());
                        zza2.put("friendlyObstructionPurpose", zza3.zza());
                        zza2.put("friendlyObstructionReason", zza3.zzc());
                    } catch (JSONException e2) {
                        zzco.zza("Error with setting friendly obstruction", e2);
                    }
                    z2 = true;
                } else {
                    z2 = false;
                }
                zzk(view, zzcf, zza2, zzk2, z || z2);
            }
            this.zzg++;
        }
    }

    public final void zzh() {
        zzl();
    }

    public final void zzi() {
        if (zzc == null) {
            Handler handler = new Handler(Looper.getMainLooper());
            zzc = handler;
            handler.post(zzd);
            zzc.postDelayed(zze, 200);
        }
    }

    public final void zzj() {
        zzl();
        this.zzf.clear();
        zzb.post(new zzcu(this));
    }
}

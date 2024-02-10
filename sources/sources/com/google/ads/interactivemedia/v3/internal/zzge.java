package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import com.facebook.internal.ServerProtocol;
import com.google.ads.interactivemedia.omid.library.adsession.zza;
import com.google.ads.interactivemedia.omid.library.adsession.zzb;
import com.google.ads.interactivemedia.omid.library.adsession.zzc;
import com.google.ads.interactivemedia.omid.library.adsession.zzf;
import com.google.ads.interactivemedia.omid.library.adsession.zzg;
import com.google.ads.interactivemedia.omid.library.adsession.zzh;
import com.google.ads.interactivemedia.omid.library.adsession.zzi;
import com.google.ads.interactivemedia.v3.api.AdErrorEvent;
import com.google.ads.interactivemedia.v3.api.AdEvent;
import com.google.ads.interactivemedia.v3.api.FriendlyObstruction;
import com.google.ads.interactivemedia.v3.impl.data.zzbn;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzge implements AdEvent.AdEventListener, AdErrorEvent.AdErrorListener, zzen, zzfl {
    private final zzfm zza;
    private final zzgd zzb;
    private final Context zzc;
    private View zzd;
    private String zze;
    private final Set zzf;
    private boolean zzg = false;
    private boolean zzh = false;
    private String zzi = null;
    private zza zzj;

    zzge(zzfm zzfm, Context context) {
        zzgd zzgd = new zzgd();
        this.zza = zzfm;
        this.zzc = context;
        this.zzb = zzgd;
        this.zzf = new HashSet();
    }

    private final void zzj(List list) {
        zzbn zzbn;
        if (list == null) {
            zzbn = null;
        } else if (!list.isEmpty()) {
            zzbn = zzbn.builder().friendlyObstructions(list).build();
        } else {
            return;
        }
        this.zza.zzp(new zzff(zzfd.omid, zzfe.registerFriendlyObstructions, this.zze, zzbn));
    }

    public final void onAdError(AdErrorEvent adErrorEvent) {
        zza zza2;
        if (this.zzg && (zza2 = this.zzj) != null) {
            zza2.zzc();
            this.zzj = null;
        }
    }

    public final void onAdEvent(AdEvent adEvent) {
        if (this.zzg) {
            AdEvent.AdEventType adEventType = AdEvent.AdEventType.ALL_ADS_COMPLETED;
            int ordinal = adEvent.getType().ordinal();
            if (ordinal == 3 || ordinal == 14) {
                zzi();
            } else if (ordinal == 15 && this.zzg && this.zzj == null && this.zzd != null) {
                zzb zza2 = zzb.zza(zzf.DEFINED_BY_JAVASCRIPT, zzg.DEFINED_BY_JAVASCRIPT, zzh.JAVASCRIPT, zzh.JAVASCRIPT, true);
                zzi zza3 = zzi.zza("Google1", "3.30.3");
                WebView zza4 = this.zza.zza();
                String str = this.zzi;
                String str2 = true != this.zzh ? "false" : ServerProtocol.DIALOG_RETURN_SCOPES_TRUE;
                zza zza5 = zza.zza(zza2, zzc.zzb(zza3, zza4, str, "{ssai:" + str2 + "}"));
                zza5.zzd(this.zzd);
                for (FriendlyObstruction friendlyObstruction : this.zzf) {
                    zza5.zzb(friendlyObstruction.getView(), friendlyObstruction.getPurpose().getOmidPurpose(), friendlyObstruction.getDetailedReason());
                }
                zzj(new ArrayList(this.zzf));
                zza5.zzf();
                this.zzj = zza5;
            }
        }
    }

    public final void zza() {
        zzbr.zza(this.zzc);
        this.zzg = true;
    }

    public final void zzb() {
        this.zzg = false;
    }

    public final void zzc(FriendlyObstruction friendlyObstruction) {
        if (!this.zzf.contains(friendlyObstruction)) {
            this.zzf.add(friendlyObstruction);
            zza zza2 = this.zzj;
            if (zza2 != null) {
                zza2.zzb(friendlyObstruction.getView(), friendlyObstruction.getPurpose().getOmidPurpose(), friendlyObstruction.getDetailedReason());
                zzj(Arrays.asList(new FriendlyObstruction[]{friendlyObstruction}));
            }
        }
    }

    public final void zzd(View view) {
        this.zzd = view;
    }

    public final void zze(String str) {
        this.zzi = str;
    }

    public final void zzf(boolean z) {
        this.zzh = true;
    }

    public final void zzg(String str) {
        this.zze = str;
    }

    public final void zzh() {
        this.zzf.clear();
        zza zza2 = this.zzj;
        if (zza2 != null) {
            zza2.zze();
            zzj((List) null);
        }
    }

    public final boolean zzi() {
        zza zza2;
        if (!this.zzg || (zza2 = this.zzj) == null) {
            return false;
        }
        zza2.zzc();
        this.zzj = null;
        return true;
    }
}

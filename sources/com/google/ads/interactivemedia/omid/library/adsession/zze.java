package com.google.ads.interactivemedia.omid.library.adsession;

import android.view.View;
import com.google.ads.interactivemedia.v3.internal.zzbx;
import com.google.ads.interactivemedia.v3.internal.zzbz;
import com.google.ads.interactivemedia.v3.internal.zzcc;
import com.google.ads.interactivemedia.v3.internal.zzcd;
import com.google.ads.interactivemedia.v3.internal.zzcj;
import com.google.ads.interactivemedia.v3.internal.zzck;
import com.google.ads.interactivemedia.v3.internal.zzcm;
import com.google.ads.interactivemedia.v3.internal.zzcp;
import com.google.ads.interactivemedia.v3.internal.zzdg;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zze extends zza {
    private static final Pattern zza = Pattern.compile("^[a-zA-Z0-9 ]+$");
    private final zzc zzb;
    private final zzb zzc;
    private final List zzd = new ArrayList();
    private zzdg zze;
    private zzcj zzf;
    private boolean zzg = false;
    private boolean zzh = false;
    private final String zzi;

    zze(zzb zzb2, zzc zzc2) {
        this.zzc = zzb2;
        this.zzb = zzc2;
        this.zzi = UUID.randomUUID().toString();
        zzl((View) null);
        if (zzc2.zzc() == zzd.HTML || zzc2.zzc() == zzd.JAVASCRIPT) {
            this.zzf = new zzck(zzc2.zza());
        } else {
            this.zzf = new zzcm(zzc2.zzh(), (String) null);
        }
        this.zzf.zzj();
        zzbx.zza().zzd(this);
        zzcc.zza().zzd(this.zzf.zza(), zzb2.zzb());
    }

    private final void zzl(View view) {
        this.zze = new zzdg(view);
    }

    public final void zzb(View view, FriendlyObstructionPurpose friendlyObstructionPurpose, String str) {
        zzbz zzbz;
        if (this.zzh) {
            return;
        }
        if (view != null) {
            if (str != null) {
                if (str.length() > 50) {
                    throw new IllegalArgumentException("FriendlyObstruction has detailed reason over 50 characters in length");
                } else if (!zza.matcher(str).matches()) {
                    throw new IllegalArgumentException("FriendlyObstruction has detailed reason that contains characters not in [a-z][A-Z][0-9] or space");
                }
            }
            Iterator it = this.zzd.iterator();
            while (true) {
                if (!it.hasNext()) {
                    zzbz = null;
                    break;
                }
                zzbz = (zzbz) it.next();
                if (zzbz.zzb().get() == view) {
                    break;
                }
            }
            if (zzbz == null) {
                this.zzd.add(new zzbz(view, friendlyObstructionPurpose, str));
                return;
            }
            return;
        }
        throw new IllegalArgumentException("FriendlyObstruction is null");
    }

    public final void zzc() {
        if (!this.zzh) {
            this.zze.clear();
            zze();
            this.zzh = true;
            zzcc.zza().zzc(this.zzf.zza());
            zzbx.zza().zze(this);
            this.zzf.zzc();
            this.zzf = null;
        }
    }

    public final void zzd(View view) {
        if (!this.zzh) {
            zzcp.zzb(view, "AdView is null");
            if (zzg() != view) {
                zzl(view);
                this.zzf.zzb();
                Collection<zze> zzc2 = zzbx.zza().zzc();
                if (zzc2 != null && !zzc2.isEmpty()) {
                    for (zze zze2 : zzc2) {
                        if (zze2 != this && zze2.zzg() == view) {
                            zze2.zze.clear();
                        }
                    }
                }
            }
        }
    }

    public final void zze() {
        if (!this.zzh) {
            this.zzd.clear();
        }
    }

    public final void zzf() {
        if (!this.zzg) {
            this.zzg = true;
            zzbx.zza().zzf(this);
            this.zzf.zzh(zzcd.zzb().zza());
            this.zzf.zzf(this, this.zzb);
        }
    }

    public final View zzg() {
        return (View) this.zze.get();
    }

    public final zzcj zzh() {
        return this.zzf;
    }

    public final String zzi() {
        return this.zzi;
    }

    public final List zzj() {
        return this.zzd;
    }

    public final boolean zzk() {
        return this.zzg && !this.zzh;
    }
}

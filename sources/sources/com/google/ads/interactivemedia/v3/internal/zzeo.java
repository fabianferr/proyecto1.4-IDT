package com.google.ads.interactivemedia.v3.internal;

import android.view.View;
import android.view.ViewGroup;
import com.google.ads.interactivemedia.v3.api.BaseDisplayContainer;
import com.google.ads.interactivemedia.v3.api.CompanionAdSlot;
import com.google.ads.interactivemedia.v3.api.FriendlyObstruction;
import com.google.ads.interactivemedia.v3.api.FriendlyObstructionPurpose;
import com.google.ads.interactivemedia.v3.impl.data.zzax;
import com.google.ads.interactivemedia.v3.impl.data.zzay;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public class zzeo implements BaseDisplayContainer {
    private static int zza;
    private ViewGroup zzb;
    private Collection zzc = zzso.zzm();
    private Map zzd = zzsw.zzm();
    private final Set zze = new HashSet();
    private zzen zzf = null;
    private boolean zzg = false;

    public zzeo(ViewGroup viewGroup) {
        this.zzb = viewGroup;
    }

    public final void claim() {
        zzrm.zze(!this.zzg, "A given DisplayContainer may only be used once");
        this.zzg = true;
    }

    public final void destroy() {
        ViewGroup viewGroup = this.zzb;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
    }

    public final ViewGroup getAdContainer() {
        return this.zzb;
    }

    public final Collection<CompanionAdSlot> getCompanionSlots() {
        return this.zzc;
    }

    public final void registerFriendlyObstruction(FriendlyObstruction friendlyObstruction) {
        if (friendlyObstruction != null && !this.zze.contains(friendlyObstruction)) {
            this.zze.add(friendlyObstruction);
            zzen zzen = this.zzf;
            if (zzen != null) {
                ((zzge) zzen).zzc(friendlyObstruction);
            }
        }
    }

    public final void registerVideoControlsOverlay(View view) {
        if (view != null) {
            zzax builder = zzay.builder();
            builder.view(view);
            builder.purpose(FriendlyObstructionPurpose.VIDEO_CONTROLS);
            zzay build = builder.build();
            if (!this.zze.contains(build)) {
                this.zze.add(build);
                zzen zzen = this.zzf;
                if (zzen != null) {
                    ((zzge) zzen).zzc(build);
                }
            }
        }
    }

    public final void setAdContainer(ViewGroup viewGroup) {
        viewGroup.getClass();
        this.zzb = viewGroup;
    }

    public final void setCompanionSlots(Collection<CompanionAdSlot> collection) {
        if (collection == null) {
            collection = zzso.zzm();
        }
        zzsq zzsq = new zzsq();
        for (CompanionAdSlot next : collection) {
            if (next != null) {
                int i = zza;
                zza = i + 1;
                zzsq.zza("compSlot_" + i, next);
            }
        }
        this.zzd = zzsq.zzc();
        this.zzc = collection;
    }

    public final void unregisterAllFriendlyObstructions() {
        this.zze.clear();
        zzen zzen = this.zzf;
        if (zzen != null) {
            ((zzge) zzen).zzh();
        }
    }

    public final void unregisterAllVideoControlsOverlays() {
        this.zze.clear();
        zzen zzen = this.zzf;
        if (zzen != null) {
            ((zzge) zzen).zzh();
        }
    }

    public final Map zza() {
        return this.zzd;
    }

    public final Set zzb() {
        return new HashSet(this.zze);
    }

    public final void zzc(zzen zzen) {
        this.zzf = zzen;
    }
}

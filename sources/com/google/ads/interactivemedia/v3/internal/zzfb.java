package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.google.ads.interactivemedia.v3.api.CompanionAdSlot;
import com.google.ads.interactivemedia.v3.impl.data.CompanionData;
import com.google.android.gms.tasks.Task;
import java.util.HashMap;
import java.util.List;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzfb extends ImageView implements View.OnClickListener {
    private final CompanionData zza;
    private final zzfm zzb;
    private final String zzc;
    private final List zzd;
    private final zzhy zze;

    public zzfb(Context context, zzfm zzfm, CompanionData companionData, Task task, String str, List list, zzhy zzhy) {
        super(context);
        this.zzb = zzfm;
        this.zza = companionData;
        this.zzc = str;
        this.zzd = list;
        this.zze = zzhy;
        setOnClickListener(this);
        task.addOnCompleteListener(new zzfa(this));
    }

    public final void onClick(View view) {
        for (CompanionAdSlot.ClickListener onCompanionAdClick : this.zzd) {
            onCompanionAdClick.onCompanionAdClick();
        }
        this.zze.zza(this.zza.clickThroughUrl());
    }

    public final void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        zzfm zzfm = this.zzb;
        String companionId = this.zza.companionId();
        String str = this.zzc;
        if (!zzro.zzc(companionId) && !zzro.zzc(str)) {
            HashMap zzb2 = zztd.zzb(1);
            zzb2.put("companionId", companionId);
            zzfm.zzp(new zzff(zzfd.displayContainer, zzfe.companionView, str, zzb2));
        }
    }
}

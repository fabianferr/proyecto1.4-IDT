package com.google.android.gms.cast.framework.media.uicontroller;

import android.view.View;
import android.widget.ImageView;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
final class zzb implements View.OnClickListener {
    final /* synthetic */ UIMediaController zza;

    zzb(UIMediaController uIMediaController) {
        this.zza = uIMediaController;
    }

    public final void onClick(View view) {
        this.zza.onMuteToggleClicked((ImageView) view);
    }
}

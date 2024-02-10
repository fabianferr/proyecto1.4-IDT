package com.google.android.gms.cast.framework.media.uicontroller;

import android.view.View;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
final class zze implements View.OnClickListener {
    final /* synthetic */ UIMediaController zza;

    zze(UIMediaController uIMediaController) {
        this.zza = uIMediaController;
    }

    public final void onClick(View view) {
        this.zza.onSkipPrevClicked(view);
    }
}

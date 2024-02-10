package com.google.android.gms.cast.framework.media;

import android.content.DialogInterface;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
final class zzbq implements DialogInterface.OnClickListener {
    final /* synthetic */ TracksChooserDialogFragment zza;

    zzbq(TracksChooserDialogFragment tracksChooserDialogFragment) {
        this.zza = tracksChooserDialogFragment;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        TracksChooserDialogFragment tracksChooserDialogFragment = this.zza;
        if (tracksChooserDialogFragment.zze != null) {
            tracksChooserDialogFragment.zze.cancel();
            this.zza.zze = null;
        }
    }
}

package com.google.android.gms.internal.cast;

import android.view.View;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
final class zzu implements View.OnClickListener {
    final /* synthetic */ zzy zza;

    zzu(zzy zzy) {
        this.zza = zzy;
    }

    public final void onClick(View view) {
        this.zza.dismiss();
    }
}

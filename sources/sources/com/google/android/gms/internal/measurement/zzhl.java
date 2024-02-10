package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.1 */
final class zzhl extends ContentObserver {
    zzhl(zzhm zzhm, Handler handler) {
        super((Handler) null);
    }

    public final void onChange(boolean z) {
        zzia.zzd();
    }
}

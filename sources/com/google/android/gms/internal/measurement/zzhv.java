package com.google.android.gms.internal.measurement;

import android.util.Log;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.1 */
final class zzhv extends zzia {
    zzhv(zzhx zzhx, String str, Double d, boolean z) {
        super(zzhx, "measurement.test.double_flag", d, true, (zzhz) null);
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public final /* bridge */ /* synthetic */ Object zza(Object obj) {
        try {
            return Double.valueOf(Double.parseDouble((String) obj));
        } catch (NumberFormatException unused) {
            String zzc = super.zzc();
            Log.e("PhenotypeFlag", "Invalid double value for " + zzc + ": " + ((String) obj));
            return null;
        }
    }
}

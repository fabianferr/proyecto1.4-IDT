package com.google.android.gms.internal.atv_ads_framework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: com.google.android.tv:tv-ads@@1.0.0-alpha02 */
public final class zzr {
    /* access modifiers changed from: private */
    public final zzk zza;
    private final zzp zzb;

    private zzr(zzp zzp, byte[] bArr) {
        zzj zzj = zzj.zza;
        this.zzb = zzp;
        this.zza = zzj;
    }

    public static zzr zzb(char c) {
        return new zzr(new zzp(new zzh(AbstractJsonLexerKt.COLON)), (byte[]) null);
    }

    public final List zzc(CharSequence charSequence) {
        charSequence.getClass();
        zzo zzo = new zzo(this.zzb, this, charSequence);
        ArrayList arrayList = new ArrayList();
        while (zzo.hasNext()) {
            arrayList.add((String) zzo.next());
        }
        return Collections.unmodifiableList(arrayList);
    }
}

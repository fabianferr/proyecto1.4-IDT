package com.google.ads.interactivemedia.v3.internal;

import java.util.Arrays;
import javax.annotation.CheckForNull;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzrg {
    private final String zza;
    private final zzre zzb;
    private zzre zzc;

    /* synthetic */ zzrg(String str, zzrf zzrf) {
        zzre zzre = new zzre((zzrd) null);
        this.zzb = zzre;
        this.zzc = zzre;
        str.getClass();
        this.zza = str;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.zza);
        sb.append(AbstractJsonLexerKt.BEGIN_OBJ);
        zzre zzre = this.zzb.zzb;
        String str = "";
        while (zzre != null) {
            Object obj = zzre.zza;
            sb.append(str);
            if (obj == null || !obj.getClass().isArray()) {
                sb.append(obj);
            } else {
                String deepToString = Arrays.deepToString(new Object[]{obj});
                sb.append(deepToString, 1, deepToString.length() - 1);
            }
            zzre = zzre.zzb;
            str = ", ";
        }
        sb.append(AbstractJsonLexerKt.END_OBJ);
        return sb.toString();
    }

    public final zzrg zza(@CheckForNull Object obj) {
        zzre zzre = new zzre((zzrd) null);
        this.zzc.zzb = zzre;
        this.zzc = zzre;
        zzre.zza = obj;
        return this;
    }
}

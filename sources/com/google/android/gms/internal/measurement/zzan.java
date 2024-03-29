package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: com.google.android.gms:play-services-measurement@@21.1.1 */
public final class zzan implements zzap {
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return obj instanceof zzan;
    }

    public final int hashCode() {
        return 1;
    }

    public final zzap zzbN(String str, zzg zzg, List list) {
        throw new IllegalStateException(String.format("null has no function %s", new Object[]{str}));
    }

    public final zzap zzd() {
        return zzap.zzg;
    }

    public final Boolean zzg() {
        return false;
    }

    public final Double zzh() {
        return Double.valueOf(0.0d);
    }

    public final String zzi() {
        return AbstractJsonLexerKt.NULL;
    }

    public final Iterator zzl() {
        return null;
    }
}

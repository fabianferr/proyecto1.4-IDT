package com.google.android.gms.internal.vision;

import java.util.Iterator;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
final class zzex<E> extends zzej<E> {
    private final transient E zza;
    private transient int zzb;

    zzex(E e) {
        this.zza = zzde.zza(e);
    }

    public final int size() {
        return 1;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzf() {
        return false;
    }

    zzex(E e, int i) {
        this.zza = e;
        this.zzb = i;
    }

    public final boolean contains(Object obj) {
        return this.zza.equals(obj);
    }

    public final zzfa<E> zza() {
        return new zzeo(this.zza);
    }

    /* access modifiers changed from: package-private */
    public final zzee<E> zzh() {
        return zzee.zza(this.zza);
    }

    /* access modifiers changed from: package-private */
    public final int zza(Object[] objArr, int i) {
        objArr[i] = this.zza;
        return i + 1;
    }

    public final int hashCode() {
        int i = this.zzb;
        if (i != 0) {
            return i;
        }
        int hashCode = this.zza.hashCode();
        this.zzb = hashCode;
        return hashCode;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzg() {
        return this.zzb != 0;
    }

    public final String toString() {
        String obj = this.zza.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(obj).length() + 2);
        sb.append(AbstractJsonLexerKt.BEGIN_LIST);
        sb.append(obj);
        sb.append(AbstractJsonLexerKt.END_LIST);
        return sb.toString();
    }

    public final /* synthetic */ Iterator iterator() {
        return iterator();
    }
}

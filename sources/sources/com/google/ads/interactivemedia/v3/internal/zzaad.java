package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.lang.reflect.Field;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
abstract class zzaad {
    final String zzi;
    final Field zzj;
    final String zzk;
    final boolean zzl;
    final boolean zzm;

    protected zzaad(String str, Field field, boolean z, boolean z2) {
        this.zzi = str;
        this.zzj = field;
        this.zzk = field.getName();
        this.zzl = z;
        this.zzm = z2;
    }

    /* access modifiers changed from: package-private */
    public abstract void zza(zzacv zzacv, int i, Object[] objArr) throws IOException, zzwv;

    /* access modifiers changed from: package-private */
    public abstract void zzb(zzacv zzacv, Object obj) throws IOException, IllegalAccessException;

    /* access modifiers changed from: package-private */
    public abstract void zzc(zzacx zzacx, Object obj) throws IOException, IllegalAccessException;
}

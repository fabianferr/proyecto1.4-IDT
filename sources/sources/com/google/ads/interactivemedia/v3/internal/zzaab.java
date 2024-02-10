package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzaab extends zzaad {
    final /* synthetic */ boolean zza;
    final /* synthetic */ Method zzb;
    final /* synthetic */ boolean zzc;
    final /* synthetic */ zzxi zzd;
    final /* synthetic */ zzwm zze;
    final /* synthetic */ zzact zzf;
    final /* synthetic */ boolean zzg;
    final /* synthetic */ boolean zzh;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzaab(zzaag zzaag, String str, Field field, boolean z, boolean z2, boolean z3, Method method, boolean z4, zzxi zzxi, zzwm zzwm, zzact zzact, boolean z5, boolean z6) {
        super(str, field, z, z2);
        this.zza = z3;
        this.zzb = method;
        this.zzc = z4;
        this.zzd = zzxi;
        this.zze = zzwm;
        this.zzf = zzact;
        this.zzg = z5;
        this.zzh = z6;
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzacv zzacv, int i, Object[] objArr) throws IOException, zzwv {
        Object read = this.zzd.read(zzacv);
        if (read != null || !this.zzg) {
            objArr[i] = read;
            return;
        }
        String str = this.zzk;
        String zze2 = zzacv.zze();
        throw new zzwv("null is not allowed as value for record component '" + str + "' of primitive type; at path " + zze2);
    }

    /* access modifiers changed from: package-private */
    public final void zzb(zzacv zzacv, Object obj) throws IOException, IllegalAccessException {
        Object read = this.zzd.read(zzacv);
        if (read != null || !this.zzg) {
            if (this.zza) {
                zzaag.zzb(obj, this.zzj);
            } else if (this.zzh) {
                throw new zzws("Cannot set value of 'static final' ".concat(zzacg.zze(this.zzj, false)));
            }
            this.zzj.set(obj, read);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzc(zzacx zzacx, Object obj) throws IOException, IllegalAccessException {
        Object obj2;
        zzxi zzxi;
        if (this.zzl) {
            if (this.zza) {
                Method method = this.zzb;
                if (method == null) {
                    zzaag.zzb(obj, this.zzj);
                } else {
                    zzaag.zzb(obj, method);
                }
            }
            Method method2 = this.zzb;
            if (method2 != null) {
                try {
                    obj2 = method2.invoke(obj, new Object[0]);
                } catch (InvocationTargetException e) {
                    String zze2 = zzacg.zze(this.zzb, false);
                    throw new zzws("Accessor " + zze2 + " threw exception", e.getCause());
                }
            } else {
                obj2 = this.zzj.get(obj);
            }
            if (obj2 != obj) {
                zzacx.zze(this.zzi);
                if (this.zzc) {
                    zzxi = this.zzd;
                } else {
                    zzxi = new zzaam(this.zze, this.zzd, this.zzf.zzd());
                }
                zzxi.write(zzacx, obj2);
            }
        }
    }
}

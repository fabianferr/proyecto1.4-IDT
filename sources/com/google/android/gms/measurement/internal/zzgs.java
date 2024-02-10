package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.1 */
abstract class zzgs extends zzgr {
    private boolean zza;

    zzgs(zzfy zzfy) {
        super(zzfy);
        this.zzs.zzD();
    }

    /* access modifiers changed from: protected */
    public void zzaA() {
    }

    /* access modifiers changed from: protected */
    public abstract boolean zzf();

    /* access modifiers changed from: protected */
    public final void zzu() {
        if (!zzx()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void zzv() {
        if (this.zza) {
            throw new IllegalStateException("Can't initialize twice");
        } else if (!zzf()) {
            this.zzs.zzB();
            this.zza = true;
        }
    }

    public final void zzw() {
        if (!this.zza) {
            zzaA();
            this.zzs.zzB();
            this.zza = true;
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }

    /* access modifiers changed from: package-private */
    public final boolean zzx() {
        return this.zza;
    }
}

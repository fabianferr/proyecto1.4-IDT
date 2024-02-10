package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzbc;
import com.google.android.gms.ads.internal.client.zzbf;
import com.google.android.gms.ads.internal.client.zzbi;
import com.google.android.gms.ads.internal.client.zzbr;
import com.google.android.gms.ads.internal.client.zzbw;
import com.google.android.gms.ads.internal.client.zzbz;
import com.google.android.gms.ads.internal.client.zzcd;
import com.google.android.gms.ads.internal.client.zzcg;
import com.google.android.gms.ads.internal.client.zzde;
import com.google.android.gms.ads.internal.client.zzdh;
import com.google.android.gms.ads.internal.client.zzdk;
import com.google.android.gms.ads.internal.client.zzdo;
import com.google.android.gms.ads.internal.client.zzff;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.client.zzw;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzenm extends zzbr implements zzdfq {
    private final Context zza;
    private final zzezu zzb;
    private final String zzc;
    private final zzeof zzd;
    private zzq zze;
    private final zzfed zzf;
    private final zzcgv zzg;
    /* access modifiers changed from: private */
    public zzcxc zzh;

    public zzenm(Context context, zzq zzq, String str, zzezu zzezu, zzeof zzeof, zzcgv zzcgv) {
        this.zza = context;
        this.zzb = zzezu;
        this.zze = zzq;
        this.zzc = str;
        this.zzd = zzeof;
        this.zzf = zzezu.zzi();
        this.zzg = zzcgv;
        zzezu.zzp(this);
    }

    private final synchronized void zze(zzq zzq) {
        this.zzf.zzr(zzq);
        this.zzf.zzw(this.zze.zzn);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002e, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized boolean zzf(com.google.android.gms.ads.internal.client.zzl r5) throws android.os.RemoteException {
        /*
            r4 = this;
            monitor-enter(r4)
            boolean r0 = r4.zzh()     // Catch:{ all -> 0x0046 }
            if (r0 == 0) goto L_0x000c
            java.lang.String r0 = "loadAd must be called on the main UI thread."
            com.google.android.gms.common.internal.Preconditions.checkMainThread(r0)     // Catch:{ all -> 0x0046 }
        L_0x000c:
            com.google.android.gms.ads.internal.zzt.zzp()     // Catch:{ all -> 0x0046 }
            android.content.Context r0 = r4.zza     // Catch:{ all -> 0x0046 }
            boolean r0 = com.google.android.gms.ads.internal.util.zzs.zzD(r0)     // Catch:{ all -> 0x0046 }
            r1 = 0
            if (r0 == 0) goto L_0x0030
            com.google.android.gms.ads.internal.client.zzc r0 = r5.zzs     // Catch:{ all -> 0x0046 }
            if (r0 != 0) goto L_0x0030
            java.lang.String r5 = "Failed to load the ad because app ID is missing."
            com.google.android.gms.ads.internal.util.zze.zzg(r5)     // Catch:{ all -> 0x0046 }
            com.google.android.gms.internal.ads.zzeof r5 = r4.zzd     // Catch:{ all -> 0x0046 }
            if (r5 == 0) goto L_0x002d
            r0 = 4
            com.google.android.gms.ads.internal.client.zze r0 = com.google.android.gms.internal.ads.zzffe.zzd(r0, r1, r1)     // Catch:{ all -> 0x0046 }
            r5.zza(r0)     // Catch:{ all -> 0x0046 }
        L_0x002d:
            monitor-exit(r4)
            r5 = 0
            return r5
        L_0x0030:
            android.content.Context r0 = r4.zza     // Catch:{ all -> 0x0046 }
            boolean r2 = r5.zzf     // Catch:{ all -> 0x0046 }
            com.google.android.gms.internal.ads.zzfez.zza(r0, r2)     // Catch:{ all -> 0x0046 }
            com.google.android.gms.internal.ads.zzezu r0 = r4.zzb     // Catch:{ all -> 0x0046 }
            java.lang.String r2 = r4.zzc     // Catch:{ all -> 0x0046 }
            com.google.android.gms.internal.ads.zzenl r3 = new com.google.android.gms.internal.ads.zzenl     // Catch:{ all -> 0x0046 }
            r3.<init>(r4)     // Catch:{ all -> 0x0046 }
            boolean r5 = r0.zzb(r5, r2, r1, r3)     // Catch:{ all -> 0x0046 }
            monitor-exit(r4)
            return r5
        L_0x0046:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzenm.zzf(com.google.android.gms.ads.internal.client.zzl):boolean");
    }

    private final boolean zzh() {
        boolean z;
        if (((Boolean) zzbkq.zzf.zze()).booleanValue()) {
            if (((Boolean) zzay.zzc().zzb(zzbjc.zziM)).booleanValue()) {
                z = true;
                return this.zzg.zzc >= ((Integer) zzay.zzc().zzb(zzbjc.zziN)).intValue() || !z;
            }
        }
        z = false;
        if (this.zzg.zzc >= ((Integer) zzay.zzc().zzb(zzbjc.zziN)).intValue()) {
        }
    }

    public final synchronized void zzA() {
        Preconditions.checkMainThread("recordManualImpression must be called on the main UI thread.");
        zzcxc zzcxc = this.zzh;
        if (zzcxc != null) {
            zzcxc.zzg();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0035, code lost:
        if (r3.zzg.zzc < ((java.lang.Integer) com.google.android.gms.ads.internal.client.zzay.zzc().zzb(com.google.android.gms.internal.ads.zzbjc.zziO)).intValue()) goto L_0x0037;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzB() {
        /*
            r3 = this;
            monitor-enter(r3)
            com.google.android.gms.internal.ads.zzbke r0 = com.google.android.gms.internal.ads.zzbkq.zzh     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r0.zze()     // Catch:{ all -> 0x004c }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x004c }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x004c }
            if (r0 == 0) goto L_0x0037
            com.google.android.gms.internal.ads.zzbiu r0 = com.google.android.gms.internal.ads.zzbjc.zziI     // Catch:{ all -> 0x004c }
            com.google.android.gms.internal.ads.zzbja r1 = com.google.android.gms.ads.internal.client.zzay.zzc()     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r1.zzb(r0)     // Catch:{ all -> 0x004c }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x004c }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x004c }
            if (r0 == 0) goto L_0x0037
            com.google.android.gms.internal.ads.zzcgv r0 = r3.zzg     // Catch:{ all -> 0x004c }
            int r0 = r0.zzc     // Catch:{ all -> 0x004c }
            com.google.android.gms.internal.ads.zzbiu r1 = com.google.android.gms.internal.ads.zzbjc.zziO     // Catch:{ all -> 0x004c }
            com.google.android.gms.internal.ads.zzbja r2 = com.google.android.gms.ads.internal.client.zzay.zzc()     // Catch:{ all -> 0x004c }
            java.lang.Object r1 = r2.zzb(r1)     // Catch:{ all -> 0x004c }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ all -> 0x004c }
            int r1 = r1.intValue()     // Catch:{ all -> 0x004c }
            if (r0 >= r1) goto L_0x003c
        L_0x0037:
            java.lang.String r0 = "resume must be called on the main UI thread."
            com.google.android.gms.common.internal.Preconditions.checkMainThread(r0)     // Catch:{ all -> 0x004c }
        L_0x003c:
            com.google.android.gms.internal.ads.zzcxc r0 = r3.zzh     // Catch:{ all -> 0x004c }
            if (r0 == 0) goto L_0x004a
            com.google.android.gms.internal.ads.zzddz r0 = r0.zzm()     // Catch:{ all -> 0x004c }
            r1 = 0
            r0.zzc(r1)     // Catch:{ all -> 0x004c }
            monitor-exit(r3)
            return
        L_0x004a:
            monitor-exit(r3)
            return
        L_0x004c:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzenm.zzB():void");
    }

    public final void zzC(zzbc zzbc) {
        if (zzh()) {
            Preconditions.checkMainThread("setAdListener must be called on the main UI thread.");
        }
        this.zzb.zzo(zzbc);
    }

    public final void zzD(zzbf zzbf) {
        if (zzh()) {
            Preconditions.checkMainThread("setAdListener must be called on the main UI thread.");
        }
        this.zzd.zze(zzbf);
    }

    public final void zzE(zzbw zzbw) {
        Preconditions.checkMainThread("setAdMetadataListener must be called on the main UI thread.");
    }

    public final synchronized void zzF(zzq zzq) {
        Preconditions.checkMainThread("setAdSize must be called on the main UI thread.");
        this.zzf.zzr(zzq);
        this.zze = zzq;
        zzcxc zzcxc = this.zzh;
        if (zzcxc != null) {
            zzcxc.zzh(this.zzb.zzd(), zzq);
        }
    }

    public final void zzG(zzbz zzbz) {
        if (zzh()) {
            Preconditions.checkMainThread("setAppEventListener must be called on the main UI thread.");
        }
        this.zzd.zzi(zzbz);
    }

    public final void zzH(zzbdm zzbdm) {
    }

    public final void zzI(zzw zzw) {
    }

    public final void zzJ(zzcg zzcg) {
    }

    public final void zzK(zzdo zzdo) {
    }

    public final void zzL(boolean z) {
    }

    public final void zzM(zzbzl zzbzl) {
    }

    public final synchronized void zzN(boolean z) {
        if (zzh()) {
            Preconditions.checkMainThread("setManualImpressionsEnabled must be called from the main thread.");
        }
        this.zzf.zzy(z);
    }

    public final synchronized void zzO(zzbjx zzbjx) {
        Preconditions.checkMainThread("setOnCustomRenderedAdLoadedListener must be called on the main UI thread.");
        this.zzb.zzq(zzbjx);
    }

    public final void zzP(zzde zzde) {
        if (zzh()) {
            Preconditions.checkMainThread("setPaidEventListener must be called on the main UI thread.");
        }
        this.zzd.zzh(zzde);
    }

    public final void zzQ(zzbzo zzbzo, String str) {
    }

    public final void zzR(String str) {
    }

    public final void zzS(zzcby zzcby) {
    }

    public final void zzT(String str) {
    }

    public final synchronized void zzU(zzff zzff) {
        if (zzh()) {
            Preconditions.checkMainThread("setVideoOptions must be called on the main UI thread.");
        }
        this.zzf.zzF(zzff);
    }

    public final void zzW(IObjectWrapper iObjectWrapper) {
    }

    public final void zzX() {
    }

    public final synchronized boolean zzY() {
        return this.zzb.zza();
    }

    public final boolean zzZ() {
        return false;
    }

    public final synchronized void zza() {
        if (this.zzb.zzr()) {
            zzq zzg2 = this.zzf.zzg();
            zzcxc zzcxc = this.zzh;
            if (!(zzcxc == null || zzcxc.zzf() == null || !this.zzf.zzO())) {
                zzg2 = zzfej.zza(this.zza, Collections.singletonList(this.zzh.zzf()));
            }
            zze(zzg2);
            try {
                zzf(this.zzf.zze());
            } catch (RemoteException unused) {
                zze.zzj("Failed to refresh the banner ad.");
            }
        } else {
            this.zzb.zzn();
        }
    }

    public final synchronized boolean zzaa(zzl zzl) throws RemoteException {
        zze(this.zze);
        return zzf(zzl);
    }

    public final synchronized void zzab(zzcd zzcd) {
        Preconditions.checkMainThread("setCorrelationIdProvider must be called on the main UI thread");
        this.zzf.zzQ(zzcd);
    }

    public final Bundle zzd() {
        Preconditions.checkMainThread("getAdMetadata must be called on the main UI thread.");
        return new Bundle();
    }

    public final synchronized zzq zzg() {
        Preconditions.checkMainThread("getAdSize must be called on the main UI thread.");
        zzcxc zzcxc = this.zzh;
        if (zzcxc != null) {
            return zzfej.zza(this.zza, Collections.singletonList(zzcxc.zze()));
        }
        return this.zzf.zzg();
    }

    public final zzbf zzi() {
        return this.zzd.zzc();
    }

    public final zzbz zzj() {
        return this.zzd.zzd();
    }

    public final synchronized zzdh zzk() {
        if (!((Boolean) zzay.zzc().zzb(zzbjc.zzfQ)).booleanValue()) {
            return null;
        }
        zzcxc zzcxc = this.zzh;
        if (zzcxc == null) {
            return null;
        }
        return zzcxc.zzl();
    }

    public final synchronized zzdk zzl() {
        Preconditions.checkMainThread("getVideoController must be called from the main thread.");
        zzcxc zzcxc = this.zzh;
        if (zzcxc == null) {
            return null;
        }
        return zzcxc.zzd();
    }

    public final IObjectWrapper zzn() {
        if (zzh()) {
            Preconditions.checkMainThread("getAdFrame must be called on the main UI thread.");
        }
        return ObjectWrapper.wrap(this.zzb.zzd());
    }

    public final synchronized String zzr() {
        return this.zzc;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized java.lang.String zzs() {
        /*
            r2 = this;
            monitor-enter(r2)
            com.google.android.gms.internal.ads.zzcxc r0 = r2.zzh     // Catch:{ all -> 0x0018 }
            if (r0 == 0) goto L_0x0015
            com.google.android.gms.internal.ads.zzdct r1 = r0.zzl()     // Catch:{ all -> 0x0018 }
            if (r1 == 0) goto L_0x0015
            com.google.android.gms.internal.ads.zzdct r0 = r0.zzl()     // Catch:{ all -> 0x0018 }
            java.lang.String r0 = r0.zzg()     // Catch:{ all -> 0x0018 }
            monitor-exit(r2)
            return r0
        L_0x0015:
            monitor-exit(r2)
            r0 = 0
            return r0
        L_0x0018:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzenm.zzs():java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized java.lang.String zzt() {
        /*
            r2 = this;
            monitor-enter(r2)
            com.google.android.gms.internal.ads.zzcxc r0 = r2.zzh     // Catch:{ all -> 0x0018 }
            if (r0 == 0) goto L_0x0015
            com.google.android.gms.internal.ads.zzdct r1 = r0.zzl()     // Catch:{ all -> 0x0018 }
            if (r1 == 0) goto L_0x0015
            com.google.android.gms.internal.ads.zzdct r0 = r0.zzl()     // Catch:{ all -> 0x0018 }
            java.lang.String r0 = r0.zzg()     // Catch:{ all -> 0x0018 }
            monitor-exit(r2)
            return r0
        L_0x0015:
            monitor-exit(r2)
            r0 = 0
            return r0
        L_0x0018:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzenm.zzt():java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0035, code lost:
        if (r3.zzg.zzc < ((java.lang.Integer) com.google.android.gms.ads.internal.client.zzay.zzc().zzb(com.google.android.gms.internal.ads.zzbjc.zziO)).intValue()) goto L_0x0037;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzx() {
        /*
            r3 = this;
            monitor-enter(r3)
            com.google.android.gms.internal.ads.zzbke r0 = com.google.android.gms.internal.ads.zzbkq.zze     // Catch:{ all -> 0x0047 }
            java.lang.Object r0 = r0.zze()     // Catch:{ all -> 0x0047 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x0047 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x0047 }
            if (r0 == 0) goto L_0x0037
            com.google.android.gms.internal.ads.zzbiu r0 = com.google.android.gms.internal.ads.zzbjc.zziJ     // Catch:{ all -> 0x0047 }
            com.google.android.gms.internal.ads.zzbja r1 = com.google.android.gms.ads.internal.client.zzay.zzc()     // Catch:{ all -> 0x0047 }
            java.lang.Object r0 = r1.zzb(r0)     // Catch:{ all -> 0x0047 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x0047 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x0047 }
            if (r0 == 0) goto L_0x0037
            com.google.android.gms.internal.ads.zzcgv r0 = r3.zzg     // Catch:{ all -> 0x0047 }
            int r0 = r0.zzc     // Catch:{ all -> 0x0047 }
            com.google.android.gms.internal.ads.zzbiu r1 = com.google.android.gms.internal.ads.zzbjc.zziO     // Catch:{ all -> 0x0047 }
            com.google.android.gms.internal.ads.zzbja r2 = com.google.android.gms.ads.internal.client.zzay.zzc()     // Catch:{ all -> 0x0047 }
            java.lang.Object r1 = r2.zzb(r1)     // Catch:{ all -> 0x0047 }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ all -> 0x0047 }
            int r1 = r1.intValue()     // Catch:{ all -> 0x0047 }
            if (r0 >= r1) goto L_0x003c
        L_0x0037:
            java.lang.String r0 = "destroy must be called on the main UI thread."
            com.google.android.gms.common.internal.Preconditions.checkMainThread(r0)     // Catch:{ all -> 0x0047 }
        L_0x003c:
            com.google.android.gms.internal.ads.zzcxc r0 = r3.zzh     // Catch:{ all -> 0x0047 }
            if (r0 == 0) goto L_0x0045
            r0.zzV()     // Catch:{ all -> 0x0047 }
            monitor-exit(r3)
            return
        L_0x0045:
            monitor-exit(r3)
            return
        L_0x0047:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzenm.zzx():void");
    }

    public final void zzy(zzl zzl, zzbi zzbi) {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0035, code lost:
        if (r3.zzg.zzc < ((java.lang.Integer) com.google.android.gms.ads.internal.client.zzay.zzc().zzb(com.google.android.gms.internal.ads.zzbjc.zziO)).intValue()) goto L_0x0037;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzz() {
        /*
            r3 = this;
            monitor-enter(r3)
            com.google.android.gms.internal.ads.zzbke r0 = com.google.android.gms.internal.ads.zzbkq.zzg     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r0.zze()     // Catch:{ all -> 0x004c }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x004c }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x004c }
            if (r0 == 0) goto L_0x0037
            com.google.android.gms.internal.ads.zzbiu r0 = com.google.android.gms.internal.ads.zzbjc.zziK     // Catch:{ all -> 0x004c }
            com.google.android.gms.internal.ads.zzbja r1 = com.google.android.gms.ads.internal.client.zzay.zzc()     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r1.zzb(r0)     // Catch:{ all -> 0x004c }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x004c }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x004c }
            if (r0 == 0) goto L_0x0037
            com.google.android.gms.internal.ads.zzcgv r0 = r3.zzg     // Catch:{ all -> 0x004c }
            int r0 = r0.zzc     // Catch:{ all -> 0x004c }
            com.google.android.gms.internal.ads.zzbiu r1 = com.google.android.gms.internal.ads.zzbjc.zziO     // Catch:{ all -> 0x004c }
            com.google.android.gms.internal.ads.zzbja r2 = com.google.android.gms.ads.internal.client.zzay.zzc()     // Catch:{ all -> 0x004c }
            java.lang.Object r1 = r2.zzb(r1)     // Catch:{ all -> 0x004c }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ all -> 0x004c }
            int r1 = r1.intValue()     // Catch:{ all -> 0x004c }
            if (r0 >= r1) goto L_0x003c
        L_0x0037:
            java.lang.String r0 = "pause must be called on the main UI thread."
            com.google.android.gms.common.internal.Preconditions.checkMainThread(r0)     // Catch:{ all -> 0x004c }
        L_0x003c:
            com.google.android.gms.internal.ads.zzcxc r0 = r3.zzh     // Catch:{ all -> 0x004c }
            if (r0 == 0) goto L_0x004a
            com.google.android.gms.internal.ads.zzddz r0 = r0.zzm()     // Catch:{ all -> 0x004c }
            r1 = 0
            r0.zzb(r1)     // Catch:{ all -> 0x004c }
            monitor-exit(r3)
            return
        L_0x004a:
            monitor-exit(r3)
            return
        L_0x004c:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzenm.zzz():void");
    }
}

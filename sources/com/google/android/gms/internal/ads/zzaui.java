package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Handler;
import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzaui extends zzawu implements zzbag {
    /* access modifiers changed from: private */
    public final zzats zzb;
    private final zzaue zzc = new zzaue((zzatj) null, new zzatl[0], new zzauh(this, (zzaug) null));
    private boolean zzd;
    private int zze;
    private int zzf;
    private long zzg;
    /* access modifiers changed from: private */
    public boolean zzh;

    public zzaui(zzaww zzaww, zzauw zzauw, boolean z, Handler handler, zzatt zzatt) {
        super(1, zzaww, (zzauw) null, true);
        this.zzb = new zzats(handler, zzatt);
    }

    public final boolean zzE() {
        return super.zzE() && this.zzc.zzo();
    }

    public final boolean zzF() {
        return this.zzc.zzn() || super.zzF();
    }

    /* access modifiers changed from: protected */
    public final int zzH(zzaww zzaww, zzasw zzasw) throws zzawz {
        int i;
        int i2;
        String str = zzasw.zzf;
        if (!zzbah.zza(str)) {
            return 0;
        }
        int i3 = zzbar.zza >= 21 ? 16 : 0;
        zzaws zzc2 = zzaxe.zzc(str, false);
        if (zzc2 == null) {
            return 1;
        }
        int i4 = 3;
        if (zzbar.zza >= 21 && (((i = zzasw.zzs) != -1 && !zzc2.zzd(i)) || ((i2 = zzasw.zzr) != -1 && !zzc2.zzc(i2)))) {
            i4 = 2;
        }
        return i3 | 4 | i4;
    }

    public final long zzI() {
        long zza = this.zzc.zza(zzE());
        if (zza != Long.MIN_VALUE) {
            if (!this.zzh) {
                zza = Math.max(this.zzg, zza);
            }
            this.zzg = zza;
            this.zzh = false;
        }
        return this.zzg;
    }

    public final zzata zzJ() {
        return this.zzc.zzc();
    }

    public final zzata zzK(zzata zzata) {
        return this.zzc.zzd(zzata);
    }

    /* access modifiers changed from: protected */
    public final zzaws zzM(zzaww zzaww, zzasw zzasw, boolean z) throws zzawz {
        return super.zzM(zzaww, zzasw, false);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0038, code lost:
        if (com.google.android.gms.internal.ads.zzbar.zzb.startsWith("heroqlte") == false) goto L_0x003b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzO(com.google.android.gms.internal.ads.zzaws r3, android.media.MediaCodec r4, com.google.android.gms.internal.ads.zzasw r5, android.media.MediaCrypto r6) {
        /*
            r2 = this;
            java.lang.String r3 = r3.zza
            int r6 = com.google.android.gms.internal.ads.zzbar.zza
            r0 = 24
            r1 = 0
            if (r6 >= r0) goto L_0x003b
            java.lang.String r6 = "OMX.SEC.aac.dec"
            boolean r3 = r6.equals(r3)
            if (r3 == 0) goto L_0x003b
            java.lang.String r3 = "samsung"
            java.lang.String r6 = com.google.android.gms.internal.ads.zzbar.zzc
            boolean r3 = r3.equals(r6)
            if (r3 == 0) goto L_0x003b
            java.lang.String r3 = com.google.android.gms.internal.ads.zzbar.zzb
            java.lang.String r6 = "zeroflte"
            boolean r3 = r3.startsWith(r6)
            r6 = 1
            if (r3 != 0) goto L_0x003c
            java.lang.String r3 = com.google.android.gms.internal.ads.zzbar.zzb
            java.lang.String r0 = "herolte"
            boolean r3 = r3.startsWith(r0)
            if (r3 != 0) goto L_0x003c
            java.lang.String r3 = com.google.android.gms.internal.ads.zzbar.zzb
            java.lang.String r0 = "heroqlte"
            boolean r3 = r3.startsWith(r0)
            if (r3 == 0) goto L_0x003b
            goto L_0x003c
        L_0x003b:
            r6 = 0
        L_0x003c:
            r2.zzd = r6
            android.media.MediaFormat r3 = r5.zzb()
            r5 = 0
            r4.configure(r3, r5, r5, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaui.zzO(com.google.android.gms.internal.ads.zzaws, android.media.MediaCodec, com.google.android.gms.internal.ads.zzasw, android.media.MediaCrypto):void");
    }

    /* access modifiers changed from: protected */
    public final void zzP(String str, long j, long j2) {
        this.zzb.zzd(str, j, j2);
    }

    /* access modifiers changed from: protected */
    public final void zzQ(zzasw zzasw) throws zzasi {
        super.zzQ(zzasw);
        this.zzb.zzg(zzasw);
        this.zze = "audio/raw".equals(zzasw.zzf) ? zzasw.zzt : 2;
        this.zzf = zzasw.zzr;
    }

    /* access modifiers changed from: protected */
    public final void zzR(MediaCodec mediaCodec, MediaFormat mediaFormat) throws zzasi {
        int[] iArr;
        int i;
        int integer = mediaFormat.getInteger("channel-count");
        int integer2 = mediaFormat.getInteger("sample-rate");
        if (!this.zzd || integer != 6) {
            i = integer;
            iArr = null;
        } else {
            int i2 = this.zzf;
            if (i2 < 6) {
                int[] iArr2 = new int[i2];
                for (int i3 = 0; i3 < this.zzf; i3++) {
                    iArr2[i3] = i3;
                }
                iArr = iArr2;
            } else {
                iArr = null;
            }
            i = 6;
        }
        try {
            this.zzc.zze("audio/raw", i, integer2, this.zze, 0, iArr);
        } catch (zzaty e) {
            throw zzasi.zza(e, zza());
        }
    }

    /* access modifiers changed from: protected */
    public final boolean zzT(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) throws zzasi {
        if (z) {
            mediaCodec.releaseOutputBuffer(i, false);
            this.zza.zze++;
            this.zzc.zzf();
            return true;
        }
        try {
            if (!this.zzc.zzm(byteBuffer, j3)) {
                return false;
            }
            mediaCodec.releaseOutputBuffer(i, false);
            this.zza.zzd++;
            return true;
        } catch (zzatz | zzaud e) {
            throw zzasi.zza(e, zza());
        }
    }

    public final zzbag zzi() {
        return this;
    }

    public final void zzl(int i, Object obj) throws zzasi {
        if (i == 2) {
            this.zzc.zzl(((Float) obj).floatValue());
        }
    }

    /* access modifiers changed from: protected */
    public final void zzn() {
        try {
            this.zzc.zzj();
            try {
                super.zzn();
            } finally {
                this.zza.zza();
                this.zzb.zze(this.zza);
            }
        } catch (Throwable th) {
            super.zzn();
            throw th;
        } finally {
            this.zza.zza();
            this.zzb.zze(this.zza);
        }
    }

    /* access modifiers changed from: protected */
    public final void zzo(boolean z) throws zzasi {
        super.zzo(z);
        this.zzb.zzf(this.zza);
        int i = zzg().zzb;
    }

    /* access modifiers changed from: protected */
    public final void zzp(long j, boolean z) throws zzasi {
        super.zzp(j, z);
        this.zzc.zzk();
        this.zzg = j;
        this.zzh = true;
    }

    /* access modifiers changed from: protected */
    public final void zzq() {
        this.zzc.zzh();
    }

    /* access modifiers changed from: protected */
    public final void zzr() {
        this.zzc.zzg();
    }

    /* access modifiers changed from: protected */
    public final void zzS() throws zzasi {
        try {
            this.zzc.zzi();
        } catch (zzaud e) {
            throw zzasi.zza(e, zza());
        }
    }
}

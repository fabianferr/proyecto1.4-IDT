package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.view.Surface;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzs;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzcmc extends zzcip implements zzfz, zzkr {
    public static final /* synthetic */ int zzc = 0;
    private final Context zzd;
    private final zzcln zze;
    private final zzvr zzf;
    private final zzcix zzg;
    private final WeakReference zzh;
    private final zzto zzi;
    private zzkf zzj;
    private ByteBuffer zzk;
    private boolean zzl;
    private zzcio zzm;
    private int zzn;
    private int zzo;
    private long zzp;
    private final String zzq;
    private final int zzr;
    private final Object zzs = new Object();
    private final ArrayList zzt;
    private volatile zzclp zzu;
    private final Set zzv = new HashSet();

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00f5, code lost:
        if (((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzay.zzc().zzb(com.google.android.gms.internal.ads.zzbjc.zzbD)).booleanValue() == false) goto L_0x00f7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00f9, code lost:
        if (r7.zzj == false) goto L_0x00fb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00fb, code lost:
        r0 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00fe, code lost:
        if (r7.zzo == false) goto L_0x0106;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0100, code lost:
        r8 = new com.google.android.gms.internal.ads.zzclt(r5, r6, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0108, code lost:
        if (r7.zzi <= 0) goto L_0x0110;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x010a, code lost:
        r8 = new com.google.android.gms.internal.ads.zzclu(r5, r6, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0110, code lost:
        r8 = new com.google.android.gms.internal.ads.zzclv(r5, r6, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0117, code lost:
        if (r7.zzj == false) goto L_0x0120;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0119, code lost:
        r7 = new com.google.android.gms.internal.ads.zzclw(r5, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0120, code lost:
        r7 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0121, code lost:
        r6 = r5.zzk;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0123, code lost:
        if (r6 == null) goto L_0x013e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0129, code lost:
        if (r6.limit() <= 0) goto L_0x013e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x012b, code lost:
        r6 = new byte[r5.zzk.limit()];
        r5.zzk.get(r6);
        r7 = new com.google.android.gms.internal.ads.zzclx(r7, r6);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzcmc(android.content.Context r6, com.google.android.gms.internal.ads.zzcix r7, com.google.android.gms.internal.ads.zzciy r8) {
        /*
            r5 = this;
            r5.<init>()
            java.lang.Object r0 = new java.lang.Object
            r0.<init>()
            r5.zzs = r0
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            r5.zzv = r0
            r5.zzd = r6
            r5.zzg = r7
            java.lang.ref.WeakReference r0 = new java.lang.ref.WeakReference
            r0.<init>(r8)
            r5.zzh = r0
            com.google.android.gms.internal.ads.zzcln r0 = new com.google.android.gms.internal.ads.zzcln
            r0.<init>()
            r5.zze = r0
            com.google.android.gms.internal.ads.zzvr r1 = new com.google.android.gms.internal.ads.zzvr
            r1.<init>(r6)
            r5.zzf = r1
            boolean r2 = com.google.android.gms.ads.internal.util.zze.zzc()
            if (r2 == 0) goto L_0x003d
            java.lang.String r2 = "OfficialSimpleExoPlayerAdapter initialize "
            java.lang.String r3 = r5.toString()
            java.lang.String r2 = r2.concat(r3)
            com.google.android.gms.ads.internal.util.zze.zza(r2)
        L_0x003d:
            java.util.concurrent.atomic.AtomicInteger r2 = zza
            r2.incrementAndGet()
            com.google.android.gms.internal.ads.zzke r2 = new com.google.android.gms.internal.ads.zzke
            com.google.android.gms.internal.ads.zzcly r3 = new com.google.android.gms.internal.ads.zzcly
            r3.<init>(r5)
            r4 = 0
            r2.<init>(r6, r3, r4)
            r2.zzb(r1)
            r2.zza(r0)
            com.google.android.gms.internal.ads.zzkf r0 = r2.zzc()
            r5.zzj = r0
            com.google.android.gms.internal.ads.zzbiu r0 = com.google.android.gms.internal.ads.zzbjc.zzbK
            com.google.android.gms.internal.ads.zzbja r1 = com.google.android.gms.ads.internal.client.zzay.zzc()
            java.lang.Object r0 = r1.zzb(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L_0x0070
            com.google.android.gms.internal.ads.zzkf r0 = r5.zzj
            com.google.android.gms.internal.ads.zzje.zza(r0)
        L_0x0070:
            com.google.android.gms.internal.ads.zzkf r0 = r5.zzj
            r0.zzx(r5)
            r0 = 0
            r5.zzn = r0
            r1 = 0
            r5.zzp = r1
            r5.zzo = r0
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r5.zzt = r1
            r5.zzu = r4
            if (r8 == 0) goto L_0x0094
            java.lang.String r1 = r8.zzt()
            if (r1 == 0) goto L_0x0094
            java.lang.String r1 = r8.zzt()
            goto L_0x0096
        L_0x0094:
            java.lang.String r1 = ""
        L_0x0096:
            r5.zzq = r1
            if (r8 == 0) goto L_0x009f
            int r1 = r8.zzh()
            goto L_0x00a0
        L_0x009f:
            r1 = 0
        L_0x00a0:
            r5.zzr = r1
            com.google.android.gms.internal.ads.zzto r1 = new com.google.android.gms.internal.ads.zzto
            com.google.android.gms.ads.internal.util.zzs r2 = com.google.android.gms.ads.internal.zzt.zzp()
            com.google.android.gms.internal.ads.zzcgv r8 = r8.zzp()
            java.lang.String r8 = r8.zza
            java.lang.String r6 = r2.zzc(r6, r8)
            boolean r8 = r5.zzl
            if (r8 == 0) goto L_0x00d2
            java.nio.ByteBuffer r8 = r5.zzk
            int r8 = r8.limit()
            if (r8 <= 0) goto L_0x00d2
            java.nio.ByteBuffer r6 = r5.zzk
            int r6 = r6.limit()
            byte[] r6 = new byte[r6]
            java.nio.ByteBuffer r7 = r5.zzk
            r7.get(r6)
            com.google.android.gms.internal.ads.zzclr r7 = new com.google.android.gms.internal.ads.zzclr
            r7.<init>(r6)
            goto L_0x013e
        L_0x00d2:
            com.google.android.gms.internal.ads.zzbiu r8 = com.google.android.gms.internal.ads.zzbjc.zzbM
            com.google.android.gms.internal.ads.zzbja r2 = com.google.android.gms.ads.internal.client.zzay.zzc()
            java.lang.Object r8 = r2.zzb(r8)
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            r2 = 1
            if (r8 == 0) goto L_0x00f7
            com.google.android.gms.internal.ads.zzbiu r8 = com.google.android.gms.internal.ads.zzbjc.zzbD
            com.google.android.gms.internal.ads.zzbja r3 = com.google.android.gms.ads.internal.client.zzay.zzc()
            java.lang.Object r8 = r3.zzb(r8)
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 != 0) goto L_0x00fb
        L_0x00f7:
            boolean r8 = r7.zzj
            if (r8 != 0) goto L_0x00fc
        L_0x00fb:
            r0 = 1
        L_0x00fc:
            boolean r8 = r7.zzo
            if (r8 == 0) goto L_0x0106
            com.google.android.gms.internal.ads.zzclt r8 = new com.google.android.gms.internal.ads.zzclt
            r8.<init>(r5, r6, r0)
            goto L_0x0115
        L_0x0106:
            int r8 = r7.zzi
            if (r8 <= 0) goto L_0x0110
            com.google.android.gms.internal.ads.zzclu r8 = new com.google.android.gms.internal.ads.zzclu
            r8.<init>(r5, r6, r0)
            goto L_0x0115
        L_0x0110:
            com.google.android.gms.internal.ads.zzclv r8 = new com.google.android.gms.internal.ads.zzclv
            r8.<init>(r5, r6, r0)
        L_0x0115:
            boolean r6 = r7.zzj
            if (r6 == 0) goto L_0x0120
            com.google.android.gms.internal.ads.zzclw r6 = new com.google.android.gms.internal.ads.zzclw
            r6.<init>(r5, r8)
            r7 = r6
            goto L_0x0121
        L_0x0120:
            r7 = r8
        L_0x0121:
            java.nio.ByteBuffer r6 = r5.zzk
            if (r6 == 0) goto L_0x013e
            int r6 = r6.limit()
            if (r6 <= 0) goto L_0x013e
            java.nio.ByteBuffer r6 = r5.zzk
            int r6 = r6.limit()
            byte[] r6 = new byte[r6]
            java.nio.ByteBuffer r8 = r5.zzk
            r8.get(r6)
            com.google.android.gms.internal.ads.zzclx r8 = new com.google.android.gms.internal.ads.zzclx
            r8.<init>(r7, r6)
            r7 = r8
        L_0x013e:
            com.google.android.gms.internal.ads.zzbiu r6 = com.google.android.gms.internal.ads.zzbjc.zzm
            com.google.android.gms.internal.ads.zzbja r8 = com.google.android.gms.ads.internal.client.zzay.zzc()
            java.lang.Object r6 = r8.zzb(r6)
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 == 0) goto L_0x0153
            com.google.android.gms.internal.ads.zzcma r6 = com.google.android.gms.internal.ads.zzcma.zza
            goto L_0x0155
        L_0x0153:
            com.google.android.gms.internal.ads.zzcmb r6 = com.google.android.gms.internal.ads.zzcmb.zza
        L_0x0155:
            com.google.android.gms.internal.ads.zztn r8 = new com.google.android.gms.internal.ads.zztn
            r8.<init>(r6)
            r1.<init>(r7, r8, r4)
            r5.zzi = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcmc.<init>(android.content.Context, com.google.android.gms.internal.ads.zzcix, com.google.android.gms.internal.ads.zzciy):void");
    }

    private final boolean zzZ() {
        return this.zzu != null && this.zzu.zzq();
    }

    public final void finalize() {
        zza.decrementAndGet();
        if (zze.zzc()) {
            zze.zza("OfficialSimpleExoPlayerAdapter finalize ".concat(toString()));
        }
    }

    public final long zzA() {
        if (!zzZ()) {
            return (long) this.zzn;
        }
        return 0;
    }

    public final long zzB() {
        if (zzZ()) {
            return this.zzu.zzl();
        }
        synchronized (this.zzs) {
            while (!this.zzt.isEmpty()) {
                long j = this.zzp;
                Map zze2 = ((zzfu) this.zzt.remove(0)).zze();
                long j2 = 0;
                if (zze2 != null) {
                    Iterator it = zze2.entrySet().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Map.Entry entry = (Map.Entry) it.next();
                        if (entry != null) {
                            try {
                                if (!(entry.getKey() == null || !zzfse.zzc("content-length", (CharSequence) entry.getKey()) || entry.getValue() == null || ((List) entry.getValue()).get(0) == null)) {
                                    j2 = Long.parseLong((String) ((List) entry.getValue()).get(0));
                                    break;
                                }
                            } catch (NumberFormatException unused) {
                                continue;
                            }
                        }
                    }
                }
                this.zzp = j + j2;
            }
        }
        return this.zzp;
    }

    public final void zzC(Uri[] uriArr, String str) {
        zzD(uriArr, str, ByteBuffer.allocate(0), false);
    }

    public final void zzE() {
        zzkf zzkf = this.zzj;
        if (zzkf != null) {
            zzkf.zzA(this);
            this.zzj.zzz();
            this.zzj = null;
            zzb.decrementAndGet();
        }
    }

    public final void zzF(long j) {
        zzkf zzkf = this.zzj;
        zzkf.zzp(zzkf.zzf(), j);
    }

    public final void zzG(int i) {
        this.zze.zzk(i);
    }

    public final void zzH(int i) {
        this.zze.zzl(i);
    }

    public final void zzI(zzcio zzcio) {
        this.zzm = zzcio;
    }

    public final void zzJ(int i) {
        this.zze.zzm(i);
    }

    public final void zzK(int i) {
        this.zze.zzn(i);
    }

    public final void zzL(boolean z) {
        this.zzj.zzC(z);
    }

    public final void zzM(boolean z) {
        if (this.zzj != null) {
            int i = 0;
            while (true) {
                this.zzj.zzt();
                if (i < 2) {
                    zzvr zzvr = this.zzf;
                    zzvd zzc2 = zzvr.zzc().zzc();
                    zzc2.zzo(i, !z);
                    zzvr.zzj(zzc2);
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    public final void zzN(int i) {
        for (WeakReference weakReference : this.zzv) {
            zzclm zzclm = (zzclm) weakReference.get();
            if (zzclm != null) {
                zzclm.zzm(i);
            }
        }
    }

    public final void zzO(Surface surface, boolean z) {
        zzkf zzkf = this.zzj;
        if (zzkf != null) {
            zzkf.zzE(surface);
        }
    }

    public final void zzP(float f, boolean z) {
        zzkf zzkf = this.zzj;
        if (zzkf != null) {
            zzkf.zzF(f);
        }
    }

    public final void zzQ() {
        this.zzj.zzG();
    }

    public final boolean zzR() {
        return this.zzj != null;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzex zzS(String str, boolean z) {
        zzcmc zzcmc = true != z ? null : this;
        zzcix zzcix = this.zzg;
        return new zzcmf(str, zzcmc, zzcix.zzd, zzcix.zzf, zzcix.zzp, zzcix.zzq);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzex zzT(String str, boolean z) {
        zzcmc zzcmc = true != z ? null : this;
        zzcix zzcix = this.zzg;
        zzclm zzclm = new zzclm(str, zzcmc, zzcix.zzd, zzcix.zzf, zzcix.zzi);
        this.zzv.add(new WeakReference(zzclm));
        return zzclm;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzex zzU(String str, boolean z) {
        zzff zzff = new zzff();
        zzff.zzf(str);
        zzff.zze(true != z ? null : this);
        zzff.zzc(this.zzg.zzd);
        zzff.zzd(this.zzg.zzf);
        zzff.zzb(true);
        return zzff.zza();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzex zzV(zzew zzew) {
        return new zzclp(this.zzd, zzew.zza(), this.zzq, this.zzr, this, new zzcls(this), (byte[]) null);
    }

    /* access modifiers changed from: package-private */
    public final zzsk zzW(Uri uri) {
        zzaj zzaj = new zzaj();
        zzaj.zzb(uri);
        zzbg zzc2 = zzaj.zzc();
        zzto zzto = this.zzi;
        zzto.zza(this.zzg.zzg);
        return zzto.zzb(zzc2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzX(boolean z, long j) {
        zzcio zzcio = this.zzm;
        if (zzcio != null) {
            zzcio.zzi(z, j);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzka[] zzY(Handler handler, zzyd zzyd, zzns zzns, zzuj zzuj, zzri zzri) {
        Context context = this.zzd;
        zzqs zzqs = zzqs.zzb;
        zznd zznd = zznd.zza;
        zzng[] zzngArr = new zzng[0];
        zzoi zzoi = new zzoi();
        zznd zznd2 = zznd.zza;
        if (zznd == null) {
            if (zznd2 != null) {
                zznd = zznd2;
            } else {
                throw new NullPointerException("Both parameters are null");
            }
        }
        zzoi.zzb(zznd);
        zzoi.zzc(zzngArr);
        return new zzka[]{new zzpa(context, zzqk.zza, zzqs, false, handler, zzns, zzoi.zzd()), new zzxg(this.zzd, zzqk.zza, zzqs.zzb, 0, false, handler, zzyd, -1, 30.0f)};
    }

    public final void zza(zzex zzex, zzfc zzfc, boolean z, int i) {
        this.zzn += i;
    }

    public final void zzb(zzex zzex, zzfc zzfc, boolean z) {
    }

    public final void zzc(zzex zzex, zzfc zzfc, boolean z) {
    }

    public final void zzd(zzex zzex, zzfc zzfc, boolean z) {
        if (zzex instanceof zzfu) {
            synchronized (this.zzs) {
                this.zzt.add((zzfu) zzex);
            }
        } else if (zzex instanceof zzclp) {
            this.zzu = (zzclp) zzex;
            zzciy zzciy = (zzciy) this.zzh.get();
            if (((Boolean) zzay.zzc().zzb(zzbjc.zzbD)).booleanValue() && zzciy != null && this.zzu.zzn()) {
                HashMap hashMap = new HashMap();
                hashMap.put("gcacheHit", String.valueOf(this.zzu.zzp()));
                hashMap.put("gcacheDownloaded", String.valueOf(this.zzu.zzo()));
                zzs.zza.post(new zzclz(zzciy, hashMap));
            }
        }
    }

    public final void zze(zzkp zzkp, zzaf zzaf, zzgt zzgt) {
        zzciy zzciy = (zzciy) this.zzh.get();
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzbD)).booleanValue() && zzciy != null && zzaf != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("audioMime", zzaf.zzl);
            hashMap.put("audioSampleMime", zzaf.zzm);
            hashMap.put("audioCodec", zzaf.zzj);
            zzciy.zzd("onMetadataEvent", hashMap);
        }
    }

    public final /* synthetic */ void zzf(zzkp zzkp, int i, long j, long j2) {
    }

    public final /* synthetic */ void zzg(zzkp zzkp, zzse zzse) {
    }

    public final void zzh(zzkp zzkp, int i, long j) {
        this.zzo += i;
    }

    public final /* synthetic */ void zzi(zzcg zzcg, zzkq zzkq) {
    }

    public final void zzj(zzkp zzkp, zzrz zzrz, zzse zzse, IOException iOException, boolean z) {
        zzcio zzcio = this.zzm;
        if (zzcio == null) {
            return;
        }
        if (this.zzg.zzl) {
            zzcio.zzl("onLoadException", iOException);
        } else {
            zzcio.zzk("onLoadError", iOException);
        }
    }

    public final void zzk(zzkp zzkp, int i) {
        zzcio zzcio = this.zzm;
        if (zzcio != null) {
            zzcio.zzm(i);
        }
    }

    public final void zzl(zzkp zzkp, zzbw zzbw) {
        zzcio zzcio = this.zzm;
        if (zzcio != null) {
            zzcio.zzk("onPlayerError", zzbw);
        }
    }

    public final /* synthetic */ void zzm(zzkp zzkp, zzcf zzcf, zzcf zzcf2, int i) {
    }

    public final void zzn(zzkp zzkp, Object obj, long j) {
        zzcio zzcio = this.zzm;
        if (zzcio != null) {
            zzcio.zzv();
        }
    }

    public final /* synthetic */ void zzo(zzkp zzkp, zzgs zzgs) {
    }

    public final void zzp(zzkp zzkp, zzaf zzaf, zzgt zzgt) {
        zzciy zzciy = (zzciy) this.zzh.get();
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzbD)).booleanValue() && zzciy != null && zzaf != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("frameRate", String.valueOf(zzaf.zzt));
            hashMap.put("bitRate", String.valueOf(zzaf.zzi));
            int i = zzaf.zzr;
            int i2 = zzaf.zzs;
            hashMap.put("resolution", i + "x" + i2);
            hashMap.put("videoMime", zzaf.zzl);
            hashMap.put("videoSampleMime", zzaf.zzm);
            hashMap.put("videoCodec", zzaf.zzj);
            zzciy.zzd("onMetadataEvent", hashMap);
        }
    }

    public final void zzq(zzkp zzkp, zzda zzda) {
        zzcio zzcio = this.zzm;
        if (zzcio != null) {
            zzcio.zzC(zzda.zzc, zzda.zzd);
        }
    }

    public final int zzr() {
        return this.zzo;
    }

    public final int zzt() {
        return this.zzj.zzh();
    }

    public final long zzv() {
        return this.zzj.zzu();
    }

    public final long zzw() {
        return (long) this.zzn;
    }

    public final long zzx() {
        if (zzZ() && this.zzu.zzp()) {
            return Math.min((long) this.zzn, this.zzu.zzk());
        }
        return 0;
    }

    public final long zzy() {
        return this.zzj.zzl();
    }

    public final long zzz() {
        return this.zzj.zzv();
    }

    public final void zzD(Uri[] uriArr, String str, ByteBuffer byteBuffer, boolean z) {
        zzsk zzsk;
        if (this.zzj != null) {
            this.zzk = byteBuffer;
            this.zzl = z;
            int length = uriArr.length;
            if (length == 1) {
                zzsk = zzW(uriArr[0]);
            } else {
                zzsk[] zzskArr = new zzsk[length];
                for (int i = 0; i < uriArr.length; i++) {
                    zzskArr[i] = zzW(uriArr[i]);
                }
                zzsk = new zzta(false, false, zzskArr);
            }
            this.zzj.zzB(zzsk);
            this.zzj.zzy();
            zzb.incrementAndGet();
        }
    }
}

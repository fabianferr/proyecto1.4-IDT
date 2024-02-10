package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.InputDeviceCompat;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.HashMap;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzcim extends FrameLayout implements zzcid {
    final zzcja zza;
    private final zzciy zzb;
    private final FrameLayout zzc;
    private final View zzd;
    private final zzbjr zze;
    private final long zzf;
    private final zzcie zzg;
    private boolean zzh;
    private boolean zzi;
    private boolean zzj;
    private boolean zzk;
    private long zzl;
    private long zzm;
    private String zzn;
    private String[] zzo;
    private Bitmap zzp;
    private final ImageView zzq;
    private boolean zzr;
    private final Integer zzs;

    /* JADX WARNING: type inference failed for: r13v0, types: [com.google.android.gms.internal.ads.zzcie, android.view.View] */
    /* JADX WARNING: type inference failed for: r1v28, types: [com.google.android.gms.internal.ads.zzcic] */
    /* JADX WARNING: type inference failed for: r1v29, types: [com.google.android.gms.internal.ads.zzcjq] */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzcim(android.content.Context r16, com.google.android.gms.internal.ads.zzciy r17, int r18, boolean r19, com.google.android.gms.internal.ads.zzbjr r20, com.google.android.gms.internal.ads.zzcix r21, java.lang.Integer r22) {
        /*
            r15 = this;
            r0 = r15
            r9 = r16
            r10 = r20
            r15.<init>(r16)
            r7 = r17
            r0.zzb = r7
            r0.zze = r10
            android.widget.FrameLayout r11 = new android.widget.FrameLayout
            r11.<init>(r9)
            r0.zzc = r11
            android.widget.FrameLayout$LayoutParams r1 = new android.widget.FrameLayout$LayoutParams
            r12 = -1
            r1.<init>(r12, r12)
            r15.addView(r11, r1)
            com.google.android.gms.ads.internal.zza r1 = r17.zzm()
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r1)
            com.google.android.gms.ads.internal.zza r1 = r17.zzm()
            com.google.android.gms.internal.ads.zzcif r1 = r1.zza
            com.google.android.gms.internal.ads.zzciz r8 = new com.google.android.gms.internal.ads.zzciz
            com.google.android.gms.internal.ads.zzcgv r3 = r17.zzp()
            java.lang.String r4 = r17.zzu()
            com.google.android.gms.internal.ads.zzbjo r6 = r17.zzn()
            r1 = r8
            r2 = r16
            r5 = r20
            r1.<init>(r2, r3, r4, r5, r6)
            r1 = 2
            r2 = r18
            if (r2 != r1) goto L_0x005c
            com.google.android.gms.internal.ads.zzcjq r13 = new com.google.android.gms.internal.ads.zzcjq
            boolean r6 = com.google.android.gms.internal.ads.zzciq.zza(r17)
            r1 = r13
            r2 = r16
            r3 = r8
            r4 = r17
            r5 = r19
            r7 = r21
            r8 = r22
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            goto L_0x0086
        L_0x005c:
            com.google.android.gms.internal.ads.zzcic r13 = new com.google.android.gms.internal.ads.zzcic
            boolean r8 = com.google.android.gms.internal.ads.zzciq.zza(r17)
            com.google.android.gms.internal.ads.zzciz r14 = new com.google.android.gms.internal.ads.zzciz
            com.google.android.gms.internal.ads.zzcgv r3 = r17.zzp()
            java.lang.String r4 = r17.zzu()
            com.google.android.gms.internal.ads.zzbjo r6 = r17.zzn()
            r1 = r14
            r2 = r16
            r5 = r20
            r1.<init>(r2, r3, r4, r5, r6)
            r1 = r13
            r3 = r17
            r4 = r19
            r5 = r8
            r6 = r21
            r7 = r14
            r8 = r22
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
        L_0x0086:
            r0.zzg = r13
            r1 = r22
            r0.zzs = r1
            android.view.View r1 = new android.view.View
            r1.<init>(r9)
            r0.zzd = r1
            r2 = 0
            r1.setBackgroundColor(r2)
            android.widget.FrameLayout$LayoutParams r2 = new android.widget.FrameLayout$LayoutParams
            r3 = 17
            r2.<init>(r12, r12, r3)
            r11.addView(r13, r2)
            com.google.android.gms.internal.ads.zzbiu r2 = com.google.android.gms.internal.ads.zzbjc.zzD
            com.google.android.gms.internal.ads.zzbja r3 = com.google.android.gms.ads.internal.client.zzay.zzc()
            java.lang.Object r2 = r3.zzb(r2)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L_0x00be
            android.widget.FrameLayout$LayoutParams r2 = new android.widget.FrameLayout$LayoutParams
            r2.<init>(r12, r12)
            r11.addView(r1, r2)
            r11.bringChildToFront(r1)
        L_0x00be:
            com.google.android.gms.internal.ads.zzbiu r1 = com.google.android.gms.internal.ads.zzbjc.zzA
            com.google.android.gms.internal.ads.zzbja r2 = com.google.android.gms.ads.internal.client.zzay.zzc()
            java.lang.Object r1 = r2.zzb(r1)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x00d3
            r15.zzn()
        L_0x00d3:
            android.widget.ImageView r1 = new android.widget.ImageView
            r1.<init>(r9)
            r0.zzq = r1
            com.google.android.gms.internal.ads.zzbiu r1 = com.google.android.gms.internal.ads.zzbjc.zzF
            com.google.android.gms.internal.ads.zzbja r2 = com.google.android.gms.ads.internal.client.zzay.zzc()
            java.lang.Object r1 = r2.zzb(r1)
            java.lang.Long r1 = (java.lang.Long) r1
            long r1 = r1.longValue()
            r0.zzf = r1
            com.google.android.gms.internal.ads.zzbiu r1 = com.google.android.gms.internal.ads.zzbjc.zzC
            com.google.android.gms.internal.ads.zzbja r2 = com.google.android.gms.ads.internal.client.zzay.zzc()
            java.lang.Object r1 = r2.zzb(r1)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            r0.zzk = r1
            if (r10 == 0) goto L_0x010d
            r2 = 1
            if (r2 == r1) goto L_0x0106
            java.lang.String r1 = "0"
            goto L_0x0108
        L_0x0106:
            java.lang.String r1 = "1"
        L_0x0108:
            java.lang.String r2 = "spinner_used"
            r10.zzd(r2, r1)
        L_0x010d:
            com.google.android.gms.internal.ads.zzcja r1 = new com.google.android.gms.internal.ads.zzcja
            r1.<init>(r15)
            r0.zza = r1
            r13.zzr(r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcim.<init>(android.content.Context, com.google.android.gms.internal.ads.zzciy, int, boolean, com.google.android.gms.internal.ads.zzbjr, com.google.android.gms.internal.ads.zzcix, java.lang.Integer):void");
    }

    private final void zzJ() {
        if (this.zzb.zzk() != null && this.zzi && !this.zzj) {
            this.zzb.zzk().getWindow().clearFlags(128);
            this.zzi = false;
        }
    }

    /* access modifiers changed from: private */
    public final void zzK(String str, String... strArr) {
        HashMap hashMap = new HashMap();
        Integer zzl2 = zzl();
        if (zzl2 != null) {
            hashMap.put("playerId", zzl2.toString());
        }
        hashMap.put("event", str);
        String str2 = null;
        for (String str3 : strArr) {
            if (str2 == null) {
                str2 = str3;
            } else {
                hashMap.put(str2, str3);
                str2 = null;
            }
        }
        this.zzb.zzd("onVideoEvent", hashMap);
    }

    private final boolean zzL() {
        return this.zzq.getParent() != null;
    }

    public final void finalize() throws Throwable {
        try {
            this.zza.zza();
            zzcie zzcie = this.zzg;
            if (zzcie != null) {
                zzchc.zze.execute(new zzcig(zzcie));
            }
        } finally {
            super.finalize();
        }
    }

    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            this.zza.zzb();
        } else {
            this.zza.zza();
            this.zzm = this.zzl;
        }
        zzs.zza.post(new zzcih(this, z));
    }

    public final void onWindowVisibilityChanged(int i) {
        boolean z;
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            this.zza.zzb();
            z = true;
        } else {
            this.zza.zza();
            this.zzm = this.zzl;
            z = false;
        }
        zzs.zza.post(new zzcil(this, z));
    }

    public final void zzA(int i) {
        zzcie zzcie = this.zzg;
        if (zzcie != null) {
            zzcie.zzy(i);
        }
    }

    public final void zzB(int i) {
        zzcie zzcie = this.zzg;
        if (zzcie != null) {
            zzcie.zzz(i);
        }
    }

    public final void zzC(int i) {
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzD)).booleanValue()) {
            this.zzc.setBackgroundColor(i);
            this.zzd.setBackgroundColor(i);
        }
    }

    public final void zzD(int i) {
        zzcie zzcie = this.zzg;
        if (zzcie != null) {
            zzcie.zzA(i);
        }
    }

    public final void zzE(String str, String[] strArr) {
        this.zzn = str;
        this.zzo = strArr;
    }

    public final void zzF(int i, int i2, int i3, int i4) {
        if (zze.zzc()) {
            zze.zza("Set video bounds to x:" + i + ";y:" + i2 + ";w:" + i3 + ";h:" + i4);
        }
        if (i3 != 0 && i4 != 0) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i3, i4);
            layoutParams.setMargins(i, i2, 0, 0);
            this.zzc.setLayoutParams(layoutParams);
            requestLayout();
        }
    }

    public final void zzG(float f) {
        zzcie zzcie = this.zzg;
        if (zzcie != null) {
            zzcie.zzb.zze(f);
            zzcie.zzn();
        }
    }

    public final void zzH(float f, float f2) {
        zzcie zzcie = this.zzg;
        if (zzcie != null) {
            zzcie.zzu(f, f2);
        }
    }

    public final void zzI() {
        zzcie zzcie = this.zzg;
        if (zzcie != null) {
            zzcie.zzb.zzd(false);
            zzcie.zzn();
        }
    }

    public final void zza() {
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzbG)).booleanValue()) {
            this.zza.zza();
        }
        zzK("ended", new String[0]);
        zzJ();
    }

    public final void zzb(String str, String str2) {
        zzK("error", "what", str, "extra", str2);
    }

    public final void zzc(String str, String str2) {
        zzK("exception", "what", "ExoPlayerAdapter exception", "extra", str2);
    }

    public final void zzd() {
        zzK(CampaignEx.JSON_NATIVE_VIDEO_PAUSE, new String[0]);
        zzJ();
        this.zzh = false;
    }

    public final void zze() {
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzbG)).booleanValue()) {
            this.zza.zzb();
        }
        if (this.zzb.zzk() != null && !this.zzi) {
            boolean z = (this.zzb.zzk().getWindow().getAttributes().flags & 128) != 0;
            this.zzj = z;
            if (!z) {
                this.zzb.zzk().getWindow().addFlags(128);
                this.zzi = true;
            }
        }
        this.zzh = true;
    }

    public final void zzf() {
        zzcie zzcie = this.zzg;
        if (zzcie != null && this.zzm == 0) {
            zzK("canplaythrough", "duration", String.valueOf(((float) zzcie.zzc()) / 1000.0f), "videoWidth", String.valueOf(this.zzg.zze()), "videoHeight", String.valueOf(this.zzg.zzd()));
        }
    }

    public final void zzg() {
        this.zzd.setVisibility(4);
        zzs.zza.post(new zzcii(this));
    }

    public final void zzh() {
        this.zza.zzb();
        zzs.zza.post(new zzcij(this));
    }

    public final void zzi() {
        if (this.zzr && this.zzp != null && !zzL()) {
            this.zzq.setImageBitmap(this.zzp);
            this.zzq.invalidate();
            this.zzc.addView(this.zzq, new FrameLayout.LayoutParams(-1, -1));
            this.zzc.bringChildToFront(this.zzq);
        }
        this.zza.zza();
        this.zzm = this.zzl;
        zzs.zza.post(new zzcik(this));
    }

    public final void zzj(int i, int i2) {
        if (this.zzk) {
            int max = Math.max(i / ((Integer) zzay.zzc().zzb(zzbjc.zzE)).intValue(), 1);
            int max2 = Math.max(i2 / ((Integer) zzay.zzc().zzb(zzbjc.zzE)).intValue(), 1);
            Bitmap bitmap = this.zzp;
            if (bitmap == null || bitmap.getWidth() != max || this.zzp.getHeight() != max2) {
                this.zzp = Bitmap.createBitmap(max, max2, Bitmap.Config.ARGB_8888);
                this.zzr = false;
            }
        }
    }

    public final void zzk() {
        if (this.zzh && zzL()) {
            this.zzc.removeView(this.zzq);
        }
        if (this.zzg != null && this.zzp != null) {
            long elapsedRealtime = zzt.zzB().elapsedRealtime();
            if (this.zzg.getBitmap(this.zzp) != null) {
                this.zzr = true;
            }
            long elapsedRealtime2 = zzt.zzB().elapsedRealtime() - elapsedRealtime;
            if (zze.zzc()) {
                zze.zza("Spinner frame grab took " + elapsedRealtime2 + "ms");
            }
            if (elapsedRealtime2 > this.zzf) {
                zze.zzj("Spinner frame grab crossed jank threshold! Suspending spinner.");
                this.zzk = false;
                this.zzp = null;
                zzbjr zzbjr = this.zze;
                if (zzbjr != null) {
                    zzbjr.zzd("spinner_jank", Long.toString(elapsedRealtime2));
                }
            }
        }
    }

    public final Integer zzl() {
        zzcie zzcie = this.zzg;
        return zzcie != null ? zzcie.zzc : this.zzs;
    }

    public final void zzn() {
        zzcie zzcie = this.zzg;
        if (zzcie != null) {
            TextView textView = new TextView(zzcie.getContext());
            textView.setText("AdMob - ".concat(this.zzg.zzj()));
            textView.setTextColor(SupportMenu.CATEGORY_MASK);
            textView.setBackgroundColor(InputDeviceCompat.SOURCE_ANY);
            this.zzc.addView(textView, new FrameLayout.LayoutParams(-2, -2, 17));
            this.zzc.bringChildToFront(textView);
        }
    }

    public final void zzo() {
        this.zza.zza();
        zzcie zzcie = this.zzg;
        if (zzcie != null) {
            zzcie.zzt();
        }
        zzJ();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzp() {
        zzK("firstFrameRendered", new String[0]);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzq(boolean z) {
        zzK("windowFocusChanged", "hasWindowFocus", String.valueOf(z));
    }

    public final void zzr() {
        if (this.zzg != null) {
            if (!TextUtils.isEmpty(this.zzn)) {
                this.zzg.zzB(this.zzn, this.zzo);
            } else {
                zzK("no_src", new String[0]);
            }
        }
    }

    public final void zzs() {
        zzcie zzcie = this.zzg;
        if (zzcie != null) {
            zzcie.zzb.zzd(true);
            zzcie.zzn();
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzt() {
        zzcie zzcie = this.zzg;
        if (zzcie != null) {
            long zza2 = (long) zzcie.zza();
            if (this.zzl != zza2 && zza2 > 0) {
                float f = ((float) zza2) / 1000.0f;
                if (((Boolean) zzay.zzc().zzb(zzbjc.zzbD)).booleanValue()) {
                    zzK("timeupdate", "time", String.valueOf(f), "totalBytes", String.valueOf(this.zzg.zzh()), "qoeCachedBytes", String.valueOf(this.zzg.zzf()), "qoeLoadedBytes", String.valueOf(this.zzg.zzg()), "droppedFrames", String.valueOf(this.zzg.zzb()), "reportTime", String.valueOf(zzt.zzB().currentTimeMillis()));
                } else {
                    zzK("timeupdate", "time", String.valueOf(f));
                }
                this.zzl = zza2;
            }
        }
    }

    public final void zzu() {
        zzcie zzcie = this.zzg;
        if (zzcie != null) {
            zzcie.zzo();
        }
    }

    public final void zzv() {
        zzcie zzcie = this.zzg;
        if (zzcie != null) {
            zzcie.zzp();
        }
    }

    public final void zzw(int i) {
        zzcie zzcie = this.zzg;
        if (zzcie != null) {
            zzcie.zzq(i);
        }
    }

    public final void zzx(MotionEvent motionEvent) {
        zzcie zzcie = this.zzg;
        if (zzcie != null) {
            zzcie.dispatchTouchEvent(motionEvent);
        }
    }

    public final void zzy(int i) {
        zzcie zzcie = this.zzg;
        if (zzcie != null) {
            zzcie.zzw(i);
        }
    }

    public final void zzz(int i) {
        zzcie zzcie = this.zzg;
        if (zzcie != null) {
            zzcie.zzx(i);
        }
    }
}

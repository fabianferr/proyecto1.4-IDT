package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.google.android.gms.common.util.CollectionUtils;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzbxz extends zzbyf {
    static final Set zza = CollectionUtils.setOf("top-left", "top-right", "top-center", "center", "bottom-left", "bottom-right", "bottom-center");
    private String zzb = "top-right";
    private boolean zzc = true;
    private int zzd = 0;
    private int zze = 0;
    private int zzf = -1;
    private int zzg = 0;
    private int zzh = 0;
    private int zzi = -1;
    private final Object zzj = new Object();
    private final zzcmp zzk;
    private final Activity zzl;
    private zzcoe zzm;
    private ImageView zzn;
    private LinearLayout zzo;
    private final zzbyg zzp;
    private PopupWindow zzq;
    private RelativeLayout zzr;
    private ViewGroup zzs;

    public zzbxz(zzcmp zzcmp, zzbyg zzbyg) {
        super(zzcmp, "resize");
        this.zzk = zzcmp;
        this.zzl = zzcmp.zzk();
        this.zzp = zzbyg;
    }

    public final void zza(boolean z) {
        synchronized (this.zzj) {
            PopupWindow popupWindow = this.zzq;
            if (popupWindow != null) {
                popupWindow.dismiss();
                this.zzr.removeView((View) this.zzk);
                ViewGroup viewGroup = this.zzs;
                if (viewGroup != null) {
                    viewGroup.removeView(this.zzn);
                    this.zzs.addView((View) this.zzk);
                    this.zzk.zzai(this.zzm);
                }
                if (z) {
                    zzk("default");
                    zzbyg zzbyg = this.zzp;
                    if (zzbyg != null) {
                        zzbyg.zzb();
                    }
                }
                this.zzq = null;
                this.zzr = null;
                this.zzs = null;
                this.zzo = null;
            }
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x01fe A[Catch:{ RuntimeException -> 0x0438 }] */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0200 A[Catch:{ RuntimeException -> 0x0438 }] */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0269 A[Catch:{ RuntimeException -> 0x0438 }] */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x0270 A[Catch:{ RuntimeException -> 0x0438 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzb(java.util.Map r19) {
        /*
            r18 = this;
            r1 = r18
            r0 = r19
            java.lang.String r2 = "Cannot show popup window: "
            java.lang.Object r3 = r1.zzj
            monitor-enter(r3)
            android.app.Activity r4 = r1.zzl     // Catch:{ all -> 0x048c }
            if (r4 != 0) goto L_0x0014
            java.lang.String r0 = "Not an activity context. Cannot resize."
            r1.zzg(r0)     // Catch:{ all -> 0x048c }
            monitor-exit(r3)     // Catch:{ all -> 0x048c }
            return
        L_0x0014:
            com.google.android.gms.internal.ads.zzcmp r4 = r1.zzk     // Catch:{ all -> 0x048c }
            com.google.android.gms.internal.ads.zzcoe r4 = r4.zzQ()     // Catch:{ all -> 0x048c }
            if (r4 != 0) goto L_0x0023
            java.lang.String r0 = "Webview is not yet available, size is not set."
            r1.zzg(r0)     // Catch:{ all -> 0x048c }
            monitor-exit(r3)     // Catch:{ all -> 0x048c }
            return
        L_0x0023:
            com.google.android.gms.internal.ads.zzcmp r4 = r1.zzk     // Catch:{ all -> 0x048c }
            com.google.android.gms.internal.ads.zzcoe r4 = r4.zzQ()     // Catch:{ all -> 0x048c }
            boolean r4 = r4.zzi()     // Catch:{ all -> 0x048c }
            if (r4 == 0) goto L_0x0036
            java.lang.String r0 = "Is interstitial. Cannot resize an interstitial."
            r1.zzg(r0)     // Catch:{ all -> 0x048c }
            monitor-exit(r3)     // Catch:{ all -> 0x048c }
            return
        L_0x0036:
            com.google.android.gms.internal.ads.zzcmp r4 = r1.zzk     // Catch:{ all -> 0x048c }
            boolean r4 = r4.zzaC()     // Catch:{ all -> 0x048c }
            if (r4 != 0) goto L_0x0485
            java.lang.String r4 = "width"
            java.lang.Object r4 = r0.get(r4)     // Catch:{ all -> 0x048c }
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4     // Catch:{ all -> 0x048c }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x048c }
            if (r4 != 0) goto L_0x005d
            com.google.android.gms.ads.internal.zzt.zzp()     // Catch:{ all -> 0x048c }
            java.lang.String r4 = "width"
            java.lang.Object r4 = r0.get(r4)     // Catch:{ all -> 0x048c }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x048c }
            int r4 = com.google.android.gms.ads.internal.util.zzs.zzK(r4)     // Catch:{ all -> 0x048c }
            r1.zzi = r4     // Catch:{ all -> 0x048c }
        L_0x005d:
            java.lang.String r4 = "height"
            java.lang.Object r4 = r0.get(r4)     // Catch:{ all -> 0x048c }
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4     // Catch:{ all -> 0x048c }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x048c }
            if (r4 != 0) goto L_0x007c
            com.google.android.gms.ads.internal.zzt.zzp()     // Catch:{ all -> 0x048c }
            java.lang.String r4 = "height"
            java.lang.Object r4 = r0.get(r4)     // Catch:{ all -> 0x048c }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x048c }
            int r4 = com.google.android.gms.ads.internal.util.zzs.zzK(r4)     // Catch:{ all -> 0x048c }
            r1.zzf = r4     // Catch:{ all -> 0x048c }
        L_0x007c:
            java.lang.String r4 = "offsetX"
            java.lang.Object r4 = r0.get(r4)     // Catch:{ all -> 0x048c }
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4     // Catch:{ all -> 0x048c }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x048c }
            if (r4 != 0) goto L_0x009b
            com.google.android.gms.ads.internal.zzt.zzp()     // Catch:{ all -> 0x048c }
            java.lang.String r4 = "offsetX"
            java.lang.Object r4 = r0.get(r4)     // Catch:{ all -> 0x048c }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x048c }
            int r4 = com.google.android.gms.ads.internal.util.zzs.zzK(r4)     // Catch:{ all -> 0x048c }
            r1.zzg = r4     // Catch:{ all -> 0x048c }
        L_0x009b:
            java.lang.String r4 = "offsetY"
            java.lang.Object r4 = r0.get(r4)     // Catch:{ all -> 0x048c }
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4     // Catch:{ all -> 0x048c }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x048c }
            if (r4 != 0) goto L_0x00ba
            com.google.android.gms.ads.internal.zzt.zzp()     // Catch:{ all -> 0x048c }
            java.lang.String r4 = "offsetY"
            java.lang.Object r4 = r0.get(r4)     // Catch:{ all -> 0x048c }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x048c }
            int r4 = com.google.android.gms.ads.internal.util.zzs.zzK(r4)     // Catch:{ all -> 0x048c }
            r1.zzh = r4     // Catch:{ all -> 0x048c }
        L_0x00ba:
            java.lang.String r4 = "allowOffscreen"
            java.lang.Object r4 = r0.get(r4)     // Catch:{ all -> 0x048c }
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4     // Catch:{ all -> 0x048c }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x048c }
            if (r4 != 0) goto L_0x00d6
            java.lang.String r4 = "allowOffscreen"
            java.lang.Object r4 = r0.get(r4)     // Catch:{ all -> 0x048c }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x048c }
            boolean r4 = java.lang.Boolean.parseBoolean(r4)     // Catch:{ all -> 0x048c }
            r1.zzc = r4     // Catch:{ all -> 0x048c }
        L_0x00d6:
            java.lang.String r4 = "customClosePosition"
            java.lang.Object r0 = r0.get(r4)     // Catch:{ all -> 0x048c }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x048c }
            boolean r4 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x048c }
            if (r4 != 0) goto L_0x00e6
            r1.zzb = r0     // Catch:{ all -> 0x048c }
        L_0x00e6:
            int r0 = r1.zzi     // Catch:{ all -> 0x048c }
            if (r0 < 0) goto L_0x047e
            int r0 = r1.zzf     // Catch:{ all -> 0x048c }
            if (r0 < 0) goto L_0x047e
            android.app.Activity r0 = r1.zzl     // Catch:{ all -> 0x048c }
            android.view.Window r0 = r0.getWindow()     // Catch:{ all -> 0x048c }
            if (r0 == 0) goto L_0x0477
            android.view.View r4 = r0.getDecorView()     // Catch:{ all -> 0x048c }
            if (r4 != 0) goto L_0x00fe
            goto L_0x0477
        L_0x00fe:
            com.google.android.gms.ads.internal.zzt.zzp()     // Catch:{ all -> 0x048c }
            android.app.Activity r4 = r1.zzl     // Catch:{ all -> 0x048c }
            int[] r4 = com.google.android.gms.ads.internal.util.zzs.zzR(r4)     // Catch:{ all -> 0x048c }
            com.google.android.gms.ads.internal.zzt.zzp()     // Catch:{ all -> 0x048c }
            android.app.Activity r5 = r1.zzl     // Catch:{ all -> 0x048c }
            int[] r5 = com.google.android.gms.ads.internal.util.zzs.zzO(r5)     // Catch:{ all -> 0x048c }
            r6 = 0
            r7 = r4[r6]     // Catch:{ all -> 0x048c }
            r8 = 1
            r4 = r4[r8]     // Catch:{ all -> 0x048c }
            int r9 = r1.zzi     // Catch:{ all -> 0x048c }
            r10 = 5
            r11 = 4
            r12 = 3
            r14 = 2
            r15 = 50
            r16 = 0
            if (r9 < r15) goto L_0x0262
            if (r9 <= r7) goto L_0x0126
            goto L_0x0262
        L_0x0126:
            int r13 = r1.zzf     // Catch:{ all -> 0x048c }
            if (r13 < r15) goto L_0x025c
            if (r13 <= r4) goto L_0x012e
            goto L_0x025c
        L_0x012e:
            if (r13 != r4) goto L_0x0139
            if (r9 != r7) goto L_0x0139
            java.lang.String r4 = "Cannot resize to a full-screen ad."
            com.google.android.gms.ads.internal.util.zze.zzj(r4)     // Catch:{ all -> 0x048c }
            goto L_0x0267
        L_0x0139:
            boolean r4 = r1.zzc     // Catch:{ all -> 0x048c }
            if (r4 == 0) goto L_0x0214
            java.lang.String r4 = r1.zzb     // Catch:{ all -> 0x048c }
            int r17 = r4.hashCode()     // Catch:{ all -> 0x048c }
            switch(r17) {
                case -1364013995: goto L_0x0179;
                case -1012429441: goto L_0x016f;
                case -655373719: goto L_0x0165;
                case 1163912186: goto L_0x015b;
                case 1288627767: goto L_0x0151;
                case 1755462605: goto L_0x0147;
                default: goto L_0x0146;
            }
        L_0x0146:
            goto L_0x0183
        L_0x0147:
            java.lang.String r6 = "top-center"
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L_0x0183
            r4 = 1
            goto L_0x0184
        L_0x0151:
            java.lang.String r6 = "bottom-center"
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L_0x0183
            r4 = 4
            goto L_0x0184
        L_0x015b:
            java.lang.String r6 = "bottom-right"
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L_0x0183
            r4 = 5
            goto L_0x0184
        L_0x0165:
            java.lang.String r6 = "bottom-left"
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L_0x0183
            r4 = 3
            goto L_0x0184
        L_0x016f:
            java.lang.String r6 = "top-left"
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L_0x0183
            r4 = 0
            goto L_0x0184
        L_0x0179:
            java.lang.String r6 = "center"
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L_0x0183
            r4 = 2
            goto L_0x0184
        L_0x0183:
            r4 = -1
        L_0x0184:
            if (r4 == 0) goto L_0x01e6
            if (r4 == r8) goto L_0x01d7
            if (r4 == r14) goto L_0x01c2
            if (r4 == r12) goto L_0x01b5
            if (r4 == r11) goto L_0x01a6
            if (r4 == r10) goto L_0x019b
            int r4 = r1.zzd     // Catch:{ all -> 0x048c }
            int r6 = r1.zzg     // Catch:{ all -> 0x048c }
            int r4 = r4 + r6
            int r4 = r4 + r9
            int r4 = r4 + -50
            int r6 = r1.zze     // Catch:{ all -> 0x048c }
            goto L_0x01e3
        L_0x019b:
            int r4 = r1.zzd     // Catch:{ all -> 0x048c }
            int r6 = r1.zzg     // Catch:{ all -> 0x048c }
            int r4 = r4 + r6
            int r4 = r4 + r9
            int r4 = r4 + -50
            int r6 = r1.zze     // Catch:{ all -> 0x048c }
            goto L_0x01b2
        L_0x01a6:
            int r4 = r1.zzd     // Catch:{ all -> 0x048c }
            int r6 = r1.zzg     // Catch:{ all -> 0x048c }
            int r4 = r4 + r6
            int r6 = r9 >> 1
            int r4 = r4 + r6
            int r4 = r4 + -25
            int r6 = r1.zze     // Catch:{ all -> 0x048c }
        L_0x01b2:
            int r9 = r1.zzh     // Catch:{ all -> 0x048c }
            goto L_0x01bd
        L_0x01b5:
            int r4 = r1.zzd     // Catch:{ all -> 0x048c }
            int r6 = r1.zzg     // Catch:{ all -> 0x048c }
            int r4 = r4 + r6
            int r6 = r1.zze     // Catch:{ all -> 0x048c }
            goto L_0x01b2
        L_0x01bd:
            int r6 = r6 + r9
            int r6 = r6 + r13
            int r6 = r6 + -50
            goto L_0x01ef
        L_0x01c2:
            int r4 = r1.zzd     // Catch:{ all -> 0x048c }
            int r6 = r1.zzg     // Catch:{ all -> 0x048c }
            int r4 = r4 + r6
            int r6 = r9 >> 1
            int r4 = r4 + r6
            int r4 = r4 + -25
            int r6 = r1.zze     // Catch:{ all -> 0x048c }
            int r9 = r1.zzh     // Catch:{ all -> 0x048c }
            int r6 = r6 + r9
            int r9 = r13 >> 1
            int r6 = r6 + r9
            int r6 = r6 + -25
            goto L_0x01ef
        L_0x01d7:
            int r4 = r1.zzd     // Catch:{ all -> 0x048c }
            int r6 = r1.zzg     // Catch:{ all -> 0x048c }
            int r4 = r4 + r6
            int r6 = r9 >> 1
            int r4 = r4 + r6
            int r4 = r4 + -25
            int r6 = r1.zze     // Catch:{ all -> 0x048c }
        L_0x01e3:
            int r9 = r1.zzh     // Catch:{ all -> 0x048c }
            goto L_0x01ee
        L_0x01e6:
            int r4 = r1.zzd     // Catch:{ all -> 0x048c }
            int r6 = r1.zzg     // Catch:{ all -> 0x048c }
            int r4 = r4 + r6
            int r6 = r1.zze     // Catch:{ all -> 0x048c }
            goto L_0x01e3
        L_0x01ee:
            int r6 = r6 + r9
        L_0x01ef:
            if (r4 < 0) goto L_0x0267
            int r4 = r4 + r15
            if (r4 > r7) goto L_0x0267
            r4 = 0
            r7 = r5[r4]     // Catch:{ all -> 0x048c }
            if (r6 < r7) goto L_0x0267
            int r6 = r6 + r15
            r4 = r5[r8]     // Catch:{ all -> 0x048c }
            if (r6 <= r4) goto L_0x0200
            goto L_0x0267
        L_0x0200:
            int[] r4 = new int[r14]     // Catch:{ all -> 0x048c }
            int r5 = r1.zzd     // Catch:{ all -> 0x048c }
            int r6 = r1.zzg     // Catch:{ all -> 0x048c }
            int r5 = r5 + r6
            r6 = 0
            r4[r6] = r5     // Catch:{ all -> 0x048c }
            int r5 = r1.zze     // Catch:{ all -> 0x048c }
            int r6 = r1.zzh     // Catch:{ all -> 0x048c }
            int r5 = r5 + r6
            r4[r8] = r5     // Catch:{ all -> 0x048c }
            r16 = r4
            goto L_0x0267
        L_0x0214:
            com.google.android.gms.ads.internal.zzt.zzp()     // Catch:{ all -> 0x048c }
            android.app.Activity r4 = r1.zzl     // Catch:{ all -> 0x048c }
            int[] r4 = com.google.android.gms.ads.internal.util.zzs.zzR(r4)     // Catch:{ all -> 0x048c }
            com.google.android.gms.ads.internal.zzt.zzp()     // Catch:{ all -> 0x048c }
            android.app.Activity r5 = r1.zzl     // Catch:{ all -> 0x048c }
            int[] r5 = com.google.android.gms.ads.internal.util.zzs.zzO(r5)     // Catch:{ all -> 0x048c }
            r6 = 0
            r4 = r4[r6]     // Catch:{ all -> 0x048c }
            int r6 = r1.zzd     // Catch:{ all -> 0x048c }
            int r7 = r1.zzg     // Catch:{ all -> 0x048c }
            int r6 = r6 + r7
            int r7 = r1.zze     // Catch:{ all -> 0x048c }
            int r9 = r1.zzh     // Catch:{ all -> 0x048c }
            int r7 = r7 + r9
            if (r6 >= 0) goto L_0x0238
            r4 = 0
        L_0x0236:
            r6 = 0
            goto L_0x0242
        L_0x0238:
            int r9 = r1.zzi     // Catch:{ all -> 0x048c }
            int r13 = r6 + r9
            if (r13 <= r4) goto L_0x0240
            int r4 = r4 - r9
            goto L_0x0236
        L_0x0240:
            r4 = r6
            goto L_0x0236
        L_0x0242:
            r9 = r5[r6]     // Catch:{ all -> 0x048c }
            if (r7 >= r9) goto L_0x0248
            r7 = r9
            goto L_0x0252
        L_0x0248:
            int r6 = r1.zzf     // Catch:{ all -> 0x048c }
            int r9 = r7 + r6
            r5 = r5[r8]     // Catch:{ all -> 0x048c }
            if (r9 <= r5) goto L_0x0252
            int r7 = r5 - r6
        L_0x0252:
            int[] r5 = new int[r14]     // Catch:{ all -> 0x048c }
            r6 = 0
            r5[r6] = r4     // Catch:{ all -> 0x048c }
            r5[r8] = r7     // Catch:{ all -> 0x048c }
            r16 = r5
            goto L_0x0267
        L_0x025c:
            java.lang.String r4 = "Height is too small or too large."
            com.google.android.gms.ads.internal.util.zze.zzj(r4)     // Catch:{ all -> 0x048c }
            goto L_0x0267
        L_0x0262:
            java.lang.String r4 = "Width is too small or too large."
            com.google.android.gms.ads.internal.util.zze.zzj(r4)     // Catch:{ all -> 0x048c }
        L_0x0267:
            if (r16 != 0) goto L_0x0270
            java.lang.String r0 = "Resize location out of screen or close button is not visible."
            r1.zzg(r0)     // Catch:{ all -> 0x048c }
            monitor-exit(r3)     // Catch:{ all -> 0x048c }
            return
        L_0x0270:
            com.google.android.gms.ads.internal.client.zzaw.zzb()     // Catch:{ all -> 0x048c }
            android.app.Activity r4 = r1.zzl     // Catch:{ all -> 0x048c }
            int r5 = r1.zzi     // Catch:{ all -> 0x048c }
            int r4 = com.google.android.gms.internal.ads.zzcgi.zzw(r4, r5)     // Catch:{ all -> 0x048c }
            com.google.android.gms.ads.internal.client.zzaw.zzb()     // Catch:{ all -> 0x048c }
            android.app.Activity r5 = r1.zzl     // Catch:{ all -> 0x048c }
            int r6 = r1.zzf     // Catch:{ all -> 0x048c }
            int r5 = com.google.android.gms.internal.ads.zzcgi.zzw(r5, r6)     // Catch:{ all -> 0x048c }
            com.google.android.gms.internal.ads.zzcmp r6 = r1.zzk     // Catch:{ all -> 0x048c }
            android.view.View r6 = (android.view.View) r6     // Catch:{ all -> 0x048c }
            android.view.ViewParent r6 = r6.getParent()     // Catch:{ all -> 0x048c }
            if (r6 == 0) goto L_0x0470
            boolean r7 = r6 instanceof android.view.ViewGroup     // Catch:{ all -> 0x048c }
            if (r7 == 0) goto L_0x0470
            android.view.ViewGroup r6 = (android.view.ViewGroup) r6     // Catch:{ all -> 0x048c }
            com.google.android.gms.internal.ads.zzcmp r7 = r1.zzk     // Catch:{ all -> 0x048c }
            android.view.View r7 = (android.view.View) r7     // Catch:{ all -> 0x048c }
            r6.removeView(r7)     // Catch:{ all -> 0x048c }
            android.widget.PopupWindow r7 = r1.zzq     // Catch:{ all -> 0x048c }
            if (r7 != 0) goto L_0x02db
            r1.zzs = r6     // Catch:{ all -> 0x048c }
            com.google.android.gms.ads.internal.zzt.zzp()     // Catch:{ all -> 0x048c }
            com.google.android.gms.internal.ads.zzcmp r6 = r1.zzk     // Catch:{ all -> 0x048c }
            r7 = r6
            android.view.View r7 = (android.view.View) r7     // Catch:{ all -> 0x048c }
            r7.setDrawingCacheEnabled(r8)     // Catch:{ all -> 0x048c }
            r7 = r6
            android.view.View r7 = (android.view.View) r7     // Catch:{ all -> 0x048c }
            android.graphics.Bitmap r7 = r7.getDrawingCache()     // Catch:{ all -> 0x048c }
            android.graphics.Bitmap r7 = android.graphics.Bitmap.createBitmap(r7)     // Catch:{ all -> 0x048c }
            android.view.View r6 = (android.view.View) r6     // Catch:{ all -> 0x048c }
            r9 = 0
            r6.setDrawingCacheEnabled(r9)     // Catch:{ all -> 0x048c }
            android.widget.ImageView r6 = new android.widget.ImageView     // Catch:{ all -> 0x048c }
            android.app.Activity r9 = r1.zzl     // Catch:{ all -> 0x048c }
            r6.<init>(r9)     // Catch:{ all -> 0x048c }
            r1.zzn = r6     // Catch:{ all -> 0x048c }
            r6.setImageBitmap(r7)     // Catch:{ all -> 0x048c }
            com.google.android.gms.internal.ads.zzcmp r6 = r1.zzk     // Catch:{ all -> 0x048c }
            com.google.android.gms.internal.ads.zzcoe r6 = r6.zzQ()     // Catch:{ all -> 0x048c }
            r1.zzm = r6     // Catch:{ all -> 0x048c }
            android.view.ViewGroup r6 = r1.zzs     // Catch:{ all -> 0x048c }
            android.widget.ImageView r7 = r1.zzn     // Catch:{ all -> 0x048c }
            r6.addView(r7)     // Catch:{ all -> 0x048c }
            goto L_0x02de
        L_0x02db:
            r7.dismiss()     // Catch:{ all -> 0x048c }
        L_0x02de:
            android.widget.RelativeLayout r6 = new android.widget.RelativeLayout     // Catch:{ all -> 0x048c }
            android.app.Activity r7 = r1.zzl     // Catch:{ all -> 0x048c }
            r6.<init>(r7)     // Catch:{ all -> 0x048c }
            r1.zzr = r6     // Catch:{ all -> 0x048c }
            r7 = 0
            r6.setBackgroundColor(r7)     // Catch:{ all -> 0x048c }
            android.widget.RelativeLayout r6 = r1.zzr     // Catch:{ all -> 0x048c }
            android.view.ViewGroup$LayoutParams r7 = new android.view.ViewGroup$LayoutParams     // Catch:{ all -> 0x048c }
            r7.<init>(r4, r5)     // Catch:{ all -> 0x048c }
            r6.setLayoutParams(r7)     // Catch:{ all -> 0x048c }
            com.google.android.gms.ads.internal.zzt.zzp()     // Catch:{ all -> 0x048c }
            android.widget.RelativeLayout r6 = r1.zzr     // Catch:{ all -> 0x048c }
            android.widget.PopupWindow r7 = new android.widget.PopupWindow     // Catch:{ all -> 0x048c }
            r9 = 0
            r7.<init>(r6, r4, r5, r9)     // Catch:{ all -> 0x048c }
            r1.zzq = r7     // Catch:{ all -> 0x048c }
            r7.setOutsideTouchable(r9)     // Catch:{ all -> 0x048c }
            android.widget.PopupWindow r6 = r1.zzq     // Catch:{ all -> 0x048c }
            r6.setTouchable(r8)     // Catch:{ all -> 0x048c }
            android.widget.PopupWindow r6 = r1.zzq     // Catch:{ all -> 0x048c }
            boolean r7 = r1.zzc     // Catch:{ all -> 0x048c }
            r7 = r7 ^ r8
            r6.setClippingEnabled(r7)     // Catch:{ all -> 0x048c }
            android.widget.RelativeLayout r6 = r1.zzr     // Catch:{ all -> 0x048c }
            com.google.android.gms.internal.ads.zzcmp r7 = r1.zzk     // Catch:{ all -> 0x048c }
            android.view.View r7 = (android.view.View) r7     // Catch:{ all -> 0x048c }
            r9 = -1
            r6.addView(r7, r9, r9)     // Catch:{ all -> 0x048c }
            android.widget.LinearLayout r6 = new android.widget.LinearLayout     // Catch:{ all -> 0x048c }
            android.app.Activity r7 = r1.zzl     // Catch:{ all -> 0x048c }
            r6.<init>(r7)     // Catch:{ all -> 0x048c }
            r1.zzo = r6     // Catch:{ all -> 0x048c }
            android.widget.RelativeLayout$LayoutParams r6 = new android.widget.RelativeLayout$LayoutParams     // Catch:{ all -> 0x048c }
            com.google.android.gms.ads.internal.client.zzaw.zzb()     // Catch:{ all -> 0x048c }
            android.app.Activity r7 = r1.zzl     // Catch:{ all -> 0x048c }
            int r7 = com.google.android.gms.internal.ads.zzcgi.zzw(r7, r15)     // Catch:{ all -> 0x048c }
            com.google.android.gms.ads.internal.client.zzaw.zzb()     // Catch:{ all -> 0x048c }
            android.app.Activity r13 = r1.zzl     // Catch:{ all -> 0x048c }
            int r13 = com.google.android.gms.internal.ads.zzcgi.zzw(r13, r15)     // Catch:{ all -> 0x048c }
            r6.<init>(r7, r13)     // Catch:{ all -> 0x048c }
            java.lang.String r7 = r1.zzb     // Catch:{ all -> 0x048c }
            int r13 = r7.hashCode()     // Catch:{ all -> 0x048c }
            switch(r13) {
                case -1364013995: goto L_0x0378;
                case -1012429441: goto L_0x036e;
                case -655373719: goto L_0x0364;
                case 1163912186: goto L_0x035a;
                case 1288627767: goto L_0x0350;
                case 1755462605: goto L_0x0346;
                default: goto L_0x0345;
            }
        L_0x0345:
            goto L_0x0382
        L_0x0346:
            java.lang.String r13 = "top-center"
            boolean r7 = r7.equals(r13)
            if (r7 == 0) goto L_0x0382
            r13 = 1
            goto L_0x0383
        L_0x0350:
            java.lang.String r13 = "bottom-center"
            boolean r7 = r7.equals(r13)
            if (r7 == 0) goto L_0x0382
            r13 = 4
            goto L_0x0383
        L_0x035a:
            java.lang.String r13 = "bottom-right"
            boolean r7 = r7.equals(r13)
            if (r7 == 0) goto L_0x0382
            r13 = 5
            goto L_0x0383
        L_0x0364:
            java.lang.String r13 = "bottom-left"
            boolean r7 = r7.equals(r13)
            if (r7 == 0) goto L_0x0382
            r13 = 3
            goto L_0x0383
        L_0x036e:
            java.lang.String r13 = "top-left"
            boolean r7 = r7.equals(r13)
            if (r7 == 0) goto L_0x0382
            r13 = 0
            goto L_0x0383
        L_0x0378:
            java.lang.String r13 = "center"
            boolean r7 = r7.equals(r13)
            if (r7 == 0) goto L_0x0382
            r13 = 2
            goto L_0x0383
        L_0x0382:
            r13 = -1
        L_0x0383:
            r7 = 9
            r9 = 10
            if (r13 == 0) goto L_0x03c2
            r15 = 14
            if (r13 == r8) goto L_0x03bb
            if (r13 == r14) goto L_0x03b5
            r14 = 12
            if (r13 == r12) goto L_0x03ae
            if (r13 == r11) goto L_0x03a7
            r7 = 11
            if (r13 == r10) goto L_0x03a0
            r6.addRule(r9)     // Catch:{ all -> 0x048c }
            r6.addRule(r7)     // Catch:{ all -> 0x048c }
            goto L_0x03c8
        L_0x03a0:
            r6.addRule(r14)     // Catch:{ all -> 0x048c }
            r6.addRule(r7)     // Catch:{ all -> 0x048c }
            goto L_0x03c8
        L_0x03a7:
            r6.addRule(r14)     // Catch:{ all -> 0x048c }
            r6.addRule(r15)     // Catch:{ all -> 0x048c }
            goto L_0x03c8
        L_0x03ae:
            r6.addRule(r14)     // Catch:{ all -> 0x048c }
            r6.addRule(r7)     // Catch:{ all -> 0x048c }
            goto L_0x03c8
        L_0x03b5:
            r7 = 13
            r6.addRule(r7)     // Catch:{ all -> 0x048c }
            goto L_0x03c8
        L_0x03bb:
            r6.addRule(r9)     // Catch:{ all -> 0x048c }
            r6.addRule(r15)     // Catch:{ all -> 0x048c }
            goto L_0x03c8
        L_0x03c2:
            r6.addRule(r9)     // Catch:{ all -> 0x048c }
            r6.addRule(r7)     // Catch:{ all -> 0x048c }
        L_0x03c8:
            android.widget.LinearLayout r7 = r1.zzo     // Catch:{ all -> 0x048c }
            com.google.android.gms.internal.ads.zzbxy r9 = new com.google.android.gms.internal.ads.zzbxy     // Catch:{ all -> 0x048c }
            r9.<init>(r1)     // Catch:{ all -> 0x048c }
            r7.setOnClickListener(r9)     // Catch:{ all -> 0x048c }
            android.widget.LinearLayout r7 = r1.zzo     // Catch:{ all -> 0x048c }
            java.lang.String r9 = "Close button"
            r7.setContentDescription(r9)     // Catch:{ all -> 0x048c }
            android.widget.RelativeLayout r7 = r1.zzr     // Catch:{ all -> 0x048c }
            android.widget.LinearLayout r9 = r1.zzo     // Catch:{ all -> 0x048c }
            r7.addView(r9, r6)     // Catch:{ all -> 0x048c }
            android.widget.PopupWindow r6 = r1.zzq     // Catch:{ RuntimeException -> 0x0438 }
            android.view.View r0 = r0.getDecorView()     // Catch:{ RuntimeException -> 0x0438 }
            com.google.android.gms.ads.internal.client.zzaw.zzb()     // Catch:{ RuntimeException -> 0x0438 }
            android.app.Activity r7 = r1.zzl     // Catch:{ RuntimeException -> 0x0438 }
            r9 = 0
            r10 = r16[r9]     // Catch:{ RuntimeException -> 0x0438 }
            int r7 = com.google.android.gms.internal.ads.zzcgi.zzw(r7, r10)     // Catch:{ RuntimeException -> 0x0438 }
            com.google.android.gms.ads.internal.client.zzaw.zzb()     // Catch:{ RuntimeException -> 0x0438 }
            android.app.Activity r9 = r1.zzl     // Catch:{ RuntimeException -> 0x0438 }
            r10 = r16[r8]     // Catch:{ RuntimeException -> 0x0438 }
            int r9 = com.google.android.gms.internal.ads.zzcgi.zzw(r9, r10)     // Catch:{ RuntimeException -> 0x0438 }
            r10 = 0
            r6.showAtLocation(r0, r10, r7, r9)     // Catch:{ RuntimeException -> 0x0438 }
            r0 = r16[r10]     // Catch:{ all -> 0x048c }
            r2 = r16[r8]     // Catch:{ all -> 0x048c }
            com.google.android.gms.internal.ads.zzbyg r6 = r1.zzp     // Catch:{ all -> 0x048c }
            if (r6 == 0) goto L_0x0410
            int r7 = r1.zzi     // Catch:{ all -> 0x048c }
            int r9 = r1.zzf     // Catch:{ all -> 0x048c }
            r6.zza(r0, r2, r7, r9)     // Catch:{ all -> 0x048c }
        L_0x0410:
            com.google.android.gms.internal.ads.zzcmp r0 = r1.zzk     // Catch:{ all -> 0x048c }
            com.google.android.gms.internal.ads.zzcoe r2 = com.google.android.gms.internal.ads.zzcoe.zzb(r4, r5)     // Catch:{ all -> 0x048c }
            r0.zzai(r2)     // Catch:{ all -> 0x048c }
            r0 = 0
            r2 = r16[r0]     // Catch:{ all -> 0x048c }
            r4 = r16[r8]     // Catch:{ all -> 0x048c }
            com.google.android.gms.ads.internal.zzt.zzp()     // Catch:{ all -> 0x048c }
            android.app.Activity r5 = r1.zzl     // Catch:{ all -> 0x048c }
            int[] r5 = com.google.android.gms.ads.internal.util.zzs.zzO(r5)     // Catch:{ all -> 0x048c }
            r0 = r5[r0]     // Catch:{ all -> 0x048c }
            int r4 = r4 - r0
            int r0 = r1.zzi     // Catch:{ all -> 0x048c }
            int r5 = r1.zzf     // Catch:{ all -> 0x048c }
            r1.zzj(r2, r4, r0, r5)     // Catch:{ all -> 0x048c }
            java.lang.String r0 = "resized"
            r1.zzk(r0)     // Catch:{ all -> 0x048c }
            monitor-exit(r3)     // Catch:{ all -> 0x048c }
            return
        L_0x0438:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x048c }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x048c }
            r4.<init>(r2)     // Catch:{ all -> 0x048c }
            r4.append(r0)     // Catch:{ all -> 0x048c }
            java.lang.String r0 = r4.toString()     // Catch:{ all -> 0x048c }
            r1.zzg(r0)     // Catch:{ all -> 0x048c }
            android.widget.RelativeLayout r0 = r1.zzr     // Catch:{ all -> 0x048c }
            com.google.android.gms.internal.ads.zzcmp r2 = r1.zzk     // Catch:{ all -> 0x048c }
            android.view.View r2 = (android.view.View) r2     // Catch:{ all -> 0x048c }
            r0.removeView(r2)     // Catch:{ all -> 0x048c }
            android.view.ViewGroup r0 = r1.zzs     // Catch:{ all -> 0x048c }
            if (r0 == 0) goto L_0x046e
            android.widget.ImageView r2 = r1.zzn     // Catch:{ all -> 0x048c }
            r0.removeView(r2)     // Catch:{ all -> 0x048c }
            android.view.ViewGroup r0 = r1.zzs     // Catch:{ all -> 0x048c }
            com.google.android.gms.internal.ads.zzcmp r2 = r1.zzk     // Catch:{ all -> 0x048c }
            android.view.View r2 = (android.view.View) r2     // Catch:{ all -> 0x048c }
            r0.addView(r2)     // Catch:{ all -> 0x048c }
            com.google.android.gms.internal.ads.zzcmp r0 = r1.zzk     // Catch:{ all -> 0x048c }
            com.google.android.gms.internal.ads.zzcoe r2 = r1.zzm     // Catch:{ all -> 0x048c }
            r0.zzai(r2)     // Catch:{ all -> 0x048c }
        L_0x046e:
            monitor-exit(r3)     // Catch:{ all -> 0x048c }
            return
        L_0x0470:
            java.lang.String r0 = "Webview is detached, probably in the middle of a resize or expand."
            r1.zzg(r0)     // Catch:{ all -> 0x048c }
            monitor-exit(r3)     // Catch:{ all -> 0x048c }
            return
        L_0x0477:
            java.lang.String r0 = "Activity context is not ready, cannot get window or decor view."
            r1.zzg(r0)     // Catch:{ all -> 0x048c }
            monitor-exit(r3)     // Catch:{ all -> 0x048c }
            return
        L_0x047e:
            java.lang.String r0 = "Invalid width and height options. Cannot resize."
            r1.zzg(r0)     // Catch:{ all -> 0x048c }
            monitor-exit(r3)     // Catch:{ all -> 0x048c }
            return
        L_0x0485:
            java.lang.String r0 = "Cannot resize an expanded banner."
            r1.zzg(r0)     // Catch:{ all -> 0x048c }
            monitor-exit(r3)     // Catch:{ all -> 0x048c }
            return
        L_0x048c:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x048c }
            goto L_0x0490
        L_0x048f:
            throw r0
        L_0x0490:
            goto L_0x048f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbxz.zzb(java.util.Map):void");
    }

    public final void zzc(int i, int i2, boolean z) {
        synchronized (this.zzj) {
            this.zzd = i;
            this.zze = i2;
        }
    }

    public final void zzd(int i, int i2) {
        this.zzd = i;
        this.zze = i2;
    }

    public final boolean zze() {
        boolean z;
        synchronized (this.zzj) {
            z = this.zzq != null;
        }
        return z;
    }
}

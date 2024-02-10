package com.google.ads.interactivemedia.v3.internal;

import android.app.Application;
import android.content.Context;
import com.google.ads.interactivemedia.v3.api.Ad;
import com.google.ads.interactivemedia.v3.api.AdError;
import com.google.ads.interactivemedia.v3.api.AdErrorEvent;
import com.google.ads.interactivemedia.v3.api.AdEvent;
import com.google.ads.interactivemedia.v3.api.AdProgressInfo;
import com.google.ads.interactivemedia.v3.api.AdsRenderingSettings;
import com.google.ads.interactivemedia.v3.api.BaseDisplayContainer;
import com.google.ads.interactivemedia.v3.api.BaseManager;
import com.google.ads.interactivemedia.v3.api.FriendlyObstruction;
import com.google.ads.interactivemedia.v3.api.player.VideoProgressUpdate;
import com.google.ads.interactivemedia.v3.impl.data.AdImpl;
import com.google.ads.interactivemedia.v3.impl.data.ResizeAndPositionVideoMsgData;
import com.google.ads.interactivemedia.v3.impl.data.zzd;
import com.google.ads.interactivemedia.v3.impl.data.zze;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
abstract class zzep implements BaseManager, zzfk, zzgr {
    private final zzfm zza;
    private final String zzb;
    private final List zzc;
    private final zzex zzd;
    private final Context zze;
    private final zzdj zzf;
    private final zzge zzg;
    private final zzgn zzh;
    private AdImpl zzi;
    private AdProgressInfo zzj;
    private AdsRenderingSettings zzk;
    private boolean zzl = false;
    private final zzhy zzm;
    private zzgs zzn;

    zzep(String str, zzfm zzfm, zzgn zzgn, BaseDisplayContainer baseDisplayContainer, zzdj zzdj, zzge zzge, zzex zzex, Context context, boolean z) {
        ArrayList arrayList = new ArrayList(1);
        this.zzc = arrayList;
        this.zzb = str;
        this.zza = zzfm;
        this.zzh = zzgn;
        this.zze = context;
        this.zzd = zzex;
        this.zzk = new zze();
        this.zzf = zzdj;
        zzdj.zzj(z);
        if (zzge == null) {
            zzge = null;
        } else {
            zzge.zzg(str);
            zzge.zzd(baseDisplayContainer.getAdContainer());
            arrayList.add(zzge);
            zzex.zza(zzge);
            zzeo zzeo = (zzeo) baseDisplayContainer;
            for (FriendlyObstruction zzc2 : zzeo.zzb()) {
                zzge.zzc(zzc2);
            }
            zzeo.zzc(zzge);
        }
        this.zzg = zzge;
        this.zzm = new zzhy(context, this.zzk);
        zzfm.zzg(this, str);
        zzfm.zzi(this.zzh, str);
        zzdj.zzf();
        Application zza2 = zzgq.zza(context);
        if (zza2 != null) {
            zzgs zzgs = new zzgs(zza2);
            this.zzn = zzgs;
            zzgs.zza(this);
        }
    }

    private final void zzo(String str) {
        if (zzgq.zzc(this.zze, this.zza.zzb())) {
            this.zza.zza().requestFocus();
            this.zza.zzp(new zzff(zzfd.userInteraction, zzfe.focusUiElement, str, (Object) null));
        }
    }

    private final boolean zzp() {
        return this.zzk.getFocusSkipButtonWhenAvailable();
    }

    public final void addAdErrorListener(AdErrorEvent.AdErrorListener adErrorListener) {
        this.zzd.zza(adErrorListener);
    }

    public final void addAdEventListener(AdEvent.AdEventListener adEventListener) {
        this.zzc.add(adEventListener);
    }

    public void destroy() {
        this.zzl = true;
        this.zzg.zzi();
        this.zzf.zzg();
        this.zzf.zzk();
        zzgs zzgs = this.zzn;
        if (zzgs != null) {
            zzgs.zzb();
        }
        this.zzh.zzc();
    }

    public final void focus() {
        zzo(this.zzb);
    }

    public final VideoProgressUpdate getAdProgress() {
        return this.zzl ? VideoProgressUpdate.VIDEO_TIME_NOT_READY : this.zzh.getAdProgress();
    }

    public final AdProgressInfo getAdProgressInfo() {
        return this.zzj;
    }

    public final Ad getCurrentAd() {
        return this.zzi;
    }

    public final void init() {
        this.zza.zzp(new zzff(zzfd.adsManager, zzfe.init, this.zzb, zza(this.zzk)));
        this.zzh.zzd();
    }

    public final void removeAdErrorListener(AdErrorEvent.AdErrorListener adErrorListener) {
        this.zzd.zzd(adErrorListener);
    }

    public final void removeAdEventListener(AdEvent.AdEventListener adEventListener) {
        this.zzc.remove(adEventListener);
    }

    /* access modifiers changed from: package-private */
    public Map zza(AdsRenderingSettings adsRenderingSettings) {
        HashMap hashMap = new HashMap();
        hashMap.put("adsRenderingSettings", zzd.builder(adsRenderingSettings).build());
        return hashMap;
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x00f0 A[LOOP:1: B:43:0x00ea->B:45:0x00f0, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0103 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0104  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void zzb(com.google.ads.interactivemedia.v3.internal.zzfj r9) {
        /*
            r8 = this;
            com.google.ads.interactivemedia.v3.api.AdEvent$AdEventType r0 = r9.zza
            com.google.ads.interactivemedia.v3.impl.data.AdImpl r1 = r9.zzb
            com.google.ads.interactivemedia.v3.impl.data.zzav r2 = com.google.ads.interactivemedia.v3.impl.data.zzav.Html
            com.google.ads.interactivemedia.v3.api.AdEvent$AdEventType r2 = com.google.ads.interactivemedia.v3.api.AdEvent.AdEventType.ALL_ADS_COMPLETED
            int r2 = r0.ordinal()
            r3 = 3
            r4 = 0
            if (r2 == r3) goto L_0x00d9
            r3 = 17
            if (r2 == r3) goto L_0x0061
            r3 = 24
            if (r2 == r3) goto L_0x00d9
            r3 = 5
            if (r2 == r3) goto L_0x005a
            r3 = 6
            if (r2 == r3) goto L_0x0053
            r3 = 20
            if (r2 == r3) goto L_0x004f
            r3 = 21
            if (r2 == r3) goto L_0x0049
            switch(r2) {
                case 13: goto L_0x003c;
                case 14: goto L_0x00d9;
                case 15: goto L_0x002b;
                default: goto L_0x0029;
            }
        L_0x0029:
            goto L_0x00db
        L_0x002b:
            if (r1 == 0) goto L_0x002f
            r8.zzi = r1
        L_0x002f:
            boolean r1 = r8.zzp()
            if (r1 == 0) goto L_0x00db
            java.lang.String r1 = r8.zzb
            r8.zzo(r1)
            goto L_0x00db
        L_0x003c:
            boolean r1 = r8.zzp()
            if (r1 == 0) goto L_0x00db
            java.lang.String r1 = r8.zzb
            r8.zzo(r1)
            goto L_0x00db
        L_0x0049:
            com.google.ads.interactivemedia.v3.api.AdProgressInfo r1 = r9.zze
            r8.zzj = r1
            goto L_0x00db
        L_0x004f:
            r8.zzi = r1
            goto L_0x00db
        L_0x0053:
            com.google.ads.interactivemedia.v3.internal.zzdj r1 = r8.zzf
            r1.zzk()
            goto L_0x00db
        L_0x005a:
            com.google.ads.interactivemedia.v3.internal.zzdj r1 = r8.zzf
            r1.zzi()
            goto L_0x00db
        L_0x0061:
            java.util.List r1 = r9.zzf
            if (r1 == 0) goto L_0x00d3
            android.content.Context r1 = r8.zze
            boolean r1 = com.google.ads.interactivemedia.v3.internal.zzgq.zzb(r1, r4)
            if (r1 == 0) goto L_0x00d3
            java.util.List r1 = r9.zzf
            com.google.android.tv.ads.AdsControlsManager r2 = new com.google.android.tv.ads.AdsControlsManager     // Catch:{ RuntimeException -> 0x00cc }
            android.content.Context r3 = r8.zze     // Catch:{ RuntimeException -> 0x00cc }
            r2.<init>(r3)     // Catch:{ RuntimeException -> 0x00cc }
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ RuntimeException -> 0x00cc }
            r5 = 1
            r3.<init>(r5)     // Catch:{ RuntimeException -> 0x00cc }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ RuntimeException -> 0x00cc }
        L_0x0080:
            boolean r5 = r1.hasNext()     // Catch:{ RuntimeException -> 0x00cc }
            if (r5 == 0) goto L_0x00c0
            java.lang.Object r5 = r1.next()     // Catch:{ RuntimeException -> 0x00cc }
            com.google.ads.interactivemedia.v3.impl.data.zzbb r5 = (com.google.ads.interactivemedia.v3.impl.data.zzbb) r5     // Catch:{ RuntimeException -> 0x00cc }
            com.google.android.tv.ads.IconClickFallbackImage$Builder r6 = com.google.android.tv.ads.IconClickFallbackImage.builder()     // Catch:{ RuntimeException -> 0x00cc }
            int r7 = r5.width()     // Catch:{ RuntimeException -> 0x00cc }
            com.google.android.tv.ads.IconClickFallbackImage$Builder r6 = r6.setWidth(r7)     // Catch:{ RuntimeException -> 0x00cc }
            int r7 = r5.height()     // Catch:{ RuntimeException -> 0x00cc }
            com.google.android.tv.ads.IconClickFallbackImage$Builder r6 = r6.setHeight(r7)     // Catch:{ RuntimeException -> 0x00cc }
            java.lang.String r7 = r5.alternateText()     // Catch:{ RuntimeException -> 0x00cc }
            com.google.android.tv.ads.IconClickFallbackImage$Builder r6 = r6.setAltText(r7)     // Catch:{ RuntimeException -> 0x00cc }
            java.lang.String r7 = r5.imageUrl()     // Catch:{ RuntimeException -> 0x00cc }
            com.google.android.tv.ads.IconClickFallbackImage$Builder r6 = r6.setStaticResourceUri(r7)     // Catch:{ RuntimeException -> 0x00cc }
            java.lang.String r5 = r5.creativeType()     // Catch:{ RuntimeException -> 0x00cc }
            com.google.android.tv.ads.IconClickFallbackImage$Builder r5 = r6.setCreativeType(r5)     // Catch:{ RuntimeException -> 0x00cc }
            com.google.android.tv.ads.IconClickFallbackImage r5 = r5.build()     // Catch:{ RuntimeException -> 0x00cc }
            r3.add(r5)     // Catch:{ RuntimeException -> 0x00cc }
            goto L_0x0080
        L_0x00c0:
            com.google.android.tv.ads.IconClickFallbackImages$Builder r1 = com.google.android.tv.ads.IconClickFallbackImages.builder(r3)     // Catch:{ RuntimeException -> 0x00cc }
            com.google.android.tv.ads.IconClickFallbackImages r1 = r1.build()     // Catch:{ RuntimeException -> 0x00cc }
            r2.handleIconClick(r1)     // Catch:{ RuntimeException -> 0x00cc }
            goto L_0x00db
        L_0x00cc:
            r1 = move-exception
            java.lang.String r2 = "Failed to handle icon fallback image click."
            com.google.ads.interactivemedia.v3.internal.zzhd.zzb(r2, r1)
            goto L_0x00db
        L_0x00d3:
            java.lang.String r1 = "Received ICON_TAPPED event without icon click fallback image list."
            com.google.ads.interactivemedia.v3.internal.zzhd.zzd(r1)
            goto L_0x00db
        L_0x00d9:
            r8.zzj = r4
        L_0x00db:
            java.util.Map r9 = r9.zzc
            com.google.ads.interactivemedia.v3.internal.zzdm r1 = new com.google.ads.interactivemedia.v3.internal.zzdm
            com.google.ads.interactivemedia.v3.impl.data.AdImpl r2 = r8.zzi
            r1.<init>(r0, r2, r9)
            java.util.List r9 = r8.zzc
            java.util.Iterator r9 = r9.iterator()
        L_0x00ea:
            boolean r2 = r9.hasNext()
            if (r2 == 0) goto L_0x00fa
            java.lang.Object r2 = r9.next()
            com.google.ads.interactivemedia.v3.api.AdEvent$AdEventListener r2 = (com.google.ads.interactivemedia.v3.api.AdEvent.AdEventListener) r2
            r2.onAdEvent(r1)
            goto L_0x00ea
        L_0x00fa:
            com.google.ads.interactivemedia.v3.api.AdEvent$AdEventType r9 = com.google.ads.interactivemedia.v3.api.AdEvent.AdEventType.COMPLETED
            if (r0 == r9) goto L_0x0104
            com.google.ads.interactivemedia.v3.api.AdEvent$AdEventType r9 = com.google.ads.interactivemedia.v3.api.AdEvent.AdEventType.SKIPPED
            if (r0 != r9) goto L_0x0103
            goto L_0x0104
        L_0x0103:
            return
        L_0x0104:
            r8.zzi = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.zzep.zzb(com.google.ads.interactivemedia.v3.internal.zzfj):void");
    }

    /* access modifiers changed from: protected */
    public final zzgn zzc() {
        return this.zzh;
    }

    public final void zzd(AdError.AdErrorType adErrorType, int i, String str) {
        zze(adErrorType, AdError.AdErrorCode.getErrorCodeByNumber(i), str);
    }

    public final void zze(AdError.AdErrorType adErrorType, AdError.AdErrorCode adErrorCode, String str) {
        this.zzj = null;
        this.zzd.zzc(new zzdl(new AdError(adErrorType, adErrorCode, str)));
    }

    public final void zzf() {
        this.zza.zzp(new zzff(zzfd.adsManager, zzfe.appBackgrounding, this.zzb, (Object) null));
    }

    public final void zzg() {
        this.zza.zzp(new zzff(zzfd.adsManager, zzfe.appForegrounding, this.zzb, (Object) null));
    }

    public final void zzh(String str) {
        this.zzm.zza(str);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: com.google.ads.interactivemedia.v3.internal.zzet} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: com.google.ads.interactivemedia.v3.impl.data.zzbd} */
    /* JADX WARNING: type inference failed for: r1v0, types: [android.view.View] */
    /* JADX WARNING: type inference failed for: r1v3 */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: type inference failed for: r1v11 */
    /* JADX WARNING: type inference failed for: r1v13 */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x001c, code lost:
        if (r0 != 2) goto L_0x0074;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzi(android.view.ViewGroup r10, com.google.ads.interactivemedia.v3.impl.data.CompanionData r11, java.lang.String r12, com.google.ads.interactivemedia.v3.api.CompanionAdSlot r13, com.google.ads.interactivemedia.v3.internal.zzfm r14, com.google.ads.interactivemedia.v3.internal.zzha r15) {
        /*
            r9 = this;
            r10.removeAllViews()
            com.google.ads.interactivemedia.v3.internal.zzeq r13 = (com.google.ads.interactivemedia.v3.internal.zzeq) r13
            java.util.List r6 = r13.zza()
            com.google.ads.interactivemedia.v3.impl.data.zzav r0 = com.google.ads.interactivemedia.v3.impl.data.zzav.Html
            com.google.ads.interactivemedia.v3.api.AdEvent$AdEventType r0 = com.google.ads.interactivemedia.v3.api.AdEvent.AdEventType.ALL_ADS_COMPLETED
            com.google.ads.interactivemedia.v3.impl.data.zzav r0 = r11.type()
            int r0 = r0.ordinal()
            if (r0 == 0) goto L_0x0064
            r1 = 0
            r2 = 2
            r3 = 1
            if (r0 == r3) goto L_0x001f
            if (r0 == r2) goto L_0x0064
            goto L_0x0074
        L_0x001f:
            android.content.Context r4 = r10.getContext()
            java.lang.String r0 = r11.src()
            java.lang.String r5 = r11.size()
            if (r5 != 0) goto L_0x002e
            goto L_0x0051
        L_0x002e:
            java.lang.String r1 = "x"
            r7 = -1
            java.lang.String[] r1 = r5.split(r1, r7)
            int r5 = r1.length
            r7 = 0
            if (r5 == r2) goto L_0x003f
            com.google.ads.interactivemedia.v3.impl.data.zzbd r1 = new com.google.ads.interactivemedia.v3.impl.data.zzbd
            r1.<init>(r7, r7)
            goto L_0x0051
        L_0x003f:
            com.google.ads.interactivemedia.v3.impl.data.zzbd r2 = new com.google.ads.interactivemedia.v3.impl.data.zzbd
            r5 = r1[r7]
            int r5 = java.lang.Integer.parseInt(r5)
            r1 = r1[r3]
            int r1 = java.lang.Integer.parseInt(r1)
            r2.<init>(r5, r1)
            r1 = r2
        L_0x0051:
            com.google.android.gms.tasks.Task r15 = r15.zzb(r0, r1)
            com.google.ads.interactivemedia.v3.internal.zzfb r8 = new com.google.ads.interactivemedia.v3.internal.zzfb
            com.google.ads.interactivemedia.v3.internal.zzhy r7 = r9.zzm
            r0 = r8
            r1 = r4
            r2 = r14
            r3 = r11
            r4 = r15
            r5 = r12
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            r1 = r8
            goto L_0x0074
        L_0x0064:
            com.google.ads.interactivemedia.v3.internal.zzet r15 = new com.google.ads.interactivemedia.v3.internal.zzet
            android.content.Context r1 = r10.getContext()
            com.google.ads.interactivemedia.v3.internal.zzhy r5 = r9.zzm
            r0 = r15
            r2 = r14
            r3 = r11
            r4 = r6
            r0.<init>(r1, r2, r3, r4, r5)
            r1 = r15
        L_0x0074:
            if (r1 == 0) goto L_0x007f
            r1.setTag(r12)
            r13.zzb(r12)
            r10.addView(r1)
        L_0x007f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.zzep.zzi(android.view.ViewGroup, com.google.ads.interactivemedia.v3.impl.data.CompanionData, java.lang.String, com.google.ads.interactivemedia.v3.api.CompanionAdSlot, com.google.ads.interactivemedia.v3.internal.zzfm, com.google.ads.interactivemedia.v3.internal.zzha):void");
    }

    public final void zzj(ResizeAndPositionVideoMsgData resizeAndPositionVideoMsgData) {
        this.zzh.zzg(resizeAndPositionVideoMsgData);
    }

    public final void zzk() {
        this.zzh.zzh();
    }

    /* access modifiers changed from: package-private */
    public final void zzl() {
        this.zza.zzo(this.zzb);
        this.zzc.clear();
        this.zzd.zzb();
    }

    /* access modifiers changed from: protected */
    public final void zzm(zzfd zzfd, zzfe zzfe, Object obj) {
        this.zza.zzp(new zzff(zzfd, zzfe, this.zzb, obj));
    }

    /* access modifiers changed from: protected */
    public final void zzn(zzfe zzfe) {
        this.zza.zzp(new zzff(zzfd.adsManager, zzfe, this.zzb, (Object) null));
    }

    public final void init(AdsRenderingSettings adsRenderingSettings) {
        if (adsRenderingSettings != null) {
            this.zzk = adsRenderingSettings;
            this.zzm.zzb(adsRenderingSettings);
        }
        this.zza.zzp(new zzff(zzfd.adsManager, zzfe.init, this.zzb, zza(this.zzk)));
        this.zzh.zzd();
    }
}

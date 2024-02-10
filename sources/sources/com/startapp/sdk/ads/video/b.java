package com.startapp.sdk.ads.video;

import android.content.Context;
import com.startapp.i3;
import com.startapp.j3;
import com.startapp.k;
import com.startapp.r0;
import com.startapp.sdk.ads.video.VideoUtil;
import com.startapp.sdk.ads.video.d;
import com.startapp.sdk.ads.video.j;
import com.startapp.sdk.ads.video.vast.VASTErrorCodes;
import com.startapp.sdk.ads.video.vast.c;
import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.AdsCommonMetaData;
import com.startapp.sdk.adsbase.HtmlAd;
import com.startapp.sdk.adsbase.StartAppAd;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;
import com.startapp.sdk.adsbase.cache.CacheKey;
import com.startapp.sdk.adsbase.cache.d;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.sdk.adsbase.model.GetAdRequest;
import com.startapp.sdk.components.ComponentLocator;
import com.startapp.z5;
import java.util.List;

/* compiled from: Sta */
public class b extends r0 {
    public final long m = System.currentTimeMillis();
    public volatile CacheKey n;
    public int o = 0;

    /* compiled from: Sta */
    public class a implements c.a {
        public a() {
        }
    }

    /* renamed from: com.startapp.sdk.ads.video.b$b  reason: collision with other inner class name */
    /* compiled from: Sta */
    public class C0165b implements j.b {
        public final /* synthetic */ boolean a;

        public C0165b(boolean z) {
            this.a = z;
        }

        public void a(String str) {
            if (str != null) {
                if (!str.equals("downloadInterrupted")) {
                    b.this.b.setState(this.a ? Ad.AdState.READY : Ad.AdState.UN_INITIALIZED);
                    b.this.g().a(str);
                }
                b.this.c(this.a);
                return;
            }
            b.this.c(false);
            b bVar = b.this;
            k.a(bVar.a, bVar.a(), b.this.b, false);
            b.a(b.this, VASTErrorCodes.FileNotFound, (List) null);
        }
    }

    /* compiled from: Sta */
    public class c implements d.a {
        public c() {
        }

        public void a(String str) {
            b.this.g().a(str);
        }
    }

    /* compiled from: Sta */
    public class d implements d.C0000d {
        public final /* synthetic */ boolean a;

        public d(boolean z) {
            this.a = z;
        }

        public void a(Ad ad, CacheKey cacheKey, boolean z) {
            if (this.a && z) {
                b.this.n = cacheKey;
            }
        }
    }

    public b(Context context, Ad ad, AdPreferences adPreferences, AdEventListener adEventListener, AdPreferences.Placement placement) {
        super(context, ad, adPreferences, adEventListener, placement, true);
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0046 A[Catch:{ all -> 0x001e, all -> 0x0077 }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(com.startapp.sdk.ads.video.b r5, com.startapp.sdk.ads.video.vast.VASTErrorCodes r6, java.util.List<java.lang.String> r7) {
        /*
            r5.getClass()
            if (r7 == 0) goto L_0x0023
            int r0 = r7.size()     // Catch:{ all -> 0x0077 }
            if (r0 <= 0) goto L_0x0023
            com.startapp.sdk.ads.video.vast.VASTErrorCodes r0 = com.startapp.sdk.ads.video.vast.VASTErrorCodes.SAProcessSuccess     // Catch:{ all -> 0x001e }
            if (r6 != r0) goto L_0x0013
            java.util.List r7 = com.startapp.k9.a((java.util.List<java.lang.String>) r7)     // Catch:{ all -> 0x001e }
        L_0x0013:
            int r0 = r7.size()     // Catch:{ all -> 0x001e }
            if (r0 <= 0) goto L_0x0040
            com.startapp.sdk.ads.video.tracking.ActionTrackingLink[] r7 = com.startapp.sdk.ads.video.tracking.VideoTrackingDetails.b(r7)     // Catch:{ all -> 0x001e }
            goto L_0x0041
        L_0x001e:
            r7 = move-exception
            com.startapp.i3.a((java.lang.Throwable) r7)     // Catch:{ all -> 0x0077 }
            goto L_0x0040
        L_0x0023:
            com.startapp.sdk.ads.video.VideoAdDetails r7 = r5.g()     // Catch:{ all -> 0x0077 }
            if (r7 == 0) goto L_0x0040
            com.startapp.sdk.ads.video.VideoAdDetails r7 = r5.g()     // Catch:{ all -> 0x0077 }
            com.startapp.sdk.ads.video.tracking.VideoTrackingDetails r7 = r7.i()     // Catch:{ all -> 0x0077 }
            if (r7 == 0) goto L_0x0040
            com.startapp.sdk.ads.video.VideoAdDetails r7 = r5.g()     // Catch:{ all -> 0x0077 }
            com.startapp.sdk.ads.video.tracking.VideoTrackingDetails r7 = r7.i()     // Catch:{ all -> 0x0077 }
            com.startapp.sdk.ads.video.tracking.ActionTrackingLink[] r7 = r7.e()     // Catch:{ all -> 0x0077 }
            goto L_0x0041
        L_0x0040:
            r7 = 0
        L_0x0041:
            if (r7 == 0) goto L_0x007b
            int r0 = r7.length     // Catch:{ all -> 0x0077 }
            if (r0 <= 0) goto L_0x007b
            com.startapp.sdk.ads.video.VideoAdDetails r0 = r5.g()     // Catch:{ all -> 0x0077 }
            java.lang.String r1 = ""
            if (r0 == 0) goto L_0x0059
            java.lang.String r2 = r0.j()     // Catch:{ all -> 0x0077 }
            if (r2 == 0) goto L_0x0059
            java.lang.String r0 = r0.j()     // Catch:{ all -> 0x0077 }
            goto L_0x005a
        L_0x0059:
            r0 = r1
        L_0x005a:
            com.startapp.sdk.ads.video.tracking.VideoTrackingParams r2 = new com.startapp.sdk.ads.video.tracking.VideoTrackingParams     // Catch:{ all -> 0x0077 }
            java.lang.String r3 = "1"
            r4 = 0
            r2.<init>(r1, r4, r4, r3)     // Catch:{ all -> 0x0077 }
            com.startapp.ga r1 = new com.startapp.ga     // Catch:{ all -> 0x0077 }
            r1.<init>(r7, r2, r0, r4)     // Catch:{ all -> 0x0077 }
            java.lang.String r7 = "error"
            r1.e = r7     // Catch:{ all -> 0x0077 }
            r1.f = r6     // Catch:{ all -> 0x0077 }
            com.startapp.fa r6 = r1.a()     // Catch:{ all -> 0x0077 }
            android.content.Context r5 = r5.a     // Catch:{ all -> 0x0077 }
            com.startapp.sdk.ads.video.VideoUtil.a((android.content.Context) r5, (com.startapp.fa) r6)     // Catch:{ all -> 0x0077 }
            goto L_0x007b
        L_0x0077:
            r5 = move-exception
            com.startapp.i3.a((java.lang.Throwable) r5)
        L_0x007b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.sdk.ads.video.b.a(com.startapp.sdk.ads.video.b, com.startapp.sdk.ads.video.vast.VASTErrorCodes, java.util.List):void");
    }

    public boolean b(GetAdRequest getAdRequest) {
        VideoUtil.VideoEligibility a2;
        if (!(getAdRequest != null)) {
            return false;
        }
        if (!getAdRequest.b() || (a2 = VideoUtil.a(this.a)) == VideoUtil.VideoEligibility.ELIGIBLE) {
            return true;
        }
        this.f = a2.a();
        return false;
    }

    public GetAdRequest d() {
        GetAdRequest a2 = a((GetAdRequest) new a());
        if (a2 != null) {
            a2.f(this.a);
        }
        return a2;
    }

    public VideoAdDetails g() {
        return ((VideoEnabledAd) this.b).x();
    }

    public void b(boolean z) {
        if (!(g() != null)) {
            this.b.setState(z ? Ad.AdState.READY : Ad.AdState.UN_INITIALIZED);
        }
    }

    public final void d(boolean z) {
        AdPreferences adPreferences;
        Ad.AdType type = this.b.getType();
        Ad.AdType adType = Ad.AdType.REWARDED_VIDEO;
        if ((type != adType && this.b.getType() != Ad.AdType.VIDEO) || z) {
            AdPreferences adPreferences2 = this.c;
            if (adPreferences2 == null) {
                adPreferences = new AdPreferences();
            } else {
                adPreferences = new AdPreferences(adPreferences2);
            }
            adPreferences.setType((this.b.getType() == adType || this.b.getType() == Ad.AdType.VIDEO) ? Ad.AdType.VIDEO_NO_VAST : Ad.AdType.NON_VIDEO);
            com.startapp.sdk.adsbase.cache.d.h.a(this.a, (StartAppAd) null, this.e, adPreferences, (d.C0000d) new d(z));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: com.startapp.r9} */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: type inference failed for: r1v7 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(java.lang.Object r15) {
        /*
            r14 = this;
            r0 = r15
            com.startapp.z5$a r0 = (com.startapp.z5.a) r0
            r1 = 0
            if (r0 == 0) goto L_0x0009
            java.lang.String r2 = r0.c
            goto L_0x000a
        L_0x0009:
            r2 = r1
        L_0x000a:
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x0193
            java.lang.String r2 = r2.toLowerCase()
            java.lang.String r5 = "json"
            boolean r2 = r2.contains(r5)
            if (r2 == 0) goto L_0x0193
            com.startapp.sdk.adsbase.AdsCommonMetaData r15 = com.startapp.sdk.adsbase.AdsCommonMetaData.h
            com.startapp.sdk.adsbase.VideoConfig r15 = r15.G()
            boolean r2 = r15.q()
            if (r2 == 0) goto L_0x003a
            com.startapp.sdk.adsbase.model.GetAdRequest r2 = r14.i
            java.util.Set<java.lang.String> r2 = r2.H0
            if (r2 == 0) goto L_0x0034
            int r2 = r2.size()
            if (r2 <= 0) goto L_0x0034
            r2 = 1
            goto L_0x0035
        L_0x0034:
            r2 = 0
        L_0x0035:
            if (r2 != 0) goto L_0x003a
            r14.d(r4)
        L_0x003a:
            java.lang.String r2 = r0.b     // Catch:{ Exception -> 0x018b }
            java.lang.Class<com.startapp.o9> r5 = com.startapp.o9.class
            java.lang.Object r2 = com.startapp.g4.a(r2, r5)     // Catch:{ Exception -> 0x018b }
            com.startapp.o9 r2 = (com.startapp.o9) r2     // Catch:{ Exception -> 0x018b }
            if (r2 == 0) goto L_0x0184
            java.lang.String r5 = r2.getVastTag()
            if (r5 == 0) goto L_0x0184
            com.startapp.sdk.adsbase.remoteconfig.MetaData r5 = com.startapp.sdk.adsbase.remoteconfig.MetaData.k
            java.lang.String r8 = r5.Q()
            boolean r5 = r2.isRecordHops()
            if (r5 == 0) goto L_0x0073
            boolean r5 = android.text.TextUtils.isEmpty(r8)
            if (r5 != 0) goto L_0x0073
            com.startapp.sdk.ads.video.vast.b r5 = new com.startapp.sdk.ads.video.vast.b
            android.content.Context r7 = r14.a
            java.lang.String r9 = r2.getPartnerResponse()
            java.lang.String r10 = r2.getPartnerName()
            boolean r11 = r2.isSkipFailed()
            r6 = r5
            r6.<init>(r7, r8, r9, r10, r11)
            goto L_0x0074
        L_0x0073:
            r5 = r1
        L_0x0074:
            android.content.Context r6 = r14.a
            com.startapp.sdk.components.ComponentLocator r6 = com.startapp.sdk.components.ComponentLocator.a((android.content.Context) r6)
            com.startapp.va r6 = r6.x()
            java.lang.String r6 = r6.a()
            com.startapp.sdk.ads.video.vast.c r7 = new com.startapp.sdk.ads.video.vast.c
            android.content.Context r8 = r14.a
            android.content.res.Resources r8 = r8.getResources()
            android.util.DisplayMetrics r8 = r8.getDisplayMetrics()
            r7.<init>(r8, r6)
            int r6 = r15.e()
            r7.f = r6
            com.startapp.sdk.ads.video.b$a r6 = new com.startapp.sdk.ads.video.b$a
            r6.<init>()
            r7.c = r6
            java.lang.String r6 = r2.getVastTag()
            java.util.Set<com.startapp.sdk.ads.video.vast.a> r8 = r7.g
            r8.clear()
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            com.startapp.m9 r6 = r7.a(r6, r8, r5)
            if (r6 == 0) goto L_0x00f4
            int r8 = r7.a
            float r8 = (float) r8
            float r9 = r7.b
            float r8 = r8 / r9
            int r8 = (int) r8
            java.util.Set<com.startapp.sdk.ads.video.vast.a> r9 = r7.g
            java.util.Iterator r9 = r9.iterator()
            r10 = r1
        L_0x00c0:
            boolean r11 = r9.hasNext()
            if (r11 == 0) goto L_0x00e0
            java.lang.Object r11 = r9.next()
            com.startapp.sdk.ads.video.vast.a r11 = (com.startapp.sdk.ads.video.vast.a) r11
            if (r10 == 0) goto L_0x00de
            int r12 = r7.a
            float r12 = r11.a(r12, r8)
            int r13 = r7.a
            float r13 = r10.a(r13, r8)
            int r12 = (r12 > r13 ? 1 : (r12 == r13 ? 0 : -1))
            if (r12 <= 0) goto L_0x00c0
        L_0x00de:
            r10 = r11
            goto L_0x00c0
        L_0x00e0:
            r6.o = r10
            java.util.ArrayList r8 = new java.util.ArrayList
            java.util.List<java.lang.String> r9 = r6.a
            r8.<init>(r9)
            com.startapp.sdk.ads.video.vast.VASTErrorCodes r9 = com.startapp.sdk.ads.video.vast.VASTErrorCodes.SAProcessSuccess
            r7.a((java.util.List<java.lang.String>) r8, (com.startapp.sdk.ads.video.vast.VASTErrorCodes) r9)
            if (r5 == 0) goto L_0x00fd
            r5.a(r9)
            goto L_0x00fd
        L_0x00f4:
            if (r5 == 0) goto L_0x00fd
            com.startapp.sdk.ads.video.vast.VASTErrorCodes r7 = r7.d
            if (r7 == 0) goto L_0x00fd
            r5.a(r7)
        L_0x00fd:
            if (r6 == 0) goto L_0x013e
            com.startapp.sdk.adsbase.Ad r3 = r14.b
            com.startapp.sdk.adsbase.Ad$AdType r3 = r3.getType()
            com.startapp.sdk.adsbase.Ad$AdType r4 = com.startapp.sdk.adsbase.Ad.AdType.REWARDED_VIDEO
            if (r3 == r4) goto L_0x0116
            com.startapp.r9 r1 = new com.startapp.r9
            java.lang.Long r3 = r2.getSkipafter()
            java.lang.Long r4 = r2.getSkipmin()
            r1.<init>(r3, r4)
        L_0x0116:
            com.startapp.sdk.adsbase.Ad r3 = r14.b
            com.startapp.sdk.ads.video.VideoEnabledAd r3 = (com.startapp.sdk.ads.video.VideoEnabledAd) r3
            r3.a(r6, r15, r1)
            java.lang.String r15 = r2.getTtlSec()
            if (r15 == 0) goto L_0x012e
            com.startapp.sdk.adsbase.Ad r15 = r14.b
            com.startapp.sdk.ads.video.VideoEnabledAd r15 = (com.startapp.sdk.ads.video.VideoEnabledAd) r15
            java.lang.String r1 = r2.getTtlSec()
            r15.b((java.lang.String) r1)
        L_0x012e:
            java.lang.String r15 = r2.getAdmTag()
            r0.b = r15
            java.lang.String r15 = "text/html"
            r0.c = r15
            boolean r15 = super.a(r0)
            goto L_0x018a
        L_0x013e:
            java.lang.String r0 = r2.getCampaignId()
            if (r0 == 0) goto L_0x014d
            java.util.Set<java.lang.String> r0 = r14.h
            java.lang.String r2 = r2.getCampaignId()
            r0.add(r2)
        L_0x014d:
            int r0 = r14.o
            int r0 = r0 + r4
            r14.o = r0
            com.startapp.sdk.adsbase.Ad r0 = r14.b
            com.startapp.sdk.ads.video.VideoEnabledAd r0 = (com.startapp.sdk.ads.video.VideoEnabledAd) r0
            r0.w()
            long r4 = java.lang.System.currentTimeMillis()
            long r6 = r14.m
            long r4 = r4 - r6
            int r0 = r15.n()
            long r6 = (long) r0
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 < 0) goto L_0x0170
            java.lang.String r15 = "VAST retry timeout"
            boolean r15 = r14.a((java.lang.String) r15, (java.lang.Throwable) r1, (boolean) r3)
            goto L_0x018a
        L_0x0170:
            int r0 = r14.o
            int r15 = r15.d()
            if (r0 <= r15) goto L_0x017f
            java.lang.String r15 = "VAST too many excludes"
            boolean r15 = r14.a((java.lang.String) r15, (java.lang.Throwable) r1, (boolean) r3)
            goto L_0x018a
        L_0x017f:
            boolean r15 = r14.b()
            goto L_0x018a
        L_0x0184:
            java.lang.String r15 = "no VAST wrapper in json"
            boolean r15 = r14.a((java.lang.String) r15, (java.lang.Throwable) r1, (boolean) r4)
        L_0x018a:
            return r15
        L_0x018b:
            r15 = move-exception
            java.lang.String r0 = "VAST json parsing"
            boolean r15 = r14.a((java.lang.String) r0, (java.lang.Throwable) r15, (boolean) r4)
            return r15
        L_0x0193:
            if (r0 == 0) goto L_0x0197
            java.lang.String r1 = r0.b
        L_0x0197:
            com.startapp.sdk.adsbase.AdsCommonMetaData r0 = com.startapp.sdk.adsbase.AdsCommonMetaData.h
            com.startapp.sdk.adsbase.VideoConfig r0 = r0.G()
            boolean r0 = r0.q()
            if (r0 == 0) goto L_0x01b2
            java.lang.String r0 = "@videoJson@"
            java.lang.String r0 = com.startapp.k9.a((java.lang.String) r1, (java.lang.String) r0, (java.lang.String) r0)
            if (r0 == 0) goto L_0x01ac
            goto L_0x01ad
        L_0x01ac:
            r4 = 0
        L_0x01ad:
            if (r4 == 0) goto L_0x01b2
            r14.d(r3)
        L_0x01b2:
            boolean r15 = super.a(r15)
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.sdk.ads.video.b.a(java.lang.Object):boolean");
    }

    public void a(boolean z) {
        super.a(z);
        if (z) {
            if (g() != null) {
                if (AdsCommonMetaData.h.G().p()) {
                    this.b.setState(z ? Ad.AdState.READY : Ad.AdState.UN_INITIALIZED);
                }
                g().a(this.c.isVideoMuted());
                C0165b bVar = new C0165b(z);
                c cVar = new c();
                h a2 = ComponentLocator.a(this.a).J.a();
                a2.c.execute(new e(a2, g().j(), bVar, cVar));
                return;
            }
        }
        c(z);
    }

    public final boolean a(String str, Throwable th, boolean z) {
        if (th != null) {
            i3.a(th);
        } else if (z) {
            i3 i3Var = new i3(j3.e);
            i3Var.d = str;
            i3Var.a();
        }
        com.startapp.sdk.adsbase.d c2 = com.startapp.sdk.adsbase.cache.d.h.c(this.n);
        if (c2 instanceof HtmlAd) {
            z5.a aVar = new z5.a();
            aVar.c = "text/html";
            aVar.b = ((HtmlAd) c2).k();
            return super.a(aVar);
        }
        this.b.setErrorMessage(this.f);
        return false;
    }
}

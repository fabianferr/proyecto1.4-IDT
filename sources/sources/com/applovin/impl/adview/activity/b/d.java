package com.applovin.impl.adview.activity.b;

import android.app.Activity;
import android.graphics.PointF;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import com.applovin.impl.a.a;
import com.applovin.impl.a.f;
import com.applovin.impl.a.j;
import com.applovin.impl.a.k;
import com.applovin.impl.a.l;
import com.applovin.impl.a.n;
import com.applovin.impl.adview.j;
import com.applovin.impl.sdk.ad.e;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.u;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.iab.omid.library.applovin.adsession.FriendlyObstructionPurpose;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class d extends f {
    /* access modifiers changed from: private */
    public final a C;
    /* access modifiers changed from: private */
    public final Set<j> D;

    public d(e eVar, Activity activity, m mVar, AppLovinAdClickListener appLovinAdClickListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        super(eVar, activity, mVar, appLovinAdClickListener, appLovinAdDisplayListener, appLovinAdVideoPlaybackListener);
        HashSet hashSet = new HashSet();
        this.D = hashSet;
        a aVar = (a) eVar;
        this.C = aVar;
        hashSet.addAll(aVar.a(a.c.VIDEO, k.a));
        a(a.c.IMPRESSION);
        a(a.c.VIDEO, "creativeView");
        aVar.o().d();
    }

    private void A() {
        if (r() && !this.D.isEmpty()) {
            if (u.a()) {
                u uVar = this.c;
                uVar.d("AppLovinFullscreenActivity", "Firing " + this.D.size() + " un-fired video progress trackers when video was completed.");
            }
            a(this.D);
        }
    }

    private void a(a.c cVar) {
        a(cVar, f.UNSPECIFIED);
    }

    private void a(a.c cVar, f fVar) {
        a(cVar, "", fVar);
    }

    private void a(a.c cVar, String str) {
        a(cVar, str, f.UNSPECIFIED);
    }

    private void a(a.c cVar, String str, f fVar) {
        a(this.C.a(cVar, str), fVar);
    }

    /* access modifiers changed from: private */
    public void a(Set<j> set) {
        a(set, f.UNSPECIFIED);
    }

    private void a(Set<j> set, f fVar) {
        if (set != null && !set.isEmpty()) {
            long seconds = TimeUnit.MILLISECONDS.toSeconds((long) this.s.getCurrentPosition());
            n aN = this.C.aN();
            Uri a = aN != null ? aN.a() : null;
            if (u.a()) {
                u uVar = this.c;
                uVar.b("AppLovinFullscreenActivity", "Firing " + set.size() + " tracker(s): " + set);
            }
            l.a(set, seconds, a, fVar, this.b);
        }
    }

    public void a(PointF pointF) {
        a(a.c.VIDEO_CLICK);
        this.C.o().o();
        super.a(pointF);
    }

    public void a(ViewGroup viewGroup) {
        super.a(viewGroup);
        this.y.a("PROGRESS_TRACKING", TimeUnit.SECONDS.toMillis(1), (j.a) new j.a() {
            public void a() {
                long seconds = TimeUnit.MILLISECONDS.toSeconds(d.this.A - ((long) (d.this.s.getDuration() - d.this.s.getCurrentPosition())));
                int z = d.this.z();
                HashSet hashSet = new HashSet();
                for (com.applovin.impl.a.j jVar : new HashSet(d.this.D)) {
                    if (jVar.a(seconds, z)) {
                        hashSet.add(jVar);
                        d.this.D.remove(jVar);
                    }
                }
                d.this.a((Set<com.applovin.impl.a.j>) hashSet);
                if (z >= 25 && z < 50) {
                    d.this.C.o().f();
                } else if (z >= 50 && z < 75) {
                    d.this.C.o().g();
                } else if (z >= 75) {
                    d.this.C.o().h();
                }
            }

            public boolean b() {
                return !d.this.B;
            }
        });
        ArrayList arrayList = new ArrayList();
        if (this.t != null) {
            arrayList.add(new com.applovin.impl.sdk.b.d(this.t, FriendlyObstructionPurpose.OTHER, "video stream buffering indicator"));
        }
        if (this.u != null) {
            arrayList.add(new com.applovin.impl.sdk.b.d(this.u, FriendlyObstructionPurpose.CLOSE_AD, "skip button"));
        }
        if (this.x != null) {
            arrayList.add(new com.applovin.impl.sdk.b.d(this.x, FriendlyObstructionPurpose.OTHER, "progress bar"));
        }
        if (this.v != null) {
            arrayList.add(new com.applovin.impl.sdk.b.d(this.v, FriendlyObstructionPurpose.VIDEO_CONTROLS, "mute button"));
        }
        if (this.w != null) {
            arrayList.add(new com.applovin.impl.sdk.b.d(this.w, FriendlyObstructionPurpose.VIDEO_CONTROLS, "generic webview overlay containing HTML controls"));
        }
        this.C.o().a((View) this.s, (List<com.applovin.impl.sdk.b.d>) arrayList);
    }

    public void c() {
        a(a.c.VIDEO, "skip");
        this.C.o().n();
        super.c();
    }

    /* access modifiers changed from: protected */
    public void c(long j) {
        super.c(j);
        this.C.o().a((float) TimeUnit.MILLISECONDS.toSeconds(j), Utils.isVideoMutedInitially(this.b));
    }

    public void c(String str) {
        a(a.c.ERROR, f.MEDIA_FILE_ERROR);
        this.C.o().a(str);
        super.c(str);
    }

    public void d() {
        a((ViewGroup) null);
    }

    public void e() {
        this.y.c();
        super.e();
    }

    public void f() {
        super.f();
        a(this.B ? a.c.COMPANION : a.c.VIDEO, CampaignEx.JSON_NATIVE_VIDEO_RESUME);
        this.C.o().k();
    }

    public void g() {
        super.g();
        a(this.B ? a.c.COMPANION : a.c.VIDEO, CampaignEx.JSON_NATIVE_VIDEO_PAUSE);
        this.C.o().j();
    }

    public void h() {
        if (this.C != null) {
            a(a.c.VIDEO, "close");
            a(a.c.COMPANION, "close");
        }
        super.h();
    }

    /* access modifiers changed from: protected */
    public void u() {
        long j;
        int t;
        long j2 = 0;
        if (this.C.ad() >= 0 || this.C.ae() >= 0) {
            int i = (this.C.ad() > 0 ? 1 : (this.C.ad() == 0 ? 0 : -1));
            a aVar = this.C;
            if (i >= 0) {
                j = aVar.ad();
            } else {
                com.applovin.impl.a.m aM = aVar.aM();
                if (aM != null && aM.b() > 0) {
                    j2 = 0 + TimeUnit.SECONDS.toMillis((long) aM.b());
                } else if (this.A > 0) {
                    j2 = 0 + this.A;
                }
                if (aVar.af() && (t = (int) aVar.t()) > 0) {
                    j2 += TimeUnit.SECONDS.toMillis((long) t);
                }
                double d = (double) j2;
                double ae = (double) this.C.ae();
                Double.isNaN(ae);
                Double.isNaN(d);
                j = (long) (d * (ae / 100.0d));
            }
            b(j);
        }
    }

    /* access modifiers changed from: protected */
    public void v() {
        super.v();
        a aVar = this.C;
        if (aVar != null) {
            aVar.o().l();
        }
    }

    /* access modifiers changed from: protected */
    public void w() {
        super.w();
        a aVar = this.C;
        if (aVar != null) {
            aVar.o().m();
        }
    }

    public void x() {
        super.x();
        a(a.c.VIDEO, this.z ? CampaignEx.JSON_NATIVE_VIDEO_MUTE : CampaignEx.JSON_NATIVE_VIDEO_UNMUTE);
        this.C.o().a(this.z);
    }

    public void y() {
        A();
        if (!l.c(this.C)) {
            if (u.a()) {
                this.c.b("AppLovinFullscreenActivity", "VAST ad does not have valid companion ad - dismissing...");
            }
            h();
        } else if (!this.B) {
            a(a.c.COMPANION, "creativeView");
            this.C.o().i();
            this.C.o().a((View) this.f, (List<com.applovin.impl.sdk.b.d>) Collections.singletonList(new com.applovin.impl.sdk.b.d(this.f, FriendlyObstructionPurpose.CLOSE_AD, "close button")));
            super.y();
        }
    }
}

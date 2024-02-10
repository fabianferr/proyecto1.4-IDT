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
import com.applovin.impl.sdk.b.d;
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

public class c extends e {
    /* access modifiers changed from: private */
    public final a F;
    /* access modifiers changed from: private */
    public final Set<j> G;

    public c(e eVar, Activity activity, m mVar, AppLovinAdClickListener appLovinAdClickListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        super(eVar, activity, mVar, appLovinAdClickListener, appLovinAdDisplayListener, appLovinAdVideoPlaybackListener);
        HashSet hashSet = new HashSet();
        this.G = hashSet;
        a aVar = (a) eVar;
        this.F = aVar;
        hashSet.addAll(aVar.a(a.c.VIDEO, k.a));
        a(a.c.IMPRESSION);
        a(a.c.VIDEO, "creativeView");
        aVar.o().d();
    }

    private void E() {
        if (r() && !this.G.isEmpty()) {
            if (u.a()) {
                u uVar = this.c;
                uVar.d("AppLovinFullscreenActivity", "Firing " + this.G.size() + " un-fired video progress trackers when video was completed.");
            }
            a(this.G);
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
        a(this.F.a(cVar, str), fVar);
    }

    /* access modifiers changed from: private */
    public void a(Set<j> set) {
        a(set, f.UNSPECIFIED);
    }

    private void a(Set<j> set, f fVar) {
        if (set != null && !set.isEmpty()) {
            long seconds = TimeUnit.MILLISECONDS.toSeconds(this.t.getCurrentPosition());
            n aN = this.F.aN();
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
        this.F.o().o();
        super.a(pointF);
    }

    public void a(ViewGroup viewGroup) {
        super.a(viewGroup);
        this.z.a("PROGRESS_TRACKING", TimeUnit.SECONDS.toMillis(1), (j.a) new j.a() {
            public void a() {
                long seconds = TimeUnit.MILLISECONDS.toSeconds(c.this.B - (c.this.t.getDuration() - c.this.t.getCurrentPosition()));
                int D = c.this.D();
                HashSet hashSet = new HashSet();
                for (com.applovin.impl.a.j jVar : new HashSet(c.this.G)) {
                    if (jVar.a(seconds, D)) {
                        hashSet.add(jVar);
                        c.this.G.remove(jVar);
                    }
                }
                c.this.a((Set<com.applovin.impl.a.j>) hashSet);
                if (D >= 25 && D < 50) {
                    c.this.F.o().f();
                } else if (D >= 50 && D < 75) {
                    c.this.F.o().g();
                } else if (D >= 75) {
                    c.this.F.o().h();
                }
            }

            public boolean b() {
                return !c.this.D;
            }
        });
        ArrayList arrayList = new ArrayList();
        if (this.u != null) {
            arrayList.add(new d(this.u, FriendlyObstructionPurpose.OTHER, "video stream buffering indicator"));
        }
        if (this.v != null) {
            arrayList.add(new d(this.v, FriendlyObstructionPurpose.CLOSE_AD, "skip button"));
        }
        if (this.y != null) {
            arrayList.add(new d(this.y, FriendlyObstructionPurpose.OTHER, "progress bar"));
        }
        if (this.w != null) {
            arrayList.add(new d(this.w, FriendlyObstructionPurpose.VIDEO_CONTROLS, "mute button"));
        }
        if (this.x != null) {
            arrayList.add(new d(this.x, FriendlyObstructionPurpose.VIDEO_CONTROLS, "generic webview overlay containing HTML controls"));
        }
        this.F.o().a((View) this.s, (List<d>) arrayList);
    }

    public void c() {
        a(a.c.VIDEO, "skip");
        this.F.o().n();
        super.c();
    }

    /* access modifiers changed from: protected */
    public void c(long j) {
        super.c(j);
        this.F.o().a((float) TimeUnit.MILLISECONDS.toSeconds(j), Utils.isVideoMutedInitially(this.b));
    }

    public void c(String str) {
        a(a.c.ERROR, f.MEDIA_FILE_ERROR);
        this.F.o().a(str);
        super.c(str);
    }

    public void d() {
        a((ViewGroup) null);
    }

    public void e() {
        this.z.c();
        super.e();
    }

    public void f() {
        super.f();
        a(this.D ? a.c.COMPANION : a.c.VIDEO, CampaignEx.JSON_NATIVE_VIDEO_RESUME);
        this.F.o().k();
    }

    public void g() {
        super.g();
        a(this.D ? a.c.COMPANION : a.c.VIDEO, CampaignEx.JSON_NATIVE_VIDEO_PAUSE);
        this.F.o().j();
    }

    public void h() {
        if (this.F != null) {
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
        if (this.F.ad() >= 0 || this.F.ae() >= 0) {
            int i = (this.F.ad() > 0 ? 1 : (this.F.ad() == 0 ? 0 : -1));
            a aVar = this.F;
            if (i >= 0) {
                j = aVar.ad();
            } else {
                com.applovin.impl.a.m aM = aVar.aM();
                if (aM != null && aM.b() > 0) {
                    j2 = 0 + TimeUnit.SECONDS.toMillis((long) aM.b());
                } else if (this.B > 0) {
                    j2 = 0 + this.B;
                }
                if (aVar.af() && (t = (int) aVar.t()) > 0) {
                    j2 += TimeUnit.SECONDS.toMillis((long) t);
                }
                double d = (double) j2;
                double ae = (double) this.F.ae();
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
        a aVar = this.F;
        if (aVar != null) {
            aVar.o().l();
        }
    }

    /* access modifiers changed from: protected */
    public void w() {
        super.w();
        a aVar = this.F;
        if (aVar != null) {
            aVar.o().m();
        }
    }

    public void x() {
        super.x();
        a(a.c.VIDEO, this.A ? CampaignEx.JSON_NATIVE_VIDEO_MUTE : CampaignEx.JSON_NATIVE_VIDEO_UNMUTE);
        this.F.o().a(this.A);
    }

    public void y() {
        E();
        if (!l.c(this.F)) {
            if (u.a()) {
                this.c.b("AppLovinFullscreenActivity", "VAST ad does not have valid companion ad - dismissing...");
            }
            h();
        } else if (!this.D) {
            a(a.c.COMPANION, "creativeView");
            this.F.o().i();
            this.F.o().a((View) this.f, (List<d>) Collections.singletonList(new d(this.f, FriendlyObstructionPurpose.CLOSE_AD, "close button")));
            super.y();
        }
    }
}

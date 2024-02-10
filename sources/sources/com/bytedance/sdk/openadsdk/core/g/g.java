package com.bytedance.sdk.openadsdk.core.g;

import android.util.Pair;
import android.view.View;
import com.iab.omid.library.bytedance2.adsession.AdEvents;
import com.iab.omid.library.bytedance2.adsession.AdSession;
import com.iab.omid.library.bytedance2.adsession.FriendlyObstructionPurpose;
import com.iab.omid.library.bytedance2.adsession.media.Position;
import com.iab.omid.library.bytedance2.adsession.media.VastProperties;
import java.util.Set;

/* compiled from: ViewabilityTracker */
public class g {
    protected boolean a = false;
    protected int b = 0;
    protected String c;
    protected VastProperties d;
    private final AdSession e;
    private final AdEvents f;
    private boolean g = false;

    /* access modifiers changed from: package-private */
    public void a(float f2, boolean z) {
    }

    public void a(boolean z) {
    }

    public void a(boolean z, float f2) {
    }

    /* access modifiers changed from: package-private */
    public void b(int i) {
    }

    public g(AdSession adSession, AdEvents adEvents, View view) {
        this.e = adSession;
        this.f = adEvents;
        this.c = adSession.getAdSessionId();
        a(view);
    }

    /* access modifiers changed from: package-private */
    public void a(View view) {
        AdSession adSession;
        if (view != null && (adSession = this.e) != null) {
            adSession.registerAdView(view);
        }
    }

    public void a(View view, FriendlyObstructionPurpose friendlyObstructionPurpose) {
        AdSession adSession = this.e;
        if (adSession != null) {
            adSession.addFriendlyObstruction(view, friendlyObstructionPurpose, (String) null);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean a() {
        return this.a;
    }

    public void a(int i) {
        int i2;
        int i3;
        if (this.e != null && this.f != null) {
            boolean z = false;
            if (e.c()) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (!(i != 4 || (i3 = this.b) == 0 || i3 == 4)) {
                                this.e.finish();
                                this.a = false;
                            }
                        } else if (!this.g && ((i2 = this.b) == 1 || i2 == 2)) {
                            this.f.impressionOccurred();
                            this.g = true;
                        }
                    } else if (this.b == 0) {
                        this.e.start();
                        if (this.d == null) {
                            this.d = VastProperties.createVastPropertiesForNonSkippableMedia(true, Position.STANDALONE);
                        }
                        this.f.loaded(this.d);
                        this.a = true;
                        this.d = null;
                    }
                } else if (this.b == 0) {
                    this.e.start();
                    this.f.loaded();
                    this.a = true;
                }
                z = true;
            }
            if (z) {
                this.b = i;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void b() {
        a(1);
    }

    /* access modifiers changed from: package-private */
    public void c() {
        a(4);
    }

    public void d() {
        a(3);
    }

    public void a(Set<Pair<View, FriendlyObstructionPurpose>> set) {
        for (Pair next : set) {
            a((View) next.first, (FriendlyObstructionPurpose) next.second);
        }
    }
}

package com.applovin.impl.sdk.b;

import android.text.TextUtils;
import android.webkit.WebView;
import com.applovin.impl.a.a;
import com.applovin.impl.a.b;
import com.applovin.impl.a.f;
import com.applovin.impl.a.j;
import com.applovin.impl.a.l;
import com.applovin.impl.sdk.u;
import com.applovin.impl.sdk.utils.StringUtils;
import com.iab.omid.library.applovin.adsession.AdSession;
import com.iab.omid.library.applovin.adsession.AdSessionConfiguration;
import com.iab.omid.library.applovin.adsession.AdSessionContext;
import com.iab.omid.library.applovin.adsession.CreativeType;
import com.iab.omid.library.applovin.adsession.ImpressionType;
import com.iab.omid.library.applovin.adsession.Owner;
import com.iab.omid.library.applovin.adsession.VerificationScriptResource;
import com.iab.omid.library.applovin.adsession.media.InteractionType;
import com.iab.omid.library.applovin.adsession.media.MediaEvents;
import com.iab.omid.library.applovin.adsession.media.Position;
import com.iab.omid.library.applovin.adsession.media.VastProperties;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public class g extends b {
    static final /* synthetic */ boolean h = true;
    private final a i;
    private final AtomicBoolean j = new AtomicBoolean();
    /* access modifiers changed from: private */
    public MediaEvents k;
    /* access modifiers changed from: private */
    public final VastProperties l;
    private final AtomicBoolean m = new AtomicBoolean();
    private final AtomicBoolean n = new AtomicBoolean();
    private final AtomicBoolean o = new AtomicBoolean();
    private final AtomicBoolean p = new AtomicBoolean();

    public g(a aVar) {
        super(aVar);
        this.i = aVar;
        this.l = aVar.i() == -1 ? VastProperties.createVastPropertiesForNonSkippableMedia(true, Position.STANDALONE) : VastProperties.createVastPropertiesForSkippableMedia((float) aVar.i(), true, Position.STANDALONE);
    }

    /* access modifiers changed from: protected */
    public AdSessionConfiguration a() {
        try {
            return AdSessionConfiguration.createAdSessionConfiguration(CreativeType.VIDEO, ImpressionType.BEGIN_TO_RENDER, Owner.NATIVE, Owner.NATIVE, false);
        } catch (Throwable th) {
            if (u.a()) {
                this.c.b(this.d, "Failed to create ad session configuration", th);
            }
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public AdSessionContext a(WebView webView) {
        Set<j> d;
        f fVar;
        if (h || this.i.aU() != null) {
            ArrayList arrayList = new ArrayList();
            for (b next : this.i.aU().a()) {
                List<com.applovin.impl.a.g> b = next.b();
                if (!b.isEmpty()) {
                    ArrayList<com.applovin.impl.a.g> arrayList2 = new ArrayList<>();
                    for (com.applovin.impl.a.g next2 : b) {
                        if (CampaignEx.KEY_OMID.equalsIgnoreCase(next2.a())) {
                            arrayList2.add(next2);
                        }
                    }
                    if (arrayList2.isEmpty()) {
                        d = next.d();
                        fVar = f.API_FRAMEWORK_OR_LANGUAGE_TYPE_NOT_SUPPORTED;
                        l.a(d, fVar, this.b);
                    } else {
                        ArrayList<URL> arrayList3 = new ArrayList<>();
                        for (com.applovin.impl.a.g b2 : arrayList2) {
                            try {
                                arrayList3.add(new URL(b2.b()));
                            } catch (Throwable th) {
                                if (u.a()) {
                                    this.c.b(this.d, "Failed to parse JavaScript resource url", th);
                                }
                            }
                        }
                        if (!arrayList3.isEmpty()) {
                            String c = next.c();
                            String a = next.a();
                            if (!StringUtils.isValidString(c) || StringUtils.isValidString(a)) {
                                for (URL url : arrayList3) {
                                    arrayList.add(StringUtils.isValidString(c) ? VerificationScriptResource.createVerificationScriptResourceWithParameters(a, url, c) : VerificationScriptResource.createVerificationScriptResourceWithoutParameters(url));
                                }
                            }
                        }
                    }
                }
                d = next.d();
                fVar = f.FAILED_TO_LOAD_RESOURCE;
                l.a(d, fVar, this.b);
            }
            String e = this.b.al().e();
            if (TextUtils.isEmpty(e)) {
                if (u.a()) {
                    this.c.e(this.d, "JavaScript SDK content not loaded successfully");
                }
                return null;
            }
            try {
                return AdSessionContext.createNativeAdSessionContext(this.b.al().d(), e, arrayList, this.i.getOpenMeasurementContentUrl(), this.i.getOpenMeasurementCustomReferenceData());
            } catch (Throwable th2) {
                if (!u.a()) {
                    return null;
                }
                this.c.b(this.d, "Failed to create ad session context", th2);
                return null;
            }
        } else {
            throw new AssertionError();
        }
    }

    public void a(final float f, final boolean z) {
        if (this.m.compareAndSet(false, true)) {
            a("track started", (Runnable) new Runnable() {
                public void run() {
                    g.this.k.start(f, z ? 0.0f : 1.0f);
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void a(AdSession adSession) {
        try {
            this.k = MediaEvents.createMediaEvents(adSession);
        } catch (Throwable th) {
            if (u.a()) {
                this.c.b(this.d, "Failed to create media events", th);
            }
        }
    }

    public void a(final boolean z) {
        a("track volume changed", (Runnable) new Runnable() {
            public void run() {
                g.this.k.volumeChange(z ? 0.0f : 1.0f);
            }
        });
    }

    public void c() {
        a("track loaded", (Runnable) new Runnable() {
            public void run() {
                g.this.g.loaded(g.this.l);
            }
        });
    }

    public void f() {
        if (this.n.compareAndSet(false, true)) {
            a("track first quartile", (Runnable) new Runnable() {
                public void run() {
                    g.this.k.firstQuartile();
                }
            });
        }
    }

    public void g() {
        if (this.o.compareAndSet(false, true)) {
            a("track midpoint", (Runnable) new Runnable() {
                public void run() {
                    g.this.k.midpoint();
                }
            });
        }
    }

    public void h() {
        if (this.p.compareAndSet(false, true)) {
            a("track third quartile", (Runnable) new Runnable() {
                public void run() {
                    g.this.k.thirdQuartile();
                }
            });
        }
    }

    public void i() {
        a("track completed", (Runnable) new Runnable() {
            public void run() {
                g.this.k.complete();
            }
        });
    }

    public void j() {
        a("track paused", (Runnable) new Runnable() {
            public void run() {
                g.this.k.pause();
            }
        });
    }

    public void k() {
        a("track resumed", (Runnable) new Runnable() {
            public void run() {
                g.this.k.resume();
            }
        });
    }

    public void l() {
        if (this.j.compareAndSet(false, true)) {
            a("buffer started", (Runnable) new Runnable() {
                public void run() {
                    g.this.k.bufferStart();
                }
            });
        }
    }

    public void m() {
        if (this.j.compareAndSet(true, false)) {
            a("buffer finished", (Runnable) new Runnable() {
                public void run() {
                    g.this.k.bufferFinish();
                }
            });
        }
    }

    public void n() {
        a("track skipped", (Runnable) new Runnable() {
            public void run() {
                g.this.k.skipped();
            }
        });
    }

    public void o() {
        a("track clicked", (Runnable) new Runnable() {
            public void run() {
                g.this.k.adUserInteraction(InteractionType.CLICK);
            }
        });
    }
}

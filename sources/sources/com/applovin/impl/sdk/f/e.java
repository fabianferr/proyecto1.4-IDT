package com.applovin.impl.sdk.f;

import android.net.Uri;
import android.webkit.URLUtil;
import com.applovin.impl.a.a;
import com.applovin.impl.a.d;
import com.applovin.impl.a.h;
import com.applovin.impl.a.n;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.u;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinAdLoadListener;
import java.util.Collections;
import java.util.List;

class e extends c {
    private final a c;

    public e(a aVar, m mVar, AppLovinAdLoadListener appLovinAdLoadListener) {
        super("TaskCacheVastAd", aVar, mVar, appLovinAdLoadListener);
        this.c = aVar;
    }

    private void j() {
        String str;
        String str2;
        String str3;
        if (!b()) {
            if (this.c.aS()) {
                d aO = this.c.aO();
                if (aO != null) {
                    h b = aO.b();
                    if (b != null) {
                        Uri b2 = b.b();
                        String uri = b2 != null ? b2.toString() : "";
                        String c2 = b.c();
                        if (URLUtil.isValidUrl(uri) || StringUtils.isValidString(c2)) {
                            if (b.a() == h.a.STATIC) {
                                if (u.a()) {
                                    a("Caching static companion ad at " + uri + "...");
                                }
                                Uri c3 = c(uri, Collections.emptyList(), false);
                                if (c3 != null) {
                                    b.a(c3);
                                } else if (u.a()) {
                                    str2 = "Failed to cache static companion ad";
                                } else {
                                    return;
                                }
                            } else if (b.a() == h.a.HTML) {
                                if (StringUtils.isValidString(uri)) {
                                    if (u.a()) {
                                        a("Begin caching HTML companion ad. Fetching from " + uri + "...");
                                    }
                                    c2 = f(uri);
                                    if (StringUtils.isValidString(c2)) {
                                        if (u.a()) {
                                            str3 = "HTML fetched. Caching HTML now...";
                                        }
                                        b.a(a(c2, (List<String>) Collections.emptyList(), (com.applovin.impl.sdk.ad.e) this.c));
                                    } else if (u.a()) {
                                        str2 = "Unable to load companion ad resources from " + uri;
                                    } else {
                                        return;
                                    }
                                } else {
                                    if (u.a()) {
                                        str3 = "Caching provided HTML for companion ad. No fetch required. HTML: " + c2;
                                    }
                                    b.a(a(c2, (List<String>) Collections.emptyList(), (com.applovin.impl.sdk.ad.e) this.c));
                                }
                                a(str3);
                                b.a(a(c2, (List<String>) Collections.emptyList(), (com.applovin.impl.sdk.ad.e) this.c));
                            } else if (b.a() == h.a.IFRAME && u.a()) {
                                str = "Skip caching of iFrame resource...";
                            } else {
                                return;
                            }
                            this.c.a(true);
                            return;
                        } else if (u.a()) {
                            c("Companion ad does not have any resources attached. Skipping...");
                            return;
                        } else {
                            return;
                        }
                    } else if (u.a()) {
                        str2 = "Failed to retrieve non-video resources from companion ad. Skipping...";
                    } else {
                        return;
                    }
                    d(str2);
                    return;
                } else if (u.a()) {
                    str = "No companion ad provided. Skipping...";
                } else {
                    return;
                }
            } else if (u.a()) {
                str = "Companion ad caching disabled. Skipping...";
            } else {
                return;
            }
            a(str);
        }
    }

    private void k() {
        n aN;
        Uri b;
        if (!b()) {
            if (this.c.aT()) {
                if (this.c.aM() != null && (aN = this.c.aN()) != null && (b = aN.b()) != null) {
                    Uri a = a(b.toString(), (List<String>) Collections.emptyList(), false);
                    if (a != null) {
                        if (u.a()) {
                            a("Video file successfully cached into: " + a);
                        }
                        aN.a(a);
                    } else if (u.a()) {
                        d("Failed to cache video file: " + aN);
                    }
                }
            } else if (u.a()) {
                a("Video caching disabled. Skipping...");
            }
        }
    }

    private void l() {
        String str;
        String str2;
        if (!b()) {
            if (this.c.aR() != null) {
                if (u.a()) {
                    a("Begin caching HTML template. Fetching from " + this.c.aR() + "...");
                }
                str = a(this.c.aR().toString(), this.c.I());
            } else {
                str = this.c.aQ();
            }
            if (StringUtils.isValidString(str)) {
                String a = a(str, this.c.I(), this.a);
                if (this.c.q() && this.c.isOpenMeasurementEnabled()) {
                    a = this.b.al().a(a);
                }
                this.c.a(a);
                if (u.a()) {
                    str2 = "Finish caching HTML template " + this.c.aQ() + " for ad #" + this.c.getAdIdNumber();
                } else {
                    return;
                }
            } else if (u.a()) {
                str2 = "Unable to load HTML template";
            } else {
                return;
            }
            a(str2);
        }
    }

    /* access modifiers changed from: package-private */
    public void h() {
        this.c.o().e();
        super.h();
    }

    /* access modifiers changed from: package-private */
    public void i() {
        this.c.o().c();
        super.i();
    }

    public void run() {
        super.run();
        if (this.c.f()) {
            if (u.a()) {
                a("Begin caching for VAST streaming ad #" + this.a.getAdIdNumber() + "...");
            }
            c();
            if (this.c.m()) {
                i();
            }
            if (this.c.l() == a.b.COMPANION_AD) {
                j();
                l();
            } else {
                k();
            }
            if (!this.c.m()) {
                i();
            }
            if (this.c.l() == a.b.COMPANION_AD) {
                k();
            } else {
                j();
                l();
            }
        } else {
            if (u.a()) {
                a("Begin caching for VAST ad #" + this.a.getAdIdNumber() + "...");
            }
            c();
            j();
            k();
            l();
            i();
        }
        if (u.a()) {
            a("Finished caching VAST ad #" + this.c.getAdIdNumber());
        }
        long currentTimeMillis = System.currentTimeMillis() - this.c.getCreatedAtMillis();
        com.applovin.impl.sdk.e.d.a(this.c, this.b);
        com.applovin.impl.sdk.e.d.a(currentTimeMillis, (AppLovinAdBase) this.c, this.b);
        a((AppLovinAdBase) this.c);
        this.c.b();
        a();
    }
}

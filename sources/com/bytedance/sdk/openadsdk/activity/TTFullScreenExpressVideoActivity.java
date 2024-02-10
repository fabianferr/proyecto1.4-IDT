package com.bytedance.sdk.openadsdk.activity;

import com.bykv.vk.openvk.component.video.api.d.c;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.b.g;
import com.bytedance.sdk.openadsdk.component.reward.b.h;
import com.bytedance.sdk.openadsdk.core.model.q;
import java.util.HashMap;
import java.util.Map;

public class TTFullScreenExpressVideoActivity extends TTFullScreenVideoActivity {
    /* access modifiers changed from: protected */
    public void f() {
    }

    public boolean p() {
        return true;
    }

    public boolean q() {
        return true;
    }

    public boolean a(long j, boolean z) {
        g gVar;
        if (this.b.J == null || this.b.J.a() == null) {
            gVar = new g();
        } else {
            gVar = this.b.J.a().getAdShowTime();
        }
        if (this.c == null || !(this.c instanceof h) || this.b.i) {
            this.b.G.a(this.b.J.b(), gVar);
        } else {
            this.b.G.a(((h) this.c).C(), gVar);
        }
        HashMap hashMap = new HashMap();
        if (this.b.J != null) {
            hashMap.put("dynamic_show_type", Integer.valueOf(this.b.J.i()));
        }
        this.b.G.a((Map<String, Object>) hashMap);
        this.b.G.a((c.a) new c.a() {
            boolean a;

            public void a(long j, int i) {
                if (!this.a) {
                    this.a = true;
                    TTFullScreenExpressVideoActivity.this.d.removeMessages(300);
                    TTFullScreenExpressVideoActivity.this.m();
                    TTFullScreenExpressVideoActivity.this.b.J.b(true);
                    if (TTFullScreenExpressVideoActivity.this.b.a.o() == 21 && !TTFullScreenExpressVideoActivity.this.b.a.c()) {
                        TTFullScreenExpressVideoActivity.this.b.a.b(true);
                        TTFullScreenExpressVideoActivity.this.b.T.r();
                    }
                    if (TTFullScreenExpressVideoActivity.this.b.b) {
                        TTFullScreenExpressVideoActivity.this.a(false, 5);
                    } else if (q.c(TTFullScreenExpressVideoActivity.this.b.a)) {
                        TTFullScreenExpressVideoActivity.this.finish();
                    } else if (TTFullScreenExpressVideoActivity.this.b.J != null && TTFullScreenExpressVideoActivity.this.b.J.a() != null) {
                        TTFullScreenExpressVideoActivity.this.b.J.a().a("0", 0, 0, false);
                        if (TTFullScreenExpressVideoActivity.this.b.J.h()) {
                            TTFullScreenExpressVideoActivity.this.b.R.a("0", "X");
                            TTFullScreenExpressVideoActivity.this.b.R.e(true);
                        }
                    }
                }
            }

            public void b(long j, int i) {
                TTFullScreenExpressVideoActivity.this.d.removeMessages(300);
                if (TTFullScreenExpressVideoActivity.this.b.G.b()) {
                    TTFullScreenExpressVideoActivity.this.l();
                    return;
                }
                TTFullScreenExpressVideoActivity.this.b.G.m();
                l.d("TTAD.FSEVA", "fullscreen_interstitial_ad", "onError、、、、、、、、");
                TTFullScreenExpressVideoActivity.this.b.J.a(true);
                if (TTFullScreenExpressVideoActivity.this.b.b) {
                    TTFullScreenExpressVideoActivity.this.a(false, 3);
                    TTFullScreenExpressVideoActivity.this.b.G.a(TTFullScreenExpressVideoActivity.this.b.G.z() ^ true ? 1 : 0, 2);
                    return;
                }
                TTFullScreenExpressVideoActivity.this.finish();
            }

            public void a() {
                TTFullScreenExpressVideoActivity.this.d.removeMessages(300);
                TTFullScreenExpressVideoActivity.this.m();
                l.a("TTAD.FSEVA", "fullscreen_interstitial_ad", "onTimeOut、、、、、、、、");
                if (TTFullScreenExpressVideoActivity.this.b.b) {
                    TTFullScreenExpressVideoActivity.this.a(false, 6);
                } else {
                    TTFullScreenExpressVideoActivity.this.finish();
                }
                TTFullScreenExpressVideoActivity.this.b.G.a(TTFullScreenExpressVideoActivity.this.b.G.z() ^ true ? 1 : 0, TTFullScreenExpressVideoActivity.this.b.G.z() ^ true ? 1 : 0);
                TTFullScreenExpressVideoActivity.this.b.G.m();
            }

            public void a(long j, long j2) {
                if (!TTFullScreenExpressVideoActivity.this.b.e && TTFullScreenExpressVideoActivity.this.b.G.b()) {
                    TTFullScreenExpressVideoActivity.this.b.G.o();
                }
                if (!TTFullScreenExpressVideoActivity.this.b.u.get()) {
                    TTFullScreenExpressVideoActivity.this.d.removeMessages(300);
                    if (j != TTFullScreenExpressVideoActivity.this.b.G.h()) {
                        TTFullScreenExpressVideoActivity.this.m();
                    }
                    if (TTFullScreenExpressVideoActivity.this.b.G.b()) {
                        TTFullScreenExpressVideoActivity.this.b.G.a(j);
                        TTFullScreenExpressVideoActivity tTFullScreenExpressVideoActivity = TTFullScreenExpressVideoActivity.this;
                        double A = tTFullScreenExpressVideoActivity.b.G.A();
                        long j3 = j / 1000;
                        double d = (double) j3;
                        Double.isNaN(d);
                        tTFullScreenExpressVideoActivity.f = (int) (A - d);
                        int i = (int) j3;
                        if ((TTFullScreenExpressVideoActivity.this.b.E.get() || TTFullScreenExpressVideoActivity.this.b.v.get()) && TTFullScreenExpressVideoActivity.this.b.G.b()) {
                            TTFullScreenExpressVideoActivity.this.b.G.o();
                        }
                        if (!(TTFullScreenExpressVideoActivity.this.b.J == null || TTFullScreenExpressVideoActivity.this.b.J.a() == null)) {
                            TTFullScreenExpressVideoActivity.this.b.J.a().a(String.valueOf(TTFullScreenExpressVideoActivity.this.f), i, 0, false);
                        }
                        if (TTFullScreenExpressVideoActivity.this.b.J.h() || TTFullScreenExpressVideoActivity.this.b.a.bd()) {
                            TTFullScreenExpressVideoActivity.this.b(i);
                            if (TTFullScreenExpressVideoActivity.this.f >= 0) {
                                TTFullScreenExpressVideoActivity.this.b.R.d(true);
                                TTFullScreenExpressVideoActivity.this.b.R.a(String.valueOf(TTFullScreenExpressVideoActivity.this.f), (CharSequence) null);
                            }
                        }
                    }
                }
            }
        });
        return this.b.G.a(j, z, hashMap, this.c);
    }
}

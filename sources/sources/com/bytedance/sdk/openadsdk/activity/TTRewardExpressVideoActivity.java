package com.bytedance.sdk.openadsdk.activity;

import com.bykv.vk.openvk.component.video.api.d.c;
import com.bytedance.sdk.openadsdk.b.g;
import com.bytedance.sdk.openadsdk.common.TTAdDislikeToast;
import com.bytedance.sdk.openadsdk.core.o;
import java.util.HashMap;
import java.util.Map;

public class TTRewardExpressVideoActivity extends TTRewardVideoActivity {
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
        this.b.G.a(this.b.J.b(), gVar);
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
                    TTRewardExpressVideoActivity.this.d.removeMessages(300);
                    TTRewardExpressVideoActivity.this.m();
                    TTRewardExpressVideoActivity.this.b.J.b(true);
                    if (TTRewardExpressVideoActivity.this.b.a.o() == 21 && !TTRewardExpressVideoActivity.this.b.a.c()) {
                        TTRewardExpressVideoActivity.this.b.a.b(true);
                        TTRewardExpressVideoActivity.this.b.T.r();
                    }
                    if (TTRewardExpressVideoActivity.this.b.b) {
                        TTRewardExpressVideoActivity.this.a(false, 5);
                    } else {
                        TTRewardExpressVideoActivity.this.finish();
                    }
                    TTRewardExpressVideoActivity.this.l = (int) (System.currentTimeMillis() / 1000);
                    TTRewardExpressVideoActivity.this.s();
                }
            }

            public void b(long j, int i) {
                TTRewardExpressVideoActivity.this.d.removeMessages(300);
                if (TTRewardExpressVideoActivity.this.b.G.b()) {
                    TTRewardExpressVideoActivity.this.l();
                    return;
                }
                TTRewardExpressVideoActivity.this.s();
                TTRewardExpressVideoActivity.this.b.G.m();
                if (TTRewardExpressVideoActivity.this.b.b) {
                    TTRewardExpressVideoActivity.this.a(false, 3);
                } else {
                    TTRewardExpressVideoActivity.this.finish();
                }
                TTRewardExpressVideoActivity.this.b.J.a(true);
                TTRewardExpressVideoActivity.this.b.G.a(true ^ TTRewardExpressVideoActivity.this.b.G.z() ? 1 : 0, 2);
            }

            public void a() {
                TTRewardExpressVideoActivity.this.d.removeMessages(300);
                TTRewardExpressVideoActivity.this.m();
                TTRewardExpressVideoActivity.this.s();
                if (TTRewardExpressVideoActivity.this.b.b) {
                    TTRewardExpressVideoActivity.this.a(false, 6);
                } else {
                    TTRewardExpressVideoActivity.this.finish();
                }
                TTRewardExpressVideoActivity.this.b.G.a(TTRewardExpressVideoActivity.this.b.G.z() ^ true ? 1 : 0, TTRewardExpressVideoActivity.this.b.G.z() ^ true ? 1 : 0);
                TTRewardExpressVideoActivity.this.b.G.m();
            }

            public void a(long j, long j2) {
                if (!TTRewardExpressVideoActivity.this.b.e && TTRewardExpressVideoActivity.this.b.G.b()) {
                    TTRewardExpressVideoActivity.this.b.G.o();
                }
                if (!TTRewardExpressVideoActivity.this.b.u.get()) {
                    TTRewardExpressVideoActivity.this.d.removeMessages(300);
                    if (j != TTRewardExpressVideoActivity.this.b.G.h()) {
                        TTRewardExpressVideoActivity.this.m();
                    }
                    if (TTRewardExpressVideoActivity.this.b.G.b()) {
                        TTRewardExpressVideoActivity.this.b.G.a(j);
                        int j3 = o.d().j(String.valueOf(TTRewardExpressVideoActivity.this.b.o));
                        boolean z = TTRewardExpressVideoActivity.this.b.J.h() && j3 != -1 && j3 >= 0;
                        TTRewardExpressVideoActivity tTRewardExpressVideoActivity = TTRewardExpressVideoActivity.this;
                        double A = tTRewardExpressVideoActivity.b.G.A();
                        long j4 = j / 1000;
                        double d = (double) j4;
                        Double.isNaN(d);
                        tTRewardExpressVideoActivity.f = (int) (A - d);
                        int i = (int) j4;
                        if ((TTRewardExpressVideoActivity.this.b.E.get() || TTRewardExpressVideoActivity.this.b.v.get()) && TTRewardExpressVideoActivity.this.b.G.b()) {
                            TTRewardExpressVideoActivity.this.b.G.o();
                        }
                        if (TTRewardExpressVideoActivity.this.f >= 0) {
                            TTRewardExpressVideoActivity.this.b.R.a(String.valueOf(TTRewardExpressVideoActivity.this.f), (CharSequence) null);
                        }
                        TTRewardExpressVideoActivity.this.b.T.e(i);
                        TTRewardExpressVideoActivity.this.a(j, j2);
                        if (!(TTRewardExpressVideoActivity.this.b.J == null || TTRewardExpressVideoActivity.this.b.J.a() == null)) {
                            TTRewardExpressVideoActivity.this.b.J.a().a(String.valueOf(TTRewardExpressVideoActivity.this.f), i, 0, false);
                        }
                        if (TTRewardExpressVideoActivity.this.f <= 0) {
                            return;
                        }
                        if (!z || i < j3 || TTRewardExpressVideoActivity.this.b.a.o() == 5) {
                            TTRewardExpressVideoActivity.this.b.R.a(String.valueOf(TTRewardExpressVideoActivity.this.f), (CharSequence) null);
                            return;
                        }
                        TTRewardExpressVideoActivity.this.b.a(true);
                        TTRewardExpressVideoActivity.this.b.R.a(String.valueOf(TTRewardExpressVideoActivity.this.f), TTAdDislikeToast.getSkipText());
                        TTRewardExpressVideoActivity.this.b.R.e(true);
                    }
                }
            }
        });
        boolean a = this.b.G.a(j, z, hashMap, this.c);
        if (a && !z) {
            this.k = (int) (System.currentTimeMillis() / 1000);
        }
        return a;
    }
}

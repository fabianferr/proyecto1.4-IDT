package com.bytedance.sdk.openadsdk.component.reward.a;

import android.util.SparseArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import com.bytedance.sdk.component.adexpress.dynamic.d;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdWrapperListener;
import com.bytedance.sdk.openadsdk.component.reward.b.e;
import com.bytedance.sdk.openadsdk.core.b.c;
import com.bytedance.sdk.openadsdk.core.model.t;
import com.bytedance.sdk.openadsdk.core.nativeexpress.g;
import com.bytedance.sdk.openadsdk.core.video.c.b;
import com.bytedance.sdk.openadsdk.utils.ac;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* compiled from: RewardFullExpressManager */
public class f {
    /* access modifiers changed from: private */
    public final a a;

    public f(a aVar) {
        this.a = aVar;
    }

    public void a(float[] fArr, b bVar, com.bytedance.sdk.openadsdk.component.reward.b.b bVar2) {
        FrameLayout.LayoutParams layoutParams;
        final b bVar3 = bVar;
        final com.bytedance.sdk.openadsdk.component.reward.b.b bVar4 = bVar2;
        l.b("TTAD.RFExpressM", "initExpressView() called with: size = [" + Arrays.toString(fArr) + "]");
        this.a.J.a(new AdSlot.Builder().setCodeId(String.valueOf(this.a.a.aZ())).setExpressViewAcceptedSize(fArr[0], fArr[1]).build());
        if (!(this.a.R == null || this.a.J == null)) {
            this.a.R.a((d) this.a.J.a());
        }
        this.a.J.a((com.bytedance.sdk.openadsdk.core.nativeexpress.l) new com.bytedance.sdk.openadsdk.core.nativeexpress.l() {
            public void a(boolean z) {
                if (f.this.a.d != z) {
                    f.this.a.R.e();
                }
            }

            public void a() {
                f.this.a.R.d();
            }

            public void b() {
                if (f.this.a.T != null && f.this.a.T.j() != null) {
                    f.this.a.T.j().performClick();
                }
            }

            public void a(int i) {
                if (i != 1) {
                    if (i == 2) {
                        f.this.a.G.y();
                        return;
                    } else if (i == 3) {
                        f.this.a.G.a(bVar3);
                        return;
                    } else if (i == 4) {
                        f.this.a.G.l();
                        return;
                    } else if (i != 5) {
                        return;
                    }
                }
                if (!f.this.a.G.b() && !f.this.a.G.d()) {
                    bVar3.a(0, false);
                }
            }

            public long c() {
                return f.this.a.G.h();
            }

            public int d() {
                if (f.this.a.J.c()) {
                    return 4;
                }
                if (f.this.a.J.d()) {
                    return 5;
                }
                if (f.this.a.G.e()) {
                    return 1;
                }
                if (f.this.a.G.b()) {
                    return 2;
                }
                f.this.a.G.d();
                return 3;
            }

            public void e() {
                f.this.a.N.a(bVar4);
            }

            public void b(int i) {
                f.this.a.h = i;
            }
        });
        this.a.J.a((PAGBannerAdWrapperListener) new PAGBannerAdWrapperListener() {
            public void onAdDismissed() {
            }

            public void onAdShow(View view, int i) {
            }

            public void onAdClicked(View view, int i) {
                if (f.this.a != null && f.this.a.a != null && f.this.a.a.av()) {
                    bVar3.onRewardBarClick(view);
                }
            }

            public void onRenderFail(View view, String str, int i) {
                if (!f.this.a.a.bd()) {
                    f.this.a.Q.a(true);
                    f.this.a.Q.e();
                }
                l.b("TTAD.RFExpressM", "onRenderFail、、、code:" + i);
                f.this.a.J.e().post(new Runnable() {
                    public void run() {
                        bVar4.a(false, false, false, 90);
                    }
                });
                f.this.a.T.m();
            }

            public void onRenderSuccess(View view, float f, float f2) {
                if (!t.k(f.this.a.a)) {
                    if (!f.this.a.a.bd()) {
                        if (f.this.a.J.h()) {
                            bVar4.a(true);
                            f.this.a.G.e(false);
                        } else {
                            f.this.a.G.e(true);
                        }
                        f.this.a.T.b(8);
                        f.this.a.Q.a(true);
                        f.this.a.Q.e();
                        if (f.this.a.J.h()) {
                            f.this.a.J.b().setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
                            bVar4.a(f.this.a.T.f());
                        } else if (f.this.a.a.K() != null && bVar4.a()) {
                            f.this.a.i = true;
                        }
                    }
                    bVar4.z();
                    if (bVar4 instanceof e) {
                        e.a(f.this.a.a, f.this.a.J.h(), f.this.a.g);
                        if (!f.this.a.J.h()) {
                            f.this.a.V.g();
                        }
                    }
                    f.this.a.T.m();
                }
            }
        });
        final b bVar5 = bVar;
        AnonymousClass3 r0 = new g(this.a.V, this.a.a, this.a.g, ac.a(this.a.g)) {
            public void a(View view, float f, float f2, float f3, float f4, SparseArray<c.a> sparseArray, boolean z) {
                super.a(view, f, f2, f3, f4, sparseArray, z);
                bVar5.onRewardBarClick(view);
            }
        };
        HashMap hashMap = new HashMap();
        if (t.k(this.a.a)) {
            hashMap.put("click_scence", 3);
        } else {
            hashMap.put("click_scence", 1);
        }
        r0.a((Map<String, Object>) hashMap);
        final b bVar6 = bVar;
        AnonymousClass4 r02 = new com.bytedance.sdk.openadsdk.core.nativeexpress.f(this.a.V, this.a.a, this.a.g, ac.a(this.a.g)) {
            public void a(View view, float f, float f2, float f3, float f4, SparseArray<c.a> sparseArray, boolean z) {
                HashMap hashMap = new HashMap();
                hashMap.put("duration", Long.valueOf(f.this.a.G.g()));
                a((Map<String, Object>) hashMap);
                super.a(view, f, f2, f3, f4, sparseArray, z);
                if (a(view, z)) {
                    bVar6.onRewardBarClick(view);
                }
            }
        };
        HashMap hashMap2 = new HashMap();
        if (t.k(this.a.a)) {
            hashMap2.put("click_scence", 3);
        } else {
            hashMap2.put("click_scence", 1);
        }
        r02.a((Map<String, Object>) hashMap2);
        this.a.J.a(r0, r02);
        if (this.a.a.bd()) {
            layoutParams = new FrameLayout.LayoutParams(-1, -1);
        } else {
            layoutParams = new FrameLayout.LayoutParams(-2, -2);
        }
        layoutParams.gravity = 17;
        this.a.T.f().addView(this.a.J.a(), layoutParams);
        if (!this.a.J.h()) {
            bVar4.a(false);
        }
        this.a.J.k();
    }
}

package com.bytedance.sdk.openadsdk.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.bykv.vk.openvk.component.video.api.d.c;
import com.bytedance.sdk.component.g.h;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.apiImpl.d.a;
import com.bytedance.sdk.openadsdk.b.g;
import com.bytedance.sdk.openadsdk.common.TTAdDislikeToast;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.core.model.t;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.q;
import com.bytedance.sdk.openadsdk.core.s;
import com.bytedance.sdk.openadsdk.core.widget.a;
import com.bytedance.sdk.openadsdk.multipro.b;
import com.bytedance.sdk.openadsdk.utils.aa;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.r;
import com.facebook.AccessToken;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class TTRewardVideoActivity extends TTBaseVideoActivity {
    private static String n;
    private static String o;
    private static String p;
    private static String q;
    private static String r;
    private static a u;
    protected int k;
    protected int l;
    protected a m;
    private String s;
    private String t;
    private final AtomicBoolean v = new AtomicBoolean(false);
    private int w = -1;
    /* access modifiers changed from: private */
    public boolean x;

    /* access modifiers changed from: private */
    public void a(String str, boolean z, int i, String str2, int i2, String str3) {
        final String str4 = str;
        final boolean z2 = z;
        final int i3 = i;
        final String str5 = str2;
        final int i4 = i2;
        final String str6 = str3;
        aa.c(new h("Reward_executeMultiProcessCallback") {
            public void run() {
                try {
                    TTRewardVideoActivity.this.a(0).executeRewardVideoCallback(TTRewardVideoActivity.this.b.c, str4, z2, i3, str5, i4, str6);
                } catch (Throwable th) {
                    l.a("TTAD.RVA", "rewarded_video", "executeRewardVideoCallback execute throw Exception : ", th);
                }
            }
        }, 5);
    }

    /* access modifiers changed from: private */
    public void a(final boolean z, boolean z2) {
        String str;
        com.bytedance.sdk.openadsdk.core.widget.a aVar;
        if (!z2 && this.x && t.c(this.b.a)) {
            this.b.Q.g();
        } else if (!o.d().h(String.valueOf(this.b.o))) {
            if (!z2 && this.b.u.get() && t.c(this.b.a)) {
                this.b.Q.g();
            } else if (z) {
                finish();
            } else {
                t();
            }
        } else if (this.v.get()) {
            if (t.c(this.b.a)) {
                this.b.Q.g();
            } else if (z) {
                finish();
            } else {
                t();
            }
        } else if (!t.c(this.b.a) || this.b.Q.i().getVisibility() != 0) {
            this.b.E.set(true);
            this.b.G.o();
            if (z) {
                this.b.I.n();
            }
            final com.bytedance.sdk.openadsdk.core.widget.a aVar2 = new com.bytedance.sdk.openadsdk.core.widget.a(this);
            this.c.m = aVar2;
            com.bytedance.sdk.openadsdk.core.widget.a aVar3 = this.c.m;
            if (z) {
                aVar = aVar3.a(o);
                str = r;
            } else {
                aVar = aVar3.a(n);
                str = q;
            }
            aVar.b(str).c(p);
            this.c.m.a((a.C0070a) new a.C0070a() {
                public void a() {
                    TTRewardVideoActivity.this.b.G.n();
                    if (z) {
                        TTRewardVideoActivity.this.b.I.a(1000);
                    }
                    aVar2.dismiss();
                    TTRewardVideoActivity.this.b.E.set(false);
                }

                public void b() {
                    aVar2.dismiss();
                    boolean unused = TTRewardVideoActivity.this.x = true;
                    TTRewardVideoActivity.this.b.E.set(false);
                    TTRewardVideoActivity.this.b.I.f(Integer.MAX_VALUE);
                    if (!z) {
                        TTRewardVideoActivity.this.t();
                    } else if (t.c(TTRewardVideoActivity.this.b.a)) {
                        TTRewardVideoActivity.this.b.Q.g();
                    } else {
                        TTRewardVideoActivity.this.b.L.f();
                        TTRewardVideoActivity.this.finish();
                    }
                }
            }).show();
        } else {
            this.b.Q.g();
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0075, code lost:
        if (r3.b.A.get() == false) goto L_0x0077;
     */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0084  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void t() {
        /*
            r3 = this;
            com.bytedance.sdk.openadsdk.b.d.b.o$a r0 = new com.bytedance.sdk.openadsdk.b.d.b.o$a
            r0.<init>()
            com.bytedance.sdk.openadsdk.component.reward.a.a r1 = r3.b
            com.bytedance.sdk.openadsdk.component.reward.a.l r1 = r1.G
            long r1 = r1.g()
            r0.a((long) r1)
            com.bytedance.sdk.openadsdk.component.reward.a.a r1 = r3.b
            com.bytedance.sdk.openadsdk.component.reward.a.l r1 = r1.G
            long r1 = r1.s()
            r0.c((long) r1)
            com.bytedance.sdk.openadsdk.component.reward.a.a r1 = r3.b
            com.bytedance.sdk.openadsdk.component.reward.a.l r1 = r1.G
            long r1 = r1.k()
            r0.b((long) r1)
            r1 = 3
            r0.c((int) r1)
            com.bytedance.sdk.openadsdk.component.reward.a.a r1 = r3.b
            com.bytedance.sdk.openadsdk.component.reward.a.l r1 = r1.G
            int r1 = r1.r()
            r0.d(r1)
            com.bytedance.sdk.openadsdk.component.reward.a.a r1 = r3.b
            com.bytedance.sdk.openadsdk.component.reward.a.l r1 = r1.G
            com.bykv.vk.openvk.component.video.api.b.a r1 = r1.c()
            com.bytedance.sdk.openadsdk.component.reward.a.a r2 = r3.b
            com.bytedance.sdk.openadsdk.component.reward.a.l r2 = r2.G
            com.bytedance.sdk.openadsdk.b.g r2 = r2.a()
            com.bytedance.sdk.openadsdk.b.d.a.a.a((com.bykv.vk.openvk.component.video.api.b.a) r1, (com.bytedance.sdk.openadsdk.b.d.b.o.a) r0, (com.bytedance.sdk.openadsdk.b.g) r2)
            com.bytedance.sdk.openadsdk.component.reward.a.a r0 = r3.b
            int r0 = r0.o
            com.bytedance.sdk.openadsdk.core.r.c((int) r0)
            com.bytedance.sdk.openadsdk.component.reward.a.a r0 = r3.b
            com.bytedance.sdk.openadsdk.component.reward.a.l r0 = r0.G
            java.lang.String r1 = "skip"
            r0.a((java.lang.String) r1)
            com.bytedance.sdk.openadsdk.component.reward.a.a r0 = r3.b
            boolean r0 = r0.b
            if (r0 == 0) goto L_0x0077
            r0 = 1
            r1 = 4
            r3.a((boolean) r0, (int) r1)
            com.bytedance.sdk.openadsdk.component.reward.a.a r0 = r3.b
            com.bytedance.sdk.openadsdk.core.model.q r0 = r0.a
            boolean r0 = com.bytedance.sdk.openadsdk.core.model.o.a((com.bytedance.sdk.openadsdk.core.model.q) r0)
            if (r0 == 0) goto L_0x007a
            com.bytedance.sdk.openadsdk.component.reward.a.a r0 = r3.b
            java.util.concurrent.atomic.AtomicBoolean r0 = r0.A
            boolean r0 = r0.get()
            if (r0 != 0) goto L_0x007a
        L_0x0077:
            r3.finish()
        L_0x007a:
            com.bytedance.sdk.openadsdk.component.reward.a.a r0 = r3.b
            com.bytedance.sdk.openadsdk.core.model.q r0 = r0.a
            com.bytedance.sdk.openadsdk.core.g.a r0 = r0.au()
            if (r0 == 0) goto L_0x0096
            com.bytedance.sdk.openadsdk.core.g.d r0 = r0.a()
            com.bytedance.sdk.openadsdk.component.reward.a.a r1 = r3.b
            com.bytedance.sdk.openadsdk.component.reward.a.l r1 = r1.G
            long r1 = r1.g()
            r0.f((long) r1)
            r0.e((long) r1)
        L_0x0096:
            com.bytedance.sdk.openadsdk.component.reward.a.a r0 = r3.b
            com.bytedance.sdk.openadsdk.core.model.q r0 = r0.a
            r1 = 5
            com.bytedance.sdk.openadsdk.n.a.e.a((com.bytedance.sdk.openadsdk.core.model.q) r0, (int) r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.t():void");
    }

    private JSONObject u() {
        JSONObject jSONObject = new JSONObject();
        int t2 = (int) this.b.G.t();
        try {
            jSONObject.put("oversea_version_type", 1);
            jSONObject.put(CampaignEx.JSON_KEY_REWARD_NAME, this.b.a.s());
            jSONObject.put(CampaignEx.JSON_KEY_REWARD_AMOUNT, this.b.a.t());
            jSONObject.put("network", com.bytedance.sdk.component.utils.o.c(getApplicationContext()));
            jSONObject.put("sdk_version", BuildConfig.VERSION_NAME);
            int H = this.b.a.H();
            String str = "unKnow";
            if (H == 2) {
                str = ac.b();
            } else if (H == 1) {
                str = ac.c();
            }
            jSONObject.put("user_agent", str);
            jSONObject.put("extra", this.b.a.aR());
            jSONObject.put("media_extra", this.s);
            jSONObject.put("video_duration", this.b.a.K().f());
            jSONObject.put("play_start_ts", this.k);
            jSONObject.put("play_end_ts", this.l);
            jSONObject.put("duration", t2);
            jSONObject.put(AccessToken.USER_ID_KEY, this.t);
            jSONObject.put("trans_id", r.a().replace("-", ""));
            return jSONObject;
        } catch (Throwable th) {
            l.c("TTAD.RVA", "", th);
            return null;
        }
    }

    private void v() {
        if (!this.g) {
            this.g = true;
            if (b.c()) {
                a("onAdClose");
                return;
            }
            com.bytedance.sdk.openadsdk.apiImpl.d.a aVar = this.m;
            if (aVar != null) {
                aVar.c();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void a() {
        this.b.R.a((String) null, TTAdDislikeToast.getSkipText());
        this.b.R.e(true);
    }

    /* access modifiers changed from: protected */
    public void a(long j, long j2) {
        long j3 = j + (((long) this.b.h) * 1000);
        if (this.w == -1) {
            this.w = o.d().z(String.valueOf(this.b.o)).f;
        }
        if (j2 > 0) {
            if (j2 >= 30000 && j3 >= 27000) {
                l.b("TTAD.RVA", "try verify reward 1");
                s();
            } else if (((float) (j3 * 100)) / ((float) j2) >= ((float) this.w)) {
                l.b("TTAD.RVA", "try verify reward 2");
                s();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void a(Intent intent) {
        super.a(intent);
        this.s = intent.getStringExtra("media_extra");
        this.t = intent.getStringExtra(AccessToken.USER_ID_KEY);
    }

    public void a(Bundle bundle) {
        if (!b.c()) {
            this.m = s.a().c();
        }
        if (this.m == null && bundle != null) {
            this.m = u;
            u = null;
        }
    }

    /* access modifiers changed from: protected */
    public void a(String str) {
        a(str, false, 0, "", 0, "");
    }

    public boolean a(long j, boolean z) {
        g gVar = new g();
        gVar.a(System.currentTimeMillis(), 1.0f);
        this.b.G.a(this.b.T.f(), gVar);
        AnonymousClass5 r0 = new c.a() {
            boolean a;

            public void a(long j, int i) {
                if (!this.a) {
                    this.a = true;
                    TTRewardVideoActivity.this.d.removeMessages(300);
                    TTRewardVideoActivity.this.m();
                    TTRewardVideoActivity.this.s();
                    TTRewardVideoActivity.this.b.D.set(true);
                    if (TTRewardVideoActivity.this.b.a.bg()) {
                        TTRewardVideoActivity.this.b.a.E(1);
                        TTRewardVideoActivity.this.b.T.r();
                    }
                    if (TTRewardVideoActivity.this.b.a.o() == 21 && !TTRewardVideoActivity.this.b.a.c()) {
                        TTRewardVideoActivity.this.b.a.b(true);
                        TTRewardVideoActivity.this.b.T.r();
                    }
                    TTRewardVideoActivity.this.l = (int) (System.currentTimeMillis() / 1000);
                    if (com.bytedance.sdk.openadsdk.core.model.o.c(TTRewardVideoActivity.this.b.a) || com.bytedance.sdk.openadsdk.core.model.o.b(TTRewardVideoActivity.this.b.a)) {
                        TTRewardVideoActivity.this.a(false, 5);
                    } else if (com.bytedance.sdk.openadsdk.core.model.o.a(TTRewardVideoActivity.this.b.a) && !TTRewardVideoActivity.this.b.A.get()) {
                        TTRewardVideoActivity.this.b.a(true);
                        TTRewardVideoActivity.this.b.R.e(true);
                    } else if (TTRewardVideoActivity.this.b.b) {
                        TTRewardVideoActivity.this.a(false, 5);
                    } else {
                        TTRewardVideoActivity.this.finish();
                    }
                }
            }

            public void b(long j, int i) {
                TTRewardVideoActivity.this.d.removeMessages(300);
                if (TTRewardVideoActivity.this.b.G.b()) {
                    TTRewardVideoActivity.this.l();
                    return;
                }
                TTRewardVideoActivity.this.b.G.m();
                TTRewardVideoActivity.this.s();
                if (TTRewardVideoActivity.this.b.b) {
                    TTRewardVideoActivity.this.a(false, true, 3);
                } else {
                    TTRewardVideoActivity.this.finish();
                }
                TTRewardVideoActivity.this.b.G.a(true ^ TTRewardVideoActivity.this.b.G.z() ? 1 : 0, 2);
            }

            public void a() {
                TTRewardVideoActivity.this.d.removeMessages(300);
                TTRewardVideoActivity.this.m();
                TTRewardVideoActivity.this.s();
                if (TTRewardVideoActivity.this.b.b) {
                    TTRewardVideoActivity.this.a(false, true, 6);
                } else {
                    TTRewardVideoActivity.this.finish();
                }
                TTRewardVideoActivity.this.b.G.a(TTRewardVideoActivity.this.b.G.z() ^ true ? 1 : 0, true ^ TTRewardVideoActivity.this.b.G.z() ? 1 : 0);
                TTRewardVideoActivity.this.b.G.m();
            }

            public void a(long j, long j2) {
                if (!TTRewardVideoActivity.this.b.e && TTRewardVideoActivity.this.b.G.b()) {
                    TTRewardVideoActivity.this.b.G.o();
                }
                if (!TTRewardVideoActivity.this.b.u.get()) {
                    TTRewardVideoActivity.this.d.removeMessages(300);
                    if (j != TTRewardVideoActivity.this.b.G.h()) {
                        TTRewardVideoActivity.this.m();
                    }
                    TTRewardVideoActivity.this.b.G.a(j);
                    TTRewardVideoActivity tTRewardVideoActivity = TTRewardVideoActivity.this;
                    double A = tTRewardVideoActivity.b.G.A();
                    long j3 = j / 1000;
                    double d = (double) j3;
                    Double.isNaN(d);
                    tTRewardVideoActivity.f = (int) (A - d);
                    if (TTRewardVideoActivity.this.f >= 0) {
                        TTRewardVideoActivity.this.b.R.a(String.valueOf(TTRewardVideoActivity.this.f), (CharSequence) null);
                    }
                    TTRewardVideoActivity tTRewardVideoActivity2 = TTRewardVideoActivity.this;
                    double A2 = tTRewardVideoActivity2.b.G.A();
                    Double.isNaN(d);
                    tTRewardVideoActivity2.f = (int) (A2 - d);
                    int i = (int) j3;
                    int j4 = o.d().j(String.valueOf(TTRewardVideoActivity.this.b.o));
                    boolean z = j4 >= 0;
                    if ((TTRewardVideoActivity.this.b.E.get() || TTRewardVideoActivity.this.b.v.get()) && TTRewardVideoActivity.this.b.G.b()) {
                        TTRewardVideoActivity.this.b.G.o();
                    }
                    TTRewardVideoActivity.this.b.T.e(i);
                    TTRewardVideoActivity.this.a(j, j2);
                    if (TTRewardVideoActivity.this.f > 0) {
                        TTRewardVideoActivity.this.b.R.d(true);
                        if (!z || i < j4) {
                            TTRewardVideoActivity.this.b.R.a(String.valueOf(TTRewardVideoActivity.this.f), (CharSequence) null);
                            return;
                        }
                        TTRewardVideoActivity.this.b.a(true);
                        TTRewardVideoActivity.this.b.R.a(String.valueOf(TTRewardVideoActivity.this.f), TTAdDislikeToast.getSkipText());
                        TTRewardVideoActivity.this.b.R.e(true);
                    }
                }
            }
        };
        this.b.G.a((c.a) r0);
        if (this.b.T.o != null) {
            this.b.T.o.a((c.a) r0);
        }
        boolean a = this.b.G.a(j, z, (Map<String, Object>) null, this.c);
        if (a && !z) {
            this.k = (int) (System.currentTimeMillis() / 1000);
        }
        return a;
    }

    public void c(int i) {
        if (i == 10000) {
            s();
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        super.finalize();
        u = null;
    }

    public void finish() {
        v();
        super.finish();
    }

    /* access modifiers changed from: protected */
    public void h() {
        if (b.c()) {
            a("onAdShow");
        } else {
            com.bytedance.sdk.openadsdk.apiImpl.d.a aVar = this.m;
            if (aVar != null) {
                aVar.a();
            }
        }
        if (p()) {
            this.b.J.j();
        }
    }

    public void i() {
        s();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x007f, code lost:
        if (r8.b.Q.j().e() != false) goto L_0x003b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0037, code lost:
        if (((1.0d - (r6 / r4)) * 100.0d) >= ((double) r0)) goto L_0x003b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void j() {
        /*
            r8 = this;
            com.bytedance.sdk.openadsdk.core.settings.e r0 = com.bytedance.sdk.openadsdk.core.o.d()
            com.bytedance.sdk.openadsdk.component.reward.a.a r1 = r8.b
            int r1 = r1.o
            java.lang.String r1 = java.lang.String.valueOf(r1)
            com.bytedance.sdk.openadsdk.core.settings.a r0 = r0.z(r1)
            int r0 = r0.f
            com.bytedance.sdk.openadsdk.component.reward.a.a r1 = r8.b
            com.bytedance.sdk.openadsdk.core.model.q r1 = r1.a
            boolean r1 = com.bytedance.sdk.openadsdk.core.model.t.l(r1)
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x003d
            com.bytedance.sdk.openadsdk.component.reward.a.a r1 = r8.b
            com.bytedance.sdk.openadsdk.component.reward.a.l r1 = r1.G
            double r4 = r1.A()
            int r1 = r8.f
            double r6 = (double) r1
            java.lang.Double.isNaN(r6)
            double r6 = r6 / r4
            r4 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r4 = r4 - r6
            r6 = 4636737291354636288(0x4059000000000000, double:100.0)
            double r4 = r4 * r6
            double r0 = (double) r0
            int r6 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r6 < 0) goto L_0x003a
            goto L_0x003b
        L_0x003a:
            r2 = 0
        L_0x003b:
            r3 = r2
            goto L_0x0085
        L_0x003d:
            com.bytedance.sdk.openadsdk.component.reward.a.a r1 = r8.b
            com.bytedance.sdk.openadsdk.core.model.q r1 = r1.a
            int r1 = r1.aq()
            float r1 = (float) r1
            com.bytedance.sdk.openadsdk.component.reward.a.a r4 = r8.b
            com.bytedance.sdk.openadsdk.component.reward.a.g r4 = r4.I
            int r4 = r4.k()
            float r4 = (float) r4
            float r4 = r4 / r1
            r1 = 1065353216(0x3f800000, float:1.0)
            float r1 = r1 - r4
            r4 = 1120403456(0x42c80000, float:100.0)
            float r1 = r1 * r4
            float r0 = (float) r0
            int r0 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r0 < 0) goto L_0x005e
            r0 = 1
            goto L_0x005f
        L_0x005e:
            r0 = 0
        L_0x005f:
            com.bytedance.sdk.openadsdk.core.settings.e r1 = com.bytedance.sdk.openadsdk.core.o.d()
            com.bytedance.sdk.openadsdk.component.reward.a.a r4 = r8.b
            int r4 = r4.o
            java.lang.String r4 = java.lang.String.valueOf(r4)
            int r1 = r1.a((java.lang.String) r4)
            if (r1 != 0) goto L_0x0082
            if (r0 == 0) goto L_0x003a
            com.bytedance.sdk.openadsdk.component.reward.a.a r0 = r8.b
            com.bytedance.sdk.openadsdk.component.reward.a.m r0 = r0.Q
            com.bytedance.sdk.openadsdk.core.x r0 = r0.j()
            boolean r0 = r0.e()
            if (r0 == 0) goto L_0x003a
            goto L_0x003b
        L_0x0082:
            if (r1 != r2) goto L_0x0085
            r3 = r0
        L_0x0085:
            if (r3 == 0) goto L_0x008a
            r8.s()
        L_0x008a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.j():void");
    }

    /* access modifiers changed from: protected */
    public void n() {
        View j = this.b.T.j();
        if (j != null) {
            AnonymousClass2 r1 = new View.OnClickListener() {
                /* JADX WARNING: Removed duplicated region for block: B:26:0x00b8 A[RETURN] */
                /* JADX WARNING: Removed duplicated region for block: B:27:0x00b9  */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void onClick(android.view.View r4) {
                    /*
                        r3 = this;
                        com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity r4 = com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.this
                        com.bytedance.sdk.openadsdk.component.reward.a.a r4 = r4.b
                        com.bytedance.sdk.openadsdk.component.reward.a.m r4 = r4.Q
                        boolean r4 = r4.w()
                        if (r4 == 0) goto L_0x003a
                        com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity r4 = com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.this
                        com.bytedance.sdk.openadsdk.component.reward.a.a r4 = r4.b
                        java.util.concurrent.atomic.AtomicBoolean r4 = r4.u
                        boolean r4 = r4.get()
                        if (r4 == 0) goto L_0x003a
                        com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity r4 = com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.this
                        com.bytedance.sdk.openadsdk.component.reward.a.a r4 = r4.b
                        com.bytedance.sdk.openadsdk.component.reward.a.m r4 = r4.Q
                        r4.G()
                        com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity r4 = com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.this
                        com.bytedance.sdk.openadsdk.component.reward.a.a r4 = r4.b
                        com.bytedance.sdk.openadsdk.component.reward.view.e r4 = r4.T
                        r0 = 8
                        r4.f(r0)
                        com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity r4 = com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.this
                        com.bytedance.sdk.openadsdk.component.reward.a.a r4 = r4.b
                        com.bytedance.sdk.component.utils.x r4 = r4.X
                        r0 = 600(0x258, float:8.41E-43)
                        r1 = 5000(0x1388, double:2.4703E-320)
                        r4.sendEmptyMessageDelayed(r0, r1)
                        return
                    L_0x003a:
                        com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity r4 = com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.this
                        com.bytedance.sdk.openadsdk.component.reward.a.a r4 = r4.b
                        com.bytedance.sdk.openadsdk.core.model.q r4 = r4.a
                        boolean r4 = r4.bh()
                        r0 = 1
                        if (r4 == 0) goto L_0x00b5
                        com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity r4 = com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.this
                        com.bytedance.sdk.openadsdk.component.reward.a.a r4 = r4.b
                        com.bytedance.sdk.openadsdk.core.model.q r4 = r4.a
                        boolean r4 = r4.at()
                        if (r4 == 0) goto L_0x0070
                        com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity r4 = com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.this
                        com.bytedance.sdk.openadsdk.component.reward.a.a r4 = r4.b
                        com.bytedance.sdk.openadsdk.component.reward.a.e r4 = r4.S
                        if (r4 == 0) goto L_0x00b5
                        com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity r4 = com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.this
                        com.bytedance.sdk.openadsdk.component.reward.a.a r4 = r4.b
                        com.bytedance.sdk.openadsdk.core.model.q r4 = r4.a
                        r1 = 2
                        r4.E(r1)
                        com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity r4 = com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.this
                        com.bytedance.sdk.openadsdk.component.reward.a.a r4 = r4.b
                        com.bytedance.sdk.openadsdk.component.reward.a.e r4 = r4.S
                        boolean r4 = r4.e()
                        goto L_0x00b6
                    L_0x0070:
                        com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity r4 = com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.this
                        com.bytedance.sdk.openadsdk.component.reward.a.a r4 = r4.b
                        com.bytedance.sdk.openadsdk.core.model.q r4 = r4.a
                        int r4 = r4.be()
                        if (r4 != 0) goto L_0x00b5
                        com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity r4 = com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.this
                        com.bytedance.sdk.openadsdk.component.reward.a.a r4 = r4.b
                        com.bytedance.sdk.openadsdk.component.reward.a.m r4 = r4.Q
                        boolean r4 = r4.o()
                        if (r4 != 0) goto L_0x00b5
                        com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity r4 = com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.this
                        com.bytedance.sdk.openadsdk.component.reward.a.a r4 = r4.b
                        com.bytedance.sdk.openadsdk.core.model.q r4 = r4.a
                        r1 = 11
                        r4.E(r1)
                        com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity r4 = com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.this
                        com.bytedance.sdk.openadsdk.component.reward.a.a r4 = r4.b
                        com.bytedance.sdk.openadsdk.component.reward.a.m r4 = r4.Q
                        boolean r4 = r4.d()
                        if (r4 == 0) goto L_0x00aa
                        com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity r4 = com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.this
                        com.bytedance.sdk.openadsdk.component.reward.a.a r4 = r4.b
                        com.bytedance.sdk.openadsdk.core.model.q r4 = r4.a
                        r1 = 12
                        r4.E(r1)
                    L_0x00aa:
                        com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity r4 = com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.this     // Catch:{ Exception -> 0x00b5 }
                        com.bytedance.sdk.openadsdk.component.reward.a.a r4 = r4.b     // Catch:{ Exception -> 0x00b5 }
                        com.bytedance.sdk.openadsdk.component.reward.view.e r4 = r4.T     // Catch:{ Exception -> 0x00b5 }
                        r4.r()     // Catch:{ Exception -> 0x00b5 }
                        r4 = 1
                        goto L_0x00b6
                    L_0x00b5:
                        r4 = 0
                    L_0x00b6:
                        if (r4 == 0) goto L_0x00b9
                        return
                    L_0x00b9:
                        com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity r4 = com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.this
                        com.bytedance.sdk.openadsdk.component.reward.a.a r4 = r4.b
                        com.bytedance.sdk.openadsdk.component.reward.a.m r4 = r4.Q
                        r4.y()
                        com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity r4 = com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.this
                        com.bytedance.sdk.openadsdk.component.reward.a.a r4 = r4.b
                        com.bytedance.sdk.openadsdk.component.reward.a.h r4 = r4.L
                        r4.f()
                        com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity r4 = com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.this
                        com.bytedance.sdk.openadsdk.component.reward.a.a r4 = r4.b
                        com.bytedance.sdk.openadsdk.core.model.q r4 = r4.a
                        boolean r4 = com.bytedance.sdk.openadsdk.core.model.t.k(r4)
                        if (r4 == 0) goto L_0x00e9
                        com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity r4 = com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.this
                        com.bytedance.sdk.openadsdk.component.reward.a.a r4 = r4.b
                        com.bytedance.sdk.openadsdk.core.model.q r4 = r4.a
                        boolean r4 = com.bytedance.sdk.openadsdk.core.model.t.c(r4)
                        if (r4 != 0) goto L_0x00e9
                        com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity r4 = com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.this
                        r4.a((boolean) r0, (boolean) r0)
                        goto L_0x00ee
                    L_0x00e9:
                        com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity r4 = com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.this
                        r4.finish()
                    L_0x00ee:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.AnonymousClass2.onClick(android.view.View):void");
                }
            };
            j.setOnClickListener(r1);
            j.setTag(j.getId(), r1);
        }
        this.b.R.a((com.bytedance.sdk.openadsdk.component.reward.top.b) new com.bytedance.sdk.openadsdk.component.reward.top.b() {
            public void a(View view) {
                if (!TTRewardVideoActivity.this.b.a.bi()) {
                    if (!TTRewardVideoActivity.this.b.b && TTRewardVideoActivity.this.b.a.bh() && !TTRewardVideoActivity.this.b.a.at()) {
                        TTRewardVideoActivity.this.b.a.E(13);
                        try {
                            TTRewardVideoActivity.this.b.T.r();
                            return;
                        } catch (Exception unused) {
                        }
                    }
                    TTRewardVideoActivity tTRewardVideoActivity = TTRewardVideoActivity.this;
                    tTRewardVideoActivity.a(t.k(tTRewardVideoActivity.b.a), false);
                } else if (TTRewardVideoActivity.this.b.T.k() != null) {
                    TTRewardVideoActivity.this.b.a.E(2);
                    TTRewardVideoActivity.this.b.T.r();
                }
            }

            public void b(View view) {
                if (!(TTRewardVideoActivity.this.c == null || TTRewardVideoActivity.this.c.d() == null)) {
                    TTRewardVideoActivity.this.c.d().a(TTRewardVideoActivity.this.b.d);
                }
                TTRewardVideoActivity.this.b.d = !TTRewardVideoActivity.this.b.d;
                l.a("TTAD.RVA", "rewarded_video", "will set is Mute " + TTRewardVideoActivity.this.b.d + " mLastVolume=" + TTRewardVideoActivity.this.b.O.a());
                TTRewardVideoActivity.this.b.G.b(TTRewardVideoActivity.this.b.d);
                if (!t.l(TTRewardVideoActivity.this.b.a) || TTRewardVideoActivity.this.b.u.get()) {
                    if (t.b(TTRewardVideoActivity.this.b.a)) {
                        TTRewardVideoActivity.this.b.O.a(TTRewardVideoActivity.this.b.d, true);
                    }
                    TTRewardVideoActivity.this.b.Q.d(TTRewardVideoActivity.this.b.d);
                    if (TTRewardVideoActivity.this.b.a != null && TTRewardVideoActivity.this.b.a.au() != null && TTRewardVideoActivity.this.b.a.au().a() != null && TTRewardVideoActivity.this.b.G != null) {
                        if (TTRewardVideoActivity.this.b.d) {
                            TTRewardVideoActivity.this.b.a.au().a().h(TTRewardVideoActivity.this.b.G.g());
                        } else {
                            TTRewardVideoActivity.this.b.a.au().a().i(TTRewardVideoActivity.this.b.G.g());
                        }
                    }
                }
            }

            public void c(View view) {
                TTRewardVideoActivity.this.b.N.a(TTRewardVideoActivity.this.c);
            }
        });
    }

    public boolean o() {
        return true;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            if (n == null) {
                n = com.bytedance.sdk.component.utils.s.a(this, "tt_reward_msg");
                o = com.bytedance.sdk.component.utils.s.a(this, "tt_msgPlayable");
                p = com.bytedance.sdk.component.utils.s.a(this, "tt_negtiveBtnBtnText");
                q = com.bytedance.sdk.component.utils.s.a(this, "tt_postiveBtnText");
                r = com.bytedance.sdk.component.utils.s.a(this, "tt_postiveBtnTextPlayable");
            }
        } catch (Throwable th) {
            l.e("TTAD.RVA", th.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        v();
        if (b.c()) {
            a("recycleRes");
        }
        this.m = null;
    }

    public void onRewardBarClick(View view) {
        if (b.c()) {
            a("onAdVideoBarClick");
            return;
        }
        com.bytedance.sdk.openadsdk.apiImpl.d.a aVar = this.m;
        if (aVar != null) {
            aVar.b();
        }
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        u = this.m;
        super.onSaveInstanceState(bundle);
    }

    public void r() {
        if (b.c()) {
            a("onAdVideoBarClick");
        } else {
            com.bytedance.sdk.openadsdk.apiImpl.d.a aVar = this.m;
            if (aVar != null) {
                aVar.b();
            }
        }
        this.b.a.bl();
        this.b.a.a(true);
        if (q.c(this.b.a)) {
            com.bytedance.sdk.openadsdk.b.c.b(this.b.a, this.b.g, this.b.a.bm());
        }
    }

    /* access modifiers changed from: protected */
    public void s() {
        if (!this.v.get()) {
            this.v.set(true);
            boolean o2 = o.d().o(String.valueOf(this.b.o));
            l.b("TTAD.RVA", "verifyRewardVideo: dir=" + o2);
            if (!o2) {
                o.c().a(u(), (p.b) new p.b() {
                    public void a(final int i, final String str) {
                        l.b("TTAD.RVA", "onError: " + i + ", " + str);
                        if (b.c()) {
                            TTRewardVideoActivity.this.a("onRewardVerify", false, 0, "", i, str);
                        } else {
                            TTRewardVideoActivity.this.d.post(new Runnable() {
                                public void run() {
                                    if (TTRewardVideoActivity.this.m != null) {
                                        TTRewardVideoActivity.this.m.a(false, 0, "", i, str);
                                    }
                                }
                            });
                        }
                    }

                    public void a(final q.b bVar) {
                        l.b("TTAD.RVA", "onVerify: " + bVar.b);
                        final int a2 = bVar.c.a();
                        final String b = bVar.c.b();
                        if (b.c()) {
                            TTRewardVideoActivity.this.a("onRewardVerify", bVar.b, a2, b, 0, "");
                        } else {
                            TTRewardVideoActivity.this.d.post(new Runnable() {
                                public void run() {
                                    if (TTRewardVideoActivity.this.m != null) {
                                        TTRewardVideoActivity.this.m.a(bVar.b, a2, b, 0, "");
                                    }
                                }
                            });
                        }
                    }
                });
            } else if (b.c()) {
                a("onRewardVerify", true, this.b.a.t(), this.b.a.s(), 0, "");
            } else {
                this.d.post(new Runnable() {
                    public void run() {
                        if (TTRewardVideoActivity.this.m != null) {
                            TTRewardVideoActivity.this.m.a(true, TTRewardVideoActivity.this.b.a.t(), TTRewardVideoActivity.this.b.a.s(), 0, "");
                        }
                    }
                });
            }
        }
    }
}

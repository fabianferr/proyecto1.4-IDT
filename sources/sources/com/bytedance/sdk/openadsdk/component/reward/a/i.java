package com.bytedance.sdk.openadsdk.component.reward.a;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.view.View;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.x;
import com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.utils.ad;

/* compiled from: RewardFullScreenManager */
public class i {
    protected int a = 0;
    /* access modifiers changed from: private */
    public final a b;
    private boolean c = true;
    private a d;

    public i(a aVar) {
        this.b = aVar;
        c();
        try {
            this.a = ad.c(aVar.V, ad.a());
            aVar.V.requestWindowFeature(1);
            aVar.V.getWindow().addFlags(16777344);
            if (aVar.j == 2 || !ad.c((Activity) aVar.V)) {
                aVar.V.getWindow().addFlags(1024);
            }
        } catch (Throwable th) {
            Log.e("TTAD.RFSM", "init: ", th);
        }
    }

    public void a(x xVar) {
        if (xVar != null && Build.VERSION.SDK_INT >= 21) {
            xVar.postDelayed(new Runnable() {
                public void run() {
                    try {
                        i.this.b.V.getWindow().getDecorView().findViewById(16908335).setVisibility(8);
                    } catch (Exception unused) {
                    }
                }
            }, 300);
        }
    }

    private void c() {
        a aVar = this.b;
        aVar.k = aVar.a.al();
        if (26 != Build.VERSION.SDK_INT) {
            a aVar2 = this.b;
            aVar2.j = aVar2.a.ak();
        } else if (this.b.V.getResources().getConfiguration().orientation == 1) {
            this.b.j = 1;
        } else {
            this.b.j = 2;
        }
    }

    public void a(boolean z) {
        float f;
        float f2;
        int i;
        int i2;
        int i3;
        if (Build.VERSION.SDK_INT != 26) {
            if (Build.VERSION.SDK_INT == 27) {
                try {
                    d();
                } catch (Throwable unused) {
                }
            } else {
                d();
            }
        }
        float e = e();
        float f3 = f();
        if (this.b.j == 2) {
            f = Math.max(e, f3);
            f2 = Math.min(e, f3);
        } else {
            f = Math.min(e, f3);
            f2 = Math.max(e, f3);
        }
        TTBaseVideoActivity tTBaseVideoActivity = this.b.V;
        int c2 = ad.c(tTBaseVideoActivity, ad.a());
        if (this.b.j != 2) {
            if (ad.c((Activity) tTBaseVideoActivity)) {
                f2 -= (float) c2;
            }
        } else if (ad.c((Activity) tTBaseVideoActivity)) {
            f -= (float) c2;
        }
        if (z) {
            this.b.l = (int) f;
            this.b.m = (int) f2;
            return;
        }
        int i4 = 20;
        if (this.b.j != 2) {
            if (!(this.b.k == 0.0f || this.b.k == 100.0f)) {
                float f4 = (float) 20;
                i3 = (int) Math.max((f2 - (((f - f4) - f4) / this.b.k)) / 2.0f, 0.0f);
                i2 = i3;
                i = 20;
                float f5 = (float) i4;
                float f6 = (float) i;
                this.b.l = (int) ((f - f5) - f6);
                float f7 = (float) i3;
                float f8 = (float) i2;
                this.b.m = (int) ((f2 - f7) - f8);
                int b2 = ad.b((Context) tTBaseVideoActivity, f7);
                int b3 = ad.b((Context) tTBaseVideoActivity, f8);
                tTBaseVideoActivity.getWindow().getDecorView().setPadding(ad.b((Context) tTBaseVideoActivity, f5), b2, ad.b((Context) tTBaseVideoActivity, f6), b3);
            }
        } else if (!(this.b.k == 0.0f || this.b.k == 100.0f)) {
            float f9 = (float) 20;
            i = (int) Math.max((f - (((f2 - f9) - f9) * this.b.k)) / 2.0f, 0.0f);
            i4 = i;
            i3 = 20;
            i2 = 20;
            float f52 = (float) i4;
            float f62 = (float) i;
            this.b.l = (int) ((f - f52) - f62);
            float f72 = (float) i3;
            float f82 = (float) i2;
            this.b.m = (int) ((f2 - f72) - f82);
            int b22 = ad.b((Context) tTBaseVideoActivity, f72);
            int b32 = ad.b((Context) tTBaseVideoActivity, f82);
            tTBaseVideoActivity.getWindow().getDecorView().setPadding(ad.b((Context) tTBaseVideoActivity, f52), b22, ad.b((Context) tTBaseVideoActivity, f62), b32);
        }
        i4 = 0;
        i = 0;
        i3 = 0;
        i2 = 0;
        float f522 = (float) i4;
        float f622 = (float) i;
        this.b.l = (int) ((f - f522) - f622);
        float f722 = (float) i3;
        float f822 = (float) i2;
        this.b.m = (int) ((f2 - f722) - f822);
        int b222 = ad.b((Context) tTBaseVideoActivity, f722);
        int b322 = ad.b((Context) tTBaseVideoActivity, f822);
        tTBaseVideoActivity.getWindow().getDecorView().setPadding(ad.b((Context) tTBaseVideoActivity, f522), b222, ad.b((Context) tTBaseVideoActivity, f622), b322);
    }

    public void b(x xVar) {
        try {
            final boolean z = true;
            final boolean z2 = this.c && o.d().K() == 1;
            if (!this.c || !ad.c((Activity) this.b.V)) {
                z = false;
            }
            if (z || z2) {
                if (this.d == null) {
                    this.d = new a() {
                        boolean a;

                        /* access modifiers changed from: package-private */
                        /* JADX WARNING: Removed duplicated region for block: B:27:0x00e9 A[Catch:{ all -> 0x010c }] */
                        /* JADX WARNING: Removed duplicated region for block: B:30:0x00fc A[Catch:{ all -> 0x010c }] */
                        /* JADX WARNING: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public void a(int r7, int r8) {
                            /*
                                r6 = this;
                                com.bytedance.sdk.openadsdk.component.reward.a.i r7 = com.bytedance.sdk.openadsdk.component.reward.a.i.this     // Catch:{ all -> 0x010c }
                                com.bytedance.sdk.openadsdk.component.reward.a.a r7 = r7.b     // Catch:{ all -> 0x010c }
                                int r7 = r7.j     // Catch:{ all -> 0x010c }
                                r8 = 2
                                if (r7 != r8) goto L_0x0045
                                com.bytedance.sdk.openadsdk.component.reward.a.i r7 = com.bytedance.sdk.openadsdk.component.reward.a.i.this     // Catch:{ all -> 0x010c }
                                com.bytedance.sdk.openadsdk.component.reward.a.a r7 = r7.b     // Catch:{ all -> 0x010c }
                                com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity r7 = r7.V     // Catch:{ all -> 0x010c }
                                android.content.res.Resources r7 = r7.getResources()     // Catch:{ all -> 0x010c }
                                android.content.res.Configuration r7 = r7.getConfiguration()     // Catch:{ all -> 0x010c }
                                int r7 = r7.orientation     // Catch:{ all -> 0x010c }
                                if (r7 != r8) goto L_0x0045
                                com.bytedance.sdk.openadsdk.component.reward.a.i r7 = com.bytedance.sdk.openadsdk.component.reward.a.i.this     // Catch:{ all -> 0x010c }
                                com.bytedance.sdk.openadsdk.component.reward.a.a r7 = r7.b     // Catch:{ all -> 0x010c }
                                com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity r7 = r7.V     // Catch:{ all -> 0x010c }
                                android.view.Window r7 = r7.getWindow()     // Catch:{ all -> 0x010c }
                                android.view.View r7 = r7.getDecorView()     // Catch:{ all -> 0x010c }
                                int r7 = r7.getWidth()     // Catch:{ all -> 0x010c }
                                com.bytedance.sdk.openadsdk.component.reward.a.i r0 = com.bytedance.sdk.openadsdk.component.reward.a.i.this     // Catch:{ all -> 0x010c }
                                com.bytedance.sdk.openadsdk.component.reward.a.a r0 = r0.b     // Catch:{ all -> 0x010c }
                                com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity r0 = r0.V     // Catch:{ all -> 0x010c }
                                int r0 = com.bytedance.sdk.openadsdk.utils.ad.j(r0)     // Catch:{ all -> 0x010c }
                                int r0 = r0 - r7
                                int r7 = java.lang.Math.abs(r0)     // Catch:{ all -> 0x010c }
                                goto L_0x006a
                            L_0x0045:
                                com.bytedance.sdk.openadsdk.component.reward.a.i r7 = com.bytedance.sdk.openadsdk.component.reward.a.i.this     // Catch:{ all -> 0x010c }
                                com.bytedance.sdk.openadsdk.component.reward.a.a r7 = r7.b     // Catch:{ all -> 0x010c }
                                com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity r7 = r7.V     // Catch:{ all -> 0x010c }
                                android.view.Window r7 = r7.getWindow()     // Catch:{ all -> 0x010c }
                                android.view.View r7 = r7.getDecorView()     // Catch:{ all -> 0x010c }
                                int r7 = r7.getHeight()     // Catch:{ all -> 0x010c }
                                com.bytedance.sdk.openadsdk.component.reward.a.i r0 = com.bytedance.sdk.openadsdk.component.reward.a.i.this     // Catch:{ all -> 0x010c }
                                com.bytedance.sdk.openadsdk.component.reward.a.a r0 = r0.b     // Catch:{ all -> 0x010c }
                                com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity r0 = r0.V     // Catch:{ all -> 0x010c }
                                int r0 = com.bytedance.sdk.openadsdk.utils.ad.i(r0)     // Catch:{ all -> 0x010c }
                                int r0 = r0 - r7
                                int r7 = java.lang.Math.abs(r0)     // Catch:{ all -> 0x010c }
                            L_0x006a:
                                com.bytedance.sdk.openadsdk.component.reward.a.i r0 = com.bytedance.sdk.openadsdk.component.reward.a.i.this     // Catch:{ all -> 0x010c }
                                com.bytedance.sdk.openadsdk.component.reward.a.a r0 = r0.b     // Catch:{ all -> 0x010c }
                                com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity r0 = r0.V     // Catch:{ all -> 0x010c }
                                android.view.Window r0 = r0.getWindow()     // Catch:{ all -> 0x010c }
                                android.view.View r0 = r0.getDecorView()     // Catch:{ all -> 0x010c }
                                int r1 = r0.getPaddingLeft()     // Catch:{ all -> 0x010c }
                                int r2 = r0.getPaddingRight()     // Catch:{ all -> 0x010c }
                                int r3 = r0.getPaddingBottom()     // Catch:{ all -> 0x010c }
                                if (r7 != 0) goto L_0x0102
                                int r7 = r0.getPaddingTop()     // Catch:{ all -> 0x010c }
                                com.bytedance.sdk.openadsdk.component.reward.a.i r4 = com.bytedance.sdk.openadsdk.component.reward.a.i.this     // Catch:{ all -> 0x010c }
                                com.bytedance.sdk.openadsdk.component.reward.a.a r4 = r4.b     // Catch:{ all -> 0x010c }
                                int r4 = r4.j     // Catch:{ all -> 0x010c }
                                r5 = 1
                                if (r4 != r5) goto L_0x00b2
                                com.bytedance.sdk.openadsdk.component.reward.a.i r4 = com.bytedance.sdk.openadsdk.component.reward.a.i.this     // Catch:{ all -> 0x010c }
                                com.bytedance.sdk.openadsdk.component.reward.a.a r4 = r4.b     // Catch:{ all -> 0x010c }
                                com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity r4 = r4.V     // Catch:{ all -> 0x010c }
                                android.content.res.Resources r4 = r4.getResources()     // Catch:{ all -> 0x010c }
                                android.content.res.Configuration r4 = r4.getConfiguration()     // Catch:{ all -> 0x010c }
                                int r4 = r4.orientation     // Catch:{ all -> 0x010c }
                                if (r4 != r5) goto L_0x00b2
                                float r8 = com.bytedance.sdk.openadsdk.utils.ad.a()     // Catch:{ all -> 0x010c }
                            L_0x00af:
                                int r8 = (int) r8     // Catch:{ all -> 0x010c }
                                int r7 = r7 + r8
                                goto L_0x00e3
                            L_0x00b2:
                                com.bytedance.sdk.openadsdk.component.reward.a.i r4 = com.bytedance.sdk.openadsdk.component.reward.a.i.this     // Catch:{ all -> 0x010c }
                                com.bytedance.sdk.openadsdk.component.reward.a.a r4 = r4.b     // Catch:{ all -> 0x010c }
                                int r4 = r4.j     // Catch:{ all -> 0x010c }
                                if (r4 != r8) goto L_0x00e3
                                com.bytedance.sdk.openadsdk.component.reward.a.i r4 = com.bytedance.sdk.openadsdk.component.reward.a.i.this     // Catch:{ all -> 0x010c }
                                com.bytedance.sdk.openadsdk.component.reward.a.a r4 = r4.b     // Catch:{ all -> 0x010c }
                                com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity r4 = r4.V     // Catch:{ all -> 0x010c }
                                android.content.res.Resources r4 = r4.getResources()     // Catch:{ all -> 0x010c }
                                android.content.res.Configuration r4 = r4.getConfiguration()     // Catch:{ all -> 0x010c }
                                int r4 = r4.orientation     // Catch:{ all -> 0x010c }
                                if (r4 != r8) goto L_0x00e3
                                boolean r8 = r0     // Catch:{ all -> 0x010c }
                                if (r8 == 0) goto L_0x00da
                                float r8 = com.bytedance.sdk.openadsdk.utils.ad.a()     // Catch:{ all -> 0x010c }
                                int r8 = (int) r8     // Catch:{ all -> 0x010c }
                                int r1 = r1 + r8
                            L_0x00da:
                                boolean r8 = r4     // Catch:{ all -> 0x010c }
                                if (r8 == 0) goto L_0x00e3
                                float r8 = com.bytedance.sdk.openadsdk.utils.ad.a()     // Catch:{ all -> 0x010c }
                                goto L_0x00af
                            L_0x00e3:
                                boolean r8 = r0.isAttachedToWindow()     // Catch:{ all -> 0x010c }
                                if (r8 == 0) goto L_0x00ee
                                r0.setPadding(r1, r7, r2, r3)     // Catch:{ all -> 0x010c }
                                r6.a = r5     // Catch:{ all -> 0x010c }
                            L_0x00ee:
                                com.bytedance.sdk.openadsdk.component.reward.a.i r7 = com.bytedance.sdk.openadsdk.component.reward.a.i.this     // Catch:{ all -> 0x010c }
                                com.bytedance.sdk.openadsdk.component.reward.a.a r7 = r7.b     // Catch:{ all -> 0x010c }
                                float r7 = r7.k     // Catch:{ all -> 0x010c }
                                r8 = 1120403456(0x42c80000, float:100.0)
                                int r7 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1))
                                if (r7 != 0) goto L_0x010c
                                r7 = -16777216(0xffffffffff000000, float:-1.7014118E38)
                                r0.setBackgroundColor(r7)     // Catch:{ all -> 0x010c }
                                goto L_0x010c
                            L_0x0102:
                                boolean r7 = r6.a     // Catch:{ all -> 0x010c }
                                if (r7 == 0) goto L_0x010c
                                r7 = 0
                                r0.setPadding(r1, r7, r2, r3)     // Catch:{ all -> 0x010c }
                                r6.a = r7     // Catch:{ all -> 0x010c }
                            L_0x010c:
                                return
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.component.reward.a.i.AnonymousClass2.a(int, int):void");
                        }
                    };
                }
                this.b.V.getWindow().getDecorView().addOnLayoutChangeListener(this.d);
            }
            this.c = false;
        } catch (Exception unused) {
        }
    }

    public float[] a(int i) {
        TTBaseVideoActivity tTBaseVideoActivity = this.b.V;
        View decorView = tTBaseVideoActivity.getWindow().getDecorView();
        float[] fArr = {(float) (decorView.getWidth() - (decorView.getPaddingLeft() * 2)), (float) (decorView.getHeight() - (decorView.getPaddingTop() * 2))};
        fArr[0] = (float) ad.c(tTBaseVideoActivity, fArr[0]);
        float c2 = (float) ad.c(tTBaseVideoActivity, fArr[1]);
        fArr[1] = c2;
        if (fArr[0] < 10.0f || c2 < 10.0f) {
            l.b("TTAD.RFSM", "get root view size error, so run backup");
            fArr = b(this.a);
        }
        if (!(Build.VERSION.SDK_INT == 26 || Build.VERSION.SDK_INT == 27 || tTBaseVideoActivity.getResources() == null || tTBaseVideoActivity.getResources().getConfiguration() == null)) {
            if ((tTBaseVideoActivity.getResources().getConfiguration().orientation == 2 ? 2 : 1) != i) {
                if (i == 2) {
                    float f = fArr[0];
                    float f2 = fArr[1];
                    if (f < f2) {
                        fArr[1] = f;
                        fArr[0] = f2;
                    }
                } else {
                    float f3 = fArr[0];
                    float f4 = fArr[1];
                    if (f3 > f4) {
                        fArr[1] = f3;
                        fArr[0] = f4;
                    }
                }
            }
        }
        return fArr;
    }

    public void a() {
        ad.a((Activity) this.b.V);
        this.b.V.getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
            public void onSystemUiVisibilityChange(int i) {
                if (i == 0) {
                    try {
                        if (!i.this.b.V.isFinishing()) {
                            i.this.b.V.getWindow().getDecorView().postDelayed(new Runnable() {
                                public void run() {
                                    ad.a((Activity) i.this.b.V);
                                }
                            }, 2500);
                        }
                    } catch (Exception e) {
                        l.e("TTAD.RFSM", e.getMessage());
                    }
                }
            }
        });
    }

    private float[] b(int i) {
        float f = f();
        float e = e();
        if ((this.b.j == 1) != (f > e)) {
            float f2 = f + e;
            e = f2 - e;
            f = f2 - e;
        }
        if (this.b.j == 1) {
            f -= (float) i;
        } else {
            e -= (float) i;
        }
        return new float[]{e, f};
    }

    private void d() {
        if (this.b.j != 2) {
            this.b.V.setRequestedOrientation(1);
        } else if (this.b.n) {
            this.b.V.setRequestedOrientation(8);
        } else {
            this.b.V.setRequestedOrientation(0);
        }
    }

    private float e() {
        return (float) ad.c(this.b.V, (float) ad.j(this.b.V));
    }

    private float f() {
        return (float) ad.c(this.b.V, (float) ad.i(this.b.V));
    }

    public void b() {
        if (this.d != null) {
            this.b.V.getWindow().getDecorView().removeOnLayoutChangeListener(this.d);
            this.d = null;
        }
    }

    /* compiled from: RewardFullScreenManager */
    private static abstract class a implements View.OnLayoutChangeListener {
        private int a;
        private int b;

        /* access modifiers changed from: package-private */
        public abstract void a(int i, int i2);

        private a() {
        }

        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            int i9 = i3 - i;
            int i10 = i4 - i2;
            if (i9 != this.a || i10 != this.b) {
                this.a = i9;
                this.b = i10;
                a(i9, i10);
            }
        }
    }
}

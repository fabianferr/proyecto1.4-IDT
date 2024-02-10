package com.mbridge.msdk.video.module;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.dycreator.baseview.cusview.MBridgeBaitClickView;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.same.report.m;
import com.mbridge.msdk.foundation.same.report.q;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.al;
import com.mbridge.msdk.shake.MBShakeView;
import com.mbridge.msdk.shake.a;
import com.mbridge.msdk.video.signal.factory.b;
import com.mbridge.msdk.videocommon.view.RoundImageView;
import com.mbridge.msdk.widget.FeedBackButton;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class MBridgeNativeEndCardView extends MBridgeBaseView {
    private LinearLayout A;
    private Runnable B;
    /* access modifiers changed from: private */
    public RelativeLayout C;
    private b D;
    /* access modifiers changed from: private */
    public boolean E = false;
    /* access modifiers changed from: private */
    public boolean F = false;
    /* access modifiers changed from: private */
    public boolean G = false;
    /* access modifiers changed from: private */
    public boolean H = false;
    private int I = 0;
    /* access modifiers changed from: private */
    public AlphaAnimation J;
    /* access modifiers changed from: private */
    public int K;
    /* access modifiers changed from: private */
    public int L;
    /* access modifiers changed from: private */
    public int M;
    /* access modifiers changed from: private */
    public int N;
    /* access modifiers changed from: private */
    public Bitmap O;
    /* access modifiers changed from: private */
    public View P;
    private View Q;
    private FeedBackButton R;
    private String S;
    private CampaignUnit T;
    private MBShakeView U;
    private com.mbridge.msdk.shake.b V;
    private MBridgeBaitClickView W;
    /* access modifiers changed from: private */
    public boolean aa = false;
    private ViewGroup n;
    private ViewGroup o;
    private RelativeLayout p;
    private RelativeLayout q;
    /* access modifiers changed from: private */
    public ImageView r;
    /* access modifiers changed from: private */
    public ImageView s;
    private ImageView t;
    private ImageView u;
    private ImageView v;
    private TextView w;
    private TextView x;
    private TextView y;
    private LinearLayout z;

    public void init(Context context) {
    }

    public void setCloseBtnDelay(int i) {
        this.I = i;
    }

    public void setUnitId(String str) {
        this.S = str;
    }

    public MBridgeNativeEndCardView(Context context) {
        super(context);
    }

    public MBridgeNativeEndCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MBridgeNativeEndCardView(Context context, AttributeSet attributeSet, boolean z2, int i, boolean z3, int i2, int i3) {
        super(context, attributeSet, z2, i, z3, i2, i3);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        int i;
        MBridgeBaitClickView mBridgeBaitClickView;
        super.onAttachedToWindow();
        if (this.B == null) {
            this.B = new Runnable() {
                public final void run() {
                    boolean unused = MBridgeNativeEndCardView.this.F = true;
                    if (MBridgeNativeEndCardView.this.P != null) {
                        MBridgeNativeEndCardView.this.P.setVisibility(0);
                    }
                }
            };
        }
        Runnable runnable = this.B;
        if (runnable != null) {
            postDelayed(runnable, (long) (this.I * 1000));
            if (!this.G) {
                this.G = true;
            }
            try {
                if (this.b != null) {
                    if (this.b.isDynamicView()) {
                        String str = this.b.getendcard_url();
                        if (TextUtils.isEmpty(str)) {
                            str = this.b.getEndScreenUrl();
                        }
                        String a = al.a(str, "alac");
                        if (!TextUtils.isEmpty(a) && a.equals("1")) {
                            postDelayed(new Runnable() {
                                public final void run() {
                                    MBridgeNativeEndCardView.a(MBridgeNativeEndCardView.this, 2);
                                }
                            }, 1000);
                        }
                    }
                }
            } catch (Throwable th) {
                aa.d(MBridgeBaseView.TAG, th.getMessage());
            }
        }
        try {
            if (this.b != null) {
                if (this.b.isDynamicView()) {
                    String str2 = this.b.getendcard_url();
                    if (TextUtils.isEmpty(str2)) {
                        str2 = this.b.getEndScreenUrl();
                    }
                    String a2 = al.a(str2, "bait_click");
                    i = Integer.parseInt(a2);
                    if (!(TextUtils.isEmpty(a2) || i == 0 || (mBridgeBaitClickView = this.W) == null)) {
                        mBridgeBaitClickView.setVisibility(0);
                        this.W.init(1342177280, i);
                        this.W.startAnimation();
                        this.W.setOnClickListener(new View.OnClickListener() {
                            public final void onClick(View view) {
                                MBridgeNativeEndCardView.a(MBridgeNativeEndCardView.this, 0);
                            }
                        });
                    }
                }
            }
        } catch (Throwable th2) {
            aa.d(MBridgeBaseView.TAG, th2.getMessage());
        }
        try {
            if (this.b == null) {
                return;
            }
            if (this.b.isDynamicView()) {
                String str3 = this.b.getendcard_url();
                if (TextUtils.isEmpty(str3)) {
                    str3 = this.b.getEndScreenUrl();
                }
                String a3 = al.a(str3, "shake_show");
                String a4 = al.a(str3, "shake_strength");
                String a5 = al.a(str3, "shake_time");
                if (!TextUtils.isEmpty(a3) && a3.equals("1")) {
                    if (this.U == null) {
                        MBridgeBaitClickView mBridgeBaitClickView2 = this.W;
                        if (mBridgeBaitClickView2 != null) {
                            mBridgeBaitClickView2.setVisibility(8);
                        }
                        MBShakeView mBShakeView = new MBShakeView(getContext());
                        this.U = mBShakeView;
                        mBShakeView.initView(this.b.getAdCall(), true);
                        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                        if (!isLandscape()) {
                            layoutParams.addRule(2, filterFindViewId(this.aa, "mbridge_iv_logo"));
                            layoutParams.addRule(14);
                            this.U.setPadding(0, 0, 0, af.b(getContext(), 20.0f));
                        } else {
                            layoutParams.addRule(13);
                        }
                        this.U.setLayoutParams(layoutParams);
                        RelativeLayout relativeLayout = this.p;
                        if (relativeLayout != null) {
                            if (relativeLayout.isShown()) {
                                this.p.addView(this.U);
                                View view = this.Q;
                                if (view != null) {
                                    view.setVisibility(4);
                                }
                                this.Q.setVisibility(4);
                                this.U.setOnClickListener(new View.OnClickListener() {
                                    public final void onClick(View view) {
                                        MBridgeNativeEndCardView.a(MBridgeNativeEndCardView.this, 0);
                                    }
                                });
                                int i2 = 10;
                                if (!TextUtils.isEmpty(a4)) {
                                    int parseInt = Integer.parseInt(a4);
                                    if (parseInt > 0) {
                                        i2 = parseInt;
                                    }
                                }
                                int i3 = 5000;
                                if (!TextUtils.isEmpty(a5)) {
                                    int parseInt2 = Integer.parseInt(a5);
                                    if (parseInt2 > 0) {
                                        i3 = parseInt2 * 1000;
                                    }
                                }
                                this.V = new com.mbridge.msdk.shake.b(i2, i3) {
                                    public final void a() {
                                        if (!MBridgeNativeEndCardView.this.H && MBridgeNativeEndCardView.this.G) {
                                            MBridgeNativeEndCardView.this.g = 0.0f;
                                            MBridgeNativeEndCardView.this.h = 0.0f;
                                            MBridgeNativeEndCardView.a(MBridgeNativeEndCardView.this, 4);
                                        }
                                    }
                                };
                                a.a().a(this.V);
                            }
                        }
                    }
                }
            }
        } catch (Throwable th3) {
            aa.d(MBridgeBaseView.TAG, th3.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.B;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        if (this.V != null) {
            a.a().b(this.V);
            this.V = null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x003f, code lost:
        if (r6.k != false) goto L_0x005c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0058, code lost:
        if (r6.k != false) goto L_0x005c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setLayout() {
        /*
            r6 = this;
            boolean r0 = r6.i
            if (r0 == 0) goto L_0x0025
            com.mbridge.msdk.video.dynview.j.c r0 = new com.mbridge.msdk.video.dynview.j.c
            r0.<init>()
            android.content.Context r1 = r6.getContext()
            com.mbridge.msdk.foundation.entity.CampaignEx r2 = r6.b
            int r3 = r6.j
            java.lang.String r4 = "en_"
            com.mbridge.msdk.video.dynview.c r0 = r0.a(r1, r2, r3, r4)
            com.mbridge.msdk.video.dynview.b r1 = com.mbridge.msdk.video.dynview.b.a()
            com.mbridge.msdk.video.module.MBridgeNativeEndCardView$9 r2 = new com.mbridge.msdk.video.module.MBridgeNativeEndCardView$9
            r2.<init>()
            r1.a(r0, r2)
            goto L_0x0096
        L_0x0025:
            int r0 = r6.l
            java.lang.String r1 = "mbridge_reward_endcard_native_half_landscape"
            java.lang.String r2 = "mbridge_reward_endcard_native_land"
            java.lang.String r3 = "mbridge_reward_endcard_native_half_portrait"
            java.lang.String r4 = "mbridge_reward_endcard_native_hor"
            if (r0 != 0) goto L_0x0042
            boolean r0 = r6.k
            if (r0 == 0) goto L_0x0036
            goto L_0x0037
        L_0x0036:
            r3 = r4
        L_0x0037:
            boolean r0 = r6.isLandscape()
            if (r0 == 0) goto L_0x005d
            boolean r0 = r6.k
            if (r0 == 0) goto L_0x005b
            goto L_0x005c
        L_0x0042:
            int r0 = r6.l
            r5 = 1
            if (r0 != r5) goto L_0x004e
            boolean r0 = r6.k
            if (r0 == 0) goto L_0x004c
            goto L_0x0051
        L_0x004c:
            r3 = r4
            goto L_0x0051
        L_0x004e:
            java.lang.String r0 = ""
            r3 = r0
        L_0x0051:
            int r0 = r6.l
            r4 = 2
            if (r0 != r4) goto L_0x005d
            boolean r0 = r6.k
            if (r0 == 0) goto L_0x005b
            goto L_0x005c
        L_0x005b:
            r1 = r2
        L_0x005c:
            r3 = r1
        L_0x005d:
            int r0 = r6.findLayout(r3)
            if (r0 <= 0) goto L_0x0096
            boolean r1 = r6.isLandscape()
            r2 = 0
            if (r1 == 0) goto L_0x007e
            android.view.LayoutInflater r1 = r6.c
            android.view.View r0 = r1.inflate(r0, r2)
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            r6.o = r0
            r6.addView(r0)
            android.view.ViewGroup r0 = r6.o
            boolean r0 = r6.b((android.view.View) r0)
            goto L_0x0091
        L_0x007e:
            android.view.LayoutInflater r1 = r6.c
            android.view.View r0 = r1.inflate(r0, r2)
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            r6.n = r0
            r6.addView(r0)
            android.view.ViewGroup r0 = r6.n
            boolean r0 = r6.b((android.view.View) r0)
        L_0x0091:
            r6.f = r0
            r6.a()
        L_0x0096:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.module.MBridgeNativeEndCardView.setLayout():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:50:0x016a A[Catch:{ all -> 0x0172 }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void preLoadData(com.mbridge.msdk.video.signal.factory.b r8) {
        /*
            r7 = this;
            r7.D = r8
            com.mbridge.msdk.foundation.entity.CampaignEx r8 = r7.b     // Catch:{ all -> 0x0172 }
            if (r8 == 0) goto L_0x017c
            boolean r8 = r7.f     // Catch:{ all -> 0x0172 }
            if (r8 == 0) goto L_0x017c
            com.mbridge.msdk.video.module.MBridgeNativeEndCardView$10 r8 = new com.mbridge.msdk.video.module.MBridgeNativeEndCardView$10     // Catch:{ all -> 0x0172 }
            r8.<init>()     // Catch:{ all -> 0x0172 }
            android.content.Context r0 = r7.a     // Catch:{ all -> 0x0172 }
            android.content.Context r0 = r0.getApplicationContext()     // Catch:{ all -> 0x0172 }
            com.mbridge.msdk.foundation.same.c.b r0 = com.mbridge.msdk.foundation.same.c.b.a((android.content.Context) r0)     // Catch:{ all -> 0x0172 }
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = r7.b     // Catch:{ all -> 0x0172 }
            java.lang.String r1 = r1.getImageUrl()     // Catch:{ all -> 0x0172 }
            r0.a((java.lang.String) r1, (com.mbridge.msdk.foundation.same.c.c) r8)     // Catch:{ all -> 0x0172 }
            com.mbridge.msdk.video.module.a.a.j r8 = new com.mbridge.msdk.video.module.a.a.j     // Catch:{ all -> 0x0172 }
            android.widget.ImageView r0 = r7.t     // Catch:{ all -> 0x0172 }
            com.mbridge.msdk.foundation.controller.b r1 = com.mbridge.msdk.foundation.controller.b.d()     // Catch:{ all -> 0x0172 }
            android.content.Context r1 = r1.g()     // Catch:{ all -> 0x0172 }
            r2 = 1090519040(0x41000000, float:8.0)
            int r1 = com.mbridge.msdk.foundation.tools.af.b((android.content.Context) r1, (float) r2)     // Catch:{ all -> 0x0172 }
            r8.<init>(r0, r1)     // Catch:{ all -> 0x0172 }
            android.content.Context r0 = r7.a     // Catch:{ all -> 0x0172 }
            android.content.Context r0 = r0.getApplicationContext()     // Catch:{ all -> 0x0172 }
            com.mbridge.msdk.foundation.same.c.b r0 = com.mbridge.msdk.foundation.same.c.b.a((android.content.Context) r0)     // Catch:{ all -> 0x0172 }
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = r7.b     // Catch:{ all -> 0x0172 }
            java.lang.String r1 = r1.getIconUrl()     // Catch:{ all -> 0x0172 }
            r0.a((java.lang.String) r1, (com.mbridge.msdk.foundation.same.c.c) r8)     // Catch:{ all -> 0x0172 }
            android.widget.TextView r8 = r7.w     // Catch:{ all -> 0x0172 }
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r7.b     // Catch:{ all -> 0x0172 }
            java.lang.String r0 = r0.getAppName()     // Catch:{ all -> 0x0172 }
            r8.setText(r0)     // Catch:{ all -> 0x0172 }
            android.view.View r8 = r7.Q     // Catch:{ all -> 0x0172 }
            if (r8 == 0) goto L_0x0068
            boolean r0 = r8 instanceof android.widget.TextView     // Catch:{ all -> 0x0172 }
            if (r0 == 0) goto L_0x0068
            android.widget.TextView r8 = (android.widget.TextView) r8     // Catch:{ all -> 0x0172 }
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r7.b     // Catch:{ all -> 0x0172 }
            java.lang.String r0 = r0.getAdCall()     // Catch:{ all -> 0x0172 }
            r8.setText(r0)     // Catch:{ all -> 0x0172 }
        L_0x0068:
            android.widget.TextView r8 = r7.x     // Catch:{ all -> 0x0172 }
            if (r8 == 0) goto L_0x0075
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r7.b     // Catch:{ all -> 0x0172 }
            java.lang.String r0 = r0.getAppDesc()     // Catch:{ all -> 0x0172 }
            r8.setText(r0)     // Catch:{ all -> 0x0172 }
        L_0x0075:
            android.widget.TextView r8 = r7.y     // Catch:{ all -> 0x0172 }
            if (r8 == 0) goto L_0x0093
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0172 }
            r0.<init>()     // Catch:{ all -> 0x0172 }
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = r7.b     // Catch:{ all -> 0x0172 }
            int r1 = r1.getNumberRating()     // Catch:{ all -> 0x0172 }
            r0.append(r1)     // Catch:{ all -> 0x0172 }
            java.lang.String r1 = ")"
            r0.append(r1)     // Catch:{ all -> 0x0172 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0172 }
            r8.setText(r0)     // Catch:{ all -> 0x0172 }
        L_0x0093:
            android.widget.LinearLayout r8 = r7.z     // Catch:{ all -> 0x0172 }
            r8.removeAllViews()     // Catch:{ all -> 0x0172 }
            com.mbridge.msdk.foundation.entity.CampaignEx r8 = r7.b     // Catch:{ all -> 0x0172 }
            double r0 = r8.getRating()     // Catch:{ all -> 0x0172 }
            r2 = 0
            int r8 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r8 > 0) goto L_0x00a6
            r0 = 4617315517961601024(0x4014000000000000, double:5.0)
        L_0x00a6:
            android.widget.LinearLayout r8 = r7.z     // Catch:{ all -> 0x0172 }
            boolean r2 = r8 instanceof com.mbridge.msdk.videocommon.view.StarLevelView     // Catch:{ all -> 0x0172 }
            if (r2 == 0) goto L_0x00b1
            com.mbridge.msdk.videocommon.view.StarLevelView r8 = (com.mbridge.msdk.videocommon.view.StarLevelView) r8     // Catch:{ all -> 0x0172 }
            r8.initScore(r0)     // Catch:{ all -> 0x0172 }
        L_0x00b1:
            android.widget.LinearLayout r8 = r7.z     // Catch:{ all -> 0x0172 }
            boolean r2 = r8 instanceof com.mbridge.msdk.video.dynview.widget.MBridgeLevelLayoutView     // Catch:{ all -> 0x0172 }
            if (r2 == 0) goto L_0x00c2
            com.mbridge.msdk.video.dynview.widget.MBridgeLevelLayoutView r8 = (com.mbridge.msdk.video.dynview.widget.MBridgeLevelLayoutView) r8     // Catch:{ all -> 0x0172 }
            com.mbridge.msdk.foundation.entity.CampaignEx r2 = r7.b     // Catch:{ all -> 0x0172 }
            int r2 = r2.getNumberRating()     // Catch:{ all -> 0x0172 }
            r8.setRatingAndUser(r0, r2)     // Catch:{ all -> 0x0172 }
        L_0x00c2:
            android.widget.LinearLayout r8 = r7.z     // Catch:{ all -> 0x0172 }
            boolean r2 = r8 instanceof com.mbridge.msdk.dycreator.baseview.MBStarLevelLayoutView     // Catch:{ all -> 0x0172 }
            if (r2 == 0) goto L_0x00ce
            com.mbridge.msdk.dycreator.baseview.MBStarLevelLayoutView r8 = (com.mbridge.msdk.dycreator.baseview.MBStarLevelLayoutView) r8     // Catch:{ all -> 0x0172 }
            int r0 = (int) r0     // Catch:{ all -> 0x0172 }
            r8.setRating(r0)     // Catch:{ all -> 0x0172 }
        L_0x00ce:
            android.widget.LinearLayout r8 = r7.A     // Catch:{ all -> 0x0172 }
            if (r8 == 0) goto L_0x00e1
            boolean r0 = r8 instanceof com.mbridge.msdk.dycreator.baseview.MBHeatLevelLayoutView     // Catch:{ all -> 0x0172 }
            if (r0 == 0) goto L_0x00e1
            com.mbridge.msdk.dycreator.baseview.MBHeatLevelLayoutView r8 = (com.mbridge.msdk.dycreator.baseview.MBHeatLevelLayoutView) r8     // Catch:{ all -> 0x0172 }
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r7.b     // Catch:{ all -> 0x0172 }
            int r0 = r0.getNumberRating()     // Catch:{ all -> 0x0172 }
            r8.setHeatCount(r0)     // Catch:{ all -> 0x0172 }
        L_0x00e1:
            com.mbridge.msdk.foundation.entity.CampaignEx r8 = r7.b     // Catch:{ all -> 0x0172 }
            java.lang.String r8 = r8.getendcard_url()     // Catch:{ all -> 0x0172 }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0172 }
            if (r8 != 0) goto L_0x00fe
            com.mbridge.msdk.foundation.entity.CampaignEx r8 = r7.b     // Catch:{ all -> 0x0172 }
            java.lang.String r8 = r8.getendcard_url()     // Catch:{ all -> 0x0172 }
            java.lang.String r0 = "alecfc=1"
            boolean r8 = r8.contains(r0)     // Catch:{ all -> 0x0172 }
            if (r8 == 0) goto L_0x00fe
            r8 = 1
            r7.E = r8     // Catch:{ all -> 0x0172 }
        L_0x00fe:
            java.util.Locale r8 = java.util.Locale.getDefault()     // Catch:{ all -> 0x0172 }
            java.lang.String r8 = r8.getLanguage()     // Catch:{ all -> 0x0172 }
            boolean r0 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0172 }
            java.lang.String r1 = "drawable"
            if (r0 != 0) goto L_0x0137
            java.lang.String r0 = "zh"
            boolean r8 = r8.equals(r0)     // Catch:{ all -> 0x0172 }
            if (r8 == 0) goto L_0x0137
            android.widget.ImageView r8 = r7.u     // Catch:{ all -> 0x0172 }
            android.content.res.Resources r0 = r7.getResources()     // Catch:{ all -> 0x0172 }
            android.content.res.Resources r2 = r7.getResources()     // Catch:{ all -> 0x0172 }
            java.lang.String r3 = "mbridge_reward_flag_cn"
            com.mbridge.msdk.foundation.controller.b r4 = com.mbridge.msdk.foundation.controller.b.d()     // Catch:{ all -> 0x0172 }
            java.lang.String r4 = r4.b()     // Catch:{ all -> 0x0172 }
            int r1 = r2.getIdentifier(r3, r1, r4)     // Catch:{ all -> 0x0172 }
            android.graphics.drawable.Drawable r0 = r0.getDrawable(r1)     // Catch:{ all -> 0x0172 }
            r8.setImageDrawable(r0)     // Catch:{ all -> 0x0172 }
            goto L_0x0156
        L_0x0137:
            android.widget.ImageView r8 = r7.u     // Catch:{ all -> 0x0172 }
            android.content.res.Resources r0 = r7.getResources()     // Catch:{ all -> 0x0172 }
            android.content.res.Resources r2 = r7.getResources()     // Catch:{ all -> 0x0172 }
            java.lang.String r3 = "mbridge_reward_flag_en"
            com.mbridge.msdk.foundation.controller.b r4 = com.mbridge.msdk.foundation.controller.b.d()     // Catch:{ all -> 0x0172 }
            java.lang.String r4 = r4.b()     // Catch:{ all -> 0x0172 }
            int r1 = r2.getIdentifier(r3, r1, r4)     // Catch:{ all -> 0x0172 }
            android.graphics.drawable.Drawable r0 = r0.getDrawable(r1)     // Catch:{ all -> 0x0172 }
            r8.setImageDrawable(r0)     // Catch:{ all -> 0x0172 }
        L_0x0156:
            r1 = 2
            android.widget.ImageView r2 = r7.v     // Catch:{ all -> 0x0172 }
            com.mbridge.msdk.foundation.entity.CampaignEx r3 = r7.b     // Catch:{ all -> 0x0172 }
            android.content.Context r4 = r7.a     // Catch:{ all -> 0x0172 }
            r5 = 1
            com.mbridge.msdk.video.module.MBridgeNativeEndCardView$11 r6 = new com.mbridge.msdk.video.module.MBridgeNativeEndCardView$11     // Catch:{ all -> 0x0172 }
            r6.<init>()     // Catch:{ all -> 0x0172 }
            com.mbridge.msdk.foundation.tools.af.a(r1, r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0172 }
            boolean r8 = r7.F     // Catch:{ all -> 0x0172 }
            if (r8 != 0) goto L_0x017c
            android.view.View r8 = r7.P     // Catch:{ all -> 0x0172 }
            r0 = 8
            r8.setVisibility(r0)     // Catch:{ all -> 0x0172 }
            goto L_0x017c
        L_0x0172:
            r8 = move-exception
            java.lang.String r0 = "MBridgeBaseView"
            java.lang.String r8 = r8.getMessage()
            com.mbridge.msdk.foundation.tools.aa.a((java.lang.String) r0, (java.lang.String) r8)
        L_0x017c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.module.MBridgeNativeEndCardView.preLoadData(com.mbridge.msdk.video.signal.factory.b):void");
    }

    /* access modifiers changed from: private */
    public void a() {
        c();
        if (!this.f) {
            this.e.a(104, "");
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 100.0f);
        this.J = alphaAnimation;
        alphaAnimation.setDuration(200);
    }

    public void onSelfConfigurationChanged(Configuration configuration) {
        super.onSelfConfigurationChanged(configuration);
        if (this.b == null || !this.b.isDynamicView()) {
            RelativeLayout relativeLayout = this.C;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(4);
            }
            this.d = configuration.orientation;
            if (this.d == 2) {
                removeView(this.n);
                a((View) this.o);
                return;
            }
            removeView(this.o);
            a((View) this.n);
        }
    }

    public boolean canBackPress() {
        View view = this.P;
        return view != null && view.getVisibility() == 0;
    }

    public void notifyShowListener() {
        this.e.a(110, "");
    }

    private void a(View view) {
        if (view == null) {
            setLayout();
            preLoadData(this.D);
        } else {
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            addView(view);
            b(view);
            c();
        }
        b();
    }

    /* access modifiers changed from: protected */
    public final void c() {
        if (this.f) {
            this.p.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    if (MBridgeNativeEndCardView.this.E) {
                        MBridgeNativeEndCardView.a(MBridgeNativeEndCardView.this, 1);
                    }
                }
            });
            this.P.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    if (MBridgeNativeEndCardView.this.i) {
                        try {
                            com.mbridge.msdk.video.dynview.moffer.a.a().b();
                        } catch (Exception e) {
                            aa.d(MBridgeBaseView.TAG, e.getMessage());
                        }
                        try {
                            if (MBridgeNativeEndCardView.this.b != null) {
                                HashMap hashMap = new HashMap();
                                String a2 = al.a(MBridgeNativeEndCardView.this.b.getendcard_url(), "ec_id");
                                String a3 = al.a(MBridgeNativeEndCardView.this.b.getendcard_url(), "mof");
                                hashMap.put("type", "choseFromTwoClose");
                                hashMap.put("endcard_id", a2);
                                hashMap.put("mof", a3);
                                com.mbridge.msdk.video.module.b.a.a("2000103", MBridgeNativeEndCardView.this.b, hashMap);
                            }
                        } catch (Exception e2) {
                            if (MBridgeConstans.DEBUG) {
                                e2.printStackTrace();
                            }
                        }
                    }
                    try {
                        if (MBridgeNativeEndCardView.this.b != null) {
                            HashMap hashMap2 = new HashMap();
                            hashMap2.put("type", "2");
                            m.a().c(MBridgeNativeEndCardView.this.b.getCurrentLRid(), "2000152", hashMap2);
                            m.a().a("2000134", MBridgeNativeEndCardView.this.b, (Map<String, String>) new HashMap());
                        }
                    } catch (Throwable th) {
                        if (MBridgeConstans.DEBUG) {
                            th.printStackTrace();
                        }
                    }
                    MBridgeNativeEndCardView.this.e.a(104, "");
                }
            });
            this.Q.setOnClickListener(new com.mbridge.msdk.widget.a() {
                /* access modifiers changed from: protected */
                public final void a(View view) {
                    MBridgeNativeEndCardView.a(MBridgeNativeEndCardView.this, 0);
                }
            });
            this.t.setOnClickListener(new com.mbridge.msdk.widget.a() {
                /* access modifiers changed from: protected */
                public final void a(View view) {
                    MBridgeNativeEndCardView.a(MBridgeNativeEndCardView.this, 0);
                }
            });
            this.s.setOnClickListener(new com.mbridge.msdk.widget.a() {
                /* access modifiers changed from: protected */
                public final void a(View view) {
                    MBridgeNativeEndCardView.a(MBridgeNativeEndCardView.this, 0);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public boolean b(View view) {
        try {
            this.p = (RelativeLayout) view.findViewById(filterFindViewId(this.aa, "mbridge_native_ec_layout"));
            this.q = (RelativeLayout) view.findViewById(filterFindViewId(this.aa, "mbridge_native_ec_layer_layout"));
            this.s = (ImageView) view.findViewById(filterFindViewId(this.aa, "mbridge_iv_adbanner"));
            this.t = (ImageView) view.findViewById(filterFindViewId(this.aa, "mbridge_iv_icon"));
            this.u = (ImageView) view.findViewById(filterFindViewId(this.aa, "mbridge_iv_flag"));
            this.v = (ImageView) view.findViewById(filterFindViewId(this.aa, "mbridge_iv_link"));
            this.w = (TextView) view.findViewById(filterFindViewId(this.aa, "mbridge_tv_apptitle"));
            this.z = (LinearLayout) view.findViewById(filterFindViewId(this.aa, "mbridge_sv_starlevel"));
            this.A = (LinearLayout) view.findViewById(filterFindViewId(this.aa, "mbridge_sv_heat_count_level"));
            this.P = view.findViewById(filterFindViewId(this.aa, "mbridge_iv_close"));
            this.Q = view.findViewById(filterFindViewId(this.aa, "mbridge_tv_cta"));
            this.R = (FeedBackButton) view.findViewById(filterFindViewId(this.aa, "mbridge_native_endcard_feed_btn"));
            this.C = (RelativeLayout) view.findViewById(filterFindViewId(this.aa, "mbridge_native_ec_controller"));
            this.r = (ImageView) view.findViewById(filterFindViewId(this.aa, "mbridge_iv_adbanner_bg"));
            this.W = (MBridgeBaitClickView) findViewById(filterFindViewId(this.aa, "mbridge_animation_click_view"));
            if (this.i) {
                ImageView imageView = this.s;
                if (imageView != null && (imageView instanceof RoundImageView)) {
                    ((RoundImageView) imageView).setBorderRadius(10);
                }
                ImageView imageView2 = this.t;
                if (imageView2 != null && (imageView2 instanceof RoundImageView)) {
                    ((RoundImageView) imageView2).setBorderRadius(10);
                }
                return isNotNULL(this.r, this.s, this.t, this.w, this.z, this.P, this.Q);
            }
            this.x = (TextView) view.findViewById(filterFindViewId(this.aa, "mbridge_tv_appdesc"));
            TextView textView = (TextView) view.findViewById(filterFindViewId(this.aa, "mbridge_tv_number"));
            this.y = textView;
            return isNotNULL(this.r, this.s, this.t, this.w, this.x, textView, this.z, this.P, this.Q);
        } catch (Throwable th) {
            aa.b(MBridgeBaseView.TAG, th.getMessage(), th);
            return false;
        }
    }

    public Bitmap blurBitmap(Bitmap bitmap) {
        try {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_4444);
            RenderScript create = RenderScript.create(this.a.getApplicationContext());
            ScriptIntrinsicBlur create2 = ScriptIntrinsicBlur.create(create, Element.U8_4(create));
            Allocation createFromBitmap = Allocation.createFromBitmap(create, bitmap);
            Allocation createFromBitmap2 = Allocation.createFromBitmap(create, createBitmap);
            create2.setRadius(25.0f);
            create2.setInput(createFromBitmap);
            create2.forEach(createFromBitmap2);
            createFromBitmap2.copyTo(createBitmap);
            create.destroy();
            return createBitmap;
        } catch (Throwable unused) {
            return null;
        }
    }

    public void setNotchPadding(int i, int i2, int i3, int i4) {
        aa.d(MBridgeBaseView.TAG, "NOTCH NativeEndCard " + String.format("%1s-%2s-%3s-%4s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}));
        this.K = i;
        this.L = i2;
        this.M = i3;
        this.N = i4;
        b();
    }

    private void b() {
        RelativeLayout relativeLayout;
        if (this.f && (relativeLayout = this.C) != null) {
            relativeLayout.postDelayed(new Runnable() {
                public final void run() {
                    if (MBridgeNativeEndCardView.this.C != null) {
                        if (!(MBridgeNativeEndCardView.this.b == null || MBridgeNativeEndCardView.this.b.isDynamicView() || MBridgeNativeEndCardView.this.b.getAdSpaceT() == 2)) {
                            MBridgeNativeEndCardView.this.C.setPadding(MBridgeNativeEndCardView.this.K, MBridgeNativeEndCardView.this.M, MBridgeNativeEndCardView.this.L, MBridgeNativeEndCardView.this.N);
                            MBridgeNativeEndCardView.this.C.startAnimation(MBridgeNativeEndCardView.this.J);
                        }
                        MBridgeNativeEndCardView.this.C.setVisibility(0);
                    }
                    if (!(MBridgeNativeEndCardView.this.P == null || MBridgeNativeEndCardView.this.P.getVisibility() == 0 || !MBridgeNativeEndCardView.this.F)) {
                        MBridgeNativeEndCardView.this.P.setVisibility(0);
                    }
                    MBridgeNativeEndCardView.n(MBridgeNativeEndCardView.this);
                }
            }, 200);
        }
    }

    public void setMoreOfferCampaignUnit(CampaignUnit campaignUnit) {
        MBShakeView mBShakeView;
        if (this.b != null && this.b.isDynamicView()) {
            this.T = campaignUnit;
            if (campaignUnit != null && campaignUnit.getAds() != null && this.T.getAds().size() > 5 && (mBShakeView = this.U) != null) {
                mBShakeView.setPadding(0, 0, 0, af.b(getContext(), 5.0f));
            }
        }
    }

    public void clearMoreOfferBitmap() {
        CampaignUnit campaignUnit;
        if (this.b != null && this.b.isDynamicView() && (campaignUnit = this.T) != null && campaignUnit.getAds() != null && this.T.getAds().size() > 0) {
            Iterator<CampaignEx> it = this.T.getAds().iterator();
            while (it.hasNext()) {
                CampaignEx next = it.next();
                if (!TextUtils.isEmpty(next.getIconUrl())) {
                    com.mbridge.msdk.foundation.same.c.b.a(com.mbridge.msdk.foundation.controller.b.d().g()).c(next.getIconUrl());
                }
            }
        }
    }

    public void release() {
        try {
            removeAllViews();
            AlphaAnimation alphaAnimation = this.J;
            if (alphaAnimation != null) {
                alphaAnimation.cancel();
            }
            this.B = null;
        } catch (Exception e) {
            aa.d(MBridgeBaseView.TAG, e.getMessage());
        }
    }

    public void setOnResume() {
        this.G = true;
    }

    public void setOnPause() {
        this.G = false;
    }

    public boolean isDyXmlSuccess() {
        return this.aa;
    }

    static /* synthetic */ void a(MBridgeNativeEndCardView mBridgeNativeEndCardView, final Bitmap bitmap) {
        try {
            com.mbridge.msdk.foundation.same.f.b.c().execute(new Runnable() {
                public final void run() {
                    MBridgeNativeEndCardView mBridgeNativeEndCardView = MBridgeNativeEndCardView.this;
                    Bitmap unused = mBridgeNativeEndCardView.O = mBridgeNativeEndCardView.blurBitmap(bitmap);
                    if (MBridgeNativeEndCardView.this.O != null && !MBridgeNativeEndCardView.this.O.isRecycled() && MBridgeNativeEndCardView.this.r != null) {
                        MBridgeNativeEndCardView.this.r.post(new Runnable() {
                            public final void run() {
                                if (MBridgeNativeEndCardView.this.i) {
                                    MBridgeNativeEndCardView.this.r.setBackground((Drawable) null);
                                }
                                aa.d("async", "执行异步加载图");
                                MBridgeNativeEndCardView.this.r.setImageBitmap(MBridgeNativeEndCardView.this.O);
                            }
                        });
                    }
                }
            });
        } catch (Exception e) {
            aa.a(MBridgeBaseView.TAG, e.getMessage());
        }
    }

    static /* synthetic */ void a(MBridgeNativeEndCardView mBridgeNativeEndCardView, int i) {
        JSONObject jSONObject;
        if (mBridgeNativeEndCardView.b != null && mBridgeNativeEndCardView.b.isDynamicView()) {
            try {
                CampaignEx.c rewardTemplateMode = mBridgeNativeEndCardView.b.getRewardTemplateMode();
                String str = "";
                if (rewardTemplateMode != null) {
                    str = rewardTemplateMode.b() + str;
                }
                q.a(com.mbridge.msdk.foundation.controller.b.d().g(), "end_card_click", mBridgeNativeEndCardView.b.getCampaignUnitId(), mBridgeNativeEndCardView.b.isBidCampaign(), mBridgeNativeEndCardView.b.getRequestId(), mBridgeNativeEndCardView.b.getRequestIdNotice(), mBridgeNativeEndCardView.b.getId(), str);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        JSONObject jSONObject2 = null;
        try {
            jSONObject = new JSONObject();
            try {
                jSONObject.put(com.mbridge.msdk.foundation.same.a.h, mBridgeNativeEndCardView.a(i));
                if (mBridgeNativeEndCardView.b.getDynamicTempCode() == 5) {
                    jSONObject.put("camp_position", 0);
                }
            } catch (JSONException e2) {
                e = e2;
                jSONObject2 = jSONObject;
                e.printStackTrace();
                jSONObject = jSONObject2;
                mBridgeNativeEndCardView.e.a(105, jSONObject);
            }
        } catch (JSONException e3) {
            e = e3;
            e.printStackTrace();
            jSONObject = jSONObject2;
            mBridgeNativeEndCardView.e.a(105, jSONObject);
        }
        mBridgeNativeEndCardView.e.a(105, jSONObject);
    }

    static /* synthetic */ void n(MBridgeNativeEndCardView mBridgeNativeEndCardView) {
        if (mBridgeNativeEndCardView.b != null) {
            mBridgeNativeEndCardView.b.setCampaignUnitId(mBridgeNativeEndCardView.S);
            com.mbridge.msdk.foundation.c.b a = com.mbridge.msdk.foundation.c.b.a();
            a.a(mBridgeNativeEndCardView.S + "_2", mBridgeNativeEndCardView.b);
        }
        if (com.mbridge.msdk.foundation.c.b.a().b()) {
            com.mbridge.msdk.foundation.c.b a2 = com.mbridge.msdk.foundation.c.b.a();
            a2.a(mBridgeNativeEndCardView.S + "_2", (com.mbridge.msdk.foundation.c.a) new com.mbridge.msdk.foundation.c.a() {
                public final void a() {
                    boolean unused = MBridgeNativeEndCardView.this.H = true;
                }

                public final void b() {
                    boolean unused = MBridgeNativeEndCardView.this.H = false;
                }

                public final void a(String str) {
                    boolean unused = MBridgeNativeEndCardView.this.H = false;
                }
            });
            com.mbridge.msdk.foundation.c.b a3 = com.mbridge.msdk.foundation.c.b.a();
            a3.c(mBridgeNativeEndCardView.S + "_1");
            if (mBridgeNativeEndCardView.R != null) {
                com.mbridge.msdk.foundation.c.b a4 = com.mbridge.msdk.foundation.c.b.a();
                a4.a(mBridgeNativeEndCardView.S + "_2", mBridgeNativeEndCardView.R);
                return;
            }
            return;
        }
        FeedBackButton feedBackButton = mBridgeNativeEndCardView.R;
        if (feedBackButton != null) {
            feedBackButton.setVisibility(8);
        }
    }
}

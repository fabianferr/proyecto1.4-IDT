package com.mbridge.msdk.video.bt.module;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import com.mbridge.msdk.video.bt.a.c;
import com.mbridge.msdk.video.signal.a.j;
import com.mbridge.msdk.videocommon.view.RoundImageView;
import com.mbridge.msdk.videocommon.view.StarLevelView;
import com.mbridge.msdk.widget.a;
import org.json.JSONException;
import org.json.JSONObject;

public class MBridgeBTNativeEC extends BTBaseView {
    private TextView A;
    private StarLevelView B;
    /* access modifiers changed from: private */
    public boolean C = false;
    /* access modifiers changed from: private */
    public boolean D = false;
    private int E = 0;
    private Runnable F;
    private boolean G = false;
    /* access modifiers changed from: private */
    public View H;
    private View I;
    /* access modifiers changed from: private */
    public String J;
    private j K;
    /* access modifiers changed from: private */
    public WebView L;
    private ViewGroup p;
    private ViewGroup q;
    private RelativeLayout r;
    private ImageView s;
    private RoundImageView t;
    private ImageView u;
    private ImageView v;
    private ImageView w;
    private ImageView x;
    private TextView y;
    private TextView z;

    public void onDestory() {
    }

    public MBridgeBTNativeEC(Context context) {
        super(context);
    }

    public MBridgeBTNativeEC(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setUnitId(String str) {
        this.J = str;
    }

    public void setJSCommon(j jVar) {
        this.K = jVar;
    }

    public void setCreateWebView(WebView webView) {
        this.L = webView;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.F == null) {
            this.F = new Runnable() {
                public final void run() {
                    boolean unused = MBridgeBTNativeEC.this.D = true;
                    if (MBridgeBTNativeEC.this.H != null) {
                        MBridgeBTNativeEC.this.H.setVisibility(0);
                    }
                }
            };
        }
        Runnable runnable = this.F;
        if (runnable != null) {
            postDelayed(runnable, (long) (this.E * 1000));
        }
        if (!this.h && this.L != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("id", this.d);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(CampaignEx.JSON_KEY_CAMPAIGN_UNITID, this.J);
                jSONObject.put("data", jSONObject2);
                aa.a(BTBaseView.TAG, "NativeEC Call H5 onCloseBtnClicked " + jSONObject.toString());
            } catch (JSONException e) {
                aa.a(BTBaseView.TAG, e.getMessage());
            }
            g.a().a(this.L, "onCloseBtnClicked", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        }
        if (this.L != null) {
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("id", this.d);
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put(CampaignEx.JSON_KEY_CAMPAIGN_UNITID, this.J);
                jSONObject3.put("data", jSONObject4);
                aa.a(BTBaseView.TAG, "NativeEC Call H5 onEndCardShow " + jSONObject3.toString());
            } catch (JSONException e2) {
                aa.a(BTBaseView.TAG, e2.getMessage());
            }
            g.a().a(this.L, "onNativeECShow", Base64.encodeToString(jSONObject3.toString().getBytes(), 2));
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.F;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        r7.s.setVisibility(8);
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x00d0 */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x016b A[Catch:{ all -> 0x018c }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0186 A[Catch:{ all -> 0x018c }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void preLoadData() {
        /*
            r7 = this;
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r7.b     // Catch:{ all -> 0x018c }
            if (r0 == 0) goto L_0x0196
            boolean r0 = r7.h     // Catch:{ all -> 0x018c }
            if (r0 == 0) goto L_0x0196
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r7.b     // Catch:{ all -> 0x018c }
            int r0 = r0.getCbd()     // Catch:{ all -> 0x018c }
            r1 = -2
            if (r0 <= r1) goto L_0x001a
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r7.b     // Catch:{ all -> 0x018c }
            int r0 = r0.getCbd()     // Catch:{ all -> 0x018c }
            r7.E = r0     // Catch:{ all -> 0x018c }
            goto L_0x0026
        L_0x001a:
            com.mbridge.msdk.videocommon.d.c r0 = r7.e     // Catch:{ all -> 0x018c }
            if (r0 == 0) goto L_0x0026
            com.mbridge.msdk.videocommon.d.c r0 = r7.e     // Catch:{ all -> 0x018c }
            int r0 = r0.p()     // Catch:{ all -> 0x018c }
            r7.E = r0     // Catch:{ all -> 0x018c }
        L_0x0026:
            com.mbridge.msdk.video.module.a.a.e r0 = new com.mbridge.msdk.video.module.a.a.e     // Catch:{ all -> 0x018c }
            com.mbridge.msdk.videocommon.view.RoundImageView r1 = r7.t     // Catch:{ all -> 0x018c }
            com.mbridge.msdk.foundation.entity.CampaignEx r2 = r7.b     // Catch:{ all -> 0x018c }
            java.lang.String r3 = r7.J     // Catch:{ all -> 0x018c }
            r0.<init>(r1, r2, r3)     // Catch:{ all -> 0x018c }
            android.content.Context r1 = r7.a     // Catch:{ all -> 0x018c }
            android.content.Context r1 = r1.getApplicationContext()     // Catch:{ all -> 0x018c }
            com.mbridge.msdk.foundation.same.c.b r1 = com.mbridge.msdk.foundation.same.c.b.a((android.content.Context) r1)     // Catch:{ all -> 0x018c }
            com.mbridge.msdk.foundation.entity.CampaignEx r2 = r7.b     // Catch:{ all -> 0x018c }
            java.lang.String r2 = r2.getImageUrl()     // Catch:{ all -> 0x018c }
            r1.a((java.lang.String) r2, (com.mbridge.msdk.foundation.same.c.c) r0)     // Catch:{ all -> 0x018c }
            com.mbridge.msdk.video.module.a.a.j r0 = new com.mbridge.msdk.video.module.a.a.j     // Catch:{ all -> 0x018c }
            android.widget.ImageView r1 = r7.u     // Catch:{ all -> 0x018c }
            com.mbridge.msdk.foundation.controller.b r2 = com.mbridge.msdk.foundation.controller.b.d()     // Catch:{ all -> 0x018c }
            android.content.Context r2 = r2.g()     // Catch:{ all -> 0x018c }
            r3 = 1090519040(0x41000000, float:8.0)
            int r2 = com.mbridge.msdk.foundation.tools.af.b((android.content.Context) r2, (float) r3)     // Catch:{ all -> 0x018c }
            r0.<init>(r1, r2)     // Catch:{ all -> 0x018c }
            android.content.Context r1 = r7.a     // Catch:{ all -> 0x018c }
            android.content.Context r1 = r1.getApplicationContext()     // Catch:{ all -> 0x018c }
            com.mbridge.msdk.foundation.same.c.b r1 = com.mbridge.msdk.foundation.same.c.b.a((android.content.Context) r1)     // Catch:{ all -> 0x018c }
            com.mbridge.msdk.foundation.entity.CampaignEx r2 = r7.b     // Catch:{ all -> 0x018c }
            java.lang.String r2 = r2.getIconUrl()     // Catch:{ all -> 0x018c }
            r1.a((java.lang.String) r2, (com.mbridge.msdk.foundation.same.c.c) r0)     // Catch:{ all -> 0x018c }
            android.widget.TextView r0 = r7.y     // Catch:{ all -> 0x018c }
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = r7.b     // Catch:{ all -> 0x018c }
            java.lang.String r1 = r1.getAppName()     // Catch:{ all -> 0x018c }
            r0.setText(r1)     // Catch:{ all -> 0x018c }
            android.widget.TextView r0 = r7.z     // Catch:{ all -> 0x018c }
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = r7.b     // Catch:{ all -> 0x018c }
            java.lang.String r1 = r1.getAppDesc()     // Catch:{ all -> 0x018c }
            r0.setText(r1)     // Catch:{ all -> 0x018c }
            android.widget.TextView r0 = r7.A     // Catch:{ all -> 0x018c }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x018c }
            r1.<init>()     // Catch:{ all -> 0x018c }
            com.mbridge.msdk.foundation.entity.CampaignEx r2 = r7.b     // Catch:{ all -> 0x018c }
            int r2 = r2.getNumberRating()     // Catch:{ all -> 0x018c }
            r1.append(r2)     // Catch:{ all -> 0x018c }
            java.lang.String r2 = ")"
            r1.append(r2)     // Catch:{ all -> 0x018c }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x018c }
            r0.setText(r1)     // Catch:{ all -> 0x018c }
            com.mbridge.msdk.videocommon.view.StarLevelView r0 = r7.B     // Catch:{ all -> 0x018c }
            r0.removeAllViews()     // Catch:{ all -> 0x018c }
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r7.b     // Catch:{ all -> 0x018c }
            double r0 = r0.getRating()     // Catch:{ all -> 0x018c }
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 > 0) goto L_0x00b1
            r0 = 4617315517961601024(0x4014000000000000, double:5.0)
        L_0x00b1:
            com.mbridge.msdk.videocommon.view.StarLevelView r2 = r7.B     // Catch:{ all -> 0x018c }
            r2.initScore(r0)     // Catch:{ all -> 0x018c }
            r0 = 8
            com.mbridge.msdk.videocommon.view.RoundImageView r1 = r7.t     // Catch:{ all -> 0x00d0 }
            android.graphics.drawable.Drawable r1 = r1.getDrawable()     // Catch:{ all -> 0x00d0 }
            android.graphics.Bitmap r1 = r7.a((android.graphics.drawable.Drawable) r1)     // Catch:{ all -> 0x00d0 }
            if (r1 == 0) goto L_0x00d5
            android.graphics.Bitmap r1 = r7.blurBitmap(r1)     // Catch:{ all -> 0x00d0 }
            if (r1 == 0) goto L_0x00d5
            android.widget.ImageView r2 = r7.s     // Catch:{ all -> 0x00d0 }
            r2.setImageBitmap(r1)     // Catch:{ all -> 0x00d0 }
            goto L_0x00d5
        L_0x00d0:
            android.widget.ImageView r1 = r7.s     // Catch:{ all -> 0x018c }
            r1.setVisibility(r0)     // Catch:{ all -> 0x018c }
        L_0x00d5:
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = r7.b     // Catch:{ all -> 0x018c }
            java.lang.String r1 = r1.getendcard_url()     // Catch:{ all -> 0x018c }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x018c }
            r2 = 1
            if (r1 != 0) goto L_0x00f2
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = r7.b     // Catch:{ all -> 0x018c }
            java.lang.String r1 = r1.getendcard_url()     // Catch:{ all -> 0x018c }
            java.lang.String r3 = "alecfc=1"
            boolean r1 = r1.contains(r3)     // Catch:{ all -> 0x018c }
            if (r1 == 0) goto L_0x00f2
            r7.C = r2     // Catch:{ all -> 0x018c }
        L_0x00f2:
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = r7.b     // Catch:{ all -> 0x018c }
            java.lang.String r1 = r1.getendcard_url()     // Catch:{ all -> 0x018c }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x018c }
            if (r1 != 0) goto L_0x010f
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = r7.b     // Catch:{ all -> 0x018c }
            java.lang.String r1 = r1.getendcard_url()     // Catch:{ all -> 0x018c }
            java.lang.String r3 = "wlgo=1"
            boolean r1 = r1.contains(r3)     // Catch:{ all -> 0x018c }
            if (r1 == 0) goto L_0x010f
            r7.G = r2     // Catch:{ all -> 0x018c }
        L_0x010f:
            java.util.Locale r1 = java.util.Locale.getDefault()     // Catch:{ all -> 0x018c }
            java.lang.String r1 = r1.getLanguage()     // Catch:{ all -> 0x018c }
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x018c }
            java.lang.String r3 = "drawable"
            if (r2 != 0) goto L_0x0148
            java.lang.String r2 = "zh"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x018c }
            if (r1 == 0) goto L_0x0148
            android.widget.ImageView r1 = r7.v     // Catch:{ all -> 0x018c }
            android.content.res.Resources r2 = r7.getResources()     // Catch:{ all -> 0x018c }
            android.content.res.Resources r4 = r7.getResources()     // Catch:{ all -> 0x018c }
            java.lang.String r5 = "mbridge_reward_flag_cn"
            com.mbridge.msdk.foundation.controller.b r6 = com.mbridge.msdk.foundation.controller.b.d()     // Catch:{ all -> 0x018c }
            java.lang.String r6 = r6.b()     // Catch:{ all -> 0x018c }
            int r3 = r4.getIdentifier(r5, r3, r6)     // Catch:{ all -> 0x018c }
            android.graphics.drawable.Drawable r2 = r2.getDrawable(r3)     // Catch:{ all -> 0x018c }
            r1.setImageDrawable(r2)     // Catch:{ all -> 0x018c }
            goto L_0x0167
        L_0x0148:
            android.widget.ImageView r1 = r7.v     // Catch:{ all -> 0x018c }
            android.content.res.Resources r2 = r7.getResources()     // Catch:{ all -> 0x018c }
            android.content.res.Resources r4 = r7.getResources()     // Catch:{ all -> 0x018c }
            java.lang.String r5 = "mbridge_reward_flag_en"
            com.mbridge.msdk.foundation.controller.b r6 = com.mbridge.msdk.foundation.controller.b.d()     // Catch:{ all -> 0x018c }
            java.lang.String r6 = r6.b()     // Catch:{ all -> 0x018c }
            int r3 = r4.getIdentifier(r5, r3, r6)     // Catch:{ all -> 0x018c }
            android.graphics.drawable.Drawable r2 = r2.getDrawable(r3)     // Catch:{ all -> 0x018c }
            r1.setImageDrawable(r2)     // Catch:{ all -> 0x018c }
        L_0x0167:
            boolean r1 = r7.G     // Catch:{ all -> 0x018c }
            if (r1 != 0) goto L_0x0176
            android.widget.ImageView r1 = r7.v     // Catch:{ all -> 0x018c }
            r2 = 4
            r1.setVisibility(r2)     // Catch:{ all -> 0x018c }
            android.widget.ImageView r1 = r7.x     // Catch:{ all -> 0x018c }
            r1.setVisibility(r2)     // Catch:{ all -> 0x018c }
        L_0x0176:
            r1 = 2
            android.widget.ImageView r2 = r7.w     // Catch:{ all -> 0x018c }
            com.mbridge.msdk.foundation.entity.CampaignEx r3 = r7.b     // Catch:{ all -> 0x018c }
            android.content.Context r4 = r7.a     // Catch:{ all -> 0x018c }
            r5 = 1
            r6 = 0
            com.mbridge.msdk.foundation.tools.af.a(r1, r2, r3, r4, r5, r6)     // Catch:{ all -> 0x018c }
            boolean r1 = r7.D     // Catch:{ all -> 0x018c }
            if (r1 != 0) goto L_0x0196
            android.view.View r1 = r7.H     // Catch:{ all -> 0x018c }
            r1.setVisibility(r0)     // Catch:{ all -> 0x018c }
            goto L_0x0196
        L_0x018c:
            r0 = move-exception
            java.lang.String r1 = "BTBaseView"
            java.lang.String r0 = r0.getMessage()
            com.mbridge.msdk.foundation.tools.aa.a((java.lang.String) r1, (java.lang.String) r0)
        L_0x0196:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.bt.module.MBridgeBTNativeEC.preLoadData():void");
    }

    public void onSelfConfigurationChanged(Configuration configuration) {
        super.onSelfConfigurationChanged(configuration);
        this.g = configuration.orientation;
        if (this.g == 2) {
            removeView(this.p);
            a((View) this.q);
            return;
        }
        removeView(this.q);
        a((View) this.p);
    }

    private void a(View view) {
        if (view == null) {
            init(this.a);
            preLoadData();
            return;
        }
        if (view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        addView(view);
        b(view);
        a();
    }

    /* access modifiers changed from: protected */
    public final void a() {
        if (this.h) {
            this.r.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    if (MBridgeBTNativeEC.this.C) {
                        MBridgeBTNativeEC.a(MBridgeBTNativeEC.this, 1);
                        MBridgeBTNativeEC.a(MBridgeBTNativeEC.this, view.getX(), view.getY());
                    }
                }
            });
            this.H.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    if (MBridgeBTNativeEC.this.L != null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("id", MBridgeBTNativeEC.this.d);
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put(CampaignEx.JSON_KEY_CAMPAIGN_UNITID, MBridgeBTNativeEC.this.J);
                            jSONObject.put("data", jSONObject2);
                            aa.a(BTBaseView.TAG, "NativeEC Call H5 onCloseBtnClicked " + jSONObject.toString());
                        } catch (JSONException e) {
                            aa.a(BTBaseView.TAG, e.getMessage());
                        }
                        g.a().a(MBridgeBTNativeEC.this.L, "onCloseBtnClicked", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    }
                }
            });
            this.I.setOnClickListener(new a() {
                /* access modifiers changed from: protected */
                public final void a(View view) {
                    MBridgeBTNativeEC.a(MBridgeBTNativeEC.this, 0);
                    MBridgeBTNativeEC.a(MBridgeBTNativeEC.this, view.getX(), view.getY());
                }
            });
            this.u.setOnClickListener(new a() {
                /* access modifiers changed from: protected */
                public final void a(View view) {
                    MBridgeBTNativeEC.a(MBridgeBTNativeEC.this, 0);
                    MBridgeBTNativeEC.a(MBridgeBTNativeEC.this, view.getX(), view.getY());
                }
            });
            this.t.setOnClickListener(new a() {
                /* access modifiers changed from: protected */
                public final void a(View view) {
                    MBridgeBTNativeEC.a(MBridgeBTNativeEC.this, 0);
                    MBridgeBTNativeEC.a(MBridgeBTNativeEC.this, view.getX(), view.getY());
                }
            });
        }
    }

    private boolean b(View view) {
        try {
            this.r = (RelativeLayout) view.findViewById(findID("mbridge_native_ec_layout"));
            this.s = (ImageView) view.findViewById(findID("mbridge_iv_adbanner_bg"));
            this.t = (RoundImageView) view.findViewById(findID("mbridge_iv_adbanner"));
            this.u = (ImageView) view.findViewById(findID("mbridge_iv_icon"));
            this.v = (ImageView) view.findViewById(findID("mbridge_iv_flag"));
            this.w = (ImageView) view.findViewById(findID("mbridge_iv_link"));
            this.y = (TextView) view.findViewById(findID("mbridge_tv_apptitle"));
            this.z = (TextView) view.findViewById(findID("mbridge_tv_appdesc"));
            this.A = (TextView) view.findViewById(findID("mbridge_tv_number"));
            this.B = (StarLevelView) view.findViewById(findID("mbridge_sv_starlevel"));
            this.H = view.findViewById(findID("mbridge_iv_close"));
            this.I = view.findViewById(findID("mbridge_tv_cta"));
            this.x = (ImageView) view.findViewById(findID("mbridge_iv_logo"));
            return isNotNULL(this.s, this.t, this.u, this.y, this.z, this.A, this.B, this.H, this.I);
        } catch (Throwable th) {
            aa.b(BTBaseView.TAG, th.getMessage(), th);
            return false;
        }
    }

    public Bitmap blurBitmap(Bitmap bitmap) {
        try {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            RenderScript create = RenderScript.create(this.a.getApplicationContext());
            ScriptIntrinsicBlur create2 = ScriptIntrinsicBlur.create(create, Element.U8_4(create));
            Allocation createFromBitmap = Allocation.createFromBitmap(create, bitmap);
            Allocation createFromBitmap2 = Allocation.createFromBitmap(create, createBitmap);
            create2.setRadius(10.0f);
            create2.setInput(createFromBitmap);
            create2.forEach(createFromBitmap2);
            createFromBitmap2.copyTo(createBitmap);
            bitmap.recycle();
            create.destroy();
            return createBitmap;
        } catch (Throwable unused) {
            return null;
        }
    }

    private Bitmap a(Drawable drawable) {
        try {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            drawable.draw(canvas);
            return createBitmap;
        } catch (Throwable th) {
            aa.a(BTBaseView.TAG, th.getMessage());
            return null;
        }
    }

    public void init(Context context) {
        boolean z2;
        int findLayout = findLayout(isLandscape() ? "mbridge_reward_endcard_native_land" : "mbridge_reward_endcard_native_hor");
        if (findLayout > 0) {
            if (isLandscape()) {
                ViewGroup viewGroup = (ViewGroup) this.f.inflate(findLayout, (ViewGroup) null);
                this.q = viewGroup;
                addView(viewGroup);
                z2 = b((View) this.q);
            } else {
                ViewGroup viewGroup2 = (ViewGroup) this.f.inflate(findLayout, (ViewGroup) null);
                this.p = viewGroup2;
                addView(viewGroup2);
                z2 = b((View) this.p);
            }
            this.h = z2;
            a();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x001e A[Catch:{ all -> 0x0013 }] */
    /* JADX WARNING: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(com.mbridge.msdk.video.bt.module.MBridgeBTNativeEC r2, int r3) {
        /*
            r0 = 0
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0015 }
            r1.<init>()     // Catch:{ JSONException -> 0x0015 }
            java.lang.String r0 = com.mbridge.msdk.foundation.same.a.h     // Catch:{ JSONException -> 0x0010 }
            org.json.JSONObject r3 = r2.a(r3)     // Catch:{ JSONException -> 0x0010 }
            r1.put(r0, r3)     // Catch:{ JSONException -> 0x0010 }
            goto L_0x001a
        L_0x0010:
            r3 = move-exception
            r0 = r1
            goto L_0x0016
        L_0x0013:
            r2 = move-exception
            goto L_0x002c
        L_0x0015:
            r3 = move-exception
        L_0x0016:
            r3.printStackTrace()     // Catch:{ all -> 0x0013 }
            r1 = r0
        L_0x001a:
            com.mbridge.msdk.video.signal.a.j r2 = r2.K     // Catch:{ all -> 0x0013 }
            if (r2 == 0) goto L_0x0035
            if (r1 == 0) goto L_0x0025
            java.lang.String r3 = r1.toString()     // Catch:{ all -> 0x0013 }
            goto L_0x0027
        L_0x0025:
            java.lang.String r3 = ""
        L_0x0027:
            r0 = 1
            r2.click(r0, r3)     // Catch:{ all -> 0x0013 }
            goto L_0x0035
        L_0x002c:
            java.lang.String r3 = "BTBaseView"
            java.lang.String r2 = r2.getMessage()
            com.mbridge.msdk.foundation.tools.aa.a((java.lang.String) r3, (java.lang.String) r2)
        L_0x0035:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.bt.module.MBridgeBTNativeEC.a(com.mbridge.msdk.video.bt.module.MBridgeBTNativeEC, int):void");
    }

    static /* synthetic */ void a(MBridgeBTNativeEC mBridgeBTNativeEC, float f, float f2) {
        if (mBridgeBTNativeEC.L != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("code", n);
                jSONObject.put("id", mBridgeBTNativeEC.d);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("x", String.valueOf(f));
                jSONObject2.put("y", String.valueOf(f2));
                jSONObject.put("data", jSONObject2);
                g.a().a(mBridgeBTNativeEC.L, "onClicked", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
            } catch (Exception unused) {
                c.a().a(mBridgeBTNativeEC.L, "onClicked", mBridgeBTNativeEC.d);
            }
        }
    }
}

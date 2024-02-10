package com.mbridge.msdk.dycreator.baseview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import com.mbridge.msdk.foundation.tools.aa;

public class MBSplashClickView extends MBRelativeLayout {
    public final int TYPE_SPLASH_BTN_CLICK = 3;
    public final int TYPE_SPLASH_BTN_GO = 2;
    public final int TYPE_SPLASH_BTN_OPEN = 1;
    private final String a = "浏览第三方应用";
    private final String b = "View";
    private final String c = "打开第三方应用";
    private final String d = "Open";
    private final String e = "下载第三方应用";
    private final String f = "Install";
    private final String g = "mbridge_splash_btn_arrow_right";
    private final String h = "mbridge_splash_btn_circle";
    private final String i = "mbridge_splash_btn_finger";
    private final String j = "mbridge_splash_btn_go";
    private final String k = "mbridge_splash_btn_light";
    private final String l = "mbridge_expand_data";
    private String m;
    private int n;
    /* access modifiers changed from: private */
    public ImageView o;
    /* access modifiers changed from: private */
    public ImageView p;
    private final RectF q = new RectF();
    private final Paint r = new Paint();
    private final Paint s = new Paint();

    public MBSplashClickView(Context context) {
        super(context);
        a();
    }

    public MBSplashClickView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public MBSplashClickView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }

    private void a() {
        this.r.setAntiAlias(true);
        this.r.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        this.s.setAntiAlias(true);
        this.s.setColor(-1);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0099, code lost:
        r12 = a(r12, "mbridge_expand_data");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void initView(java.lang.String r12) {
        /*
            r11 = this;
            r11.m = r12
            r12.hashCode()
            int r0 = r12.hashCode()
            java.lang.String r1 = "浏览第三方应用"
            java.lang.String r2 = "View"
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            r7 = -1
            switch(r0) {
                case -672744069: goto L_0x004d;
                case 2464362: goto L_0x0042;
                case 2666181: goto L_0x0039;
                case 855294846: goto L_0x002d;
                case 1383132195: goto L_0x0021;
                case 1681333335: goto L_0x0018;
                default: goto L_0x0016;
            }
        L_0x0016:
            r12 = -1
            goto L_0x0057
        L_0x0018:
            boolean r12 = r12.equals(r1)
            if (r12 != 0) goto L_0x001f
            goto L_0x0016
        L_0x001f:
            r12 = 5
            goto L_0x0057
        L_0x0021:
            java.lang.String r0 = "打开第三方应用"
            boolean r12 = r12.equals(r0)
            if (r12 != 0) goto L_0x002b
            goto L_0x0016
        L_0x002b:
            r12 = 4
            goto L_0x0057
        L_0x002d:
            java.lang.String r0 = "下载第三方应用"
            boolean r12 = r12.equals(r0)
            if (r12 != 0) goto L_0x0037
            goto L_0x0016
        L_0x0037:
            r12 = 3
            goto L_0x0057
        L_0x0039:
            boolean r12 = r12.equals(r2)
            if (r12 != 0) goto L_0x0040
            goto L_0x0016
        L_0x0040:
            r12 = 2
            goto L_0x0057
        L_0x0042:
            java.lang.String r0 = "Open"
            boolean r12 = r12.equals(r0)
            if (r12 != 0) goto L_0x004b
            goto L_0x0016
        L_0x004b:
            r12 = 1
            goto L_0x0057
        L_0x004d:
            java.lang.String r0 = "Install"
            boolean r12 = r12.equals(r0)
            if (r12 != 0) goto L_0x0056
            goto L_0x0016
        L_0x0056:
            r12 = 0
        L_0x0057:
            switch(r12) {
                case 0: goto L_0x0063;
                case 1: goto L_0x0060;
                case 2: goto L_0x005c;
                case 3: goto L_0x0063;
                case 4: goto L_0x0060;
                case 5: goto L_0x005c;
                default: goto L_0x005a;
            }
        L_0x005a:
            r12 = 0
            goto L_0x0066
        L_0x005c:
            r11.n = r4
        L_0x005e:
            r12 = 1
            goto L_0x0066
        L_0x0060:
            r11.n = r5
            goto L_0x005e
        L_0x0063:
            r11.n = r3
            goto L_0x005e
        L_0x0066:
            if (r12 != 0) goto L_0x0091
            android.content.Context r12 = r11.getContext()
            android.content.res.Resources r12 = r12.getResources()
            android.content.res.Configuration r12 = r12.getConfiguration()
            java.util.Locale r12 = r12.locale
            java.lang.String r12 = r12.getLanguage()
            java.lang.String r0 = "zh"
            boolean r12 = r12.contains(r0)
            java.lang.String r0 = r11.m
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x008f
            if (r12 == 0) goto L_0x008c
            goto L_0x008d
        L_0x008c:
            r1 = r2
        L_0x008d:
            r11.m = r1
        L_0x008f:
            r11.n = r4
        L_0x0091:
            android.view.ViewParent r12 = r11.getParent()
            android.view.ViewGroup r12 = (android.view.ViewGroup) r12
            if (r12 == 0) goto L_0x00b0
            java.lang.String r0 = "mbridge_expand_data"
            android.view.View r12 = r11.a(r12, r0)
            if (r12 == 0) goto L_0x00b0
            boolean r0 = r12 instanceof android.widget.TextView
            if (r0 == 0) goto L_0x00b0
            android.widget.TextView r12 = (android.widget.TextView) r12
            java.lang.CharSequence r12 = r12.getText()
            java.lang.String r12 = r12.toString()
            goto L_0x00b2
        L_0x00b0:
            java.lang.String r12 = ""
        L_0x00b2:
            int r0 = r11.n
            java.lang.String r1 = "#666666"
            int r1 = android.graphics.Color.parseColor(r1)
            java.lang.String r2 = "#8FC31F"
            int r2 = android.graphics.Color.parseColor(r2)
            java.lang.String r8 = "#000000"
            int r8 = android.graphics.Color.parseColor(r8)
            android.graphics.drawable.GradientDrawable r9 = new android.graphics.drawable.GradientDrawable
            r9.<init>()
            if (r0 != r4) goto L_0x00d1
            r9.setColor(r2)
            goto L_0x00d7
        L_0x00d1:
            r9.setColor(r8)
            r9.setStroke(r4, r1)
        L_0x00d7:
            r0 = 200(0xc8, float:2.8E-43)
            float r0 = (float) r0
            r9.setCornerRadius(r0)
            r11.setBackground(r9)
            android.widget.TextView r0 = new android.widget.TextView
            android.content.Context r1 = r11.getContext()
            r0.<init>(r1)
            android.widget.RelativeLayout$LayoutParams r1 = new android.widget.RelativeLayout$LayoutParams
            r1.<init>(r7, r7)
            r2 = 15
            r1.addRule(r2)
            r0.setLayoutParams(r1)
            r1 = 17
            r0.setGravity(r1)
            r1 = 1101004800(0x41a00000, float:20.0)
            r0.setTextSize(r1)
            r0.setTextColor(r7)
            java.lang.String r1 = r11.m
            r0.setText(r1)
            android.widget.ImageView r1 = new android.widget.ImageView
            android.content.Context r8 = r11.getContext()
            r1.<init>(r8)
            r11.o = r1
            int r1 = r11.n
            r8 = 11
            java.lang.String r9 = "drawable"
            if (r1 != r4) goto L_0x0158
            android.content.res.Resources r1 = r11.getResources()
            com.mbridge.msdk.foundation.controller.b r3 = com.mbridge.msdk.foundation.controller.b.d()
            java.lang.String r3 = r3.b()
            java.lang.String r4 = "mbridge_splash_btn_go"
            int r6 = r1.getIdentifier(r4, r9, r3)
            android.widget.RelativeLayout$LayoutParams r1 = new android.widget.RelativeLayout$LayoutParams
            android.content.Context r3 = r11.getContext()
            r4 = 1108082688(0x420c0000, float:35.0)
            int r3 = com.mbridge.msdk.foundation.tools.af.b((android.content.Context) r3, (float) r4)
            android.content.Context r5 = r11.getContext()
            int r4 = com.mbridge.msdk.foundation.tools.af.b((android.content.Context) r5, (float) r4)
            r1.<init>(r3, r4)
            r1.addRule(r8)
            r1.addRule(r2)
            android.content.Context r2 = r11.getContext()
            r3 = 1092616192(0x41200000, float:10.0)
            int r2 = com.mbridge.msdk.foundation.tools.af.b((android.content.Context) r2, (float) r3)
            r1.rightMargin = r2
            goto L_0x025c
        L_0x0158:
            r4 = 1112014848(0x42480000, float:50.0)
            if (r1 != r5) goto L_0x01ba
            android.content.res.Resources r1 = r11.getResources()
            com.mbridge.msdk.foundation.controller.b r3 = com.mbridge.msdk.foundation.controller.b.d()
            java.lang.String r3 = r3.b()
            java.lang.String r5 = "mbridge_splash_btn_light"
            int r6 = r1.getIdentifier(r5, r9, r3)
            android.widget.RelativeLayout$LayoutParams r1 = new android.widget.RelativeLayout$LayoutParams
            r3 = -2
            r1.<init>(r3, r7)
            r5 = 20
            r1.leftMargin = r5
            r1.rightMargin = r5
            android.widget.ImageView r5 = new android.widget.ImageView
            android.content.Context r10 = r11.getContext()
            r5.<init>(r10)
            android.widget.RelativeLayout$LayoutParams r10 = new android.widget.RelativeLayout$LayoutParams
            r10.<init>(r3, r7)
            r10.addRule(r8)
            r10.addRule(r2)
            android.content.Context r2 = r11.getContext()
            int r2 = com.mbridge.msdk.foundation.tools.af.b((android.content.Context) r2, (float) r4)
            r10.rightMargin = r2
            android.content.res.Resources r2 = r11.getResources()
            com.mbridge.msdk.foundation.controller.b r3 = com.mbridge.msdk.foundation.controller.b.d()
            java.lang.String r3 = r3.b()
            java.lang.String r4 = "mbridge_splash_btn_arrow_right"
            int r2 = r2.getIdentifier(r4, r9, r3)
            r5.setImageResource(r2)
            android.widget.ImageView$ScaleType r2 = android.widget.ImageView.ScaleType.CENTER
            r5.setScaleType(r2)
            r5.setLayoutParams(r10)
            r11.addView(r5)
            goto L_0x025c
        L_0x01ba:
            if (r1 != r3) goto L_0x025b
            android.content.res.Resources r1 = r11.getResources()
            com.mbridge.msdk.foundation.controller.b r2 = com.mbridge.msdk.foundation.controller.b.d()
            java.lang.String r2 = r2.b()
            java.lang.String r3 = "mbridge_splash_btn_finger"
            int r6 = r1.getIdentifier(r3, r9, r2)
            android.widget.RelativeLayout$LayoutParams r1 = new android.widget.RelativeLayout$LayoutParams
            android.content.Context r2 = r11.getContext()
            r3 = 1103626240(0x41c80000, float:25.0)
            int r2 = com.mbridge.msdk.foundation.tools.af.b((android.content.Context) r2, (float) r3)
            android.content.Context r5 = r11.getContext()
            int r3 = com.mbridge.msdk.foundation.tools.af.b((android.content.Context) r5, (float) r3)
            r1.<init>(r2, r3)
            r1.addRule(r8)
            android.content.Context r2 = r11.getContext()
            int r2 = com.mbridge.msdk.foundation.tools.af.b((android.content.Context) r2, (float) r4)
            r1.rightMargin = r2
            android.content.Context r2 = r11.getContext()
            r3 = 1099956224(0x41900000, float:18.0)
            int r2 = com.mbridge.msdk.foundation.tools.af.b((android.content.Context) r2, (float) r3)
            r1.topMargin = r2
            android.widget.ImageView r2 = new android.widget.ImageView
            android.content.Context r3 = r11.getContext()
            r2.<init>(r3)
            r11.p = r2
            android.widget.RelativeLayout$LayoutParams r2 = new android.widget.RelativeLayout$LayoutParams
            android.content.Context r3 = r11.getContext()
            r5 = 1106247680(0x41f00000, float:30.0)
            int r3 = com.mbridge.msdk.foundation.tools.af.b((android.content.Context) r3, (float) r5)
            android.content.Context r7 = r11.getContext()
            int r5 = com.mbridge.msdk.foundation.tools.af.b((android.content.Context) r7, (float) r5)
            r2.<init>(r3, r5)
            r2.addRule(r8)
            android.content.Context r3 = r11.getContext()
            int r3 = com.mbridge.msdk.foundation.tools.af.b((android.content.Context) r3, (float) r4)
            r2.rightMargin = r3
            android.content.Context r3 = r11.getContext()
            r4 = 1084227584(0x40a00000, float:5.0)
            int r3 = com.mbridge.msdk.foundation.tools.af.b((android.content.Context) r3, (float) r4)
            r2.topMargin = r3
            android.widget.ImageView r3 = r11.p
            r3.setLayoutParams(r2)
            android.content.res.Resources r2 = r11.getResources()
            com.mbridge.msdk.foundation.controller.b r3 = com.mbridge.msdk.foundation.controller.b.d()
            java.lang.String r3 = r3.b()
            java.lang.String r4 = "mbridge_splash_btn_circle"
            int r2 = r2.getIdentifier(r4, r9, r3)
            android.widget.ImageView r3 = r11.p
            r3.setImageResource(r2)
            android.widget.ImageView r2 = r11.p
            r11.addView(r2)
            goto L_0x025c
        L_0x025b:
            r1 = 0
        L_0x025c:
            android.widget.ImageView r2 = r11.o
            r2.setLayoutParams(r1)
            boolean r1 = android.text.TextUtils.isEmpty(r12)
            if (r1 == 0) goto L_0x026d
            android.widget.ImageView r12 = r11.o
            r12.setImageResource(r6)
            goto L_0x029f
        L_0x026d:
            android.widget.ImageView r1 = r11.o
            if (r1 != 0) goto L_0x0272
            goto L_0x029f
        L_0x0272:
            boolean r2 = android.text.TextUtils.isEmpty(r12)     // Catch:{ Exception -> 0x0290 }
            if (r2 == 0) goto L_0x027b
            r1.setBackgroundResource(r6)     // Catch:{ Exception -> 0x0290 }
        L_0x027b:
            com.mbridge.msdk.foundation.controller.b r2 = com.mbridge.msdk.foundation.controller.b.d()     // Catch:{ Exception -> 0x0290 }
            android.content.Context r2 = r2.g()     // Catch:{ Exception -> 0x0290 }
            com.mbridge.msdk.foundation.same.c.b r2 = com.mbridge.msdk.foundation.same.c.b.a((android.content.Context) r2)     // Catch:{ Exception -> 0x0290 }
            com.mbridge.msdk.dycreator.baseview.MBSplashClickView$4 r3 = new com.mbridge.msdk.dycreator.baseview.MBSplashClickView$4     // Catch:{ Exception -> 0x0290 }
            r3.<init>(r1, r6)     // Catch:{ Exception -> 0x0290 }
            r2.a((java.lang.String) r12, (com.mbridge.msdk.foundation.same.c.c) r3)     // Catch:{ Exception -> 0x0290 }
            goto L_0x029f
        L_0x0290:
            r12 = move-exception
            java.lang.String r2 = "MBSplashClickView"
            java.lang.String r12 = r12.getMessage()
            com.mbridge.msdk.foundation.tools.aa.a((java.lang.String) r2, (java.lang.String) r12)
            if (r1 == 0) goto L_0x029f
            r1.setBackgroundResource(r6)
        L_0x029f:
            r11.addView(r0)
            android.widget.ImageView r12 = r11.o
            r11.addView(r12)
            r11.invalidate()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.dycreator.baseview.MBSplashClickView.initView(java.lang.String):void");
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        this.q.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
    }

    public void draw(Canvas canvas) {
        canvas.saveLayer(this.q, this.s, 31);
        canvas.drawRoundRect(this.q, 200.0f, 200.0f, this.s);
        canvas.saveLayer(this.q, this.r, 31);
        super.draw(canvas);
        canvas.restore();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        int i2 = this.n;
        if (i2 == 2) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f, 1.0f, 0.8f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(500);
            scaleAnimation.setRepeatCount(-1);
            scaleAnimation.setRepeatMode(2);
            this.o.startAnimation(scaleAnimation);
        } else if (i2 == 1) {
            TranslateAnimation translateAnimation = new TranslateAnimation(0, -100.0f, 0, 1000.0f, 0, 0.0f, 0, 0.0f);
            translateAnimation.setDuration(1000);
            translateAnimation.setAnimationListener(new Animation.AnimationListener() {
                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                    MBSplashClickView.this.o.setVisibility(0);
                }

                public void onAnimationEnd(final Animation animation) {
                    MBSplashClickView.this.o.setVisibility(4);
                    MBSplashClickView.this.o.postDelayed(new Runnable() {
                        public void run() {
                            MBSplashClickView.this.o.startAnimation(animation);
                        }
                    }, 2000);
                }
            });
            this.o.startAnimation(translateAnimation);
        } else if (i2 == 3) {
            ScaleAnimation scaleAnimation2 = new ScaleAnimation(1.0f, 0.7f, 1.0f, 0.7f, 1, 0.5f, 1, 0.5f);
            scaleAnimation2.setDuration(1000);
            scaleAnimation2.setRepeatCount(-1);
            scaleAnimation2.setRepeatMode(2);
            final ScaleAnimation scaleAnimation3 = new ScaleAnimation(0.0f, 0.5f, 0.0f, 0.5f, 1, 0.5f, 1, 0.5f);
            scaleAnimation3.setDuration(400);
            scaleAnimation3.setAnimationListener(new Animation.AnimationListener() {
                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                    MBSplashClickView.this.p.setVisibility(0);
                }

                public void onAnimationEnd(Animation animation) {
                    MBSplashClickView.this.p.setVisibility(4);
                    MBSplashClickView.this.p.postDelayed(new Runnable() {
                        public void run() {
                            MBSplashClickView.this.p.startAnimation(scaleAnimation3);
                        }
                    }, 1600);
                }
            });
            this.p.setVisibility(4);
            this.o.startAnimation(scaleAnimation2);
            this.p.postDelayed(new Runnable() {
                public void run() {
                    MBSplashClickView.this.p.startAnimation(scaleAnimation3);
                }
            }, 800);
        }
    }

    private View a(ViewGroup viewGroup, String str) {
        if (viewGroup != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    if (viewGroup.getId() == str.hashCode()) {
                        return viewGroup;
                    }
                    int childCount = viewGroup.getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = viewGroup.getChildAt(i2);
                        if (childAt.getId() == str.hashCode()) {
                            return childAt;
                        }
                        if (childAt instanceof ViewGroup) {
                            a((ViewGroup) childAt, str);
                        }
                    }
                    return null;
                }
            } catch (Exception e2) {
                aa.d("MBSplashClickView", e2.getMessage());
            }
        }
        return null;
    }
}

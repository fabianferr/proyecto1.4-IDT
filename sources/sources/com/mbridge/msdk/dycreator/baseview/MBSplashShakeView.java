package com.mbridge.msdk.dycreator.baseview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

public class MBSplashShakeView extends MBLinearLayout {
    private final String a = "浏览第三方应用";
    private final String b = "View";
    private final String c = "打开第三方应用";
    private final String d = "Open";
    private final String e = "下载第三方应用";
    private final String f = "Install";
    private ImageView g;
    private Animation h;

    public MBSplashShakeView(Context context) {
        super(context);
    }

    public MBSplashShakeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MBSplashShakeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0128, code lost:
        if (r0 != false) goto L_0x0149;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void initView(java.lang.String r11) {
        /*
            r10 = this;
            r0 = 1
            r10.setOrientation(r0)
            r10.setGravity(r0)
            android.widget.ImageView r1 = new android.widget.ImageView
            android.content.Context r2 = r10.getContext()
            r1.<init>(r2)
            android.widget.LinearLayout$LayoutParams r2 = new android.widget.LinearLayout$LayoutParams
            android.content.Context r3 = r10.getContext()
            r4 = 1117782016(0x42a00000, float:80.0)
            int r3 = com.mbridge.msdk.foundation.tools.af.b((android.content.Context) r3, (float) r4)
            android.content.Context r5 = r10.getContext()
            int r4 = com.mbridge.msdk.foundation.tools.af.b((android.content.Context) r5, (float) r4)
            r2.<init>(r3, r4)
            r1.setLayoutParams(r2)
            java.lang.String r2 = "#60000000"
            int r2 = android.graphics.Color.parseColor(r2)
            android.graphics.drawable.GradientDrawable r3 = new android.graphics.drawable.GradientDrawable
            r3.<init>()
            r3.setColor(r2)
            r2 = 200(0xc8, float:2.8E-43)
            float r2 = (float) r2
            r3.setCornerRadius(r2)
            r1.setBackground(r3)
            android.widget.ImageView r2 = new android.widget.ImageView
            android.content.Context r3 = r10.getContext()
            r2.<init>(r3)
            r10.g = r2
            android.widget.FrameLayout$LayoutParams r2 = new android.widget.FrameLayout$LayoutParams
            android.content.Context r3 = r10.getContext()
            r4 = 1109393408(0x42200000, float:40.0)
            int r3 = com.mbridge.msdk.foundation.tools.af.b((android.content.Context) r3, (float) r4)
            android.content.Context r5 = r10.getContext()
            int r4 = com.mbridge.msdk.foundation.tools.af.b((android.content.Context) r5, (float) r4)
            r2.<init>(r3, r4)
            r3 = 17
            r2.gravity = r3
            android.widget.ImageView r4 = r10.g
            r4.setLayoutParams(r2)
            android.content.res.Resources r2 = r10.getResources()
            com.mbridge.msdk.foundation.controller.b r4 = com.mbridge.msdk.foundation.controller.b.d()
            java.lang.String r4 = r4.b()
            java.lang.String r5 = "mbridge_cm_btn_shake"
            java.lang.String r6 = "drawable"
            int r2 = r2.getIdentifier(r5, r6, r4)
            android.widget.ImageView r4 = r10.g
            r4.setImageResource(r2)
            android.widget.FrameLayout r2 = new android.widget.FrameLayout
            android.content.Context r4 = r10.getContext()
            r2.<init>(r4)
            android.widget.LinearLayout$LayoutParams r4 = new android.widget.LinearLayout$LayoutParams
            r5 = -2
            r4.<init>(r5, r5)
            r2.setLayoutParams(r4)
            r2.addView(r1)
            android.widget.ImageView r1 = r10.g
            r2.addView(r1)
            android.widget.TextView r1 = new android.widget.TextView
            android.content.Context r4 = r10.getContext()
            r1.<init>(r4)
            android.widget.LinearLayout$LayoutParams r4 = new android.widget.LinearLayout$LayoutParams
            r4.<init>(r5, r5)
            android.content.Context r6 = r10.getContext()
            r7 = 1092616192(0x41200000, float:10.0)
            int r6 = com.mbridge.msdk.foundation.tools.af.b((android.content.Context) r6, (float) r7)
            r4.topMargin = r6
            r1.setLayoutParams(r4)
            r1.setGravity(r3)
            java.lang.String r4 = "Shake your phone"
            r1.setText(r4)
            r4 = 1098907648(0x41800000, float:16.0)
            r1.setTextSize(r4)
            r4 = -1
            r1.setTextColor(r4)
            boolean r6 = android.text.TextUtils.isEmpty(r11)
            java.lang.String r7 = "浏览第三方应用"
            java.lang.String r8 = "View"
            if (r6 != 0) goto L_0x012b
            r11.hashCode()
            int r6 = r11.hashCode()
            r9 = 0
            switch(r6) {
                case -672744069: goto L_0x011a;
                case 2464362: goto L_0x010f;
                case 2666181: goto L_0x0106;
                case 855294846: goto L_0x00fa;
                case 1383132195: goto L_0x00ee;
                case 1681333335: goto L_0x00e5;
                default: goto L_0x00e3;
            }
        L_0x00e3:
            r6 = -1
            goto L_0x0124
        L_0x00e5:
            boolean r6 = r11.equals(r7)
            if (r6 != 0) goto L_0x00ec
            goto L_0x00e3
        L_0x00ec:
            r6 = 5
            goto L_0x0124
        L_0x00ee:
            java.lang.String r6 = "打开第三方应用"
            boolean r6 = r11.equals(r6)
            if (r6 != 0) goto L_0x00f8
            goto L_0x00e3
        L_0x00f8:
            r6 = 4
            goto L_0x0124
        L_0x00fa:
            java.lang.String r6 = "下载第三方应用"
            boolean r6 = r11.equals(r6)
            if (r6 != 0) goto L_0x0104
            goto L_0x00e3
        L_0x0104:
            r6 = 3
            goto L_0x0124
        L_0x0106:
            boolean r6 = r11.equals(r8)
            if (r6 != 0) goto L_0x010d
            goto L_0x00e3
        L_0x010d:
            r6 = 2
            goto L_0x0124
        L_0x010f:
            java.lang.String r6 = "Open"
            boolean r6 = r11.equals(r6)
            if (r6 != 0) goto L_0x0118
            goto L_0x00e3
        L_0x0118:
            r6 = 1
            goto L_0x0124
        L_0x011a:
            java.lang.String r6 = "Install"
            boolean r6 = r11.equals(r6)
            if (r6 != 0) goto L_0x0123
            goto L_0x00e3
        L_0x0123:
            r6 = 0
        L_0x0124:
            switch(r6) {
                case 0: goto L_0x0128;
                case 1: goto L_0x0128;
                case 2: goto L_0x0128;
                case 3: goto L_0x0128;
                case 4: goto L_0x0128;
                case 5: goto L_0x0128;
                default: goto L_0x0127;
            }
        L_0x0127:
            r0 = 0
        L_0x0128:
            if (r0 == 0) goto L_0x012b
            goto L_0x0149
        L_0x012b:
            android.content.Context r11 = r10.getContext()
            android.content.res.Resources r11 = r11.getResources()
            android.content.res.Configuration r11 = r11.getConfiguration()
            java.util.Locale r11 = r11.locale
            java.lang.String r11 = r11.getLanguage()
            java.lang.String r0 = "zh"
            boolean r11 = r11.contains(r0)
            if (r11 == 0) goto L_0x0148
            r11 = r7
            goto L_0x0149
        L_0x0148:
            r11 = r8
        L_0x0149:
            android.widget.TextView r0 = new android.widget.TextView
            android.content.Context r6 = r10.getContext()
            r0.<init>(r6)
            android.widget.LinearLayout$LayoutParams r6 = new android.widget.LinearLayout$LayoutParams
            r6.<init>(r5, r5)
            android.content.Context r5 = r10.getContext()
            r7 = 1084227584(0x40a00000, float:5.0)
            int r5 = com.mbridge.msdk.foundation.tools.af.b((android.content.Context) r5, (float) r7)
            r6.topMargin = r5
            r0.setLayoutParams(r6)
            r0.setGravity(r3)
            r0.setText(r11)
            r11 = 1094713344(0x41400000, float:12.0)
            r0.setTextSize(r11)
            r0.setTextColor(r4)
            r10.addView(r2)
            r10.addView(r1)
            r10.addView(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.dycreator.baseview.MBSplashShakeView.initView(java.lang.String):void");
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.g != null) {
            RotateAnimation rotateAnimation = new RotateAnimation(-10.0f, 10.0f, 1, 0.5f, 1, 0.5f);
            this.h = rotateAnimation;
            rotateAnimation.setDuration(100);
            this.h.setRepeatMode(2);
            this.h.setRepeatCount(-1);
            this.g.startAnimation(this.h);
        }
    }
}

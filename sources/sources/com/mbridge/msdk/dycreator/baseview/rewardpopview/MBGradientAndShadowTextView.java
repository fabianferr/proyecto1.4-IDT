package com.mbridge.msdk.dycreator.baseview.rewardpopview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class MBGradientAndShadowTextView extends TextView {
    private int a = AcquireRewardPopViewConst.DEFAULT_COLOR_FFFBED;
    private int b = AcquireRewardPopViewConst.DEFAULT_COLOR_FFBD6F;
    private int c = AcquireRewardPopViewConst.DEFAULT_COLOR_EC7501;
    private int d = 40;
    private LinearGradient e;
    public float mShadowDx = 1.5f;
    public float mShadowDy = 1.8f;
    public float mShadowRadius = 3.0f;

    public static class GradientAndShadowParameters {
        public int gradientEndColor;
        public int gradientStartColor;
        public int shadowColor;
        public float shadowDx = 1.5f;
        public float shadowDy = 1.8f;
        public float shadowRadius = 3.0f;
        public int textSize = 40;
    }

    public MBGradientAndShadowTextView(Context context) {
        super(context);
        a();
    }

    public MBGradientAndShadowTextView(Context context, GradientAndShadowParameters gradientAndShadowParameters) {
        super(context);
        if (gradientAndShadowParameters != null) {
            this.a = gradientAndShadowParameters.gradientStartColor;
            this.b = gradientAndShadowParameters.gradientEndColor;
            this.c = gradientAndShadowParameters.shadowColor;
            this.d = gradientAndShadowParameters.textSize;
            this.mShadowRadius = gradientAndShadowParameters.shadowRadius;
            this.mShadowDx = gradientAndShadowParameters.shadowDx;
            this.mShadowDy = gradientAndShadowParameters.shadowDy;
        }
        a();
    }

    public MBGradientAndShadowTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MBGradientAndShadowTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public MBGradientAndShadowTextView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    private void a() {
        setTextSize((float) this.d);
        setTypeface(Typeface.defaultFromStyle(3));
        this.e = new LinearGradient(0.0f, 0.0f, 0.0f, getTextSize(), this.a, this.b, Shader.TileMode.CLAMP);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        getPaint().setShader((Shader) null);
        getPaint().setShadowLayer(3.0f, 1.5f, 1.8f, this.c);
        super.onDraw(canvas);
        getPaint().clearShadowLayer();
        getPaint().setShader(this.e);
        super.onDraw(canvas);
    }
}

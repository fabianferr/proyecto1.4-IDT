package com.bytedance.sdk.openadsdk.layout;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.s;
import com.bytedance.sdk.openadsdk.core.customview.PAGFrameLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGImageView;
import com.bytedance.sdk.openadsdk.core.customview.PAGTextView;
import com.bytedance.sdk.openadsdk.core.widget.TTBackUpAdImageView;
import com.bytedance.sdk.openadsdk.core.widget.TTRoundRectImageView;

public abstract class TTInteractionStyleBaseFrameLayout extends PAGFrameLayout {
    protected PAGFrameLayout a;
    protected PAGImageView b;
    protected TTRoundRectImageView c;
    protected PAGTextView d;
    protected PAGTextView e;
    protected PAGTextView f;

    /* access modifiers changed from: protected */
    public abstract void a(Context context);

    public TTInteractionStyleBaseFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    public FrameLayout getTtAdContainer() {
        return this.a;
    }

    public ImageView getTtFullImg() {
        return this.b;
    }

    public TTRoundRectImageView getTtFullAdIcon() {
        return this.c;
    }

    public TextView getTtFullAdAppName() {
        return this.d;
    }

    public TextView getTtFullAdDesc() {
        return this.e;
    }

    public TextView getTtFullAdDownload() {
        return this.f;
    }

    /* access modifiers changed from: protected */
    public PAGFrameLayout e(Context context) {
        return new PAGFrameLayout(context);
    }

    /* access modifiers changed from: protected */
    public PAGImageView f(Context context) {
        PAGImageView pAGImageView = new PAGImageView(context);
        pAGImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        return pAGImageView;
    }

    /* access modifiers changed from: protected */
    public TTRoundRectImageView g(Context context) {
        TTRoundRectImageView tTRoundRectImageView = new TTRoundRectImageView(context);
        tTRoundRectImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        tTRoundRectImageView.setBackgroundColor(0);
        return tTRoundRectImageView;
    }

    /* access modifiers changed from: protected */
    public PAGTextView b(Context context) {
        PAGTextView pAGTextView = new PAGTextView(context);
        pAGTextView.setEllipsize(TextUtils.TruncateAt.END);
        pAGTextView.setMaxLines(1);
        pAGTextView.setTextColor(Color.parseColor("#FF999999"));
        pAGTextView.setTextSize(2, 16.0f);
        return pAGTextView;
    }

    /* access modifiers changed from: protected */
    public PAGTextView c(Context context) {
        PAGTextView pAGTextView = new PAGTextView(context);
        pAGTextView.setEllipsize(TextUtils.TruncateAt.END);
        pAGTextView.setMaxLines(1);
        pAGTextView.setSingleLine();
        pAGTextView.setTextColor(Color.parseColor("#FF999999"));
        pAGTextView.setTextSize(2, 12.0f);
        return pAGTextView;
    }

    /* access modifiers changed from: protected */
    public PAGTextView d(Context context) {
        PAGTextView pAGTextView = new PAGTextView(context);
        pAGTextView.setBackgroundResource(s.d(context, "tt_backup_btn_1"));
        pAGTextView.setGravity(17);
        pAGTextView.setText(s.b(context, "tt_video_download_apk"));
        pAGTextView.setTextColor(-1);
        pAGTextView.setTextSize(2, 14.0f);
        return pAGTextView;
    }

    /* access modifiers changed from: protected */
    public TTBackUpAdImageView h(Context context) {
        return new TTBackUpAdImageView(context);
    }
}

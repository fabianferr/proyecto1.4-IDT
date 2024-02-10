package com.mbridge.msdk.video.module;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import androidx.exifinterface.media.ExifInterface;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.m;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.video.signal.factory.b;
import com.mbridge.msdk.videocommon.download.g;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class MBridgeClickMiniCardView extends MBridgeH5EndCardView {
    private boolean y = false;

    public MBridgeClickMiniCardView(Context context) {
        super(context);
    }

    public MBridgeClickMiniCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onSelfConfigurationChanged(Configuration configuration) {
        if (this.f) {
            a(this.n);
        }
        super.onSelfConfigurationChanged(configuration);
    }

    /* access modifiers changed from: protected */
    public final RelativeLayout.LayoutParams b() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13, -1);
        return layoutParams;
    }

    /* access modifiers changed from: protected */
    public final void e() {
        super.e();
        if (this.f) {
            setBackgroundResource(findColor("mbridge_reward_minicard_bg"));
            a(this.n);
            setClickable(true);
        }
    }

    /* access modifiers changed from: protected */
    public final String a() {
        String str = null;
        if (this.b == null) {
            return null;
        }
        CampaignEx.c rewardTemplateMode = this.b.getRewardTemplateMode();
        if (rewardTemplateMode != null) {
            str = rewardTemplateMode.d();
        }
        if (TextUtils.isEmpty(str) || !str.contains(".zip")) {
            return str;
        }
        String b = g.a().b(str);
        return !TextUtils.isEmpty(b) ? b : str;
    }

    public void preLoadData(b bVar) {
        super.preLoadData(bVar);
        setCloseVisible(0);
    }

    public void webviewshow() {
        if (this.q != null) {
            this.q.post(new Runnable() {
                public final void run() {
                    try {
                        aa.a(MBridgeBaseView.TAG, "webviewshow");
                        String str = "";
                        try {
                            int[] iArr = new int[2];
                            MBridgeClickMiniCardView.this.q.getLocationOnScreen(iArr);
                            aa.d(MBridgeBaseView.TAG, "coordinate:" + iArr[0] + "--" + iArr[1]);
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("startX", af.a(com.mbridge.msdk.foundation.controller.b.d().g(), (float) iArr[0]));
                            jSONObject.put("startY", af.a(com.mbridge.msdk.foundation.controller.b.d().g(), (float) iArr[1]));
                            str = jSONObject.toString();
                        } catch (Throwable th) {
                            aa.b(MBridgeBaseView.TAG, th.getMessage(), th);
                        }
                        com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) MBridgeClickMiniCardView.this.q, "webviewshow", Base64.encodeToString(str.toString().getBytes(), 2));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            HashMap hashMap = new HashMap();
            hashMap.put("type", ExifInterface.GPS_MEASUREMENT_3D);
            m.a().a("2000133", this.b, (Map<String, String>) hashMap);
        }
    }

    private void a(View view) {
        int i = af.i(this.a);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = (int) ((((float) i) * 0.7f) + 0.5f);
        layoutParams.height = (int) ((((float) af.h(this.a)) * 0.7f) + 0.5f);
        view.setLayoutParams(layoutParams);
    }

    public void setMBridgeClickMiniCardViewTransparent() {
        setBackgroundColor(0);
    }

    public void setMBridgeClickMiniCardViewClickable(boolean z) {
        setClickable(z);
    }

    public void setMiniCardLocation(int i, int i2, int i3, int i4) {
        this.y = true;
        resizeMiniCard(i3, i4);
    }

    public void resizeMiniCard(int i, int i2) {
        View findViewById = ((Activity) this.a).getWindow().findViewById(16908290);
        int width = findViewById.getWidth();
        int height = findViewById.getHeight();
        if (i > 0 && i2 > 0 && i <= width && i2 <= height) {
            ViewGroup.LayoutParams layoutParams = this.n.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.n.setLayoutParams(layoutParams);
        }
    }

    public void setRadius(int i) {
        if (i > 0) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius((float) af.b(getContext(), (float) i));
            gradientDrawable.setColor(-1);
            this.q.setBackground(gradientDrawable);
            if (Build.VERSION.SDK_INT >= 21) {
                this.q.setClipToOutline(true);
            }
        }
    }
}

package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.core.customview.PAGFrameLayout;
import com.bytedance.sdk.openadsdk.core.model.m;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.utils.ad;

public class FullRewardExpressBackupView extends BackupView {
    private FrameLayout a;
    private NativeExpressView m;
    private FrameLayout n;

    public FullRewardExpressBackupView(Context context) {
        super(context);
        this.b = context;
    }

    public void a(q qVar, NativeExpressView nativeExpressView) {
        l.b("FullRewardExpressBackupView", "show backup view");
        if (qVar != null) {
            setBackgroundColor(-1);
            this.c = qVar;
            this.m = nativeExpressView;
            if (qVar.aS() == 7) {
                this.f = "rewarded_video";
            } else {
                this.f = "fullscreen_interstitial_ad";
            }
            b();
            this.m.addView(this, new ViewGroup.LayoutParams(-2, -2));
        }
    }

    private void b() {
        this.g = ad.b(this.b, (float) this.m.getExpectExpressWidth());
        this.h = ad.b(this.b, (float) this.m.getExpectExpressWidth());
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(this.g, this.h);
        }
        layoutParams.width = this.g;
        layoutParams.height = this.h;
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = 17;
        }
        setLayoutParams(layoutParams);
        this.c.B();
        c();
    }

    private void c() {
        PAGFrameLayout pAGFrameLayout = new PAGFrameLayout(this.b);
        this.a = pAGFrameLayout;
        addView(pAGFrameLayout, new FrameLayout.LayoutParams(-1, -1));
        PAGFrameLayout pAGFrameLayout2 = new PAGFrameLayout(this.b);
        this.n = pAGFrameLayout2;
        this.a.addView(pAGFrameLayout2, new FrameLayout.LayoutParams(-1, -1));
        this.n.removeAllViews();
    }

    public FrameLayout getVideoContainer() {
        return this.n;
    }

    /* access modifiers changed from: protected */
    public void a(View view, int i, m mVar) {
        NativeExpressView nativeExpressView = this.m;
        if (nativeExpressView != null) {
            nativeExpressView.a(view, i, mVar);
        }
    }

    public View getBackupContainerBackgroundView() {
        return this.a;
    }
}

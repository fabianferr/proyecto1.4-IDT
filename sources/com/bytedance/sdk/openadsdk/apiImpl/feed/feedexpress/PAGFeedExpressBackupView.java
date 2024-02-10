package com.bytedance.sdk.openadsdk.apiImpl.feed.feedexpress;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.apiImpl.feed.a;
import com.bytedance.sdk.openadsdk.core.model.m;
import com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;

public class PAGFeedExpressBackupView extends BackupView {
    private NativeExpressView a;
    private a m;

    public PAGFeedExpressBackupView(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void a(View view, int i, m mVar) {
        NativeExpressView nativeExpressView = this.a;
        if (nativeExpressView != null) {
            nativeExpressView.a(view, i, mVar);
        }
    }

    public void a(NativeExpressView nativeExpressView) {
        this.a = nativeExpressView;
        nativeExpressView.addView(this, new FrameLayout.LayoutParams(-1, -1));
    }

    public void setExtraFuncationHelper(a aVar) {
        this.m = aVar;
    }
}

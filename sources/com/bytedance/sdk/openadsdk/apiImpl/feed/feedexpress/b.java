package com.bytedance.sdk.openadsdk.apiImpl.feed.feedexpress;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.component.adexpress.b.c;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdWrapperListener;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGMediaView;
import com.bytedance.sdk.openadsdk.apiImpl.feed.h;
import com.bytedance.sdk.openadsdk.core.b.a;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressVideoView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.utils.ad;

/* compiled from: PAGFeedExpressView */
public class b extends h {
    protected final Context h;
    protected AdSlot i;
    protected NativeExpressView j;
    protected String k = "embeded_ad";
    /* access modifiers changed from: private */
    public boolean l = false;

    public b(Context context, q qVar, AdSlot adSlot) {
        super(context, qVar, 5, true);
        this.b.h(1);
        this.d.a(this);
        this.h = context;
        this.i = adSlot;
        a();
        b();
    }

    /* access modifiers changed from: protected */
    public void a() {
        this.j = new NativeExpressView(this.h, this.b, this.i, this.k);
        c();
    }

    private void b() {
        NativeExpressView nativeExpressView = this.j;
        if (nativeExpressView != null) {
            nativeExpressView.setBackupListener(new c() {
                public boolean a(ViewGroup viewGroup, int i) {
                    PAGFeedExpressBackupView pAGFeedExpressBackupView = new PAGFeedExpressBackupView(b.this.j.getContext());
                    pAGFeedExpressBackupView.setExtraFuncationHelper(b.this.d);
                    pAGFeedExpressBackupView.a(b.this.j);
                    return true;
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void c() {
        NativeExpressView nativeExpressView = this.j;
        if (nativeExpressView != null) {
            nativeExpressView.setExpressInteractionListener(new PAGBannerAdWrapperListener() {
                public void onAdClicked(View view, int i) {
                }

                public void onAdDismissed() {
                }

                public void onAdShow(View view, int i) {
                }

                public void onRenderFail(View view, String str, int i) {
                }

                public void onRenderSuccess(View view, float f, float f2) {
                    if (b.this.j.n()) {
                        com.bytedance.sdk.openadsdk.apiImpl.feed.b bVar = new com.bytedance.sdk.openadsdk.apiImpl.feed.b(b.this.h, b.this.b, 5, b.this.i, b.this.d, b.this.a);
                        b bVar2 = b.this;
                        if (bVar2 instanceof a) {
                            bVar.a(((NativeExpressVideoView) bVar2.d()).getVideoAdListener());
                        }
                        b.this.d.a((a) b.this.j.getClickCreativeListener());
                        PAGMediaView i = b.this.d.i();
                        if (i == null) {
                            i = new PAGMediaView(b.this.h);
                        }
                        b.this.j.addView(i);
                        return;
                    }
                    b.this.a(f, f2);
                    if (b.this.l) {
                        b.this.j.i();
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void a(float f, float f2) {
        int b = ad.b(this.h, f);
        int b2 = ad.b(this.h, f2);
        ViewGroup.LayoutParams layoutParams = this.j.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(b, b2);
        }
        layoutParams.width = b;
        layoutParams.height = b2;
        this.j.setLayoutParams(layoutParams);
    }

    public NativeExpressView d() {
        return this.j;
    }

    public void a(boolean z) {
        this.l = z;
    }

    public void e() {
        NativeExpressView nativeExpressView = this.j;
        if (nativeExpressView != null) {
            nativeExpressView.j();
        }
    }
}

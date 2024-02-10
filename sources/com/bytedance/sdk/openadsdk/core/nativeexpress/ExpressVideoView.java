package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.view.View;
import com.bykv.vk.openvk.component.video.api.d.b;
import com.bytedance.sdk.openadsdk.b.g;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.k.c;
import com.bytedance.sdk.openadsdk.utils.ad;

public class ExpressVideoView extends NativeVideoTsView implements View.OnClickListener {
    private boolean p = false;

    /* access modifiers changed from: protected */
    public void a(boolean z) {
    }

    public ExpressVideoView(Context context, q qVar, String str, g gVar) {
        super(context, qVar, false, str, false, false, gVar);
        setOnClickListener(this);
        setNeedNativeVideoPlayBtnVisible(false);
    }

    /* access modifiers changed from: protected */
    public void b() {
        if (!this.e || !p.b(this.l)) {
            this.d = false;
        }
        super.b();
    }

    /* access modifiers changed from: protected */
    public void c() {
        if (this.p) {
            super.c();
        }
    }

    public void setCanInterruptVideoPlay(boolean z) {
        this.p = z;
    }

    public void setShouldCheckNetChange(boolean z) {
        if (this.b != null) {
            this.b.e(z);
        }
    }

    public void d() {
        if (this.j != null) {
            ad.a((View) this.j, 8);
        }
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i) {
        if (this.i == null || this.i.getVisibility() != 0) {
            super.onWindowVisibilityChanged(i);
        } else {
            r();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        if (this.i == null || this.i.getVisibility() != 0) {
            super.onWindowFocusChanged(z);
        } else {
            r();
        }
    }

    private void q() {
        ad.a((View) this.g, 0);
        ad.a((View) this.h, 0);
        ad.a((View) this.j, 8);
    }

    private void r() {
        g();
        if (this.g != null) {
            if (this.g.getVisibility() != 0) {
                c.a().a(this.a.K().j(), this.a.K().c(), this.a.K().b(), this.h, this.a);
            } else {
                return;
            }
        }
        q();
    }

    public void onClick(View view) {
        if (this.i != null && this.i.getVisibility() == 0) {
            ad.e((View) this.g);
        }
        c();
    }

    public void setShowAdInteractionView(boolean z) {
        b m;
        if (this.b != null && (m = this.b.m()) != null) {
            m.a(z);
        }
    }

    /* access modifiers changed from: protected */
    public void e() {
        g();
        ad.a((View) this.g, 0);
    }
}

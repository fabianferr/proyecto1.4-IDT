package com.bytedance.sdk.openadsdk.component.reward.a;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.common.TTAdDislikeDialog;
import com.bytedance.sdk.openadsdk.common.TTAdDislikeToast;
import com.bytedance.sdk.openadsdk.component.reward.b.b;

/* compiled from: RewardFullDislikeManager */
public class c {
    /* access modifiers changed from: private */
    public final a a;
    private TTAdDislikeDialog b;
    private TTAdDislikeToast c;

    public c(a aVar) {
        this.a = aVar;
    }

    public void a(b bVar) {
        if (!this.a.V.isFinishing()) {
            if (this.a.w.get()) {
                this.c.a(TTAdDislikeToast.getDislikeTip());
                return;
            }
            b(bVar);
            this.b.a();
        }
    }

    public void a() {
        TTAdDislikeToast tTAdDislikeToast = this.c;
        if (tTAdDislikeToast != null) {
            tTAdDislikeToast.b();
        }
    }

    public void b() {
        TTAdDislikeToast tTAdDislikeToast = this.c;
        if (tTAdDislikeToast != null) {
            tTAdDislikeToast.c();
        }
    }

    private void b(final b bVar) {
        if (this.b == null) {
            TTAdDislikeDialog tTAdDislikeDialog = new TTAdDislikeDialog((Context) this.a.V, this.a.a);
            this.b = tTAdDislikeDialog;
            tTAdDislikeDialog.setCallback(new TTAdDislikeDialog.a() {
                public void c(View view) {
                }

                public void a(View view) {
                    c.this.a.v.set(true);
                    bVar.q();
                    if (c.this.a.G.b()) {
                        c.this.a.G.o();
                    }
                }

                public void b(View view) {
                    c.this.a.v.set(false);
                    c.this.a.G.a(bVar);
                    if (c.this.a.G.d()) {
                        c.this.a.G.n();
                    }
                }

                public void a(int i, FilterWord filterWord) {
                    if (!c.this.a.w.get() && filterWord != null && !filterWord.hasSecondOptions()) {
                        c.this.a.w.set(true);
                        c.this.c();
                    }
                }
            });
            ((FrameLayout) this.a.V.findViewById(16908290)).addView(this.b);
        }
        if (this.c == null) {
            this.c = new TTAdDislikeToast(this.a.V);
            ((FrameLayout) this.a.V.findViewById(16908290)).addView(this.c);
        }
    }

    /* access modifiers changed from: private */
    public void c() {
        this.c.a(TTAdDislikeToast.getDislikeSendTip());
    }
}

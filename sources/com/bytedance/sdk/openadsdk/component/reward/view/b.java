package com.bytedance.sdk.openadsdk.component.reward.view;

import android.view.View;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.component.reward.a.a;
import com.bytedance.sdk.openadsdk.component.reward.a.n;
import com.bytedance.sdk.openadsdk.core.b.e;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.i;

/* compiled from: RewardFullBackUpEndCard */
public class b {
    private final a a;
    private RFEndCardBackUpLayout b;
    private boolean c;
    private n d;

    public b(a aVar) {
        this.a = aVar;
    }

    public void a() {
        if (!this.c) {
            this.c = true;
            RFEndCardBackUpLayout rFEndCardBackUpLayout = (RFEndCardBackUpLayout) this.a.U.findViewById(i.ap);
            this.b = rFEndCardBackUpLayout;
            rFEndCardBackUpLayout.a(this.a);
            if (this.a.a.at()) {
                this.d = new n(this.a);
            }
        }
    }

    public void a(e eVar) {
        ad.a((View) this.b, (View.OnClickListener) new View.OnClickListener() {
            public void onClick(View view) {
            }
        }, "TTBaseVideoActivity#mFLEndCardBackupContainer");
        n nVar = this.d;
        if (nVar != null) {
            nVar.a(eVar);
        }
    }

    public void b() {
        l.b("TTAD.RFBackUpEndCard", "show: ");
        ad.a((View) this.b, 0);
    }

    public boolean a(com.bytedance.sdk.openadsdk.component.reward.a.l lVar) {
        n nVar = this.d;
        if (nVar == null || !nVar.a(lVar)) {
            return false;
        }
        ad.a((View) this.b, 0);
        return true;
    }

    public void c() {
        n nVar = this.d;
        if (nVar != null) {
            nVar.a();
        }
    }

    public void d() {
        n nVar = this.d;
        if (nVar != null) {
            nVar.b();
        }
    }

    public boolean e() {
        n nVar = this.d;
        if (nVar != null) {
            return nVar.c();
        }
        return false;
    }
}

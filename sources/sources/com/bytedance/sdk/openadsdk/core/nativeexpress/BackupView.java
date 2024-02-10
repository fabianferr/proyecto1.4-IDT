package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.activity.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.b.g;
import com.bytedance.sdk.openadsdk.core.b.a;
import com.bytedance.sdk.openadsdk.core.customview.PAGFrameLayout;
import com.bytedance.sdk.openadsdk.core.model.m;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.t;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.dislike.b;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.ad;

public abstract class BackupView extends PAGFrameLayout {
    private g a;
    /* access modifiers changed from: protected */
    public Context b;
    /* access modifiers changed from: protected */
    public q c;
    protected b d;
    protected TTDislikeDialogAbstract e;
    /* access modifiers changed from: protected */
    public String f = "embeded_ad";
    protected int g;
    protected int h;
    protected int i;
    protected boolean j = true;
    protected boolean k = true;
    protected String l;

    /* access modifiers changed from: protected */
    public abstract void a(View view, int i2, m mVar);

    public Object getTag() {
        return "tt_express_backup_fl_tag_26";
    }

    public BackupView(Context context) {
        super(context);
        setTag("tt_express_backup_fl_tag_26");
    }

    public BackupView(Context context, String str) {
        super(context);
        this.l = str;
        setTag("tt_express_backup_fl_tag_26");
    }

    public void setTag(Object obj) {
        super.setTag("tt_express_backup_fl_tag_26");
    }

    public void setDislikeInner(t tVar) {
        if (tVar instanceof b) {
            this.d = (b) tVar;
        }
    }

    public void setDislikeOuter(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        q qVar;
        if (!(tTDislikeDialogAbstract == null || (qVar = this.c) == null)) {
            tTDislikeDialogAbstract.setMaterialMeta(qVar.ac(), this.c.ae());
        }
        this.e = tTDislikeDialogAbstract;
    }

    public void a() {
        TTDislikeDialogAbstract tTDislikeDialogAbstract = this.e;
        if (tTDislikeDialogAbstract != null) {
            tTDislikeDialogAbstract.show();
            return;
        }
        b bVar = this.d;
        if (bVar != null) {
            bVar.a();
        } else {
            TTDelegateActivity.a(this.c, (String) null);
        }
    }

    /* access modifiers changed from: protected */
    public String getNameOrSource() {
        q qVar = this.c;
        if (qVar == null) {
            return "";
        }
        if (qVar.aa() != null && !TextUtils.isEmpty(this.c.aa().b())) {
            return this.c.aa().b();
        }
        if (!TextUtils.isEmpty(this.c.L())) {
            return this.c.L();
        }
        return "";
    }

    /* access modifiers changed from: protected */
    public String getTitle() {
        if (this.c.aa() != null && !TextUtils.isEmpty(this.c.aa().b())) {
            return this.c.aa().b();
        }
        if (!TextUtils.isEmpty(this.c.L())) {
            return this.c.L();
        }
        return !TextUtils.isEmpty(this.c.V()) ? this.c.V() : "";
    }

    /* access modifiers changed from: protected */
    public String getDescription() {
        if (!TextUtils.isEmpty(this.c.V())) {
            return this.c.V();
        }
        return !TextUtils.isEmpty(this.c.W()) ? this.c.W() : "";
    }

    public float getRealWidth() {
        return (float) ad.c(this.b, (float) this.g);
    }

    public float getRealHeight() {
        return (float) ad.c(this.b, (float) this.h);
    }

    /* access modifiers changed from: protected */
    public void a(View view, boolean z) {
        com.bytedance.sdk.openadsdk.core.b.b bVar;
        if (view != null) {
            if (z) {
                Context context = this.b;
                q qVar = this.c;
                String str = this.f;
                bVar = new a(context, qVar, str, ac.a(str));
            } else {
                Context context2 = this.b;
                q qVar2 = this.c;
                String str2 = this.f;
                bVar = new com.bytedance.sdk.openadsdk.core.b.b(context2, qVar2, str2, ac.a(str2));
            }
            view.setOnTouchListener(bVar);
            view.setOnClickListener(bVar);
            bVar.a((a) new a() {
                public void a(View view, int i, m mVar) {
                    BackupView.this.a(view, i, mVar);
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public NativeVideoTsView getVideoView() {
        NativeVideoTsView nativeVideoTsView;
        q qVar = this.c;
        if (!(qVar == null || this.b == null)) {
            if (q.c(qVar)) {
                try {
                    nativeVideoTsView = new NativeVideoTsView(this.b, this.c, this.f, true, false, this.a);
                    nativeVideoTsView.setVideoCacheUrl(this.l);
                    nativeVideoTsView.setControllerStatusCallBack(new NativeVideoTsView.b() {
                        public void a(boolean z, long j, long j2, long j3, boolean z2) {
                        }
                    });
                    nativeVideoTsView.setIsAutoPlay(this.j);
                    nativeVideoTsView.setIsQuiet(this.k);
                } catch (Throwable unused) {
                }
                if (q.c(this.c) || nativeVideoTsView == null || !nativeVideoTsView.a(0, true, false)) {
                    return null;
                }
                return nativeVideoTsView;
            }
            nativeVideoTsView = null;
            if (q.c(this.c)) {
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void a(int i2) {
        this.k = o.d().c(String.valueOf(this.i));
        int b2 = o.d().b(i2);
        if (3 == b2) {
            this.j = false;
            return;
        }
        int c2 = com.bytedance.sdk.component.utils.o.c(o.a());
        if (1 == b2 && ac.d(c2)) {
            this.j = true;
        } else if (2 == b2) {
            if (ac.e(c2) || ac.d(c2) || ac.f(c2)) {
                this.j = true;
            }
        } else if (5 != b2) {
        } else {
            if (ac.d(c2) || ac.f(c2)) {
                this.j = true;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void a(View view) {
        q qVar = this.c;
        if (qVar != null && qVar.K() != null && view != null) {
            boolean z = true;
            if (this.c.w() != 1 || !this.j) {
                z = false;
            }
            a(view, z);
        }
    }
}

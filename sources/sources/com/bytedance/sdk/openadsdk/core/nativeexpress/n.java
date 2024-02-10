package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.view.View;
import com.bytedance.sdk.component.adexpress.b.a;
import com.bytedance.sdk.component.adexpress.b.c;
import com.bytedance.sdk.component.adexpress.b.g;
import com.bytedance.sdk.component.adexpress.b.m;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;
import com.bytedance.sdk.openadsdk.utils.aa;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: NativeRender */
public class n extends a<BackupView> {
    AtomicBoolean a = new AtomicBoolean(false);
    private BackupView b;
    private final View c;
    private c d;
    private g e;
    private final m f;

    public n(View view, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, m mVar) {
        this.c = view;
        this.f = mVar;
    }

    public void a(g gVar) {
        this.e = gVar;
        aa.a((Runnable) new Runnable() {
            public void run() {
                n.this.b();
            }
        });
    }

    /* access modifiers changed from: private */
    public void b() {
        if (!this.a.get()) {
            c cVar = this.d;
            boolean z = false;
            if (cVar != null && cVar.a((NativeExpressView) this.c, 0)) {
                z = true;
            }
            if (!z) {
                this.e.a(107);
                return;
            }
            this.f.e().e();
            BackupView backupView = (BackupView) this.c.findViewWithTag("tt_express_backup_fl_tag_26");
            this.b = backupView;
            if (backupView != null) {
                com.bytedance.sdk.component.adexpress.b.n nVar = new com.bytedance.sdk.component.adexpress.b.n();
                BackupView backupView2 = this.b;
                float f2 = 0.0f;
                float realWidth = backupView2 == null ? 0.0f : backupView2.getRealWidth();
                BackupView backupView3 = this.b;
                if (backupView3 != null) {
                    f2 = backupView3.getRealHeight();
                }
                nVar.a(true);
                nVar.a((double) realWidth);
                nVar.b((double) f2);
                this.e.a(this.b, nVar);
                return;
            }
            this.e.a(107);
        }
    }

    /* renamed from: a */
    public BackupView e() {
        return this.b;
    }

    public void a(c cVar) {
        this.d = cVar;
    }
}

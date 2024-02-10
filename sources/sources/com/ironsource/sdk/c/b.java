package com.ironsource.sdk.c;

import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.ironsource.sdk.utils.Logger;
import org.json.JSONObject;

public final class b extends FrameLayout implements f {
    public d a;

    public b(d dVar, Context context) {
        super(context);
        setLayoutParams(new FrameLayout.LayoutParams(dVar.d.a, dVar.d.b));
        this.a = dVar;
        addView(dVar.b);
    }

    public final WebView a() {
        return this.a.b;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0033, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(final java.lang.String r4, final java.lang.String r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            com.ironsource.sdk.c.d r0 = r3.a     // Catch:{ all -> 0x0034 }
            if (r0 == 0) goto L_0x0032
            com.ironsource.sdk.b.b r0 = r0.c     // Catch:{ all -> 0x0034 }
            if (r0 == 0) goto L_0x0032
            com.ironsource.sdk.c.d r0 = r3.a     // Catch:{ all -> 0x0034 }
            android.webkit.WebView r0 = r0.b     // Catch:{ all -> 0x0034 }
            if (r0 != 0) goto L_0x0010
            goto L_0x0032
        L_0x0010:
            com.ironsource.sdk.c.d r0 = r3.a     // Catch:{ all -> 0x0034 }
            com.ironsource.sdk.b.b r0 = r0.c     // Catch:{ all -> 0x0034 }
            com.ironsource.sdk.b.a r1 = r0.a     // Catch:{ all -> 0x0034 }
            if (r1 == 0) goto L_0x0026
            com.ironsource.sdk.b.d r1 = r0.b     // Catch:{ all -> 0x0034 }
            if (r1 != 0) goto L_0x001d
            goto L_0x0026
        L_0x001d:
            org.json.JSONObject r1 = r0.a()     // Catch:{ all -> 0x0034 }
            java.lang.String r2 = "containerWasRemoved"
            r0.a((java.lang.String) r2, (org.json.JSONObject) r1)     // Catch:{ all -> 0x0034 }
        L_0x0026:
            com.ironsource.environment.thread.a r0 = com.ironsource.environment.thread.a.a     // Catch:{ all -> 0x0034 }
            com.ironsource.sdk.c.b$1 r1 = new com.ironsource.sdk.c.b$1     // Catch:{ all -> 0x0034 }
            r1.<init>(r4, r5)     // Catch:{ all -> 0x0034 }
            r0.a(r1)     // Catch:{ all -> 0x0034 }
            monitor-exit(r3)
            return
        L_0x0032:
            monitor-exit(r3)
            return
        L_0x0034:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.sdk.c.b.a(java.lang.String, java.lang.String):void");
    }

    public final void a(String str, String str2, String str3) {
        d dVar = this.a;
        if (dVar != null) {
            dVar.a(str, str2, str3);
        }
    }

    public final void a(JSONObject jSONObject, String str, String str2) {
        this.a.a(jSONObject, str, str2);
    }

    public final void b(JSONObject jSONObject, String str, String str2) {
        this.a.b(jSONObject, str, str2);
    }

    /* access modifiers changed from: protected */
    public final void onVisibilityChanged(View view, int i) {
        Logger.i("IronSourceAdContainer", "onVisibilityChanged: " + i);
        d dVar = this.a;
        if (dVar != null) {
            try {
                dVar.c.a("isVisible", i, isShown());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void onWindowVisibilityChanged(int i) {
        Logger.i("IronSourceAdContainer", "onWindowVisibilityChanged: " + i);
        d dVar = this.a;
        if (dVar != null) {
            try {
                dVar.c.a("isWindowVisible", i, isShown());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

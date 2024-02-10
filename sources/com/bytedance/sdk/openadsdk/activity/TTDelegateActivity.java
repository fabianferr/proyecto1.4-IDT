package com.bytedance.sdk.openadsdk.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import com.bytedance.sdk.openadsdk.core.bannerexpress.a;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.l;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.t;
import com.bytedance.sdk.openadsdk.multipro.b;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TTDelegateActivity extends TTBaseActivity {
    /* access modifiers changed from: private */
    public static final Map<String, a.C0062a> c = Collections.synchronizedMap(new HashMap());
    private Intent a;
    /* access modifiers changed from: private */
    public t b;

    public static void a(q qVar, String str, a.C0062a aVar) {
        if (qVar != null) {
            Intent intent = new Intent(o.a(), TTDelegateActivity.class);
            intent.addFlags(268435456);
            intent.putExtra("type", 6);
            intent.putExtra("ext_info", qVar.ac());
            intent.putExtra("filter_words", com.bytedance.sdk.openadsdk.tool.a.a(qVar.ae()));
            intent.putExtra("creative_info", qVar.ao().toString());
            intent.putExtra("closed_listener_key", str);
            if (aVar != null) {
                if (b.c()) {
                    h.b().a(str, aVar);
                } else {
                    c.put(str, aVar);
                }
            }
            if (o.a() != null) {
                o.a().startActivity(intent);
            }
        }
    }

    public static void a(q qVar, String str) {
        a(qVar, str, (a.C0062a) null);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!l.e()) {
            finish();
            return;
        }
        b();
        this.a = getIntent();
        if (o.a() == null) {
            o.a(this);
        }
    }

    private void b() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (o.a() == null) {
            o.a(this);
        }
        setIntent(intent);
        this.a = intent;
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        t tVar = this.b;
        if ((tVar == null || ((com.bytedance.sdk.openadsdk.dislike.b) tVar).a == null || !((com.bytedance.sdk.openadsdk.dislike.b) this.b).a.isShowing()) && this.a != null) {
            c();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
    }

    private void c() {
        int intExtra = this.a.getIntExtra("type", 0);
        if (intExtra == 1) {
            return;
        }
        if (intExtra != 6) {
            finish();
            return;
        }
        a(this.a.getStringExtra("ext_info"), this.a.getStringExtra("filter_words"), this.a.getStringExtra("closed_listener_key"), this.a.getStringExtra("creative_info"));
    }

    private void a(String str, String str2, final String str3, String str4) {
        if (!(str2 == null || str == null || this.b != null)) {
            com.bytedance.sdk.openadsdk.dislike.b bVar = new com.bytedance.sdk.openadsdk.dislike.b(this, str, com.bytedance.sdk.openadsdk.tool.a.a(str2), str4);
            this.b = bVar;
            com.bytedance.sdk.openadsdk.dislike.b bVar2 = bVar;
            bVar.a(str3);
            this.b.a(new t.a() {
                public void a(int i, String str) {
                    a.C0062a c;
                    com.bytedance.sdk.component.utils.l.c("showDislike", "closedListenerKey=" + str3 + ",onSelected->position=" + i + ",value=" + str);
                    if (TTDelegateActivity.c != null && TTDelegateActivity.c.size() > 0 && !TextUtils.isEmpty(str3) && !b.c()) {
                        a.C0062a aVar = (a.C0062a) TTDelegateActivity.c.get(str3);
                        if (aVar != null) {
                            aVar.a();
                        }
                    } else if (!TextUtils.isEmpty(str3) && (c = h.b().c(str3)) != null) {
                        c.a();
                        h.b().d(str3);
                    }
                    TTDelegateActivity.this.a(str3);
                    TTDelegateActivity.this.finish();
                }

                public void a() {
                    if (!((com.bytedance.sdk.openadsdk.dislike.b) TTDelegateActivity.this.b).b()) {
                        TTDelegateActivity.this.a(str3);
                        TTDelegateActivity.this.finish();
                    }
                    ((com.bytedance.sdk.openadsdk.dislike.b) TTDelegateActivity.this.b).a(false);
                }
            });
        }
        t tVar = this.b;
        if (tVar != null) {
            tVar.a();
        }
    }

    /* access modifiers changed from: private */
    public void a(String str) {
        com.bytedance.sdk.component.utils.l.c("showDislike", "removeDislikeListener....closedListenerKey=" + str);
        Map<String, a.C0062a> map = c;
        if (map != null && !TextUtils.isEmpty(str)) {
            map.remove(str);
            if (com.bytedance.sdk.component.utils.l.d()) {
                com.bytedance.sdk.component.utils.l.c("showDislike", "removeDislikeListener....mListenerMap.size:" + map.size());
            }
        }
    }
}

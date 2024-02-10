package com.bytedance.sdk.openadsdk.dislike;

import android.app.Activity;
import android.content.Context;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.core.t;
import com.bytedance.sdk.openadsdk.dislike.c;
import com.bytedance.sdk.openadsdk.dislike.e;
import java.util.List;

/* compiled from: TTAdDislikeImpl */
public class b implements t {
    public e a;
    private final Context b;
    /* access modifiers changed from: private */
    public c c;
    private boolean d;
    /* access modifiers changed from: private */
    public t.a e;

    public b(Context context, String str, List<FilterWord> list, String str2) {
        if (!(context instanceof Activity)) {
            l.d("Dislike Initialization must use activity, please pass in TTAdManager.createAdNative(activity)");
        }
        this.b = context;
        a(str, list, str2);
    }

    private void a(String str, List<FilterWord> list, String str2) {
        this.c = new c(this.b, str, list);
        e eVar = new e(this.b);
        this.a = eVar;
        eVar.a(str, str2);
        this.a.a((e.a) new e.a() {
            public void a() {
            }

            public void b() {
            }

            public void c() {
                b.this.a();
            }

            public void d() {
                b.this.a();
            }

            public void a(int i, FilterWord filterWord) {
                if (b.this.e != null) {
                    b.this.e.a(i, filterWord.getName());
                }
                if (b.this.e != null) {
                    b.this.e.a();
                }
            }
        });
        this.c.a((c.a) new c.a() {
            public void a() {
                b.this.a(true);
                if (b.this.c != null && b.this.c.isShowing()) {
                    b.this.c.dismiss();
                }
                b.this.c();
            }

            public void b() {
                l.b("TTAdDislikeImpl", "onDislikeShow: ");
            }

            public void a(int i, FilterWord filterWord) {
                try {
                    if (!filterWord.hasSecondOptions() && b.this.e != null) {
                        b.this.e.a(i, filterWord.getName());
                    }
                    l.e("TTAdDislikeImpl", "onDislikeSelected: " + i + ", " + filterWord.getName());
                } catch (Throwable th) {
                    l.c("TTAdDislikeImpl", "dislike callback selected error: ", th);
                }
            }

            public void c() {
                l.e("TTAdDislikeImpl", "onDislikeDismiss: ");
                try {
                    if (b.this.e != null) {
                        b.this.e.a();
                    }
                } catch (Throwable th) {
                    l.c("TTAdDislikeImpl", "dislike callback cancel error: ", th);
                }
            }

            public void d() {
                l.e("TTAdDislikeImpl", "onDislikeOptionBack: ");
            }
        });
    }

    public void a() {
        Context context = this.b;
        if (((context instanceof Activity) && !((Activity) context).isFinishing()) && !this.c.isShowing()) {
            this.c.show();
        }
    }

    public void a(String str, List<FilterWord> list) {
        this.c.a(str, list);
    }

    public void a(t.a aVar) {
        this.e = aVar;
    }

    public void a(String str) {
        c cVar = this.c;
        if (cVar != null) {
            cVar.a(str);
        }
    }

    public boolean b() {
        return this.d;
    }

    public void a(boolean z) {
        this.d = z;
    }

    /* access modifiers changed from: private */
    public void c() {
        Context context = this.b;
        if ((context instanceof Activity) && (!((Activity) context).isFinishing()) && !this.a.isShowing()) {
            this.a.show();
        }
    }
}

package com.bytedance.sdk.openadsdk.core.g;

import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.webkit.WebView;
import com.bykv.vk.openvk.component.video.a.c.a;
import com.bytedance.sdk.component.utils.h;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.core.o;
import com.facebook.share.internal.ShareConstants;
import com.iab.omid.library.bytedance2.adsession.FriendlyObstructionPurpose;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* compiled from: ViewabilitySessionManager */
public class f {
    final Set<Pair<View, FriendlyObstructionPurpose>> a = new HashSet();
    private g b;

    private f() {
        e.a(o.a());
    }

    private Handler e() {
        return h.b();
    }

    public static f a() {
        return new f();
    }

    public void a(final WebView webView) {
        if (webView != null && this.b == null) {
            if (a.b()) {
                b(webView);
            } else {
                e().post(new Runnable() {
                    public void run() {
                        f.this.b(webView);
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    public void b(WebView webView) {
        try {
            if (this.b == null) {
                this.b = h.a(webView);
            }
        } catch (Throwable th) {
            l.d("createWebViewSession failed : " + th);
            HashMap hashMap = new HashMap();
            hashMap.put("scene", "createWebViewSession");
            hashMap.put(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, th.getMessage());
            e.a((Map<String, String>) hashMap);
        }
    }

    public void a(final View view, final Set<j> set) {
        if (this.b == null) {
            if (view == null || set == null) {
                l.c("video view or view ability Vendors is null");
            } else if (a.b()) {
                b(view, set);
            } else {
                e().post(new Runnable() {
                    public void run() {
                        f.this.b(view, (Set<j>) set);
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    public void b(View view, Set<j> set) {
        try {
            if (this.b == null) {
                this.b = h.a(view, set);
            }
        } catch (Throwable th) {
            l.d("createVideoSession failed : " + th);
            HashMap hashMap = new HashMap();
            hashMap.put("scene", "createVideoSession");
            hashMap.put(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, th.getMessage());
            e.a((Map<String, String>) hashMap);
        }
    }

    public void b() {
        if (a.b()) {
            f();
        } else {
            e().post(new Runnable() {
                public void run() {
                    f.this.f();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void f() {
        if (this.b != null) {
            try {
                a((View) null, (FriendlyObstructionPurpose) null);
                this.b.b();
            } catch (Throwable unused) {
            }
        }
    }

    public void a(final boolean z, final float f) {
        if (a.b()) {
            b(z, f);
        } else {
            e().post(new Runnable() {
                public void run() {
                    f.this.b(z, f);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void b(boolean z, float f) {
        if (this.b != null) {
            try {
                a((View) null, (FriendlyObstructionPurpose) null);
                this.b.a(z, f);
            } catch (Throwable unused) {
            }
        }
    }

    public void c() {
        if (a.b()) {
            g();
        } else {
            e().post(new Runnable() {
                public void run() {
                    f.this.g();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void g() {
        g gVar = this.b;
        if (gVar != null) {
            try {
                gVar.d();
            } catch (Throwable unused) {
            }
        }
    }

    public void d() {
        if (a.b()) {
            h();
        } else {
            e().post(new Runnable() {
                public void run() {
                    f.this.h();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void h() {
        g gVar = this.b;
        if (gVar != null) {
            try {
                gVar.c();
            } catch (Throwable unused) {
            }
        }
    }

    public void a(final View view, final FriendlyObstructionPurpose friendlyObstructionPurpose) {
        if (a.b()) {
            b(view, friendlyObstructionPurpose);
        } else {
            e().post(new Runnable() {
                public void run() {
                    f.this.b(view, friendlyObstructionPurpose);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void b(View view, FriendlyObstructionPurpose friendlyObstructionPurpose) {
        g gVar = this.b;
        if (gVar != null) {
            if (!(view == null || friendlyObstructionPurpose == null)) {
                gVar.a(view, friendlyObstructionPurpose);
            }
            if (this.a.size() > 0) {
                gVar.a(this.a);
                this.a.clear();
            }
        } else if (view != null && friendlyObstructionPurpose != null) {
            try {
                this.a.add(new Pair(view, friendlyObstructionPurpose));
            } catch (Throwable unused) {
            }
        }
    }

    public void a(final long j, final boolean z) {
        if (a.b()) {
            b(j, z);
        } else {
            e().post(new Runnable() {
                public void run() {
                    f.this.b(j, z);
                }
            });
        }
    }

    public void b(long j, boolean z) {
        g gVar = this.b;
        if (gVar != null) {
            try {
                gVar.a(((float) j) / 1000.0f, z);
            } catch (Throwable unused) {
            }
        }
    }

    public void a(final boolean z) {
        if (a.b()) {
            b(z);
        } else {
            e().post(new Runnable() {
                public void run() {
                    f.this.b(z);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void b(boolean z) {
        g gVar = this.b;
        if (gVar != null) {
            try {
                gVar.a(z);
            } catch (Throwable unused) {
            }
        }
    }

    public void a(final int i) {
        if (a.b()) {
            b(i);
        } else {
            e().post(new Runnable() {
                public void run() {
                    f.this.b(i);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void b(int i) {
        g gVar = this.b;
        if (gVar != null) {
            try {
                gVar.b(i);
            } catch (Throwable unused) {
            }
        }
    }
}

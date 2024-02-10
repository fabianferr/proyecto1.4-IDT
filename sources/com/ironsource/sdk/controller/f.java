package com.ironsource.sdk.controller;

import com.ironsource.sdk.a.h;
import com.ironsource.sdk.h.c;
import com.ironsource.sdk.l.d;
import com.ironsource.sdk.utils.IronSourceStorageUtils;
import com.ironsource.sdk.utils.SDKUtils;
import java.util.Map;
import org.json.JSONObject;

final class f {
    long a;
    int b;
    int c;
    b d = b.NONE;
    private String e;
    private String f;
    private d g;

    /* renamed from: com.ironsource.sdk.controller.f$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|(2:1|2)|3|5|6|7|8|10) */
        /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0016 */
        static {
            /*
                int[] r0 = com.ironsource.sdk.controller.f.a.a()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                r1 = 1
                int r2 = com.ironsource.sdk.controller.f.a.a     // Catch:{ NoSuchFieldError -> 0x000f }
                r2 = 0
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                r0 = 2
                int[] r2 = a     // Catch:{ NoSuchFieldError -> 0x0016 }
                int r3 = com.ironsource.sdk.controller.f.a.b     // Catch:{ NoSuchFieldError -> 0x0016 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                int[] r1 = a     // Catch:{ NoSuchFieldError -> 0x001d }
                int r2 = com.ironsource.sdk.controller.f.a.c     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 3
                r1[r0] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ironsource.sdk.controller.f.AnonymousClass2.<clinit>():void");
        }
    }

    public enum a {
        ;
        
        public static final int a = 1;
        public static final int b = 2;
        public static final int c = 3;

        static {
            d = new int[]{1, 2, 3};
        }

        public static int[] a() {
            return (int[]) d.clone();
        }
    }

    public enum b {
        NONE(0),
        PREPARED_CONTROLLER_LOADED(1),
        CONTROLLER_FROM_SERVER(2),
        MISSING_PREPARED_CONTROLLER_LOAD_LAST_USED_CONTROLLER(3),
        FAILED_RENAME_PREPARED_CONTROLLER_LOAD_LAST_USED_CONTROLLER(4),
        FALLBACK_CONTROLLER_RECOVERY(5);
        
        int g;

        private b(int i) {
            this.g = i;
        }
    }

    f(JSONObject jSONObject, String str, String str2, d dVar) {
        int optInt = jSONObject.optInt("controllerSourceStrategy", -1);
        this.b = optInt;
        this.c = optInt != 1 ? optInt != 2 ? a.a : a.c : a.b;
        this.e = str;
        this.f = str2;
        this.g = dVar;
    }

    private void a(c cVar) {
        if (!this.g.b()) {
            this.g.a(cVar, this.f);
        }
    }

    private c g() {
        return new c(this.e, "next_mobileController.html");
    }

    private c h() {
        return new c(this.e, "fallback_mobileController.html");
    }

    private void i() {
        try {
            c d2 = d();
            if (d2.exists()) {
                c h = h();
                if (h.exists()) {
                    h.delete();
                }
                IronSourceStorageUtils.renameFile(d2.getPath(), h.getPath());
            }
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: package-private */
    public void a(b bVar) {
        com.ironsource.sdk.a.a a2 = new com.ironsource.sdk.a.a().a("generalmessage", Integer.valueOf(this.b)).a("controllersource", Integer.valueOf(bVar.g));
        if (this.a > 0) {
            a2.a("timingvalue", Long.valueOf(System.currentTimeMillis() - this.a));
        }
        com.ironsource.sdk.a.f.a(h.v, (Map<String, Object>) a2.a);
    }

    /* access modifiers changed from: package-private */
    public final boolean a() {
        return this.d != b.NONE;
    }

    /* access modifiers changed from: package-private */
    public final boolean b() {
        c cVar;
        int i = AnonymousClass2.a[this.c - 1];
        if (i == 1) {
            IronSourceStorageUtils.deleteFile(d());
            cVar = new c(this.e, SDKUtils.getFileName(this.f));
        } else if (i != 2) {
            if (i == 3) {
                try {
                    c d2 = d();
                    c g2 = g();
                    if (!g2.exists() && !d2.exists()) {
                        a(new c(this.e, SDKUtils.getFileName(this.f)));
                        return false;
                    } else if (g2.exists() || !d2.exists()) {
                        i();
                        if (IronSourceStorageUtils.renameFile(g().getPath(), d().getPath())) {
                            b bVar = b.PREPARED_CONTROLLER_LOADED;
                            this.d = bVar;
                            a(bVar);
                            c();
                            a(new c(this.e, g2.getName()));
                            return true;
                        } else if (e()) {
                            b bVar2 = b.FAILED_RENAME_PREPARED_CONTROLLER_LOAD_LAST_USED_CONTROLLER;
                            this.d = bVar2;
                            a(bVar2);
                            a(new c(this.e, g2.getName()));
                            return true;
                        } else {
                            a(new c(this.e, SDKUtils.getFileName(this.f)));
                        }
                    } else {
                        b bVar3 = b.MISSING_PREPARED_CONTROLLER_LOAD_LAST_USED_CONTROLLER;
                        this.d = bVar3;
                        a(bVar3);
                        a(new c(this.e, g2.getName()));
                        return true;
                    }
                } catch (Exception unused) {
                }
            }
            return false;
        } else {
            i();
            cVar = new c(this.e, SDKUtils.getFileName(this.f));
        }
        a(cVar);
        return false;
    }

    /* access modifiers changed from: package-private */
    public void c() {
        IronSourceStorageUtils.deleteFile(h());
    }

    /* access modifiers changed from: package-private */
    public final c d() {
        return new c(this.e, "mobileController.html");
    }

    /* access modifiers changed from: package-private */
    public boolean e() {
        try {
            if (!h().exists()) {
                return false;
            }
            return IronSourceStorageUtils.renameFile(h().getPath(), d().getPath());
        } catch (Exception unused) {
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public final JSONObject f() {
        return new JSONObject() {
            {
                putOpt("controllerSourceStrategy", Integer.valueOf(f.this.b));
                putOpt("controllerSourceCode", Integer.valueOf(f.this.d.g));
            }
        };
    }
}

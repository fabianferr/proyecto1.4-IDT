package com.bytedance.sdk.component.d.c;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageView;
import com.bytedance.sdk.component.d.g;
import com.bytedance.sdk.component.d.h;
import com.bytedance.sdk.component.d.i;
import com.bytedance.sdk.component.d.j;
import com.bytedance.sdk.component.d.k;
import com.bytedance.sdk.component.d.o;
import com.bytedance.sdk.component.d.s;
import com.bytedance.sdk.component.d.t;
import com.bytedance.sdk.component.d.u;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: ImageRequest */
public class c implements i {
    private int A;
    Future<?> a;
    private String b;
    /* access modifiers changed from: private */
    public String c;
    private String d;
    private o e;
    private ImageView.ScaleType f;
    private Bitmap.Config g;
    private int h;
    private int i;
    /* access modifiers changed from: private */
    public h j;
    /* access modifiers changed from: private */
    public u k;
    /* access modifiers changed from: private */
    public WeakReference<ImageView> l;
    /* access modifiers changed from: private */
    public volatile boolean m;
    private boolean n;
    private boolean o;
    /* access modifiers changed from: private */
    public s p;
    /* access modifiers changed from: private */
    public t q;
    /* access modifiers changed from: private */
    public Queue<com.bytedance.sdk.component.d.d.i> r;
    /* access modifiers changed from: private */
    public final Handler s;
    private boolean t;
    private g u;
    private int v;
    private f w;
    private a x;
    private com.bytedance.sdk.component.d.b y;
    private int z;

    private c(b bVar) {
        t tVar;
        this.r = new LinkedBlockingQueue();
        this.s = new Handler(Looper.getMainLooper());
        this.t = true;
        this.b = bVar.d;
        this.e = new a(bVar.a);
        this.l = new WeakReference<>(bVar.b);
        this.f = bVar.e;
        this.g = bVar.f;
        this.h = bVar.g;
        this.i = bVar.h;
        this.k = bVar.i == null ? u.AUTO : bVar.i;
        if (bVar.j == null) {
            tVar = t.MAIN;
        } else {
            tVar = bVar.j;
        }
        this.q = tVar;
        this.p = bVar.k;
        this.y = a(bVar);
        if (!TextUtils.isEmpty(bVar.c)) {
            b(bVar.c);
            a(bVar.c);
        }
        this.n = bVar.l;
        this.o = bVar.m;
        this.w = bVar.p;
        this.j = bVar.q;
        this.A = bVar.s;
        this.z = bVar.r;
        this.r.add(new com.bytedance.sdk.component.d.d.c());
    }

    private com.bytedance.sdk.component.d.b a(b bVar) {
        if (bVar.o != null) {
            return bVar.o;
        }
        if (!TextUtils.isEmpty(bVar.n)) {
            return com.bytedance.sdk.component.d.c.a.a.a(new File(bVar.n));
        }
        return com.bytedance.sdk.component.d.c.a.a.f();
    }

    public int f() {
        return this.z;
    }

    public int g() {
        return this.A;
    }

    public String a() {
        return this.b;
    }

    public o h() {
        return this.e;
    }

    public String i() {
        return this.d;
    }

    public void a(String str) {
        this.d = str;
    }

    public String e() {
        return this.c;
    }

    public void b(String str) {
        WeakReference<ImageView> weakReference = this.l;
        if (!(weakReference == null || weakReference.get() == null)) {
            ((ImageView) this.l.get()).setTag(1094453505, str);
        }
        this.c = str;
    }

    public ImageView.ScaleType d() {
        return this.f;
    }

    public Bitmap.Config j() {
        return this.g;
    }

    public int b() {
        return this.h;
    }

    public int c() {
        return this.i;
    }

    public u k() {
        return this.k;
    }

    public boolean l() {
        return this.n;
    }

    public boolean m() {
        return this.o;
    }

    public void a(boolean z2) {
        this.t = z2;
    }

    public boolean n() {
        return this.t;
    }

    public g o() {
        return this.u;
    }

    public void a(g gVar) {
        this.u = gVar;
    }

    public int p() {
        return this.v;
    }

    public void a(int i2) {
        this.v = i2;
    }

    public a q() {
        return this.x;
    }

    public void a(a aVar) {
        this.x = aVar;
    }

    public f r() {
        return this.w;
    }

    public com.bytedance.sdk.component.d.b s() {
        return this.y;
    }

    public boolean a(com.bytedance.sdk.component.d.d.i iVar) {
        if (this.m) {
            return false;
        }
        return this.r.add(iVar);
    }

    /* access modifiers changed from: private */
    public i u() {
        try {
            f fVar = this.w;
            if (fVar == null) {
                o oVar = this.e;
                if (oVar != null) {
                    oVar.a(1005, "not init !", (Throwable) null);
                }
                return this;
            }
            ExecutorService e2 = fVar.e();
            if (e2 != null) {
                this.a = e2.submit(new Runnable() {
                    public void run() {
                        while (true) {
                            try {
                                if (c.this.m) {
                                    break;
                                }
                                com.bytedance.sdk.component.d.d.i iVar = (com.bytedance.sdk.component.d.d.i) c.this.r.poll();
                                if (iVar == null) {
                                    break;
                                }
                                if (c.this.p != null) {
                                    c.this.p.a(iVar.a(), c.this);
                                }
                                iVar.a(c.this);
                                if (c.this.p != null) {
                                    c.this.p.b(iVar.a(), c.this);
                                }
                            } catch (Throwable th) {
                                c.this.a(2000, th.getMessage(), th);
                                if (c.this.p != null) {
                                    c.this.p.b("exception", c.this);
                                    return;
                                }
                                return;
                            }
                        }
                        if (c.this.m) {
                            c.this.a(1003, "canceled", (Throwable) null);
                        }
                    }
                });
            }
            return this;
        } catch (Exception e3) {
            Log.e("ImageRequest", e3.getMessage());
        }
    }

    /* access modifiers changed from: private */
    public void a(int i2, String str, Throwable th) {
        new com.bytedance.sdk.component.d.d.h(i2, str, th).a(this);
        this.r.clear();
    }

    public String t() {
        return e() + k();
    }

    /* compiled from: ImageRequest */
    public static class b implements j {
        /* access modifiers changed from: private */
        public o a;
        /* access modifiers changed from: private */
        public ImageView b;
        /* access modifiers changed from: private */
        public String c;
        /* access modifiers changed from: private */
        public String d;
        /* access modifiers changed from: private */
        public ImageView.ScaleType e;
        /* access modifiers changed from: private */
        public Bitmap.Config f;
        /* access modifiers changed from: private */
        public int g;
        /* access modifiers changed from: private */
        public int h;
        /* access modifiers changed from: private */
        public u i;
        /* access modifiers changed from: private */
        public t j;
        /* access modifiers changed from: private */
        public s k;
        /* access modifiers changed from: private */
        public boolean l;
        /* access modifiers changed from: private */
        public boolean m;
        /* access modifiers changed from: private */
        public String n;
        /* access modifiers changed from: private */
        public com.bytedance.sdk.component.d.b o;
        /* access modifiers changed from: private */
        public f p;
        /* access modifiers changed from: private */
        public h q;
        /* access modifiers changed from: private */
        public int r;
        /* access modifiers changed from: private */
        public int s;

        public b(f fVar) {
            this.p = fVar;
        }

        public j c(String str) {
            this.d = str;
            return this;
        }

        public j a(String str) {
            this.c = str;
            return this;
        }

        public j a(ImageView.ScaleType scaleType) {
            this.e = scaleType;
            return this;
        }

        public j a(Bitmap.Config config) {
            this.f = config;
            return this;
        }

        public j a(int i2) {
            this.g = i2;
            return this;
        }

        public j b(int i2) {
            this.h = i2;
            return this;
        }

        public j a(u uVar) {
            this.i = uVar;
            return this;
        }

        public j a(s sVar) {
            this.k = sVar;
            return this;
        }

        public j a(boolean z) {
            this.m = z;
            return this;
        }

        public j b(String str) {
            this.n = str;
            return this;
        }

        public i a(o oVar, t tVar) {
            this.j = tVar;
            return a(oVar);
        }

        public i a(o oVar) {
            this.a = oVar;
            return new c(this).u();
        }

        public i a(ImageView imageView) {
            this.b = imageView;
            return new c(this).u();
        }

        public j a(h hVar) {
            this.q = hVar;
            return this;
        }

        public j c(int i2) {
            this.r = i2;
            return this;
        }

        public j d(int i2) {
            this.s = i2;
            return this;
        }
    }

    /* compiled from: ImageRequest */
    private class a implements o {
        /* access modifiers changed from: private */
        public o b;

        public a(o oVar) {
            this.b = oVar;
        }

        public void a(final k kVar) {
            final ImageView imageView = (ImageView) c.this.l.get();
            if (imageView != null && c.this.k != u.RAW && a(imageView) && (kVar.b() instanceof Bitmap)) {
                final Bitmap bitmap = (Bitmap) kVar.b();
                c.this.s.post(new Runnable() {
                    public void run() {
                        imageView.setImageBitmap(bitmap);
                    }
                });
            }
            try {
                if (c.this.j != null && (kVar.b() instanceof Bitmap)) {
                    h h = c.this.j;
                    Bitmap bitmap2 = (Bitmap) kVar.b();
                    Bitmap bitmap3 = bitmap2;
                    Bitmap a2 = h.a(bitmap2);
                    if (a2 != null) {
                        kVar.a(a2);
                    }
                }
            } catch (Throwable unused) {
            }
            if (c.this.q == t.MAIN) {
                c.this.s.postAtFrontOfQueue(new Runnable() {
                    public void run() {
                        if (a.this.b != null) {
                            a.this.b.a(kVar);
                        }
                    }
                });
                return;
            }
            o oVar = this.b;
            if (oVar != null) {
                oVar.a(kVar);
            }
        }

        private boolean a(ImageView imageView) {
            Object tag;
            if (imageView == null || (tag = imageView.getTag(1094453505)) == null || !tag.equals(c.this.c)) {
                return false;
            }
            return true;
        }

        public void a(final int i, final String str, final Throwable th) {
            if (c.this.q == t.MAIN) {
                c.this.s.post(new Runnable() {
                    public void run() {
                        if (a.this.b != null) {
                            a.this.b.a(i, str, th);
                        }
                    }
                });
                return;
            }
            o oVar = this.b;
            if (oVar != null) {
                oVar.a(i, str, th);
            }
        }
    }
}

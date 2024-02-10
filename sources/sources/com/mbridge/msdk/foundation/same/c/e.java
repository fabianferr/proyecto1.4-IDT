package com.mbridge.msdk.foundation.same.c;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.same.net.f;
import com.mbridge.msdk.foundation.same.net.h.b;
import com.mbridge.msdk.foundation.same.net.l;
import java.io.File;

/* compiled from: CommonImageTask */
public final class e extends com.mbridge.msdk.foundation.same.e.a {
    private String a;
    /* access modifiers changed from: private */
    public String e;
    /* access modifiers changed from: private */
    public String f;
    private boolean g;
    private a h;
    /* access modifiers changed from: private */
    public boolean i;

    /* compiled from: CommonImageTask */
    public interface a {
        void a(String str, String str2);

        void b(String str, String str2);
    }

    public final void b() {
    }

    public final void a(boolean z) {
        this.g = z;
    }

    public final void a(a aVar) {
        this.h = aVar;
    }

    public e(String str, String str2, String str3) {
        this.g = false;
        this.i = false;
        this.a = str;
        this.e = str2;
        this.f = str3;
    }

    public e(String str, String str2, String str3, h hVar) {
        this.g = false;
        this.a = str;
        this.e = str2;
        this.f = str3;
        this.i = true;
    }

    private void e() {
        try {
            File file = new File(this.f);
            if (!file.exists()) {
                file.mkdirs();
            }
            if (file.exists()) {
                file.delete();
            }
            b.downloadFile(file, this.e, new f<Void>() {
                public final void onFinish() {
                }

                public final void onProgressChange(long j, long j2) {
                }

                public final void onSuccess(l lVar) {
                    AnonymousClass1 r2 = new Runnable() {
                        public final void run() {
                            e eVar = e.this;
                            String unused = e.this.f;
                            e.this.c();
                        }
                    };
                    if (e.this.i) {
                        com.mbridge.msdk.foundation.same.f.b.f().execute(r2);
                    } else {
                        r2.run();
                    }
                }

                public final void onError(final com.mbridge.msdk.foundation.same.net.b.a aVar) {
                    AnonymousClass2 r0 = new Runnable() {
                        public final void run() {
                            e eVar = e.this;
                            String c = e.this.e;
                            eVar.a(c, "load image from http faild because http return code: " + aVar.a + ".image url is " + e.this.e);
                        }
                    };
                    if (e.this.i) {
                        com.mbridge.msdk.foundation.same.f.b.f().execute(r0);
                    } else {
                        r0.run();
                    }
                }
            });
        } catch (Exception e2) {
            a(this.e, e2.getMessage());
            if (MBridgeConstans.DEBUG) {
                e2.printStackTrace();
            }
        } catch (OutOfMemoryError e3) {
            a(this.e, e3.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    public final void c() {
        if (new File(this.f).exists()) {
            String str = this.e;
            String str2 = this.f;
            a aVar = this.h;
            if (aVar != null) {
                aVar.a(str, str2);
                return;
            }
            return;
        }
        a(this.e, "load image faild.because file[" + this.f + "] is not exist!");
    }

    /* access modifiers changed from: private */
    public void a(String str, String str2) {
        a aVar = this.h;
        if (aVar != null) {
            aVar.b(str, str2);
        }
    }

    public final void a() {
        if (this.g) {
            e();
        } else if (TextUtils.isEmpty(this.f)) {
            a(this.e, "save path is null.");
        } else {
            File file = new File(this.f);
            if (!file.exists() || file.length() <= 0) {
                e();
            } else {
                c();
            }
        }
    }
}

package com.mbridge.msdk.videocommon.download;

import android.text.TextUtils;
import com.iab.omid.library.mmadbridge.ScriptInjector;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.f;
import com.mbridge.msdk.foundation.controller.b;
import com.mbridge.msdk.foundation.same.b.c;
import com.mbridge.msdk.foundation.same.b.e;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.al;
import com.mbridge.msdk.foundation.tools.y;
import java.io.File;

/* compiled from: HTMLResourceManager */
public final class h {
    /* access modifiers changed from: private */
    public String a;

    /* compiled from: HTMLResourceManager */
    private static class a {
        public static h a = new h((AnonymousClass1) null);
    }

    /* synthetic */ h(AnonymousClass1 r1) {
        this();
    }

    private h() {
        this.a = e.b(c.MBRIDGE_700_HTML);
    }

    public static h a() {
        return a.a;
    }

    /* renamed from: com.mbridge.msdk.videocommon.download.h$1  reason: invalid class name */
    /* compiled from: HTMLResourceManager */
    class AnonymousClass1 extends com.mbridge.msdk.foundation.same.e.a {
        final /* synthetic */ h a;

        public final void b() {
        }

        public final void a() {
            y.c(this.a.a);
        }
    }

    public final boolean a(String str, byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        try {
            if (bArr.length <= 0) {
                return false;
            }
            if (y.a(bArr, new File(this.a + "/" + SameMD5.getMD5(al.b(str)) + ".html"))) {
                return true;
            }
            return false;
        } catch (Exception e) {
            if (!MBridgeConstans.DEBUG) {
                return false;
            }
            e.printStackTrace();
            return false;
        }
    }

    public final String a(String str) {
        try {
            String str2 = this.a + "/" + SameMD5.getMD5(al.b(str)) + ".html";
            File file = new File(str2);
            if (!file.exists()) {
                return null;
            }
            com.mbridge.msdk.c.e b = f.a().b(b.d().h());
            if (b != null && !TextUtils.isEmpty(b.aw())) {
                y.a(com.mbridge.msdk.a.b.c(ScriptInjector.injectScriptContentIntoHtml(MBridgeConstans.OMID_JS_SERVICE_CONTENT, y.a(file))).getBytes(), file);
            }
            return "file:////" + str2;
        } catch (Throwable th) {
            if (!MBridgeConstans.DEBUG) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    public final String b(String str) {
        try {
            String md5 = SameMD5.getMD5(al.b(str));
            File file = new File(this.a + "/" + md5 + ".html");
            if (file.exists()) {
                return y.a(file);
            }
            return null;
        } catch (Throwable th) {
            if (!MBridgeConstans.DEBUG) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }
}

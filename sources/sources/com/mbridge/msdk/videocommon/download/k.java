package com.mbridge.msdk.videocommon.download;

import android.net.Uri;
import android.text.TextUtils;
import com.iab.omid.library.mmadbridge.ScriptInjector;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.f;
import com.mbridge.msdk.foundation.controller.b;
import com.mbridge.msdk.foundation.same.b.c;
import com.mbridge.msdk.foundation.same.b.e;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.al;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.foundation.tools.y;
import com.vungle.ads.internal.model.AdPayload;
import java.io.File;
import java.util.List;

/* compiled from: ResourceManager */
public final class k {
    private static String a = "ResourceManager";
    /* access modifiers changed from: private */
    public String b;

    /* compiled from: ResourceManager */
    private static class a {
        public static k a = new k((AnonymousClass1) null);
    }

    /* synthetic */ k(AnonymousClass1 r1) {
        this();
    }

    private k() {
        this.b = e.b(c.MBRIDGE_700_RES);
    }

    public static k a() {
        return a.a;
    }

    /* renamed from: com.mbridge.msdk.videocommon.download.k$1  reason: invalid class name */
    /* compiled from: ResourceManager */
    class AnonymousClass1 extends com.mbridge.msdk.foundation.same.e.a {
        final /* synthetic */ k a;

        public final void b() {
        }

        public final void a() {
            y.c(this.a.b);
        }
    }

    public final synchronized String a(String str, byte[] bArr) {
        String str2;
        String str3 = "unknow exception ";
        if (bArr != null) {
            try {
                if (bArr.length > 0) {
                    String str4 = this.b + "/" + SameMD5.getMD5(al.b(str)) + ".zip";
                    File file = new File(str4);
                    if (y.a(bArr, file)) {
                        Uri parse = Uri.parse(str);
                        List<String> queryParameters = parse.getQueryParameters("nc");
                        if (queryParameters != null) {
                            if (queryParameters.size() != 0) {
                                str3 = a(str, str4, file);
                            }
                        }
                        List<String> queryParameters2 = parse.getQueryParameters("md5filename");
                        if (queryParameters2 != null && queryParameters2.size() > 0) {
                            String str5 = queryParameters2.get(0);
                            if (!TextUtils.isEmpty(str5) && str5.equals(x.a(file))) {
                                str3 = a(str, str4, file);
                            }
                        }
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        y.b(file);
                    }
                }
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    e.printStackTrace();
                }
                str2 = e.getMessage();
            }
        }
        str2 = str3;
        return str2;
    }

    private String a(String str, String str2, File file) {
        String a2 = y.a(str2, this.b + "/" + SameMD5.getMD5(al.b(str)));
        return TextUtils.isEmpty(a2) ? y.b(file) : a2;
    }

    public final String a(String str) {
        String str2;
        String str3 = "";
        try {
            String str4 = this.b + "/" + SameMD5.getMD5(al.b(str));
            List<String> queryParameters = Uri.parse(str).getQueryParameters("foldername");
            if (queryParameters == null || queryParameters.size() <= 0) {
                return null;
            }
            String str5 = queryParameters.get(0);
            if (TextUtils.isEmpty(str5)) {
                return null;
            }
            String str6 = str4 + "/" + str5 + "/" + str5 + ".html";
            if (!y.a(str6)) {
                return null;
            }
            try {
                com.mbridge.msdk.c.e b2 = f.a().b(b.d().h());
                if (b2 != null && !TextUtils.isEmpty(b2.aw())) {
                    File file = new File(str6);
                    y.a(com.mbridge.msdk.a.b.c(ScriptInjector.injectScriptContentIntoHtml(MBridgeConstans.OMID_JS_SERVICE_CONTENT, y.a(file))).getBytes(), file);
                }
                str2 = str.substring(str.indexOf("?") + 1);
            } catch (Exception unused) {
                str2 = str3;
            }
            if (!TextUtils.isEmpty(str2)) {
                str3 = "?" + str2;
            }
            return AdPayload.FILE_SCHEME + str6 + str3;
        } catch (Exception e) {
            if (!MBridgeConstans.DEBUG) {
                return null;
            }
            e.printStackTrace();
            return null;
        }
    }
}

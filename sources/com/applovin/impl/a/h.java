package com.applovin.impl.a;

import android.net.Uri;
import android.webkit.URLUtil;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.u;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.r;

public class h {
    private a a;
    private Uri b;
    private String c;

    public enum a {
        UNSPECIFIED,
        STATIC,
        IFRAME,
        HTML
    }

    private h() {
    }

    static h a(r rVar, h hVar, m mVar) {
        if (rVar == null) {
            throw new IllegalArgumentException("No node specified.");
        } else if (mVar != null) {
            if (hVar == null) {
                try {
                    hVar = new h();
                } catch (Throwable th) {
                    if (!u.a()) {
                        return null;
                    }
                    mVar.A().b("VastNonVideoResource", "Error occurred while initializing", th);
                    return null;
                }
            }
            if (hVar.b == null && !StringUtils.isValidString(hVar.c)) {
                String a2 = a(rVar, "StaticResource");
                if (URLUtil.isValidUrl(a2)) {
                    hVar.b = Uri.parse(a2);
                    hVar.a = a.STATIC;
                    return hVar;
                }
                String a3 = a(rVar, "IFrameResource");
                if (StringUtils.isValidString(a3)) {
                    hVar.a = a.IFRAME;
                    if (URLUtil.isValidUrl(a3)) {
                        hVar.b = Uri.parse(a3);
                    } else {
                        hVar.c = a3;
                    }
                    return hVar;
                }
                String a4 = a(rVar, "HTMLResource");
                if (StringUtils.isValidString(a4)) {
                    hVar.a = a.HTML;
                    if (URLUtil.isValidUrl(a4)) {
                        hVar.b = Uri.parse(a4);
                    } else {
                        hVar.c = a4;
                    }
                }
            }
            return hVar;
        } else {
            throw new IllegalArgumentException("No sdk specified.");
        }
    }

    private static String a(r rVar, String str) {
        r b2 = rVar.b(str);
        if (b2 != null) {
            return b2.c();
        }
        return null;
    }

    public a a() {
        return this.a;
    }

    public void a(Uri uri) {
        this.b = uri;
    }

    public void a(String str) {
        this.c = str;
    }

    public Uri b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        if (this.a != hVar.a) {
            return false;
        }
        Uri uri = this.b;
        if (uri == null ? hVar.b != null : !uri.equals(hVar.b)) {
            return false;
        }
        String str = this.c;
        String str2 = hVar.c;
        return str != null ? str.equals(str2) : str2 == null;
    }

    public int hashCode() {
        a aVar = this.a;
        int i = 0;
        int hashCode = (aVar != null ? aVar.hashCode() : 0) * 31;
        Uri uri = this.b;
        int hashCode2 = (hashCode + (uri != null ? uri.hashCode() : 0)) * 31;
        String str = this.c;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "VastNonVideoResource{type=" + this.a + ", resourceUri=" + this.b + ", resourceContents='" + this.c + "'}";
    }
}

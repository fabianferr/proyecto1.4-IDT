package com.applovin.impl.a;

import android.net.Uri;
import android.webkit.URLUtil;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.u;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.r;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.Locale;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class n {
    private Uri a;
    private Uri b;
    private a c;
    private String d;
    private int e;
    private int f;
    private int g;

    public enum a {
        Progressive,
        Streaming
    }

    private n() {
    }

    private static a a(String str) {
        if (StringUtils.isValidString(str)) {
            if ("progressive".equalsIgnoreCase(str)) {
                return a.Progressive;
            }
            if ("streaming".equalsIgnoreCase(str)) {
                return a.Streaming;
            }
        }
        return a.Progressive;
    }

    public static n a(r rVar, m mVar) {
        if (rVar == null) {
            throw new IllegalArgumentException("No node specified.");
        } else if (mVar != null) {
            try {
                String c2 = rVar.c();
                if (URLUtil.isValidUrl(c2)) {
                    Uri parse = Uri.parse(c2);
                    n nVar = new n();
                    nVar.a = parse;
                    nVar.b = parse;
                    nVar.g = StringUtils.parseInt(rVar.b().get("bitrate"));
                    nVar.c = a(rVar.b().get("delivery"));
                    nVar.f = StringUtils.parseInt(rVar.b().get(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY));
                    nVar.e = StringUtils.parseInt(rVar.b().get(ViewHierarchyConstants.DIMENSION_WIDTH_KEY));
                    nVar.d = rVar.b().get("type").toLowerCase(Locale.ENGLISH);
                    return nVar;
                } else if (!u.a()) {
                    return null;
                } else {
                    mVar.A().e("VastVideoFile", "Unable to create video file. Could not find URL.");
                    return null;
                }
            } catch (Throwable th) {
                if (!u.a()) {
                    return null;
                }
                mVar.A().b("VastVideoFile", "Error occurred while initializing", th);
                return null;
            }
        } else {
            throw new IllegalArgumentException("No sdk specified.");
        }
    }

    public Uri a() {
        return this.a;
    }

    public void a(Uri uri) {
        this.b = uri;
    }

    public Uri b() {
        return this.b;
    }

    public String c() {
        return this.d;
    }

    public int d() {
        return this.g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        if (this.e != nVar.e || this.f != nVar.f || this.g != nVar.g) {
            return false;
        }
        Uri uri = this.a;
        if (uri == null ? nVar.a != null : !uri.equals(nVar.a)) {
            return false;
        }
        Uri uri2 = this.b;
        if (uri2 == null ? nVar.b != null : !uri2.equals(nVar.b)) {
            return false;
        }
        if (this.c != nVar.c) {
            return false;
        }
        String str = this.d;
        String str2 = nVar.d;
        return str != null ? str.equals(str2) : str2 == null;
    }

    public int hashCode() {
        Uri uri = this.a;
        int i = 0;
        int hashCode = (uri != null ? uri.hashCode() : 0) * 31;
        Uri uri2 = this.b;
        int hashCode2 = (hashCode + (uri2 != null ? uri2.hashCode() : 0)) * 31;
        a aVar = this.c;
        int hashCode3 = (hashCode2 + (aVar != null ? aVar.hashCode() : 0)) * 31;
        String str = this.d;
        if (str != null) {
            i = str.hashCode();
        }
        return ((((((hashCode3 + i) * 31) + this.e) * 31) + this.f) * 31) + this.g;
    }

    public String toString() {
        return "VastVideoFile{sourceVideoUri=" + this.a + ", videoUri=" + this.b + ", deliveryType=" + this.c + ", fileType='" + this.d + "', width=" + this.e + ", height=" + this.f + ", bitrate=" + this.g + AbstractJsonLexerKt.END_OBJ;
    }
}

package com.applovin.impl.a;

import android.net.Uri;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.u;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.r;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class d {
    private int a;
    private int b;
    private Uri c;
    private h d;
    private final Set<j> e = new HashSet();
    private final Map<String, Set<j>> f = CollectionUtils.map();

    private d() {
    }

    public static d a(r rVar, d dVar, e eVar, m mVar) {
        r b2;
        if (rVar == null) {
            throw new IllegalArgumentException("No node specified.");
        } else if (mVar != null) {
            if (dVar == null) {
                try {
                    dVar = new d();
                } catch (Throwable th) {
                    if (!u.a()) {
                        return null;
                    }
                    mVar.A().b("VastCompanionAd", "Error occurred while initializing", th);
                    return null;
                }
            }
            if (dVar.a == 0 && dVar.b == 0) {
                int parseInt = StringUtils.parseInt(rVar.b().get(ViewHierarchyConstants.DIMENSION_WIDTH_KEY));
                int parseInt2 = StringUtils.parseInt(rVar.b().get(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY));
                if (parseInt > 0 && parseInt2 > 0) {
                    dVar.a = parseInt;
                    dVar.b = parseInt2;
                }
            }
            dVar.d = h.a(rVar, dVar.d, mVar);
            if (dVar.c == null && (b2 = rVar.b("CompanionClickThrough")) != null) {
                String c2 = b2.c();
                if (StringUtils.isValidString(c2)) {
                    dVar.c = Uri.parse(c2);
                }
            }
            l.a(rVar.a("CompanionClickTracking"), dVar.e, eVar, mVar);
            l.a(rVar, dVar.f, eVar, mVar);
            return dVar;
        } else {
            throw new IllegalArgumentException("No sdk specified.");
        }
    }

    public Uri a() {
        return this.c;
    }

    public h b() {
        return this.d;
    }

    public Set<j> c() {
        return this.e;
    }

    public Map<String, Set<j>> d() {
        return this.f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (this.a != dVar.a || this.b != dVar.b) {
            return false;
        }
        Uri uri = this.c;
        if (uri == null ? dVar.c != null : !uri.equals(dVar.c)) {
            return false;
        }
        h hVar = this.d;
        if (hVar == null ? dVar.d != null : !hVar.equals(dVar.d)) {
            return false;
        }
        Set<j> set = this.e;
        if (set == null ? dVar.e != null : !set.equals(dVar.e)) {
            return false;
        }
        Map<String, Set<j>> map = this.f;
        Map<String, Set<j>> map2 = dVar.f;
        return map != null ? map.equals(map2) : map2 == null;
    }

    public int hashCode() {
        int i = ((this.a * 31) + this.b) * 31;
        Uri uri = this.c;
        int i2 = 0;
        int hashCode = (i + (uri != null ? uri.hashCode() : 0)) * 31;
        h hVar = this.d;
        int hashCode2 = (hashCode + (hVar != null ? hVar.hashCode() : 0)) * 31;
        Set<j> set = this.e;
        int hashCode3 = (hashCode2 + (set != null ? set.hashCode() : 0)) * 31;
        Map<String, Set<j>> map = this.f;
        if (map != null) {
            i2 = map.hashCode();
        }
        return hashCode3 + i2;
    }

    public String toString() {
        return "VastCompanionAd{width=" + this.a + ", height=" + this.b + ", destinationUri=" + this.c + ", nonVideoResource=" + this.d + ", clickTrackers=" + this.e + ", eventTrackers=" + this.f + AbstractJsonLexerKt.END_OBJ;
    }
}

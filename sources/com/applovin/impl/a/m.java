package com.applovin.impl.a;

import android.net.Uri;
import android.webkit.MimeTypeMap;
import com.applovin.impl.sdk.d.b;
import com.applovin.impl.sdk.u;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.g;
import com.applovin.impl.sdk.utils.r;
import com.facebook.internal.security.CertificateUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class m {
    private List<n> a = Collections.emptyList();
    private List<String> b = Collections.emptyList();
    private int c;
    private Uri d;
    private final Set<j> e = new HashSet();
    private final Map<String, Set<j>> f = CollectionUtils.map();

    public enum a {
        UNSPECIFIED,
        LOW,
        MEDIUM,
        HIGH
    }

    private m() {
    }

    private m(e eVar) {
        this.b = eVar.g();
    }

    private static int a(String str, com.applovin.impl.sdk.m mVar) {
        try {
            List<String> explode = CollectionUtils.explode(str, CertificateUtil.DELIMITER);
            if (explode.size() == 3) {
                return (int) (TimeUnit.HOURS.toSeconds((long) StringUtils.parseInt(explode.get(0))) + TimeUnit.MINUTES.toSeconds((long) StringUtils.parseInt(explode.get(1))) + ((long) StringUtils.parseInt(explode.get(2))));
            }
        } catch (Throwable unused) {
            if (u.a()) {
                u A = mVar.A();
                A.e("VastVideoCreative", "Unable to parse duration from \"" + str + "\"");
            }
        }
        return 0;
    }

    public static m a(r rVar, m mVar, e eVar, com.applovin.impl.sdk.m mVar2) {
        r b2;
        List<n> a2;
        r b3;
        int a3;
        if (rVar == null) {
            throw new IllegalArgumentException("No node specified.");
        } else if (eVar == null) {
            throw new IllegalArgumentException("No context specified.");
        } else if (mVar2 != null) {
            if (mVar == null) {
                try {
                    mVar = new m(eVar);
                } catch (Throwable th) {
                    if (!u.a()) {
                        return null;
                    }
                    mVar2.A().b("VastVideoCreative", "Error occurred while initializing", th);
                    return null;
                }
            }
            if (mVar.c == 0 && (b3 = rVar.b("Duration")) != null && (a3 = a(b3.c(), mVar2)) > 0) {
                mVar.c = a3;
            }
            r b4 = rVar.b("MediaFiles");
            if (!(b4 == null || (a2 = a(b4, mVar2)) == null || a2.size() <= 0)) {
                List<n> list = mVar.a;
                if (list != null) {
                    a2.addAll(list);
                }
                mVar.a = a2;
            }
            r b5 = rVar.b("VideoClicks");
            if (b5 != null) {
                if (mVar.d == null && (b2 = b5.b("ClickThrough")) != null) {
                    String c2 = b2.c();
                    if (StringUtils.isValidString(c2)) {
                        mVar.d = Uri.parse(c2);
                    }
                }
                l.a(b5.a("ClickTracking"), mVar.e, eVar, mVar2);
            }
            l.a(rVar, mVar.f, eVar, mVar2);
            return mVar;
        } else {
            throw new IllegalArgumentException("No sdk specified.");
        }
    }

    private static List<n> a(r rVar, com.applovin.impl.sdk.m mVar) {
        List<r> a2 = rVar.a("MediaFile");
        ArrayList arrayList = new ArrayList(a2.size());
        List<String> explode = CollectionUtils.explode((String) mVar.a(b.en));
        List<String> explode2 = CollectionUtils.explode((String) mVar.a(b.em));
        for (r a3 : a2) {
            n a4 = n.a(a3, mVar);
            if (a4 != null) {
                try {
                    String c2 = a4.c();
                    if (!StringUtils.isValidString(c2) || explode.contains(c2)) {
                        if (((Boolean) mVar.a(b.eo)).booleanValue()) {
                            String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(a4.b().toString());
                            if (StringUtils.isValidString(fileExtensionFromUrl) && !explode2.contains(fileExtensionFromUrl)) {
                            }
                        }
                        if (u.a()) {
                            u A = mVar.A();
                            A.d("VastVideoCreative", "Video file not supported: " + a4);
                        }
                    }
                    arrayList.add(a4);
                } catch (Throwable th) {
                    if (u.a()) {
                        u A2 = mVar.A();
                        A2.b("VastVideoCreative", "Failed to validate video file: " + a4, th);
                    }
                }
            }
        }
        return arrayList;
    }

    public n a(a aVar) {
        List<n> list = this.a;
        if (list == null || list.size() == 0) {
            return null;
        }
        List arrayList = new ArrayList(3);
        for (String next : this.b) {
            for (n next2 : this.a) {
                String c2 = next2.c();
                if (StringUtils.isValidString(c2) && next.equalsIgnoreCase(c2)) {
                    arrayList.add(next2);
                }
            }
            if (!arrayList.isEmpty()) {
                break;
            }
        }
        if (arrayList.isEmpty()) {
            arrayList = this.a;
        }
        if (g.c()) {
            Collections.sort(arrayList, new Comparator<n>() {
                /* renamed from: a */
                public int compare(n nVar, n nVar2) {
                    return Integer.compare(nVar.d(), nVar2.d());
                }
            });
        }
        return (n) arrayList.get(aVar == a.LOW ? 0 : aVar == a.MEDIUM ? arrayList.size() / 2 : arrayList.size() - 1);
    }

    public List<n> a() {
        return this.a;
    }

    public int b() {
        return this.c;
    }

    public Uri c() {
        return this.d;
    }

    public Set<j> d() {
        return this.e;
    }

    public Map<String, Set<j>> e() {
        return this.f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        if (this.c != mVar.c) {
            return false;
        }
        List<n> list = this.a;
        if (list == null ? mVar.a != null : !list.equals(mVar.a)) {
            return false;
        }
        Uri uri = this.d;
        if (uri == null ? mVar.d != null : !uri.equals(mVar.d)) {
            return false;
        }
        Set<j> set = this.e;
        if (set == null ? mVar.e != null : !set.equals(mVar.e)) {
            return false;
        }
        Map<String, Set<j>> map = this.f;
        Map<String, Set<j>> map2 = mVar.f;
        return map != null ? map.equals(map2) : map2 == null;
    }

    public int hashCode() {
        List<n> list = this.a;
        int i = 0;
        int hashCode = (((list != null ? list.hashCode() : 0) * 31) + this.c) * 31;
        Uri uri = this.d;
        int hashCode2 = (hashCode + (uri != null ? uri.hashCode() : 0)) * 31;
        Set<j> set = this.e;
        int hashCode3 = (hashCode2 + (set != null ? set.hashCode() : 0)) * 31;
        Map<String, Set<j>> map = this.f;
        if (map != null) {
            i = map.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "VastVideoCreative{videoFiles=" + this.a + ", durationSeconds=" + this.c + ", destinationUri=" + this.d + ", clickTrackers=" + this.e + ", eventTrackers=" + this.f + AbstractJsonLexerKt.END_OBJ;
    }
}

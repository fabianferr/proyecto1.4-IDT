package com.applovin.impl.a;

import android.net.Uri;
import com.applovin.impl.a.m;
import com.applovin.impl.sdk.ad.e;
import com.applovin.impl.sdk.b.g;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.u;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.Utils;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

public class a extends e {
    private final String a;
    private final String b;
    private final i c;
    private final long d;
    private final m e;
    private final d f;
    private final String g;
    private final c h;
    private final g i;
    private final Set<j> j;
    private final Set<j> k;

    /* renamed from: com.applovin.impl.a.a$a  reason: collision with other inner class name */
    public static class C0006a {
        /* access modifiers changed from: private */
        public JSONObject a;
        /* access modifiers changed from: private */
        public JSONObject b;
        /* access modifiers changed from: private */
        public com.applovin.impl.sdk.ad.b c;
        /* access modifiers changed from: private */
        public m d;
        /* access modifiers changed from: private */
        public long e;
        /* access modifiers changed from: private */
        public String f;
        /* access modifiers changed from: private */
        public String g;
        /* access modifiers changed from: private */
        public i h;
        /* access modifiers changed from: private */
        public m i;
        /* access modifiers changed from: private */
        public d j;
        /* access modifiers changed from: private */
        public c k;
        /* access modifiers changed from: private */
        public Set<j> l;
        /* access modifiers changed from: private */
        public Set<j> m;

        public C0006a a(long j2) {
            this.e = j2;
            return this;
        }

        public C0006a a(c cVar) {
            this.k = cVar;
            return this;
        }

        public C0006a a(d dVar) {
            this.j = dVar;
            return this;
        }

        public C0006a a(i iVar) {
            this.h = iVar;
            return this;
        }

        public C0006a a(m mVar) {
            this.i = mVar;
            return this;
        }

        public C0006a a(com.applovin.impl.sdk.ad.b bVar) {
            this.c = bVar;
            return this;
        }

        public C0006a a(m mVar) {
            if (mVar != null) {
                this.d = mVar;
                return this;
            }
            throw new IllegalArgumentException("No sdk specified.");
        }

        public C0006a a(String str) {
            this.f = str;
            return this;
        }

        public C0006a a(Set<j> set) {
            this.l = set;
            return this;
        }

        public C0006a a(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.a = jSONObject;
                return this;
            }
            throw new IllegalArgumentException("No ad object specified.");
        }

        public a a() {
            return new a(this);
        }

        public C0006a b(String str) {
            this.g = str;
            return this;
        }

        public C0006a b(Set<j> set) {
            this.m = set;
            return this;
        }

        public C0006a b(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.b = jSONObject;
                return this;
            }
            throw new IllegalArgumentException("No full ad response specified.");
        }
    }

    public enum b {
        COMPANION_AD,
        VIDEO
    }

    public enum c {
        IMPRESSION,
        VIDEO_CLICK,
        COMPANION_CLICK,
        VIDEO,
        COMPANION,
        ERROR
    }

    private a(C0006a aVar) {
        super(aVar.a, aVar.b, aVar.c, aVar.d);
        this.a = aVar.f;
        this.c = aVar.h;
        this.b = aVar.g;
        this.e = aVar.i;
        this.f = aVar.j;
        this.h = aVar.k;
        this.j = aVar.l;
        this.k = aVar.m;
        this.i = new g(this);
        Uri h2 = h();
        this.g = h2 != null ? h2.toString() : "";
        this.d = aVar.e;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        r6 = r5.f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.Set<com.applovin.impl.a.j> a(com.applovin.impl.a.a.b r6, java.lang.String[] r7) {
        /*
            r5 = this;
            if (r7 == 0) goto L_0x004a
            int r0 = r7.length
            if (r0 <= 0) goto L_0x004a
            com.applovin.impl.a.a$b r0 = com.applovin.impl.a.a.b.VIDEO
            if (r6 != r0) goto L_0x0012
            com.applovin.impl.a.m r0 = r5.e
            if (r0 == 0) goto L_0x0012
            java.util.Map r6 = r0.e()
            goto L_0x0020
        L_0x0012:
            com.applovin.impl.a.a$b r0 = com.applovin.impl.a.a.b.COMPANION_AD
            if (r6 != r0) goto L_0x001f
            com.applovin.impl.a.d r6 = r5.f
            if (r6 == 0) goto L_0x001f
            java.util.Map r6 = r6.d()
            goto L_0x0020
        L_0x001f:
            r6 = 0
        L_0x0020:
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            if (r6 == 0) goto L_0x0045
            boolean r1 = r6.isEmpty()
            if (r1 != 0) goto L_0x0045
            int r1 = r7.length
            r2 = 0
        L_0x002f:
            if (r2 >= r1) goto L_0x0045
            r3 = r7[r2]
            boolean r4 = r6.containsKey(r3)
            if (r4 == 0) goto L_0x0042
            java.lang.Object r3 = r6.get(r3)
            java.util.Collection r3 = (java.util.Collection) r3
            r0.addAll(r3)
        L_0x0042:
            int r2 = r2 + 1
            goto L_0x002f
        L_0x0045:
            java.util.Set r6 = java.util.Collections.unmodifiableSet(r0)
            return r6
        L_0x004a:
            java.util.Set r6 = java.util.Collections.emptySet()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.a.a.a(com.applovin.impl.a.a$b, java.lang.String[]):java.util.Set");
    }

    private String aV() {
        String stringFromAdObject = getStringFromAdObject("vimp_url", (String) null);
        if (stringFromAdObject != null) {
            return stringFromAdObject.replace(Utils.MACRO_CLCODE, getClCode());
        }
        return null;
    }

    private m.a aW() {
        m.a[] values = m.a.values();
        int intValue = ((Integer) this.sdk.a(com.applovin.impl.sdk.d.b.ep)).intValue();
        return (intValue < 0 || intValue >= values.length) ? m.a.UNSPECIFIED : values[intValue];
    }

    private Set<j> aX() {
        m mVar = this.e;
        return mVar != null ? mVar.d() : Collections.emptySet();
    }

    private Set<j> aY() {
        d dVar = this.f;
        return dVar != null ? dVar.c() : Collections.emptySet();
    }

    public boolean E() {
        return getBooleanFromAdObject("video_clickable", false) && j() != null;
    }

    public Set<j> a(c cVar, String str) {
        return a(cVar, new String[]{str});
    }

    public Set<j> a(c cVar, String[] strArr) {
        b bVar;
        if (u.a()) {
            u A = this.sdk.A();
            A.b("VastAd", "Retrieving trackers of type '" + cVar + "' and events '" + strArr + "'...");
        }
        if (cVar == c.IMPRESSION) {
            return this.j;
        }
        if (cVar == c.VIDEO_CLICK) {
            return aX();
        }
        if (cVar == c.COMPANION_CLICK) {
            return aY();
        }
        if (cVar == c.VIDEO) {
            bVar = b.VIDEO;
        } else if (cVar == c.COMPANION) {
            bVar = b.COMPANION_AD;
        } else if (cVar == c.ERROR) {
            return this.k;
        } else {
            if (u.a()) {
                u A2 = this.sdk.A();
                A2.e("VastAd", "Failed to retrieve trackers of invalid type '" + cVar + "' and events '" + strArr + "'");
            }
            return Collections.emptySet();
        }
        return a(bVar, strArr);
    }

    public void a() {
    }

    public void a(String str) {
        synchronized (this.adObjectLock) {
            JsonUtils.putString(this.adObject, "html_template", str);
        }
    }

    public m aM() {
        return this.e;
    }

    public n aN() {
        m mVar = this.e;
        if (mVar != null) {
            return mVar.a(aW());
        }
        return null;
    }

    public d aO() {
        return this.f;
    }

    public boolean aP() {
        return getBooleanFromAdObject("vast_fire_click_trackers_on_html_clicks", false);
    }

    public String aQ() {
        return getStringFromAdObject("html_template", "");
    }

    public Uri aR() {
        String stringFromAdObject = getStringFromAdObject("html_template_url", (String) null);
        if (StringUtils.isValidString(stringFromAdObject)) {
            return Uri.parse(stringFromAdObject);
        }
        return null;
    }

    public boolean aS() {
        return getBooleanFromAdObject("cache_companion_ad", true);
    }

    public boolean aT() {
        return getBooleanFromAdObject("cache_video", true);
    }

    public c aU() {
        return this.h;
    }

    public List<com.applovin.impl.sdk.e.a> at() {
        List<com.applovin.impl.sdk.e.a> postbacks;
        synchronized (this.adObjectLock) {
            postbacks = Utils.getPostbacks("vimp_urls", this.adObject, getClCode(), (Map<String, String>) null, aV(), au(), z(), this.sdk);
        }
        return postbacks;
    }

    public void b() {
        synchronized (this.adObjectLock) {
            this.adObject.remove("vast_is_streaming");
        }
    }

    public boolean c() {
        return getBooleanFromAdObject("iopms", false);
    }

    public String d() {
        return this.g;
    }

    public boolean e() {
        return getBooleanFromAdObject("iopmsfsr", true);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a) || !super.equals(obj)) {
            return false;
        }
        a aVar = (a) obj;
        String str = this.a;
        if (str == null ? aVar.a != null : !str.equals(aVar.a)) {
            return false;
        }
        String str2 = this.b;
        if (str2 == null ? aVar.b != null : !str2.equals(aVar.b)) {
            return false;
        }
        i iVar = this.c;
        if (iVar == null ? aVar.c != null : !iVar.equals(aVar.c)) {
            return false;
        }
        m mVar = this.e;
        if (mVar == null ? aVar.e != null : !mVar.equals(aVar.e)) {
            return false;
        }
        d dVar = this.f;
        if (dVar == null ? aVar.f != null : !dVar.equals(aVar.f)) {
            return false;
        }
        c cVar = this.h;
        if (cVar == null ? aVar.h != null : !cVar.equals(aVar.h)) {
            return false;
        }
        Set<j> set = this.j;
        if (set == null ? aVar.j != null : !set.equals(aVar.j)) {
            return false;
        }
        Set<j> set2 = this.k;
        Set<j> set3 = aVar.k;
        return set2 != null ? set2.equals(set3) : set3 == null;
    }

    public boolean f() {
        return getBooleanFromAdObject("vast_is_streaming", false);
    }

    /* renamed from: g */
    public g o() {
        return this.i;
    }

    public long getCreatedAtMillis() {
        return this.d;
    }

    public JSONObject getOriginalFullResponse() {
        return this.fullResponse;
    }

    public Uri h() {
        n aN = aN();
        if (aN != null) {
            return aN.b();
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
        r0 = r0.a();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean hasVideoUrl() {
        /*
            r2 = this;
            com.applovin.impl.a.m r0 = r2.e
            r1 = 0
            if (r0 == 0) goto L_0x0012
            java.util.List r0 = r0.a()
            if (r0 == 0) goto L_0x0012
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x0012
            r1 = 1
        L_0x0012:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.a.a.hasVideoUrl():boolean");
    }

    public int hashCode() {
        int hashCode = super.hashCode() * 31;
        String str = this.a;
        int i2 = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.b;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        i iVar = this.c;
        int hashCode4 = (hashCode3 + (iVar != null ? iVar.hashCode() : 0)) * 31;
        m mVar = this.e;
        int hashCode5 = (hashCode4 + (mVar != null ? mVar.hashCode() : 0)) * 31;
        d dVar = this.f;
        int hashCode6 = (hashCode5 + (dVar != null ? dVar.hashCode() : 0)) * 31;
        c cVar = this.h;
        int hashCode7 = (hashCode6 + (cVar != null ? cVar.hashCode() : 0)) * 31;
        Set<j> set = this.j;
        int hashCode8 = (hashCode7 + (set != null ? set.hashCode() : 0)) * 31;
        Set<j> set2 = this.k;
        if (set2 != null) {
            i2 = set2.hashCode();
        }
        return hashCode8 + i2;
    }

    public long i() {
        return getLongFromAdObject("real_close_delay", 0);
    }

    public boolean isOpenMeasurementEnabled() {
        return getBooleanFromAdObject("omsdk_enabled", true) && this.h != null;
    }

    public Uri j() {
        m mVar = this.e;
        if (mVar != null) {
            return mVar.c();
        }
        return null;
    }

    public Uri k() {
        return j();
    }

    public b l() {
        return "companion_ad".equalsIgnoreCase(getStringFromAdObject("vast_first_caching_operation", "companion_ad")) ? b.COMPANION_AD : b.VIDEO;
    }

    public boolean m() {
        return getBooleanFromAdObject("vast_immediate_ad_load", true);
    }

    public i n() {
        return this.c;
    }

    public String toString() {
        return "VastAd{title='" + this.a + "', adDescription='" + this.b + "', systemInfo=" + this.c + ", videoCreative=" + this.e + ", companionAd=" + this.f + ", adVerifications=" + this.h + ", impressionTrackers=" + this.j + ", errorTrackers=" + this.k + AbstractJsonLexerKt.END_OBJ;
    }
}

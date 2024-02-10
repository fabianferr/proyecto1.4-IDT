package com.wortise.ads;

import android.net.Uri;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0019\u0010\u001aB\u0011\b\u0017\u0012\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u0019\u0010\u001dJ\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\t\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000e\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0013\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\f¨\u0006\u001e"}, d2 = {"Lcom/wortise/ads/u3;", "", "", "toString", "", "hashCode", "other", "", "equals", "hasGesture", "Z", "a", "()Z", "Landroid/net/Uri;", "url", "Landroid/net/Uri;", "b", "()Landroid/net/Uri;", "c", "isWortise", "", "headers", "isForMainFrame", "isRedirect", "method", "<init>", "(ZLjava/util/Map;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Landroid/net/Uri;)V", "Landroid/webkit/WebResourceRequest;", "request", "(Landroid/webkit/WebResourceRequest;)V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: HtmlWebResourceRequest.kt */
public final class u3 {
    private final boolean a;
    private final Map<String, String> b;
    private final Boolean c;
    private final Boolean d;
    private final String e;
    private final Uri f;

    public u3(boolean z, Map<String, String> map, Boolean bool, Boolean bool2, String str, Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "url");
        this.a = z;
        this.b = map;
        this.c = bool;
        this.d = bool2;
        this.e = str;
        this.f = uri;
    }

    public final boolean a() {
        return this.a;
    }

    public final Uri b() {
        return this.f;
    }

    public final boolean c() {
        return p6.a(this.f, "wortise");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof u3)) {
            return false;
        }
        u3 u3Var = (u3) obj;
        return this.a == u3Var.a && Intrinsics.areEqual((Object) this.b, (Object) u3Var.b) && Intrinsics.areEqual((Object) this.c, (Object) u3Var.c) && Intrinsics.areEqual((Object) this.d, (Object) u3Var.d) && Intrinsics.areEqual((Object) this.e, (Object) u3Var.e) && Intrinsics.areEqual((Object) this.f, (Object) u3Var.f);
    }

    public int hashCode() {
        boolean z = this.a;
        if (z) {
            z = true;
        }
        int i = (z ? 1 : 0) * true;
        Map<String, String> map = this.b;
        int i2 = 0;
        int hashCode = (i + (map == null ? 0 : map.hashCode())) * 31;
        Boolean bool = this.c;
        int hashCode2 = (hashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.d;
        int hashCode3 = (hashCode2 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        String str = this.e;
        if (str != null) {
            i2 = str.hashCode();
        }
        return ((hashCode3 + i2) * 31) + this.f.hashCode();
    }

    public String toString() {
        return "HtmlWebResourceRequest(hasGesture=" + this.a + ", headers=" + this.b + ", isForMainFrame=" + this.c + ", isRedirect=" + this.d + ", method=" + this.e + ", url=" + this.f + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ u3(boolean z, Map map, Boolean bool, Boolean bool2, String str, Uri uri, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, (i & 2) != 0 ? null : map, (i & 4) != 0 ? null : bool, (i & 8) != 0 ? null : bool2, (i & 16) != 0 ? null : str, uri);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public u3(android.webkit.WebResourceRequest r9) {
        /*
            r8 = this;
            java.lang.String r0 = "request"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            boolean r2 = r9.hasGesture()
            java.util.Map r3 = r9.getRequestHeaders()
            boolean r0 = r9.isForMainFrame()
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r0)
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 24
            if (r0 < r1) goto L_0x001d
            r0 = 1
            goto L_0x001e
        L_0x001d:
            r0 = 0
        L_0x001e:
            if (r0 == 0) goto L_0x0029
            boolean r0 = r9.isRedirect()
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            goto L_0x002a
        L_0x0029:
            r0 = 0
        L_0x002a:
            r5 = r0
            java.lang.String r6 = r9.getMethod()
            android.net.Uri r7 = r9.getUrl()
            java.lang.String r9 = "request.url"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r9)
            r1 = r8
            r1.<init>(r2, r3, r4, r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wortise.ads.u3.<init>(android.webkit.WebResourceRequest):void");
    }
}

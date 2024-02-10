package com.mbridge.msdk.e.a;

import android.net.Uri;
import android.text.TextUtils;
import com.mbridge.msdk.e.a.a;
import com.mbridge.msdk.e.a.a.d;
import com.mbridge.msdk.e.a.o;
import com.mbridge.msdk.e.a.v;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.Map;
import kotlin.text.Typography;

/* compiled from: Request */
public abstract class m<T> implements Comparable<m<T>> {
    private c a;
    private String b;
    private p c;
    private final v.a d;
    private final int e;
    private final String f;
    private final int g;
    private final int h;
    private final Object i;
    private o.a j;
    private Integer k;
    private n l;
    private boolean m;
    private boolean n;
    private boolean o;
    private boolean p;
    private boolean q;
    private r r;
    private a.C0133a s;
    private a t;

    /* compiled from: Request */
    interface a {
        void a(m<?> mVar);

        void a(m<?> mVar, o<?> oVar);
    }

    /* compiled from: Request */
    public enum b {
        LOW,
        NORMAL,
        HIGH,
        IMMEDIATE
    }

    /* access modifiers changed from: protected */
    public abstract o<T> a(k kVar);

    /* access modifiers changed from: protected */
    public abstract void a(T t2);

    /* access modifiers changed from: protected */
    public Map<String, String> b() {
        return null;
    }

    public final String m() {
        return "application/x-www-form-urlencoded; charset=UTF-8";
    }

    public /* synthetic */ int compareTo(Object obj) {
        m mVar = (m) obj;
        b d2 = d();
        b d3 = mVar.d();
        return d2 == d3 ? this.k.intValue() - mVar.k.intValue() : d3.ordinal() - d2.ordinal();
    }

    public m(int i2, String str) {
        this(i2, str, 0);
    }

    public m(int i2, String str, int i3) {
        Uri parse;
        String host;
        this.d = null;
        this.i = new Object();
        int i4 = 0;
        this.m = false;
        this.n = false;
        this.o = false;
        this.p = false;
        this.q = false;
        this.s = null;
        this.e = i2;
        this.f = str;
        this.g = i3;
        this.r = new e();
        if (!(TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null || (host = parse.getHost()) == null)) {
            i4 = host.hashCode();
        }
        this.h = i4;
    }

    public final void a(o.a aVar) {
        this.j = aVar;
    }

    public final int e() {
        return this.g;
    }

    public final int f() {
        return this.e;
    }

    public final int g() {
        return this.h;
    }

    /* access modifiers changed from: package-private */
    public final void a(String str) {
        n nVar = this.l;
        if (nVar != null) {
            nVar.b(this);
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2) {
        n nVar = this.l;
        if (nVar != null) {
            nVar.a(this, i2);
        }
    }

    public final m<?> a(n nVar) {
        this.l = nVar;
        return this;
    }

    public final m<?> b(int i2) {
        this.k = Integer.valueOf(i2);
        return this;
    }

    public final String h() {
        return this.f;
    }

    public final String i() {
        if (!TextUtils.isEmpty(this.b)) {
            return this.b;
        }
        if (this.a == null) {
            this.a = new d();
        }
        String a2 = this.a.a(this);
        this.b = a2;
        return a2;
    }

    public final p j() {
        return this.c;
    }

    public final m<?> a(a.C0133a aVar) {
        this.s = aVar;
        return this;
    }

    public final a.C0133a k() {
        return this.s;
    }

    public final boolean l() {
        boolean z;
        synchronized (this.i) {
            z = this.n;
        }
        return z;
    }

    public Map<String, String> c() {
        return Collections.emptyMap();
    }

    public final byte[] n() {
        Map<String, String> b2 = b();
        if (b2 == null || b2.size() <= 0) {
            return null;
        }
        return a(b2, "UTF-8");
    }

    private byte[] a(Map<String, String> map, String str) {
        StringBuilder sb = new StringBuilder();
        try {
            int i2 = 0;
            for (Map.Entry next : map.entrySet()) {
                i2++;
                if (next.getKey() == null || next.getValue() == null) {
                    throw new IllegalArgumentException(String.format("Request#getParams() or Request#getPostParams() returned a map containing a null key or value: (%s, %s). All keys and values must be non-null.", new Object[]{next.getKey(), next.getValue()}));
                }
                sb.append(URLEncoder.encode((String) next.getKey(), str));
                sb.append('=');
                sb.append(URLEncoder.encode((String) next.getValue(), str));
                if (i2 <= map.size() - 1) {
                    sb.append(Typography.amp);
                }
            }
            return sb.toString().getBytes(str);
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException("Encoding not supported: " + str, e2);
        }
    }

    public final m<?> a(boolean z) {
        this.m = z;
        return this;
    }

    public final boolean o() {
        return this.m;
    }

    public final m<?> b(boolean z) {
        this.p = z;
        return this;
    }

    public final boolean p() {
        return this.p;
    }

    public final m<?> c(boolean z) {
        this.q = z;
        return this;
    }

    public final boolean q() {
        return this.q;
    }

    public b d() {
        return b.NORMAL;
    }

    public final int r() {
        return a().a();
    }

    public r a() {
        return this.r;
    }

    public final void s() {
        synchronized (this.i) {
            this.o = true;
        }
    }

    public final boolean t() {
        boolean z;
        synchronized (this.i) {
            z = this.o;
        }
        return z;
    }

    public final void a(u uVar) {
        o.a aVar;
        synchronized (this.i) {
            aVar = this.j;
        }
        if (aVar != null) {
            aVar.a(uVar);
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(a aVar) {
        synchronized (this.i) {
            this.t = aVar;
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(o<?> oVar) {
        a aVar;
        synchronized (this.i) {
            aVar = this.t;
        }
        if (aVar != null) {
            aVar.a(this, oVar);
        }
    }

    /* access modifiers changed from: package-private */
    public final void u() {
        a aVar;
        synchronized (this.i) {
            aVar = this.t;
        }
        if (aVar != null) {
            aVar.a(this);
        }
    }

    public String toString() {
        String str = "0x" + Integer.toHexString(this.h);
        StringBuilder sb = new StringBuilder();
        sb.append(l() ? "[X] " : "[ ] ");
        sb.append(this.f);
        sb.append(" ");
        sb.append(str);
        sb.append(" ");
        sb.append(d());
        sb.append(" ");
        sb.append(this.k);
        return sb.toString();
    }
}

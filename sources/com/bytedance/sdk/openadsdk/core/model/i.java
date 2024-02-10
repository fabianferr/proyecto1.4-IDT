package com.bytedance.sdk.openadsdk.core.model;

import android.util.SparseArray;
import com.bytedance.sdk.component.f.c.d;
import com.bytedance.sdk.openadsdk.core.b.c;
import com.bytedance.sdk.openadsdk.core.g.b.c;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ClickEventModel */
public class i {
    private final int[] a;
    private final int[] b;
    private final int[] c;
    private final int[] d;
    private final float e;
    private final float f;
    private final float g;
    private final float h;
    private final long i;
    private final long j;
    private final int k;
    private final int l;
    private final int m;
    private final int n;
    private final SparseArray<c.a> o;
    private final int p;
    private final JSONObject q;
    private final String r;

    /* compiled from: ClickEventModel */
    public static class a {
        float a;
        int b;
        float c;
        private long d;
        private long e;
        private float f;
        private float g;
        private float h;
        private float i;
        /* access modifiers changed from: private */
        public int[] j;
        /* access modifiers changed from: private */
        public int[] k;
        /* access modifiers changed from: private */
        public int[] l;
        /* access modifiers changed from: private */
        public int[] m;
        private int n;
        private int o;
        private int p;
        /* access modifiers changed from: private */
        public SparseArray<c.a> q;
        private int r;
        /* access modifiers changed from: private */
        public String s;
        private int t;
        /* access modifiers changed from: private */
        public JSONObject u;

        static /* synthetic */ float e(a aVar) {
            float f2 = aVar.i;
            while (true) {
                char c2 = '^';
                char c3 = 'K';
                while (true) {
                    switch (c2) {
                        case '\\':
                            switch (c3) {
                                case 21:
                                    break;
                                case 22:
                                case 23:
                                    break;
                            }
                        case ']':
                            break;
                        case '^':
                            break;
                    }
                    c3 = AbstractJsonLexerKt.END_LIST;
                    c2 = AbstractJsonLexerKt.END_LIST;
                }
                while (true) {
                    switch (c3) {
                        case '[':
                        case '\\':
                        case ']':
                            break;
                        default:
                            c3 = AbstractJsonLexerKt.BEGIN_LIST;
                    }
                }
            }
            return f2;
        }

        static /* synthetic */ float f(a aVar) {
            float f2 = aVar.h;
            while (true) {
                char c2 = '^';
                char c3 = 'K';
                while (true) {
                    switch (c2) {
                        case '\\':
                            switch (c3) {
                                case 21:
                                    break;
                                case 22:
                                case 23:
                                    break;
                            }
                        case ']':
                            break;
                        case '^':
                            break;
                    }
                    c3 = AbstractJsonLexerKt.END_LIST;
                    c2 = AbstractJsonLexerKt.END_LIST;
                }
                while (true) {
                    switch (c3) {
                        case '[':
                        case '\\':
                        case ']':
                            break;
                        default:
                            c3 = AbstractJsonLexerKt.BEGIN_LIST;
                    }
                }
            }
            return f2;
        }

        static /* synthetic */ float g(a aVar) {
            float f2 = aVar.g;
            while (true) {
                char c2 = AbstractJsonLexerKt.END_LIST;
                char c3 = AbstractJsonLexerKt.END_LIST;
                while (true) {
                    switch (c2) {
                        case '\\':
                            switch (c3) {
                                case 21:
                                    break;
                                case 22:
                                case 23:
                                    break;
                            }
                        case ']':
                            break;
                        case '^':
                            if (c3 > 4) {
                                break;
                            } else {
                                continue;
                            }
                    }
                    while (true) {
                        switch (c3) {
                            case '[':
                            case ']':
                                break;
                            case '\\':
                                break;
                            default:
                                c3 = AbstractJsonLexerKt.BEGIN_LIST;
                        }
                    }
                    c2 = '^';
                    c3 = 'K';
                }
            }
            return f2;
        }

        static /* synthetic */ float h(a aVar) {
            float f2 = aVar.f;
            while (true) {
                char c2 = AbstractJsonLexerKt.END_LIST;
                char c3 = AbstractJsonLexerKt.END_LIST;
                while (true) {
                    switch (c2) {
                        case '\\':
                            switch (c3) {
                                case 21:
                                    break;
                                case 22:
                                case 23:
                                    break;
                            }
                        case ']':
                            break;
                        case '^':
                            if (c3 > 4) {
                                break;
                            } else {
                                continue;
                            }
                    }
                    while (true) {
                        switch (c3) {
                            case '[':
                            case ']':
                                break;
                            case '\\':
                                break;
                            default:
                                c3 = AbstractJsonLexerKt.BEGIN_LIST;
                        }
                    }
                    c2 = '^';
                    c3 = 'K';
                }
            }
            return f2;
        }

        static /* synthetic */ long i(a aVar) {
            long j2 = aVar.e;
            while (true) {
                char c2 = AbstractJsonLexerKt.END_LIST;
                char c3 = AbstractJsonLexerKt.END_LIST;
                while (true) {
                    switch (c2) {
                        case '\\':
                            switch (c3) {
                                case 21:
                                    break;
                                case 22:
                                case 23:
                                    break;
                            }
                        case ']':
                            break;
                        case '^':
                            if (c3 > 4) {
                                break;
                            } else {
                                continue;
                            }
                    }
                    while (true) {
                        switch (c3) {
                            case '[':
                            case ']':
                                break;
                            case '\\':
                                break;
                            default:
                                c3 = AbstractJsonLexerKt.BEGIN_LIST;
                        }
                    }
                    c2 = '^';
                    c3 = 'K';
                }
            }
            return j2;
        }

        static /* synthetic */ long j(a aVar) {
            long j2 = aVar.d;
            while (true) {
                char c2 = '^';
                char c3 = 'K';
                while (true) {
                    switch (c2) {
                        case '\\':
                            switch (c3) {
                                case 21:
                                    break;
                                case 22:
                                case 23:
                                    break;
                            }
                        case ']':
                            break;
                        case '^':
                            break;
                    }
                    c3 = AbstractJsonLexerKt.END_LIST;
                    c2 = AbstractJsonLexerKt.END_LIST;
                }
                while (true) {
                    switch (c3) {
                        case '[':
                        case '\\':
                        case ']':
                            break;
                        default:
                            c3 = AbstractJsonLexerKt.BEGIN_LIST;
                    }
                }
            }
            return j2;
        }

        static /* synthetic */ int k(a aVar) {
            int i2 = aVar.n;
            while (true) {
                char c2 = AbstractJsonLexerKt.END_LIST;
                char c3 = AbstractJsonLexerKt.END_LIST;
                while (true) {
                    switch (c2) {
                        case '\\':
                            switch (c3) {
                                case 21:
                                    break;
                                case 22:
                                case 23:
                                    break;
                            }
                        case ']':
                            break;
                        case '^':
                            if (c3 > 4) {
                                break;
                            } else {
                                continue;
                            }
                    }
                    while (true) {
                        switch (c3) {
                            case '[':
                            case ']':
                                break;
                            case '\\':
                                break;
                            default:
                                c3 = AbstractJsonLexerKt.BEGIN_LIST;
                        }
                    }
                    c2 = '^';
                    c3 = 'K';
                }
            }
            return i2;
        }

        static /* synthetic */ int l(a aVar) {
            int i2 = aVar.o;
            while (true) {
                char c2 = '^';
                char c3 = 'K';
                while (true) {
                    switch (c2) {
                        case '\\':
                            switch (c3) {
                                case 21:
                                    break;
                                case 22:
                                case 23:
                                    break;
                            }
                        case ']':
                            break;
                        case '^':
                            break;
                    }
                    c3 = AbstractJsonLexerKt.END_LIST;
                    c2 = AbstractJsonLexerKt.END_LIST;
                }
                while (true) {
                    switch (c3) {
                        case '[':
                        case '\\':
                        case ']':
                            break;
                        default:
                            c3 = AbstractJsonLexerKt.BEGIN_LIST;
                    }
                }
            }
            return i2;
        }

        static /* synthetic */ int m(a aVar) {
            int i2 = aVar.p;
            while (true) {
                char c2 = AbstractJsonLexerKt.END_LIST;
                char c3 = AbstractJsonLexerKt.END_LIST;
                while (true) {
                    switch (c2) {
                        case '\\':
                            switch (c3) {
                                case 21:
                                    break;
                                case 22:
                                case 23:
                                    break;
                            }
                        case ']':
                            break;
                        case '^':
                            if (c3 > 4) {
                                break;
                            } else {
                                continue;
                            }
                    }
                    while (true) {
                        switch (c3) {
                            case '[':
                            case ']':
                                break;
                            case '\\':
                                break;
                            default:
                                c3 = AbstractJsonLexerKt.BEGIN_LIST;
                        }
                    }
                    c2 = '^';
                    c3 = 'K';
                }
            }
            return i2;
        }

        static /* synthetic */ int n(a aVar) {
            int i2 = aVar.r;
            while (true) {
                char c2 = AbstractJsonLexerKt.END_LIST;
                char c3 = AbstractJsonLexerKt.END_LIST;
                while (true) {
                    switch (c2) {
                        case '\\':
                            switch (c3) {
                                case 21:
                                    break;
                                case 22:
                                case 23:
                                    break;
                            }
                        case ']':
                            break;
                        case '^':
                            if (c3 > 4) {
                                break;
                            } else {
                                continue;
                            }
                    }
                    while (true) {
                        switch (c3) {
                            case '[':
                            case ']':
                                break;
                            case '\\':
                                break;
                            default:
                                c3 = AbstractJsonLexerKt.BEGIN_LIST;
                        }
                    }
                    c2 = '^';
                    c3 = 'K';
                }
            }
            return i2;
        }

        static /* synthetic */ int q(a aVar) {
            int i2 = aVar.t;
            while (true) {
                char c2 = '^';
                char c3 = 'K';
                while (true) {
                    switch (c2) {
                        case '\\':
                            switch (c3) {
                                case 21:
                                    break;
                                case 22:
                                case 23:
                                    break;
                            }
                        case ']':
                            break;
                        case '^':
                            break;
                    }
                    c3 = AbstractJsonLexerKt.END_LIST;
                    c2 = AbstractJsonLexerKt.END_LIST;
                }
                while (true) {
                    switch (c3) {
                        case '[':
                        case '\\':
                        case ']':
                            break;
                        default:
                            c3 = AbstractJsonLexerKt.BEGIN_LIST;
                    }
                }
            }
            return i2;
        }

        public a a(float f2) {
            this.a = f2;
            return this;
        }

        public a a(int i2) {
            this.t = i2;
            return this;
        }

        public a a(long j2) {
            this.d = j2;
            return this;
        }

        public a a(SparseArray<c.a> sparseArray) {
            this.q = sparseArray;
            return this;
        }

        public a a(String str) {
            this.s = str;
            return this;
        }

        public a a(JSONObject jSONObject) {
            this.u = jSONObject;
            return this;
        }

        public a a(int[] iArr) {
            this.j = iArr;
            return this;
        }

        public i a() {
            return new i(this);
        }

        public a b(float f2) {
            this.c = f2;
            return this;
        }

        public a b(int i2) {
            this.r = i2;
            return this;
        }

        public a b(long j2) {
            this.e = j2;
            return this;
        }

        public a b(int[] iArr) {
            this.k = iArr;
            return this;
        }

        public a c(float f2) {
            this.f = f2;
            return this;
        }

        public a c(int i2) {
            this.b = i2;
            return this;
        }

        public a c(int[] iArr) {
            this.l = iArr;
            return this;
        }

        public a d(float f2) {
            this.g = f2;
            return this;
        }

        public a d(int i2) {
            this.n = i2;
            return this;
        }

        public a d(int[] iArr) {
            this.m = iArr;
            return this;
        }

        public a e(float f2) {
            this.h = f2;
            return this;
        }

        public a e(int i2) {
            this.o = i2;
            return this;
        }

        public a f(float f2) {
            this.i = f2;
            return this;
        }

        public a f(int i2) {
            this.p = i2;
            return this;
        }
    }

    private i(a aVar) {
        this.a = aVar.k;
        this.b = aVar.l;
        this.d = aVar.m;
        this.c = aVar.j;
        this.e = a.e(aVar);
        this.f = a.f(aVar);
        this.g = a.g(aVar);
        this.h = a.h(aVar);
        this.i = a.i(aVar);
        this.j = a.j(aVar);
        this.k = a.k(aVar);
        this.l = a.l(aVar);
        this.m = a.m(aVar);
        this.n = a.n(aVar);
        this.o = aVar.q;
        this.r = aVar.s;
        this.p = a.q(aVar);
        this.q = aVar.u;
    }

    public static JSONObject a(SparseArray<c.a> sparseArray, int i2) {
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            if (sparseArray != null) {
                for (int i3 = 0; i3 < sparseArray.size(); i3++) {
                    c.a valueAt = sparseArray.valueAt(i3);
                    if (valueAt != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.putOpt(c.b.c$b1699434667869dc("fnp`a"), Double.valueOf(valueAt.c)).putOpt(c.b.c$b1699434667869dc("ms"), Double.valueOf(valueAt.b)).putOpt(c.b.c$b1699434667869dc("picpa"), Integer.valueOf(valueAt.a)).putOpt(c.b.c$b1699434667869dc("tr"), Long.valueOf(valueAt.d));
                        jSONArray.put(jSONObject2);
                        jSONObject.putOpt(c.b.c$b1699434667869dc("fua"), Integer.valueOf(i2)).putOpt(c.b.c$b1699434667869dc("iodl"), jSONArray);
                    }
                }
            }
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0026, code lost:
        r0 = 'J';
        r1 = '7';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000b, code lost:
        switch(r1) {
            case 55: goto L_0x000f;
            case 56: goto L_0x0026;
            case 57: goto L_0x0026;
            default: goto L_0x000e;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000f, code lost:
        r2 = r2.toCharArray();
        r0 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0015, code lost:
        if (r0 >= r2.length) goto L_0x0020;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0017, code lost:
        r2[r0] = (char) (r2[r0] ^ r0);
        r0 = r0 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0025, code lost:
        return new java.lang.String(r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String i1699434667884dc(java.lang.String r2) {
        /*
        L_0x0000:
            r0 = 73
            r1 = 96
        L_0x0004:
            switch(r0) {
                case 72: goto L_0x0026;
                case 73: goto L_0x0008;
                case 74: goto L_0x000b;
                default: goto L_0x0007;
            }
        L_0x0007:
            goto L_0x002b
        L_0x0008:
            switch(r1) {
                case 94: goto L_0x0000;
                case 95: goto L_0x0026;
                case 96: goto L_0x0026;
                default: goto L_0x000b;
            }
        L_0x000b:
            switch(r1) {
                case 55: goto L_0x000f;
                case 56: goto L_0x0026;
                case 57: goto L_0x0026;
                default: goto L_0x000e;
            }
        L_0x000e:
            goto L_0x0000
        L_0x000f:
            char[] r2 = r2.toCharArray()
            r0 = 0
        L_0x0014:
            int r1 = r2.length
            if (r0 >= r1) goto L_0x0020
            char r1 = r2[r0]
            r1 = r1 ^ r0
            char r1 = (char) r1
            r2[r0] = r1
            int r0 = r0 + 1
            goto L_0x0014
        L_0x0020:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r2)
            return r0
        L_0x0026:
            r0 = 74
            r1 = 55
            goto L_0x0004
        L_0x002b:
            r0 = 72
            goto L_0x0004
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.model.i.i1699434667884dc(java.lang.String):java.lang.String");
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            int[] iArr = this.a;
            if (iArr != null && iArr.length == 2) {
                jSONObject.putOpt(d.d1699434667873dc("ae]{"), Integer.valueOf(this.a[0])).putOpt(d.d1699434667873dc("ae]z"), Integer.valueOf(this.a[1]));
            }
            int[] iArr2 = this.b;
            if (iArr2 != null && iArr2.length == 2) {
                jSONObject.putOpt(d.d1699434667873dc("whfwl"), Integer.valueOf(this.b[0])).putOpt(d.d1699434667873dc("hdkdlq"), Integer.valueOf(this.b[1]));
            }
            int[] iArr3 = this.c;
            if (iArr3 != null && iArr3.length == 2) {
                jSONObject.putOpt(d.d1699434667873dc("btvwkkY"), Integer.valueOf(this.c[0])).putOpt(d.d1699434667873dc("btvwkkY~"), Integer.valueOf(this.c[1]));
            }
            int[] iArr4 = this.d;
            if (iArr4 != null && iArr4.length == 2) {
                jSONObject.putOpt(d.d1699434667873dc("btvwkkYpam~c"), Integer.valueOf(this.d[0])).putOpt(d.d1699434667873dc("btvwkkYom`mcx"), Integer.valueOf(this.d[1]));
            }
            jSONObject.putOpt(d.d1699434667873dc("dnum[}"), Float.toString(this.e)).putOpt(d.d1699434667873dc("dnum[|"), Float.toString(this.f)).putOpt(d.d1699434667873dc("uq]{"), Float.toString(this.g)).putOpt(d.d1699434667873dc("uq]z"), Float.toString(this.h)).putOpt(d.d1699434667873dc("dnum[qojm"), Long.valueOf(this.i)).putOpt(d.d1699434667873dc("uq]wmhc"), Long.valueOf(this.j)).putOpt(d.d1699434667873dc("tnmoP|vb"), Integer.valueOf(this.k)).putOpt(d.d1699434667873dc("ddtjg`Oc"), Integer.valueOf(this.l)).putOpt(d.d1699434667873dc("snwqg`"), Integer.valueOf(this.m)).putOpt(d.d1699434667873dc("fu"), a(this.o, this.n)).putOpt(d.d1699434667873dc("cmk`oZgumhUu}k"), this.r);
            if (this.p > 0) {
                jSONObject.putOpt(d.d1699434667873dc("asgbP|vb"), Integer.valueOf(this.p));
            }
            if (this.q != null) {
                jSONObject.putOpt(d.d1699434667873dc("rdawMk`h"), this.q);
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }
}

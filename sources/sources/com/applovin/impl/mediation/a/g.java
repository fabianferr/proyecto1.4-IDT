package com.applovin.impl.mediation.a;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class g {
    private final h a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;

    public interface a {
        void a(g gVar);
    }

    private g(h hVar, com.applovin.impl.mediation.g gVar, String str, String str2) {
        String str3;
        this.a = hVar;
        this.d = str;
        this.e = str2;
        if (gVar != null) {
            this.b = gVar.h();
            str3 = gVar.i();
        } else {
            str3 = null;
            this.b = null;
        }
        this.c = str3;
    }

    public static g a(h hVar, com.applovin.impl.mediation.g gVar, String str) {
        if (hVar == null) {
            throw new IllegalArgumentException("No spec specified");
        } else if (gVar != null) {
            return new g(hVar, gVar, str, (String) null);
        } else {
            throw new IllegalArgumentException("No adapterWrapper specified");
        }
    }

    public static g a(h hVar, String str) {
        return b(hVar, (com.applovin.impl.mediation.g) null, str);
    }

    public static g b(h hVar, com.applovin.impl.mediation.g gVar, String str) {
        if (hVar != null) {
            return new g(hVar, gVar, (String) null, str);
        }
        throw new IllegalArgumentException("No spec specified");
    }

    public h a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    public String d() {
        return this.d;
    }

    public String e() {
        return this.e;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("SignalCollectionResult{mSignalProviderSpec=");
        sb.append(this.a);
        sb.append(", mSdkVersion='");
        sb.append(this.b);
        sb.append("', mAdapterVersion='");
        sb.append(this.c);
        sb.append("', mSignalDataLength='");
        String str = this.d;
        sb.append(str != null ? str.length() : 0);
        sb.append("', mErrorMessage=");
        sb.append(this.e);
        sb.append(AbstractJsonLexerKt.END_OBJ);
        return sb.toString();
    }
}

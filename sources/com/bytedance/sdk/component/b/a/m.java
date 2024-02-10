package com.bytedance.sdk.component.b.a;

/* compiled from: RequestBody */
public class m {
    public i c;
    public String d;
    public byte[] e;
    public a f;

    /* compiled from: RequestBody */
    public enum a {
        STRING_TYPE,
        BYTE_ARRAY_TYPE
    }

    public m() {
    }

    public String a() {
        return this.d;
    }

    public m(i iVar, String str, a aVar) {
        this.c = iVar;
        this.d = str;
        this.f = aVar;
    }

    public m(i iVar, byte[] bArr, a aVar) {
        this.c = iVar;
        this.e = bArr;
        this.f = aVar;
    }

    public static m a(i iVar, String str) {
        return new m(iVar, str, a.STRING_TYPE);
    }

    public static m a(i iVar, byte[] bArr) {
        return new m(iVar, bArr, a.BYTE_ARRAY_TYPE);
    }
}

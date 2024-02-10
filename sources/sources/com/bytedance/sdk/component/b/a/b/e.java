package com.bytedance.sdk.component.b.a.b;

/* compiled from: Segment */
final class e {
    final byte[] a;
    int b;
    int c;
    boolean d;
    boolean e;
    e f;
    e g;

    e() {
        this.a = new byte[8192];
        this.e = true;
        this.d = false;
    }

    e(byte[] bArr, int i, int i2, boolean z, boolean z2) {
        this.a = bArr;
        this.b = i;
        this.c = i2;
        this.d = z;
        this.e = z2;
    }

    /* access modifiers changed from: package-private */
    public final e a() {
        this.d = true;
        return new e(this.a, this.b, this.c, true, false);
    }

    public final e b() {
        e eVar = this.f;
        e eVar2 = eVar != this ? eVar : null;
        e eVar3 = this.g;
        if (eVar3 != null) {
            eVar3.f = eVar;
        }
        e eVar4 = this.f;
        if (eVar4 != null) {
            eVar4.g = eVar3;
        }
        this.f = null;
        this.g = null;
        return eVar2;
    }

    public final e a(e eVar) {
        eVar.g = this;
        eVar.f = this.f;
        this.f.g = eVar;
        this.f = eVar;
        return eVar;
    }
}

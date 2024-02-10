package com.bytedance.sdk.component.d.d;

import com.bytedance.sdk.component.d.c.c;
import com.bytedance.sdk.component.d.c.c.a;
import com.bytedance.sdk.component.d.f;
import com.bytedance.sdk.component.d.u;

/* compiled from: BytesVisitor */
public class b implements i {
    private byte[] a;
    private f b;

    public String a() {
        return "image_type";
    }

    public b(byte[] bArr, f fVar) {
        this.a = bArr;
        this.b = fVar;
    }

    public void a(c cVar) {
        i iVar;
        u k = cVar.k();
        cVar.a(this.a.length);
        int i = AnonymousClass1.a[k.ordinal()];
        if (i == 1) {
            byte[] bArr = this.a;
            iVar = new m(bArr, this.b, a.b(bArr));
        } else if (i != 3) {
            if (a.a(this.a)) {
                iVar = new e(this.a, this.b);
            } else {
                byte[] bArr2 = this.a;
                iVar = new m(bArr2, this.b, a.b(bArr2));
            }
        } else if (a.a(this.a)) {
            iVar = new e(this.a, this.b);
        } else if (this.b == null) {
            iVar = new k();
        } else {
            iVar = new h(1001, "not image format", (Throwable) null);
        }
        cVar.a(iVar);
    }

    /* renamed from: com.bytedance.sdk.component.d.d.b$1  reason: invalid class name */
    /* compiled from: BytesVisitor */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.bytedance.sdk.component.d.u[] r0 = com.bytedance.sdk.component.d.u.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                com.bytedance.sdk.component.d.u r1 = com.bytedance.sdk.component.d.u.RAW     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.bytedance.sdk.component.d.u r1 = com.bytedance.sdk.component.d.u.AUTO     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.bytedance.sdk.component.d.u r1 = com.bytedance.sdk.component.d.u.BITMAP     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.d.d.b.AnonymousClass1.<clinit>():void");
        }
    }
}

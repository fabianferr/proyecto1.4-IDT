package com.bytedance.sdk.openadsdk.k.a;

import android.graphics.Bitmap;
import com.bytedance.sdk.component.utils.d;
import com.bytedance.sdk.component.utils.l;
import java.util.List;
import java.util.Map;

/* compiled from: GifRequestResult */
public class b {
    int a;
    private byte[] b;
    private Bitmap c;
    private Bitmap d;
    private List<Object> e;
    private Map<String, String> f;

    public b(byte[] bArr, int i) {
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.b = bArr;
        this.a = i;
    }

    public b(Bitmap bitmap, Bitmap bitmap2, int i) {
        this.b = null;
        this.e = null;
        this.f = null;
        this.d = bitmap2;
        this.c = bitmap;
        this.a = i;
    }

    public Bitmap a() {
        return this.c;
    }

    public Bitmap b() {
        return this.d;
    }

    public byte[] c() {
        try {
            if (this.b == null) {
                this.b = d.a(this.c);
            }
        } catch (OutOfMemoryError e2) {
            l.e("GifRequestResult", e2.getMessage());
        }
        return this.b;
    }

    public boolean d() {
        if (this.c != null) {
            return true;
        }
        byte[] bArr = this.b;
        if (bArr == null || bArr.length <= 0) {
            return false;
        }
        return true;
    }
}

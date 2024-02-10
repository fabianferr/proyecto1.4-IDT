package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.b.a;
import com.bytedance.sdk.openadsdk.core.b.c;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.model.i;
import com.bytedance.sdk.openadsdk.core.model.m;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.utils.ad;
import org.json.JSONObject;

/* compiled from: ExpressClickCreativeListener */
public class f extends a {
    public f(Context context, q qVar, String str, int i) {
        super(context, qVar, str, i);
    }

    /* access modifiers changed from: protected */
    public i a(float f, float f2, float f3, float f4, SparseArray<c.a> sparseArray, long j, long j2, View view, View view2, String str, float f5, int i, float f6, int i2, JSONObject jSONObject) {
        float f7;
        float f8;
        float f9;
        float f10;
        int i3;
        int i4;
        long j3;
        long j4;
        int i5;
        char c;
        char c2;
        int i6;
        int[] a = ad.a(view);
        int i7 = 0;
        if (a == null || a.length != 2) {
            f10 = f;
            f9 = f2;
            f8 = f3;
            f7 = f4;
            i4 = 0;
            i3 = 0;
        } else {
            i4 = a[0];
            i3 = a[1];
            if (this.s == 0) {
                f7 = ((float) (ad.b(this.c, f4) + i3)) - 0.5f;
                f8 = ((float) (ad.b(this.c, f3) + i4)) - 0.5f;
                f10 = ((float) (ad.b(this.c, f) + i4)) - 0.5f;
                f9 = ((float) (ad.b(this.c, f2) + i3)) - 0.5f;
            } else {
                f10 = f;
                f9 = f2;
                f8 = f3;
                f7 = f4;
            }
        }
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        if (this.d != null) {
            j3 = this.d.e;
            j4 = this.d.f;
            if (this.s == 0) {
                iArr[0] = ad.b(this.c, (float) this.d.g) + i4;
                iArr[1] = ad.b(this.c, (float) this.d.h) + i3;
                i6 = ad.b(this.c, (float) this.d.i);
                i5 = ad.b(this.c, (float) this.d.j);
                c2 = 0;
                c = 1;
            } else {
                c2 = 0;
                iArr[0] = this.d.g;
                c = 1;
                iArr[1] = this.d.h;
                i6 = this.d.i;
                i5 = this.d.j;
            }
            iArr2[c2] = i6;
            iArr2[c] = i5;
            if (i6 == 0 && i5 == 0 && view2 != null) {
                iArr = ad.a(view2);
                iArr2 = ad.c(view2);
            }
            i7 = 0;
        } else {
            j3 = j;
            j4 = j2;
        }
        this.s = i7;
        return new i.a().f(f10).e(f9).d(f8).c(f7).b(j3).a(j4).b(a).a(iArr).c(ad.c(view)).d(iArr2).d(this.z).e(this.A).f(this.B).b(h.b().a() ? 1 : 2).a(sparseArray).a(str).a(f5).c(i).b(f6).a(i2).a(jSONObject).a();
    }

    public void a(m mVar) {
        this.d = mVar;
    }
}

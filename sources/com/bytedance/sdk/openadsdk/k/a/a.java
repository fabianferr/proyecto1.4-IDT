package com.bytedance.sdk.openadsdk.k.a;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedance.sdk.component.d.h;
import com.bytedance.sdk.component.d.k;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.f.b;
import com.bytedance.sdk.openadsdk.f.d;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.Map;

/* compiled from: GifLoader */
public class a {

    /* renamed from: com.bytedance.sdk.openadsdk.k.a.a$a  reason: collision with other inner class name */
    /* compiled from: GifLoader */
    public interface C0071a {
        void a();

        void a(int i, String str, Throwable th);

        void a(String str, b bVar);
    }

    /* access modifiers changed from: protected */
    public void a() {
    }

    public void a(com.bytedance.sdk.openadsdk.k.a aVar, final C0071a aVar2, int i, int i2, ImageView.ScaleType scaleType, String str, final int i3, q qVar) {
        d.a(aVar.a).a(aVar.b).a(i).b(i2).d(ad.d(o.a())).c(ad.c(o.a())).b(str).a(Bitmap.Config.RGB_565).a(scaleType).a(!TextUtils.isEmpty(str)).a((h) new h() {
            public Bitmap a(Bitmap bitmap) {
                if (i3 <= 0) {
                    return bitmap;
                }
                return com.bytedance.sdk.component.adexpress.c.a.a(o.a(), bitmap, i3);
            }
        }).a((com.bytedance.sdk.component.d.o) new b(qVar, aVar.a, new com.bytedance.sdk.component.d.o() {
            public void a(k kVar) {
                a.this.a(kVar, aVar2);
            }

            public void a(int i, String str, Throwable th) {
                a.this.a(i, str, th, aVar2);
            }
        }));
        a();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: android.graphics.Bitmap} */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.bytedance.sdk.component.d.k r5, com.bytedance.sdk.openadsdk.k.a.a.C0071a r6) {
        /*
            r4 = this;
            if (r6 == 0) goto L_0x0048
            java.lang.Object r0 = r5.b()
            int r1 = r4.a(r5)
            boolean r2 = r0 instanceof byte[]
            if (r2 == 0) goto L_0x001f
            java.lang.String r5 = r5.a()
            com.bytedance.sdk.openadsdk.k.a.b r2 = new com.bytedance.sdk.openadsdk.k.a.b
            byte[] r0 = (byte[]) r0
            byte[] r0 = (byte[]) r0
            r2.<init>(r0, r1)
            r6.a(r5, r2)
            goto L_0x0048
        L_0x001f:
            boolean r2 = r0 instanceof android.graphics.Bitmap
            r3 = 0
            if (r2 == 0) goto L_0x0042
            java.lang.Object r2 = r5.c()
            boolean r2 = r2 instanceof android.graphics.Bitmap
            if (r2 == 0) goto L_0x0033
            java.lang.Object r2 = r5.c()
            r3 = r2
            android.graphics.Bitmap r3 = (android.graphics.Bitmap) r3
        L_0x0033:
            java.lang.String r5 = r5.a()
            com.bytedance.sdk.openadsdk.k.a.b r2 = new com.bytedance.sdk.openadsdk.k.a.b
            android.graphics.Bitmap r0 = (android.graphics.Bitmap) r0
            r2.<init>(r0, r3, r1)
            r6.a(r5, r2)
            goto L_0x0048
        L_0x0042:
            r5 = 0
            java.lang.String r0 = "not bitmap or gif result!"
            r6.a(r5, r0, r3)
        L_0x0048:
            if (r6 == 0) goto L_0x004d
            r6.a()
        L_0x004d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.k.a.a.a(com.bytedance.sdk.component.d.k, com.bytedance.sdk.openadsdk.k.a.a$a):void");
    }

    private int a(k kVar) {
        String str;
        Map<String, String> d = kVar.d();
        if (d == null || (str = d.get(CampaignEx.JSON_KEY_IMAGE_SIZE)) == null || !(str instanceof Integer)) {
            return 0;
        }
        return ((Integer) str).intValue();
    }

    /* access modifiers changed from: protected */
    public void a(int i, String str, Throwable th, C0071a aVar) {
        if (aVar != null) {
            aVar.a(i, str, th);
        }
    }
}

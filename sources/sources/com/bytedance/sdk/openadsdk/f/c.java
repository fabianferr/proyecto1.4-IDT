package com.bytedance.sdk.openadsdk.f;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.bytedance.sdk.component.d.k;
import com.bytedance.sdk.component.d.o;
import com.bytedance.sdk.openadsdk.core.l;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.utils.aa;
import java.lang.ref.WeakReference;

/* compiled from: ImageLoaderToViewWrapper */
public class c implements o<Bitmap> {
    private final WeakReference<ImageView> a;
    private final String b = "ImageLoaderToViewWrapper";

    public void a(int i, String str, Throwable th) {
    }

    public static o a(q qVar, String str, ImageView imageView) {
        return new b(qVar, str, new c(imageView));
    }

    private c(ImageView imageView) {
        this.a = new WeakReference<>(imageView);
    }

    public void a(k<Bitmap> kVar) {
        final ImageView imageView = (ImageView) this.a.get();
        if (imageView != null && (kVar.b() instanceof Bitmap)) {
            final Bitmap b2 = kVar.b();
            if (aa.e()) {
                imageView.setImageBitmap(b2);
            } else {
                l.c().post(new Runnable() {
                    public void run() {
                        imageView.setImageBitmap(b2);
                    }
                });
            }
        }
    }
}

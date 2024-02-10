package com.google.android.gms.cast.framework.media.internal;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
final class zzq implements zza {
    final /* synthetic */ zzv zza;

    zzq(zzv zzv) {
        this.zza = zzv;
    }

    public final void zza(Bitmap bitmap) {
        int i = zzv.zza;
        Bitmap bitmap2 = null;
        if (bitmap != null) {
            int width = bitmap.getWidth();
            float f = (float) width;
            int height = bitmap.getHeight();
            int i2 = (int) (((9.0f * f) / 16.0f) + 0.5f);
            float f2 = ((float) (i2 - height)) / 2.0f;
            RectF rectF = new RectF(0.0f, f2, f, ((float) height) + f2);
            Bitmap.Config config = bitmap.getConfig();
            if (config == null) {
                config = Bitmap.Config.ARGB_8888;
            }
            Bitmap createBitmap = Bitmap.createBitmap(width, i2, config);
            new Canvas(createBitmap).drawBitmap(bitmap, (Rect) null, rectF, (Paint) null);
            bitmap2 = createBitmap;
        }
        this.zza.zzp(bitmap2, 0);
    }
}

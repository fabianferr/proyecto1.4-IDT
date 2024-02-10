package com.bytedance.sdk.component.d.c.b;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

/* compiled from: DefaultDecoder */
public class a {
    public static final ImageView.ScaleType a = ImageView.ScaleType.CENTER_INSIDE;
    public static final Bitmap.Config b = Bitmap.Config.ARGB_4444;
    private final Bitmap.Config c;
    private int d;
    private int e;
    private final int f;
    private final int g;
    private final ImageView.ScaleType h;
    private final int i = 3840;
    private final int j = 104857600;

    public a(int i2, int i3, ImageView.ScaleType scaleType, Bitmap.Config config, int i4, int i5) {
        this.c = config;
        this.d = i2;
        this.e = i3;
        this.h = scaleType;
        this.f = i4;
        this.g = i5;
        a(i2, i3);
    }

    static int a(int i2, int i3, int i4, int i5, int i6, int i7) {
        double d2 = (double) i2;
        double d3 = (double) i4;
        Double.isNaN(d2);
        Double.isNaN(d3);
        double d4 = d2 / d3;
        double d5 = (double) i3;
        double d6 = (double) i5;
        Double.isNaN(d5);
        Double.isNaN(d6);
        double min = Math.min(d4, d5 / d6);
        if (i6 > 0 && i7 > 0) {
            double max = (double) Math.max(i2, i3);
            double max2 = (double) Math.max(i6, i7);
            Double.isNaN(max);
            Double.isNaN(max2);
            double min2 = (double) Math.min(i2, i3);
            double min3 = (double) Math.min(i6, i7);
            Double.isNaN(min2);
            Double.isNaN(min3);
            min = Math.max(min, Math.min(max / max2, min2 / min3));
        }
        float f2 = 1.0f;
        while (true) {
            float f3 = 2.0f * f2;
            if (((double) f3) > min) {
                return (int) f2;
            }
            f2 = f3;
        }
    }

    private static int a(int i2, int i3, int i4, int i5, ImageView.ScaleType scaleType) {
        if (i2 == 0 && i3 == 0) {
            return i4;
        }
        if (scaleType == ImageView.ScaleType.FIT_XY) {
            return i2 == 0 ? i4 : i2;
        }
        if (i2 == 0) {
            double d2 = (double) i3;
            double d3 = (double) i5;
            Double.isNaN(d2);
            Double.isNaN(d3);
            double d4 = (double) i4;
            Double.isNaN(d4);
            return (int) (d4 * (d2 / d3));
        } else if (i3 == 0) {
            return i2;
        } else {
            double d5 = (double) i5;
            double d6 = (double) i4;
            Double.isNaN(d5);
            Double.isNaN(d6);
            double d7 = d5 / d6;
            if (scaleType == ImageView.ScaleType.CENTER_CROP) {
                double d8 = (double) i2;
                Double.isNaN(d8);
                double d9 = (double) i3;
                if (d8 * d7 >= d9) {
                    return i2;
                }
                Double.isNaN(d9);
                return (int) (d9 / d7);
            }
            double d10 = (double) i2;
            Double.isNaN(d10);
            double d11 = (double) i3;
            if (d10 * d7 <= d11) {
                return i2;
            }
            Double.isNaN(d11);
            return (int) (d11 / d7);
        }
    }

    public Bitmap a(byte[] bArr) {
        Bitmap bitmap;
        BitmapFactory.Options options = new BitmapFactory.Options();
        if (this.d == 0 && this.e == 0) {
            options.inPreferredConfig = this.c;
            bitmap = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        } else {
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            int i2 = options.outWidth;
            int i3 = options.outHeight;
            int a2 = a(this.d, this.e, i2, i3, this.h);
            int a3 = a(this.e, this.d, i3, i2, this.h);
            options.inJustDecodeBounds = false;
            options.inSampleSize = a(i2, i3, a2, a3, this.f, this.g);
            bitmap = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            if (bitmap != null && (bitmap.getWidth() > a2 || bitmap.getHeight() > a3)) {
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, a2, a3, true);
                if (createScaledBitmap != bitmap) {
                    bitmap.recycle();
                }
                bitmap = createScaledBitmap;
            }
        }
        if (bitmap != null && bitmap.getByteCount() > 104857600) {
            int width = bitmap.getWidth() / 2;
            int height = bitmap.getHeight() / 2;
            if (width > 0 && height > 0) {
                Bitmap createScaledBitmap2 = Bitmap.createScaledBitmap(bitmap, width, height, true);
                if (createScaledBitmap2 != bitmap) {
                    bitmap.recycle();
                }
                return createScaledBitmap2;
            }
        }
        return bitmap;
    }

    private void a(int i2, int i3) {
        if (i2 <= 3840 || i3 <= 3840) {
            if (i2 > 3840) {
                this.d = 3840;
                this.e = (i3 * 3840) / i2;
            } else if (i3 > 3840) {
                this.d = (i2 * 3840) / i3;
                this.e = 3840;
            }
        } else if (i2 > i3) {
            this.d = 3840;
            this.e = (i3 * 3840) / i2;
        } else {
            this.d = (i2 * 3840) / i3;
            this.e = 3840;
        }
    }
}

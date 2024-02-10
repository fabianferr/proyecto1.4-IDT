package androidx.core.graphics;

import android.graphics.Bitmap;
import android.graphics.BlendMode;
import android.graphics.ColorSpace;
import android.graphics.Paint;
import android.os.Build;

public final class BitmapCompat {
    public static int sizeAtStep(int i, int i2, int i3, int i4) {
        return i3 == 0 ? i2 : i3 > 0 ? i * (1 << (i4 - i3)) : i2 << ((-i3) - 1);
    }

    public static boolean hasMipMap(Bitmap bitmap) {
        return Api17Impl.hasMipMap(bitmap);
    }

    public static void setHasMipMap(Bitmap bitmap, boolean z) {
        Api17Impl.setHasMipMap(bitmap, z);
    }

    public static int getAllocationByteCount(Bitmap bitmap) {
        return Api19Impl.getAllocationByteCount(bitmap);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:109:0x01a6, code lost:
        if (androidx.core.graphics.BitmapCompat.Api27Impl.isAlreadyF16AndLinear(r10) == false) goto L_0x01b8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap createScaledBitmap(android.graphics.Bitmap r22, int r23, int r24, android.graphics.Rect r25, boolean r26) {
        /*
            r0 = r22
            r1 = r23
            r2 = r24
            r3 = r25
            if (r1 <= 0) goto L_0x020b
            if (r2 <= 0) goto L_0x020b
            if (r3 == 0) goto L_0x0036
            boolean r4 = r25.isEmpty()
            if (r4 != 0) goto L_0x002d
            int r4 = r3.left
            if (r4 < 0) goto L_0x002d
            int r4 = r3.right
            int r5 = r22.getWidth()
            if (r4 > r5) goto L_0x002d
            int r4 = r3.top
            if (r4 < 0) goto L_0x002d
            int r4 = r3.bottom
            int r5 = r22.getHeight()
            if (r4 > r5) goto L_0x002d
            goto L_0x0036
        L_0x002d:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "srcRect must be contained by srcBm!"
            r0.<init>(r1)
            throw r0
        L_0x0036:
            int r4 = android.os.Build.VERSION.SDK_INT
            r5 = 27
            if (r4 < r5) goto L_0x0041
            android.graphics.Bitmap r4 = androidx.core.graphics.BitmapCompat.Api27Impl.copyBitmapIfHardware(r22)
            goto L_0x0042
        L_0x0041:
            r4 = r0
        L_0x0042:
            if (r3 == 0) goto L_0x0049
            int r6 = r25.width()
            goto L_0x004d
        L_0x0049:
            int r6 = r22.getWidth()
        L_0x004d:
            if (r3 == 0) goto L_0x0054
            int r7 = r25.height()
            goto L_0x0058
        L_0x0054:
            int r7 = r22.getHeight()
        L_0x0058:
            float r8 = (float) r1
            float r9 = (float) r6
            float r8 = r8 / r9
            float r9 = (float) r2
            float r10 = (float) r7
            float r9 = r9 / r10
            if (r3 == 0) goto L_0x0063
            int r11 = r3.left
            goto L_0x0064
        L_0x0063:
            r11 = 0
        L_0x0064:
            if (r3 == 0) goto L_0x0069
            int r3 = r3.top
            goto L_0x006a
        L_0x0069:
            r3 = 0
        L_0x006a:
            r12 = 1
            if (r11 != 0) goto L_0x008d
            if (r3 != 0) goto L_0x008d
            int r13 = r22.getWidth()
            if (r1 != r13) goto L_0x008d
            int r13 = r22.getHeight()
            if (r2 != r13) goto L_0x008d
            boolean r1 = r22.isMutable()
            if (r1 == 0) goto L_0x008c
            if (r0 != r4) goto L_0x008c
            android.graphics.Bitmap$Config r1 = r22.getConfig()
            android.graphics.Bitmap r0 = r0.copy(r1, r12)
            return r0
        L_0x008c:
            return r4
        L_0x008d:
            android.graphics.Paint r13 = new android.graphics.Paint
            r13.<init>(r12)
            r13.setFilterBitmap(r12)
            int r14 = android.os.Build.VERSION.SDK_INT
            r15 = 29
            if (r14 < r15) goto L_0x009f
            androidx.core.graphics.BitmapCompat.Api29Impl.setPaintBlendMode(r13)
            goto L_0x00a9
        L_0x009f:
            android.graphics.PorterDuffXfermode r14 = new android.graphics.PorterDuffXfermode
            android.graphics.PorterDuff$Mode r15 = android.graphics.PorterDuff.Mode.SRC
            r14.<init>(r15)
            r13.setXfermode(r14)
        L_0x00a9:
            if (r6 != r1) goto L_0x00c2
            if (r7 != r2) goto L_0x00c2
            android.graphics.Bitmap$Config r0 = r4.getConfig()
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r1, r2, r0)
            android.graphics.Canvas r1 = new android.graphics.Canvas
            r1.<init>(r0)
            int r2 = -r11
            float r2 = (float) r2
            int r3 = -r3
            float r3 = (float) r3
            r1.drawBitmap(r4, r2, r3, r13)
            return r0
        L_0x00c2:
            r14 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r14 = java.lang.Math.log(r14)
            r16 = 1065353216(0x3f800000, float:1.0)
            int r17 = (r8 > r16 ? 1 : (r8 == r16 ? 0 : -1))
            if (r17 <= 0) goto L_0x00db
            r18 = r11
            double r10 = (double) r8
            double r10 = java.lang.Math.log(r10)
            double r10 = r10 / r14
            double r10 = java.lang.Math.ceil(r10)
            goto L_0x00e7
        L_0x00db:
            r18 = r11
            double r10 = (double) r8
            double r10 = java.lang.Math.log(r10)
            double r10 = r10 / r14
            double r10 = java.lang.Math.floor(r10)
        L_0x00e7:
            int r8 = (int) r10
            int r10 = (r9 > r16 ? 1 : (r9 == r16 ? 0 : -1))
            if (r10 <= 0) goto L_0x00f7
            double r9 = (double) r9
            double r9 = java.lang.Math.log(r9)
            double r9 = r9 / r14
            double r9 = java.lang.Math.ceil(r9)
            goto L_0x0101
        L_0x00f7:
            double r9 = (double) r9
            double r9 = java.lang.Math.log(r9)
            double r9 = r9 / r14
            double r9 = java.lang.Math.floor(r9)
        L_0x0101:
            int r9 = (int) r9
            if (r26 == 0) goto L_0x0139
            int r10 = android.os.Build.VERSION.SDK_INT
            if (r10 < r5) goto L_0x0139
            boolean r10 = androidx.core.graphics.BitmapCompat.Api27Impl.isAlreadyF16AndLinear(r22)
            if (r10 != 0) goto L_0x0139
            if (r8 <= 0) goto L_0x0115
            int r10 = sizeAtStep(r6, r1, r12, r8)
            goto L_0x0116
        L_0x0115:
            r10 = r6
        L_0x0116:
            if (r9 <= 0) goto L_0x011d
            int r11 = sizeAtStep(r7, r2, r12, r9)
            goto L_0x011e
        L_0x011d:
            r11 = r7
        L_0x011e:
            android.graphics.Bitmap r10 = androidx.core.graphics.BitmapCompat.Api27Impl.createBitmapWithSourceColorspace(r10, r11, r0, r12)
            android.graphics.Canvas r11 = new android.graphics.Canvas
            r11.<init>(r10)
            r14 = r18
            int r14 = -r14
            float r14 = (float) r14
            int r3 = -r3
            float r3 = (float) r3
            r11.drawBitmap(r4, r14, r3, r13)
            r3 = 0
            r11 = 0
            r14 = 1
            r21 = r10
            r10 = r4
            r4 = r21
            goto L_0x013e
        L_0x0139:
            r14 = r18
            r10 = 0
            r11 = r14
            r14 = 0
        L_0x013e:
            android.graphics.Rect r15 = new android.graphics.Rect
            r15.<init>(r11, r3, r6, r7)
            android.graphics.Rect r3 = new android.graphics.Rect
            r3.<init>()
            r11 = r8
            r16 = r9
        L_0x014b:
            if (r11 != 0) goto L_0x0158
            if (r16 == 0) goto L_0x0150
            goto L_0x0158
        L_0x0150:
            if (r10 == r0) goto L_0x0157
            if (r10 == 0) goto L_0x0157
            r10.recycle()
        L_0x0157:
            return r4
        L_0x0158:
            if (r11 >= 0) goto L_0x015d
            int r11 = r11 + 1
            goto L_0x0161
        L_0x015d:
            if (r11 <= 0) goto L_0x0161
            int r11 = r11 + -1
        L_0x0161:
            if (r16 >= 0) goto L_0x0166
            int r16 = r16 + 1
            goto L_0x016a
        L_0x0166:
            if (r16 <= 0) goto L_0x016a
            int r16 = r16 + -1
        L_0x016a:
            r12 = r16
            int r5 = sizeAtStep(r6, r1, r11, r8)
            r18 = r13
            int r13 = sizeAtStep(r7, r2, r12, r9)
            r19 = r15
            r15 = 0
            r3.set(r15, r15, r5, r13)
            if (r11 != 0) goto L_0x0182
            if (r12 != 0) goto L_0x0182
            r5 = 1
            goto L_0x0183
        L_0x0182:
            r5 = 0
        L_0x0183:
            if (r10 == 0) goto L_0x0193
            int r13 = r10.getWidth()
            if (r13 != r1) goto L_0x0193
            int r13 = r10.getHeight()
            if (r13 != r2) goto L_0x0193
            r13 = 1
            goto L_0x0194
        L_0x0193:
            r13 = 0
        L_0x0194:
            if (r10 == 0) goto L_0x01b6
            if (r10 == r0) goto L_0x01b6
            if (r26 == 0) goto L_0x01a9
            int r15 = android.os.Build.VERSION.SDK_INT
            r20 = r3
            r3 = 27
            if (r15 < r3) goto L_0x01ab
            boolean r3 = androidx.core.graphics.BitmapCompat.Api27Impl.isAlreadyF16AndLinear(r10)
            if (r3 == 0) goto L_0x01b8
            goto L_0x01ab
        L_0x01a9:
            r20 = r3
        L_0x01ab:
            if (r5 == 0) goto L_0x01b2
            if (r13 == 0) goto L_0x01b8
            if (r14 == 0) goto L_0x01b2
            goto L_0x01b8
        L_0x01b2:
            r3 = r10
            r15 = 27
            goto L_0x01eb
        L_0x01b6:
            r20 = r3
        L_0x01b8:
            if (r10 == r0) goto L_0x01bf
            if (r10 == 0) goto L_0x01bf
            r10.recycle()
        L_0x01bf:
            if (r11 <= 0) goto L_0x01c3
            r3 = r14
            goto L_0x01c4
        L_0x01c3:
            r3 = r11
        L_0x01c4:
            int r3 = sizeAtStep(r6, r1, r3, r8)
            if (r12 <= 0) goto L_0x01cc
            r10 = r14
            goto L_0x01cd
        L_0x01cc:
            r10 = r12
        L_0x01cd:
            int r10 = sizeAtStep(r7, r2, r10, r9)
            int r13 = android.os.Build.VERSION.SDK_INT
            r15 = 27
            if (r13 < r15) goto L_0x01e3
            if (r26 == 0) goto L_0x01dd
            if (r5 != 0) goto L_0x01dd
            r5 = 1
            goto L_0x01de
        L_0x01dd:
            r5 = 0
        L_0x01de:
            android.graphics.Bitmap r3 = androidx.core.graphics.BitmapCompat.Api27Impl.createBitmapWithSourceColorspace(r3, r10, r0, r5)
            goto L_0x01eb
        L_0x01e3:
            android.graphics.Bitmap$Config r5 = r4.getConfig()
            android.graphics.Bitmap r3 = android.graphics.Bitmap.createBitmap(r3, r10, r5)
        L_0x01eb:
            android.graphics.Canvas r5 = new android.graphics.Canvas
            r5.<init>(r3)
            r10 = r18
            r13 = r19
            r15 = r20
            r5.drawBitmap(r4, r13, r15, r10)
            r13.set(r15)
            r16 = r12
            r5 = 27
            r12 = 1
            r21 = r4
            r4 = r3
            r3 = r15
            r15 = r13
            r13 = r10
            r10 = r21
            goto L_0x014b
        L_0x020b:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "dstW and dstH must be > 0!"
            r0.<init>(r1)
            goto L_0x0214
        L_0x0213:
            throw r0
        L_0x0214:
            goto L_0x0213
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.BitmapCompat.createScaledBitmap(android.graphics.Bitmap, int, int, android.graphics.Rect, boolean):android.graphics.Bitmap");
    }

    private BitmapCompat() {
    }

    static class Api17Impl {
        private Api17Impl() {
        }

        static boolean hasMipMap(Bitmap bitmap) {
            return bitmap.hasMipMap();
        }

        static void setHasMipMap(Bitmap bitmap, boolean z) {
            bitmap.setHasMipMap(z);
        }
    }

    static class Api19Impl {
        private Api19Impl() {
        }

        static int getAllocationByteCount(Bitmap bitmap) {
            return bitmap.getAllocationByteCount();
        }
    }

    static class Api27Impl {
        private Api27Impl() {
        }

        static Bitmap createBitmapWithSourceColorspace(int i, int i2, Bitmap bitmap, boolean z) {
            Bitmap.Config config = bitmap.getConfig();
            ColorSpace colorSpace = bitmap.getColorSpace();
            ColorSpace colorSpace2 = ColorSpace.get(ColorSpace.Named.LINEAR_EXTENDED_SRGB);
            if (z && !bitmap.getColorSpace().equals(colorSpace2)) {
                config = Bitmap.Config.RGBA_F16;
                colorSpace = colorSpace2;
            } else if (bitmap.getConfig() == Bitmap.Config.HARDWARE) {
                config = Bitmap.Config.ARGB_8888;
                if (Build.VERSION.SDK_INT >= 31) {
                    config = Api31Impl.getHardwareBitmapConfig(bitmap);
                }
            }
            return Bitmap.createBitmap(i, i2, config, bitmap.hasAlpha(), colorSpace);
        }

        static boolean isAlreadyF16AndLinear(Bitmap bitmap) {
            return bitmap.getConfig() == Bitmap.Config.RGBA_F16 && bitmap.getColorSpace().equals(ColorSpace.get(ColorSpace.Named.LINEAR_EXTENDED_SRGB));
        }

        static Bitmap copyBitmapIfHardware(Bitmap bitmap) {
            if (bitmap.getConfig() != Bitmap.Config.HARDWARE) {
                return bitmap;
            }
            Bitmap.Config config = Bitmap.Config.ARGB_8888;
            if (Build.VERSION.SDK_INT >= 31) {
                config = Api31Impl.getHardwareBitmapConfig(bitmap);
            }
            return bitmap.copy(config, true);
        }
    }

    static class Api29Impl {
        private Api29Impl() {
        }

        static void setPaintBlendMode(Paint paint) {
            paint.setBlendMode(BlendMode.SRC);
        }
    }

    static class Api31Impl {
        private Api31Impl() {
        }

        static Bitmap.Config getHardwareBitmapConfig(Bitmap bitmap) {
            if (bitmap.getHardwareBuffer().getFormat() == 22) {
                return Bitmap.Config.RGBA_F16;
            }
            return Bitmap.Config.ARGB_8888;
        }
    }
}

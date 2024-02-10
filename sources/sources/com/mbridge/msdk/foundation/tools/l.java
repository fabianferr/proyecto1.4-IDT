package com.mbridge.msdk.foundation.tools;

import android.graphics.Bitmap;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import java.lang.reflect.Array;

/* compiled from: FastBlurUtil */
public final class l {
    public static int a = 2048;

    public static Bitmap a(Bitmap bitmap, int i) {
        int[] iArr;
        int i2 = i <= 0 ? 10 : i;
        int width = bitmap.getWidth() / i2;
        int height = bitmap.getHeight() / i2;
        int i3 = 0;
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, width, height, false);
        int width2 = createScaledBitmap.getWidth();
        int height2 = createScaledBitmap.getHeight();
        int i4 = width2 * height2;
        int[] iArr2 = new int[i4];
        createScaledBitmap.getPixels(iArr2, 0, width2, 0, 0, width2, height2);
        int i5 = width2 - 1;
        int i6 = height2 - 1;
        int[] iArr3 = new int[i4];
        int[] iArr4 = new int[i4];
        int[] iArr5 = new int[i4];
        int[] iArr6 = new int[Math.max(width2, height2)];
        int[] iArr7 = new int[20736];
        for (int i7 = 0; i7 < 20736; i7++) {
            iArr7[i7] = i7 / 81;
        }
        int[] iArr8 = new int[2];
        iArr8[1] = 3;
        iArr8[0] = 17;
        int[][] iArr9 = (int[][]) Array.newInstance(Integer.TYPE, iArr8);
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        while (true) {
            if (i8 >= height2) {
                break;
            }
            int i11 = -8;
            int i12 = 0;
            int i13 = 0;
            int i14 = 0;
            int i15 = 0;
            int i16 = 0;
            int i17 = 0;
            int i18 = 0;
            int i19 = 0;
            int i20 = 0;
            for (int i21 = 8; i11 <= i21; i21 = 8) {
                int i22 = iArr2[i9 + Math.min(i5, Math.max(i11, i3))];
                int[] iArr10 = iArr9[i11 + 8];
                iArr10[i3] = (i22 & 16711680) >> 16;
                iArr10[1] = (i22 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                iArr10[2] = i22 & 255;
                int abs = 9 - Math.abs(i11);
                int i23 = iArr10[i3];
                i12 += i23 * abs;
                int i24 = iArr10[1];
                i13 += i24 * abs;
                int i25 = iArr10[2];
                i14 += abs * i25;
                if (i11 > 0) {
                    i18 += i23;
                    i19 += i24;
                    i20 += i25;
                } else {
                    i15 += i23;
                    i16 += i24;
                    i17 += i25;
                }
                i11++;
            }
            int i26 = 8;
            int i27 = 0;
            while (i27 < width2) {
                iArr3[i9] = iArr7[i12];
                iArr4[i9] = iArr7[i13];
                iArr5[i9] = iArr7[i14];
                int i28 = i12 - i15;
                int i29 = i13 - i16;
                int i30 = i14 - i17;
                int[] iArr11 = iArr9[((i26 - 8) + 17) % 17];
                int i31 = i15 - iArr11[i3];
                int i32 = i16 - iArr11[1];
                int i33 = i17 - iArr11[2];
                if (i8 == 0) {
                    iArr6[i27] = Math.min(i27 + 8 + 1, i5);
                }
                int i34 = iArr2[i10 + iArr6[i27]];
                int i35 = (i34 & 16711680) >> 16;
                iArr11[0] = i35;
                int i36 = (i34 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                iArr11[1] = i36;
                int i37 = i34 & 255;
                iArr11[2] = i37;
                int i38 = i18 + i35;
                int i39 = i19 + i36;
                int i40 = i20 + i37;
                i12 = i28 + i38;
                i13 = i29 + i39;
                i14 = i30 + i40;
                i26 = (i26 + 1) % 17;
                int[] iArr12 = iArr9[i26 % 17];
                int i41 = iArr12[0];
                i15 = i31 + i41;
                int i42 = iArr12[1];
                i16 = i32 + i42;
                int i43 = iArr12[2];
                i17 = i33 + i43;
                i18 = i38 - i41;
                i19 = i39 - i42;
                i20 = i40 - i43;
                i9++;
                i27++;
                i3 = 0;
            }
            i10 += width2;
            i8++;
            i3 = 0;
        }
        int i44 = 0;
        while (i44 < width2) {
            int i45 = -8 * width2;
            Bitmap bitmap2 = createScaledBitmap;
            int[] iArr13 = iArr6;
            int i46 = -8;
            int i47 = 0;
            int i48 = 0;
            int i49 = 0;
            int i50 = 0;
            int i51 = 0;
            int i52 = 0;
            int i53 = 0;
            int i54 = 0;
            int i55 = 0;
            for (int i56 = 8; i46 <= i56; i56 = 8) {
                int max = Math.max(0, i45) + i44;
                int[] iArr14 = iArr9[i46 + 8];
                iArr14[0] = iArr3[max];
                iArr14[1] = iArr4[max];
                iArr14[2] = iArr5[max];
                int abs2 = 9 - Math.abs(i46);
                i47 += iArr3[max] * abs2;
                i48 += iArr4[max] * abs2;
                i49 += iArr5[max] * abs2;
                if (i46 > 0) {
                    i53 += iArr14[0];
                    i54 += iArr14[1];
                    i55 += iArr14[2];
                } else {
                    i50 += iArr14[0];
                    i51 += iArr14[1];
                    i52 += iArr14[2];
                }
                if (i46 < i6) {
                    i45 += width2;
                }
                i46++;
            }
            int i57 = i44;
            int i58 = 0;
            int i59 = 8;
            while (i58 < height2) {
                iArr2[i57] = (iArr2[i57] & ViewCompat.MEASURED_STATE_MASK) | (iArr7[i47] << 16) | (iArr7[i48] << 8) | iArr7[i49];
                int i60 = i47 - i50;
                int i61 = i48 - i51;
                int i62 = i49 - i52;
                int[] iArr15 = iArr9[((i59 - 8) + 17) % 17];
                int i63 = i50 - iArr15[0];
                int i64 = i51 - iArr15[1];
                int i65 = i52 - iArr15[2];
                if (i44 == 0) {
                    iArr = iArr7;
                    iArr13[i58] = Math.min(i58 + 9, i6) * width2;
                } else {
                    iArr = iArr7;
                }
                int i66 = iArr13[i58] + i44;
                int i67 = iArr3[i66];
                iArr15[0] = i67;
                int i68 = iArr4[i66];
                iArr15[1] = i68;
                int i69 = iArr5[i66];
                iArr15[2] = i69;
                int i70 = i53 + i67;
                int i71 = i54 + i68;
                int i72 = i55 + i69;
                i47 = i60 + i70;
                i48 = i61 + i71;
                i49 = i62 + i72;
                i59 = (i59 + 1) % 17;
                int[] iArr16 = iArr9[i59];
                int i73 = iArr16[0];
                i50 = i63 + i73;
                int i74 = iArr16[1];
                i51 = i64 + i74;
                int i75 = iArr16[2];
                i52 = i65 + i75;
                i53 = i70 - i73;
                i54 = i71 - i74;
                i55 = i72 - i75;
                i57 += width2;
                i58++;
                iArr7 = iArr;
            }
            int[] iArr17 = iArr7;
            i44++;
            createScaledBitmap = bitmap2;
            iArr6 = iArr13;
        }
        Bitmap bitmap3 = createScaledBitmap;
        bitmap3.setPixels(iArr2, 0, width2, 0, 0, width2, height2);
        return bitmap3;
    }
}

package com.mbridge.msdk.foundation.tools;

import com.google.common.base.Ascii;
import com.mbridge.msdk.foundation.tools.FastKV;
import java.util.LinkedHashSet;
import java.util.Set;

/* compiled from: StringSetEncoder */
final class aj implements FastKV.a<Set<String>> {
    static final aj a = new aj();

    public final String a() {
        return "StringSet";
    }

    public final /* synthetic */ byte[] a(Object obj) {
        Set<String> set = (Set) obj;
        if (set.isEmpty()) {
            return new byte[0];
        }
        int size = set.size();
        int[] iArr = new int[size];
        String[] strArr = new String[size];
        int i = 0;
        int i2 = 0;
        for (String str : set) {
            if (str == null) {
                i += 5;
                iArr[i2] = -1;
            } else {
                int b = m.b(str);
                strArr[i2] = str;
                iArr[i2] = b;
                i += ((b >> 7) == 0 ? 1 : (b >> 14) == 0 ? 2 : (b >> 21) == 0 ? 3 : (b >> 28) == 0 ? 4 : 5) + b;
            }
            i2++;
        }
        m mVar = new m(i);
        for (int i3 = 0; i3 < size; i3++) {
            int i4 = iArr[i3];
            int i5 = mVar.b;
            int i6 = i4;
            while ((i6 & -128) != 0) {
                mVar.a[i5] = (byte) ((i6 & 127) | 128);
                i6 >>>= 7;
                i5++;
            }
            mVar.a[i5] = (byte) i6;
            mVar.b = i5 + 1;
            if (i4 >= 0) {
                mVar.a(strArr[i3]);
            }
        }
        return mVar.a;
    }

    private aj() {
    }

    public final /* synthetic */ Object a(byte[] bArr, int i, int i2) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (i2 > 0) {
            m mVar = new m(bArr, i);
            int i3 = i + i2;
            while (mVar.b < i3) {
                byte[] bArr2 = mVar.a;
                int i4 = mVar.b;
                mVar.b = i4 + 1;
                byte b = bArr2[i4];
                if ((b >> 7) != 0) {
                    byte[] bArr3 = mVar.a;
                    int i5 = mVar.b;
                    mVar.b = i5 + 1;
                    b = (b & Byte.MAX_VALUE) | (bArr3[i5] << 7);
                    if ((b >> Ascii.SO) != 0) {
                        byte[] bArr4 = mVar.a;
                        int i6 = mVar.b;
                        mVar.b = i6 + 1;
                        b = (b & 16383) | (bArr4[i6] << Ascii.SO);
                        if ((b >> Ascii.NAK) != 0) {
                            byte[] bArr5 = mVar.a;
                            int i7 = mVar.b;
                            mVar.b = i7 + 1;
                            b = (b & 2097151) | (bArr5[i7] << Ascii.NAK);
                            if ((b >> Ascii.FS) != 0) {
                                byte[] bArr6 = mVar.a;
                                int i8 = mVar.b;
                                mVar.b = i8 + 1;
                                b = (b & 268435455) | (bArr6[i8] << Ascii.FS);
                            }
                        }
                    }
                }
                linkedHashSet.add(mVar.b((int) b));
            }
            if (mVar.b != i3) {
                throw new IllegalArgumentException("Invalid String set");
            }
        }
        return linkedHashSet;
    }
}

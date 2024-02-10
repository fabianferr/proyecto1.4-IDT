package com.mbridge.msdk.foundation.tools;

import android.telephony.PreciseDisconnectCause;
import com.google.common.base.Ascii;
import java.util.HashMap;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import okio.Utf8;

/* compiled from: SameMVEncoder */
public final class ab {
    private static Map<Character, Character> a;
    private static final char[] b;
    private static char[] c;
    private static final byte[] d = new byte[128];

    static {
        char[] cArr = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', AbstractJsonLexerKt.UNICODE_ESC, 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
        b = cArr;
        HashMap hashMap = new HashMap();
        a = hashMap;
        hashMap.put('A', 'v');
        a.put('B', 'S');
        a.put('C', 'o');
        a.put('D', 'a');
        a.put('E', 'j');
        a.put('F', 'c');
        a.put('G', '7');
        a.put('H', 'd');
        a.put('I', 'R');
        a.put('J', 'z');
        a.put('K', 'p');
        a.put('L', 'W');
        a.put('M', 'i');
        a.put('N', 'f');
        a.put('O', 'G');
        a.put('P', 'y');
        a.put('Q', 'N');
        a.put('R', 'x');
        a.put('S', 'Z');
        a.put('T', 'n');
        a.put('U', 'V');
        a.put('V', '5');
        a.put('W', 'k');
        a.put('X', '+');
        a.put('Y', 'D');
        a.put('Z', 'H');
        a.put('a', 'L');
        a.put('b', 'Y');
        a.put('c', 'h');
        a.put('d', 'J');
        a.put('e', '4');
        a.put('f', '6');
        a.put('g', 'l');
        a.put('h', 't');
        a.put('i', '0');
        a.put('j', 'U');
        a.put('k', '3');
        a.put('l', 'Q');
        a.put('m', 'r');
        a.put('n', 'g');
        a.put('o', 'E');
        a.put('p', Character.valueOf(AbstractJsonLexerKt.UNICODE_ESC));
        a.put('q', 'q');
        a.put('r', '8');
        a.put('s', 's');
        a.put('t', 'w');
        a.put(Character.valueOf(AbstractJsonLexerKt.UNICODE_ESC), '/');
        a.put('v', 'X');
        a.put('w', 'M');
        a.put('x', 'e');
        a.put('y', 'B');
        a.put('z', 'A');
        a.put('0', 'T');
        a.put('1', '2');
        a.put('2', 'F');
        a.put('3', 'b');
        a.put('4', '9');
        a.put('5', 'P');
        a.put('6', '1');
        a.put(55, 'O');
        a.put('8', 'I');
        a.put('9', 'K');
        a.put('+', 'm');
        a.put('/', 67);
        c = new char[cArr.length];
        int i = 0;
        int i2 = 0;
        while (true) {
            char[] cArr2 = b;
            if (i2 >= cArr2.length) {
                break;
            }
            c[i2] = a.get(Character.valueOf(cArr2[i2])).charValue();
            i2++;
        }
        int i3 = 0;
        while (true) {
            byte[] bArr = d;
            if (i3 >= bArr.length) {
                break;
            }
            bArr[i3] = Byte.MAX_VALUE;
            i3++;
        }
        while (true) {
            char[] cArr3 = c;
            if (i < cArr3.length) {
                d[cArr3[i]] = (byte) i;
                i++;
            } else {
                return;
            }
        }
    }

    private static int a(char[] cArr, byte[] bArr, int i) {
        try {
            char c2 = cArr[3];
            char c3 = c2 == '=' ? (char) 2 : 3;
            char c4 = cArr[2];
            if (c4 == '=') {
                c3 = 1;
            }
            byte[] bArr2 = d;
            byte b2 = bArr2[cArr[0]];
            byte b3 = bArr2[cArr[1]];
            byte b4 = bArr2[c4];
            byte b5 = bArr2[c2];
            if (c3 == 1) {
                bArr[i] = (byte) (((b3 >> 4) & 3) | ((b2 << 2) & PreciseDisconnectCause.NETWORK_REJECT));
                return 1;
            } else if (c3 == 2) {
                bArr[i] = (byte) ((3 & (b3 >> 4)) | ((b2 << 2) & PreciseDisconnectCause.NETWORK_REJECT));
                bArr[i + 1] = (byte) (((b3 << 4) & 240) | ((b4 >> 2) & 15));
                return 2;
            } else if (c3 == 3) {
                int i2 = i + 1;
                bArr[i] = (byte) (((b2 << 2) & PreciseDisconnectCause.NETWORK_REJECT) | ((b3 >> 4) & 3));
                bArr[i2] = (byte) (((b3 << 4) & 240) | ((b4 >> 2) & 15));
                bArr[i2 + 1] = (byte) (((b4 << 6) & 192) | (b5 & Utf8.REPLACEMENT_BYTE));
                return 3;
            } else {
                throw new RuntimeException("Internal Error");
            }
        } catch (Exception unused) {
            return 0;
        }
    }

    public static String a(String str) {
        byte[] c2 = c(str);
        if (c2 == null || c2.length <= 0) {
            return null;
        }
        return new String(c2);
    }

    private static byte[] c(String str) {
        int i;
        try {
            int length = str.length();
            int i2 = 259;
            if (length < 259) {
                i2 = length;
            }
            char[] cArr = new char[i2];
            int i3 = ((length >> 2) * 3) + 3;
            byte[] bArr = new byte[i3];
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            while (i4 < length) {
                int i7 = i4 + 256;
                if (i7 <= length) {
                    str.getChars(i4, i7, cArr, i6);
                    i = i6 + 256;
                } else {
                    str.getChars(i4, length, cArr, i6);
                    i = (length - i4) + i6;
                }
                int i8 = i6;
                while (i6 < i) {
                    char c2 = cArr[i6];
                    if (c2 != '=') {
                        byte[] bArr2 = d;
                        if (c2 < bArr2.length) {
                            if (bArr2[c2] == Byte.MAX_VALUE) {
                            }
                        }
                        i6++;
                    }
                    int i9 = i8 + 1;
                    cArr[i8] = c2;
                    if (i9 == 4) {
                        i5 += a(cArr, bArr, i5);
                        i8 = 0;
                    } else {
                        i8 = i9;
                    }
                    i6++;
                }
                i4 = i7;
                i6 = i8;
            }
            if (i5 == i3) {
                return bArr;
            }
            byte[] bArr3 = new byte[i5];
            System.arraycopy(bArr, 0, bArr3, 0, i5);
            return bArr3;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String b(String str) {
        byte[] bytes = str.getBytes();
        return a(bytes, 0, bytes.length);
    }

    private static String a(byte[] bArr, int i, int i2) {
        if (i2 <= 0) {
            return "";
        }
        try {
            char[] cArr = new char[(((i2 / 3) << 2) + 4)];
            int i3 = 0;
            while (i2 >= 3) {
                int i4 = ((bArr[i] & 255) << Ascii.DLE) + ((bArr[i + 1] & 255) << 8) + (bArr[i + 2] & 255);
                int i5 = i3 + 1;
                char[] cArr2 = c;
                cArr[i3] = cArr2[i4 >> 18];
                int i6 = i5 + 1;
                cArr[i5] = cArr2[(i4 >> 12) & 63];
                int i7 = i6 + 1;
                cArr[i6] = cArr2[(i4 >> 6) & 63];
                i3 = i7 + 1;
                cArr[i7] = cArr2[i4 & 63];
                i += 3;
                i2 -= 3;
            }
            if (i2 == 1) {
                byte b2 = bArr[i] & 255;
                int i8 = i3 + 1;
                char[] cArr3 = c;
                cArr[i3] = cArr3[b2 >> 2];
                int i9 = i8 + 1;
                cArr[i8] = cArr3[(b2 << 4) & 63];
                int i10 = i9 + 1;
                cArr[i9] = '=';
                i3 = i10 + 1;
                cArr[i10] = '=';
            } else if (i2 == 2) {
                int i11 = ((bArr[i] & 255) << 8) + (bArr[i + 1] & 255);
                int i12 = i3 + 1;
                char[] cArr4 = c;
                cArr[i3] = cArr4[i11 >> 10];
                int i13 = i12 + 1;
                cArr[i12] = cArr4[(i11 >> 4) & 63];
                int i14 = i13 + 1;
                cArr[i13] = cArr4[(i11 << 2) & 63];
                i3 = i14 + 1;
                cArr[i14] = '=';
            }
            return new String(cArr, 0, i3);
        } catch (Exception unused) {
            return null;
        }
    }
}

package org.apache.commons.codec.binary;

import com.google.common.base.Ascii;
import java.math.BigInteger;
import okio.Utf8;
import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;

public class Base64 implements BinaryEncoder, BinaryDecoder {
    static final byte[] CHUNK_SEPARATOR = {Ascii.CR, 10};
    static final int CHUNK_SIZE = 76;
    private static final byte[] DECODE_TABLE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, 62, -1, Utf8.REPLACEMENT_BYTE, 52, 53, 54, 55, 56, 57, 58, 59, 60, PAD, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, Ascii.VT, Ascii.FF, Ascii.CR, Ascii.SO, Ascii.SI, Ascii.DLE, 17, Ascii.DC2, 19, Ascii.DC4, Ascii.NAK, Ascii.SYN, Ascii.ETB, Ascii.CAN, Ascii.EM, -1, -1, -1, -1, Utf8.REPLACEMENT_BYTE, -1, Ascii.SUB, Ascii.ESC, Ascii.FS, Ascii.GS, Ascii.RS, Ascii.US, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51};
    private static final int DEFAULT_BUFFER_RESIZE_FACTOR = 2;
    private static final int DEFAULT_BUFFER_SIZE = 8192;
    private static final int MASK_6BITS = 63;
    private static final int MASK_8BITS = 255;
    private static final byte PAD = 61;
    private static final byte[] STANDARD_ENCODE_TABLE = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    private static final byte[] URL_SAFE_ENCODE_TABLE = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
    private byte[] buffer;
    private int currentLinePos;
    private final int decodeSize;
    private final int encodeSize;
    private final byte[] encodeTable;
    private boolean eof;
    private final int lineLength;
    private final byte[] lineSeparator;
    private int modulus;
    private int pos;
    private int readPos;
    private int x;

    private static boolean isWhiteSpace(byte b) {
        return b == 9 || b == 10 || b == 13 || b == 32;
    }

    public Base64() {
        this(false);
    }

    public Base64(boolean z) {
        this(76, CHUNK_SEPARATOR, z);
    }

    public Base64(int i) {
        this(i, CHUNK_SEPARATOR);
    }

    public Base64(int i, byte[] bArr) {
        this(i, bArr, false);
    }

    public Base64(int i, byte[] bArr, boolean z) {
        if (bArr == null) {
            bArr = CHUNK_SEPARATOR;
            i = 0;
        }
        this.lineLength = i > 0 ? (i / 4) * 4 : 0;
        byte[] bArr2 = new byte[bArr.length];
        this.lineSeparator = bArr2;
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        if (i > 0) {
            this.encodeSize = bArr.length + 4;
        } else {
            this.encodeSize = 4;
        }
        this.decodeSize = this.encodeSize - 1;
        if (!containsBase64Byte(bArr)) {
            this.encodeTable = z ? URL_SAFE_ENCODE_TABLE : STANDARD_ENCODE_TABLE;
            return;
        }
        throw new IllegalArgumentException(new StringBuffer("lineSeperator must not contain base64 characters: [").append(StringUtils.newStringUtf8(bArr)).append("]").toString());
    }

    public boolean isUrlSafe() {
        return this.encodeTable == URL_SAFE_ENCODE_TABLE;
    }

    /* access modifiers changed from: package-private */
    public boolean hasData() {
        return this.buffer != null;
    }

    /* access modifiers changed from: package-private */
    public int avail() {
        if (this.buffer != null) {
            return this.pos - this.readPos;
        }
        return 0;
    }

    private void resizeBuffer() {
        byte[] bArr = this.buffer;
        if (bArr == null) {
            this.buffer = new byte[8192];
            this.pos = 0;
            this.readPos = 0;
            return;
        }
        byte[] bArr2 = new byte[(bArr.length * 2)];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        this.buffer = bArr2;
    }

    /* access modifiers changed from: package-private */
    public int readResults(byte[] bArr, int i, int i2) {
        if (this.buffer == null) {
            return this.eof ? -1 : 0;
        }
        int min = Math.min(avail(), i2);
        byte[] bArr2 = this.buffer;
        if (bArr2 != bArr) {
            System.arraycopy(bArr2, this.readPos, bArr, i, min);
            int i3 = this.readPos + min;
            this.readPos = i3;
            if (i3 >= this.pos) {
                this.buffer = null;
            }
        } else {
            this.buffer = null;
        }
        return min;
    }

    /* access modifiers changed from: package-private */
    public void setInitialBuffer(byte[] bArr, int i, int i2) {
        if (bArr != null && bArr.length == i2) {
            this.buffer = bArr;
            this.pos = i;
            this.readPos = i;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v15, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v16, resolved type: byte} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void encode(byte[] r10, int r11, int r12) {
        /*
            r9 = this;
            boolean r0 = r9.eof
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            r0 = 0
            r1 = 1
            if (r12 >= 0) goto L_0x009d
            r9.eof = r1
            byte[] r10 = r9.buffer
            if (r10 == 0) goto L_0x0017
            int r10 = r10.length
            int r11 = r9.pos
            int r10 = r10 - r11
            int r11 = r9.encodeSize
            if (r10 >= r11) goto L_0x001a
        L_0x0017:
            r9.resizeBuffer()
        L_0x001a:
            int r10 = r9.modulus
            r11 = 61
            if (r10 == r1) goto L_0x0057
            r12 = 2
            if (r10 == r12) goto L_0x0024
            goto L_0x0083
        L_0x0024:
            byte[] r10 = r9.buffer
            int r1 = r9.pos
            int r2 = r1 + 1
            byte[] r3 = r9.encodeTable
            int r4 = r9.x
            int r5 = r4 >> 10
            r5 = r5 & 63
            byte r5 = r3[r5]
            r10[r1] = r5
            int r1 = r2 + 1
            int r5 = r4 >> 4
            r5 = r5 & 63
            byte r5 = r3[r5]
            r10[r2] = r5
            int r2 = r1 + 1
            r9.pos = r2
            int r12 = r4 << 2
            r12 = r12 & 63
            byte r12 = r3[r12]
            r10[r1] = r12
            byte[] r12 = STANDARD_ENCODE_TABLE
            if (r3 != r12) goto L_0x0083
            int r12 = r2 + 1
            r9.pos = r12
            r10[r2] = r11
            goto L_0x0083
        L_0x0057:
            byte[] r10 = r9.buffer
            int r12 = r9.pos
            int r1 = r12 + 1
            byte[] r2 = r9.encodeTable
            int r3 = r9.x
            int r4 = r3 >> 2
            r4 = r4 & 63
            byte r4 = r2[r4]
            r10[r12] = r4
            int r12 = r1 + 1
            r9.pos = r12
            int r3 = r3 << 4
            r3 = r3 & 63
            byte r3 = r2[r3]
            r10[r1] = r3
            byte[] r1 = STANDARD_ENCODE_TABLE
            if (r2 != r1) goto L_0x0083
            int r1 = r12 + 1
            r10[r12] = r11
            int r12 = r1 + 1
            r9.pos = r12
            r10[r1] = r11
        L_0x0083:
            int r10 = r9.lineLength
            if (r10 <= 0) goto L_0x0117
            int r10 = r9.pos
            if (r10 <= 0) goto L_0x0117
            byte[] r11 = r9.lineSeparator
            byte[] r12 = r9.buffer
            int r1 = r11.length
            java.lang.System.arraycopy(r11, r0, r12, r10, r1)
            int r10 = r9.pos
            byte[] r11 = r9.lineSeparator
            int r11 = r11.length
            int r10 = r10 + r11
            r9.pos = r10
            goto L_0x0117
        L_0x009d:
            r2 = 0
        L_0x009e:
            if (r2 >= r12) goto L_0x0117
            byte[] r3 = r9.buffer
            if (r3 == 0) goto L_0x00ac
            int r3 = r3.length
            int r4 = r9.pos
            int r3 = r3 - r4
            int r4 = r9.encodeSize
            if (r3 >= r4) goto L_0x00af
        L_0x00ac:
            r9.resizeBuffer()
        L_0x00af:
            int r3 = r9.modulus
            int r3 = r3 + r1
            r9.modulus = r3
            int r3 = r3 % 3
            r9.modulus = r3
            int r4 = r11 + 1
            byte r11 = r10[r11]
            if (r11 >= 0) goto L_0x00c0
            int r11 = r11 + 256
        L_0x00c0:
            int r5 = r9.x
            int r5 = r5 << 8
            int r5 = r5 + r11
            r9.x = r5
            if (r3 != 0) goto L_0x0113
            byte[] r11 = r9.buffer
            int r3 = r9.pos
            int r6 = r3 + 1
            byte[] r7 = r9.encodeTable
            int r8 = r5 >> 18
            r8 = r8 & 63
            byte r8 = r7[r8]
            r11[r3] = r8
            int r3 = r6 + 1
            int r8 = r5 >> 12
            r8 = r8 & 63
            byte r8 = r7[r8]
            r11[r6] = r8
            int r6 = r3 + 1
            int r8 = r5 >> 6
            r8 = r8 & 63
            byte r8 = r7[r8]
            r11[r3] = r8
            int r3 = r6 + 1
            r9.pos = r3
            r5 = r5 & 63
            byte r5 = r7[r5]
            r11[r6] = r5
            int r5 = r9.currentLinePos
            int r5 = r5 + 4
            r9.currentLinePos = r5
            int r6 = r9.lineLength
            if (r6 <= 0) goto L_0x0113
            if (r6 > r5) goto L_0x0113
            byte[] r5 = r9.lineSeparator
            int r6 = r5.length
            java.lang.System.arraycopy(r5, r0, r11, r3, r6)
            int r11 = r9.pos
            byte[] r3 = r9.lineSeparator
            int r3 = r3.length
            int r11 = r11 + r3
            r9.pos = r11
            r9.currentLinePos = r0
        L_0x0113:
            int r2 = r2 + 1
            r11 = r4
            goto L_0x009e
        L_0x0117:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.codec.binary.Base64.encode(byte[], int, int):void");
    }

    /* access modifiers changed from: package-private */
    public void decode(byte[] bArr, int i, int i2) {
        int i3;
        byte b;
        if (!this.eof) {
            if (i2 < 0) {
                this.eof = true;
            }
            int i4 = 0;
            while (true) {
                if (i4 >= i2) {
                    break;
                }
                byte[] bArr2 = this.buffer;
                if (bArr2 == null || bArr2.length - this.pos < this.decodeSize) {
                    resizeBuffer();
                }
                int i5 = i + 1;
                byte b2 = bArr[i];
                if (b2 == 61) {
                    this.eof = true;
                    break;
                }
                if (b2 >= 0) {
                    byte[] bArr3 = DECODE_TABLE;
                    if (b2 < bArr3.length && (b = bArr3[b2]) >= 0) {
                        int i6 = this.modulus + 1;
                        this.modulus = i6;
                        int i7 = i6 % 4;
                        this.modulus = i7;
                        int i8 = (this.x << 6) + b;
                        this.x = i8;
                        if (i7 == 0) {
                            byte[] bArr4 = this.buffer;
                            int i9 = this.pos;
                            int i10 = i9 + 1;
                            bArr4[i9] = (byte) ((i8 >> 16) & 255);
                            int i11 = i10 + 1;
                            bArr4[i10] = (byte) ((i8 >> 8) & 255);
                            this.pos = i11 + 1;
                            bArr4[i11] = (byte) (i8 & 255);
                        }
                    }
                }
                i4++;
                i = i5;
            }
            if (this.eof && (i3 = this.modulus) != 0) {
                int i12 = this.x << 6;
                this.x = i12;
                if (i3 == 2) {
                    int i13 = i12 << 6;
                    this.x = i13;
                    byte[] bArr5 = this.buffer;
                    int i14 = this.pos;
                    this.pos = i14 + 1;
                    bArr5[i14] = (byte) ((i13 >> 16) & 255);
                } else if (i3 == 3) {
                    byte[] bArr6 = this.buffer;
                    int i15 = this.pos;
                    int i16 = i15 + 1;
                    bArr6[i15] = (byte) ((i12 >> 16) & 255);
                    this.pos = i16 + 1;
                    bArr6[i16] = (byte) ((i12 >> 8) & 255);
                }
            }
        }
    }

    public static boolean isBase64(byte b) {
        if (b != 61) {
            if (b >= 0) {
                byte[] bArr = DECODE_TABLE;
                if (b >= bArr.length || bArr[b] == -1) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public static boolean isArrayByteBase64(byte[] bArr) {
        for (int i = 0; i < bArr.length; i++) {
            if (!isBase64(bArr[i]) && !isWhiteSpace(bArr[i])) {
                return false;
            }
        }
        return true;
    }

    private static boolean containsBase64Byte(byte[] bArr) {
        for (byte isBase64 : bArr) {
            if (isBase64(isBase64)) {
                return true;
            }
        }
        return false;
    }

    public static byte[] encodeBase64(byte[] bArr) {
        return encodeBase64(bArr, false);
    }

    public static String encodeBase64String(byte[] bArr) {
        return StringUtils.newStringUtf8(encodeBase64(bArr, true));
    }

    public static byte[] encodeBase64URLSafe(byte[] bArr) {
        return encodeBase64(bArr, false, true);
    }

    public static String encodeBase64URLSafeString(byte[] bArr) {
        return StringUtils.newStringUtf8(encodeBase64(bArr, false, true));
    }

    public static byte[] encodeBase64Chunked(byte[] bArr) {
        return encodeBase64(bArr, true);
    }

    public Object decode(Object obj) throws DecoderException {
        if (obj instanceof byte[]) {
            return decode((byte[]) obj);
        }
        if (obj instanceof String) {
            return decode((String) obj);
        }
        throw new DecoderException("Parameter supplied to Base64 decode is not a byte[] or a String");
    }

    public byte[] decode(String str) {
        return decode(StringUtils.getBytesUtf8(str));
    }

    public byte[] decode(byte[] bArr) {
        reset();
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        int length = (int) ((long) ((bArr.length * 3) / 4));
        setInitialBuffer(new byte[length], 0, length);
        decode(bArr, 0, bArr.length);
        decode(bArr, 0, -1);
        int i = this.pos;
        byte[] bArr2 = new byte[i];
        readResults(bArr2, 0, i);
        return bArr2;
    }

    public static byte[] encodeBase64(byte[] bArr, boolean z) {
        return encodeBase64(bArr, z, false);
    }

    public static byte[] encodeBase64(byte[] bArr, boolean z, boolean z2) {
        return encodeBase64(bArr, z, z2, Integer.MAX_VALUE);
    }

    public static byte[] encodeBase64(byte[] bArr, boolean z, boolean z2, int i) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        byte[] bArr2 = CHUNK_SEPARATOR;
        long encodeLength = getEncodeLength(bArr, 76, bArr2);
        if (encodeLength <= ((long) i)) {
            return (z ? new Base64(z2) : new Base64(0, bArr2, z2)).encode(bArr);
        }
        throw new IllegalArgumentException(new StringBuffer("Input array too big, the output array would be bigger (").append(encodeLength).append(") than the specified maxium size of ").append(i).toString());
    }

    public static byte[] decodeBase64(String str) {
        return new Base64().decode(str);
    }

    public static byte[] decodeBase64(byte[] bArr) {
        return new Base64().decode(bArr);
    }

    static byte[] discardWhitespace(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length];
        int i = 0;
        for (byte b : bArr) {
            if (!(b == 9 || b == 10 || b == 13 || b == 32)) {
                bArr2[i] = b;
                i++;
            }
        }
        byte[] bArr3 = new byte[i];
        System.arraycopy(bArr2, 0, bArr3, 0, i);
        return bArr3;
    }

    public Object encode(Object obj) throws EncoderException {
        if (obj instanceof byte[]) {
            return encode((byte[]) obj);
        }
        throw new EncoderException("Parameter supplied to Base64 encode is not a byte[]");
    }

    public String encodeToString(byte[] bArr) {
        return StringUtils.newStringUtf8(encode(bArr));
    }

    public byte[] encode(byte[] bArr) {
        int i;
        reset();
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        int encodeLength = (int) getEncodeLength(bArr, this.lineLength, this.lineSeparator);
        byte[] bArr2 = new byte[encodeLength];
        setInitialBuffer(bArr2, 0, encodeLength);
        encode(bArr, 0, bArr.length);
        encode(bArr, 0, -1);
        if (this.buffer != bArr2) {
            readResults(bArr2, 0, encodeLength);
        }
        if (!isUrlSafe() || (i = this.pos) >= encodeLength) {
            return bArr2;
        }
        byte[] bArr3 = new byte[i];
        System.arraycopy(bArr2, 0, bArr3, 0, i);
        return bArr3;
    }

    private static long getEncodeLength(byte[] bArr, int i, byte[] bArr2) {
        int i2 = (i / 4) * 4;
        long length = (long) ((bArr.length * 4) / 3);
        long j = length % 4;
        if (j != 0) {
            length += 4 - j;
        }
        if (i2 <= 0) {
            return length;
        }
        long j2 = (long) i2;
        boolean z = length % j2 == 0;
        long length2 = length + ((length / j2) * ((long) bArr2.length));
        return !z ? length2 + ((long) bArr2.length) : length2;
    }

    public static BigInteger decodeInteger(byte[] bArr) {
        return new BigInteger(1, decodeBase64(bArr));
    }

    public static byte[] encodeInteger(BigInteger bigInteger) {
        if (bigInteger != null) {
            return encodeBase64(toIntegerBytes(bigInteger), false);
        }
        throw new NullPointerException("encodeInteger called with null parameter");
    }

    static byte[] toIntegerBytes(BigInteger bigInteger) {
        int bitLength = ((bigInteger.bitLength() + 7) >> 3) << 3;
        byte[] byteArray = bigInteger.toByteArray();
        int i = 1;
        if (bigInteger.bitLength() % 8 != 0 && (bigInteger.bitLength() / 8) + 1 == bitLength / 8) {
            return byteArray;
        }
        int length = byteArray.length;
        if (bigInteger.bitLength() % 8 == 0) {
            length--;
        } else {
            i = 0;
        }
        int i2 = bitLength / 8;
        int i3 = i2 - length;
        byte[] bArr = new byte[i2];
        System.arraycopy(byteArray, i, bArr, i3, length);
        return bArr;
    }

    private void reset() {
        this.buffer = null;
        this.pos = 0;
        this.readPos = 0;
        this.currentLinePos = 0;
        this.modulus = 0;
        this.eof = false;
    }
}

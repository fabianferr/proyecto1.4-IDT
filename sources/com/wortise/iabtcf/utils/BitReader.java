package com.wortise.iabtcf.utils;

import com.google.common.base.Ascii;
import com.wortise.iabtcf.exceptions.ByteParseException;
import java.io.IOException;
import java.io.InputStream;
import java.util.BitSet;

public class BitReader {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private byte[] buffer;
    final LengthOffsetCache cache;
    private final InputStream is;
    private int isrpos;

    private byte unsafeReadLsb(byte b, int i, int i2) {
        return i2 == 0 ? b : (byte) ((b & ((1 << i2) - 1)) << i);
    }

    private byte unsafeReadMsb(byte b, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        return (byte) ((b >>> ((8 - i2) - i)) & ((1 << i2) - 1));
    }

    public BitReader(InputStream inputStream) {
        this.buffer = new byte[4096];
        this.is = inputStream;
        this.isrpos = 0;
        this.cache = new LengthOffsetCache(this);
    }

    public BitReader(byte[] bArr) {
        this.buffer = bArr;
        this.isrpos = bArr.length;
        this.is = null;
        this.cache = new LengthOffsetCache(this);
    }

    private void ensureCapacity(int i) {
        byte[] bArr = this.buffer;
        if (bArr.length < i) {
            byte[] bArr2 = new byte[(i * 2)];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            this.buffer = bArr2;
        }
    }

    private boolean ensureReadable(int i, int i2) {
        int i3 = i + i2;
        int i4 = this.isrpos;
        int i5 = i3 - i4;
        if (i3 <= i4) {
            return true;
        }
        if (this.is != null) {
            ensureCapacity(i3);
            while (i5 > 0) {
                try {
                    int read = this.is.read(this.buffer, this.isrpos, i5);
                    if (read == -1) {
                        return false;
                    }
                    this.isrpos += read;
                    i5 -= read;
                } catch (IOException e) {
                    throw new ByteParseException(String.format("error decoding at offset %d length %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), e);
                }
            }
            return true;
        }
        throw new ByteParseException(String.format("read %d bytes at index %d out of bounds for buffer length %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(this.buffer.length)}));
    }

    public String readStr2(int i) {
        return String.valueOf(new char[]{(char) (readBits6(i) + 65), (char) (readBits6(i + 6) + 65)});
    }

    public String readStr2(FieldDefs fieldDefs) {
        return readStr2(fieldDefs.getOffset(this));
    }

    public boolean readBits1(FieldDefs fieldDefs) {
        return readBits1(fieldDefs.getOffset(this));
    }

    public boolean readBits1(int i) {
        int i2 = i >> 3;
        ensureReadable(i2, 1);
        if (((this.buffer[i2] >>> (7 - (i % 8))) & 1) == 1) {
            return true;
        }
        return false;
    }

    public byte readBits2(FieldDefs fieldDefs) {
        return readBits2(fieldDefs.getOffset(this));
    }

    public byte readBits2(int i) {
        return readByteBits(i, 2);
    }

    public byte readBits3(FieldDefs fieldDefs) {
        return readBits3(fieldDefs.getOffset(this));
    }

    public byte readBits3(int i) {
        return readByteBits(i, 3);
    }

    public byte readBits6(FieldDefs fieldDefs) {
        return readBits6(fieldDefs.getOffset(this));
    }

    public byte readBits6(int i) {
        int i2 = i >> 3;
        int i3 = i % 8;
        int i4 = 8 - i3;
        if (i4 < 6) {
            ensureReadable(i2, 2);
            int i5 = 6 - i4;
            return (byte) (unsafeReadLsb(this.buffer[i2], i5, i4) | unsafeReadMsb(this.buffer[i2 + 1], 0, i5));
        }
        ensureReadable(i2, 1);
        return unsafeReadMsb(this.buffer[i2], i3, 6);
    }

    private byte readByteBits(int i, int i2) {
        int i3 = i >> 3;
        int i4 = i % 8;
        int i5 = 8 - i4;
        if (i5 < i2) {
            ensureReadable(i3, 2);
            int i6 = i2 - i5;
            return (byte) (unsafeReadLsb(this.buffer[i3], i6, i5) | unsafeReadMsb(this.buffer[i3 + 1], 0, i6));
        }
        ensureReadable(i3, 1);
        return unsafeReadMsb(this.buffer[i3], i4, i2);
    }

    public int readBits12(FieldDefs fieldDefs) {
        return readBits12(fieldDefs.getOffset(this));
    }

    public int readBits12(int i) {
        int unsafeReadLsb;
        byte unsafeReadMsb;
        int i2 = i >> 3;
        int i3 = i % 8;
        int i4 = 8 - i3;
        if (i4 < 4) {
            ensureReadable(i2, 3);
            byte[] bArr = this.buffer;
            int i5 = i3 - 4;
            unsafeReadLsb = ((unsafeReadLsb(this.buffer[i2], i3, i4) & 255) << 4) | ((bArr[i2 + 1] & 255) << i5);
            unsafeReadMsb = unsafeReadMsb(bArr[i2 + 2], 0, i5);
        } else {
            ensureReadable(i2, 2);
            unsafeReadLsb = (unsafeReadLsb(this.buffer[i2], i3, i4) & 255) << 4;
            unsafeReadMsb = unsafeReadMsb(this.buffer[i2 + 1], 0, i3 + 4);
        }
        return (unsafeReadMsb & 255) | unsafeReadLsb;
    }

    public int readBits16(FieldDefs fieldDefs) {
        return readBits16(fieldDefs.getOffset(this));
    }

    public int readBits16(int i) {
        int i2;
        byte b;
        int i3 = i >> 3;
        int i4 = i % 8;
        int i5 = 8 - i4;
        if (i5 < 8) {
            ensureReadable(i3, 3);
            int unsafeReadLsb = (unsafeReadLsb(this.buffer[i3], i4, i5) & 255) << 8;
            byte[] bArr = this.buffer;
            i2 = unsafeReadLsb | ((bArr[i3 + 1] & 255) << i4);
            b = unsafeReadMsb(bArr[i3 + 2], 0, i4);
        } else {
            ensureReadable(i3, 2);
            byte[] bArr2 = this.buffer;
            i2 = (bArr2[i3] & 255) << 8;
            b = bArr2[i3 + 1];
        }
        return (b & 255) | i2;
    }

    public int readBits24(FieldDefs fieldDefs) {
        return readBits24(fieldDefs.getOffset(this));
    }

    public int readBits24(int i) {
        byte b;
        byte b2;
        int i2 = i >> 3;
        int i3 = i % 8;
        int i4 = 8 - i3;
        if (i4 < 8) {
            ensureReadable(i2, 4);
            int unsafeReadLsb = (unsafeReadLsb(this.buffer[i2], i3, i4) & 255) << Ascii.DLE;
            byte[] bArr = this.buffer;
            b = unsafeReadLsb | ((bArr[i2 + 1] & 255) << (i3 + 8)) | ((bArr[i2 + 2] & 255) << i3);
            b2 = unsafeReadMsb(bArr[i2 + 3], 0, i3);
        } else {
            ensureReadable(i2, 3);
            byte[] bArr2 = this.buffer;
            b = ((bArr2[i2 + 1] & 255) << 8) | ((bArr2[i2] & 255) << Ascii.DLE);
            b2 = bArr2[i2 + 2];
        }
        return (b2 & 255) | b;
    }

    public long readBits36(FieldDefs fieldDefs) {
        return readBits36(fieldDefs.getOffset(this));
    }

    public long readBits36(int i) {
        int i2 = i >> 3;
        int i3 = i % 8;
        int i4 = 8 - i3;
        if (i4 < 4) {
            ensureReadable(i2, 6);
            byte[] bArr = this.buffer;
            int i5 = i3 - 4;
            return (((long) unsafeReadMsb(bArr[i2 + 5], 0, i5)) & 255) | ((((long) unsafeReadLsb(this.buffer[i2], i3, i4)) & 255) << 28) | ((((long) bArr[i2 + 1]) & 255) << (i3 + 20)) | ((((long) bArr[i2 + 2]) & 255) << (i3 + 12)) | ((((long) bArr[i2 + 3]) & 255) << (i3 + 4)) | ((((long) bArr[i2 + 4]) & 255) << i5);
        }
        ensureReadable(i2, 5);
        byte[] bArr2 = this.buffer;
        int i6 = i3 + 4;
        return (((long) unsafeReadMsb(bArr2[i2 + 4], 0, i6)) & 255) | ((((long) unsafeReadLsb(this.buffer[i2], i3, i4)) & 255) << 28) | ((((long) bArr2[i2 + 1]) & 255) << (i3 + 20)) | ((((long) bArr2[i2 + 2]) & 255) << (i3 + 12)) | ((((long) bArr2[i2 + 3]) & 255) << i6);
    }

    public BitSet readBitSet(int i, int i2) {
        BitSet bitSet = new BitSet(i2);
        for (int i3 = 0; i3 < i2; i3++) {
            if (readBits1(i + i3)) {
                bitSet.set(i3);
            }
        }
        return bitSet;
    }
}

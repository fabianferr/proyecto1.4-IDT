package org.apache.commons.codec.binary;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Base64OutputStream extends FilterOutputStream {
    private final Base64 base64;
    private final boolean doEncode;
    private final byte[] singleByte;

    public Base64OutputStream(OutputStream outputStream) {
        this(outputStream, true);
    }

    public Base64OutputStream(OutputStream outputStream, boolean z) {
        super(outputStream);
        this.singleByte = new byte[1];
        this.doEncode = z;
        this.base64 = new Base64();
    }

    public Base64OutputStream(OutputStream outputStream, boolean z, int i, byte[] bArr) {
        super(outputStream);
        this.singleByte = new byte[1];
        this.doEncode = z;
        this.base64 = new Base64(i, bArr);
    }

    public void write(int i) throws IOException {
        byte[] bArr = this.singleByte;
        bArr[0] = (byte) i;
        write(bArr, 0, 1);
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        bArr.getClass();
        if (i < 0 || i2 < 0) {
            throw new IndexOutOfBoundsException();
        } else if (i > bArr.length || i + i2 > bArr.length) {
            throw new IndexOutOfBoundsException();
        } else if (i2 > 0) {
            if (this.doEncode) {
                this.base64.encode(bArr, i, i2);
            } else {
                this.base64.decode(bArr, i, i2);
            }
            flush(false);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r1 = new byte[r0];
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void flush(boolean r5) throws java.io.IOException {
        /*
            r4 = this;
            org.apache.commons.codec.binary.Base64 r0 = r4.base64
            int r0 = r0.avail()
            if (r0 <= 0) goto L_0x0018
            byte[] r1 = new byte[r0]
            org.apache.commons.codec.binary.Base64 r2 = r4.base64
            r3 = 0
            int r0 = r2.readResults(r1, r3, r0)
            if (r0 <= 0) goto L_0x0018
            java.io.OutputStream r2 = r4.out
            r2.write(r1, r3, r0)
        L_0x0018:
            if (r5 == 0) goto L_0x001f
            java.io.OutputStream r5 = r4.out
            r5.flush()
        L_0x001f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.codec.binary.Base64OutputStream.flush(boolean):void");
    }

    public void flush() throws IOException {
        flush(true);
    }

    public void close() throws IOException {
        if (this.doEncode) {
            this.base64.encode(this.singleByte, 0, -1);
        } else {
            this.base64.decode(this.singleByte, 0, -1);
        }
        flush();
        this.out.close();
    }
}

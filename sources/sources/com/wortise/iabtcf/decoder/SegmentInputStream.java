package com.wortise.iabtcf.decoder;

import java.io.IOException;
import java.io.InputStream;

class SegmentInputStream extends InputStream {
    private int end = -1;
    private int rpos;
    private final String src;
    private int start;

    public boolean markSupported() {
        return true;
    }

    public SegmentInputStream(String str, int i) {
        if (str == null) {
            throw new IllegalArgumentException("src");
        } else if (i >= 0) {
            this.src = str;
            this.rpos = Math.min(i, str.length());
        } else {
            throw new IllegalArgumentException(String.format("start is invalid %d", new Object[]{Integer.valueOf(i)}));
        }
    }

    public int read() throws IOException {
        char charAt;
        if (this.rpos >= this.src.length() || (charAt = this.src.charAt(this.rpos)) == '.') {
            return -1;
        }
        this.rpos++;
        if ((charAt & 255) != charAt) {
            return -1;
        }
        return charAt;
    }

    public int available() throws IOException {
        return (this.rpos >= this.src.length() || this.src.charAt(this.rpos) == '.') ? 0 : 1;
    }

    public synchronized void reset() throws IOException {
        this.rpos = this.start;
    }

    /* access modifiers changed from: protected */
    public int segmentEnd() {
        if (this.end == -1) {
            int i = this.rpos;
            while (true) {
                this.end = i;
                if (this.end >= this.src.length() || this.src.charAt(this.end) == '.') {
                    break;
                }
                i = this.end + 1;
            }
        }
        return this.end;
    }

    /* access modifiers changed from: protected */
    public boolean hasNextSegment() {
        for (int max = Math.max(this.rpos, this.end); max < this.src.length(); max++) {
            if (this.src.charAt(max) == '.') {
                this.end = max;
                return true;
            }
        }
        return false;
    }
}

package androidx.media3.exoplayer.mediacodec;

import java.util.NoSuchElementException;

final class IntArrayQueue {
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private int[] data;
    private int headIndex = 0;
    private int size = 0;
    private int tailIndex = -1;
    private int wrapAroundMask;

    public IntArrayQueue() {
        int[] iArr = new int[16];
        this.data = iArr;
        this.wrapAroundMask = iArr.length - 1;
    }

    public void add(int i) {
        if (this.size == this.data.length) {
            doubleArraySize();
        }
        int i2 = (this.tailIndex + 1) & this.wrapAroundMask;
        this.tailIndex = i2;
        this.data[i2] = i;
        this.size++;
    }

    public int remove() {
        int i = this.size;
        if (i != 0) {
            int[] iArr = this.data;
            int i2 = this.headIndex;
            int i3 = iArr[i2];
            this.headIndex = (i2 + 1) & this.wrapAroundMask;
            this.size = i - 1;
            return i3;
        }
        throw new NoSuchElementException();
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void clear() {
        this.headIndex = 0;
        this.tailIndex = -1;
        this.size = 0;
    }

    public int capacity() {
        return this.data.length;
    }

    private void doubleArraySize() {
        int[] iArr = this.data;
        int length = iArr.length << 1;
        if (length >= 0) {
            int[] iArr2 = new int[length];
            int length2 = iArr.length;
            int i = this.headIndex;
            int i2 = length2 - i;
            System.arraycopy(iArr, i, iArr2, 0, i2);
            System.arraycopy(this.data, 0, iArr2, i2, i);
            this.headIndex = 0;
            this.tailIndex = this.size - 1;
            this.data = iArr2;
            this.wrapAroundMask = iArr2.length - 1;
            return;
        }
        throw new IllegalStateException();
    }
}
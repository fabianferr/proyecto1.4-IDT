package androidx.media3.decoder;

import androidx.media3.common.C;

public abstract class Buffer {
    private int flags;

    public void clear() {
        this.flags = 0;
    }

    public final boolean isDecodeOnly() {
        return getFlag(Integer.MIN_VALUE);
    }

    public final boolean isFirstSample() {
        return getFlag(C.BUFFER_FLAG_FIRST_SAMPLE);
    }

    public final boolean isEndOfStream() {
        return getFlag(4);
    }

    public final boolean isKeyFrame() {
        return getFlag(1);
    }

    public final boolean isLastSample() {
        return getFlag(536870912);
    }

    public final boolean hasSupplementalData() {
        return getFlag(268435456);
    }

    public final void setFlags(int i) {
        this.flags = i;
    }

    public final void addFlag(int i) {
        this.flags = i | this.flags;
    }

    public final void clearFlag(int i) {
        this.flags = (i ^ -1) & this.flags;
    }

    /* access modifiers changed from: protected */
    public final boolean getFlag(int i) {
        return (this.flags & i) == i;
    }
}
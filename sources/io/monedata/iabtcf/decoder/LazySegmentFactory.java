package io.monedata.iabtcf.decoder;

import io.monedata.iabtcf.utils.Supplier;
import java.io.InputStream;

class LazySegmentFactory {
    /* access modifiers changed from: private */
    public final String src;
    private SegmentSupplier sup = new SegmentSupplier();

    public LazySegmentFactory(String str) {
        this.src = str;
    }

    public Supplier<InputStream> next() {
        SegmentSupplier segmentSupplier = this.sup;
        this.sup = new SegmentSupplier(segmentSupplier);
        return segmentSupplier;
    }

    private static class EmptyInputStream extends SegmentInputStream {
        public static EmptyInputStream INSTANCE = new EmptyInputStream();

        /* access modifiers changed from: protected */
        public boolean hasNextSegment() {
            return false;
        }

        /* access modifiers changed from: protected */
        public int segmentEnd() {
            return -1;
        }

        private EmptyInputStream() {
            super("", 0);
        }
    }

    class SegmentSupplier implements Supplier<InputStream> {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private SegmentInputStream current;
        private final SegmentSupplier prev;

        static {
            Class<LazySegmentFactory> cls = LazySegmentFactory.class;
        }

        public SegmentSupplier() {
            this.prev = null;
            this.current = new SegmentInputStream(LazySegmentFactory.this.src, 0);
        }

        public SegmentSupplier(SegmentSupplier segmentSupplier) {
            this.prev = segmentSupplier;
        }

        private SegmentInputStream getCurrent() {
            if (this.current == null) {
                SegmentInputStream current2 = this.prev.getCurrent();
                if (current2 == EmptyInputStream.INSTANCE) {
                    this.current = EmptyInputStream.INSTANCE;
                } else {
                    this.current = new SegmentInputStream(LazySegmentFactory.this.src, current2.segmentEnd() + 1);
                }
            }
            return this.current;
        }

        public InputStream get() {
            return getCurrent();
        }
    }
}

package com.wortise.iabtcf.utils;

import java.util.BitSet;
import java.util.Collection;
import java.util.NoSuchElementException;

public class BitSetIntIterable extends IntIterable {
    public static final BitSetIntIterable EMPTY = new BitSetIntIterable(new BitSet());
    /* access modifiers changed from: private */
    public final BitSet bs;

    public static BitSetIntIterable from(BitSet bitSet) {
        return new BitSetIntIterable((BitSet) bitSet.clone());
    }

    public static BitSetIntIterable from(IntIterable intIterable) {
        if (intIterable instanceof BitSetIntIterable) {
            return ((BitSetIntIterable) intIterable).clone();
        }
        BitSet bitSet = new BitSet();
        IntIterator intIterator = intIterable.intIterator();
        while (intIterator.hasNext()) {
            bitSet.set(intIterator.nextInt());
        }
        return new BitSetIntIterable(bitSet);
    }

    public static BitSetIntIterable from(int... iArr) {
        BitSet bitSet = new BitSet();
        for (int i : iArr) {
            bitSet.set(i);
        }
        return new BitSetIntIterable(bitSet);
    }

    public static BitSetIntIterable from(Collection<Integer> collection) {
        BitSet bitSet = new BitSet();
        for (Integer intValue : collection) {
            bitSet.set(intValue.intValue());
        }
        return new BitSetIntIterable(bitSet);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(BitSetIntIterable bitSetIntIterable) {
        return new Builder();
    }

    public static Builder newBuilder(BitSet bitSet) {
        return new Builder();
    }

    private BitSetIntIterable(BitSet bitSet) {
        this.bs = bitSet;
    }

    public BitSet toBitSet() {
        return (BitSet) this.bs.clone();
    }

    public BitSetIntIterable clone() {
        return new BitSetIntIterable((BitSet) this.bs.clone());
    }

    public boolean contains(int i) {
        if (i < 0) {
            return false;
        }
        return this.bs.get(i);
    }

    public IntIterator intIterator() {
        return new IntIterator() {
            int currentIndex = start();

            public int start() {
                if (BitSetIntIterable.this.bs.isEmpty()) {
                    return -1;
                }
                return BitSetIntIterable.this.bs.nextSetBit(0);
            }

            public boolean hasNext() {
                return this.currentIndex != -1;
            }

            public Integer next() {
                return Integer.valueOf(nextInt());
            }

            public int nextInt() {
                if (hasNext()) {
                    int i = this.currentIndex;
                    this.currentIndex = BitSetIntIterable.this.bs.nextSetBit(this.currentIndex + 1);
                    return i;
                }
                throw new NoSuchElementException();
            }
        };
    }

    public int hashCode() {
        BitSet bitSet = this.bs;
        return 31 + (bitSet == null ? 0 : bitSet.hashCode());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BitSetIntIterable bitSetIntIterable = (BitSetIntIterable) obj;
        BitSet bitSet = this.bs;
        if (bitSet != null) {
            return bitSet.equals(bitSetIntIterable.bs);
        }
        if (bitSetIntIterable.bs == null) {
            return true;
        }
        return false;
    }

    public String toString() {
        return this.bs.toString();
    }

    public static class Builder {
        private final BitSet bs;

        private Builder() {
            this(new BitSet());
        }

        private Builder(BitSet bitSet) {
            this.bs = bitSet;
        }

        private Builder(BitSetIntIterable bitSetIntIterable) {
            this(bitSetIntIterable.clone().bs);
        }

        public Builder add(int i) {
            this.bs.set(i);
            return this;
        }

        public Builder add(BitSetIntIterable bitSetIntIterable) {
            this.bs.or(bitSetIntIterable.bs);
            return this;
        }

        public Builder add(IntIterable intIterable) {
            IntIterator intIterator = intIterable.intIterator();
            while (intIterator.hasNext()) {
                this.bs.set(intIterator.nextInt());
            }
            return this;
        }

        public Builder add(Builder builder) {
            this.bs.or(builder.bs);
            return this;
        }

        public Builder clear() {
            this.bs.clear();
            return this;
        }

        public int max() {
            if (this.bs.isEmpty()) {
                return 0;
            }
            return this.bs.length() - 1;
        }

        public BitSetIntIterable build() {
            return new BitSetIntIterable((BitSet) this.bs.clone());
        }
    }

    public static Builder newBuilder(IntIterable intIterable) {
        return new Builder();
    }
}

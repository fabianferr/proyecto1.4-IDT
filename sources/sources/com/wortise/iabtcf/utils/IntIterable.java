package com.wortise.iabtcf.utils;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public abstract class IntIterable implements Iterable<Integer> {
    public abstract boolean contains(int i);

    public abstract IntIterator intIterator();

    public Set<Integer> toSet() {
        HashSet hashSet = new HashSet();
        IntIterator intIterator = intIterator();
        while (intIterator.hasNext()) {
            hashSet.add(intIterator.next());
        }
        return hashSet;
    }

    public boolean isEmpty() {
        return !intIterator().hasNext();
    }

    public boolean containsAll(int... iArr) {
        for (int contains : iArr) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public boolean containsAny(int... iArr) {
        for (int contains : iArr) {
            if (contains(contains)) {
                return true;
            }
        }
        return false;
    }

    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            final IntIterator internal;

            {
                this.internal = IntIterable.this.intIterator();
            }

            public boolean hasNext() {
                return this.internal.hasNext();
            }

            public Integer next() {
                return (Integer) this.internal.next();
            }
        };
    }
}

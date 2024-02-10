package com.applovin.impl.sdk.utils;

import java.lang.Comparable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.RandomAccess;
import java.util.Set;

public class l<T extends Comparable<? super T>> implements RandomAccess, Set<T> {
    private final ArrayList<T> a = new ArrayList<>();
    private final HashSet<T> b = new HashSet<>();

    public T a() {
        return (Comparable) this.a.get(size() - 1);
    }

    public T a(int i) {
        return (Comparable) this.a.get(i);
    }

    public void a(int i, T t) {
        this.b.remove((Comparable) this.a.get(i));
        this.a.set(i, t);
        this.b.add(t);
    }

    /* renamed from: a */
    public boolean add(T t) {
        if (contains(t)) {
            return false;
        }
        if (isEmpty() || t.compareTo(a()) > 0) {
            this.a.add(t);
        } else {
            this.a.add(c(t), t);
        }
        return this.b.add(t);
    }

    public boolean addAll(Collection<? extends T> collection) {
        Iterator<? extends T> it = collection.iterator();
        while (true) {
            boolean z = false;
            while (true) {
                if (!it.hasNext()) {
                    return z;
                }
                if (add((Comparable) it.next()) || z) {
                    z = true;
                }
            }
        }
    }

    public int b(T t) {
        if (t == null || !contains(t)) {
            return -1;
        }
        return c(t);
    }

    public T b(int i) {
        T t = (Comparable) this.a.remove(i);
        this.b.remove(t);
        return t;
    }

    public int c(T t) {
        int binarySearch = Collections.binarySearch(this.a, t);
        if (binarySearch < 0) {
            return binarySearch ^ -1;
        }
        Comparable a2 = a(binarySearch);
        while (binarySearch >= 0 && a2 == a(binarySearch)) {
            binarySearch--;
        }
        return binarySearch + 1;
    }

    public void clear() {
        this.a.clear();
        this.b.clear();
    }

    public boolean contains(Object obj) {
        return this.b.contains(obj);
    }

    public boolean containsAll(Collection<?> collection) {
        return this.b.containsAll(collection);
    }

    public int d(T t) {
        int binarySearch = Collections.binarySearch(this.a, t);
        if (binarySearch < 0) {
            return binarySearch ^ -1;
        }
        Comparable a2 = a(binarySearch);
        while (binarySearch < size() && a2 == a(binarySearch)) {
            binarySearch++;
        }
        return binarySearch;
    }

    public boolean isEmpty() {
        return this.a.isEmpty();
    }

    public Iterator<T> iterator() {
        return this.a.iterator();
    }

    public boolean remove(Object obj) {
        int b2 = b((Comparable) obj);
        if (b2 == -1) {
            return false;
        }
        this.a.remove(b2);
        return this.b.remove(obj);
    }

    public boolean removeAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (true) {
            boolean z = false;
            while (true) {
                if (!it.hasNext()) {
                    return false;
                }
                Object next = it.next();
                if (z || remove(next)) {
                    z = true;
                }
            }
        }
    }

    public boolean retainAll(Collection<?> collection) {
        boolean z = false;
        for (int size = size() - 1; size >= 0; size--) {
            Comparable comparable = (Comparable) this.a.get(size);
            if (!collection.contains(comparable)) {
                this.a.remove(size);
                this.b.remove(comparable);
                z = true;
            }
        }
        return z;
    }

    public int size() {
        return this.a.size();
    }

    public Object[] toArray() {
        return this.a.toArray();
    }

    public <T1> T1[] toArray(T1[] t1Arr) {
        return this.a.toArray(t1Arr);
    }
}

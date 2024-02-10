package com.applovin.impl.mediation.b.a;

import com.applovin.impl.sdk.u;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.l;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.nativeAds.adPlacer.MaxAdPlacerSettings;
import java.util.Collection;
import java.util.Map;
import java.util.TreeSet;

public class a {
    private final l<Integer> a = new l<>();
    private final TreeSet<Integer> b = new TreeSet<>();
    private final Map<Integer, MaxAd> c = CollectionUtils.map();
    private int d;
    private int e;

    public a(MaxAdPlacerSettings maxAdPlacerSettings) {
        a(maxAdPlacerSettings);
    }

    private int a(int i, boolean z) {
        int d2 = this.a.d(Integer.valueOf(i));
        if (!z) {
            int i2 = i + d2;
            while (d2 < this.a.size() && i2 >= this.a.a(d2).intValue()) {
                i2++;
                d2++;
            }
        }
        return d2;
    }

    private void a(MaxAdPlacerSettings maxAdPlacerSettings) {
        if (!maxAdPlacerSettings.hasValidPositioning()) {
            u.i("MaxAdPlacerData", "No positioning info was provided with ad placer settings. You must set at least (1) one or more fixed positions or (2) a repeating interval greater than or equal to 2 for the ad placer to determine where to position ads.");
            return;
        }
        this.a.addAll(maxAdPlacerSettings.getFixedPositions());
        if (maxAdPlacerSettings.isRepeatingEnabled()) {
            int repeatingInterval = maxAdPlacerSettings.getRepeatingInterval();
            if (this.a.isEmpty()) {
                this.a.add(Integer.valueOf(repeatingInterval - 1));
            }
            int intValue = this.a.a().intValue();
            while (true) {
                intValue += repeatingInterval;
                if (this.a.size() < maxAdPlacerSettings.getMaxAdCount()) {
                    this.a.add(Integer.valueOf(intValue));
                } else {
                    return;
                }
            }
        }
    }

    private void c(int i, int i2) {
        if (this.c.containsKey(Integer.valueOf(i))) {
            this.c.put(Integer.valueOf(i2), this.c.get(Integer.valueOf(i)));
            this.b.add(Integer.valueOf(i2));
            this.c.remove(Integer.valueOf(i));
            this.b.remove(Integer.valueOf(i));
        }
    }

    public int a() {
        int i = this.d;
        if (!(i == -1 || this.e == -1)) {
            while (i <= this.e) {
                if (a(i) && !b(i)) {
                    return i;
                }
                i++;
            }
        }
        return -1;
    }

    public void a(int i, int i2) {
        this.d = i;
        this.e = i2;
    }

    public void a(MaxAd maxAd, int i) {
        this.c.put(Integer.valueOf(i), maxAd);
        this.b.add(Integer.valueOf(i));
    }

    public void a(Collection<Integer> collection) {
        for (Integer next : collection) {
            this.c.remove(next);
            this.b.remove(next);
        }
    }

    public boolean a(int i) {
        return this.a.contains(Integer.valueOf(i));
    }

    public Collection<Integer> b() {
        return new TreeSet(this.b);
    }

    public void b(int i, int i2) {
        i(i);
        h(i2);
    }

    public boolean b(int i) {
        return this.b.contains(Integer.valueOf(i));
    }

    public MaxAd c(int i) {
        return this.c.get(Integer.valueOf(i));
    }

    public void c() {
        this.c.clear();
        this.b.clear();
    }

    public Collection<Integer> d(int i) {
        return new TreeSet(this.b.tailSet(Integer.valueOf(i), false));
    }

    public int e(int i) {
        if (i == 0) {
            return 0;
        }
        return i + a(i - 1, false);
    }

    public int f(int i) {
        return i + a(i, false);
    }

    public int g(int i) {
        if (a(i)) {
            return -1;
        }
        return i - a(i, true);
    }

    public void h(int i) {
        int c2 = this.a.c(Integer.valueOf(i));
        for (int size = this.a.size() - 1; size >= c2; size--) {
            Integer a2 = this.a.a(size);
            int intValue = a2.intValue() + 1;
            c(a2.intValue(), intValue);
            this.a.a(size, Integer.valueOf(intValue));
        }
    }

    public void i(int i) {
        int c2 = this.a.c(Integer.valueOf(i));
        if (a(i)) {
            this.c.remove(Integer.valueOf(i));
            this.b.remove(Integer.valueOf(i));
            this.a.b(c2);
        }
        while (c2 < this.a.size()) {
            Integer a2 = this.a.a(c2);
            int intValue = a2.intValue() - 1;
            c(a2.intValue(), intValue);
            this.a.a(c2, Integer.valueOf(intValue));
            c2++;
        }
    }
}

package com.applovin.mediation.nativeAds.adPlacer;

import com.applovin.impl.sdk.u;
import java.util.Set;
import java.util.TreeSet;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class MaxAdPlacerSettings {
    public static final int MIN_REPEATING_INTERVAL = 2;
    private final String a;
    private final Set<Integer> b = new TreeSet();
    private int c = 0;
    private int d = 256;
    private int e = 4;

    public MaxAdPlacerSettings(String str) {
        this.a = str;
    }

    public void addFixedPosition(int i) {
        this.b.add(Integer.valueOf(i));
    }

    public String getAdUnitId() {
        return this.a;
    }

    public Set<Integer> getFixedPositions() {
        return this.b;
    }

    public int getMaxAdCount() {
        return this.d;
    }

    public int getMaxPreloadedAdCount() {
        return this.e;
    }

    public int getRepeatingInterval() {
        return this.c;
    }

    public boolean hasValidPositioning() {
        return !this.b.isEmpty() || isRepeatingEnabled();
    }

    public boolean isRepeatingEnabled() {
        return this.c >= 2;
    }

    public void resetFixedPositions() {
        this.b.clear();
    }

    public void setMaxAdCount(int i) {
        this.d = i;
    }

    public void setMaxPreloadedAdCount(int i) {
        this.e = i;
    }

    public void setRepeatingInterval(int i) {
        if (i >= 2) {
            this.c = i;
            u.f("MaxAdPlacerSettings", "Repeating interval set to " + i);
            return;
        }
        this.c = 0;
        u.h("MaxAdPlacerSettings", "Repeating interval has been disabled, since it has been set to " + i + ", which is less than minimum value of 2");
    }

    public String toString() {
        return "MaxAdPlacerSettings{adUnitId='" + this.a + "', fixedPositions=" + this.b + ", repeatingInterval=" + this.c + ", maxAdCount=" + this.d + ", maxPreloadedAdCount=" + this.e + AbstractJsonLexerKt.END_OBJ;
    }
}

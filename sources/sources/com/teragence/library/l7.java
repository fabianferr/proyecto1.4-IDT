package com.teragence.library;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class l7 implements u5 {
    private final float accuracy;
    private final double altitude;
    private final double latitude;
    private final double longitude;
    private final float verticalAccuracy;

    public l7(double d, double d2, double d3, float f, float f2) {
        this.latitude = d;
        this.longitude = d2;
        this.altitude = d3;
        this.accuracy = f;
        this.verticalAccuracy = f2;
    }

    public float a() {
        return this.verticalAccuracy;
    }

    public double b() {
        return this.latitude;
    }

    public float c() {
        return this.accuracy;
    }

    public double d() {
        return this.longitude;
    }

    public double e() {
        return this.altitude;
    }

    public String toString() {
        return "LocationStatus{latitude=" + this.latitude + ", longitude=" + this.longitude + ", altitude=" + this.altitude + ", accuracy=" + this.accuracy + AbstractJsonLexerKt.END_OBJ;
    }
}

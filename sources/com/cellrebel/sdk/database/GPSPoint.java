package com.cellrebel.sdk.database;

public class GPSPoint {
    public double a;
    public double b;

    public double a() {
        return this.a;
    }

    /* access modifiers changed from: protected */
    public boolean a(Object obj) {
        return obj instanceof GPSPoint;
    }

    public double b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GPSPoint)) {
            return false;
        }
        GPSPoint gPSPoint = (GPSPoint) obj;
        return gPSPoint.a(this) && Double.compare(a(), gPSPoint.a()) == 0 && Double.compare(b(), gPSPoint.b()) == 0;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(a());
        long doubleToLongBits2 = Double.doubleToLongBits(b());
        return ((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 59) * 59) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
    }

    public String toString() {
        return "GPSPoint(latitude=" + a() + ", longitude=" + b() + ")";
    }
}

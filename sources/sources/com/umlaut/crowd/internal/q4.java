package com.umlaut.crowd.internal;

import java.io.Serializable;

public class q4 implements Cloneable, Serializable {
    private static final long a = -937846764579533362L;
    public int IpLocationAccuracy = -1;
    public long IpLocationAge = -1;
    public double IpLocationLatitude = 2.147483647E9d;
    public double IpLocationLongitude = 2.147483647E9d;
    public int IsMocked = -1;
    public double LocationAccuracyHorizontal;
    public double LocationAccuracyVertical;
    public long LocationAge = -1;
    public double LocationAltitude;
    public double LocationBearing;
    public double LocationLatitude;
    public double LocationLongitude;
    public r4 LocationPermissionType = r4.Unknown;
    public s4 LocationProvider = s4.Unknown;
    public double LocationSpeed;
    public String LocationTimestamp = "";
    public int NumberOfSatellites = -1;
    public transient long locationTimestampMillis;

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

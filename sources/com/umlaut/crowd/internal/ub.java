package com.umlaut.crowd.internal;

import com.umlaut.crowd.utils.DateUtils;
import java.io.Serializable;
import java.util.TimeZone;

public class ub implements Cloneable, Serializable {
    private static final long a = 3793653153982296400L;
    public long DeviceDriftMillis;
    public boolean IsSynced;
    public long MillisSinceLastSync;
    public vb TimeSource = vb.Unknown;
    public String TimestampDateTime = "";
    public long TimestampMillis;
    public double TimestampOffset;
    public String TimestampTableau = "";
    public transient int day;
    public transient int hour;
    public transient int millisecond;
    public transient int minute;
    public transient int month;
    public transient int second;
    public transient int year;

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public void setMillis(long j) {
        this.TimestampTableau = DateUtils.formatTableau(j);
        this.TimestampDateTime = DateUtils.formatDateTime(j);
        this.TimestampOffset = (double) (((((float) TimeZone.getDefault().getOffset(j)) / 1000.0f) / 60.0f) / 60.0f);
        this.TimestampMillis = j;
        v1 millisToDate = DateUtils.millisToDate(j);
        this.year = millisToDate.a;
        this.month = millisToDate.b;
        this.day = millisToDate.c;
        this.hour = millisToDate.d;
        this.minute = millisToDate.e;
        this.second = millisToDate.f;
        this.millisecond = millisToDate.g;
    }
}

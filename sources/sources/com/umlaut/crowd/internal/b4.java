package com.umlaut.crowd.internal;

import com.umlaut.crowd.timeserver.TimeServer;

public class b4 implements Cloneable {
    public double a;
    public double b;
    public int c;
    public long d;

    public b4() {
        this.a = 2.147483647E9d;
        this.b = 2.147483647E9d;
        this.c = -1;
        this.d = -1;
    }

    public long a() {
        if (this.d > 0) {
            return TimeServer.getTimeInMillis() - this.d;
        }
        return -1;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public b4(double d2, double d3, int i, long j) {
        this.a = d2;
        this.b = d3;
        this.c = i;
        this.d = j;
    }
}

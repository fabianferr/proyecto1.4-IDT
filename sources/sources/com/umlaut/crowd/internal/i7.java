package com.umlaut.crowd.internal;

public class i7 implements c7 {
    public static final int STATUS_DONE = 1;
    public static final int STATUS_ERROR = 2;
    public static final int STATUS_ERROR_PACKAGETIMEOUT = 3;
    public static final int STATUS_ERROR_TOOMUCHLOAD = 4;
    public static final int STATUS_RUNNNG = 0;
    public j7 global;
    public long lastSeq;
    public j7[] measurepoints;
    public int offset;
    public int teststatus;
    public long timeFirstPkg;
    public long timeLastPkg;

    public a7 a() {
        return a7.PROGRESS_UDP_RECEIVE_STATUS;
    }
}

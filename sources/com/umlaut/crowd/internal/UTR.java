package com.umlaut.crowd.internal;

public class UTR {
    public static final int STATUS_DENIED = 2;
    public static final int STATUS_MISSINGDATA = 3;
    public static final int STATUS_SUCCESS = 1;
    public String[] params;
    public String paramsetid = null;
    public long status = -1;
    public long timeout;
}

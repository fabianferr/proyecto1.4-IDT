package com.umlaut.crowd.internal;

public enum a7 {
    PROGRESS_TCP(g7.class),
    PROGRESS_TRACEROUTE(h7.class),
    PROGRESS_FTP(b7.class),
    PROGRESS_TCP2(e7.class),
    PROGRESS_TCP3(f7.class),
    PROGRESS_UDP_RECEIVE_STATUS(i7.class);
    
    private Class<?> progressclass;

    private a7(Class<?> cls) {
        this.progressclass = cls;
    }

    public Class<?> a() {
        return this.progressclass;
    }
}

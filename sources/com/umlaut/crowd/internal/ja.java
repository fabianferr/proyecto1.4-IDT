package com.umlaut.crowd.internal;

public enum ja {
    TEST_TCPUPLOAD(hb.class),
    TEST_TCPDOWNLOAD(bb.class),
    TEST_TCPPING(gb.class),
    TEST_FTPDOWNFILESIZE(la.class),
    TEST_FTPDOWNPERIOD(ma.class),
    TEST_FTPUPFILESIZE(oa.class),
    TEST_FTPUPPERIOD(pa.class),
    TEST_TRACEROUTE(jb.class),
    TEST_UDP_FIXEDSENDDATA(mb.class),
    TEST_UDP_FIXEDRECEIVEDATA(lb.class),
    TEST_UDP_FIXEDTIMEFRAME(nb.class),
    TEST_TCPUPLOAD_SIZE(ib.class),
    TEST_TCPDOWNLOAD_SIZE(cb.class);
    
    private Class<?> testclass;

    private ja(Class<?> cls) {
        this.testclass = cls;
    }

    public Class<?> a() {
        return this.testclass;
    }
}

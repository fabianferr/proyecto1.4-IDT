package com.umlaut.crowd.internal;

public enum v5 {
    MESSAGETYPE_QUIT(0, e0.class, e0.class),
    MESSAGETYPE_FAIL(2, (int) null, w7.class),
    MESSAGETYPE_PING(3, c0.class, c0.class),
    MESSAGETYPE_REQUEST_TESTSERVER(4, f0.class, f0.class),
    MESSAGETYPE_ADDTESTSERVER(5, r7.class, f0.class),
    MESSAGETYPE_BINARY(1, (int) null, v7.class),
    MESSAGETYPE_REGISTER_TEST(6, o7.class, v7.class),
    MESSAGETYPE_REQUEST_TESTSOCKET(7, s7.class, v7.class),
    MESSAGETYPE_STARTTEST(8, w9.class, v7.class),
    MESSAGETYPE_STOPTEST(9, x9.class, v7.class),
    MESSAGETYPE_PROGRESS(10, d0.class, d0.class),
    MESSAGETYPE_INTERNAL_TESTSERVERSTATUS(11, pb.class, v7.class);
    
    static final int MESSAGE_ADDTESTSERVER = 5;
    static final int MESSAGE_BINARY = 1;
    static final int MESSAGE_FAIL = 2;
    static final int MESSAGE_INTERNAL_TESTSERVERSTATUS = 11;
    static final int MESSAGE_PING = 3;
    static final int MESSAGE_PROGRESS = 10;
    static final int MESSAGE_QUIT = 0;
    static final int MESSAGE_REGISTER_TEST = 6;
    static final int MESSAGE_REQUEST_TESTSERVER = 4;
    static final int MESSAGE_REQUEST_TESTSOCKET = 7;
    static final int MESSAGE_STARTTEST = 8;
    static final int MESSAGE_STOPTEST = 9;
    private int msgType;
    private Class<? extends s5> request;
    private Class<? extends u5> response;

    private v5(int i, Class<? extends s5> cls, Class<? extends u5> cls2) {
        this.msgType = i;
        this.request = cls;
        this.response = cls2;
    }

    public static v5 a(int i) {
        for (v5 v5Var : values()) {
            if (v5Var.msgType == i) {
                return v5Var;
            }
        }
        return null;
    }

    public Class<? extends s5> b() {
        return this.request;
    }

    public Class<? extends u5> c() {
        return this.response;
    }

    public int a() {
        return this.msgType;
    }
}

package com.umlaut.crowd.internal;

public class ra extends db {
    public int a = 7000;
    public long b = Long.MAX_VALUE;
    public String c = "Connection: close\r\nContent-Length: 1073741824\r\n";
    public int d = 2048;
    public String e = "PUT";
    public boolean f = false;

    public ja a() {
        return ja.TEST_TCPUPLOAD;
    }

    public boolean c() {
        return true;
    }

    public String toString() {
        return "TestHTTPFileUpload [measureLength=" + this.a + ", transferBytes=" + this.b + ", server=" + this.server + ", uuid=" + this.uuid + ", sign=" + this.sign + ", testSockets=" + this.testSockets + ", reportingInterval=" + this.reportingInterval + "]";
    }
}

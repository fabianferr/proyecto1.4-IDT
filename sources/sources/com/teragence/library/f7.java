package com.teragence.library;

import com.teragence.client.i;

public class f7 implements r5 {
    private final r5 a;

    public f7(r5 r5Var) {
        this.a = r5Var;
    }

    public a6 a(z5 z5Var) {
        try {
            return this.a.a(z5Var);
        } catch (Exception e) {
            i.b("SafeGdprSoapService", "registerDevice() " + e.getMessage());
            return null;
        }
    }

    public t5 a(s5 s5Var) {
        try {
            return this.a.a(s5Var);
        } catch (Exception e) {
            i.b("SafeGdprSoapService", "getTestConfig() " + e.getMessage());
            return null;
        }
    }

    public boolean a(b6 b6Var) {
        try {
            return this.a.a(b6Var);
        } catch (Exception e) {
            i.b("SafeGdprSoapService", "reportBurst() " + e.getMessage());
            return false;
        }
    }

    public boolean a(c6 c6Var) {
        try {
            return this.a.a(c6Var);
        } catch (Exception e) {
            i.b("SafeGdprSoapService", "reportDeadzones() " + e.getMessage());
            return false;
        }
    }

    public boolean a(d6 d6Var) {
        try {
            return this.a.a(d6Var);
        } catch (Exception e) {
            i.b("SafeGdprSoapService", "reportDownload() " + e.getMessage());
            return false;
        }
    }

    public boolean a(e6 e6Var) {
        try {
            return this.a.a(e6Var);
        } catch (Exception e) {
            i.b("SafeGdprSoapService", "reportMeasurement() " + e.getMessage());
            return false;
        }
    }

    public boolean a(v5 v5Var) {
        try {
            return this.a.a(v5Var);
        } catch (Exception e) {
            i.b("SafeGdprSoapService", "logError()" + e.getMessage());
            return false;
        }
    }

    public boolean a(y5 y5Var) {
        try {
            return this.a.a(y5Var);
        } catch (Exception e) {
            i.b("SafeGdprSoapService", "receivedBurst() " + e.getMessage());
            return false;
        }
    }
}

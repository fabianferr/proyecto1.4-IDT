package com.teragence.library;

import com.teragence.client.i;

public class g6 implements r5 {
    private final r5 a;

    public g6(r5 r5Var) {
        this.a = r5Var;
    }

    public a6 a(z5 z5Var) {
        i.a("LoggableGdprSoapService", "registerDevice() called with: registerDeviceRequest = [" + z5Var + "]");
        return this.a.a(z5Var);
    }

    public t5 a(s5 s5Var) {
        i.a("LoggableGdprSoapService", "getTestConfig() called with: request = [" + s5Var + "]");
        return this.a.a(s5Var);
    }

    public boolean a(b6 b6Var) {
        i.a("LoggableGdprSoapService", "reportBurst() called with: request = [" + b6Var + "]");
        return this.a.a(b6Var);
    }

    public boolean a(c6 c6Var) {
        i.a("LoggableGdprSoapService", "reportDeadzones() called with: request = [" + c6Var + "]");
        return this.a.a(c6Var);
    }

    public boolean a(d6 d6Var) {
        i.a("LoggableGdprSoapService", "reportDownload() called with: request = [" + d6Var + "]");
        return this.a.a(d6Var);
    }

    public boolean a(e6 e6Var) {
        i.a("LoggableGdprSoapService", "reportMeasurement() called with: reportMeasurementRequest = [" + e6Var + "]");
        return this.a.a(e6Var);
    }

    public boolean a(v5 v5Var) {
        i.a("LoggableGdprSoapService", "logError() called with: request = [" + v5Var + "]");
        return this.a.a(v5Var);
    }

    public boolean a(y5 y5Var) {
        i.a("LoggableGdprSoapService", "receivedBurst() called with: request = [" + y5Var + "]");
        return this.a.a(y5Var);
    }
}

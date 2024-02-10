package com.teragence.library;

public class h6 {
    private final String a;
    private r6 b;

    public h6(r6 r6Var, String str) {
        this.b = r6Var;
        this.a = str;
    }

    /* access modifiers changed from: package-private */
    public a7 a(z6 z6Var) {
        n8 n8Var = new n8(110);
        n8Var.k = true;
        n8Var.m = true;
        l8 l8Var = new l8("https://control.teragence.net/service2", "RegisterDevice");
        n8Var.a("https://control.teragence.net/service2", "request", z6.class);
        l8Var.b("request", z6Var);
        n8Var.a((Object) l8Var);
        try {
            new q2(this.a, 30000).a("https://control.teragence.net/service2/IService/RegisterDevice", n8Var);
            Object obj = n8Var.a;
            if (obj instanceof a8) {
                Exception exc = new Exception(((a8) obj).c);
                r6 r6Var = this.b;
                if (r6Var == null) {
                    return null;
                }
                r6Var.a(exc);
                return null;
            }
            l8 l8Var2 = (l8) obj;
            if (l8Var2.m() > 0) {
                return new a7((l8) l8Var2.a(0));
            }
            return null;
        } catch (Exception e) {
            r6 r6Var2 = this.b;
            if (r6Var2 == null) {
                return null;
            }
            r6Var2.a(e);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public q6 a(p6 p6Var) {
        n8 n8Var = new n8(110);
        n8Var.k = true;
        n8Var.m = true;
        l8 l8Var = new l8("https://control.teragence.net/service2", "GetTestConfig");
        n8Var.a("https://control.teragence.net/service2", "request", p6.class);
        l8Var.b("request", p6Var);
        n8Var.a((Object) l8Var);
        try {
            new q2(this.a, 30000).a("https://control.teragence.net/service2/IService/GetTestConfig", n8Var);
            Object obj = n8Var.a;
            if (obj instanceof a8) {
                Exception exc = new Exception(((a8) obj).c);
                r6 r6Var = this.b;
                if (r6Var == null) {
                    return null;
                }
                r6Var.a(exc);
                return null;
            }
            l8 l8Var2 = (l8) obj;
            if (l8Var2.m() > 0) {
                return new q6((l8) l8Var2.a(0));
            }
            return null;
        } catch (Exception e) {
            r6 r6Var2 = this.b;
            if (r6Var2 == null) {
                return null;
            }
            r6Var2.a(e);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean a(b7 b7Var) {
        n8 n8Var = new n8(110);
        n8Var.k = true;
        n8Var.m = true;
        l8 l8Var = new l8("https://control.teragence.net/service2", "ReportBurst");
        n8Var.a("https://control.teragence.net/service2", "request", b7.class);
        new j8().a(n8Var);
        l8Var.b("request", b7Var);
        n8Var.a((Object) l8Var);
        try {
            new q2(this.a, 30000).a("https://control.teragence.net/service2/IService/ReportBurst", n8Var);
            return true;
        } catch (Exception e) {
            r6 r6Var = this.b;
            if (r6Var == null) {
                return false;
            }
            r6Var.a(e);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean a(c7 c7Var) {
        n8 n8Var = new n8(110);
        n8Var.k = true;
        n8Var.m = true;
        l8 l8Var = new l8("https://control.teragence.net/service2", "ReportDeadzones");
        n8Var.a("https://control.teragence.net/service2", "request", c7.class);
        new j8().a(n8Var);
        l8Var.b("request", c7Var);
        n8Var.a((Object) l8Var);
        try {
            new q2(this.a, 30000).a("https://control.teragence.net/service2/IService/ReportDeadzones", n8Var);
            return true;
        } catch (Exception e) {
            r6 r6Var = this.b;
            if (r6Var == null) {
                return false;
            }
            r6Var.a(e);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean a(d7 d7Var) {
        n8 n8Var = new n8(110);
        n8Var.k = true;
        n8Var.m = true;
        l8 l8Var = new l8("https://control.teragence.net/service2", "ReportDownload");
        n8Var.a("https://control.teragence.net/service2", "request", d7.class);
        new j8().a(n8Var);
        l8Var.b("request", d7Var);
        n8Var.a((Object) l8Var);
        try {
            new q2(this.a, 30000).a("https://control.teragence.net/service2/IService/ReportDownload", n8Var);
            return true;
        } catch (Exception e) {
            r6 r6Var = this.b;
            if (r6Var == null) {
                return false;
            }
            r6Var.a(e);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean a(e7 e7Var) {
        n8 n8Var = new n8(110);
        n8Var.k = true;
        n8Var.m = true;
        l8 l8Var = new l8("https://control.teragence.net/service2", "ReportMeasurement");
        n8Var.a("https://control.teragence.net/service2", "request", e7.class);
        l8Var.b("request", e7Var);
        n8Var.a((Object) l8Var);
        try {
            new q2(this.a, 30000).a("https://control.teragence.net/service2/IService/ReportMeasurement", n8Var);
            return true;
        } catch (Exception e) {
            r6 r6Var = this.b;
            if (r6Var == null) {
                return false;
            }
            r6Var.a(e);
            return false;
        }
    }

    public boolean a(u6 u6Var) {
        n8 n8Var = new n8(110);
        n8Var.k = true;
        n8Var.m = true;
        l8 l8Var = new l8("https://control.teragence.net/service2", "LogError");
        n8Var.a("https://control.teragence.net/service2", "request", u6.class);
        l8Var.b("request", u6Var);
        n8Var.a((Object) l8Var);
        try {
            new q2(this.a, 30000).a("https://control.teragence.net/service2/IService/LogError", n8Var);
            return true;
        } catch (Exception e) {
            r6 r6Var = this.b;
            if (r6Var != null) {
                r6Var.a(e);
            }
            e.printStackTrace();
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean a(y6 y6Var) {
        n8 n8Var = new n8(110);
        n8Var.k = true;
        n8Var.m = true;
        l8 l8Var = new l8("https://control.teragence.net/service2", "ReceivedBurst");
        n8Var.a("https://control.teragence.net/service2", "request", y6.class);
        new j8().a(n8Var);
        l8Var.b("request", y6Var);
        n8Var.a((Object) l8Var);
        try {
            new q2(this.a, 30000).a("https://control.teragence.net/service2/IService/ReceivedBurst", n8Var);
            return true;
        } catch (Exception e) {
            r6 r6Var = this.b;
            if (r6Var == null) {
                return false;
            }
            r6Var.a(e);
            return false;
        }
    }
}

package com.umlaut.crowd.internal;

public class va extends Thread {
    private ta a;
    private s6 b;
    private boolean c;
    private boolean d = false;

    public va(s6 s6Var, ta taVar, boolean z) {
        this.a = taVar;
        this.b = s6Var;
        this.c = z;
    }

    public void a() {
        this.d = true;
        this.a.close();
    }

    public void run() {
        try {
            if (this.a.a(this.b.c)) {
                if (this.d) {
                    this.a.close();
                    return;
                }
                if (this.c) {
                    this.b.a(l2.PERFORM_TEST);
                }
                if (!this.a.f()) {
                    this.a.close();
                } else if (this.d) {
                    this.a.close();
                } else {
                    if (this.c) {
                        this.b.a(l2.REPORT_TEST);
                    }
                    if (!this.a.a()) {
                        this.a.close();
                    } else {
                        this.a.close();
                    }
                }
            }
        } catch (Exception e) {
            e3 d2 = this.a.d();
            sa b2 = this.a.b();
            r5 r5Var = r5.UNKNOWN;
            d2.a(b2, r5Var, "Error occured: " + e.getMessage());
        } finally {
            this.a.close();
        }
    }
}

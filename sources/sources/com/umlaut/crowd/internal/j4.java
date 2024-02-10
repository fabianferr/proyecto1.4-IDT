package com.umlaut.crowd.internal;

import java.util.HashMap;
import java.util.Set;

public class j4 {
    static final String e = "h";
    static final String f = "d";
    private static final int g = 1;
    private static final String h = "r";
    private static final String i = "b";
    private static final String j = "v";
    private static final String k = "c";
    private static final String l = "g";
    private String a = null;
    private int b = 0;
    private Boolean c = null;
    private HashMap<String, String> d = new HashMap<>();

    private void a(k4 k4Var) throws g4 {
        k4Var.H();
        while (k4Var.p()) {
            this.d.put(k4Var.q(), k4Var.z());
        }
        k4Var.l();
    }

    private void b(k4 k4Var) throws g4 {
        k4Var.H();
        while (k4Var.p()) {
            String q = k4Var.q();
            if (q.equals("r")) {
                this.a = k4Var.z();
            } else if (!q.equals("b")) {
                throw new g4("Unknown key \"" + q + "\"");
            } else if (k4Var.w() == 1) {
                this.c = Boolean.TRUE;
            } else {
                this.c = Boolean.FALSE;
            }
        }
        k4Var.l();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0030, code lost:
        if (r0.equals(l) == false) goto L_0x001c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void c(com.umlaut.crowd.internal.k4 r5) throws com.umlaut.crowd.internal.g4 {
        /*
            r4 = this;
            r5.H()
        L_0x0003:
            boolean r0 = r5.p()
            r1 = 1
            if (r0 == 0) goto L_0x0069
            java.lang.String r0 = r5.q()
            r0.hashCode()
            r0.hashCode()
            int r2 = r0.hashCode()
            r3 = -1
            switch(r2) {
                case 99: goto L_0x0033;
                case 103: goto L_0x002a;
                case 118: goto L_0x001e;
                default: goto L_0x001c;
            }
        L_0x001c:
            r1 = -1
            goto L_0x003d
        L_0x001e:
            java.lang.String r1 = "v"
            boolean r1 = r0.equals(r1)
            if (r1 != 0) goto L_0x0028
            goto L_0x001c
        L_0x0028:
            r1 = 2
            goto L_0x003d
        L_0x002a:
            java.lang.String r2 = "g"
            boolean r2 = r0.equals(r2)
            if (r2 != 0) goto L_0x003d
            goto L_0x001c
        L_0x0033:
            java.lang.String r1 = "c"
            boolean r1 = r0.equals(r1)
            if (r1 != 0) goto L_0x003c
            goto L_0x001c
        L_0x003c:
            r1 = 0
        L_0x003d:
            switch(r1) {
                case 0: goto L_0x0065;
                case 1: goto L_0x0061;
                case 2: goto L_0x0059;
                default: goto L_0x0040;
            }
        L_0x0040:
            com.umlaut.crowd.internal.g4 r5 = new com.umlaut.crowd.internal.g4
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Unknown header description field: \""
            r1.<init>(r2)
            r1.append(r0)
            java.lang.String r0 = "\""
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r5.<init>(r0)
            throw r5
        L_0x0059:
            long r0 = r5.w()
            int r1 = (int) r0
            r4.b = r1
            goto L_0x0003
        L_0x0061:
            r4.b((com.umlaut.crowd.internal.k4) r5)
            goto L_0x0003
        L_0x0065:
            r4.a((com.umlaut.crowd.internal.k4) r5)
            goto L_0x0003
        L_0x0069:
            int r0 = r4.b
            if (r1 != r0) goto L_0x0071
            r5.l()
            return
        L_0x0071:
            com.umlaut.crowd.internal.g4 r5 = new com.umlaut.crowd.internal.g4
            java.lang.String r0 = "Unknown Protocol version!"
            r5.<init>(r0)
            goto L_0x007a
        L_0x0079:
            throw r5
        L_0x007a:
            goto L_0x0079
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.j4.c(com.umlaut.crowd.internal.k4):void");
    }

    public boolean d() {
        Boolean bool = this.c;
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public String a(String str) {
        return this.d.get(str);
    }

    public Set<String> a() {
        return this.d.keySet();
    }

    public void a(String str, String str2) {
        this.d.put(str, str2);
    }

    public void a(boolean z) {
        this.c = Boolean.valueOf(z);
    }

    /* access modifiers changed from: package-private */
    public void a(o4 o4Var) throws g4 {
        o4Var.p();
        o4Var.b("v");
        o4Var.a(1);
        if (!(this.a == null && this.c == null)) {
            o4Var.b(l);
            o4Var.p();
            if (this.a != null) {
                o4Var.b("r");
                o4Var.d(this.a);
            }
            if (this.c != null) {
                o4Var.b("b");
                if (this.c.booleanValue()) {
                    o4Var.a(1);
                    o4Var.d(true);
                } else {
                    o4Var.a(0);
                    o4Var.d(false);
                }
            }
            o4Var.k();
        }
        if (this.d.size() > 0) {
            o4Var.b(k);
            o4Var.p();
            for (String next : this.d.keySet()) {
                o4Var.b(next);
                if (this.d.get(next) == null) {
                    o4Var.q();
                } else {
                    o4Var.d(this.d.get(next));
                }
            }
            o4Var.k();
        }
        o4Var.k();
    }

    public String b() {
        return this.a;
    }

    public void b(String str) {
        this.a = str;
    }

    public int c() {
        return this.b;
    }
}

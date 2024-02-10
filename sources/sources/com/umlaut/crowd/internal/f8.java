package com.umlaut.crowd.internal;

import java.text.ParseException;

public abstract class f8 extends e8 {
    private double c = 0.0d;
    private Integer d = null;

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.umlaut.crowd.internal.wb$a[] r0 = com.umlaut.crowd.internal.wb.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                com.umlaut.crowd.internal.wb$a r1 = com.umlaut.crowd.internal.wb.a.TOKEN_INTEGER     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.umlaut.crowd.internal.wb$a r1 = com.umlaut.crowd.internal.wb.a.TOKEN_NUMBER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.f8.a.<clinit>():void");
        }
    }

    protected f8(String str) {
        super(str);
    }

    /* access modifiers changed from: protected */
    public final void a(wb wbVar) throws ParseException {
        int i = a.a[wbVar.g().ordinal()];
        if (i == 1) {
            this.d = Integer.valueOf(wbVar.c());
        } else if (i == 2) {
            this.c = wbVar.a();
        } else {
            throw new ParseException("Attributevalue has be be a number \"" + wbVar.g() + "\"", wbVar.f());
        }
        b(wbVar);
    }

    /* access modifiers changed from: protected */
    public abstract boolean a(double d2, double d3);

    /* access modifiers changed from: protected */
    public abstract boolean a(int i, int i2);

    /* access modifiers changed from: protected */
    public void b(wb wbVar) throws ParseException {
    }

    /* access modifiers changed from: protected */
    public boolean a(String str) {
        if (str == null) {
            return false;
        }
        if (this.d != null) {
            return a(this.d.intValue(), Integer.parseInt(str));
        }
        return a(this.c, Double.parseDouble(str));
    }
}

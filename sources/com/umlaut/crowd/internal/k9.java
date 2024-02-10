package com.umlaut.crowd.internal;

public class k9 {
    private long a;
    private long b;
    private long c;
    private long d;
    private long e;
    private long f;
    private long g;

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.umlaut.crowd.internal.l9[] r0 = com.umlaut.crowd.internal.l9.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                com.umlaut.crowd.internal.l9 r1 = com.umlaut.crowd.internal.l9.Bad     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.umlaut.crowd.internal.l9 r1 = com.umlaut.crowd.internal.l9.Excellent     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.umlaut.crowd.internal.l9 r1 = com.umlaut.crowd.internal.l9.Fair     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.umlaut.crowd.internal.l9 r1 = com.umlaut.crowd.internal.l9.Good     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.umlaut.crowd.internal.l9 r1 = com.umlaut.crowd.internal.l9.Poor     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.umlaut.crowd.internal.l9 r1 = com.umlaut.crowd.internal.l9.Unknown     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.k9.a.<clinit>():void");
        }
    }

    public k9() {
        this.a = 0;
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = 0;
    }

    public void addMeasurement(l9 l9Var) {
        this.a++;
        int i = a.a[l9Var.ordinal()];
        if (i == 1) {
            this.b++;
        } else if (i == 2) {
            this.c++;
        } else if (i == 3) {
            this.d++;
        } else if (i == 4) {
            this.e++;
        } else if (i != 5) {
            this.g++;
        } else {
            this.f++;
        }
    }

    public long getSamplesBad() {
        return this.b;
    }

    public long getSamplesExcellent() {
        return this.c;
    }

    public long getSamplesFair() {
        return this.d;
    }

    public long getSamplesGood() {
        return this.e;
    }

    public long getSamplesPoor() {
        return this.f;
    }

    public long getSamplesTotal() {
        return this.a;
    }

    public long getSamplesUnknown() {
        return this.g;
    }

    public double getShareBad() {
        long j = this.a;
        if (j == 0) {
            return 0.0d;
        }
        double d2 = (double) this.b;
        double d3 = (double) j;
        Double.isNaN(d2);
        Double.isNaN(d3);
        return d2 / d3;
    }

    public double getShareExcellect() {
        long j = this.a;
        if (j == 0) {
            return 0.0d;
        }
        double d2 = (double) this.c;
        double d3 = (double) j;
        Double.isNaN(d2);
        Double.isNaN(d3);
        return d2 / d3;
    }

    public double getShareFair() {
        long j = this.a;
        if (j == 0) {
            return 0.0d;
        }
        double d2 = (double) this.d;
        double d3 = (double) j;
        Double.isNaN(d2);
        Double.isNaN(d3);
        return d2 / d3;
    }

    public double getShareGood() {
        long j = this.a;
        if (j == 0) {
            return 0.0d;
        }
        double d2 = (double) this.e;
        double d3 = (double) j;
        Double.isNaN(d2);
        Double.isNaN(d3);
        return d2 / d3;
    }

    public double getSharePoor() {
        long j = this.a;
        if (j == 0) {
            return 0.0d;
        }
        double d2 = (double) this.f;
        double d3 = (double) j;
        Double.isNaN(d2);
        Double.isNaN(d3);
        return d2 / d3;
    }

    public double getShareUnknown() {
        long j = this.a;
        if (j == 0) {
            return 0.0d;
        }
        double d2 = (double) this.g;
        double d3 = (double) j;
        Double.isNaN(d2);
        Double.isNaN(d3);
        return d2 / d3;
    }

    public void reset() {
        this.a = 0;
        this.c = 0;
        this.e = 0;
        this.d = 0;
        this.f = 0;
        this.b = 0;
        this.g = 0;
    }

    public k9(long j, long j2, long j3, long j4, long j5, long j6) {
        this.b = j6;
        this.c = j2;
        this.e = j3;
        this.f = j5;
        this.d = j4;
        this.g = j;
        this.a = j6 + j2 + j4 + j3 + j5 + j;
    }
}

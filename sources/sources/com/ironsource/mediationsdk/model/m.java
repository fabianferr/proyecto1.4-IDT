package com.ironsource.mediationsdk.model;

public final class m {
    public boolean a;
    public boolean b;
    public boolean c;
    public n d;
    public int e;
    public int f;

    public static class a {
        public boolean a = true;
        private boolean b = false;
        private boolean c = false;
        private n d = null;
        private int e = 0;
        private int f = 0;

        public final a a(boolean z, int i) {
            this.c = z;
            this.f = i;
            return this;
        }

        public final a a(boolean z, n nVar, int i) {
            this.b = z;
            if (nVar == null) {
                nVar = n.PER_DAY;
            }
            this.d = nVar;
            this.e = i;
            return this;
        }

        public final m a() {
            return new m(this.a, this.b, this.c, this.d, this.e, this.f, (byte) 0);
        }
    }

    private m(boolean z, boolean z2, boolean z3, n nVar, int i, int i2) {
        this.a = z;
        this.b = z2;
        this.c = z3;
        this.d = nVar;
        this.e = i;
        this.f = i2;
    }

    /* synthetic */ m(boolean z, boolean z2, boolean z3, n nVar, int i, int i2, byte b2) {
        this(z, z2, z3, nVar, i, i2);
    }
}

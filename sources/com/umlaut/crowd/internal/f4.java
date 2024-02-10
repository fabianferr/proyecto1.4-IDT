package com.umlaut.crowd.internal;

abstract class f4 {
    protected static final int d = 200;
    protected final char[] a = new char[200];
    protected int b = 0;
    protected char c;

    /* access modifiers changed from: protected */
    public void a(char c2) throws g4 {
        if (c2 == 'a' || c2 == 'o' || c2 == 'd') {
            int i = this.b;
            if (i < 200) {
                this.a[i] = c2;
                this.c = c2;
                this.b = i + 1;
                return;
            }
            throw new g4("Nesting too deep.");
        }
        throw new g4("Only Arrays and objects can be surrounding objects");
    }

    public i4 g() {
        char c2 = this.c;
        if (c2 == 'v' && h() == 'd') {
            c2 = 'd';
        }
        return i4.a(c2);
    }

    /* access modifiers changed from: protected */
    public char h() {
        int i = this.b;
        if (i <= 0) {
            return 0;
        }
        return this.a[i - 1];
    }

    /* access modifiers changed from: protected */
    public char i() {
        this.b--;
        return h();
    }
}

package com.teragence.library;

public class e implements f {
    private final f a;
    private String b;

    public e(f fVar) {
        this.a = fVar;
    }

    public String toString() {
        if (this.b == null) {
            this.b = this.a.toString();
        }
        return this.b;
    }
}

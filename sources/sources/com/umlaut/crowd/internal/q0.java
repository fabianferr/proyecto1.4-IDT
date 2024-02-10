package com.umlaut.crowd.internal;

import java.util.Arrays;

public final class q0 {
    private byte[] a;

    public q0(int i) {
        this.a = new byte[i];
    }

    public byte[] a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof q0)) {
            return false;
        }
        return Arrays.equals(this.a, ((q0) obj).a);
    }

    public int hashCode() {
        return Arrays.hashCode(this.a);
    }

    public q0(byte[] bArr) {
        bArr.getClass();
        this.a = bArr;
    }
}

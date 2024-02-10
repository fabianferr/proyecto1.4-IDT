package com.cellrebel.sdk.database;

public class ConnectionTimeActive {
    public long a;
    public long b;
    public ConnectionType c;

    public ConnectionType a() {
        return this.c;
    }

    /* access modifiers changed from: protected */
    public boolean a(Object obj) {
        return obj instanceof ConnectionTimeActive;
    }

    public long b() {
        return this.b;
    }

    public long c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConnectionTimeActive)) {
            return false;
        }
        ConnectionTimeActive connectionTimeActive = (ConnectionTimeActive) obj;
        if (!connectionTimeActive.a(this) || c() != connectionTimeActive.c() || b() != connectionTimeActive.b()) {
            return false;
        }
        ConnectionType a2 = a();
        ConnectionType a3 = connectionTimeActive.a();
        return a2 != null ? a2.equals(a3) : a3 == null;
    }

    public int hashCode() {
        long c2 = c();
        long b2 = b();
        int i = ((((int) (c2 ^ (c2 >>> 32))) + 59) * 59) + ((int) (b2 ^ (b2 >>> 32)));
        ConnectionType a2 = a();
        return (i * 59) + (a2 == null ? 43 : a2.hashCode());
    }

    public String toString() {
        return "ConnectionTimeActive(id=" + c() + ", duration=" + b() + ", connectionType=" + a() + ")";
    }
}

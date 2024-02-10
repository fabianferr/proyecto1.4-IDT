package com.cellrebel.sdk.database;

public class ConnectionTimePassive {
    public long a;
    public ConnectionType b;
    public long c;

    public ConnectionTimePassive a(long j) {
        this.c = j;
        return this;
    }

    public ConnectionTimePassive a(ConnectionType connectionType) {
        this.b = connectionType;
        return this;
    }

    public ConnectionType a() {
        return this.b;
    }

    /* access modifiers changed from: protected */
    public boolean a(Object obj) {
        return obj instanceof ConnectionTimePassive;
    }

    public long b() {
        return this.c;
    }

    public long c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConnectionTimePassive)) {
            return false;
        }
        ConnectionTimePassive connectionTimePassive = (ConnectionTimePassive) obj;
        if (!connectionTimePassive.a((Object) this) || c() != connectionTimePassive.c()) {
            return false;
        }
        ConnectionType a2 = a();
        ConnectionType a3 = connectionTimePassive.a();
        if (a2 != null ? a2.equals(a3) : a3 == null) {
            return b() == connectionTimePassive.b();
        }
        return false;
    }

    public int hashCode() {
        long c2 = c();
        ConnectionType a2 = a();
        int i = (((int) (c2 ^ (c2 >>> 32))) + 59) * 59;
        int hashCode = a2 == null ? 43 : a2.hashCode();
        long b2 = b();
        return ((i + hashCode) * 59) + ((int) (b2 ^ (b2 >>> 32)));
    }

    public String toString() {
        return "ConnectionTimePassive(id=" + c() + ", connectionType=" + a() + ", duration=" + b() + ")";
    }
}

package com.ironsource.mediationsdk.adunit.c.c;

public final class a {
    public final C0109a a;
    public final long b;
    public final long c;
    public final long d;

    /* renamed from: com.ironsource.mediationsdk.adunit.c.c.a$a  reason: collision with other inner class name */
    public enum C0109a {
        MANUAL,
        MANUAL_WITH_AUTOMATIC_RELOAD,
        AUTOMATIC_LOAD_AFTER_CLOSE,
        AUTOMATIC_LOAD_WHILE_SHOW
    }

    public a(C0109a aVar, long j, long j2, long j3) {
        this.a = aVar;
        this.b = j;
        this.c = j2;
        this.d = j3;
    }

    public final boolean a() {
        return this.a == C0109a.MANUAL || this.a == C0109a.MANUAL_WITH_AUTOMATIC_RELOAD;
    }

    public final boolean b() {
        return this.a == C0109a.AUTOMATIC_LOAD_AFTER_CLOSE || this.a == C0109a.AUTOMATIC_LOAD_WHILE_SHOW;
    }
}

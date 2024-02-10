package com.teragence.library;

import com.teragence.client.i;

public class d0 implements r {
    private final r a;

    public d0(r rVar) {
        this.a = rVar;
    }

    public void a(e6... e6VarArr) {
        i.a("LFailedReportsRepository", "queue() called with: report = [" + e6VarArr + "]");
        this.a.a(e6VarArr);
    }

    public e6[] a() {
        i.a("LFailedReportsRepository", "pollAll() called");
        return this.a.a();
    }
}

package com.startapp.sdk.jobs;

import com.startapp.l7;
import com.startapp.sdk.jobs.JobRequest;

/* compiled from: Sta */
public final class d extends JobRequest {
    public final Long e;

    /* compiled from: Sta */
    public static final class a extends JobRequest.a<a> {
        public Long d;

        public a(Class<? extends b> cls) {
            super(cls);
        }

        public JobRequest.a a() {
            return this;
        }
    }

    public d(a aVar) {
        super(aVar);
        this.e = aVar.d;
    }

    public boolean a(l7 l7Var) {
        return l7Var.a(this, this.e, (Long) null);
    }
}

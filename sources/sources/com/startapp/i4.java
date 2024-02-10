package com.startapp;

import com.startapp.sdk.jobs.JobRequest;

/* compiled from: Sta */
public class i4 {
    public final l7 a;
    public final l7 b;

    public i4(l7 l7Var, l7 l7Var2) {
        this.a = l7Var;
        this.b = l7Var2;
    }

    public boolean a(JobRequest... jobRequestArr) {
        boolean z = true;
        for (JobRequest jobRequest : jobRequestArr) {
            if (jobRequest.d) {
                if (jobRequest.a(this.b)) {
                }
            } else if (jobRequest.a(this.a)) {
            }
            z = false;
        }
        return z;
    }

    public boolean a(int i) {
        if (!this.b.a(i)) {
            return this.a.a(i);
        }
        return true;
    }
}

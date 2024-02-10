package com.startapp;

import com.startapp.sdk.triggeredlinks.TriggeredLinksMetadata;

/* compiled from: Sta */
public class b9 implements Runnable {
    public final /* synthetic */ TriggeredLinksMetadata a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ int d;
    public final /* synthetic */ z8 e;

    public b9(z8 z8Var, TriggeredLinksMetadata triggeredLinksMetadata, String str, String str2, int i) {
        this.e = z8Var;
        this.a = triggeredLinksMetadata;
        this.b = str;
        this.c = str2;
        this.d = i;
    }

    public void run() {
        try {
            this.e.a(this.a, "Periodic", this.b, this.c);
        } catch (Throwable th) {
            if (this.e.a(1)) {
                i3.a(th);
            }
        } finally {
            this.e.a(this.b, this.d);
            this.e.a(0);
        }
    }
}

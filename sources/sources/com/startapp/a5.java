package com.startapp;

import com.iab.omid.library.startio.publisher.AdSessionStatePublisher;

/* compiled from: Sta */
public final class a5 {
    public final fb a;

    public a5(fb fbVar) {
        this.a = fbVar;
    }

    public static a5 a(o oVar) {
        fb fbVar = (fb) oVar;
        if (!fbVar.e()) {
            throw new IllegalStateException("Cannot create MediaEvents for JavaScript AdSession");
        } else if (fbVar.f) {
            throw new IllegalStateException("AdSession is started");
        } else if (!fbVar.g) {
            AdSessionStatePublisher adSessionStatePublisher = fbVar.e;
            if (adSessionStatePublisher.c == null) {
                a5 a5Var = new a5(fbVar);
                adSessionStatePublisher.c = a5Var;
                return a5Var;
            }
            throw new IllegalStateException("MediaEvents already exists for AdSession");
        } else {
            throw new IllegalStateException("AdSession is finished");
        }
    }

    public final void a(float f) {
        if (f < 0.0f || f > 1.0f) {
            throw new IllegalArgumentException("Invalid Media volume");
        }
    }
}

package com.startapp;

import com.iab.omid.library.startio.publisher.AdSessionStatePublisher;

/* compiled from: Sta */
public final class l {
    public final fb a;

    public l(fb fbVar) {
        this.a = fbVar;
    }

    public static l a(o oVar) {
        fb fbVar = (fb) oVar;
        AdSessionStatePublisher adSessionStatePublisher = fbVar.e;
        if (adSessionStatePublisher.b != null) {
            throw new IllegalStateException("AdEvents already exists for AdSession");
        } else if (!fbVar.g) {
            l lVar = new l(fbVar);
            adSessionStatePublisher.b = lVar;
            return lVar;
        } else {
            throw new IllegalStateException("AdSession is finished");
        }
    }
}

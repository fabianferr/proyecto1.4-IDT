package com.startapp;

import com.iab.omid.library.startio.adsession.CreativeType;
import com.iab.omid.library.startio.adsession.ImpressionType;
import com.iab.omid.library.startio.adsession.Owner;

/* compiled from: Sta */
public class p {
    public final Owner a;
    public final Owner b;
    public final boolean c;
    public final CreativeType d;
    public final ImpressionType e;

    public p(CreativeType creativeType, ImpressionType impressionType, Owner owner, Owner owner2, boolean z) {
        this.d = creativeType;
        this.e = impressionType;
        this.a = owner;
        if (owner2 == null) {
            this.b = Owner.NONE;
        } else {
            this.b = owner2;
        }
        this.c = z;
    }
}

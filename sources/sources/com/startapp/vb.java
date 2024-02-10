package com.startapp;

import android.view.View;
import com.iab.omid.library.startio.adsession.FriendlyObstructionPurpose;

/* compiled from: Sta */
public class vb {
    public final lb a;
    public final String b;
    public final FriendlyObstructionPurpose c;
    public final String d;

    public vb(View view, FriendlyObstructionPurpose friendlyObstructionPurpose, String str) {
        this.a = new lb(view);
        this.b = view.getClass().getCanonicalName();
        this.c = friendlyObstructionPurpose;
        this.d = str;
    }
}

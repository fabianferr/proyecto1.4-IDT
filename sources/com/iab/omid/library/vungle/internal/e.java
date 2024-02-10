package com.iab.omid.library.vungle.internal;

import android.view.View;
import com.iab.omid.library.vungle.adsession.FriendlyObstructionPurpose;
import com.iab.omid.library.vungle.weakreference.a;

public class e {
    private final a a;
    private final String b;
    private final FriendlyObstructionPurpose c;
    private final String d;

    public e(View view, FriendlyObstructionPurpose friendlyObstructionPurpose, String str) {
        this.a = new a(view);
        this.b = view.getClass().getCanonicalName();
        this.c = friendlyObstructionPurpose;
        this.d = str;
    }

    public String a() {
        return this.d;
    }

    public FriendlyObstructionPurpose b() {
        return this.c;
    }

    public a c() {
        return this.a;
    }

    public String d() {
        return this.b;
    }
}

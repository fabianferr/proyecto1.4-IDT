package com.applovin.impl.sdk.b;

import android.view.View;
import com.iab.omid.library.applovin.adsession.FriendlyObstructionPurpose;

public class d {
    private final View a;
    private final FriendlyObstructionPurpose b;
    private final String c;

    public d(View view, FriendlyObstructionPurpose friendlyObstructionPurpose, String str) {
        this.a = view;
        this.b = friendlyObstructionPurpose;
        this.c = str;
    }

    public View a() {
        return this.a;
    }

    public FriendlyObstructionPurpose b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        View view = this.a;
        if (view == null ? dVar.a != null : !view.equals(dVar.a)) {
            return false;
        }
        if (this.b != dVar.b) {
            return false;
        }
        String str = this.c;
        String str2 = dVar.c;
        return str != null ? str.equals(str2) : str2 == null;
    }

    public int hashCode() {
        View view = this.a;
        int i = 0;
        int hashCode = (view != null ? view.hashCode() : 0) * 31;
        FriendlyObstructionPurpose friendlyObstructionPurpose = this.b;
        int hashCode2 = (hashCode + (friendlyObstructionPurpose != null ? friendlyObstructionPurpose.hashCode() : 0)) * 31;
        String str = this.c;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode2 + i;
    }
}

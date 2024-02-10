package com.startapp;

import com.startapp.sdk.adsbase.model.AdPreferences;

/* compiled from: Sta */
public class e implements Comparable<e> {
    public long a = System.currentTimeMillis();
    public AdPreferences.Placement b;
    public String c;

    public e(AdPreferences.Placement placement, String str) {
        this.b = placement;
        this.c = str == null ? "" : str;
    }

    public int compareTo(Object obj) {
        int i = ((this.a - ((e) obj).a) > 0 ? 1 : ((this.a - ((e) obj).a) == 0 ? 0 : -1));
        if (i > 0) {
            return 1;
        }
        return i == 0 ? 0 : -1;
    }

    public String toString() {
        StringBuilder a2 = p0.a("AdDisplayEvent [displayTime=");
        a2.append(this.a);
        a2.append(", placement=");
        a2.append(this.b);
        a2.append(", adTag=");
        a2.append(this.c);
        a2.append("]");
        return a2.toString();
    }
}

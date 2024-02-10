package com.startapp;

import java.util.List;

/* compiled from: Sta */
public class fa {
    public List<String> a;
    public String b;

    public fa(List<String> list, String str) {
        this.a = list;
        this.b = str;
    }

    public String toString() {
        StringBuilder a2 = p0.a("[VideoEvent: tag=");
        a2.append(this.b);
        a2.append(", fullUrls=");
        a2.append(this.a.toString());
        a2.append("]");
        return a2.toString();
    }
}

package com.startapp;

import java.util.regex.Pattern;

/* compiled from: Sta */
public class n8 {
    public final Pattern a = Pattern.compile("\\+");
    public final Pattern b = Pattern.compile("/");
    public final Pattern c = Pattern.compile("=");

    public n8() {
        Pattern.compile("_");
        Pattern.compile("\\*");
        Pattern.compile("#");
    }

    public String a(String str) {
        return this.c.matcher(this.b.matcher(this.a.matcher(str).replaceAll("_")).replaceAll("*")).replaceAll("#");
    }
}

package com.umlaut.crowd.internal;

public class kd implements Cloneable {
    public String Key;
    public String Value;

    public kd(String str, String str2) {
        this.Key = str;
        this.Value = str2;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

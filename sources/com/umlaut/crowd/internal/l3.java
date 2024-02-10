package com.umlaut.crowd.internal;

public class l3 implements Cloneable {
    public String Key;
    public String Value;

    public l3() {
        this.Key = "";
        this.Value = "";
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public l3(String str, String str2) {
        this.Key = str;
        this.Value = str2;
    }
}

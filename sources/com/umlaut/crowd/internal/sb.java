package com.umlaut.crowd.internal;

public class sb implements Cloneable {
    public double Temperature;
    public String Type;

    public sb(String str, double d) {
        this.Type = str;
        this.Temperature = d;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

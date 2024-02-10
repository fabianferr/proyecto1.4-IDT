package com.umlaut.crowd.internal;

public class k1 implements Cloneable {
    public double BogoMIPS;
    public int CoreNumber;
    public String ModelName = "";

    public Object clone() throws CloneNotSupportedException {
        return (k1) super.clone();
    }
}

package com.umlaut.crowd.internal;

public class k7 implements Cloneable {
    public String Answer;
    public int Index;

    public k7(int i, String str) {
        this.Index = i;
        this.Answer = str;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

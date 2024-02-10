package com.umlaut.crowd.internal;

public class RBR implements Cloneable {
    public String GUID;
    public String ProjectId;
    public String Version = "20230301124918";

    public RBR(String str, String str2) {
        this.ProjectId = str;
        this.GUID = str2;
    }

    /* access modifiers changed from: protected */
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

package com.umlaut.crowd.internal;

public class x7 implements Cloneable {
    public l3[] HeaderItem = new l3[0];
    public String IP = "";
    public int ResponseCode = -1;
    public int Socket = -1;

    public Object clone() throws CloneNotSupportedException {
        x7 x7Var = (x7) super.clone();
        x7Var.HeaderItem = new l3[this.HeaderItem.length];
        int i = 0;
        while (true) {
            l3[] l3VarArr = this.HeaderItem;
            if (i >= l3VarArr.length) {
                return x7Var;
            }
            x7Var.HeaderItem[i] = (l3) l3VarArr[i].clone();
            i++;
        }
    }
}

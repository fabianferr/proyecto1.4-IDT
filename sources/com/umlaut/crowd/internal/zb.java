package com.umlaut.crowd.internal;

public class zb implements Cloneable {
    public y7[] Route = new y7[0];

    public Object clone() throws CloneNotSupportedException {
        zb zbVar = (zb) super.clone();
        zbVar.Route = new y7[this.Route.length];
        int i = 0;
        while (true) {
            y7[] y7VarArr = this.Route;
            if (i >= y7VarArr.length) {
                return zbVar;
            }
            zbVar.Route[i] = (y7) y7VarArr[i].clone();
            i++;
        }
    }
}

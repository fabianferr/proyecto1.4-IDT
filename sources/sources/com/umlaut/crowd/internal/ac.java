package com.umlaut.crowd.internal;

public class ac extends RP3 implements Cloneable {
    public String AirportCode = "";
    public e4 IspInfo = new e4();
    public String Rdns = "";
    public y7[] Route = new y7[0];
    public String TrcId = "";

    public ac(String str, String str2) {
        super(str, str2);
    }

    public Object clone() throws CloneNotSupportedException {
        ac acVar = (ac) super.clone();
        acVar.Route = new y7[this.Route.length];
        int i = 0;
        while (true) {
            y7[] y7VarArr = this.Route;
            if (i >= y7VarArr.length) {
                return acVar;
            }
            acVar.Route[i] = (y7) y7VarArr[i].clone();
            i++;
        }
    }
}

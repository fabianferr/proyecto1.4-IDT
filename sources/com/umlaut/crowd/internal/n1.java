package com.umlaut.crowd.internal;

import java.io.Serializable;

public class n1 implements Cloneable, Serializable {
    private static final long a = -937846764179533362L;
    public int CoresAvgFrequency = -1;
    public int CoresOnline = -1;
    public l1[] CpuCoresLoads = new l1[0];
    public double CpuLoad = -1.0d;
    public int GpuFrequency = -1;
    public double GpuLoad = -1.0d;
    public int GpuMaxFrequency = -1;

    public Object clone() throws CloneNotSupportedException {
        n1 n1Var = (n1) super.clone();
        n1Var.CpuCoresLoads = new l1[this.CpuCoresLoads.length];
        int i = 0;
        while (true) {
            l1[] l1VarArr = this.CpuCoresLoads;
            if (i >= l1VarArr.length) {
                return n1Var;
            }
            n1Var.CpuCoresLoads[i] = (l1) l1VarArr[i].clone();
            i++;
        }
    }
}

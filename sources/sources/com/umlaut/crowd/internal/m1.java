package com.umlaut.crowd.internal;

public class m1 implements Cloneable {
    public k1[] Cores = new k1[0];
    public String CpuArchitecture = "";
    public String CpuChipRevision = "";
    public String[] CpuFeatures = new String[0];
    public String CpuHardware = "";
    public String CpuImplementer = "";
    public String CpuPart = "";
    public String CpuRevision = "";
    public String CpuRevisionCode = "";
    public String CpuVariant = "";
    public String MSMHardware = "";
    public int NumberOfCores;
    public String Processor = "";

    public Object clone() throws CloneNotSupportedException {
        m1 m1Var = (m1) super.clone();
        m1Var.Cores = new k1[this.Cores.length];
        int i = 0;
        int i2 = 0;
        while (true) {
            k1[] k1VarArr = this.Cores;
            if (i2 >= k1VarArr.length) {
                break;
            }
            m1Var.Cores[i2] = (k1) k1VarArr[i2].clone();
            i2++;
        }
        m1Var.CpuFeatures = new String[this.CpuFeatures.length];
        while (true) {
            String[] strArr = this.CpuFeatures;
            if (i >= strArr.length) {
                return m1Var;
            }
            m1Var.CpuFeatures[i] = strArr[i];
            i++;
        }
    }
}

package com.umlaut.crowd.internal;

import com.umlaut.crowd.enums.ThreeState;

public class a2 implements Cloneable {
    public l0 BluetoothInfo = new l0();
    public String BuildFingerprint = "";
    public m1 CpuInfo = new m1();
    public String DeviceManufacturer = "";
    public String DeviceName = "";
    public long DeviceUpTime;
    public c2 DisplayInfo = new c2();
    public n3 HostAppInfo = new n3();
    public boolean IsRooted;
    public y5 MultiSimInfo = new y5();
    public r6 OS = r6.Android;
    public String OSVersion = "";
    public String OsSystemVersion = "";
    public int PhoneCount = -1;
    public v6 PhoneType = v6.Unknown;
    public ThreeState PowerSaveMode = ThreeState.Unknown;
    public c9[] Sensors = new c9[0];
    public String SimOperator = "";
    public String SimOperatorName = "";
    public p9 SimState = p9.Unknown;
    public String TAC = "";
    public String UserLocal = "";

    public Object clone() throws CloneNotSupportedException {
        a2 a2Var = (a2) super.clone();
        a2Var.CpuInfo = (m1) this.CpuInfo.clone();
        a2Var.DisplayInfo = (c2) this.DisplayInfo.clone();
        a2Var.BluetoothInfo = (l0) this.BluetoothInfo.clone();
        a2Var.MultiSimInfo = (y5) this.MultiSimInfo.clone();
        a2Var.HostAppInfo = (n3) this.HostAppInfo.clone();
        return a2Var;
    }
}

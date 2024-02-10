package com.umlaut.crowd.internal;

public class l0 implements Cloneable {
    public h0 A2DPConnectionState;
    public boolean BluetoothEnabled;
    public j0[] ConnectedA2DPBluetoothDevices = new j0[0];
    public j0[] ConnectedHeadsetBluetoothDevices = new j0[0];
    public j0[] ConnectedHealthBluetoothDevices = new j0[0];
    public h0 HeadsetConnectionState;
    public h0 HealthConnectionState;
    public boolean MissingPermission = false;
    public j0[] PairedBluetoothDevices = new j0[0];

    public l0() {
        h0 h0Var = h0.Unknown;
        this.HealthConnectionState = h0Var;
        this.HeadsetConnectionState = h0Var;
        this.A2DPConnectionState = h0Var;
    }

    public Object clone() throws CloneNotSupportedException {
        l0 l0Var = (l0) super.clone();
        l0Var.PairedBluetoothDevices = new j0[this.PairedBluetoothDevices.length];
        int i = 0;
        int i2 = 0;
        while (true) {
            j0[] j0VarArr = this.PairedBluetoothDevices;
            if (i2 >= j0VarArr.length) {
                break;
            }
            l0Var.PairedBluetoothDevices[i2] = (j0) j0VarArr[i2].clone();
            i2++;
        }
        l0Var.ConnectedA2DPBluetoothDevices = new j0[this.ConnectedA2DPBluetoothDevices.length];
        int i3 = 0;
        while (true) {
            j0[] j0VarArr2 = this.ConnectedA2DPBluetoothDevices;
            if (i3 >= j0VarArr2.length) {
                break;
            }
            l0Var.ConnectedA2DPBluetoothDevices[i3] = (j0) j0VarArr2[i3].clone();
            i3++;
        }
        l0Var.ConnectedHealthBluetoothDevices = new j0[this.ConnectedHealthBluetoothDevices.length];
        int i4 = 0;
        while (true) {
            j0[] j0VarArr3 = this.ConnectedHealthBluetoothDevices;
            if (i4 >= j0VarArr3.length) {
                break;
            }
            l0Var.ConnectedHealthBluetoothDevices[i4] = (j0) j0VarArr3[i4].clone();
            i4++;
        }
        l0Var.ConnectedHeadsetBluetoothDevices = new j0[this.ConnectedHeadsetBluetoothDevices.length];
        while (true) {
            j0[] j0VarArr4 = this.ConnectedHeadsetBluetoothDevices;
            if (i >= j0VarArr4.length) {
                return l0Var;
            }
            l0Var.ConnectedHeadsetBluetoothDevices[i] = (j0) j0VarArr4[i].clone();
            i++;
        }
    }
}

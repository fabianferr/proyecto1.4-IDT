package com.umlaut.crowd.internal;

import com.umlaut.crowd.enums.NetworkTypes;
import java.io.Serializable;

public class j6 implements Cloneable, Serializable {
    private static final long a = 9179460790954950419L;
    public int Age;
    public int Arfcn;
    public String AvailableServices;
    public int Bandwidth;
    public tb CarrierAggregation;
    public String CellId;
    public a1 CellTechnology;
    public tb DcNrRestricted;
    public i2 Domain = i2.Unknown;
    public boolean EmergencyEnabled = false;
    public tb EnDcAvailable;
    public int MaxDataCalls;
    public String Mcc;
    public String Mnc;
    public NetworkTypes NetworkTechnology = NetworkTypes.Unknown;
    public tb NrAvailable;
    public o6 NrState;
    public String OperatorLong;
    public String OperatorShort;
    public String Pci;
    public String ReasonForDenial = "";
    public String RegState = "";
    public String Tac;
    public qc TransportType = qc.Unknown;

    public j6() {
        tb tbVar = tb.Unknown;
        this.CarrierAggregation = tbVar;
        this.CellTechnology = a1.Unknown;
        this.CellId = "";
        this.Tac = "";
        this.Pci = "";
        this.Arfcn = -1;
        this.Bandwidth = -1;
        this.Mcc = "";
        this.Mnc = "";
        this.OperatorLong = "";
        this.OperatorShort = "";
        this.MaxDataCalls = -1;
        this.AvailableServices = "";
        this.NrState = o6.Unknown;
        this.DcNrRestricted = tbVar;
        this.NrAvailable = tbVar;
        this.EnDcAvailable = tbVar;
        this.Age = -1;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

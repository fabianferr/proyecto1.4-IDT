package com.umlaut.crowd.internal;

import com.umlaut.crowd.enums.NetworkTypes;
import java.io.Serializable;

public class c6 implements Cloneable, Serializable {
    private static final long a = 341410194515647516L;
    public int ARFCN = -1;
    public int EcN0 = 0;
    public String GsmCellId = "";
    public String GsmLAC = "";
    public NetworkTypes NetworkType = NetworkTypes.Unknown;
    public String PrimaryScramblingCode = "";
    public int RXLevel;

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

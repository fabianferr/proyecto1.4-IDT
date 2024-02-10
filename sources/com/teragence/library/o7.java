package com.teragence.library;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class o7 implements x5 {
    private final String cell;
    private final String cellInfo;
    private final int dbmSignalStrength;
    private final boolean isNetworkRoaming;
    private final w5 networkInfo;
    private final double rxRate;
    private final String signalStrength;
    private final double txRate;

    public o7(w5 w5Var, String str, String str2, String str3, boolean z, double d, double d2, int i) {
        this.networkInfo = w5Var;
        this.signalStrength = str;
        this.cell = str2;
        this.cellInfo = str3;
        this.isNetworkRoaming = z;
        this.rxRate = d;
        this.txRate = d2;
        this.dbmSignalStrength = i;
    }

    public String a() {
        return this.cell;
    }

    public boolean b() {
        return this.isNetworkRoaming;
    }

    public int c() {
        return this.dbmSignalStrength;
    }

    public w5 d() {
        return this.networkInfo;
    }

    public double e() {
        return this.rxRate;
    }

    public double f() {
        return this.txRate;
    }

    public String g() {
        return this.cellInfo;
    }

    public String h() {
        return this.signalStrength;
    }

    public String toString() {
        return "NetworkStatus{networkInfo=" + this.networkInfo + ", signalStrength='" + this.signalStrength + "', cell='" + this.cell + "', cellInfo='" + this.cellInfo + "', isNetworkRoaming=" + this.isNetworkRoaming + ", rxRate=" + this.rxRate + ", txRate=" + this.txRate + ", dbmSignalStrength=" + this.dbmSignalStrength + AbstractJsonLexerKt.END_OBJ;
    }
}

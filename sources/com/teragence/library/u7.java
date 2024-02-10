package com.teragence.library;

import java.util.Date;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class u7 implements e6 {
    private final n5 activityTypeId;
    private final long deviceId;
    private final boolean hasAvailableCellInfo;
    private final boolean hasCellInfo;
    private final boolean hasLocation;
    private final Date measurementDate;
    private final w5 network;
    private final String ownerKey;

    public u7(long j, Date date, String str, w5 w5Var, n5 n5Var, boolean z, boolean z2, boolean z3) {
        this.deviceId = j;
        this.measurementDate = date;
        this.ownerKey = str;
        this.network = w5Var;
        this.activityTypeId = n5Var;
        this.hasLocation = z;
        this.hasCellInfo = z2;
        this.hasAvailableCellInfo = z3;
    }

    public w5 a() {
        return this.network;
    }

    public String b() {
        return this.ownerKey;
    }

    public boolean c() {
        return this.hasAvailableCellInfo;
    }

    public boolean d() {
        return this.hasCellInfo;
    }

    public long e() {
        return this.deviceId;
    }

    public n5 f() {
        return this.activityTypeId;
    }

    public boolean g() {
        return this.hasLocation;
    }

    public Date h() {
        return this.measurementDate;
    }

    public String toString() {
        return "ReportMeasurementRequest{deviceId=" + this.deviceId + ", measurementDate=" + this.measurementDate + ", ownerKey='" + this.ownerKey + "', network=" + this.network + ", activityTypeId=" + this.activityTypeId + ", hasLocation=" + this.hasLocation + ", hasCellInfo=" + this.hasCellInfo + ", hasAvailableCellInfo=" + this.hasAvailableCellInfo + AbstractJsonLexerKt.END_OBJ;
    }
}

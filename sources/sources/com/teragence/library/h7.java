package com.teragence.library;

import java.util.Date;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class h7 implements o5 {
    private final Date date;
    private final u5 locationStatus;
    private final x5 networkStatus;

    public h7(u5 u5Var, x5 x5Var, Date date2) {
        this.locationStatus = u5Var;
        this.networkStatus = x5Var;
        this.date = date2;
    }

    public Date a() {
        return this.date;
    }

    public x5 d() {
        return this.networkStatus;
    }

    public u5 e() {
        return this.locationStatus;
    }

    public String toString() {
        return "Deadzone{locationStatus=" + this.locationStatus + ", networkStatus=" + this.networkStatus + ", date=" + this.date + AbstractJsonLexerKt.END_OBJ;
    }
}

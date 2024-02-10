package com.umlaut.crowd.internal;

import com.umlaut.crowd.internal.wb;
import java.text.ParseException;

public class g8 extends f8 {
    public g8() {
        super("EQ");
    }

    /* access modifiers changed from: protected */
    public boolean a(double d, double d2) {
        throw new IllegalArgumentException("EQ comparison for Double is not defined");
    }

    /* access modifiers changed from: protected */
    public boolean a(int i, int i2) {
        return i == i2;
    }

    /* access modifiers changed from: protected */
    public void b(wb wbVar) throws ParseException {
        if (wbVar.g() != wb.a.TOKEN_INTEGER) {
            throw new ParseException("Equal operation  is only defined for integers", wbVar.f());
        }
    }
}

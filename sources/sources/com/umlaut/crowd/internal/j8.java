package com.umlaut.crowd.internal;

import com.umlaut.crowd.internal.wb;
import java.text.ParseException;

public abstract class j8 extends e8 {
    private String c = "";

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[wb.a.values().length];
            a = iArr;
            try {
                iArr[wb.a.TOKEN_QUOTED_STRING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    protected j8(String str) {
        super(str);
    }

    /* access modifiers changed from: protected */
    public final void a(wb wbVar) throws ParseException {
        if (a.a[wbVar.g().ordinal()] == 1) {
            this.c = wbVar.h();
            b(wbVar);
            return;
        }
        throw new ParseException("Attributevalue has be be a quoted string, any special characters has to be escaped, was: \"" + wbVar.g() + "\"", wbVar.f());
    }

    /* access modifiers changed from: protected */
    public abstract boolean a(String str, String str2);

    /* access modifiers changed from: protected */
    public void b(wb wbVar) throws ParseException {
    }

    /* access modifiers changed from: protected */
    public boolean a(String str) {
        if (str == null) {
            return false;
        }
        return a(this.c, str);
    }
}

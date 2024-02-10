package com.umlaut.crowd.internal;

import com.umlaut.crowd.internal.wb;
import java.io.IOException;
import java.io.StringReader;
import java.text.ParseException;
import java.util.Map;
import java.util.Set;

public class u8 implements d8 {
    private d8 a(String str) throws ParseException, xb, IllegalAccessException {
        try {
            wb b = new yb(new StringReader(str)).b();
            if (b != null) {
                u6 a = a(b, this);
                if (a.a() != null && a.a().d() == null) {
                    return a.b();
                }
                throw new ParseException("Expected ruleend but got tokentype " + a.a().d().g(), a.a().d().f());
            }
            throw new ParseException("No rule defined", 0);
        } catch (IOException unused) {
            throw new ParseException("Unexpected IOException", 0);
        }
    }

    public static d8 b(String str) throws IllegalAccessException, ParseException, xb {
        return new u8().a(str);
    }

    public Set<String> a(Set<String> set) {
        return set;
    }

    public boolean a(Map<String, String> map) {
        return false;
    }

    public u6 a(wb wbVar, d8 d8Var) throws ParseException, IllegalAccessException {
        if (wbVar == null) {
            throw new ParseException("Expected Token of type String, but no token given", -1);
        } else if (wbVar.g() == wb.a.TOKEN_STRING) {
            t8 a = t8.a(wbVar.h());
            if (a != null) {
                try {
                    return ((d8) a.b.newInstance()).a(wbVar, this);
                } catch (InstantiationException e) {
                    throw new IllegalArgumentException("Cannot create Class for " + a, e);
                }
            } else {
                throw new ParseException("Cannot find condition \"" + wbVar.h() + "\"", wbVar.f());
            }
        } else {
            throw new ParseException("Expected Token of type String, got " + wbVar.g(), wbVar.f());
        }
    }
}

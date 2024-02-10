package com.umlaut.crowd.internal;

import com.umlaut.crowd.internal.wb;
import java.text.ParseException;
import java.util.Map;
import java.util.Set;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class q8 implements d8 {
    d8 a;

    public Set<String> a(Set<String> set) {
        d8 d8Var = this.a;
        if (d8Var == null) {
            throw new IllegalStateException("No rule was parsed yet!");
        } else if (set != null) {
            d8Var.a(set);
            return set;
        } else {
            throw new IllegalArgumentException("Attributes are not initialized");
        }
    }

    public boolean a(Map<String, String> map) {
        d8 d8Var = this.a;
        if (d8Var == null) {
            throw new IllegalStateException("No rule was parsed yet!");
        } else if (map != null) {
            return !d8Var.a(map);
        } else {
            throw new IllegalArgumentException("No parameters passed");
        }
    }

    public u6 a(wb wbVar, d8 d8Var) throws ParseException, IllegalAccessException {
        if (wbVar == null) {
            throw new IllegalArgumentException("given token is null!");
        } else if (d8Var == null) {
            throw new IllegalArgumentException("callback is not defined!");
        } else if (wbVar.g() != wb.a.TOKEN_STRING) {
            throw new ParseException("expected NOT from type TOKEN_STRING, but got: \"" + wbVar.h() + "\" of type \"" + wbVar.g() + "\"", wbVar.f());
        } else if (wbVar.h().equals("NOT")) {
            wb d = wbVar.d();
            Object obj = AbstractJsonLexerKt.NULL;
            if (d == null || d.g() != wb.a.TOKEN_BRACKET_OPEN) {
                StringBuilder sb = new StringBuilder("Expected open bracket, got : \"");
                sb.append(d != null ? d.h() : obj);
                sb.append("\" of tokentype \"");
                Object obj2 = obj;
                if (d != null) {
                    obj2 = d.g();
                }
                sb.append(obj2);
                sb.append("\"");
                throw new ParseException(sb.toString(), d != null ? d.f() : wbVar.f());
            }
            u6 a2 = d8Var.a(d.d(), d8Var);
            this.a = a2.b();
            wb d2 = a2.a().d();
            if (d2 != null && d2.g() == wb.a.TOKEN_BRACKET_CLOSE) {
                return new u6(this, d2);
            }
            StringBuilder sb2 = new StringBuilder("Expected closing bracket, got : \"");
            sb2.append(d2 != null ? d2.h() : obj);
            sb2.append("\" of tokentype \"");
            Object obj3 = obj;
            if (d2 != null) {
                obj3 = d2.g();
            }
            sb2.append(obj3);
            sb2.append("\"");
            throw new ParseException(sb2.toString(), d2 != null ? d2.f() : wbVar.f());
        } else {
            throw new ParseException("expected NOT: \"" + wbVar.h() + "\"", wbVar.f());
        }
    }
}

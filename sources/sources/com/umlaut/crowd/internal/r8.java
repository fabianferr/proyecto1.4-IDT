package com.umlaut.crowd.internal;

import com.umlaut.crowd.internal.wb;
import java.text.ParseException;
import java.util.Map;
import java.util.Set;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class r8 implements d8 {
    private String a;

    public Set<String> a(Set<String> set) {
        set.add(this.a);
        return set;
    }

    public boolean a(Map<String, String> map) {
        return !map.containsKey(this.a) || map.get(this.a) == null;
    }

    public u6 a(wb wbVar, d8 d8Var) throws ParseException, IllegalAccessException {
        if (wbVar != null) {
            wb.a g = wbVar.g();
            wb.a aVar = wb.a.TOKEN_STRING;
            if (g != aVar) {
                throw new ParseException("expected NOT from type TOKEN_STRING, but got: \"" + wbVar.h() + "\" of type \"" + wbVar.g() + "\"", wbVar.f());
            } else if (wbVar.h().equals("ISNULL")) {
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
                wb d2 = d.d();
                if (d2 == null || d2.g() != aVar) {
                    StringBuilder sb2 = new StringBuilder("Expected attribute identifier, got : \"");
                    sb2.append(d2 != null ? d2.h() : obj);
                    sb2.append("\" of tokentype \"");
                    Object obj3 = obj;
                    if (d2 != null) {
                        obj3 = d2.g();
                    }
                    sb2.append(obj3);
                    sb2.append("\"");
                    throw new ParseException(sb2.toString(), d2 != null ? d2.f() : wbVar.f());
                }
                this.a = d2.h();
                wb d3 = d2.d();
                if (d3 != null && d3.g() == wb.a.TOKEN_BRACKET_CLOSE) {
                    return new u6(this, d3);
                }
                StringBuilder sb3 = new StringBuilder("Expected closing bracket, got : \"");
                sb3.append(d3 != null ? d3.h() : obj);
                sb3.append("\" of tokentype \"");
                Object obj4 = obj;
                if (d3 != null) {
                    obj4 = d3.g();
                }
                sb3.append(obj4);
                sb3.append("\"");
                throw new ParseException(sb3.toString(), d3 != null ? d3.f() : wbVar.f());
            } else {
                throw new ParseException("expected ISNULL: \"" + wbVar.h() + "\"", wbVar.f());
            }
        } else {
            throw new IllegalArgumentException("given token is null!");
        }
    }
}

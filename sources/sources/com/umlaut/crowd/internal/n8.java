package com.umlaut.crowd.internal;

import com.umlaut.crowd.internal.wb;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Set;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public abstract class n8 implements d8 {
    d8[] a = null;
    String b;

    n8(String str) {
        this.b = str;
    }

    public Set<String> a(Set<String> set) {
        d8[] d8VarArr = this.a;
        if (d8VarArr == null) {
            throw new IllegalStateException("No rule was parsed yet!");
        } else if (set != null) {
            for (d8 a2 : d8VarArr) {
                a2.a(set);
            }
            return set;
        } else {
            throw new IllegalArgumentException("Attributes are not initialized");
        }
    }

    public u6 a(wb wbVar, d8 d8Var) throws ParseException, IllegalAccessException {
        wb d;
        if (wbVar == null) {
            throw new IllegalArgumentException("given token is null!");
        } else if (d8Var == null) {
            throw new IllegalArgumentException("given context is null!");
        } else if (wbVar.g() != wb.a.TOKEN_STRING) {
            throw new ParseException("Unknown connection: \"" + wbVar.h() + "\"", wbVar.f());
        } else if (wbVar.h().equals(this.b)) {
            wb d2 = wbVar.d();
            Object obj = AbstractJsonLexerKt.NULL;
            if (d2 == null || d2.g() != wb.a.TOKEN_BRACKET_OPEN) {
                StringBuilder sb = new StringBuilder("Expected open bracket, got : \"");
                sb.append(d2 != null ? d2.h() : obj);
                sb.append("\" of tokentype \"");
                Object obj2 = obj;
                if (d2 != null) {
                    obj2 = d2.g();
                }
                sb.append(obj2);
                sb.append("\"");
                throw new ParseException(sb.toString(), d2 != null ? d2.f() : wbVar.f());
            }
            wb d3 = d2.d();
            if (d3 == null || d3.g() != wb.a.TOKEN_SQUAREBRACKET_OPEN) {
                StringBuilder sb2 = new StringBuilder("Expected open quarebracket, got : \"");
                sb2.append(d3 != null ? d3.h() : obj);
                sb2.append("\" of tokentype \"");
                Object obj3 = obj;
                if (d3 != null) {
                    obj3 = d3.g();
                }
                sb2.append(obj3);
                sb2.append("\"");
                throw new ParseException(sb2.toString(), d3 != null ? d3.f() : wbVar.f());
            }
            ArrayList arrayList = new ArrayList(10);
            while (true) {
                wb d4 = d3.d();
                if (d4 != null) {
                    u6 a2 = d8Var.a(d4, d8Var);
                    d = a2.a().d();
                    arrayList.add(a2.b());
                    if (d == null || !(d.g() == wb.a.TOKEN_COMMA || d.g() == wb.a.TOKEN_SQUAREBRACKET_CLOSE)) {
                        StringBuilder sb3 = new StringBuilder("Expected comma or closing squarebracket , got : \"");
                    } else if (d.g() == wb.a.TOKEN_SQUAREBRACKET_CLOSE) {
                        wb d5 = d.d();
                        if (d5 == null || d5.g() != wb.a.TOKEN_BRACKET_CLOSE) {
                            StringBuilder sb4 = new StringBuilder("Expected closing bracket, got : \"");
                            sb4.append(d5 != null ? d5.h() : obj);
                            sb4.append("\" of tokentype \"");
                            Object obj4 = obj;
                            if (d5 != null) {
                                obj4 = d5.g();
                            }
                            sb4.append(obj4);
                            sb4.append("\"");
                            throw new ParseException(sb4.toString(), d5 != null ? d5.f() : wbVar.f());
                        }
                        d8[] d8VarArr = new d8[arrayList.size()];
                        this.a = d8VarArr;
                        arrayList.toArray(d8VarArr);
                        return new u6(this, d5);
                    } else {
                        d3 = d;
                    }
                } else {
                    throw new ParseException("expected Inner Rule, but got eol", d3.b() + 1);
                }
            }
            StringBuilder sb32 = new StringBuilder("Expected comma or closing squarebracket , got : \"");
            sb32.append(d != null ? d.h() : obj);
            sb32.append("\" of tokentype \"");
            Object obj5 = obj;
            if (d != null) {
                obj5 = d.g();
            }
            sb32.append(obj5);
            sb32.append("\"");
            throw new ParseException(sb32.toString(), d != null ? d.f() : wbVar.f());
        } else {
            throw new ParseException("Unknown connection: \"" + wbVar.h() + "\"", wbVar.f());
        }
    }
}

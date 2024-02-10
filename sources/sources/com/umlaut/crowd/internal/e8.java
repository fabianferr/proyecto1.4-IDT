package com.umlaut.crowd.internal;

import com.umlaut.crowd.internal.wb;
import java.text.ParseException;
import java.util.Map;
import java.util.Set;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public abstract class e8 implements d8 {
    protected String a = null;
    String b;

    protected e8(String str) {
        this.b = str;
    }

    public u6 a(wb wbVar, d8 d8Var) throws ParseException {
        if (wbVar != null) {
            wb.a g = wbVar.g();
            wb.a aVar = wb.a.TOKEN_STRING;
            if (g != aVar) {
                throw new ParseException("Operatortypes has to be type of String but was: \"" + wbVar.g() + "\" with value \"" + wbVar.h() + "\"", wbVar.f());
            } else if (wbVar.h().equals(this.b)) {
                wb d = wbVar.d();
                if (d != null && d.g() == wb.a.TOKEN_BRACKET_OPEN) {
                    wb d2 = d.d();
                    Object obj = AbstractJsonLexerKt.NULL;
                    if (d2 == null || d2.g() != aVar) {
                        StringBuilder sb = new StringBuilder("Expected attributename of type STRING, got : \"");
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
                    this.a = d2.h();
                    wb d3 = d2.d();
                    if (d3 == null || d3.g() != wb.a.TOKEN_COMMA) {
                        StringBuilder sb2 = new StringBuilder("Expected comma , got : \"");
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
                    wb d4 = d3.d();
                    if (d4 != null) {
                        a(d4);
                        wb d5 = d4.d();
                        if (d5 != null && d5.g() == wb.a.TOKEN_BRACKET_CLOSE) {
                            return new u6(this, d5);
                        }
                        StringBuilder sb3 = new StringBuilder("Expected close bracket, got : \"");
                        sb3.append(d5 != null ? d5.h() : obj);
                        sb3.append("\" of tokentype \"");
                        Object obj4 = obj;
                        if (d5 != null) {
                            obj4 = d5.g();
                        }
                        sb3.append(obj4);
                        sb3.append("\"");
                        throw new ParseException(sb3.toString(), d5 != null ? d5.f() : wbVar.f());
                    }
                    throw new ParseException("Expected attributvalue , got : \"null\" of tokentype \"null\"", wbVar.f());
                } else if (d == null) {
                    throw new ParseException("Expected open bracket, got : \"null\" of tokentype \"null\"", wbVar.f());
                } else {
                    throw new ParseException("Expected open bracket, got : \"" + d.h() + "\" of tokentype \"" + d.g() + "\"", d.f());
                }
            } else {
                throw new ParseException("Unknown operator: \"" + wbVar.h() + "\"", wbVar.f());
            }
        } else {
            throw new IllegalArgumentException("given token is null!");
        }
    }

    /* access modifiers changed from: protected */
    public abstract void a(wb wbVar) throws ParseException;

    /* access modifiers changed from: protected */
    public abstract boolean a(String str);

    public Set<String> a(Set<String> set) {
        if (set != null) {
            String str = this.a;
            if (str != null) {
                set.add(str);
                return set;
            }
            throw new IllegalStateException("No rule parsed yet");
        }
        throw new IllegalArgumentException("attributes not set");
    }

    public boolean a(Map<String, String> map) {
        if (map != null) {
            String str = this.a;
            if (str == null) {
                throw new IllegalStateException("No rule parsed yet");
            } else if (!map.containsKey(str)) {
                return false;
            } else {
                return a(map.get(this.a));
            }
        } else {
            throw new IllegalArgumentException("No params passed");
        }
    }
}

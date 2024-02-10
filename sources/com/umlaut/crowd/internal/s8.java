package com.umlaut.crowd.internal;

import com.umlaut.crowd.internal.wb;
import java.text.ParseException;
import java.util.Map;
import java.util.Set;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class s8 implements d8 {
    static final String c = "PIR";
    private static final int d = 2;
    private static final int e = 4;
    private static final String f = "Provided coordinates doesn't satisfy the latitude constraints (-90 to +90).";
    private static final String g = "Provided coordinates doesn't satisfy the longitude constraints (-180 to +180).";
    private String[] a = new String[2];
    private wb[] b = new wb[4];

    class a {
        double a;
        double b;

        public a() {
        }

        public double a() {
            return this.a;
        }

        public double b() {
            return this.b;
        }

        public a(double d, double d2) {
            this.a = d;
            this.b = d2;
        }

        public void a(double d) {
            this.a = d;
        }

        public void b(double d) {
            this.b = d;
        }
    }

    private enum b {
        LATITUDE,
        LONGITUDE
    }

    class c {
        a a;
        a b;

        public c() {
        }

        public a b() {
            return this.a;
        }

        public c(a aVar, a aVar2) {
            this.a = aVar;
            this.b = aVar2;
        }

        public a a() {
            return this.b;
        }

        public void b(a aVar) {
            this.a = aVar;
        }

        public void a(a aVar) {
            this.b = aVar;
        }

        /* access modifiers changed from: private */
        public boolean a(double d, double d2) {
            a aVar = this.a;
            if (aVar.a < d) {
                return false;
            }
            a aVar2 = this.b;
            if (d < aVar2.a) {
                return false;
            }
            double d3 = aVar.b;
            double d4 = aVar2.b;
            return d3 <= d4 && d3 <= d2 && d2 <= d4;
        }
    }

    public u6 a(wb wbVar, d8 d8Var) throws ParseException {
        wb.a aVar;
        wb.a aVar2;
        if (wbVar != null) {
            wb.a g2 = wbVar.g();
            wb.a aVar3 = wb.a.TOKEN_STRING;
            if (g2 != aVar3) {
                throw new ParseException("Operatortypes has to be type of String but was: \"" + wbVar.g() + "\" with value \"" + wbVar.h() + "\"", wbVar.f());
            } else if (wbVar.h().equals(c)) {
                wb d2 = wbVar.d();
                if (d2 != null && d2.g() == wb.a.TOKEN_BRACKET_OPEN) {
                    wb d3 = d2.d();
                    Object obj = AbstractJsonLexerKt.NULL;
                    if (d3 == null || d3.g() != aVar3) {
                        StringBuilder sb = new StringBuilder("Expected attributename of type STRING, got : \"");
                        sb.append(d3 != null ? d3.h() : obj);
                        sb.append("\" of tokentype \"");
                        Object obj2 = obj;
                        if (d3 != null) {
                            obj2 = d3.g();
                        }
                        sb.append(obj2);
                        sb.append("\"");
                        throw new ParseException(sb.toString(), d3 != null ? d3.f() : wbVar.f());
                    }
                    this.a[0] = d3.h();
                    wb d4 = d3.d();
                    if (d4 == null || d4.g() != (aVar = wb.a.TOKEN_COMMA)) {
                        StringBuilder sb2 = new StringBuilder("Expected comma , got : \"");
                        sb2.append(d4 != null ? d4.h() : obj);
                        sb2.append("\" of tokentype \"");
                        Object obj3 = obj;
                        if (d4 != null) {
                            obj3 = d4.g();
                        }
                        sb2.append(obj3);
                        sb2.append("\"");
                        throw new ParseException(sb2.toString(), d4 != null ? d4.f() : wbVar.f());
                    }
                    wb d5 = d4.d();
                    if (d5 == null || d5.g() != aVar3) {
                        StringBuilder sb3 = new StringBuilder("Expected attributename of type STRING, got : \"");
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
                    this.a[1] = d5.h();
                    wb d6 = d5.d();
                    if (d6 == null || d6.g() != aVar) {
                        StringBuilder sb4 = new StringBuilder("Expected comma , got : \"");
                        sb4.append(d6 != null ? d6.h() : obj);
                        sb4.append("\" of tokentype \"");
                        Object obj5 = obj;
                        if (d6 != null) {
                            obj5 = d6.g();
                        }
                        sb4.append(obj5);
                        sb4.append("\"");
                        throw new ParseException(sb4.toString(), d6 != null ? d6.f() : wbVar.f());
                    }
                    wb d7 = d6.d();
                    if (d7 == null || d7.g() != (aVar2 = wb.a.TOKEN_NUMBER)) {
                        StringBuilder sb5 = new StringBuilder("Expected attributename of type NUMBER, got : \"");
                        sb5.append(d7 != null ? d7.h() : obj);
                        sb5.append("\" of tokentype \"");
                        Object obj6 = obj;
                        if (d7 != null) {
                            obj6 = d7.g();
                        }
                        sb5.append(obj6);
                        sb5.append("\"");
                        throw new ParseException(sb5.toString(), d7 != null ? d7.f() : wbVar.f());
                    }
                    this.b[0] = d7;
                    wb d8 = d7.d();
                    if (d8 == null || d8.g() != aVar) {
                        StringBuilder sb6 = new StringBuilder("Expected comma , got : \"");
                        sb6.append(d8 != null ? d8.h() : obj);
                        sb6.append("\" of tokentype \"");
                        Object obj7 = obj;
                        if (d8 != null) {
                            obj7 = d8.g();
                        }
                        sb6.append(obj7);
                        sb6.append("\"");
                        throw new ParseException(sb6.toString(), d8 != null ? d8.f() : wbVar.f());
                    }
                    wb d9 = d8.d();
                    if (d9 == null || d9.g() != aVar2) {
                        StringBuilder sb7 = new StringBuilder("Expected attributename of type NUMBER, got : \"");
                        sb7.append(d9 != null ? d9.h() : obj);
                        sb7.append("\" of tokentype \"");
                        Object obj8 = obj;
                        if (d9 != null) {
                            obj8 = d9.g();
                        }
                        sb7.append(obj8);
                        sb7.append("\"");
                        throw new ParseException(sb7.toString(), d9 != null ? d9.f() : wbVar.f());
                    }
                    this.b[1] = d9;
                    wb d10 = d9.d();
                    if (d10 == null || d10.g() != aVar) {
                        StringBuilder sb8 = new StringBuilder("Expected comma , got : \"");
                        sb8.append(d10 != null ? d10.h() : obj);
                        sb8.append("\" of tokentype \"");
                        Object obj9 = obj;
                        if (d10 != null) {
                            obj9 = d10.g();
                        }
                        sb8.append(obj9);
                        sb8.append("\"");
                        throw new ParseException(sb8.toString(), d10 != null ? d10.f() : wbVar.f());
                    }
                    wb d11 = d10.d();
                    if (d11 == null || d11.g() != aVar2) {
                        StringBuilder sb9 = new StringBuilder("Expected attributename of type NUMBER, got : \"");
                        sb9.append(d11 != null ? d11.h() : obj);
                        sb9.append("\" of tokentype \"");
                        Object obj10 = obj;
                        if (d11 != null) {
                            obj10 = d11.g();
                        }
                        sb9.append(obj10);
                        sb9.append("\"");
                        throw new ParseException(sb9.toString(), d11 != null ? d11.f() : wbVar.f());
                    }
                    this.b[2] = d11;
                    wb d12 = d11.d();
                    if (d12 == null || d12.g() != aVar) {
                        StringBuilder sb10 = new StringBuilder("Expected comma , got : \"");
                        sb10.append(d12 != null ? d12.h() : obj);
                        sb10.append("\" of tokentype \"");
                        Object obj11 = obj;
                        if (d12 != null) {
                            obj11 = d12.g();
                        }
                        sb10.append(obj11);
                        sb10.append("\"");
                        throw new ParseException(sb10.toString(), d12 != null ? d12.f() : wbVar.f());
                    }
                    wb d13 = d12.d();
                    if (d13 == null || d13.g() != aVar2) {
                        StringBuilder sb11 = new StringBuilder("Expected attributename of type NUMBER, got : \"");
                        sb11.append(d13 != null ? d13.h() : obj);
                        sb11.append("\" of tokentype \"");
                        Object obj12 = obj;
                        if (d13 != null) {
                            obj12 = d13.g();
                        }
                        sb11.append(obj12);
                        sb11.append("\"");
                        throw new ParseException(sb11.toString(), d13 != null ? d13.f() : wbVar.f());
                    }
                    this.b[3] = d13;
                    wb d14 = d13.d();
                    if (d14 == null || d14.g() != wb.a.TOKEN_BRACKET_CLOSE) {
                        StringBuilder sb12 = new StringBuilder("Expected close bracket, got : \"");
                        sb12.append(d14 != null ? d14.h() : obj);
                        sb12.append("\" of tokentype \"");
                        Object obj13 = obj;
                        if (d14 != null) {
                            obj13 = d14.g();
                        }
                        sb12.append(obj13);
                        sb12.append("\"");
                        throw new ParseException(sb12.toString(), d14 != null ? d14.f() : wbVar.f());
                    }
                    a(this.b);
                    return new u6(this, d14);
                } else if (d2 == null) {
                    throw new ParseException("Expected open bracket, got : \"null\" of tokentype \"null\"", wbVar.f());
                } else {
                    throw new ParseException("Expected open bracket, got : \"" + d2.h() + "\" of tokentype \"" + d2.g() + "\"", d2.f());
                }
            } else {
                throw new ParseException("Unknown operator: \"" + wbVar.h() + "\"", wbVar.f());
            }
        } else {
            throw new IllegalArgumentException("given token is null!");
        }
    }

    public Set<String> a(Set<String> set) {
        if (set != null) {
            String[] strArr = this.a;
            if (strArr != null) {
                for (String add : strArr) {
                    set.add(add);
                }
                return set;
            }
            throw new IllegalStateException("No rule parsed yet");
        }
        throw new IllegalArgumentException("attributes not set");
    }

    private boolean a(double d2, b bVar) {
        return bVar == b.LATITUDE ? d2 <= 90.0d && d2 >= -90.0d : d2 <= 180.0d && d2 >= -180.0d;
    }

    public void a(wb[] wbVarArr) throws ParseException {
        wb.a g2 = wbVarArr[0].g();
        wb.a aVar = wb.a.TOKEN_NUMBER;
        if (g2 == aVar) {
            double a2 = wbVarArr[0].a();
            b bVar = b.LATITUDE;
            if (a(a2, bVar)) {
                if (wbVarArr[1].g() == aVar) {
                    double a3 = wbVarArr[1].a();
                    b bVar2 = b.LONGITUDE;
                    if (a(a3, bVar2)) {
                        if (wbVarArr[2].g() != aVar || !a(wbVarArr[2].a(), bVar)) {
                            throw new ParseException(f, wbVarArr[0].f());
                        } else if (wbVarArr[3].g() != aVar || !a(wbVarArr[3].a(), bVar2)) {
                            throw new ParseException(g, wbVarArr[0].f());
                        } else {
                            return;
                        }
                    }
                }
                throw new ParseException(g, wbVarArr[0].f());
            }
        }
        throw new ParseException(f, wbVarArr[0].f());
    }

    public boolean a(Map<String, String> map) {
        if (map == null) {
            throw new IllegalArgumentException("No params passed");
        } else if (this.a != null) {
            c cVar = new c(new a(this.b[0].a(), this.b[1].a()), new a(this.b[2].a(), this.b[3].a()));
            if (!map.containsKey(this.a[0]) || !map.containsKey(this.a[1])) {
                return false;
            }
            return cVar.a(Double.parseDouble(map.get(this.a[0])), Double.parseDouble(map.get(this.a[1])));
        } else {
            throw new IllegalStateException("No rule parsed yet");
        }
    }
}

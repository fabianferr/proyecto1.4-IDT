package com.teragence.library;

import java.util.Arrays;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class s7 implements c6 {
    private final o5[] a;
    private final String b;
    private final q5 c;
    private final f6 d;

    public s7(o5[] o5VarArr, String str, q5 q5Var, f6 f6Var) {
        this.a = o5VarArr;
        this.b = str;
        this.c = q5Var;
        this.d = f6Var;
    }

    public f6 a() {
        return this.d;
    }

    public String b() {
        return this.b;
    }

    public o5[] c() {
        return this.a;
    }

    public q5 f() {
        return this.c;
    }

    public String toString() {
        return "ReportDeadzonesRequest{deadzones=" + Arrays.toString(this.a) + ", ownerKey='" + this.b + "', deviceInfo=" + this.c + ", simOperatorInfo=" + this.d + AbstractJsonLexerKt.END_OBJ;
    }
}

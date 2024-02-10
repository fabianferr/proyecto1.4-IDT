package com.m2catalyst.m2sdk;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* compiled from: M2InternalConfiguration.kt */
public final class s2 extends Lambda implements Function0<String> {
    public final /* synthetic */ r2 a;
    public final /* synthetic */ a6 b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public s2(r2 r2Var, a6 a6Var) {
        super(0);
        this.a = r2Var;
        this.b = a6Var;
    }

    public final Object invoke() {
        z5 a2 = this.a.a();
        a6 a6Var = this.b;
        Object obj = a6Var.b;
        String str = a6Var.a;
        if (a2.a.getAll().containsKey(str)) {
            obj = a2.a.getAll().get(str);
        }
        String str2 = (String) obj;
        return str2 == null ? "" : str2;
    }
}

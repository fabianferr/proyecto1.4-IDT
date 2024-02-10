package com.teragence.library;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.math.BigDecimal;

public class j8 implements i8 {
    public Object a(x8 x8Var, String str, String str2, k8 k8Var) {
        String d = x8Var.d();
        if (str2.equals(TypedValues.Custom.S_FLOAT)) {
            return new Float(d);
        }
        if (str2.equals("double")) {
            return new Double(d);
        }
        if (str2.equals("decimal")) {
            return new BigDecimal(d);
        }
        throw new RuntimeException("float, double, or decimal expected");
    }

    public void a(n8 n8Var) {
        n8Var.a(n8Var.i, TypedValues.Custom.S_FLOAT, Float.class, (i8) this);
        n8Var.a(n8Var.i, "double", Double.class, (i8) this);
        n8Var.a(n8Var.i, "decimal", BigDecimal.class, (i8) this);
    }

    public void a(z8 z8Var, Object obj) {
        z8Var.b(obj.toString());
    }
}

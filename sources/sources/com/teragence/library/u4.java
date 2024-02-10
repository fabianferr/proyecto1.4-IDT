package com.teragence.library;

import com.teragence.client.i;
import com.teragence.library.s4;

public class u4 implements s4 {
    private final s4 a;

    public u4(s4 s4Var) {
        this.a = s4Var;
    }

    public void a(s4.a aVar) {
        try {
            this.a.a(aVar);
        } catch (Exception e) {
            i.b("SafeReportLogErrorUseCase", e.getMessage());
        }
    }
}

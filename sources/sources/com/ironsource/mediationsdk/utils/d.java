package com.ironsource.mediationsdk.utils;

import java.util.Date;

public final class d {
    private long a = new Date().getTime();

    public static long a(d dVar) {
        if (dVar == null) {
            return 0;
        }
        return new Date().getTime() - dVar.a;
    }
}

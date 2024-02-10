package com.squareup.wire.internal;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u0005\n\u0002\b\u0003\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\f\u001a\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\f¨\u0006\u0005"}, d2 = {"and", "", "", "other", "shl", "wire-runtime"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Util.kt */
public final class RuntimeUtils {
    public static final int and(byte b, int i) {
        return b & i;
    }

    public static final int shl(byte b, int i) {
        return b << i;
    }
}

package com.mbridge.msdk.foundation.same.net.e;

import com.mbridge.msdk.foundation.same.net.j;
import com.mbridge.msdk.foundation.tools.aa;
import java.io.UnsupportedEncodingException;

/* compiled from: JsonRequest */
public abstract class e<T> extends j<T> {
    private static final String c = "e";
    private final String d;

    public e(int i, String str, String str2, com.mbridge.msdk.foundation.same.net.e<T> eVar) {
        super(i, str, eVar);
        this.d = str2;
    }

    public e(int i, String str, String str2, com.mbridge.msdk.foundation.same.net.e<T> eVar, boolean z) {
        super(i, str, eVar, z);
        this.d = str2;
    }

    public final byte[] f() {
        try {
            String str = this.d;
            if (str == null) {
                return null;
            }
            return str.getBytes("utf-8");
        } catch (UnsupportedEncodingException unused) {
            String str2 = c;
            aa.d(str2, "Unsupported Encoding while trying to get the bytes of " + this.d + " using utf-8");
            return null;
        }
    }
}

package com.teragence.library;

import android.content.Context;
import com.teragence.client.g;
import java.net.InetAddress;

public class i1 implements j1 {
    private final Context a;

    public i1(Context context) {
        this.a = context;
    }

    public g a(InetAddress inetAddress, boolean z) {
        g a2 = v0.a(this.a, inetAddress, z);
        if (a2 != null) {
            return a2;
        }
        throw new l("No network available");
    }
}

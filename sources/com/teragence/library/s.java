package com.teragence.library;

import android.content.Context;
import java.io.InputStream;
import java.io.OutputStream;

public class s implements t {
    private final Context a;
    private final int b;
    private final String c;

    public s(Context context, int i, String str) {
        this.a = context;
        this.b = i;
        this.c = str;
    }

    public InputStream a() {
        return this.a.openFileInput(this.c);
    }

    public OutputStream b() {
        return this.a.openFileOutput(this.c, this.b);
    }
}

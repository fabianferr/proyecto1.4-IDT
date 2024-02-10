package com.teragence.library;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Proxy;
import java.util.HashMap;

public abstract class s8 {
    protected Proxy a;
    protected String b;
    protected int c = 20000;
    public boolean d;
    private String e = "";
    private int f = 262144;
    private HashMap g = new HashMap();

    public s8(String str, int i) {
        this.b = str;
        this.c = i;
    }

    /* access modifiers changed from: protected */
    public void a(y7 y7Var, InputStream inputStream) {
        t8 t8Var = new t8();
        t8Var.a("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
        t8Var.a(inputStream, (String) null);
        y7Var.a((x8) t8Var);
        inputStream.close();
    }

    /* access modifiers changed from: protected */
    public byte[] a(y7 y7Var, String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(this.f);
        byteArrayOutputStream.write(this.e.getBytes());
        u8 u8Var = new u8();
        u8Var.a((OutputStream) byteArrayOutputStream, str);
        for (String str2 : this.g.keySet()) {
            u8Var.a(str2, (String) this.g.get(str2));
        }
        y7Var.a((z8) u8Var);
        u8Var.a();
        byteArrayOutputStream.write(13);
        byteArrayOutputStream.write(10);
        byteArrayOutputStream.flush();
        return byteArrayOutputStream.toByteArray();
    }
}

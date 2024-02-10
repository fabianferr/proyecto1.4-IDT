package com.startapp;

import java.io.ByteArrayOutputStream;
import java.util.zip.GZIPOutputStream;

/* compiled from: Sta */
public class j2 implements p8 {
    public final n8 a;

    public j2(n8 n8Var) {
        this.a = n8Var;
    }

    public String a(String str) {
        GZIPOutputStream gZIPOutputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(byteArrayOutputStream);
            try {
                gZIPOutputStream2.write(str.getBytes());
                e3.a(gZIPOutputStream2);
                String a2 = this.a.a(q0.b(byteArrayOutputStream.toByteArray()));
                e3.a(gZIPOutputStream2);
                return a2;
            } catch (Exception unused) {
                gZIPOutputStream = gZIPOutputStream2;
                e3.a(gZIPOutputStream);
                return "";
            } catch (Throwable th) {
                e3.a(gZIPOutputStream2);
                throw th;
            }
        } catch (Exception unused2) {
            e3.a(gZIPOutputStream);
            return "";
        }
    }
}

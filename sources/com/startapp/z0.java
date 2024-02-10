package com.startapp;

import android.content.Context;
import android.graphics.Bitmap;
import java.io.Closeable;
import java.io.FileOutputStream;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Sta */
public class z0 implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Bitmap c;
    public final /* synthetic */ Context d;

    public z0(String str, String str2, Bitmap bitmap, Context context) {
        this.a = str;
        this.b = str2;
        this.c = bitmap;
        this.d = context;
    }

    public void run() {
        FileOutputStream fileOutputStream;
        Throwable th;
        ((ConcurrentHashMap) a1.a).put(this.a + this.b, this.c);
        try {
            fileOutputStream = new FileOutputStream(this.d.getFilesDir().getPath() + "/" + this.a + this.b);
            try {
                this.c.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                k9.a((Closeable) fileOutputStream);
            } catch (Throwable th2) {
                th = th2;
                try {
                    i3.a(th);
                } finally {
                    k9.a((Closeable) fileOutputStream);
                }
            }
        } catch (Throwable th3) {
            Throwable th4 = th3;
            fileOutputStream = null;
            th = th4;
            i3.a(th);
        }
    }
}

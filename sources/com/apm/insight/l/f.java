package com.apm.insight.l;

import com.apm.insight.i;
import com.apm.insight.nativecrash.NativeImpl;
import com.apm.insight.runtime.a;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class f {
    public static File a(String str, int i, int i2) {
        File file = new File(o.a(i.g(), str), "logcat.txt");
        if (file.exists() && file.length() > 0) {
            return file;
        }
        file.getParentFile().mkdirs();
        try {
            file.createNewFile();
        } catch (IOException unused) {
        }
        NativeImpl.a(file.getAbsolutePath(), String.valueOf(i), String.valueOf(i2));
        return file;
    }

    public static void a() {
        try {
            a(i.f(), i.i().getLogcatDumpCount(), i.i().getLogcatLevel());
            if (i.u()) {
                b();
                d();
                c();
                e();
            }
        } catch (Throwable unused) {
        }
    }

    public static File b() {
        File file = new File(o.e(i.g()), "maps.txt");
        if (file.exists()) {
            return file;
        }
        file.getParentFile().mkdirs();
        try {
            file.createNewFile();
        } catch (IOException unused) {
        }
        NativeImpl.f(file.getAbsolutePath());
        return file;
    }

    public static File c() {
        File file = new File(o.e(i.g()), "meminfo.txt");
        if (file.exists()) {
            return file;
        }
        file.getParentFile().mkdirs();
        try {
            file.createNewFile();
        } catch (IOException unused) {
        }
        NativeImpl.d(file.getAbsolutePath());
        return file;
    }

    public static File d() {
        File file = new File(o.e(i.g()), "fds.txt");
        if (file.exists()) {
            return file;
        }
        file.getParentFile().mkdirs();
        try {
            file.createNewFile();
        } catch (IOException unused) {
        }
        NativeImpl.e(file.getAbsolutePath());
        return file;
    }

    public static File e() {
        File file = new File(o.e(i.g()), "threads.txt");
        if (file.exists()) {
            return file;
        }
        file.getParentFile().mkdirs();
        try {
            file.createNewFile();
        } catch (IOException unused) {
        }
        NativeImpl.g(file.getAbsolutePath());
        return file;
    }

    public static File f() {
        BufferedWriter bufferedWriter;
        File file = new File(o.e(i.g()), "anr_trace.txt");
        if (file.exists() || !a.f()) {
            return file;
        }
        File file2 = new File("/data/anr/traces.txt");
        if (!file2.exists()) {
            return file;
        }
        BufferedReader bufferedReader = null;
        try {
            file.getParentFile().mkdirs();
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file2));
            try {
                bufferedWriter = new BufferedWriter(new FileWriter(file));
                int i = 0;
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine != null) {
                            bufferedWriter.write(readLine);
                            bufferedWriter.write(10);
                            i += readLine.length();
                            if (i >= 1048576) {
                                break;
                            }
                        } else {
                            break;
                        }
                    } catch (IOException unused) {
                        bufferedReader = bufferedReader2;
                        k.a((Closeable) bufferedReader);
                        k.a((Closeable) bufferedWriter);
                        return file;
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        k.a((Closeable) bufferedReader);
                        k.a((Closeable) bufferedWriter);
                        throw th;
                    }
                }
                k.a((Closeable) bufferedReader2);
            } catch (IOException unused2) {
                bufferedWriter = null;
                bufferedReader = bufferedReader2;
                k.a((Closeable) bufferedReader);
                k.a((Closeable) bufferedWriter);
                return file;
            } catch (Throwable th2) {
                th = th2;
                bufferedWriter = null;
                bufferedReader = bufferedReader2;
                k.a((Closeable) bufferedReader);
                k.a((Closeable) bufferedWriter);
                throw th;
            }
        } catch (IOException unused3) {
            bufferedWriter = null;
            k.a((Closeable) bufferedReader);
            k.a((Closeable) bufferedWriter);
            return file;
        } catch (Throwable th3) {
            th = th3;
            bufferedWriter = null;
            k.a((Closeable) bufferedReader);
            k.a((Closeable) bufferedWriter);
            throw th;
        }
        k.a((Closeable) bufferedWriter);
        return file;
    }
}

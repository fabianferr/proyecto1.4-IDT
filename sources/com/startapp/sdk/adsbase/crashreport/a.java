package com.startapp.sdk.adsbase.crashreport;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Base64OutputStream;
import com.startapp.f2;
import com.startapp.i3;
import com.startapp.j3;
import com.startapp.k9;
import com.startapp.sdk.adsbase.crashreport.ThreadsState;
import com.startapp.sdk.adsbase.crashreport.b;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Map;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: Sta */
public class a implements b.d {
    public final Context a;
    public final boolean b;
    public final boolean c;
    public final boolean d;

    public a(Context context, String str, boolean z, boolean z2, boolean z3) {
        this.a = context;
        this.b = z;
        this.c = z2;
        this.d = z3;
    }

    public boolean a(long j, String str) {
        HashSet hashSet;
        ThreadsState.b bVar = new ThreadsState.b();
        bVar.a = "com.startapp.";
        bVar.e = this.b;
        bVar.f = this.c;
        bVar.d = j;
        bVar.b = str;
        if (this.d) {
            hashSet = new HashSet();
            hashSet.add("android.webkit.WebView.loadDataWithBaseURL");
            hashSet.add("android.webkit.WebView.<init>");
            hashSet.add("android.webkit.WebView.stopLoading");
            hashSet.add("android.webkit.WebView.loadUrl");
            hashSet.add("libcore.icu.LocaleData.initLocaleData");
            hashSet.add("android.os.BinderProxy.transact");
            hashSet.add("android.hardware.SystemSensorManager.registerListenerImpl");
            hashSet.add("android.hardware.SystemSensorManager.<init>");
            hashSet.add("java.lang.Thread.<init>");
            hashSet.add("android.content.ContextWrapper.checkSelfPermission");
        } else {
            hashSet = null;
        }
        bVar.c = hashSet;
        ThreadsState threadsState = new ThreadsState(bVar);
        if (threadsState.d() == null) {
            return false;
        }
        f2.a(this.a, "StartappAnrTrace", (Serializable) threadsState);
        return true;
    }

    public void remove() {
        if (new File(f2.c(this.a, "StartappAnrTrace")).exists()) {
            f2.a(this.a, "StartappAnrTrace");
        }
    }

    public void a() {
        ThreadsState threadsState;
        ThreadsState.ShrunkStackTraceElement[] shrunkStackTraceElementArr;
        if (new File(f2.c(this.a, "StartappAnrTrace")).exists() && (threadsState = (ThreadsState) f2.a(this.a, "StartappAnrTrace", ThreadsState.class)) != null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            Map<Activity, Integer> map = k9.a;
            PrintWriter printWriter = new PrintWriter(new DeflaterOutputStream(new Base64OutputStream(byteArrayOutputStream, 10), new Deflater(9, true)));
            printWriter.print("\"delay: ");
            printWriter.print(threadsState.b());
            printWriter.println('\"');
            if (!TextUtils.isEmpty(threadsState.c())) {
                printWriter.print("\"handler: ");
                printWriter.print(threadsState.c());
                printWriter.println('\"');
            }
            Map<String, ThreadsState.ShrunkStackTraceElement[]> d2 = threadsState.d();
            int i = 0;
            StackTraceElement stackTraceElement = null;
            if (d2 == null) {
                shrunkStackTraceElementArr = null;
            } else {
                shrunkStackTraceElementArr = null;
                for (Map.Entry next : d2.entrySet()) {
                    if (shrunkStackTraceElementArr == null) {
                        shrunkStackTraceElementArr = (ThreadsState.ShrunkStackTraceElement[]) next.getValue();
                    }
                    ThreadsState.ShrunkStackTraceElement[] shrunkStackTraceElementArr2 = (ThreadsState.ShrunkStackTraceElement[]) next.getValue();
                    printWriter.print('\"');
                    printWriter.print((String) next.getKey());
                    printWriter.println('\"');
                    for (ThreadsState.ShrunkStackTraceElement shrunkStackTraceElement : shrunkStackTraceElementArr2) {
                        if (shrunkStackTraceElement.a() != 0) {
                            printWriter.print(9);
                            printWriter.println(shrunkStackTraceElement.a());
                        }
                        StackTraceElement b2 = shrunkStackTraceElement.b();
                        if (b2 != null) {
                            printWriter.print(9);
                            printWriter.print("at ");
                            printWriter.print(b2.getClassName());
                            printWriter.print('.');
                            printWriter.print(b2.getMethodName());
                            printWriter.print('(');
                            printWriter.print(b2.getFileName());
                            printWriter.print(AbstractJsonLexerKt.COLON);
                            printWriter.print(b2.getLineNumber());
                            printWriter.println(')');
                        }
                    }
                }
            }
            printWriter.close();
            if (shrunkStackTraceElementArr != null) {
                int length = shrunkStackTraceElementArr.length;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    StackTraceElement b3 = shrunkStackTraceElementArr[i].b();
                    if (b3 != null && b3.getClassName().startsWith("com.startapp.")) {
                        stackTraceElement = b3;
                        break;
                    }
                    i++;
                }
                if (stackTraceElement != null) {
                    String byteArrayOutputStream2 = byteArrayOutputStream.toString();
                    i3 i3Var = new i3(j3.h);
                    i3Var.d = stackTraceElement.getClassName() + '.' + stackTraceElement.getMethodName();
                    i3Var.e = byteArrayOutputStream2;
                    i3Var.a();
                }
            }
        }
    }
}

package com.apm.insight.l;

import android.text.TextUtils;
import com.apm.insight.l.e;
import com.apm.insight.nativecrash.NativeImpl;
import com.facebook.internal.security.CertificateUtil;
import com.google.common.base.Ascii;
import com.mbridge.msdk.foundation.tools.SameMD5;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public final class v {
    private static final StackTraceElement a = new StackTraceElement("", "", "", 0);

    public static class a {
        public int a;
        public int b;

        public a(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        public JSONObject a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("start", this.a);
                jSONObject.put("end", this.b);
            } catch (Throwable unused) {
            }
            return jSONObject;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0064  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(java.lang.String r8) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r8)
            r1 = 0
            if (r0 == 0) goto L_0x0008
            return r1
        L_0x0008:
            java.io.File r0 = new java.io.File
            r0.<init>(r8)
            boolean r8 = r0.exists()
            if (r8 != 0) goto L_0x0014
            return r1
        L_0x0014:
            java.util.LinkedList r8 = new java.util.LinkedList
            r8.<init>()
            java.util.LinkedList r2 = new java.util.LinkedList
            r2.<init>()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r4 = 10
            r5 = 0
            java.io.BufferedReader r6 = new java.io.BufferedReader     // Catch:{ all -> 0x005b }
            java.io.FileReader r7 = new java.io.FileReader     // Catch:{ all -> 0x005b }
            r7.<init>(r0)     // Catch:{ all -> 0x005b }
            r6.<init>(r7)     // Catch:{ all -> 0x005b }
            r0 = 0
        L_0x0031:
            java.lang.String r1 = r6.readLine()     // Catch:{ all -> 0x005a }
            if (r1 == 0) goto L_0x0056
            r7 = 256(0x100, float:3.59E-43)
            if (r0 > r7) goto L_0x0045
            r8.add(r1)     // Catch:{ all -> 0x005a }
            r3.append(r1)     // Catch:{ all -> 0x005a }
            r3.append(r4)     // Catch:{ all -> 0x005a }
            goto L_0x0053
        L_0x0045:
            r2.add(r1)     // Catch:{ all -> 0x005a }
            int r1 = r2.size()     // Catch:{ all -> 0x005a }
            if (r1 <= r7) goto L_0x0053
            r2.poll()     // Catch:{ all -> 0x005a }
            int r5 = r5 + 1
        L_0x0053:
            int r0 = r0 + 1
            goto L_0x0031
        L_0x0056:
            com.apm.insight.l.k.a((java.io.Closeable) r6)
            goto L_0x005e
        L_0x005a:
            r1 = r6
        L_0x005b:
            com.apm.insight.l.k.a((java.io.Closeable) r1)
        L_0x005e:
            boolean r8 = r2.isEmpty()
            if (r8 != 0) goto L_0x008a
            if (r5 == 0) goto L_0x0073
            java.lang.String r8 = "\t... skip "
            r3.append(r8)
            r3.append(r5)
            java.lang.String r8 = " lines\n"
            r3.append(r8)
        L_0x0073:
            java.util.Iterator r8 = r2.iterator()
        L_0x0077:
            boolean r0 = r8.hasNext()
            if (r0 == 0) goto L_0x008a
            java.lang.Object r0 = r8.next()
            java.lang.String r0 = (java.lang.String) r0
            r3.append(r0)
            r3.append(r4)
            goto L_0x0077
        L_0x008a:
            java.lang.String r8 = r3.toString()
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apm.insight.l.v.a(java.lang.String):java.lang.String");
    }

    public static String a(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        try {
            a(th, printWriter);
            String stringWriter2 = stringWriter.toString();
            printWriter.close();
            return stringWriter2;
        } catch (Throwable unused) {
            printWriter.close();
            return "";
        }
    }

    public static String a(Throwable th, Thread thread, PrintStream printStream, e.a aVar) {
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance(SameMD5.TAG);
        } catch (Throwable unused) {
            messageDigest = null;
        }
        e eVar = new e(printStream, messageDigest, aVar);
        try {
            a(th, (PrintWriter) eVar);
        } catch (Throwable unused2) {
        }
        eVar.close();
        if (messageDigest != null) {
            return a(messageDigest.digest());
        }
        return null;
    }

    private static String a(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return "";
        }
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] cArr2 = new char[(bArr.length * 2)];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            cArr2[i] = cArr[(b >>> 4) & 15];
            i = i2 + 1;
            cArr2[i2] = cArr[b & Ascii.SI];
        }
        return new String(cArr2);
    }

    public static String a(StackTraceElement[] stackTraceElementArr) {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement a2 : stackTraceElementArr) {
            a(a2, sb);
        }
        return sb.toString();
    }

    public static StringBuilder a(StackTraceElement stackTraceElement, StringBuilder sb) {
        String className = stackTraceElement.getClassName();
        sb.append("  at ");
        sb.append(className);
        sb.append(".");
        sb.append(stackTraceElement.getMethodName());
        sb.append("(");
        sb.append(stackTraceElement.getFileName());
        sb.append(CertificateUtil.DELIMITER);
        sb.append(stackTraceElement.getLineNumber());
        sb.append(")\n");
        return sb;
    }

    public static JSONArray a(StackTraceElement[] stackTraceElementArr, String[] strArr) {
        a aVar = new a(-1, -1);
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < stackTraceElementArr.length; i++) {
            if (aVar.a == -1) {
                if (a(stackTraceElementArr[i].getClassName(), strArr)) {
                    aVar.a = i;
                    aVar.b = i;
                }
            } else if (!a(stackTraceElementArr[i].getClassName(), strArr)) {
                aVar.b = i;
                jSONArray.put(aVar.a());
                aVar = new a(-1, -1);
            }
        }
        if (aVar.a != -1) {
            aVar.b = stackTraceElementArr.length;
            jSONArray.put(aVar.a());
        }
        return jSONArray;
    }

    public static JSONArray a(String[] strArr, String[] strArr2) {
        a aVar = new a(-1, -1);
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < strArr.length; i++) {
            if (aVar.a == -1) {
                if (a(strArr[i], strArr2)) {
                    aVar.a = i;
                    aVar.b = i;
                }
            } else if (!a(strArr[i], strArr2)) {
                aVar.b = i;
                jSONArray.put(aVar.a());
                aVar = new a(-1, -1);
            }
        }
        if (aVar.a != -1) {
            aVar.b = strArr.length;
            jSONArray.put(aVar.a());
        }
        return jSONArray;
    }

    private static void a(StackTraceElement stackTraceElement, int i) {
        String str;
        String valueOf;
        try {
            a("\tat ", i);
            a(stackTraceElement.getClassName(), i);
            a(".", i);
            a(stackTraceElement.getMethodName(), i);
            if (stackTraceElement.isNativeMethod()) {
                str = "(Native Method)";
            } else {
                if (stackTraceElement.getFileName() != null) {
                    if (stackTraceElement.getLineNumber() >= 0) {
                        a("(", i);
                        a(stackTraceElement.getFileName(), i);
                        a(CertificateUtil.DELIMITER, i);
                        valueOf = String.valueOf(stackTraceElement.getLineNumber());
                    } else {
                        a("(", i);
                        valueOf = stackTraceElement.getFileName();
                    }
                } else if (stackTraceElement.getLineNumber() >= 0) {
                    a("(Unknown Source:", i);
                    valueOf = String.valueOf(stackTraceElement.getLineNumber());
                } else {
                    str = "(Unknown Source)";
                }
                a(valueOf, i);
                a(")", i);
                a("\n", i);
            }
            a(str, i);
            a("\n", i);
        } catch (Throwable unused) {
        }
    }

    private static void a(String str, int i) {
        NativeImpl.a(i, str);
    }

    public static void a(Throwable th, int i) {
        try {
            c(th, i);
        } catch (Throwable unused) {
        }
    }

    private static void a(Throwable th, int i, String str, String str2) {
        StackTraceElement[] stackTrace = th.getStackTrace();
        try {
            NativeImpl.a(i, str2);
            NativeImpl.a(i, str);
        } catch (Throwable unused) {
        }
        b(th, i);
        for (StackTraceElement a2 : stackTrace) {
            a(a2, i);
        }
        for (Throwable a3 : th.getSuppressed()) {
            a(a3, i, "Suppressed: ", str2 + "\t");
        }
        Throwable cause = th.getCause();
        if (cause != null) {
            a(cause, i, "Caused by: ", str2);
        }
    }

    private static void a(Throwable th, PrintWriter printWriter) {
        if (th != null && printWriter != null) {
            Set newSetFromMap = Collections.newSetFromMap(new IdentityHashMap());
            newSetFromMap.add(th);
            printWriter.println(th);
            StackTraceElement[] stackTrace = th.getStackTrace();
            boolean z = stackTrace.length > 384;
            int length = stackTrace.length;
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                StackTraceElement stackTraceElement = stackTrace[i];
                if (z && i2 > 256) {
                    StringBuilder sb = new StringBuilder("\t... skip ");
                    sb.append((stackTrace.length - i2) - 128);
                    sb.append(" lines");
                    printWriter.println(sb.toString());
                    break;
                }
                printWriter.println("\tat " + stackTraceElement);
                i2++;
                i++;
            }
            if (z) {
                for (int length2 = stackTrace.length - 128; length2 < stackTrace.length; length2++) {
                    printWriter.println("\tat " + stackTrace[length2]);
                }
            }
            for (Throwable a2 : th.getSuppressed()) {
                a(a2, printWriter, stackTrace, "Suppressed: ", "\t", (Set<Throwable>) newSetFromMap, 128);
            }
            Throwable cause = th.getCause();
            if (cause != null) {
                a(cause, printWriter, stackTrace, "Caused by: ", "", (Set<Throwable>) newSetFromMap, 128);
            }
        }
    }

    private static void a(Throwable th, PrintWriter printWriter, StackTraceElement[] stackTraceElementArr, String str, String str2, Set<Throwable> set, int i) {
        if (set.contains(th)) {
            printWriter.println("\t[CIRCULAR REFERENCE:" + th + "]");
            return;
        }
        set.add(th);
        StackTraceElement[] stackTrace = th.getStackTrace();
        boolean z = stackTrace.length > i;
        printWriter.println(str2 + str + th);
        int length = stackTrace.length;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= length) {
                break;
            }
            StackTraceElement stackTraceElement = stackTrace[i2];
            if (z && i3 > i) {
                printWriter.println("\t... skip " + ((stackTrace.length - i3) - (i / 2)) + " lines");
                break;
            }
            printWriter.println("\tat " + stackTraceElement);
            i3++;
            i2++;
        }
        if (z) {
            for (int length2 = stackTrace.length - (i / 2); length2 < stackTrace.length; length2++) {
                printWriter.println("\tat " + stackTrace[length2]);
            }
        }
        for (Throwable a2 : th.getSuppressed()) {
            int i4 = i / 2;
            a(a2, printWriter, stackTrace, "Suppressed: ", str2 + "\t", set, i4 > 10 ? i4 : 10);
        }
        Throwable cause = th.getCause();
        if (cause != null) {
            int i5 = i / 2;
            a(cause, printWriter, stackTrace, "Caused by: ", str2, set, i5 > 10 ? i5 : 10);
        }
    }

    private static void a(Throwable th, List<StackTraceElement> list) {
        if (th != null && list != null) {
            Set newSetFromMap = Collections.newSetFromMap(new IdentityHashMap());
            newSetFromMap.add(th);
            list.add(a);
            StackTraceElement[] stackTrace = th.getStackTrace();
            boolean z = stackTrace.length > 384;
            int length = stackTrace.length;
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                StackTraceElement stackTraceElement = stackTrace[i];
                if (z && i2 > 256) {
                    list.add(a);
                    break;
                }
                list.add(stackTraceElement);
                i2++;
                i++;
            }
            if (z) {
                for (int length2 = stackTrace.length - 128; length2 < stackTrace.length; length2++) {
                    list.add(stackTrace[length2]);
                }
            }
            for (Throwable a2 : th.getSuppressed()) {
                a(a2, list, stackTrace, "Suppressed: ", "\t", (Set<Throwable>) newSetFromMap, 128);
            }
            Throwable cause = th.getCause();
            if (cause != null) {
                a(cause, list, stackTrace, "Caused by: ", "", (Set<Throwable>) newSetFromMap, 128);
            }
        }
    }

    private static void a(Throwable th, List<StackTraceElement> list, StackTraceElement[] stackTraceElementArr, String str, String str2, Set<Throwable> set, int i) {
        if (set.contains(th)) {
            list.add(a);
            return;
        }
        set.add(th);
        StackTraceElement[] stackTrace = th.getStackTrace();
        boolean z = stackTrace.length > i;
        list.add(a);
        int length = stackTrace.length;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= length) {
                break;
            }
            StackTraceElement stackTraceElement = stackTrace[i2];
            if (z && i3 > i) {
                list.add(a);
                break;
            }
            list.add(stackTraceElement);
            i3++;
            i2++;
        }
        if (z) {
            for (int length2 = stackTrace.length - (i / 2); length2 < stackTrace.length; length2++) {
                list.add(stackTrace[length2]);
            }
        }
        for (Throwable a2 : th.getSuppressed()) {
            int i4 = i / 2;
            a(a2, list, stackTrace, "Suppressed: ", str2 + "\t", set, i4 > 10 ? i4 : 10);
        }
        Throwable cause = th.getCause();
        if (cause != null) {
            int i5 = i / 2;
            a(cause, list, stackTrace, "Caused by: ", str2, set, i5 > 10 ? i5 : 10);
        }
    }

    public static boolean a(String str, String[] strArr) {
        if (strArr != null && !TextUtils.isEmpty(str)) {
            for (String contains : strArr) {
                if (str.contains(contains)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00d5 A[Catch:{ all -> 0x00e0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0029 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.json.JSONObject b(java.lang.String r16) {
        /*
            r0 = r16
            java.lang.String r1 = ")"
            java.lang.String r2 = "("
            r3 = 0
            java.util.Map r4 = java.lang.Thread.getAllStackTraces()     // Catch:{ all -> 0x00e0 }
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ all -> 0x00e0 }
            r5.<init>()     // Catch:{ all -> 0x00e0 }
            if (r4 != 0) goto L_0x0013
            return r3
        L_0x0013:
            java.lang.String r6 = "thread_all_count"
            int r7 = r4.size()     // Catch:{ all -> 0x00e0 }
            r5.put(r6, r7)     // Catch:{ all -> 0x00e0 }
            org.json.JSONArray r6 = new org.json.JSONArray     // Catch:{ all -> 0x00e0 }
            r6.<init>()     // Catch:{ all -> 0x00e0 }
            java.util.Set r4 = r4.entrySet()     // Catch:{ all -> 0x00e0 }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ all -> 0x00e0 }
        L_0x0029:
            boolean r7 = r4.hasNext()     // Catch:{ all -> 0x00e0 }
            if (r7 == 0) goto L_0x00da
            java.lang.Object r7 = r4.next()     // Catch:{ all -> 0x00e0 }
            java.util.Map$Entry r7 = (java.util.Map.Entry) r7     // Catch:{ all -> 0x00e0 }
            org.json.JSONObject r8 = new org.json.JSONObject     // Catch:{ all -> 0x00e0 }
            r8.<init>()     // Catch:{ all -> 0x00e0 }
            java.lang.Object r9 = r7.getKey()     // Catch:{ all -> 0x00e0 }
            java.lang.Thread r9 = (java.lang.Thread) r9     // Catch:{ all -> 0x00e0 }
            java.lang.String r10 = r9.getName()     // Catch:{ all -> 0x00e0 }
            boolean r11 = c((java.lang.String) r10)     // Catch:{ all -> 0x00e0 }
            if (r11 != 0) goto L_0x0029
            if (r0 == 0) goto L_0x005f
            boolean r11 = r0.equals(r10)     // Catch:{ all -> 0x00e0 }
            if (r11 != 0) goto L_0x0029
            boolean r11 = r10.startsWith(r0)     // Catch:{ all -> 0x00e0 }
            if (r11 != 0) goto L_0x0029
            boolean r10 = r10.endsWith(r0)     // Catch:{ all -> 0x00e0 }
            if (r10 == 0) goto L_0x005f
            goto L_0x0029
        L_0x005f:
            java.lang.String r10 = "thread_name"
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e0 }
            r11.<init>()     // Catch:{ all -> 0x00e0 }
            java.lang.String r12 = r9.getName()     // Catch:{ all -> 0x00e0 }
            r11.append(r12)     // Catch:{ all -> 0x00e0 }
            r11.append(r2)     // Catch:{ all -> 0x00e0 }
            long r12 = r9.getId()     // Catch:{ all -> 0x00e0 }
            r11.append(r12)     // Catch:{ all -> 0x00e0 }
            r11.append(r1)     // Catch:{ all -> 0x00e0 }
            java.lang.String r9 = r11.toString()     // Catch:{ all -> 0x00e0 }
            r8.put(r10, r9)     // Catch:{ all -> 0x00e0 }
            java.lang.Object r7 = r7.getValue()     // Catch:{ all -> 0x00e0 }
            java.lang.StackTraceElement[] r7 = (java.lang.StackTraceElement[]) r7     // Catch:{ all -> 0x00e0 }
            if (r7 == 0) goto L_0x00d2
            org.json.JSONArray r10 = new org.json.JSONArray     // Catch:{ all -> 0x00e0 }
            r10.<init>()     // Catch:{ all -> 0x00e0 }
            int r11 = r7.length     // Catch:{ all -> 0x00e0 }
            r12 = 0
            r13 = 0
        L_0x0091:
            if (r13 >= r11) goto L_0x00c4
            r14 = r7[r13]     // Catch:{ all -> 0x00e0 }
            java.lang.String r15 = r14.getClassName()     // Catch:{ all -> 0x00e0 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e0 }
            r9.<init>()     // Catch:{ all -> 0x00e0 }
            r9.append(r15)     // Catch:{ all -> 0x00e0 }
            java.lang.String r15 = "."
            r9.append(r15)     // Catch:{ all -> 0x00e0 }
            java.lang.String r15 = r14.getMethodName()     // Catch:{ all -> 0x00e0 }
            r9.append(r15)     // Catch:{ all -> 0x00e0 }
            r9.append(r2)     // Catch:{ all -> 0x00e0 }
            int r14 = r14.getLineNumber()     // Catch:{ all -> 0x00e0 }
            r9.append(r14)     // Catch:{ all -> 0x00e0 }
            r9.append(r1)     // Catch:{ all -> 0x00e0 }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x00e0 }
            r10.put(r9)     // Catch:{ all -> 0x00e0 }
            int r13 = r13 + 1
            goto L_0x0091
        L_0x00c4:
            java.lang.String r7 = "thread_stack"
            r8.put(r7, r10)     // Catch:{ all -> 0x00e0 }
            int r7 = r10.length()     // Catch:{ all -> 0x00e0 }
            if (r7 <= 0) goto L_0x00d0
            goto L_0x00d2
        L_0x00d0:
            r9 = 0
            goto L_0x00d3
        L_0x00d2:
            r9 = 1
        L_0x00d3:
            if (r9 == 0) goto L_0x0029
            r6.put(r8)     // Catch:{ all -> 0x00e0 }
            goto L_0x0029
        L_0x00da:
            java.lang.String r0 = "thread_stacks"
            r5.put(r0, r6)     // Catch:{ all -> 0x00e0 }
            return r5
        L_0x00e0:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apm.insight.l.v.b(java.lang.String):org.json.JSONObject");
    }

    private static void b(Throwable th, int i) {
        th.getClass().getName();
        String localizedMessage = th.getLocalizedMessage();
        try {
            a(th.getClass().getName(), i);
            if (localizedMessage != null) {
                a(": ", i);
                a(localizedMessage, i);
            }
            a("\n", i);
        } catch (Throwable unused) {
        }
    }

    public static StackTraceElement[] b(Throwable th) {
        ArrayList arrayList = new ArrayList();
        try {
            a(th, (List<StackTraceElement>) arrayList);
        } catch (Throwable unused) {
        }
        return (StackTraceElement[]) arrayList.toArray(new StackTraceElement[arrayList.size()]);
    }

    private static void c(Throwable th, int i) {
        if (th != null && i > 0) {
            b(th, i);
            for (StackTraceElement a2 : th.getStackTrace()) {
                a(a2, i);
            }
            for (Throwable a3 : th.getSuppressed()) {
                a(a3, i, "Suppressed: ", "\t");
            }
            Throwable cause = th.getCause();
            if (cause != null) {
                a(cause, i, "Caused by: ", "");
            }
        }
    }

    private static boolean c(String str) {
        Set<String> a2 = j.a();
        if (a2.contains(str)) {
            return true;
        }
        for (String next : a2) {
            if (!TextUtils.isEmpty(str) && str.startsWith(next)) {
                return true;
            }
        }
        return false;
    }

    public static boolean c(Throwable th) {
        if (th == null) {
            return false;
        }
        int i = 0;
        while (th != null) {
            try {
                if (th instanceof OutOfMemoryError) {
                    return true;
                }
                if (i > 20) {
                    return false;
                }
                i++;
                th = th.getCause();
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static boolean d(Throwable th) {
        if (th == null) {
            return false;
        }
        int i = 0;
        while (th != null) {
            try {
                if ((th instanceof OutOfMemoryError) && (th.getMessage().contains("allocate") || th.getMessage().contains("thrown"))) {
                    return true;
                }
                if (i > 20) {
                    return false;
                }
                i++;
                th = th.getCause();
            } catch (Throwable unused) {
                return true;
            }
        }
        return false;
    }
}

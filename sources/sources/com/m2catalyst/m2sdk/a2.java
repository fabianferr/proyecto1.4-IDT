package com.m2catalyst.m2sdk;

import android.content.Context;
import com.m2catalyst.m2sdk.business.repositories.MNSIRepository;
import com.m2catalyst.m2sdk.logger.M2SDKLogger;
import com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsManager;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/* compiled from: IngestionTransmissionUtils.kt */
public final class a2 {
    public static final M2SDKLogger a = M2SDKLogger.Companion.getLogger("TRANSMISSION");

    public static final String a(byte[] bArr, Context context, String str, int i, int i2) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "nameTag");
        try {
            String str2 = str + "_" + i;
            FileOutputStream openFileOutput = context.openFileOutput(str2, i2);
            Intrinsics.checkNotNullExpressionValue(openFileOutput, "context.openFileOutput(name, contextMode)");
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(openFileOutput);
            bufferedOutputStream.write(bArr);
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
            M2SDKLogger.Companion.log$default(M2SDKLogger.Companion, "SAVE_FILES", "For byte array size " + bArr.length + " and TAG " + str + ", the file was saved with name " + str2, (Map) null, false, 12, (Object) null);
            return str2;
        } catch (Exception unused) {
            M2SDKLogger.Companion.e("IngestionTransmissionUtil", "Excpetion when trying to save file with tag " + str, new String[0]);
            return "";
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0039, code lost:
        if (kotlin.text.StringsKt.contains((java.lang.CharSequence) r7, (java.lang.CharSequence) r15, true) != false) goto L_0x003d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.util.LinkedHashMap b(android.content.Context r14, java.lang.String r15) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.String r0 = "NAME_TAG"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.util.LinkedHashMap r0 = new java.util.LinkedHashMap
            r0.<init>()
            java.io.File r14 = r14.getFilesDir()
            java.io.File[] r14 = r14.listFiles()
            if (r14 == 0) goto L_0x008f
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            int r2 = r14.length
            r3 = 0
            r4 = 0
        L_0x0021:
            java.lang.String r5 = "it.name"
            if (r4 >= r2) goto L_0x0045
            r6 = r14[r4]
            boolean r7 = r6.isDirectory()
            if (r7 != 0) goto L_0x003c
            java.lang.String r7 = r6.getName()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r5)
            r5 = 1
            boolean r7 = kotlin.text.StringsKt.contains((java.lang.CharSequence) r7, (java.lang.CharSequence) r15, (boolean) r5)
            if (r7 == 0) goto L_0x003c
            goto L_0x003d
        L_0x003c:
            r5 = 0
        L_0x003d:
            if (r5 == 0) goto L_0x0042
            r1.add(r6)
        L_0x0042:
            int r4 = r4 + 1
            goto L_0x0021
        L_0x0045:
            java.util.Iterator r14 = r1.iterator()
        L_0x0049:
            boolean r1 = r14.hasNext()
            if (r1 == 0) goto L_0x008f
            java.lang.Object r1 = r14.next()
            java.io.File r1 = (java.io.File) r1
            long r6 = r1.length()
            int r2 = (int) r6
            byte[] r4 = new byte[r2]
            java.io.BufferedInputStream r6 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x0077 }
            java.io.FileInputStream r7 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0077 }
            r7.<init>(r1)     // Catch:{ Exception -> 0x0077 }
            r6.<init>(r7)     // Catch:{ Exception -> 0x0077 }
            r6.read(r4, r3, r2)     // Catch:{ Exception -> 0x0077 }
            r6.close()     // Catch:{ Exception -> 0x0077 }
            java.lang.String r1 = r1.getName()     // Catch:{ Exception -> 0x0077 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r5)     // Catch:{ Exception -> 0x0077 }
            r0.put(r1, r4)     // Catch:{ Exception -> 0x0077 }
            goto L_0x0049
        L_0x0077:
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r1 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r4 = "Excpetion when trying to get file with tag "
            r2.<init>(r4)
            r2.append(r15)
            java.lang.String r2 = r2.toString()
            java.lang.String[] r4 = new java.lang.String[r3]
            java.lang.String r6 = "IngestionTransmissionUtil"
            r1.e((java.lang.String) r6, (java.lang.String) r2, (java.lang.String[]) r4)
            goto L_0x0049
        L_0x008f:
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r7 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            int r14 = r0.size()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "For name "
            r1.<init>(r2)
            r1.append(r15)
            java.lang.String r15 = ", "
            r1.append(r15)
            r1.append(r14)
            java.lang.String r14 = " files were retrieved"
            r1.append(r14)
            java.lang.String r9 = r1.toString()
            java.lang.String r8 = "GET_SAVED_FILES"
            r10 = 0
            r11 = 0
            r12 = 12
            r13 = 0
            com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion.log$default(r7, r8, r9, r10, r11, r12, r13)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.a2.b(android.content.Context, java.lang.String):java.util.LinkedHashMap");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x004f, code lost:
        if (r8.lastModified() < r0.getTimeInMillis()) goto L_0x0053;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void a(android.content.Context r14, java.lang.String r15) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.String r0 = "NAME_TAG"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.util.Calendar r0 = java.util.Calendar.getInstance()
            r1 = 6
            r2 = -14
            r0.add(r1, r2)
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.io.File r2 = r14.getFilesDir()
            java.io.File[] r2 = r2.listFiles()
            if (r2 == 0) goto L_0x0076
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            int r4 = r2.length
            r5 = 0
            r6 = 0
        L_0x002b:
            java.lang.String r7 = "it.name"
            if (r6 >= r4) goto L_0x005b
            r8 = r2[r6]
            boolean r9 = r8.isDirectory()
            if (r9 != 0) goto L_0x0052
            java.lang.String r9 = r8.getName()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r7)
            r7 = 1
            boolean r9 = kotlin.text.StringsKt.contains((java.lang.CharSequence) r9, (java.lang.CharSequence) r15, (boolean) r7)
            if (r9 == 0) goto L_0x0052
            long r9 = r8.lastModified()
            long r11 = r0.getTimeInMillis()
            int r13 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r13 >= 0) goto L_0x0052
            goto L_0x0053
        L_0x0052:
            r7 = 0
        L_0x0053:
            if (r7 == 0) goto L_0x0058
            r3.add(r8)
        L_0x0058:
            int r6 = r6 + 1
            goto L_0x002b
        L_0x005b:
            java.util.Iterator r15 = r3.iterator()
        L_0x005f:
            boolean r0 = r15.hasNext()
            if (r0 == 0) goto L_0x0076
            java.lang.Object r0 = r15.next()
            java.io.File r0 = (java.io.File) r0
            java.lang.String r0 = r0.getName()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r7)
            r1.add(r0)
            goto L_0x005f
        L_0x0076:
            a((android.content.Context) r14, (java.util.List<java.lang.String>) r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.a2.a(android.content.Context, java.lang.String):void");
    }

    public static final void a(Context context, List<String> list) {
        int i;
        List<String> list2 = list;
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(list2, "files");
        a.i("IngestionTransmissionUtils", "deleteFiles() files=" + list2, new String[0]);
        File[] listFiles = context.getFilesDir().listFiles();
        if (listFiles != null) {
            ArrayList<File> arrayList = new ArrayList<>();
            for (File file : listFiles) {
                if (!file.isDirectory()) {
                    arrayList.add(file);
                }
            }
            i = 0;
            for (File file2 : arrayList) {
                if (list2.contains(file2.getName())) {
                    try {
                        if (file2.delete()) {
                            i++;
                            a.d("IngestionTransmissionUtils", "The file with name " + file2.getName() + " was deleted", new String[0]);
                            M2SDKLogger.Companion.log$default(M2SDKLogger.Companion, "DELETE_FILE", "The file with name " + file2.getName() + " was deleted", (Map) null, false, 12, (Object) null);
                        }
                    } catch (Exception e) {
                        a.e("IngestionTransmissionUtils", "The file with name " + file2.getName() + " couldn't be deleted " + e.getMessage(), new String[0]);
                        M2SDKLogger.Companion.log$default(M2SDKLogger.Companion, "DELETE_FILE", "The file with name " + file2.getName() + " couldn't be deleted EXCEPTION", (Map) null, false, 12, (Object) null);
                    }
                }
            }
        } else {
            i = 0;
        }
        a.i("MNSIRepository", "There were " + i + "/" + list.size() + " correctly deleted - " + (list.size() - i) + " still exist", new String[0]);
        M2SDKLogger.Companion.log$default(M2SDKLogger.Companion, "DELETE_FILE", "There were " + i + "/" + list.size() + " correctly deleted - " + (list.size() - i) + " WERE NOT DELETED", (Map) null, false, 12, (Object) null);
    }

    public static final String a(byte[] bArr, Context context) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(MNSIRepository.TAG_NETWORK_LOGS, "fileName");
        return a(bArr, context, MNSIRepository.TAG_NETWORK_LOGS, new Random().nextInt(100000), 0);
    }

    public static final String a(String str) {
        Intrinsics.checkNotNullParameter(MonitorStatsManager.TAG, "fileName");
        Intrinsics.checkNotNullParameter(str, "date");
        String replace$default = StringsKt.replace$default(str, "-", "_", false, 4, (Object) null);
        return "MonitoringStats_" + replace$default;
    }

    public static final String a(byte[] bArr, Context context, String str) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(MonitorStatsManager.TAG, "fileName");
        Intrinsics.checkNotNullParameter(str, "date");
        return a(bArr, context, String.valueOf(a(str)), new Random().nextInt(100000), 0);
    }

    public static final RequestBody a(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        RequestBody create = RequestBody.create(MediaType.parse("application/octet-stream"), bArr);
        Intrinsics.checkNotNullExpressionValue(create, "create(MediaType.parse(\"…ion/octet-stream\"), this)");
        return create;
    }
}

package com.bykv.vk.openvk.preload.geckox.a;

import com.bykv.vk.openvk.preload.geckox.utils.b;
import com.bykv.vk.openvk.preload.geckox.utils.e;
import com.bykv.vk.openvk.preload.geckox.utils.i;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ChannelCleanHelper */
public final class c {
    public static void a(final String str) {
        i.a().execute(new Runnable() {
            public final void run() {
                try {
                    c.c(str);
                } catch (Throwable th) {
                    b.a(new RuntimeException("delete old channel version failed，path：" + str, th));
                }
            }
        });
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(9:5|6|7|8|9|10|11|12|13) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0040 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean b(java.lang.String r4) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x004c }
            r0.<init>()     // Catch:{ all -> 0x004c }
            r0.append(r4)     // Catch:{ all -> 0x004c }
            java.lang.String r1 = java.io.File.separator     // Catch:{ all -> 0x004c }
            r0.append(r1)     // Catch:{ all -> 0x004c }
            java.lang.String r1 = "update.lock"
            r0.append(r1)     // Catch:{ all -> 0x004c }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x004c }
            com.bykv.vk.openvk.preload.geckox.g.a r0 = com.bykv.vk.openvk.preload.geckox.g.a.a(r0)     // Catch:{ all -> 0x004c }
            r1 = 1
            if (r0 != 0) goto L_0x001e
            return r1
        L_0x001e:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0047 }
            r2.<init>()     // Catch:{ all -> 0x0047 }
            r2.append(r4)     // Catch:{ all -> 0x0047 }
            java.lang.String r3 = java.io.File.separator     // Catch:{ all -> 0x0047 }
            r2.append(r3)     // Catch:{ all -> 0x0047 }
            java.lang.String r3 = "select.lock"
            r2.append(r3)     // Catch:{ all -> 0x0047 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0047 }
            com.bykv.vk.openvk.preload.geckox.g.b r2 = com.bykv.vk.openvk.preload.geckox.g.b.a(r2)     // Catch:{ all -> 0x0047 }
            java.io.File r3 = new java.io.File     // Catch:{ all -> 0x0040 }
            r3.<init>(r4)     // Catch:{ all -> 0x0040 }
            com.bykv.vk.openvk.preload.geckox.utils.c.b(r3)     // Catch:{ all -> 0x0040 }
        L_0x0040:
            r2.a()     // Catch:{ all -> 0x0047 }
            r0.a()     // Catch:{ all -> 0x004c }
            return r1
        L_0x0047:
            r4 = move-exception
            r0.a()     // Catch:{ all -> 0x004c }
            throw r4     // Catch:{ all -> 0x004c }
        L_0x004c:
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.openvk.preload.geckox.a.c.b(java.lang.String):boolean");
    }

    private static List<File> a(File[] fileArr) {
        long j;
        File file;
        ArrayList<File> arrayList = new ArrayList<>();
        ArrayList arrayList2 = new ArrayList();
        int length = fileArr.length;
        File file2 = null;
        long j2 = -1;
        for (int i = 0; i < length; i++) {
            file = fileArr[i];
            String name = file.getName();
            if (name.endsWith("--updating")) {
                arrayList.add(file);
            } else if (name.endsWith("--pending-delete")) {
                a(file);
            } else {
                try {
                    long parseLong = Long.parseLong(name);
                    if (parseLong > j2) {
                        if (file2 != null) {
                            try {
                                arrayList2.add(file2);
                            } catch (Exception unused) {
                                j2 = parseLong;
                            }
                        }
                        file2 = file;
                        j2 = parseLong;
                    } else {
                        arrayList2.add(file);
                    }
                } catch (Exception unused2) {
                }
            }
        }
        for (File file3 : arrayList) {
            String name2 = file3.getName();
            int indexOf = name2.indexOf("--updating");
            if (indexOf == -1) {
                a(file3);
            } else {
                try {
                    j = Long.parseLong(name2.substring(0, indexOf));
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    j = -1;
                }
                if (j <= j2) {
                    a(file3);
                }
            }
        }
        return arrayList2;
        a(file);
    }

    private static void a(final File file) {
        e.a().execute(new Runnable() {
            public final void run() {
                com.bykv.vk.openvk.preload.geckox.utils.c.a(file);
            }
        });
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0056 A[Catch:{ all -> 0x0099, all -> 0x009e }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void c(java.lang.String r4) throws java.lang.Exception {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r4)
            java.lang.String r1 = java.io.File.separator
            r0.append(r1)
            java.lang.String r1 = "update.lock"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.bykv.vk.openvk.preload.geckox.g.a r0 = com.bykv.vk.openvk.preload.geckox.g.a.a(r0)
            if (r0 == 0) goto L_0x00a3
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x009e }
            r1.<init>()     // Catch:{ all -> 0x009e }
            r1.append(r4)     // Catch:{ all -> 0x009e }
            java.lang.String r2 = java.io.File.separator     // Catch:{ all -> 0x009e }
            r1.append(r2)     // Catch:{ all -> 0x009e }
            java.lang.String r2 = "select.lock"
            r1.append(r2)     // Catch:{ all -> 0x009e }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x009e }
            com.bykv.vk.openvk.preload.geckox.g.b r1 = com.bykv.vk.openvk.preload.geckox.g.b.a(r1)     // Catch:{ all -> 0x009e }
            java.io.File r2 = new java.io.File     // Catch:{ all -> 0x0099 }
            r2.<init>(r4)     // Catch:{ all -> 0x0099 }
            com.bykv.vk.openvk.preload.geckox.a.c$2 r4 = new com.bykv.vk.openvk.preload.geckox.a.c$2     // Catch:{ all -> 0x0099 }
            r4.<init>()     // Catch:{ all -> 0x0099 }
            java.io.File[] r4 = r2.listFiles(r4)     // Catch:{ all -> 0x0099 }
            if (r4 == 0) goto L_0x0053
            int r2 = r4.length     // Catch:{ all -> 0x0099 }
            if (r2 == 0) goto L_0x0053
            int r2 = r4.length     // Catch:{ all -> 0x0099 }
            r3 = 1
            if (r2 != r3) goto L_0x004e
            goto L_0x0053
        L_0x004e:
            java.util.List r4 = a((java.io.File[]) r4)     // Catch:{ all -> 0x0099 }
            goto L_0x0054
        L_0x0053:
            r4 = 0
        L_0x0054:
            if (r4 == 0) goto L_0x0092
            boolean r2 = r4.isEmpty()     // Catch:{ all -> 0x0099 }
            if (r2 == 0) goto L_0x005d
            goto L_0x0092
        L_0x005d:
            java.util.Iterator r4 = r4.iterator()     // Catch:{ all -> 0x0099 }
        L_0x0061:
            boolean r2 = r4.hasNext()     // Catch:{ all -> 0x0099 }
            if (r2 == 0) goto L_0x008b
            java.lang.Object r2 = r4.next()     // Catch:{ all -> 0x0099 }
            java.io.File r2 = (java.io.File) r2     // Catch:{ all -> 0x0099 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0099 }
            r3.<init>()     // Catch:{ all -> 0x0099 }
            java.lang.String r2 = r2.getAbsolutePath()     // Catch:{ all -> 0x0099 }
            r3.append(r2)     // Catch:{ all -> 0x0099 }
            java.lang.String r2 = java.io.File.separator     // Catch:{ all -> 0x0099 }
            r3.append(r2)     // Catch:{ all -> 0x0099 }
            java.lang.String r2 = "using.lock"
            r3.append(r2)     // Catch:{ all -> 0x0099 }
            java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x0099 }
            com.bykv.vk.openvk.preload.geckox.g.c.c(r2)     // Catch:{ all -> 0x0099 }
            goto L_0x0061
        L_0x008b:
            r1.a()     // Catch:{ all -> 0x009e }
            r0.a()
            return
        L_0x0092:
            r1.a()     // Catch:{ all -> 0x009e }
            r0.a()
            return
        L_0x0099:
            r4 = move-exception
            r1.a()     // Catch:{ all -> 0x009e }
            throw r4     // Catch:{ all -> 0x009e }
        L_0x009e:
            r4 = move-exception
            r0.a()
            throw r4
        L_0x00a3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.openvk.preload.geckox.a.c.c(java.lang.String):void");
    }
}

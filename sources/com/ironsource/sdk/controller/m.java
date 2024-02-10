package com.ironsource.sdk.controller;

import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.sdk.h.b;
import org.json.JSONObject;

final class m {
    private final String a;
    private final b b;

    m(String str, b bVar) {
        this.a = str;
        this.b = bVar;
    }

    private static JSONObject a(o oVar, long j) {
        try {
            return oVar.a().put(IronSourceConstants.EVENTS_RESULT, j);
        } catch (Exception e) {
            e.printStackTrace();
            return new JSONObject();
        }
    }

    static JSONObject a(o oVar, String str) {
        try {
            return oVar.a().put("errMsg", str);
        } catch (Exception e) {
            e.printStackTrace();
            return new JSONObject();
        }
    }

    static JSONObject a(o oVar, JSONObject jSONObject) {
        try {
            return oVar.a().put(IronSourceConstants.EVENTS_RESULT, jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
            return new JSONObject();
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(org.json.JSONObject r14, com.ironsource.sdk.controller.A.d.a r15) {
        /*
            r13 = this;
            java.lang.String r0 = "fileName"
            java.lang.String r1 = "filePath"
            com.ironsource.sdk.controller.o r2 = new com.ironsource.sdk.controller.o
            r2.<init>(r14)
            com.ironsource.sdk.controller.p r14 = new com.ironsource.sdk.controller.p
            r14.<init>(r15)
            java.lang.String r15 = r2.a     // Catch:{ Exception -> 0x01fc }
            org.json.JSONObject r3 = r2.b     // Catch:{ Exception -> 0x01fc }
            java.lang.String r4 = r13.a     // Catch:{ Exception -> 0x01fc }
            boolean r5 = r3.has(r1)     // Catch:{ Exception -> 0x01fc }
            java.lang.String r6 = "Missing params for file"
            if (r5 == 0) goto L_0x01f6
            boolean r5 = r3.has(r0)     // Catch:{ Exception -> 0x01fc }
            if (r5 == 0) goto L_0x01f6
            java.lang.String r1 = r3.getString(r1)     // Catch:{ Exception -> 0x01fc }
            java.lang.String r0 = r3.getString(r0)     // Catch:{ Exception -> 0x01fc }
            com.ironsource.sdk.h.c r8 = new com.ironsource.sdk.h.c     // Catch:{ Exception -> 0x01fc }
            java.lang.String r1 = com.ironsource.sdk.utils.IronSourceStorageUtils.buildAbsolutePathToDirInCache(r4, r1)     // Catch:{ Exception -> 0x01fc }
            r8.<init>(r1, r0)     // Catch:{ Exception -> 0x01fc }
            java.lang.String r0 = r13.a     // Catch:{ Exception -> 0x01fc }
            com.ironsource.sdk.utils.IronSourceStorageUtils.ensurePathSafety(r8, r0)     // Catch:{ Exception -> 0x01fc }
            int r0 = r15.hashCode()     // Catch:{ Exception -> 0x01fc }
            r1 = 0
            r4 = 5
            r5 = 4
            r7 = 3
            r9 = 2
            r10 = 1
            switch(r0) {
                case -2073025383: goto L_0x0079;
                case -1137024519: goto L_0x006f;
                case -318115535: goto L_0x0065;
                case 537556755: goto L_0x005a;
                case 1764172231: goto L_0x0050;
                case 1953259713: goto L_0x0046;
                default: goto L_0x0045;
            }     // Catch:{ Exception -> 0x01fc }
        L_0x0045:
            goto L_0x0083
        L_0x0046:
            java.lang.String r0 = "getFiles"
            boolean r15 = r15.equals(r0)     // Catch:{ Exception -> 0x01fc }
            if (r15 == 0) goto L_0x0083
            r15 = 3
            goto L_0x0084
        L_0x0050:
            java.lang.String r0 = "deleteFile"
            boolean r15 = r15.equals(r0)     // Catch:{ Exception -> 0x01fc }
            if (r15 == 0) goto L_0x0083
            r15 = 1
            goto L_0x0084
        L_0x005a:
            java.lang.String r0 = "updateAttributesOfFile"
            boolean r15 = r15.equals(r0)     // Catch:{ Exception -> 0x01fc }
            if (r15 == 0) goto L_0x0083
            r15 = 5
            goto L_0x0084
        L_0x0065:
            java.lang.String r0 = "getTotalSizeOfFiles"
            boolean r15 = r15.equals(r0)     // Catch:{ Exception -> 0x01fc }
            if (r15 == 0) goto L_0x0083
            r15 = 4
            goto L_0x0084
        L_0x006f:
            java.lang.String r0 = "deleteFolder"
            boolean r15 = r15.equals(r0)     // Catch:{ Exception -> 0x01fc }
            if (r15 == 0) goto L_0x0083
            r15 = 2
            goto L_0x0084
        L_0x0079:
            java.lang.String r0 = "saveFile"
            boolean r15 = r15.equals(r0)     // Catch:{ Exception -> 0x01fc }
            if (r15 == 0) goto L_0x0083
            r15 = 0
            goto L_0x0084
        L_0x0083:
            r15 = -1
        L_0x0084:
            if (r15 == 0) goto L_0x0167
            if (r15 == r10) goto L_0x013d
            if (r15 == r9) goto L_0x010b
            java.lang.String r0 = "Folder does not exist"
            if (r15 == r7) goto L_0x00ee
            if (r15 == r5) goto L_0x00d5
            if (r15 == r4) goto L_0x0094
            goto L_0x01ca
        L_0x0094:
            java.lang.String r15 = "attributesToUpdate"
            org.json.JSONObject r15 = r3.optJSONObject(r15)     // Catch:{ Exception -> 0x01fc }
            com.ironsource.sdk.h.b r0 = r13.b     // Catch:{ Exception -> 0x01fc }
            if (r15 == 0) goto L_0x00cd
            boolean r1 = r8.exists()     // Catch:{ Exception -> 0x01fc }
            if (r1 == 0) goto L_0x00c5
            com.ironsource.sdk.h.d r0 = r0.d     // Catch:{ Exception -> 0x01fc }
            java.lang.String r1 = r8.getName()     // Catch:{ Exception -> 0x01fc }
            boolean r15 = r0.b(r1, r15)     // Catch:{ Exception -> 0x01fc }
            if (r15 == 0) goto L_0x00bd
            org.json.JSONObject r15 = r8.a()     // Catch:{ Exception -> 0x01fc }
            org.json.JSONObject r15 = a((com.ironsource.sdk.controller.o) r2, (org.json.JSONObject) r15)     // Catch:{ Exception -> 0x01fc }
            r14.a(r2, r15)     // Catch:{ Exception -> 0x01fc }
            goto L_0x01ca
        L_0x00bd:
            java.lang.Exception r15 = new java.lang.Exception     // Catch:{ Exception -> 0x01fc }
            java.lang.String r0 = "Failed to update attribute"
            r15.<init>(r0)     // Catch:{ Exception -> 0x01fc }
            throw r15     // Catch:{ Exception -> 0x01fc }
        L_0x00c5:
            java.lang.Exception r15 = new java.lang.Exception     // Catch:{ Exception -> 0x01fc }
            java.lang.String r0 = "File does not exist"
            r15.<init>(r0)     // Catch:{ Exception -> 0x01fc }
            throw r15     // Catch:{ Exception -> 0x01fc }
        L_0x00cd:
            java.lang.Exception r15 = new java.lang.Exception     // Catch:{ Exception -> 0x01fc }
            java.lang.String r0 = "Missing attributes to update"
            r15.<init>(r0)     // Catch:{ Exception -> 0x01fc }
            throw r15     // Catch:{ Exception -> 0x01fc }
        L_0x00d5:
            boolean r15 = r8.exists()     // Catch:{ Exception -> 0x01fc }
            if (r15 == 0) goto L_0x00e8
            long r0 = com.ironsource.sdk.utils.IronSourceStorageUtils.getTotalSizeOfDir(r8)     // Catch:{ Exception -> 0x01fc }
            org.json.JSONObject r15 = a((com.ironsource.sdk.controller.o) r2, (long) r0)     // Catch:{ Exception -> 0x01fc }
        L_0x00e3:
            r14.a(r2, r15)     // Catch:{ Exception -> 0x01fc }
            goto L_0x0208
        L_0x00e8:
            java.lang.Exception r15 = new java.lang.Exception     // Catch:{ Exception -> 0x01fc }
            r15.<init>(r0)     // Catch:{ Exception -> 0x01fc }
            throw r15     // Catch:{ Exception -> 0x01fc }
        L_0x00ee:
            com.ironsource.sdk.h.b r15 = r13.b     // Catch:{ Exception -> 0x01fc }
            boolean r1 = r8.exists()     // Catch:{ Exception -> 0x01fc }
            if (r1 == 0) goto L_0x0105
            com.ironsource.sdk.h.d r15 = r15.d     // Catch:{ Exception -> 0x01fc }
            org.json.JSONObject r15 = r15.a()     // Catch:{ Exception -> 0x01fc }
            org.json.JSONObject r15 = com.ironsource.sdk.utils.IronSourceStorageUtils.buildFilesMapOfDirectory(r8, r15)     // Catch:{ Exception -> 0x01fc }
            org.json.JSONObject r15 = a((com.ironsource.sdk.controller.o) r2, (org.json.JSONObject) r15)     // Catch:{ Exception -> 0x01fc }
            goto L_0x00e3
        L_0x0105:
            java.lang.Exception r15 = new java.lang.Exception     // Catch:{ Exception -> 0x01fc }
            r15.<init>(r0)     // Catch:{ Exception -> 0x01fc }
            throw r15     // Catch:{ Exception -> 0x01fc }
        L_0x010b:
            com.ironsource.sdk.h.b r15 = r13.b     // Catch:{ Exception -> 0x01fc }
            boolean r0 = r8.exists()     // Catch:{ Exception -> 0x01fc }
            if (r0 == 0) goto L_0x0134
            java.util.ArrayList r0 = com.ironsource.sdk.utils.IronSourceStorageUtils.getFilesInFolderRecursive(r8)     // Catch:{ Exception -> 0x01fc }
            boolean r3 = com.ironsource.sdk.utils.IronSourceStorageUtils.deleteFolderContentRecursive(r8)     // Catch:{ Exception -> 0x01fc }
            if (r3 == 0) goto L_0x0124
            boolean r3 = r8.delete()     // Catch:{ Exception -> 0x01fc }
            if (r3 == 0) goto L_0x0124
            r1 = 1
        L_0x0124:
            if (r1 == 0) goto L_0x012c
            com.ironsource.sdk.h.d r15 = r15.d     // Catch:{ Exception -> 0x01fc }
            r15.a((java.util.ArrayList<com.ironsource.sdk.h.c>) r0)     // Catch:{ Exception -> 0x01fc }
            goto L_0x0134
        L_0x012c:
            java.lang.Exception r15 = new java.lang.Exception     // Catch:{ Exception -> 0x01fc }
            java.lang.String r0 = "Failed to delete folder"
            r15.<init>(r0)     // Catch:{ Exception -> 0x01fc }
            throw r15     // Catch:{ Exception -> 0x01fc }
        L_0x0134:
            org.json.JSONObject r15 = r8.a()     // Catch:{ Exception -> 0x01fc }
            org.json.JSONObject r15 = a((com.ironsource.sdk.controller.o) r2, (org.json.JSONObject) r15)     // Catch:{ Exception -> 0x01fc }
            goto L_0x00e3
        L_0x013d:
            com.ironsource.sdk.h.b r15 = r13.b     // Catch:{ Exception -> 0x01fc }
            boolean r0 = r8.exists()     // Catch:{ Exception -> 0x01fc }
            if (r0 == 0) goto L_0x015d
            boolean r0 = r8.delete()     // Catch:{ Exception -> 0x01fc }
            if (r0 == 0) goto L_0x0155
            com.ironsource.sdk.h.d r15 = r15.d     // Catch:{ Exception -> 0x01fc }
            java.lang.String r0 = r8.getName()     // Catch:{ Exception -> 0x01fc }
            r15.a((java.lang.String) r0)     // Catch:{ Exception -> 0x01fc }
            goto L_0x015d
        L_0x0155:
            java.lang.Exception r15 = new java.lang.Exception     // Catch:{ Exception -> 0x01fc }
            java.lang.String r0 = "Failed to delete file"
            r15.<init>(r0)     // Catch:{ Exception -> 0x01fc }
            throw r15     // Catch:{ Exception -> 0x01fc }
        L_0x015d:
            org.json.JSONObject r15 = r8.a()     // Catch:{ Exception -> 0x01fc }
            org.json.JSONObject r15 = a((com.ironsource.sdk.controller.o) r2, (org.json.JSONObject) r15)     // Catch:{ Exception -> 0x01fc }
            goto L_0x00e3
        L_0x0167:
            java.lang.String r15 = "fileUrl"
            java.lang.String r9 = r3.optString(r15)     // Catch:{ Exception -> 0x01fc }
            java.lang.String r15 = "connectionTimeout"
            int r10 = r3.optInt(r15)     // Catch:{ Exception -> 0x01fc }
            java.lang.String r15 = "readTimeout"
            int r11 = r3.optInt(r15)     // Catch:{ Exception -> 0x01fc }
            com.ironsource.sdk.controller.m$1 r15 = new com.ironsource.sdk.controller.m$1     // Catch:{ Exception -> 0x01fc }
            r15.<init>(r14, r2)     // Catch:{ Exception -> 0x01fc }
            com.ironsource.sdk.h.b r0 = r13.b     // Catch:{ Exception -> 0x01fc }
            boolean r1 = android.text.TextUtils.isEmpty(r9)     // Catch:{ Exception -> 0x01fc }
            if (r1 != 0) goto L_0x01f0
            com.ironsource.sdk.l.d r1 = r0.b     // Catch:{ Exception -> 0x01fc }
            java.lang.String r1 = r1.b     // Catch:{ Exception -> 0x01fc }
            long r3 = com.ironsource.environment.h.a((java.lang.String) r1)     // Catch:{ Exception -> 0x01fc }
            r5 = 0
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 <= 0) goto L_0x01e8
            boolean r1 = com.ironsource.sdk.utils.SDKUtils.isExternalStorageAvailable()     // Catch:{ Exception -> 0x01fc }
            if (r1 == 0) goto L_0x01df
            android.content.Context r1 = r0.a     // Catch:{ Exception -> 0x01fc }
            boolean r1 = com.ironsource.environment.a.AnonymousClass1.b(r1)     // Catch:{ Exception -> 0x01fc }
            if (r1 == 0) goto L_0x01d7
            com.ironsource.sdk.h.a r1 = r0.c     // Catch:{ Exception -> 0x01fc }
            java.lang.String r3 = r8.getPath()     // Catch:{ Exception -> 0x01fc }
            com.ironsource.sdk.h.b$1 r4 = new com.ironsource.sdk.h.b$1     // Catch:{ Exception -> 0x01fc }
            r4.<init>(r15)     // Catch:{ Exception -> 0x01fc }
            if (r3 == 0) goto L_0x01b4
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.ironsource.sdk.l.f> r15 = r1.a     // Catch:{ Exception -> 0x01fc }
            r15.put(r3, r4)     // Catch:{ Exception -> 0x01fc }
        L_0x01b4:
            boolean r15 = r8.exists()     // Catch:{ Exception -> 0x01fc }
            if (r15 == 0) goto L_0x01cb
            android.os.Message r15 = new android.os.Message     // Catch:{ Exception -> 0x01fc }
            r15.<init>()     // Catch:{ Exception -> 0x01fc }
            r15.obj = r8     // Catch:{ Exception -> 0x01fc }
            r1 = 1015(0x3f7, float:1.422E-42)
            r15.what = r1     // Catch:{ Exception -> 0x01fc }
            com.ironsource.sdk.h.a r0 = r0.c     // Catch:{ Exception -> 0x01fc }
            r0.sendMessage(r15)     // Catch:{ Exception -> 0x01fc }
        L_0x01ca:
            return
        L_0x01cb:
            com.ironsource.sdk.l.d r7 = r0.b     // Catch:{ Exception -> 0x01fc }
            com.ironsource.sdk.h.a r12 = r0.c     // Catch:{ Exception -> 0x01fc }
            java.lang.Thread r15 = r7.a(r8, r9, r10, r11, r12)     // Catch:{ Exception -> 0x01fc }
            r15.start()     // Catch:{ Exception -> 0x01fc }
            goto L_0x0208
        L_0x01d7:
            java.lang.Exception r15 = new java.lang.Exception     // Catch:{ Exception -> 0x01fc }
            java.lang.String r0 = "no_network_connection"
            r15.<init>(r0)     // Catch:{ Exception -> 0x01fc }
            throw r15     // Catch:{ Exception -> 0x01fc }
        L_0x01df:
            java.lang.Exception r15 = new java.lang.Exception     // Catch:{ Exception -> 0x01fc }
            java.lang.String r0 = "storage_unavailable"
            r15.<init>(r0)     // Catch:{ Exception -> 0x01fc }
            throw r15     // Catch:{ Exception -> 0x01fc }
        L_0x01e8:
            java.lang.Exception r15 = new java.lang.Exception     // Catch:{ Exception -> 0x01fc }
            java.lang.String r0 = "no_disk_space"
            r15.<init>(r0)     // Catch:{ Exception -> 0x01fc }
            throw r15     // Catch:{ Exception -> 0x01fc }
        L_0x01f0:
            java.lang.Exception r15 = new java.lang.Exception     // Catch:{ Exception -> 0x01fc }
            r15.<init>(r6)     // Catch:{ Exception -> 0x01fc }
            throw r15     // Catch:{ Exception -> 0x01fc }
        L_0x01f6:
            java.lang.Exception r15 = new java.lang.Exception     // Catch:{ Exception -> 0x01fc }
            r15.<init>(r6)     // Catch:{ Exception -> 0x01fc }
            throw r15     // Catch:{ Exception -> 0x01fc }
        L_0x01fc:
            r15 = move-exception
            java.lang.String r15 = r15.getMessage()
            org.json.JSONObject r15 = a((com.ironsource.sdk.controller.o) r2, (java.lang.String) r15)
            r14.b(r2, r15)
        L_0x0208:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.sdk.controller.m.a(org.json.JSONObject, com.ironsource.sdk.controller.A$d$a):void");
    }
}

package com.mbridge.msdk.foundation.download.core;

class SynchronizeAvailableDirectorPath implements IDownloadTask {
    private int cacheDirectorPathType;
    private String cacheDirectoryPath;
    private String cacheDirectoryPathExternal;
    private String cacheDirectoryPathInternal;
    private DownloadRequest downloadRequest;

    public SynchronizeAvailableDirectorPath(DownloadRequest downloadRequest2) {
        this.downloadRequest = downloadRequest2;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:13|14|15) */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0045, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        r1 = r3.cacheDirectoryPathInternal;
        r3.cacheDirectoryPath = r1;
        r3.cacheDirectorPathType = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004d, code lost:
        r0 = r3.downloadRequest;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x005b, code lost:
        r3.downloadRequest.setCacheDirectoryPath(r3.cacheDirectoryPath);
        r3.downloadRequest.setCacheDirectorPathType(r3.cacheDirectorPathType);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0069, code lost:
        throw r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0047 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.mbridge.msdk.foundation.download.DownloadResponse run() {
        /*
            r3 = this;
            com.mbridge.msdk.foundation.download.core.DownloadRequest r0 = r3.downloadRequest
            java.lang.String r0 = r0.getDirectoryPathExternal()
            r3.cacheDirectoryPathExternal = r0
            com.mbridge.msdk.foundation.download.core.DownloadRequest r0 = r3.downloadRequest
            java.lang.String r0 = r0.getDirectoryPathInternal()
            r3.cacheDirectoryPathInternal = r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x006a
            r0 = 0
            java.lang.String r1 = r3.cacheDirectoryPathExternal     // Catch:{ Exception -> 0x0047 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x0047 }
            if (r1 == 0) goto L_0x0026
            java.lang.String r1 = r3.cacheDirectoryPathInternal     // Catch:{ Exception -> 0x0047 }
            r3.cacheDirectoryPath = r1     // Catch:{ Exception -> 0x0047 }
            r3.cacheDirectorPathType = r0     // Catch:{ Exception -> 0x0047 }
            goto L_0x0040
        L_0x0026:
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x0047 }
            r2 = 28
            if (r1 <= r2) goto L_0x0033
            java.lang.String r1 = r3.cacheDirectoryPathInternal     // Catch:{ Exception -> 0x0047 }
            r3.cacheDirectoryPath = r1     // Catch:{ Exception -> 0x0047 }
            r3.cacheDirectorPathType = r0     // Catch:{ Exception -> 0x0047 }
            goto L_0x0040
        L_0x0033:
            com.mbridge.msdk.foundation.download.core.GlobalComponent r1 = com.mbridge.msdk.foundation.download.core.GlobalComponent.getInstance()     // Catch:{ Exception -> 0x0047 }
            r1.getContext()     // Catch:{ Exception -> 0x0047 }
            java.lang.String r1 = r3.cacheDirectoryPathInternal     // Catch:{ Exception -> 0x0047 }
            r3.cacheDirectoryPath = r1     // Catch:{ Exception -> 0x0047 }
            r3.cacheDirectorPathType = r0     // Catch:{ Exception -> 0x0047 }
        L_0x0040:
            com.mbridge.msdk.foundation.download.core.DownloadRequest r0 = r3.downloadRequest
            java.lang.String r1 = r3.cacheDirectoryPath
            goto L_0x004f
        L_0x0045:
            r0 = move-exception
            goto L_0x005b
        L_0x0047:
            java.lang.String r1 = r3.cacheDirectoryPathInternal     // Catch:{ all -> 0x0045 }
            r3.cacheDirectoryPath = r1     // Catch:{ all -> 0x0045 }
            r3.cacheDirectorPathType = r0     // Catch:{ all -> 0x0045 }
            com.mbridge.msdk.foundation.download.core.DownloadRequest r0 = r3.downloadRequest
        L_0x004f:
            r0.setCacheDirectoryPath(r1)
            com.mbridge.msdk.foundation.download.core.DownloadRequest r0 = r3.downloadRequest
            int r1 = r3.cacheDirectorPathType
            r0.setCacheDirectorPathType(r1)
            r0 = 0
            return r0
        L_0x005b:
            com.mbridge.msdk.foundation.download.core.DownloadRequest r1 = r3.downloadRequest
            java.lang.String r2 = r3.cacheDirectoryPath
            r1.setCacheDirectoryPath(r2)
            com.mbridge.msdk.foundation.download.core.DownloadRequest r1 = r3.downloadRequest
            int r2 = r3.cacheDirectorPathType
            r1.setCacheDirectorPathType(r2)
            throw r0
        L_0x006a:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.String r1 = "must have cacheDirectoryPathInternal"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.download.core.SynchronizeAvailableDirectorPath.run():com.mbridge.msdk.foundation.download.DownloadResponse");
    }

    public static IDownloadTask create(DownloadRequest downloadRequest2) {
        return new SynchronizeAvailableDirectorPath(downloadRequest2);
    }
}

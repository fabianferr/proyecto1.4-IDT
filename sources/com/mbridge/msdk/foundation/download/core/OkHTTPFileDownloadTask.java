package com.mbridge.msdk.foundation.download.core;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.download.DownloadMessage;
import com.mbridge.msdk.foundation.download.DownloadProgress;
import com.mbridge.msdk.foundation.download.DownloadResponse;
import com.mbridge.msdk.foundation.download.DownloadStatus;
import com.mbridge.msdk.foundation.download.core.DownloaderReporter;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import com.mbridge.msdk.foundation.download.database.IDatabaseHelper;
import com.mbridge.msdk.foundation.download.resource.MBResourceManager;
import com.mbridge.msdk.foundation.download.resource.stream.DownloadFileOutputStream;
import com.mbridge.msdk.foundation.download.utils.Objects;
import com.mbridge.msdk.foundation.download.utils.Utils;
import com.mbridge.msdk.foundation.tools.ac;
import com.mbridge.msdk.thrid.okhttp.Response;
import com.mbridge.msdk.thrid.okhttp.ResponseBody;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

class OkHTTPFileDownloadTask implements IDownloadTask {
    private static final String CLOSE = "close";
    private static final String CONNECTION = "Connection";
    private static final String FORMAT_RANGE = "bytes=%d-";
    private static final String RESPONSE_BODY_IS_NULL = "response body is null";
    private static final String RESPONSE_CODE = "responseCode ";
    private static final String RESPONSE_CONTENT_LENGTH_IS_NULL = "response content length is null";
    private static final String RESPONSE_INPUTSTREAM_IS_NULL = "response inputStream is null";
    private static final String RESPONSE_IS_NULL = "response is null";
    private final IDatabaseHelper _databaseHelper;
    private volatile DownloadMessage _downloadMessage;
    private DownloadModel _downloadModel;
    private final DownloadRequest _downloadRequest;
    private DownloadResponse _downloadResponse;
    private DownloaderReporter.Builder _downloaderReporter;
    private String _etag = "";
    private InputStream _inputStream;
    private DownloadFileOutputStream _outputStream;
    private ResponseBody _responseBody;

    private OkHTTPFileDownloadTask(DownloadRequest downloadRequest, DownloadModel downloadModel, IDatabaseHelper iDatabaseHelper, DownloadMessage downloadMessage, DownloaderReporter.Builder builder) {
        this._downloadRequest = downloadRequest;
        this._downloadModel = downloadModel;
        this._databaseHelper = iDatabaseHelper;
        this._downloadMessage = downloadMessage;
        this._downloaderReporter = builder;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x01d4, code lost:
        if (r3.isCanceled() == false) goto L_0x0222;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0220, code lost:
        if (r3.isCanceled() != false) goto L_0x0225;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0222, code lost:
        r3.cancel();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0225, code lost:
        reportDownloadMessage();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x022a, code lost:
        return r13._downloadResponse;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.mbridge.msdk.foundation.download.DownloadResponse run() {
        /*
            r13 = this;
            java.lang.String r0 = "responseCode "
            com.mbridge.msdk.foundation.download.DownloadResponse r1 = new com.mbridge.msdk.foundation.download.DownloadResponse
            r1.<init>()
            r13._downloadResponse = r1
            com.mbridge.msdk.foundation.download.core.DownloadRequest r1 = r13._downloadRequest
            com.mbridge.msdk.foundation.download.DownloadStatus r1 = r1.getStatus()
            com.mbridge.msdk.foundation.download.DownloadStatus r2 = com.mbridge.msdk.foundation.download.DownloadStatus.CANCELLED
            r3 = 1
            if (r1 != r2) goto L_0x001c
            com.mbridge.msdk.foundation.download.DownloadResponse r0 = r13._downloadResponse
            r0.setCancelled(r3)
            com.mbridge.msdk.foundation.download.DownloadResponse r0 = r13._downloadResponse
            return r0
        L_0x001c:
            com.mbridge.msdk.foundation.download.core.DownloadRequest r1 = r13._downloadRequest
            long r1 = r1.getTotalBytes()
            com.mbridge.msdk.foundation.download.core.DownloadRequest r4 = r13._downloadRequest
            long r4 = r4.getDownloadedBytes()
            int r6 = com.mbridge.msdk.foundation.download.utils.Utils.getDownloadRate(r1, r4)
            com.mbridge.msdk.foundation.download.core.DownloaderReporter$Builder r7 = r13._downloaderReporter
            java.lang.String r8 = "dcr"
            java.lang.String r6 = java.lang.String.valueOf(r6)
            r7.add(r8, r6)
            com.mbridge.msdk.foundation.download.core.DownloaderReporter$Builder r6 = r13._downloaderReporter
            java.lang.String r7 = "ddb"
            java.lang.String r8 = java.lang.String.valueOf(r4)
            r6.add(r7, r8)
            com.mbridge.msdk.foundation.download.core.DownloaderReporter$Builder r6 = r13._downloaderReporter
            java.lang.String r7 = "dtb"
            java.lang.String r8 = java.lang.String.valueOf(r1)
            r6.add(r7, r8)
            r6 = 0
            int r8 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x0076
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x0076
            int r6 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r6 != 0) goto L_0x0076
            com.mbridge.msdk.foundation.download.core.DownloaderReporter$Builder r0 = r13._downloaderReporter
            java.lang.String r1 = "de"
            java.lang.String r2 = "t=c"
            r0.add(r1, r2)
            com.mbridge.msdk.foundation.download.core.DownloaderReporter$Builder r0 = r13._downloaderReporter
            com.mbridge.msdk.foundation.download.core.DownloaderReporter r0 = r0.build()
            r0.report()
            com.mbridge.msdk.foundation.download.DownloadResponse r0 = r13._downloadResponse
            r0.setSuccessful(r3)
            com.mbridge.msdk.foundation.download.DownloadResponse r0 = r13._downloadResponse
            return r0
        L_0x0076:
            com.mbridge.msdk.foundation.download.DownloadMessage r1 = r13._downloadMessage
            java.lang.String r1 = r1.getSaveFileName()
            com.mbridge.msdk.foundation.download.core.DownloadRequest r2 = r13._downloadRequest
            java.lang.String r2 = r2.getCacheDirectoryPath()
            com.mbridge.msdk.foundation.download.core.DownloadRequest r6 = r13._downloadRequest
            java.lang.String r12 = r6.getDownloadId()
            com.mbridge.msdk.foundation.download.DownloadMessage r6 = r13._downloadMessage
            java.lang.String r6 = r6.getDownloadUrl()
            com.mbridge.msdk.foundation.download.core.GlobalComponent r7 = com.mbridge.msdk.foundation.download.core.GlobalComponent.getInstance()
            com.mbridge.msdk.thrid.okhttp.OkHttpClient r7 = r7.getOkHttpClient()
            com.mbridge.msdk.thrid.okhttp.OkHttpClient$Builder r7 = r7.newBuilder()
            com.mbridge.msdk.foundation.download.core.DownloadRequest r8 = r13._downloadRequest
            long r8 = r8.getConnectTimeout()
            java.util.concurrent.TimeUnit r10 = java.util.concurrent.TimeUnit.MILLISECONDS
            com.mbridge.msdk.thrid.okhttp.OkHttpClient$Builder r7 = r7.connectTimeout(r8, r10)
            com.mbridge.msdk.foundation.download.core.DownloadRequest r8 = r13._downloadRequest
            long r8 = r8.getReadTimeout()
            java.util.concurrent.TimeUnit r10 = java.util.concurrent.TimeUnit.MILLISECONDS
            com.mbridge.msdk.thrid.okhttp.OkHttpClient$Builder r7 = r7.readTimeout(r8, r10)
            com.mbridge.msdk.foundation.download.core.DownloadRequest r8 = r13._downloadRequest
            long r8 = r8.getWriteTimeout()
            java.util.concurrent.TimeUnit r10 = java.util.concurrent.TimeUnit.MILLISECONDS
            com.mbridge.msdk.thrid.okhttp.OkHttpClient$Builder r7 = r7.writeTimeout(r8, r10)
            com.mbridge.msdk.foundation.download.core.DownloadRequest r8 = r13._downloadRequest
            long r8 = r8.getTimeout()
            java.util.concurrent.TimeUnit r10 = java.util.concurrent.TimeUnit.MILLISECONDS
            com.mbridge.msdk.thrid.okhttp.OkHttpClient$Builder r7 = r7.callTimeout(r8, r10)
            com.mbridge.msdk.thrid.okhttp.OkHttpClient$Builder r7 = r7.retryOnConnectionFailure(r3)
            com.mbridge.msdk.thrid.okhttp.OkHttpClient r7 = r7.build()
            com.mbridge.msdk.thrid.okhttp.CacheControl$Builder r8 = new com.mbridge.msdk.thrid.okhttp.CacheControl$Builder
            r8.<init>()
            com.mbridge.msdk.thrid.okhttp.CacheControl$Builder r8 = r8.noCache()
            com.mbridge.msdk.thrid.okhttp.CacheControl r8 = r8.build()
            java.util.Locale r9 = java.util.Locale.ENGLISH
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r10 = 0
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            r3[r10] = r4
            java.lang.String r4 = "bytes=%d-"
            java.lang.String r3 = java.lang.String.format(r9, r4, r3)
            com.mbridge.msdk.thrid.okhttp.Request$Builder r4 = new com.mbridge.msdk.thrid.okhttp.Request$Builder
            r4.<init>()
            com.mbridge.msdk.thrid.okhttp.Request$Builder r4 = r4.url((java.lang.String) r6)
            com.mbridge.msdk.thrid.okhttp.Request$Builder r4 = r4.cacheControl(r8)
            java.lang.String r5 = "Connection"
            java.lang.String r8 = "close"
            com.mbridge.msdk.thrid.okhttp.Request$Builder r4 = r4.addHeader(r5, r8)
            java.lang.String r5 = "Range"
            com.mbridge.msdk.thrid.okhttp.Request$Builder r3 = r4.addHeader(r5, r3)
            java.lang.String r4 = "User-Agent"
            com.mbridge.msdk.thrid.okhttp.Request$Builder r3 = r3.removeHeader(r4)
            java.lang.String r5 = "okhttp/3.12.13/MAL_16.5.91"
            com.mbridge.msdk.thrid.okhttp.Request$Builder r3 = r3.addHeader(r4, r5)
            com.mbridge.msdk.thrid.okhttp.Request r3 = r3.build()
            com.mbridge.msdk.foundation.download.core.DownloaderReporter$Builder r4 = r13._downloaderReporter
            com.mbridge.msdk.thrid.okhttp.HttpUrl r5 = r3.url()
            java.lang.String r5 = r5.host()
            java.lang.String r8 = "ht"
            r4.add(r8, r5)
            com.mbridge.msdk.foundation.download.core.DownloaderReporter$Builder r4 = r13._downloaderReporter
            java.lang.String r5 = "url"
            r4.add(r5, r6)
            com.mbridge.msdk.thrid.okhttp.Call r3 = r7.newCall(r3)
            r4 = 0
            com.mbridge.msdk.thrid.okhttp.Response r4 = r3.execute()     // Catch:{ Exception -> 0x0206 }
            boolean r5 = com.mbridge.msdk.foundation.download.utils.Objects.isNull(r4)     // Catch:{ Exception -> 0x0206 }
            if (r5 != 0) goto L_0x01d7
            com.mbridge.msdk.thrid.okhttp.ResponseBody r5 = r4.body()     // Catch:{ Exception -> 0x0206 }
            boolean r5 = com.mbridge.msdk.foundation.download.utils.Objects.isNull(r5)     // Catch:{ Exception -> 0x0206 }
            if (r5 == 0) goto L_0x014d
            goto L_0x01d7
        L_0x014d:
            int r11 = r4.code()     // Catch:{ Exception -> 0x0206 }
            com.mbridge.msdk.foundation.download.core.DownloaderReporter$Builder r5 = r13._downloaderReporter     // Catch:{ Exception -> 0x0206 }
            java.lang.String r6 = "drc"
            java.lang.String r7 = java.lang.String.valueOf(r11)     // Catch:{ Exception -> 0x0206 }
            r5.add(r6, r7)     // Catch:{ Exception -> 0x0206 }
            boolean r5 = r4.isSuccessful()     // Catch:{ Exception -> 0x0206 }
            if (r5 != 0) goto L_0x01a9
            com.mbridge.msdk.foundation.download.DownloadResponse r5 = r13._downloadResponse     // Catch:{ Exception -> 0x0206 }
            java.io.IOException r6 = new java.io.IOException     // Catch:{ Exception -> 0x0206 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0206 }
            r7.<init>(r0)     // Catch:{ Exception -> 0x0206 }
            r7.append(r11)     // Catch:{ Exception -> 0x0206 }
            java.lang.String r0 = "\n"
            r7.append(r0)     // Catch:{ Exception -> 0x0206 }
            com.mbridge.msdk.thrid.okhttp.ResponseBody r0 = r4.body()     // Catch:{ Exception -> 0x0206 }
            java.lang.String r0 = r0.string()     // Catch:{ Exception -> 0x0206 }
            r7.append(r0)     // Catch:{ Exception -> 0x0206 }
            java.lang.String r0 = r7.toString()     // Catch:{ Exception -> 0x0206 }
            r6.<init>(r0)     // Catch:{ Exception -> 0x0206 }
            r5.setError((java.lang.Exception) r6)     // Catch:{ Exception -> 0x0206 }
            com.mbridge.msdk.foundation.download.DownloadResponse r0 = r13._downloadResponse     // Catch:{ Exception -> 0x0206 }
            java.io.InputStream r1 = r13._inputStream
            com.mbridge.msdk.foundation.download.utils.Objects.closeInputStream(r1)
            com.mbridge.msdk.foundation.download.resource.stream.DownloadFileOutputStream r1 = r13._outputStream
            com.mbridge.msdk.foundation.download.utils.Objects.closeOutputStream(r1)
            com.mbridge.msdk.foundation.download.utils.Objects.closeResponse(r4)
            com.mbridge.msdk.thrid.okhttp.ResponseBody r1 = r13._responseBody
            com.mbridge.msdk.foundation.download.utils.Objects.closeResponseBody(r1)
            boolean r1 = r3.isCanceled()
            if (r1 != 0) goto L_0x01a5
            r3.cancel()
        L_0x01a5:
            r13.reportDownloadMessage()
            return r0
        L_0x01a9:
            java.lang.String r0 = "ETag"
            java.lang.String r5 = ""
            java.lang.String r0 = r4.header(r0, r5)     // Catch:{ Exception -> 0x0206 }
            r13._etag = r0     // Catch:{ Exception -> 0x0206 }
            r6 = r13
            r7 = r1
            r8 = r2
            r9 = r12
            r10 = r4
            com.mbridge.msdk.foundation.download.DownloadResponse r0 = r6.handlerRequestSuccessful(r7, r8, r9, r10, r11)     // Catch:{ Exception -> 0x0206 }
            r13._downloadResponse = r0     // Catch:{ Exception -> 0x0206 }
            java.io.InputStream r0 = r13._inputStream
            com.mbridge.msdk.foundation.download.utils.Objects.closeInputStream(r0)
            com.mbridge.msdk.foundation.download.resource.stream.DownloadFileOutputStream r0 = r13._outputStream
            com.mbridge.msdk.foundation.download.utils.Objects.closeOutputStream(r0)
            com.mbridge.msdk.foundation.download.utils.Objects.closeResponse(r4)
            com.mbridge.msdk.thrid.okhttp.ResponseBody r0 = r13._responseBody
            com.mbridge.msdk.foundation.download.utils.Objects.closeResponseBody(r0)
            boolean r0 = r3.isCanceled()
            if (r0 != 0) goto L_0x0225
            goto L_0x0222
        L_0x01d7:
            com.mbridge.msdk.foundation.download.DownloadResponse r0 = r13._downloadResponse     // Catch:{ Exception -> 0x0206 }
            java.io.IOException r5 = new java.io.IOException     // Catch:{ Exception -> 0x0206 }
            java.lang.String r6 = "response is null"
            r5.<init>(r6)     // Catch:{ Exception -> 0x0206 }
            r0.setError((java.lang.Exception) r5)     // Catch:{ Exception -> 0x0206 }
            com.mbridge.msdk.foundation.download.DownloadResponse r0 = r13._downloadResponse     // Catch:{ Exception -> 0x0206 }
            java.io.InputStream r1 = r13._inputStream
            com.mbridge.msdk.foundation.download.utils.Objects.closeInputStream(r1)
            com.mbridge.msdk.foundation.download.resource.stream.DownloadFileOutputStream r1 = r13._outputStream
            com.mbridge.msdk.foundation.download.utils.Objects.closeOutputStream(r1)
            com.mbridge.msdk.foundation.download.utils.Objects.closeResponse(r4)
            com.mbridge.msdk.thrid.okhttp.ResponseBody r1 = r13._responseBody
            com.mbridge.msdk.foundation.download.utils.Objects.closeResponseBody(r1)
            boolean r1 = r3.isCanceled()
            if (r1 != 0) goto L_0x0200
            r3.cancel()
        L_0x0200:
            r13.reportDownloadMessage()
            return r0
        L_0x0204:
            r0 = move-exception
            goto L_0x022b
        L_0x0206:
            r0 = move-exception
            r13.handlerException(r1, r2, r12, r0)     // Catch:{ all -> 0x0204 }
            java.io.InputStream r0 = r13._inputStream
            com.mbridge.msdk.foundation.download.utils.Objects.closeInputStream(r0)
            com.mbridge.msdk.foundation.download.resource.stream.DownloadFileOutputStream r0 = r13._outputStream
            com.mbridge.msdk.foundation.download.utils.Objects.closeOutputStream(r0)
            com.mbridge.msdk.foundation.download.utils.Objects.closeResponse(r4)
            com.mbridge.msdk.thrid.okhttp.ResponseBody r0 = r13._responseBody
            com.mbridge.msdk.foundation.download.utils.Objects.closeResponseBody(r0)
            boolean r0 = r3.isCanceled()
            if (r0 != 0) goto L_0x0225
        L_0x0222:
            r3.cancel()
        L_0x0225:
            r13.reportDownloadMessage()
            com.mbridge.msdk.foundation.download.DownloadResponse r0 = r13._downloadResponse
            return r0
        L_0x022b:
            java.io.InputStream r1 = r13._inputStream
            com.mbridge.msdk.foundation.download.utils.Objects.closeInputStream(r1)
            com.mbridge.msdk.foundation.download.resource.stream.DownloadFileOutputStream r1 = r13._outputStream
            com.mbridge.msdk.foundation.download.utils.Objects.closeOutputStream(r1)
            com.mbridge.msdk.foundation.download.utils.Objects.closeResponse(r4)
            com.mbridge.msdk.thrid.okhttp.ResponseBody r1 = r13._responseBody
            com.mbridge.msdk.foundation.download.utils.Objects.closeResponseBody(r1)
            boolean r1 = r3.isCanceled()
            if (r1 != 0) goto L_0x0246
            r3.cancel()
        L_0x0246:
            r13.reportDownloadMessage()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.download.core.OkHTTPFileDownloadTask.run():com.mbridge.msdk.foundation.download.DownloadResponse");
    }

    private void reportDownloadMessage() {
        boolean isSuccessful = this._downloadResponse.isSuccessful();
        this._downloaderReporter.add(DownloadCommon.DOWNLOAD_REPORT_SUCCESS, Boolean.toString(isSuccessful));
        boolean isCancelled = this._downloadResponse.isCancelled();
        this._downloaderReporter.add(DownloadCommon.DOWNLOAD_REPORT_CANCEL, Boolean.toString(isCancelled));
        this._downloaderReporter.add(DownloadCommon.DOWNLOAD_REPORT_DOWNLOAD_RATE, String.valueOf(Utils.getDownloadRate(this._downloadRequest.getTotalBytes(), this._downloadRequest.getDownloadedBytes())));
        if (!isSuccessful && !isCancelled) {
            this._downloaderReporter.add(DownloadCommon.DOWNLOAD_REPORT_REASON, this._downloadResponse.getErrorMessage());
        }
        this._downloaderReporter.build().report();
    }

    private DownloadResponse handlerRequestSuccessful(String str, String str2, String str3, Response response, int i) throws IOException, IllegalAccessException {
        String str4 = str2;
        String str5 = str3;
        int i2 = i;
        DownloadResponse downloadResponse = new DownloadResponse();
        boolean z = true;
        boolean z2 = !isSupportResume(i2, this._downloadModel);
        if (response == null || this._downloadRequest == null || i2 != 206 || response.body() == null || this._downloadRequest.getTotalBytes() <= 0 || response.body().contentLength() == this._downloadRequest.getTotalBytes() - this._downloadRequest.getDownloadedBytes()) {
            z = false;
        }
        if (z2 && z) {
            this._downloadRequest.setDownloadedBytes(0);
            this._downloadRequest.setTotalBytes(0);
            if (Objects.isNotNull(this._databaseHelper)) {
                this._databaseHelper.remove(str5, str4);
            }
            this._downloadModel = null;
            MBResourceManager.getInstance().deleteFile(new File(this._downloadRequest.getCacheDirectoryPath() + this._downloadMessage.getSaveFileName()));
        }
        ResponseBody body = response.body();
        this._responseBody = body;
        if (Objects.isNull(body)) {
            downloadResponse.setError((Exception) new IOException(RESPONSE_BODY_IS_NULL));
            this._downloadRequest.setTotalBytes(0);
            this._downloadRequest.setDownloadedBytes(0);
            return downloadResponse;
        }
        long contentLength = this._responseBody.contentLength();
        if (contentLength <= 0) {
            downloadResponse.setError((Exception) new IOException(RESPONSE_CONTENT_LENGTH_IS_NULL));
            return downloadResponse;
        }
        if (this._downloadRequest.getTotalBytes() == 0) {
            this._downloadRequest.setTotalBytes(contentLength);
        }
        InputStream byteStream = this._responseBody.byteStream();
        this._inputStream = byteStream;
        if (Objects.isNull(byteStream)) {
            downloadResponse.setError((Exception) new IOException(RESPONSE_INPUTSTREAM_IS_NULL));
            return downloadResponse;
        }
        return handleInputStream(str, str4, str5, this._etag);
    }

    private DownloadResponse handleInputStream(String str, String str2, String str3, String str4) throws IOException, IllegalAccessException {
        DownloadResponse downloadResponse;
        String str5;
        String str6 = str2;
        DownloadResponse downloadResponse2 = new DownloadResponse();
        if (Objects.isNull(this._downloadModel)) {
            DownloadModel create = DownloadModel.create(this._downloadRequest.getDownloadId(), this._downloadMessage.getDownloadUrl(), this._downloadMessage.getResourceUrl(), str4, str2, this._downloadMessage.getSaveFileName(), this._downloadRequest.getTotalBytes(), 0, this._downloadMessage.getDownloadRate(), 1, this._downloadMessage.getDownloadResourceType());
            this._downloadModel = create;
            this._databaseHelper.insert(create);
        } else {
            DownloadModel create2 = DownloadModel.create(this._downloadModel.getDownloadId(), this._downloadModel.getDownloadUrl(), this._downloadMessage.getResourceUrl(), this._downloadModel.getEtag(), this._downloadModel.getSaveDirectorPath(), this._downloadModel.getSaveFileName(), this._downloadRequest.getTotalBytes(), this._downloadModel.getDownloadedBytes(), this._downloadMessage.getDownloadRate(), this._downloadModel.getUsageCounter() + 1, this._downloadMessage.getDownloadResourceType());
            this._downloadModel = create2;
            this._databaseHelper.update(create2, str6);
        }
        DownloadFileOutputStream downloadFileOutputStream = MBResourceManager.getInstance().getDownloadFileOutputStream(new File(str6, str));
        this._outputStream = downloadFileOutputStream;
        downloadFileOutputStream.seek(this._downloadRequest.getDownloadedBytes());
        byte[] bArr = new byte[GlobalComponent.getInstance().getByteBufferSize()];
        while (true) {
            int read = this._inputStream.read(bArr);
            if (read == -1) {
                downloadResponse = downloadResponse2;
                str5 = str6;
                break;
            }
            this._outputStream.write(bArr, 0, read);
            DownloadRequest downloadRequest = this._downloadRequest;
            downloadRequest.setDownloadedBytes(downloadRequest.getDownloadedBytes() + ((long) read));
            this._outputStream.flushAndSync();
            int downloadRate = Utils.getDownloadRate(this._downloadRequest.getTotalBytes(), this._downloadRequest.getDownloadedBytes());
            downloadResponse = downloadResponse2;
            str5 = str6;
            sendProgress(this._downloadRequest, this._downloadMessage, this._downloadRequest.getDownloadedBytes(), this._downloadRequest.getTotalBytes(), downloadRate);
            if (this._downloadMessage.getDownloadRate() != 100 && downloadRate >= this._downloadMessage.getDownloadRate()) {
                break;
            } else if (this._downloadRequest.getStatus() == DownloadStatus.CANCELLED) {
                downloadResponse.setCancelled(true);
                break;
            } else {
                str6 = str5;
                downloadResponse2 = downloadResponse;
            }
        }
        IDatabaseHelper databaseHelper = GlobalComponent.getInstance().getDatabaseHelper();
        String downloadUrl = this._downloadMessage.getDownloadUrl();
        String resourceUrl = this._downloadMessage.getResourceUrl();
        String saveFileName = this._downloadMessage.getSaveFileName();
        String str7 = saveFileName;
        DownloadResponse downloadResponse3 = downloadResponse;
        String str8 = str3;
        databaseHelper.updateProgress(str8, str5, DownloadModel.create(str3, downloadUrl, resourceUrl, str4, str2, str7, this._downloadRequest.getTotalBytes(), this._downloadRequest.getDownloadedBytes(), this._downloadMessage.getDownloadRate(), this._downloadModel.getUsageCounter(), this._downloadMessage.getDownloadResourceType()));
        if (!downloadResponse3.isCancelled()) {
            downloadResponse3.setSuccessful(true);
        }
        return downloadResponse3;
    }

    private void handlerException(String str, String str2, String str3, Exception exc) {
        try {
            if (Objects.isNotNull(this._databaseHelper) && Objects.isNotNull(this._downloadRequest)) {
                if (!ac.a().a("r_f_s_d_e", true)) {
                    this._databaseHelper.remove(str3, str2);
                    MBResourceManager instance = MBResourceManager.getInstance();
                    instance.deleteFile(new File(this._downloadRequest.getCacheDirectoryPath() + this._downloadMessage.getSaveFileName()));
                }
                this._downloadRequest.setDownloadedBytes(0);
                this._downloadRequest.setTotalBytes(0);
            }
        } catch (Exception e) {
            GlobalComponent.getInstance().getLogger().log(IDownloadTask.TAG, e.getMessage());
        }
        this._downloadResponse.setError(exc);
    }

    public static IDownloadTask create(DownloadRequest downloadRequest, DownloadModel downloadModel, IDatabaseHelper iDatabaseHelper, DownloadMessage downloadMessage, DownloaderReporter.Builder builder) {
        if (Objects.isNull(builder)) {
            builder = new DownloaderReporter.Builder(DownloadCommon.DOWNLOAD_REPORT_KEY);
        }
        return new OkHTTPFileDownloadTask(downloadRequest, downloadModel, iDatabaseHelper, downloadMessage, builder);
    }

    private boolean isSupportResume(int i, DownloadModel downloadModel) {
        return i == 206 && !TextUtils.isEmpty(this._etag) && (downloadModel == null || TextUtils.equals(this._etag, downloadModel.getEtag()));
    }

    private void sendProgress(DownloadRequest downloadRequest, DownloadMessage downloadMessage, long j, long j2, int i) {
        if (downloadRequest.getStatus() != DownloadStatus.CANCELLED) {
            downloadRequest.handlerProcessEvent(downloadMessage, new DownloadProgress(j, j2, i));
        }
    }
}

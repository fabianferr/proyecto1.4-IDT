package com.mbridge.msdk.foundation.download.core;

import com.mbridge.msdk.foundation.download.Command;
import com.mbridge.msdk.foundation.download.DownloadMessage;
import com.mbridge.msdk.foundation.download.DownloadResponse;
import com.mbridge.msdk.foundation.download.DownloadStatus;
import com.mbridge.msdk.foundation.download.core.DownloaderReporter;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import com.mbridge.msdk.foundation.download.database.IDatabaseHelper;
import com.mbridge.msdk.foundation.download.resource.MBResourceManager;
import com.mbridge.msdk.foundation.download.resource.stream.DownloadFileOutputStream;
import com.mbridge.msdk.foundation.download.utils.Objects;
import com.mbridge.msdk.foundation.download.utils.Utils;
import com.mbridge.msdk.foundation.same.net.a.a;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.ac;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Locale;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import org.chromium.net.CronetEngine;
import org.chromium.net.UrlRequest;

public class CronetDownloadTask implements IDownloadTask {
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
    private BlockingQueue<DownloadResponse> callbackResults = new ArrayBlockingQueue(2, true);

    private CronetDownloadTask(DownloadRequest downloadRequest, DownloadModel downloadModel, IDatabaseHelper iDatabaseHelper, DownloadMessage downloadMessage, DownloaderReporter.Builder builder) {
        this._downloadRequest = downloadRequest;
        this._downloadModel = downloadModel;
        this._databaseHelper = iDatabaseHelper;
        this._downloadMessage = downloadMessage;
        this._downloaderReporter = builder;
    }

    public DownloadResponse run() {
        this._downloadResponse = new DownloadResponse();
        if (this._downloadRequest.getStatus() == DownloadStatus.CANCELLED) {
            this._downloadResponse.setCancelled(true);
            return this._downloadResponse;
        }
        long totalBytes = this._downloadRequest.getTotalBytes();
        long downloadedBytes = this._downloadRequest.getDownloadedBytes();
        this._downloaderReporter.add(DownloadCommon.DOWNLOAD_REPORT_DOWNLOAD_CURRENT_RATE, String.valueOf(Utils.getDownloadRate(totalBytes, downloadedBytes)));
        this._downloaderReporter.add(DownloadCommon.DOWNLOAD_REPORT_DOWNLOAD_DOWNLOAD_BYTES, String.valueOf(downloadedBytes));
        this._downloaderReporter.add(DownloadCommon.DOWNLOAD_REPORT_DOWNLOAD_TOTAL_BYTES, String.valueOf(totalBytes));
        if (totalBytes == 0 || downloadedBytes == 0 || totalBytes != downloadedBytes) {
            String saveFileName = this._downloadMessage.getSaveFileName();
            String cacheDirectoryPath = this._downloadRequest.getCacheDirectoryPath();
            String downloadId = this._downloadRequest.getDownloadId();
            String downloadUrl = this._downloadMessage.getDownloadUrl();
            String format = String.format(Locale.ENGLISH, FORMAT_RANGE, new Object[]{Long.valueOf(downloadedBytes)});
            try {
                CronetEngine b = a.a().b();
                CronetDownloadCallback cronetDownloadCallback = new CronetDownloadCallback(this._downloadResponse, this._downloadRequest, this._downloadMessage, this._databaseHelper, this._downloadModel, this._downloaderReporter);
                cronetDownloadCallback.setBlockingQueue(this.callbackResults);
                UrlRequest.Builder allowDirectExecutor = b.newUrlRequestBuilder(downloadUrl, cronetDownloadCallback, a.a().c()).setPriority(getPriority(this._downloadRequest)).setHttpMethod("GET").disableCache().addHeader("User-Agent", Command.DEFAULT_USER_AGENT).addHeader("Range", format).allowDirectExecutor();
                try {
                    this._downloaderReporter.add(DownloadCommon.DOWNLOAD_REPORT_HOST, URI.create(downloadUrl).getHost());
                } catch (Exception unused) {
                    this._downloaderReporter.add(DownloadCommon.DOWNLOAD_REPORT_HOST, "");
                }
                this._downloaderReporter.add("url", downloadUrl);
                long j = 30000;
                long writeTimeout = this._downloadRequest.getWriteTimeout() == 0 ? 30000 : this._downloadRequest.getWriteTimeout();
                if (this._downloadRequest.getReadTimeout() != 0) {
                    j = this._downloadRequest.getReadTimeout();
                }
                UrlRequest build = allowDirectExecutor.build();
                build.start();
                try {
                    DownloadResponse poll = this.callbackResults.poll(writeTimeout, TimeUnit.MILLISECONDS);
                    if (poll != null) {
                        if (poll.isResponseStart()) {
                            poll = this.callbackResults.poll(j, TimeUnit.MILLISECONDS);
                        }
                        if (poll.isSuccessful()) {
                            this._downloadResponse = poll;
                        }
                        if (poll.isFailed()) {
                            throw new IOException(this._downloadResponse.getErrorMessage());
                        } else if (this._downloadResponse != null) {
                            Objects.closeInputStream(this._inputStream);
                            Objects.closeOutputStream(this._outputStream);
                            reportDownloadMessage();
                            return this._downloadResponse;
                        } else {
                            cancelRequest(build, this._downloadRequest);
                            this.callbackResults.clear();
                            aa.d(IDownloadTask.TAG, "response cancel because response timeout");
                            throw new IOException("Response timeout.");
                        }
                    } else {
                        cancelRequest(build, this._downloadRequest);
                        this.callbackResults.clear();
                        aa.d(IDownloadTask.TAG, "Request cancel because request timeout");
                        throw new IOException("request timeout.");
                    }
                } catch (Exception e) {
                    handlerException(saveFileName, cacheDirectoryPath, downloadId, e);
                } catch (Throwable th) {
                    Objects.closeInputStream(this._inputStream);
                    Objects.closeOutputStream(this._outputStream);
                    reportDownloadMessage();
                    throw th;
                }
            } catch (Exception e2) {
                throw e2;
            }
        } else {
            this._downloaderReporter.add(DownloadCommon.DOWNLOAD_REPORT_DOWNLOAD_ERROR, DownloadCommon.DOWNLOAD_REPORT_DOWNLOAD_ERROR_VALUE);
            this._downloaderReporter.build().report();
            this._downloadResponse.setSuccessful(true);
            return this._downloadResponse;
        }
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
        return new CronetDownloadTask(downloadRequest, downloadModel, iDatabaseHelper, downloadMessage, builder);
    }

    /* renamed from: com.mbridge.msdk.foundation.download.core.CronetDownloadTask$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$mbridge$msdk$foundation$download$DownloadPriority;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.mbridge.msdk.foundation.download.DownloadPriority[] r0 = com.mbridge.msdk.foundation.download.DownloadPriority.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$mbridge$msdk$foundation$download$DownloadPriority = r0
                com.mbridge.msdk.foundation.download.DownloadPriority r1 = com.mbridge.msdk.foundation.download.DownloadPriority.LOW     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$mbridge$msdk$foundation$download$DownloadPriority     // Catch:{ NoSuchFieldError -> 0x001d }
                com.mbridge.msdk.foundation.download.DownloadPriority r1 = com.mbridge.msdk.foundation.download.DownloadPriority.HIGH     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$mbridge$msdk$foundation$download$DownloadPriority     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.mbridge.msdk.foundation.download.DownloadPriority r1 = com.mbridge.msdk.foundation.download.DownloadPriority.IMMEDIATE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.download.core.CronetDownloadTask.AnonymousClass1.<clinit>():void");
        }
    }

    private int getPriority(DownloadRequest<?> downloadRequest) {
        int i = AnonymousClass1.$SwitchMap$com$mbridge$msdk$foundation$download$DownloadPriority[downloadRequest.getDownloadPriority().ordinal()];
        if (i != 1) {
            return (i == 2 || i == 3) ? 4 : 3;
        }
        return 2;
    }

    private void cancelRequest(UrlRequest urlRequest, DownloadRequest<?> downloadRequest) {
        if (urlRequest != null) {
            urlRequest.cancel();
        }
        if (downloadRequest != null) {
            downloadRequest.cancel(this._downloadMessage);
        }
    }
}

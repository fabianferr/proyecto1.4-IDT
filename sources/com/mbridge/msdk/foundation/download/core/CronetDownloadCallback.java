package com.mbridge.msdk.foundation.download.core;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
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
import com.mbridge.msdk.foundation.same.net.d.b;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.ac;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import org.chromium.net.CronetException;
import org.chromium.net.UrlRequest;
import org.chromium.net.UrlResponseInfo;
import org.json.JSONObject;

public class CronetDownloadCallback extends UrlRequest.Callback {
    private static final String TAG = "CronetDownloadCallback";
    private ByteArrayOutputStream bytesReceived = null;
    private long contentLength;
    private IDatabaseHelper databaseHelper;
    private DownloadMessage<?> downloadMessage;
    private DownloadModel downloadModel;
    private DownloaderReporter.Builder downloadReporter;
    private DownloadRequest<?> downloadRequest;
    private DownloadResponse downloadResponse;
    private String etag;
    private DownloadFileOutputStream outputStream;
    private WritableByteChannel receiveChannel = null;
    private int responseCode;
    private BlockingQueue<DownloadResponse> responseQueue;
    AtomicBoolean startResponse = new AtomicBoolean(false);

    private boolean isSuccessful(int i) {
        return i >= 200 && i < 300;
    }

    public CronetDownloadCallback(DownloadResponse downloadResponse2, DownloadRequest<?> downloadRequest2, DownloadMessage<?> downloadMessage2, IDatabaseHelper iDatabaseHelper, DownloadModel downloadModel2, DownloaderReporter.Builder builder) {
        this.downloadResponse = downloadResponse2;
        this.downloadRequest = downloadRequest2;
        this.downloadMessage = downloadMessage2;
        this.databaseHelper = iDatabaseHelper;
        this.downloadModel = downloadModel2;
        this.downloadReporter = builder;
    }

    public void setBlockingQueue(BlockingQueue<DownloadResponse> blockingQueue) {
        this.responseQueue = blockingQueue;
    }

    public void onRedirectReceived(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, String str) throws Exception {
        if (urlRequest != null) {
            try {
                urlRequest.followRedirect();
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    aa.b(TAG, "onRedirectReceived error: ", e);
                }
            }
        }
    }

    public void onResponseStarted(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) throws Exception {
        if (urlRequest != null) {
            AtomicBoolean atomicBoolean = this.startResponse;
            if (!(atomicBoolean == null || atomicBoolean.get() || this.responseQueue == null)) {
                DownloadResponse downloadResponse2 = new DownloadResponse();
                downloadResponse2.setResponseStart(true);
                this.responseQueue.add(downloadResponse2);
                DownloadRequest<?> downloadRequest2 = this.downloadRequest;
                if (downloadRequest2 != null) {
                    downloadRequest2.putExtraData("responseHeaders", getResponseHeadersWithJSON(urlResponseInfo));
                }
            }
            if (checkDownloadRequestInfo(urlRequest, urlResponseInfo)) {
                try {
                    GlobalComponent.getInstance().getLogger().log(TAG, "onResponseStarted");
                    String saveFileName = this.downloadMessage.getSaveFileName();
                    DownloadFileOutputStream downloadFileOutputStream = MBResourceManager.getInstance().getDownloadFileOutputStream(new File(this.downloadRequest.getCacheDirectoryPath(), saveFileName));
                    this.outputStream = downloadFileOutputStream;
                    downloadFileOutputStream.seek(this.downloadRequest.getDownloadedBytes());
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    this.bytesReceived = byteArrayOutputStream;
                    this.receiveChannel = Channels.newChannel(byteArrayOutputStream);
                    urlRequest.read(ByteBuffer.allocateDirect(GlobalComponent.getInstance().getByteBufferSize()));
                } catch (Exception e) {
                    if (MBridgeConstans.DEBUG) {
                        aa.b(TAG, "onResponseStarted error: ", e);
                    }
                    cancelRequestSafety(urlRequest);
                }
            } else {
                GlobalComponent.getInstance().getLogger().log(TAG, "onResponseStarted failed");
                cancelRequestSafety(urlRequest);
            }
        }
    }

    private static void cancelRequestSafety(UrlRequest urlRequest) {
        try {
            urlRequest.cancel();
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                aa.b(TAG, "cancelRequest error: ", e);
            }
        }
    }

    public void onReadCompleted(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, ByteBuffer byteBuffer) throws Exception {
        if (urlRequest != null && urlResponseInfo != null && byteBuffer != null) {
            try {
                byteBuffer.flip();
                this.receiveChannel.write(byteBuffer);
                byte[] byteArray = this.bytesReceived.toByteArray();
                int length = byteArray.length;
                this.outputStream.write(byteArray, 0, length);
                this.outputStream.flushAndSync();
                DownloadRequest<?> downloadRequest2 = this.downloadRequest;
                downloadRequest2.setDownloadedBytes(downloadRequest2.getDownloadedBytes() + ((long) length));
                int downloadRate = Utils.getDownloadRate(this.downloadRequest.getTotalBytes(), this.downloadRequest.getDownloadedBytes());
                DownloadRequest<?> downloadRequest3 = this.downloadRequest;
                sendProgress(downloadRequest3, this.downloadMessage, downloadRequest3.getDownloadedBytes(), this.downloadRequest.getTotalBytes(), downloadRate);
                if (this.downloadMessage.getDownloadRate() != 100 && downloadRate >= this.downloadMessage.getDownloadRate()) {
                    cancelRequestSafety(urlRequest);
                } else if (this.downloadRequest.getStatus() == DownloadStatus.CANCELLED) {
                    this.downloadResponse.setCancelled(true);
                    cancelRequestSafety(urlRequest);
                } else {
                    this.bytesReceived.flush();
                    this.bytesReceived.reset();
                    byteBuffer.clear();
                    urlRequest.read(byteBuffer);
                }
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    aa.b(TAG, "onReadCompleted error: ", e);
                }
                cancelRequestSafety(urlRequest);
            }
        }
    }

    public void onSucceeded(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
        GlobalComponent.getInstance().getLogger().log(TAG, "onSucceeded");
        insertDownloadInfo(this.downloadRequest.getDownloadId(), this.downloadRequest.getCacheDirectoryPath());
        if (this.responseQueue != null) {
            DownloadResponse downloadResponse2 = new DownloadResponse();
            downloadResponse2.setSuccessful(true);
            this.responseQueue.add(downloadResponse2);
        }
    }

    private void insertDownloadInfo(String str, String str2) {
        int i;
        IDatabaseHelper databaseHelper2 = GlobalComponent.getInstance().getDatabaseHelper();
        String downloadUrl = this.downloadMessage.getDownloadUrl();
        String resourceUrl = this.downloadMessage.getResourceUrl();
        String str3 = this.etag;
        String saveFileName = this.downloadMessage.getSaveFileName();
        long totalBytes = this.downloadRequest.getTotalBytes();
        long downloadedBytes = this.downloadRequest.getDownloadedBytes();
        int downloadRate = this.downloadMessage.getDownloadRate();
        DownloadModel downloadModel2 = this.downloadModel;
        if (downloadModel2 == null) {
            i = 0;
        } else {
            i = downloadModel2.getUsageCounter();
        }
        String str4 = str;
        databaseHelper2.updateProgress(str4, str2, DownloadModel.create(str4, downloadUrl, resourceUrl, str3, str2, saveFileName, totalBytes, downloadedBytes, downloadRate, i, this.downloadMessage.getDownloadResourceType()));
        if (!this.downloadResponse.isCancelled()) {
            this.downloadResponse.setSuccessful(true);
        }
    }

    public void onFailed(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, CronetException cronetException) {
        GlobalComponent.getInstance().getLogger().log(TAG, "onFailed");
        try {
            if (Objects.isNotNull(this.databaseHelper) && Objects.isNotNull(this.downloadRequest)) {
                if (!ac.a().a("r_f_s_d_e", true)) {
                    this.databaseHelper.remove(this.downloadRequest.getDownloadId(), this.downloadRequest.getCacheDirectoryPath());
                    MBResourceManager instance = MBResourceManager.getInstance();
                    instance.deleteFile(new File(this.downloadRequest.getCacheDirectoryPath() + this.downloadMessage.getSaveFileName()));
                }
                this.downloadRequest.setDownloadedBytes(0);
                this.downloadRequest.setTotalBytes(0);
            }
        } catch (Exception e) {
            GlobalComponent.getInstance().getLogger().log(TAG, e.getMessage());
        }
        this.downloadResponse.setError((Exception) cronetException);
        if (this.responseQueue != null) {
            this.downloadResponse.setFailed(true);
            this.responseQueue.add(this.downloadResponse);
        }
    }

    public void onCanceled(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
        GlobalComponent.getInstance().getLogger().log(TAG, "onCanceled");
        super.onCanceled(urlRequest, urlResponseInfo);
        insertDownloadInfo(this.downloadRequest.getDownloadId(), this.downloadRequest.getCacheDirectoryPath());
    }

    private int getContentLength(UrlResponseInfo urlResponseInfo) {
        List list = urlResponseInfo.getAllHeaders().get("Content-Length");
        if (list == null) {
            return 0;
        }
        return Integer.parseInt((String) list.get(0));
    }

    private List<b> getResponseHeaders(List<Map.Entry<String, String>> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            for (Map.Entry next : list) {
                arrayList.add(new b((String) next.getKey(), (String) next.getValue()));
            }
        }
        return arrayList;
    }

    private String getResponseHeadersWithJSON(UrlResponseInfo urlResponseInfo) {
        if (urlResponseInfo == null) {
            return "";
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("url", urlResponseInfo.getUrl());
            jSONObject.put("statusCode", urlResponseInfo.getHttpStatusCode());
            jSONObject.put("protocol", urlResponseInfo.getNegotiatedProtocol());
            List<Map.Entry<String, String>> allHeadersAsList = urlResponseInfo.getAllHeadersAsList();
            if (allHeadersAsList == null) {
                jSONObject.put("headers", "");
                String jSONObject2 = jSONObject.toString();
            } else {
                for (Map.Entry next : allHeadersAsList) {
                    jSONObject.put((String) next.getKey(), next.getValue());
                }
            }
            return jSONObject.toString();
        } catch (Throwable th) {
            aa.d(TAG, th.getMessage());
            return "";
        }
    }

    private String getETagFromHeader(List<Map.Entry<String, String>> list) {
        List<b> responseHeaders = getResponseHeaders(list);
        if (responseHeaders.isEmpty()) {
            return "";
        }
        for (b next : responseHeaders) {
            if (next != null) {
                String a = next.a();
                if (!TextUtils.isEmpty(a) && a.equalsIgnoreCase("ETag")) {
                    return next.b();
                }
            }
        }
        return "";
    }

    private boolean isSupportResume(int i, DownloadModel downloadModel2) {
        return i == 206 && !TextUtils.isEmpty(this.etag) && (downloadModel2 == null || TextUtils.equals(this.etag, downloadModel2.getEtag()));
    }

    private void sendProgress(DownloadRequest downloadRequest2, DownloadMessage downloadMessage2, long j, long j2, int i) {
        if (downloadRequest2.getStatus() != DownloadStatus.CANCELLED) {
            downloadRequest2.handlerProcessEvent(downloadMessage2, new DownloadProgress(j, j2, i));
        }
    }

    private boolean checkDownloadRequestInfo(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
        String downloadId = this.downloadRequest.getDownloadId();
        String cacheDirectoryPath = this.downloadRequest.getCacheDirectoryPath();
        int httpStatusCode = urlResponseInfo.getHttpStatusCode();
        this.responseCode = httpStatusCode;
        this.downloadReporter.add(DownloadCommon.DOWNLOAD_REPORT_DOWNLOAD_RESPONSE_CODE, String.valueOf(httpStatusCode));
        if (isSuccessful(this.responseCode)) {
            this.contentLength = (long) getContentLength(urlResponseInfo);
            this.etag = getETagFromHeader(urlResponseInfo.getAllHeadersAsList());
            handlerDownloadResume(downloadId, cacheDirectoryPath);
            if (this.contentLength <= 0) {
                this.downloadResponse.setError((Exception) new IOException("response content length is null"));
                return false;
            }
            if (this.downloadRequest.getTotalBytes() == 0) {
                this.downloadRequest.setTotalBytes(this.contentLength);
            }
            handlerDownloadModel(cacheDirectoryPath);
            return true;
        }
        DownloadResponse downloadResponse2 = this.downloadResponse;
        downloadResponse2.setError((Exception) new IOException("responseCode " + this.responseCode));
        return false;
    }

    private void handlerDownloadModel(String str) {
        if (Objects.isNull(this.downloadModel)) {
            DownloadModel create = DownloadModel.create(this.downloadRequest.getDownloadId(), this.downloadMessage.getDownloadUrl(), this.downloadMessage.getResourceUrl(), this.etag, str, this.downloadMessage.getSaveFileName(), this.downloadRequest.getTotalBytes(), 0, this.downloadMessage.getDownloadRate(), 1, this.downloadMessage.getDownloadResourceType());
            this.downloadModel = create;
            this.databaseHelper.insert(create);
            return;
        }
        DownloadModel create2 = DownloadModel.create(this.downloadModel.getDownloadId(), this.downloadModel.getDownloadUrl(), this.downloadMessage.getResourceUrl(), this.downloadModel.getEtag(), this.downloadModel.getSaveDirectorPath(), this.downloadModel.getSaveFileName(), this.downloadRequest.getTotalBytes(), this.downloadModel.getDownloadedBytes(), this.downloadMessage.getDownloadRate(), this.downloadModel.getUsageCounter() + 1, this.downloadMessage.getDownloadResourceType());
        this.downloadModel = create2;
        this.databaseHelper.update(create2, str);
    }

    private void handlerDownloadResume(String str, String str2) {
        boolean z = true;
        boolean z2 = !isSupportResume(this.responseCode, this.downloadModel);
        DownloadRequest<?> downloadRequest2 = this.downloadRequest;
        if (downloadRequest2 == null || this.responseCode != 206 || downloadRequest2.getTotalBytes() <= 0 || this.contentLength == this.downloadRequest.getTotalBytes() - this.downloadRequest.getDownloadedBytes()) {
            z = false;
        }
        if (z2 && z) {
            this.downloadRequest.setDownloadedBytes(0);
            this.downloadRequest.setTotalBytes(0);
            if (Objects.isNotNull(this.databaseHelper)) {
                this.databaseHelper.remove(str, str2);
            }
            this.downloadModel = null;
            MBResourceManager.getInstance().deleteFile(new File(this.downloadRequest.getCacheDirectoryPath() + this.downloadMessage.getSaveFileName()));
        }
    }
}

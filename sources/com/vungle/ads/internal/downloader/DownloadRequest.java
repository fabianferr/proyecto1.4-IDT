package com.vungle.ads.internal.downloader;

import androidx.media3.common.C;
import com.vungle.ads.AnalyticsClient;
import com.vungle.ads.TimeIntervalMetric;
import com.vungle.ads.internal.downloader.Downloader;
import com.vungle.ads.internal.protos.Sdk;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001>Be\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u000eB\u0001\b\u0016\u0012\b\b\u0001\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0011\u001a\u00020\t\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0013J\u0006\u00106\u001a\u000207J\u0006\u00108\u001a\u00020\u0010J\u0006\u00109\u001a\u00020\tJ\u000e\u0010:\u001a\u0002072\u0006\u0010\u0002\u001a\u00020\u0003J\u0006\u0010;\u001a\u000207J\u0006\u0010<\u001a\u000207J\b\u0010=\u001a\u00020\u0005H\u0016R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0015\"\u0004\b!\u0010\u0017R\u001c\u0010\"\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0015\"\u0004\b$\u0010\u0017R\u001a\u0010\n\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010%\"\u0004\b&\u0010'R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010%\"\u0004\b(\u0010'R\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0015\"\u0004\b.\u0010\u0017R\u001a\u0010\u0011\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010%\"\u0004\b0\u0010'R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0015\"\u0004\b2\u0010\u0017R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u000303X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0015\"\u0004\b5\u0010\u0017¨\u0006?"}, d2 = {"Lcom/vungle/ads/internal/downloader/DownloadRequest;", "", "priority", "Lcom/vungle/ads/internal/downloader/DownloadRequest$Priority;", "url", "", "path", "cookieString", "isTemplate", "", "isMainVideo", "placementId", "creativeId", "eventId", "(Lcom/vungle/ads/internal/downloader/DownloadRequest$Priority;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "networkType", "", "pauseOnConnectionLost", "advertisementId", "(ILcom/vungle/ads/internal/downloader/DownloadRequest$Priority;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAdvertisementId", "()Ljava/lang/String;", "setAdvertisementId", "(Ljava/lang/String;)V", "cancelled", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getCookieString", "setCookieString", "getCreativeId", "setCreativeId", "downloadDuration", "Lcom/vungle/ads/TimeIntervalMetric;", "getEventId", "setEventId", "id", "getId", "setId", "()Z", "setMainVideo", "(Z)V", "setTemplate", "getNetworkType", "()I", "setNetworkType", "(I)V", "getPath", "setPath", "getPauseOnConnectionLost", "setPauseOnConnectionLost", "getPlacementId", "setPlacementId", "Ljava/util/concurrent/atomic/AtomicReference;", "getUrl", "setUrl", "cancel", "", "getPriority", "isCancelled", "setPriority", "startRecord", "stopRecord", "toString", "Priority", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: DownloadRequest.kt */
public final class DownloadRequest {
    private String advertisementId;
    private final AtomicBoolean cancelled;
    private String cookieString;
    private String creativeId;
    private TimeIntervalMetric downloadDuration;
    private String eventId;
    private String id;
    private boolean isMainVideo;
    private boolean isTemplate;
    private int networkType;
    private String path;
    private boolean pauseOnConnectionLost;
    private String placementId;
    private AtomicReference<Priority> priority;
    private String url;

    public final int getNetworkType() {
        return this.networkType;
    }

    public final void setNetworkType(int i) {
        this.networkType = i;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public final String getPath() {
        return this.path;
    }

    public final void setPath(String str) {
        this.path = str;
    }

    public final boolean getPauseOnConnectionLost() {
        return this.pauseOnConnectionLost;
    }

    public final void setPauseOnConnectionLost(boolean z) {
        this.pauseOnConnectionLost = z;
    }

    public final String getId() {
        return this.id;
    }

    public final void setId(String str) {
        this.id = str;
    }

    public final String getCookieString() {
        return this.cookieString;
    }

    public final void setCookieString(String str) {
        this.cookieString = str;
    }

    public final String getAdvertisementId() {
        return this.advertisementId;
    }

    public final void setAdvertisementId(String str) {
        this.advertisementId = str;
    }

    public final boolean isTemplate() {
        return this.isTemplate;
    }

    public final void setTemplate(boolean z) {
        this.isTemplate = z;
    }

    public final boolean isMainVideo() {
        return this.isMainVideo;
    }

    public final void setMainVideo(boolean z) {
        this.isMainVideo = z;
    }

    public final String getPlacementId() {
        return this.placementId;
    }

    public final void setPlacementId(String str) {
        this.placementId = str;
    }

    public final String getCreativeId() {
        return this.creativeId;
    }

    public final void setCreativeId(String str) {
        this.creativeId = str;
    }

    public final String getEventId() {
        return this.eventId;
    }

    public final void setEventId(String str) {
        this.eventId = str;
    }

    public String toString() {
        return "DownloadRequest{networkType=" + this.networkType + ", priority=" + this.priority + ", url='" + this.url + "', path='" + this.path + "', pauseOnConnectionLost=" + this.pauseOnConnectionLost + ", id='" + this.id + "', cookieString='" + this.cookieString + "', cancelled=" + this.cancelled + ", advertisementId=" + this.advertisementId + ", placementId=" + this.placementId + ", creativeId=" + this.creativeId + ", eventId=" + this.eventId + AbstractJsonLexerKt.END_OBJ;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/vungle/ads/internal/downloader/DownloadRequest$Priority;", "", "priority", "", "(Ljava/lang/String;II)V", "getPriority", "()I", "CRITICAL", "HIGHEST", "HIGH", "LOWEST", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: DownloadRequest.kt */
    public enum Priority {
        CRITICAL(C.RATE_UNSET_INT),
        HIGHEST(0),
        HIGH(1),
        LOWEST(Integer.MAX_VALUE);
        
        private final int priority;

        private Priority(int i) {
            this.priority = i;
        }

        public final int getPriority() {
            return this.priority;
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ DownloadRequest(com.vungle.ads.internal.downloader.DownloadRequest.Priority r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, boolean r18, boolean r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, int r23, kotlin.jvm.internal.DefaultConstructorMarker r24) {
        /*
            r13 = this;
            r0 = r23
            r1 = r0 & 16
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r8 = 0
            goto L_0x000b
        L_0x0009:
            r8 = r18
        L_0x000b:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x0011
            r9 = 0
            goto L_0x0013
        L_0x0011:
            r9 = r19
        L_0x0013:
            r1 = r0 & 64
            r2 = 0
            if (r1 == 0) goto L_0x001a
            r10 = r2
            goto L_0x001c
        L_0x001a:
            r10 = r20
        L_0x001c:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0022
            r11 = r2
            goto L_0x0024
        L_0x0022:
            r11 = r21
        L_0x0024:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x002a
            r12 = r2
            goto L_0x002c
        L_0x002a:
            r12 = r22
        L_0x002c:
            r3 = r13
            r4 = r14
            r5 = r15
            r6 = r16
            r7 = r17
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.downloader.DownloadRequest.<init>(com.vungle.ads.internal.downloader.DownloadRequest$Priority, java.lang.String, java.lang.String, java.lang.String, boolean, boolean, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public DownloadRequest(Priority priority2, String str, String str2, String str3, boolean z, boolean z2, String str4, String str5, String str6) {
        this(Downloader.NetworkType.Companion.getANY(), priority2, str, str2, false, str3, (String) null, z, z2, str4, str5, str6);
        Intrinsics.checkNotNullParameter(priority2, "priority");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ DownloadRequest(int r17, com.vungle.ads.internal.downloader.DownloadRequest.Priority r18, java.lang.String r19, java.lang.String r20, boolean r21, java.lang.String r22, java.lang.String r23, boolean r24, boolean r25, java.lang.String r26, java.lang.String r27, java.lang.String r28, int r29, kotlin.jvm.internal.DefaultConstructorMarker r30) {
        /*
            r16 = this;
            r0 = r29
            r1 = r0 & 128(0x80, float:1.794E-43)
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r11 = 0
            goto L_0x000b
        L_0x0009:
            r11 = r24
        L_0x000b:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0011
            r12 = 0
            goto L_0x0013
        L_0x0011:
            r12 = r25
        L_0x0013:
            r1 = r0 & 512(0x200, float:7.175E-43)
            r2 = 0
            if (r1 == 0) goto L_0x001a
            r13 = r2
            goto L_0x001c
        L_0x001a:
            r13 = r26
        L_0x001c:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x0022
            r14 = r2
            goto L_0x0024
        L_0x0022:
            r14 = r27
        L_0x0024:
            r0 = r0 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x002a
            r15 = r2
            goto L_0x002c
        L_0x002a:
            r15 = r28
        L_0x002c:
            r3 = r16
            r4 = r17
            r5 = r18
            r6 = r19
            r7 = r20
            r8 = r21
            r9 = r22
            r10 = r23
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.downloader.DownloadRequest.<init>(int, com.vungle.ads.internal.downloader.DownloadRequest$Priority, java.lang.String, java.lang.String, boolean, java.lang.String, java.lang.String, boolean, boolean, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public DownloadRequest(@Downloader.NetworkType int i, Priority priority2, String str, String str2, boolean z, String str3, String str4, boolean z2, boolean z3, String str5, String str6, String str7) {
        Intrinsics.checkNotNullParameter(priority2, "priority");
        this.priority = new AtomicReference<>();
        this.cancelled = new AtomicBoolean(false);
        this.url = str;
        this.networkType = i;
        this.priority.set(priority2);
        this.path = str2;
        this.pauseOnConnectionLost = z;
        this.cookieString = str3;
        this.advertisementId = str4;
        this.isTemplate = z2;
        this.isMainVideo = z3;
        this.placementId = str5;
        this.creativeId = str6;
        this.eventId = str7;
    }

    public final void cancel() {
        this.cancelled.set(true);
    }

    public final boolean isCancelled() {
        return this.cancelled.get();
    }

    public final void setPriority(Priority priority2) {
        Intrinsics.checkNotNullParameter(priority2, "priority");
        this.priority.set(priority2);
    }

    public final int getPriority() {
        return this.priority.get().getPriority();
    }

    public final void startRecord() {
        TimeIntervalMetric timeIntervalMetric = new TimeIntervalMetric(Sdk.SDKMetric.SDKMetricType.TEMPLATE_DOWNLOAD_DURATION_MS);
        this.downloadDuration = timeIntervalMetric;
        timeIntervalMetric.markStart();
    }

    public final void stopRecord() {
        TimeIntervalMetric timeIntervalMetric = this.downloadDuration;
        if (timeIntervalMetric != null) {
            timeIntervalMetric.markEnd();
            AnalyticsClient.INSTANCE.logMetric$vungle_ads_release(timeIntervalMetric, this.placementId, this.creativeId, this.eventId, this.url);
        }
    }
}

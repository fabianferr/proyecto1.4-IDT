package com.vungle.ads.internal.model;

import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0003567B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006B+\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u0013\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u00103\u001a\u00020\u001eH\u0016J\b\u00104\u001a\u00020\u0003H\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\nR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\n\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\nR\u001a\u0010*\u001a\u00020+X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/¨\u00068"}, d2 = {"Lcom/vungle/ads/internal/model/AdAsset;", "", "adIdentifier", "", "serverPath", "localPath", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "identifier", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAdIdentifier", "()Ljava/lang/String;", "fileSize", "", "getFileSize", "()J", "setFileSize", "(J)V", "fileType", "Lcom/vungle/ads/internal/model/AdAsset$FileType;", "getFileType", "()Lcom/vungle/ads/internal/model/AdAsset$FileType;", "setFileType", "(Lcom/vungle/ads/internal/model/AdAsset$FileType;)V", "getIdentifier", "getLocalPath", "parentId", "getParentId", "setParentId", "(Ljava/lang/String;)V", "retryCount", "", "getRetryCount", "()I", "setRetryCount", "(I)V", "retryTypeError", "Lcom/vungle/ads/internal/model/AdAsset$ErrorType;", "getRetryTypeError", "()Lcom/vungle/ads/internal/model/AdAsset$ErrorType;", "setRetryTypeError", "(Lcom/vungle/ads/internal/model/AdAsset$ErrorType;)V", "getServerPath", "status", "Lcom/vungle/ads/internal/model/AdAsset$Status;", "getStatus", "()Lcom/vungle/ads/internal/model/AdAsset$Status;", "setStatus", "(Lcom/vungle/ads/internal/model/AdAsset$Status;)V", "equals", "", "o", "hashCode", "toString", "ErrorType", "FileType", "Status", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: AdAsset.kt */
public final class AdAsset {
    private final String adIdentifier;
    private long fileSize;
    private FileType fileType;
    private final String identifier;
    private final String localPath;
    private String parentId;
    private int retryCount;
    private ErrorType retryTypeError;
    private final String serverPath;
    private Status status;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/vungle/ads/internal/model/AdAsset$ErrorType;", "", "(Ljava/lang/String;I)V", "NO_ERROR", "CAN_RETRY_ERROR", "CANNOT_RETRY_ERROR", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: AdAsset.kt */
    public enum ErrorType {
        NO_ERROR,
        CAN_RETRY_ERROR,
        CANNOT_RETRY_ERROR
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/vungle/ads/internal/model/AdAsset$FileType;", "", "(Ljava/lang/String;I)V", "ZIP", "ZIP_ASSET", "ASSET", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: AdAsset.kt */
    public enum FileType {
        ZIP,
        ZIP_ASSET,
        ASSET
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/vungle/ads/internal/model/AdAsset$Status;", "", "(Ljava/lang/String;I)V", "NEW", "DOWNLOAD_RUNNING", "DOWNLOAD_FAILED", "DOWNLOAD_SUCCESS", "PROCESSED", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: AdAsset.kt */
    public enum Status {
        NEW,
        DOWNLOAD_RUNNING,
        DOWNLOAD_FAILED,
        DOWNLOAD_SUCCESS,
        PROCESSED
    }

    public AdAsset(String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, "adIdentifier");
        Intrinsics.checkNotNullParameter(str3, "localPath");
        this.identifier = str4;
        this.status = Status.NEW;
        this.adIdentifier = str;
        this.serverPath = str2;
        this.localPath = str3;
        this.fileSize = -1;
        this.retryCount = 0;
        this.retryTypeError = ErrorType.NO_ERROR;
    }

    public final String getIdentifier() {
        return this.identifier;
    }

    public final String getAdIdentifier() {
        return this.adIdentifier;
    }

    public final String getParentId() {
        return this.parentId;
    }

    public final void setParentId(String str) {
        this.parentId = str;
    }

    public final String getServerPath() {
        return this.serverPath;
    }

    public final String getLocalPath() {
        return this.localPath;
    }

    public final Status getStatus() {
        return this.status;
    }

    public final void setStatus(Status status2) {
        Intrinsics.checkNotNullParameter(status2, "<set-?>");
        this.status = status2;
    }

    public final FileType getFileType() {
        return this.fileType;
    }

    public final void setFileType(FileType fileType2) {
        this.fileType = fileType2;
    }

    public final long getFileSize() {
        return this.fileSize;
    }

    public final void setFileSize(long j) {
        this.fileSize = j;
    }

    public final int getRetryCount() {
        return this.retryCount;
    }

    public final void setRetryCount(int i) {
        this.retryCount = i;
    }

    public final ErrorType getRetryTypeError() {
        return this.retryTypeError;
    }

    public final void setRetryTypeError(ErrorType errorType) {
        Intrinsics.checkNotNullParameter(errorType, "<set-?>");
        this.retryTypeError = errorType;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AdAsset(String str, String str2, String str3) {
        this(str, str2, str3, UUID.randomUUID().toString());
        Intrinsics.checkNotNullParameter(str, "adIdentifier");
        Intrinsics.checkNotNullParameter(str3, "localPath");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !Intrinsics.areEqual((Object) getClass(), (Object) obj.getClass())) {
            return false;
        }
        AdAsset adAsset = (AdAsset) obj;
        if (this.status != adAsset.status || this.fileType != adAsset.fileType || this.fileSize != adAsset.fileSize || this.retryCount != adAsset.retryCount || this.retryTypeError != adAsset.retryTypeError) {
            return false;
        }
        String str = this.identifier;
        if (str == null ? adAsset.identifier != null : !Intrinsics.areEqual((Object) str, (Object) adAsset.identifier)) {
            return false;
        }
        String str2 = this.adIdentifier;
        if (str2 == null ? adAsset.adIdentifier != null : !Intrinsics.areEqual((Object) str2, (Object) adAsset.adIdentifier)) {
            return false;
        }
        String str3 = this.parentId;
        if (str3 == null ? adAsset.parentId != null : !Intrinsics.areEqual((Object) str3, (Object) adAsset.parentId)) {
            return false;
        }
        String str4 = this.serverPath;
        if (str4 == null ? adAsset.serverPath != null : !Intrinsics.areEqual((Object) str4, (Object) adAsset.serverPath)) {
            return false;
        }
        String str5 = this.localPath;
        String str6 = adAsset.localPath;
        if (str5 != null) {
            return Intrinsics.areEqual((Object) str5, (Object) str6);
        }
        if (str6 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        String str = this.identifier;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.adIdentifier;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.parentId;
        int hashCode3 = (hashCode2 + ((str3 == null || str3 == null) ? 0 : str3.hashCode())) * 31;
        String str4 = this.serverPath;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.localPath;
        int hashCode5 = (((hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31) + this.status.hashCode()) * 31;
        FileType fileType2 = this.fileType;
        if (fileType2 != null) {
            i = fileType2.hashCode();
        }
        long j = this.fileSize;
        return ((((((hashCode5 + i) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + this.retryCount) * 31) + this.retryTypeError.hashCode();
    }

    public String toString() {
        return "AdAsset{identifier='" + this.identifier + "', adIdentifier='" + this.adIdentifier + "', serverPath='" + this.serverPath + "', localPath='" + this.localPath + "', status=" + this.status + ", fileType=" + this.fileType + ", fileSize=" + this.fileSize + ", retryCount=" + this.retryCount + ", retryTypeError=" + this.retryTypeError + AbstractJsonLexerKt.END_OBJ;
    }
}

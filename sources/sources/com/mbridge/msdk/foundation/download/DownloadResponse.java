package com.mbridge.msdk.foundation.download;

import com.mbridge.msdk.foundation.download.utils.Objects;

public class DownloadResponse {
    private static final String UN_KNOWN = "unknown";
    private DownloadError _error;
    private boolean _isCancelled;
    private boolean _isSuccessful;
    private boolean isFailed;
    private boolean isResponseStart;
    private boolean isTimeout;

    public DownloadError getError() {
        return this._error;
    }

    public void setError(DownloadError downloadError) {
        this._error = downloadError;
        setSuccessful(false);
    }

    public void setError(Exception exc) {
        setError(new DownloadError(exc));
    }

    public boolean isSuccessful() {
        return this._isSuccessful;
    }

    public void setSuccessful(boolean z) {
        this._isSuccessful = z;
    }

    public boolean isCancelled() {
        return this._isCancelled;
    }

    public void setCancelled(boolean z) {
        this._isCancelled = z;
    }

    public String getErrorMessage() {
        return (Objects.isNull(getError()) || Objects.isNull(getError().getException())) ? "unknown" : getError().getException().getMessage();
    }

    public boolean isTimeout() {
        return this.isTimeout;
    }

    public void setTimeout(boolean z) {
        this.isTimeout = z;
    }

    public boolean isResponseStart() {
        return this.isResponseStart;
    }

    public void setResponseStart(boolean z) {
        this.isResponseStart = z;
    }

    public boolean isFailed() {
        return this.isFailed;
    }

    public void setFailed(boolean z) {
        this.isFailed = z;
    }
}

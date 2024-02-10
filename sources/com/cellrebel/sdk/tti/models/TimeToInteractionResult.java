package com.cellrebel.sdk.tti.models;

import java.util.ArrayList;
import java.util.List;

public class TimeToInteractionResult {
    public long bytesDownloaded;
    public long bytesUploaded;
    public long downloadTime;
    public long downloadTimeToFirstByte;
    public List<ErrorType> errors = new ArrayList();
    public int latency;
    public String serverBuild;
    public int serverId;
    public String serverIp;
    public int serverPort;
    public String serverVersion;
    public long uploadTime;
    public long uploadTimeToFirstByte;

    public enum ErrorType {
        SERVER_CONFIG_FAILURE,
        SERVER_LIST_FAILURE,
        SERVER_SELECTION_FAILURE,
        FILE_DOWNLOAD_FAILURE,
        FILE_UPLOAD_FAILURE,
        UPLOAD_STATS_FAILURE,
        TIME_TO_INTERACTION_TIMEOUT,
        TIME_TO_INTERACTION_INTERRUPTED
    }

    public void addError(ErrorType errorType) {
        this.errors.add(errorType);
    }
}

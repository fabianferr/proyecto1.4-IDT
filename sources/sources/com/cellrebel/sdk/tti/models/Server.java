package com.cellrebel.sdk.tti.models;

import com.google.gson.annotations.SerializedName;

public class Server {
    @SerializedName("host")
    public String host;
    @SerializedName("id")
    public int id;

    public Server(int i, String str) {
        this.id = i;
        this.host = str;
    }

    public String getDownloadUrl() {
        return "https://" + this.host + "/download";
    }

    public String getLatencyUrl() {
        return "wss://" + this.host + "/ws";
    }

    public String getUploadStatsUrl() {
        return "wss://" + this.host + "/ws";
    }

    public String getUploadUrl() {
        return "https://" + this.host + "/upload";
    }

    public String getUrl() {
        return "https://" + this.host;
    }
}

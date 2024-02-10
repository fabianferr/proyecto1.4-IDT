package com.cellrebel.sdk.networking.beans.response;

import com.google.gson.annotations.SerializedName;

public class Server {
    @SerializedName("serverDescription")
    public String description;
    public long id;
    @SerializedName("loadedLatencyTestFileTransferUrl")
    public String loadedLatencyTestFileTransferUrl;
    @SerializedName("serverLocation")
    public String location;
    @SerializedName("serverName")
    public String name;
    @SerializedName("serverUrl")
    public String url;

    public Server() {
    }

    public Server(String str, String str2, String str3, String str4, String str5) {
        this.name = str;
        this.description = str2;
        this.url = str3;
        this.location = str4;
        this.loadedLatencyTestFileTransferUrl = str5;
    }
}

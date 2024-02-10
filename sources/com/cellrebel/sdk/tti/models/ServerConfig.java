package com.cellrebel.sdk.tti.models;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class ServerConfig {
    @SerializedName("clientAuth")
    public ClientAuth clientAuth;
    @SerializedName("guid")
    public String guid;
    @SerializedName("servers")
    public List<Server> servers;
}

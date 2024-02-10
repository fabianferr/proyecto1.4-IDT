package com.cellrebel.sdk.networking.beans.response;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

public class Game {
    public long id;
    public Boolean isHidden = Boolean.FALSE;
    @SerializedName("gameName")
    public String name;
    @SerializedName("gameServers")
    public List<Server> servers = new ArrayList();
    @SerializedName("iconUrl")
    public String subtitle;

    public Game() {
    }

    public Game(String str, String str2) {
        this.name = str;
        this.subtitle = str2;
    }

    public List<Server> getServers() {
        return this.servers;
    }
}

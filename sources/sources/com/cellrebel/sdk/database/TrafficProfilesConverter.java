package com.cellrebel.sdk.database;

import com.cellrebel.sdk.networking.beans.response.TrafficProfiles;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.List;

public class TrafficProfilesConverter {
    private final Gson a = new Gson();

    public String a(List<TrafficProfiles> list) {
        return this.a.toJson((Object) list);
    }

    public List<TrafficProfiles> a(String str) {
        return (List) this.a.fromJson(str, new TypeToken<List<TrafficProfiles>>() {
        }.getType());
    }
}

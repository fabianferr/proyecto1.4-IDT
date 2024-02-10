package com.cellrebel.sdk.database;

import com.cellrebel.sdk.networking.beans.response.Server;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.List;

public class ServerConverter {
    public static String a(List<Server> list) {
        return new Gson().toJson((Object) list);
    }

    public static List<Server> a(String str) {
        return (List) new Gson().fromJson(str, new TypeToken<List<Server>>() {
        }.getType());
    }
}

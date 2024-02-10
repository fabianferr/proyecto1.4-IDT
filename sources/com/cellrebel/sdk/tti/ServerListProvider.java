package com.cellrebel.sdk.tti;

import com.cellrebel.sdk.networking.ApiClient;
import com.cellrebel.sdk.tti.models.ServerConfig;
import java.io.IOException;
import retrofit2.Response;

public class ServerListProvider {
    private final String a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;

    public ServerListProvider(String str, String str2, String str3, String str4, String str5) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
    }

    public ServerConfig a() {
        try {
            Response<ServerConfig> execute = ApiClient.a().a(this.a, this.b, this.c, this.d, this.e).execute();
            if (execute.isSuccessful()) {
                return execute.body();
            }
            return null;
        } catch (IOException unused) {
            return null;
        }
    }
}

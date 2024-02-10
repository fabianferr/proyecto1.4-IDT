package com.cellrebel.sdk.database;

import android.content.Context;
import com.cellrebel.sdk.networking.beans.request.BaseMetric;
import com.cellrebel.sdk.networking.beans.request.GameInfoMetric;
import com.cellrebel.sdk.tti.ServerSelection;
import com.cellrebel.sdk.tti.models.Server;
import com.cellrebel.sdk.workers.BaseMetricsWorker;
import java.net.InetAddress;
import java.net.URL;

public class LatencyRepository implements ServerSelection.LatencyRepository {
    private final Context a;
    private final String b;
    private final String c;

    public LatencyRepository(Context context, String str, String str2) {
        this.a = context;
        this.b = str;
        this.c = str2;
    }

    private String a(String str) {
        try {
            return InetAddress.getByName(new URL(str).getHost()).getHostAddress();
        } catch (Exception unused) {
            return null;
        }
    }

    public void a(Server server, int i, Integer num, Double d) {
        GameInfoMetric gameInfoMetric = new GameInfoMetric();
        gameInfoMetric.measurementSequenceId = this.b;
        gameInfoMetric.gameName = this.c;
        gameInfoMetric.serverName = String.valueOf(server.id);
        gameInfoMetric.serverUrl = server.host;
        gameInfoMetric.serverIp = a(server.getUrl());
        gameInfoMetric.latency = Float.valueOf(num.floatValue());
        gameInfoMetric.jitter = Float.valueOf(d.floatValue());
        gameInfoMetric.latencyType = 4;
        gameInfoMetric.pingsCount = Float.valueOf((float) i);
        BaseMetricsWorker.a(this.a, (BaseMetric) gameInfoMetric);
    }
}

package com.cellrebel.sdk.tti;

import com.cellrebel.sdk.tti.models.Server;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;

public class ServerSelection {
    private final OkHttpClient a;
    private final List<Server> b;
    private final LatencyMeasurerFactory c = new ServerSelection$$ExternalSyntheticLambda1();
    private final LatencyRepository d;
    private Server e;
    private Integer f;

    public interface LatencyMeasurerFactory {
        LatencyMeasurer a(OkHttpClient okHttpClient);
    }

    public interface LatencyRepository {
        void a(Server server, int i, Integer num, Double d);
    }

    public ServerSelection(OkHttpClient okHttpClient, List<Server> list, LatencyRepository latencyRepository) {
        this.a = okHttpClient;
        this.b = list;
        this.d = latencyRepository;
    }

    private double a(List<Integer> list) {
        if (list.size() < 2) {
            return 0.0d;
        }
        int i = 0;
        for (int i2 = 1; i2 < list.size(); i2++) {
            i += Math.abs(list.get(i2).intValue() - list.get(i2 - 1).intValue());
        }
        double d2 = (double) i;
        double size = (double) (list.size() - 1);
        Double.isNaN(d2);
        Double.isNaN(size);
        return d2 / size;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(Server server, int i, int i2, String str, String str2, Map map) {
        Double d2;
        Integer num;
        List<Integer> a2 = this.c.a(this.a).a(server.getLatencyUrl(), i, i2, str, str2);
        if (!a2.isEmpty()) {
            num = (Integer) Collections.min(a2);
            d2 = Double.valueOf(a(a2));
        } else {
            num = null;
            d2 = null;
        }
        if (num != null) {
            map.put(num, server);
            LatencyRepository latencyRepository = this.d;
            if (latencyRepository != null) {
                latencyRepository.a(server, a2.size(), num, d2);
            }
        }
    }

    public Server a() {
        return this.e;
    }

    public void a(int i, int i2, int i3, String str, String str2) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        for (Server serverSelection$$ExternalSyntheticLambda0 : this.b) {
            newFixedThreadPool.submit(new ServerSelection$$ExternalSyntheticLambda0(this, serverSelection$$ExternalSyntheticLambda0, i2, i3, str, str2, concurrentHashMap));
        }
        try {
            newFixedThreadPool.shutdown();
            newFixedThreadPool.awaitTermination((long) i, TimeUnit.SECONDS);
        } catch (InterruptedException unused) {
        }
        Integer num = Integer.MAX_VALUE;
        for (Map.Entry entry : concurrentHashMap.entrySet()) {
            Integer num2 = (Integer) entry.getKey();
            Server server = (Server) entry.getValue();
            if (((Integer) entry.getKey()).intValue() > 0 && ((Integer) entry.getKey()).intValue() < num.intValue()) {
                int i4 = ((Server) entry.getValue()).id;
                entry.getKey();
                this.f = num2;
                this.e = server;
                num = num2;
            }
        }
    }

    public int b() {
        return this.f.intValue();
    }
}

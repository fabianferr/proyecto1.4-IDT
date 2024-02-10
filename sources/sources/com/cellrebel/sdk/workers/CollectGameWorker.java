package com.cellrebel.sdk.workers;

import android.content.Context;
import com.cellrebel.sdk.database.DatabaseClient;
import com.cellrebel.sdk.database.GPSPoint;
import com.cellrebel.sdk.database.GameLatency;
import com.cellrebel.sdk.database.dao.GameLatencyDAO;
import com.cellrebel.sdk.networking.beans.request.GameInfoMetric;
import com.cellrebel.sdk.networking.beans.response.Settings;
import com.cellrebel.sdk.ping.AndroidPing;
import com.cellrebel.sdk.ping.Ping;
import com.cellrebel.sdk.ping.PingResult;
import com.cellrebel.sdk.utils.SettingsManager;
import com.cellrebel.sdk.utils.Utils;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;

public class CollectGameWorker extends BaseMetricsWorker {
    Settings j = SettingsManager.b().c();
    private List<GameInfoMetric> k;
    Map<String, GameInfoMetric> l = new HashMap();
    String m;
    private GameLatencyDAO n;
    int o = 0;
    private boolean p = false;
    private CountDownLatch q = new CountDownLatch(1);

    /* access modifiers changed from: private */
    public /* synthetic */ void b() {
        try {
            this.q.countDown();
        } catch (Exception | OutOfMemoryError unused) {
        }
    }

    private void b(GameInfoMetric gameInfoMetric) {
        try {
            if (Utils.d() && gameInfoMetric.latitude != 0.0d && gameInfoMetric.longitude != 0.0d && gameInfoMetric.latency.floatValue() != 0.0f) {
                if (gameInfoMetric.latency.floatValue() < 999.0f) {
                    if (this.n == null) {
                        if (DatabaseClient.a() != null) {
                            this.n = DatabaseClient.a().k();
                        } else {
                            return;
                        }
                    }
                    GameLatency gameLatency = new GameLatency();
                    gameLatency.c = gameInfoMetric.gameName;
                    gameLatency.d = gameInfoMetric.serverName;
                    gameLatency.e = gameInfoMetric.latency;
                    gameLatency.b = System.currentTimeMillis();
                    gameLatency.f = gameInfoMetric.latitude;
                    gameLatency.g = gameInfoMetric.longitude;
                    this.n.a(gameLatency);
                }
            }
        } catch (Exception | OutOfMemoryError unused) {
        }
    }

    /* access modifiers changed from: package-private */
    public void a() {
        try {
            if (Utils.d()) {
                if (this.n == null) {
                    if (DatabaseClient.a() != null) {
                        this.n = DatabaseClient.a().k();
                    } else {
                        return;
                    }
                }
                if (this.n.a() > 5000) {
                    this.n.a(5000);
                }
                List<GPSPoint> b = this.n.b();
                if (!b.isEmpty()) {
                    ArrayList arrayList = new ArrayList();
                    for (GPSPoint next : b) {
                        List<GameLatency> a = this.n.a(next.a, next.b);
                        HashMap hashMap = new HashMap();
                        for (GameLatency next2 : a) {
                            if (hashMap.containsKey(next2.c)) {
                                for (Map map : (List) hashMap.get(next2.c)) {
                                    if (map.containsKey(next2.d)) {
                                        GameLatency gameLatency = (GameLatency) map.get(next2.d);
                                        if (gameLatency == null || gameLatency.b >= next2.b) {
                                            arrayList.add(Long.valueOf(next2.a));
                                        } else {
                                            arrayList.add(Long.valueOf(gameLatency.a));
                                        }
                                    }
                                    map.put(next2.d, next2);
                                }
                            } else {
                                ArrayList arrayList2 = new ArrayList();
                                HashMap hashMap2 = new HashMap();
                                hashMap2.put(next2.d, next2);
                                arrayList2.add(hashMap2);
                                hashMap.put(next2.c, arrayList2);
                            }
                        }
                    }
                    if (arrayList.isEmpty()) {
                        return;
                    }
                    if (arrayList.size() < 999) {
                        this.n.a((List<Long>) arrayList);
                        return;
                    }
                    int i = 0;
                    while (i < arrayList.size()) {
                        int i2 = i + 998;
                        this.n.a((List<Long>) arrayList.subList(i, Math.min(arrayList.size() + 1, i2)));
                        i = i2;
                    }
                }
            }
        } catch (Exception | OutOfMemoryError unused) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x008e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.content.Context r14) {
        /*
            r13 = this;
            boolean r0 = com.cellrebel.sdk.utils.Utils.e()
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            long r1 = java.lang.System.currentTimeMillis()
            r3 = 1000(0x3e8, double:4.94E-321)
            long r1 = r1 / r3
            java.lang.String.valueOf(r1)
            com.cellrebel.sdk.networking.beans.request.GameInfoMetric r1 = new com.cellrebel.sdk.networking.beans.request.GameInfoMetric
            r1.<init>()
            java.lang.String r2 = r13.m
            r1.measurementSequenceId = r2
            java.lang.String r2 = "power"
            java.lang.Object r2 = r14.getSystemService(r2)
            r6 = r2
            android.os.PowerManager r6 = (android.os.PowerManager) r6
            com.cellrebel.sdk.utils.TrackingHelper r2 = com.cellrebel.sdk.utils.TrackingHelper.a()
            boolean r2 = r2.c()
            if (r2 != 0) goto L_0x0034
            r2 = 500(0x1f4, float:7.0E-43)
        L_0x0030:
            r1.stateDuringMeasurement(r2)
            goto L_0x004f
        L_0x0034:
            boolean r2 = r0.booleanValue()
            if (r2 != 0) goto L_0x003d
            r2 = 501(0x1f5, float:7.02E-43)
            goto L_0x0030
        L_0x003d:
            boolean r4 = com.cellrebel.sdk.workers.BaseMetricsWorker.h
            boolean r5 = r13.c
            boolean r7 = r13.b
            boolean r8 = r13.d
            boolean r9 = r13.e
            boolean r10 = r13.f
            boolean r11 = r13.g
            r3 = r1
            com.cellrebel.sdk.utils.Utils.a(r3, r4, r5, r6, r7, r8, r9, r10, r11)
        L_0x004f:
            java.util.concurrent.CountDownLatch r2 = new java.util.concurrent.CountDownLatch
            r3 = 1
            r2.<init>(r3)
            r13.q = r2
            com.cellrebel.sdk.workers.CollectGameWorker$$ExternalSyntheticLambda0 r2 = new com.cellrebel.sdk.workers.CollectGameWorker$$ExternalSyntheticLambda0
            r2.<init>(r13)
            com.cellrebel.sdk.workers.BaseMetricsWorker.a((android.content.Context) r14, (com.cellrebel.sdk.networking.beans.request.BaseMetric) r1, (java.lang.Runnable) r2)
            java.util.concurrent.CountDownLatch r2 = r13.q     // Catch:{ InterruptedException -> 0x0065 }
            r2.await()     // Catch:{ InterruptedException -> 0x0065 }
            goto L_0x0066
        L_0x0065:
        L_0x0066:
            com.cellrebel.sdk.networking.beans.response.Settings r2 = r13.j
            java.lang.Integer r2 = r2.gamePingsPerServer
            if (r2 != 0) goto L_0x006d
            goto L_0x0071
        L_0x006d:
            int r3 = r2.intValue()
        L_0x0071:
            com.cellrebel.sdk.networking.beans.response.Settings r2 = r13.j
            java.lang.Integer r2 = r2.gameTimeoutTimer
            if (r2 != 0) goto L_0x007a
            r2 = 1000(0x3e8, float:1.401E-42)
            goto L_0x007e
        L_0x007a:
            int r2 = r2.intValue()
        L_0x007e:
            long r4 = java.lang.System.currentTimeMillis()
            java.util.List<com.cellrebel.sdk.networking.beans.request.GameInfoMetric> r6 = r13.k
            java.util.Iterator r6 = r6.iterator()
        L_0x0088:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x00dd
            java.lang.Object r7 = r6.next()
            com.cellrebel.sdk.networking.beans.request.GameInfoMetric r7 = (com.cellrebel.sdk.networking.beans.request.GameInfoMetric) r7
            java.lang.String r8 = r7.serverUrl
            if (r8 == 0) goto L_0x0088
            boolean r8 = r13.p
            if (r8 != 0) goto L_0x0088
            long r8 = java.lang.System.currentTimeMillis()
            long r8 = r8 - r4
            r10 = 30000(0x7530, double:1.4822E-319)
            int r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r12 <= 0) goto L_0x00ae
            long r4 = java.lang.System.currentTimeMillis()
            com.cellrebel.sdk.workers.BaseMetricsWorker.a((android.content.Context) r14, (com.cellrebel.sdk.networking.beans.request.BaseMetric) r1)
        L_0x00ae:
            com.cellrebel.sdk.networking.beans.request.GameInfoMetric r8 = r7.convertToGameInfo(r1)
            r9 = 0
            r8.isUnderAdditionalLoad = r9
            boolean r9 = r0.booleanValue()
            if (r9 != 0) goto L_0x00bf
            r13.c(r8)
            goto L_0x0088
        L_0x00bf:
            com.cellrebel.sdk.networking.beans.response.Settings r9 = r13.j
            java.lang.Boolean r9 = r9.gameServersCacheEnabled()
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto L_0x00d9
            java.util.Map<java.lang.String, com.cellrebel.sdk.networking.beans.request.GameInfoMetric> r9 = r13.l
            java.lang.String r7 = r7.serverUrl
            boolean r7 = r9.containsKey(r7)
            if (r7 == 0) goto L_0x00d9
            r13.a((com.cellrebel.sdk.networking.beans.request.GameInfoMetric) r8)
            goto L_0x0088
        L_0x00d9:
            r13.a(r14, r8, r3, r2)
            goto L_0x0088
        L_0x00dd:
            java.util.Map<java.lang.String, com.cellrebel.sdk.networking.beans.request.GameInfoMetric> r14 = r13.l
            r14.clear()
            r13.a()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cellrebel.sdk.workers.CollectGameWorker.a(android.content.Context):void");
    }

    /* access modifiers changed from: package-private */
    public void a(Context context, GameInfoMetric gameInfoMetric) {
        Objects.toString(gameInfoMetric.latency);
        String str = gameInfoMetric.serverUrl;
        Objects.toString(gameInfoMetric);
        Objects.toString(gameInfoMetric.pingsCount);
        if (gameInfoMetric.latency.floatValue() > 998.0f) {
            gameInfoMetric.failedMeasurementsCount = Float.valueOf(gameInfoMetric.failedMeasurementsCount.floatValue() + 1.0f);
        }
        gameInfoMetric.latencyType = this.o;
        gameInfoMetric.isSending = false;
        gameInfoMetric.isSent = false;
        gameInfoMetric.pingsCount = Float.valueOf(gameInfoMetric.pingsCount.floatValue() + 1.0f);
        this.l.put(gameInfoMetric.serverUrl, gameInfoMetric.copy());
        b(gameInfoMetric);
        gameInfoMetric.save();
    }

    /* access modifiers changed from: package-private */
    public void a(Context context, GameInfoMetric gameInfoMetric, int i, int i2) {
        gameInfoMetric.jitter = Float.valueOf(0.0f);
        int i3 = 0;
        gameInfoMetric.isCached = false;
        int i4 = 0;
        int i5 = 0;
        while (i3 < i) {
            try {
                InetAddress byName = InetAddress.getByName(gameInfoMetric.serverUrl);
                gameInfoMetric.serverIp = byName.getHostAddress();
                PingResult a = Ping.a(byName).a(i2).a();
                a.a();
                if (a.a() > 0.0f) {
                    i5 = (int) a.a();
                    this.o = 1;
                } else {
                    AndroidPing androidPing = new AndroidPing(byName);
                    androidPing.a(i2);
                    androidPing.run();
                    i5 = (int) androidPing.f;
                    this.o = 2;
                }
            } catch (UnknownHostException e) {
                e.toString();
                gameInfoMetric.latency = Float.valueOf(999.0f);
                a(context, gameInfoMetric);
                return;
            } catch (Throwable unused) {
            }
            if (i5 == 0) {
                i5 = 999;
            }
            if (gameInfoMetric.pingsCount.floatValue() > 0.0f) {
                Objects.toString(gameInfoMetric.pingsCount);
                Objects.toString(gameInfoMetric.latency);
                double floatValue = (double) (((gameInfoMetric.pingsCount.floatValue() * gameInfoMetric.latency.floatValue()) + ((float) i5)) / (gameInfoMetric.pingsCount.floatValue() + 1.0f));
                Double.isNaN(floatValue);
                gameInfoMetric.latency = Float.valueOf(((float) Math.round(floatValue * 100.0d)) / 100.0f);
                Objects.toString(gameInfoMetric.latency);
                gameInfoMetric.setJitter(i5, i4);
            } else {
                gameInfoMetric.latency = Float.valueOf((float) i5);
            }
            a(context, gameInfoMetric);
            i3++;
            i4 = i5;
        }
    }

    public void a(Context context, List<GameInfoMetric> list) {
        this.k = list;
        a(context);
    }

    /* access modifiers changed from: package-private */
    public void a(GameInfoMetric gameInfoMetric) {
        GameInfoMetric gameInfoMetric2 = this.l.get(gameInfoMetric.serverUrl);
        Objects.toString(gameInfoMetric2);
        if (gameInfoMetric2 != null) {
            gameInfoMetric.isSending = false;
            gameInfoMetric.pingsCount = gameInfoMetric2.pingsCount;
            gameInfoMetric.serverIp = gameInfoMetric2.serverIp;
            gameInfoMetric.jitter = gameInfoMetric2.jitter;
            gameInfoMetric.latencyType = gameInfoMetric2.latencyType;
            if (gameInfoMetric2.latency.floatValue() > 998.0f) {
                gameInfoMetric.failedMeasurementsCount = Float.valueOf(gameInfoMetric.failedMeasurementsCount.floatValue() + 1.0f);
            }
            gameInfoMetric.isSent = false;
            gameInfoMetric.isCached = true;
            gameInfoMetric.latency = gameInfoMetric2.latency;
            gameInfoMetric.save();
        }
    }

    public void a(boolean z) {
        this.p = z;
    }

    /* access modifiers changed from: package-private */
    public void c(GameInfoMetric gameInfoMetric) {
        gameInfoMetric.isSending = false;
        gameInfoMetric.pingsCount = Float.valueOf(gameInfoMetric.pingsCount.floatValue() + 1.0f);
        gameInfoMetric.latency = Float.valueOf(999.0f);
        gameInfoMetric.failedMeasurementsCount = Float.valueOf(gameInfoMetric.failedMeasurementsCount.floatValue() + 1.0f);
        gameInfoMetric.isSent = false;
        gameInfoMetric.saveOffline();
    }
}

package com.cellrebel.sdk.tti;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.UByte$$ExternalSyntheticBackport0;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;

public class LatencyMeasurer {
    private final OkHttpClient a;
    /* access modifiers changed from: private */
    public final List<Integer> b = new ArrayList();
    /* access modifiers changed from: private */
    public WebSocket c;
    /* access modifiers changed from: private */
    public CountDownLatch d;
    /* access modifiers changed from: private */
    public long e;
    /* access modifiers changed from: private */
    public long f;

    class a extends WebSocketListener {
        final /* synthetic */ String a;
        final /* synthetic */ String b;
        final /* synthetic */ int c;

        a(String str, String str2, int i) {
            this.a = str;
            this.b = str2;
            this.c = i;
        }

        public void onClosed(WebSocket webSocket, int i, String str) {
        }

        public void onFailure(WebSocket webSocket, Throwable th, Response response) {
            th.getMessage();
            LatencyMeasurer.this.c.close(1000, (String) null);
            LatencyMeasurer.this.d.countDown();
        }

        public void onMessage(WebSocket webSocket, String str) {
            if (str.startsWith("PONG ")) {
                long unused = LatencyMeasurer.this.f = System.currentTimeMillis();
                LatencyMeasurer.this.b.add(Integer.valueOf(UByte$$ExternalSyntheticBackport0.m$1(LatencyMeasurer.this.f - LatencyMeasurer.this.e)));
                if (LatencyMeasurer.this.b.size() < this.c) {
                    LatencyMeasurer.this.a(webSocket);
                    return;
                }
                LatencyMeasurer.this.c.close(1000, (String) null);
                LatencyMeasurer.this.d.countDown();
            }
        }

        public void onOpen(WebSocket webSocket, Response response) {
            webSocket.send("HI " + this.a + " " + this.b);
            webSocket.send("GETIP");
            webSocket.send("CAPABILITIES");
            LatencyMeasurer.this.a(webSocket);
        }
    }

    public LatencyMeasurer(OkHttpClient okHttpClient) {
        this.a = okHttpClient;
    }

    /* access modifiers changed from: private */
    public void a(WebSocket webSocket) {
        this.e = System.currentTimeMillis();
        webSocket.send("PING ");
    }

    public List<Integer> a(String str, int i, int i2, String str2, String str3) {
        WebSocket webSocket;
        try {
            Request build = new Request.Builder().url(str).build();
            this.d = new CountDownLatch(1);
            this.c = this.a.newWebSocket(build, new a(str2, str3, i));
            if (!this.d.await((long) i2, TimeUnit.SECONDS) && (webSocket = this.c) != null) {
                webSocket.cancel();
            }
            return this.b;
        } catch (InterruptedException unused) {
            return null;
        }
    }
}

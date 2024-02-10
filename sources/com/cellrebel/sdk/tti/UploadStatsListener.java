package com.cellrebel.sdk.tti;

import com.ironsource.sdk.c.e;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import org.json.JSONException;
import org.json.JSONObject;

public class UploadStatsListener {
    private final String a = "t";
    private final String b = "u";
    private final String c = "b";
    private final String d = e.a;
    private final OkHttpClient e;
    /* access modifiers changed from: private */
    public WebSocket f;
    /* access modifiers changed from: private */
    public String g = null;
    /* access modifiers changed from: private */
    public String h = null;
    /* access modifiers changed from: private */
    public long i = 0;
    /* access modifiers changed from: private */
    public long j = 0;
    /* access modifiers changed from: private */
    public long k = 0;

    public interface EventCallback {
        void a();

        void b();

        void c();
    }

    class a extends WebSocketListener {
        final /* synthetic */ String a;
        final /* synthetic */ String b;
        final /* synthetic */ int c;
        final /* synthetic */ int d;
        final /* synthetic */ EventCallback e;

        a(String str, String str2, int i, int i2, EventCallback eventCallback) {
            this.a = str;
            this.b = str2;
            this.c = i;
            this.d = i2;
            this.e = eventCallback;
        }

        public void onClosed(WebSocket webSocket, int i, String str) {
            EventCallback eventCallback = this.e;
            if (eventCallback != null) {
                eventCallback.c();
            }
        }

        public void onFailure(WebSocket webSocket, Throwable th, Response response) {
            th.getMessage();
            UploadStatsListener.this.f.close(1000, (String) null);
            EventCallback eventCallback = this.e;
            if (eventCallback != null) {
                eventCallback.b();
            }
        }

        public void onMessage(WebSocket webSocket, String str) {
            if (str.startsWith("HELLO")) {
                Matcher matcher = Pattern.compile("^HELLO ([^ ]+)(?: \\(([^)]+)\\))?( .+)$").matcher(str);
                if (matcher.find()) {
                    String unused = UploadStatsListener.this.g = matcher.group(1);
                    String group = matcher.group(2);
                    if (group != null) {
                        UploadStatsListener uploadStatsListener = UploadStatsListener.this;
                        String unused2 = uploadStatsListener.g = UploadStatsListener.this.g + " (" + group + ")";
                    }
                    String group2 = matcher.group(3);
                    if (group2 != null) {
                        String unused3 = UploadStatsListener.this.h = group2.trim();
                    }
                }
            } else if (this.e != null && str.contains("{\"t\":\"u\"}")) {
                this.e.a();
            } else if (str.startsWith("{")) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.has("t") && jSONObject.getString("t").equals("u") && jSONObject.has("b")) {
                        if (jSONObject.has(e.a)) {
                            int i = jSONObject.getInt("b");
                            int i2 = jSONObject.getInt(e.a);
                            long j = (long) i;
                            if (j - UploadStatsListener.this.i > 0) {
                                if (UploadStatsListener.this.k == 0) {
                                    long unused4 = UploadStatsListener.this.k = (long) i2;
                                }
                                long unused5 = UploadStatsListener.this.i = j;
                                long unused6 = UploadStatsListener.this.j = (long) i2;
                            }
                        }
                    }
                } catch (JSONException unused7) {
                }
            }
        }

        public void onOpen(WebSocket webSocket, Response response) {
            webSocket.send("HI " + this.a + " " + this.b);
            webSocket.send("GETIP");
            webSocket.send("CAPABILITIES");
            webSocket.send("UPLOAD_STATS " + this.c + " " + this.d + " 0");
        }
    }

    public UploadStatsListener(OkHttpClient okHttpClient) {
        this.e = okHttpClient;
    }

    public void a() {
        this.f.cancel();
    }

    public void a(String str, String str2, String str3, int i2, int i3, EventCallback eventCallback) {
        this.f = this.e.newWebSocket(new Request.Builder().url(str).build(), new a(str2, str3, i2, i3, eventCallback));
    }

    public long b() {
        return this.i;
    }

    public long c() {
        return this.j;
    }

    public long d() {
        return this.k;
    }

    public String e() {
        return this.h;
    }

    public String f() {
        return this.g;
    }

    public void g() {
        this.f.close(1000, (String) null);
    }
}

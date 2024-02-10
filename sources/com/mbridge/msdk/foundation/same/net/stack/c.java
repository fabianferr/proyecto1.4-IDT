package com.mbridge.msdk.foundation.same.net.stack;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.c.e;
import com.mbridge.msdk.c.f;
import com.mbridge.msdk.foundation.same.net.dns.MBDns;
import com.mbridge.msdk.foundation.same.net.g.d;
import com.mbridge.msdk.foundation.same.report.k;
import com.mbridge.msdk.foundation.same.report.q;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.thrid.okhttp.ConnectionPool;
import com.mbridge.msdk.thrid.okhttp.Dispatcher;
import com.mbridge.msdk.thrid.okhttp.EventListener;
import com.mbridge.msdk.thrid.okhttp.OkHttpClient;
import java.io.Serializable;
import java.net.URLEncoder;
import java.util.concurrent.TimeUnit;

/* compiled from: OKHTTPClientManager */
public final class c {
    private OkHttpClient a;
    private e b;
    private String c;

    /* compiled from: OKHTTPClientManager */
    private static final class a {
        /* access modifiers changed from: private */
        public static final c a = new c();
    }

    private c() {
        this.a = null;
        this.c = "";
    }

    public static c a() {
        return a.a;
    }

    public final synchronized OkHttpClient b() {
        if (this.a == null) {
            Dispatcher dispatcher = new Dispatcher();
            dispatcher.setMaxRequestsPerHost(50);
            dispatcher.setMaxRequests(256);
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.readTimeout(100, TimeUnit.SECONDS);
            builder.connectTimeout(60, TimeUnit.SECONDS);
            builder.writeTimeout(60, TimeUnit.SECONDS);
            builder.connectionPool(new ConnectionPool(32, 5, TimeUnit.MINUTES));
            builder.dispatcher(dispatcher);
            builder.eventListener(new EventListener() {
            });
            builder.dns(new MBDns());
            this.a = builder.build();
        }
        return this.a;
    }

    public final b c() {
        b bVar = new b();
        bVar.f = this.c;
        return bVar;
    }

    public final boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (this.b == null) {
                this.b = f.a().g(com.mbridge.msdk.foundation.controller.b.d().h());
            }
            e eVar = this.b;
            if (eVar == null) {
                return false;
            }
            String y = eVar.y();
            String str2 = d.a().a;
            if (TextUtils.isEmpty(y) || !str.startsWith(y) || TextUtils.equals(y, str2)) {
                return false;
            }
            this.c = y;
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public final void a(b bVar) {
        if (bVar != null) {
            final b a2 = b.a(bVar);
            com.mbridge.msdk.foundation.same.f.b.a().execute(new Runnable() {
                public final void run() {
                    try {
                        StringBuilder sb = new StringBuilder("key=2000102&app_id=");
                        sb.append(com.mbridge.msdk.foundation.controller.b.d().h());
                        sb.append("&status=");
                        sb.append(a2.a);
                        sb.append("&domain=");
                        sb.append(a2.f);
                        sb.append("&method=");
                        sb.append(a2.d);
                        sb.append("&");
                        if (!TextUtils.isEmpty(a2.h)) {
                            sb.append("dns_r=");
                            sb.append(a2.h);
                            sb.append("&dns_d=");
                            sb.append(a2.g);
                            sb.append("&host=");
                            sb.append(a2.e);
                            sb.append("&");
                            if (TextUtils.isEmpty(a2.j)) {
                                if (TextUtils.isEmpty(a2.c)) {
                                    sb.append("call_d=");
                                    sb.append(a2.b);
                                    sb.append("&connect_d=");
                                    sb.append(a2.i);
                                    sb.append("&connection_d=");
                                    sb.append(a2.k);
                                } else {
                                    sb.append("connect_d=");
                                    sb.append(a2.i);
                                    sb.append("&connection_e=");
                                    sb.append(a2.c);
                                }
                            } else if (!TextUtils.isEmpty(a2.j)) {
                                sb.append("connect_e=");
                                sb.append(a2.j);
                            } else if (!TextUtils.isEmpty(a2.c)) {
                                sb.append("connect_e=");
                                sb.append(a2.c);
                            }
                        } else if (!TextUtils.isEmpty(a2.c)) {
                            sb.append("connect_e=");
                            sb.append(a2.c);
                        } else if (!TextUtils.isEmpty(a2.j)) {
                            sb.append("connect_e=");
                            sb.append(a2.j);
                        }
                        if (k.a().c()) {
                            k.a().a(sb.toString());
                            return;
                        }
                        c cVar = c.this;
                        String sb2 = sb.toString();
                        Context g = com.mbridge.msdk.foundation.controller.b.d().g();
                        com.mbridge.msdk.foundation.same.report.d.a aVar = new com.mbridge.msdk.foundation.same.report.d.a(g);
                        com.mbridge.msdk.foundation.same.net.h.d a2 = q.a(g);
                        a2.a("data", URLEncoder.encode(sb2, "utf-8"));
                        a2.a("m_sdk", "msdk");
                        aVar.post(0, d.a().a, a2, new com.mbridge.msdk.foundation.same.report.d.b() {
                            public final void onSuccess(String str) {
                                aa.a("OKHTTPClientManager", "report success");
                            }

                            public final void onFailed(String str) {
                                aa.a("OKHTTPClientManager", "report failed");
                            }
                        });
                    } catch (Exception e) {
                        aa.d("OKHTTPClientManager", e.getMessage());
                    }
                }
            });
        }
    }

    /* compiled from: OKHTTPClientManager */
    public static class b implements Serializable {
        public int a;
        public long b = 0;
        public String c = "";
        public String d = "";
        public String e = "";
        public String f = "";
        public long g = 0;
        public String h = "";
        public long i = 0;
        public String j = "";
        public long k = 0;

        public static b a(b bVar) {
            b bVar2 = new b();
            bVar2.a = bVar.a;
            bVar2.d = bVar.d;
            bVar2.f = bVar.f;
            bVar2.b = bVar.b;
            bVar2.i = bVar.i;
            bVar2.c = bVar.c;
            bVar2.h = bVar.h;
            bVar2.g = bVar.g;
            bVar2.e = bVar.e;
            bVar2.j = bVar.j;
            bVar2.k = bVar.k;
            return bVar2;
        }
    }
}

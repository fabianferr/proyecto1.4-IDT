package com.mbridge.msdk.foundation.same.net.stack;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.same.net.a;
import com.mbridge.msdk.foundation.same.net.dns.MBDns;
import com.mbridge.msdk.foundation.same.net.f.b;
import com.mbridge.msdk.foundation.same.net.j;
import com.mbridge.msdk.foundation.same.net.stack.c;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.thrid.okhttp.Call;
import com.mbridge.msdk.thrid.okhttp.Connection;
import com.mbridge.msdk.thrid.okhttp.EventListener;
import com.mbridge.msdk.thrid.okhttp.Headers;
import com.mbridge.msdk.thrid.okhttp.MediaType;
import com.mbridge.msdk.thrid.okhttp.OkHttpClient;
import com.mbridge.msdk.thrid.okhttp.Protocol;
import com.mbridge.msdk.thrid.okhttp.Request;
import com.mbridge.msdk.thrid.okhttp.RequestBody;
import com.mbridge.msdk.thrid.okhttp.Response;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class OkHttpStack implements b {
    private final OkHttpClient mClient = c.a.a.b();

    private static void setConnectionParametersForRequest(Request.Builder builder, j<?> jVar) throws IOException {
        switch (jVar.a()) {
            case 0:
                builder.get();
                return;
            case 1:
                builder.post(createRequestBody(jVar));
                return;
            case 2:
                builder.put(createRequestBody(jVar));
                return;
            case 3:
                builder.delete();
                return;
            case 4:
                builder.head();
                return;
            case 5:
                builder.method("OPTIONS", (RequestBody) null);
                return;
            case 6:
                builder.method("TRACE", (RequestBody) null);
                return;
            case 7:
                builder.patch(createRequestBody(jVar));
                return;
            default:
                throw new IllegalStateException("Unknown method type.");
        }
    }

    private static RequestBody createRequestBody(j jVar) {
        byte[] f = jVar.f();
        if (f == null) {
            return null;
        }
        return RequestBody.create((MediaType) null, f);
    }

    public b performRequest(j<?> jVar) throws IOException {
        int i = jVar.i();
        int j = jVar.j();
        int k = jVar.k();
        int l = jVar.l();
        int m = jVar.m();
        if (j == 0) {
            j = i;
        }
        if (k == 0) {
            k = i;
        }
        if (l != 0) {
            i = l;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(Protocol.HTTP_1_1);
        arrayList.add(Protocol.HTTP_2);
        OkHttpClient.Builder eventListener = this.mClient.newBuilder().protocols(arrayList).readTimeout((long) k, TimeUnit.MILLISECONDS).connectTimeout((long) j, TimeUnit.MILLISECONDS).writeTimeout((long) i, TimeUnit.MILLISECONDS).eventListener(new DefaultEventListener(jVar.b()));
        if (m > 0) {
            eventListener.callTimeout((long) m, TimeUnit.MILLISECONDS);
        }
        eventListener.dns(new MBDns());
        StringBuilder sb = new StringBuilder("connectTimeout: ");
        sb.append(j);
        sb.append(" readTimeout: ");
        sb.append(k);
        sb.append(" writeTimeout: ");
        sb.append(i);
        sb.append(" callTimeout: ");
        sb.append(m == 0 ? "not set" : Integer.valueOf(m));
        aa.a("OkHttpStack", sb.toString());
        Request.Builder builder = new Request.Builder();
        for (Map.Entry next : jVar.e().entrySet()) {
            builder.addHeader((String) next.getKey(), (String) next.getValue());
        }
        setConnectionParametersForRequest(builder, jVar);
        Response execute = eventListener.build().newCall(builder.url(jVar.b()).build()).execute();
        Headers headers = execute.headers();
        ArrayList arrayList2 = new ArrayList();
        int size = headers.size();
        for (int i2 = 0; i2 < size; i2++) {
            String name = headers.name(i2);
            String value = headers.value(i2);
            if (name != null) {
                arrayList2.add(new com.mbridge.msdk.foundation.same.net.d.b(name, value));
            }
        }
        return new b(execute.code(), arrayList2, execute.body().byteStream());
    }

    private static class DefaultEventListener extends EventListener {
        private long callDuring;
        private long callStart;
        private long connectDuring;
        private String connectErrorMessage;
        private long connectStart;
        private long connectionDuring;
        private long connectionStart;
        private long dnsDuring;
        private String dnsResult;
        private long dnsStart;
        private String hostName;
        private c.b httpStatus;
        private boolean isReportHttpStatus;
        private String method;

        public DefaultEventListener(String str) {
            try {
                boolean a = c.a().a(str);
                this.isReportHttpStatus = a;
                if (a) {
                    this.httpStatus = c.a().c();
                }
            } catch (Exception unused) {
                this.isReportHttpStatus = false;
                this.httpStatus = null;
            }
        }

        public void callStart(Call call) {
            super.callStart(call);
            try {
                a.a().b();
            } catch (Exception unused) {
            }
            if (this.isReportHttpStatus && this.httpStatus != null) {
                this.callStart = System.currentTimeMillis();
                if (call != null) {
                    try {
                        this.method = call.request().method();
                    } catch (Exception unused2) {
                        this.method = "";
                    }
                }
            }
        }

        public void dnsStart(Call call, String str) {
            super.dnsStart(call, str);
            if (this.isReportHttpStatus && this.httpStatus != null) {
                this.dnsStart = System.currentTimeMillis();
            }
        }

        public void dnsEnd(Call call, String str, List<InetAddress> list) {
            super.dnsEnd(call, str, list);
            if (this.isReportHttpStatus && this.httpStatus != null) {
                try {
                    this.dnsDuring = System.currentTimeMillis() - this.dnsStart;
                    if (TextUtils.isEmpty(str)) {
                        this.hostName = "unKnown";
                    } else {
                        this.hostName = str;
                    }
                    if (list != null) {
                        if (list.size() != 0) {
                            InetAddress inetAddress = list.get(0);
                            if (inetAddress != null) {
                                if (!TextUtils.isEmpty(inetAddress.getHostAddress())) {
                                    this.dnsResult = inetAddress.getHostAddress();
                                    return;
                                }
                            }
                            this.dnsResult = "unKnown";
                            return;
                        }
                    }
                    this.dnsResult = "unKnown";
                } catch (Exception e) {
                    aa.d("OkHttpStack", e.getMessage());
                    this.hostName = "";
                    this.dnsResult = "";
                }
            }
        }

        public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
            super.connectStart(call, inetSocketAddress, proxy);
            if (this.isReportHttpStatus && this.httpStatus != null) {
                this.connectStart = System.currentTimeMillis();
            }
        }

        public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
            super.connectEnd(call, inetSocketAddress, proxy, protocol);
            if (this.isReportHttpStatus && this.httpStatus != null) {
                this.connectDuring = System.currentTimeMillis() - this.connectStart;
                this.connectErrorMessage = "";
            }
            try {
                com.mbridge.msdk.c.c.a().d(call.request().url().host());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException iOException) {
            super.connectFailed(call, inetSocketAddress, proxy, protocol, iOException);
            if (this.isReportHttpStatus && this.httpStatus != null) {
                this.connectDuring = System.currentTimeMillis() - this.connectStart;
                this.connectErrorMessage = iOException != null ? iOException.getMessage() : "IO Exception";
            }
            try {
                com.mbridge.msdk.c.c.a().c(call.request().url().host());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void connectionAcquired(Call call, Connection connection) {
            super.connectionAcquired(call, connection);
            if (this.isReportHttpStatus && this.httpStatus != null) {
                this.connectionStart = System.currentTimeMillis();
            }
        }

        public void connectionReleased(Call call, Connection connection) {
            super.connectionReleased(call, connection);
            if (this.isReportHttpStatus && this.httpStatus != null) {
                this.connectionDuring = System.currentTimeMillis() - this.connectionStart;
            }
        }

        public void callEnd(Call call) {
            super.callEnd(call);
            try {
                a.a().c();
            } catch (Exception unused) {
            }
            if (this.isReportHttpStatus && this.httpStatus != null) {
                try {
                    this.callDuring = System.currentTimeMillis() - this.callStart;
                    this.httpStatus.a = 0;
                    this.httpStatus.d = this.method;
                    this.httpStatus.b = this.callDuring;
                    this.httpStatus.e = this.hostName;
                    this.httpStatus.g = this.dnsDuring;
                    this.httpStatus.h = this.dnsResult;
                    this.httpStatus.i = this.connectDuring;
                    this.httpStatus.k = this.connectionDuring;
                    c.a().a(this.httpStatus);
                } catch (Exception e) {
                    aa.d("OkHttpStack", e.getMessage());
                }
            }
        }

        public void callFailed(Call call, IOException iOException) {
            super.callFailed(call, iOException);
            try {
                a.a().d();
            } catch (Exception unused) {
            }
            if (this.isReportHttpStatus && this.httpStatus != null) {
                try {
                    this.callDuring = System.currentTimeMillis() - this.callStart;
                    if (!TextUtils.isEmpty(this.connectErrorMessage)) {
                        this.httpStatus.a = 1;
                        this.httpStatus.j = this.connectErrorMessage;
                    } else {
                        this.httpStatus.a = 2;
                    }
                    this.httpStatus.c = iOException != null ? iOException.getMessage() : "IO Exception";
                    this.httpStatus.b = this.callDuring;
                    this.httpStatus.e = this.hostName;
                    this.httpStatus.d = this.method;
                    this.httpStatus.g = this.dnsDuring;
                    this.httpStatus.h = this.dnsResult;
                    this.httpStatus.i = this.connectDuring;
                    this.httpStatus.k = this.connectionDuring;
                    c.a().a(this.httpStatus);
                } catch (Exception e) {
                    aa.d("OkHttpStack", e.getMessage());
                }
            }
        }
    }
}

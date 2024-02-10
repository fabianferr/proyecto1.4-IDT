package com.mbridge.msdk.foundation.same.net.stack;

import com.mbridge.msdk.foundation.same.net.a.b;
import com.mbridge.msdk.foundation.same.net.a.c;
import com.mbridge.msdk.foundation.same.net.j;
import com.mbridge.msdk.foundation.tools.aa;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import org.chromium.net.CronetEngine;
import org.chromium.net.UploadDataProviders;
import org.chromium.net.UrlRequest;

/* compiled from: CronetStack */
public final class a implements b {
    private CronetEngine a;
    private BlockingQueue<b> b = new ArrayBlockingQueue(2, true);

    public a() {
        aa.d("CronetStack", "Cronet stack init.");
        this.a = com.mbridge.msdk.foundation.same.net.a.a.a().b();
    }

    public final com.mbridge.msdk.foundation.same.net.f.b performRequest(j<?> jVar) throws IOException {
        int i;
        aa.d("CronetStack", "CronetStack request start : " + jVar.b() + " " + a(jVar));
        int l = jVar.l();
        int k = jVar.k();
        if (l == 0) {
            l = 30000;
        }
        if (k == 0) {
            k = 30000;
        }
        aa.d("CronetStack", "Cronet writeTimeout : " + l + " readTimeout : " + k);
        UrlRequest.Builder newUrlRequestBuilder = this.a.newUrlRequestBuilder(jVar.b(), new c(this.b), com.mbridge.msdk.foundation.same.net.a.a.a().c());
        int h = jVar.h();
        if (h != 1) {
            i = 4;
            if (!(h == 3 || h == 4)) {
                i = 3;
            }
        } else {
            i = 2;
        }
        UrlRequest.Builder allowDirectExecutor = newUrlRequestBuilder.setPriority(i).setHttpMethod(a(jVar)).allowDirectExecutor();
        if (jVar.e() != null) {
            for (Map.Entry next : jVar.e().entrySet()) {
                allowDirectExecutor.addHeader((String) next.getKey(), (String) next.getValue());
            }
        }
        if (jVar.f() != null) {
            allowDirectExecutor.setUploadDataProvider(UploadDataProviders.create(jVar.f()), com.mbridge.msdk.foundation.same.net.a.a.a().c());
        }
        UrlRequest build = allowDirectExecutor.build();
        build.start();
        com.mbridge.msdk.foundation.same.net.f.b bVar = null;
        try {
            b poll = this.b.poll((long) l, TimeUnit.MILLISECONDS);
            if (poll != null) {
                if (poll.a() == 0) {
                    poll = this.b.poll((long) k, TimeUnit.MILLISECONDS);
                }
                if (poll.a() == 1) {
                    bVar = poll.b();
                }
                if (poll.a() == 2) {
                    throw new IOException(poll.c());
                } else if (bVar != null) {
                    aa.d("CronetStack", "HttpResponse : " + bVar.a() + " content : " + bVar.c().toString());
                    return bVar;
                } else {
                    a(build, jVar);
                    this.b.clear();
                    aa.d("CronetStack", "response cancel because response timeout");
                    throw new IOException("Response timeout.");
                }
            } else {
                a(build, jVar);
                this.b.clear();
                aa.d("CronetStack", "Request cancel because request timeout");
                throw new IOException("request timeout.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }

    private void a(UrlRequest urlRequest, j<?> jVar) {
        if (urlRequest != null) {
            urlRequest.cancel();
        }
        if (jVar != null) {
            jVar.c();
        }
    }

    private String a(j<?> jVar) {
        switch (jVar.a()) {
            case 0:
                return "GET";
            case 1:
                return "POST";
            case 2:
                return "PUT";
            case 3:
                return "DELETE";
            case 4:
                return "HEAD";
            case 5:
                return "OPTIONS";
            case 6:
                return "TRACE";
            case 7:
                return "PATCH";
            default:
                throw new IllegalStateException("Unknown method type.");
        }
    }
}

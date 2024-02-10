package com.bytedance.sdk.component.b.a.a.a;

import android.text.TextUtils;
import com.bytedance.sdk.component.b.a.b;
import com.bytedance.sdk.component.b.a.c;
import com.bytedance.sdk.component.b.a.d;
import com.bytedance.sdk.component.b.a.h;
import com.bytedance.sdk.component.b.a.l;
import com.bytedance.sdk.component.b.a.m;
import com.bytedance.sdk.component.b.a.n;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: NetCall */
public class a implements b {
    l a;
    d b;
    private AtomicBoolean c = new AtomicBoolean(false);

    a(l lVar, d dVar) {
        this.a = lVar;
        this.b = dVar;
    }

    public n a() throws IOException {
        this.b.c().remove(this);
        this.b.d().add(this);
        if (this.b.c().size() + this.b.d().size() > this.b.a() || this.c.get()) {
            this.b.d().remove(this);
            return null;
        }
        try {
            if (this.a.a == null || this.a.a.a == null || this.a.a.a.size() <= 0) {
                return a(this.a);
            }
            ArrayList arrayList = new ArrayList(this.a.a.a);
            arrayList.add(new h() {
                public n a(h.a aVar) throws IOException {
                    return a.this.a(aVar.a());
                }
            });
            return ((h) arrayList.get(0)).a(new b(arrayList, this.a));
        } catch (Throwable th) {
            throw new IOException(th.getMessage());
        }
    }

    private boolean a(m mVar) {
        l lVar;
        if (mVar == null || (lVar = this.a) == null || !"POST".equalsIgnoreCase(lVar.c()) || mVar.f != m.a.BYTE_ARRAY_TYPE || mVar.e == null || mVar.e.length <= 0) {
            return false;
        }
        return true;
    }

    private boolean b(m mVar) {
        l lVar;
        if (mVar == null || (lVar = this.a) == null || !"POST".equalsIgnoreCase(lVar.c()) || mVar.f != m.a.STRING_TYPE || TextUtils.isEmpty(mVar.d)) {
            return false;
        }
        return true;
    }

    public n a(l lVar) throws IOException {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(lVar.b().a().toString()).openConnection();
            if (lVar.d() != null && lVar.d().size() > 0) {
                for (Map.Entry next : lVar.d().entrySet()) {
                    for (String addRequestProperty : (List) next.getValue()) {
                        httpURLConnection.addRequestProperty((String) next.getKey(), addRequestProperty);
                    }
                }
            }
            if (lVar.a != null) {
                if (lVar.a.c != null) {
                    httpURLConnection.setConnectTimeout((int) lVar.a.c.toMillis(lVar.a.b));
                }
                if (lVar.a.c != null) {
                    httpURLConnection.setReadTimeout((int) lVar.a.e.toMillis(lVar.a.d));
                }
            }
            if (lVar.f() == null) {
                httpURLConnection.setRequestMethod("GET");
            } else {
                if (!c() && lVar.f().c != null) {
                    httpURLConnection.addRequestProperty("Content-Type", lVar.f().c.a());
                }
                httpURLConnection.setRequestMethod(lVar.c());
                if ("POST".equalsIgnoreCase(lVar.c())) {
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    if (a(lVar.f())) {
                        outputStream.write(lVar.f().e);
                    } else if (b(lVar.f())) {
                        outputStream.write(lVar.f().d.getBytes());
                    }
                    outputStream.flush();
                    outputStream.close();
                }
            }
            httpURLConnection.connect();
            httpURLConnection.getResponseCode();
            if (this.c.get()) {
                httpURLConnection.disconnect();
                this.b.d().remove(this);
                return null;
            }
            f fVar = new f(httpURLConnection, lVar);
            this.b.d().remove(this);
            return fVar;
        } catch (Exception e) {
            throw new IOException(e.getMessage());
        } catch (Throwable th) {
            this.b.d().remove(this);
            throw th;
        }
    }

    private boolean c() {
        if (this.a.d() == null) {
            return false;
        }
        return this.a.d().containsKey("Content-Type");
    }

    public void a(final c cVar) {
        this.b.b().submit(new Runnable() {
            public void run() {
                try {
                    n a2 = a.this.a();
                    if (a2 == null) {
                        cVar.a((b) a.this, new IOException("response is null"));
                    } else {
                        cVar.a((b) a.this, a2);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    cVar.a((b) a.this, e);
                }
            }
        });
    }

    /* renamed from: b */
    public b clone() {
        return new a(this.a, this.b);
    }
}

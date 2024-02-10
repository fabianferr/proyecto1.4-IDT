package com.bytedance.sdk.component.b.a.a.a;

import android.text.TextUtils;
import com.bytedance.sdk.component.b.a.k;
import com.bytedance.sdk.component.b.a.l;
import com.bytedance.sdk.component.b.a.n;
import com.bytedance.sdk.component.b.a.o;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: NetResponse */
public class f extends n {
    HttpURLConnection a;
    l b;

    public long a() {
        return 0;
    }

    public long b() {
        return 0;
    }

    public String toString() {
        return "";
    }

    public f(HttpURLConnection httpURLConnection, l lVar) {
        this.a = httpURLConnection;
        this.b = lVar;
    }

    public int c() {
        try {
            return this.a.getResponseCode();
        } catch (Exception unused) {
            return -1;
        }
    }

    public boolean d() {
        return c() >= 200 && c() < 300;
    }

    public String e() throws IOException {
        return this.a.getResponseMessage();
    }

    public o f() {
        try {
            return new g(this.a);
        } catch (Exception unused) {
            return null;
        }
    }

    public com.bytedance.sdk.component.b.a.f g() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : this.a.getHeaderFields().entrySet()) {
            for (String str : (List) entry.getValue()) {
                if (!"Content-Range".equalsIgnoreCase((String) entry.getKey()) || c() != 206) {
                    arrayList.add(entry.getKey());
                    arrayList.add(str);
                }
            }
        }
        return new com.bytedance.sdk.component.b.a.f((String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    public String a(String str) {
        return this.a.getHeaderField(str);
    }

    public String a(String str, String str2) {
        return !TextUtils.isEmpty(a(str)) ? a(str) : str2;
    }

    public void close() {
        try {
            f().close();
        } catch (Exception unused) {
        }
    }

    public k h() {
        return k.HTTP_1_1;
    }
}

package com.teragence.library;

import androidx.webkit.ProxyConfig;
import com.teragence.client.h;
import com.teragence.client.i;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import org.apache.http.conn.ssl.SSLSocketFactory;

public class p2 implements r8 {
    /* access modifiers changed from: private */
    public HttpURLConnection a;

    class a implements HostnameVerifier {
        a() {
        }

        public boolean verify(String str, SSLSession sSLSession) {
            return str != null && str.equals(p2.this.a.getURL().getHost());
        }
    }

    public p2(Proxy proxy, String str, int i) {
        String str2;
        HttpURLConnection httpURLConnection = (HttpURLConnection) (proxy == null ? new URL(str).openConnection() : new URL(str).openConnection(proxy));
        this.a = httpURLConnection;
        httpURLConnection.setUseCaches(false);
        this.a.setDoOutput(true);
        this.a.setDoInput(true);
        this.a.setConnectTimeout(i);
        this.a.setReadTimeout(i);
        if (str.startsWith(ProxyConfig.MATCH_HTTPS)) {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) this.a;
            httpsURLConnection.setHostnameVerifier(new a());
            try {
                SSLContext instance = SSLContext.getInstance(SSLSocketFactory.TLS);
                instance.init((KeyManager[]) null, new TrustManager[]{new h()}, new SecureRandom());
                httpsURLConnection.setSSLSocketFactory(instance.getSocketFactory());
                return;
            } catch (NoSuchAlgorithmException e) {
                str2 = e.toString();
            } catch (KeyManagementException e2) {
                str2 = e2.toString();
            }
        } else {
            return;
        }
        i.b("setSSLSocketFactory", str2);
    }

    public List a() {
        LinkedList linkedList = new LinkedList();
        Map headerFields = this.a.getHeaderFields();
        if (headerFields != null) {
            for (String str : headerFields.keySet()) {
                List list = (List) headerFields.get(str);
                for (int i = 0; i < list.size(); i++) {
                    linkedList.add(new x7(str, (String) list.get(i)));
                }
            }
        }
        return linkedList;
    }

    public void a(int i) {
        this.a.setFixedLengthStreamingMode(i);
    }

    public void a(String str) {
        this.a.setRequestMethod(str);
    }

    public void a(String str, String str2) {
        this.a.setRequestProperty(str, str2);
    }

    public InputStream b() {
        return this.a.getErrorStream();
    }

    public void c() {
        this.a.disconnect();
    }

    public OutputStream d() {
        return this.a.getOutputStream();
    }

    public int e() {
        return this.a.getResponseCode();
    }

    public InputStream f() {
        return this.a.getInputStream();
    }
}

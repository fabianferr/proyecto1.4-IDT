package org.apache.http.impl.client;

import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.HttpVersion;
import org.apache.http.client.protocol.RequestAddCookies;
import org.apache.http.client.protocol.RequestAuthCache;
import org.apache.http.client.protocol.RequestClientConnControl;
import org.apache.http.client.protocol.RequestDefaultHeaders;
import org.apache.http.client.protocol.RequestProxyAuthentication;
import org.apache.http.client.protocol.RequestTargetAuthentication;
import org.apache.http.client.protocol.ResponseAuthCache;
import org.apache.http.client.protocol.ResponseProcessCookies;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.params.SyncBasicHttpParams;
import org.apache.http.protocol.BasicHttpProcessor;
import org.apache.http.protocol.RequestContent;
import org.apache.http.protocol.RequestExpectContinue;
import org.apache.http.protocol.RequestTargetHost;
import org.apache.http.protocol.RequestUserAgent;
import org.apache.http.util.VersionInfo;

public class DefaultHttpClient extends AbstractHttpClient {
    public DefaultHttpClient(ClientConnectionManager clientConnectionManager, HttpParams httpParams) {
        super(clientConnectionManager, httpParams);
    }

    public DefaultHttpClient(ClientConnectionManager clientConnectionManager) {
        super(clientConnectionManager, (HttpParams) null);
    }

    public DefaultHttpClient(HttpParams httpParams) {
        super((ClientConnectionManager) null, httpParams);
    }

    public DefaultHttpClient() {
        super((ClientConnectionManager) null, (HttpParams) null);
    }

    /* access modifiers changed from: protected */
    public HttpParams createHttpParams() {
        SyncBasicHttpParams syncBasicHttpParams = new SyncBasicHttpParams();
        setDefaultHttpParams(syncBasicHttpParams);
        return syncBasicHttpParams;
    }

    public static void setDefaultHttpParams(HttpParams httpParams) {
        HttpProtocolParams.setVersion(httpParams, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setContentCharset(httpParams, "ISO-8859-1");
        HttpConnectionParams.setTcpNoDelay(httpParams, true);
        HttpConnectionParams.setSocketBufferSize(httpParams, 8192);
        VersionInfo loadVersionInfo = VersionInfo.loadVersionInfo("org.apache.http.client", DefaultHttpClient.class.getClassLoader());
        String release = loadVersionInfo != null ? loadVersionInfo.getRelease() : VersionInfo.UNAVAILABLE;
        HttpProtocolParams.setUserAgent(httpParams, "Apache-HttpClient/" + release + " (java 1.5)");
    }

    /* access modifiers changed from: protected */
    public BasicHttpProcessor createHttpProcessor() {
        BasicHttpProcessor basicHttpProcessor = new BasicHttpProcessor();
        basicHttpProcessor.addInterceptor((HttpRequestInterceptor) new RequestDefaultHeaders());
        basicHttpProcessor.addInterceptor((HttpRequestInterceptor) new RequestContent());
        basicHttpProcessor.addInterceptor((HttpRequestInterceptor) new RequestTargetHost());
        basicHttpProcessor.addInterceptor((HttpRequestInterceptor) new RequestClientConnControl());
        basicHttpProcessor.addInterceptor((HttpRequestInterceptor) new RequestUserAgent());
        basicHttpProcessor.addInterceptor((HttpRequestInterceptor) new RequestExpectContinue());
        basicHttpProcessor.addInterceptor((HttpRequestInterceptor) new RequestAddCookies());
        basicHttpProcessor.addInterceptor((HttpResponseInterceptor) new ResponseProcessCookies());
        basicHttpProcessor.addInterceptor((HttpRequestInterceptor) new RequestAuthCache());
        basicHttpProcessor.addInterceptor((HttpResponseInterceptor) new ResponseAuthCache());
        basicHttpProcessor.addInterceptor((HttpRequestInterceptor) new RequestTargetAuthentication());
        basicHttpProcessor.addInterceptor((HttpRequestInterceptor) new RequestProxyAuthentication());
        return basicHttpProcessor;
    }
}

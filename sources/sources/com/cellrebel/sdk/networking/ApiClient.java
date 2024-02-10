package com.cellrebel.sdk.networking;

import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import com.cellrebel.sdk.utils.PreferencesManager;
import com.cellrebel.sdk.workers.TrackingManager;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import okhttp3.Cache;
import okhttp3.ConnectionSpec;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.TlsVersion;
import org.apache.http.client.cache.HeaderConstants;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static volatile ApiClient c;
    private ApiService a;
    private OkHttpClient b;

    private ApiClient() {
        if (c != null) {
            throw new RuntimeException("Use apiService() method to get the single instance of this class.");
        }
    }

    public static ApiService a() {
        return c().e();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Response a(Interceptor.Chain chain) {
        Request request = chain.request();
        String header = request.header("CustomTimeout");
        if (TextUtils.isEmpty(header)) {
            return chain.proceed(request);
        }
        request.newBuilder().removeHeader(header);
        int k = (int) PreferencesManager.m().k();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        return chain.withConnectTimeout(k, timeUnit).withReadTimeout(k, timeUnit).withWriteTimeout(k, timeUnit).proceed(request);
    }

    public static FullX509TrustManager b() {
        try {
            return new FullX509TrustManager((KeyStore) null);
        } catch (KeyStoreException | NoSuchAlgorithmException unused) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Response b(Interceptor.Chain chain) {
        Request request = chain.request();
        String w = PreferencesManager.m().w();
        return !TextUtils.isEmpty(w) ? chain.proceed(request.newBuilder().addHeader("Authorization", w).addHeader("Cache-Control", HeaderConstants.CACHE_CONTROL_NO_CACHE).build()) : chain.proceed(request);
    }

    private static ApiClient c() {
        if (c == null) {
            synchronized (ApiClient.class) {
                if (c == null) {
                    c = new ApiClient();
                }
            }
        }
        return c;
    }

    private OkHttpClient d() {
        OkHttpClient okHttpClient = this.b;
        if (okHttpClient != null) {
            return okHttpClient;
        }
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        OkHttpClient.Builder retryOnConnectionFailure = builder.readTimeout(60000, timeUnit).writeTimeout(60000, timeUnit).connectTimeout(60000, timeUnit).cache((Cache) null).retryOnConnectionFailure(true);
        PreferenceManager.getDefaultSharedPreferences(TrackingManager.getContext());
        retryOnConnectionFailure.authenticator(new TokenAuthenticator());
        retryOnConnectionFailure.addInterceptor(new ApiClient$$ExternalSyntheticLambda0());
        retryOnConnectionFailure.addInterceptor(new ApiClient$$ExternalSyntheticLambda1());
        try {
            SSLContext instance = SSLContext.getInstance("TLSv1.2");
            instance.init((KeyManager[]) null, (TrustManager[]) null, (SecureRandom) null);
            retryOnConnectionFailure.sslSocketFactory(new TLSSocketFactory(instance.getSocketFactory()), b());
        } catch (Exception | OutOfMemoryError e) {
            Log.e("OkHttp", "Error while setting TLS 1.2", e);
        }
        ConnectionSpec build = new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).tlsVersions(TlsVersion.TLS_1_2).build();
        ArrayList arrayList = new ArrayList();
        arrayList.add(build);
        arrayList.add(ConnectionSpec.COMPATIBLE_TLS);
        arrayList.add(ConnectionSpec.CLEARTEXT);
        retryOnConnectionFailure.connectionSpecs(arrayList);
        OkHttpClient build2 = retryOnConnectionFailure.build();
        this.b = build2;
        return build2;
    }

    private ApiService e() {
        if (this.a == null) {
            this.a = (ApiService) new Retrofit.Builder().baseUrl("https://metricreceiver.cellrebel.com/").addConverterFactory(GsonConverterFactory.create()).client(d()).build().create(ApiService.class);
        }
        return this.a;
    }
}

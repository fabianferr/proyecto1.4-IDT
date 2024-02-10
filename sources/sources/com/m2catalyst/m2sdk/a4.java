package com.m2catalyst.m2sdk;

import com.google.gson.GsonBuilder;
import com.m2catalyst.m2sdk.configuration.M2Configuration;
import com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLoggingApis;
import com.m2catalyst.m2sdk.r2;
import com.m2catalyst.m2sdk.speed_test.NDTApi;
import java.util.concurrent.TimeUnit;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.wire.WireConverterFactory;

/* compiled from: NetworkFactory.kt */
public final class a4 {
    public final r2 a = r2.a.a();

    /* compiled from: NetworkFactory.kt */
    public enum a {
        WIRE,
        JSON
    }

    /* compiled from: NetworkFactory.kt */
    public enum b {
        INGESTION,
        NDT
    }

    public final MonitorStatsLoggingApis a() {
        Retrofit a2 = a(b.INGESTION, a.WIRE);
        Class cls = MonitorStatsLoggingApis.class;
        Intrinsics.checkNotNullParameter(a2, "retrofit");
        Intrinsics.checkNotNullParameter(cls, "apiInterface");
        return (MonitorStatsLoggingApis) a2.create(cls);
    }

    public final NDTApi b() {
        Retrofit a2 = a(b.NDT, a.JSON);
        Class cls = NDTApi.class;
        Intrinsics.checkNotNullParameter(a2, "retrofit");
        Intrinsics.checkNotNullParameter(cls, "apiInterface");
        return (NDTApi) a2.create(cls);
    }

    public final Retrofit a(b bVar, a aVar) {
        String str;
        Converter.Factory factory;
        Intrinsics.checkNotNullParameter(bVar, "urlType");
        Intrinsics.checkNotNullParameter(aVar, "converterType");
        M2Configuration a2 = this.a.a(false);
        int ordinal = bVar.ordinal();
        if (ordinal == 0) {
            str = a2.getIngestionBaseUrl();
        } else if (ordinal == 1) {
            str = a2.getM2RemoteConfigBaseUrl();
        } else if (ordinal == 2) {
            str = a2.getNdtUrl();
        } else {
            throw new NoWhenBranchMatchedException();
        }
        int ordinal2 = aVar.ordinal();
        if (ordinal2 == 0) {
            factory = WireConverterFactory.create();
        } else if (ordinal2 == 1) {
            factory = GsonConverterFactory.create(new GsonBuilder().setLenient().create());
        } else {
            throw new NoWhenBranchMatchedException();
        }
        Retrofit.Builder baseUrl = new Retrofit.Builder().baseUrl(str);
        OkHttpClient.Builder newBuilder = new OkHttpClient().newBuilder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        OkHttpClient build = newBuilder.connectTimeout(30, timeUnit).readTimeout(30, timeUnit).writeTimeout(30, timeUnit).build();
        Intrinsics.checkNotNullExpressionValue(build, "OkHttpClient().newBuilde…TimeUnit.SECONDS).build()");
        Retrofit build2 = baseUrl.client(build).addConverterFactory(factory).build();
        Intrinsics.checkNotNullExpressionValue(build2, "Builder().baseUrl(url)\n …ter)\n            .build()");
        return build2;
    }
}

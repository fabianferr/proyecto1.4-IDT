package com.vungle.ads.internal.network;

import com.vungle.ads.AnalyticsClient;
import com.vungle.ads.internal.model.AdPayload;
import com.vungle.ads.internal.model.CommonRequestBody;
import com.vungle.ads.internal.model.ConfigPayload;
import com.vungle.ads.internal.network.converters.EmptyResponseConverter;
import com.vungle.ads.internal.network.converters.JsonConverter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.StringFormat;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonKt;
import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 !2\u00020\u0001:\u0001!B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J(\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J(\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0002J\u0018\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0002J\u001e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\f2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0006H\u0016J(\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J&\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\f2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J&\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00180\f2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0002\u001a\u00020\u00038\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\""}, d2 = {"Lcom/vungle/ads/internal/network/VungleApiImpl;", "Lcom/vungle/ads/internal/network/VungleApi;", "okHttpClient", "Lokhttp3/Call$Factory;", "(Lokhttp3/Call$Factory;)V", "appId", "", "emptyResponseConverter", "Lcom/vungle/ads/internal/network/converters/EmptyResponseConverter;", "getOkHttpClient$vungle_ads_release", "()Lokhttp3/Call$Factory;", "ads", "Lcom/vungle/ads/internal/network/Call;", "Lcom/vungle/ads/internal/model/AdPayload;", "ua", "path", "body", "Lcom/vungle/ads/internal/model/CommonRequestBody;", "config", "Lcom/vungle/ads/internal/model/ConfigPayload;", "defaultBuilder", "Lokhttp3/Request$Builder;", "defaultProtoBufBuilder", "pingTPAT", "Ljava/lang/Void;", "url", "ri", "sendErrors", "requestBody", "Lokhttp3/RequestBody;", "sendMetrics", "setAppId", "", "Companion", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: VungleApiImpl.kt */
public final class VungleApiImpl implements VungleApi {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String VUNGLE_VERSION = "7.0.0";
    private static final Json json = JsonKt.Json$default((Json) null, VungleApiImpl$Companion$json$1.INSTANCE, 1, (Object) null);
    private String appId;
    private final EmptyResponseConverter emptyResponseConverter = new EmptyResponseConverter();
    private final Call.Factory okHttpClient;

    public VungleApiImpl(Call.Factory factory) {
        Intrinsics.checkNotNullParameter(factory, "okHttpClient");
        this.okHttpClient = factory;
    }

    public final Call.Factory getOkHttpClient$vungle_ads_release() {
        return this.okHttpClient;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/vungle/ads/internal/network/VungleApiImpl$Companion;", "", "()V", "VUNGLE_VERSION", "", "json", "Lkotlinx/serialization/json/Json;", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: VungleApiImpl.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public void setAppId(String str) {
        Intrinsics.checkNotNullParameter(str, "appId");
        this.appId = str;
    }

    private final Request.Builder defaultBuilder(String str, String str2) {
        Request.Builder addHeader = new Request.Builder().url(str2).addHeader("User-Agent", str).addHeader("Vungle-Version", VUNGLE_VERSION).addHeader("Content-Type", "application/json");
        String str3 = this.appId;
        if (str3 != null) {
            addHeader.addHeader("X-Vungle-App-Id", str3);
        }
        return addHeader;
    }

    private final Request.Builder defaultProtoBufBuilder(String str, String str2) {
        Request.Builder addHeader = new Request.Builder().url(str2).addHeader("User-Agent", str).addHeader("Vungle-Version", VUNGLE_VERSION).addHeader("Content-Type", "application/x-protobuf");
        String str3 = this.appId;
        if (str3 != null) {
            addHeader.addHeader("X-Vungle-App-Id", str3);
        }
        return addHeader;
    }

    public Call<ConfigPayload> config(String str, String str2, CommonRequestBody commonRequestBody) {
        Intrinsics.checkNotNullParameter(str, "ua");
        Intrinsics.checkNotNullParameter(str2, "path");
        Intrinsics.checkNotNullParameter(commonRequestBody, "body");
        try {
            StringFormat stringFormat = json;
            KSerializer<Object> serializer = SerializersKt.serializer(stringFormat.getSerializersModule(), Reflection.typeOf(CommonRequestBody.class));
            Intrinsics.checkNotNull(serializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
            return new OkHttpCall<>(this.okHttpClient.newCall(defaultBuilder(str, str2).post(RequestBody.Companion.create(stringFormat.encodeToString(serializer, commonRequestBody), (MediaType) null)).build()), new JsonConverter(Reflection.typeOf(ConfigPayload.class)));
        } catch (Exception unused) {
            Call call = null;
            return null;
        }
    }

    public Call<AdPayload> ads(String str, String str2, CommonRequestBody commonRequestBody) {
        Intrinsics.checkNotNullParameter(str, "ua");
        Intrinsics.checkNotNullParameter(str2, "path");
        Intrinsics.checkNotNullParameter(commonRequestBody, "body");
        try {
            StringFormat stringFormat = json;
            KSerializer<Object> serializer = SerializersKt.serializer(stringFormat.getSerializersModule(), Reflection.typeOf(CommonRequestBody.class));
            Intrinsics.checkNotNull(serializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
            return new OkHttpCall<>(this.okHttpClient.newCall(defaultBuilder(str, str2).post(RequestBody.Companion.create(stringFormat.encodeToString(serializer, commonRequestBody), (MediaType) null)).build()), new JsonConverter(Reflection.typeOf(AdPayload.class)));
        } catch (Exception unused) {
            AnalyticsClient analyticsClient = AnalyticsClient.INSTANCE;
            AnalyticsClient.logError$vungle_ads_release$default(analyticsClient, 101, "Error with url: " + str2, (String) null, (String) null, (String) null, 28, (Object) null);
            Call call = null;
            return null;
        }
    }

    public Call<Void> ri(String str, String str2, CommonRequestBody commonRequestBody) {
        Intrinsics.checkNotNullParameter(str, "ua");
        Intrinsics.checkNotNullParameter(str2, "path");
        Intrinsics.checkNotNullParameter(commonRequestBody, "body");
        try {
            StringFormat stringFormat = json;
            KSerializer<Object> serializer = SerializersKt.serializer(stringFormat.getSerializersModule(), Reflection.typeOf(CommonRequestBody.class));
            Intrinsics.checkNotNull(serializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
            return new OkHttpCall<>(this.okHttpClient.newCall(defaultBuilder(str, str2).post(RequestBody.Companion.create(stringFormat.encodeToString(serializer, commonRequestBody), (MediaType) null)).build()), this.emptyResponseConverter);
        } catch (Exception unused) {
            AnalyticsClient analyticsClient = AnalyticsClient.INSTANCE;
            AnalyticsClient.logError$vungle_ads_release$default(analyticsClient, 101, "Error with url: " + str2, (String) null, (String) null, (String) null, 28, (Object) null);
            Call call = null;
            return null;
        }
    }

    public Call<Void> pingTPAT(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "ua");
        Intrinsics.checkNotNullParameter(str2, "url");
        return new OkHttpCall<>(this.okHttpClient.newCall(defaultBuilder(str, HttpUrl.Companion.get(str2).newBuilder().build().toString()).get().build()), this.emptyResponseConverter);
    }

    public Call<Void> sendMetrics(String str, String str2, RequestBody requestBody) {
        Intrinsics.checkNotNullParameter(str, "ua");
        Intrinsics.checkNotNullParameter(str2, "path");
        Intrinsics.checkNotNullParameter(requestBody, "requestBody");
        return new OkHttpCall<>(this.okHttpClient.newCall(defaultProtoBufBuilder(str, HttpUrl.Companion.get(str2).newBuilder().build().toString()).post(requestBody).build()), this.emptyResponseConverter);
    }

    public Call<Void> sendErrors(String str, String str2, RequestBody requestBody) {
        Intrinsics.checkNotNullParameter(str, "ua");
        Intrinsics.checkNotNullParameter(str2, "path");
        Intrinsics.checkNotNullParameter(requestBody, "requestBody");
        return new OkHttpCall<>(this.okHttpClient.newCall(defaultProtoBufBuilder(str, HttpUrl.Companion.get(str2).newBuilder().build().toString()).post(requestBody).build()), this.emptyResponseConverter);
    }
}

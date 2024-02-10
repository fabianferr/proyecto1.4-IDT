package com.vungle.ads.internal.network;

import android.util.Log;
import com.vungle.ads.AnalyticsClient;
import com.vungle.ads.TpatRetryFailure;
import com.vungle.ads.internal.load.BaseAdLoader;
import com.vungle.ads.internal.persistence.FilePreferences;
import com.vungle.ads.internal.protos.Sdk;
import com.vungle.ads.internal.util.PathProvider;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KTypeProjection;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.StringFormat;
import kotlinx.serialization.json.Json;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u0000 $2\u00020\u0001:\u0001$B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ$\u0010\u0015\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00170\u0016j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0017`\u0018H\u0002J\u0016\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\tJ\u0015\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\tH\u0000¢\u0006\u0002\b\u001eJ,\u0010\u001f\u001a\u00020\u001a2\"\u0010 \u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00170\u0016j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0017`\u0018H\u0002J\u0016\u0010!\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\tJ\u0016\u0010#\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\tR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006%"}, d2 = {"Lcom/vungle/ads/internal/network/TpatSender;", "", "vungleApiClient", "Lcom/vungle/ads/internal/network/VungleApiClient;", "placementId", "", "creativeId", "eventId", "ioExecutor", "Ljava/util/concurrent/Executor;", "pathProvider", "Lcom/vungle/ads/internal/util/PathProvider;", "(Lcom/vungle/ads/internal/network/VungleApiClient;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/concurrent/Executor;Lcom/vungle/ads/internal/util/PathProvider;)V", "getCreativeId", "()Ljava/lang/String;", "getEventId", "getPlacementId", "tpatFilePreferences", "Lcom/vungle/ads/internal/persistence/FilePreferences;", "getVungleApiClient", "()Lcom/vungle/ads/internal/network/VungleApiClient;", "getStoredTpats", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "pingUrl", "", "url", "executor", "resendStoredTpats", "resendStoredTpats$vungle_ads_release", "saveStoredTpats", "tpats", "sendTpat", "urlString", "sendWinNotification", "Companion", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: TpatSender.kt */
public final class TpatSender {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String FAILED_TPATS = "FAILED_TPATS";
    private static final int MAX_RETRIES = 5;
    private static final String TAG = "TpatSender";
    private final String creativeId;
    private final String eventId;
    private final String placementId;
    private final FilePreferences tpatFilePreferences;
    private final VungleApiClient vungleApiClient;

    public TpatSender(VungleApiClient vungleApiClient2, String str, String str2, String str3, Executor executor, PathProvider pathProvider) {
        Intrinsics.checkNotNullParameter(vungleApiClient2, "vungleApiClient");
        Intrinsics.checkNotNullParameter(executor, "ioExecutor");
        Intrinsics.checkNotNullParameter(pathProvider, "pathProvider");
        this.vungleApiClient = vungleApiClient2;
        this.placementId = str;
        this.creativeId = str2;
        this.eventId = str3;
        this.tpatFilePreferences = new FilePreferences(executor, pathProvider, "failedTpats");
    }

    public final VungleApiClient getVungleApiClient() {
        return this.vungleApiClient;
    }

    public final String getPlacementId() {
        return this.placementId;
    }

    public final String getCreativeId() {
        return this.creativeId;
    }

    public final String getEventId() {
        return this.eventId;
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/vungle/ads/internal/network/TpatSender$Companion;", "", "()V", "FAILED_TPATS", "", "MAX_RETRIES", "", "TAG", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: TpatSender.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final void sendWinNotification(String str, Executor executor) {
        Intrinsics.checkNotNullParameter(str, "urlString");
        Intrinsics.checkNotNullParameter(executor, "executor");
        executor.execute(new TpatSender$$ExternalSyntheticLambda2(this, str));
    }

    /* access modifiers changed from: private */
    /* renamed from: sendWinNotification$lambda-0  reason: not valid java name */
    public static final void m2305sendWinNotification$lambda0(TpatSender tpatSender, String str) {
        Intrinsics.checkNotNullParameter(tpatSender, "this$0");
        Intrinsics.checkNotNullParameter(str, "$urlString");
        BaseAdLoader.ErrorInfo pingTPAT = tpatSender.vungleApiClient.pingTPAT(str);
        if (pingTPAT != null) {
            AnalyticsClient analyticsClient = AnalyticsClient.INSTANCE;
            Sdk.SDKError.Reason reason = Sdk.SDKError.Reason.AD_WIN_NOTIFICATION_ERROR;
            analyticsClient.logError$vungle_ads_release(reason, "Fail to send " + str + ", error: " + pingTPAT.getDescription(), tpatSender.placementId, tpatSender.creativeId, tpatSender.eventId);
        }
    }

    public final void sendTpat(String str, Executor executor) {
        Intrinsics.checkNotNullParameter(str, "urlString");
        Intrinsics.checkNotNullParameter(executor, "executor");
        executor.execute(new TpatSender$$ExternalSyntheticLambda1(this, str));
    }

    /* access modifiers changed from: private */
    /* renamed from: sendTpat$lambda-1  reason: not valid java name */
    public static final void m2304sendTpat$lambda1(TpatSender tpatSender, String str) {
        TpatSender tpatSender2 = tpatSender;
        String str2 = str;
        Intrinsics.checkNotNullParameter(tpatSender2, "this$0");
        Intrinsics.checkNotNullParameter(str2, "$urlString");
        HashMap<String, Integer> storedTpats = tpatSender.getStoredTpats();
        int i = storedTpats.get(str2);
        if (i == null) {
            i = 0;
        }
        int intValue = i.intValue();
        BaseAdLoader.ErrorInfo pingTPAT = tpatSender2.vungleApiClient.pingTPAT(str2);
        if (pingTPAT != null) {
            if (!pingTPAT.getErrorIsTerminal()) {
                if (intValue >= 5) {
                    storedTpats.remove(str2);
                    tpatSender2.saveStoredTpats(storedTpats);
                    new TpatRetryFailure(str2).logErrorNoReturnValue$vungle_ads_release();
                } else {
                    storedTpats.put(str2, Integer.valueOf(intValue + 1));
                    tpatSender2.saveStoredTpats(storedTpats);
                }
            }
            Log.e(TAG, "TPAT failed with " + pingTPAT.getDescription() + ", url:" + str2);
            if (pingTPAT.getReason() == 29) {
                AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, Sdk.SDKMetric.SDKMetricType.NOTIFICATION_REDIRECT, 0, tpatSender2.placementId, (String) null, (String) null, str, 26, (Object) null);
                return;
            }
            AnalyticsClient analyticsClient = AnalyticsClient.INSTANCE;
            Sdk.SDKError.Reason reason = Sdk.SDKError.Reason.TPAT_ERROR;
            analyticsClient.logError$vungle_ads_release(reason, "Fail to send " + str2 + ", error: " + pingTPAT.getDescription(), tpatSender2.placementId, tpatSender2.creativeId, tpatSender2.eventId);
        } else if (intValue != 0) {
            storedTpats.remove(str2);
            tpatSender2.saveStoredTpats(storedTpats);
        }
    }

    private final HashMap<String, Integer> getStoredTpats() {
        String string = this.tpatFilePreferences.getString(FAILED_TPATS);
        if (string == null) {
            return new HashMap<>();
        }
        StringFormat stringFormat = Json.Default;
        KSerializer<Object> serializer = SerializersKt.serializer(stringFormat.getSerializersModule(), Reflection.typeOf(HashMap.class, KTypeProjection.Companion.invariant(Reflection.typeOf(String.class)), KTypeProjection.Companion.invariant(Reflection.typeOf(Integer.TYPE))));
        Intrinsics.checkNotNull(serializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
        return (HashMap) stringFormat.decodeFromString(serializer, string);
    }

    private final void saveStoredTpats(HashMap<String, Integer> hashMap) {
        FilePreferences filePreferences = this.tpatFilePreferences;
        StringFormat stringFormat = Json.Default;
        KSerializer<Object> serializer = SerializersKt.serializer(stringFormat.getSerializersModule(), Reflection.typeOf(HashMap.class, KTypeProjection.Companion.invariant(Reflection.typeOf(String.class)), KTypeProjection.Companion.invariant(Reflection.typeOf(Integer.TYPE))));
        Intrinsics.checkNotNull(serializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
        filePreferences.put(FAILED_TPATS, stringFormat.encodeToString(serializer, hashMap)).apply();
    }

    public final void resendStoredTpats$vungle_ads_release(Executor executor) {
        Intrinsics.checkNotNullParameter(executor, "executor");
        for (Map.Entry key : getStoredTpats().entrySet()) {
            sendTpat((String) key.getKey(), executor);
        }
    }

    public final void pingUrl(String str, Executor executor) {
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(executor, "executor");
        executor.execute(new TpatSender$$ExternalSyntheticLambda0(this, str));
    }

    /* access modifiers changed from: private */
    /* renamed from: pingUrl$lambda-3  reason: not valid java name */
    public static final void m2303pingUrl$lambda3(TpatSender tpatSender, String str) {
        Intrinsics.checkNotNullParameter(tpatSender, "this$0");
        Intrinsics.checkNotNullParameter(str, "$url");
        BaseAdLoader.ErrorInfo pingTPAT = tpatSender.vungleApiClient.pingTPAT(str);
        if (pingTPAT != null) {
            Log.e(TAG, "Ping URL failed with " + pingTPAT.getDescription() + ", url:" + str);
        }
    }
}

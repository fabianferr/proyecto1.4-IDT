package com.unity3d.services.ads.token;

import com.unity3d.services.core.configuration.ConfigurationReader;
import com.unity3d.services.core.configuration.InitializeEventsMetricSender;
import com.unity3d.services.core.configuration.PrivacyConfigStorage;
import com.unity3d.services.core.device.reader.GameSessionIdReader;
import com.unity3d.services.core.device.reader.builder.DeviceInfoReaderBuilder;
import com.unity3d.services.core.di.IServiceComponent;
import com.unity3d.services.core.di.IServiceProvider;
import com.unity3d.services.core.webview.WebViewApp;
import com.unity3d.services.core.webview.WebViewEventCategory;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.json.JSONArray;
import org.json.JSONException;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001f\u001a\u00020\u0013H\u0016J\u0012\u0010 \u001a\u00020\u00132\b\u0010!\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020$H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u0016\u0010\r\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000eX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u00138VX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00110\u0017X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u00118VX\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006%"}, d2 = {"Lcom/unity3d/services/ads/token/InMemoryTokenStorage;", "Lcom/unity3d/services/ads/token/TokenStorage;", "Lcom/unity3d/services/core/di/IServiceComponent;", "()V", "accessCounter", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "asyncTokenStorage", "Lcom/unity3d/services/ads/token/AsyncTokenStorage;", "getAsyncTokenStorage", "()Lcom/unity3d/services/ads/token/AsyncTokenStorage;", "asyncTokenStorage$delegate", "Lkotlin/Lazy;", "executorService", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "initToken", "", "nativeGeneratedToken", "", "getNativeGeneratedToken", "()Lkotlin/Unit;", "queue", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "token", "getToken", "()Ljava/lang/String;", "appendTokens", "tokens", "Lorg/json/JSONArray;", "createTokens", "deleteTokens", "setInitToken", "value", "triggerTokenAvailable", "withConfig", "", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: InMemoryTokenStorage.kt */
public final class InMemoryTokenStorage implements TokenStorage, IServiceComponent {
    private final MutableStateFlow<Integer> accessCounter = StateFlowKt.MutableStateFlow(-1);
    private final Lazy asyncTokenStorage$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new InMemoryTokenStorage$special$$inlined$inject$default$1(this, ""));
    private final ExecutorService executorService = Executors.newSingleThreadExecutor();
    private final MutableStateFlow<String> initToken = StateFlowKt.MutableStateFlow(null);
    private final ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();

    public IServiceProvider getServiceProvider() {
        return IServiceComponent.DefaultImpls.getServiceProvider(this);
    }

    private final AsyncTokenStorage getAsyncTokenStorage() {
        return (AsyncTokenStorage) this.asyncTokenStorage$delegate.getValue();
    }

    public void createTokens(JSONArray jSONArray) throws JSONException {
        Intrinsics.checkNotNullParameter(jSONArray, "tokens");
        deleteTokens();
        appendTokens(jSONArray);
    }

    public void appendTokens(JSONArray jSONArray) throws JSONException {
        Intrinsics.checkNotNullParameter(jSONArray, "tokens");
        this.accessCounter.compareAndSet(-1, 0);
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            this.queue.add(jSONArray.getString(i));
        }
        if (length > 0) {
            triggerTokenAvailable(false);
            getAsyncTokenStorage().onTokenAvailable();
        }
    }

    public void deleteTokens() {
        Integer value;
        this.queue.clear();
        MutableStateFlow<Integer> mutableStateFlow = this.accessCounter;
        do {
            value = mutableStateFlow.getValue();
            value.intValue();
        } while (!mutableStateFlow.compareAndSet(value, -1));
    }

    public String getToken() {
        Integer value;
        Number number;
        if (this.accessCounter.getValue().intValue() == -1) {
            return this.initToken.getValue();
        }
        if (this.queue.isEmpty()) {
            WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.TOKEN, TokenEvent.QUEUE_EMPTY, new Object[0]);
            return null;
        }
        MutableStateFlow<Integer> mutableStateFlow = this.accessCounter;
        do {
            value = mutableStateFlow.getValue();
            number = value;
        } while (!mutableStateFlow.compareAndSet(value, Integer.valueOf(number.intValue() + 1)));
        WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.TOKEN, TokenEvent.TOKEN_ACCESS, Integer.valueOf(number.intValue()));
        return this.queue.poll();
    }

    public Unit getNativeGeneratedToken() {
        new NativeTokenGenerator(this.executorService, new DeviceInfoReaderBuilder(new ConfigurationReader(), PrivacyConfigStorage.getInstance(), GameSessionIdReader.getInstance()), (String) null).generateToken(new InMemoryTokenStorage$$ExternalSyntheticLambda0());
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void _get_nativeGeneratedToken_$lambda$2(String str) {
        WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.TOKEN, TokenEvent.TOKEN_NATIVE_DATA, str);
    }

    public void setInitToken(String str) {
        String value;
        if (str != null) {
            MutableStateFlow<String> mutableStateFlow = this.initToken;
            do {
                value = mutableStateFlow.getValue();
                String str2 = value;
            } while (!mutableStateFlow.compareAndSet(value, str));
            triggerTokenAvailable(true);
            getAsyncTokenStorage().onTokenAvailable();
        }
    }

    private final void triggerTokenAvailable(boolean z) {
        InitializeEventsMetricSender.getInstance().sdkTokenDidBecomeAvailableWithConfig(z);
    }
}

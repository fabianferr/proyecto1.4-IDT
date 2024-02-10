package io.monedata.adapters;

import android.app.Application;
import android.content.Context;
import com.m2catalyst.m2sdk.external.M2SDK;
import com.m2catalyst.m2sdk.external.M2SDKConfiguration;
import io.monedata.adapters.m2catalyst.BuildConfig;
import io.monedata.models.Extras;
import io.monedata.partners.ConsentPartnerAdapter;
import io.monedata.partners.PartnerAdapter;
import io.monedata.partners.extensions.PartnerAdapterKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J!\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H@ø\u0001\u0000¢\u0006\u0002\u0010\u0012J\u0019\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rH@ø\u0001\u0000¢\u0006\u0002\u0010\u0014J\u0019\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rH@ø\u0001\u0000¢\u0006\u0002\u0010\u0014R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\b8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\t\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"Lio/monedata/adapters/M2Adapter;", "Lio/monedata/partners/ConsentPartnerAdapter;", "()V", "consentConfig", "Lio/monedata/adapters/M2Consent;", "getConsentConfig", "()Lio/monedata/adapters/M2Consent;", "isMonitoring", "", "()Z", "getAppName", "", "context", "Landroid/content/Context;", "onInitialize", "", "extras", "Lio/monedata/models/Extras;", "(Landroid/content/Context;Lio/monedata/models/Extras;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onStart", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onStop", "Companion", "adapter-m2catalyst_productionRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: M2Adapter.kt */
public final class M2Adapter extends ConsentPartnerAdapter {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String KEY_API = "apiKey";
    private final M2Consent consentConfig = M2Consent.INSTANCE;

    public M2Adapter() {
        super("m2catalyst", "M2Catalyst", BuildConfig.ADAPTER_VERSION);
    }

    private final boolean isMonitoring() {
        return M2SDK.INSTANCE.isMonitoring();
    }

    /* access modifiers changed from: protected */
    public M2Consent getConsentConfig() {
        return this.consentConfig;
    }

    /* access modifiers changed from: protected */
    public Object onInitialize(Context context, Extras extras, Continuation<? super Unit> continuation) {
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNull(applicationContext, "null cannot be cast to non-null type android.app.Application");
        Application application = (Application) applicationContext;
        PartnerAdapter partnerAdapter = this;
        M2SDKConfiguration build = new M2SDKConfiguration.Builder(application).withApiKey((String) PartnerAdapterKt.testNotNullOrEmpty(partnerAdapter, Extras.getString$default(extras, KEY_API, (String) null, 2, (Object) null))).withAppName(getAppName(context)).build();
        PartnerAdapterKt.testNotNull(partnerAdapter, build);
        M2SDK.INSTANCE.initialize(application, build);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: protected */
    public Object onStart(Context context, Continuation<? super Unit> continuation) {
        if (isMonitoring()) {
            return Unit.INSTANCE;
        }
        M2SDK m2sdk = M2SDK.INSTANCE;
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
        m2sdk.turnOnDataCollection(applicationContext);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: protected */
    public Object onStop(Context context, Continuation<? super Unit> continuation) {
        if (!isMonitoring()) {
            return Unit.INSTANCE;
        }
        M2SDK m2sdk = M2SDK.INSTANCE;
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
        m2sdk.turnOffDataCollection(applicationContext);
        return Unit.INSTANCE;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lio/monedata/adapters/M2Adapter$Companion;", "", "()V", "KEY_API", "", "adapter-m2catalyst_productionRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: M2Adapter.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private final String getAppName(Context context) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.m2344constructorimpl(context.getApplicationInfo().loadLabel(context.getPackageManager()).toString());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m2344constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m2350isFailureimpl(obj)) {
            obj = "Monedata";
        }
        return (String) obj;
    }
}

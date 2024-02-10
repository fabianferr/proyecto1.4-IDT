package io.monedata.adapters;

import android.app.Application;
import android.content.Context;
import com.teragence.client.Measurement;
import com.teragence.client.SdkControls;
import io.monedata.Settings;
import io.monedata.adapters.teragence.BuildConfig;
import io.monedata.partners.ConsentPartnerAdapter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000)\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0019\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\u0019\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0010\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0004\n\u0002\u0010\t\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Lio/monedata/adapters/TeragenceAdapter;", "Lio/monedata/partners/ConsentPartnerAdapter;", "()V", "consentConfig", "Lio/monedata/adapters/TeragenceConsent;", "getConsentConfig", "()Lio/monedata/adapters/TeragenceConsent;", "lifecycleCallbacks", "io/monedata/adapters/TeragenceAdapter$lifecycleCallbacks$1", "Lio/monedata/adapters/TeragenceAdapter$lifecycleCallbacks$1;", "makeMeasurement", "", "context", "Landroid/content/Context;", "onStart", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onStop", "registerLifecycleCallbacks", "unregisterLifecycleCallbacks", "adapter-teragence_productionRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: TeragenceAdapter.kt */
public final class TeragenceAdapter extends ConsentPartnerAdapter {
    private final TeragenceConsent consentConfig = TeragenceConsent.INSTANCE;
    private final TeragenceAdapter$lifecycleCallbacks$1 lifecycleCallbacks = new TeragenceAdapter$lifecycleCallbacks$1(this);

    public TeragenceAdapter() {
        super("teragence", "Teragence", BuildConfig.ADAPTER_VERSION);
    }

    /* access modifiers changed from: protected */
    public TeragenceConsent getConsentConfig() {
        return this.consentConfig;
    }

    /* access modifiers changed from: protected */
    public Object onStart(Context context, Continuation<? super Unit> continuation) {
        if (Settings.isBackgroundLocationEnabled(context)) {
            SdkControls.startBackgroundWork(context);
            return Unit.INSTANCE;
        }
        registerLifecycleCallbacks(context);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: protected */
    public Object onStop(Context context, Continuation<? super Unit> continuation) {
        SdkControls.stopBackgroundWork(context);
        unregisterLifecycleCallbacks(context);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public final void makeMeasurement(Context context) {
        new Measurement(context).make();
    }

    private final void registerLifecycleCallbacks(Context context) {
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNull(applicationContext, "null cannot be cast to non-null type android.app.Application");
        ((Application) applicationContext).registerActivityLifecycleCallbacks(this.lifecycleCallbacks);
        makeMeasurement(context);
    }

    private final void unregisterLifecycleCallbacks(Context context) {
        Context applicationContext = context.getApplicationContext();
        Application application = applicationContext instanceof Application ? (Application) applicationContext : null;
        if (application != null) {
            application.unregisterActivityLifecycleCallbacks(this.lifecycleCallbacks);
        }
    }
}

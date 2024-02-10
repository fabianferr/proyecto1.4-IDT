package io.monedata.adapters;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.umlaut.crowd.BuildConfig;
import com.umlaut.crowd.InsightCore;
import io.monedata.extensions.ExtrasKt;
import io.monedata.models.Extras;
import io.monedata.partners.ConsentPartnerAdapter;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0003J\u0019\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0002\u0010\rJ\u0019\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0002\u0010\rJ\u0019\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0002\u0010\rJ\u0018\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\bH\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Lio/monedata/adapters/UmlautAdapter;", "Lio/monedata/partners/ConsentPartnerAdapter;", "()V", "consentConfig", "Lio/monedata/adapters/UmlautConsent;", "getConsentConfig", "()Lio/monedata/adapters/UmlautConsent;", "hasPackageUsageStats", "", "context", "Landroid/content/Context;", "onExtras", "Lio/monedata/models/Extras;", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onStart", "", "onStop", "setUseCases", "enable", "adapter-umlaut_productionRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: UmlautAdapter.kt */
public final class UmlautAdapter extends ConsentPartnerAdapter {
    private final UmlautConsent consentConfig = UmlautConsent.INSTANCE;

    public UmlautAdapter() {
        super(BuildConfig.BUILD_TYPE, "Umlaut", io.monedata.adapters.umlaut.BuildConfig.ADAPTER_VERSION);
    }

    /* access modifiers changed from: protected */
    public UmlautConsent getConsentConfig() {
        return this.consentConfig;
    }

    /* access modifiers changed from: protected */
    public Object onExtras(Context context, Continuation<? super Extras> continuation) {
        return ExtrasKt.extrasOf(TuplesKt.to("guid", InsightCore.getGUID()));
    }

    /* access modifiers changed from: protected */
    public Object onStart(Context context, Continuation<? super Unit> continuation) {
        setUseCases(context, true);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: protected */
    public Object onStop(Context context, Continuation<? super Unit> continuation) {
        setUseCases(context, false);
        return Unit.INSTANCE;
    }

    private final boolean hasPackageUsageStats(Context context) {
        boolean z;
        boolean z2 = true;
        if (Build.VERSION.SDK_INT < 21) {
            return true;
        }
        try {
            Result.Companion companion = Result.Companion;
            UmlautAdapter umlautAdapter = this;
            Object systemService = context.getSystemService("appops");
            AppOpsManager appOpsManager = systemService instanceof AppOpsManager ? (AppOpsManager) systemService : null;
            if (appOpsManager == null || appOpsManager.checkOpNoThrow("android:get_usage_stats", Process.myUid(), context.getPackageName()) != 0) {
                z2 = false;
            }
            z = Result.m2344constructorimpl(Boolean.valueOf(z2));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            z = Result.m2344constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m2347exceptionOrNullimpl(z) != null) {
            z = false;
        }
        return ((Boolean) z).booleanValue();
    }

    private final void setUseCases(Context context, boolean z) {
        InsightCore.setAppUsageServiceEnabled(z && hasPackageUsageStats(context));
        InsightCore.setBackgroundTestServiceEnabled(z);
        InsightCore.setConnectivityTestEnabled(z);
        InsightCore.setCoverageMapperServiceEnabled(z);
        InsightCore.setTrafficAnalyzerEnabled(z);
        InsightCore.setVoiceServiceEnabled(z);
        InsightCore.setWifiScanServiceEnabled(z);
    }
}

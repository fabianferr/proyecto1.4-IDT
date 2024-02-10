package com.vungle.ads.internal.presenter;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.View;
import com.facebook.internal.NativeProtocol;
import com.vungle.ads.AnalyticsClient;
import com.vungle.ads.PrivacyUrlError;
import com.vungle.ads.ServiceLocator;
import com.vungle.ads.VungleError;
import com.vungle.ads.internal.ConfigManager;
import com.vungle.ads.internal.executor.Executors;
import com.vungle.ads.internal.model.AdPayload;
import com.vungle.ads.internal.network.TpatSender;
import com.vungle.ads.internal.network.VungleApiClient;
import com.vungle.ads.internal.omsdk.NativeOMTracker;
import com.vungle.ads.internal.privacy.PrivacyConsent;
import com.vungle.ads.internal.privacy.PrivacyManager;
import com.vungle.ads.internal.ui.PresenterAdOpenCallback;
import com.vungle.ads.internal.ui.PresenterAppLeftCallback;
import com.vungle.ads.internal.util.ExternalRouter;
import com.vungle.ads.internal.util.FileUtility;
import com.vungle.ads.internal.util.PathProvider;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 92\u00020\u0001:\u00019B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010#\u001a\u00020$J\u000e\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020'J\b\u0010(\u001a\u00020\fH\u0002J\u0012\u0010)\u001a\u00020$2\b\u0010*\u001a\u0004\u0018\u00010'H\u0002J\u0006\u0010+\u001a\u00020$J\u0012\u0010,\u001a\u00020$2\b\u0010-\u001a\u0004\u0018\u00010'H\u0002J\u0006\u0010.\u001a\u00020$J\u001a\u0010/\u001a\u00020$2\u0006\u00100\u001a\u00020'2\n\b\u0002\u00101\u001a\u0004\u0018\u00010'J\u0010\u00102\u001a\u00020$2\b\u00103\u001a\u0004\u0018\u00010\u000eJ\b\u00104\u001a\u00020$H\u0002J\b\u00105\u001a\u00020$H\u0002J\u000e\u00106\u001a\u00020$2\u0006\u00107\u001a\u000208R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0016\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\u001e\u001a\u00020\u001f8BX\u0002¢\u0006\f\n\u0004\b\"\u0010\u0016\u001a\u0004\b \u0010!¨\u0006:"}, d2 = {"Lcom/vungle/ads/internal/presenter/NativeAdPresenter;", "", "context", "Landroid/content/Context;", "delegate", "Lcom/vungle/ads/internal/presenter/NativePresenterDelegate;", "advertisement", "Lcom/vungle/ads/internal/model/AdPayload;", "executor", "Ljava/util/concurrent/Executor;", "(Landroid/content/Context;Lcom/vungle/ads/internal/presenter/NativePresenterDelegate;Lcom/vungle/ads/internal/model/AdPayload;Ljava/util/concurrent/Executor;)V", "adViewed", "", "bus", "Lcom/vungle/ads/internal/presenter/AdEventListener;", "currentDialog", "Landroid/app/Dialog;", "executors", "Lcom/vungle/ads/internal/executor/Executors;", "getExecutors", "()Lcom/vungle/ads/internal/executor/Executors;", "executors$delegate", "Lkotlin/Lazy;", "omTracker", "Lcom/vungle/ads/internal/omsdk/NativeOMTracker;", "pathProvider", "Lcom/vungle/ads/internal/util/PathProvider;", "getPathProvider", "()Lcom/vungle/ads/internal/util/PathProvider;", "pathProvider$delegate", "vungleApiClient", "Lcom/vungle/ads/internal/network/VungleApiClient;", "getVungleApiClient", "()Lcom/vungle/ads/internal/network/VungleApiClient;", "vungleApiClient$delegate", "detach", "", "initOMTracker", "omSdkData", "", "needShowGdpr", "onDownload", "ctaUrl", "onImpression", "onPrivacy", "privacyUrl", "prepare", "processCommand", "action", "value", "setEventListener", "listener", "showGdpr", "start", "startTracking", "rootView", "Landroid/view/View;", "Companion", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: NativeAdPresenter.kt */
public final class NativeAdPresenter {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String DOWNLOAD = "download";
    public static final String OPEN_PRIVACY = "openPrivacy";
    private static final String TAG = Reflection.getOrCreateKotlinClass(NativeAdPresenter.class).getSimpleName();
    public static final String TPAT = "tpat";
    public static final String VIDEO_VIEWED = "videoViewed";
    private boolean adViewed;
    /* access modifiers changed from: private */
    public final AdPayload advertisement;
    private AdEventListener bus;
    private final Context context;
    private Dialog currentDialog;
    private final NativePresenterDelegate delegate;
    /* access modifiers changed from: private */
    public Executor executor;
    private final Lazy executors$delegate;
    private NativeOMTracker omTracker;
    private final Lazy pathProvider$delegate;
    private final Lazy vungleApiClient$delegate;

    public NativeAdPresenter(Context context2, NativePresenterDelegate nativePresenterDelegate, AdPayload adPayload, Executor executor2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(nativePresenterDelegate, "delegate");
        Intrinsics.checkNotNullParameter(executor2, "executor");
        this.context = context2;
        this.delegate = nativePresenterDelegate;
        this.advertisement = adPayload;
        this.executor = executor2;
        ServiceLocator.Companion companion = ServiceLocator.Companion;
        this.vungleApiClient$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new NativeAdPresenter$special$$inlined$inject$1(context2));
        ServiceLocator.Companion companion2 = ServiceLocator.Companion;
        this.executors$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new NativeAdPresenter$special$$inlined$inject$2(context2));
        ServiceLocator.Companion companion3 = ServiceLocator.Companion;
        this.pathProvider$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new NativeAdPresenter$special$$inlined$inject$3(context2));
    }

    private final VungleApiClient getVungleApiClient() {
        return (VungleApiClient) this.vungleApiClient$delegate.getValue();
    }

    private final Executors getExecutors() {
        return (Executors) this.executors$delegate.getValue();
    }

    private final PathProvider getPathProvider() {
        return (PathProvider) this.pathProvider$delegate.getValue();
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/vungle/ads/internal/presenter/NativeAdPresenter$Companion;", "", "()V", "DOWNLOAD", "", "OPEN_PRIVACY", "TAG", "TPAT", "VIDEO_VIEWED", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: NativeAdPresenter.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final void setEventListener(AdEventListener adEventListener) {
        this.bus = adEventListener;
    }

    public static /* synthetic */ void processCommand$default(NativeAdPresenter nativeAdPresenter, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        nativeAdPresenter.processCommand(str, str2);
    }

    public final void processCommand(String str, String str2) {
        String str3 = str;
        String str4 = str2;
        Intrinsics.checkNotNullParameter(str3, NativeProtocol.WEB_DIALOG_ACTION);
        boolean z = true;
        String str5 = null;
        switch (str.hashCode()) {
            case -511324706:
                if (str3.equals("openPrivacy")) {
                    onPrivacy(str4);
                    return;
                }
                break;
            case 3566511:
                if (str3.equals("tpat")) {
                    CharSequence charSequence = str4;
                    if (charSequence == null || charSequence.length() == 0) {
                        AnalyticsClient analyticsClient = AnalyticsClient.INSTANCE;
                        String placementRefId = this.delegate.getPlacementRefId();
                        AdPayload adPayload = this.advertisement;
                        if (adPayload != null) {
                            str5 = adPayload.getCreativeId();
                        }
                        AnalyticsClient.logError$vungle_ads_release$default(analyticsClient, 129, "Empty tpat key", placementRefId, str5, (String) null, 16, (Object) null);
                        return;
                    }
                    AdPayload adPayload2 = this.advertisement;
                    List<String> tpatUrls$default = adPayload2 != null ? AdPayload.getTpatUrls$default(adPayload2, str4, (String) null, 2, (Object) null) : null;
                    Collection collection = tpatUrls$default;
                    if (collection != null && !collection.isEmpty()) {
                        z = false;
                    }
                    if (z) {
                        AnalyticsClient analyticsClient2 = AnalyticsClient.INSTANCE;
                        String str6 = "Invalid tpat key: " + str4;
                        String placementRefId2 = this.delegate.getPlacementRefId();
                        AdPayload adPayload3 = this.advertisement;
                        if (adPayload3 != null) {
                            str5 = adPayload3.getCreativeId();
                        }
                        AnalyticsClient.logError$vungle_ads_release$default(analyticsClient2, 128, str6, placementRefId2, str5, (String) null, 16, (Object) null);
                        return;
                    }
                    VungleApiClient vungleApiClient = getVungleApiClient();
                    String placementRefId3 = this.delegate.getPlacementRefId();
                    AdPayload adPayload4 = this.advertisement;
                    String creativeId = adPayload4 != null ? adPayload4.getCreativeId() : null;
                    AdPayload adPayload5 = this.advertisement;
                    if (adPayload5 != null) {
                        str5 = adPayload5.eventId();
                    }
                    TpatSender tpatSender = new TpatSender(vungleApiClient, placementRefId3, creativeId, str5, getExecutors().getIoExecutor(), getPathProvider());
                    for (String sendTpat : tpatUrls$default) {
                        tpatSender.sendTpat(sendTpat, this.executor);
                    }
                    return;
                }
                break;
            case 1118284383:
                if (str3.equals("videoViewed")) {
                    AdEventListener adEventListener = this.bus;
                    if (adEventListener != null && !this.adViewed) {
                        this.adViewed = true;
                        if (adEventListener != null) {
                            adEventListener.onNext("adViewed", (String) null, this.delegate.getPlacementRefId());
                        }
                        VungleApiClient vungleApiClient2 = getVungleApiClient();
                        String placementRefId4 = this.delegate.getPlacementRefId();
                        AdPayload adPayload6 = this.advertisement;
                        String creativeId2 = adPayload6 != null ? adPayload6.getCreativeId() : null;
                        AdPayload adPayload7 = this.advertisement;
                        if (adPayload7 != null) {
                            str5 = adPayload7.eventId();
                        }
                        TpatSender tpatSender2 = new TpatSender(vungleApiClient2, placementRefId4, creativeId2, str5, getExecutors().getIoExecutor(), getPathProvider());
                        List<String> impressionUrls = this.delegate.getImpressionUrls();
                        if (impressionUrls != null) {
                            for (String sendTpat2 : impressionUrls) {
                                tpatSender2.sendTpat(sendTpat2, this.executor);
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                break;
            case 1427818632:
                if (str3.equals(DOWNLOAD)) {
                    onDownload(str4);
                    return;
                }
                break;
        }
        Log.w(TAG, "Unknown native ad action: " + str3);
    }

    private final void onDownload(String str) {
        AdPayload.AdUnit adUnit;
        String str2 = str;
        AdPayload adPayload = this.advertisement;
        List<String> tpatUrls$default = adPayload != null ? AdPayload.getTpatUrls$default(adPayload, "clickUrl", (String) null, 2, (Object) null) : null;
        VungleApiClient vungleApiClient = getVungleApiClient();
        String placementRefId = this.delegate.getPlacementRefId();
        AdPayload adPayload2 = this.advertisement;
        String creativeId = adPayload2 != null ? adPayload2.getCreativeId() : null;
        AdPayload adPayload3 = this.advertisement;
        TpatSender tpatSender = new TpatSender(vungleApiClient, placementRefId, creativeId, adPayload3 != null ? adPayload3.eventId() : null, getExecutors().getIoExecutor(), getPathProvider());
        Collection collection = tpatUrls$default;
        if (collection == null || collection.isEmpty()) {
            AnalyticsClient analyticsClient = AnalyticsClient.INSTANCE;
            String placementRefId2 = this.delegate.getPlacementRefId();
            AdPayload adPayload4 = this.advertisement;
            AnalyticsClient.logError$vungle_ads_release$default(analyticsClient, 129, "Empty tpat key: clickUrl", placementRefId2, adPayload4 != null ? adPayload4.getCreativeId() : null, (String) null, 16, (Object) null);
        } else {
            for (String sendTpat : tpatUrls$default) {
                tpatSender.sendTpat(sendTpat, this.executor);
            }
        }
        if (str2 != null) {
            tpatSender.sendTpat(str2, this.executor);
        }
        AdPayload adPayload5 = this.advertisement;
        ExternalRouter.launch((adPayload5 == null || (adUnit = adPayload5.adUnit()) == null) ? null : adUnit.getDeeplinkUrl(), str, this.context, true, new PresenterAppLeftCallback(this.bus, (String) null), new NativeAdPresenter$onDownload$3(this, tpatSender));
        AdEventListener adEventListener = this.bus;
        if (adEventListener != null) {
            adEventListener.onNext("open", "adClick", this.delegate.getPlacementRefId());
        }
    }

    private final void onPrivacy(String str) {
        if (str == null) {
            return;
        }
        if (!FileUtility.INSTANCE.isValidUrl(str)) {
            VungleError placementId$vungle_ads_release = new PrivacyUrlError(str).setPlacementId$vungle_ads_release(this.delegate.getPlacementRefId());
            AdPayload adPayload = this.advertisement;
            String str2 = null;
            VungleError creativeId$vungle_ads_release = placementId$vungle_ads_release.setCreativeId$vungle_ads_release(adPayload != null ? adPayload.getCreativeId() : null);
            AdPayload adPayload2 = this.advertisement;
            if (adPayload2 != null) {
                str2 = adPayload2.eventId();
            }
            creativeId$vungle_ads_release.setEventId$vungle_ads_release(str2).logErrorNoReturnValue$vungle_ads_release();
            return;
        }
        if (!ExternalRouter.launch((String) null, str, this.context, true, new PresenterAppLeftCallback(this.bus, this.delegate.getPlacementRefId()), (PresenterAdOpenCallback) null)) {
            new PrivacyUrlError(str).logErrorNoReturnValue$vungle_ads_release();
        }
    }

    public final void prepare() {
        start();
        AdEventListener adEventListener = this.bus;
        if (adEventListener != null) {
            adEventListener.onNext("start", (String) null, this.delegate.getPlacementRefId());
        }
    }

    private final void start() {
        if (needShowGdpr()) {
            showGdpr();
        }
    }

    public final void detach() {
        NativeOMTracker nativeOMTracker = this.omTracker;
        if (nativeOMTracker != null) {
            nativeOMTracker.stop();
        }
        Dialog dialog = this.currentDialog;
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
        AdEventListener adEventListener = this.bus;
        if (adEventListener != null) {
            adEventListener.onNext("end", (String) null, this.delegate.getPlacementRefId());
        }
    }

    private final boolean needShowGdpr() {
        return ConfigManager.INSTANCE.getGDPRIsCountryDataProtected() && Intrinsics.areEqual((Object) "unknown", (Object) PrivacyManager.INSTANCE.getConsentStatus());
    }

    private final void showGdpr() {
        PrivacyManager.INSTANCE.updateGdprConsent("opted_out_by_timeout", "vungle_modal", (String) null);
        NativeAdPresenter$$ExternalSyntheticLambda0 nativeAdPresenter$$ExternalSyntheticLambda0 = new NativeAdPresenter$$ExternalSyntheticLambda0(this);
        String gDPRConsentTitle = ConfigManager.INSTANCE.getGDPRConsentTitle();
        String gDPRConsentMessage = ConfigManager.INSTANCE.getGDPRConsentMessage();
        String gDPRButtonAccept = ConfigManager.INSTANCE.getGDPRButtonAccept();
        String gDPRButtonDeny = ConfigManager.INSTANCE.getGDPRButtonDeny();
        Context context2 = this.context;
        AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(context2, context2.getApplicationInfo().theme));
        CharSequence charSequence = gDPRConsentTitle;
        boolean z = true;
        if (!(charSequence == null || charSequence.length() == 0)) {
            builder.setTitle(charSequence);
        }
        CharSequence charSequence2 = gDPRConsentMessage;
        if (!(charSequence2 == null || charSequence2.length() == 0)) {
            z = false;
        }
        if (!z) {
            builder.setMessage(charSequence2);
        }
        builder.setPositiveButton(gDPRButtonAccept, nativeAdPresenter$$ExternalSyntheticLambda0);
        builder.setNegativeButton(gDPRButtonDeny, nativeAdPresenter$$ExternalSyntheticLambda0);
        builder.setCancelable(false);
        AlertDialog create = builder.create();
        create.setOnDismissListener(new NativeAdPresenter$$ExternalSyntheticLambda1(this));
        this.currentDialog = create;
        create.show();
    }

    /* access modifiers changed from: private */
    /* renamed from: showGdpr$lambda-6  reason: not valid java name */
    public static final void m2323showGdpr$lambda6(NativeAdPresenter nativeAdPresenter, DialogInterface dialogInterface, int i) {
        String str;
        Intrinsics.checkNotNullParameter(nativeAdPresenter, "this$0");
        if (i != -2) {
            str = i != -1 ? "opted_out_by_timeout" : PrivacyConsent.OPT_IN.getValue();
        } else {
            str = PrivacyConsent.OPT_OUT.getValue();
        }
        PrivacyManager.INSTANCE.updateGdprConsent(str, "vungle_modal", (String) null);
        nativeAdPresenter.start();
    }

    /* access modifiers changed from: private */
    /* renamed from: showGdpr$lambda-7  reason: not valid java name */
    public static final void m2324showGdpr$lambda7(NativeAdPresenter nativeAdPresenter, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(nativeAdPresenter, "this$0");
        nativeAdPresenter.currentDialog = null;
    }

    public final void initOMTracker(String str) {
        Intrinsics.checkNotNullParameter(str, "omSdkData");
        AdPayload adPayload = this.advertisement;
        boolean z = false;
        boolean omEnabled = adPayload != null ? adPayload.omEnabled() : false;
        if (str.length() > 0) {
            z = true;
        }
        if (z && ConfigManager.INSTANCE.omEnabled() && omEnabled) {
            this.omTracker = new NativeOMTracker(str);
        }
    }

    public final void startTracking(View view) {
        Intrinsics.checkNotNullParameter(view, "rootView");
        NativeOMTracker nativeOMTracker = this.omTracker;
        if (nativeOMTracker != null) {
            nativeOMTracker.start(view);
        }
    }

    public final void onImpression() {
        NativeOMTracker nativeOMTracker = this.omTracker;
        if (nativeOMTracker != null) {
            nativeOMTracker.impressionOccurred();
        }
    }
}

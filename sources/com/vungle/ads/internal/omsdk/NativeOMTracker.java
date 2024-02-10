package com.vungle.ads.internal.omsdk;

import android.util.Base64;
import android.util.Log;
import android.view.View;
import com.iab.omid.library.vungle.Omid;
import com.iab.omid.library.vungle.adsession.AdEvents;
import com.iab.omid.library.vungle.adsession.AdSession;
import com.iab.omid.library.vungle.adsession.AdSessionConfiguration;
import com.iab.omid.library.vungle.adsession.AdSessionContext;
import com.iab.omid.library.vungle.adsession.CreativeType;
import com.iab.omid.library.vungle.adsession.ImpressionType;
import com.iab.omid.library.vungle.adsession.Owner;
import com.iab.omid.library.vungle.adsession.Partner;
import com.iab.omid.library.vungle.adsession.VerificationScriptResource;
import com.vungle.ads.BuildConfig;
import com.vungle.ads.internal.model.OmSdkData;
import java.net.URL;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.Charsets;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.StringFormat;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonKt;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\fR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/vungle/ads/internal/omsdk/NativeOMTracker;", "", "omSdkData", "", "(Ljava/lang/String;)V", "adEvents", "Lcom/iab/omid/library/vungle/adsession/AdEvents;", "adSession", "Lcom/iab/omid/library/vungle/adsession/AdSession;", "json", "Lkotlinx/serialization/json/Json;", "impressionOccurred", "", "start", "view", "Landroid/view/View;", "stop", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: NativeOMTracker.kt */
public final class NativeOMTracker {
    private AdEvents adEvents;
    private AdSession adSession;
    private final Json json;

    public NativeOMTracker(String str) {
        OmSdkData omSdkData;
        Intrinsics.checkNotNullParameter(str, "omSdkData");
        Json Json$default = JsonKt.Json$default((Json) null, NativeOMTracker$json$1.INSTANCE, 1, (Object) null);
        this.json = Json$default;
        try {
            AdSessionConfiguration createAdSessionConfiguration = AdSessionConfiguration.createAdSessionConfiguration(CreativeType.NATIVE_DISPLAY, ImpressionType.BEGIN_TO_RENDER, Owner.NATIVE, Owner.NONE, false);
            Partner createPartner = Partner.createPartner(BuildConfig.OMSDK_PARTNER_NAME, BuildConfig.VERSION_NAME);
            byte[] decode = Base64.decode(str, 0);
            if (decode != null) {
                String str2 = new String(decode, Charsets.UTF_8);
                StringFormat stringFormat = Json$default;
                KSerializer<Object> serializer = SerializersKt.serializer(stringFormat.getSerializersModule(), Reflection.typeOf(OmSdkData.class));
                Intrinsics.checkNotNull(serializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                omSdkData = (OmSdkData) stringFormat.decodeFromString(serializer, str2);
            } else {
                omSdkData = null;
            }
            VerificationScriptResource createVerificationScriptResourceWithParameters = VerificationScriptResource.createVerificationScriptResourceWithParameters(omSdkData != null ? omSdkData.getVendorKey() : null, new URL(omSdkData != null ? omSdkData.getVendorURL() : null), omSdkData != null ? omSdkData.getParams() : null);
            Intrinsics.checkNotNullExpressionValue(createVerificationScriptResourceWithParameters, "verificationScriptResource");
            this.adSession = AdSession.createAdSession(createAdSessionConfiguration, AdSessionContext.createNativeAdSessionContext(createPartner, Res.INSTANCE.getOM_JS$vungle_ads_release(), CollectionsKt.listOf(createVerificationScriptResourceWithParameters), (String) null, (String) null));
        } catch (Exception e) {
            Log.e("NativeOMTracker", "error occured when create omsdk adSession:", e);
        }
    }

    public final void start(View view) {
        AdSession adSession2;
        Intrinsics.checkNotNullParameter(view, "view");
        if (Omid.isActive() && (adSession2 = this.adSession) != null) {
            adSession2.registerAdView(view);
            adSession2.start();
            AdEvents createAdEvents = AdEvents.createAdEvents(adSession2);
            this.adEvents = createAdEvents;
            if (createAdEvents != null) {
                createAdEvents.loaded();
            }
        }
    }

    public final void stop() {
        AdSession adSession2 = this.adSession;
        if (adSession2 != null) {
            adSession2.finish();
        }
        this.adSession = null;
    }

    public final void impressionOccurred() {
        AdEvents adEvents2 = this.adEvents;
        if (adEvents2 != null) {
            adEvents2.impressionOccurred();
        }
    }
}

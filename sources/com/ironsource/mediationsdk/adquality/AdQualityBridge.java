package com.ironsource.mediationsdk.adquality;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.ironsource.adqualitysdk.sdk.ISAdQualityConfig;
import com.ironsource.adqualitysdk.sdk.ISAdQualityDeviceIdType;
import com.ironsource.adqualitysdk.sdk.ISAdQualityLogLevel;
import com.ironsource.adqualitysdk.sdk.ISAdQualitySegment;
import com.ironsource.adqualitysdk.sdk.IronSourceAdQuality;
import com.ironsource.environment.c.a;
import com.ironsource.mediationsdk.IronSourceSegment;
import com.ironsource.mediationsdk.adunit.data.DataKeys;
import com.ironsource.mediationsdk.events.i;
import com.ironsource.mediationsdk.sdk.c;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.vungle.ads.internal.model.Cookie;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0005J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\bH\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0002J-\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\b2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0002\u0010\u0016J\u000e\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0019¨\u0006\u001b"}, d2 = {"Lcom/ironsource/mediationsdk/adquality/AdQualityBridge;", "", "context", "Landroid/content/Context;", "appKey", "", "userId", "logLevel", "", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;I)V", "changeUserId", "", "convertToAdQualityLogLevel", "Lcom/ironsource/adqualitysdk/sdk/ISAdQualityLogLevel;", "getCoppaValue", "", "getDeviceIdType", "Lcom/ironsource/adqualitysdk/sdk/ISAdQualityDeviceIdType;", "logEvent", "eventId", "errorCode", "errorReason", "(ILjava/lang/Integer;Ljava/lang/String;)V", "setSegment", "segment", "Lcom/ironsource/mediationsdk/IronSourceSegment;", "Companion", "mediationsdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AdQualityBridge {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\b\u0010\u0005\u001a\u00020\u0006H\u0003J\b\u0010\u0007\u001a\u00020\u0004H\u0003J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0003¨\u0006\f"}, d2 = {"Lcom/ironsource/mediationsdk/adquality/AdQualityBridge$Companion;", "", "()V", "adQualityAvailable", "", "getAdQualitySdkVersion", "", "isGetVersionMethodExist", "versionCompare", "", "ver1", "ver2", "mediationsdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        @JvmStatic
        public final String getAdQualitySdkVersion() {
            if (!isGetVersionMethodExist()) {
                return new String();
            }
            String sDKVersion = IronSourceAdQuality.getSDKVersion();
            Intrinsics.checkNotNullExpressionValue(sDKVersion, "getSDKVersion()");
            return sDKVersion;
        }

        /* access modifiers changed from: private */
        @JvmStatic
        public final boolean isGetVersionMethodExist() {
            return IronSourceAdQuality.class.getDeclaredMethods().length >= 10;
        }

        /* access modifiers changed from: private */
        @JvmStatic
        public final int versionCompare(String str, String str2) {
            CharSequence charSequence = str;
            if (TextUtils.isEmpty(charSequence)) {
                return -1;
            }
            CharSequence charSequence2 = str2;
            if (TextUtils.isEmpty(charSequence2)) {
                return -1;
            }
            int i = 0;
            Object[] array = StringsKt.split$default((CharSequence) new Regex("[^0-9.]").replace(charSequence, ""), new String[]{"."}, false, 0, 6, (Object) null).toArray(new String[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            String[] strArr = (String[]) array;
            Object[] array2 = StringsKt.split$default((CharSequence) new Regex("[^0-9.]").replace(charSequence2, ""), new String[]{"."}, false, 0, 6, (Object) null).toArray(new String[0]);
            Intrinsics.checkNotNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            String[] strArr2 = (String[]) array2;
            while (i < strArr.length && i < strArr2.length && Intrinsics.areEqual((Object) strArr[i], (Object) strArr2[i])) {
                i++;
            }
            if (i >= strArr.length || i >= strArr2.length) {
                return Integer.signum(strArr.length - strArr2.length);
            }
            int intValue = Integer.valueOf(strArr[i]).intValue();
            Integer valueOf = Integer.valueOf(strArr2[i]);
            Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(vals2[i])");
            return Integer.signum(Intrinsics.compare(intValue, valueOf.intValue()));
        }

        @JvmStatic
        public final boolean adQualityAvailable() {
            return versionCompare(getAdQualitySdkVersion(), "7.9.0") >= 0;
        }
    }

    public AdQualityBridge(Context context, String str, String str2, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "appKey");
        ISAdQualityConfig.Builder deviceIdType = new ISAdQualityConfig.Builder().setInitializationSource("LevelPlay").setLogLevel(convertToAdQualityLogLevel(i)).setAdQualityInitListener(new AdQualityBridge$configBuilder$1(this)).setCoppa(getCoppaValue()).setDeviceIdType(getDeviceIdType());
        if (!TextUtils.isEmpty(str2)) {
            deviceIdType.setUserId(str2);
        }
        logEvent$default(this, 80, (Integer) null, (String) null, 6, (Object) null);
        IronSourceAdQuality.getInstance().initialize(context, str, deviceIdType.build());
    }

    @JvmStatic
    public static final boolean adQualityAvailable() {
        return Companion.adQualityAvailable();
    }

    private final ISAdQualityLogLevel convertToAdQualityLogLevel(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? ISAdQualityLogLevel.INFO : ISAdQualityLogLevel.ERROR : ISAdQualityLogLevel.WARNING : ISAdQualityLogLevel.INFO : ISAdQualityLogLevel.VERBOSE;
    }

    @JvmStatic
    private static final String getAdQualitySdkVersion() {
        return Companion.getAdQualitySdkVersion();
    }

    private final boolean getCoppaValue() {
        String a = c.a().a(Cookie.COPPA_STATUS_KEY);
        return a != null && Boolean.parseBoolean(a);
    }

    private final ISAdQualityDeviceIdType getDeviceIdType() {
        return !TextUtils.isEmpty(c.a().a("AdvIdOptOutReason")) ? ISAdQualityDeviceIdType.NONE : ISAdQualityDeviceIdType.GAID;
    }

    @JvmStatic
    private static final boolean isGetVersionMethodExist() {
        return Companion.isGetVersionMethodExist();
    }

    /* access modifiers changed from: private */
    public final void logEvent(int i, Integer num, String str) {
        JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false);
        if (num != null) {
            mediationAdditionalData.put(IronSourceConstants.EVENTS_ERROR_CODE, num.intValue());
        }
        if (str != null) {
            mediationAdditionalData.put(IronSourceConstants.EVENTS_ERROR_REASON, str);
        }
        i.d().a(new a(i, mediationAdditionalData));
    }

    static /* synthetic */ void logEvent$default(AdQualityBridge adQualityBridge, int i, Integer num, String str, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            num = null;
        }
        if ((i2 & 4) != 0) {
            str = null;
        }
        adQualityBridge.logEvent(i, num, str);
    }

    @JvmStatic
    private static final int versionCompare(String str, String str2) {
        return Companion.versionCompare(str, str2);
    }

    public final void changeUserId(String str) {
        Intrinsics.checkNotNullParameter(str, DataKeys.USER_ID);
        IronSourceAdQuality.getInstance().changeUserId(str);
    }

    public final void setSegment(IronSourceSegment ironSourceSegment) {
        Intrinsics.checkNotNullParameter(ironSourceSegment, "segment");
        ISAdQualitySegment.Builder builder = new ISAdQualitySegment.Builder();
        if (ironSourceSegment.getSegmentName() != null) {
            builder.setSegmentName(ironSourceSegment.getSegmentName());
        }
        if (ironSourceSegment.getAge() >= 0) {
            builder.setAge(ironSourceSegment.getAge());
        }
        if (ironSourceSegment.getGender() != null) {
            builder.setGender(ironSourceSegment.getGender());
        }
        if (ironSourceSegment.getLevel() >= 0) {
            builder.setLevel(ironSourceSegment.getLevel());
        }
        if (ironSourceSegment.getIsPaying() != null) {
            builder.setIsPaying(ironSourceSegment.getIsPaying().get());
        }
        if (ironSourceSegment.getIapt() > -1.0d) {
            builder.setInAppPurchasesTotal(ironSourceSegment.getIapt());
        }
        if (ironSourceSegment.getUcd() > 0) {
            builder.setUserCreationDate(ironSourceSegment.getUcd());
        }
        Iterator<Pair<String, String>> it = ironSourceSegment.getSegmentData().iterator();
        while (it.hasNext()) {
            Pair next = it.next();
            String str = (String) next.first;
            String str2 = (String) next.second;
            Intrinsics.checkNotNullExpressionValue(str, "key");
            if (StringsKt.startsWith$default(str, "custom_", false, 2, (Object) null)) {
                builder.setCustomData(StringsKt.removePrefix(str, (CharSequence) "custom_"), str2);
            }
        }
        IronSourceAdQuality.getInstance().setSegment(builder.build());
    }
}

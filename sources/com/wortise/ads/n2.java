package com.wortise.ads;

import android.content.Context;
import android.os.Build;
import com.wortise.ads.device.DeviceType;
import com.wortise.ads.device.ScreenOrientation;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/wortise/ads/n2;", "", "Landroid/content/Context;", "context", "Lcom/wortise/ads/l2;", "a", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: DeviceFactory.kt */
public final class n2 {
    public static final n2 a = new n2();

    private n2() {
    }

    public final l2 a(Context context) {
        String str;
        Context context2 = context;
        Intrinsics.checkNotNullParameter(context2, "context");
        String str2 = Build.MANUFACTURER;
        String str3 = Build.DEVICE;
        String str4 = Build.MODEL;
        String str5 = Build.VERSION.RELEASE;
        int i = Build.VERSION.SDK_INT;
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
        String country = locale.getCountry();
        Locale locale2 = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale2, "getDefault()");
        String language = locale2.getLanguage();
        Locale locale3 = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale3, "getDefault()");
        if (i >= 21) {
            str = locale3.toLanguageTag();
        } else {
            String locale4 = locale3.toString();
            Intrinsics.checkNotNullExpressionValue(locale4, "toString()");
            str = StringsKt.replace$default(locale4, "_", "-", false, 4, (Object) null);
        }
        String str6 = str;
        TimeZone timeZone = TimeZone.getDefault();
        Intrinsics.checkNotNullExpressionValue(timeZone, "<get-defaultTimeZone>");
        String id = timeZone.getID();
        ScreenOrientation a2 = ScreenOrientation.Companion.a(context2);
        d6 a3 = e6.a.a(context2);
        DeviceType a4 = DeviceType.Companion.a(context2);
        String a5 = p2.a.a(context2);
        return new l2(str2, country, str3, q2.a.a(), language, str6, str4, a2, "android", str5, Integer.valueOf(i), a3, id, a4, a5);
    }
}

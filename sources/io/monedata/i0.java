package io.monedata;

import android.os.Build;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u0006"}, d2 = {"Lio/monedata/i0;", "", "Lio/monedata/h0;", "a", "<init>", "()V", "core_productionRelease"}, k = 1, mv = {1, 7, 1})
public final class i0 {
    public static final i0 a = new i0();

    private i0() {
    }

    public final h0 a() {
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
        String country = locale.getCountry();
        Intrinsics.checkNotNullExpressionValue(country, "defaultLocale.country");
        String str = Build.DEVICE;
        Intrinsics.checkNotNullExpressionValue(str, "DEVICE");
        boolean a2 = l0.a.a();
        String str2 = Build.FINGERPRINT;
        Intrinsics.checkNotNullExpressionValue(str2, "FINGERPRINT");
        Locale locale2 = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale2, "getDefault()");
        String language = locale2.getLanguage();
        Intrinsics.checkNotNullExpressionValue(language, "defaultLocale.language");
        String str3 = Build.MANUFACTURER;
        Intrinsics.checkNotNullExpressionValue(str3, "MANUFACTURER");
        String str4 = Build.MODEL;
        Intrinsics.checkNotNullExpressionValue(str4, "MODEL");
        String str5 = Build.VERSION.RELEASE;
        Intrinsics.checkNotNullExpressionValue(str5, "RELEASE");
        int i = Build.VERSION.SDK_INT;
        TimeZone timeZone = TimeZone.getDefault();
        Intrinsics.checkNotNullExpressionValue(timeZone, "<get-defaultTimeZone>");
        String id = timeZone.getID();
        Intrinsics.checkNotNullExpressionValue(id, "defaultTimeZone.id");
        return new h0(country, str, a2, str2, language, str3, str4, "android", str5, i, id);
    }
}

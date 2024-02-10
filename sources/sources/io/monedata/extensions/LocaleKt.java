package io.monedata.extensions;

import java.util.Locale;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0012\u0010\u0000\u001a\u00020\u00018Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0012\u0010\u0004\u001a\u00020\u00058Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"defaultLocale", "Ljava/util/Locale;", "getDefaultLocale", "()Ljava/util/Locale;", "defaultTimeZone", "Ljava/util/TimeZone;", "getDefaultTimeZone", "()Ljava/util/TimeZone;", "core_productionRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class LocaleKt {
    public static final Locale getDefaultLocale() {
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
        return locale;
    }

    public static final TimeZone getDefaultTimeZone() {
        TimeZone timeZone = TimeZone.getDefault();
        Intrinsics.checkNotNullExpressionValue(timeZone, "<get-defaultTimeZone>");
        return timeZone;
    }
}

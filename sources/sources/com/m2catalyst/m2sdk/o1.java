package com.m2catalyst.m2sdk;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DateTimeUtils.kt */
public final class o1 {
    public static final int a(boolean z) {
        return z ? 1 : 0;
    }

    public static final long b(int i) {
        return ((long) i) * ((long) 60) * ((long) 1000);
    }

    public static final String b() {
        String displayName = TimeZone.getDefault().getDisplayName(true, 0);
        Intrinsics.checkNotNullExpressionValue(displayName, "getTimeZoneDisplayName");
        return displayName;
    }

    public static final long c(int i) {
        return ((long) i) * 1000;
    }

    public static final String a(Date date) {
        Intrinsics.checkNotNullParameter(date, "<this>");
        Locale locale = Locale.US;
        Intrinsics.checkNotNullExpressionValue(locale, "US");
        Intrinsics.checkNotNullParameter(date, "<this>");
        Intrinsics.checkNotNullParameter("yyyy-MM-dd", "pattern");
        Intrinsics.checkNotNullParameter(locale, "locale");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", locale);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        String format = simpleDateFormat.format(date);
        Intrinsics.checkNotNullExpressionValue(format, "dateFormat.format(this)");
        return format;
    }

    public static final Integer a(Long l) {
        if (l == null) {
            return null;
        }
        l.longValue();
        return Integer.valueOf(TimeZone.getDefault().getOffset(l.longValue()));
    }

    public static final long a(int i) {
        return b(i * 60);
    }

    public static final String a(long j) {
        String format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss a").format(new Date(j));
        Intrinsics.checkNotNullExpressionValue(format, "SimpleDateFormat(\"MM/dd/…ss a\").format(Date(this))");
        return format;
    }

    public static final String a() {
        return a(System.currentTimeMillis());
    }
}

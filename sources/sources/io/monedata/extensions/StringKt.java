package io.monedata.extensions;

import android.os.Build;
import android.text.Html;
import android.text.Spanned;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\u001a#\u0010\u0005\u001a\u00020\u00062\u0016\u0010\u0007\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\b\"\u0004\u0018\u00010\u0002¢\u0006\u0002\u0010\t\u001a\u001d\u0010\n\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0002\n\n\b\b\u0000\u001a\u0004\b\u0003\u0010\u0001\"\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\f"}, d2 = {"html", "Landroid/text/Spanned;", "", "getHtml", "(Ljava/lang/String;)Landroid/text/Spanned;", "requireNoneEmpty", "", "values", "", "([Ljava/lang/String;)V", "requireNotEmpty", "value", "core_productionRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class StringKt {
    public static final Spanned getHtml(String str) {
        Spanned spanned;
        String str2;
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (Build.VERSION.SDK_INT >= 24) {
            spanned = Html.fromHtml(str, 0);
            str2 = "fromHtml(this, FROM_HTML_MODE_LEGACY)";
        } else {
            spanned = Html.fromHtml(str);
            str2 = "fromHtml(this)";
        }
        Intrinsics.checkNotNullExpressionValue(spanned, str2);
        return spanned;
    }

    public static final void requireNoneEmpty(String... strArr) {
        Intrinsics.checkNotNullParameter(strArr, "values");
        for (String requireNotEmpty : strArr) {
            requireNotEmpty(requireNotEmpty);
        }
    }

    public static final void requireNotEmpty(String str) {
        if (!(!(str == null || str.length() == 0))) {
            throw new IllegalArgumentException("Required value was null or empty.".toString());
        }
    }
}

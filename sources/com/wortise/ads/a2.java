package com.wortise.ads;

import android.webkit.MimeTypeMap;
import kotlin.Metadata;
import kotlin.text.StringsKt;

@Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¨\u0006\t"}, d2 = {"Lcom/wortise/ads/a2;", "", "", "url", "a", "", "b", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: ContentUtils.kt */
public final class a2 {
    public static final a2 a = new a2();

    private a2() {
    }

    public final String a(String str) {
        String fileExtensionFromUrl = str == null ? null : MimeTypeMap.getFileExtensionFromUrl(str);
        if (fileExtensionFromUrl == null) {
            return null;
        }
        return MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl);
    }

    public final boolean b(String str) {
        if (str == null) {
            return false;
        }
        return StringsKt.equals("image/gif", a(str), true);
    }
}

package com.wortise.ads;

import android.net.Uri;
import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\f\b\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/wortise/ads/AdEvent;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Companion", "a", "CLOSE", "LOAD_FAIL", "SHOW_CLOSE", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: AdEvent.kt */
public enum AdEvent {
    CLOSE("close"),
    LOAD_FAIL("loadFail"),
    SHOW_CLOSE("showClose");
    
    public static final a Companion = null;
    private final String value;

    @Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006¨\u0006\n"}, d2 = {"Lcom/wortise/ads/AdEvent$a;", "", "", "value", "Lcom/wortise/ads/AdEvent;", "a", "Landroid/net/Uri;", "uri", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* compiled from: AdEvent.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AdEvent a(String str) {
            Intrinsics.checkNotNullParameter(str, "value");
            for (AdEvent adEvent : AdEvent.values()) {
                if (Intrinsics.areEqual((Object) adEvent.getValue(), (Object) str)) {
                    return adEvent;
                }
            }
            return null;
        }

        public final AdEvent a(Uri uri) {
            Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
            String host = uri.getHost();
            if (host == null) {
                return null;
            }
            return AdEvent.Companion.a(host);
        }
    }

    static {
        Companion = new a((DefaultConstructorMarker) null);
    }

    private AdEvent(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }
}

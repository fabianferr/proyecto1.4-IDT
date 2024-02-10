package com.wortise.ads.device;

import android.app.Activity;
import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0001\u0018\u0000 \u00042\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/wortise/ads/device/ScreenOrientation;", "", "<init>", "(Ljava/lang/String;I)V", "Companion", "a", "LANDSCAPE", "PORTRAIT", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: ScreenOrientation.kt */
public enum ScreenOrientation {
    LANDSCAPE,
    PORTRAIT;
    
    public static final a Companion = null;

    @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/wortise/ads/device/ScreenOrientation$a;", "", "Landroid/content/Context;", "context", "Lcom/wortise/ads/device/ScreenOrientation;", "a", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* compiled from: ScreenOrientation.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ScreenOrientation a(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            Activity activity = context instanceof Activity ? (Activity) context : null;
            if (activity == null) {
                return null;
            }
            int i = activity.getResources().getConfiguration().orientation;
            if (i == 1) {
                return ScreenOrientation.PORTRAIT;
            }
            if (i != 2) {
                return null;
            }
            return ScreenOrientation.LANDSCAPE;
        }
    }

    static {
        Companion = new a((DefaultConstructorMarker) null);
    }
}

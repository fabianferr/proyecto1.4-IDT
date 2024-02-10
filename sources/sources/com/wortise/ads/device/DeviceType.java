package com.wortise.ads.device;

import android.content.Context;
import com.wortise.ads.q2;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0001\u0018\u0000 \u00042\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/wortise/ads/device/DeviceType;", "", "<init>", "(Ljava/lang/String;I)V", "Companion", "a", "MOBILE", "TABLET", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: DeviceType.kt */
public enum DeviceType {
    MOBILE,
    TABLET;
    
    public static final a Companion = null;

    @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/wortise/ads/device/DeviceType$a;", "", "Landroid/content/Context;", "context", "Lcom/wortise/ads/device/DeviceType;", "a", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* compiled from: DeviceType.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DeviceType a(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return q2.a.a(context) ? DeviceType.TABLET : DeviceType.MOBILE;
        }
    }

    static {
        Companion = new a((DefaultConstructorMarker) null);
    }
}

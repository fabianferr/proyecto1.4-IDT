package com.wortise.ads;

import android.content.Context;
import com.wortise.ads.consent.ConsentManager;
import com.wortise.ads.user.UserGender;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/wortise/ads/t6;", "", "Landroid/content/Context;", "context", "Lcom/wortise/ads/s6;", "a", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: UserDataFactory.kt */
public final class t6 {
    public static final t6 a = new t6();

    private t6() {
    }

    public final s6 a(Context context) {
        Integer num;
        Intrinsics.checkNotNullParameter(context, "context");
        UserGender userGender = null;
        u6 u6Var = ConsentManager.canCollectData(context) ? new u6(context) : null;
        if (u6Var == null) {
            num = null;
        } else {
            num = u6Var.c();
        }
        List<q3> a2 = r3.a.a(u6Var == null ? null : u6Var.d());
        if (u6Var != null) {
            userGender = u6Var.e();
        }
        return new s6(num, a2, userGender, AdSettings.getUserId(context));
    }
}

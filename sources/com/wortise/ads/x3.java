package com.wortise.ads;

import android.content.Context;
import com.wortise.ads.v3;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¨\u0006\n"}, d2 = {"Lcom/wortise/ads/x3;", "", "Landroid/content/Context;", "context", "Lcom/wortise/ads/v3$a;", "listener", "Lcom/wortise/ads/v3;", "a", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: HtmlWebViewFactory.kt */
public final class x3 {
    public static final x3 a = new x3();

    private x3() {
    }

    public final v3 a(Context context, v3.a aVar) {
        Intrinsics.checkNotNullParameter(context, "context");
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
        v3 v3Var = new v3(applicationContext);
        v3Var.setListener(aVar);
        return v3Var;
    }
}

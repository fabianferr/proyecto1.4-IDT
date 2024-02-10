package com.wortise.ads;

import android.content.Context;
import com.wortise.ads.identifier.Identifier;
import com.wortise.ads.identifier.IdentifierManager;
import com.wortise.ads.identifier.IdentifierType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¨\u0006\u0005"}, d2 = {"Lcom/wortise/ads/h4;", "Landroid/content/Context;", "context", "", "a", "sdk_productionRelease"}, k = 2, mv = {1, 5, 1})
/* compiled from: IRequest.kt */
public final class i4 {
    public static final void a(h4 h4Var, Context context) {
        String str;
        Intrinsics.checkNotNullParameter(h4Var, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Identifier fetchSync = IdentifierManager.INSTANCE.fetchSync(context);
        h4Var.c(AdSettings.INSTANCE.requireAssetKey$sdk_productionRelease(context));
        h4Var.a(h7.a.a(context));
        IdentifierType identifierType = null;
        if (fetchSync == null) {
            str = null;
        } else {
            str = fetchSync.getId();
        }
        h4Var.b(str);
        if (fetchSync != null) {
            identifierType = fetchSync.getType();
        }
        h4Var.a(identifierType);
    }
}

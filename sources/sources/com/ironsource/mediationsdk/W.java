package com.ironsource.mediationsdk;

import android.content.Context;
import com.ironsource.environment.l;
import com.ironsource.mediationsdk.utils.n;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/ironsource/mediationsdk/TokenRepository;", "", "()V", "getBiddingData", "Lorg/json/JSONObject;", "context", "Landroid/content/Context;", "tokenSettings", "Lcom/ironsource/mediationsdk/utils/TokenSettings;", "mediationsdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class W {
    public static JSONObject a(Context context, n nVar) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(nVar, "tokenSettings");
        return l.a.a(nVar, context);
    }
}

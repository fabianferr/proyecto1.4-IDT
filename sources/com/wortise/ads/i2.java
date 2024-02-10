package com.wortise.ads;

import android.content.Context;
import android.os.Bundle;
import com.wortise.ads.events.modules.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\f"}, d2 = {"Lcom/wortise/ads/i2;", "Lcom/wortise/ads/events/modules/a;", "", "canHandle", "Landroid/content/Context;", "context", "Lcom/wortise/ads/AdResponse;", "adResponse", "Landroid/os/Bundle;", "adExtras", "<init>", "(Landroid/content/Context;Lcom/wortise/ads/AdResponse;Landroid/os/Bundle;)V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: DefaultHandler.kt */
public final class i2 extends a {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i2(Context context, AdResponse adResponse, Bundle bundle) {
        super(context, adResponse, bundle);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
    }

    public boolean canHandle() {
        return true;
    }
}

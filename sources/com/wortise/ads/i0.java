package com.wortise.ads;

import android.content.Context;
import android.content.ContextWrapper;
import android.location.Location;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u0003\u001a\u0004\u0018\u00010\u0002H¦@ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lcom/wortise/ads/i0;", "Landroid/content/ContextWrapper;", "Landroid/location/Location;", "a", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "()Z", "isAvailable", "Landroid/content/Context;", "base", "<init>", "(Landroid/content/Context;)V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: BaseLocation.kt */
public abstract class i0 extends ContextWrapper {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i0(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "base");
    }

    public abstract Object a(Continuation<? super Location> continuation);

    public boolean a() {
        return true;
    }
}

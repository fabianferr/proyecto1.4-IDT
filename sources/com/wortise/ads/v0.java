package com.wortise.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a \u0010\u0006\u001a\u00020\u00052\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0000¨\u0006\u0007"}, d2 = {"Lkotlin/Function2;", "Landroid/content/Context;", "Landroid/content/Intent;", "", "block", "Landroid/content/BroadcastReceiver;", "a", "sdk_productionRelease"}, k = 2, mv = {1, 5, 1})
/* compiled from: BroadcastReceiver.kt */
public final class v0 {

    @Metadata(bv = {}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\b"}, d2 = {"com/wortise/ads/v0$a", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", "onReceive", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* compiled from: BroadcastReceiver.kt */
    public static final class a extends BroadcastReceiver {
        final /* synthetic */ Function2<Context, Intent, Unit> a;

        a(Function2<? super Context, ? super Intent, Unit> function2) {
            this.a = function2;
        }

        public void onReceive(Context context, Intent intent) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(intent, "intent");
            this.a.invoke(context, intent);
        }
    }

    public static final BroadcastReceiver a(Function2<? super Context, ? super Intent, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "block");
        return new a(function2);
    }
}

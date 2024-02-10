package com.vungle.ads.internal;

import android.util.Log;
import com.vungle.ads.ConfigurationError;
import com.vungle.ads.InitializationListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: VungleInitializer.kt */
final class VungleInitializer$configure$2 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ InitializationListener $callback;
    final /* synthetic */ VungleInitializer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VungleInitializer$configure$2(VungleInitializer vungleInitializer, InitializationListener initializationListener) {
        super(1);
        this.this$0 = vungleInitializer;
        this.$callback = initializationListener;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z) {
        if (z) {
            this.this$0.setInitialized$vungle_ads_release(true);
            this.this$0.onInitSuccess(this.$callback);
            Log.d("VungleInitializer", "onSuccess");
            return;
        }
        this.this$0.setInitialized$vungle_ads_release(false);
        this.this$0.onInitError(this.$callback, new ConfigurationError());
    }
}

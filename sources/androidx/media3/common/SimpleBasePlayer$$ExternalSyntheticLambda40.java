package androidx.media3.common;

import androidx.media3.common.SimpleBasePlayer;
import com.google.common.base.Supplier;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SimpleBasePlayer$$ExternalSyntheticLambda40 implements Supplier {
    public final /* synthetic */ SimpleBasePlayer.State f$0;
    public final /* synthetic */ boolean f$1;

    public /* synthetic */ SimpleBasePlayer$$ExternalSyntheticLambda40(SimpleBasePlayer.State state, boolean z) {
        this.f$0 = state;
        this.f$1 = z;
    }

    public final Object get() {
        return this.f$0.buildUpon().setIsDeviceMuted(this.f$1).build();
    }
}

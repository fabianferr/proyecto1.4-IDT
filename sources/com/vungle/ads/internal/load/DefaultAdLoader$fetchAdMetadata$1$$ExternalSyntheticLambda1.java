package com.vungle.ads.internal.load;

import com.vungle.ads.internal.model.Placement;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DefaultAdLoader$fetchAdMetadata$1$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ DefaultAdLoader f$0;
    public final /* synthetic */ Throwable f$1;
    public final /* synthetic */ Placement f$2;

    public /* synthetic */ DefaultAdLoader$fetchAdMetadata$1$$ExternalSyntheticLambda1(DefaultAdLoader defaultAdLoader, Throwable th, Placement placement) {
        this.f$0 = defaultAdLoader;
        this.f$1 = th;
        this.f$2 = placement;
    }

    public final void run() {
        DefaultAdLoader$fetchAdMetadata$1.m2300onFailure$lambda1(this.f$0, this.f$1, this.f$2);
    }
}

package com.vungle.ads.internal.load;

import com.vungle.ads.internal.model.Placement;
import com.vungle.ads.internal.network.Response;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DefaultAdLoader$fetchAdMetadata$1$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ DefaultAdLoader f$0;
    public final /* synthetic */ Placement f$1;
    public final /* synthetic */ Response f$2;

    public /* synthetic */ DefaultAdLoader$fetchAdMetadata$1$$ExternalSyntheticLambda0(DefaultAdLoader defaultAdLoader, Placement placement, Response response) {
        this.f$0 = defaultAdLoader;
        this.f$1 = placement;
        this.f$2 = response;
    }

    public final void run() {
        DefaultAdLoader$fetchAdMetadata$1.m2301onResponse$lambda0(this.f$0, this.f$1, this.f$2);
    }
}

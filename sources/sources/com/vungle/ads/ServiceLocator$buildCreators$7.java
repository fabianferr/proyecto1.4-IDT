package com.vungle.ads;

import com.vungle.ads.ServiceLocator;
import com.vungle.ads.internal.omsdk.OMTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\f\u0012\u0004\u0012\u00020\u00020\u0001R\u00020\u0003J\b\u0010\u0004\u001a\u00020\u0002H\u0016¨\u0006\u0005"}, d2 = {"com/vungle/ads/ServiceLocator$buildCreators$7", "Lcom/vungle/ads/ServiceLocator$Creator;", "Lcom/vungle/ads/internal/omsdk/OMTracker$Factory;", "Lcom/vungle/ads/ServiceLocator;", "create", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ServiceLocator.kt */
public final class ServiceLocator$buildCreators$7 extends ServiceLocator.Creator<OMTracker.Factory> {
    ServiceLocator$buildCreators$7(ServiceLocator serviceLocator) {
        super(serviceLocator, false, 1, (DefaultConstructorMarker) null);
    }

    public OMTracker.Factory create() {
        return new OMTracker.Factory();
    }
}

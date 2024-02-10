package com.vungle.ads;

import com.vungle.ads.ServiceLocator;
import com.vungle.ads.internal.task.JobCreator;
import com.vungle.ads.internal.task.VungleJobCreator;
import com.vungle.ads.internal.util.PathProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\f\u0012\u0004\u0012\u00020\u00020\u0001R\u00020\u0003J\b\u0010\u0004\u001a\u00020\u0002H\u0016¨\u0006\u0005"}, d2 = {"com/vungle/ads/ServiceLocator$buildCreators$1", "Lcom/vungle/ads/ServiceLocator$Creator;", "Lcom/vungle/ads/internal/task/JobCreator;", "Lcom/vungle/ads/ServiceLocator;", "create", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ServiceLocator.kt */
public final class ServiceLocator$buildCreators$1 extends ServiceLocator.Creator<JobCreator> {
    final /* synthetic */ ServiceLocator this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ServiceLocator$buildCreators$1(ServiceLocator serviceLocator) {
        super(serviceLocator, false, 1, (DefaultConstructorMarker) null);
        this.this$0 = serviceLocator;
    }

    public JobCreator create() {
        return new VungleJobCreator(this.this$0.ctx, (PathProvider) this.this$0.getOrBuild$vungle_ads_release(PathProvider.class));
    }
}

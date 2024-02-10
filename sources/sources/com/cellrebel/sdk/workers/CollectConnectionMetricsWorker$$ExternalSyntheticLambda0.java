package com.cellrebel.sdk.workers;

import com.cellrebel.sdk.database.dao.ConnectionTimePassiveDAO;
import com.cellrebel.sdk.networking.beans.response.Settings;
import com.cellrebel.sdk.utils.TrackingHelper;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class CollectConnectionMetricsWorker$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ CollectConnectionMetricsWorker f$0;
    public final /* synthetic */ TrackingHelper f$1;
    public final /* synthetic */ Settings f$2;
    public final /* synthetic */ ConnectionTimePassiveDAO f$3;

    public /* synthetic */ CollectConnectionMetricsWorker$$ExternalSyntheticLambda0(CollectConnectionMetricsWorker collectConnectionMetricsWorker, TrackingHelper trackingHelper, Settings settings, ConnectionTimePassiveDAO connectionTimePassiveDAO) {
        this.f$0 = collectConnectionMetricsWorker;
        this.f$1 = trackingHelper;
        this.f$2 = settings;
        this.f$3 = connectionTimePassiveDAO;
    }

    public final void run() {
        this.f$0.a(this.f$1, this.f$2, this.f$3);
    }
}

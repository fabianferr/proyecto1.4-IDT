package com.cellrebel.sdk.tti;

import com.cellrebel.sdk.tti.ServerSelection;
import okhttp3.OkHttpClient;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ServerSelection$$ExternalSyntheticLambda1 implements ServerSelection.LatencyMeasurerFactory {
    public final LatencyMeasurer a(OkHttpClient okHttpClient) {
        return new LatencyMeasurer(okHttpClient);
    }
}

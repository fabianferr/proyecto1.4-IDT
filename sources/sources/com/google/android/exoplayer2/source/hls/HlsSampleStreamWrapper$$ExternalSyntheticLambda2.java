package com.google.android.exoplayer2.source.hls;

import com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class HlsSampleStreamWrapper$$ExternalSyntheticLambda2 implements Runnable {
    public final /* synthetic */ HlsSampleStreamWrapper.Callback f$0;

    public /* synthetic */ HlsSampleStreamWrapper$$ExternalSyntheticLambda2(HlsSampleStreamWrapper.Callback callback) {
        this.f$0 = callback;
    }

    public final void run() {
        this.f$0.onPrepared();
    }
}

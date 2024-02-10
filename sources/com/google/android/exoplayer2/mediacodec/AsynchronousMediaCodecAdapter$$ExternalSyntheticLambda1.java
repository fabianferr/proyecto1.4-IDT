package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AsynchronousMediaCodecAdapter$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ MediaCodec f$0;

    public /* synthetic */ AsynchronousMediaCodecAdapter$$ExternalSyntheticLambda1(MediaCodec mediaCodec) {
        this.f$0 = mediaCodec;
    }

    public final void run() {
        this.f$0.start();
    }
}

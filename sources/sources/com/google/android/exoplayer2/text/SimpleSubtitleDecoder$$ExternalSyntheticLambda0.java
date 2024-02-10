package com.google.android.exoplayer2.text;

import com.google.android.exoplayer2.decoder.OutputBuffer;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SimpleSubtitleDecoder$$ExternalSyntheticLambda0 implements OutputBuffer.Owner {
    public final /* synthetic */ SimpleSubtitleDecoder f$0;

    public /* synthetic */ SimpleSubtitleDecoder$$ExternalSyntheticLambda0(SimpleSubtitleDecoder simpleSubtitleDecoder) {
        this.f$0 = simpleSubtitleDecoder;
    }

    public final void releaseOutputBuffer(OutputBuffer outputBuffer) {
        this.f$0.releaseOutputBuffer((SubtitleOutputBuffer) outputBuffer);
    }
}

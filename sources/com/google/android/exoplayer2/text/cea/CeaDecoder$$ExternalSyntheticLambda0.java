package com.google.android.exoplayer2.text.cea;

import com.google.android.exoplayer2.decoder.OutputBuffer;
import com.google.android.exoplayer2.text.cea.CeaDecoder;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class CeaDecoder$$ExternalSyntheticLambda0 implements OutputBuffer.Owner {
    public final /* synthetic */ CeaDecoder f$0;

    public /* synthetic */ CeaDecoder$$ExternalSyntheticLambda0(CeaDecoder ceaDecoder) {
        this.f$0 = ceaDecoder;
    }

    public final void releaseOutputBuffer(OutputBuffer outputBuffer) {
        this.f$0.releaseOutputBuffer((CeaDecoder.CeaOutputBuffer) outputBuffer);
    }
}

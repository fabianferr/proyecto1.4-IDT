package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.source.ProgressiveMediaExtractor;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ProgressiveMediaSource$Factory$$ExternalSyntheticLambda2 implements ProgressiveMediaExtractor.Factory {
    public final /* synthetic */ ExtractorsFactory f$0;

    public /* synthetic */ ProgressiveMediaSource$Factory$$ExternalSyntheticLambda2(ExtractorsFactory extractorsFactory) {
        this.f$0 = extractorsFactory;
    }

    public final ProgressiveMediaExtractor createProgressiveMediaExtractor() {
        return ProgressiveMediaSource.Factory.lambda$setExtractorsFactory$1(this.f$0);
    }
}
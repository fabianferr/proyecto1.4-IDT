package com.google.android.exoplayer2.transformer;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.util.Assertions;
import java.nio.ByteBuffer;

final class TransformerVideoRenderer extends TransformerBaseRenderer {
    private static final String TAG = "TransformerVideoRenderer";
    private final DecoderInputBuffer buffer = new DecoderInputBuffer(2);
    private boolean formatRead;
    private boolean isBufferPending;
    private boolean isInputStreamEnded;
    private SampleTransformer sampleTransformer;

    public String getName() {
        return TAG;
    }

    public TransformerVideoRenderer(MuxerWrapper muxerWrapper, TransformerMediaClock transformerMediaClock, Transformation transformation) {
        super(2, muxerWrapper, transformerMediaClock, transformation);
    }

    public void render(long j, long j2) {
        boolean z;
        if (this.isRendererStarted && !isEnded()) {
            if (!this.formatRead) {
                FormatHolder formatHolder = getFormatHolder();
                if (readSource(formatHolder, this.buffer, 2) == -5) {
                    Format format = (Format) Assertions.checkNotNull(formatHolder.format);
                    this.formatRead = true;
                    if (this.transformation.flattenForSlowMotion) {
                        this.sampleTransformer = new SefSlowMotionVideoSampleTransformer(format);
                    }
                    this.muxerWrapper.addTrackFormat(format);
                } else {
                    return;
                }
            }
            do {
                if (this.isBufferPending || readAndTransformBuffer()) {
                    z = !this.muxerWrapper.writeSample(getTrackType(), this.buffer.data, this.buffer.isKeyFrame(), this.buffer.timeUs);
                    this.isBufferPending = z;
                } else {
                    return;
                }
            } while (!z);
        }
    }

    public boolean isEnded() {
        return this.isInputStreamEnded;
    }

    private boolean readAndTransformBuffer() {
        this.buffer.clear();
        int readSource = readSource(getFormatHolder(), this.buffer, 0);
        if (readSource == -5) {
            throw new IllegalStateException("Format changes are not supported.");
        } else if (readSource == -3) {
            return false;
        } else {
            if (this.buffer.isEndOfStream()) {
                this.isInputStreamEnded = true;
                this.muxerWrapper.endTrack(getTrackType());
                return false;
            }
            this.mediaClock.updateTimeForTrackType(getTrackType(), this.buffer.timeUs);
            ((ByteBuffer) Assertions.checkNotNull(this.buffer.data)).flip();
            SampleTransformer sampleTransformer2 = this.sampleTransformer;
            if (sampleTransformer2 != null) {
                sampleTransformer2.transformSample(this.buffer);
            }
            return true;
        }
    }
}

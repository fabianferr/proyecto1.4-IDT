package com.google.android.exoplayer2.transformer;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.mediacodec.MediaCodecAdapter;
import com.google.android.exoplayer2.mediacodec.MediaCodecInfo;
import com.google.android.exoplayer2.mediacodec.SynchronousMediaCodecAdapter;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MediaFormatUtil;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.nio.ByteBuffer;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

final class MediaCodecAdapterWrapper {
    private static final int MEDIA_CODEC_PCM_ENCODING = 2;
    private final MediaCodecAdapter codec;
    private int inputBufferIndex = -1;
    private boolean inputStreamEnded;
    private ByteBuffer outputBuffer;
    private int outputBufferIndex = -1;
    private final MediaCodec.BufferInfo outputBufferInfo = new MediaCodec.BufferInfo();
    private Format outputFormat;
    private boolean outputStreamEnded;

    private static class Factory extends SynchronousMediaCodecAdapter.Factory {
        private final boolean decoder;

        public Factory(boolean z) {
            this.decoder = z;
        }

        /* access modifiers changed from: protected */
        public MediaCodec createCodec(MediaCodecAdapter.Configuration configuration) throws IOException {
            String str = (String) Assertions.checkNotNull(configuration.mediaFormat.getString("mime"));
            if (this.decoder) {
                return MediaCodec.createDecoderByType((String) Assertions.checkNotNull(str));
            }
            return MediaCodec.createEncoderByType((String) Assertions.checkNotNull(str));
        }
    }

    private static MediaCodecInfo createPlaceholderMediaCodecInfo() {
        return MediaCodecInfo.newInstance("name-placeholder", "mime-type-placeholder", "mime-type-placeholder", (MediaCodecInfo.CodecCapabilities) null, false, false, false, false, false);
    }

    public static MediaCodecAdapterWrapper createForAudioDecoding(Format format) throws IOException {
        MediaCodecAdapter mediaCodecAdapter = null;
        try {
            MediaFormat createAudioFormat = MediaFormat.createAudioFormat((String) Assertions.checkNotNull(format.sampleMimeType), format.sampleRate, format.channelCount);
            MediaFormatUtil.maybeSetInteger(createAudioFormat, "max-input-size", format.maxInputSize);
            MediaFormatUtil.setCsdBuffers(createAudioFormat, format.initializationData);
            mediaCodecAdapter = new Factory(true).createAdapter(new MediaCodecAdapter.Configuration(createPlaceholderMediaCodecInfo(), createAudioFormat, format, (Surface) null, (MediaCrypto) null, 0));
            return new MediaCodecAdapterWrapper(mediaCodecAdapter);
        } catch (Exception e) {
            if (mediaCodecAdapter != null) {
                mediaCodecAdapter.release();
            }
            throw e;
        }
    }

    public static MediaCodecAdapterWrapper createForAudioEncoding(Format format) throws IOException {
        MediaCodecAdapter mediaCodecAdapter = null;
        try {
            MediaFormat createAudioFormat = MediaFormat.createAudioFormat((String) Assertions.checkNotNull(format.sampleMimeType), format.sampleRate, format.channelCount);
            createAudioFormat.setInteger("bitrate", format.bitrate);
            mediaCodecAdapter = new Factory(false).createAdapter(new MediaCodecAdapter.Configuration(createPlaceholderMediaCodecInfo(), createAudioFormat, format, (Surface) null, (MediaCrypto) null, 1));
            return new MediaCodecAdapterWrapper(mediaCodecAdapter);
        } catch (Exception e) {
            if (mediaCodecAdapter != null) {
                mediaCodecAdapter.release();
            }
            throw e;
        }
    }

    private MediaCodecAdapterWrapper(MediaCodecAdapter mediaCodecAdapter) {
        this.codec = mediaCodecAdapter;
    }

    @EnsuresNonNullIf(expression = {"#1.data"}, result = true)
    public boolean maybeDequeueInputBuffer(DecoderInputBuffer decoderInputBuffer) {
        if (this.inputStreamEnded) {
            return false;
        }
        if (this.inputBufferIndex < 0) {
            int dequeueInputBufferIndex = this.codec.dequeueInputBufferIndex();
            this.inputBufferIndex = dequeueInputBufferIndex;
            if (dequeueInputBufferIndex < 0) {
                return false;
            }
            decoderInputBuffer.data = this.codec.getInputBuffer(dequeueInputBufferIndex);
            decoderInputBuffer.clear();
        }
        Assertions.checkNotNull(decoderInputBuffer.data);
        return true;
    }

    public void queueInputBuffer(DecoderInputBuffer decoderInputBuffer) {
        int i;
        int i2;
        int i3;
        Assertions.checkState(!this.inputStreamEnded, "Input buffer can not be queued after the input stream has ended.");
        if (decoderInputBuffer.data == null || !decoderInputBuffer.data.hasRemaining()) {
            i2 = 0;
            i = 0;
        } else {
            i2 = decoderInputBuffer.data.position();
            i = decoderInputBuffer.data.remaining();
        }
        if (decoderInputBuffer.isEndOfStream()) {
            this.inputStreamEnded = true;
            i3 = 4;
        } else {
            i3 = 0;
        }
        this.codec.queueInputBuffer(this.inputBufferIndex, i2, i, decoderInputBuffer.timeUs, i3);
        this.inputBufferIndex = -1;
        decoderInputBuffer.data = null;
    }

    public Format getOutputFormat() {
        maybeDequeueOutputBuffer();
        return this.outputFormat;
    }

    public ByteBuffer getOutputBuffer() {
        if (maybeDequeueOutputBuffer()) {
            return this.outputBuffer;
        }
        return null;
    }

    public MediaCodec.BufferInfo getOutputBufferInfo() {
        if (maybeDequeueOutputBuffer()) {
            return this.outputBufferInfo;
        }
        return null;
    }

    public void releaseOutputBuffer() {
        this.outputBuffer = null;
        this.codec.releaseOutputBuffer(this.outputBufferIndex, false);
        this.outputBufferIndex = -1;
    }

    public boolean isEnded() {
        return this.outputStreamEnded && this.outputBufferIndex == -1;
    }

    public void release() {
        this.outputBuffer = null;
        this.codec.release();
    }

    private boolean maybeDequeueOutputBuffer() {
        if (this.outputBufferIndex >= 0) {
            return true;
        }
        if (this.outputStreamEnded) {
            return false;
        }
        int dequeueOutputBufferIndex = this.codec.dequeueOutputBufferIndex(this.outputBufferInfo);
        this.outputBufferIndex = dequeueOutputBufferIndex;
        if (dequeueOutputBufferIndex < 0) {
            if (dequeueOutputBufferIndex == -2) {
                this.outputFormat = getFormat(this.codec.getOutputFormat());
            }
            return false;
        }
        if ((this.outputBufferInfo.flags & 4) != 0) {
            this.outputStreamEnded = true;
            if (this.outputBufferInfo.size == 0) {
                releaseOutputBuffer();
                return false;
            }
        }
        if ((this.outputBufferInfo.flags & 2) != 0) {
            releaseOutputBuffer();
            return false;
        }
        ByteBuffer byteBuffer = (ByteBuffer) Assertions.checkNotNull(this.codec.getOutputBuffer(this.outputBufferIndex));
        this.outputBuffer = byteBuffer;
        byteBuffer.position(this.outputBufferInfo.offset);
        this.outputBuffer.limit(this.outputBufferInfo.offset + this.outputBufferInfo.size);
        return true;
    }

    private static Format getFormat(MediaFormat mediaFormat) {
        ImmutableList.Builder builder = new ImmutableList.Builder();
        int i = 0;
        while (true) {
            StringBuilder sb = new StringBuilder(15);
            sb.append("csd-");
            sb.append(i);
            ByteBuffer byteBuffer = mediaFormat.getByteBuffer(sb.toString());
            if (byteBuffer == null) {
                break;
            }
            byte[] bArr = new byte[byteBuffer.remaining()];
            byteBuffer.get(bArr);
            builder.add((Object) bArr);
            i++;
        }
        String string = mediaFormat.getString("mime");
        Format.Builder initializationData = new Format.Builder().setSampleMimeType(mediaFormat.getString("mime")).setInitializationData(builder.build());
        if (MimeTypes.isVideo(string)) {
            initializationData.setWidth(mediaFormat.getInteger(ViewHierarchyConstants.DIMENSION_WIDTH_KEY)).setHeight(mediaFormat.getInteger(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY));
        } else if (MimeTypes.isAudio(string)) {
            initializationData.setChannelCount(mediaFormat.getInteger("channel-count")).setSampleRate(mediaFormat.getInteger("sample-rate")).setPcmEncoding(2);
        }
        return initializationData.build();
    }
}

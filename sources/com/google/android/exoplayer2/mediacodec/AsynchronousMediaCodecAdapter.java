package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import com.google.android.exoplayer2.decoder.CryptoInfo;
import com.google.android.exoplayer2.mediacodec.MediaCodecAdapter;
import com.google.android.exoplayer2.util.TraceUtil;
import com.google.common.base.Supplier;
import java.nio.ByteBuffer;
import java.util.Objects;

final class AsynchronousMediaCodecAdapter implements MediaCodecAdapter {
    private static final int STATE_CREATED = 0;
    private static final int STATE_INITIALIZED = 1;
    private static final int STATE_SHUT_DOWN = 2;
    private final AsynchronousMediaCodecCallback asynchronousMediaCodecCallback;
    private final AsynchronousMediaCodecBufferEnqueuer bufferEnqueuer;
    private final MediaCodec codec;
    private boolean codecReleased;
    private int state;
    private final boolean synchronizeCodecInteractionsWithQueueing;

    public boolean needsReconfiguration() {
        return false;
    }

    public static final class Factory implements MediaCodecAdapter.Factory {
        private final Supplier<HandlerThread> callbackThreadSupplier;
        private final boolean forceQueueingSynchronizationWorkaround;
        private final Supplier<HandlerThread> queueingThreadSupplier;
        private final boolean synchronizeCodecInteractionsWithQueueing;

        public Factory(int i) {
            this(i, false, false);
        }

        public Factory(int i, boolean z, boolean z2) {
            this(new AsynchronousMediaCodecAdapter$Factory$$ExternalSyntheticLambda0(i), new AsynchronousMediaCodecAdapter$Factory$$ExternalSyntheticLambda1(i), z, z2);
        }

        static /* synthetic */ HandlerThread lambda$new$0(int i) {
            return new HandlerThread(AsynchronousMediaCodecAdapter.createCallbackThreadLabel(i));
        }

        static /* synthetic */ HandlerThread lambda$new$1(int i) {
            return new HandlerThread(AsynchronousMediaCodecAdapter.createQueueingThreadLabel(i));
        }

        Factory(Supplier<HandlerThread> supplier, Supplier<HandlerThread> supplier2, boolean z, boolean z2) {
            this.callbackThreadSupplier = supplier;
            this.queueingThreadSupplier = supplier2;
            this.forceQueueingSynchronizationWorkaround = z;
            this.synchronizeCodecInteractionsWithQueueing = z2;
        }

        /* JADX WARNING: Removed duplicated region for block: B:18:0x0059  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x005f  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.google.android.exoplayer2.mediacodec.AsynchronousMediaCodecAdapter createAdapter(com.google.android.exoplayer2.mediacodec.MediaCodecAdapter.Configuration r11) throws java.io.IOException {
            /*
                r10 = this;
                com.google.android.exoplayer2.mediacodec.MediaCodecInfo r0 = r11.codecInfo
                java.lang.String r0 = r0.name
                r1 = 0
                java.lang.String r2 = "createCodec:"
                java.lang.String r3 = java.lang.String.valueOf(r0)     // Catch:{ Exception -> 0x0055 }
                int r4 = r3.length()     // Catch:{ Exception -> 0x0055 }
                if (r4 == 0) goto L_0x0016
                java.lang.String r2 = r2.concat(r3)     // Catch:{ Exception -> 0x0055 }
                goto L_0x001c
            L_0x0016:
                java.lang.String r3 = new java.lang.String     // Catch:{ Exception -> 0x0055 }
                r3.<init>(r2)     // Catch:{ Exception -> 0x0055 }
                r2 = r3
            L_0x001c:
                com.google.android.exoplayer2.util.TraceUtil.beginSection(r2)     // Catch:{ Exception -> 0x0055 }
                android.media.MediaCodec r0 = android.media.MediaCodec.createByCodecName(r0)     // Catch:{ Exception -> 0x0055 }
                com.google.android.exoplayer2.mediacodec.AsynchronousMediaCodecAdapter r2 = new com.google.android.exoplayer2.mediacodec.AsynchronousMediaCodecAdapter     // Catch:{ Exception -> 0x0053 }
                com.google.common.base.Supplier<android.os.HandlerThread> r3 = r10.callbackThreadSupplier     // Catch:{ Exception -> 0x0053 }
                java.lang.Object r3 = r3.get()     // Catch:{ Exception -> 0x0053 }
                r5 = r3
                android.os.HandlerThread r5 = (android.os.HandlerThread) r5     // Catch:{ Exception -> 0x0053 }
                com.google.common.base.Supplier<android.os.HandlerThread> r3 = r10.queueingThreadSupplier     // Catch:{ Exception -> 0x0053 }
                java.lang.Object r3 = r3.get()     // Catch:{ Exception -> 0x0053 }
                r6 = r3
                android.os.HandlerThread r6 = (android.os.HandlerThread) r6     // Catch:{ Exception -> 0x0053 }
                boolean r7 = r10.forceQueueingSynchronizationWorkaround     // Catch:{ Exception -> 0x0053 }
                boolean r8 = r10.synchronizeCodecInteractionsWithQueueing     // Catch:{ Exception -> 0x0053 }
                r9 = 0
                r3 = r2
                r4 = r0
                r3.<init>(r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x0053 }
                com.google.android.exoplayer2.util.TraceUtil.endSection()     // Catch:{ Exception -> 0x0050 }
                android.media.MediaFormat r1 = r11.mediaFormat     // Catch:{ Exception -> 0x0050 }
                android.view.Surface r3 = r11.surface     // Catch:{ Exception -> 0x0050 }
                android.media.MediaCrypto r4 = r11.crypto     // Catch:{ Exception -> 0x0050 }
                int r11 = r11.flags     // Catch:{ Exception -> 0x0050 }
                r2.initialize(r1, r3, r4, r11)     // Catch:{ Exception -> 0x0050 }
                return r2
            L_0x0050:
                r11 = move-exception
                r1 = r2
                goto L_0x0057
            L_0x0053:
                r11 = move-exception
                goto L_0x0057
            L_0x0055:
                r11 = move-exception
                r0 = r1
            L_0x0057:
                if (r1 != 0) goto L_0x005f
                if (r0 == 0) goto L_0x0062
                r0.release()
                goto L_0x0062
            L_0x005f:
                r1.release()
            L_0x0062:
                throw r11
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.mediacodec.AsynchronousMediaCodecAdapter.Factory.createAdapter(com.google.android.exoplayer2.mediacodec.MediaCodecAdapter$Configuration):com.google.android.exoplayer2.mediacodec.AsynchronousMediaCodecAdapter");
        }
    }

    private AsynchronousMediaCodecAdapter(MediaCodec mediaCodec, HandlerThread handlerThread, HandlerThread handlerThread2, boolean z, boolean z2) {
        this.codec = mediaCodec;
        this.asynchronousMediaCodecCallback = new AsynchronousMediaCodecCallback(handlerThread);
        this.bufferEnqueuer = new AsynchronousMediaCodecBufferEnqueuer(mediaCodec, handlerThread2, z);
        this.synchronizeCodecInteractionsWithQueueing = z2;
        this.state = 0;
    }

    /* access modifiers changed from: private */
    public void initialize(MediaFormat mediaFormat, Surface surface, MediaCrypto mediaCrypto, int i) {
        this.asynchronousMediaCodecCallback.initialize(this.codec);
        TraceUtil.beginSection("configureCodec");
        this.codec.configure(mediaFormat, surface, mediaCrypto, i);
        TraceUtil.endSection();
        this.bufferEnqueuer.start();
        TraceUtil.beginSection("startCodec");
        this.codec.start();
        TraceUtil.endSection();
        this.state = 1;
    }

    public void queueInputBuffer(int i, int i2, int i3, long j, int i4) {
        this.bufferEnqueuer.queueInputBuffer(i, i2, i3, j, i4);
    }

    public void queueSecureInputBuffer(int i, int i2, CryptoInfo cryptoInfo, long j, int i3) {
        this.bufferEnqueuer.queueSecureInputBuffer(i, i2, cryptoInfo, j, i3);
    }

    public void releaseOutputBuffer(int i, boolean z) {
        this.codec.releaseOutputBuffer(i, z);
    }

    public void releaseOutputBuffer(int i, long j) {
        this.codec.releaseOutputBuffer(i, j);
    }

    public int dequeueInputBufferIndex() {
        return this.asynchronousMediaCodecCallback.dequeueInputBufferIndex();
    }

    public int dequeueOutputBufferIndex(MediaCodec.BufferInfo bufferInfo) {
        return this.asynchronousMediaCodecCallback.dequeueOutputBufferIndex(bufferInfo);
    }

    public MediaFormat getOutputFormat() {
        return this.asynchronousMediaCodecCallback.getOutputFormat();
    }

    public ByteBuffer getInputBuffer(int i) {
        return this.codec.getInputBuffer(i);
    }

    public ByteBuffer getOutputBuffer(int i) {
        return this.codec.getOutputBuffer(i);
    }

    public void flush() {
        this.bufferEnqueuer.flush();
        this.codec.flush();
        AsynchronousMediaCodecCallback asynchronousMediaCodecCallback2 = this.asynchronousMediaCodecCallback;
        MediaCodec mediaCodec = this.codec;
        Objects.requireNonNull(mediaCodec);
        asynchronousMediaCodecCallback2.flushAsync(new AsynchronousMediaCodecAdapter$$ExternalSyntheticLambda1(mediaCodec));
    }

    public void release() {
        try {
            if (this.state == 1) {
                this.bufferEnqueuer.shutdown();
                this.asynchronousMediaCodecCallback.shutdown();
            }
            this.state = 2;
        } finally {
            if (!this.codecReleased) {
                this.codec.release();
                this.codecReleased = true;
            }
        }
    }

    public void setOnFrameRenderedListener(MediaCodecAdapter.OnFrameRenderedListener onFrameRenderedListener, Handler handler) {
        maybeBlockOnQueueing();
        this.codec.setOnFrameRenderedListener(new AsynchronousMediaCodecAdapter$$ExternalSyntheticLambda0(this, onFrameRenderedListener), handler);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$setOnFrameRenderedListener$0$com-google-android-exoplayer2-mediacodec-AsynchronousMediaCodecAdapter  reason: not valid java name */
    public /* synthetic */ void m2044lambda$setOnFrameRenderedListener$0$comgoogleandroidexoplayer2mediacodecAsynchronousMediaCodecAdapter(MediaCodecAdapter.OnFrameRenderedListener onFrameRenderedListener, MediaCodec mediaCodec, long j, long j2) {
        onFrameRenderedListener.onFrameRendered(this, j, j2);
    }

    public void setOutputSurface(Surface surface) {
        maybeBlockOnQueueing();
        this.codec.setOutputSurface(surface);
    }

    public void setParameters(Bundle bundle) {
        maybeBlockOnQueueing();
        this.codec.setParameters(bundle);
    }

    public void setVideoScalingMode(int i) {
        maybeBlockOnQueueing();
        this.codec.setVideoScalingMode(i);
    }

    /* access modifiers changed from: package-private */
    public void onError(MediaCodec.CodecException codecException) {
        this.asynchronousMediaCodecCallback.onError(this.codec, codecException);
    }

    /* access modifiers changed from: package-private */
    public void onOutputFormatChanged(MediaFormat mediaFormat) {
        this.asynchronousMediaCodecCallback.onOutputFormatChanged(this.codec, mediaFormat);
    }

    private void maybeBlockOnQueueing() {
        if (this.synchronizeCodecInteractionsWithQueueing) {
            try {
                this.bufferEnqueuer.waitUntilQueueingComplete();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException(e);
            }
        }
    }

    /* access modifiers changed from: private */
    public static String createCallbackThreadLabel(int i) {
        return createThreadLabel(i, "ExoPlayer:MediaCodecAsyncAdapter:");
    }

    /* access modifiers changed from: private */
    public static String createQueueingThreadLabel(int i) {
        return createThreadLabel(i, "ExoPlayer:MediaCodecQueueingThread:");
    }

    private static String createThreadLabel(int i, String str) {
        StringBuilder sb = new StringBuilder(str);
        if (i == 1) {
            sb.append("Audio");
        } else if (i == 2) {
            sb.append("Video");
        } else {
            sb.append("Unknown(");
            sb.append(i);
            sb.append(")");
        }
        return sb.toString();
    }
}

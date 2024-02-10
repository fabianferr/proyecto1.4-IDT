package com.google.android.exoplayer2;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.exoplayer2.audio.AudioCapabilities;
import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.audio.AudioSink;
import com.google.android.exoplayer2.audio.DefaultAudioSink;
import com.google.android.exoplayer2.mediacodec.MediaCodecSelector;
import com.google.android.exoplayer2.metadata.MetadataOutput;
import com.google.android.exoplayer2.metadata.MetadataRenderer;
import com.google.android.exoplayer2.text.TextOutput;
import com.google.android.exoplayer2.text.TextRenderer;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import com.google.android.exoplayer2.video.spherical.CameraMotionRenderer;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;

public class DefaultRenderersFactory implements RenderersFactory {
    public static final long DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS = 5000;
    public static final int EXTENSION_RENDERER_MODE_OFF = 0;
    public static final int EXTENSION_RENDERER_MODE_ON = 1;
    public static final int EXTENSION_RENDERER_MODE_PREFER = 2;
    public static final int MAX_DROPPED_VIDEO_FRAME_COUNT_TO_NOTIFY = 50;
    private static final String TAG = "DefaultRenderersFactory";
    private long allowedVideoJoiningTimeMs;
    private final Context context;
    private boolean enableAsyncQueueing;
    private boolean enableAudioTrackPlaybackParams;
    private boolean enableDecoderFallback;
    private boolean enableFloatOutput;
    private boolean enableOffload;
    private boolean enableSynchronizeCodecInteractionsWithQueueing;
    private int extensionRendererMode;
    private boolean forceAsyncQueueingSynchronizationWorkaround;
    private MediaCodecSelector mediaCodecSelector;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface ExtensionRendererMode {
    }

    /* access modifiers changed from: protected */
    public void buildMiscellaneousRenderers(Context context2, Handler handler, int i, ArrayList<Renderer> arrayList) {
    }

    public DefaultRenderersFactory(Context context2) {
        this.context = context2;
        this.extensionRendererMode = 0;
        this.allowedVideoJoiningTimeMs = 5000;
        this.mediaCodecSelector = MediaCodecSelector.DEFAULT;
    }

    @Deprecated
    public DefaultRenderersFactory(Context context2, int i) {
        this(context2, i, 5000);
    }

    @Deprecated
    public DefaultRenderersFactory(Context context2, int i, long j) {
        this.context = context2;
        this.extensionRendererMode = i;
        this.allowedVideoJoiningTimeMs = j;
        this.mediaCodecSelector = MediaCodecSelector.DEFAULT;
    }

    public DefaultRenderersFactory setExtensionRendererMode(int i) {
        this.extensionRendererMode = i;
        return this;
    }

    public DefaultRenderersFactory experimentalSetAsynchronousBufferQueueingEnabled(boolean z) {
        this.enableAsyncQueueing = z;
        return this;
    }

    public DefaultRenderersFactory experimentalSetForceAsyncQueueingSynchronizationWorkaround(boolean z) {
        this.forceAsyncQueueingSynchronizationWorkaround = z;
        return this;
    }

    public DefaultRenderersFactory experimentalSetSynchronizeCodecInteractionsWithQueueingEnabled(boolean z) {
        this.enableSynchronizeCodecInteractionsWithQueueing = z;
        return this;
    }

    public DefaultRenderersFactory setEnableDecoderFallback(boolean z) {
        this.enableDecoderFallback = z;
        return this;
    }

    public DefaultRenderersFactory setMediaCodecSelector(MediaCodecSelector mediaCodecSelector2) {
        this.mediaCodecSelector = mediaCodecSelector2;
        return this;
    }

    public DefaultRenderersFactory setEnableAudioFloatOutput(boolean z) {
        this.enableFloatOutput = z;
        return this;
    }

    public DefaultRenderersFactory setEnableAudioOffload(boolean z) {
        this.enableOffload = z;
        return this;
    }

    public DefaultRenderersFactory setEnableAudioTrackPlaybackParams(boolean z) {
        this.enableAudioTrackPlaybackParams = z;
        return this;
    }

    public DefaultRenderersFactory setAllowedVideoJoiningTimeMs(long j) {
        this.allowedVideoJoiningTimeMs = j;
        return this;
    }

    public Renderer[] createRenderers(Handler handler, VideoRendererEventListener videoRendererEventListener, AudioRendererEventListener audioRendererEventListener, TextOutput textOutput, MetadataOutput metadataOutput) {
        ArrayList arrayList = new ArrayList();
        buildVideoRenderers(this.context, this.extensionRendererMode, this.mediaCodecSelector, this.enableDecoderFallback, handler, videoRendererEventListener, this.allowedVideoJoiningTimeMs, arrayList);
        AudioSink buildAudioSink = buildAudioSink(this.context, this.enableFloatOutput, this.enableAudioTrackPlaybackParams, this.enableOffload);
        if (buildAudioSink != null) {
            buildAudioRenderers(this.context, this.extensionRendererMode, this.mediaCodecSelector, this.enableDecoderFallback, buildAudioSink, handler, audioRendererEventListener, arrayList);
        }
        ArrayList arrayList2 = arrayList;
        buildTextRenderers(this.context, textOutput, handler.getLooper(), this.extensionRendererMode, arrayList2);
        buildMetadataRenderers(this.context, metadataOutput, handler.getLooper(), this.extensionRendererMode, arrayList2);
        buildCameraMotionRenderers(this.context, this.extensionRendererMode, arrayList);
        Handler handler2 = handler;
        buildMiscellaneousRenderers(this.context, handler, this.extensionRendererMode, arrayList);
        return (Renderer[]) arrayList.toArray(new Renderer[0]);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x007f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0087, code lost:
        throw new java.lang.RuntimeException("Error instantiating VP9 extension", r0);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x007f A[ExcHandler: Exception (r0v7 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:7:0x0040] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void buildVideoRenderers(android.content.Context r15, int r16, com.google.android.exoplayer2.mediacodec.MediaCodecSelector r17, boolean r18, android.os.Handler r19, com.google.android.exoplayer2.video.VideoRendererEventListener r20, long r21, java.util.ArrayList<com.google.android.exoplayer2.Renderer> r23) {
        /*
            r14 = this;
            r1 = r14
            r0 = r16
            r11 = r23
            java.lang.String r12 = "DefaultRenderersFactory"
            com.google.android.exoplayer2.video.MediaCodecVideoRenderer r13 = new com.google.android.exoplayer2.video.MediaCodecVideoRenderer
            r10 = 50
            r2 = r13
            r3 = r15
            r4 = r17
            r5 = r21
            r7 = r18
            r8 = r19
            r9 = r20
            r2.<init>(r3, r4, r5, r7, r8, r9, r10)
            boolean r2 = r1.enableAsyncQueueing
            r13.experimentalSetAsynchronousBufferQueueingEnabled(r2)
            boolean r2 = r1.forceAsyncQueueingSynchronizationWorkaround
            r13.experimentalSetForceAsyncQueueingSynchronizationWorkaround(r2)
            boolean r2 = r1.enableSynchronizeCodecInteractionsWithQueueing
            r13.experimentalSetSynchronizeCodecInteractionsWithQueueingEnabled(r2)
            r11.add(r13)
            if (r0 != 0) goto L_0x002f
            return
        L_0x002f:
            int r2 = r23.size()
            r3 = 2
            if (r0 != r3) goto L_0x0038
            int r2 = r2 + -1
        L_0x0038:
            r0 = 50
            r4 = 3
            r5 = 0
            r6 = 4
            r7 = 1
            java.lang.String r8 = "com.google.android.exoplayer2.ext.vp9.LibvpxVideoRenderer"
            java.lang.Class r8 = java.lang.Class.forName(r8)     // Catch:{ ClassNotFoundException -> 0x0088, Exception -> 0x007f }
            java.lang.Class[] r9 = new java.lang.Class[r6]     // Catch:{ ClassNotFoundException -> 0x0088, Exception -> 0x007f }
            java.lang.Class r10 = java.lang.Long.TYPE     // Catch:{ ClassNotFoundException -> 0x0088, Exception -> 0x007f }
            r9[r5] = r10     // Catch:{ ClassNotFoundException -> 0x0088, Exception -> 0x007f }
            java.lang.Class<android.os.Handler> r10 = android.os.Handler.class
            r9[r7] = r10     // Catch:{ ClassNotFoundException -> 0x0088, Exception -> 0x007f }
            java.lang.Class<com.google.android.exoplayer2.video.VideoRendererEventListener> r10 = com.google.android.exoplayer2.video.VideoRendererEventListener.class
            r9[r3] = r10     // Catch:{ ClassNotFoundException -> 0x0088, Exception -> 0x007f }
            java.lang.Class r10 = java.lang.Integer.TYPE     // Catch:{ ClassNotFoundException -> 0x0088, Exception -> 0x007f }
            r9[r4] = r10     // Catch:{ ClassNotFoundException -> 0x0088, Exception -> 0x007f }
            java.lang.reflect.Constructor r8 = r8.getConstructor(r9)     // Catch:{ ClassNotFoundException -> 0x0088, Exception -> 0x007f }
            java.lang.Object[] r9 = new java.lang.Object[r6]     // Catch:{ ClassNotFoundException -> 0x0088, Exception -> 0x007f }
            java.lang.Long r10 = java.lang.Long.valueOf(r21)     // Catch:{ ClassNotFoundException -> 0x0088, Exception -> 0x007f }
            r9[r5] = r10     // Catch:{ ClassNotFoundException -> 0x0088, Exception -> 0x007f }
            r9[r7] = r19     // Catch:{ ClassNotFoundException -> 0x0088, Exception -> 0x007f }
            r9[r3] = r20     // Catch:{ ClassNotFoundException -> 0x0088, Exception -> 0x007f }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r0)     // Catch:{ ClassNotFoundException -> 0x0088, Exception -> 0x007f }
            r9[r4] = r10     // Catch:{ ClassNotFoundException -> 0x0088, Exception -> 0x007f }
            java.lang.Object r8 = r8.newInstance(r9)     // Catch:{ ClassNotFoundException -> 0x0088, Exception -> 0x007f }
            com.google.android.exoplayer2.Renderer r8 = (com.google.android.exoplayer2.Renderer) r8     // Catch:{ ClassNotFoundException -> 0x0088, Exception -> 0x007f }
            int r9 = r2 + 1
            r11.add(r2, r8)     // Catch:{ ClassNotFoundException -> 0x007d, Exception -> 0x007f }
            java.lang.String r2 = "Loaded LibvpxVideoRenderer."
            com.google.android.exoplayer2.util.Log.i(r12, r2)     // Catch:{ ClassNotFoundException -> 0x007d, Exception -> 0x007f }
            goto L_0x0089
        L_0x007d:
            r2 = r9
            goto L_0x0088
        L_0x007f:
            r0 = move-exception
            java.lang.RuntimeException r2 = new java.lang.RuntimeException
            java.lang.String r3 = "Error instantiating VP9 extension"
            r2.<init>(r3, r0)
            throw r2
        L_0x0088:
            r9 = r2
        L_0x0089:
            java.lang.String r2 = "com.google.android.exoplayer2.ext.av1.Libgav1VideoRenderer"
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ ClassNotFoundException -> 0x00cf, Exception -> 0x00c6 }
            java.lang.Class[] r8 = new java.lang.Class[r6]     // Catch:{ ClassNotFoundException -> 0x00cf, Exception -> 0x00c6 }
            java.lang.Class r10 = java.lang.Long.TYPE     // Catch:{ ClassNotFoundException -> 0x00cf, Exception -> 0x00c6 }
            r8[r5] = r10     // Catch:{ ClassNotFoundException -> 0x00cf, Exception -> 0x00c6 }
            java.lang.Class<android.os.Handler> r10 = android.os.Handler.class
            r8[r7] = r10     // Catch:{ ClassNotFoundException -> 0x00cf, Exception -> 0x00c6 }
            java.lang.Class<com.google.android.exoplayer2.video.VideoRendererEventListener> r10 = com.google.android.exoplayer2.video.VideoRendererEventListener.class
            r8[r3] = r10     // Catch:{ ClassNotFoundException -> 0x00cf, Exception -> 0x00c6 }
            java.lang.Class r10 = java.lang.Integer.TYPE     // Catch:{ ClassNotFoundException -> 0x00cf, Exception -> 0x00c6 }
            r8[r4] = r10     // Catch:{ ClassNotFoundException -> 0x00cf, Exception -> 0x00c6 }
            java.lang.reflect.Constructor r2 = r2.getConstructor(r8)     // Catch:{ ClassNotFoundException -> 0x00cf, Exception -> 0x00c6 }
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ ClassNotFoundException -> 0x00cf, Exception -> 0x00c6 }
            java.lang.Long r8 = java.lang.Long.valueOf(r21)     // Catch:{ ClassNotFoundException -> 0x00cf, Exception -> 0x00c6 }
            r6[r5] = r8     // Catch:{ ClassNotFoundException -> 0x00cf, Exception -> 0x00c6 }
            r6[r7] = r19     // Catch:{ ClassNotFoundException -> 0x00cf, Exception -> 0x00c6 }
            r6[r3] = r20     // Catch:{ ClassNotFoundException -> 0x00cf, Exception -> 0x00c6 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ ClassNotFoundException -> 0x00cf, Exception -> 0x00c6 }
            r6[r4] = r0     // Catch:{ ClassNotFoundException -> 0x00cf, Exception -> 0x00c6 }
            java.lang.Object r0 = r2.newInstance(r6)     // Catch:{ ClassNotFoundException -> 0x00cf, Exception -> 0x00c6 }
            com.google.android.exoplayer2.Renderer r0 = (com.google.android.exoplayer2.Renderer) r0     // Catch:{ ClassNotFoundException -> 0x00cf, Exception -> 0x00c6 }
            r11.add(r9, r0)     // Catch:{ ClassNotFoundException -> 0x00cf, Exception -> 0x00c6 }
            java.lang.String r0 = "Loaded Libgav1VideoRenderer."
            com.google.android.exoplayer2.util.Log.i(r12, r0)     // Catch:{ ClassNotFoundException -> 0x00cf, Exception -> 0x00c6 }
            goto L_0x00cf
        L_0x00c6:
            r0 = move-exception
            java.lang.RuntimeException r2 = new java.lang.RuntimeException
            java.lang.String r3 = "Error instantiating AV1 extension"
            r2.<init>(r3, r0)
            throw r2
        L_0x00cf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.DefaultRenderersFactory.buildVideoRenderers(android.content.Context, int, com.google.android.exoplayer2.mediacodec.MediaCodecSelector, boolean, android.os.Handler, com.google.android.exoplayer2.video.VideoRendererEventListener, long, java.util.ArrayList):void");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x006a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0072, code lost:
        throw new java.lang.RuntimeException("Error instantiating Opus extension", r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00a7, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00af, code lost:
        throw new java.lang.RuntimeException("Error instantiating FLAC extension", r0);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x006a A[ExcHandler: Exception (r0v7 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:7:0x0039] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00a7 A[ExcHandler: Exception (r0v6 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:20:0x0076] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void buildAudioRenderers(android.content.Context r13, int r14, com.google.android.exoplayer2.mediacodec.MediaCodecSelector r15, boolean r16, com.google.android.exoplayer2.audio.AudioSink r17, android.os.Handler r18, com.google.android.exoplayer2.audio.AudioRendererEventListener r19, java.util.ArrayList<com.google.android.exoplayer2.Renderer> r20) {
        /*
            r12 = this;
            r1 = r12
            r0 = r14
            r9 = r20
            java.lang.String r10 = "DefaultRenderersFactory"
            com.google.android.exoplayer2.audio.MediaCodecAudioRenderer r11 = new com.google.android.exoplayer2.audio.MediaCodecAudioRenderer
            r2 = r11
            r3 = r13
            r4 = r15
            r5 = r16
            r6 = r18
            r7 = r19
            r8 = r17
            r2.<init>((android.content.Context) r3, (com.google.android.exoplayer2.mediacodec.MediaCodecSelector) r4, (boolean) r5, (android.os.Handler) r6, (com.google.android.exoplayer2.audio.AudioRendererEventListener) r7, (com.google.android.exoplayer2.audio.AudioSink) r8)
            boolean r2 = r1.enableAsyncQueueing
            r11.experimentalSetAsynchronousBufferQueueingEnabled(r2)
            boolean r2 = r1.forceAsyncQueueingSynchronizationWorkaround
            r11.experimentalSetForceAsyncQueueingSynchronizationWorkaround(r2)
            boolean r2 = r1.enableSynchronizeCodecInteractionsWithQueueing
            r11.experimentalSetSynchronizeCodecInteractionsWithQueueingEnabled(r2)
            r9.add(r11)
            if (r0 != 0) goto L_0x002b
            return
        L_0x002b:
            int r2 = r20.size()
            r3 = 2
            if (r0 != r3) goto L_0x0034
            int r2 = r2 + -1
        L_0x0034:
            r0 = 0
            r4 = 3
            r5 = 1
            java.lang.String r6 = "com.google.android.exoplayer2.ext.opus.LibopusAudioRenderer"
            java.lang.Class r6 = java.lang.Class.forName(r6)     // Catch:{ ClassNotFoundException -> 0x0073, Exception -> 0x006a }
            java.lang.Class[] r7 = new java.lang.Class[r4]     // Catch:{ ClassNotFoundException -> 0x0073, Exception -> 0x006a }
            java.lang.Class<android.os.Handler> r8 = android.os.Handler.class
            r7[r0] = r8     // Catch:{ ClassNotFoundException -> 0x0073, Exception -> 0x006a }
            java.lang.Class<com.google.android.exoplayer2.audio.AudioRendererEventListener> r8 = com.google.android.exoplayer2.audio.AudioRendererEventListener.class
            r7[r5] = r8     // Catch:{ ClassNotFoundException -> 0x0073, Exception -> 0x006a }
            java.lang.Class<com.google.android.exoplayer2.audio.AudioSink> r8 = com.google.android.exoplayer2.audio.AudioSink.class
            r7[r3] = r8     // Catch:{ ClassNotFoundException -> 0x0073, Exception -> 0x006a }
            java.lang.reflect.Constructor r6 = r6.getConstructor(r7)     // Catch:{ ClassNotFoundException -> 0x0073, Exception -> 0x006a }
            java.lang.Object[] r7 = new java.lang.Object[r4]     // Catch:{ ClassNotFoundException -> 0x0073, Exception -> 0x006a }
            r7[r0] = r18     // Catch:{ ClassNotFoundException -> 0x0073, Exception -> 0x006a }
            r7[r5] = r19     // Catch:{ ClassNotFoundException -> 0x0073, Exception -> 0x006a }
            r7[r3] = r17     // Catch:{ ClassNotFoundException -> 0x0073, Exception -> 0x006a }
            java.lang.Object r6 = r6.newInstance(r7)     // Catch:{ ClassNotFoundException -> 0x0073, Exception -> 0x006a }
            com.google.android.exoplayer2.Renderer r6 = (com.google.android.exoplayer2.Renderer) r6     // Catch:{ ClassNotFoundException -> 0x0073, Exception -> 0x006a }
            int r7 = r2 + 1
            r9.add(r2, r6)     // Catch:{ ClassNotFoundException -> 0x0068, Exception -> 0x006a }
            java.lang.String r2 = "Loaded LibopusAudioRenderer."
            com.google.android.exoplayer2.util.Log.i(r10, r2)     // Catch:{ ClassNotFoundException -> 0x0068, Exception -> 0x006a }
            goto L_0x0074
        L_0x0068:
            r2 = r7
            goto L_0x0073
        L_0x006a:
            r0 = move-exception
            java.lang.RuntimeException r2 = new java.lang.RuntimeException
            java.lang.String r3 = "Error instantiating Opus extension"
            r2.<init>(r3, r0)
            throw r2
        L_0x0073:
            r7 = r2
        L_0x0074:
            java.lang.String r2 = "com.google.android.exoplayer2.ext.flac.LibflacAudioRenderer"
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ ClassNotFoundException -> 0x00b0, Exception -> 0x00a7 }
            java.lang.Class[] r6 = new java.lang.Class[r4]     // Catch:{ ClassNotFoundException -> 0x00b0, Exception -> 0x00a7 }
            java.lang.Class<android.os.Handler> r8 = android.os.Handler.class
            r6[r0] = r8     // Catch:{ ClassNotFoundException -> 0x00b0, Exception -> 0x00a7 }
            java.lang.Class<com.google.android.exoplayer2.audio.AudioRendererEventListener> r8 = com.google.android.exoplayer2.audio.AudioRendererEventListener.class
            r6[r5] = r8     // Catch:{ ClassNotFoundException -> 0x00b0, Exception -> 0x00a7 }
            java.lang.Class<com.google.android.exoplayer2.audio.AudioSink> r8 = com.google.android.exoplayer2.audio.AudioSink.class
            r6[r3] = r8     // Catch:{ ClassNotFoundException -> 0x00b0, Exception -> 0x00a7 }
            java.lang.reflect.Constructor r2 = r2.getConstructor(r6)     // Catch:{ ClassNotFoundException -> 0x00b0, Exception -> 0x00a7 }
            java.lang.Object[] r6 = new java.lang.Object[r4]     // Catch:{ ClassNotFoundException -> 0x00b0, Exception -> 0x00a7 }
            r6[r0] = r18     // Catch:{ ClassNotFoundException -> 0x00b0, Exception -> 0x00a7 }
            r6[r5] = r19     // Catch:{ ClassNotFoundException -> 0x00b0, Exception -> 0x00a7 }
            r6[r3] = r17     // Catch:{ ClassNotFoundException -> 0x00b0, Exception -> 0x00a7 }
            java.lang.Object r2 = r2.newInstance(r6)     // Catch:{ ClassNotFoundException -> 0x00b0, Exception -> 0x00a7 }
            com.google.android.exoplayer2.Renderer r2 = (com.google.android.exoplayer2.Renderer) r2     // Catch:{ ClassNotFoundException -> 0x00b0, Exception -> 0x00a7 }
            int r6 = r7 + 1
            r9.add(r7, r2)     // Catch:{ ClassNotFoundException -> 0x00a5, Exception -> 0x00a7 }
            java.lang.String r2 = "Loaded LibflacAudioRenderer."
            com.google.android.exoplayer2.util.Log.i(r10, r2)     // Catch:{ ClassNotFoundException -> 0x00a5, Exception -> 0x00a7 }
            goto L_0x00b1
        L_0x00a5:
            r7 = r6
            goto L_0x00b0
        L_0x00a7:
            r0 = move-exception
            java.lang.RuntimeException r2 = new java.lang.RuntimeException
            java.lang.String r3 = "Error instantiating FLAC extension"
            r2.<init>(r3, r0)
            throw r2
        L_0x00b0:
            r6 = r7
        L_0x00b1:
            java.lang.String r2 = "com.google.android.exoplayer2.ext.ffmpeg.FfmpegAudioRenderer"
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ ClassNotFoundException -> 0x00e9, Exception -> 0x00e0 }
            java.lang.Class[] r7 = new java.lang.Class[r4]     // Catch:{ ClassNotFoundException -> 0x00e9, Exception -> 0x00e0 }
            java.lang.Class<android.os.Handler> r8 = android.os.Handler.class
            r7[r0] = r8     // Catch:{ ClassNotFoundException -> 0x00e9, Exception -> 0x00e0 }
            java.lang.Class<com.google.android.exoplayer2.audio.AudioRendererEventListener> r8 = com.google.android.exoplayer2.audio.AudioRendererEventListener.class
            r7[r5] = r8     // Catch:{ ClassNotFoundException -> 0x00e9, Exception -> 0x00e0 }
            java.lang.Class<com.google.android.exoplayer2.audio.AudioSink> r8 = com.google.android.exoplayer2.audio.AudioSink.class
            r7[r3] = r8     // Catch:{ ClassNotFoundException -> 0x00e9, Exception -> 0x00e0 }
            java.lang.reflect.Constructor r2 = r2.getConstructor(r7)     // Catch:{ ClassNotFoundException -> 0x00e9, Exception -> 0x00e0 }
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ ClassNotFoundException -> 0x00e9, Exception -> 0x00e0 }
            r4[r0] = r18     // Catch:{ ClassNotFoundException -> 0x00e9, Exception -> 0x00e0 }
            r4[r5] = r19     // Catch:{ ClassNotFoundException -> 0x00e9, Exception -> 0x00e0 }
            r4[r3] = r17     // Catch:{ ClassNotFoundException -> 0x00e9, Exception -> 0x00e0 }
            java.lang.Object r0 = r2.newInstance(r4)     // Catch:{ ClassNotFoundException -> 0x00e9, Exception -> 0x00e0 }
            com.google.android.exoplayer2.Renderer r0 = (com.google.android.exoplayer2.Renderer) r0     // Catch:{ ClassNotFoundException -> 0x00e9, Exception -> 0x00e0 }
            r9.add(r6, r0)     // Catch:{ ClassNotFoundException -> 0x00e9, Exception -> 0x00e0 }
            java.lang.String r0 = "Loaded FfmpegAudioRenderer."
            com.google.android.exoplayer2.util.Log.i(r10, r0)     // Catch:{ ClassNotFoundException -> 0x00e9, Exception -> 0x00e0 }
            goto L_0x00e9
        L_0x00e0:
            r0 = move-exception
            java.lang.RuntimeException r2 = new java.lang.RuntimeException
            java.lang.String r3 = "Error instantiating FFmpeg extension"
            r2.<init>(r3, r0)
            throw r2
        L_0x00e9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.DefaultRenderersFactory.buildAudioRenderers(android.content.Context, int, com.google.android.exoplayer2.mediacodec.MediaCodecSelector, boolean, com.google.android.exoplayer2.audio.AudioSink, android.os.Handler, com.google.android.exoplayer2.audio.AudioRendererEventListener, java.util.ArrayList):void");
    }

    /* access modifiers changed from: protected */
    public void buildTextRenderers(Context context2, TextOutput textOutput, Looper looper, int i, ArrayList<Renderer> arrayList) {
        arrayList.add(new TextRenderer(textOutput, looper));
    }

    /* access modifiers changed from: protected */
    public void buildMetadataRenderers(Context context2, MetadataOutput metadataOutput, Looper looper, int i, ArrayList<Renderer> arrayList) {
        arrayList.add(new MetadataRenderer(metadataOutput, looper));
    }

    /* access modifiers changed from: protected */
    public void buildCameraMotionRenderers(Context context2, int i, ArrayList<Renderer> arrayList) {
        arrayList.add(new CameraMotionRenderer());
    }

    /* access modifiers changed from: protected */
    public AudioSink buildAudioSink(Context context2, boolean z, boolean z2, boolean z3) {
        return new DefaultAudioSink(AudioCapabilities.getCapabilities(context2), new DefaultAudioSink.DefaultAudioProcessorChain(new AudioProcessor[0]), z, z2, z3 ? 1 : 0);
    }
}

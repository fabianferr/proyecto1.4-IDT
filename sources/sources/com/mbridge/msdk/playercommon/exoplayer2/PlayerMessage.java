package com.mbridge.msdk.playercommon.exoplayer2;

import android.os.Handler;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;

public final class PlayerMessage {
    private boolean deleteAfterDelivery = true;
    private Handler handler;
    private boolean isCanceled;
    private boolean isDelivered;
    private boolean isProcessed;
    private boolean isSent;
    private Object payload;
    private long positionMs = -9223372036854775807L;
    private final Sender sender;
    private final Target target;
    private final Timeline timeline;
    private int type;
    private int windowIndex;

    public interface Sender {
        void sendMessage(PlayerMessage playerMessage);
    }

    public interface Target {
        void handleMessage(int i, Object obj) throws ExoPlaybackException;
    }

    public PlayerMessage(Sender sender2, Target target2, Timeline timeline2, int i, Handler handler2) {
        this.sender = sender2;
        this.target = target2;
        this.timeline = timeline2;
        this.handler = handler2;
        this.windowIndex = i;
    }

    public final Timeline getTimeline() {
        return this.timeline;
    }

    public final Target getTarget() {
        return this.target;
    }

    public final PlayerMessage setType(int i) {
        Assertions.checkState(!this.isSent);
        this.type = i;
        return this;
    }

    public final int getType() {
        return this.type;
    }

    public final PlayerMessage setPayload(Object obj) {
        Assertions.checkState(!this.isSent);
        this.payload = obj;
        return this;
    }

    public final Object getPayload() {
        return this.payload;
    }

    public final PlayerMessage setHandler(Handler handler2) {
        Assertions.checkState(!this.isSent);
        this.handler = handler2;
        return this;
    }

    public final Handler getHandler() {
        return this.handler;
    }

    public final PlayerMessage setPosition(long j) {
        Assertions.checkState(!this.isSent);
        this.positionMs = j;
        return this;
    }

    public final long getPositionMs() {
        return this.positionMs;
    }

    public final PlayerMessage setPosition(int i, long j) {
        boolean z = true;
        Assertions.checkState(!this.isSent);
        if (j == -9223372036854775807L) {
            z = false;
        }
        Assertions.checkArgument(z);
        if (i < 0 || (!this.timeline.isEmpty() && i >= this.timeline.getWindowCount())) {
            throw new IllegalSeekPositionException(this.timeline, i, j);
        }
        this.windowIndex = i;
        this.positionMs = j;
        return this;
    }

    public final int getWindowIndex() {
        return this.windowIndex;
    }

    public final PlayerMessage setDeleteAfterDelivery(boolean z) {
        Assertions.checkState(!this.isSent);
        this.deleteAfterDelivery = z;
        return this;
    }

    public final boolean getDeleteAfterDelivery() {
        return this.deleteAfterDelivery;
    }

    public final PlayerMessage send() {
        Assertions.checkState(!this.isSent);
        if (this.positionMs == -9223372036854775807L) {
            Assertions.checkArgument(this.deleteAfterDelivery);
        }
        this.isSent = true;
        this.sender.sendMessage(this);
        return this;
    }

    public final synchronized PlayerMessage cancel() {
        Assertions.checkState(this.isSent);
        this.isCanceled = true;
        markAsProcessed(false);
        return this;
    }

    public final synchronized boolean isCanceled() {
        return this.isCanceled;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x003d A[SYNTHETIC, Splitter:B:16:0x003d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean blockUntilDelivered() throws java.lang.InterruptedException, java.util.concurrent.TimeoutException {
        /*
            r8 = this;
            monitor-enter(r8)
            boolean r0 = r8.isSent     // Catch:{ all -> 0x0045 }
            com.mbridge.msdk.playercommon.exoplayer2.util.Assertions.checkState(r0)     // Catch:{ all -> 0x0045 }
            android.os.Handler r0 = r8.handler     // Catch:{ all -> 0x0045 }
            android.os.Looper r0 = r0.getLooper()     // Catch:{ all -> 0x0045 }
            java.lang.Thread r0 = r0.getThread()     // Catch:{ all -> 0x0045 }
            java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0045 }
            if (r0 == r1) goto L_0x0018
            r0 = 1
            goto L_0x0019
        L_0x0018:
            r0 = 0
        L_0x0019:
            com.mbridge.msdk.playercommon.exoplayer2.util.Assertions.checkState(r0)     // Catch:{ all -> 0x0045 }
            long r0 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x0045 }
            r2 = 500(0x1f4, double:2.47E-321)
            long r0 = r0 + r2
        L_0x0023:
            boolean r4 = r8.isProcessed     // Catch:{ all -> 0x0045 }
            if (r4 != 0) goto L_0x0037
            r5 = 0
            int r7 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x0037
            r8.wait(r2)     // Catch:{ all -> 0x0045 }
            long r2 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x0045 }
            long r2 = r0 - r2
            goto L_0x0023
        L_0x0037:
            if (r4 == 0) goto L_0x003d
            boolean r0 = r8.isDelivered     // Catch:{ all -> 0x0045 }
            monitor-exit(r8)
            return r0
        L_0x003d:
            java.util.concurrent.TimeoutException r0 = new java.util.concurrent.TimeoutException     // Catch:{ all -> 0x0045 }
            java.lang.String r1 = "Message delivery time out"
            r0.<init>(r1)     // Catch:{ all -> 0x0045 }
            throw r0     // Catch:{ all -> 0x0045 }
        L_0x0045:
            r0 = move-exception
            monitor-exit(r8)
            goto L_0x0049
        L_0x0048:
            throw r0
        L_0x0049:
            goto L_0x0048
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.PlayerMessage.blockUntilDelivered():boolean");
    }

    public final synchronized void markAsProcessed(boolean z) {
        this.isDelivered = z | this.isDelivered;
        this.isProcessed = true;
        notifyAll();
    }
}

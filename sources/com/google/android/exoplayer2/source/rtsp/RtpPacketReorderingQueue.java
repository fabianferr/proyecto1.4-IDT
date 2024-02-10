package com.google.android.exoplayer2.source.rtsp;

import java.util.TreeSet;

final class RtpPacketReorderingQueue {
    static final int MAX_SEQUENCE_LEAP_ALLOWED = 1000;
    private static final int MAX_SEQUENCE_NUMBER = 65535;
    private static final int QUEUE_SIZE_THRESHOLD_FOR_RESET = 5000;
    private int lastDequeuedSequenceNumber;
    private int lastReceivedSequenceNumber;
    private final TreeSet<RtpPacketContainer> packetQueue = new TreeSet<>(new RtpPacketReorderingQueue$$ExternalSyntheticLambda0());
    private boolean started;

    public RtpPacketReorderingQueue() {
        reset();
    }

    public synchronized void reset() {
        this.packetQueue.clear();
        this.started = false;
        this.lastDequeuedSequenceNumber = -1;
        this.lastReceivedSequenceNumber = -1;
    }

    public synchronized boolean offer(RtpPacket rtpPacket, long j) {
        if (this.packetQueue.size() < 5000) {
            int i = rtpPacket.sequenceNumber;
            if (!this.started) {
                reset();
                this.lastDequeuedSequenceNumber = prevSequenceNumber(i);
                this.started = true;
                addToQueue(new RtpPacketContainer(rtpPacket, j));
                return true;
            } else if (Math.abs(calculateSequenceNumberShift(i, nextSequenceNumber(this.lastReceivedSequenceNumber))) >= 1000) {
                this.lastDequeuedSequenceNumber = prevSequenceNumber(i);
                this.packetQueue.clear();
                addToQueue(new RtpPacketContainer(rtpPacket, j));
                return true;
            } else if (calculateSequenceNumberShift(i, this.lastDequeuedSequenceNumber) <= 0) {
                return false;
            } else {
                addToQueue(new RtpPacketContainer(rtpPacket, j));
                return true;
            }
        } else {
            throw new IllegalStateException("Queue size limit of 5000 reached.");
        }
    }

    public synchronized RtpPacket poll(long j) {
        if (this.packetQueue.isEmpty()) {
            return null;
        }
        RtpPacketContainer first = this.packetQueue.first();
        int i = first.packet.sequenceNumber;
        if (i != nextSequenceNumber(this.lastDequeuedSequenceNumber) && j < first.receivedTimestampMs) {
            return null;
        }
        this.packetQueue.pollFirst();
        this.lastDequeuedSequenceNumber = i;
        return first.packet;
    }

    private synchronized void addToQueue(RtpPacketContainer rtpPacketContainer) {
        this.lastReceivedSequenceNumber = rtpPacketContainer.packet.sequenceNumber;
        this.packetQueue.add(rtpPacketContainer);
    }

    private static final class RtpPacketContainer {
        public final RtpPacket packet;
        public final long receivedTimestampMs;

        public RtpPacketContainer(RtpPacket rtpPacket, long j) {
            this.packet = rtpPacket;
            this.receivedTimestampMs = j;
        }
    }

    private static int nextSequenceNumber(int i) {
        return (i + 1) % 65535;
    }

    private static int prevSequenceNumber(int i) {
        if (i == 0) {
            return 65534;
        }
        return (i - 1) % 65535;
    }

    /* access modifiers changed from: private */
    public static int calculateSequenceNumberShift(int i, int i2) {
        int min;
        int i3 = i - i2;
        if (Math.abs(i3) <= 1000 || (min = (Math.min(i, i2) - Math.max(i, i2)) + 65535) >= 1000) {
            return i3;
        }
        return i < i2 ? min : -min;
    }
}

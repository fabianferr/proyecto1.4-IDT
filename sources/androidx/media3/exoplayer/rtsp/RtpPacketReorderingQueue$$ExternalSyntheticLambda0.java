package androidx.media3.exoplayer.rtsp;

import androidx.media3.exoplayer.rtsp.RtpPacketReorderingQueue;
import java.util.Comparator;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class RtpPacketReorderingQueue$$ExternalSyntheticLambda0 implements Comparator {
    public final int compare(Object obj, Object obj2) {
        return RtpPacketReorderingQueue.calculateSequenceNumberShift(((RtpPacketReorderingQueue.RtpPacketContainer) obj).packet.sequenceNumber, ((RtpPacketReorderingQueue.RtpPacketContainer) obj2).packet.sequenceNumber);
    }
}

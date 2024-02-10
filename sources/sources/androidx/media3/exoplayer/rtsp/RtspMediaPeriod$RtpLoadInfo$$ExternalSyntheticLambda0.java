package androidx.media3.exoplayer.rtsp;

import androidx.media3.exoplayer.rtsp.RtpDataLoadable;
import androidx.media3.exoplayer.rtsp.RtspMediaPeriod;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class RtspMediaPeriod$RtpLoadInfo$$ExternalSyntheticLambda0 implements RtpDataLoadable.EventListener {
    public final /* synthetic */ RtspMediaPeriod.RtpLoadInfo f$0;

    public /* synthetic */ RtspMediaPeriod$RtpLoadInfo$$ExternalSyntheticLambda0(RtspMediaPeriod.RtpLoadInfo rtpLoadInfo) {
        this.f$0 = rtpLoadInfo;
    }

    public final void onTransportReady(String str, RtpDataChannel rtpDataChannel) {
        this.f$0.m142lambda$new$0$androidxmedia3exoplayerrtspRtspMediaPeriod$RtpLoadInfo(str, rtpDataChannel);
    }
}

package androidx.media3.exoplayer.rtsp;

import androidx.media3.exoplayer.rtsp.RtspMessageChannel;
import java.util.List;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class RtspMessageChannel$Sender$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ RtspMessageChannel.Sender f$0;
    public final /* synthetic */ byte[] f$1;
    public final /* synthetic */ List f$2;

    public /* synthetic */ RtspMessageChannel$Sender$$ExternalSyntheticLambda0(RtspMessageChannel.Sender sender, byte[] bArr, List list) {
        this.f$0 = sender;
        this.f$1 = bArr;
        this.f$2 = list;
    }

    public final void run() {
        this.f$0.m143lambda$send$0$androidxmedia3exoplayerrtspRtspMessageChannel$Sender(this.f$1, this.f$2);
    }
}

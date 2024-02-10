package androidx.media3.exoplayer.rtsp;

import androidx.media3.exoplayer.rtsp.RtspClient;
import java.util.List;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class RtspClient$MessageListener$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ RtspClient.MessageListener f$0;
    public final /* synthetic */ List f$1;

    public /* synthetic */ RtspClient$MessageListener$$ExternalSyntheticLambda0(RtspClient.MessageListener messageListener, List list) {
        this.f$0 = messageListener;
        this.f$1 = list;
    }

    public final void run() {
        this.f$0.m141lambda$onRtspMessageReceived$0$androidxmedia3exoplayerrtspRtspClient$MessageListener(this.f$1);
    }
}

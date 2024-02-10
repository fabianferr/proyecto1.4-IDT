package androidx.media3.exoplayer.rtsp;

final class RtspDescribeResponse {
    public final RtspHeaders headers;
    public final SessionDescription sessionDescription;
    public final int status;

    public RtspDescribeResponse(RtspHeaders rtspHeaders, int i, SessionDescription sessionDescription2) {
        this.headers = rtspHeaders;
        this.status = i;
        this.sessionDescription = sessionDescription2;
    }
}

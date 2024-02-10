package com.google.android.exoplayer2.source.rtsp;

import android.net.Uri;
import android.os.Handler;
import android.util.SparseArray;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.source.rtsp.RtspHeaders;
import com.google.android.exoplayer2.source.rtsp.RtspMediaPeriod;
import com.google.android.exoplayer2.source.rtsp.RtspMediaSource;
import com.google.android.exoplayer2.source.rtsp.RtspMessageChannel;
import com.google.android.exoplayer2.source.rtsp.RtspMessageUtil;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.net.SocketFactory;

final class RtspClient implements Closeable {
    private static final long DEFAULT_RTSP_KEEP_ALIVE_INTERVAL_MS = 30000;
    /* access modifiers changed from: private */
    public boolean hasUpdatedTimelineAndTracks;
    /* access modifiers changed from: private */
    public KeepAliveMonitor keepAliveMonitor;
    /* access modifiers changed from: private */
    public RtspMessageChannel messageChannel = new RtspMessageChannel(new MessageListener());
    /* access modifiers changed from: private */
    public final MessageSender messageSender = new MessageSender();
    /* access modifiers changed from: private */
    public final SparseArray<RtspRequest> pendingRequests = new SparseArray<>();
    /* access modifiers changed from: private */
    public long pendingSeekPositionUs = -9223372036854775807L;
    private final ArrayDeque<RtspMediaPeriod.RtpLoadInfo> pendingSetupRtpLoadInfos = new ArrayDeque<>();
    /* access modifiers changed from: private */
    public final PlaybackEventListener playbackEventListener;
    /* access modifiers changed from: private */
    public boolean receivedAuthorizationRequest;
    /* access modifiers changed from: private */
    public final RtspMessageUtil.RtspAuthUserInfo rtspAuthUserInfo;
    /* access modifiers changed from: private */
    public RtspAuthenticationInfo rtspAuthenticationInfo;
    /* access modifiers changed from: private */
    public String sessionId;
    /* access modifiers changed from: private */
    public final SessionInfoListener sessionInfoListener;
    /* access modifiers changed from: private */
    public final Uri uri;
    /* access modifiers changed from: private */
    public final String userAgent;

    public interface PlaybackEventListener {
        void onPlaybackError(RtspMediaSource.RtspPlaybackException rtspPlaybackException);

        void onPlaybackStarted(long j, ImmutableList<RtspTrackTiming> immutableList);

        void onRtspSetupCompleted();
    }

    public interface SessionInfoListener {
        void onSessionTimelineRequestFailed(String str, Throwable th);

        void onSessionTimelineUpdated(RtspSessionTiming rtspSessionTiming, ImmutableList<RtspMediaTrack> immutableList);
    }

    public RtspClient(SessionInfoListener sessionInfoListener2, PlaybackEventListener playbackEventListener2, String str, Uri uri2) {
        this.sessionInfoListener = sessionInfoListener2;
        this.playbackEventListener = playbackEventListener2;
        this.uri = RtspMessageUtil.removeUserInfo(uri2);
        this.rtspAuthUserInfo = RtspMessageUtil.parseUserInfo(uri2);
        this.userAgent = str;
    }

    public void start() throws IOException {
        try {
            this.messageChannel.open(getSocket(this.uri));
            this.messageSender.sendOptionsRequest(this.uri, this.sessionId);
        } catch (IOException e) {
            Util.closeQuietly((Closeable) this.messageChannel);
            throw e;
        }
    }

    public void setupSelectedTracks(List<RtspMediaPeriod.RtpLoadInfo> list) {
        this.pendingSetupRtpLoadInfos.addAll(list);
        continueSetupRtspTrack();
    }

    public void startPlayback(long j) {
        this.messageSender.sendPlayRequest(this.uri, j, (String) Assertions.checkNotNull(this.sessionId));
    }

    public void seekToUs(long j) {
        this.messageSender.sendPauseRequest(this.uri, (String) Assertions.checkNotNull(this.sessionId));
        this.pendingSeekPositionUs = j;
    }

    public void close() throws IOException {
        KeepAliveMonitor keepAliveMonitor2 = this.keepAliveMonitor;
        if (keepAliveMonitor2 != null) {
            keepAliveMonitor2.close();
            this.keepAliveMonitor = null;
            this.messageSender.sendTeardownRequest(this.uri, (String) Assertions.checkNotNull(this.sessionId));
        }
        this.messageChannel.close();
    }

    public void retryWithRtpTcp() {
        try {
            close();
            RtspMessageChannel rtspMessageChannel = new RtspMessageChannel(new MessageListener());
            this.messageChannel = rtspMessageChannel;
            rtspMessageChannel.open(getSocket(this.uri));
            this.sessionId = null;
            this.receivedAuthorizationRequest = false;
            this.rtspAuthenticationInfo = null;
        } catch (IOException e) {
            this.playbackEventListener.onPlaybackError(new RtspMediaSource.RtspPlaybackException((Throwable) e));
        }
    }

    public void registerInterleavedDataChannel(int i, RtspMessageChannel.InterleavedBinaryDataListener interleavedBinaryDataListener) {
        this.messageChannel.registerInterleavedBinaryDataListener(i, interleavedBinaryDataListener);
    }

    /* access modifiers changed from: private */
    public void continueSetupRtspTrack() {
        RtspMediaPeriod.RtpLoadInfo pollFirst = this.pendingSetupRtpLoadInfos.pollFirst();
        if (pollFirst == null) {
            this.playbackEventListener.onRtspSetupCompleted();
        } else {
            this.messageSender.sendSetupRequest(pollFirst.getTrackUri(), pollFirst.getTransport(), this.sessionId);
        }
    }

    private static Socket getSocket(Uri uri2) throws IOException {
        Assertions.checkArgument(uri2.getHost() != null);
        return SocketFactory.getDefault().createSocket((String) Assertions.checkNotNull(uri2.getHost()), uri2.getPort() > 0 ? uri2.getPort() : 554);
    }

    /* access modifiers changed from: private */
    public void dispatchRtspError(Throwable th) {
        RtspMediaSource.RtspPlaybackException rtspPlaybackException;
        if (th instanceof RtspMediaSource.RtspPlaybackException) {
            rtspPlaybackException = (RtspMediaSource.RtspPlaybackException) th;
        } else {
            rtspPlaybackException = new RtspMediaSource.RtspPlaybackException(th);
        }
        if (this.hasUpdatedTimelineAndTracks) {
            this.playbackEventListener.onPlaybackError(rtspPlaybackException);
        } else {
            this.sessionInfoListener.onSessionTimelineRequestFailed(Strings.nullToEmpty(th.getMessage()), th);
        }
    }

    /* access modifiers changed from: private */
    public static boolean serverSupportsDescribe(List<Integer> list) {
        return list.isEmpty() || list.contains(2);
    }

    /* access modifiers changed from: private */
    public static ImmutableList<RtspMediaTrack> buildTrackList(SessionDescription sessionDescription, Uri uri2) {
        ImmutableList.Builder builder = new ImmutableList.Builder();
        for (int i = 0; i < sessionDescription.mediaDescriptionList.size(); i++) {
            MediaDescription mediaDescription = (MediaDescription) sessionDescription.mediaDescriptionList.get(i);
            if (RtpPayloadFormat.isFormatSupported(mediaDescription)) {
                builder.add((Object) new RtspMediaTrack(mediaDescription, uri2));
            }
        }
        return builder.build();
    }

    private final class MessageSender {
        private int cSeq;
        private RtspRequest lastRequest;

        private MessageSender() {
        }

        public void sendOptionsRequest(Uri uri, String str) {
            sendRequest(getRequestWithCommonHeaders(4, str, ImmutableMap.of(), uri));
        }

        public void sendDescribeRequest(Uri uri, String str) {
            sendRequest(getRequestWithCommonHeaders(2, str, ImmutableMap.of(), uri));
        }

        public void sendSetupRequest(Uri uri, String str, String str2) {
            sendRequest(getRequestWithCommonHeaders(10, str2, ImmutableMap.of("Transport", str), uri));
        }

        public void sendPlayRequest(Uri uri, long j, String str) {
            sendRequest(getRequestWithCommonHeaders(6, str, ImmutableMap.of("Range", RtspSessionTiming.getOffsetStartTimeTiming(j)), uri));
        }

        public void sendTeardownRequest(Uri uri, String str) {
            sendRequest(getRequestWithCommonHeaders(12, str, ImmutableMap.of(), uri));
        }

        public void sendPauseRequest(Uri uri, String str) {
            sendRequest(getRequestWithCommonHeaders(5, str, ImmutableMap.of(), uri));
        }

        public void retryLastRequest() {
            Assertions.checkStateNotNull(this.lastRequest);
            ImmutableListMultimap<String, String> asMultiMap = this.lastRequest.headers.asMultiMap();
            HashMap hashMap = new HashMap();
            for (String next : asMultiMap.keySet()) {
                if (!next.equals("CSeq") && !next.equals("User-Agent") && !next.equals("Session") && !next.equals("Authorization")) {
                    hashMap.put(next, (String) Iterables.getLast(asMultiMap.get(next)));
                }
            }
            sendRequest(getRequestWithCommonHeaders(this.lastRequest.method, RtspClient.this.sessionId, hashMap, this.lastRequest.uri));
        }

        private RtspRequest getRequestWithCommonHeaders(int i, String str, Map<String, String> map, Uri uri) {
            RtspHeaders.Builder builder = new RtspHeaders.Builder();
            int i2 = this.cSeq;
            this.cSeq = i2 + 1;
            builder.add("CSeq", String.valueOf(i2));
            builder.add("User-Agent", RtspClient.this.userAgent);
            if (str != null) {
                builder.add("Session", str);
            }
            if (RtspClient.this.rtspAuthenticationInfo != null) {
                Assertions.checkStateNotNull(RtspClient.this.rtspAuthUserInfo);
                try {
                    builder.add("Authorization", RtspClient.this.rtspAuthenticationInfo.getAuthorizationHeaderValue(RtspClient.this.rtspAuthUserInfo, uri, i));
                } catch (ParserException e) {
                    RtspClient.this.dispatchRtspError(new RtspMediaSource.RtspPlaybackException((Throwable) e));
                }
            }
            builder.addAll(map);
            return new RtspRequest(uri, i, builder.build(), "");
        }

        private void sendRequest(RtspRequest rtspRequest) {
            int parseInt = Integer.parseInt((String) Assertions.checkNotNull(rtspRequest.headers.get("CSeq")));
            Assertions.checkState(RtspClient.this.pendingRequests.get(parseInt) == null);
            RtspClient.this.pendingRequests.append(parseInt, rtspRequest);
            RtspClient.this.messageChannel.send(RtspMessageUtil.serializeRequest(rtspRequest));
            this.lastRequest = rtspRequest;
        }
    }

    private final class MessageListener implements RtspMessageChannel.MessageListener {
        private final Handler messageHandler = Util.createHandlerForCurrentLooper();

        public /* synthetic */ void onReceivingFailed(Exception exc) {
            RtspMessageChannel.MessageListener.CC.$default$onReceivingFailed(this, exc);
        }

        public /* synthetic */ void onSendingFailed(List list, Exception exc) {
            RtspMessageChannel.MessageListener.CC.$default$onSendingFailed(this, list, exc);
        }

        public MessageListener() {
        }

        public void onRtspMessageReceived(List<String> list) {
            this.messageHandler.post(new RtspClient$MessageListener$$ExternalSyntheticLambda0(this, list));
        }

        /* access modifiers changed from: private */
        /* renamed from: handleRtspMessage */
        public void m2075lambda$onRtspMessageReceived$0$comgoogleandroidexoplayer2sourcertspRtspClient$MessageListener(List<String> list) {
            RtspSessionTiming rtspSessionTiming;
            ImmutableList<RtspTrackTiming> immutableList;
            RtspResponse parseResponse = RtspMessageUtil.parseResponse(list);
            int parseInt = Integer.parseInt((String) Assertions.checkNotNull(parseResponse.headers.get("CSeq")));
            RtspRequest rtspRequest = (RtspRequest) RtspClient.this.pendingRequests.get(parseInt);
            if (rtspRequest != null) {
                RtspClient.this.pendingRequests.remove(parseInt);
                int i = rtspRequest.method;
                try {
                    int i2 = parseResponse.status;
                    if (i2 != 200) {
                        if (i2 == 401) {
                            if (RtspClient.this.rtspAuthUserInfo != null && !RtspClient.this.receivedAuthorizationRequest) {
                                String str = parseResponse.headers.get("WWW-Authenticate");
                                if (str != null) {
                                    RtspAuthenticationInfo unused = RtspClient.this.rtspAuthenticationInfo = RtspMessageUtil.parseWwwAuthenticateHeader(str);
                                    RtspClient.this.messageSender.retryLastRequest();
                                    boolean unused2 = RtspClient.this.receivedAuthorizationRequest = true;
                                    return;
                                }
                                throw ParserException.createForMalformedManifest("Missing WWW-Authenticate header in a 401 response.", (Throwable) null);
                            }
                        }
                        RtspClient rtspClient = RtspClient.this;
                        String methodString = RtspMessageUtil.toMethodString(i);
                        int i3 = parseResponse.status;
                        StringBuilder sb = new StringBuilder(String.valueOf(methodString).length() + 12);
                        sb.append(methodString);
                        sb.append(" ");
                        sb.append(i3);
                        rtspClient.dispatchRtspError(new RtspMediaSource.RtspPlaybackException(sb.toString()));
                        return;
                    }
                    switch (i) {
                        case 1:
                        case 3:
                        case 7:
                        case 8:
                        case 9:
                        case 11:
                        case 12:
                            return;
                        case 2:
                            onDescribeResponseReceived(new RtspDescribeResponse(parseResponse.status, SessionDescriptionParser.parse(parseResponse.messageBody)));
                            return;
                        case 4:
                            onOptionsResponseReceived(new RtspOptionsResponse(parseResponse.status, RtspMessageUtil.parsePublicHeader(parseResponse.headers.get("Public"))));
                            return;
                        case 5:
                            onPauseResponseReceived();
                            return;
                        case 6:
                            String str2 = parseResponse.headers.get("Range");
                            if (str2 == null) {
                                rtspSessionTiming = RtspSessionTiming.DEFAULT;
                            } else {
                                rtspSessionTiming = RtspSessionTiming.parseTiming(str2);
                            }
                            String str3 = parseResponse.headers.get("RTP-Info");
                            if (str3 == null) {
                                immutableList = ImmutableList.of();
                            } else {
                                immutableList = RtspTrackTiming.parseTrackTiming(str3, RtspClient.this.uri);
                            }
                            onPlayResponseReceived(new RtspPlayResponse(parseResponse.status, rtspSessionTiming, immutableList));
                            return;
                        case 10:
                            String str4 = parseResponse.headers.get("Session");
                            String str5 = parseResponse.headers.get("Transport");
                            if (str4 == null || str5 == null) {
                                throw ParserException.createForMalformedManifest("Missing mandatory session or transport header", (Throwable) null);
                            }
                            onSetupResponseReceived(new RtspSetupResponse(parseResponse.status, RtspMessageUtil.parseSessionHeader(str4), str5));
                            return;
                        default:
                            throw new IllegalStateException();
                    }
                } catch (ParserException e) {
                    RtspClient.this.dispatchRtspError(new RtspMediaSource.RtspPlaybackException((Throwable) e));
                }
            }
        }

        private void onOptionsResponseReceived(RtspOptionsResponse rtspOptionsResponse) {
            if (RtspClient.this.keepAliveMonitor == null) {
                if (RtspClient.serverSupportsDescribe(rtspOptionsResponse.supportedMethods)) {
                    RtspClient.this.messageSender.sendDescribeRequest(RtspClient.this.uri, RtspClient.this.sessionId);
                } else {
                    RtspClient.this.sessionInfoListener.onSessionTimelineRequestFailed("DESCRIBE not supported.", (Throwable) null);
                }
            }
        }

        private void onDescribeResponseReceived(RtspDescribeResponse rtspDescribeResponse) {
            RtspSessionTiming rtspSessionTiming = RtspSessionTiming.DEFAULT;
            String str = rtspDescribeResponse.sessionDescription.attributes.get("range");
            if (str != null) {
                try {
                    rtspSessionTiming = RtspSessionTiming.parseTiming(str);
                } catch (ParserException e) {
                    RtspClient.this.sessionInfoListener.onSessionTimelineRequestFailed("SDP format error.", e);
                    return;
                }
            }
            ImmutableList access$1400 = RtspClient.buildTrackList(rtspDescribeResponse.sessionDescription, RtspClient.this.uri);
            if (access$1400.isEmpty()) {
                RtspClient.this.sessionInfoListener.onSessionTimelineRequestFailed("No playable track.", (Throwable) null);
                return;
            }
            RtspClient.this.sessionInfoListener.onSessionTimelineUpdated(rtspSessionTiming, access$1400);
            boolean unused = RtspClient.this.hasUpdatedTimelineAndTracks = true;
        }

        private void onSetupResponseReceived(RtspSetupResponse rtspSetupResponse) {
            String unused = RtspClient.this.sessionId = rtspSetupResponse.sessionHeader.sessionId;
            RtspClient.this.continueSetupRtspTrack();
        }

        private void onPlayResponseReceived(RtspPlayResponse rtspPlayResponse) {
            if (RtspClient.this.keepAliveMonitor == null) {
                RtspClient rtspClient = RtspClient.this;
                KeepAliveMonitor unused = rtspClient.keepAliveMonitor = new KeepAliveMonitor(30000);
                RtspClient.this.keepAliveMonitor.start();
            }
            RtspClient.this.playbackEventListener.onPlaybackStarted(C.msToUs(rtspPlayResponse.sessionTiming.startTimeMs), rtspPlayResponse.trackTimingList);
            long unused2 = RtspClient.this.pendingSeekPositionUs = -9223372036854775807L;
        }

        private void onPauseResponseReceived() {
            if (RtspClient.this.pendingSeekPositionUs != -9223372036854775807L) {
                RtspClient rtspClient = RtspClient.this;
                rtspClient.startPlayback(C.usToMs(rtspClient.pendingSeekPositionUs));
            }
        }
    }

    private final class KeepAliveMonitor implements Runnable, Closeable {
        private final long intervalMs;
        private boolean isStarted;
        private final Handler keepAliveHandler = Util.createHandlerForCurrentLooper();

        public KeepAliveMonitor(long j) {
            this.intervalMs = j;
        }

        public void start() {
            if (!this.isStarted) {
                this.isStarted = true;
                this.keepAliveHandler.postDelayed(this, this.intervalMs);
            }
        }

        public void run() {
            RtspClient.this.messageSender.sendOptionsRequest(RtspClient.this.uri, RtspClient.this.sessionId);
            this.keepAliveHandler.postDelayed(this, this.intervalMs);
        }

        public void close() {
            this.isStarted = false;
            this.keepAliveHandler.removeCallbacks(this);
        }
    }
}

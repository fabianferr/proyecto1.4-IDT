package com.google.ads.interactivemedia.v3.api;

import com.google.ads.interactivemedia.v3.api.player.VideoStreamPlayer;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public interface StreamDisplayContainer extends BaseDisplayContainer {
    VideoStreamPlayer getVideoStreamPlayer();

    @Deprecated
    void setVideoStreamPlayer(VideoStreamPlayer videoStreamPlayer);
}

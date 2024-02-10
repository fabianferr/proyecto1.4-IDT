package com.iab.omid.library.bytedance2.adsession.media;

import com.appnext.ads.fullscreen.RewardedVideo;

public enum PlayerState {
    MINIMIZED("minimized"),
    COLLAPSED("collapsed"),
    NORMAL(RewardedVideo.VIDEO_MODE_NORMAL),
    EXPANDED("expanded"),
    FULLSCREEN("fullscreen");
    
    private final String playerState;

    private PlayerState(String str) {
        this.playerState = str;
    }

    public String toString() {
        return this.playerState;
    }
}
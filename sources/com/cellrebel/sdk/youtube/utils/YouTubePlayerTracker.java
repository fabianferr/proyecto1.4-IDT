package com.cellrebel.sdk.youtube.utils;

import com.cellrebel.sdk.youtube.player.PlayerConstants;
import com.cellrebel.sdk.youtube.player.listeners.AbstractYouTubePlayerListener;

public class YouTubePlayerTracker extends AbstractYouTubePlayerListener {
    private PlayerConstants.PlayerState a = PlayerConstants.PlayerState.UNKNOWN;
    private float b;
    private float c;
    private String d;

    public void a(float f) {
        this.c = f;
    }

    public void a(PlayerConstants.PlayerState playerState) {
        this.a = playerState;
    }

    public void a(String str) {
        this.d = str;
    }

    public void b(float f) {
        this.b = f;
    }
}

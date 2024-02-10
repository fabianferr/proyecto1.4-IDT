package com.cellrebel.sdk.youtube.player.listeners;

import com.cellrebel.sdk.youtube.player.PlayerConstants;

public interface YouTubePlayerListener {
    void a();

    void a(float f);

    void a(PlayerConstants.PlaybackQuality playbackQuality);

    void a(PlayerConstants.PlaybackRate playbackRate);

    void a(PlayerConstants.PlayerError playerError);

    void a(PlayerConstants.PlayerState playerState);

    void a(String str);

    void b(float f);

    void c();

    void c(float f);
}

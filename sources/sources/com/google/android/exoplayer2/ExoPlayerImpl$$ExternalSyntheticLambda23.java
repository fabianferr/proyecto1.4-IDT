package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.util.ListenerSet;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ExoPlayerImpl$$ExternalSyntheticLambda23 implements ListenerSet.Event {
    public final /* synthetic */ PlaybackInfo f$0;

    public /* synthetic */ ExoPlayerImpl$$ExternalSyntheticLambda23(PlaybackInfo playbackInfo) {
        this.f$0 = playbackInfo;
    }

    public final void invoke(Object obj) {
        ((Player.EventListener) obj).onPlaybackParametersChanged(this.f$0.playbackParameters);
    }
}
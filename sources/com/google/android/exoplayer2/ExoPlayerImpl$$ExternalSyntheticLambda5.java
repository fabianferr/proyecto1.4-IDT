package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.util.ListenerSet;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ExoPlayerImpl$$ExternalSyntheticLambda5 implements ListenerSet.Event {
    public final /* synthetic */ PlaybackInfo f$0;
    public final /* synthetic */ TrackSelectionArray f$1;

    public /* synthetic */ ExoPlayerImpl$$ExternalSyntheticLambda5(PlaybackInfo playbackInfo, TrackSelectionArray trackSelectionArray) {
        this.f$0 = playbackInfo;
        this.f$1 = trackSelectionArray;
    }

    public final void invoke(Object obj) {
        ((Player.EventListener) obj).onTracksChanged(this.f$0.trackGroups, this.f$1);
    }
}

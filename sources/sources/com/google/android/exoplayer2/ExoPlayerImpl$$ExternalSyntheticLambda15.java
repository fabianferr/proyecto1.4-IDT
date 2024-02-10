package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.util.FlagSet;
import com.google.android.exoplayer2.util.ListenerSet;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ExoPlayerImpl$$ExternalSyntheticLambda15 implements ListenerSet.IterationFinishedEvent {
    public final /* synthetic */ Player f$0;

    public /* synthetic */ ExoPlayerImpl$$ExternalSyntheticLambda15(Player player) {
        this.f$0 = player;
    }

    public final void invoke(Object obj, FlagSet flagSet) {
        ((Player.EventListener) obj).onEvents(this.f$0, new Player.Events(flagSet));
    }
}

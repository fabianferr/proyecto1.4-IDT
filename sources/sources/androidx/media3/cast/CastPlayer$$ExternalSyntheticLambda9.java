package androidx.media3.cast;

import androidx.media3.common.Player;
import androidx.media3.common.util.ListenerSet;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class CastPlayer$$ExternalSyntheticLambda9 implements ListenerSet.Event {
    public final /* synthetic */ Player.PositionInfo f$0;
    public final /* synthetic */ Player.PositionInfo f$1;

    public /* synthetic */ CastPlayer$$ExternalSyntheticLambda9(Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2) {
        this.f$0 = positionInfo;
        this.f$1 = positionInfo2;
    }

    public final void invoke(Object obj) {
        CastPlayer.lambda$updateTimelineAndNotifyIfChanged$9(this.f$0, this.f$1, (Player.Listener) obj);
    }
}

package androidx.media3.common;

import android.os.Bundle;
import androidx.media3.common.Bundleable;
import androidx.media3.common.Tracks;
import androidx.media3.common.util.Assertions;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class Tracks$Group$$ExternalSyntheticLambda0 implements Bundleable.Creator {
    public final Bundleable fromBundle(Bundle bundle) {
        return TrackGroup.CREATOR.fromBundle((Bundle) Assertions.checkNotNull(bundle.getBundle(Tracks.Group.FIELD_TRACK_GROUP)));
    }
}

package androidx.media3.exoplayer.trackselection;

import androidx.media3.exoplayer.trackselection.DefaultTrackSelector;
import java.util.Comparator;
import java.util.List;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DefaultTrackSelector$$ExternalSyntheticLambda4 implements Comparator {
    public final int compare(Object obj, Object obj2) {
        return DefaultTrackSelector.VideoTrackInfo.compareSelections((List) obj, (List) obj2);
    }
}
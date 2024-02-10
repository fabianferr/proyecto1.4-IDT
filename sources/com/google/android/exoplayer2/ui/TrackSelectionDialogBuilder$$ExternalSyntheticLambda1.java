package com.google.android.exoplayer2.ui;

import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.ui.TrackSelectionDialogBuilder;
import java.util.List;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class TrackSelectionDialogBuilder$$ExternalSyntheticLambda1 implements TrackSelectionDialogBuilder.DialogCallback {
    public final /* synthetic */ DefaultTrackSelector f$0;
    public final /* synthetic */ DefaultTrackSelector.Parameters f$1;
    public final /* synthetic */ int f$2;
    public final /* synthetic */ TrackGroupArray f$3;

    public /* synthetic */ TrackSelectionDialogBuilder$$ExternalSyntheticLambda1(DefaultTrackSelector defaultTrackSelector, DefaultTrackSelector.Parameters parameters, int i, TrackGroupArray trackGroupArray) {
        this.f$0 = defaultTrackSelector;
        this.f$1 = parameters;
        this.f$2 = i;
        this.f$3 = trackGroupArray;
    }

    public final void onTracksSelected(boolean z, List list) {
        TrackSelectionDialogBuilder.lambda$new$0(this.f$0, this.f$1, this.f$2, this.f$3, z, list);
    }
}

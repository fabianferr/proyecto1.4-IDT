package androidx.media3.exoplayer.video;

import android.view.Display;
import androidx.media3.exoplayer.video.VideoFrameReleaseHelper;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class VideoFrameReleaseHelper$$ExternalSyntheticLambda0 implements VideoFrameReleaseHelper.DisplayHelper.Listener {
    public final /* synthetic */ VideoFrameReleaseHelper f$0;

    public /* synthetic */ VideoFrameReleaseHelper$$ExternalSyntheticLambda0(VideoFrameReleaseHelper videoFrameReleaseHelper) {
        this.f$0 = videoFrameReleaseHelper;
    }

    public final void onDefaultDisplayChanged(Display display) {
        this.f$0.updateDefaultDisplayRefreshRateParams(display);
    }
}

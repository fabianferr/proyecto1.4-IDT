package com.cellrebel.sdk.youtube.player;

import androidx.lifecycle.GeneratedAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MethodCallsLogger;

public class YouTubePlayerView_LifecycleAdapter implements GeneratedAdapter {
    final YouTubePlayerView a;

    YouTubePlayerView_LifecycleAdapter(YouTubePlayerView youTubePlayerView) {
        this.a = youTubePlayerView;
    }

    public void callMethods(LifecycleOwner lifecycleOwner, Lifecycle.Event event, boolean z, MethodCallsLogger methodCallsLogger) {
        boolean z2 = methodCallsLogger != null;
        if (!z) {
            if (event == Lifecycle.Event.ON_DESTROY) {
                if (!z2 || methodCallsLogger.approveCall("release", 1)) {
                    this.a.release();
                }
            } else if (event != Lifecycle.Event.ON_STOP) {
            } else {
                if (!z2 || methodCallsLogger.approveCall("onStop", 1)) {
                    this.a.onStop();
                }
            }
        }
    }
}

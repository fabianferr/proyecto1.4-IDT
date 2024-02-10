package com.mbridge.msdk.playercommon;

import com.mbridge.msdk.foundation.tools.aa;

public class DefaultVideoPlayerStatusListener implements VideoPlayerStatusListener {
    protected static final String TAG = "DefaultVideoPlayerStatusListener";

    public void onPlayStarted(int i) {
        aa.a(TAG, "onPlayStarted:" + i);
    }

    public void onPlayCompleted() {
        aa.a(TAG, "onPlayCompleted");
    }

    public void onPlayError(String str) {
        aa.a(TAG, "onPlayError:" + str);
    }

    public void onPlayProgress(int i, int i2) {
        aa.a(TAG, "onPlayProgress:" + i + ",allDuration:" + i2);
    }

    public void onBufferingStart(String str) {
        aa.a(TAG, "OnBufferingStart:" + str);
    }

    public void onBufferingEnd() {
        aa.a(TAG, "OnBufferingEnd");
    }

    public void onPlaySetDataSourceError(String str) {
        aa.a(TAG, "onPlaySetDataSourceError:" + str);
    }

    public void onPlayProgressMS(int i, int i2) {
        aa.a(TAG, "onPlayProgressMS:");
    }
}

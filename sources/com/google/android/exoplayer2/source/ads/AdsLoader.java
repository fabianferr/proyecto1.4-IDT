package com.google.android.exoplayer2.source.ads;

import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.source.ads.AdsMediaSource;
import com.google.android.exoplayer2.ui.AdViewProvider;
import com.google.android.exoplayer2.upstream.DataSpec;
import java.io.IOException;

public interface AdsLoader {

    public interface EventListener {

        @SynthesizedClassV2(kind = 8, versionHash = "7a5b85d3ee2e0991ca3502602e9389a98f55c0576b887125894a7ec03823f8d3")
        /* renamed from: com.google.android.exoplayer2.source.ads.AdsLoader$EventListener$-CC  reason: invalid class name */
        public final /* synthetic */ class CC {
            public static void $default$onAdClicked(EventListener _this) {
            }

            public static void $default$onAdLoadError(EventListener _this, AdsMediaSource.AdLoadException adLoadException, DataSpec dataSpec) {
            }

            public static void $default$onAdPlaybackState(EventListener _this, AdPlaybackState adPlaybackState) {
            }

            public static void $default$onAdTapped(EventListener _this) {
            }
        }

        void onAdClicked();

        void onAdLoadError(AdsMediaSource.AdLoadException adLoadException, DataSpec dataSpec);

        void onAdPlaybackState(AdPlaybackState adPlaybackState);

        void onAdTapped();
    }

    void handlePrepareComplete(AdsMediaSource adsMediaSource, int i, int i2);

    void handlePrepareError(AdsMediaSource adsMediaSource, int i, int i2, IOException iOException);

    void release();

    void setPlayer(Player player);

    void setSupportedContentTypes(int... iArr);

    void start(AdsMediaSource adsMediaSource, DataSpec dataSpec, Object obj, AdViewProvider adViewProvider, EventListener eventListener);

    void stop(AdsMediaSource adsMediaSource, EventListener eventListener);
}

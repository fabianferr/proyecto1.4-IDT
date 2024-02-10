package com.bytedance.sdk.openadsdk.core.g;

import android.view.View;
import com.iab.omid.library.bytedance2.adsession.AdEvents;
import com.iab.omid.library.bytedance2.adsession.AdSession;
import com.iab.omid.library.bytedance2.adsession.media.InteractionType;
import com.iab.omid.library.bytedance2.adsession.media.MediaEvents;
import com.iab.omid.library.bytedance2.adsession.media.PlayerState;
import com.iab.omid.library.bytedance2.adsession.media.Position;
import com.iab.omid.library.bytedance2.adsession.media.VastProperties;

/* compiled from: ViewabilityTrackerForVideo */
public class i extends g {
    private final MediaEvents e;
    private boolean f;

    public i(AdSession adSession, AdEvents adEvents, View view, MediaEvents mediaEvents) {
        super(adSession, adEvents, view);
        this.e = mediaEvents;
    }

    public void a(boolean z, float f2) {
        if (z) {
            this.d = VastProperties.createVastPropertiesForSkippableMedia(f2, true, Position.STANDALONE);
        } else {
            this.d = VastProperties.createVastPropertiesForNonSkippableMedia(true, Position.STANDALONE);
        }
        a(2);
    }

    public void a(float f2, boolean z) {
        if (a()) {
            this.e.start(f2, z ? 0.0f : 1.0f);
        }
    }

    public void a(boolean z) {
        this.f = z;
        b(12);
    }

    public void b(int i) {
        if (a()) {
            switch (i) {
                case 0:
                    this.e.pause();
                    return;
                case 1:
                    this.e.resume();
                    return;
                case 2:
                case 14:
                    this.e.skipped();
                    return;
                case 4:
                    this.e.bufferStart();
                    return;
                case 5:
                    this.e.bufferFinish();
                    return;
                case 6:
                    this.e.firstQuartile();
                    return;
                case 7:
                    this.e.midpoint();
                    return;
                case 8:
                    this.e.thirdQuartile();
                    return;
                case 9:
                    this.e.complete();
                    return;
                case 10:
                    this.e.playerStateChange(PlayerState.FULLSCREEN);
                    return;
                case 11:
                    this.e.playerStateChange(PlayerState.NORMAL);
                    return;
                case 12:
                    this.e.volumeChange(this.f ? 0.0f : 1.0f);
                    return;
                case 13:
                    this.e.adUserInteraction(InteractionType.CLICK);
                    return;
                default:
                    return;
            }
        }
    }
}

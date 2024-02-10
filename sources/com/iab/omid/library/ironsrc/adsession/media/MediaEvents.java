package com.iab.omid.library.ironsrc.adsession.media;

import com.facebook.login.LoginLogger;
import com.iab.omid.library.ironsrc.adsession.AdSession;
import com.iab.omid.library.ironsrc.adsession.a;
import com.iab.omid.library.ironsrc.internal.h;
import com.iab.omid.library.ironsrc.utils.c;
import com.iab.omid.library.ironsrc.utils.g;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import org.json.JSONObject;

public final class MediaEvents {
    private final a adSession;

    private MediaEvents(a aVar) {
        this.adSession = aVar;
    }

    private void confirmValidDuration(float f) {
        if (f <= 0.0f) {
            throw new IllegalArgumentException("Invalid Media duration");
        }
    }

    private void confirmValidVolume(float f) {
        if (f < 0.0f || f > 1.0f) {
            throw new IllegalArgumentException("Invalid Media volume");
        }
    }

    public static MediaEvents createMediaEvents(AdSession adSession2) {
        a aVar = (a) adSession2;
        g.a((Object) adSession2, "AdSession is null");
        g.f(aVar);
        g.c(aVar);
        g.b(aVar);
        g.h(aVar);
        MediaEvents mediaEvents = new MediaEvents(aVar);
        aVar.getAdSessionStatePublisher().a(mediaEvents);
        return mediaEvents;
    }

    public final void adUserInteraction(InteractionType interactionType) {
        g.a((Object) interactionType, "InteractionType is null");
        g.a(this.adSession);
        JSONObject jSONObject = new JSONObject();
        c.a(jSONObject, "interactionType", interactionType);
        this.adSession.getAdSessionStatePublisher().a("adUserInteraction", jSONObject);
    }

    public final void bufferFinish() {
        g.a(this.adSession);
        this.adSession.getAdSessionStatePublisher().a("bufferFinish");
    }

    public final void bufferStart() {
        g.a(this.adSession);
        this.adSession.getAdSessionStatePublisher().a("bufferStart");
    }

    public final void complete() {
        g.a(this.adSession);
        this.adSession.getAdSessionStatePublisher().a(CampaignEx.JSON_NATIVE_VIDEO_COMPLETE);
    }

    public final void firstQuartile() {
        g.a(this.adSession);
        this.adSession.getAdSessionStatePublisher().a("firstQuartile");
    }

    public final void midpoint() {
        g.a(this.adSession);
        this.adSession.getAdSessionStatePublisher().a(CampaignEx.JSON_NATIVE_VIDEO_MIDPOINT);
    }

    public final void pause() {
        g.a(this.adSession);
        this.adSession.getAdSessionStatePublisher().a(CampaignEx.JSON_NATIVE_VIDEO_PAUSE);
    }

    public final void playerStateChange(PlayerState playerState) {
        g.a((Object) playerState, "PlayerState is null");
        g.a(this.adSession);
        JSONObject jSONObject = new JSONObject();
        c.a(jSONObject, "state", playerState);
        this.adSession.getAdSessionStatePublisher().a("playerStateChange", jSONObject);
    }

    public final void resume() {
        g.a(this.adSession);
        this.adSession.getAdSessionStatePublisher().a(CampaignEx.JSON_NATIVE_VIDEO_RESUME);
    }

    public final void skipped() {
        g.a(this.adSession);
        this.adSession.getAdSessionStatePublisher().a(LoginLogger.EVENT_PARAM_METHOD_RESULT_SKIPPED);
    }

    public final void start(float f, float f2) {
        confirmValidDuration(f);
        confirmValidVolume(f2);
        g.a(this.adSession);
        JSONObject jSONObject = new JSONObject();
        c.a(jSONObject, "duration", Float.valueOf(f));
        c.a(jSONObject, "mediaPlayerVolume", Float.valueOf(f2));
        c.a(jSONObject, "deviceVolume", Float.valueOf(h.c().b()));
        this.adSession.getAdSessionStatePublisher().a("start", jSONObject);
    }

    public final void thirdQuartile() {
        g.a(this.adSession);
        this.adSession.getAdSessionStatePublisher().a("thirdQuartile");
    }

    public final void volumeChange(float f) {
        confirmValidVolume(f);
        g.a(this.adSession);
        JSONObject jSONObject = new JSONObject();
        c.a(jSONObject, "mediaPlayerVolume", Float.valueOf(f));
        c.a(jSONObject, "deviceVolume", Float.valueOf(h.c().b()));
        this.adSession.getAdSessionStatePublisher().a("volumeChange", jSONObject);
    }
}

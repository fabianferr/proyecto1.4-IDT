package com.iab.omid.library.applovin.adsession.media;

import com.vungle.ads.internal.model.AdPayload;

public enum Position {
    PREROLL("preroll"),
    MIDROLL("midroll"),
    POSTROLL(AdPayload.KEY_POSTROLL),
    STANDALONE("standalone");
    
    private final String position;

    private Position(String str) {
        this.position = str;
    }

    public String toString() {
        return this.position;
    }
}
package com.iab.omid.library.startio.adsession.media;

import com.mbridge.msdk.foundation.entity.CampaignEx;

/* compiled from: Sta */
public enum InteractionType {
    CLICK(CampaignEx.JSON_NATIVE_VIDEO_CLICK);
    
    public String interactionType;

    /* access modifiers changed from: public */
    InteractionType(String str) {
        this.interactionType = str;
    }

    public String toString() {
        return this.interactionType;
    }
}

package com.startapp.simple.bloomfilter.version;

import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.mbridge.msdk.foundation.entity.CampaignEx;

/* compiled from: Sta */
public enum BloomVersion {
    ZERO("0", 1, 720),
    THREE("3.0", 1, 720) {
    },
    FOUR("4", 3, IronSourceConstants.BN_AUCTION_REQUEST),
    FIVE(CampaignEx.CLICKMODE_ON, 3, 1000000);
    
    private final int numberOfHashes;
    private final int sizeOfBucket;
    private final String version;

    public int a() {
        return this.numberOfHashes;
    }

    public int b() {
        return this.sizeOfBucket;
    }

    public String c() {
        return this.version;
    }

    /* access modifiers changed from: public */
    BloomVersion(String str, int i, int i2) {
        this.version = str;
        this.numberOfHashes = i;
        this.sizeOfBucket = i2;
    }
}

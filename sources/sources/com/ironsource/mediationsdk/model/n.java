package com.ironsource.mediationsdk.model;

import androidx.media3.exoplayer.upstream.CmcdHeadersFactory;

public enum n {
    PER_DAY("d"),
    PER_HOUR(CmcdHeadersFactory.STREAMING_FORMAT_HLS);
    
    public String c;

    private n(String str) {
        this.c = str;
    }

    public final String toString() {
        return this.c;
    }
}

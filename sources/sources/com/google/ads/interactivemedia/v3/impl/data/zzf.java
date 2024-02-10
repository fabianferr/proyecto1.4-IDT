package com.google.ads.interactivemedia.v3.impl.data;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzf implements zza {
    private String appState;
    private String eventId;
    private long nativeTime;
    private zzau nativeViewBounds;
    private boolean nativeViewHidden;
    private zzau nativeViewVisibleBounds;
    private double nativeVolume;
    private String queryId;
    private byte set$0;

    zzf() {
    }

    public zza appState(String str) {
        this.appState = str;
        return this;
    }

    public zzb build() {
        String str;
        String str2;
        String str3;
        zzau zzau;
        zzau zzau2;
        if (this.set$0 == 7 && (str = this.queryId) != null && (str2 = this.eventId) != null && (str3 = this.appState) != null && (zzau = this.nativeViewBounds) != null && (zzau2 = this.nativeViewVisibleBounds) != null) {
            return new zzh(str, str2, str3, this.nativeTime, this.nativeVolume, this.nativeViewHidden, zzau, zzau2);
        }
        StringBuilder sb = new StringBuilder();
        if (this.queryId == null) {
            sb.append(" queryId");
        }
        if (this.eventId == null) {
            sb.append(" eventId");
        }
        if (this.appState == null) {
            sb.append(" appState");
        }
        if ((this.set$0 & 1) == 0) {
            sb.append(" nativeTime");
        }
        if ((this.set$0 & 2) == 0) {
            sb.append(" nativeVolume");
        }
        if ((this.set$0 & 4) == 0) {
            sb.append(" nativeViewHidden");
        }
        if (this.nativeViewBounds == null) {
            sb.append(" nativeViewBounds");
        }
        if (this.nativeViewVisibleBounds == null) {
            sb.append(" nativeViewVisibleBounds");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }

    public zza eventId(String str) {
        if (str != null) {
            this.eventId = str;
            return this;
        }
        throw new NullPointerException("Null eventId");
    }

    public zza nativeTime(long j) {
        this.nativeTime = j;
        this.set$0 = (byte) (this.set$0 | 1);
        return this;
    }

    public zza nativeViewBounds(zzau zzau) {
        this.nativeViewBounds = zzau;
        return this;
    }

    public zza nativeViewHidden(boolean z) {
        this.nativeViewHidden = z;
        this.set$0 = (byte) (this.set$0 | 4);
        return this;
    }

    public zza nativeViewVisibleBounds(zzau zzau) {
        this.nativeViewVisibleBounds = zzau;
        return this;
    }

    public zza nativeVolume(double d) {
        this.nativeVolume = d;
        this.set$0 = (byte) (this.set$0 | 2);
        return this;
    }

    public zza queryId(String str) {
        if (str != null) {
            this.queryId = str;
            return this;
        }
        throw new NullPointerException("Null queryId");
    }
}

package com.google.ads.interactivemedia.v3.impl.data;

import com.google.ads.interactivemedia.v3.api.FriendlyObstructionPurpose;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzag extends zzbl {
    private boolean attached;
    private zzau bounds;
    private String detailedReason;
    private boolean hidden;
    private FriendlyObstructionPurpose purpose;
    private byte set$0;
    private String type;

    zzag() {
    }

    public zzbl attached(boolean z) {
        this.attached = z;
        this.set$0 = (byte) (this.set$0 | 1);
        return this;
    }

    public zzbl bounds(zzau zzau) {
        this.bounds = zzau;
        return this;
    }

    public zzbm build() {
        zzau zzau;
        FriendlyObstructionPurpose friendlyObstructionPurpose;
        String str;
        if (this.set$0 == 3 && (zzau = this.bounds) != null && (friendlyObstructionPurpose = this.purpose) != null && (str = this.type) != null) {
            return new zzai(this.attached, zzau, this.detailedReason, this.hidden, friendlyObstructionPurpose, str);
        }
        StringBuilder sb = new StringBuilder();
        if ((this.set$0 & 1) == 0) {
            sb.append(" attached");
        }
        if (this.bounds == null) {
            sb.append(" bounds");
        }
        if ((this.set$0 & 2) == 0) {
            sb.append(" hidden");
        }
        if (this.purpose == null) {
            sb.append(" purpose");
        }
        if (this.type == null) {
            sb.append(" type");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }

    public zzbl detailedReason(String str) {
        this.detailedReason = str;
        return this;
    }

    public zzbl hidden(boolean z) {
        this.hidden = z;
        this.set$0 = (byte) (this.set$0 | 2);
        return this;
    }

    public zzbl purpose(FriendlyObstructionPurpose friendlyObstructionPurpose) {
        if (friendlyObstructionPurpose != null) {
            this.purpose = friendlyObstructionPurpose;
            return this;
        }
        throw new NullPointerException("Null purpose");
    }

    public zzbl type(String str) {
        if (str != null) {
            this.type = str;
            return this;
        }
        throw new NullPointerException("Null type");
    }
}

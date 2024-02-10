package com.m2catalyst.m2sdk.features.badsignals;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/m2catalyst/m2sdk/features/badsignals/BadSignalTypeDefinition;", "", "type", "", "threshold", "(Ljava/lang/String;III)V", "getThreshold", "()I", "getType", "TWO_G", "THREE_G", "FOUR_G", "FIVE_G", "UNKNOWN", "m2sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: BadSignalTypeDefinition.kt */
public enum BadSignalTypeDefinition {
    TWO_G(2, -107),
    THREE_G(3, -107),
    FOUR_G(4, -112),
    FIVE_G(5, -112),
    UNKNOWN(-1, -112);
    
    private final int threshold;
    private final int type;

    private BadSignalTypeDefinition(int i, int i2) {
        this.type = i;
        this.threshold = i2;
    }

    public final int getThreshold() {
        return this.threshold;
    }

    public final int getType() {
        return this.type;
    }
}

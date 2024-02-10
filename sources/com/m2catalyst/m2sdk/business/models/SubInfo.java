package com.m2catalyst.m2sdk.business.models;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n¨\u0006\r"}, d2 = {"Lcom/m2catalyst/m2sdk/business/models/SubInfo;", "", "()V", "id", "", "simSlot", "(II)V", "getId", "()I", "setId", "(I)V", "getSimSlot", "setSimSlot", "m2sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: SubInfo.kt */
public final class SubInfo {
    private int id;
    private int simSlot;

    public SubInfo(int i, int i2) {
        this.id = i;
        this.simSlot = i2;
    }

    public final int getId() {
        return this.id;
    }

    public final int getSimSlot() {
        return this.simSlot;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final void setSimSlot(int i) {
        this.simSlot = i;
    }

    public SubInfo() {
        this(Integer.MAX_VALUE, Integer.MAX_VALUE);
    }
}

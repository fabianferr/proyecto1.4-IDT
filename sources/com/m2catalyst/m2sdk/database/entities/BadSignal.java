package com.m2catalyst.m2sdk.database.entities;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eR\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001a\u0010\u0015\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\u001a\u0010\u0018\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000e¨\u0006\u001f"}, d2 = {"Lcom/m2catalyst/m2sdk/database/entities/BadSignal;", "", "()V", "date", "", "getDate", "()Ljava/lang/String;", "setDate", "(Ljava/lang/String;)V", "fiveCount", "", "getFiveCount", "()I", "setFiveCount", "(I)V", "fourCount", "getFourCount", "setFourCount", "noNetworkCount", "getNoNetworkCount", "setNoNetworkCount", "threeCount", "getThreeCount", "setThreeCount", "twoCount", "getTwoCount", "setTwoCount", "updateValues", "", "values", "", "m2sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: BadSignal.kt */
public final class BadSignal {
    private String date = "";
    private int fiveCount;
    private int fourCount;
    private int noNetworkCount;
    private int threeCount;
    private int twoCount;

    public final String getDate() {
        return this.date;
    }

    public final int getFiveCount() {
        return this.fiveCount;
    }

    public final int getFourCount() {
        return this.fourCount;
    }

    public final int getNoNetworkCount() {
        return this.noNetworkCount;
    }

    public final int getThreeCount() {
        return this.threeCount;
    }

    public final int getTwoCount() {
        return this.twoCount;
    }

    public final void setDate(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.date = str;
    }

    public final void setFiveCount(int i) {
        this.fiveCount = i;
    }

    public final void setFourCount(int i) {
        this.fourCount = i;
    }

    public final void setNoNetworkCount(int i) {
        this.noNetworkCount = i;
    }

    public final void setThreeCount(int i) {
        this.threeCount = i;
    }

    public final void setTwoCount(int i) {
        this.twoCount = i;
    }

    public final void updateValues(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "values");
        this.twoCount += iArr[0];
        this.threeCount += iArr[1];
        this.fourCount += iArr[2];
        this.fiveCount += iArr[3];
        this.noNetworkCount += iArr[4];
    }
}

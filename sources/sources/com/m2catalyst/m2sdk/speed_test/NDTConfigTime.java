package com.m2catalyst.m2sdk.speed_test;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0011\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\t\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u0004HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/m2catalyst/m2sdk/speed_test/NDTConfigTime;", "", "days", "", "", "(Ljava/util/List;)V", "getDays", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "m2sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: SpeedTestNDTApiClient.kt */
public final class NDTConfigTime {
    private final List<Integer> days;

    public NDTConfigTime(List<Integer> list) {
        this.days = list;
    }

    public static /* synthetic */ NDTConfigTime copy$default(NDTConfigTime nDTConfigTime, List<Integer> list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = nDTConfigTime.days;
        }
        return nDTConfigTime.copy(list);
    }

    public final List<Integer> component1() {
        return this.days;
    }

    public final NDTConfigTime copy(List<Integer> list) {
        return new NDTConfigTime(list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof NDTConfigTime) && Intrinsics.areEqual((Object) this.days, (Object) ((NDTConfigTime) obj).days);
    }

    public final List<Integer> getDays() {
        return this.days;
    }

    public int hashCode() {
        List<Integer> list = this.days;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    public String toString() {
        List<Integer> list = this.days;
        return "NDTConfigTime(days=" + list + ")";
    }
}

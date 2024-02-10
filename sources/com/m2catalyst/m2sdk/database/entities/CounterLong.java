package com.m2catalyst.m2sdk.database.entities;

import kotlin.Metadata;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J1\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\bHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006!"}, d2 = {"Lcom/m2catalyst/m2sdk/database/entities/CounterLong;", "", "counterId", "", "counterValue", "", "date", "transmitted", "", "(Ljava/lang/String;JLjava/lang/String;I)V", "getCounterId", "()Ljava/lang/String;", "getCounterValue", "()J", "setCounterValue", "(J)V", "getDate", "setDate", "(Ljava/lang/String;)V", "getTransmitted", "()I", "setTransmitted", "(I)V", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "m2sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: CounterLong.kt */
public final class CounterLong {
    private final String counterId;
    private long counterValue;
    private String date;
    private int transmitted;

    public CounterLong(String str, long j, String str2, int i) {
        Intrinsics.checkNotNullParameter(str, "counterId");
        Intrinsics.checkNotNullParameter(str2, "date");
        this.counterId = str;
        this.counterValue = j;
        this.date = str2;
        this.transmitted = i;
    }

    public static /* synthetic */ CounterLong copy$default(CounterLong counterLong, String str, long j, String str2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = counterLong.counterId;
        }
        if ((i2 & 2) != 0) {
            j = counterLong.counterValue;
        }
        long j2 = j;
        if ((i2 & 4) != 0) {
            str2 = counterLong.date;
        }
        String str3 = str2;
        if ((i2 & 8) != 0) {
            i = counterLong.transmitted;
        }
        return counterLong.copy(str, j2, str3, i);
    }

    public final String component1() {
        return this.counterId;
    }

    public final long component2() {
        return this.counterValue;
    }

    public final String component3() {
        return this.date;
    }

    public final int component4() {
        return this.transmitted;
    }

    public final CounterLong copy(String str, long j, String str2, int i) {
        Intrinsics.checkNotNullParameter(str, "counterId");
        Intrinsics.checkNotNullParameter(str2, "date");
        return new CounterLong(str, j, str2, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CounterLong)) {
            return false;
        }
        CounterLong counterLong = (CounterLong) obj;
        return Intrinsics.areEqual((Object) this.counterId, (Object) counterLong.counterId) && this.counterValue == counterLong.counterValue && Intrinsics.areEqual((Object) this.date, (Object) counterLong.date) && this.transmitted == counterLong.transmitted;
    }

    public final String getCounterId() {
        return this.counterId;
    }

    public final long getCounterValue() {
        return this.counterValue;
    }

    public final String getDate() {
        return this.date;
    }

    public final int getTransmitted() {
        return this.transmitted;
    }

    public int hashCode() {
        int m = UByte$$ExternalSyntheticBackport0.m(this.counterValue);
        int hashCode = this.date.hashCode();
        return this.transmitted + ((hashCode + ((m + (this.counterId.hashCode() * 31)) * 31)) * 31);
    }

    public final void setCounterValue(long j) {
        this.counterValue = j;
    }

    public final void setDate(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.date = str;
    }

    public final void setTransmitted(int i) {
        this.transmitted = i;
    }

    public String toString() {
        String str = this.counterId;
        long j = this.counterValue;
        String str2 = this.date;
        int i = this.transmitted;
        return "CounterLong(counterId=" + str + ", counterValue=" + j + ", date=" + str2 + ", transmitted=" + i + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CounterLong(String str, long j, String str2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i2 & 2) != 0 ? 0 : j, str2, (i2 & 8) != 0 ? 0 : i);
    }
}

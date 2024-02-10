package com.m2catalyst.m2sdk.database.entities;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J1\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0007\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\f\"\u0004\b\u0013\u0010\u000e¨\u0006\u001e"}, d2 = {"Lcom/m2catalyst/m2sdk/database/entities/CounterInt;", "", "counterId", "", "counterValue", "", "date", "transmitted", "(Ljava/lang/String;ILjava/lang/String;I)V", "getCounterId", "()Ljava/lang/String;", "getCounterValue", "()I", "setCounterValue", "(I)V", "getDate", "setDate", "(Ljava/lang/String;)V", "getTransmitted", "setTransmitted", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "m2sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: CounterInt.kt */
public final class CounterInt {
    private final String counterId;
    private int counterValue;
    private String date;
    private int transmitted;

    public CounterInt(String str, int i, String str2, int i2) {
        Intrinsics.checkNotNullParameter(str, "counterId");
        Intrinsics.checkNotNullParameter(str2, "date");
        this.counterId = str;
        this.counterValue = i;
        this.date = str2;
        this.transmitted = i2;
    }

    public static /* synthetic */ CounterInt copy$default(CounterInt counterInt, String str, int i, String str2, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = counterInt.counterId;
        }
        if ((i3 & 2) != 0) {
            i = counterInt.counterValue;
        }
        if ((i3 & 4) != 0) {
            str2 = counterInt.date;
        }
        if ((i3 & 8) != 0) {
            i2 = counterInt.transmitted;
        }
        return counterInt.copy(str, i, str2, i2);
    }

    public final String component1() {
        return this.counterId;
    }

    public final int component2() {
        return this.counterValue;
    }

    public final String component3() {
        return this.date;
    }

    public final int component4() {
        return this.transmitted;
    }

    public final CounterInt copy(String str, int i, String str2, int i2) {
        Intrinsics.checkNotNullParameter(str, "counterId");
        Intrinsics.checkNotNullParameter(str2, "date");
        return new CounterInt(str, i, str2, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CounterInt)) {
            return false;
        }
        CounterInt counterInt = (CounterInt) obj;
        return Intrinsics.areEqual((Object) this.counterId, (Object) counterInt.counterId) && this.counterValue == counterInt.counterValue && Intrinsics.areEqual((Object) this.date, (Object) counterInt.date) && this.transmitted == counterInt.transmitted;
    }

    public final String getCounterId() {
        return this.counterId;
    }

    public final int getCounterValue() {
        return this.counterValue;
    }

    public final String getDate() {
        return this.date;
    }

    public final int getTransmitted() {
        return this.transmitted;
    }

    public int hashCode() {
        int i = this.counterValue;
        int hashCode = this.date.hashCode();
        return this.transmitted + ((hashCode + ((i + (this.counterId.hashCode() * 31)) * 31)) * 31);
    }

    public final void setCounterValue(int i) {
        this.counterValue = i;
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
        int i = this.counterValue;
        String str2 = this.date;
        int i2 = this.transmitted;
        return "CounterInt(counterId=" + str + ", counterValue=" + i + ", date=" + str2 + ", transmitted=" + i2 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CounterInt(String str, int i, String str2, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? 0 : i, str2, (i3 & 8) != 0 ? 0 : i2);
    }
}

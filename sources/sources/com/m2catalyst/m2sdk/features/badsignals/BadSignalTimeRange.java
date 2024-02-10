package com.m2catalyst.m2sdk.features.badsignals;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0001\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0019\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/m2catalyst/m2sdk/features/badsignals/BadSignalTimeRange;", "", "days", "", "code", "(Ljava/lang/String;ILjava/lang/Integer;I)V", "getDays", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "DAY", "WEEK", "MONTH", "ALL", "Companion", "m2sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: BadSignalTimeRange.kt */
public enum BadSignalTimeRange {
    DAY(0, 0),
    WEEK(-6, 1),
    MONTH(-30, 2),
    ALL((String) null, 3);
    
    public static final Companion Companion = null;
    /* access modifiers changed from: private */
    public final int code;
    private final Integer days;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/m2catalyst/m2sdk/features/badsignals/BadSignalTimeRange$Companion;", "", "()V", "get", "Lcom/m2catalyst/m2sdk/features/badsignals/BadSignalTimeRange;", "code", "", "m2sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: BadSignalTimeRange.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final BadSignalTimeRange get(int i) {
            BadSignalTimeRange badSignalTimeRange;
            BadSignalTimeRange[] values = BadSignalTimeRange.values();
            int length = values.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    badSignalTimeRange = null;
                    break;
                }
                badSignalTimeRange = values[i2];
                if (badSignalTimeRange.code == i) {
                    break;
                }
                i2++;
            }
            return badSignalTimeRange == null ? BadSignalTimeRange.ALL : badSignalTimeRange;
        }
    }

    /* access modifiers changed from: public */
    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    private BadSignalTimeRange(Integer num, int i) {
        this.days = num;
        this.code = i;
    }

    public final Integer getDays() {
        return this.days;
    }
}

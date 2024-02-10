package com.m2catalyst.m2sdk.business.models;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0001\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/m2catalyst/m2sdk/business/models/DataCompleteness;", "", "id", "", "type", "", "(Ljava/lang/String;IILjava/lang/String;)V", "getId", "()I", "getType", "()Ljava/lang/String;", "USELESS", "BASIC", "STANDARD", "Companion", "m2sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: DataCompleteness.kt */
public enum DataCompleteness {
    USELESS(-1, "useless"),
    BASIC(1, "basic"),
    STANDARD(2, "standard");
    
    public static final Companion Companion = null;
    private final int id;
    private final String type;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0017\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/m2catalyst/m2sdk/business/models/DataCompleteness$Companion;", "", "()V", "getById", "Lcom/m2catalyst/m2sdk/business/models/DataCompleteness;", "id", "", "(Ljava/lang/Integer;)Lcom/m2catalyst/m2sdk/business/models/DataCompleteness;", "m2sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: DataCompleteness.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DataCompleteness getById(Integer num) {
            if (num != null) {
                num.intValue();
                for (DataCompleteness dataCompleteness : DataCompleteness.values()) {
                    if (dataCompleteness.getId() == num.intValue()) {
                        return dataCompleteness;
                    }
                }
            }
            return null;
        }
    }

    /* access modifiers changed from: public */
    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    private DataCompleteness(int i, String str) {
        this.id = i;
        this.type = str;
    }

    public final int getId() {
        return this.id;
    }

    public final String getType() {
        return this.type;
    }
}

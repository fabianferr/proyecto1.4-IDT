package com.m2catalyst.m2sdk.external;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0001\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/m2catalyst/m2sdk/external/LoggingLevel;", "", "id", "", "(Ljava/lang/String;II)V", "getId", "()I", "VERBOSE", "DEBUG", "INFO", "WARN", "ERROR", "ASSERT", "Companion", "m2sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: LoggingLevel.kt */
public enum LoggingLevel {
    VERBOSE(6),
    DEBUG(5),
    INFO(4),
    WARN(3),
    ERROR(2),
    ASSERT(1);
    
    public static final Companion Companion = null;
    private final int id;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0017\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/m2catalyst/m2sdk/external/LoggingLevel$Companion;", "", "()V", "getById", "Lcom/m2catalyst/m2sdk/external/LoggingLevel;", "id", "", "getById$m2sdk_release", "m2sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: LoggingLevel.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final LoggingLevel getById$m2sdk_release(int i) {
            LoggingLevel loggingLevel = null;
            if (i == -1) {
                return null;
            }
            LoggingLevel[] values = LoggingLevel.values();
            int length = values.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                LoggingLevel loggingLevel2 = values[i2];
                if (loggingLevel2.getId() == i) {
                    loggingLevel = loggingLevel2;
                    break;
                }
                i2++;
            }
            return loggingLevel == null ? LoggingLevel.INFO : loggingLevel;
        }
    }

    /* access modifiers changed from: public */
    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    private LoggingLevel(int i) {
        this.id = i;
    }

    public final int getId() {
        return this.id;
    }
}

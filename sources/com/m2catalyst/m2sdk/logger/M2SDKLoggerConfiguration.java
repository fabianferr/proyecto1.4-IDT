package com.m2catalyst.m2sdk.logger;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\fB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\n\u001a\u00020\u000bR\"\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/m2catalyst/m2sdk/logger/M2SDKLoggerConfiguration;", "", "builder", "Lcom/m2catalyst/m2sdk/logger/M2SDKLoggerConfiguration$Builder;", "(Lcom/m2catalyst/m2sdk/logger/M2SDKLoggerConfiguration$Builder;)V", "<set-?>", "Lcom/m2catalyst/m2sdk/logger/M2LoggingListener;", "listener", "getListener", "()Lcom/m2catalyst/m2sdk/logger/M2LoggingListener;", "readyToForward", "", "Builder", "m2sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: M2SDKLoggerConfiguration.kt */
public final class M2SDKLoggerConfiguration {
    private M2LoggingListener listener;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\u0000J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004R\"\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/m2catalyst/m2sdk/logger/M2SDKLoggerConfiguration$Builder;", "", "()V", "<set-?>", "Lcom/m2catalyst/m2sdk/logger/M2LoggingListener;", "listener", "getListener", "()Lcom/m2catalyst/m2sdk/logger/M2LoggingListener;", "removeListener", "withListener", "m2sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: M2SDKLoggerConfiguration.kt */
    public static final class Builder {
        private M2LoggingListener listener;

        public final M2LoggingListener getListener() {
            return this.listener;
        }

        public final Builder removeListener() {
            this.listener = null;
            return this;
        }

        public final Builder withListener(M2LoggingListener m2LoggingListener) {
            Intrinsics.checkNotNullParameter(m2LoggingListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            this.listener = m2LoggingListener;
            return this;
        }
    }

    private M2SDKLoggerConfiguration(Builder builder) {
        this.listener = builder.getListener();
    }

    public final M2LoggingListener getListener() {
        return this.listener;
    }

    public final boolean readyToForward() {
        return this.listener != null;
    }
}

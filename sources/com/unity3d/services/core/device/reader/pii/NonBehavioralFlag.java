package com.unity3d.services.core.device.reader.pii;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u0000 \u00062\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0007"}, d2 = {"Lcom/unity3d/services/core/device/reader/pii/NonBehavioralFlag;", "", "(Ljava/lang/String;I)V", "UNKNOWN", "TRUE", "FALSE", "Companion", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: NonBehavioralFlag.kt */
public enum NonBehavioralFlag {
    UNKNOWN,
    TRUE,
    FALSE;
    
    public static final Companion Companion = null;

    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/unity3d/services/core/device/reader/pii/NonBehavioralFlag$Companion;", "", "()V", "fromString", "Lcom/unity3d/services/core/device/reader/pii/NonBehavioralFlag;", "value", "", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: NonBehavioralFlag.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final NonBehavioralFlag fromString(String str) {
            NonBehavioralFlag nonBehavioralFlag;
            Intrinsics.checkNotNullParameter(str, "value");
            try {
                Result.Companion companion = Result.Companion;
                Companion companion2 = this;
                String upperCase = str.toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
                nonBehavioralFlag = Result.m2344constructorimpl(NonBehavioralFlag.valueOf(upperCase));
            } catch (Throwable th) {
                Result.Companion companion3 = Result.Companion;
                nonBehavioralFlag = Result.m2344constructorimpl(ResultKt.createFailure(th));
            }
            NonBehavioralFlag nonBehavioralFlag2 = NonBehavioralFlag.UNKNOWN;
            if (Result.m2350isFailureimpl(nonBehavioralFlag)) {
                nonBehavioralFlag = nonBehavioralFlag2;
            }
            return (NonBehavioralFlag) nonBehavioralFlag;
        }
    }
}

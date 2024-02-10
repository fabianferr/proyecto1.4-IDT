package com.unity3d.services.core.extensions;

import com.ironsource.mediationsdk.utils.IronSourceConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/unity3d/services/core/extensions/AbortRetryException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "reason", "", "(Ljava/lang/String;)V", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TaskExtensions.kt */
public final class AbortRetryException extends Exception {
    private final String reason;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AbortRetryException(String str) {
        super(str);
        Intrinsics.checkNotNullParameter(str, IronSourceConstants.EVENTS_ERROR_REASON);
        this.reason = str;
    }
}

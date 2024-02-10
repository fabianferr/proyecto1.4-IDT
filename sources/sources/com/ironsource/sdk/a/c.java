package com.ironsource.sdk.a;

import com.facebook.internal.NativeProtocol;
import com.ironsource.sdk.a.h;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0016¨\u0006\u000b"}, d2 = {"Lcom/ironsource/sdk/Events/ISNEventTrackerWrapper;", "Lcom/ironsource/sdk/Events/ISNEventTrackerInterface;", "()V", "logEvent", "", "event", "Lcom/ironsource/sdk/Events/SDK5Events$Event;", "params", "", "", "", "sdk5_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class c implements b {
    public final void a(h.a aVar, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(aVar, "event");
        Intrinsics.checkNotNullParameter(map, NativeProtocol.WEB_DIALOG_PARAMS);
        f.a(aVar, (Map<String, Object>) map);
    }
}

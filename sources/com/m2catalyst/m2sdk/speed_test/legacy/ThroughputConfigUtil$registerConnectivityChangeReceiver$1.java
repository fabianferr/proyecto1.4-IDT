package com.m2catalyst.m2sdk.speed_test.legacy;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.m2catalyst.m2sdk.logger.M2SDKLogger;
import com.m2catalyst.m2sdk.m4;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/m2catalyst/m2sdk/speed_test/legacy/ThroughputConfigUtil$registerConnectivityChangeReceiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "m2sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ThroughputConfigUtil.kt */
public final class ThroughputConfigUtil$registerConnectivityChangeReceiver$1 extends BroadcastReceiver {
    final /* synthetic */ ThroughputConfigUtil this$0;

    public ThroughputConfigUtil$registerConnectivityChangeReceiver$1(ThroughputConfigUtil throughputConfigUtil) {
        this.this$0 = throughputConfigUtil;
    }

    public void onReceive(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        String action = intent.getAction();
        if (action != null && Intrinsics.areEqual((Object) action, (Object) "android.net.conn.CONNECTIVITY_CHANGE")) {
            M2SDKLogger logger = M2SDKLogger.Companion.getLogger("NDT");
            Object a = m4.a(context);
            if (a == null) {
                a = "";
            }
            logger.d(ThroughputConfigUtil.TAG, "CONNECTIVITY CHANGED - " + a, new String[0]);
            this.this$0.activeDataNetworkUpdated(m4.a(context));
        }
    }
}
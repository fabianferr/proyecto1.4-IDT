package com.m2catalyst.m2sdk.speed_test.legacy;

import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import com.m2catalyst.m2sdk.logger.M2SDKLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0010\u001a\u00020\u0003H\u0016¨\u0006\u0011"}, d2 = {"com/m2catalyst/m2sdk/speed_test/legacy/ThroughputConfigUtil$createDefaultMonitoringNetworkCallback$1", "Landroid/net/ConnectivityManager$NetworkCallback;", "onAvailable", "", "network", "Landroid/net/Network;", "onCapabilitiesChanged", "networkCapabilities", "Landroid/net/NetworkCapabilities;", "onLinkPropertiesChanged", "linkProperties", "Landroid/net/LinkProperties;", "onLosing", "maxMsToLive", "", "onLost", "onUnavailable", "m2sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ThroughputConfigUtil.kt */
public final class ThroughputConfigUtil$createDefaultMonitoringNetworkCallback$1 extends ConnectivityManager.NetworkCallback {
    final /* synthetic */ ThroughputConfigUtil this$0;

    public ThroughputConfigUtil$createDefaultMonitoringNetworkCallback$1(ThroughputConfigUtil throughputConfigUtil) {
        this.this$0 = throughputConfigUtil;
    }

    public void onAvailable(Network network) {
        Intrinsics.checkNotNullParameter(network, "network");
        super.onAvailable(network);
        M2SDKLogger logger = M2SDKLogger.Companion.getLogger("NDT");
        logger.d(ThroughputConfigUtil.TAG, "NCB-DEFAULT onAvailable - " + network, new String[0]);
        this.this$0.activeDataNetworkUpdated(network);
    }

    public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        Intrinsics.checkNotNullParameter(network, "network");
        Intrinsics.checkNotNullParameter(networkCapabilities, "networkCapabilities");
        super.onCapabilitiesChanged(network, networkCapabilities);
        M2SDKLogger logger = M2SDKLogger.Companion.getLogger("NDT");
        logger.d(ThroughputConfigUtil.TAG, "NCB-DEFAULT onCapabilitiesChanged - " + network + ", " + networkCapabilities, new String[0]);
    }

    public void onLinkPropertiesChanged(Network network, LinkProperties linkProperties) {
        Intrinsics.checkNotNullParameter(network, "network");
        Intrinsics.checkNotNullParameter(linkProperties, "linkProperties");
        super.onLinkPropertiesChanged(network, linkProperties);
        M2SDKLogger logger = M2SDKLogger.Companion.getLogger("NDT");
        logger.d(ThroughputConfigUtil.TAG, "NCB-DEFAULT onLinkPropertiesChanged - " + network + ", " + linkProperties, new String[0]);
    }

    public void onLosing(Network network, int i) {
        Intrinsics.checkNotNullParameter(network, "network");
        super.onLosing(network, i);
        M2SDKLogger logger = M2SDKLogger.Companion.getLogger("NDT");
        logger.d(ThroughputConfigUtil.TAG, "NCB-DEFAULT onLosing - " + network, new String[0]);
    }

    public void onLost(Network network) {
        Intrinsics.checkNotNullParameter(network, "network");
        super.onLost(network);
        M2SDKLogger logger = M2SDKLogger.Companion.getLogger("NDT");
        logger.d(ThroughputConfigUtil.TAG, "NCB-DEFAULT onLost - " + network, new String[0]);
    }

    public void onUnavailable() {
        super.onUnavailable();
        M2SDKLogger.Companion.getLogger("NDT").d(ThroughputConfigUtil.TAG, "NCB-DEFAULT onUnavailable", new String[0]);
    }
}

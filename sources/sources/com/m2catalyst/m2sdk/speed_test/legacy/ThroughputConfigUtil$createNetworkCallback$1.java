package com.m2catalyst.m2sdk.speed_test.legacy;

import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Handler;
import com.m2catalyst.m2sdk.logger.M2SDKLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0010\u001a\u00020\u0003H\u0016¨\u0006\u0011"}, d2 = {"com/m2catalyst/m2sdk/speed_test/legacy/ThroughputConfigUtil$createNetworkCallback$1", "Landroid/net/ConnectivityManager$NetworkCallback;", "onAvailable", "", "network", "Landroid/net/Network;", "onCapabilitiesChanged", "networkCapabilities", "Landroid/net/NetworkCapabilities;", "onLinkPropertiesChanged", "linkProperties", "Landroid/net/LinkProperties;", "onLosing", "maxMsToLive", "", "onLost", "onUnavailable", "m2sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ThroughputConfigUtil.kt */
public final class ThroughputConfigUtil$createNetworkCallback$1 extends ConnectivityManager.NetworkCallback {
    final /* synthetic */ Network $desiredNetwork;
    final /* synthetic */ ThroughputConfigUtil this$0;

    public ThroughputConfigUtil$createNetworkCallback$1(Network network, ThroughputConfigUtil throughputConfigUtil) {
        this.$desiredNetwork = network;
        this.this$0 = throughputConfigUtil;
    }

    /* access modifiers changed from: private */
    public static final void onAvailable$lambda$0(ThroughputConfigUtil throughputConfigUtil) {
        Intrinsics.checkNotNullParameter(throughputConfigUtil, "this$0");
        throughputConfigUtil.runTest();
    }

    public void onAvailable(Network network) {
        Intrinsics.checkNotNullParameter(network, "network");
        super.onAvailable(network);
        M2SDKLogger.Companion companion = M2SDKLogger.Companion;
        M2SDKLogger logger = companion.getLogger("NDT");
        logger.d(ThroughputConfigUtil.TAG, "NCB onAvailable - " + network, new String[0]);
        if (Intrinsics.areEqual((Object) this.$desiredNetwork, (Object) network)) {
            this.this$0.getNdt().setNetwork(network);
            Handler access$getTcuMainHandler$p = this.this$0.tcuMainHandler;
            Intrinsics.checkNotNull(access$getTcuMainHandler$p);
            access$getTcuMainHandler$p.post(new ThroughputConfigUtil$createNetworkCallback$1$$ExternalSyntheticLambda0(this.this$0));
            return;
        }
        companion.getLogger("NDT").d(ThroughputConfigUtil.TAG, "NCB onAvailable network does not match desired network", new String[0]);
    }

    public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        Intrinsics.checkNotNullParameter(network, "network");
        Intrinsics.checkNotNullParameter(networkCapabilities, "networkCapabilities");
        super.onCapabilitiesChanged(network, networkCapabilities);
        M2SDKLogger logger = M2SDKLogger.Companion.getLogger("NDT");
        logger.d(ThroughputConfigUtil.TAG, "NCB onCapabilitiesChanged - " + network + ", " + networkCapabilities, new String[0]);
    }

    public void onLinkPropertiesChanged(Network network, LinkProperties linkProperties) {
        Intrinsics.checkNotNullParameter(network, "network");
        Intrinsics.checkNotNullParameter(linkProperties, "linkProperties");
        super.onLinkPropertiesChanged(network, linkProperties);
        M2SDKLogger logger = M2SDKLogger.Companion.getLogger("NDT");
        logger.d(ThroughputConfigUtil.TAG, "NCB onLinkPropertiesChanged - " + network + ", " + linkProperties, new String[0]);
    }

    public void onLosing(Network network, int i) {
        Intrinsics.checkNotNullParameter(network, "network");
        super.onLosing(network, i);
        M2SDKLogger logger = M2SDKLogger.Companion.getLogger("NDT");
        logger.d(ThroughputConfigUtil.TAG, "NCB onLosing - " + network, new String[0]);
    }

    public void onLost(Network network) {
        Intrinsics.checkNotNullParameter(network, "network");
        super.onLost(network);
        M2SDKLogger logger = M2SDKLogger.Companion.getLogger("NDT");
        logger.d(ThroughputConfigUtil.TAG, "NCB onLost - " + network, new String[0]);
        if (Intrinsics.areEqual((Object) this.$desiredNetwork, (Object) network)) {
            this.this$0.testFailed("Network Lost", 8, true);
        }
    }

    public void onUnavailable() {
        super.onUnavailable();
        M2SDKLogger.Companion.getLogger("NDT").d(ThroughputConfigUtil.TAG, "NCB onUnavailable", new String[0]);
        this.this$0.testFailed("Network Unavailable", 9, true);
    }
}

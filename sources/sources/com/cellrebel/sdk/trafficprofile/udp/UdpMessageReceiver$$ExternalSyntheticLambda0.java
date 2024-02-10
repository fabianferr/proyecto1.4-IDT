package com.cellrebel.sdk.trafficprofile.udp;

import com.cellrebel.sdk.trafficprofile.udp.UdpClient;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class UdpMessageReceiver$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ UdpMessageReceiver f$0;
    public final /* synthetic */ UdpClient.UdpClientListener f$1;

    public /* synthetic */ UdpMessageReceiver$$ExternalSyntheticLambda0(UdpMessageReceiver udpMessageReceiver, UdpClient.UdpClientListener udpClientListener) {
        this.f$0 = udpMessageReceiver;
        this.f$1 = udpClientListener;
    }

    public final void run() {
        this.f$0.a(this.f$1);
    }
}

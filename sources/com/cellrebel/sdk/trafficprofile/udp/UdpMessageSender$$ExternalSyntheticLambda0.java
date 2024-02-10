package com.cellrebel.sdk.trafficprofile.udp;

import com.cellrebel.sdk.trafficprofile.udp.messages.UdpMessage;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class UdpMessageSender$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ UdpMessageSender f$0;
    public final /* synthetic */ UdpMessage f$1;

    public /* synthetic */ UdpMessageSender$$ExternalSyntheticLambda0(UdpMessageSender udpMessageSender, UdpMessage udpMessage) {
        this.f$0 = udpMessageSender;
        this.f$1 = udpMessage;
    }

    public final void run() {
        this.f$0.a(this.f$1);
    }
}

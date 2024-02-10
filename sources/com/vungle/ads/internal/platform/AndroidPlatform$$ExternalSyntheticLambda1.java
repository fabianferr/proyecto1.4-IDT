package com.vungle.ads.internal.platform;

import androidx.core.util.Consumer;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AndroidPlatform$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ AndroidPlatform f$0;
    public final /* synthetic */ Consumer f$1;

    public /* synthetic */ AndroidPlatform$$ExternalSyntheticLambda1(AndroidPlatform androidPlatform, Consumer consumer) {
        this.f$0 = androidPlatform;
        this.f$1 = consumer;
    }

    public final void run() {
        AndroidPlatform.m2311getUserAgentLazy$lambda0(this.f$0, this.f$1);
    }
}

package com.cellrebel.sdk.tti;

import com.cellrebel.sdk.tti.models.Server;
import java.util.Map;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ServerSelection$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ ServerSelection f$0;
    public final /* synthetic */ Server f$1;
    public final /* synthetic */ int f$2;
    public final /* synthetic */ int f$3;
    public final /* synthetic */ String f$4;
    public final /* synthetic */ String f$5;
    public final /* synthetic */ Map f$6;

    public /* synthetic */ ServerSelection$$ExternalSyntheticLambda0(ServerSelection serverSelection, Server server, int i, int i2, String str, String str2, Map map) {
        this.f$0 = serverSelection;
        this.f$1 = server;
        this.f$2 = i;
        this.f$3 = i2;
        this.f$4 = str;
        this.f$5 = str2;
        this.f$6 = map;
    }

    public final void run() {
        this.f$0.a(this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6);
    }
}

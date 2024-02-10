package com.cellrebel.sdk.networking;

import com.cellrebel.sdk.utils.PreferencesManager;
import java.util.concurrent.Callable;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class TokenAuthenticator$$ExternalSyntheticLambda0 implements Callable {
    public final /* synthetic */ String f$0;
    public final /* synthetic */ String f$1;
    public final /* synthetic */ String f$2;

    public /* synthetic */ TokenAuthenticator$$ExternalSyntheticLambda0(String str, String str2, String str3) {
        this.f$0 = str;
        this.f$1 = str2;
        this.f$2 = str3;
    }

    public final Object call() {
        return PreferencesManager.m().a(this.f$0, this.f$1, this.f$2);
    }
}

package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzor extends GoogleApi implements zzok {
    private static final Api.ClientKey zza;
    private static final Api.AbstractClientBuilder zzb;
    private static final Api zzc;

    static {
        Api.ClientKey clientKey = new Api.ClientKey();
        zza = clientKey;
        zzoo zzoo = new zzoo();
        zzb = zzoo;
        zzc = new Api("SignalSdk.API", zzoo, clientKey);
    }

    public zzor(Context context) {
        super(context, zzc, null, GoogleApi.Settings.DEFAULT_SETTINGS);
    }
}

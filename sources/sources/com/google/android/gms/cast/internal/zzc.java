package com.google.android.gms.cast.internal;

import com.google.android.gms.cast.Cast;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;

/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
public abstract class zzc extends BaseImplementation.ApiMethodImpl {
    public zzc(GoogleApiClient googleApiClient) {
        super((Api<?>) Cast.API, googleApiClient);
    }

    public final /* bridge */ /* synthetic */ void setResult(Object obj) {
        super.setResult((Result) obj);
    }

    public final void zzc(int i) {
        setResult(createFailedResult(new Status(2001)));
    }
}

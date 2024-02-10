package com.google.android.gms.cast;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.cast.internal.zzx;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
final class zzbk extends Api.AbstractClientBuilder {
    zzbk() {
    }

    public final /* bridge */ /* synthetic */ Api.Client buildClient(Context context, Looper looper, ClientSettings clientSettings, Object obj, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        Cast.CastOptions castOptions = (Cast.CastOptions) obj;
        Preconditions.checkNotNull(castOptions, "Setting the API options is required.");
        return new zzx(context, looper, clientSettings, castOptions.zza, (long) castOptions.zzd, castOptions.zzc, castOptions.zze, connectionCallbacks, onConnectionFailedListener);
    }
}

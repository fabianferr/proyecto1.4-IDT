package com.google.android.gms.cast.framework;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
public abstract class SessionProvider {
    private final Context zza;
    private final String zzb;
    private final zzbb zzc = new zzbb(this, (zzba) null);

    protected SessionProvider(Context context, String str) {
        this.zza = ((Context) Preconditions.checkNotNull(context)).getApplicationContext();
        this.zzb = Preconditions.checkNotEmpty(str);
    }

    public abstract Session createSession(String str);

    public final String getCategory() {
        return this.zzb;
    }

    public final Context getContext() {
        return this.zza;
    }

    public abstract boolean isSessionRecoverable();

    public final IBinder zza() {
        return this.zzc;
    }
}

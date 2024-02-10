package com.google.android.gms.internal.cast;

import com.google.android.gms.cast.framework.CastOptions;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.Session;
import com.google.android.gms.cast.framework.SessionProvider;
import com.google.android.gms.cast.framework.media.internal.zzv;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
public final class zzah extends SessionProvider {
    private final CastOptions zza;
    private final zzbf zzb;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzah(android.content.Context r3, com.google.android.gms.cast.framework.CastOptions r4, com.google.android.gms.internal.cast.zzbf r5) {
        /*
            r2 = this;
            java.util.List r0 = r4.getSupportedNamespaces()
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x0013
            java.lang.String r0 = r4.getReceiverApplicationId()
            java.lang.String r0 = com.google.android.gms.cast.CastMediaControlIntent.categoryForCast((java.lang.String) r0)
            goto L_0x001f
        L_0x0013:
            java.lang.String r0 = r4.getReceiverApplicationId()
            java.util.List r1 = r4.getSupportedNamespaces()
            java.lang.String r0 = com.google.android.gms.cast.CastMediaControlIntent.categoryForCast(r0, r1)
        L_0x001f:
            r2.<init>(r3, r0)
            r2.zza = r4
            r2.zzb = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.cast.zzah.<init>(android.content.Context, com.google.android.gms.cast.framework.CastOptions, com.google.android.gms.internal.cast.zzbf):void");
    }

    public final Session createSession(String str) {
        return new CastSession(getContext(), getCategory(), str, this.zza, this.zzb, new zzv(getContext(), this.zza, this.zzb));
    }

    public final boolean isSessionRecoverable() {
        return this.zza.getResumeSavedSession();
    }
}

package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;

/* compiled from: com.google.android.gms:play-services-pal@@20.0.1 */
final class zzmy extends ThreadLocal {
    zzmy() {
    }

    protected static final Cipher zza() {
        try {
            return (Cipher) zzxz.zza.zza("AES/GCM-SIV/NoPadding");
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException(e);
        }
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ Object initialValue() {
        return zza();
    }
}

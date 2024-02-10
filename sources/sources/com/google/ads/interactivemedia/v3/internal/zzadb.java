package com.google.ads.interactivemedia.v3.internal;

import com.google.ads.interactivemedia.v3.internal.zzada;
import com.google.ads.interactivemedia.v3.internal.zzadb;
import java.io.IOException;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public abstract class zzadb<MessageType extends zzadb<MessageType, BuilderType>, BuilderType extends zzada<MessageType, BuilderType>> implements zzafz {
    protected int zza = 0;

    /* access modifiers changed from: package-private */
    public int zzat(zzags zzags) {
        throw null;
    }

    public final zzadr zzau() {
        try {
            int zzax = zzax();
            zzadr zzadr = zzadr.zzb;
            byte[] bArr = new byte[zzax];
            zzaea zzz = zzaea.zzz(bArr, 0, zzax);
            zzaO(zzz);
            zzz.zzA();
            return new zzado(bArr);
        } catch (IOException e) {
            String name = getClass().getName();
            throw new RuntimeException("Serializing " + name + " to a ByteString threw an IOException (should never happen).", e);
        }
    }

    public final byte[] zzav() {
        try {
            int zzax = zzax();
            byte[] bArr = new byte[zzax];
            zzaea zzz = zzaea.zzz(bArr, 0, zzax);
            zzaO(zzz);
            zzz.zzA();
            return bArr;
        } catch (IOException e) {
            String name = getClass().getName();
            throw new RuntimeException("Serializing " + name + " to a byte array threw an IOException (should never happen).", e);
        }
    }
}

package com.google.ads.interactivemedia.v3.internal;

import com.google.ads.interactivemedia.v3.internal.zzaep;
import com.google.ads.interactivemedia.v3.internal.zzaet;
import java.io.IOException;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public class zzaep<MessageType extends zzaet<MessageType, BuilderType>, BuilderType extends zzaep<MessageType, BuilderType>> extends zzada<MessageType, BuilderType> {
    protected zzaet zza;
    private final zzaet zzb;

    protected zzaep(MessageType messagetype) {
        this.zzb = messagetype;
        if (!messagetype.zzaQ()) {
            this.zza = messagetype.zzaA();
            return;
        }
        throw new IllegalArgumentException("Default instance must be immutable.");
    }

    public final /* synthetic */ zzafz zzaR() {
        throw null;
    }

    /* renamed from: zzai */
    public final zzaep zzah() {
        zzaep zzaep = (zzaep) this.zzb.zzj(5, (Object) null, (Object) null);
        zzaep.zza = zzam();
        return zzaep;
    }

    public final zzaep zzaj(byte[] bArr, int i, int i2, zzaef zzaef) throws zzafc {
        if (!this.zza.zzaQ()) {
            zzap();
        }
        try {
            zzagh.zza().zzb(this.zza.getClass()).zzi(this.zza, bArr, 0, i2, new zzade(zzaef));
            return this;
        } catch (zzafc e) {
            throw e;
        } catch (IndexOutOfBoundsException unused) {
            throw zzafc.zzi();
        } catch (IOException e2) {
            throw new RuntimeException("Reading from byte array should not throw IOException.", e2);
        }
    }

    public final MessageType zzak() {
        MessageType zzal = zzam();
        if (zzal.zzaP()) {
            return zzal;
        }
        throw new zzahi(zzal);
    }

    /* renamed from: zzal */
    public MessageType zzam() {
        if (!this.zza.zzaQ()) {
            return this.zza;
        }
        this.zza.zzaK();
        return this.zza;
    }

    /* access modifiers changed from: protected */
    public final void zzao() {
        if (!this.zza.zzaQ()) {
            zzap();
        }
    }

    /* access modifiers changed from: protected */
    public void zzap() {
        zzaet zzaA = this.zzb.zzaA();
        zzagh.zza().zzb(zzaA.getClass()).zzg(zzaA, this.zza);
        this.zza = zzaA;
    }
}

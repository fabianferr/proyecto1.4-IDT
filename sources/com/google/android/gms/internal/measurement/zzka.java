package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzka;
import com.google.android.gms.internal.measurement.zzke;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.1.1 */
public class zzka<MessageType extends zzke<MessageType, BuilderType>, BuilderType extends zzka<MessageType, BuilderType>> extends zzim<MessageType, BuilderType> {
    protected zzke zza;
    protected boolean zzb = false;
    private final zzke zzc;

    protected zzka(MessageType messagetype) {
        this.zzc = messagetype;
        this.zza = (zzke) messagetype.zzl(4, (Object) null, (Object) null);
    }

    private static final void zza(zzke zzke, zzke zzke2) {
        zzlt.zza().zzb(zzke.getClass()).zzg(zzke, zzke2);
    }

    /* renamed from: zzaB */
    public final zzka zzau() {
        zzka zzka = (zzka) this.zzc.zzl(5, (Object) null, (Object) null);
        zzka.zzaC(zzaG());
        return zzka;
    }

    public final zzka zzaC(zzke zzke) {
        if (this.zzb) {
            zzaI();
            this.zzb = false;
        }
        zza(this.zza, zzke);
        return this;
    }

    public final zzka zzaD(byte[] bArr, int i, int i2, zzjq zzjq) throws zzko {
        if (this.zzb) {
            zzaI();
            this.zzb = false;
        }
        try {
            zzlt.zza().zzb(this.zza.getClass()).zzh(this.zza, bArr, 0, i2, new zziq(zzjq));
            return this;
        } catch (zzko e) {
            throw e;
        } catch (IndexOutOfBoundsException unused) {
            throw zzko.zzf();
        } catch (IOException e2) {
            throw new RuntimeException("Reading from byte array should not throw IOException.", e2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0030, code lost:
        if (r3 != false) goto L_0x0032;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final MessageType zzaE() {
        /*
            r5 = this;
            com.google.android.gms.internal.measurement.zzke r0 = r5.zzaG()
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            r1 = 1
            r2 = 0
            java.lang.Object r3 = r0.zzl(r1, r2, r2)
            java.lang.Byte r3 = (java.lang.Byte) r3
            byte r3 = r3.byteValue()
            if (r3 != r1) goto L_0x0015
            goto L_0x0032
        L_0x0015:
            if (r3 == 0) goto L_0x0033
            com.google.android.gms.internal.measurement.zzlt r3 = com.google.android.gms.internal.measurement.zzlt.zza()
            java.lang.Class r4 = r0.getClass()
            com.google.android.gms.internal.measurement.zzlw r3 = r3.zzb(r4)
            boolean r3 = r3.zzk(r0)
            if (r1 == r3) goto L_0x002b
            r1 = r2
            goto L_0x002c
        L_0x002b:
            r1 = r0
        L_0x002c:
            r4 = 2
            r0.zzl(r4, r1, r2)
            if (r3 == 0) goto L_0x0033
        L_0x0032:
            return r0
        L_0x0033:
            com.google.android.gms.internal.measurement.zzmm r1 = new com.google.android.gms.internal.measurement.zzmm
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzka.zzaE():com.google.android.gms.internal.measurement.zzke");
    }

    /* renamed from: zzaF */
    public MessageType zzaG() {
        if (this.zzb) {
            return this.zza;
        }
        zzke zzke = this.zza;
        zzlt.zza().zzb(zzke.getClass()).zzf(zzke);
        this.zzb = true;
        return this.zza;
    }

    /* access modifiers changed from: protected */
    public void zzaI() {
        zzke zzke = (zzke) this.zza.zzl(4, (Object) null, (Object) null);
        zza(zzke, this.zza);
        this.zza = zzke;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ zzim zzav(zzin zzin) {
        zzaC((zzke) zzin);
        return this;
    }

    public final /* bridge */ /* synthetic */ zzim zzaw(byte[] bArr, int i, int i2) throws zzko {
        zzaD(bArr, 0, i2, zzjq.zza);
        return this;
    }

    public final /* bridge */ /* synthetic */ zzim zzax(byte[] bArr, int i, int i2, zzjq zzjq) throws zzko {
        zzaD(bArr, 0, i2, zzjq);
        return this;
    }

    public final /* synthetic */ zzll zzbO() {
        return this.zzc;
    }
}

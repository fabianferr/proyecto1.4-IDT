package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzim;
import com.google.android.gms.internal.measurement.zzin;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.1.1 */
public abstract class zzim<MessageType extends zzin<MessageType, BuilderType>, BuilderType extends zzim<MessageType, BuilderType>> implements zzlk {
    public final /* synthetic */ zzlk zzaA(byte[] bArr, zzjq zzjq) throws zzko {
        return zzax(bArr, 0, bArr.length, zzjq);
    }

    /* renamed from: zzau */
    public abstract zzim clone();

    /* access modifiers changed from: protected */
    public abstract zzim zzav(zzin zzin);

    public zzim zzaw(byte[] bArr, int i, int i2) throws zzko {
        throw null;
    }

    public zzim zzax(byte[] bArr, int i, int i2, zzjq zzjq) throws zzko {
        throw null;
    }

    public final /* bridge */ /* synthetic */ zzlk zzay(zzll zzll) {
        if (zzbO().getClass().isInstance(zzll)) {
            return zzav((zzin) zzll);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }

    public final /* synthetic */ zzlk zzaz(byte[] bArr) throws zzko {
        return zzaw(bArr, 0, bArr.length);
    }
}

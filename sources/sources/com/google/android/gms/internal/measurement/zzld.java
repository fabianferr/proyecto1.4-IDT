package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.1.1 */
final class zzld implements zzlx {
    private static final zzlj zza = new zzlb();
    private final zzlj zzb;

    public zzld() {
        zzlj zzlj;
        zzlj[] zzljArr = new zzlj[2];
        zzljArr[0] = zzjz.zza();
        try {
            zzlj = (zzlj) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (Exception unused) {
            zzlj = zza;
        }
        zzljArr[1] = zzlj;
        zzlc zzlc = new zzlc(zzljArr);
        zzkm.zzf(zzlc, "messageInfoFactory");
        this.zzb = zzlc;
    }

    private static boolean zzb(zzli zzli) {
        return zzli.zzc() == 1;
    }

    public final zzlw zza(Class cls) {
        zzly.zzG(cls);
        zzli zzb2 = this.zzb.zzb(cls);
        if (zzb2.zzb()) {
            if (zzke.class.isAssignableFrom(cls)) {
                return zzlp.zzc(zzly.zzB(), zzjt.zzb(), zzb2.zza());
            }
            return zzlp.zzc(zzly.zzz(), zzjt.zza(), zzb2.zza());
        } else if (zzke.class.isAssignableFrom(cls)) {
            if (zzb(zzb2)) {
                return zzlo.zzl(cls, zzb2, zzlr.zzb(), zzkz.zzd(), zzly.zzB(), zzjt.zzb(), zzlh.zzb());
            }
            return zzlo.zzl(cls, zzb2, zzlr.zzb(), zzkz.zzd(), zzly.zzB(), (zzjr) null, zzlh.zzb());
        } else if (zzb(zzb2)) {
            return zzlo.zzl(cls, zzb2, zzlr.zza(), zzkz.zzc(), zzly.zzz(), zzjt.zza(), zzlh.zza());
        } else {
            return zzlo.zzl(cls, zzb2, zzlr.zza(), zzkz.zzc(), zzly.zzA(), (zzjr) null, zzlh.zza());
        }
    }
}

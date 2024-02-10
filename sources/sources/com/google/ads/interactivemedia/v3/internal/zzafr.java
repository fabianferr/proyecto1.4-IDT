package com.google.ads.interactivemedia.v3.internal;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzafr implements zzagt {
    private static final zzafx zza = new zzafp();
    private final zzafx zzb;

    public zzafr() {
        zzafx zzafx;
        zzafx[] zzafxArr = new zzafx[2];
        zzafxArr[0] = zzaeo.zza();
        try {
            zzafx = (zzafx) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (Exception unused) {
            zzafx = zza;
        }
        zzafxArr[1] = zzafx;
        zzafq zzafq = new zzafq(zzafxArr);
        byte[] bArr = zzafa.zzd;
        this.zzb = zzafq;
    }

    private static boolean zzb(zzafw zzafw) {
        return zzafw.zzc() == 1;
    }

    public final zzags zza(Class cls) {
        zzagu.zzE(cls);
        zzafw zzb2 = this.zzb.zzb(cls);
        if (zzb2.zzb()) {
            if (zzaet.class.isAssignableFrom(cls)) {
                return zzagd.zzc(zzagu.zzA(), zzaei.zzb(), zzb2.zza());
            }
            return zzagd.zzc(zzagu.zzy(), zzaei.zza(), zzb2.zza());
        } else if (zzaet.class.isAssignableFrom(cls)) {
            if (zzb(zzb2)) {
                return zzagc.zzm(cls, zzb2, zzagf.zzb(), zzafn.zze(), zzagu.zzA(), zzaei.zzb(), zzafv.zzb());
            }
            return zzagc.zzm(cls, zzb2, zzagf.zzb(), zzafn.zze(), zzagu.zzA(), (zzaeg) null, zzafv.zzb());
        } else if (zzb(zzb2)) {
            return zzagc.zzm(cls, zzb2, zzagf.zza(), zzafn.zzd(), zzagu.zzy(), zzaei.zza(), zzafv.zza());
        } else {
            return zzagc.zzm(cls, zzb2, zzagf.zza(), zzafn.zzd(), zzagu.zzz(), (zzaeg) null, zzafv.zza());
        }
    }
}

package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzagd implements zzags {
    private final zzafz zza;
    private final zzahj zzb;
    private final boolean zzc;
    private final zzaeg zzd;

    private zzagd(zzahj zzahj, zzaeg zzaeg, zzafz zzafz) {
        this.zzb = zzahj;
        this.zzc = zzaeg.zzh(zzafz);
        this.zzd = zzaeg;
        this.zza = zzafz;
    }

    static zzagd zzc(zzahj zzahj, zzaeg zzaeg, zzafz zzafz) {
        return new zzagd(zzahj, zzaeg, zzafz);
    }

    public final int zza(Object obj) {
        zzahj zzahj = this.zzb;
        int zzb2 = zzahj.zzb(zzahj.zzd(obj));
        if (!this.zzc) {
            return zzb2;
        }
        this.zzd.zza(obj);
        throw null;
    }

    public final int zzb(Object obj) {
        int hashCode = this.zzb.zzd(obj).hashCode();
        if (!this.zzc) {
            return hashCode;
        }
        this.zzd.zza(obj);
        throw null;
    }

    public final Object zze() {
        zzafz zzafz = this.zza;
        if (zzafz instanceof zzaet) {
            return ((zzaet) zzafz).zzaA();
        }
        return zzafz.zzaH().zzam();
    }

    public final void zzf(Object obj) {
        this.zzb.zzm(obj);
        this.zzd.zze(obj);
    }

    public final void zzg(Object obj, Object obj2) {
        zzagu.zzD(this.zzb, obj, obj2);
        if (this.zzc) {
            this.zzd.zza(obj2);
            throw null;
        }
    }

    public final void zzh(Object obj, zzagk zzagk, zzaef zzaef) throws IOException {
        boolean z;
        zzahj zzahj = this.zzb;
        zzaeg zzaeg = this.zzd;
        Object zzc2 = zzahj.zzc(obj);
        zzaek zzb2 = zzaeg.zzb(obj);
        while (zzagk.zzc() != Integer.MAX_VALUE) {
            int zzd2 = zzagk.zzd();
            if (zzd2 != 11) {
                if ((zzd2 & 7) == 2) {
                    Object zzc3 = zzaeg.zzc(zzaef, this.zza, zzd2 >>> 3);
                    if (zzc3 != null) {
                        zzaeg.zzf(zzagk, zzc3, zzaef, zzb2);
                    } else {
                        z = zzahj.zzq(zzc2, zzagk);
                    }
                } else {
                    z = zzagk.zzO();
                }
                if (!z) {
                    zzahj.zzn(obj, zzc2);
                    return;
                }
            } else {
                Object obj2 = null;
                zzadr zzadr = null;
                int i = 0;
                while (true) {
                    try {
                        if (zzagk.zzc() == Integer.MAX_VALUE) {
                            break;
                        }
                        int zzd3 = zzagk.zzd();
                        if (zzd3 == 16) {
                            i = zzagk.zzj();
                            obj2 = zzaeg.zzc(zzaef, this.zza, i);
                        } else if (zzd3 == 26) {
                            if (obj2 != null) {
                                zzaeg.zzf(zzagk, obj2, zzaef, zzb2);
                            } else {
                                zzadr = zzagk.zzp();
                            }
                        } else if (!zzagk.zzO()) {
                            break;
                        }
                    } catch (Throwable th) {
                        zzahj.zzn(obj, zzc2);
                        throw th;
                    }
                }
                if (zzagk.zzd() != 12) {
                    throw zzafc.zzb();
                } else if (zzadr != null) {
                    if (obj2 != null) {
                        zzaeg.zzg(zzadr, obj2, zzaef, zzb2);
                    } else {
                        zzahj.zzk(zzc2, i, zzadr);
                    }
                }
            }
        }
        zzahj.zzn(obj, zzc2);
    }

    public final void zzi(Object obj, byte[] bArr, int i, int i2, zzade zzade) throws IOException {
        zzaet zzaet = (zzaet) obj;
        if (zzaet.zzc == zzahk.zzc()) {
            zzaet.zzc = zzahk.zzf();
        }
        zzaeq zzaeq = (zzaeq) obj;
        throw null;
    }

    public final void zzj(Object obj, zzaib zzaib) throws IOException {
        this.zzd.zza(obj);
        throw null;
    }

    public final boolean zzk(Object obj, Object obj2) {
        if (!this.zzb.zzd(obj).equals(this.zzb.zzd(obj2))) {
            return false;
        }
        if (!this.zzc) {
            return true;
        }
        this.zzd.zza(obj);
        this.zzd.zza(obj2);
        throw null;
    }

    public final boolean zzl(Object obj) {
        this.zzd.zza(obj);
        throw null;
    }
}

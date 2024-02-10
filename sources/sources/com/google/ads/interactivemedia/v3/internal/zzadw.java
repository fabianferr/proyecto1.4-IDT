package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.util.List;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzadw implements zzagk {
    private final zzadv zza;
    private int zzb;
    private int zzc;
    private int zzd = 0;

    private zzadw(zzadv zzadv) {
        byte[] bArr = zzafa.zzd;
        this.zza = zzadv;
        zzadv.zzc = this;
    }

    private final void zzP(Object obj, zzags zzags, zzaef zzaef) throws IOException {
        int i = this.zzc;
        this.zzc = ((this.zzb >>> 3) << 3) | 4;
        try {
            zzags.zzh(obj, this, zzaef);
            if (this.zzb != this.zzc) {
                throw zzafc.zzg();
            }
        } finally {
            this.zzc = i;
        }
    }

    private final void zzQ(Object obj, zzags zzags, zzaef zzaef) throws IOException {
        int zze = ((zzadt) this.zza).zze();
        zzadv zzadv = this.zza;
        if (zzadv.zza < zzadv.zzb) {
            int zzc2 = zzadv.zzc(zze);
            this.zza.zza++;
            zzags.zzh(obj, this, zzaef);
            this.zza.zzm(0);
            zzadv zzadv2 = this.zza;
            zzadv2.zza--;
            zzadv2.zzn(zzc2);
            return;
        }
        throw new zzafc("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    private final void zzR(int i) throws IOException {
        if (this.zza.zzb() != i) {
            throw zzafc.zzi();
        }
    }

    private final void zzS(int i) throws IOException {
        if ((this.zzb & 7) != i) {
            throw zzafc.zza();
        }
    }

    private static final void zzT(int i) throws IOException {
        if ((i & 3) != 0) {
            throw zzafc.zzg();
        }
    }

    private static final void zzU(int i) throws IOException {
        if ((i & 7) != 0) {
            throw zzafc.zzg();
        }
    }

    public static zzadw zzq(zzadv zzadv) {
        zzadw zzadw = zzadv.zzc;
        return zzadw != null ? zzadw : new zzadw(zzadv);
    }

    public final void zzA(List list) throws IOException {
        int zzf;
        int zzf2;
        if (list instanceof zzafo) {
            zzafo zzafo = (zzafo) list;
            int i = this.zzb & 7;
            if (i == 1) {
                do {
                    zzafo.zzf(((zzadt) this.zza).zzg());
                    zzadv zzadv = this.zza;
                    if (!zzadv.zzp()) {
                        zzf2 = zzadv.zzf();
                    } else {
                        return;
                    }
                } while (zzf2 == this.zzb);
                this.zzd = zzf2;
            } else if (i == 2) {
                int zze = ((zzadt) this.zza).zze();
                zzU(zze);
                int zzb2 = this.zza.zzb() + zze;
                do {
                    zzafo.zzf(((zzadt) this.zza).zzg());
                } while (this.zza.zzb() < zzb2);
            } else {
                throw zzafc.zza();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 1) {
                do {
                    list.add(Long.valueOf(((zzadt) this.zza).zzg()));
                    zzadv zzadv2 = this.zza;
                    if (!zzadv2.zzp()) {
                        zzf = zzadv2.zzf();
                    } else {
                        return;
                    }
                } while (zzf == this.zzb);
                this.zzd = zzf;
            } else if (i2 == 2) {
                int zze2 = ((zzadt) this.zza).zze();
                zzU(zze2);
                int zzb3 = this.zza.zzb() + zze2;
                do {
                    list.add(Long.valueOf(((zzadt) this.zza).zzg()));
                } while (this.zza.zzb() < zzb3);
            } else {
                throw zzafc.zza();
            }
        }
    }

    public final void zzB(List list) throws IOException {
        int zzf;
        int zzf2;
        if (list instanceof zzaem) {
            zzaem zzaem = (zzaem) list;
            int i = this.zzb & 7;
            if (i == 2) {
                int zze = ((zzadt) this.zza).zze();
                zzT(zze);
                int zzb2 = this.zza.zzb() + zze;
                do {
                    zzaem.zze(Float.intBitsToFloat(((zzadt) this.zza).zzd()));
                } while (this.zza.zzb() < zzb2);
            } else if (i == 5) {
                do {
                    zzaem.zze(Float.intBitsToFloat(((zzadt) this.zza).zzd()));
                    zzadv zzadv = this.zza;
                    if (!zzadv.zzp()) {
                        zzf2 = zzadv.zzf();
                    } else {
                        return;
                    }
                } while (zzf2 == this.zzb);
                this.zzd = zzf2;
            } else {
                throw zzafc.zza();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 2) {
                int zze2 = ((zzadt) this.zza).zze();
                zzT(zze2);
                int zzb3 = this.zza.zzb() + zze2;
                do {
                    list.add(Float.valueOf(Float.intBitsToFloat(((zzadt) this.zza).zzd())));
                } while (this.zza.zzb() < zzb3);
            } else if (i2 == 5) {
                do {
                    list.add(Float.valueOf(Float.intBitsToFloat(((zzadt) this.zza).zzd())));
                    zzadv zzadv2 = this.zza;
                    if (!zzadv2.zzp()) {
                        zzf = zzadv2.zzf();
                    } else {
                        return;
                    }
                } while (zzf == this.zzb);
                this.zzd = zzf;
            } else {
                throw zzafc.zza();
            }
        }
    }

    @Deprecated
    public final void zzC(List list, zzags zzags, zzaef zzaef) throws IOException {
        int zzf;
        int i = this.zzb;
        if ((i & 7) == 3) {
            do {
                Object zze = zzags.zze();
                zzP(zze, zzags, zzaef);
                zzags.zzf(zze);
                list.add(zze);
                zzadv zzadv = this.zza;
                if (!zzadv.zzp() && this.zzd == 0) {
                    zzf = zzadv.zzf();
                } else {
                    return;
                }
            } while (zzf == i);
            this.zzd = zzf;
            return;
        }
        throw zzafc.zza();
    }

    public final void zzD(List list) throws IOException {
        int zzf;
        int zzf2;
        if (list instanceof zzaeu) {
            zzaeu zzaeu = (zzaeu) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzaeu.zzg(((zzadt) this.zza).zze());
                    zzadv zzadv = this.zza;
                    if (!zzadv.zzp()) {
                        zzf2 = zzadv.zzf();
                    } else {
                        return;
                    }
                } while (zzf2 == this.zzb);
                this.zzd = zzf2;
            } else if (i == 2) {
                int zzb2 = this.zza.zzb() + ((zzadt) this.zza).zze();
                do {
                    zzaeu.zzg(((zzadt) this.zza).zze());
                } while (this.zza.zzb() < zzb2);
                zzR(zzb2);
            } else {
                throw zzafc.zza();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(((zzadt) this.zza).zze()));
                    zzadv zzadv2 = this.zza;
                    if (!zzadv2.zzp()) {
                        zzf = zzadv2.zzf();
                    } else {
                        return;
                    }
                } while (zzf == this.zzb);
                this.zzd = zzf;
            } else if (i2 == 2) {
                int zzb3 = this.zza.zzb() + ((zzadt) this.zza).zze();
                do {
                    list.add(Integer.valueOf(((zzadt) this.zza).zze()));
                } while (this.zza.zzb() < zzb3);
                zzR(zzb3);
            } else {
                throw zzafc.zza();
            }
        }
    }

    public final void zzE(List list) throws IOException {
        int zzf;
        int zzf2;
        if (list instanceof zzafo) {
            zzafo zzafo = (zzafo) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzafo.zzf(((zzadt) this.zza).zzh());
                    zzadv zzadv = this.zza;
                    if (!zzadv.zzp()) {
                        zzf2 = zzadv.zzf();
                    } else {
                        return;
                    }
                } while (zzf2 == this.zzb);
                this.zzd = zzf2;
            } else if (i == 2) {
                int zzb2 = this.zza.zzb() + ((zzadt) this.zza).zze();
                do {
                    zzafo.zzf(((zzadt) this.zza).zzh());
                } while (this.zza.zzb() < zzb2);
                zzR(zzb2);
            } else {
                throw zzafc.zza();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(((zzadt) this.zza).zzh()));
                    zzadv zzadv2 = this.zza;
                    if (!zzadv2.zzp()) {
                        zzf = zzadv2.zzf();
                    } else {
                        return;
                    }
                } while (zzf == this.zzb);
                this.zzd = zzf;
            } else if (i2 == 2) {
                int zzb3 = this.zza.zzb() + ((zzadt) this.zza).zze();
                do {
                    list.add(Long.valueOf(((zzadt) this.zza).zzh()));
                } while (this.zza.zzb() < zzb3);
                zzR(zzb3);
            } else {
                throw zzafc.zza();
            }
        }
    }

    public final void zzF(List list, zzags zzags, zzaef zzaef) throws IOException {
        int zzf;
        int i = this.zzb;
        if ((i & 7) == 2) {
            do {
                Object zze = zzags.zze();
                zzQ(zze, zzags, zzaef);
                zzags.zzf(zze);
                list.add(zze);
                zzadv zzadv = this.zza;
                if (!zzadv.zzp() && this.zzd == 0) {
                    zzf = zzadv.zzf();
                } else {
                    return;
                }
            } while (zzf == i);
            this.zzd = zzf;
            return;
        }
        throw zzafc.zza();
    }

    public final void zzG(List list) throws IOException {
        int zzf;
        int zzf2;
        if (list instanceof zzaeu) {
            zzaeu zzaeu = (zzaeu) list;
            int i = this.zzb & 7;
            if (i == 2) {
                int zze = ((zzadt) this.zza).zze();
                zzT(zze);
                int zzb2 = this.zza.zzb() + zze;
                do {
                    zzaeu.zzg(((zzadt) this.zza).zzd());
                } while (this.zza.zzb() < zzb2);
            } else if (i == 5) {
                do {
                    zzaeu.zzg(((zzadt) this.zza).zzd());
                    zzadv zzadv = this.zza;
                    if (!zzadv.zzp()) {
                        zzf2 = zzadv.zzf();
                    } else {
                        return;
                    }
                } while (zzf2 == this.zzb);
                this.zzd = zzf2;
            } else {
                throw zzafc.zza();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 2) {
                int zze2 = ((zzadt) this.zza).zze();
                zzT(zze2);
                int zzb3 = this.zza.zzb() + zze2;
                do {
                    list.add(Integer.valueOf(((zzadt) this.zza).zzd()));
                } while (this.zza.zzb() < zzb3);
            } else if (i2 == 5) {
                do {
                    list.add(Integer.valueOf(((zzadt) this.zza).zzd()));
                    zzadv zzadv2 = this.zza;
                    if (!zzadv2.zzp()) {
                        zzf = zzadv2.zzf();
                    } else {
                        return;
                    }
                } while (zzf == this.zzb);
                this.zzd = zzf;
            } else {
                throw zzafc.zza();
            }
        }
    }

    public final void zzH(List list) throws IOException {
        int zzf;
        int zzf2;
        if (list instanceof zzafo) {
            zzafo zzafo = (zzafo) list;
            int i = this.zzb & 7;
            if (i == 1) {
                do {
                    zzafo.zzf(((zzadt) this.zza).zzg());
                    zzadv zzadv = this.zza;
                    if (!zzadv.zzp()) {
                        zzf2 = zzadv.zzf();
                    } else {
                        return;
                    }
                } while (zzf2 == this.zzb);
                this.zzd = zzf2;
            } else if (i == 2) {
                int zze = ((zzadt) this.zza).zze();
                zzU(zze);
                int zzb2 = this.zza.zzb() + zze;
                do {
                    zzafo.zzf(((zzadt) this.zza).zzg());
                } while (this.zza.zzb() < zzb2);
            } else {
                throw zzafc.zza();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 1) {
                do {
                    list.add(Long.valueOf(((zzadt) this.zza).zzg()));
                    zzadv zzadv2 = this.zza;
                    if (!zzadv2.zzp()) {
                        zzf = zzadv2.zzf();
                    } else {
                        return;
                    }
                } while (zzf == this.zzb);
                this.zzd = zzf;
            } else if (i2 == 2) {
                int zze2 = ((zzadt) this.zza).zze();
                zzU(zze2);
                int zzb3 = this.zza.zzb() + zze2;
                do {
                    list.add(Long.valueOf(((zzadt) this.zza).zzg()));
                } while (this.zza.zzb() < zzb3);
            } else {
                throw zzafc.zza();
            }
        }
    }

    public final void zzI(List list) throws IOException {
        int zzf;
        int zzf2;
        if (list instanceof zzaeu) {
            zzaeu zzaeu = (zzaeu) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzaeu.zzg(zzadt.zzs(((zzadt) this.zza).zze()));
                    zzadv zzadv = this.zza;
                    if (!zzadv.zzp()) {
                        zzf2 = zzadv.zzf();
                    } else {
                        return;
                    }
                } while (zzf2 == this.zzb);
                this.zzd = zzf2;
            } else if (i == 2) {
                int zzb2 = this.zza.zzb() + ((zzadt) this.zza).zze();
                do {
                    zzaeu.zzg(zzadt.zzs(((zzadt) this.zza).zze()));
                } while (this.zza.zzb() < zzb2);
                zzR(zzb2);
            } else {
                throw zzafc.zza();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(zzadt.zzs(((zzadt) this.zza).zze())));
                    zzadv zzadv2 = this.zza;
                    if (!zzadv2.zzp()) {
                        zzf = zzadv2.zzf();
                    } else {
                        return;
                    }
                } while (zzf == this.zzb);
                this.zzd = zzf;
            } else if (i2 == 2) {
                int zzb3 = this.zza.zzb() + ((zzadt) this.zza).zze();
                do {
                    list.add(Integer.valueOf(zzadt.zzs(((zzadt) this.zza).zze())));
                } while (this.zza.zzb() < zzb3);
                zzR(zzb3);
            } else {
                throw zzafc.zza();
            }
        }
    }

    public final void zzJ(List list) throws IOException {
        int zzf;
        int zzf2;
        if (list instanceof zzafo) {
            zzafo zzafo = (zzafo) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzafo.zzf(zzadt.zzt(((zzadt) this.zza).zzh()));
                    zzadv zzadv = this.zza;
                    if (!zzadv.zzp()) {
                        zzf2 = zzadv.zzf();
                    } else {
                        return;
                    }
                } while (zzf2 == this.zzb);
                this.zzd = zzf2;
            } else if (i == 2) {
                int zzb2 = this.zza.zzb() + ((zzadt) this.zza).zze();
                do {
                    zzafo.zzf(zzadt.zzt(((zzadt) this.zza).zzh()));
                } while (this.zza.zzb() < zzb2);
                zzR(zzb2);
            } else {
                throw zzafc.zza();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(zzadt.zzt(((zzadt) this.zza).zzh())));
                    zzadv zzadv2 = this.zza;
                    if (!zzadv2.zzp()) {
                        zzf = zzadv2.zzf();
                    } else {
                        return;
                    }
                } while (zzf == this.zzb);
                this.zzd = zzf;
            } else if (i2 == 2) {
                int zzb3 = this.zza.zzb() + ((zzadt) this.zza).zze();
                do {
                    list.add(Long.valueOf(zzadt.zzt(((zzadt) this.zza).zzh())));
                } while (this.zza.zzb() < zzb3);
                zzR(zzb3);
            } else {
                throw zzafc.zza();
            }
        }
    }

    public final void zzK(List list, boolean z) throws IOException {
        int zzf;
        int zzf2;
        if ((this.zzb & 7) != 2) {
            throw zzafc.zza();
        } else if ((list instanceof zzafh) && !z) {
            zzafh zzafh = (zzafh) list;
            do {
                zzafh.zzi(zzp());
                zzadv zzadv = this.zza;
                if (!zzadv.zzp()) {
                    zzf2 = zzadv.zzf();
                } else {
                    return;
                }
            } while (zzf2 == this.zzb);
            this.zzd = zzf2;
        } else {
            do {
                list.add(z ? zzs() : zzr());
                zzadv zzadv2 = this.zza;
                if (!zzadv2.zzp()) {
                    zzf = zzadv2.zzf();
                } else {
                    return;
                }
            } while (zzf == this.zzb);
            this.zzd = zzf;
        }
    }

    public final void zzL(List list) throws IOException {
        int zzf;
        int zzf2;
        if (list instanceof zzaeu) {
            zzaeu zzaeu = (zzaeu) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzaeu.zzg(((zzadt) this.zza).zze());
                    zzadv zzadv = this.zza;
                    if (!zzadv.zzp()) {
                        zzf2 = zzadv.zzf();
                    } else {
                        return;
                    }
                } while (zzf2 == this.zzb);
                this.zzd = zzf2;
            } else if (i == 2) {
                int zzb2 = this.zza.zzb() + ((zzadt) this.zza).zze();
                do {
                    zzaeu.zzg(((zzadt) this.zza).zze());
                } while (this.zza.zzb() < zzb2);
                zzR(zzb2);
            } else {
                throw zzafc.zza();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(((zzadt) this.zza).zze()));
                    zzadv zzadv2 = this.zza;
                    if (!zzadv2.zzp()) {
                        zzf = zzadv2.zzf();
                    } else {
                        return;
                    }
                } while (zzf == this.zzb);
                this.zzd = zzf;
            } else if (i2 == 2) {
                int zzb3 = this.zza.zzb() + ((zzadt) this.zza).zze();
                do {
                    list.add(Integer.valueOf(((zzadt) this.zza).zze()));
                } while (this.zza.zzb() < zzb3);
                zzR(zzb3);
            } else {
                throw zzafc.zza();
            }
        }
    }

    public final void zzM(List list) throws IOException {
        int zzf;
        int zzf2;
        if (list instanceof zzafo) {
            zzafo zzafo = (zzafo) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzafo.zzf(((zzadt) this.zza).zzh());
                    zzadv zzadv = this.zza;
                    if (!zzadv.zzp()) {
                        zzf2 = zzadv.zzf();
                    } else {
                        return;
                    }
                } while (zzf2 == this.zzb);
                this.zzd = zzf2;
            } else if (i == 2) {
                int zzb2 = this.zza.zzb() + ((zzadt) this.zza).zze();
                do {
                    zzafo.zzf(((zzadt) this.zza).zzh());
                } while (this.zza.zzb() < zzb2);
                zzR(zzb2);
            } else {
                throw zzafc.zza();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(((zzadt) this.zza).zzh()));
                    zzadv zzadv2 = this.zza;
                    if (!zzadv2.zzp()) {
                        zzf = zzadv2.zzf();
                    } else {
                        return;
                    }
                } while (zzf == this.zzb);
                this.zzd = zzf;
            } else if (i2 == 2) {
                int zzb3 = this.zza.zzb() + ((zzadt) this.zza).zze();
                do {
                    list.add(Long.valueOf(((zzadt) this.zza).zzh()));
                } while (this.zza.zzb() < zzb3);
                zzR(zzb3);
            } else {
                throw zzafc.zza();
            }
        }
    }

    public final boolean zzN() throws IOException {
        zzS(0);
        return this.zza.zzq();
    }

    public final boolean zzO() throws IOException {
        int i;
        zzadv zzadv = this.zza;
        if (zzadv.zzp() || (i = this.zzb) == this.zzc) {
            return false;
        }
        return zzadv.zzr(i);
    }

    public final double zza() throws IOException {
        zzS(1);
        return Double.longBitsToDouble(((zzadt) this.zza).zzg());
    }

    public final float zzb() throws IOException {
        zzS(5);
        return Float.intBitsToFloat(((zzadt) this.zza).zzd());
    }

    public final int zzc() throws IOException {
        int i = this.zzd;
        if (i != 0) {
            this.zzb = i;
            this.zzd = 0;
        } else {
            i = this.zza.zzf();
            this.zzb = i;
        }
        if (i == 0 || i == this.zzc) {
            return Integer.MAX_VALUE;
        }
        return i >>> 3;
    }

    public final int zzd() {
        return this.zzb;
    }

    public final int zze() throws IOException {
        zzS(0);
        return ((zzadt) this.zza).zze();
    }

    public final int zzf() throws IOException {
        zzS(5);
        return ((zzadt) this.zza).zzd();
    }

    public final int zzg() throws IOException {
        zzS(0);
        return ((zzadt) this.zza).zze();
    }

    public final int zzh() throws IOException {
        zzS(5);
        return ((zzadt) this.zza).zzd();
    }

    public final int zzi() throws IOException {
        zzS(0);
        return zzadt.zzs(((zzadt) this.zza).zze());
    }

    public final int zzj() throws IOException {
        zzS(0);
        return ((zzadt) this.zza).zze();
    }

    public final long zzk() throws IOException {
        zzS(1);
        return ((zzadt) this.zza).zzg();
    }

    public final long zzl() throws IOException {
        zzS(0);
        return ((zzadt) this.zza).zzh();
    }

    public final long zzm() throws IOException {
        zzS(1);
        return ((zzadt) this.zza).zzg();
    }

    public final long zzn() throws IOException {
        zzS(0);
        return zzadt.zzt(((zzadt) this.zza).zzh());
    }

    public final long zzo() throws IOException {
        zzS(0);
        return ((zzadt) this.zza).zzh();
    }

    public final zzadr zzp() throws IOException {
        zzS(2);
        return this.zza.zzj();
    }

    public final String zzr() throws IOException {
        zzS(2);
        return this.zza.zzk();
    }

    public final String zzs() throws IOException {
        zzS(2);
        return this.zza.zzl();
    }

    public final void zzt(Object obj, zzags zzags, zzaef zzaef) throws IOException {
        zzS(3);
        zzP(obj, zzags, zzaef);
    }

    public final void zzu(Object obj, zzags zzags, zzaef zzaef) throws IOException {
        zzS(2);
        zzQ(obj, zzags, zzaef);
    }

    public final void zzv(List list) throws IOException {
        int zzf;
        int zzf2;
        if (list instanceof zzadg) {
            zzadg zzadg = (zzadg) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzadg.zze(this.zza.zzq());
                    zzadv zzadv = this.zza;
                    if (!zzadv.zzp()) {
                        zzf2 = zzadv.zzf();
                    } else {
                        return;
                    }
                } while (zzf2 == this.zzb);
                this.zzd = zzf2;
            } else if (i == 2) {
                int zzb2 = this.zza.zzb() + ((zzadt) this.zza).zze();
                do {
                    zzadg.zze(this.zza.zzq());
                } while (this.zza.zzb() < zzb2);
                zzR(zzb2);
            } else {
                throw zzafc.zza();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    list.add(Boolean.valueOf(this.zza.zzq()));
                    zzadv zzadv2 = this.zza;
                    if (!zzadv2.zzp()) {
                        zzf = zzadv2.zzf();
                    } else {
                        return;
                    }
                } while (zzf == this.zzb);
                this.zzd = zzf;
            } else if (i2 == 2) {
                int zzb3 = this.zza.zzb() + ((zzadt) this.zza).zze();
                do {
                    list.add(Boolean.valueOf(this.zza.zzq()));
                } while (this.zza.zzb() < zzb3);
                zzR(zzb3);
            } else {
                throw zzafc.zza();
            }
        }
    }

    public final void zzw(List list) throws IOException {
        int zzf;
        if ((this.zzb & 7) == 2) {
            do {
                list.add(zzp());
                zzadv zzadv = this.zza;
                if (!zzadv.zzp()) {
                    zzf = zzadv.zzf();
                } else {
                    return;
                }
            } while (zzf == this.zzb);
            this.zzd = zzf;
            return;
        }
        throw zzafc.zza();
    }

    public final void zzx(List list) throws IOException {
        int zzf;
        int zzf2;
        if (list instanceof zzaec) {
            zzaec zzaec = (zzaec) list;
            int i = this.zzb & 7;
            if (i == 1) {
                do {
                    zzaec.zze(Double.longBitsToDouble(((zzadt) this.zza).zzg()));
                    zzadv zzadv = this.zza;
                    if (!zzadv.zzp()) {
                        zzf2 = zzadv.zzf();
                    } else {
                        return;
                    }
                } while (zzf2 == this.zzb);
                this.zzd = zzf2;
            } else if (i == 2) {
                int zze = ((zzadt) this.zza).zze();
                zzU(zze);
                int zzb2 = this.zza.zzb() + zze;
                do {
                    zzaec.zze(Double.longBitsToDouble(((zzadt) this.zza).zzg()));
                } while (this.zza.zzb() < zzb2);
            } else {
                throw zzafc.zza();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 1) {
                do {
                    list.add(Double.valueOf(Double.longBitsToDouble(((zzadt) this.zza).zzg())));
                    zzadv zzadv2 = this.zza;
                    if (!zzadv2.zzp()) {
                        zzf = zzadv2.zzf();
                    } else {
                        return;
                    }
                } while (zzf == this.zzb);
                this.zzd = zzf;
            } else if (i2 == 2) {
                int zze2 = ((zzadt) this.zza).zze();
                zzU(zze2);
                int zzb3 = this.zza.zzb() + zze2;
                do {
                    list.add(Double.valueOf(Double.longBitsToDouble(((zzadt) this.zza).zzg())));
                } while (this.zza.zzb() < zzb3);
            } else {
                throw zzafc.zza();
            }
        }
    }

    public final void zzy(List list) throws IOException {
        int zzf;
        int zzf2;
        if (list instanceof zzaeu) {
            zzaeu zzaeu = (zzaeu) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzaeu.zzg(((zzadt) this.zza).zze());
                    zzadv zzadv = this.zza;
                    if (!zzadv.zzp()) {
                        zzf2 = zzadv.zzf();
                    } else {
                        return;
                    }
                } while (zzf2 == this.zzb);
                this.zzd = zzf2;
            } else if (i == 2) {
                int zzb2 = this.zza.zzb() + ((zzadt) this.zza).zze();
                do {
                    zzaeu.zzg(((zzadt) this.zza).zze());
                } while (this.zza.zzb() < zzb2);
                zzR(zzb2);
            } else {
                throw zzafc.zza();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(((zzadt) this.zza).zze()));
                    zzadv zzadv2 = this.zza;
                    if (!zzadv2.zzp()) {
                        zzf = zzadv2.zzf();
                    } else {
                        return;
                    }
                } while (zzf == this.zzb);
                this.zzd = zzf;
            } else if (i2 == 2) {
                int zzb3 = this.zza.zzb() + ((zzadt) this.zza).zze();
                do {
                    list.add(Integer.valueOf(((zzadt) this.zza).zze()));
                } while (this.zza.zzb() < zzb3);
                zzR(zzb3);
            } else {
                throw zzafc.zza();
            }
        }
    }

    public final void zzz(List list) throws IOException {
        int zzf;
        int zzf2;
        if (list instanceof zzaeu) {
            zzaeu zzaeu = (zzaeu) list;
            int i = this.zzb & 7;
            if (i == 2) {
                int zze = ((zzadt) this.zza).zze();
                zzT(zze);
                int zzb2 = this.zza.zzb() + zze;
                do {
                    zzaeu.zzg(((zzadt) this.zza).zzd());
                } while (this.zza.zzb() < zzb2);
            } else if (i == 5) {
                do {
                    zzaeu.zzg(((zzadt) this.zza).zzd());
                    zzadv zzadv = this.zza;
                    if (!zzadv.zzp()) {
                        zzf2 = zzadv.zzf();
                    } else {
                        return;
                    }
                } while (zzf2 == this.zzb);
                this.zzd = zzf2;
            } else {
                throw zzafc.zza();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 2) {
                int zze2 = ((zzadt) this.zza).zze();
                zzT(zze2);
                int zzb3 = this.zza.zzb() + zze2;
                do {
                    list.add(Integer.valueOf(((zzadt) this.zza).zzd()));
                } while (this.zza.zzb() < zzb3);
            } else if (i2 == 5) {
                do {
                    list.add(Integer.valueOf(((zzadt) this.zza).zzd()));
                    zzadv zzadv2 = this.zza;
                    if (!zzadv2.zzp()) {
                        zzf = zzadv2.zzf();
                    } else {
                        return;
                    }
                } while (zzf == this.zzb);
                this.zzd = zzf;
            } else {
                throw zzafc.zza();
            }
        }
    }
}

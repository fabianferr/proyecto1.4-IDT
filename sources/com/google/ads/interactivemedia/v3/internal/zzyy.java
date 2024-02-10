package com.google.ads.interactivemedia.v3.internal;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzyy extends AbstractMap implements Serializable {
    private static final Comparator zze = new zzyr();
    zzyx zza;
    int zzb;
    int zzc;
    final zzyx zzd;
    private final Comparator zzf;
    private final boolean zzg;
    private zzyt zzh;
    private zzyv zzi;

    public zzyy() {
        this(zze, true);
    }

    private final void zzf(zzyx zzyx, boolean z) {
        while (zzyx != null) {
            zzyx zzyx2 = zzyx.zzb;
            zzyx zzyx3 = zzyx.zzc;
            int i = 0;
            int i2 = zzyx2 != null ? zzyx2.zzi : 0;
            int i3 = zzyx3 != null ? zzyx3.zzi : 0;
            int i4 = i2 - i3;
            if (i4 == -2) {
                zzyx zzyx4 = zzyx3.zzb;
                zzyx zzyx5 = zzyx3.zzc;
                int i5 = zzyx5 != null ? zzyx5.zzi : 0;
                if (zzyx4 != null) {
                    i = zzyx4.zzi;
                }
                int i6 = i - i5;
                if (i6 == -1 || (i6 == 0 && !z)) {
                    zzh(zzyx);
                } else {
                    zzi(zzyx3);
                    zzh(zzyx);
                }
                if (z) {
                    return;
                }
            } else if (i4 == 2) {
                zzyx zzyx6 = zzyx2.zzb;
                zzyx zzyx7 = zzyx2.zzc;
                int i7 = zzyx7 != null ? zzyx7.zzi : 0;
                if (zzyx6 != null) {
                    i = zzyx6.zzi;
                }
                int i8 = i - i7;
                if (i8 == 1 || (i8 == 0 && !z)) {
                    zzi(zzyx);
                } else {
                    zzh(zzyx2);
                    zzi(zzyx);
                }
                if (z) {
                    return;
                }
            } else if (i4 == 0) {
                zzyx.zzi = i2 + 1;
                if (z) {
                    return;
                }
            } else {
                zzyx.zzi = Math.max(i2, i3) + 1;
                if (!z) {
                    return;
                }
            }
            zzyx = zzyx.zza;
        }
    }

    private final void zzg(zzyx zzyx, zzyx zzyx2) {
        zzyx zzyx3 = zzyx.zza;
        zzyx.zza = null;
        if (zzyx2 != null) {
            zzyx2.zza = zzyx3;
        }
        if (zzyx3 == null) {
            this.zza = zzyx2;
        } else if (zzyx3.zzb == zzyx) {
            zzyx3.zzb = zzyx2;
        } else {
            zzyx3.zzc = zzyx2;
        }
    }

    private final void zzh(zzyx zzyx) {
        zzyx zzyx2 = zzyx.zzb;
        zzyx zzyx3 = zzyx.zzc;
        zzyx zzyx4 = zzyx3.zzb;
        zzyx zzyx5 = zzyx3.zzc;
        zzyx.zzc = zzyx4;
        if (zzyx4 != null) {
            zzyx4.zza = zzyx;
        }
        zzg(zzyx, zzyx3);
        zzyx3.zzb = zzyx;
        zzyx.zza = zzyx3;
        int i = 0;
        int max = Math.max(zzyx2 != null ? zzyx2.zzi : 0, zzyx4 != null ? zzyx4.zzi : 0) + 1;
        zzyx.zzi = max;
        if (zzyx5 != null) {
            i = zzyx5.zzi;
        }
        zzyx3.zzi = Math.max(max, i) + 1;
    }

    private final void zzi(zzyx zzyx) {
        zzyx zzyx2 = zzyx.zzb;
        zzyx zzyx3 = zzyx.zzc;
        zzyx zzyx4 = zzyx2.zzb;
        zzyx zzyx5 = zzyx2.zzc;
        zzyx.zzb = zzyx5;
        if (zzyx5 != null) {
            zzyx5.zza = zzyx;
        }
        zzg(zzyx, zzyx2);
        zzyx2.zzc = zzyx;
        zzyx.zza = zzyx2;
        int i = 0;
        int max = Math.max(zzyx3 != null ? zzyx3.zzi : 0, zzyx5 != null ? zzyx5.zzi : 0) + 1;
        zzyx.zzi = max;
        if (zzyx4 != null) {
            i = zzyx4.zzi;
        }
        zzyx2.zzi = Math.max(max, i) + 1;
    }

    public final void clear() {
        this.zza = null;
        this.zzb = 0;
        this.zzc++;
        zzyx zzyx = this.zzd;
        zzyx.zze = zzyx;
        zzyx.zzd = zzyx;
    }

    public final boolean containsKey(Object obj) {
        return zzc(obj) != null;
    }

    public final Set entrySet() {
        zzyt zzyt = this.zzh;
        if (zzyt != null) {
            return zzyt;
        }
        zzyt zzyt2 = new zzyt(this);
        this.zzh = zzyt2;
        return zzyt2;
    }

    public final Object get(Object obj) {
        zzyx zzc2 = zzc(obj);
        if (zzc2 != null) {
            return zzc2.zzh;
        }
        return null;
    }

    public final Set keySet() {
        zzyv zzyv = this.zzi;
        if (zzyv != null) {
            return zzyv;
        }
        zzyv zzyv2 = new zzyv(this);
        this.zzi = zzyv2;
        return zzyv2;
    }

    public final Object put(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException("key == null");
        } else if (obj2 != null || this.zzg) {
            zzyx zza2 = zza(obj, true);
            Object obj3 = zza2.zzh;
            zza2.zzh = obj2;
            return obj3;
        } else {
            throw new NullPointerException("value == null");
        }
    }

    public final Object remove(Object obj) {
        zzyx zzd2 = zzd(obj);
        if (zzd2 != null) {
            return zzd2.zzh;
        }
        return null;
    }

    public final int size() {
        return this.zzb;
    }

    /* access modifiers changed from: package-private */
    public final zzyx zza(Object obj, boolean z) {
        int i;
        zzyx zzyx;
        Comparator comparator = this.zzf;
        zzyx zzyx2 = this.zza;
        if (zzyx2 != null) {
            Comparable comparable = comparator == zze ? (Comparable) obj : null;
            while (true) {
                if (comparable != null) {
                    i = comparable.compareTo(zzyx2.zzf);
                } else {
                    i = comparator.compare(obj, zzyx2.zzf);
                }
                if (i == 0) {
                    return zzyx2;
                }
                zzyx zzyx3 = i < 0 ? zzyx2.zzb : zzyx2.zzc;
                if (zzyx3 == null) {
                    break;
                }
                zzyx2 = zzyx3;
            }
        } else {
            i = 0;
        }
        if (!z) {
            return null;
        }
        zzyx zzyx4 = this.zzd;
        if (zzyx2 != null) {
            zzyx = new zzyx(this.zzg, zzyx2, obj, zzyx4, zzyx4.zze);
            if (i < 0) {
                zzyx2.zzb = zzyx;
            } else {
                zzyx2.zzc = zzyx;
            }
            zzf(zzyx2, true);
        } else if (comparator != zze || (obj instanceof Comparable)) {
            zzyx = new zzyx(this.zzg, (zzyx) null, obj, zzyx4, zzyx4.zze);
            this.zza = zzyx;
        } else {
            throw new ClassCastException(String.valueOf(obj.getClass().getName()).concat(" is not Comparable"));
        }
        this.zzb++;
        this.zzc++;
        return zzyx;
    }

    /* access modifiers changed from: package-private */
    public final zzyx zzb(Map.Entry entry) {
        zzyx zzc2 = zzc(entry.getKey());
        if (zzc2 == null) {
            return null;
        }
        Object obj = zzc2.zzh;
        Object value = entry.getValue();
        if (obj == value || (obj != null && obj.equals(value))) {
            return zzc2;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final zzyx zzc(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return zza(obj, false);
        } catch (ClassCastException unused) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final zzyx zzd(Object obj) {
        zzyx zzc2 = zzc(obj);
        if (zzc2 != null) {
            zze(zzc2, true);
        }
        return zzc2;
    }

    /* access modifiers changed from: package-private */
    public final void zze(zzyx zzyx, boolean z) {
        zzyx zzyx2;
        int i;
        zzyx zzyx3;
        if (z) {
            zzyx zzyx4 = zzyx.zze;
            zzyx4.zzd = zzyx.zzd;
            zzyx.zzd.zze = zzyx4;
        }
        zzyx zzyx5 = zzyx.zzb;
        zzyx zzyx6 = zzyx.zzc;
        zzyx zzyx7 = zzyx.zza;
        int i2 = 0;
        if (zzyx5 == null || zzyx6 == null) {
            if (zzyx5 != null) {
                zzg(zzyx, zzyx5);
                zzyx.zzb = null;
            } else if (zzyx6 != null) {
                zzg(zzyx, zzyx6);
                zzyx.zzc = null;
            } else {
                zzg(zzyx, (zzyx) null);
            }
            zzf(zzyx7, false);
            this.zzb--;
            this.zzc++;
            return;
        }
        if (zzyx5.zzi > zzyx6.zzi) {
            do {
                zzyx2 = zzyx5;
                zzyx5 = zzyx5.zzc;
            } while (zzyx5 != null);
        } else {
            do {
                zzyx zzyx8 = zzyx6;
                zzyx6 = zzyx6.zzb;
                zzyx3 = zzyx8;
            } while (zzyx6 != null);
            zzyx2 = zzyx3;
        }
        zze(zzyx2, false);
        zzyx zzyx9 = zzyx.zzb;
        if (zzyx9 != null) {
            i = zzyx9.zzi;
            zzyx2.zzb = zzyx9;
            zzyx9.zza = zzyx2;
            zzyx.zzb = null;
        } else {
            i = 0;
        }
        zzyx zzyx10 = zzyx.zzc;
        if (zzyx10 != null) {
            i2 = zzyx10.zzi;
            zzyx2.zzc = zzyx10;
            zzyx10.zza = zzyx2;
            zzyx.zzc = null;
        }
        zzyx2.zzi = Math.max(i, i2) + 1;
        zzg(zzyx, zzyx2);
    }

    public zzyy(Comparator comparator, boolean z) {
        this.zzb = 0;
        this.zzc = 0;
        this.zzf = comparator;
        this.zzg = z;
        this.zzd = new zzyx(z);
    }

    public zzyy(boolean z) {
        this(zze, false);
    }
}

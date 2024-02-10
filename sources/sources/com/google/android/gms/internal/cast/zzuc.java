package com.google.android.gms.internal.cast;

import java.io.IOException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
final class zzuc {
    public static final /* synthetic */ int zza = 0;
    private static final Class zzb;
    private static final zzur zzc = zzW(false);
    private static final zzur zzd = zzW(true);
    private static final zzur zze = new zzut();

    static {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        zzb = cls;
    }

    public static zzur zzA() {
        return zze;
    }

    static void zzB(zzur zzur, Object obj, Object obj2) {
        zzur.zzf(obj, zzur.zzd(zzur.zzc(obj), zzur.zzc(obj2)));
    }

    public static void zzC(Class cls) {
        Class cls2;
        if (!zzsh.class.isAssignableFrom(cls) && (cls2 = zzb) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void zzD(int i, List list, zzvi zzvi, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzvi.zzc(i, list, z);
        }
    }

    public static void zzE(int i, List list, zzvi zzvi) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzvi.zze(i, list);
        }
    }

    public static void zzF(int i, List list, zzvi zzvi, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzvi.zzg(i, list, z);
        }
    }

    public static void zzG(int i, List list, zzvi zzvi, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzvi.zzi(i, list, z);
        }
    }

    public static void zzH(int i, List list, zzvi zzvi, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzvi.zzk(i, list, z);
        }
    }

    public static void zzI(int i, List list, zzvi zzvi, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzvi.zzm(i, list, z);
        }
    }

    public static void zzJ(int i, List list, zzvi zzvi, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzvi.zzo(i, list, z);
        }
    }

    public static void zzK(int i, List list, zzvi zzvi, zzua zzua) throws IOException {
        if (list != null && !list.isEmpty()) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                ((zzrv) zzvi).zzp(i, list.get(i2), zzua);
            }
        }
    }

    public static void zzL(int i, List list, zzvi zzvi, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzvi.zzr(i, list, z);
        }
    }

    public static void zzM(int i, List list, zzvi zzvi, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzvi.zzt(i, list, z);
        }
    }

    public static void zzN(int i, List list, zzvi zzvi, zzua zzua) throws IOException {
        if (list != null && !list.isEmpty()) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                ((zzrv) zzvi).zzu(i, list.get(i2), zzua);
            }
        }
    }

    public static void zzO(int i, List list, zzvi zzvi, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzvi.zzw(i, list, z);
        }
    }

    public static void zzP(int i, List list, zzvi zzvi, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzvi.zzy(i, list, z);
        }
    }

    public static void zzQ(int i, List list, zzvi zzvi, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzvi.zzA(i, list, z);
        }
    }

    public static void zzR(int i, List list, zzvi zzvi, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzvi.zzC(i, list, z);
        }
    }

    public static void zzS(int i, List list, zzvi zzvi) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzvi.zzE(i, list);
        }
    }

    public static void zzT(int i, List list, zzvi zzvi, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzvi.zzG(i, list, z);
        }
    }

    public static void zzU(int i, List list, zzvi zzvi, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzvi.zzI(i, list, z);
        }
    }

    static boolean zzV(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    private static zzur zzW(boolean z) {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            cls = null;
        }
        if (cls == null) {
            return null;
        }
        try {
            return (zzur) cls.getConstructor(new Class[]{Boolean.TYPE}).newInstance(new Object[]{Boolean.valueOf(z)});
        } catch (Throwable unused2) {
            return null;
        }
    }

    static int zza(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzru.zzx(i << 3) + 1);
    }

    static int zzb(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzx = size * zzru.zzx(i << 3);
        for (int i2 = 0; i2 < list.size(); i2++) {
            int zzd2 = ((zzrm) list.get(i2)).zzd();
            zzx += zzru.zzx(zzd2) + zzd2;
        }
        return zzx;
    }

    static int zzc(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzd(list) + (size * zzru.zzx(i << 3));
    }

    static int zzd(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzsi) {
            zzsi zzsi = (zzsi) list;
            i = 0;
            while (i2 < size) {
                i += zzru.zzu(zzsi.zzd(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzru.zzu(((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zze(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzru.zzx(i << 3) + 4);
    }

    static int zzf(List list) {
        return list.size() * 4;
    }

    static int zzg(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzru.zzx(i << 3) + 8);
    }

    static int zzh(List list) {
        return list.size() * 8;
    }

    static int zzi(int i, List list, zzua zzua) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += zzru.zzt(i, (zztp) list.get(i3), zzua);
        }
        return i2;
    }

    static int zzj(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzk(list) + (size * zzru.zzx(i << 3));
    }

    static int zzk(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzsi) {
            zzsi zzsi = (zzsi) list;
            i = 0;
            while (i2 < size) {
                i += zzru.zzu(zzsi.zzd(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzru.zzu(((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzl(int i, List list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return zzm(list) + (list.size() * zzru.zzx(i << 3));
    }

    static int zzm(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzte) {
            zzte zzte = (zzte) list;
            i = 0;
            while (i2 < size) {
                i += zzru.zzy(zzte.zzd(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzru.zzy(((Long) list.get(i2)).longValue());
                i2++;
            }
        }
        return i;
    }

    static int zzn(int i, Object obj, zzua zzua) {
        if (obj instanceof zzsv) {
            int i2 = zzru.zzb;
            int zza2 = ((zzsv) obj).zza();
            return zzru.zzx(i << 3) + zzru.zzx(zza2) + zza2;
        }
        return zzru.zzx(i << 3) + zzru.zzv((zztp) obj, zzua);
    }

    static int zzo(int i, List list, zzua zzua) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzx = zzru.zzx(i << 3) * size;
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = list.get(i2);
            if (obj instanceof zzsv) {
                int zza2 = ((zzsv) obj).zza();
                zzx += zzru.zzx(zza2) + zza2;
            } else {
                zzx += zzru.zzv((zztp) obj, zzua);
            }
        }
        return zzx;
    }

    static int zzp(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzq(list) + (size * zzru.zzx(i << 3));
    }

    static int zzq(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzsi) {
            zzsi zzsi = (zzsi) list;
            i = 0;
            while (i2 < size) {
                int zzd2 = zzsi.zzd(i2);
                i += zzru.zzx((zzd2 >> 31) ^ (zzd2 + zzd2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                int intValue = ((Integer) list.get(i2)).intValue();
                i3 = i + zzru.zzx((intValue >> 31) ^ (intValue + intValue));
                i2++;
            }
        }
        return i;
    }

    static int zzr(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzs(list) + (size * zzru.zzx(i << 3));
    }

    static int zzs(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzte) {
            zzte zzte = (zzte) list;
            i = 0;
            while (i2 < size) {
                long zzd2 = zzte.zzd(i2);
                i += zzru.zzy((zzd2 >> 63) ^ (zzd2 + zzd2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                long longValue = ((Long) list.get(i2)).longValue();
                i3 = i + zzru.zzy((longValue >> 63) ^ (longValue + longValue));
                i2++;
            }
        }
        return i;
    }

    static int zzt(int i, List list) {
        int zzw;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        int i3 = zzru.zzb;
        boolean z = list instanceof zzsx;
        int zzx = zzru.zzx(i << 3) * size;
        if (z) {
            zzsx zzsx = (zzsx) list;
            while (i2 < size) {
                Object zze2 = zzsx.zze(i2);
                if (zze2 instanceof zzrm) {
                    int zzd2 = ((zzrm) zze2).zzd();
                    zzx += zzru.zzx(zzd2) + zzd2;
                } else {
                    zzx += zzru.zzw((String) zze2);
                }
                i2++;
            }
        } else {
            while (i2 < size) {
                Object obj = list.get(i2);
                if (obj instanceof zzrm) {
                    int zzd3 = ((zzrm) obj).zzd();
                    zzw = zzx + zzru.zzx(zzd3) + zzd3;
                } else {
                    zzw = zzx + zzru.zzw((String) obj);
                }
                i2++;
            }
        }
        return zzx;
    }

    static int zzu(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzv(list) + (size * zzru.zzx(i << 3));
    }

    static int zzv(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzsi) {
            zzsi zzsi = (zzsi) list;
            i = 0;
            while (i2 < size) {
                i += zzru.zzx(zzsi.zzd(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzru.zzx(((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzw(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzx(list) + (size * zzru.zzx(i << 3));
    }

    static int zzx(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzte) {
            zzte zzte = (zzte) list;
            i = 0;
            while (i2 < size) {
                i += zzru.zzy(zzte.zzd(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzru.zzy(((Long) list.get(i2)).longValue());
                i2++;
            }
        }
        return i;
    }

    public static zzur zzy() {
        return zzc;
    }

    public static zzur zzz() {
        return zzd;
    }
}

package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.1.1 */
final class zzly {
    private static final Class zza;
    private static final zzmn zzb = zzab(false);
    private static final zzmn zzc = zzab(true);
    private static final zzmn zzd = new zzmp();

    static {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        zza = cls;
    }

    public static zzmn zzA() {
        return zzc;
    }

    public static zzmn zzB() {
        return zzd;
    }

    static Object zzC(int i, List list, zzki zzki, Object obj, zzmn zzmn) {
        if (zzki == null) {
            return obj;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int intValue = ((Integer) list.get(i3)).intValue();
                if (zzki.zza(intValue)) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(intValue));
                    }
                    i2++;
                } else {
                    obj = zzD(i, intValue, obj, zzmn);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
                return obj;
            }
        } else {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = ((Integer) it.next()).intValue();
                if (!zzki.zza(intValue2)) {
                    obj = zzD(i, intValue2, obj, zzmn);
                    it.remove();
                }
            }
        }
        return obj;
    }

    static Object zzD(int i, int i2, Object obj, zzmn zzmn) {
        if (obj == null) {
            obj = zzmn.zze();
        }
        zzmn.zzf(obj, i, (long) i2);
        return obj;
    }

    static void zzE(zzjr zzjr, Object obj, Object obj2) {
        zzjr.zza(obj2);
        throw null;
    }

    static void zzF(zzmn zzmn, Object obj, Object obj2) {
        zzmn.zzh(obj, zzmn.zzd(zzmn.zzc(obj), zzmn.zzc(obj2)));
    }

    public static void zzG(Class cls) {
        Class cls2;
        if (!zzke.class.isAssignableFrom(cls) && (cls2 = zza) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void zzH(int i, List list, zznf zznf, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zznf.zzc(i, list, z);
        }
    }

    public static void zzI(int i, List list, zznf zznf) throws IOException {
        if (list != null && !list.isEmpty()) {
            zznf.zze(i, list);
        }
    }

    public static void zzJ(int i, List list, zznf zznf, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zznf.zzg(i, list, z);
        }
    }

    public static void zzK(int i, List list, zznf zznf, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zznf.zzj(i, list, z);
        }
    }

    public static void zzL(int i, List list, zznf zznf, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zznf.zzl(i, list, z);
        }
    }

    public static void zzM(int i, List list, zznf zznf, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zznf.zzn(i, list, z);
        }
    }

    public static void zzN(int i, List list, zznf zznf, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zznf.zzp(i, list, z);
        }
    }

    public static void zzO(int i, List list, zznf zznf, zzlw zzlw) throws IOException {
        if (list != null && !list.isEmpty()) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                ((zzjm) zznf).zzq(i, list.get(i2), zzlw);
            }
        }
    }

    public static void zzP(int i, List list, zznf zznf, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zznf.zzs(i, list, z);
        }
    }

    public static void zzQ(int i, List list, zznf zznf, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zznf.zzu(i, list, z);
        }
    }

    public static void zzR(int i, List list, zznf zznf, zzlw zzlw) throws IOException {
        if (list != null && !list.isEmpty()) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                ((zzjm) zznf).zzv(i, list.get(i2), zzlw);
            }
        }
    }

    public static void zzS(int i, List list, zznf zznf, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zznf.zzx(i, list, z);
        }
    }

    public static void zzT(int i, List list, zznf zznf, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zznf.zzz(i, list, z);
        }
    }

    public static void zzU(int i, List list, zznf zznf, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zznf.zzB(i, list, z);
        }
    }

    public static void zzV(int i, List list, zznf zznf, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zznf.zzD(i, list, z);
        }
    }

    public static void zzW(int i, List list, zznf zznf) throws IOException {
        if (list != null && !list.isEmpty()) {
            zznf.zzG(i, list);
        }
    }

    public static void zzX(int i, List list, zznf zznf, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zznf.zzI(i, list, z);
        }
    }

    public static void zzY(int i, List list, zznf zznf, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zznf.zzK(i, list, z);
        }
    }

    static boolean zzZ(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    static int zza(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzjl.zzA(i << 3) + 1);
    }

    static void zzaa(zzlg zzlg, Object obj, Object obj2, long j) {
        zzmx.zzs(obj, j, zzlg.zzb(zzmx.zzf(obj, j), zzmx.zzf(obj2, j)));
    }

    private static zzmn zzab(boolean z) {
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
            return (zzmn) cls.getConstructor(new Class[]{Boolean.TYPE}).newInstance(new Object[]{Boolean.valueOf(z)});
        } catch (Throwable unused2) {
            return null;
        }
    }

    static int zzb(List list) {
        return list.size();
    }

    static int zzc(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzz = size * zzjl.zzz(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzz += zzjl.zzt((zzjd) list.get(i2));
        }
        return zzz;
    }

    static int zzd(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zze(list) + (size * zzjl.zzz(i));
    }

    static int zze(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzkf) {
            zzkf zzkf = (zzkf) list;
            i = 0;
            while (i2 < size) {
                i += zzjl.zzv(zzkf.zze(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzjl.zzv(((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzf(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzjl.zzA(i << 3) + 4);
    }

    static int zzg(List list) {
        return list.size() * 4;
    }

    static int zzh(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzjl.zzA(i << 3) + 8);
    }

    static int zzi(List list) {
        return list.size() * 8;
    }

    static int zzj(int i, List list, zzlw zzlw) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += zzjl.zzu(i, (zzll) list.get(i3), zzlw);
        }
        return i2;
    }

    static int zzk(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzl(list) + (size * zzjl.zzz(i));
    }

    static int zzl(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzkf) {
            zzkf zzkf = (zzkf) list;
            i = 0;
            while (i2 < size) {
                i += zzjl.zzv(zzkf.zze(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzjl.zzv(((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzm(int i, List list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return zzn(list) + (list.size() * zzjl.zzz(i));
    }

    static int zzn(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzla) {
            zzla zzla = (zzla) list;
            i = 0;
            while (i2 < size) {
                i += zzjl.zzB(zzla.zza(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzjl.zzB(((Long) list.get(i2)).longValue());
                i2++;
            }
        }
        return i;
    }

    static int zzo(int i, Object obj, zzlw zzlw) {
        if (!(obj instanceof zzkr)) {
            return zzjl.zzA(i << 3) + zzjl.zzx((zzll) obj, zzlw);
        }
        int zzA = zzjl.zzA(i << 3);
        int zza2 = ((zzkr) obj).zza();
        return zzA + zzjl.zzA(zza2) + zza2;
    }

    static int zzp(int i, List list, zzlw zzlw) {
        int i2;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzz = zzjl.zzz(i) * size;
        for (int i3 = 0; i3 < size; i3++) {
            Object obj = list.get(i3);
            if (obj instanceof zzkr) {
                i2 = zzjl.zzw((zzkr) obj);
            } else {
                i2 = zzjl.zzx((zzll) obj, zzlw);
            }
            zzz += i2;
        }
        return zzz;
    }

    static int zzq(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzr(list) + (size * zzjl.zzz(i));
    }

    static int zzr(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzkf) {
            zzkf zzkf = (zzkf) list;
            i = 0;
            while (i2 < size) {
                int zze = zzkf.zze(i2);
                i += zzjl.zzA((zze >> 31) ^ (zze + zze));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                int intValue = ((Integer) list.get(i2)).intValue();
                i3 = i + zzjl.zzA((intValue >> 31) ^ (intValue + intValue));
                i2++;
            }
        }
        return i;
    }

    static int zzs(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzt(list) + (size * zzjl.zzz(i));
    }

    static int zzt(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzla) {
            zzla zzla = (zzla) list;
            i = 0;
            while (i2 < size) {
                long zza2 = zzla.zza(i2);
                i += zzjl.zzB((zza2 >> 63) ^ (zza2 + zza2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                long longValue = ((Long) list.get(i2)).longValue();
                i3 = i + zzjl.zzB((longValue >> 63) ^ (longValue + longValue));
                i2++;
            }
        }
        return i;
    }

    static int zzu(int i, List list) {
        int i2;
        int i3;
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        int zzz = zzjl.zzz(i) * size;
        if (list instanceof zzkt) {
            zzkt zzkt = (zzkt) list;
            while (i4 < size) {
                Object zzf = zzkt.zzf(i4);
                if (zzf instanceof zzjd) {
                    i3 = zzjl.zzt((zzjd) zzf);
                } else {
                    i3 = zzjl.zzy((String) zzf);
                }
                zzz += i3;
                i4++;
            }
        } else {
            while (i4 < size) {
                Object obj = list.get(i4);
                if (obj instanceof zzjd) {
                    i2 = zzjl.zzt((zzjd) obj);
                } else {
                    i2 = zzjl.zzy((String) obj);
                }
                zzz += i2;
                i4++;
            }
        }
        return zzz;
    }

    static int zzv(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzw(list) + (size * zzjl.zzz(i));
    }

    static int zzw(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzkf) {
            zzkf zzkf = (zzkf) list;
            i = 0;
            while (i2 < size) {
                i += zzjl.zzA(zzkf.zze(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzjl.zzA(((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzx(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzy(list) + (size * zzjl.zzz(i));
    }

    static int zzy(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzla) {
            zzla zzla = (zzla) list;
            i = 0;
            while (i2 < size) {
                i += zzjl.zzB(zzla.zza(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzjl.zzB(((Long) list.get(i2)).longValue());
                i2++;
            }
        }
        return i;
    }

    public static zzmn zzz() {
        return zzb;
    }
}

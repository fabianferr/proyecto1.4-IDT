package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzagu {
    public static final /* synthetic */ int zza = 0;
    private static final Class zzb;
    private static final zzahj zzc = zzY(false);
    private static final zzahj zzd = zzY(true);
    private static final zzahj zze = new zzahl();

    static {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        zzb = cls;
    }

    public static zzahj zzA() {
        return zze;
    }

    static Object zzB(Object obj, int i, List list, zzaex zzaex, Object obj2, zzahj zzahj) {
        if (zzaex == null) {
            return obj2;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int intValue = ((Integer) list.get(i3)).intValue();
                if (zzaex.zza(intValue)) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(intValue));
                    }
                    i2++;
                } else {
                    obj2 = zzC(obj, i, intValue, obj2, zzahj);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
                return obj2;
            }
        } else {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = ((Integer) it.next()).intValue();
                if (!zzaex.zza(intValue2)) {
                    obj2 = zzC(obj, i, intValue2, obj2, zzahj);
                    it.remove();
                }
            }
        }
        return obj2;
    }

    static Object zzC(Object obj, int i, int i2, Object obj2, zzahj zzahj) {
        if (obj2 == null) {
            obj2 = zzahj.zzc(obj);
        }
        zzahj.zzl(obj2, i, (long) i2);
        return obj2;
    }

    static void zzD(zzahj zzahj, Object obj, Object obj2) {
        zzahj.zzo(obj, zzahj.zze(zzahj.zzd(obj), zzahj.zzd(obj2)));
    }

    public static void zzE(Class cls) {
        Class cls2;
        if (!zzaet.class.isAssignableFrom(cls) && (cls2 = zzb) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void zzF(int i, List list, zzaib zzaib, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzaib.zzc(i, list, z);
        }
    }

    public static void zzG(int i, List list, zzaib zzaib) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzaib.zze(i, list);
        }
    }

    public static void zzH(int i, List list, zzaib zzaib, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzaib.zzg(i, list, z);
        }
    }

    public static void zzI(int i, List list, zzaib zzaib, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzaib.zzj(i, list, z);
        }
    }

    public static void zzJ(int i, List list, zzaib zzaib, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzaib.zzl(i, list, z);
        }
    }

    public static void zzK(int i, List list, zzaib zzaib, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzaib.zzn(i, list, z);
        }
    }

    public static void zzL(int i, List list, zzaib zzaib, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzaib.zzp(i, list, z);
        }
    }

    public static void zzM(int i, List list, zzaib zzaib, zzags zzags) throws IOException {
        if (list != null && !list.isEmpty()) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                ((zzaeb) zzaib).zzq(i, list.get(i2), zzags);
            }
        }
    }

    public static void zzN(int i, List list, zzaib zzaib, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzaib.zzs(i, list, z);
        }
    }

    public static void zzO(int i, List list, zzaib zzaib, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzaib.zzu(i, list, z);
        }
    }

    public static void zzP(int i, List list, zzaib zzaib, zzags zzags) throws IOException {
        if (list != null && !list.isEmpty()) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                ((zzaeb) zzaib).zzv(i, list.get(i2), zzags);
            }
        }
    }

    public static void zzQ(int i, List list, zzaib zzaib, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzaib.zzx(i, list, z);
        }
    }

    public static void zzR(int i, List list, zzaib zzaib, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzaib.zzz(i, list, z);
        }
    }

    public static void zzS(int i, List list, zzaib zzaib, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzaib.zzB(i, list, z);
        }
    }

    public static void zzT(int i, List list, zzaib zzaib, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzaib.zzD(i, list, z);
        }
    }

    public static void zzU(int i, List list, zzaib zzaib) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzaib.zzG(i, list);
        }
    }

    public static void zzV(int i, List list, zzaib zzaib, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzaib.zzI(i, list, z);
        }
    }

    public static void zzW(int i, List list, zzaib zzaib, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzaib.zzK(i, list, z);
        }
    }

    static boolean zzX(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    private static zzahj zzY(boolean z) {
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
            return (zzahj) cls.getConstructor(new Class[]{Boolean.TYPE}).newInstance(new Object[]{Boolean.valueOf(z)});
        } catch (Throwable unused2) {
            return null;
        }
    }

    static int zza(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzaea.zzx(i << 3) + 1);
    }

    static int zzb(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzx = size * zzaea.zzx(i << 3);
        for (int i2 = 0; i2 < list.size(); i2++) {
            int zzd2 = ((zzadr) list.get(i2)).zzd();
            zzx += zzaea.zzx(zzd2) + zzd2;
        }
        return zzx;
    }

    static int zzc(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzd(list) + (size * zzaea.zzx(i << 3));
    }

    static int zzd(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzaeu) {
            zzaeu zzaeu = (zzaeu) list;
            i = 0;
            while (i2 < size) {
                i += zzaea.zzu(zzaeu.zze(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzaea.zzu(((Integer) list.get(i2)).intValue());
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
        return size * (zzaea.zzx(i << 3) + 4);
    }

    static int zzf(List list) {
        return list.size() * 4;
    }

    static int zzg(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzaea.zzx(i << 3) + 8);
    }

    static int zzh(List list) {
        return list.size() * 8;
    }

    static int zzi(int i, List list, zzags zzags) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += zzaea.zzt(i, (zzafz) list.get(i3), zzags);
        }
        return i2;
    }

    static int zzj(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzk(list) + (size * zzaea.zzx(i << 3));
    }

    static int zzk(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzaeu) {
            zzaeu zzaeu = (zzaeu) list;
            i = 0;
            while (i2 < size) {
                i += zzaea.zzu(zzaeu.zze(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzaea.zzu(((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzl(int i, List list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return zzm(list) + (list.size() * zzaea.zzx(i << 3));
    }

    static int zzm(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzafo) {
            zzafo zzafo = (zzafo) list;
            i = 0;
            while (i2 < size) {
                i += zzaea.zzy(zzafo.zze(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzaea.zzy(((Long) list.get(i2)).longValue());
                i2++;
            }
        }
        return i;
    }

    static int zzn(int i, Object obj, zzags zzags) {
        if (obj instanceof zzaff) {
            int i2 = zzaea.zzb;
            int zza2 = ((zzaff) obj).zza();
            return zzaea.zzx(i << 3) + zzaea.zzx(zza2) + zza2;
        }
        return zzaea.zzx(i << 3) + zzaea.zzv((zzafz) obj, zzags);
    }

    static int zzo(int i, List list, zzags zzags) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzx = zzaea.zzx(i << 3) * size;
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = list.get(i2);
            if (obj instanceof zzaff) {
                int zza2 = ((zzaff) obj).zza();
                zzx += zzaea.zzx(zza2) + zza2;
            } else {
                zzx += zzaea.zzv((zzafz) obj, zzags);
            }
        }
        return zzx;
    }

    static int zzp(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzq(list) + (size * zzaea.zzx(i << 3));
    }

    static int zzq(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzaeu) {
            zzaeu zzaeu = (zzaeu) list;
            i = 0;
            while (i2 < size) {
                int zze2 = zzaeu.zze(i2);
                i += zzaea.zzx((zze2 >> 31) ^ (zze2 + zze2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                int intValue = ((Integer) list.get(i2)).intValue();
                i3 = i + zzaea.zzx((intValue >> 31) ^ (intValue + intValue));
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
        return zzs(list) + (size * zzaea.zzx(i << 3));
    }

    static int zzs(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzafo) {
            zzafo zzafo = (zzafo) list;
            i = 0;
            while (i2 < size) {
                long zze2 = zzafo.zze(i2);
                i += zzaea.zzy((zze2 >> 63) ^ (zze2 + zze2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                long longValue = ((Long) list.get(i2)).longValue();
                i3 = i + zzaea.zzy((longValue >> 63) ^ (longValue + longValue));
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
        int i3 = zzaea.zzb;
        boolean z = list instanceof zzafh;
        int zzx = zzaea.zzx(i << 3) * size;
        if (z) {
            zzafh zzafh = (zzafh) list;
            while (i2 < size) {
                Object zzf = zzafh.zzf(i2);
                if (zzf instanceof zzadr) {
                    int zzd2 = ((zzadr) zzf).zzd();
                    zzx += zzaea.zzx(zzd2) + zzd2;
                } else {
                    zzx += zzaea.zzw((String) zzf);
                }
                i2++;
            }
        } else {
            while (i2 < size) {
                Object obj = list.get(i2);
                if (obj instanceof zzadr) {
                    int zzd3 = ((zzadr) obj).zzd();
                    zzw = zzx + zzaea.zzx(zzd3) + zzd3;
                } else {
                    zzw = zzx + zzaea.zzw((String) obj);
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
        return zzv(list) + (size * zzaea.zzx(i << 3));
    }

    static int zzv(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzaeu) {
            zzaeu zzaeu = (zzaeu) list;
            i = 0;
            while (i2 < size) {
                i += zzaea.zzx(zzaeu.zze(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzaea.zzx(((Integer) list.get(i2)).intValue());
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
        return zzx(list) + (size * zzaea.zzx(i << 3));
    }

    static int zzx(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzafo) {
            zzafo zzafo = (zzafo) list;
            i = 0;
            while (i2 < size) {
                i += zzaea.zzy(zzafo.zze(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzaea.zzy(((Long) list.get(i2)).longValue());
                i2++;
            }
        }
        return i;
    }

    public static zzahj zzy() {
        return zzc;
    }

    public static zzahj zzz() {
        return zzd;
    }
}

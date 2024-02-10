package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzwm {
    static final zzwf zza = zzwe.IDENTITY;
    static final zzxg zzb = zzxf.DOUBLE;
    static final zzxg zzc = zzxf.LAZILY_PARSED_NUMBER;
    public static final /* synthetic */ int zzn = 0;
    final List zzd;
    final zzyn zze;
    final zzwf zzf;
    final Map zzg;
    final boolean zzh;
    final List zzi;
    final List zzj;
    final zzxg zzk;
    final zzxg zzl;
    final List zzm;
    private final ThreadLocal zzo;
    private final ConcurrentMap zzp;
    private final zzyl zzq;
    private final zzzt zzr;

    public zzwm() {
        zzyn zzyn = zzyn.zza;
        throw null;
    }

    static void zzg(double d) {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            throw new IllegalArgumentException(d + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzd);
        String obj = this.zzq.toString();
        return "{serializeNulls:false,factories:" + valueOf + ",instanceCreators:" + obj + "}";
    }

    public final zzxi zza(zzact zzact) {
        boolean z;
        zzxi zzxi = (zzxi) this.zzp.get(zzact);
        if (zzxi != null) {
            return zzxi;
        }
        Map map = (Map) this.zzo.get();
        if (map == null) {
            map = new HashMap();
            this.zzo.set(map);
            z = true;
        } else {
            zzxi zzxi2 = (zzxi) map.get(zzact);
            if (zzxi2 != null) {
                return zzxi2;
            }
            z = false;
        }
        try {
            zzwl zzwl = new zzwl();
            map.put(zzact, zzwl);
            Iterator it = this.zzd.iterator();
            zzxi zzxi3 = null;
            while (true) {
                if (it.hasNext()) {
                    zzxi3 = ((zzxj) it.next()).zza(this, zzact);
                    if (zzxi3 != null) {
                        zzwl.zzb(zzxi3);
                        map.put(zzact, zzxi3);
                        break;
                    }
                } else {
                    break;
                }
            }
            if (z) {
                this.zzo.remove();
            }
            if (zzxi3 != null) {
                if (z) {
                    this.zzp.putAll(map);
                }
                return zzxi3;
            }
            throw new IllegalArgumentException("GSON (${project.version}) cannot handle ".concat(zzact.toString()));
        } catch (Throwable th) {
            if (z) {
                this.zzo.remove();
            }
            throw th;
        }
    }

    public final zzxi zzb(zzxj zzxj, zzact zzact) {
        if (!this.zzd.contains(zzxj)) {
            zzxj = this.zzr;
        }
        boolean z = false;
        for (zzxj zzxj2 : this.zzd) {
            if (z) {
                zzxi zza2 = zzxj2.zza(this, zzact);
                if (zza2 != null) {
                    return zza2;
                }
            } else if (zzxj2 == zzxj) {
                z = true;
            }
        }
        throw new IllegalArgumentException("GSON cannot serialize ".concat(String.valueOf(String.valueOf(zzact))));
    }

    public final zzacx zzc(Writer writer) throws IOException {
        zzacx zzacx = new zzacx(writer);
        zzacx.zzm((zzwg) null);
        zzacx.zzn(this.zzh);
        zzacx.zzo(false);
        zzacx.zzp(false);
        return zzacx;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001e, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        r3 = r7.getMessage();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0034, code lost:
        throw new java.lang.AssertionError("AssertionError (GSON ${project.version}): " + r3, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0035, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003b, code lost:
        throw new com.google.ads.interactivemedia.v3.internal.zzwz((java.lang.Throwable) r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003c, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0042, code lost:
        throw new com.google.ads.interactivemedia.v3.internal.zzwz((java.lang.Throwable) r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0046, code lost:
        r6.zzo(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x004a, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0050, code lost:
        throw new com.google.ads.interactivemedia.v3.internal.zzwz((java.lang.Throwable) r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0051, code lost:
        r6.zzo(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0054, code lost:
        throw r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0019, code lost:
        r7 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001a, code lost:
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001c, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x001e A[ExcHandler: AssertionError (r7v5 'e' java.lang.AssertionError A[CUSTOM_DECLARE]), Splitter:B:1:0x000a] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0035 A[Catch:{ EOFException -> 0x0019, IllegalStateException -> 0x003c, IOException -> 0x0035, AssertionError -> 0x001e, all -> 0x001c }, ExcHandler: IOException (r7v4 'e' java.io.IOException A[CUSTOM_DECLARE, Catch:{  }]), Splitter:B:1:0x000a] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x003c A[Catch:{ EOFException -> 0x0019, IllegalStateException -> 0x003c, IOException -> 0x0035, AssertionError -> 0x001e, all -> 0x001c }, ExcHandler: IllegalStateException (r7v3 'e' java.lang.IllegalStateException A[CUSTOM_DECLARE, Catch:{  }]), Splitter:B:1:0x000a] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004b A[SYNTHETIC, Splitter:B:24:0x004b] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object zzd(com.google.ads.interactivemedia.v3.internal.zzacv r6, com.google.ads.interactivemedia.v3.internal.zzact r7) throws com.google.ads.interactivemedia.v3.internal.zzws, com.google.ads.interactivemedia.v3.internal.zzwz {
        /*
            r5 = this;
            java.lang.String r0 = "AssertionError (GSON ${project.version}): "
            boolean r1 = r6.zzr()
            r2 = 1
            r6.zzo(r2)
            r6.zzt()     // Catch:{ EOFException -> 0x0043, IllegalStateException -> 0x003c, IOException -> 0x0035, AssertionError -> 0x001e }
            com.google.ads.interactivemedia.v3.internal.zzxi r7 = r5.zza(r7)     // Catch:{ EOFException -> 0x0019, IllegalStateException -> 0x003c, IOException -> 0x0035, AssertionError -> 0x001e }
            java.lang.Object r7 = r7.read(r6)     // Catch:{ EOFException -> 0x0019, IllegalStateException -> 0x003c, IOException -> 0x0035, AssertionError -> 0x001e }
            r6.zzo(r1)
            return r7
        L_0x0019:
            r7 = move-exception
            r2 = 0
            goto L_0x0044
        L_0x001c:
            r7 = move-exception
            goto L_0x0051
        L_0x001e:
            r7 = move-exception
            java.lang.AssertionError r2 = new java.lang.AssertionError     // Catch:{ all -> 0x001c }
            java.lang.String r3 = r7.getMessage()     // Catch:{ all -> 0x001c }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x001c }
            r4.<init>(r0)     // Catch:{ all -> 0x001c }
            r4.append(r3)     // Catch:{ all -> 0x001c }
            java.lang.String r0 = r4.toString()     // Catch:{ all -> 0x001c }
            r2.<init>(r0, r7)     // Catch:{ all -> 0x001c }
            throw r2     // Catch:{ all -> 0x001c }
        L_0x0035:
            r7 = move-exception
            com.google.ads.interactivemedia.v3.internal.zzwz r0 = new com.google.ads.interactivemedia.v3.internal.zzwz     // Catch:{ all -> 0x001c }
            r0.<init>((java.lang.Throwable) r7)     // Catch:{ all -> 0x001c }
            throw r0     // Catch:{ all -> 0x001c }
        L_0x003c:
            r7 = move-exception
            com.google.ads.interactivemedia.v3.internal.zzwz r0 = new com.google.ads.interactivemedia.v3.internal.zzwz     // Catch:{ all -> 0x001c }
            r0.<init>((java.lang.Throwable) r7)     // Catch:{ all -> 0x001c }
            throw r0     // Catch:{ all -> 0x001c }
        L_0x0043:
            r7 = move-exception
        L_0x0044:
            if (r2 == 0) goto L_0x004b
            r6.zzo(r1)
            r6 = 0
            return r6
        L_0x004b:
            com.google.ads.interactivemedia.v3.internal.zzwz r0 = new com.google.ads.interactivemedia.v3.internal.zzwz     // Catch:{ all -> 0x001c }
            r0.<init>((java.lang.Throwable) r7)     // Catch:{ all -> 0x001c }
            throw r0     // Catch:{ all -> 0x001c }
        L_0x0051:
            r6.zzo(r1)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.zzwm.zzd(com.google.ads.interactivemedia.v3.internal.zzacv, com.google.ads.interactivemedia.v3.internal.zzact):java.lang.Object");
    }

    public final Object zze(String str, Class cls) throws zzwz {
        Object obj;
        zzact zza2 = zzact.zza(cls);
        if (str == null) {
            obj = null;
        } else {
            zzacv zzacv = new zzacv(new StringReader(str));
            zzacv.zzo(false);
            Object zzd2 = zzd(zzacv, zza2);
            if (zzd2 != null) {
                try {
                    if (zzacv.zzt() != 10) {
                        throw new zzwz("JSON document was not fully consumed.");
                    }
                } catch (zzacy e) {
                    throw new zzwz((Throwable) e);
                } catch (IOException e2) {
                    throw new zzws((Throwable) e2);
                }
            }
            obj = zzd2;
        }
        if (cls == Integer.TYPE) {
            cls = Integer.class;
        } else if (cls == Float.TYPE) {
            cls = Float.class;
        } else if (cls == Byte.TYPE) {
            cls = Byte.class;
        } else if (cls == Double.TYPE) {
            cls = Double.class;
        } else if (cls == Long.TYPE) {
            cls = Long.class;
        } else if (cls == Character.TYPE) {
            cls = Character.class;
        } else if (cls == Boolean.TYPE) {
            cls = Boolean.class;
        } else if (cls == Short.TYPE) {
            cls = Short.class;
        } else if (cls == Void.TYPE) {
            cls = Void.class;
        }
        return cls.cast(obj);
    }

    public final String zzf(Object obj) {
        if (obj == null) {
            zzwt zzwt = zzwt.zza;
            StringWriter stringWriter = new StringWriter();
            try {
                zzh(zzwt, zzc(stringWriter));
                return stringWriter.toString();
            } catch (IOException e) {
                throw new zzws((Throwable) e);
            }
        } else {
            StringWriter stringWriter2 = new StringWriter();
            try {
                zzi(obj, obj.getClass(), zzc(stringWriter2));
                return stringWriter2.toString();
            } catch (IOException e2) {
                throw new zzws((Throwable) e2);
            }
        }
    }

    public final void zzh(zzwr zzwr, zzacx zzacx) throws zzws {
        boolean zzs = zzacx.zzs();
        zzacx.zzo(true);
        boolean zzr2 = zzacx.zzr();
        zzacx.zzn(this.zzh);
        boolean zzq2 = zzacx.zzq();
        zzacx.zzp(false);
        try {
            zzaby.zzV.write(zzacx, zzwr);
            zzacx.zzo(zzs);
            zzacx.zzn(zzr2);
            zzacx.zzp(zzq2);
        } catch (IOException e) {
            throw new zzws((Throwable) e);
        } catch (AssertionError e2) {
            String message = e2.getMessage();
            throw new AssertionError("AssertionError (GSON ${project.version}): " + message, e2);
        } catch (Throwable th) {
            zzacx.zzo(zzs);
            zzacx.zzn(zzr2);
            zzacx.zzp(zzq2);
            throw th;
        }
    }

    public final void zzi(Object obj, Type type, zzacx zzacx) throws zzws {
        zzxi zza2 = zza(zzact.zzb(type));
        boolean zzs = zzacx.zzs();
        zzacx.zzo(true);
        boolean zzr2 = zzacx.zzr();
        zzacx.zzn(this.zzh);
        boolean zzq2 = zzacx.zzq();
        zzacx.zzp(false);
        try {
            zza2.write(zzacx, obj);
            zzacx.zzo(zzs);
            zzacx.zzn(zzr2);
            zzacx.zzp(zzq2);
        } catch (IOException e) {
            throw new zzws((Throwable) e);
        } catch (AssertionError e2) {
            String message = e2.getMessage();
            throw new AssertionError("AssertionError (GSON ${project.version}): " + message, e2);
        } catch (Throwable th) {
            zzacx.zzo(zzs);
            zzacx.zzn(zzr2);
            zzacx.zzp(zzq2);
            throw th;
        }
    }

    zzwm(zzyn zzyn, zzwf zzwf, Map map, boolean z, boolean z2, boolean z3, boolean z4, zzwg zzwg, boolean z5, boolean z6, boolean z7, int i, String str, int i2, int i3, List list, List list2, List list3, zzxg zzxg, zzxg zzxg2, List list4) {
        List list5 = list4;
        this.zzo = new ThreadLocal();
        this.zzp = new ConcurrentHashMap();
        this.zze = zzyn;
        this.zzf = zzwf;
        this.zzg = map;
        zzyl zzyl = new zzyl(map, true, list5);
        this.zzq = zzyl;
        this.zzh = true;
        this.zzi = list;
        this.zzj = list2;
        this.zzk = zzxg;
        this.zzl = zzxg2;
        this.zzm = list5;
        ArrayList arrayList = new ArrayList();
        arrayList.add(zzaby.zzW);
        arrayList.add(zzaaa.zza(zzxg));
        arrayList.add(zzyn);
        arrayList.addAll(list3);
        arrayList.add(zzaby.zzC);
        arrayList.add(zzaby.zzm);
        arrayList.add(zzaby.zzg);
        arrayList.add(zzaby.zzi);
        arrayList.add(zzaby.zzk);
        zzxi zzxi = zzaby.zzt;
        arrayList.add(zzaby.zzc(Long.TYPE, Long.class, zzxi));
        arrayList.add(zzaby.zzc(Double.TYPE, Double.class, new zzwh(this)));
        arrayList.add(zzaby.zzc(Float.TYPE, Float.class, new zzwi(this)));
        arrayList.add(zzzx.zza(zzxg2));
        arrayList.add(zzaby.zzo);
        arrayList.add(zzaby.zzq);
        arrayList.add(zzaby.zzb(AtomicLong.class, new zzwj(zzxi).nullSafe()));
        arrayList.add(zzaby.zzb(AtomicLongArray.class, new zzwk(zzxi).nullSafe()));
        arrayList.add(zzaby.zzs);
        arrayList.add(zzaby.zzx);
        arrayList.add(zzaby.zzE);
        arrayList.add(zzaby.zzG);
        arrayList.add(zzaby.zzb(BigDecimal.class, zzaby.zzz));
        arrayList.add(zzaby.zzb(BigInteger.class, zzaby.zzA));
        arrayList.add(zzaby.zzb(zzyq.class, zzaby.zzB));
        arrayList.add(zzaby.zzI);
        arrayList.add(zzaby.zzK);
        arrayList.add(zzaby.zzO);
        arrayList.add(zzaby.zzQ);
        arrayList.add(zzaby.zzU);
        arrayList.add(zzaby.zzM);
        arrayList.add(zzaby.zzd);
        arrayList.add(zzzq.zza);
        arrayList.add(zzaby.zzS);
        if (zzacs.zza) {
            arrayList.add(zzacs.zze);
            arrayList.add(zzacs.zzd);
            arrayList.add(zzacs.zzf);
        }
        arrayList.add(zzzm.zza);
        arrayList.add(zzaby.zzb);
        arrayList.add(new zzzo(zzyl));
        arrayList.add(new zzzv(zzyl, false));
        zzzt zzzt = new zzzt(zzyl);
        this.zzr = zzzt;
        arrayList.add(zzzt);
        arrayList.add(zzaby.zzX);
        arrayList.add(new zzaag(zzyl, zzwf, zzyn, zzzt, list4));
        this.zzd = Collections.unmodifiableList(arrayList);
    }
}

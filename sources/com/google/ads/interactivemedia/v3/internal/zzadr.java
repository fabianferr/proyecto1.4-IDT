package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import org.slf4j.Marker;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public abstract class zzadr implements Iterable, Serializable {
    private static final Comparator zza = new zzadj();
    public static final zzadr zzb = new zzado(zzafa.zzd);
    private static final zzadq zzd = new zzadq((zzadp) null);
    private int zzc = 0;

    static {
        int i = zzadd.zza;
    }

    zzadr() {
    }

    public static zzadr zzs(byte[] bArr, int i, int i2) {
        zzp(i, i + i2, bArr.length);
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return new zzado(bArr2);
    }

    public static zzadr zzt(InputStream inputStream) throws IOException {
        zzadr zzadr;
        ArrayList arrayList = new ArrayList();
        int i = 256;
        while (true) {
            byte[] bArr = new byte[i];
            int i2 = 0;
            while (i2 < i) {
                int read = inputStream.read(bArr, i2, i - i2);
                if (read == -1) {
                    break;
                }
                i2 += read;
            }
            if (i2 == 0) {
                zzadr = null;
            } else {
                zzadr = zzs(bArr, 0, i2);
            }
            if (zzadr == null) {
                break;
            }
            arrayList.add(zzadr);
            i = Math.min(i + i, 8192);
        }
        int size = arrayList.size();
        if (size == 0) {
            return zzb;
        }
        return zzc(arrayList.iterator(), size);
    }

    static void zzv(int i, int i2) {
        if (((i2 - (i + 1)) | i) >= 0) {
            return;
        }
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException("Index < 0: " + i);
        }
        throw new ArrayIndexOutOfBoundsException("Index > length: " + i + ", " + i2);
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int i = this.zzc;
        if (i == 0) {
            int zzd2 = zzd();
            i = zzi(zzd2, 0, zzd2);
            if (i == 0) {
                i = 1;
            }
            this.zzc = i;
        }
        return i;
    }

    public final String toString() {
        Locale locale = Locale.ROOT;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.toHexString(System.identityHashCode(this));
        objArr[1] = Integer.valueOf(zzd());
        objArr[2] = zzd() <= 50 ? zzahh.zza(this) : zzahh.zza(zzk(0, 47)).concat("...");
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", objArr);
    }

    public abstract byte zza(int i);

    /* access modifiers changed from: package-private */
    public abstract byte zzb(int i);

    public abstract int zzd();

    /* access modifiers changed from: protected */
    public abstract void zze(byte[] bArr, int i, int i2, int i3);

    /* access modifiers changed from: protected */
    public abstract int zzf();

    /* access modifiers changed from: protected */
    public abstract boolean zzh();

    /* access modifiers changed from: protected */
    public abstract int zzi(int i, int i2, int i3);

    /* access modifiers changed from: protected */
    public abstract int zzj(int i, int i2, int i3);

    public abstract zzadr zzk(int i, int i2);

    public abstract zzadv zzl();

    /* access modifiers changed from: protected */
    public abstract String zzm(Charset charset);

    /* access modifiers changed from: package-private */
    public abstract void zzn(zzadh zzadh) throws IOException;

    public abstract boolean zzo();

    /* access modifiers changed from: protected */
    public final int zzq() {
        return this.zzc;
    }

    /* renamed from: zzr */
    public zzadm iterator() {
        return new zzadi(this);
    }

    public final String zzu(Charset charset) {
        return zzd() == 0 ? "" : zzm(charset);
    }

    @Deprecated
    public final void zzw(byte[] bArr, int i, int i2, int i3) {
        zzp(0, i3, zzd());
        zzp(i2, i2 + i3, bArr.length);
        if (i3 > 0) {
            zze(bArr, 0, i2, i3);
        }
    }

    public final byte[] zzx() {
        int zzd2 = zzd();
        if (zzd2 == 0) {
            return zzafa.zzd;
        }
        byte[] bArr = new byte[zzd2];
        zze(bArr, 0, 0, zzd2);
        return bArr;
    }

    private static zzadr zzc(Iterator it, int i) {
        if (i <= 0) {
            throw new IllegalArgumentException(String.format("length (%s) must be >= 1", new Object[]{Integer.valueOf(i)}));
        } else if (i == 1) {
            return (zzadr) it.next();
        } else {
            int i2 = i >>> 1;
            zzadr zzc2 = zzc(it, i2);
            zzadr zzc3 = zzc(it, i - i2);
            if (Integer.MAX_VALUE - zzc2.zzd() >= zzc3.zzd()) {
                return zzagr.zzz(zzc2, zzc3);
            }
            int zzd2 = zzc2.zzd();
            int zzd3 = zzc3.zzd();
            throw new IllegalArgumentException("ByteString would be too long: " + zzd2 + Marker.ANY_NON_NULL_MARKER + zzd3);
        }
    }

    static int zzp(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i < 0) {
            throw new IndexOutOfBoundsException("Beginning index: " + i + " < 0");
        } else if (i2 < i) {
            throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + i + ", " + i2);
        } else {
            throw new IndexOutOfBoundsException("End index: " + i2 + " >= " + i3);
        }
    }
}

package com.google.ads.interactivemedia.v3.internal;

import com.facebook.internal.ServerProtocol;
import com.facebook.internal.security.CertificateUtil;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Pattern;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzacx implements Closeable, Flushable {
    private static final Pattern zza = Pattern.compile("-?(?:0|[1-9][0-9]*)(?:\\.[0-9]+)?(?:[eE][-+]?[0-9]+)?");
    private static final String[] zzb = new String[128];
    private static final String[] zzc;
    private final Writer zzd;
    private int[] zze = new int[32];
    private int zzf = 0;
    private String zzg;
    private boolean zzh;
    private boolean zzi;
    private String zzj;
    private boolean zzk;

    static {
        for (int i = 0; i <= 31; i++) {
            zzb[i] = String.format("\\u%04x", new Object[]{Integer.valueOf(i)});
        }
        String[] strArr = zzb;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        zzc = strArr2;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public zzacx(Writer writer) {
        zzx(6);
        this.zzg = CertificateUtil.DELIMITER;
        this.zzk = true;
        this.zzd = writer;
    }

    private final void zzA() throws IOException {
        if (this.zzj != null) {
            int zzt = zzt();
            if (zzt == 5) {
                this.zzd.write(44);
            } else if (zzt != 3) {
                throw new IllegalStateException("Nesting problem.");
            }
            zzy(4);
            zzz(this.zzj);
            this.zzj = null;
        }
    }

    private final int zzt() {
        int i = this.zzf;
        if (i != 0) {
            return this.zze[i - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    private final zzacx zzu(int i, int i2, char c) throws IOException {
        int zzt = zzt();
        if (zzt == i2 || zzt == i) {
            String str = this.zzj;
            if (str == null) {
                this.zzf--;
                this.zzd.write(c);
                return this;
            }
            throw new IllegalStateException("Dangling name: ".concat(str));
        }
        throw new IllegalStateException("Nesting problem.");
    }

    private final zzacx zzv(int i, char c) throws IOException {
        zzw();
        zzx(i);
        this.zzd.write(c);
        return this;
    }

    private final void zzw() throws IOException {
        int zzt = zzt();
        if (zzt == 1) {
            zzy(2);
        } else if (zzt == 2) {
            this.zzd.append(AbstractJsonLexerKt.COMMA);
        } else if (zzt != 4) {
            if (zzt != 6) {
                if (zzt != 7) {
                    throw new IllegalStateException("Nesting problem.");
                } else if (!this.zzh) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
            }
            zzy(7);
        } else {
            this.zzd.append(this.zzg);
            zzy(5);
        }
    }

    private final void zzx(int i) {
        int i2 = this.zzf;
        int[] iArr = this.zze;
        if (i2 == iArr.length) {
            this.zze = Arrays.copyOf(iArr, i2 + i2);
        }
        int[] iArr2 = this.zze;
        int i3 = this.zzf;
        this.zzf = i3 + 1;
        iArr2[i3] = i;
    }

    private final void zzy(int i) {
        this.zze[this.zzf - 1] = i;
    }

    private final void zzz(String str) throws IOException {
        String[] strArr;
        String str2;
        if (this.zzi) {
            strArr = zzc;
        } else {
            strArr = zzb;
        }
        this.zzd.write(34);
        int length = str.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (charAt < 128) {
                str2 = strArr[charAt];
                if (str2 == null) {
                }
            } else if (charAt == 8232) {
                str2 = "\\u2028";
            } else if (charAt == 8233) {
                str2 = "\\u2029";
            }
            if (i < i2) {
                this.zzd.write(str, i, i2 - i);
            }
            this.zzd.write(str2);
            i = i2 + 1;
        }
        if (i < length) {
            this.zzd.write(str, i, length - i);
        }
        this.zzd.write(34);
    }

    public final void close() throws IOException {
        this.zzd.close();
        int i = this.zzf;
        if (i > 1 || (i == 1 && this.zze[0] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.zzf = 0;
    }

    public final void flush() throws IOException {
        if (this.zzf != 0) {
            this.zzd.flush();
            return;
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    public final zzacx zza() throws IOException {
        zzA();
        zzv(1, AbstractJsonLexerKt.BEGIN_LIST);
        return this;
    }

    public final zzacx zzb() throws IOException {
        zzA();
        zzv(3, AbstractJsonLexerKt.BEGIN_OBJ);
        return this;
    }

    public final zzacx zzc() throws IOException {
        zzu(1, 2, AbstractJsonLexerKt.END_LIST);
        return this;
    }

    public final zzacx zzd() throws IOException {
        zzu(3, 5, AbstractJsonLexerKt.END_OBJ);
        return this;
    }

    public final zzacx zze(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("name == null");
        } else if (this.zzj != null) {
            throw new IllegalStateException();
        } else if (this.zzf != 0) {
            this.zzj = str;
            return this;
        } else {
            throw new IllegalStateException("JsonWriter is closed.");
        }
    }

    public final zzacx zzf() throws IOException {
        if (this.zzj != null) {
            if (this.zzk) {
                zzA();
            } else {
                this.zzj = null;
                return this;
            }
        }
        zzw();
        this.zzd.write(AbstractJsonLexerKt.NULL);
        return this;
    }

    public final zzacx zzg(double d) throws IOException {
        zzA();
        if (this.zzh || (!Double.isNaN(d) && !Double.isInfinite(d))) {
            zzw();
            this.zzd.append(Double.toString(d));
            return this;
        }
        throw new IllegalArgumentException("Numeric values must be finite, but was " + d);
    }

    public final zzacx zzh(long j) throws IOException {
        zzA();
        zzw();
        this.zzd.write(Long.toString(j));
        return this;
    }

    public final zzacx zzi(Boolean bool) throws IOException {
        if (bool == null) {
            zzf();
            return this;
        }
        zzA();
        zzw();
        this.zzd.write(true != bool.booleanValue() ? "false" : ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
        return this;
    }

    public final zzacx zzj(Number number) throws IOException {
        if (number == null) {
            zzf();
            return this;
        }
        zzA();
        String obj = number.toString();
        if (!obj.equals("-Infinity") && !obj.equals("Infinity") && !obj.equals("NaN")) {
            Class<?> cls = number.getClass();
            if (!(cls == Integer.class || cls == Long.class || cls == Double.class || cls == Float.class || cls == Byte.class || cls == Short.class || cls == BigDecimal.class || cls == BigInteger.class || cls == AtomicInteger.class || cls == AtomicLong.class || zza.matcher(obj).matches())) {
                String valueOf = String.valueOf(cls);
                throw new IllegalArgumentException("String created by " + valueOf + " is not a valid JSON number: " + obj);
            }
        } else if (!this.zzh) {
            throw new IllegalArgumentException("Numeric values must be finite, but was ".concat(String.valueOf(obj)));
        }
        zzw();
        this.zzd.append(obj);
        return this;
    }

    public final zzacx zzk(String str) throws IOException {
        if (str == null) {
            zzf();
            return this;
        }
        zzA();
        zzw();
        zzz(str);
        return this;
    }

    public final zzacx zzl(boolean z) throws IOException {
        zzA();
        zzw();
        this.zzd.write(true != z ? "false" : ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
        return this;
    }

    public final void zzm(zzwg zzwg) {
        this.zzg = CertificateUtil.DELIMITER;
    }

    public final void zzn(boolean z) {
        this.zzi = z;
    }

    public final void zzo(boolean z) {
        this.zzh = z;
    }

    public final void zzp(boolean z) {
        this.zzk = z;
    }

    public final boolean zzq() {
        return this.zzk;
    }

    public final boolean zzr() {
        return this.zzi;
    }

    public final boolean zzs() {
        return this.zzh;
    }
}

package com.google.ads.interactivemedia.v3.internal;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzacv implements Closeable {
    int zza = 0;
    private final Reader zzb;
    private boolean zzc = false;
    private final char[] zzd = new char[1024];
    private int zze = 0;
    private int zzf = 0;
    private int zzg = 0;
    private int zzh = 0;
    private long zzi;
    private int zzj;
    private String zzk;
    private int[] zzl;
    private int zzm;
    private String[] zzn;
    private int[] zzo;

    static {
        zzyp.zza = new zzacu();
    }

    public zzacv(Reader reader) {
        int[] iArr = new int[32];
        this.zzl = iArr;
        this.zzm = 1;
        iArr[0] = 6;
        this.zzn = new String[32];
        this.zzo = new int[32];
        this.zzb = reader;
    }

    private final void zzA() throws IOException {
        if (!this.zzc) {
            throw zzw("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private final void zzB(int i) {
        int i2 = this.zzm;
        int[] iArr = this.zzl;
        if (i2 == iArr.length) {
            int i3 = i2 + i2;
            this.zzl = Arrays.copyOf(iArr, i3);
            this.zzo = Arrays.copyOf(this.zzo, i3);
            this.zzn = (String[]) Arrays.copyOf(this.zzn, i3);
        }
        int[] iArr2 = this.zzl;
        int i4 = this.zzm;
        this.zzm = i4 + 1;
        iArr2[i4] = i;
    }

    private final void zzC(char c) throws IOException {
        char[] cArr = this.zzd;
        do {
            int i = this.zze;
            int i2 = this.zzf;
            while (i < i2) {
                int i3 = i + 1;
                char c2 = cArr[i];
                if (c2 == c) {
                    this.zze = i3;
                    return;
                } else if (c2 == '\\') {
                    this.zze = i3;
                    zzu();
                    i = this.zze;
                    i2 = this.zzf;
                } else {
                    if (c2 == 10) {
                        this.zzg++;
                        this.zzh = i3;
                    }
                    i = i3;
                }
            }
            this.zze = i;
        } while (zzF(1));
        throw zzw("Unterminated string");
    }

    private final void zzD() throws IOException {
        char c;
        do {
            if (this.zze < this.zzf || zzF(1)) {
                char[] cArr = this.zzd;
                int i = this.zze;
                int i2 = i + 1;
                this.zze = i2;
                c = cArr[i];
                if (c == 10) {
                    this.zzg++;
                    this.zzh = i2;
                    return;
                }
            } else {
                return;
            }
        } while (c != 13);
    }

    private final void zzE() throws IOException {
        do {
            int i = 0;
            while (true) {
                int i2 = this.zze + i;
                if (i2 < this.zzf) {
                    char c = this.zzd[i2];
                    if (!(c == 9 || c == 10 || c == 12 || c == 13 || c == ' ')) {
                        if (c != '#') {
                            if (c != ',') {
                                if (!(c == '/' || c == '=')) {
                                    if (!(c == '{' || c == '}' || c == ':')) {
                                        if (c != ';') {
                                            switch (c) {
                                                case '[':
                                                case ']':
                                                    break;
                                                case '\\':
                                                    break;
                                                default:
                                                    i++;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else {
                    this.zze = i2;
                }
            }
            zzA();
            this.zze += i;
            return;
        } while (zzF(1));
    }

    private final boolean zzF(int i) throws IOException {
        int i2;
        char[] cArr = this.zzd;
        int i3 = this.zzh;
        int i4 = this.zze;
        this.zzh = i3 - i4;
        int i5 = this.zzf;
        if (i5 != i4) {
            int i6 = i5 - i4;
            this.zzf = i6;
            System.arraycopy(cArr, i4, cArr, 0, i6);
        } else {
            this.zzf = 0;
        }
        this.zze = 0;
        do {
            Reader reader = this.zzb;
            int i7 = this.zzf;
            int read = reader.read(cArr, i7, 1024 - i7);
            if (read == -1) {
                return false;
            }
            i2 = this.zzf + read;
            this.zzf = i2;
            if (this.zzg == 0 && this.zzh == 0 && i2 > 0 && cArr[0] == 65279) {
                this.zze++;
                this.zzh = 1;
                i++;
                continue;
            }
        } while (i2 < i);
        return true;
    }

    private final boolean zzG(char c) throws IOException {
        if (c == 9 || c == 10 || c == 12 || c == 13 || c == ' ') {
            return false;
        }
        if (c != '#') {
            if (c == ',') {
                return false;
            }
            if (!(c == '/' || c == '=')) {
                if (c == '{' || c == '}' || c == ':') {
                    return false;
                }
                if (c != ';') {
                    switch (c) {
                        case '[':
                        case ']':
                            return false;
                        case '\\':
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        zzA();
        return false;
    }

    private final char zzu() throws IOException {
        int i;
        if (this.zze != this.zzf || zzF(1)) {
            char[] cArr = this.zzd;
            int i2 = this.zze;
            int i3 = i2 + 1;
            this.zze = i3;
            char c = cArr[i2];
            if (c == 10) {
                this.zzg++;
                this.zzh = i3;
            } else if (!(c == '\"' || c == '\'' || c == '/' || c == '\\')) {
                if (c == 'b') {
                    return 8;
                }
                if (c == 'f') {
                    return 12;
                }
                if (c == 'n') {
                    return 10;
                }
                if (c == 'r') {
                    return 13;
                }
                if (c == 't') {
                    return 9;
                }
                if (c != 'u') {
                    throw zzw("Invalid escape sequence");
                } else if (i3 + 4 <= this.zzf || zzF(4)) {
                    int i4 = this.zze;
                    int i5 = i4 + 4;
                    char c2 = 0;
                    while (i4 < i5) {
                        char[] cArr2 = this.zzd;
                        char c3 = cArr2[i4];
                        char c4 = (char) (c2 << 4);
                        if (c3 >= '0' && c3 <= '9') {
                            i = c3 - '0';
                        } else if (c3 >= 'a' && c3 <= 'f') {
                            i = c3 - 'W';
                        } else if (c3 < 'A' || c3 > 'F') {
                            throw new NumberFormatException("\\u".concat(new String(cArr2, this.zze, 4)));
                        } else {
                            i = c3 - '7';
                        }
                        c2 = (char) (c4 + i);
                        i4++;
                    }
                    this.zze += 4;
                    return c2;
                } else {
                    throw zzw("Unterminated escape sequence");
                }
            }
            return c;
        }
        throw zzw("Unterminated escape sequence");
    }

    private final int zzv(boolean z) throws IOException {
        char[] cArr = this.zzd;
        int i = this.zze;
        int i2 = this.zzf;
        while (true) {
            if (i == i2) {
                this.zze = i;
                if (zzF(1)) {
                    i = this.zze;
                    i2 = this.zzf;
                } else if (!z) {
                    return -1;
                } else {
                    throw new EOFException("End of input".concat(zzg()));
                }
            }
            int i3 = i + 1;
            char c = cArr[i];
            if (c == 10) {
                this.zzg++;
                this.zzh = i3;
            } else if (!(c == ' ' || c == 13 || c == 9)) {
                if (c == '/') {
                    this.zze = i3;
                    if (i3 == i2) {
                        this.zze = i3 - 1;
                        boolean zzF = zzF(2);
                        this.zze++;
                        if (!zzF) {
                            return 47;
                        }
                    }
                    zzA();
                    int i4 = this.zze;
                    char c2 = cArr[i4];
                    if (c2 == '*') {
                        this.zze = i4 + 1;
                        while (true) {
                            if (this.zze + 2 <= this.zzf || zzF(2)) {
                                char[] cArr2 = this.zzd;
                                int i5 = this.zze;
                                if (cArr2[i5] != 10) {
                                    int i6 = 0;
                                    while (i6 < 2) {
                                        if (this.zzd[this.zze + i6] == "*/".charAt(i6)) {
                                            i6++;
                                        }
                                    }
                                    i = 2 + this.zze;
                                    i2 = this.zzf;
                                    break;
                                }
                                this.zzg++;
                                this.zzh = i5 + 1;
                                this.zze++;
                            } else {
                                throw zzw("Unterminated comment");
                            }
                        }
                    } else if (c2 != '/') {
                        return 47;
                    } else {
                        this.zze = i4 + 1;
                        zzD();
                        i = this.zze;
                        i2 = this.zzf;
                    }
                } else if (c == '#') {
                    this.zze = i3;
                    zzA();
                    zzD();
                    i = this.zze;
                    i2 = this.zzf;
                } else {
                    this.zze = i3;
                    return c;
                }
            }
            i = i3;
        }
    }

    private final IOException zzw(String str) throws IOException {
        throw new zzacy(str.concat(zzg()));
    }

    private final String zzx(boolean z) {
        StringBuilder sb = new StringBuilder("$");
        int i = 0;
        while (true) {
            int i2 = this.zzm;
            if (i >= i2) {
                return sb.toString();
            }
            int i3 = this.zzl[i];
            if (i3 == 1 || i3 == 2) {
                int i4 = this.zzo[i];
                if (z && i4 > 0 && i == i2 - 1) {
                    i4--;
                }
                sb.append(AbstractJsonLexerKt.BEGIN_LIST);
                sb.append(i4);
                sb.append(AbstractJsonLexerKt.END_LIST);
            } else if (i3 == 3 || i3 == 4 || i3 == 5) {
                sb.append('.');
                String str = this.zzn[i];
                if (str != null) {
                    sb.append(str);
                }
            }
            i++;
        }
    }

    private final String zzy(char c) throws IOException {
        char[] cArr = this.zzd;
        StringBuilder sb = null;
        do {
            int i = this.zze;
            int i2 = this.zzf;
            int i3 = i;
            while (i < i2) {
                int i4 = i + 1;
                char c2 = cArr[i];
                if (c2 == c) {
                    this.zze = i4;
                    int i5 = (i4 - i3) - 1;
                    if (sb == null) {
                        return new String(cArr, i3, i5);
                    }
                    sb.append(cArr, i3, i5);
                    return sb.toString();
                } else if (c2 == '\\') {
                    this.zze = i4;
                    int i6 = (i4 - i3) - 1;
                    if (sb == null) {
                        int i7 = i6 + 1;
                        sb = new StringBuilder(Math.max(i7 + i7, 16));
                    }
                    sb.append(cArr, i3, i6);
                    sb.append(zzu());
                    i3 = this.zze;
                    i2 = this.zzf;
                    i = i3;
                } else {
                    if (c2 == 10) {
                        this.zzg++;
                        this.zzh = i4;
                    }
                    i = i4;
                }
            }
            if (sb == null) {
                int i8 = i - i3;
                sb = new StringBuilder(Math.max(i8 + i8, 16));
            }
            sb.append(cArr, i3, i - i3);
            this.zze = i;
        } while (zzF(1));
        throw zzw("Unterminated string");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0048, code lost:
        zzA();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String zzz() throws java.io.IOException {
        /*
            r5 = this;
            r0 = 0
            r1 = 0
        L_0x0002:
            r2 = 0
        L_0x0003:
            int r3 = r5.zze
            int r3 = r3 + r2
            int r4 = r5.zzf
            if (r3 >= r4) goto L_0x004c
            char[] r4 = r5.zzd
            char r3 = r4[r3]
            r4 = 9
            if (r3 == r4) goto L_0x0059
            r4 = 10
            if (r3 == r4) goto L_0x0059
            r4 = 12
            if (r3 == r4) goto L_0x0059
            r4 = 13
            if (r3 == r4) goto L_0x0059
            r4 = 32
            if (r3 == r4) goto L_0x0059
            r4 = 35
            if (r3 == r4) goto L_0x0048
            r4 = 44
            if (r3 == r4) goto L_0x0059
            r4 = 47
            if (r3 == r4) goto L_0x0048
            r4 = 61
            if (r3 == r4) goto L_0x0048
            r4 = 123(0x7b, float:1.72E-43)
            if (r3 == r4) goto L_0x0059
            r4 = 125(0x7d, float:1.75E-43)
            if (r3 == r4) goto L_0x0059
            r4 = 58
            if (r3 == r4) goto L_0x0059
            r4 = 59
            if (r3 == r4) goto L_0x0048
            switch(r3) {
                case 91: goto L_0x0059;
                case 92: goto L_0x0048;
                case 93: goto L_0x0059;
                default: goto L_0x0045;
            }
        L_0x0045:
            int r2 = r2 + 1
            goto L_0x0003
        L_0x0048:
            r5.zzA()
            goto L_0x0059
        L_0x004c:
            r3 = 1024(0x400, float:1.435E-42)
            if (r2 >= r3) goto L_0x005b
            int r3 = r2 + 1
            boolean r3 = r5.zzF(r3)
            if (r3 == 0) goto L_0x0059
            goto L_0x0003
        L_0x0059:
            r0 = r2
            goto L_0x007b
        L_0x005b:
            if (r1 != 0) goto L_0x0068
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r3 = 16
            int r3 = java.lang.Math.max(r2, r3)
            r1.<init>(r3)
        L_0x0068:
            char[] r3 = r5.zzd
            int r4 = r5.zze
            r1.append(r3, r4, r2)
            int r3 = r5.zze
            int r3 = r3 + r2
            r5.zze = r3
            r2 = 1
            boolean r2 = r5.zzF(r2)
            if (r2 != 0) goto L_0x0002
        L_0x007b:
            if (r1 != 0) goto L_0x0087
            java.lang.String r1 = new java.lang.String
            char[] r2 = r5.zzd
            int r3 = r5.zze
            r1.<init>(r2, r3, r0)
            goto L_0x0092
        L_0x0087:
            char[] r2 = r5.zzd
            int r3 = r5.zze
            r1.append(r2, r3, r0)
            java.lang.String r1 = r1.toString()
        L_0x0092:
            int r2 = r5.zze
            int r2 = r2 + r0
            r5.zze = r2
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.zzacv.zzz():java.lang.String");
    }

    public final void close() throws IOException {
        this.zza = 0;
        this.zzl[0] = 8;
        this.zzm = 1;
        this.zzb.close();
    }

    public final String toString() {
        return String.valueOf(getClass().getSimpleName()).concat(zzg());
    }

    public final double zza() throws IOException {
        int i = this.zza;
        if (i == 0) {
            i = zzb();
        }
        if (i == 15) {
            this.zza = 0;
            int[] iArr = this.zzo;
            int i2 = this.zzm - 1;
            iArr[i2] = iArr[i2] + 1;
            return (double) this.zzi;
        }
        if (i == 16) {
            char[] cArr = this.zzd;
            int i3 = this.zze;
            int i4 = this.zzj;
            this.zzk = new String(cArr, i3, i4);
            this.zze = i3 + i4;
        } else if (i == 8 || i == 9) {
            this.zzk = zzy(i == 8 ? '\'' : '\"');
        } else if (i == 10) {
            this.zzk = zzz();
        } else if (i != 11) {
            throw new IllegalStateException(zzacw.zzb(this, "Expected a double but was "));
        }
        this.zza = 11;
        double parseDouble = Double.parseDouble(this.zzk);
        if (this.zzc || (!Double.isNaN(parseDouble) && !Double.isInfinite(parseDouble))) {
            this.zzk = null;
            this.zza = 0;
            int[] iArr2 = this.zzo;
            int i5 = this.zzm - 1;
            iArr2[i5] = iArr2[i5] + 1;
            return parseDouble;
        }
        throw new zzacy("JSON forbids NaN and infinities: " + parseDouble + zzg());
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x019f, code lost:
        r1 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x0220, code lost:
        if (zzG(r1) == false) goto L_0x019f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x0224, code lost:
        if (r9 != 2) goto L_0x0250;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x0226, code lost:
        if (r15 == false) goto L_0x024e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x022c, code lost:
        if (r11 != Long.MIN_VALUE) goto L_0x0231;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x022e, code lost:
        if (r16 == false) goto L_0x024e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x0231, code lost:
        r14 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x0237, code lost:
        if (r11 != 0) goto L_0x023c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x0239, code lost:
        if (r14 != false) goto L_0x024e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x023c, code lost:
        if (r14 == false) goto L_0x023f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x023f, code lost:
        r11 = -r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x0240, code lost:
        r0.zzi = r11;
        r0.zze += r10;
        r0.zza = 15;
        r14 = 15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x024e, code lost:
        r1 = 2;
        r9 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x0250, code lost:
        if (r9 == r1) goto L_0x0258;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x0253, code lost:
        if (r9 == 4) goto L_0x0258;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x0256, code lost:
        if (r9 != 7) goto L_0x0194;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x0258, code lost:
        r0.zzj = r10;
        r0.zza = 16;
        r14 = 16;
     */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x017e  */
    /* JADX WARNING: Removed duplicated region for block: B:197:0x02a3 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:214:0x02d2  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00e5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzb() throws java.io.IOException {
        /*
            r21 = this;
            r0 = r21
            int[] r1 = r0.zzl
            int r2 = r0.zzm
            r3 = -1
            int r2 = r2 + r3
            r4 = r1[r2]
            r6 = 10
            r8 = 39
            r9 = 93
            r10 = 59
            r11 = 44
            r12 = 6
            r13 = 3
            r15 = 4
            r5 = 5
            r7 = 2
            r14 = 1
            if (r4 != r14) goto L_0x0021
            r1[r2] = r7
        L_0x001e:
            r1 = 0
            goto L_0x00dd
        L_0x0021:
            if (r4 != r7) goto L_0x003b
            int r1 = r0.zzv(r14)
            if (r1 == r11) goto L_0x001e
            if (r1 == r10) goto L_0x0037
            if (r1 != r9) goto L_0x0030
            r0.zza = r15
            return r15
        L_0x0030:
            java.lang.String r1 = "Unterminated array"
            java.io.IOException r1 = r0.zzw(r1)
            throw r1
        L_0x0037:
            r21.zzA()
            goto L_0x001e
        L_0x003b:
            r7 = 125(0x7d, float:1.75E-43)
            if (r4 == r13) goto L_0x02df
            if (r4 != r5) goto L_0x0043
            goto L_0x02df
        L_0x0043:
            if (r4 != r15) goto L_0x0077
            r1[r2] = r5
            int r1 = r0.zzv(r14)
            r2 = 58
            if (r1 == r2) goto L_0x001e
            r2 = 61
            if (r1 != r2) goto L_0x0070
            r21.zzA()
            int r1 = r0.zze
            int r2 = r0.zzf
            if (r1 < r2) goto L_0x0062
            boolean r1 = r0.zzF(r14)
            if (r1 == 0) goto L_0x001e
        L_0x0062:
            char[] r1 = r0.zzd
            int r2 = r0.zze
            char r1 = r1[r2]
            r7 = 62
            if (r1 != r7) goto L_0x001e
            int r2 = r2 + r14
            r0.zze = r2
            goto L_0x001e
        L_0x0070:
            java.lang.String r1 = "Expected ':'"
            java.io.IOException r1 = r0.zzw(r1)
            throw r1
        L_0x0077:
            if (r4 != r12) goto L_0x00c0
            boolean r1 = r0.zzc
            if (r1 == 0) goto L_0x00b6
            r0.zzv(r14)
            int r1 = r0.zze
            int r1 = r1 + r3
            r0.zze = r1
            int r2 = r0.zzf
            int r1 = r1 + r5
            if (r1 <= r2) goto L_0x0091
            boolean r1 = r0.zzF(r5)
            if (r1 != 0) goto L_0x0091
            goto L_0x00b6
        L_0x0091:
            int r1 = r0.zze
            char[] r2 = r0.zzd
            char r15 = r2[r1]
            r12 = 41
            if (r15 != r12) goto L_0x00b6
            int r12 = r1 + 1
            char r12 = r2[r12]
            if (r12 != r9) goto L_0x00b6
            int r12 = r1 + 2
            char r12 = r2[r12]
            if (r12 != r7) goto L_0x00b6
            int r7 = r1 + 3
            char r7 = r2[r7]
            if (r7 != r8) goto L_0x00b6
            int r7 = r1 + 4
            char r2 = r2[r7]
            if (r2 != r6) goto L_0x00b6
            int r1 = r1 + r5
            r0.zze = r1
        L_0x00b6:
            int[] r1 = r0.zzl
            int r2 = r0.zzm
            int r2 = r2 + r3
            r7 = 7
            r1[r2] = r7
            goto L_0x001e
        L_0x00c0:
            r7 = 7
            if (r4 != r7) goto L_0x00d8
            r1 = 0
            int r2 = r0.zzv(r1)
            if (r2 != r3) goto L_0x00cf
            r1 = 17
            r0.zza = r1
            return r1
        L_0x00cf:
            r21.zzA()
            int r2 = r0.zze
            int r2 = r2 + r3
            r0.zze = r2
            goto L_0x00dd
        L_0x00d8:
            r1 = 0
            r2 = 8
            if (r4 == r2) goto L_0x02d7
        L_0x00dd:
            int r2 = r0.zzv(r14)
            r7 = 34
            if (r2 == r7) goto L_0x02d2
            if (r2 == r8) goto L_0x02ca
            if (r2 == r11) goto L_0x02b1
            if (r2 == r10) goto L_0x02b1
            r7 = 91
            if (r2 == r7) goto L_0x02ae
            if (r2 == r9) goto L_0x02a7
            r4 = 123(0x7b, float:1.72E-43)
            if (r2 == r4) goto L_0x02a4
            int r2 = r0.zze
            int r2 = r2 + r3
            r0.zze = r2
            char[] r3 = r0.zzd
            char r2 = r3[r2]
            r3 = 116(0x74, float:1.63E-43)
            if (r2 == r3) goto L_0x0124
            r3 = 84
            if (r2 != r3) goto L_0x0107
            goto L_0x0124
        L_0x0107:
            r3 = 102(0x66, float:1.43E-43)
            if (r2 == r3) goto L_0x011e
            r3 = 70
            if (r2 != r3) goto L_0x0110
            goto L_0x011e
        L_0x0110:
            r3 = 110(0x6e, float:1.54E-43)
            if (r2 == r3) goto L_0x0118
            r3 = 78
            if (r2 != r3) goto L_0x0173
        L_0x0118:
            java.lang.String r2 = "NULL"
            java.lang.String r3 = "null"
            r4 = 7
            goto L_0x0129
        L_0x011e:
            java.lang.String r2 = "FALSE"
            java.lang.String r3 = "false"
            r4 = 6
            goto L_0x0129
        L_0x0124:
            java.lang.String r2 = "TRUE"
            java.lang.String r3 = "true"
            r4 = 5
        L_0x0129:
            r7 = 1
        L_0x012a:
            int r8 = r3.length()
            if (r7 >= r8) goto L_0x0157
            int r8 = r0.zze
            int r8 = r8 + r7
            int r9 = r0.zzf
            if (r8 < r9) goto L_0x0140
            int r8 = r7 + 1
            boolean r8 = r0.zzF(r8)
            if (r8 != 0) goto L_0x0140
            goto L_0x0173
        L_0x0140:
            char[] r8 = r0.zzd
            int r9 = r0.zze
            int r9 = r9 + r7
            char r8 = r8[r9]
            char r9 = r3.charAt(r7)
            if (r8 == r9) goto L_0x0154
            char r9 = r2.charAt(r7)
            if (r8 == r9) goto L_0x0154
            goto L_0x0173
        L_0x0154:
            int r7 = r7 + 1
            goto L_0x012a
        L_0x0157:
            int r2 = r0.zze
            int r2 = r2 + r8
            int r3 = r0.zzf
            if (r2 < r3) goto L_0x0166
            int r2 = r8 + 1
            boolean r2 = r0.zzF(r2)
            if (r2 == 0) goto L_0x0175
        L_0x0166:
            char[] r2 = r0.zzd
            int r3 = r0.zze
            int r3 = r3 + r8
            char r2 = r2[r3]
            boolean r2 = r0.zzG(r2)
            if (r2 == 0) goto L_0x0175
        L_0x0173:
            r4 = 0
            goto L_0x017c
        L_0x0175:
            int r2 = r0.zze
            int r2 = r2 + r8
            r0.zze = r2
            r0.zza = r4
        L_0x017c:
            if (r4 != 0) goto L_0x02a3
            char[] r2 = r0.zzd
            int r3 = r0.zze
            int r4 = r0.zzf
            r7 = 0
            r11 = r7
            r9 = 0
            r10 = 0
            r15 = 1
            r16 = 0
        L_0x018c:
            int r1 = r3 + r10
            if (r1 != r4) goto L_0x01a8
            r1 = 1024(0x400, float:1.435E-42)
            if (r10 != r1) goto L_0x0197
        L_0x0194:
            r14 = 0
            goto L_0x0285
        L_0x0197:
            int r1 = r10 + 1
            boolean r1 = r0.zzF(r1)
            if (r1 != 0) goto L_0x01a2
        L_0x019f:
            r1 = 2
            goto L_0x0224
        L_0x01a2:
            int r1 = r0.zze
            int r3 = r0.zzf
            r4 = r3
            r3 = r1
        L_0x01a8:
            int r1 = r3 + r10
            char r1 = r2[r1]
            r6 = 43
            if (r1 == r6) goto L_0x027b
            r6 = 69
            if (r1 == r6) goto L_0x0272
            r6 = 101(0x65, float:1.42E-43)
            if (r1 == r6) goto L_0x0272
            r6 = 45
            if (r1 == r6) goto L_0x0267
            r6 = 46
            if (r1 == r6) goto L_0x0261
            r6 = 48
            if (r1 < r6) goto L_0x021c
            r6 = 57
            if (r1 <= r6) goto L_0x01c9
            goto L_0x021c
        L_0x01c9:
            if (r9 == r14) goto L_0x0212
            if (r9 != 0) goto L_0x01ce
            goto L_0x0212
        L_0x01ce:
            r6 = 2
            if (r9 != r6) goto L_0x0201
            int r6 = (r11 > r7 ? 1 : (r11 == r7 ? 0 : -1))
            if (r6 != 0) goto L_0x01d6
            goto L_0x0194
        L_0x01d6:
            r17 = 10
            long r17 = r17 * r11
            int r1 = r1 + -48
            r19 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            int r6 = (r11 > r19 ? 1 : (r11 == r19 ? 0 : -1))
            long r7 = (long) r1
            long r17 = r17 - r7
            if (r6 > 0) goto L_0x01f8
            r6 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            int r1 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1))
            if (r1 != 0) goto L_0x01f6
            int r1 = (r17 > r11 ? 1 : (r17 == r11 ? 0 : -1))
            if (r1 >= 0) goto L_0x01f6
            goto L_0x01f8
        L_0x01f6:
            r1 = 0
            goto L_0x01f9
        L_0x01f8:
            r1 = 1
        L_0x01f9:
            r15 = r15 & r1
            r11 = r17
            r6 = 6
            r7 = 0
            goto L_0x027f
        L_0x0201:
            r6 = 6
            if (r9 != r13) goto L_0x0209
            r7 = 0
            r9 = 4
            goto L_0x027f
        L_0x0209:
            r7 = 0
            if (r9 == r5) goto L_0x020f
            if (r9 != r6) goto L_0x027f
        L_0x020f:
            r9 = 7
            goto L_0x027f
        L_0x0212:
            r6 = 6
            int r1 = r1 + -48
            int r1 = -r1
            long r11 = (long) r1
            r7 = 0
            r9 = 2
            goto L_0x027f
        L_0x021c:
            boolean r1 = r0.zzG(r1)
            if (r1 == 0) goto L_0x019f
            goto L_0x0194
        L_0x0224:
            if (r9 != r1) goto L_0x0250
            if (r15 == 0) goto L_0x024e
            r1 = -9223372036854775808
            int r3 = (r11 > r1 ? 1 : (r11 == r1 ? 0 : -1))
            if (r3 != 0) goto L_0x0231
            if (r16 == 0) goto L_0x024e
            goto L_0x0233
        L_0x0231:
            r14 = r16
        L_0x0233:
            r7 = 0
            int r1 = (r11 > r7 ? 1 : (r11 == r7 ? 0 : -1))
            if (r1 != 0) goto L_0x023c
            if (r14 != 0) goto L_0x024e
            goto L_0x023f
        L_0x023c:
            if (r14 == 0) goto L_0x023f
            goto L_0x0240
        L_0x023f:
            long r11 = -r11
        L_0x0240:
            r0.zzi = r11
            int r1 = r0.zze
            int r1 = r1 + r10
            r0.zze = r1
            r1 = 15
            r0.zza = r1
            r14 = 15
            goto L_0x0285
        L_0x024e:
            r1 = 2
            r9 = 2
        L_0x0250:
            if (r9 == r1) goto L_0x0258
            r1 = 4
            if (r9 == r1) goto L_0x0258
            r1 = 7
            if (r9 != r1) goto L_0x0194
        L_0x0258:
            r0.zzj = r10
            r1 = 16
            r0.zza = r1
            r14 = 16
            goto L_0x0285
        L_0x0261:
            r1 = 2
            r6 = 6
            if (r9 != r1) goto L_0x0194
            r9 = 3
            goto L_0x027f
        L_0x0267:
            r1 = 2
            r6 = 6
            if (r9 != 0) goto L_0x026f
            r9 = 1
            r16 = 1
            goto L_0x027f
        L_0x026f:
            if (r9 != r5) goto L_0x0194
            goto L_0x027e
        L_0x0272:
            r1 = 2
            r6 = 6
            if (r9 == r1) goto L_0x0279
            r1 = 4
            if (r9 != r1) goto L_0x0194
        L_0x0279:
            r9 = 5
            goto L_0x027f
        L_0x027b:
            r6 = 6
            if (r9 != r5) goto L_0x0194
        L_0x027e:
            r9 = 6
        L_0x027f:
            int r10 = r10 + 1
            r6 = 10
            goto L_0x018c
        L_0x0285:
            if (r14 == 0) goto L_0x0288
            return r14
        L_0x0288:
            char[] r1 = r0.zzd
            int r2 = r0.zze
            char r1 = r1[r2]
            boolean r1 = r0.zzG(r1)
            if (r1 == 0) goto L_0x029c
            r21.zzA()
            r1 = 10
            r0.zza = r1
            return r1
        L_0x029c:
            java.lang.String r1 = "Expected value"
            java.io.IOException r1 = r0.zzw(r1)
            throw r1
        L_0x02a3:
            return r4
        L_0x02a4:
            r0.zza = r14
            return r14
        L_0x02a7:
            if (r4 == r14) goto L_0x02aa
            goto L_0x02b1
        L_0x02aa:
            r1 = 4
            r0.zza = r1
            return r1
        L_0x02ae:
            r0.zza = r13
            return r13
        L_0x02b1:
            if (r4 == r14) goto L_0x02be
            r1 = 2
            if (r4 != r1) goto L_0x02b7
            goto L_0x02be
        L_0x02b7:
            java.lang.String r1 = "Unexpected value"
            java.io.IOException r1 = r0.zzw(r1)
            throw r1
        L_0x02be:
            r21.zzA()
            int r1 = r0.zze
            int r1 = r1 + r3
            r0.zze = r1
            r1 = 7
            r0.zza = r1
            return r1
        L_0x02ca:
            r21.zzA()
            r1 = 8
            r0.zza = r1
            return r1
        L_0x02d2:
            r1 = 9
            r0.zza = r1
            return r1
        L_0x02d7:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "JsonReader is closed"
            r1.<init>(r2)
            throw r1
        L_0x02df:
            r6 = 4
            r1[r2] = r6
            if (r4 != r5) goto L_0x02fc
            int r1 = r0.zzv(r14)
            if (r1 == r11) goto L_0x02fc
            if (r1 == r10) goto L_0x02f9
            if (r1 != r7) goto L_0x02f2
            r1 = 2
            r0.zza = r1
            return r1
        L_0x02f2:
            java.lang.String r1 = "Unterminated object"
            java.io.IOException r1 = r0.zzw(r1)
            throw r1
        L_0x02f9:
            r21.zzA()
        L_0x02fc:
            int r1 = r0.zzv(r14)
            r2 = 34
            if (r1 == r2) goto L_0x0336
            if (r1 == r8) goto L_0x032e
            java.lang.String r2 = "Expected name"
            if (r1 == r7) goto L_0x0323
            r21.zzA()
            int r4 = r0.zze
            int r4 = r4 + r3
            r0.zze = r4
            char r1 = (char) r1
            boolean r1 = r0.zzG(r1)
            if (r1 == 0) goto L_0x031e
            r1 = 14
            r0.zza = r1
            return r1
        L_0x031e:
            java.io.IOException r1 = r0.zzw(r2)
            throw r1
        L_0x0323:
            if (r4 == r5) goto L_0x0329
            r1 = 2
            r0.zza = r1
            return r1
        L_0x0329:
            java.io.IOException r1 = r0.zzw(r2)
            throw r1
        L_0x032e:
            r21.zzA()
            r1 = 12
            r0.zza = r1
            return r1
        L_0x0336:
            r1 = 13
            r0.zza = r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.zzacv.zzb():int");
    }

    public final int zzc() throws IOException {
        int i = this.zza;
        if (i == 0) {
            i = zzb();
        }
        if (i == 15) {
            long j = this.zzi;
            int i2 = (int) j;
            if (j == ((long) i2)) {
                this.zza = 0;
                int[] iArr = this.zzo;
                int i3 = this.zzm - 1;
                iArr[i3] = iArr[i3] + 1;
                return i2;
            }
            throw new NumberFormatException("Expected an int but was " + j + zzg());
        }
        if (i == 16) {
            char[] cArr = this.zzd;
            int i4 = this.zze;
            int i5 = this.zzj;
            this.zzk = new String(cArr, i4, i5);
            this.zze = i4 + i5;
        } else if (i == 8 || i == 9 || i == 10) {
            if (i == 10) {
                this.zzk = zzz();
            } else {
                this.zzk = zzy(i == 8 ? '\'' : '\"');
            }
            try {
                int parseInt = Integer.parseInt(this.zzk);
                this.zza = 0;
                int[] iArr2 = this.zzo;
                int i6 = this.zzm - 1;
                iArr2[i6] = iArr2[i6] + 1;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        } else {
            throw new IllegalStateException(zzacw.zzb(this, "Expected an int but was "));
        }
        this.zza = 11;
        double parseDouble = Double.parseDouble(this.zzk);
        int i7 = (int) parseDouble;
        if (((double) i7) == parseDouble) {
            this.zzk = null;
            this.zza = 0;
            int[] iArr3 = this.zzo;
            int i8 = this.zzm - 1;
            iArr3[i8] = iArr3[i8] + 1;
            return i7;
        }
        throw new NumberFormatException("Expected an int but was " + this.zzk + zzg());
    }

    public final long zzd() throws IOException {
        int i = this.zza;
        if (i == 0) {
            i = zzb();
        }
        if (i == 15) {
            this.zza = 0;
            int[] iArr = this.zzo;
            int i2 = this.zzm - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.zzi;
        }
        if (i == 16) {
            char[] cArr = this.zzd;
            int i3 = this.zze;
            int i4 = this.zzj;
            this.zzk = new String(cArr, i3, i4);
            this.zze = i3 + i4;
        } else if (i == 8 || i == 9 || i == 10) {
            if (i == 10) {
                this.zzk = zzz();
            } else {
                this.zzk = zzy(i == 8 ? '\'' : '\"');
            }
            try {
                long parseLong = Long.parseLong(this.zzk);
                this.zza = 0;
                int[] iArr2 = this.zzo;
                int i5 = this.zzm - 1;
                iArr2[i5] = iArr2[i5] + 1;
                return parseLong;
            } catch (NumberFormatException unused) {
            }
        } else {
            throw new IllegalStateException(zzacw.zzb(this, "Expected a long but was "));
        }
        this.zza = 11;
        double parseDouble = Double.parseDouble(this.zzk);
        long j = (long) parseDouble;
        if (((double) j) == parseDouble) {
            this.zzk = null;
            this.zza = 0;
            int[] iArr3 = this.zzo;
            int i6 = this.zzm - 1;
            iArr3[i6] = iArr3[i6] + 1;
            return j;
        }
        throw new NumberFormatException("Expected a long but was " + this.zzk + zzg());
    }

    public final String zze() {
        return zzx(false);
    }

    public final String zzf() {
        return zzx(true);
    }

    /* access modifiers changed from: package-private */
    public final String zzg() {
        int i = this.zze - this.zzh;
        String zzx = zzx(false);
        return " at line " + (this.zzg + 1) + " column " + (i + 1) + " path " + zzx;
    }

    public final String zzh() throws IOException {
        String str;
        int i = this.zza;
        if (i == 0) {
            i = zzb();
        }
        if (i == 14) {
            str = zzz();
        } else if (i == 12) {
            str = zzy('\'');
        } else if (i == 13) {
            str = zzy('\"');
        } else {
            throw new IllegalStateException(zzacw.zzb(this, "Expected a name but was "));
        }
        this.zza = 0;
        this.zzn[this.zzm - 1] = str;
        return str;
    }

    public final String zzi() throws IOException {
        String str;
        int i = this.zza;
        if (i == 0) {
            i = zzb();
        }
        if (i == 10) {
            str = zzz();
        } else if (i == 8) {
            str = zzy('\'');
        } else if (i == 9) {
            str = zzy('\"');
        } else if (i == 11) {
            str = this.zzk;
            this.zzk = null;
        } else if (i == 15) {
            str = Long.toString(this.zzi);
        } else if (i == 16) {
            str = new String(this.zzd, this.zze, this.zzj);
            this.zze += this.zzj;
        } else {
            throw new IllegalStateException(zzacw.zzb(this, "Expected a string but was "));
        }
        this.zza = 0;
        int[] iArr = this.zzo;
        int i2 = this.zzm - 1;
        iArr[i2] = iArr[i2] + 1;
        return str;
    }

    public final void zzj() throws IOException {
        int i = this.zza;
        if (i == 0) {
            i = zzb();
        }
        if (i == 3) {
            zzB(1);
            this.zzo[this.zzm - 1] = 0;
            this.zza = 0;
            return;
        }
        throw new IllegalStateException(zzacw.zzb(this, "Expected BEGIN_ARRAY but was "));
    }

    public final void zzk() throws IOException {
        int i = this.zza;
        if (i == 0) {
            i = zzb();
        }
        if (i == 1) {
            zzB(3);
            this.zza = 0;
            return;
        }
        throw new IllegalStateException(zzacw.zzb(this, "Expected BEGIN_OBJECT but was "));
    }

    public final void zzl() throws IOException {
        int i = this.zza;
        if (i == 0) {
            i = zzb();
        }
        if (i == 4) {
            int i2 = this.zzm - 1;
            this.zzm = i2;
            int[] iArr = this.zzo;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
            this.zza = 0;
            return;
        }
        throw new IllegalStateException(zzacw.zzb(this, "Expected END_ARRAY but was "));
    }

    public final void zzm() throws IOException {
        int i = this.zza;
        if (i == 0) {
            i = zzb();
        }
        if (i == 2) {
            int i2 = this.zzm - 1;
            this.zzm = i2;
            this.zzn[i2] = null;
            int[] iArr = this.zzo;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
            this.zza = 0;
            return;
        }
        throw new IllegalStateException(zzacw.zzb(this, "Expected END_OBJECT but was "));
    }

    public final void zzn() throws IOException {
        int i = this.zza;
        if (i == 0) {
            i = zzb();
        }
        if (i == 7) {
            this.zza = 0;
            int[] iArr = this.zzo;
            int i2 = this.zzm - 1;
            iArr[i2] = iArr[i2] + 1;
            return;
        }
        throw new IllegalStateException(zzacw.zzb(this, "Expected null but was "));
    }

    public final void zzo(boolean z) {
        this.zzc = z;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0048, code lost:
        r1 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005c, code lost:
        r1 = r1 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x007a, code lost:
        r1 = r1 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x007c, code lost:
        r7.zza = 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzp() throws java.io.IOException {
        /*
            r7 = this;
            r0 = 0
            r1 = 0
        L_0x0002:
            int r2 = r7.zza
            if (r2 != 0) goto L_0x000a
            int r2 = r7.zzb()
        L_0x000a:
            r3 = 34
            r4 = 39
            java.lang.String r5 = "<skipped>"
            r6 = 1
            switch(r2) {
                case 1: goto L_0x0076;
                case 2: goto L_0x0063;
                case 3: goto L_0x005f;
                case 4: goto L_0x0056;
                case 5: goto L_0x0014;
                case 6: goto L_0x0014;
                case 7: goto L_0x0014;
                case 8: goto L_0x0052;
                case 9: goto L_0x004e;
                case 10: goto L_0x004a;
                case 11: goto L_0x0014;
                case 12: goto L_0x003b;
                case 13: goto L_0x002d;
                case 14: goto L_0x001f;
                case 15: goto L_0x0014;
                case 16: goto L_0x0017;
                case 17: goto L_0x0016;
                default: goto L_0x0014;
            }
        L_0x0014:
            goto L_0x007c
        L_0x0016:
            return
        L_0x0017:
            int r2 = r7.zze
            int r3 = r7.zzj
            int r2 = r2 + r3
            r7.zze = r2
            goto L_0x007c
        L_0x001f:
            r7.zzE()
            if (r1 != 0) goto L_0x007c
            java.lang.String[] r1 = r7.zzn
            int r2 = r7.zzm
            int r2 = r2 + -1
            r1[r2] = r5
            goto L_0x0048
        L_0x002d:
            r7.zzC(r3)
            if (r1 != 0) goto L_0x007c
            java.lang.String[] r1 = r7.zzn
            int r2 = r7.zzm
            int r2 = r2 + -1
            r1[r2] = r5
            goto L_0x0048
        L_0x003b:
            r7.zzC(r4)
            if (r1 != 0) goto L_0x007c
            java.lang.String[] r1 = r7.zzn
            int r2 = r7.zzm
            int r2 = r2 + -1
            r1[r2] = r5
        L_0x0048:
            r1 = 0
            goto L_0x007c
        L_0x004a:
            r7.zzE()
            goto L_0x007c
        L_0x004e:
            r7.zzC(r3)
            goto L_0x007c
        L_0x0052:
            r7.zzC(r4)
            goto L_0x007c
        L_0x0056:
            int r2 = r7.zzm
            int r2 = r2 + -1
            r7.zzm = r2
        L_0x005c:
            int r1 = r1 + -1
            goto L_0x007c
        L_0x005f:
            r7.zzB(r6)
            goto L_0x007a
        L_0x0063:
            if (r1 != 0) goto L_0x006f
            java.lang.String[] r1 = r7.zzn
            int r2 = r7.zzm
            int r2 = r2 + -1
            r3 = 0
            r1[r2] = r3
            r1 = 0
        L_0x006f:
            int r2 = r7.zzm
            int r2 = r2 + -1
            r7.zzm = r2
            goto L_0x005c
        L_0x0076:
            r2 = 3
            r7.zzB(r2)
        L_0x007a:
            int r1 = r1 + 1
        L_0x007c:
            r7.zza = r0
            if (r1 > 0) goto L_0x0002
            int[] r0 = r7.zzo
            int r1 = r7.zzm
            int r1 = r1 + -1
            r2 = r0[r1]
            int r2 = r2 + r6
            r0[r1] = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.zzacv.zzp():void");
    }

    public final boolean zzq() throws IOException {
        int i = this.zza;
        if (i == 0) {
            i = zzb();
        }
        return (i == 2 || i == 4 || i == 17) ? false : true;
    }

    public final boolean zzr() {
        return this.zzc;
    }

    public final boolean zzs() throws IOException {
        int i = this.zza;
        if (i == 0) {
            i = zzb();
        }
        if (i == 5) {
            this.zza = 0;
            int[] iArr = this.zzo;
            int i2 = this.zzm - 1;
            iArr[i2] = iArr[i2] + 1;
            return true;
        } else if (i == 6) {
            this.zza = 0;
            int[] iArr2 = this.zzo;
            int i3 = this.zzm - 1;
            iArr2[i3] = iArr2[i3] + 1;
            return false;
        } else {
            throw new IllegalStateException(zzacw.zzb(this, "Expected a boolean but was "));
        }
    }

    public final int zzt() throws IOException {
        int i = this.zza;
        if (i == 0) {
            i = zzb();
        }
        switch (i) {
            case 1:
                return 3;
            case 2:
                return 4;
            case 3:
                return 1;
            case 4:
                return 2;
            case 5:
            case 6:
                return 8;
            case 7:
                return 9;
            case 8:
            case 9:
            case 10:
            case 11:
                return 6;
            case 12:
            case 13:
            case 14:
                return 5;
            case 15:
            case 16:
                return 7;
            default:
                return 10;
        }
    }
}

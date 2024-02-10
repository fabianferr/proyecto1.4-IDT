package com.bykv.vk.openvk.preload.a.d;

import com.facebook.internal.ServerProtocol;
import com.facebook.internal.security.CertificateUtil;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: JsonWriter */
public class c implements Closeable, Flushable {
    private static final String[] a = new String[128];
    private static final String[] b;
    public boolean c;
    public boolean d;
    public boolean e;
    private final Writer f;
    private int[] g = new int[32];
    private int h = 0;
    private String i;
    private String j;
    private String k;

    static {
        for (int i2 = 0; i2 <= 31; i2++) {
            a[i2] = String.format("\\u%04x", new Object[]{Integer.valueOf(i2)});
        }
        String[] strArr = a;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        b = strArr2;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public c(Writer writer) {
        a(6);
        this.j = CertificateUtil.DELIMITER;
        this.e = true;
        if (writer != null) {
            this.f = writer;
            return;
        }
        throw new NullPointerException("out == null");
    }

    public final void c(String str) {
        if (str.length() == 0) {
            this.i = null;
            this.j = CertificateUtil.DELIMITER;
            return;
        }
        this.i = str;
        this.j = ": ";
    }

    public c a() throws IOException {
        g();
        return a(1, AbstractJsonLexerKt.BEGIN_LIST);
    }

    public c b() throws IOException {
        return a(1, 2, AbstractJsonLexerKt.END_LIST);
    }

    public c c() throws IOException {
        g();
        return a(3, AbstractJsonLexerKt.BEGIN_OBJ);
    }

    public c d() throws IOException {
        return a(3, 5, AbstractJsonLexerKt.END_OBJ);
    }

    private c a(int i2, char c2) throws IOException {
        j();
        a(i2);
        this.f.write(c2);
        return this;
    }

    private c a(int i2, int i3, char c2) throws IOException {
        int f2 = f();
        if (f2 != i3 && f2 != i2) {
            throw new IllegalStateException("Nesting problem.");
        } else if (this.k == null) {
            this.h--;
            if (f2 == i3) {
                h();
            }
            this.f.write(c2);
            return this;
        } else {
            throw new IllegalStateException("Dangling name: " + this.k);
        }
    }

    private void a(int i2) {
        int i3 = this.h;
        int[] iArr = this.g;
        if (i3 == iArr.length) {
            this.g = Arrays.copyOf(iArr, i3 * 2);
        }
        int[] iArr2 = this.g;
        int i4 = this.h;
        this.h = i4 + 1;
        iArr2[i4] = i2;
    }

    private int f() {
        int i2 = this.h;
        if (i2 != 0) {
            return this.g[i2 - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    private void b(int i2) {
        this.g[this.h - 1] = i2;
    }

    public c a(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("name == null");
        } else if (this.k != null) {
            throw new IllegalStateException();
        } else if (this.h != 0) {
            this.k = str;
            return this;
        } else {
            throw new IllegalStateException("JsonWriter is closed.");
        }
    }

    private void g() throws IOException {
        if (this.k != null) {
            i();
            d(this.k);
            this.k = null;
        }
    }

    public c b(String str) throws IOException {
        if (str == null) {
            return e();
        }
        g();
        j();
        d(str);
        return this;
    }

    public c e() throws IOException {
        if (this.k != null) {
            if (this.e) {
                g();
            } else {
                this.k = null;
                return this;
            }
        }
        j();
        this.f.write(AbstractJsonLexerKt.NULL);
        return this;
    }

    public c a(boolean z) throws IOException {
        g();
        j();
        this.f.write(z ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false");
        return this;
    }

    public c a(Boolean bool) throws IOException {
        if (bool == null) {
            return e();
        }
        g();
        j();
        this.f.write(bool.booleanValue() ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false");
        return this;
    }

    public c a(long j2) throws IOException {
        g();
        j();
        this.f.write(Long.toString(j2));
        return this;
    }

    public c a(Number number) throws IOException {
        if (number == null) {
            return e();
        }
        g();
        String obj = number.toString();
        if (this.c || (!obj.equals("-Infinity") && !obj.equals("Infinity") && !obj.equals("NaN"))) {
            j();
            this.f.append(obj);
            return this;
        }
        throw new IllegalArgumentException("Numeric values must be finite, but was ".concat(String.valueOf(number)));
    }

    public void flush() throws IOException {
        if (this.h != 0) {
            this.f.flush();
            return;
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    public void close() throws IOException {
        this.f.close();
        int i2 = this.h;
        if (i2 > 1 || (i2 == 1 && this.g[i2 - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.h = 0;
    }

    private void d(String str) throws IOException {
        String str2;
        String[] strArr = this.d ? b : a;
        this.f.write(34);
        int length = str.length();
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            char charAt = str.charAt(i3);
            if (charAt < 128) {
                str2 = strArr[charAt];
                if (str2 == null) {
                }
            } else if (charAt == 8232) {
                str2 = "\\u2028";
            } else if (charAt == 8233) {
                str2 = "\\u2029";
            }
            if (i2 < i3) {
                this.f.write(str, i2, i3 - i2);
            }
            this.f.write(str2);
            i2 = i3 + 1;
        }
        if (i2 < length) {
            this.f.write(str, i2, length - i2);
        }
        this.f.write(34);
    }

    private void h() throws IOException {
        if (this.i != null) {
            this.f.write(10);
            int i2 = this.h;
            for (int i3 = 1; i3 < i2; i3++) {
                this.f.write(this.i);
            }
        }
    }

    private void i() throws IOException {
        int f2 = f();
        if (f2 == 5) {
            this.f.write(44);
        } else if (f2 != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        h();
        b(4);
    }

    private void j() throws IOException {
        int f2 = f();
        if (f2 == 1) {
            b(2);
            h();
        } else if (f2 == 2) {
            this.f.append(AbstractJsonLexerKt.COMMA);
            h();
        } else if (f2 != 4) {
            if (f2 != 6) {
                if (f2 != 7) {
                    throw new IllegalStateException("Nesting problem.");
                } else if (!this.c) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
            }
            b(7);
        } else {
            this.f.append(this.j);
            b(5);
        }
    }
}

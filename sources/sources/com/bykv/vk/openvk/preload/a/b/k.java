package com.bykv.vk.openvk.preload.a.b;

import com.bykv.vk.openvk.preload.a.b.a.n;
import com.bykv.vk.openvk.preload.a.d.c;
import java.io.IOException;
import java.io.Writer;

/* compiled from: Streams */
public final class k {
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001c, code lost:
        throw new com.bykv.vk.openvk.preload.a.l((java.lang.Throwable) r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001d, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0023, code lost:
        throw new com.bykv.vk.openvk.preload.a.r((java.lang.Throwable) r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x002a, code lost:
        return com.bykv.vk.openvk.preload.a.m.a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0030, code lost:
        throw new com.bykv.vk.openvk.preload.a.r((java.lang.Throwable) r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000d, code lost:
        r2 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x000f, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        throw new com.bykv.vk.openvk.preload.a.r((java.lang.Throwable) r2);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0016 A[ExcHandler: IOException (r2v5 'e' java.io.IOException A[CUSTOM_DECLARE]), Splitter:B:0:0x0000] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x001d A[ExcHandler: d (r2v4 'e' com.bykv.vk.openvk.preload.a.d.d A[CUSTOM_DECLARE]), Splitter:B:0:0x0000] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0028  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x002b  */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x000f A[ExcHandler: NumberFormatException (r2v6 'e' java.lang.NumberFormatException A[CUSTOM_DECLARE]), Splitter:B:0:0x0000] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.bykv.vk.openvk.preload.a.k a(com.bykv.vk.openvk.preload.a.d.a r2) throws com.bykv.vk.openvk.preload.a.o {
        /*
            r2.f()     // Catch:{ EOFException -> 0x0024, d -> 0x001d, IOException -> 0x0016, NumberFormatException -> 0x000f }
            r0 = 0
            com.bykv.vk.openvk.preload.a.t<com.bykv.vk.openvk.preload.a.k> r1 = com.bykv.vk.openvk.preload.a.b.a.n.X     // Catch:{ EOFException -> 0x000d, d -> 0x001d, IOException -> 0x0016, NumberFormatException -> 0x000f }
            java.lang.Object r2 = r1.a((com.bykv.vk.openvk.preload.a.d.a) r2)     // Catch:{ EOFException -> 0x000d, d -> 0x001d, IOException -> 0x0016, NumberFormatException -> 0x000f }
            com.bykv.vk.openvk.preload.a.k r2 = (com.bykv.vk.openvk.preload.a.k) r2     // Catch:{ EOFException -> 0x000d, d -> 0x001d, IOException -> 0x0016, NumberFormatException -> 0x000f }
            return r2
        L_0x000d:
            r2 = move-exception
            goto L_0x0026
        L_0x000f:
            r2 = move-exception
            com.bykv.vk.openvk.preload.a.r r0 = new com.bykv.vk.openvk.preload.a.r
            r0.<init>((java.lang.Throwable) r2)
            throw r0
        L_0x0016:
            r2 = move-exception
            com.bykv.vk.openvk.preload.a.l r0 = new com.bykv.vk.openvk.preload.a.l
            r0.<init>((java.lang.Throwable) r2)
            throw r0
        L_0x001d:
            r2 = move-exception
            com.bykv.vk.openvk.preload.a.r r0 = new com.bykv.vk.openvk.preload.a.r
            r0.<init>((java.lang.Throwable) r2)
            throw r0
        L_0x0024:
            r2 = move-exception
            r0 = 1
        L_0x0026:
            if (r0 == 0) goto L_0x002b
            com.bykv.vk.openvk.preload.a.m r2 = com.bykv.vk.openvk.preload.a.m.a
            return r2
        L_0x002b:
            com.bykv.vk.openvk.preload.a.r r0 = new com.bykv.vk.openvk.preload.a.r
            r0.<init>((java.lang.Throwable) r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.openvk.preload.a.b.k.a(com.bykv.vk.openvk.preload.a.d.a):com.bykv.vk.openvk.preload.a.k");
    }

    public static void a(com.bykv.vk.openvk.preload.a.k kVar, c cVar) throws IOException {
        n.X.a(cVar, kVar);
    }

    public static Writer a(Appendable appendable) {
        return appendable instanceof Writer ? (Writer) appendable : new a(appendable);
    }

    /* compiled from: Streams */
    static final class a extends Writer {
        private final Appendable a;
        private final C0038a b = new C0038a();

        public final void close() {
        }

        public final void flush() {
        }

        a(Appendable appendable) {
            this.a = appendable;
        }

        public final void write(char[] cArr, int i, int i2) throws IOException {
            this.b.a = cArr;
            this.a.append(this.b, i, i2 + i);
        }

        public final void write(int i) throws IOException {
            this.a.append((char) i);
        }

        /* renamed from: com.bykv.vk.openvk.preload.a.b.k$a$a  reason: collision with other inner class name */
        /* compiled from: Streams */
        static class C0038a implements CharSequence {
            char[] a;

            C0038a() {
            }

            public final int length() {
                return this.a.length;
            }

            public final char charAt(int i) {
                return this.a[i];
            }

            public final CharSequence subSequence(int i, int i2) {
                return new String(this.a, i, i2 - i);
            }
        }
    }
}

package com.bykv.vk.openvk.preload.a.b.a;

import com.bykv.vk.openvk.preload.a.b.g;
import com.bykv.vk.openvk.preload.a.d.b;
import com.bykv.vk.openvk.preload.a.d.c;
import com.bykv.vk.openvk.preload.a.f;
import com.bykv.vk.openvk.preload.a.i;
import com.bykv.vk.openvk.preload.a.k;
import com.bykv.vk.openvk.preload.a.l;
import com.bykv.vk.openvk.preload.a.m;
import com.bykv.vk.openvk.preload.a.p;
import com.bykv.vk.openvk.preload.a.r;
import com.bykv.vk.openvk.preload.a.t;
import com.bykv.vk.openvk.preload.a.u;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.slf4j.Marker;

/* compiled from: TypeAdapters */
public final class n {
    public static final t<String> A;
    public static final t<BigDecimal> B = new t<BigDecimal>() {
        public final /* synthetic */ Object a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
            return b(aVar);
        }

        public final /* bridge */ /* synthetic */ void a(c cVar, Object obj) throws IOException {
            cVar.a((Number) (BigDecimal) obj);
        }

        private static BigDecimal b(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
            if (aVar.f() == b.NULL) {
                aVar.k();
                return null;
            }
            try {
                return new BigDecimal(aVar.i());
            } catch (NumberFormatException e) {
                throw new r((Throwable) e);
            }
        }
    };
    public static final t<BigInteger> C = new t<BigInteger>() {
        public final /* synthetic */ Object a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
            return b(aVar);
        }

        public final /* bridge */ /* synthetic */ void a(c cVar, Object obj) throws IOException {
            cVar.a((Number) (BigInteger) obj);
        }

        private static BigInteger b(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
            if (aVar.f() == b.NULL) {
                aVar.k();
                return null;
            }
            try {
                return new BigInteger(aVar.i());
            } catch (NumberFormatException e) {
                throw new r((Throwable) e);
            }
        }
    };
    public static final u D;
    public static final t<StringBuilder> E;
    public static final u F;
    public static final t<StringBuffer> G;
    public static final u H;
    public static final t<URL> I;
    public static final u J;
    public static final t<URI> K;
    public static final u L;
    public static final t<InetAddress> M;
    public static final u N;
    public static final t<UUID> O;
    public static final u P;
    public static final t<Currency> Q;
    public static final u R;
    public static final u S = new u() {
        public final <T> t<T> a(f fVar, com.bykv.vk.openvk.preload.a.c.a<T> aVar) {
            if (aVar.b != Timestamp.class) {
                return null;
            }
            final t<Date> a = fVar.a(Date.class);
            return new t<Timestamp>() {
                public final /* bridge */ /* synthetic */ void a(c cVar, Object obj) throws IOException {
                    a.a(cVar, (Timestamp) obj);
                }

                public final /* synthetic */ Object a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                    Date date = (Date) a.a(aVar);
                    if (date != null) {
                        return new Timestamp(date.getTime());
                    }
                    return null;
                }
            };
        }
    };
    public static final t<Calendar> T;
    public static final u U;
    public static final t<Locale> V;
    public static final u W;
    public static final t<k> X;
    public static final u Y;
    public static final u Z = new u() {
        public final <T> t<T> a(f fVar, com.bykv.vk.openvk.preload.a.c.a<T> aVar) {
            Class cls = aVar.b;
            if (!Enum.class.isAssignableFrom(cls) || cls == Enum.class) {
                return null;
            }
            if (!cls.isEnum()) {
                cls = cls.getSuperclass();
            }
            return new a(cls);
        }
    };
    public static final t<Class> a;
    public static final u b;
    public static final t<BitSet> c;
    public static final u d;
    public static final t<Boolean> e;
    public static final t<Boolean> f = new t<Boolean>() {
        public final /* synthetic */ void a(c cVar, Object obj) throws IOException {
            Boolean bool = (Boolean) obj;
            cVar.b(bool == null ? AbstractJsonLexerKt.NULL : bool.toString());
        }

        public final /* synthetic */ Object a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
            if (aVar.f() != b.NULL) {
                return Boolean.valueOf(aVar.i());
            }
            aVar.k();
            return null;
        }
    };
    public static final u g;
    public static final t<Number> h;
    public static final u i;
    public static final t<Number> j;
    public static final u k;
    public static final t<Number> l;
    public static final u m;
    public static final t<AtomicInteger> n;
    public static final u o;
    public static final t<AtomicBoolean> p;
    public static final u q;
    public static final t<AtomicIntegerArray> r;
    public static final u s;
    public static final t<Number> t = new t<Number>() {
        public final /* synthetic */ Object a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
            return b(aVar);
        }

        public final /* bridge */ /* synthetic */ void a(c cVar, Object obj) throws IOException {
            cVar.a((Number) obj);
        }

        private static Number b(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
            if (aVar.f() == b.NULL) {
                aVar.k();
                return null;
            }
            try {
                return Long.valueOf(aVar.m());
            } catch (NumberFormatException e) {
                throw new r((Throwable) e);
            }
        }
    };
    public static final t<Number> u = new t<Number>() {
        public final /* bridge */ /* synthetic */ void a(c cVar, Object obj) throws IOException {
            cVar.a((Number) obj);
        }

        public final /* synthetic */ Object a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
            if (aVar.f() != b.NULL) {
                return Float.valueOf((float) aVar.l());
            }
            aVar.k();
            return null;
        }
    };
    public static final t<Number> v = new t<Number>() {
        public final /* bridge */ /* synthetic */ void a(c cVar, Object obj) throws IOException {
            cVar.a((Number) obj);
        }

        public final /* synthetic */ Object a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
            if (aVar.f() != b.NULL) {
                return Double.valueOf(aVar.l());
            }
            aVar.k();
            return null;
        }
    };
    public static final t<Number> w;
    public static final u x;
    public static final t<Character> y;
    public static final u z;

    static {
        t<Class> a2 = new t<Class>() {
            public final /* synthetic */ void a(c cVar, Object obj) throws IOException {
                throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + ((Class) obj).getName() + ". Forgot to register a type adapter?");
            }

            public final /* synthetic */ Object a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
            }
        }.a();
        a = a2;
        b = a(Class.class, a2);
        t<BitSet> a3 = new t<BitSet>() {
            public final /* synthetic */ Object a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                return b(aVar);
            }

            public final /* synthetic */ void a(c cVar, Object obj) throws IOException {
                BitSet bitSet = (BitSet) obj;
                cVar.a();
                int length = bitSet.length();
                for (int i = 0; i < length; i++) {
                    cVar.a(bitSet.get(i) ? 1 : 0);
                }
                cVar.b();
            }

            /* JADX WARNING: Code restructure failed: missing block: B:12:0x002b, code lost:
                if (java.lang.Integer.parseInt(r1) != 0) goto L_0x005b;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:21:0x0059, code lost:
                if (r7.n() != 0) goto L_0x005b;
             */
            /* JADX WARNING: Removed duplicated region for block: B:23:0x005d  */
            /* JADX WARNING: Removed duplicated region for block: B:30:0x0060 A[SYNTHETIC] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            private static java.util.BitSet b(com.bykv.vk.openvk.preload.a.d.a r7) throws java.io.IOException {
                /*
                    java.util.BitSet r0 = new java.util.BitSet
                    r0.<init>()
                    r7.a()
                    com.bykv.vk.openvk.preload.a.d.b r1 = r7.f()
                    r2 = 0
                    r3 = 0
                L_0x000e:
                    com.bykv.vk.openvk.preload.a.d.b r4 = com.bykv.vk.openvk.preload.a.d.b.END_ARRAY
                    if (r1 == r4) goto L_0x0067
                    int[] r4 = com.bykv.vk.openvk.preload.a.b.a.n.AnonymousClass30.a
                    int r5 = r1.ordinal()
                    r4 = r4[r5]
                    r5 = 1
                    if (r4 == r5) goto L_0x0055
                    r6 = 2
                    if (r4 == r6) goto L_0x0050
                    r6 = 3
                    if (r4 != r6) goto L_0x0040
                    java.lang.String r1 = r7.i()
                    int r1 = java.lang.Integer.parseInt(r1)     // Catch:{ NumberFormatException -> 0x0030 }
                    if (r1 == 0) goto L_0x002e
                    goto L_0x005b
                L_0x002e:
                    r5 = 0
                    goto L_0x005b
                L_0x0030:
                    com.bykv.vk.openvk.preload.a.r r7 = new com.bykv.vk.openvk.preload.a.r
                    java.lang.String r0 = "Error: Expecting: bitset number value (1, 0), Found: "
                    java.lang.String r1 = java.lang.String.valueOf(r1)
                    java.lang.String r0 = r0.concat(r1)
                    r7.<init>((java.lang.String) r0)
                    throw r7
                L_0x0040:
                    com.bykv.vk.openvk.preload.a.r r7 = new com.bykv.vk.openvk.preload.a.r
                    java.lang.String r0 = "Invalid bitset value type: "
                    java.lang.String r1 = java.lang.String.valueOf(r1)
                    java.lang.String r0 = r0.concat(r1)
                    r7.<init>((java.lang.String) r0)
                    throw r7
                L_0x0050:
                    boolean r5 = r7.j()
                    goto L_0x005b
                L_0x0055:
                    int r1 = r7.n()
                    if (r1 == 0) goto L_0x002e
                L_0x005b:
                    if (r5 == 0) goto L_0x0060
                    r0.set(r3)
                L_0x0060:
                    int r3 = r3 + 1
                    com.bykv.vk.openvk.preload.a.d.b r1 = r7.f()
                    goto L_0x000e
                L_0x0067:
                    r7.b()
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.openvk.preload.a.b.a.n.AnonymousClass12.b(com.bykv.vk.openvk.preload.a.d.a):java.util.BitSet");
            }
        }.a();
        c = a3;
        d = a(BitSet.class, a3);
        AnonymousClass23 r0 = new t<Boolean>() {
            public final /* bridge */ /* synthetic */ void a(c cVar, Object obj) throws IOException {
                cVar.a((Boolean) obj);
            }

            public final /* synthetic */ Object a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                b f = aVar.f();
                if (f == b.NULL) {
                    aVar.k();
                    return null;
                } else if (f == b.STRING) {
                    return Boolean.valueOf(Boolean.parseBoolean(aVar.i()));
                } else {
                    return Boolean.valueOf(aVar.j());
                }
            }
        };
        e = r0;
        g = a(Boolean.TYPE, Boolean.class, r0);
        AnonymousClass32 r02 = new t<Number>() {
            public final /* synthetic */ Object a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                return b(aVar);
            }

            public final /* bridge */ /* synthetic */ void a(c cVar, Object obj) throws IOException {
                cVar.a((Number) obj);
            }

            private static Number b(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                if (aVar.f() == b.NULL) {
                    aVar.k();
                    return null;
                }
                try {
                    return Byte.valueOf((byte) aVar.n());
                } catch (NumberFormatException e) {
                    throw new r((Throwable) e);
                }
            }
        };
        h = r02;
        i = a(Byte.TYPE, Byte.class, r02);
        AnonymousClass33 r03 = new t<Number>() {
            public final /* synthetic */ Object a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                return b(aVar);
            }

            public final /* bridge */ /* synthetic */ void a(c cVar, Object obj) throws IOException {
                cVar.a((Number) obj);
            }

            private static Number b(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                if (aVar.f() == b.NULL) {
                    aVar.k();
                    return null;
                }
                try {
                    return Short.valueOf((short) aVar.n());
                } catch (NumberFormatException e) {
                    throw new r((Throwable) e);
                }
            }
        };
        j = r03;
        k = a(Short.TYPE, Short.class, r03);
        AnonymousClass34 r04 = new t<Number>() {
            public final /* synthetic */ Object a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                return b(aVar);
            }

            public final /* bridge */ /* synthetic */ void a(c cVar, Object obj) throws IOException {
                cVar.a((Number) obj);
            }

            private static Number b(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                if (aVar.f() == b.NULL) {
                    aVar.k();
                    return null;
                }
                try {
                    return Integer.valueOf(aVar.n());
                } catch (NumberFormatException e) {
                    throw new r((Throwable) e);
                }
            }
        };
        l = r04;
        m = a(Integer.TYPE, Integer.class, r04);
        t<AtomicInteger> a4 = new t<AtomicInteger>() {
            public final /* synthetic */ Object a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                return b(aVar);
            }

            public final /* synthetic */ void a(c cVar, Object obj) throws IOException {
                cVar.a((long) ((AtomicInteger) obj).get());
            }

            private static AtomicInteger b(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                try {
                    return new AtomicInteger(aVar.n());
                } catch (NumberFormatException e) {
                    throw new r((Throwable) e);
                }
            }
        }.a();
        n = a4;
        o = a(AtomicInteger.class, a4);
        t<AtomicBoolean> a5 = new t<AtomicBoolean>() {
            public final /* synthetic */ void a(c cVar, Object obj) throws IOException {
                cVar.a(((AtomicBoolean) obj).get());
            }

            public final /* synthetic */ Object a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                return new AtomicBoolean(aVar.j());
            }
        }.a();
        p = a5;
        q = a(AtomicBoolean.class, a5);
        t<AtomicIntegerArray> a6 = new t<AtomicIntegerArray>() {
            public final /* synthetic */ Object a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                return b(aVar);
            }

            public final /* synthetic */ void a(c cVar, Object obj) throws IOException {
                AtomicIntegerArray atomicIntegerArray = (AtomicIntegerArray) obj;
                cVar.a();
                int length = atomicIntegerArray.length();
                for (int i = 0; i < length; i++) {
                    cVar.a((long) atomicIntegerArray.get(i));
                }
                cVar.b();
            }

            private static AtomicIntegerArray b(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                ArrayList arrayList = new ArrayList();
                aVar.a();
                while (aVar.e()) {
                    try {
                        arrayList.add(Integer.valueOf(aVar.n()));
                    } catch (NumberFormatException e) {
                        throw new r((Throwable) e);
                    }
                }
                aVar.b();
                int size = arrayList.size();
                AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(size);
                for (int i = 0; i < size; i++) {
                    atomicIntegerArray.set(i, ((Integer) arrayList.get(i)).intValue());
                }
                return atomicIntegerArray;
            }
        }.a();
        r = a6;
        s = a(AtomicIntegerArray.class, a6);
        AnonymousClass6 r05 = new t<Number>() {
            public final /* bridge */ /* synthetic */ void a(c cVar, Object obj) throws IOException {
                cVar.a((Number) obj);
            }

            public final /* synthetic */ Object a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                b f = aVar.f();
                int i = AnonymousClass30.a[f.ordinal()];
                if (i == 1 || i == 3) {
                    return new g(aVar.i());
                }
                if (i == 4) {
                    aVar.k();
                    return null;
                }
                throw new r("Expecting number, got: ".concat(String.valueOf(f)));
            }
        };
        w = r05;
        x = a(Number.class, r05);
        AnonymousClass7 r06 = new t<Character>() {
            public final /* synthetic */ void a(c cVar, Object obj) throws IOException {
                Character ch = (Character) obj;
                cVar.b(ch == null ? null : String.valueOf(ch));
            }

            public final /* synthetic */ Object a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                if (aVar.f() == b.NULL) {
                    aVar.k();
                    return null;
                }
                String i = aVar.i();
                if (i.length() == 1) {
                    return Character.valueOf(i.charAt(0));
                }
                throw new r("Expecting character, got: ".concat(String.valueOf(i)));
            }
        };
        y = r06;
        z = a(Character.TYPE, Character.class, r06);
        AnonymousClass8 r07 = new t<String>() {
            public final /* synthetic */ void a(c cVar, Object obj) throws IOException {
                cVar.b((String) obj);
            }

            public final /* synthetic */ Object a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                b f = aVar.f();
                if (f == b.NULL) {
                    aVar.k();
                    return null;
                } else if (f == b.BOOLEAN) {
                    return Boolean.toString(aVar.j());
                } else {
                    return aVar.i();
                }
            }
        };
        A = r07;
        D = a(String.class, r07);
        AnonymousClass11 r08 = new t<StringBuilder>() {
            public final /* synthetic */ void a(c cVar, Object obj) throws IOException {
                StringBuilder sb = (StringBuilder) obj;
                cVar.b(sb == null ? null : sb.toString());
            }

            public final /* synthetic */ Object a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                if (aVar.f() != b.NULL) {
                    return new StringBuilder(aVar.i());
                }
                aVar.k();
                return null;
            }
        };
        E = r08;
        F = a(StringBuilder.class, r08);
        AnonymousClass13 r09 = new t<StringBuffer>() {
            public final /* synthetic */ void a(c cVar, Object obj) throws IOException {
                StringBuffer stringBuffer = (StringBuffer) obj;
                cVar.b(stringBuffer == null ? null : stringBuffer.toString());
            }

            public final /* synthetic */ Object a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                if (aVar.f() != b.NULL) {
                    return new StringBuffer(aVar.i());
                }
                aVar.k();
                return null;
            }
        };
        G = r09;
        H = a(StringBuffer.class, r09);
        AnonymousClass14 r010 = new t<URL>() {
            public final /* synthetic */ void a(c cVar, Object obj) throws IOException {
                URL url = (URL) obj;
                cVar.b(url == null ? null : url.toExternalForm());
            }

            public final /* synthetic */ Object a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                if (aVar.f() == b.NULL) {
                    aVar.k();
                    return null;
                }
                String i = aVar.i();
                if (AbstractJsonLexerKt.NULL.equals(i)) {
                    return null;
                }
                return new URL(i);
            }
        };
        I = r010;
        J = a(URL.class, r010);
        AnonymousClass15 r011 = new t<URI>() {
            public final /* synthetic */ Object a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                return b(aVar);
            }

            public final /* synthetic */ void a(c cVar, Object obj) throws IOException {
                URI uri = (URI) obj;
                cVar.b(uri == null ? null : uri.toASCIIString());
            }

            private static URI b(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                if (aVar.f() == b.NULL) {
                    aVar.k();
                    return null;
                }
                try {
                    String i = aVar.i();
                    if (AbstractJsonLexerKt.NULL.equals(i)) {
                        return null;
                    }
                    return new URI(i);
                } catch (URISyntaxException e) {
                    throw new l((Throwable) e);
                }
            }
        };
        K = r011;
        L = a(URI.class, r011);
        AnonymousClass16 r012 = new t<InetAddress>() {
            public final /* synthetic */ void a(c cVar, Object obj) throws IOException {
                InetAddress inetAddress = (InetAddress) obj;
                cVar.b(inetAddress == null ? null : inetAddress.getHostAddress());
            }

            public final /* synthetic */ Object a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                if (aVar.f() != b.NULL) {
                    return InetAddress.getByName(aVar.i());
                }
                aVar.k();
                return null;
            }
        };
        M = r012;
        N = b(InetAddress.class, r012);
        AnonymousClass17 r013 = new t<UUID>() {
            public final /* synthetic */ void a(c cVar, Object obj) throws IOException {
                UUID uuid = (UUID) obj;
                cVar.b(uuid == null ? null : uuid.toString());
            }

            public final /* synthetic */ Object a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                if (aVar.f() != b.NULL) {
                    return UUID.fromString(aVar.i());
                }
                aVar.k();
                return null;
            }
        };
        O = r013;
        P = a(UUID.class, r013);
        t<Currency> a7 = new t<Currency>() {
            public final /* synthetic */ void a(c cVar, Object obj) throws IOException {
                cVar.b(((Currency) obj).getCurrencyCode());
            }

            public final /* synthetic */ Object a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                return Currency.getInstance(aVar.i());
            }
        }.a();
        Q = a7;
        R = a(Currency.class, a7);
        final AnonymousClass20 r014 = new t<Calendar>() {
            public final /* synthetic */ void a(c cVar, Object obj) throws IOException {
                Calendar calendar = (Calendar) obj;
                if (calendar == null) {
                    cVar.e();
                    return;
                }
                cVar.c();
                cVar.a("year");
                cVar.a((long) calendar.get(1));
                cVar.a("month");
                cVar.a((long) calendar.get(2));
                cVar.a("dayOfMonth");
                cVar.a((long) calendar.get(5));
                cVar.a("hourOfDay");
                cVar.a((long) calendar.get(11));
                cVar.a("minute");
                cVar.a((long) calendar.get(12));
                cVar.a("second");
                cVar.a((long) calendar.get(13));
                cVar.d();
            }

            public final /* synthetic */ Object a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                if (aVar.f() == b.NULL) {
                    aVar.k();
                    return null;
                }
                aVar.c();
                int i = 0;
                int i2 = 0;
                int i3 = 0;
                int i4 = 0;
                int i5 = 0;
                int i6 = 0;
                while (aVar.f() != b.END_OBJECT) {
                    String h = aVar.h();
                    int n = aVar.n();
                    if ("year".equals(h)) {
                        i = n;
                    } else if ("month".equals(h)) {
                        i2 = n;
                    } else if ("dayOfMonth".equals(h)) {
                        i3 = n;
                    } else if ("hourOfDay".equals(h)) {
                        i4 = n;
                    } else if ("minute".equals(h)) {
                        i5 = n;
                    } else if ("second".equals(h)) {
                        i6 = n;
                    }
                }
                aVar.d();
                return new GregorianCalendar(i, i2, i3, i4, i5, i6);
            }
        };
        T = r014;
        final Class<Calendar> cls = Calendar.class;
        final Class<GregorianCalendar> cls2 = GregorianCalendar.class;
        U = new u() {
            public final String toString() {
                return "Factory[type=" + cls.getName() + Marker.ANY_NON_NULL_MARKER + cls2.getName() + ",adapter=" + r014 + "]";
            }

            public final <T> t<T> a(f fVar, com.bykv.vk.openvk.preload.a.c.a<T> aVar) {
                Class<? super T> cls = aVar.b;
                if (cls == cls || cls == cls2) {
                    return r014;
                }
                return null;
            }
        };
        AnonymousClass21 r015 = new t<Locale>() {
            public final /* synthetic */ void a(c cVar, Object obj) throws IOException {
                Locale locale = (Locale) obj;
                cVar.b(locale == null ? null : locale.toString());
            }

            public final /* synthetic */ Object a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                String str = null;
                if (aVar.f() == b.NULL) {
                    aVar.k();
                    return null;
                }
                StringTokenizer stringTokenizer = new StringTokenizer(aVar.i(), "_");
                String nextToken = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
                String nextToken2 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
                if (stringTokenizer.hasMoreElements()) {
                    str = stringTokenizer.nextToken();
                }
                if (nextToken2 == null && str == null) {
                    return new Locale(nextToken);
                }
                if (str == null) {
                    return new Locale(nextToken, nextToken2);
                }
                return new Locale(nextToken, nextToken2, str);
            }
        };
        V = r015;
        W = a(Locale.class, r015);
        AnonymousClass22 r016 = new t<k>() {
            /* access modifiers changed from: private */
            /* renamed from: b */
            public k a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                switch (AnonymousClass30.a[aVar.f().ordinal()]) {
                    case 1:
                        return new p((Number) new g(aVar.i()));
                    case 2:
                        return new p(Boolean.valueOf(aVar.j()));
                    case 3:
                        return new p(aVar.i());
                    case 4:
                        aVar.k();
                        return m.a;
                    case 5:
                        i iVar = new i();
                        aVar.a();
                        while (aVar.e()) {
                            iVar.a(a(aVar));
                        }
                        aVar.b();
                        return iVar;
                    case 6:
                        com.bykv.vk.openvk.preload.a.n nVar = new com.bykv.vk.openvk.preload.a.n();
                        aVar.c();
                        while (aVar.e()) {
                            nVar.a(aVar.h(), a(aVar));
                        }
                        aVar.d();
                        return nVar;
                    default:
                        throw new IllegalArgumentException();
                }
            }

            /* access modifiers changed from: private */
            public void a(c cVar, k kVar) throws IOException {
                if (kVar == null || (kVar instanceof m)) {
                    cVar.e();
                } else if (kVar instanceof p) {
                    p g = kVar.g();
                    if (g.a instanceof Number) {
                        cVar.a(g.a());
                    } else if (g.a instanceof Boolean) {
                        cVar.a(g.f());
                    } else {
                        cVar.b(g.b());
                    }
                } else {
                    boolean z = kVar instanceof i;
                    if (z) {
                        cVar.a();
                        if (z) {
                            Iterator<k> it = ((i) kVar).iterator();
                            while (it.hasNext()) {
                                a(cVar, it.next());
                            }
                            cVar.b();
                            return;
                        }
                        throw new IllegalStateException("Not a JSON Array: ".concat(String.valueOf(kVar)));
                    }
                    boolean z2 = kVar instanceof com.bykv.vk.openvk.preload.a.n;
                    if (z2) {
                        cVar.c();
                        if (z2) {
                            for (Map.Entry next : ((com.bykv.vk.openvk.preload.a.n) kVar).a.entrySet()) {
                                cVar.a((String) next.getKey());
                                a(cVar, (k) next.getValue());
                            }
                            cVar.d();
                            return;
                        }
                        throw new IllegalStateException("Not a JSON Object: ".concat(String.valueOf(kVar)));
                    }
                    throw new IllegalArgumentException("Couldn't write " + kVar.getClass());
                }
            }
        };
        X = r016;
        Y = b(k.class, r016);
    }

    /* renamed from: com.bykv.vk.openvk.preload.a.b.a.n$30  reason: invalid class name */
    /* compiled from: TypeAdapters */
    static /* synthetic */ class AnonymousClass30 {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(20:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|(3:19|20|22)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(22:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|22) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.bykv.vk.openvk.preload.a.d.b[] r0 = com.bykv.vk.openvk.preload.a.d.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                com.bykv.vk.openvk.preload.a.d.b r1 = com.bykv.vk.openvk.preload.a.d.b.NUMBER     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.bykv.vk.openvk.preload.a.d.b r1 = com.bykv.vk.openvk.preload.a.d.b.BOOLEAN     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.bykv.vk.openvk.preload.a.d.b r1 = com.bykv.vk.openvk.preload.a.d.b.STRING     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.bykv.vk.openvk.preload.a.d.b r1 = com.bykv.vk.openvk.preload.a.d.b.NULL     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.bykv.vk.openvk.preload.a.d.b r1 = com.bykv.vk.openvk.preload.a.d.b.BEGIN_ARRAY     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.bykv.vk.openvk.preload.a.d.b r1 = com.bykv.vk.openvk.preload.a.d.b.BEGIN_OBJECT     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.bykv.vk.openvk.preload.a.d.b r1 = com.bykv.vk.openvk.preload.a.d.b.END_DOCUMENT     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.bykv.vk.openvk.preload.a.d.b r1 = com.bykv.vk.openvk.preload.a.d.b.NAME     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x006c }
                com.bykv.vk.openvk.preload.a.d.b r1 = com.bykv.vk.openvk.preload.a.d.b.END_OBJECT     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.bykv.vk.openvk.preload.a.d.b r1 = com.bykv.vk.openvk.preload.a.d.b.END_ARRAY     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.openvk.preload.a.b.a.n.AnonymousClass30.<clinit>():void");
        }
    }

    /* compiled from: TypeAdapters */
    static final class a<T extends Enum<T>> extends t<T> {
        private final Map<String, T> a = new HashMap();
        private final Map<T, String> b = new HashMap();

        public final /* synthetic */ void a(c cVar, Object obj) throws IOException {
            Enum enumR = (Enum) obj;
            cVar.b(enumR == null ? null : this.b.get(enumR));
        }

        public a(Class<T> cls) {
            try {
                for (Enum enumR : (Enum[]) cls.getEnumConstants()) {
                    String name = enumR.name();
                    com.bykv.vk.openvk.preload.a.a.c cVar = (com.bykv.vk.openvk.preload.a.a.c) cls.getField(name).getAnnotation(com.bykv.vk.openvk.preload.a.a.c.class);
                    if (cVar != null) {
                        name = cVar.a();
                        for (String put : cVar.b()) {
                            this.a.put(put, enumR);
                        }
                    }
                    this.a.put(name, enumR);
                    this.b.put(enumR, name);
                }
            } catch (NoSuchFieldException e) {
                throw new AssertionError(e);
            }
        }

        public final /* synthetic */ Object a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
            if (aVar.f() != b.NULL) {
                return (Enum) this.a.get(aVar.i());
            }
            aVar.k();
            return null;
        }
    }

    public static <TT> u a(final com.bykv.vk.openvk.preload.a.c.a<TT> aVar, final t<TT> tVar) {
        return new u() {
            public final <T> t<T> a(f fVar, com.bykv.vk.openvk.preload.a.c.a<T> aVar) {
                if (aVar.equals(aVar)) {
                    return tVar;
                }
                return null;
            }
        };
    }

    public static <TT> u a(final Class<TT> cls, final t<TT> tVar) {
        return new u() {
            public final String toString() {
                return "Factory[type=" + cls.getName() + ",adapter=" + tVar + "]";
            }

            public final <T> t<T> a(f fVar, com.bykv.vk.openvk.preload.a.c.a<T> aVar) {
                if (aVar.b == cls) {
                    return tVar;
                }
                return null;
            }
        };
    }

    public static <TT> u a(final Class<TT> cls, final Class<TT> cls2, final t<? super TT> tVar) {
        return new u() {
            public final String toString() {
                return "Factory[type=" + cls2.getName() + Marker.ANY_NON_NULL_MARKER + cls.getName() + ",adapter=" + tVar + "]";
            }

            public final <T> t<T> a(f fVar, com.bykv.vk.openvk.preload.a.c.a<T> aVar) {
                Class<? super T> cls = aVar.b;
                if (cls == cls || cls == cls2) {
                    return tVar;
                }
                return null;
            }
        };
    }

    private static <T1> u b(final Class<T1> cls, final t<T1> tVar) {
        return new u() {
            public final String toString() {
                return "Factory[typeHierarchy=" + cls.getName() + ",adapter=" + tVar + "]";
            }

            public final <T2> t<T2> a(f fVar, com.bykv.vk.openvk.preload.a.c.a<T2> aVar) {
                final Class<? super T> cls = aVar.b;
                if (!cls.isAssignableFrom(cls)) {
                    return null;
                }
                return new t<T1>() {
                    public final void a(c cVar, T1 t1) throws IOException {
                        tVar.a(cVar, t1);
                    }

                    public final T1 a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                        T1 a2 = tVar.a(aVar);
                        if (a2 == null || cls.isInstance(a2)) {
                            return a2;
                        }
                        throw new r("Expected a " + cls.getName() + " but was " + a2.getClass().getName());
                    }
                };
            }
        };
    }
}

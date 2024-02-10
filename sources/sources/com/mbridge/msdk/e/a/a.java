package com.mbridge.msdk.e.a;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: Cache */
public interface a {
    C0133a a(String str);

    void a();

    void a(String str, C0133a aVar);

    void a(String str, boolean z);

    /* renamed from: com.mbridge.msdk.e.a.a$a  reason: collision with other inner class name */
    /* compiled from: Cache */
    public static class C0133a {
        public byte[] a;
        public String b;
        public long c;
        public long d;
        public long e;
        public long f;
        public Map<String, String> g = Collections.emptyMap();
        public List<g> h;

        /* access modifiers changed from: package-private */
        public final boolean a(long j) {
            return this.e < j;
        }
    }
}

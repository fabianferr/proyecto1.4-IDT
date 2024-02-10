package com.applovin.impl.mediation;

import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.u;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.mediation.adapters.MediationAdapterBase;
import com.applovin.sdk.AppLovinSdk;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

public class f {
    private final Map<String, g> a = Collections.synchronizedMap(CollectionUtils.map(16));
    private final m b;
    private final u c;
    private final Object d = new Object();
    private final Map<String, Class<? extends MaxAdapter>> e = CollectionUtils.map();
    private final Set<String> f = new HashSet();
    private final Object g = new Object();
    private final Set<a> h = new HashSet();

    private static class a {
        private final String a;
        private final String b;
        private final MaxAdFormat c;
        private final JSONObject d;

        a(String str, String str2, com.applovin.impl.mediation.a.a aVar, m mVar) {
            this.a = str;
            this.b = str2;
            JSONObject jSONObject = new JSONObject();
            this.d = jSONObject;
            JsonUtils.putString(jSONObject, "class", str);
            JsonUtils.putString(jSONObject, "operation", str2);
            if (aVar != null) {
                this.c = aVar.getFormat();
                if (aVar.getFormat() != null) {
                    JsonUtils.putString(jSONObject, "format", aVar.getFormat().getLabel());
                    return;
                }
                return;
            }
            this.c = null;
        }

        /* access modifiers changed from: package-private */
        public JSONObject a() {
            return this.d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            if (!this.a.equals(aVar.a) || !this.b.equals(aVar.b)) {
                return false;
            }
            MaxAdFormat maxAdFormat = this.c;
            MaxAdFormat maxAdFormat2 = aVar.c;
            return maxAdFormat == null ? maxAdFormat2 == null : maxAdFormat.equals(maxAdFormat2);
        }

        public int hashCode() {
            int hashCode = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
            MaxAdFormat maxAdFormat = this.c;
            return hashCode + (maxAdFormat != null ? maxAdFormat.hashCode() : 0);
        }

        public String toString() {
            return "DisabledAdapterInfo{className='" + this.a + "', operationTag='" + this.b + "', format=" + this.c + AbstractJsonLexerKt.END_OBJ;
        }
    }

    public f(m mVar) {
        if (mVar != null) {
            this.b = mVar;
            this.c = mVar.A();
            return;
        }
        throw new IllegalArgumentException("No sdk specified");
    }

    private g a(com.applovin.impl.mediation.a.f fVar, Class<? extends MaxAdapter> cls, boolean z) {
        try {
            return new g(fVar, (MediationAdapterBase) cls.getConstructor(new Class[]{AppLovinSdk.class}).newInstance(new Object[]{this.b.Y()}), z, this.b);
        } catch (Throwable th) {
            if (!u.a()) {
                return null;
            }
            u.c("MediationAdapterManager", "Failed to load adapter: " + fVar, th);
            return null;
        }
    }

    private Class<? extends MaxAdapter> a(String str) {
        try {
            Class<?> cls = Class.forName(str);
            if (MaxAdapter.class.isAssignableFrom(cls)) {
                return cls.asSubclass(MaxAdapter.class);
            }
            if (!u.a()) {
                return null;
            }
            u.i("MediationAdapterManager", str + " error: not an instance of '" + MaxAdapter.class.getName() + "'.");
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public g a(com.applovin.impl.mediation.a.f fVar) {
        return a(fVar, false);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00c5, code lost:
        return r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0105, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.applovin.impl.mediation.g a(com.applovin.impl.mediation.a.f r10, boolean r11) {
        /*
            r9 = this;
            java.lang.String r0 = "Loaded "
            java.lang.String r1 = "Failed to load "
            java.lang.String r2 = "Not attempting to load "
            if (r10 == 0) goto L_0x0109
            java.lang.String r3 = r10.N()
            java.lang.String r4 = r10.M()
            boolean r5 = android.text.TextUtils.isEmpty(r3)
            r6 = 0
            if (r5 == 0) goto L_0x0038
            boolean r10 = com.applovin.impl.sdk.u.a()
            if (r10 == 0) goto L_0x0037
            com.applovin.impl.sdk.u r10 = r9.c
            java.lang.String r11 = "MediationAdapterManager"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "No adapter name provided for "
            r0.<init>(r1)
            r0.append(r4)
            java.lang.String r1 = ", not loading the adapter "
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r10.e(r11, r0)
        L_0x0037:
            return r6
        L_0x0038:
            boolean r5 = android.text.TextUtils.isEmpty(r4)
            if (r5 == 0) goto L_0x005f
            boolean r10 = com.applovin.impl.sdk.u.a()
            if (r10 == 0) goto L_0x005e
            com.applovin.impl.sdk.u r10 = r9.c
            java.lang.String r11 = "MediationAdapterManager"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Unable to find default className for '"
            r0.<init>(r1)
            r0.append(r3)
            java.lang.String r1 = "'"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r10.e(r11, r0)
        L_0x005e:
            return r6
        L_0x005f:
            if (r11 == 0) goto L_0x006c
            java.util.Map<java.lang.String, com.applovin.impl.mediation.g> r5 = r9.a
            java.lang.Object r5 = r5.get(r4)
            com.applovin.impl.mediation.g r5 = (com.applovin.impl.mediation.g) r5
            if (r5 == 0) goto L_0x006c
            return r5
        L_0x006c:
            java.lang.Object r5 = r9.d
            monitor-enter(r5)
            java.util.Set<java.lang.String> r7 = r9.f     // Catch:{ all -> 0x0106 }
            boolean r7 = r7.contains(r4)     // Catch:{ all -> 0x0106 }
            if (r7 != 0) goto L_0x00e6
            java.util.Map<java.lang.String, java.lang.Class<? extends com.applovin.mediation.adapter.MaxAdapter>> r2 = r9.e     // Catch:{ all -> 0x0106 }
            boolean r2 = r2.containsKey(r4)     // Catch:{ all -> 0x0106 }
            if (r2 == 0) goto L_0x0088
            java.util.Map<java.lang.String, java.lang.Class<? extends com.applovin.mediation.adapter.MaxAdapter>> r2 = r9.e     // Catch:{ all -> 0x0106 }
            java.lang.Object r2 = r2.get(r4)     // Catch:{ all -> 0x0106 }
            java.lang.Class r2 = (java.lang.Class) r2     // Catch:{ all -> 0x0106 }
            goto L_0x0095
        L_0x0088:
            java.lang.Class r2 = r9.a((java.lang.String) r4)     // Catch:{ all -> 0x0106 }
            if (r2 != 0) goto L_0x0095
            java.util.Set<java.lang.String> r10 = r9.f     // Catch:{ all -> 0x0106 }
            r10.add(r4)     // Catch:{ all -> 0x0106 }
            monitor-exit(r5)     // Catch:{ all -> 0x0106 }
            return r6
        L_0x0095:
            com.applovin.impl.mediation.g r7 = r9.a((com.applovin.impl.mediation.a.f) r10, (java.lang.Class<? extends com.applovin.mediation.adapter.MaxAdapter>) r2, (boolean) r11)     // Catch:{ all -> 0x0106 }
            if (r7 == 0) goto L_0x00c6
            boolean r1 = com.applovin.impl.sdk.u.a()     // Catch:{ all -> 0x0106 }
            if (r1 == 0) goto L_0x00b4
            com.applovin.impl.sdk.u r1 = r9.c     // Catch:{ all -> 0x0106 }
            java.lang.String r6 = "MediationAdapterManager"
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0106 }
            r8.<init>(r0)     // Catch:{ all -> 0x0106 }
            r8.append(r3)     // Catch:{ all -> 0x0106 }
            java.lang.String r0 = r8.toString()     // Catch:{ all -> 0x0106 }
            r1.b(r6, r0)     // Catch:{ all -> 0x0106 }
        L_0x00b4:
            java.util.Map<java.lang.String, java.lang.Class<? extends com.applovin.mediation.adapter.MaxAdapter>> r0 = r9.e     // Catch:{ all -> 0x0106 }
            r0.put(r4, r2)     // Catch:{ all -> 0x0106 }
            if (r11 == 0) goto L_0x00c4
            java.util.Map<java.lang.String, com.applovin.impl.mediation.g> r11 = r9.a     // Catch:{ all -> 0x0106 }
            java.lang.String r10 = r10.M()     // Catch:{ all -> 0x0106 }
            r11.put(r10, r7)     // Catch:{ all -> 0x0106 }
        L_0x00c4:
            monitor-exit(r5)     // Catch:{ all -> 0x0106 }
            return r7
        L_0x00c6:
            boolean r10 = com.applovin.impl.sdk.u.a()     // Catch:{ all -> 0x0106 }
            if (r10 == 0) goto L_0x00df
            com.applovin.impl.sdk.u r10 = r9.c     // Catch:{ all -> 0x0106 }
            java.lang.String r11 = "MediationAdapterManager"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0106 }
            r0.<init>(r1)     // Catch:{ all -> 0x0106 }
            r0.append(r3)     // Catch:{ all -> 0x0106 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0106 }
            r10.e(r11, r0)     // Catch:{ all -> 0x0106 }
        L_0x00df:
            java.util.Set<java.lang.String> r10 = r9.f     // Catch:{ all -> 0x0106 }
            r10.add(r4)     // Catch:{ all -> 0x0106 }
            monitor-exit(r5)     // Catch:{ all -> 0x0106 }
            return r6
        L_0x00e6:
            boolean r10 = com.applovin.impl.sdk.u.a()     // Catch:{ all -> 0x0106 }
            if (r10 == 0) goto L_0x0104
            com.applovin.impl.sdk.u r10 = r9.c     // Catch:{ all -> 0x0106 }
            java.lang.String r11 = "MediationAdapterManager"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0106 }
            r0.<init>(r2)     // Catch:{ all -> 0x0106 }
            r0.append(r3)     // Catch:{ all -> 0x0106 }
            java.lang.String r1 = " due to prior errors"
            r0.append(r1)     // Catch:{ all -> 0x0106 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0106 }
            r10.b(r11, r0)     // Catch:{ all -> 0x0106 }
        L_0x0104:
            monitor-exit(r5)     // Catch:{ all -> 0x0106 }
            return r6
        L_0x0106:
            r10 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x0106 }
            throw r10
        L_0x0109:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.String r11 = "No adapter spec specified"
            r10.<init>(r11)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.mediation.f.a(com.applovin.impl.mediation.a.f, boolean):com.applovin.impl.mediation.g");
    }

    public Collection<String> a() {
        Set unmodifiableSet;
        synchronized (this.d) {
            HashSet hashSet = new HashSet(this.e.size());
            for (Class<? extends MaxAdapter> name : this.e.values()) {
                hashSet.add(name.getName());
            }
            unmodifiableSet = Collections.unmodifiableSet(hashSet);
        }
        return unmodifiableSet;
    }

    public void a(String str, String str2, com.applovin.impl.mediation.a.a aVar) {
        synchronized (this.g) {
            if (u.a()) {
                u A = this.b.A();
                A.e("MediationAdapterManager", "Adding " + str + " to list of disabled adapters.");
            }
            this.h.add(new a(str, str2, aVar, this.b));
        }
    }

    public Collection<String> b() {
        Set<T> unmodifiableSet;
        synchronized (this.d) {
            unmodifiableSet = Collections.unmodifiableSet(this.f);
        }
        return unmodifiableSet;
    }

    public Collection<JSONObject> c() {
        ArrayList arrayList;
        synchronized (this.g) {
            arrayList = new ArrayList(this.h.size());
            for (a a2 : this.h) {
                arrayList.add(a2.a());
            }
        }
        return arrayList;
    }
}

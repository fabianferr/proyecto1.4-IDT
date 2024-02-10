package com.wortise.ads;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u0001\u000fB\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0006R\u001b\u0010\u000e\u001a\u00020\t8BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0011\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0015\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001a"}, d2 = {"Lcom/wortise/ads/m1;", "", "", "e", "", "expired", "Lcom/wortise/ads/l1;", "a", "config", "Landroid/content/SharedPreferences;", "preferences$delegate", "Lkotlin/Lazy;", "c", "()Landroid/content/SharedPreferences;", "preferences", "b", "()Z", "hasExpired", "", "d", "()J", "time", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: ConfigCache.kt */
public final class m1 {
    public static final b Companion = new b((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Lazy<Long> c = LazyKt.lazy(a.a);
    /* access modifiers changed from: private */
    public final Context a;
    private final Lazy b = LazyKt.lazy(new d(this));

    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0010\t\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: ConfigCache.kt */
    static final class a extends Lambda implements Function0<Long> {
        public static final a a = new a();

        a() {
            super(0);
        }

        /* renamed from: a */
        public final Long invoke() {
            return Long.valueOf(TimeUnit.HOURS.toMillis(12));
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rR\u001b\u0010\u0007\u001a\u00020\u00028BX\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0002XT¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0002XT¢\u0006\u0006\n\u0004\b\u000b\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/wortise/ads/m1$b;", "", "", "CACHE_EXPIRE$delegate", "Lkotlin/Lazy;", "a", "()J", "CACHE_EXPIRE", "", "KEY_CONFIG", "Ljava/lang/String;", "KEY_TIME", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* compiled from: ConfigCache.kt */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final long a() {
            return ((Number) m1.c.getValue()).longValue();
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002"}, d2 = {"com/wortise/ads/utils/JsonParser$fromJson$1", "Lcom/google/gson/reflect/TypeToken;", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* compiled from: JsonParser.kt */
    public static final class c extends TypeToken<l1> {
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Landroid/content/SharedPreferences;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: ConfigCache.kt */
    static final class d extends Lambda implements Function0<SharedPreferences> {
        final /* synthetic */ m1 a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(m1 m1Var) {
            super(0);
            this.a = m1Var;
        }

        /* renamed from: a */
        public final SharedPreferences invoke() {
            return r5.a.a(this.a.a);
        }
    }

    public m1(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = context;
    }

    private final SharedPreferences c() {
        return (SharedPreferences) this.b.getValue();
    }

    public final boolean b() {
        return new Date().getTime() - d() >= Companion.a();
    }

    public final long d() {
        return c().getLong("configTime", 0);
    }

    public final void e() {
        WortiseLog.d$default("Invalidating config cache...", (Throwable) null, 2, (Object) null);
        SharedPreferences.Editor edit = c().edit();
        edit.remove("configTime");
        edit.apply();
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x000f A[Catch:{ all -> 0x0036 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.wortise.ads.l1 a(boolean r5) {
        /*
            r4 = this;
            r0 = 0
            if (r5 != 0) goto L_0x000c
            boolean r5 = r4.b()     // Catch:{ all -> 0x0036 }
            if (r5 != 0) goto L_0x000a
            goto L_0x000c
        L_0x000a:
            r5 = 0
            goto L_0x000d
        L_0x000c:
            r5 = 1
        L_0x000d:
            if (r5 == 0) goto L_0x0036
            android.content.SharedPreferences r5 = r4.c()     // Catch:{ all -> 0x0036 }
            java.lang.String r1 = "config"
            java.lang.String r5 = r5.getString(r1, r0)     // Catch:{ all -> 0x0031 }
            if (r5 != 0) goto L_0x001c
            goto L_0x0031
        L_0x001c:
            com.wortise.ads.q4 r1 = com.wortise.ads.q4.a     // Catch:{ all -> 0x0031 }
            com.wortise.ads.m1$c r2 = new com.wortise.ads.m1$c     // Catch:{ all -> 0x0031 }
            r2.<init>()     // Catch:{ all -> 0x0031 }
            java.lang.reflect.Type r2 = r2.getType()     // Catch:{ all -> 0x0031 }
            java.lang.String r3 = "object: TypeToken<T>() {}.type"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)     // Catch:{ all -> 0x0031 }
            java.lang.Object r5 = r1.a((java.lang.String) r5, (java.lang.reflect.Type) r2)     // Catch:{ all -> 0x0031 }
            goto L_0x0032
        L_0x0031:
            r5 = r0
        L_0x0032:
            com.wortise.ads.l1 r5 = (com.wortise.ads.l1) r5     // Catch:{ all -> 0x0036 }
            r0 = r5
        L_0x0036:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wortise.ads.m1.a(boolean):com.wortise.ads.l1");
    }

    public final boolean a(l1 l1Var) {
        Intrinsics.checkNotNullParameter(l1Var, "config");
        try {
            SharedPreferences.Editor edit = c().edit();
            g6.a(edit, "config", l1Var, (Type) null, 4, (Object) null);
            edit.putLong("configTime", new Date().getTime());
            edit.apply();
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}

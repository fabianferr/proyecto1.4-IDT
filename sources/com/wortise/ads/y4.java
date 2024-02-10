package com.wortise.ads;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00152\u00020\u0001:\u0001\u0003B\u0011\b\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011B\u0011\b\u0016\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0010\u0010\u0014R\u001d\u0010\u0007\u001a\u0004\u0018\u00010\u00028BX\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\u000b\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\t\u0010\nR\u001d\u0010\r\u001a\u0004\u0018\u00010\b8FX\u0002¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\f\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/wortise/ads/y4;", "", "Landroid/os/Bundle;", "a", "Lkotlin/Lazy;", "b", "()Landroid/os/Bundle;", "bundle", "", "c", "()Ljava/lang/String;", "prefix", "d", "utm", "Landroid/app/Application;", "app", "<init>", "(Landroid/app/Application;)V", "Landroid/content/Context;", "context", "(Landroid/content/Context;)V", "Companion", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: Metadata.kt */
public final class y4 {
    public static final a Companion = new a((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static y4 d;
    private final Lazy a;
    private final Lazy b;
    private final Lazy c;

    @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/wortise/ads/y4$a;", "", "Landroid/content/Context;", "context", "Lcom/wortise/ads/y4;", "a", "instance", "Lcom/wortise/ads/y4;", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Metadata.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final y4 a(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            y4 a = y4.d;
            if (a != null) {
                return a;
            }
            y4 y4Var = new y4(context);
            a aVar = y4.Companion;
            y4.d = y4Var;
            return y4Var;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n"}, d2 = {"Landroid/os/Bundle;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: Metadata.kt */
    static final class b extends Lambda implements Function0<Bundle> {
        final /* synthetic */ Application a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(Application application) {
            super(0);
            this.a = application;
        }

        /* renamed from: a */
        public final Bundle invoke() {
            Application application = this.a;
            try {
                return application.getPackageManager().getApplicationInfo(application.getPackageName(), 128).metaData;
            } catch (Throwable unused) {
                return null;
            }
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0010\u000e\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: Metadata.kt */
    static final class c extends Lambda implements Function0<String> {
        public static final c a = new c();

        c() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "com.wortise.ads";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0010\u000e\n\u0000\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: Metadata.kt */
    static final class d extends Lambda implements Function0<String> {
        final /* synthetic */ y4 a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(y4 y4Var) {
            super(0);
            this.a = y4Var;
        }

        /* renamed from: a */
        public final String invoke() {
            Bundle a2 = this.a.b();
            if (a2 == null) {
                return null;
            }
            return a2.getString(Intrinsics.stringPlus(this.a.c(), ".utm"));
        }
    }

    private y4(Application application) {
        this.a = LazyKt.lazy(new b(application));
        this.b = LazyKt.lazy(c.a);
        this.c = LazyKt.lazy(new d(this));
    }

    public final String d() {
        return (String) this.c.getValue();
    }

    /* access modifiers changed from: private */
    public final Bundle b() {
        return (Bundle) this.a.getValue();
    }

    /* access modifiers changed from: private */
    public final String c() {
        return (String) this.b.getValue();
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public y4(android.content.Context r2) {
        /*
            r1 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            android.content.Context r2 = r2.getApplicationContext()
            if (r2 == 0) goto L_0x0011
            android.app.Application r2 = (android.app.Application) r2
            r1.<init>((android.app.Application) r2)
            return
        L_0x0011:
            java.lang.NullPointerException r2 = new java.lang.NullPointerException
            java.lang.String r0 = "null cannot be cast to non-null type android.app.Application"
            r2.<init>(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wortise.ads.y4.<init>(android.content.Context):void");
    }
}

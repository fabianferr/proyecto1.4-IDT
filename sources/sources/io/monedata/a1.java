package io.monedata;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import io.monedata.extensions.PackageManagerKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u000e2\u00020\u0001:\u0001\u0003B\u0011\b\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013B\u0011\b\u0016\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0012\u0010\u0016R\u001d\u0010\u0007\u001a\u0004\u0018\u00010\u00028BX\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\u000b\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\t\u0010\nR\u001d\u0010\r\u001a\u0004\u0018\u00010\b8FX\u0002¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\f\u0010\nR\u001d\u0010\u000f\u001a\u0004\u0018\u00010\b8FX\u0002¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\u000e\u0010\n¨\u0006\u0017"}, d2 = {"Lio/monedata/a1;", "", "Landroid/os/Bundle;", "a", "Lkotlin/Lazy;", "b", "()Landroid/os/Bundle;", "bundle", "", "d", "()Ljava/lang/String;", "prefix", "c", "framework", "e", "utm", "Landroid/app/Application;", "app", "<init>", "(Landroid/app/Application;)V", "Landroid/content/Context;", "context", "(Landroid/content/Context;)V", "core_productionRelease"}, k = 1, mv = {1, 7, 1})
public final class a1 {
    public static final a e = new a((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static a1 f;
    private final Lazy a;
    private final Lazy b;
    private final Lazy c;
    private final Lazy d;

    @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lio/monedata/a1$a;", "", "Landroid/content/Context;", "context", "Lio/monedata/a1;", "a", "instance", "Lio/monedata/a1;", "<init>", "()V", "core_productionRelease"}, k = 1, mv = {1, 7, 1})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final a1 a(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            a1 a = a1.f;
            if (a != null) {
                return a;
            }
            a1 a1Var = new a1(context);
            a aVar = a1.e;
            a1.f = a1Var;
            return a1Var;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Landroid/os/Bundle;", "a", "()Landroid/os/Bundle;"}, k = 3, mv = {1, 7, 1})
    static final class b extends Lambda implements Function0<Bundle> {
        final /* synthetic */ Application a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(Application application) {
            super(0);
            this.a = application;
        }

        /* renamed from: a */
        public final Bundle invoke() {
            Object obj;
            Application application = this.a;
            try {
                Result.Companion companion = Result.Companion;
                PackageManager packageManager = application.getPackageManager();
                Intrinsics.checkNotNullExpressionValue(packageManager, "app.packageManager");
                String packageName = application.getPackageName();
                Intrinsics.checkNotNullExpressionValue(packageName, "app.packageName");
                obj = Result.m2344constructorimpl(PackageManagerKt.getCompatApplicationInfo(packageManager, packageName, 128).metaData);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.m2344constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m2350isFailureimpl(obj)) {
                obj = null;
            }
            return (Bundle) obj;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 7, 1})
    static final class c extends Lambda implements Function0<String> {
        final /* synthetic */ a1 a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(a1 a1Var) {
            super(0);
            this.a = a1Var;
        }

        /* renamed from: a */
        public final String invoke() {
            Bundle a2 = this.a.b();
            if (a2 == null) {
                return null;
            }
            return a2.getString(this.a.d() + ".framework");
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 7, 1})
    static final class d extends Lambda implements Function0<String> {
        public static final d a = new d();

        d() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return BuildConfig.LIBRARY_PACKAGE_NAME;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 7, 1})
    static final class e extends Lambda implements Function0<String> {
        final /* synthetic */ a1 a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(a1 a1Var) {
            super(0);
            this.a = a1Var;
        }

        /* renamed from: a */
        public final String invoke() {
            Bundle a2 = this.a.b();
            if (a2 == null) {
                return null;
            }
            return a2.getString(this.a.d() + ".utm");
        }
    }

    private a1(Application application) {
        this.a = LazyKt.lazy(new b(application));
        this.b = LazyKt.lazy(d.a);
        this.c = LazyKt.lazy(new c(this));
        this.d = LazyKt.lazy(new e(this));
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public a1(android.content.Context r2) {
        /*
            r1 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            android.content.Context r2 = r2.getApplicationContext()
            java.lang.String r0 = "null cannot be cast to non-null type android.app.Application"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2, r0)
            android.app.Application r2 = (android.app.Application) r2
            r1.<init>((android.app.Application) r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.monedata.a1.<init>(android.content.Context):void");
    }

    /* access modifiers changed from: private */
    public final Bundle b() {
        return (Bundle) this.a.getValue();
    }

    /* access modifiers changed from: private */
    public final String d() {
        return (String) this.b.getValue();
    }

    public final String c() {
        return (String) this.c.getValue();
    }

    public final String e() {
        return (String) this.d.getValue();
    }
}

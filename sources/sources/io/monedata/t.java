package io.monedata;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;

@Metadata(bv = {}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0004\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u0001\bB\u000f\u0012\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b\"\u0010#J7\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00072\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0002\b\u0005H\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\b\u0010\tJ \u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0007H\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\b\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\nR\u0014\u0010\u0016\u001a\u00020\u00138BX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u001c\u001a\u00020\u00178BX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001d\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\b\u0010\u0015R\u0011\u0010\u001f\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0015\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006$"}, d2 = {"Lio/monedata/t;", "", "Lkotlin/Function1;", "Landroid/content/SharedPreferences$Editor;", "", "Lkotlin/ExtensionFunctionType;", "f", "Lkotlin/Result;", "a", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Lio/monedata/s;", "e", "()Ljava/lang/Object;", "", "maxAge", "Ljava/util/concurrent/TimeUnit;", "unit", "config", "", "", "b", "()J", "currentTime", "Landroid/content/SharedPreferences;", "preferences$delegate", "Lkotlin/Lazy;", "c", "()Landroid/content/SharedPreferences;", "preferences", "currentAge", "d", "time", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "core_productionRelease"}, k = 1, mv = {1, 7, 1})
public final class t {
    public static final a c = new a((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public final Context a;
    private final Lazy b = LazyKt.lazy(new b(this));

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\b"}, d2 = {"Lio/monedata/t$a;", "", "", "KEY_CONFIG", "Ljava/lang/String;", "KEY_TIME", "<init>", "()V", "core_productionRelease"}, k = 1, mv = {1, 7, 1})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Landroid/content/SharedPreferences;", "a", "()Landroid/content/SharedPreferences;"}, k = 3, mv = {1, 7, 1})
    static final class b extends Lambda implements Function0<SharedPreferences> {
        final /* synthetic */ t a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(t tVar) {
            super(0);
            this.a = tVar;
        }

        /* renamed from: a */
        public final SharedPreferences invoke() {
            SharedPreferences sharedPreferences = this.a.a.getSharedPreferences(BuildConfig.LIBRARY_PACKAGE_NAME, 0);
            Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(\"io.monedata\", MODE_PRIVATE)");
            return sharedPreferences;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroid/content/SharedPreferences$Editor;", "", "a", "(Landroid/content/SharedPreferences$Editor;)V"}, k = 3, mv = {1, 7, 1})
    static final class c extends Lambda implements Function1<SharedPreferences.Editor, Unit> {
        final /* synthetic */ s a;
        final /* synthetic */ t b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(s sVar, t tVar) {
            super(1);
            this.a = sVar;
            this.b = tVar;
        }

        public final void a(SharedPreferences.Editor editor) {
            Intrinsics.checkNotNullParameter(editor, "$this$edit");
            u1.a(editor, "config", this.a, Reflection.getOrCreateKotlinClass(s.class));
            editor.putLong("configTime", this.b.b());
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((SharedPreferences.Editor) obj);
            return Unit.INSTANCE;
        }
    }

    public t(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = context;
    }

    private final Object a(Function1<? super SharedPreferences.Editor, Unit> function1) {
        try {
            Result.Companion companion = Result.Companion;
            u1.a(c(), function1);
            return Result.m2344constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            return Result.m2344constructorimpl(ResultKt.createFailure(th));
        }
    }

    /* access modifiers changed from: private */
    public final long b() {
        return new Date().getTime();
    }

    private final SharedPreferences c() {
        return (SharedPreferences) this.b.getValue();
    }

    private final Object e() {
        try {
            Result.Companion companion = Result.Companion;
            return Result.m2344constructorimpl((s) u1.a(c(), "config", Reflection.getOrCreateKotlinClass(s.class)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            return Result.m2344constructorimpl(ResultKt.createFailure(th));
        }
    }

    public final long a() {
        return b() - d();
    }

    public final s a(Number number, TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter(number, "maxAge");
        Intrinsics.checkNotNullParameter(timeUnit, "unit");
        s sVar = null;
        if (timeUnit.toMillis(number.longValue()) <= a()) {
            return null;
        }
        Object e = e();
        Throwable r6 = Result.m2347exceptionOrNullimpl(e);
        if (r6 != null) {
            MonedataLog.INSTANCE.e("Failed to load config from cache", r6);
        }
        if (!Result.m2350isFailureimpl(e)) {
            sVar = e;
        }
        return sVar;
    }

    public final boolean a(s sVar) {
        Intrinsics.checkNotNullParameter(sVar, "config");
        Object a2 = a((Function1<? super SharedPreferences.Editor, Unit>) new c(sVar, this));
        Throwable r0 = Result.m2347exceptionOrNullimpl(a2);
        if (r0 != null) {
            MonedataLog.INSTANCE.e("Failed to save config to cache", r0);
        }
        return Result.m2351isSuccessimpl(a2);
    }

    public final long d() {
        return c().getLong("configTime", 0);
    }
}

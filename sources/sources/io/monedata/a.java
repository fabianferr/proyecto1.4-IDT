package io.monedata;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.mbridge.msdk.MBridgeConstans;
import io.monedata.extensions.CoroutinesKt;
import io.monedata.kotlin.WeakReferenceDelegate;
import io.monedata.models.Extras;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R/\u0010\u0011\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u00028F@BX\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u0005\u0010\u000f\"\u0004\b\t\u0010\u0010R$\u0010\u0012\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b8\u0006@BX\u000e¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\t\u0010\u0014¨\u0006\u0017"}, d2 = {"Lio/monedata/a;", "", "Landroid/app/Activity;", "activity", "", "a", "Landroid/content/Context;", "context", "", "b", "Landroid/app/Application;", "app", "<set-?>", "current$delegate", "Lio/monedata/kotlin/WeakReferenceDelegate;", "()Landroid/app/Activity;", "(Landroid/app/Activity;)V", "current", "isForeground", "Z", "()Z", "<init>", "()V", "core_productionRelease"}, k = 1, mv = {1, 7, 1})
public final class a {
    public static final a a = new a();
    static final /* synthetic */ KProperty<Object>[] b = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(a.class, "current", "getCurrent()Landroid/app/Activity;", 0))};
    private static boolean c;
    private static final WeakReferenceDelegate d = new WeakReferenceDelegate();
    /* access modifiers changed from: private */
    public static boolean e;
    private static final C0201a f = new C0201a();

    @Metadata(bv = {}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0004H\u0016J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u000f"}, d2 = {"io/monedata/a$a", "Landroid/app/Application$ActivityLifecycleCallbacks;", "Landroid/app/Activity;", "activity", "Landroid/os/Bundle;", "savedInstanceState", "", "onActivityCreated", "onActivityDestroyed", "onActivityPaused", "onActivityResumed", "outState", "onActivitySaveInstanceState", "onActivityStarted", "onActivityStopped", "core_productionRelease"}, k = 1, mv = {1, 7, 1})
    /* renamed from: io.monedata.a$a  reason: collision with other inner class name */
    public static final class C0201a implements Application.ActivityLifecycleCallbacks {
        C0201a() {
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            a.a.a(activity);
        }

        public void onActivityDestroyed(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            a aVar = a.a;
            aVar.a(activity);
            if (Intrinsics.areEqual((Object) aVar.a(), (Object) activity)) {
                aVar.b((Activity) null);
            }
        }

        public void onActivityPaused(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            a.a.a(activity);
            a.e = false;
        }

        public void onActivityResumed(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            a aVar = a.a;
            aVar.a(activity);
            aVar.b(activity);
            a.e = true;
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(bundle, "outState");
        }

        public void onActivityStarted(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            a aVar = a.a;
            aVar.a(activity);
            aVar.b(activity);
        }

        public void onActivityStopped(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            a.a.a(activity);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "io.monedata.lifecycle.ActivityLifecycle$record$1$1", f = "ActivityLifecycle.kt", i = {}, l = {57, 60}, m = "invokeSuspend", n = {}, s = {})
    static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int a;
        final /* synthetic */ Context b;
        final /* synthetic */ String c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(Context context, String str, Continuation<? super b> continuation) {
            super(2, continuation);
            this.b = context;
            this.c = str;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new b(this.b, this.c, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                g0 g0Var = g0.a;
                Context context = this.b;
                String str = this.c;
                this.a = 1;
                obj = g0.a(g0Var, context, str, (Extras) null, this, 4, (Object) null);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else if (i == 2) {
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            k a2 = l.a();
            this.a = 2;
            if (a2.b((f0) obj, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }
    }

    private a() {
    }

    /* access modifiers changed from: private */
    public final synchronized void a(Activity activity) {
        if (!c) {
            c = b((Context) activity);
        }
    }

    /* access modifiers changed from: private */
    public final void b(Activity activity) {
        d.setValue(this, b[0], activity);
    }

    private final boolean b(Context context) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutinesKt.getIoScope(), CoroutinesKt.getEmptyErrorHandler(), (CoroutineStart) null, new b(context, Settings.INSTANCE.requireAssetKey$core_productionRelease(context), (Continuation<? super b>) null), 2, (Object) null);
            obj = Result.m2344constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m2344constructorimpl(ResultKt.createFailure(th));
        }
        return Result.m2351isSuccessimpl(obj);
    }

    public final Activity a() {
        return (Activity) d.getValue(this, b[0]);
    }

    public final void a(Application application) {
        Intrinsics.checkNotNullParameter(application, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
        Activity a2 = a();
        if (a2 != null) {
            a.a(a2);
        }
        application.registerActivityLifecycleCallbacks(f);
    }

    public final void a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (context instanceof Activity) {
            b((Activity) context);
        }
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNull(applicationContext, "null cannot be cast to non-null type android.app.Application");
        a((Application) applicationContext);
    }

    public final boolean b() {
        return e;
    }
}

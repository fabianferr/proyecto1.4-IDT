package com.wortise.ads;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.mbridge.msdk.MBridgeConstans;
import kotlin.Metadata;
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

@Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R/\u0010\u0011\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u00028F@BX\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u0005\u0010\u000f\"\u0004\b\t\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/wortise/ads/b;", "", "Landroid/app/Activity;", "activity", "", "a", "Landroid/content/Context;", "context", "", "b", "Landroid/app/Application;", "app", "<set-?>", "current$delegate", "Lcom/wortise/ads/b7;", "()Landroid/app/Activity;", "(Landroid/app/Activity;)V", "current", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: ActivityLifecycle.kt */
public final class b {
    public static final b a = new b();
    static final /* synthetic */ KProperty<Object>[] b = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(b.class, "current", "getCurrent()Landroid/app/Activity;", 0))};
    private static boolean c;
    private static final b7 d = new b7();
    private static final a e = new a();

    @Metadata(bv = {}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\r"}, d2 = {"com/wortise/ads/b$a", "Lcom/wortise/ads/h2;", "Landroid/app/Activity;", "activity", "Landroid/os/Bundle;", "savedInstanceState", "", "onActivityCreated", "onActivityDestroyed", "onActivityPaused", "onActivityResumed", "onActivityStarted", "onActivityStopped", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* compiled from: ActivityLifecycle.kt */
    public static final class a extends h2 {
        a() {
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            b.a.a(activity);
        }

        public void onActivityDestroyed(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            b bVar = b.a;
            bVar.a(activity);
            if (Intrinsics.areEqual((Object) bVar.a(), (Object) activity)) {
                bVar.b((Activity) null);
            }
        }

        public void onActivityPaused(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            b.a.a(activity);
        }

        public void onActivityResumed(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            b bVar = b.a;
            bVar.a(activity);
            bVar.b(activity);
        }

        public void onActivityStarted(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            b bVar = b.a;
            bVar.a(activity);
            bVar.b(activity);
        }

        public void onActivityStopped(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            b.a.a(activity);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.wortise.ads.lifecycle.ActivityLifecycle$notify$1$1", f = "ActivityLifecycle.kt", i = {}, l = {45}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.wortise.ads.b$b  reason: collision with other inner class name */
    /* compiled from: ActivityLifecycle.kt */
    static final class C0179b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int a;
        final /* synthetic */ Context b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0179b(Context context, Continuation<? super C0179b> continuation) {
            super(2, continuation);
            this.b = context;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C0179b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C0179b(this.b, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                l0 l0Var = new l0(this.b);
                w a2 = x.a();
                this.a = 1;
                if (a2.a(l0Var, (Continuation<? super w5<Unit>>) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    private b() {
    }

    /* access modifiers changed from: private */
    public final void b(Activity activity) {
        d.a(this, b[0], activity);
    }

    public final Activity a() {
        return (Activity) d.a(this, b[0]);
    }

    /* access modifiers changed from: private */
    public final synchronized void a(Activity activity) {
        if (!c) {
            c = b((Context) activity);
        }
    }

    private final boolean b(Context context) {
        try {
            AdSettings.INSTANCE.requireAssetKey$sdk_productionRelease(context);
            Job unused = BuildersKt__Builders_commonKt.launch$default(c2.b(), c2.a(), (CoroutineStart) null, new C0179b(context, (Continuation<? super C0179b>) null), 2, (Object) null);
            return true;
        } catch (Throwable unused2) {
            return false;
        }
    }

    public final void a(Application application) {
        Intrinsics.checkNotNullParameter(application, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
        Activity a2 = a();
        if (a2 != null) {
            a.a(a2);
        }
        application.registerActivityLifecycleCallbacks(e);
    }

    public final void a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (context instanceof Activity) {
            b((Activity) context);
        }
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            a((Application) applicationContext);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.app.Application");
    }
}

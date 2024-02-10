package com.m2catalyst.m2sdk;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.m2catalyst.m2sdk.external.M2SDK;
import com.m2catalyst.m2sdk.logger.M2SDKLogger;
import com.m2catalyst.m2sdk.s5;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: M2LifecycleCallback.kt */
public final class u2 implements Application.ActivityLifecycleCallbacks {

    @DebugMetadata(c = "com.m2catalyst.m2sdk.permissions.M2LifecycleCallback$onActivityStarted$1", f = "M2LifecycleCallback.kt", i = {}, l = {30}, m = "invokeSuspend", n = {}, s = {})
    /* compiled from: M2LifecycleCallback.kt */
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int a;
        public final /* synthetic */ Activity b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Activity activity, Continuation<? super a> continuation) {
            super(2, continuation);
            this.b = activity;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new a(this.b, continuation);
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((a) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                M2SDK m2sdk = M2SDK.INSTANCE;
                Context applicationContext = this.b.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext, "activity.applicationContext");
                this.a = 1;
                if (m2sdk.initialize$m2sdk_release(applicationContext, this) == coroutine_suspended) {
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

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    public final void onActivityDestroyed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    public final void onActivityPaused(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    public final void onActivityResumed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(bundle, "outState");
    }

    public final void onActivityStarted(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        M2SDKLogger.Companion companion = M2SDKLogger.Companion;
        M2SDK m2sdk = M2SDK.INSTANCE;
        boolean isMonitoring = m2sdk.isMonitoring();
        boolean initAttempt$m2sdk_release = m2sdk.getInitAttempt$m2sdk_release();
        boolean c = s5.a.a().c();
        boolean startAttempt$m2sdk_release = m2sdk.getStartAttempt$m2sdk_release();
        companion.i("M2LifecycleCallback", "onActivityStarted M2SDK.isCollectionOn()=" + isMonitoring + " initAttempt=" + initAttempt$m2sdk_release + " isInitialized()=" + c + "startAttempt " + startAttempt$m2sdk_release, new String[0]);
        if (m2sdk.isMonitoring()) {
            companion.i("M2LifecycleCallback", "M2SDK.checkPermissionsAndRestartCollection", new String[0]);
            Context applicationContext = activity.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "activity.applicationContext");
            m2sdk.checkPermissionsAndRestartCollection$m2sdk_release(applicationContext);
        }
        if (m2sdk.getInitAttempt$m2sdk_release() && !s5.a.a().c()) {
            companion.i("M2LifecycleCallback", "REINITIALIZE", new String[0]);
            j3.b(new a(activity, (Continuation<? super a>) null));
        }
        if (m2sdk.getStartAttempt$m2sdk_release() && !m2sdk.isMonitoring()) {
            companion.i("M2LifecycleCallback", "RESTART", new String[0]);
            Context applicationContext2 = activity.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext2, "activity.applicationContext");
            m2sdk.turnOnDataCollection(applicationContext2);
        }
    }

    public final void onActivityStopped(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }
}

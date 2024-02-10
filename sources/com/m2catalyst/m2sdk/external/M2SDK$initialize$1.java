package com.m2catalyst.m2sdk.external;

import android.app.Application;
import android.content.SharedPreferences;
import com.m2catalyst.m2sdk.a6;
import com.m2catalyst.m2sdk.business.repositories.DeviceRepository;
import com.m2catalyst.m2sdk.logger.M2SDKLogger;
import com.m2catalyst.m2sdk.r2;
import com.m2catalyst.m2sdk.s5;
import com.m2catalyst.m2sdk.u2;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.m2catalyst.m2sdk.external.M2SDK$initialize$1", f = "M2SDK.kt", i = {}, l = {71}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: M2SDK.kt */
public final class M2SDK$initialize$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Application $application;
    final /* synthetic */ M2SDKConfiguration $configuration;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public M2SDK$initialize$1(Application application, M2SDKConfiguration m2SDKConfiguration, Continuation<? super M2SDK$initialize$1> continuation) {
        super(2, continuation);
        this.$application = application;
        this.$configuration = m2SDKConfiguration;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new M2SDK$initialize$1(this.$application, this.$configuration, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((M2SDK$initialize$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Boolean bool;
        int i;
        Object obj2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            M2SDKLogger.Companion companion = M2SDKLogger.Companion;
            companion.i("M2SDK", "Init job queued", new String[0]);
            M2SDK m2sdk = M2SDK.INSTANCE;
            m2sdk.setInitAttempt$m2sdk_release(true);
            if (s5.i == null) {
                s5.i = new s5();
            }
            s5 s5Var = s5.i;
            Intrinsics.checkNotNull(s5Var);
            if (s5Var.a.e()) {
                companion.i("M2SDK", "SDK Already initialized, skip initialization.", new String[0]);
                return Unit.INSTANCE;
            }
            if (r2.j == null) {
                r2.j = new r2();
            }
            r2 r2Var = r2.j;
            Intrinsics.checkNotNull(r2Var);
            Application application = this.$application;
            r2Var.getClass();
            Intrinsics.checkNotNullParameter(application, "context");
            String str = null;
            if (application == null) {
                bool = null;
            } else {
                SharedPreferences sharedPreferences = application.getSharedPreferences("ServerIds", 0);
                Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…ds, Context.MODE_PRIVATE)");
                bool = Boolean.valueOf(sharedPreferences.getBoolean("NCICrowdsourceSharing", true));
            }
            if (application == null) {
                i = -3;
            } else {
                SharedPreferences sharedPreferences2 = application.getSharedPreferences("ServerIds", 0);
                Intrinsics.checkNotNullExpressionValue(sharedPreferences2, "context.getSharedPrefere…ds, Context.MODE_PRIVATE)");
                i = sharedPreferences2.getInt("device_id", -3);
            }
            if (application == null) {
                obj2 = coroutine_suspended;
            } else {
                obj2 = coroutine_suspended;
                SharedPreferences sharedPreferences3 = application.getSharedPreferences(DeviceRepository.SYNC_DEVICE_PREFS, 0);
                Intrinsics.checkNotNullExpressionValue(sharedPreferences3, "context.getSharedPrefere…fo, Context.MODE_PRIVATE)");
                str = sharedPreferences3.getString("deviceGuid", (String) null);
            }
            if (bool != null) {
                r2Var.a().a(a6.CROWDSOURCE_SHARING_ENABLED, bool);
                if (application != null) {
                    SharedPreferences sharedPreferences4 = application.getSharedPreferences("ServerIds", 0);
                    Intrinsics.checkNotNullExpressionValue(sharedPreferences4, "context.getSharedPrefere…ds, Context.MODE_PRIVATE)");
                    sharedPreferences4.edit().remove("NCICrowdsourceSharing").apply();
                }
            }
            if (i != -3) {
                r2Var.a().a(a6.DEVICE_ID, Integer.valueOf(i));
                if (application != null) {
                    SharedPreferences sharedPreferences5 = application.getSharedPreferences("ServerIds", 0);
                    Intrinsics.checkNotNullExpressionValue(sharedPreferences5, "context.getSharedPrefere…ds, Context.MODE_PRIVATE)");
                    sharedPreferences5.edit().remove("device_id").apply();
                }
            }
            if (str != null) {
                r2Var.a().a(a6.M2_UUID, str);
                if (application != null) {
                    SharedPreferences sharedPreferences6 = application.getSharedPreferences(DeviceRepository.SYNC_DEVICE_PREFS, 0);
                    Intrinsics.checkNotNullExpressionValue(sharedPreferences6, "context.getSharedPrefere…fo, Context.MODE_PRIVATE)");
                    sharedPreferences6.edit().remove("deviceGuid").apply();
                }
            }
            if (r2.j == null) {
                r2.j = new r2();
            }
            r2 r2Var2 = r2.j;
            Intrinsics.checkNotNull(r2Var2);
            M2SDKConfiguration m2SDKConfiguration = this.$configuration;
            r2Var2.getClass();
            Intrinsics.checkNotNullParameter(m2SDKConfiguration, "configuration");
            r2Var2.a((Object) m2SDKConfiguration);
            r2Var2.a(true);
            if (r2.j == null) {
                r2.j = new r2();
            }
            r2 r2Var3 = r2.j;
            Intrinsics.checkNotNull(r2Var3);
            r2Var3.a(this.$configuration);
            m2sdk.setExceptionHandler();
            try {
                this.$application.registerActivityLifecycleCallbacks(new u2());
            } catch (Exception unused) {
                M2SDKLogger.Companion.logError$default(M2SDKLogger.Companion, "Lifecycle callback", "Exception while registering lifecycle callback", (Exception) null, false, 12, (Object) null);
            }
            M2SDK m2sdk2 = M2SDK.INSTANCE;
            Application application2 = this.$application;
            this.label = 1;
            Object initialize$m2sdk_release = m2sdk2.initialize$m2sdk_release(application2, this);
            Object obj3 = obj2;
            if (initialize$m2sdk_release == obj3) {
                return obj3;
            }
        } else if (i2 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}

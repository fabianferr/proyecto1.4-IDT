package com.wortise.ads.consent;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.gson.reflect.TypeToken;
import com.wortise.ads.AdSettings;
import com.wortise.ads.c2;
import com.wortise.ads.consent.ConsentDialog;
import com.wortise.ads.consent.ConsentSubmitWorker;
import com.wortise.ads.consent.models.ConsentData;
import com.wortise.ads.consent.models.ConsentSource;
import com.wortise.ads.g6;
import com.wortise.ads.i6;
import com.wortise.ads.l1;
import com.wortise.ads.n1;
import com.wortise.ads.q4;
import com.wortise.ads.r1;
import com.wortise.ads.r5;
import com.wortise.ads.s1;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u000b\u001a\u00020\t2\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007j\u0002`\nH\u0007J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u001f\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\bH\u0000¢\u0006\u0002\b\u0013J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u0017\u0010\u0017\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007¢\u0006\u0002\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J \u0010\u001a\u001a\u00020\t2\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007j\u0002`\nH\u0007J&\u0010\u001b\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u001c\u001a\u00020\u000e2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u001dH\u0007J&\u0010\u001e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u001c\u001a\u00020\u000e2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u001dH\u0007J%\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u000eH\u0000¢\u0006\u0002\b!J\u0018\u0010\u001f\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u000eH\u0007J\u0018\u0010#\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u0004H\u0007J\u0010\u0010 \u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J%\u0010%\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010&\u001a\u0004\u0018\u00010\bH@ø\u0001\u0000¢\u0006\u0004\b'\u0010(J\u0018\u0010)\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R$\u0010\u0005\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007j\u0002`\n0\u0006X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006*"}, d2 = {"Lcom/wortise/ads/consent/ConsentManager;", "", "()V", "KEY_DATA", "", "listeners", "", "Lkotlin/Function1;", "Lcom/wortise/ads/consent/models/ConsentData;", "", "Lcom/wortise/ads/consent/ConsentListener;", "addListener", "listener", "canCollectData", "", "context", "Landroid/content/Context;", "canRequestPersonalizedAds", "consent", "canRequestPersonalizedAds$sdk_productionRelease", "cancelSubmit", "Lkotlinx/coroutines/Job;", "get", "isGranted", "(Landroid/content/Context;)Ljava/lang/Boolean;", "isReplied", "removeListener", "request", "withOptOut", "Lcom/wortise/ads/consent/ConsentDialog$Listener;", "requestOnce", "set", "submit", "set$sdk_productionRelease", "granted", "setIabString", "value", "sync", "remote", "sync$sdk_productionRelease", "(Landroid/content/Context;Lcom/wortise/ads/consent/models/ConsentData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "update", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: ConsentManager.kt */
public final class ConsentManager {
    public static final ConsentManager INSTANCE = new ConsentManager();
    private static final String KEY_DATA = "consentData";
    private static final List<Function1<ConsentData, Unit>> listeners = new ArrayList();

    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.wortise.ads.consent.ConsentManager$cancelSubmit$1", f = "ConsentManager.kt", i = {}, l = {31}, m = "invokeSuspend", n = {}, s = {})
    /* compiled from: ConsentManager.kt */
    static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int a;
        final /* synthetic */ Context b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(Context context, Continuation<? super a> continuation) {
            super(2, continuation);
            this.b = context;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new a(this.b, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ConsentSubmitWorker.a aVar = ConsentSubmitWorker.Companion;
                Context context = this.b;
                this.a = 1;
                if (aVar.a(context, this) == coroutine_suspended) {
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

    @Metadata(bv = {}, d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002"}, d2 = {"com/wortise/ads/utils/JsonParser$fromJson$1", "Lcom/google/gson/reflect/TypeToken;", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* compiled from: JsonParser.kt */
    public static final class b extends TypeToken<ConsentData> {
    }

    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.wortise.ads.consent.ConsentManager$submit$1", f = "ConsentManager.kt", i = {}, l = {36}, m = "invokeSuspend", n = {}, s = {})
    /* compiled from: ConsentManager.kt */
    static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int a;
        final /* synthetic */ Context b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(Context context, Continuation<? super c> continuation) {
            super(2, continuation);
            this.b = context;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((c) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new c(this.b, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (ConsentManager.isReplied(this.b)) {
                    ConsentSubmitWorker.a aVar = ConsentSubmitWorker.Companion;
                    Context context = this.b;
                    this.a = 1;
                    if (aVar.b(context, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    private ConsentManager() {
    }

    @JvmStatic
    public static final void addListener(Function1<? super ConsentData, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        listeners.add(function1);
    }

    @JvmStatic
    public static final boolean canCollectData(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ConsentData consentData = get(context);
        return consentData != null && consentData.canCollectData(context);
    }

    @JvmStatic
    public static final boolean canRequestPersonalizedAds(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return INSTANCE.canRequestPersonalizedAds$sdk_productionRelease(context, get(context));
    }

    private final Job cancelSubmit(Context context) {
        return BuildersKt__Builders_commonKt.launch$default(c2.c(), (CoroutineContext) null, (CoroutineStart) null, new a(context, (Continuation<? super a>) null), 3, (Object) null);
    }

    @JvmStatic
    public static final ConsentData get(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object obj = null;
        try {
            String string = r5.a.a(context).getString(KEY_DATA, (String) null);
            if (string != null) {
                q4 q4Var = q4.a;
                Type type = new b().getType();
                Intrinsics.checkNotNullExpressionValue(type, "object: TypeToken<T>() {}.type");
                obj = q4Var.a(string, type);
            }
        } catch (Throwable unused) {
        }
        return (ConsentData) obj;
    }

    @JvmStatic
    public static final Boolean isGranted(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ConsentData consentData = get(context);
        if (consentData == null) {
            return null;
        }
        return Boolean.valueOf(consentData.getGranted());
    }

    @JvmStatic
    public static final boolean isReplied(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return r5.a.a(context).contains(KEY_DATA);
    }

    @JvmStatic
    public static final void removeListener(Function1<? super ConsentData, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        listeners.remove(function1);
    }

    @JvmStatic
    public static final void request(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        request$default(context, false, (ConsentDialog.Listener) null, 6, (Object) null);
    }

    @JvmStatic
    public static final void request(Context context, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        request$default(context, z, (ConsentDialog.Listener) null, 4, (Object) null);
    }

    @JvmStatic
    public static final void request(Context context, boolean z, ConsentDialog.Listener listener) {
        Intrinsics.checkNotNullParameter(context, "context");
        s1 s1Var = new s1(context);
        s1Var.a(listener);
        s1Var.a(z);
        s1Var.g();
    }

    public static /* synthetic */ void request$default(Context context, boolean z, ConsentDialog.Listener listener, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            listener = null;
        }
        request(context, z, listener);
    }

    @JvmStatic
    public static final void requestOnce(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        requestOnce$default(context, false, (ConsentDialog.Listener) null, 6, (Object) null);
    }

    @JvmStatic
    public static final void requestOnce(Context context, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        requestOnce$default(context, z, (ConsentDialog.Listener) null, 4, (Object) null);
    }

    @JvmStatic
    public static final void requestOnce(Context context, boolean z, ConsentDialog.Listener listener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Boolean isGranted = isGranted(context);
        if (isGranted == null) {
            request(context, z, listener);
        } else if (listener != null) {
            listener.onConsentRequestFinished(isGranted);
        }
    }

    public static /* synthetic */ void requestOnce$default(Context context, boolean z, ConsentDialog.Listener listener, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            listener = null;
        }
        requestOnce(context, z, listener);
    }

    @JvmStatic
    public static final void set(Context context, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        INSTANCE.update(context, new ConsentData(new Date(), z, (String) null, ConsentSource.EXTERNAL, 4, (DefaultConstructorMarker) null));
    }

    @JvmStatic
    public static final void setIabString(Context context, String str) {
        ConsentData consentData;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "value");
        try {
            consentData = i6.a.a(str);
        } catch (Throwable unused) {
            consentData = null;
        }
        if (consentData != null) {
            INSTANCE.update(context, consentData);
            return;
        }
        throw new IllegalArgumentException("Invalid IAB string".toString());
    }

    private final Job submit(Context context) {
        return BuildersKt__Builders_commonKt.launch$default(c2.c(), (CoroutineContext) null, (CoroutineStart) null, new c(context, (Continuation<? super c>) null), 3, (Object) null);
    }

    private final void update(Context context, ConsentData consentData) {
        if (!r1.b(consentData, get(context))) {
            set$sdk_productionRelease(context, consentData, true);
        }
    }

    public final boolean canRequestPersonalizedAds$sdk_productionRelease(Context context, ConsentData consentData) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (AdSettings.isChildDirected(context)) {
            return false;
        }
        if (consentData != null && consentData.canCollectData(context)) {
            return true;
        }
        l1 a2 = n1.a();
        if (a2 == null) {
            return false;
        }
        return Intrinsics.areEqual((Object) a2.c(), (Object) Boolean.FALSE);
    }

    public final boolean set$sdk_productionRelease(Context context, ConsentData consentData, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(consentData, "consent");
        if (!r1.c(consentData, get(context))) {
            return false;
        }
        SharedPreferences.Editor edit = r5.a.a(context).edit();
        g6.a(edit, KEY_DATA, consentData, (Type) null, 4, (Object) null);
        edit.apply();
        for (Function1 invoke : listeners) {
            invoke.invoke(consentData);
        }
        if (!z) {
            return true;
        }
        submit(context);
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000d, code lost:
        if (com.wortise.ads.r1.d(r0, r7) == true) goto L_0x0011;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object sync$sdk_productionRelease(android.content.Context r6, com.wortise.ads.consent.models.ConsentData r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r5 = this;
            com.wortise.ads.consent.models.ConsentData r0 = get(r6)
            r1 = 0
            if (r0 != 0) goto L_0x0008
            goto L_0x0010
        L_0x0008:
            boolean r2 = com.wortise.ads.r1.d(r0, r7)
            r3 = 1
            if (r2 != r3) goto L_0x0010
            goto L_0x0011
        L_0x0010:
            r3 = 0
        L_0x0011:
            r2 = 2
            r4 = 0
            if (r3 == 0) goto L_0x0040
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r3 = "Submitting consent as remote copy is outdated\nRemote: "
            r1.<init>(r3)
            r1.append(r7)
            java.lang.String r7 = "\nLocal:  "
            r1.append(r7)
            r1.append(r0)
            java.lang.String r7 = r1.toString()
            com.wortise.ads.WortiseLog.d$default((java.lang.String) r7, (java.lang.Throwable) r4, (int) r2, (java.lang.Object) r4)
            kotlinx.coroutines.Job r6 = r5.submit(r6)
            java.lang.Object r6 = r6.join(r8)
            java.lang.Object r7 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r6 != r7) goto L_0x003d
            return r6
        L_0x003d:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L_0x0040:
            if (r7 == 0) goto L_0x0074
            boolean r1 = r5.set$sdk_productionRelease(r6, r7, r1)
            if (r1 != 0) goto L_0x0049
            goto L_0x0074
        L_0x0049:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r3 = "Consent was updated from remote copy\nLocal:  "
            r1.<init>(r3)
            r1.append(r0)
            java.lang.String r0 = "\nRemote: "
            r1.append(r0)
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            com.wortise.ads.WortiseLog.d$default((java.lang.String) r7, (java.lang.Throwable) r4, (int) r2, (java.lang.Object) r4)
            kotlinx.coroutines.Job r6 = r5.cancelSubmit(r6)
            java.lang.Object r6 = r6.join(r8)
            java.lang.Object r7 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r6 != r7) goto L_0x0071
            return r6
        L_0x0071:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L_0x0074:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wortise.ads.consent.ConsentManager.sync$sdk_productionRelease(android.content.Context, com.wortise.ads.consent.models.ConsentData, kotlin.coroutines.Continuation):java.lang.Object");
    }
}

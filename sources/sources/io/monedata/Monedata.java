package io.monedata;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import io.monedata.activities.AdaptersActivity;
import io.monedata.consent.ConsentManager;
import io.monedata.extensions.CoroutinesKt;
import io.monedata.partners.PartnerAdapter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(bv = {}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\f\n\u0002\u0010 \n\u0002\b\u000b\bÇ\u0002\u0018\u00002\u00020\u0001:\u00019B\t\b\u0002¢\u0006\u0004\b8\u0010*J#\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH@ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\r\u001a\u00020\u0006H\u0002J \u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000fH\u0007J!\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u000fH\u0007¢\u0006\u0004\b\u0013\u0010\u0014J:\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u0015\u001a\u00020\u000f2\u0016\b\u0002\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0016H\u0007J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u001c\u0010\u001b\u001a\u00020\u00062\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00060\u0016H\u0007R\u0014\u0010\u001d\u001a\u00020\u001c8\u0006X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010 \u001a\u00020\u001f8\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R(\u0010#\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00060\u00160\"8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b#\u0010$R*\u0010&\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u000f8\u0006@BX\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u0012\u0004\b)\u0010*\u001a\u0004\b&\u0010(R*\u0010+\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u000f8\u0006@BX\u000e¢\u0006\u0012\n\u0004\b+\u0010'\u0012\u0004\b,\u0010*\u001a\u0004\b+\u0010(R*\u0010-\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u000f8\u0006@BX\u000e¢\u0006\u0012\n\u0004\b-\u0010'\u0012\u0004\b.\u0010*\u001a\u0004\b-\u0010(R \u00103\u001a\b\u0012\u0004\u0012\u00020\t0/8FX\u0004¢\u0006\f\u0012\u0004\b2\u0010*\u001a\u0004\b0\u00101R\u001a\u00107\u001a\u00020\t8FX\u0004¢\u0006\f\u0012\u0004\b6\u0010*\u001a\u0004\b4\u00105\u0002\u0004\n\u0002\b\u0019¨\u0006:"}, d2 = {"Lio/monedata/Monedata;", "", "Landroid/content/Context;", "context", "Lio/monedata/s;", "config", "", "onConfigFetched", "(Landroid/content/Context;Lio/monedata/s;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "assetKey", "doInitialize", "(Landroid/content/Context;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invokeListeners", "id", "", "value", "disableAdapter", "enable", "enableBackgroundLocation", "(Landroid/content/Context;Ljava/lang/Boolean;)V", "start", "Lkotlin/Function1;", "listener", "initialize", "startAdaptersActivity", "stop", "waitForInitialization", "Lio/monedata/consent/ConsentManager;", "Consent", "Lio/monedata/consent/ConsentManager;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "initRequested", "Ljava/util/concurrent/atomic/AtomicBoolean;", "", "listeners", "Ljava/util/List;", "<set-?>", "isInitialized", "Z", "()Z", "isInitialized$annotations", "()V", "isReady", "isReady$annotations", "isStarted", "isStarted$annotations", "", "getFoundAdapters", "()Ljava/util/List;", "getFoundAdapters$annotations", "foundAdapters", "getVersionName", "()Ljava/lang/String;", "getVersionName$annotations", "versionName", "<init>", "Coroutines", "core_productionRelease"}, k = 1, mv = {1, 7, 1})
public final class Monedata {
    public static final ConsentManager Consent = ConsentManager.INSTANCE;
    public static final Monedata INSTANCE = new Monedata();
    /* access modifiers changed from: private */
    public static final AtomicBoolean initRequested = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public static boolean isInitialized;
    /* access modifiers changed from: private */
    public static boolean isReady;
    private static boolean isStarted;
    private static List<Function1<Boolean, Unit>> listeners = new ArrayList();

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J+\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u0004H@ø\u0001\u0000¢\u0006\u0002\u0010\nJ\u0011\u0010\u000b\u001a\u00020\u0004H@ø\u0001\u0000¢\u0006\u0002\u0010\f\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {"Lio/monedata/Monedata$Coroutines;", "", "()V", "initialize", "", "context", "Landroid/content/Context;", "assetKey", "", "start", "(Landroid/content/Context;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "waitForInitialization", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "core_productionRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Coroutines {
        public static final Coroutines INSTANCE = new Coroutines();

        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        @DebugMetadata(c = "io.monedata.Monedata$Coroutines", f = "Monedata.kt", i = {1, 1}, l = {208, 232, 252}, m = "initialize", n = {"app", "start"}, s = {"L$0", "Z$0"})
        static final class a extends ContinuationImpl {
            boolean a;
            Object b;
            /* synthetic */ Object c;
            final /* synthetic */ Coroutines d;
            int e;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(Coroutines coroutines, Continuation<? super a> continuation) {
                super(continuation);
                this.d = coroutines;
            }

            public final Object invokeSuspend(Object obj) {
                this.c = obj;
                this.e |= Integer.MIN_VALUE;
                return this.d.initialize((Context) null, (String) null, false, this);
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
        @DebugMetadata(c = "io.monedata.Monedata$Coroutines$initialize$2", f = "Monedata.kt", i = {}, l = {232}, m = "invokeSuspend", n = {}, s = {})
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
                    Monedata monedata = Monedata.INSTANCE;
                    Context context = this.b;
                    Intrinsics.checkNotNullExpressionValue(context, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
                    String str = this.c;
                    this.a = 1;
                    if (monedata.doInitialize(context, str, this) == coroutine_suspended) {
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

        @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
        @DebugMetadata(c = "io.monedata.Monedata$Coroutines$initialize$3", f = "Monedata.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int a;

            c(Continuation<? super c> continuation) {
                super(2, continuation);
            }

            /* renamed from: a */
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((c) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new c(continuation);
            }

            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.a == 0) {
                    ResultKt.throwOnFailure(obj);
                    Monedata.INSTANCE.invokeListeners();
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* synthetic */ class d extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
            d(Object obj) {
                super(1, obj, ContinuationKt.class, CampaignEx.JSON_NATIVE_VIDEO_RESUME, "resume(Lkotlin/coroutines/Continuation;Ljava/lang/Object;)V", 1);
            }

            public final void a(boolean z) {
                Boolean valueOf = Boolean.valueOf(z);
                Result.Companion companion = Result.Companion;
                ((Continuation) this.receiver).resumeWith(Result.m2344constructorimpl(valueOf));
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a(((Boolean) obj).booleanValue());
                return Unit.INSTANCE;
            }
        }

        private Coroutines() {
        }

        public static /* synthetic */ Object initialize$default(Coroutines coroutines, Context context, String str, boolean z, Continuation continuation, int i, Object obj) {
            if ((i & 4) != 0) {
                z = true;
            }
            return coroutines.initialize(context, str, z, continuation);
        }

        /* JADX WARNING: Removed duplicated region for block: B:19:0x004e  */
        /* JADX WARNING: Removed duplicated region for block: B:41:0x00d3  */
        /* JADX WARNING: Removed duplicated region for block: B:44:0x00ec A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object initialize(android.content.Context r11, java.lang.String r12, boolean r13, kotlin.coroutines.Continuation<? super java.lang.Boolean> r14) {
            /*
                r10 = this;
                boolean r0 = r14 instanceof io.monedata.Monedata.Coroutines.a
                if (r0 == 0) goto L_0x0013
                r0 = r14
                io.monedata.Monedata$Coroutines$a r0 = (io.monedata.Monedata.Coroutines.a) r0
                int r1 = r0.e
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L_0x0013
                int r1 = r1 - r2
                r0.e = r1
                goto L_0x0018
            L_0x0013:
                io.monedata.Monedata$Coroutines$a r0 = new io.monedata.Monedata$Coroutines$a
                r0.<init>(r10, r14)
            L_0x0018:
                java.lang.Object r14 = r0.c
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.e
                java.lang.String r3 = "app"
                r4 = 3
                r5 = 0
                r6 = 2
                r7 = 0
                r8 = 1
                if (r2 == 0) goto L_0x004e
                if (r2 == r8) goto L_0x004a
                if (r2 == r6) goto L_0x003c
                if (r2 != r4) goto L_0x0034
                kotlin.ResultKt.throwOnFailure(r14)
                goto L_0x00ed
            L_0x0034:
                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
                r11.<init>(r12)
                throw r11
            L_0x003c:
                boolean r13 = r0.a
                java.lang.Object r11 = r0.b
                android.content.Context r11 = (android.content.Context) r11
                kotlin.ResultKt.throwOnFailure(r14)     // Catch:{ all -> 0x0047 }
                goto L_0x00c0
            L_0x0047:
                r12 = move-exception
                goto L_0x00c4
            L_0x004a:
                kotlin.ResultKt.throwOnFailure(r14)
                goto L_0x006f
            L_0x004e:
                kotlin.ResultKt.throwOnFailure(r14)
                boolean r14 = io.monedata.extensions.ContextKt.isMainProcess(r11)
                if (r14 != 0) goto L_0x005c
                java.lang.Boolean r11 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
                return r11
            L_0x005c:
                java.util.concurrent.atomic.AtomicBoolean r14 = io.monedata.Monedata.initRequested
                boolean r14 = r14.compareAndSet(r5, r8)
                if (r14 != 0) goto L_0x0070
                r0.e = r8
                java.lang.Object r14 = r10.waitForInitialization(r0)
                if (r14 != r1) goto L_0x006f
                return r1
            L_0x006f:
                return r14
            L_0x0070:
                io.monedata.MonedataLog r14 = io.monedata.MonedataLog.INSTANCE
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                java.lang.String r9 = "Initializing Monedata SDK (assetKey = "
                r2.<init>(r9)
                r2.append(r12)
                java.lang.String r9 = ", start = "
                r2.append(r9)
                r2.append(r13)
                r9 = 41
                r2.append(r9)
                java.lang.String r2 = r2.toString()
                io.monedata.MonedataLog.v$default((io.monedata.MonedataLog) r14, (java.lang.String) r2, (java.lang.Throwable) r7, (int) r6, (java.lang.Object) r7)
                android.content.Context r14 = r11.getApplicationContext()
                io.monedata.Settings r2 = io.monedata.Settings.INSTANCE
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r14, r3)
                r2.setAssetKey$core_productionRelease(r14, r12)
                io.monedata.j1 r2 = io.monedata.j1.a
                r2.b(r14)
                r2.c(r14)
                io.monedata.l1 r2 = io.monedata.l1.a
                r2.b(r11)
                kotlinx.coroutines.CoroutineDispatcher r11 = kotlinx.coroutines.Dispatchers.getIO()     // Catch:{ all -> 0x00c2 }
                io.monedata.Monedata$Coroutines$b r2 = new io.monedata.Monedata$Coroutines$b     // Catch:{ all -> 0x00c2 }
                r2.<init>(r14, r12, r7)     // Catch:{ all -> 0x00c2 }
                r0.b = r14     // Catch:{ all -> 0x00c2 }
                r0.a = r13     // Catch:{ all -> 0x00c2 }
                r0.e = r6     // Catch:{ all -> 0x00c2 }
                java.lang.Object r11 = kotlinx.coroutines.BuildersKt.withContext(r11, r2, r0)     // Catch:{ all -> 0x00c2 }
                if (r11 != r1) goto L_0x00bf
                return r1
            L_0x00bf:
                r11 = r14
            L_0x00c0:
                r5 = 1
                goto L_0x00cb
            L_0x00c2:
                r12 = move-exception
                r11 = r14
            L_0x00c4:
                io.monedata.MonedataLog r14 = io.monedata.MonedataLog.INSTANCE
                java.lang.String r2 = "Monedata SDK could not be initialized"
                r14.e((java.lang.String) r2, (java.lang.Throwable) r12)
            L_0x00cb:
                io.monedata.Monedata.isReady = r5
                io.monedata.Monedata.isInitialized = r8
                if (r13 == 0) goto L_0x00d9
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r3)
                io.monedata.Monedata.start(r11)
            L_0x00d9:
                kotlinx.coroutines.MainCoroutineDispatcher r11 = kotlinx.coroutines.Dispatchers.getMain()
                io.monedata.Monedata$Coroutines$c r12 = new io.monedata.Monedata$Coroutines$c
                r12.<init>(r7)
                r0.b = r7
                r0.e = r4
                java.lang.Object r11 = kotlinx.coroutines.BuildersKt.withContext(r11, r12, r0)
                if (r11 != r1) goto L_0x00ed
                return r1
            L_0x00ed:
                boolean r11 = io.monedata.Monedata.isReady()
                java.lang.Boolean r11 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r11)
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: io.monedata.Monedata.Coroutines.initialize(android.content.Context, java.lang.String, boolean, kotlin.coroutines.Continuation):java.lang.Object");
        }

        public final Object waitForInitialization(Continuation<? super Boolean> continuation) {
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
            cancellableContinuationImpl.initCancellability();
            Monedata.waitForInitialization(new d(cancellableContinuationImpl));
            Object result = cancellableContinuationImpl.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return result;
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "io.monedata.Monedata", f = "Monedata.kt", i = {0, 0, 0, 1, 1}, l = {83, 86, 92}, m = "doInitialize", n = {"this", "context", "assetKey", "this", "context"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1"})
    static final class a extends ContinuationImpl {
        Object a;
        Object b;
        Object c;
        /* synthetic */ Object d;
        final /* synthetic */ Monedata e;
        int f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(Monedata monedata, Continuation<? super a> continuation) {
            super(continuation);
            this.e = monedata;
        }

        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= Integer.MIN_VALUE;
            return this.e.doInitialize((Context) null, (String) null, this);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "io.monedata.Monedata$initialize$2", f = "Monedata.kt", i = {}, l = {134}, m = "invokeSuspend", n = {}, s = {})
    static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int a;
        final /* synthetic */ Context b;
        final /* synthetic */ String c;
        final /* synthetic */ boolean d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(Context context, String str, boolean z, Continuation<? super b> continuation) {
            super(2, continuation);
            this.b = context;
            this.c = str;
            this.d = z;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new b(this.b, this.c, this.d, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Coroutines coroutines = Coroutines.INSTANCE;
                Context context = this.b;
                String str = this.c;
                boolean z = this.d;
                this.a = 1;
                if (coroutines.initialize(context, str, z, this) == coroutine_suspended) {
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

    private Monedata() {
    }

    @JvmStatic
    public static final void disableAdapter(Context context, String str, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "id");
        j1.a.a(context, str, z);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v6, resolved type: java.lang.String} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0082 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object doInitialize(android.content.Context r8, java.lang.String r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof io.monedata.Monedata.a
            if (r0 == 0) goto L_0x0013
            r0 = r10
            io.monedata.Monedata$a r0 = (io.monedata.Monedata.a) r0
            int r1 = r0.f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f = r1
            goto L_0x0018
        L_0x0013:
            io.monedata.Monedata$a r0 = new io.monedata.Monedata$a
            r0.<init>(r7, r10)
        L_0x0018:
            java.lang.Object r10 = r0.d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L_0x0057
            if (r2 == r5) goto L_0x0044
            if (r2 == r4) goto L_0x0038
            if (r2 != r3) goto L_0x0030
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0094
        L_0x0030:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0038:
            java.lang.Object r8 = r0.b
            android.content.Context r8 = (android.content.Context) r8
            java.lang.Object r9 = r0.a
            io.monedata.Monedata r9 = (io.monedata.Monedata) r9
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0083
        L_0x0044:
            java.lang.Object r8 = r0.c
            r9 = r8
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r8 = r0.b
            android.content.Context r8 = (android.content.Context) r8
            java.lang.Object r2 = r0.a
            io.monedata.Monedata r2 = (io.monedata.Monedata) r2
            kotlin.ResultKt.throwOnFailure(r10)
            r10 = r9
            r9 = r2
            goto L_0x0072
        L_0x0057:
            kotlin.ResultKt.throwOnFailure(r10)
            io.monedata.consent.ConsentManager r10 = io.monedata.consent.ConsentManager.INSTANCE
            r10.initialize$core_productionRelease(r8)
            io.monedata.identifier.IdentifierManager r10 = io.monedata.identifier.IdentifierManager.INSTANCE
            r0.a = r7
            r0.b = r8
            r0.c = r9
            r0.f = r5
            java.lang.Object r10 = r10.fetch(r8, r0)
            if (r10 != r1) goto L_0x0070
            return r1
        L_0x0070:
            r10 = r9
            r9 = r7
        L_0x0072:
            io.monedata.u r2 = io.monedata.u.a
            r0.a = r9
            r0.b = r8
            r0.c = r6
            r0.f = r4
            java.lang.Object r10 = r2.a((android.content.Context) r8, (java.lang.String) r10, (kotlin.coroutines.Continuation<? super io.monedata.s>) r0)
            if (r10 != r1) goto L_0x0083
            return r1
        L_0x0083:
            io.monedata.s r10 = (io.monedata.s) r10
            if (r10 == 0) goto L_0x0097
            r0.a = r6
            r0.b = r6
            r0.f = r3
            java.lang.Object r8 = r9.onConfigFetched(r8, r10, r0)
            if (r8 != r1) goto L_0x0094
            return r1
        L_0x0094:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        L_0x0097:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r9 = "No config could be loaded"
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.monedata.Monedata.doInitialize(android.content.Context, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @JvmStatic
    public static final void enableBackgroundLocation(Context context, Boolean bool) {
        Intrinsics.checkNotNullParameter(context, "context");
        Settings.setBackgroundLocationEnabled(context, bool);
    }

    public static final List<String> getFoundAdapters() {
        List<PartnerAdapter> a2 = j1.a.a();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(a2, 10));
        for (PartnerAdapter id : a2) {
            arrayList.add(id.getId());
        }
        return arrayList;
    }

    @JvmStatic
    public static /* synthetic */ void getFoundAdapters$annotations() {
    }

    public static final String getVersionName() {
        return "1.7.1";
    }

    @JvmStatic
    public static /* synthetic */ void getVersionName$annotations() {
    }

    @JvmStatic
    public static final void initialize(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "assetKey");
        initialize$default(context, str, false, (Function1) null, 12, (Object) null);
    }

    @JvmStatic
    public static final void initialize(Context context, String str, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "assetKey");
        initialize$default(context, str, z, (Function1) null, 8, (Object) null);
    }

    @JvmStatic
    public static final synchronized void initialize(Context context, String str, boolean z, Function1<? super Boolean, Unit> function1) {
        synchronized (Monedata.class) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "assetKey");
            if (function1 != null) {
                listeners.add(function1);
            }
            Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutinesKt.getMainScope(), (CoroutineContext) null, (CoroutineStart) null, new b(context, str, z, (Continuation<? super b>) null), 3, (Object) null);
        }
    }

    public static /* synthetic */ void initialize$default(Context context, String str, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            function1 = null;
        }
        initialize(context, str, z, function1);
    }

    /* access modifiers changed from: private */
    public final void invokeListeners() {
        List<Function1<Boolean, Unit>> list = listeners;
        for (Function1 invoke : list) {
            invoke.invoke(Boolean.valueOf(isReady));
        }
        list.clear();
    }

    public static final boolean isInitialized() {
        return isInitialized;
    }

    @JvmStatic
    public static /* synthetic */ void isInitialized$annotations() {
    }

    public static final boolean isReady() {
        return isReady;
    }

    @JvmStatic
    public static /* synthetic */ void isReady$annotations() {
    }

    public static final boolean isStarted() {
        return isStarted;
    }

    @JvmStatic
    public static /* synthetic */ void isStarted$annotations() {
    }

    /* access modifiers changed from: private */
    public final Object onConfigFetched(Context context, s sVar, Continuation<? super Unit> continuation) {
        Object a2 = j1.a.a(context, sVar, continuation);
        return a2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? a2 : Unit.INSTANCE;
    }

    @JvmStatic
    public static final void start(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (isReady && !isStarted) {
            MonedataLog.v$default(MonedataLog.INSTANCE, "Starting Monedata SDK", (Throwable) null, 2, (Object) null);
            isStarted = true;
            i1.a(j1.a, context);
            l1.a.c(context);
        }
    }

    @JvmStatic
    public static final boolean startAdaptersActivity(Context context) {
        Object obj;
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            Result.Companion companion = Result.Companion;
            context.startActivity(new Intent(context, AdaptersActivity.class));
            obj = Result.m2344constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m2344constructorimpl(ResultKt.createFailure(th));
        }
        return Result.m2351isSuccessimpl(obj);
    }

    @JvmStatic
    public static final void stop(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        MonedataLog.v$default(MonedataLog.INSTANCE, "Stopping Monedata SDK", (Throwable) null, 2, (Object) null);
        isStarted = false;
        i1.b(j1.a, context);
        l1.a.d(context);
    }

    @JvmStatic
    public static final synchronized void waitForInitialization(Function1<? super Boolean, Unit> function1) {
        synchronized (Monedata.class) {
            Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            if (isInitialized) {
                function1.invoke(Boolean.valueOf(isReady));
            } else {
                listeners.add(function1);
            }
        }
    }
}

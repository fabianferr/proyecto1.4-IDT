package com.m2catalyst.m2sdk;

import com.m2catalyst.m2sdk.external.M2SDK;
import com.m2catalyst.m2sdk.logger.M2SDKLogger;
import kotlin.ExceptionsKt;
import kotlin.Unit;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ReceiveChannel;

/* compiled from: MNSICoroutineUtils.kt */
public final class j3 {
    public static final b a;
    public static final CoroutineScope b;
    public static final CoroutineScope c;
    public static final Channel<Job> d;

    @DebugMetadata(c = "com.m2catalyst.m2sdk.coroutines.MNSICoroutineUtilsKt$lazyJobChannel$1$1", f = "MNSICoroutineUtils.kt", i = {0, 1}, l = {148, 26}, m = "invokeSuspend", n = {"$this$consume$iv$iv", "$this$consume$iv$iv"}, s = {"L$0", "L$0"})
    /* compiled from: MNSICoroutineUtils.kt */
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public ReceiveChannel a;
        public ChannelIterator b;
        public int c;
        public final /* synthetic */ Channel<Job> d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Channel<Job> channel, Continuation<? super a> continuation) {
            super(2, continuation);
            this.d = channel;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new a(this.d, continuation);
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((a) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARNING: Removed duplicated region for block: B:21:0x0043  */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x0051 A[Catch:{ all -> 0x0070 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r7.c
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L_0x002c
                if (r1 == r3) goto L_0x001e
                if (r1 != r2) goto L_0x0016
                kotlinx.coroutines.channels.ChannelIterator r1 = r7.b
                kotlinx.coroutines.channels.ReceiveChannel r4 = r7.a
                kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ all -> 0x002a }
                goto L_0x0035
            L_0x0016:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L_0x001e:
                kotlinx.coroutines.channels.ChannelIterator r1 = r7.b
                kotlinx.coroutines.channels.ReceiveChannel r4 = r7.a
                kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ all -> 0x002a }
                r5 = r4
                r4 = r1
                r1 = r0
                r0 = r7
                goto L_0x0049
            L_0x002a:
                r8 = move-exception
                goto L_0x0072
            L_0x002c:
                kotlin.ResultKt.throwOnFailure(r8)
                kotlinx.coroutines.channels.Channel<kotlinx.coroutines.Job> r4 = r7.d
                kotlinx.coroutines.channels.ChannelIterator r1 = r4.iterator()     // Catch:{ all -> 0x002a }
            L_0x0035:
                r8 = r7
            L_0x0036:
                r8.a = r4     // Catch:{ all -> 0x002a }
                r8.b = r1     // Catch:{ all -> 0x002a }
                r8.c = r3     // Catch:{ all -> 0x002a }
                java.lang.Object r5 = r1.hasNext(r8)     // Catch:{ all -> 0x002a }
                if (r5 != r0) goto L_0x0043
                return r0
            L_0x0043:
                r6 = r0
                r0 = r8
                r8 = r5
                r5 = r4
                r4 = r1
                r1 = r6
            L_0x0049:
                java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch:{ all -> 0x0070 }
                boolean r8 = r8.booleanValue()     // Catch:{ all -> 0x0070 }
                if (r8 == 0) goto L_0x0069
                java.lang.Object r8 = r4.next()     // Catch:{ all -> 0x0070 }
                kotlinx.coroutines.Job r8 = (kotlinx.coroutines.Job) r8     // Catch:{ all -> 0x0070 }
                r0.a = r5     // Catch:{ all -> 0x0070 }
                r0.b = r4     // Catch:{ all -> 0x0070 }
                r0.c = r2     // Catch:{ all -> 0x0070 }
                java.lang.Object r8 = r8.join(r0)     // Catch:{ all -> 0x0070 }
                if (r8 != r1) goto L_0x0064
                return r1
            L_0x0064:
                r8 = r0
                r0 = r1
                r1 = r4
                r4 = r5
                goto L_0x0036
            L_0x0069:
                r8 = 0
                kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r5, r8)
                kotlin.Unit r8 = kotlin.Unit.INSTANCE
                return r8
            L_0x0070:
                r8 = move-exception
                r4 = r5
            L_0x0072:
                throw r8     // Catch:{ all -> 0x0073 }
            L_0x0073:
                r0 = move-exception
                kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r4, r8)
                goto L_0x0079
            L_0x0078:
                throw r0
            L_0x0079:
                goto L_0x0078
            */
            throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.j3.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: CoroutineExceptionHandler.kt */
    public static final class b extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
        public b(CoroutineExceptionHandler.Key key) {
            super(key);
        }

        public final void handleException(CoroutineContext coroutineContext, Throwable th) {
            ExceptionsKt.stackTraceToString(th);
            M2SDKLogger.Companion.getLogger().e("CoroutineScope", ExceptionsKt.stackTraceToString(th), new String[0]);
            M2SDK.INSTANCE.recordException$m2sdk_release(th);
        }
    }

    static {
        b bVar = new b(CoroutineExceptionHandler.Key);
        a = bVar;
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)).plus(bVar));
        b = CoroutineScope;
        c = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)).plus(bVar));
        Channel<Job> Channel$default = ChannelKt.Channel$default(Integer.MAX_VALUE, (BufferOverflow) null, (Function1) null, 6, (Object) null);
        Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScope, (CoroutineContext) null, (CoroutineStart) null, new a(Channel$default, (Continuation<? super a>) null), 3, (Object) null);
        d = Channel$default;
    }

    public static void a(Function2 function2) {
        Intrinsics.checkNotNullParameter(function2, "block");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = BuildersKt__Builders_commonKt.launch$default(b, (CoroutineContext) null, (CoroutineStart) null, new h3((Long) null, function2, (Function1<? super Throwable, Unit>) null, objectRef, (Continuation<? super h3>) null), 3, (Object) null);
    }

    public static void b(Function2 function2) {
        Intrinsics.checkNotNullParameter(function2, "block");
        d.m1248trySendJP2dKIU(BuildersKt__Builders_commonKt.launch$default(b, (CoroutineContext) null, CoroutineStart.LAZY, new k3(function2, (Continuation<? super k3>) null), 1, (Object) null));
    }

    public static void c(Function2 function2) {
        Intrinsics.checkNotNullParameter(function2, "block");
        d.m1248trySendJP2dKIU(BuildersKt__Builders_commonKt.launch$default(c, (CoroutineContext) null, CoroutineStart.LAZY, new l3(function2, (Continuation<? super l3>) null), 1, (Object) null));
    }
}

package io.monedata.partners.extensions;

import android.content.Context;
import io.monedata.m0;
import io.monedata.partners.PartnerAdapter;
import io.monedata.partners.models.AdapterException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

@Metadata(bv = {}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0006\u001a'\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a1\u0010\r\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\t\u001a\u00020\b2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH\u0007\u0002\b\n\u0006\b\u0000\u001a\u0002\u0010\u0001\u001a!\u0010\u000e\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\t\u001a\u00020\bH\u0007\u0002\n\n\b\b\u0000\u001a\u0004\b\u0001\u0010\u0001\u001a4\u0010\u0011\u001a\u00028\u0000\"\b\b\u0000\u0010\u0010*\u00020\u000f*\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00018\u0000H\u0007\u0002\n\n\b\b\u0000\u001a\u0004\b\u0003\u0010\u0001¢\u0006\u0004\b\u0011\u0010\u0012\u001a0\u0010\u0013\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0010*\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00018\u0000H\u0007\u0002\n\n\b\b\u0000\u001a\u0004\b\u0003\u0010\u0001¢\u0006\u0004\b\u0013\u0010\u0014\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"Lio/monedata/partners/PartnerAdapter;", "Landroid/content/Context;", "context", "", "error", "", "a", "(Lio/monedata/partners/PartnerAdapter;Landroid/content/Context;Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "value", "Lkotlin/Function0;", "", "lazyMessage", "test", "testNot", "", "T", "testNotNullOrEmpty", "(Lio/monedata/partners/PartnerAdapter;Ljava/lang/CharSequence;)Ljava/lang/CharSequence;", "testNotNull", "(Lio/monedata/partners/PartnerAdapter;Ljava/lang/Object;)Ljava/lang/Object;", "core_productionRelease"}, k = 2, mv = {1, 7, 1})
public final class PartnerAdapterKt {

    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/Job;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "io.monedata.partners.extensions.PartnerAdapterKt$recordError$2", f = "PartnerAdapter.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Job>, Object> {
        int a;
        private /* synthetic */ Object b;
        final /* synthetic */ Context c;
        final /* synthetic */ PartnerAdapter d;
        final /* synthetic */ Throwable e;

        @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
        @DebugMetadata(c = "io.monedata.partners.extensions.PartnerAdapterKt$recordError$2$1", f = "PartnerAdapter.kt", i = {}, l = {20}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: io.monedata.partners.extensions.PartnerAdapterKt$a$a  reason: collision with other inner class name */
        static final class C0208a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int a;
            final /* synthetic */ Context b;
            final /* synthetic */ PartnerAdapter c;
            final /* synthetic */ Throwable d;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0208a(Context context, PartnerAdapter partnerAdapter, Throwable th, Continuation<? super C0208a> continuation) {
                super(2, continuation);
                this.b = context;
                this.c = partnerAdapter;
                this.d = th;
            }

            /* renamed from: a */
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C0208a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C0208a(this.b, this.c, this.d, continuation);
            }

            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.a;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    m0 m0Var = m0.a;
                    Context context = this.b;
                    PartnerAdapter partnerAdapter = this.c;
                    Throwable th = this.d;
                    this.a = 1;
                    if (m0Var.a(context, partnerAdapter, th, this) == coroutine_suspended) {
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

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(Context context, PartnerAdapter partnerAdapter, Throwable th, Continuation<? super a> continuation) {
            super(2, continuation);
            this.c = context;
            this.d = partnerAdapter;
            this.e = th;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Job> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            a aVar = new a(this.c, this.d, this.e, continuation);
            aVar.b = obj;
            return aVar;
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.a == 0) {
                ResultKt.throwOnFailure(obj);
                return BuildersKt__Builders_commonKt.launch$default((CoroutineScope) this.b, (CoroutineContext) null, (CoroutineStart) null, new C0208a(this.c, this.d, this.e, (Continuation<? super C0208a>) null), 3, (Object) null);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static final Object a(PartnerAdapter partnerAdapter, Context context, Throwable th, Continuation<? super Unit> continuation) {
        if (th instanceof AdapterException) {
            return Unit.INSTANCE;
        }
        Object supervisorScope = SupervisorKt.supervisorScope(new a(context, partnerAdapter, th, (Continuation<? super a>) null), continuation);
        return supervisorScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? supervisorScope : Unit.INSTANCE;
    }

    public static /* synthetic */ void a(PartnerAdapter partnerAdapter, boolean z, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            function0 = null;
        }
        test(partnerAdapter, z, function0);
    }

    public static final void test(PartnerAdapter partnerAdapter, boolean z, Function0<String> function0) {
        String str;
        Intrinsics.checkNotNullParameter(partnerAdapter, "<this>");
        if (!z) {
            if (function0 == null || (str = function0.invoke()) == null) {
                str = "Test failed";
            }
            throw new AdapterException(partnerAdapter, str, (Throwable) null, 4, (DefaultConstructorMarker) null);
        }
    }

    public static final void testNot(PartnerAdapter partnerAdapter, boolean z) {
        Intrinsics.checkNotNullParameter(partnerAdapter, "<this>");
        a(partnerAdapter, !z, (Function0) null, 2, (Object) null);
    }

    public static final <T> T testNotNull(PartnerAdapter partnerAdapter, T t) {
        Intrinsics.checkNotNullParameter(partnerAdapter, "<this>");
        a(partnerAdapter, t != null, (Function0) null, 2, (Object) null);
        return t;
    }

    public static final <T extends CharSequence> T testNotNullOrEmpty(PartnerAdapter partnerAdapter, T t) {
        Intrinsics.checkNotNullParameter(partnerAdapter, "<this>");
        testNot(partnerAdapter, t == null || t.length() == 0);
        return t;
    }
}

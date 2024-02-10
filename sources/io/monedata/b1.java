package io.monedata;

import android.content.Context;
import android.content.SharedPreferences;
import io.monedata.identifier.Identifier;
import io.monedata.identifier.IdentifierType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

@Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\t"}, d2 = {"Lio/monedata/b1;", "Lio/monedata/x0;", "Landroid/content/Context;", "context", "Lio/monedata/identifier/Identifier;", "a", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<init>", "()V", "core_productionRelease"}, k = 1, mv = {1, 7, 1})
public final class b1 implements x0 {
    public static final b1 a = new b1();

    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lio/monedata/identifier/Identifier;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "io.monedata.identifier.impl.Monedata$fetch$2", f = "Monedata.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Identifier>, Object> {
        int a;
        final /* synthetic */ Context b;

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 7, 1})
        /* renamed from: io.monedata.b1$a$a  reason: collision with other inner class name */
        static final class C0203a extends Lambda implements Function0<String> {
            public static final C0203a a = new C0203a();

            C0203a() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return z1.a.a();
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(Context context, Continuation<? super a> continuation) {
            super(2, continuation);
            this.b = context;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Identifier> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new a(this.b, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.a == 0) {
                ResultKt.throwOnFailure(obj);
                SharedPreferences sharedPreferences = this.b.getSharedPreferences(BuildConfig.LIBRARY_PACKAGE_NAME, 0);
                Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(\"io.monedata\", MODE_PRIVATE)");
                return new Identifier(u1.a(sharedPreferences, "uuid", (Function0<String>) C0203a.a), false, IdentifierType.MONEDATA);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private b1() {
    }

    public Object a(Context context, Continuation<? super Identifier> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new a(context, (Continuation<? super a>) null), continuation);
    }
}

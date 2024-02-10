package io.monedata;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import io.monedata.identifier.Identifier;
import io.monedata.identifier.IdentifierType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

@Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\t"}, d2 = {"Lio/monedata/r0;", "Lio/monedata/x0;", "Landroid/content/Context;", "context", "Lio/monedata/identifier/Identifier;", "a", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<init>", "()V", "core_productionRelease"}, k = 1, mv = {1, 7, 1})
public final class r0 implements x0 {
    public static final r0 a = new r0();

    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lio/monedata/identifier/Identifier;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "io.monedata.identifier.impl.Google$fetch$2", f = "Google.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Identifier>, Object> {
        int a;
        final /* synthetic */ Context b;

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
                AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.b);
                if (advertisingIdInfo != null) {
                    String id = advertisingIdInfo.getId();
                    boolean z = false;
                    if (!(id == null || id.length() == 0)) {
                        z1 z1Var = z1.a;
                        String id2 = advertisingIdInfo.getId();
                        Intrinsics.checkNotNullExpressionValue(id2, "info.id");
                        if (!z1Var.a(id2)) {
                            z = true;
                        }
                    }
                    if (z) {
                        String id3 = advertisingIdInfo.getId();
                        Intrinsics.checkNotNullExpressionValue(id3, "info.id");
                        return new Identifier(id3, advertisingIdInfo.isLimitAdTrackingEnabled(), IdentifierType.GOOGLE);
                    }
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private r0() {
    }

    public Object a(Context context, Continuation<? super Identifier> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new a(context, (Continuation<? super a>) null), continuation);
    }
}

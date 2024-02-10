package com.wortise.ads;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;
import com.wortise.ads.identifier.Identifier;
import com.wortise.ads.identifier.IdentifierType;
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

@Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001b\u0010\u0005\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u000b\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"Lcom/wortise/ads/t;", "Lcom/wortise/ads/s;", "Landroid/content/ContentResolver;", "resolver", "", "a", "", "b", "Landroid/content/Context;", "context", "Lcom/wortise/ads/identifier/Identifier;", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: Amazon.kt */
public final class t extends s {
    public static final t a = new t();

    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/wortise/ads/identifier/Identifier;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.wortise.ads.identifier.modules.Amazon$fetch$2", f = "Amazon.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* compiled from: Amazon.kt */
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
                ContentResolver contentResolver = this.b.getContentResolver();
                t tVar = t.a;
                Intrinsics.checkNotNullExpressionValue(contentResolver, "resolver");
                String a2 = tVar.a(contentResolver);
                int b2 = tVar.b(contentResolver);
                boolean z = false;
                if (!(a2 == null || a2.length() == 0) && b2 != -1) {
                    if (b2 != 0) {
                        z = true;
                    }
                    return new Identifier(a2, z, IdentifierType.AMAZON);
                }
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private t() {
    }

    /* access modifiers changed from: private */
    public final int b(ContentResolver contentResolver) {
        return Settings.Secure.getInt(contentResolver, "limit_ad_tracking", -1);
    }

    /* access modifiers changed from: protected */
    public Object a(Context context, Continuation<? super Identifier> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new a(context, (Continuation<? super a>) null), continuation);
    }

    /* access modifiers changed from: private */
    public final String a(ContentResolver contentResolver) {
        return Settings.Secure.getString(contentResolver, "advertising_id");
    }
}

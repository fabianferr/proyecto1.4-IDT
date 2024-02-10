package com.wortise.ads;

import android.content.Context;
import android.content.ContextWrapper;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

@Metadata(bv = {}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&R\u001b\u0010\f\u001a\u00020\b8DX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/wortise/ads/k0;", "Landroid/content/ContextWrapper;", "", "a", "Lcom/wortise/ads/AdResponse;", "adResponse", "", "b", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope$delegate", "Lkotlin/Lazy;", "()Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: BasePushModule.kt */
public abstract class k0 extends ContextWrapper {
    private final Lazy a = LazyKt.lazy(a.a);

    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: BasePushModule.kt */
    static final class a extends Lambda implements Function0<CoroutineScope> {
        public static final a a = new a();

        a() {
            super(0);
        }

        /* renamed from: a */
        public final CoroutineScope invoke() {
            return CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public k0(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void a() {
    }

    public abstract void a(AdResponse adResponse);

    /* access modifiers changed from: protected */
    public final CoroutineScope b() {
        return (CoroutineScope) this.a.getValue();
    }

    public boolean b(AdResponse adResponse) {
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        return true;
    }
}

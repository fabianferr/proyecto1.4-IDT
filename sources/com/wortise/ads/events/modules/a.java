package com.wortise.ads.events.modules;

import android.content.Context;
import android.os.Bundle;
import com.wortise.ads.AdResponse;
import com.wortise.ads.WortiseLog;
import com.wortise.ads.c2;
import com.wortise.ads.o6;
import com.wortise.ads.v4;
import com.wortise.ads.w4;
import com.wortise.ads.y3;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(bv = {}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\b&\u0018\u0000 .2\u00020\u0001:\u0001/B#\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!¢\u0006\u0004\b,\u0010-J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0002J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u000e\u001a\u00020\tH&J\u000e\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\tJ\u0006\u0010\u0011\u001a\u00020\tJ\u0006\u0010\u0012\u001a\u00020\tJ\u0010\u0010\u0013\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\tH\u0014J\b\u0010\u0014\u001a\u00020\tH\u0014J\b\u0010\u0015\u001a\u00020\tH\u0014J\b\u0010\u0016\u001a\u00020\tH\u0014R\u0017\u0010\u0018\u001a\u00020\u00178\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u001d\u001a\u00020\u001c8\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0019\u0010\"\u001a\u0004\u0018\u00010!8\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001c\u0010&\u001a\u0004\u0018\u00010\u00018\u0014X\u0004¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00038TX\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+¨\u00060"}, d2 = {"Lcom/wortise/ads/events/modules/a;", "", "", "", "list", "", "call", "url", "post", "", "success", "onClickResult", "onCompletionResult", "onImpressionResult", "canHandle", "open", "handleClick", "handleCompletion", "handleImpression", "onHandleClick", "onHandleCompletion", "onHandleImpression", "onOpenTarget", "Landroid/content/Context;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Lcom/wortise/ads/AdResponse;", "adResponse", "Lcom/wortise/ads/AdResponse;", "getAdResponse", "()Lcom/wortise/ads/AdResponse;", "Landroid/os/Bundle;", "adExtras", "Landroid/os/Bundle;", "getAdExtras", "()Landroid/os/Bundle;", "logExtras", "Ljava/lang/Object;", "getLogExtras", "()Ljava/lang/Object;", "getUrl", "()Ljava/lang/String;", "<init>", "(Landroid/content/Context;Lcom/wortise/ads/AdResponse;Landroid/os/Bundle;)V", "Companion", "a", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: BaseEventHandler.kt */
public abstract class a {
    public static final C0182a Companion = new C0182a((DefaultConstructorMarker) null);
    public static final String EXTRA_URL = "url";
    private final Bundle adExtras;
    private final AdResponse adResponse;
    private final Context context;
    private final Object logExtras;

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/wortise/ads/events/modules/a$a;", "", "", "EXTRA_URL", "Ljava/lang/String;", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* renamed from: com.wortise.ads.events.modules.a$a  reason: collision with other inner class name */
    /* compiled from: BaseEventHandler.kt */
    public static final class C0182a {
        private C0182a() {
        }

        public /* synthetic */ C0182a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.wortise.ads.events.modules.BaseEventHandler$call$1", f = "BaseEventHandler.kt", i = {}, l = {40}, m = "invokeSuspend", n = {}, s = {})
    /* compiled from: BaseEventHandler.kt */
    static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object a;
        int b;
        final /* synthetic */ List<String> c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(List<String> list, Continuation<? super b> continuation) {
            super(2, continuation);
            this.c = list;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new b(this.c, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            Iterator<T> it;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.b;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                it = this.c.iterator();
            } else if (i == 1) {
                it = (Iterator) this.a;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            while (it.hasNext()) {
                y3 y3Var = y3.a;
                this.a = it;
                this.b = 1;
                if (y3Var.a((String) it.next(), (Continuation<? super Unit>) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.wortise.ads.events.modules.BaseEventHandler$post$1", f = "BaseEventHandler.kt", i = {}, l = {50}, m = "invokeSuspend", n = {}, s = {})
    /* compiled from: BaseEventHandler.kt */
    static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int a;
        final /* synthetic */ String b;
        final /* synthetic */ a c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(String str, a aVar, Continuation<? super c> continuation) {
            super(2, continuation);
            this.b = str;
            this.c = aVar;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((c) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new c(this.b, this.c, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                y3 y3Var = y3.a;
                String str = this.b;
                v4 a2 = w4.a.a(this.c.getContext(), this.c.getLogExtras());
                this.a = 1;
                if (y3Var.a(str, a2, this) == coroutine_suspended) {
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

    public a(Context context2, AdResponse adResponse2, Bundle bundle) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(adResponse2, "adResponse");
        this.context = context2;
        this.adResponse = adResponse2;
        this.adExtras = bundle;
    }

    private final void call(List<String> list) {
        if (!list.isEmpty()) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(c2.b(), (CoroutineContext) null, (CoroutineStart) null, new b(list, (Continuation<? super b>) null), 3, (Object) null);
        }
    }

    private final void onClickResult(boolean z) {
        if (z && this.adResponse.q()) {
            post(this.adResponse.b());
            List<String> a = this.adResponse.a();
            if (a != null) {
                call(a);
            }
        }
    }

    private final void onCompletionResult(boolean z) {
        if (z && this.adResponse.r()) {
            post(this.adResponse.e());
            List<String> d = this.adResponse.d();
            if (d != null) {
                call(d);
            }
        }
    }

    private final void onImpressionResult(boolean z) {
        if (z && this.adResponse.s()) {
            post(this.adResponse.l());
            List<String> k = this.adResponse.k();
            if (k != null) {
                call(k);
            }
        }
    }

    private final void post(String str) {
        if (!(str == null || str.length() == 0)) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(c2.b(), (CoroutineContext) null, (CoroutineStart) null, new c(str, this, (Continuation<? super c>) null), 3, (Object) null);
        }
    }

    public abstract boolean canHandle();

    public final Bundle getAdExtras() {
        return this.adExtras;
    }

    public final AdResponse getAdResponse() {
        return this.adResponse;
    }

    public final Context getContext() {
        return this.context;
    }

    /* access modifiers changed from: protected */
    public Object getLogExtras() {
        return this.logExtras;
    }

    /* access modifiers changed from: protected */
    public String getUrl() {
        Bundle bundle = this.adExtras;
        String string = bundle == null ? null : bundle.getString("url");
        if (string == null) {
            string = this.adResponse.o();
            if (string == null || string.length() == 0) {
                return null;
            }
        }
        return string;
    }

    public final boolean handleClick(boolean z) {
        boolean onHandleClick = onHandleClick(z);
        onClickResult(onHandleClick);
        return onHandleClick;
    }

    public final boolean handleCompletion() {
        boolean onHandleCompletion = onHandleCompletion();
        onCompletionResult(onHandleCompletion);
        return onHandleCompletion;
    }

    public final boolean handleImpression() {
        boolean onHandleImpression = onHandleImpression();
        onImpressionResult(onHandleImpression);
        return onHandleImpression;
    }

    /* access modifiers changed from: protected */
    public boolean onHandleClick(boolean z) {
        if (!z) {
            return true;
        }
        return onOpenTarget();
    }

    /* access modifiers changed from: protected */
    public boolean onHandleCompletion() {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean onHandleImpression() {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean onOpenTarget() {
        String url = getUrl();
        if (url == null) {
            return false;
        }
        boolean a = o6.a.a(this.context, url);
        if (!a) {
            WortiseLog.v$default(Intrinsics.stringPlus("Could not handle URL: ", url), (Throwable) null, 2, (Object) null);
        }
        return a;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(Context context2, AdResponse adResponse2, Bundle bundle, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context2, adResponse2, (i & 4) != 0 ? null : bundle);
    }
}

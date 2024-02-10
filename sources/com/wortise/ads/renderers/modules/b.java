package com.wortise.ads.renderers.modules;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.wortise.ads.AdError;
import com.wortise.ads.AdFormat;
import com.wortise.ads.AdResponse;
import com.wortise.ads.a2;
import com.wortise.ads.device.Dimensions;
import com.wortise.ads.renderers.modules.a;
import com.wortise.ads.z3;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import okhttp3.Request;
import pl.droidsonroids.gif.GifDrawable;

@Metadata(bv = {}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001bB\u001f\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0014J\b\u0010\b\u001a\u00020\u0005H\u0014J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0014J\b\u0010\f\u001a\u00020\u0005H\u0014R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/wortise/ads/renderers/modules/b;", "Lcom/wortise/ads/renderers/modules/a;", "Landroid/widget/ImageView;", "", "array", "", "onFetched", "onDestroy", "onPause", "Landroid/content/Context;", "context", "onRender", "onResume", "Lpl/droidsonroids/gif/GifDrawable;", "drawable", "Lpl/droidsonroids/gif/GifDrawable;", "view", "Landroid/widget/ImageView;", "Landroid/view/View;", "adView", "Lcom/wortise/ads/AdResponse;", "adResponse", "Lcom/wortise/ads/renderers/modules/a$a;", "listener", "<init>", "(Landroid/view/View;Lcom/wortise/ads/AdResponse;Lcom/wortise/ads/renderers/modules/a$a;)V", "Companion", "a", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: GifAdRenderer.kt */
public final class b extends a<ImageView> {
    public static final a Companion = new a((DefaultConstructorMarker) null);
    private GifDrawable drawable;
    private ImageView view;

    @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¨\u0006\b"}, d2 = {"Lcom/wortise/ads/renderers/modules/b$a;", "", "Lcom/wortise/ads/AdResponse;", "response", "", "a", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* compiled from: GifAdRenderer.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final boolean a(AdResponse adResponse) {
            Intrinsics.checkNotNullParameter(adResponse, "response");
            return adResponse.a(AdFormat.IMAGE) && a2.a.b(adResponse.f());
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.wortise.ads.renderers.modules.GifAdRenderer$onRender$1", f = "GifAdRenderer.kt", i = {}, l = {37}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.wortise.ads.renderers.modules.b$b  reason: collision with other inner class name */
    /* compiled from: GifAdRenderer.kt */
    static final class C0193b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int a;
        final /* synthetic */ b b;
        final /* synthetic */ Context c;
        final /* synthetic */ Request d;

        @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
        @DebugMetadata(c = "com.wortise.ads.renderers.modules.GifAdRenderer$onRender$1$data$1", f = "GifAdRenderer.kt", i = {}, l = {38}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.wortise.ads.renderers.modules.b$b$a */
        /* compiled from: GifAdRenderer.kt */
        static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super byte[]>, Object> {
            int a;
            final /* synthetic */ Context b;
            final /* synthetic */ Request c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(Context context, Request request, Continuation<? super a> continuation) {
                super(2, continuation);
                this.b = context;
                this.c = request;
            }

            /* renamed from: a */
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super byte[]> continuation) {
                return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new a(this.b, this.c, continuation);
            }

            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.a;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    z3 z3Var = z3.a;
                    Context context = this.b;
                    Request request = this.c;
                    this.a = 1;
                    obj = z3Var.a(context, request, (Continuation<? super byte[]>) this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return obj;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0193b(b bVar, Context context, Request request, Continuation<? super C0193b> continuation) {
            super(2, continuation);
            this.b = bVar;
            this.c = context;
            this.d = request;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C0193b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C0193b(this.b, this.c, this.d, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineDispatcher io2 = Dispatchers.getIO();
                a aVar = new a(this.c, this.d, (Continuation<? super a>) null);
                this.a = 1;
                obj = BuildersKt.withContext(io2, aVar, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            this.b.onFetched((byte[]) obj);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(View view2, AdResponse adResponse, a.C0192a aVar) {
        super(view2, adResponse, aVar);
        Intrinsics.checkNotNullParameter(view2, "adView");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(aVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
    }

    @JvmStatic
    public static final boolean canRender(AdResponse adResponse) {
        return Companion.a(adResponse);
    }

    /* access modifiers changed from: private */
    public final void onFetched(byte[] bArr) {
        if (bArr == null) {
            deliverError(AdError.NO_FILL);
            return;
        }
        this.drawable = new GifDrawable(bArr);
        ImageView imageView = new ImageView(getContext());
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setImageDrawable(this.drawable);
        attachClickListener(imageView);
        a.deliverView$default(this, imageView, (Dimensions) null, 2, (Object) null);
        Unit unit = Unit.INSTANCE;
        this.view = imageView;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        try {
            GifDrawable gifDrawable = this.drawable;
            if (gifDrawable != null) {
                gifDrawable.stop();
            }
        } finally {
            this.view = null;
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        GifDrawable gifDrawable = this.drawable;
        if (gifDrawable != null) {
            gifDrawable.stop();
        }
    }

    /* access modifiers changed from: protected */
    public void onRender(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Request a2 = z3.a(z3.a, getAdResponse().f(), (Function1) null, 2, (Object) null);
        if (a2 == null) {
            deliverError(AdError.NO_FILL);
            return;
        }
        Job unused = BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), (CoroutineContext) null, (CoroutineStart) null, new C0193b(this, context, a2, (Continuation<? super C0193b>) null), 3, (Object) null);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        GifDrawable gifDrawable = this.drawable;
        if (gifDrawable != null) {
            gifDrawable.start();
        }
    }
}

package com.wortise.ads.renderers.modules;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.wortise.ads.AdError;
import com.wortise.ads.AdFormat;
import com.wortise.ads.AdResponse;
import com.wortise.ads.device.Dimensions;
import com.wortise.ads.j4;
import com.wortise.ads.renderers.modules.a;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0010B\u001f\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0014¨\u0006\u0011"}, d2 = {"Lcom/wortise/ads/renderers/modules/e;", "Lcom/wortise/ads/renderers/modules/a;", "Landroid/widget/ImageView;", "Landroid/content/Context;", "context", "", "onRender", "Landroid/view/View;", "adView", "Lcom/wortise/ads/AdResponse;", "adResponse", "Lcom/wortise/ads/renderers/modules/a$a;", "listener", "<init>", "(Landroid/view/View;Lcom/wortise/ads/AdResponse;Lcom/wortise/ads/renderers/modules/a$a;)V", "Companion", "a", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: ImageAdRenderer.kt */
public final class e extends a<ImageView> {
    public static final a Companion = new a((DefaultConstructorMarker) null);

    @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¨\u0006\b"}, d2 = {"Lcom/wortise/ads/renderers/modules/e$a;", "", "Lcom/wortise/ads/AdResponse;", "response", "", "a", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* compiled from: ImageAdRenderer.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final boolean a(AdResponse adResponse) {
            Intrinsics.checkNotNullParameter(adResponse, "response");
            return adResponse.a(AdFormat.IMAGE);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.wortise.ads.renderers.modules.ImageAdRenderer$onRender$1", f = "ImageAdRenderer.kt", i = {}, l = {24}, m = "invokeSuspend", n = {}, s = {})
    /* compiled from: ImageAdRenderer.kt */
    static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int a;
        final /* synthetic */ ImageView b;
        final /* synthetic */ String c;
        final /* synthetic */ e d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(ImageView imageView, String str, e eVar, Continuation<? super b> continuation) {
            super(2, continuation);
            this.b = imageView;
            this.c = str;
            this.d = eVar;
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
                j4 j4Var = j4.a;
                ImageView imageView = this.b;
                String str = this.c;
                this.a = 1;
                obj = j4Var.a(imageView, str, (Continuation<? super Boolean>) this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            if (!((Boolean) obj).booleanValue()) {
                this.d.deliverError(AdError.NO_FILL);
                return Unit.INSTANCE;
            }
            this.d.attachClickListener(this.b);
            a.deliverView$default(this.d, this.b, (Dimensions) null, 2, (Object) null);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(View view, AdResponse adResponse, a.C0192a aVar) {
        super(view, adResponse, aVar);
        Intrinsics.checkNotNullParameter(view, "adView");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(aVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
    }

    @JvmStatic
    public static final boolean canRender(AdResponse adResponse) {
        return Companion.a(adResponse);
    }

    /* access modifiers changed from: protected */
    public void onRender(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String f = getAdResponse().f();
        if (f == null) {
            deliverError(AdError.NO_FILL);
            return;
        }
        ImageView imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        Job unused = BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), (CoroutineContext) null, (CoroutineStart) null, new b(imageView, f, this, (Continuation<? super b>) null), 3, (Object) null);
    }
}

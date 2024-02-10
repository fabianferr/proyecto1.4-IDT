package com.wortise.ads;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(bv = {}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ%\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\bJ#\u0010\u0007\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004H@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\r\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"Lcom/wortise/ads/j4;", "", "Landroid/content/Context;", "context", "", "url", "", "a", "(Landroid/content/Context;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroid/graphics/Bitmap;", "b", "Landroid/widget/ImageView;", "view", "(Landroid/widget/ImageView;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: ImageLoader.kt */
public final class j4 {
    public static final j4 a = new j4();

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.wortise.ads.image.ImageLoader", f = "ImageLoader.kt", i = {}, l = {16}, m = "cache", n = {}, s = {})
    /* compiled from: ImageLoader.kt */
    static final class a extends ContinuationImpl {
        /* synthetic */ Object a;
        final /* synthetic */ j4 b;
        int c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(j4 j4Var, Continuation<? super a> continuation) {
            super(continuation);
            this.b = j4Var;
        }

        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= Integer.MIN_VALUE;
            return this.b.a((Context) null, (String) null, (Continuation<? super Boolean>) this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.wortise.ads.image.ImageLoader", f = "ImageLoader.kt", i = {}, l = {22}, m = "load", n = {}, s = {})
    /* compiled from: ImageLoader.kt */
    static final class b extends ContinuationImpl {
        /* synthetic */ Object a;
        final /* synthetic */ j4 b;
        int c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(j4 j4Var, Continuation<? super b> continuation) {
            super(continuation);
            this.b = j4Var;
        }

        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= Integer.MIN_VALUE;
            return this.b.b((Context) null, (String) null, this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.wortise.ads.image.ImageLoader", f = "ImageLoader.kt", i = {0}, l = {28}, m = "load", n = {"view"}, s = {"L$0"})
    /* compiled from: ImageLoader.kt */
    static final class c extends ContinuationImpl {
        Object a;
        /* synthetic */ Object b;
        final /* synthetic */ j4 c;
        int d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(j4 j4Var, Continuation<? super c> continuation) {
            super(continuation);
            this.c = j4Var;
        }

        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return this.c.a((ImageView) null, (String) null, (Continuation<? super Boolean>) this);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Landroid/graphics/Bitmap;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.wortise.ads.image.ImageLoader$load$bitmap$1", f = "ImageLoader.kt", i = {}, l = {29}, m = "invokeSuspend", n = {}, s = {})
    /* compiled from: ImageLoader.kt */
    static final class d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bitmap>, Object> {
        int a;
        final /* synthetic */ ImageView b;
        final /* synthetic */ String c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(ImageView imageView, String str, Continuation<? super d> continuation) {
            super(2, continuation);
            this.b = imageView;
            this.c = str;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Bitmap> continuation) {
            return ((d) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new d(this.b, this.c, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                j4 j4Var = j4.a;
                Context context = this.b.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "view.context");
                String str = this.c;
                this.a = 1;
                obj = j4Var.b(context, str, this);
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

    private j4() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(android.content.Context r5, java.lang.String r6, kotlin.coroutines.Continuation<? super java.lang.Boolean> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.wortise.ads.j4.a
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.wortise.ads.j4$a r0 = (com.wortise.ads.j4.a) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.c = r1
            goto L_0x0018
        L_0x0013:
            com.wortise.ads.j4$a r0 = new com.wortise.ads.j4$a
            r0.<init>(r4, r7)
        L_0x0018:
            java.lang.Object r7 = r0.a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x003d
        L_0x0029:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r7)
            r0.c = r3
            java.lang.Object r7 = r4.b(r5, r6, r0)
            if (r7 != r1) goto L_0x003d
            return r1
        L_0x003d:
            if (r7 == 0) goto L_0x0040
            goto L_0x0041
        L_0x0040:
            r3 = 0
        L_0x0041:
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wortise.ads.j4.a(android.content.Context, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object b(android.content.Context r6, java.lang.String r7, kotlin.coroutines.Continuation<? super android.graphics.Bitmap> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.wortise.ads.j4.b
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.wortise.ads.j4$b r0 = (com.wortise.ads.j4.b) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.c = r1
            goto L_0x0018
        L_0x0013:
            com.wortise.ads.j4$b r0 = new com.wortise.ads.j4$b
            r0.<init>(r5, r8)
        L_0x0018:
            java.lang.Object r8 = r0.a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.c
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0048
        L_0x002a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r8)
            com.wortise.ads.z3 r8 = com.wortise.ads.z3.a
            r2 = 2
            okhttp3.Request r7 = com.wortise.ads.z3.a((com.wortise.ads.z3) r8, (java.lang.String) r7, (kotlin.jvm.functions.Function1) r4, (int) r2, (java.lang.Object) r4)
            if (r7 != 0) goto L_0x003f
            return r4
        L_0x003f:
            r0.c = r3
            java.lang.Object r8 = r8.b(r6, r7, r0)
            if (r8 != r1) goto L_0x0048
            return r1
        L_0x0048:
            java.io.InputStream r8 = (java.io.InputStream) r8
            if (r8 != 0) goto L_0x004d
            goto L_0x0051
        L_0x004d:
            android.graphics.Bitmap r4 = android.graphics.BitmapFactory.decodeStream(r8)
        L_0x0051:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wortise.ads.j4.b(android.content.Context, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(android.widget.ImageView r6, java.lang.String r7, kotlin.coroutines.Continuation<? super java.lang.Boolean> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.wortise.ads.j4.c
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.wortise.ads.j4$c r0 = (com.wortise.ads.j4.c) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.d = r1
            goto L_0x0018
        L_0x0013:
            com.wortise.ads.j4$c r0 = new com.wortise.ads.j4$c
            r0.<init>(r5, r8)
        L_0x0018:
            java.lang.Object r8 = r0.b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r6 = r0.a
            android.widget.ImageView r6 = (android.widget.ImageView) r6
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x004d
        L_0x002d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r8)
            kotlinx.coroutines.CoroutineDispatcher r8 = kotlinx.coroutines.Dispatchers.getIO()
            com.wortise.ads.j4$d r2 = new com.wortise.ads.j4$d
            r4 = 0
            r2.<init>(r6, r7, r4)
            r0.a = r6
            r0.d = r3
            java.lang.Object r8 = kotlinx.coroutines.BuildersKt.withContext(r8, r2, r0)
            if (r8 != r1) goto L_0x004d
            return r1
        L_0x004d:
            android.graphics.Bitmap r8 = (android.graphics.Bitmap) r8
            r6.setImageBitmap(r8)
            if (r8 == 0) goto L_0x0055
            goto L_0x0056
        L_0x0055:
            r3 = 0
        L_0x0056:
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wortise.ads.j4.a(android.widget.ImageView, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}

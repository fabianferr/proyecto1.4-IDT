package com.wortise.ads;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import com.wortise.ads.events.ClickHandlerActivity;
import com.wortise.ads.push.models.Notification;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;

@Metadata(bv = {}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010 ¢\u0006\u0004\b\"\u0010#J&\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002J\u0013\u0010\b\u001a\u00020\tH@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\nR\u0014\u0010\r\u001a\u00020\u000b8BX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\fR\u001b\u0010\u0013\u001a\u00020\u000e8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148CX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188BX\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a\u0002\u0004\n\u0002\b\u0019¨\u0006$"}, d2 = {"Lcom/wortise/ads/t5;", "", "", "text", "Landroid/graphics/Bitmap;", "icon", "feature", "Landroidx/core/app/NotificationCompat$Style;", "a", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroid/content/Intent;", "()Landroid/content/Intent;", "intent", "Lcom/wortise/ads/e5;", "notificationHelper$delegate", "Lkotlin/Lazy;", "b", "()Lcom/wortise/ads/e5;", "notificationHelper", "Landroid/app/PendingIntent;", "c", "()Landroid/app/PendingIntent;", "pendingIntent", "Lcom/wortise/ads/push/models/Notification;", "d", "()Lcom/wortise/ads/push/models/Notification;", "values", "Landroid/content/Context;", "context", "Lcom/wortise/ads/AdResponse;", "adResponse", "Landroid/os/Bundle;", "adExtras", "<init>", "(Landroid/content/Context;Lcom/wortise/ads/AdResponse;Landroid/os/Bundle;)V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: PushManager.kt */
public final class t5 {
    /* access modifiers changed from: private */
    public final Context a;
    private final AdResponse b;
    private final Bundle c;
    private final Lazy d;

    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcom/wortise/ads/e5;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: PushManager.kt */
    static final class a extends Lambda implements Function0<e5> {
        final /* synthetic */ t5 a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(t5 t5Var) {
            super(0);
            this.a = t5Var;
        }

        /* renamed from: a */
        public final e5 invoke() {
            return new e5(this.a.a);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.wortise.ads.push.PushManager", f = "PushManager.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, l = {55, 59}, m = "show", n = {"this", "defaultValue$iv$iv", "text", "title", "log$iv", "this", "defaultValue$iv$iv", "text", "title", "feature", "log$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0"})
    /* compiled from: PushManager.kt */
    static final class b extends ContinuationImpl {
        Object a;
        Object b;
        Object c;
        Object d;
        Object e;
        int f;
        /* synthetic */ Object g;
        final /* synthetic */ t5 h;
        int i;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(t5 t5Var, Continuation<? super b> continuation) {
            super(continuation);
            this.h = t5Var;
        }

        public final Object invokeSuspend(Object obj) {
            this.g = obj;
            this.i |= Integer.MIN_VALUE;
            return this.h.a((Continuation<? super Boolean>) this);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Landroid/graphics/Bitmap;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.wortise.ads.push.PushManager$show$2$feature$1", f = "PushManager.kt", i = {}, l = {56}, m = "invokeSuspend", n = {}, s = {})
    /* compiled from: PushManager.kt */
    static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bitmap>, Object> {
        int a;
        final /* synthetic */ t5 b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(t5 t5Var, Continuation<? super c> continuation) {
            super(2, continuation);
            this.b = t5Var;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Bitmap> continuation) {
            return ((c) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new c(this.b, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                j4 j4Var = j4.a;
                Context a2 = this.b.a;
                String c = this.b.d().c();
                this.a = 1;
                obj = j4Var.b(a2, c, this);
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

    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Landroid/graphics/Bitmap;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.wortise.ads.push.PushManager$show$2$icon$1", f = "PushManager.kt", i = {}, l = {60}, m = "invokeSuspend", n = {}, s = {})
    /* compiled from: PushManager.kt */
    static final class d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bitmap>, Object> {
        int a;
        final /* synthetic */ t5 b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(t5 t5Var, Continuation<? super d> continuation) {
            super(2, continuation);
            this.b = t5Var;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Bitmap> continuation) {
            return ((d) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new d(this.b, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                j4 j4Var = j4.a;
                Context a2 = this.b.a;
                String b2 = this.b.d().b();
                this.a = 1;
                obj = j4Var.b(a2, b2, this);
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

    public t5(Context context, AdResponse adResponse, Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        this.a = context;
        this.b = adResponse;
        this.c = bundle;
        this.d = LazyKt.lazy(new a(this));
    }

    private final PendingIntent c() {
        PendingIntent activity = PendingIntent.getActivity(this.a, 0, a(), 201326592);
        Intrinsics.checkNotNullExpressionValue(activity, "getActivity(context, 0, …E or FLAG_UPDATE_CURRENT)");
        return activity;
    }

    /* access modifiers changed from: private */
    public final Notification d() {
        Notification m = this.b.m();
        if (m != null) {
            return m;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    private final Intent a() {
        return ClickHandlerActivity.Companion.a(this.a, this.b, this.c);
    }

    private final e5 b() {
        return (e5) this.d.getValue();
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00df A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(kotlin.coroutines.Continuation<? super java.lang.Boolean> r14) {
        /*
            r13 = this;
            boolean r0 = r14 instanceof com.wortise.ads.t5.b
            if (r0 == 0) goto L_0x0013
            r0 = r14
            com.wortise.ads.t5$b r0 = (com.wortise.ads.t5.b) r0
            int r1 = r0.i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.i = r1
            goto L_0x0018
        L_0x0013:
            com.wortise.ads.t5$b r0 = new com.wortise.ads.t5$b
            r0.<init>(r13, r14)
        L_0x0018:
            java.lang.Object r14 = r0.g
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.i
            r3 = 2
            r4 = 0
            r5 = 1
            if (r2 == 0) goto L_0x006a
            if (r2 == r5) goto L_0x0050
            if (r2 != r3) goto L_0x0048
            int r1 = r0.f
            java.lang.Object r2 = r0.e
            android.graphics.Bitmap r2 = (android.graphics.Bitmap) r2
            java.lang.Object r3 = r0.d
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r4 = r0.c
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r6 = r0.b
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            java.lang.Object r0 = r0.a
            com.wortise.ads.t5 r0 = (com.wortise.ads.t5) r0
            kotlin.ResultKt.throwOnFailure(r14)     // Catch:{ all -> 0x0044 }
            goto L_0x00e7
        L_0x0044:
            r14 = move-exception
            r5 = r1
            goto L_0x013f
        L_0x0048:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r0)
            throw r14
        L_0x0050:
            int r2 = r0.f
            java.lang.Object r6 = r0.d
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r7 = r0.c
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r8 = r0.b
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            java.lang.Object r9 = r0.a
            com.wortise.ads.t5 r9 = (com.wortise.ads.t5) r9
            kotlin.ResultKt.throwOnFailure(r14)     // Catch:{ all -> 0x0066 }
            goto L_0x00c0
        L_0x0066:
            r14 = move-exception
            r5 = r2
            goto L_0x0141
        L_0x006a:
            kotlin.ResultKt.throwOnFailure(r14)
            r14 = 0
            java.lang.Boolean r2 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r14)
            com.wortise.ads.e5 r6 = r13.b()     // Catch:{ all -> 0x014f }
            boolean r6 = r6.d()     // Catch:{ all -> 0x014f }
            if (r6 == 0) goto L_0x0143
            com.wortise.ads.push.models.Notification r6 = r13.d()     // Catch:{ all -> 0x014f }
            java.lang.String r6 = r6.d()     // Catch:{ all -> 0x014f }
            if (r6 == 0) goto L_0x008c
            int r7 = r6.length()     // Catch:{ all -> 0x014f }
            if (r7 != 0) goto L_0x008d
        L_0x008c:
            r14 = 1
        L_0x008d:
            if (r14 != 0) goto L_0x0090
            goto L_0x0091
        L_0x0090:
            r6 = r4
        L_0x0091:
            com.wortise.ads.push.models.Notification r14 = r13.d()     // Catch:{ all -> 0x014f }
            java.lang.String r14 = r14.e()     // Catch:{ all -> 0x014f }
            java.lang.String r14 = com.wortise.ads.h6.a((java.lang.String) r14)     // Catch:{ all -> 0x014f }
            kotlinx.coroutines.CoroutineDispatcher r7 = kotlinx.coroutines.Dispatchers.getIO()     // Catch:{ all -> 0x014f }
            com.wortise.ads.t5$c r8 = new com.wortise.ads.t5$c     // Catch:{ all -> 0x014f }
            r8.<init>(r13, r4)     // Catch:{ all -> 0x014f }
            r0.a = r13     // Catch:{ all -> 0x014f }
            r0.b = r2     // Catch:{ all -> 0x014f }
            r0.c = r6     // Catch:{ all -> 0x014f }
            r0.d = r14     // Catch:{ all -> 0x014f }
            r0.f = r5     // Catch:{ all -> 0x014f }
            r0.i = r5     // Catch:{ all -> 0x014f }
            java.lang.Object r7 = kotlinx.coroutines.BuildersKt.withContext(r7, r8, r0)     // Catch:{ all -> 0x014f }
            if (r7 != r1) goto L_0x00b9
            return r1
        L_0x00b9:
            r9 = r13
            r8 = r2
            r2 = 1
            r12 = r6
            r6 = r14
            r14 = r7
            r7 = r12
        L_0x00c0:
            android.graphics.Bitmap r14 = (android.graphics.Bitmap) r14     // Catch:{ all -> 0x0066 }
            kotlinx.coroutines.CoroutineDispatcher r10 = kotlinx.coroutines.Dispatchers.getIO()     // Catch:{ all -> 0x0066 }
            com.wortise.ads.t5$d r11 = new com.wortise.ads.t5$d     // Catch:{ all -> 0x0066 }
            r11.<init>(r9, r4)     // Catch:{ all -> 0x0066 }
            r0.a = r9     // Catch:{ all -> 0x0066 }
            r0.b = r8     // Catch:{ all -> 0x0066 }
            r0.c = r7     // Catch:{ all -> 0x0066 }
            r0.d = r6     // Catch:{ all -> 0x0066 }
            r0.e = r14     // Catch:{ all -> 0x0066 }
            r0.f = r2     // Catch:{ all -> 0x0066 }
            r0.i = r3     // Catch:{ all -> 0x0066 }
            java.lang.Object r0 = kotlinx.coroutines.BuildersKt.withContext(r10, r11, r0)     // Catch:{ all -> 0x0066 }
            if (r0 != r1) goto L_0x00e0
            return r1
        L_0x00e0:
            r1 = r2
            r3 = r6
            r4 = r7
            r6 = r8
            r2 = r14
            r14 = r0
            r0 = r9
        L_0x00e7:
            android.graphics.Bitmap r14 = (android.graphics.Bitmap) r14     // Catch:{ all -> 0x0044 }
            androidx.core.app.NotificationCompat$Style r2 = r0.a(r4, r14, r2)     // Catch:{ all -> 0x0044 }
            com.wortise.ads.e5 r7 = r0.b()     // Catch:{ all -> 0x0044 }
            androidx.core.app.NotificationCompat$Builder r7 = r7.a()     // Catch:{ all -> 0x0044 }
            androidx.core.app.NotificationCompat$Builder r7 = r7.setAutoCancel(r5)     // Catch:{ all -> 0x0044 }
            r8 = -65536(0xffffffffffff0000, float:NaN)
            androidx.core.app.NotificationCompat$Builder r7 = r7.setColor(r8)     // Catch:{ all -> 0x0044 }
            android.app.PendingIntent r8 = r0.c()     // Catch:{ all -> 0x0044 }
            androidx.core.app.NotificationCompat$Builder r7 = r7.setContentIntent(r8)     // Catch:{ all -> 0x0044 }
            androidx.core.app.NotificationCompat$Builder r4 = r7.setContentText(r4)     // Catch:{ all -> 0x0044 }
            androidx.core.app.NotificationCompat$Builder r3 = r4.setContentTitle(r3)     // Catch:{ all -> 0x0044 }
            androidx.core.app.NotificationCompat$Builder r14 = r3.setLargeIcon(r14)     // Catch:{ all -> 0x0044 }
            android.content.Context r3 = r0.a     // Catch:{ all -> 0x0044 }
            android.content.pm.ApplicationInfo r3 = r3.getApplicationInfo()     // Catch:{ all -> 0x0044 }
            int r3 = r3.icon     // Catch:{ all -> 0x0044 }
            androidx.core.app.NotificationCompat$Builder r14 = r14.setSmallIcon((int) r3)     // Catch:{ all -> 0x0044 }
            androidx.core.app.NotificationCompat$Builder r14 = r14.setStyle(r2)     // Catch:{ all -> 0x0044 }
            java.lang.String r2 = "notificationHelper.creat… .setStyle        (style)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r14, r2)     // Catch:{ all -> 0x0044 }
            com.wortise.ads.e5 r2 = r0.b()     // Catch:{ all -> 0x0044 }
            r2.a((androidx.core.app.NotificationCompat.Builder) r14)     // Catch:{ all -> 0x0044 }
            com.wortise.ads.s2 r14 = com.wortise.ads.s2.a     // Catch:{ all -> 0x0044 }
            android.content.Context r2 = r0.a     // Catch:{ all -> 0x0044 }
            com.wortise.ads.AdResponse r3 = r0.b     // Catch:{ all -> 0x0044 }
            android.os.Bundle r0 = r0.c     // Catch:{ all -> 0x0044 }
            r14.c(r2, r3, r0)     // Catch:{ all -> 0x0044 }
            java.lang.Boolean r14 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)     // Catch:{ all -> 0x0044 }
            goto L_0x015e
        L_0x013f:
            r2 = r6
            goto L_0x0150
        L_0x0141:
            r2 = r8
            goto L_0x0150
        L_0x0143:
            java.lang.String r14 = "Push not shown as notifications are not available"
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x014f }
            java.lang.String r14 = r14.toString()     // Catch:{ all -> 0x014f }
            r0.<init>(r14)     // Catch:{ all -> 0x014f }
            throw r0     // Catch:{ all -> 0x014f }
        L_0x014f:
            r14 = move-exception
        L_0x0150:
            if (r5 == 0) goto L_0x015d
            java.lang.String r0 = r14.getMessage()
            if (r0 != 0) goto L_0x015a
            java.lang.String r0 = "Caught an exception"
        L_0x015a:
            com.wortise.ads.WortiseLog.e((java.lang.String) r0, (java.lang.Throwable) r14)
        L_0x015d:
            r14 = r2
        L_0x015e:
            boolean r14 = r14.booleanValue()
            java.lang.Boolean r14 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r14)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wortise.ads.t5.a(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ t5(Context context, AdResponse adResponse, Bundle bundle, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, adResponse, (i & 4) != 0 ? null : bundle);
    }

    private final NotificationCompat.Style a(String str, Bitmap bitmap, Bitmap bitmap2) {
        if (bitmap2 == null) {
            NotificationCompat.BigTextStyle bigText = new NotificationCompat.BigTextStyle().bigText(str);
            Intrinsics.checkNotNullExpressionValue(bigText, "BigTextStyle().bigText(text)");
            return bigText;
        }
        NotificationCompat.BigPictureStyle summaryText = new NotificationCompat.BigPictureStyle().bigLargeIcon(bitmap).bigPicture(bitmap2).setSummaryText(str);
        Intrinsics.checkNotNullExpressionValue(summaryText, "BigPictureStyle()\n      …    .setSummaryText(text)");
        return summaryText;
    }
}

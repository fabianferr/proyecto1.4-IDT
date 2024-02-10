package com.wortise.ads;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(bv = {}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010!\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001*B\t\b\u0002¢\u0006\u0004\b(\u0010)J#\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0012\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0012\u0010\r\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u001a\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000bH\u0007J\u001a\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\tH\u0007J\u0017\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0014H\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\tH\u0000¢\u0006\u0004\b\u001d\u0010\u001eR\u0014\u0010 \u001a\u00020\t8\u0002XT¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010\"\u001a\u00020\t8\u0002XT¢\u0006\u0006\n\u0004\b\"\u0010!R\u0014\u0010#\u001a\u00020\t8\u0002XT¢\u0006\u0006\n\u0004\b#\u0010!R\u0014\u0010$\u001a\u00020\t8\u0002XT¢\u0006\u0006\n\u0004\b$\u0010!R\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00140%8\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'\u0002\u0004\n\u0002\b\u0019¨\u0006+"}, d2 = {"Lcom/wortise/ads/AdSettings;", "", "Landroid/content/Context;", "context", "", "enabled", "", "onChildDirectedChange", "(Landroid/content/Context;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "getAssetKey", "Lcom/wortise/ads/AdContentRating;", "getMaxAdContentRating", "getUserId", "isChildDirected", "setChildDirected", "rating", "setMaxAdContentRating", "userId", "setUserId", "Lcom/wortise/ads/AdSettings$a;", "listener", "addListener$sdk_productionRelease", "(Lcom/wortise/ads/AdSettings$a;)V", "addListener", "requireAssetKey$sdk_productionRelease", "(Landroid/content/Context;)Ljava/lang/String;", "requireAssetKey", "key", "setAssetKey$sdk_productionRelease", "(Landroid/content/Context;Ljava/lang/String;)V", "setAssetKey", "ASSET_KEY", "Ljava/lang/String;", "CHILD_DIRECTED_KEY", "MAX_CONTENT_RATING_KEY", "USER_ID_KEY", "", "listeners", "Ljava/util/List;", "<init>", "()V", "a", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: AdSettings.kt */
public final class AdSettings {
    private static final String ASSET_KEY = "assetKey";
    private static final String CHILD_DIRECTED_KEY = "childDirected";
    public static final AdSettings INSTANCE = new AdSettings();
    private static final String MAX_CONTENT_RATING_KEY = "maxContentRating";
    private static final String USER_ID_KEY = "userId";
    private static final List<a> listeners = new ArrayList();

    @Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/wortise/ads/AdSettings$a;", "", "", "enabled", "", "a", "Lcom/wortise/ads/AdContentRating;", "rating", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* compiled from: AdSettings.kt */
    public interface a {

        @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
        /* renamed from: com.wortise.ads.AdSettings$a$a  reason: collision with other inner class name */
        /* compiled from: AdSettings.kt */
        public static final class C0176a {
            public static void a(a aVar, AdContentRating adContentRating) {
                Intrinsics.checkNotNullParameter(aVar, "this");
            }
        }

        void a(AdContentRating adContentRating);

        void a(boolean z);
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.wortise.ads.AdSettings", f = "AdSettings.kt", i = {0}, l = {33}, m = "onChildDirectedChange", n = {"enabled"}, s = {"Z$0"})
    /* compiled from: AdSettings.kt */
    static final class b extends ContinuationImpl {
        boolean a;
        /* synthetic */ Object b;
        final /* synthetic */ AdSettings c;
        int d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(AdSettings adSettings, Continuation<? super b> continuation) {
            super(continuation);
            this.c = adSettings;
        }

        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return this.c.onChildDirectedChange((Context) null, false, this);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n"}, d2 = {"Landroid/content/SharedPreferences$Editor;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: AdSettings.kt */
    static final class c extends Lambda implements Function1<SharedPreferences.Editor, Unit> {
        final /* synthetic */ String a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(String str) {
            super(1);
            this.a = str;
        }

        public final void a(SharedPreferences.Editor editor) {
            Intrinsics.checkNotNullParameter(editor, "$this$edit");
            editor.putString(AdSettings.ASSET_KEY, this.a);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((SharedPreferences.Editor) obj);
            return Unit.INSTANCE;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n"}, d2 = {"Landroid/content/SharedPreferences$Editor;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: AdSettings.kt */
    static final class d extends Lambda implements Function1<SharedPreferences.Editor, Unit> {
        final /* synthetic */ boolean a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(boolean z) {
            super(1);
            this.a = z;
        }

        public final void a(SharedPreferences.Editor editor) {
            Intrinsics.checkNotNullParameter(editor, "$this$edit");
            editor.putBoolean(AdSettings.CHILD_DIRECTED_KEY, this.a);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((SharedPreferences.Editor) obj);
            return Unit.INSTANCE;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.wortise.ads.AdSettings$setChildDirected$2", f = "AdSettings.kt", i = {}, l = {83}, m = "invokeSuspend", n = {}, s = {})
    /* compiled from: AdSettings.kt */
    static final class e extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int a;
        final /* synthetic */ Context b;
        final /* synthetic */ boolean c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(Context context, boolean z, Continuation<? super e> continuation) {
            super(2, continuation);
            this.b = context;
            this.c = z;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((e) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new e(this.b, this.c, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AdSettings adSettings = AdSettings.INSTANCE;
                Context context = this.b;
                boolean z = this.c;
                this.a = 1;
                if (adSettings.onChildDirectedChange(context, z, this) == coroutine_suspended) {
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

    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n"}, d2 = {"Landroid/content/SharedPreferences$Editor;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: AdSettings.kt */
    static final class f extends Lambda implements Function1<SharedPreferences.Editor, Unit> {
        final /* synthetic */ AdContentRating a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(AdContentRating adContentRating) {
            super(1);
            this.a = adContentRating;
        }

        public final void a(SharedPreferences.Editor editor) {
            Intrinsics.checkNotNullParameter(editor, "$this$edit");
            g6.a(editor, AdSettings.MAX_CONTENT_RATING_KEY, (Enum<?>) this.a);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((SharedPreferences.Editor) obj);
            return Unit.INSTANCE;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n"}, d2 = {"Landroid/content/SharedPreferences$Editor;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: AdSettings.kt */
    static final class g extends Lambda implements Function1<SharedPreferences.Editor, Unit> {
        final /* synthetic */ String a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(String str) {
            super(1);
            this.a = str;
        }

        public final void a(SharedPreferences.Editor editor) {
            Intrinsics.checkNotNullParameter(editor, "$this$edit");
            editor.putString("userId", this.a);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((SharedPreferences.Editor) obj);
            return Unit.INSTANCE;
        }
    }

    private AdSettings() {
    }

    @JvmStatic
    public static final String getAssetKey(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return r5.a.a(context).getString(ASSET_KEY, (String) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001f  */
    @kotlin.jvm.JvmStatic
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final com.wortise.ads.AdContentRating getMaxAdContentRating(android.content.Context r2) {
        /*
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            com.wortise.ads.r5 r0 = com.wortise.ads.r5.a
            android.content.SharedPreferences r2 = r0.a(r2)
            java.lang.String r0 = "maxContentRating"
            r1 = 0
            java.lang.String r2 = r2.getString(r0, r1)     // Catch:{ all -> 0x001a }
            if (r2 != 0) goto L_0x0015
            goto L_0x001b
        L_0x0015:
            com.wortise.ads.AdContentRating r2 = com.wortise.ads.AdContentRating.valueOf(r2)     // Catch:{ all -> 0x001a }
            goto L_0x001c
        L_0x001a:
        L_0x001b:
            r2 = r1
        L_0x001c:
            if (r2 != 0) goto L_0x001f
            goto L_0x0020
        L_0x001f:
            r1 = r2
        L_0x0020:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wortise.ads.AdSettings.getMaxAdContentRating(android.content.Context):com.wortise.ads.AdContentRating");
    }

    @JvmStatic
    public static final String getUserId(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return r5.a.a(context).getString("userId", (String) null);
    }

    @JvmStatic
    public static final boolean isChildDirected(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return r5.a.a(context).getBoolean(CHILD_DIRECTED_KEY, false);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x004f A[LOOP:0: B:16:0x0049->B:18:0x004f, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object onChildDirectedChange(android.content.Context r5, boolean r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.wortise.ads.AdSettings.b
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.wortise.ads.AdSettings$b r0 = (com.wortise.ads.AdSettings.b) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.d = r1
            goto L_0x0018
        L_0x0013:
            com.wortise.ads.AdSettings$b r0 = new com.wortise.ads.AdSettings$b
            r0.<init>(r4, r7)
        L_0x0018:
            java.lang.Object r7 = r0.b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L_0x0033
            if (r2 != r3) goto L_0x002b
            boolean r6 = r0.a
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0043
        L_0x002b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0033:
            kotlin.ResultKt.throwOnFailure(r7)
            com.wortise.ads.identifier.IdentifierManager r7 = com.wortise.ads.identifier.IdentifierManager.INSTANCE
            r0.a = r6
            r0.d = r3
            java.lang.Object r5 = r7.refresh(r5, r0)
            if (r5 != r1) goto L_0x0043
            return r1
        L_0x0043:
            java.util.List<com.wortise.ads.AdSettings$a> r5 = listeners
            java.util.Iterator r5 = r5.iterator()
        L_0x0049:
            boolean r7 = r5.hasNext()
            if (r7 == 0) goto L_0x0059
            java.lang.Object r7 = r5.next()
            com.wortise.ads.AdSettings$a r7 = (com.wortise.ads.AdSettings.a) r7
            r7.a((boolean) r6)
            goto L_0x0049
        L_0x0059:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wortise.ads.AdSettings.onChildDirectedChange(android.content.Context, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @JvmStatic
    public static final void setChildDirected(Context context, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (isChildDirected(context) != z) {
            r5.a.a(context, new d(z));
            Job unused = BuildersKt__Builders_commonKt.launch$default(c2.c(), (CoroutineContext) null, (CoroutineStart) null, new e(context, z, (Continuation<? super e>) null), 3, (Object) null);
        }
    }

    @JvmStatic
    public static final void setMaxAdContentRating(Context context, AdContentRating adContentRating) {
        Intrinsics.checkNotNullParameter(context, "context");
        r5.a.a(context, new f(adContentRating));
        for (a a2 : listeners) {
            a2.a(adContentRating);
        }
    }

    @JvmStatic
    public static final void setUserId(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        r5.a.a(context, new g(str));
    }

    public final void addListener$sdk_productionRelease(a aVar) {
        Intrinsics.checkNotNullParameter(aVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        listeners.add(aVar);
    }

    public final String requireAssetKey$sdk_productionRelease(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String assetKey = getAssetKey(context);
        if (assetKey != null) {
            return assetKey;
        }
        throw new IllegalArgumentException("The SDK has not yet been initialized".toString());
    }

    public final void setAssetKey$sdk_productionRelease(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "key");
        r5.a.a(context, new c(str));
    }
}

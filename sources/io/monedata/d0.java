package io.monedata;

import android.content.Context;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ%\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"Lio/monedata/d0;", "", "Landroid/content/Context;", "context", "", "locale", "Lio/monedata/consent/models/ConsentSettings;", "a", "(Landroid/content/Context;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<init>", "()V", "core_productionRelease"}, k = 1, mv = {1, 7, 1})
public final class d0 {
    public static final d0 a = new d0();

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "io.monedata.consent.ConsentUtils", f = "ConsentUtils.kt", i = {}, l = {22}, m = "getSettings", n = {}, s = {})
    static final class a extends ContinuationImpl {
        /* synthetic */ Object a;
        final /* synthetic */ d0 b;
        int c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(d0 d0Var, Continuation<? super a> continuation) {
            super(continuation);
            this.b = d0Var;
        }

        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= Integer.MIN_VALUE;
            return this.b.a((Context) null, (String) null, this);
        }
    }

    private d0() {
    }

    public static /* synthetic */ Object a(d0 d0Var, Context context, String str, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
            str = locale.getLanguage();
            Intrinsics.checkNotNullExpressionValue(str, "defaultLocale.language");
        }
        return d0Var.a(context, str, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(android.content.Context r5, java.lang.String r6, kotlin.coroutines.Continuation<? super io.monedata.consent.models.ConsentSettings> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof io.monedata.d0.a
            if (r0 == 0) goto L_0x0013
            r0 = r7
            io.monedata.d0$a r0 = (io.monedata.d0.a) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.c = r1
            goto L_0x0018
        L_0x0013:
            io.monedata.d0$a r0 = new io.monedata.d0$a
            r0.<init>(r4, r7)
        L_0x0018:
            java.lang.Object r7 = r0.a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0047
        L_0x0029:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r7)
            io.monedata.Settings r7 = io.monedata.Settings.INSTANCE
            java.lang.String r5 = r7.requireAssetKey$core_productionRelease(r5)
            io.monedata.b0 r7 = io.monedata.c0.a()
            r0.c = r3
            java.lang.Object r7 = r7.a(r5, r6, r0)
            if (r7 != r1) goto L_0x0047
            return r1
        L_0x0047:
            io.monedata.o1 r7 = (io.monedata.o1) r7
            java.lang.Object r5 = r7.b()
            if (r5 == 0) goto L_0x0050
            return r5
        L_0x0050:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r6 = "Required value was null."
            java.lang.String r6 = r6.toString()
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.monedata.d0.a(android.content.Context, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}

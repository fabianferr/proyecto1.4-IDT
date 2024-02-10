package io.monedata;

import android.content.Context;
import io.monedata.consent.models.ConsentData;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ+\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {"Lio/monedata/a0;", "", "Landroid/content/Context;", "context", "", "assetKey", "Lio/monedata/consent/models/ConsentData;", "consent", "Lio/monedata/z;", "a", "(Landroid/content/Context;Ljava/lang/String;Lio/monedata/consent/models/ConsentData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<init>", "()V", "core_productionRelease"}, k = 1, mv = {1, 7, 1})
public final class a0 {
    public static final a0 a = new a0();

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "io.monedata.consent.factories.ConsentRequestFactory", f = "ConsentRequestFactory.kt", i = {0, 0}, l = {14}, m = "create", n = {"assetKey", "consent"}, s = {"L$0", "L$1"})
    static final class a extends ContinuationImpl {
        Object a;
        Object b;
        /* synthetic */ Object c;
        final /* synthetic */ a0 d;
        int e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(a0 a0Var, Continuation<? super a> continuation) {
            super(continuation);
            this.d = a0Var;
        }

        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            return this.d.a((Context) null, (String) null, (ConsentData) null, this);
        }
    }

    private a0() {
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: io.monedata.consent.models.ConsentData} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(android.content.Context r5, java.lang.String r6, io.monedata.consent.models.ConsentData r7, kotlin.coroutines.Continuation<? super io.monedata.z> r8) {
        /*
            r4 = this;
            boolean r0 = r8 instanceof io.monedata.a0.a
            if (r0 == 0) goto L_0x0013
            r0 = r8
            io.monedata.a0$a r0 = (io.monedata.a0.a) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.e = r1
            goto L_0x0018
        L_0x0013:
            io.monedata.a0$a r0 = new io.monedata.a0$a
            r0.<init>(r4, r8)
        L_0x0018:
            java.lang.Object r8 = r0.c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.e
            r3 = 1
            if (r2 == 0) goto L_0x003b
            if (r2 != r3) goto L_0x0033
            java.lang.Object r5 = r0.b
            r7 = r5
            io.monedata.consent.models.ConsentData r7 = (io.monedata.consent.models.ConsentData) r7
            java.lang.Object r5 = r0.a
            r6 = r5
            java.lang.String r6 = (java.lang.String) r6
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x004d
        L_0x0033:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x003b:
            kotlin.ResultKt.throwOnFailure(r8)
            io.monedata.identifier.IdentifierManager r8 = io.monedata.identifier.IdentifierManager.INSTANCE
            r0.a = r6
            r0.b = r7
            r0.e = r3
            java.lang.Object r8 = r8.fetch(r5, r0)
            if (r8 != r1) goto L_0x004d
            return r1
        L_0x004d:
            io.monedata.identifier.Identifier r8 = (io.monedata.identifier.Identifier) r8
            io.monedata.z r5 = new io.monedata.z
            java.lang.String r8 = r8.getId()
            r5.<init>(r6, r7, r8)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.monedata.a0.a(android.content.Context, java.lang.String, io.monedata.consent.models.ConsentData, kotlin.coroutines.Continuation):java.lang.Object");
    }
}

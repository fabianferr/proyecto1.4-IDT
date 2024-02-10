package io.monedata;

import android.content.Context;
import io.monedata.partners.PartnerAdapter;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ#\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"Lio/monedata/c;", "", "Landroid/content/Context;", "context", "Lio/monedata/partners/PartnerAdapter;", "partner", "Lio/monedata/b;", "a", "(Landroid/content/Context;Lio/monedata/partners/PartnerAdapter;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<init>", "()V", "core_productionRelease"}, k = 1, mv = {1, 7, 1})
public final class c {
    public static final c a = new c();

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "io.monedata.models.factories.AdapterFactory", f = "AdapterFactory.kt", i = {0}, l = {12}, m = "create", n = {"partner"}, s = {"L$0"})
    static final class a extends ContinuationImpl {
        Object a;
        /* synthetic */ Object b;
        final /* synthetic */ c c;
        int d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(c cVar, Continuation<? super a> continuation) {
            super(continuation);
            this.c = cVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return this.c.a((Context) null, (PartnerAdapter) null, this);
        }
    }

    private c() {
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: io.monedata.partners.PartnerAdapter} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(android.content.Context r5, io.monedata.partners.PartnerAdapter r6, kotlin.coroutines.Continuation<? super io.monedata.b> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof io.monedata.c.a
            if (r0 == 0) goto L_0x0013
            r0 = r7
            io.monedata.c$a r0 = (io.monedata.c.a) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.d = r1
            goto L_0x0018
        L_0x0013:
            io.monedata.c$a r0 = new io.monedata.c$a
            r0.<init>(r4, r7)
        L_0x0018:
            java.lang.Object r7 = r0.b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r5 = r0.a
            r6 = r5
            io.monedata.partners.PartnerAdapter r6 = (io.monedata.partners.PartnerAdapter) r6
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0044
        L_0x002e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r7)
            r0.a = r6
            r0.d = r3
            java.lang.Object r7 = r6.getExtras(r5, r0)
            if (r7 != r1) goto L_0x0044
            return r1
        L_0x0044:
            io.monedata.models.Extras r7 = (io.monedata.models.Extras) r7
            java.lang.String r5 = r6.getId()
            java.lang.String r6 = r6.getVersion()
            io.monedata.b r0 = new io.monedata.b
            r0.<init>(r7, r5, r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.monedata.c.a(android.content.Context, io.monedata.partners.PartnerAdapter, kotlin.coroutines.Continuation):java.lang.Object");
    }
}

package io.monedata.partners;

import android.content.Context;
import io.monedata.consent.models.ConsentData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b'\u0018\u00002\u00020\u0001B#\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J!\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0002\u0010\rJ\u001b\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0011\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0010\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Lio/monedata/partners/ConsentPartnerAdapter;", "Lio/monedata/partners/PartnerAdapter;", "id", "", "name", "version", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "onConsentChange", "", "context", "Landroid/content/Context;", "consent", "Lio/monedata/consent/models/ConsentData;", "(Landroid/content/Context;Lio/monedata/consent/models/ConsentData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostInitialize", "onPostInitialize$core_productionRelease", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPreStart", "onPreStart$core_productionRelease", "core_productionRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class ConsentPartnerAdapter extends PartnerAdapter {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "io.monedata.partners.ConsentPartnerAdapter", f = "ConsentPartnerAdapter.kt", i = {0, 0, 0}, l = {14, 17, 17}, m = "onConsentChange$suspendImpl", n = {"$this", "context", "consent"}, s = {"L$0", "L$1", "L$2"})
    static final class a extends ContinuationImpl {
        Object a;
        Object b;
        Object c;
        /* synthetic */ Object d;
        final /* synthetic */ ConsentPartnerAdapter e;
        int f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(ConsentPartnerAdapter consentPartnerAdapter, Continuation<? super a> continuation) {
            super(continuation);
            this.e = consentPartnerAdapter;
        }

        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= Integer.MIN_VALUE;
            return ConsentPartnerAdapter.onConsentChange$suspendImpl(this.e, (Context) null, (ConsentData) null, this);
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "io.monedata.partners.ConsentPartnerAdapter", f = "ConsentPartnerAdapter.kt", i = {0, 0}, l = {28, 31}, m = "onPostInitialize$suspendImpl", n = {"$this", "context"}, s = {"L$0", "L$1"})
    static final class b extends ContinuationImpl {
        Object a;
        Object b;
        /* synthetic */ Object c;
        final /* synthetic */ ConsentPartnerAdapter d;
        int e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(ConsentPartnerAdapter consentPartnerAdapter, Continuation<? super b> continuation) {
            super(continuation);
            this.d = consentPartnerAdapter;
        }

        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            return ConsentPartnerAdapter.onPostInitialize$suspendImpl(this.d, (Context) null, this);
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "io.monedata.partners.ConsentPartnerAdapter", f = "ConsentPartnerAdapter.kt", i = {0, 0}, l = {21}, m = "onPreStart$suspendImpl", n = {"$this", "context"}, s = {"L$0", "L$1"})
    static final class c extends ContinuationImpl {
        Object a;
        Object b;
        /* synthetic */ Object c;
        final /* synthetic */ ConsentPartnerAdapter d;
        int e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(ConsentPartnerAdapter consentPartnerAdapter, Continuation<? super c> continuation) {
            super(continuation);
            this.d = consentPartnerAdapter;
        }

        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            return ConsentPartnerAdapter.onPreStart$suspendImpl(this.d, (Context) null, this);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 7, 1})
    static final class d extends Lambda implements Function0<String> {
        public static final d a = new d();

        d() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Consent requirements are not met";
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ConsentPartnerAdapter(String str, String str2) {
        this(str, str2, (String) null, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "name");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ConsentPartnerAdapter(String str, String str2, String str3) {
        super(str, str2, str3);
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "name");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ConsentPartnerAdapter(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? null : str3);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: io.monedata.consent.models.ConsentData} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: android.content.Context} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ java.lang.Object onConsentChange$suspendImpl(io.monedata.partners.ConsentPartnerAdapter r6, android.content.Context r7, io.monedata.consent.models.ConsentData r8, kotlin.coroutines.Continuation r9) {
        /*
            boolean r0 = r9 instanceof io.monedata.partners.ConsentPartnerAdapter.a
            if (r0 == 0) goto L_0x0013
            r0 = r9
            io.monedata.partners.ConsentPartnerAdapter$a r0 = (io.monedata.partners.ConsentPartnerAdapter.a) r0
            int r1 = r0.f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f = r1
            goto L_0x0018
        L_0x0013:
            io.monedata.partners.ConsentPartnerAdapter$a r0 = new io.monedata.partners.ConsentPartnerAdapter$a
            r0.<init>(r6, r9)
        L_0x0018:
            java.lang.Object r9 = r0.d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x004d
            if (r2 == r5) goto L_0x003b
            if (r2 == r4) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0081
        L_0x002f:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0075
        L_0x003b:
            java.lang.Object r6 = r0.c
            r8 = r6
            io.monedata.consent.models.ConsentData r8 = (io.monedata.consent.models.ConsentData) r8
            java.lang.Object r6 = r0.b
            r7 = r6
            android.content.Context r7 = (android.content.Context) r7
            java.lang.Object r6 = r0.a
            io.monedata.partners.ConsentPartnerAdapter r6 = (io.monedata.partners.ConsentPartnerAdapter) r6
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x005f
        L_0x004d:
            kotlin.ResultKt.throwOnFailure(r9)
            r0.a = r6
            r0.b = r7
            r0.c = r8
            r0.f = r5
            java.lang.Object r9 = super.onConsentChange(r7, r8, r0)
            if (r9 != r1) goto L_0x005f
            return r1
        L_0x005f:
            boolean r8 = r6.hasConsent(r7, r8)
            r9 = 0
            r0.a = r9
            r0.b = r9
            r0.c = r9
            if (r8 == 0) goto L_0x0078
            r0.f = r4
            java.lang.Object r6 = r6.internalStart$core_productionRelease(r7, r0)
            if (r6 != r1) goto L_0x0075
            return r1
        L_0x0075:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L_0x0078:
            r0.f = r3
            java.lang.Object r6 = r6.internalStop$core_productionRelease(r7, r0)
            if (r6 != r1) goto L_0x0081
            return r1
        L_0x0081:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.monedata.partners.ConsentPartnerAdapter.onConsentChange$suspendImpl(io.monedata.partners.ConsentPartnerAdapter, android.content.Context, io.monedata.consent.models.ConsentData, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: android.content.Context} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ java.lang.Object onPostInitialize$suspendImpl(io.monedata.partners.ConsentPartnerAdapter r5, android.content.Context r6, kotlin.coroutines.Continuation r7) {
        /*
            boolean r0 = r7 instanceof io.monedata.partners.ConsentPartnerAdapter.b
            if (r0 == 0) goto L_0x0013
            r0 = r7
            io.monedata.partners.ConsentPartnerAdapter$b r0 = (io.monedata.partners.ConsentPartnerAdapter.b) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.e = r1
            goto L_0x0018
        L_0x0013:
            io.monedata.partners.ConsentPartnerAdapter$b r0 = new io.monedata.partners.ConsentPartnerAdapter$b
            r0.<init>(r5, r7)
        L_0x0018:
            java.lang.Object r7 = r0.c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.e
            r3 = 1
            r4 = 2
            if (r2 == 0) goto L_0x0041
            if (r2 == r3) goto L_0x0034
            if (r2 != r4) goto L_0x002c
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0065
        L_0x002c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0034:
            java.lang.Object r5 = r0.b
            r6 = r5
            android.content.Context r6 = (android.content.Context) r6
            java.lang.Object r5 = r0.a
            io.monedata.partners.ConsentPartnerAdapter r5 = (io.monedata.partners.ConsentPartnerAdapter) r5
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0051
        L_0x0041:
            kotlin.ResultKt.throwOnFailure(r7)
            r0.a = r5
            r0.b = r6
            r0.e = r3
            java.lang.Object r7 = super.onPostInitialize$core_productionRelease(r6, r0)
            if (r7 != r1) goto L_0x0051
            return r1
        L_0x0051:
            r7 = 0
            boolean r2 = io.monedata.partners.bases.BaseConsentPartnerAdapter.hasConsent$default(r5, r6, r7, r4, r7)
            if (r2 != 0) goto L_0x0068
            r0.a = r7
            r0.b = r7
            r0.e = r4
            java.lang.Object r5 = r5.internalStop$core_productionRelease(r6, r0)
            if (r5 != r1) goto L_0x0065
            return r1
        L_0x0065:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L_0x0068:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.monedata.partners.ConsentPartnerAdapter.onPostInitialize$suspendImpl(io.monedata.partners.ConsentPartnerAdapter, android.content.Context, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: android.content.Context} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ java.lang.Object onPreStart$suspendImpl(io.monedata.partners.ConsentPartnerAdapter r4, android.content.Context r5, kotlin.coroutines.Continuation r6) {
        /*
            boolean r0 = r6 instanceof io.monedata.partners.ConsentPartnerAdapter.c
            if (r0 == 0) goto L_0x0013
            r0 = r6
            io.monedata.partners.ConsentPartnerAdapter$c r0 = (io.monedata.partners.ConsentPartnerAdapter.c) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.e = r1
            goto L_0x0018
        L_0x0013:
            io.monedata.partners.ConsentPartnerAdapter$c r0 = new io.monedata.partners.ConsentPartnerAdapter$c
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.e
            r3 = 1
            if (r2 == 0) goto L_0x003a
            if (r2 != r3) goto L_0x0032
            java.lang.Object r4 = r0.b
            r5 = r4
            android.content.Context r5 = (android.content.Context) r5
            java.lang.Object r4 = r0.a
            io.monedata.partners.ConsentPartnerAdapter r4 = (io.monedata.partners.ConsentPartnerAdapter) r4
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x004a
        L_0x0032:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x003a:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.a = r4
            r0.b = r5
            r0.e = r3
            java.lang.Object r6 = super.onPreStart$core_productionRelease(r5, r0)
            if (r6 != r1) goto L_0x004a
            return r1
        L_0x004a:
            r6 = 2
            r0 = 0
            boolean r5 = io.monedata.partners.bases.BaseConsentPartnerAdapter.hasConsent$default(r4, r5, r0, r6, r0)
            io.monedata.partners.ConsentPartnerAdapter$d r6 = io.monedata.partners.ConsentPartnerAdapter.d.a
            io.monedata.partners.extensions.PartnerAdapterKt.test(r4, r5, r6)
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.monedata.partners.ConsentPartnerAdapter.onPreStart$suspendImpl(io.monedata.partners.ConsentPartnerAdapter, android.content.Context, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: protected */
    public Object onConsentChange(Context context, ConsentData consentData, Continuation<? super Unit> continuation) {
        return onConsentChange$suspendImpl(this, context, consentData, continuation);
    }

    public Object onPostInitialize$core_productionRelease(Context context, Continuation<? super Unit> continuation) {
        return onPostInitialize$suspendImpl(this, context, continuation);
    }

    public Object onPreStart$core_productionRelease(Context context, Continuation<? super Unit> continuation) {
        return onPreStart$suspendImpl(this, context, continuation);
    }
}

package io.monedata.partners.bases;

import android.content.Context;
import io.monedata.models.Extras;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b'\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u001b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ!\u0010\u0010\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0002\u0010\u0013J\u0019\u0010\u0014\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u000eH@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\u0019\u0010\u0015\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u000eH@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0016\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u000eH\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"Lio/monedata/partners/bases/BasePartnerAdapter;", "", "id", "", "name", "version", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "getVersion", "onExtras", "Lio/monedata/models/Extras;", "context", "Landroid/content/Context;", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onInitialize", "", "extras", "(Landroid/content/Context;Lio/monedata/models/Extras;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onStart", "onStop", "onWarmUp", "core_productionRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class BasePartnerAdapter {
    private final String id;
    private final String name;
    private final String version;

    public BasePartnerAdapter(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "name");
        this.id = str;
        this.name = str2;
        this.version = str3;
    }

    static /* synthetic */ Object onExtras$suspendImpl(BasePartnerAdapter basePartnerAdapter, Context context, Continuation continuation) {
        return null;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getVersion() {
        return this.version;
    }

    /* access modifiers changed from: protected */
    public Object onExtras(Context context, Continuation<? super Extras> continuation) {
        return onExtras$suspendImpl(this, context, continuation);
    }

    /* access modifiers changed from: protected */
    public Object onInitialize(Context context, Extras extras, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: protected */
    public Object onStart(Context context, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: protected */
    public Object onStop(Context context, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: protected */
    public void onWarmUp(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
    }
}

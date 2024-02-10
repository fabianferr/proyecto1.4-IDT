package com.wortise.ads;

import android.content.Context;
import com.wortise.ads.identifier.Identifier;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H¤@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lcom/wortise/ads/s;", "", "Landroid/content/Context;", "context", "Lcom/wortise/ads/identifier/Identifier;", "a", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "b", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: AdvertisingId.kt */
public abstract class s {
    /* access modifiers changed from: protected */
    public abstract Object a(Context context, Continuation<? super Identifier> continuation);

    public final Object b(Context context, Continuation<? super Identifier> continuation) {
        return a(context, continuation);
    }
}

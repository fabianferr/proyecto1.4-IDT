package com.wortise.ads;

import android.content.Context;
import com.google.gson.annotations.SerializedName;
import com.wortise.ads.identifier.IdentifierType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0015\u0010\u0016B\u0011\b\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0015\u0010\u0019R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0016@\u0016X.¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u000b\u0010\u0014¨\u0006\u001a"}, d2 = {"Lcom/wortise/ads/l0;", "Lcom/wortise/ads/h4;", "", "assetKey", "Ljava/lang/String;", "getAssetKey", "()Ljava/lang/String;", "c", "(Ljava/lang/String;)V", "auid", "getAuid", "a", "udid", "getUdid", "b", "Lcom/wortise/ads/identifier/IdentifierType;", "udidType", "Lcom/wortise/ads/identifier/IdentifierType;", "getUdidType", "()Lcom/wortise/ads/identifier/IdentifierType;", "(Lcom/wortise/ads/identifier/IdentifierType;)V", "<init>", "()V", "Landroid/content/Context;", "context", "(Landroid/content/Context;)V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: BaseRequest.kt */
public class l0 implements h4 {
    @SerializedName("assetKey")
    private String a;
    @SerializedName("auid")
    public String b;
    @SerializedName("udid")
    private String c;
    @SerializedName("udidType")
    private IdentifierType d;

    public l0() {
    }

    public void a(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.b = str;
    }

    public void b(String str) {
        this.c = str;
    }

    public void c(String str) {
        this.a = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public l0(Context context) {
        this();
        Intrinsics.checkNotNullParameter(context, "context");
        i4.a(this, context);
    }

    public void a(IdentifierType identifierType) {
        this.d = identifierType;
    }
}

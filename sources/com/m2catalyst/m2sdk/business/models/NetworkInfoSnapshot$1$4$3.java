package com.m2catalyst.m2sdk.business.models;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: NetworkInfoSnapshot.kt */
public final class NetworkInfoSnapshot$1$4$3 extends Lambda implements Function0<Integer> {
    final /* synthetic */ NetworkInfoSnapshot this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NetworkInfoSnapshot$1$4$3(NetworkInfoSnapshot networkInfoSnapshot) {
        super(0);
        this.this$0 = networkInfoSnapshot;
    }

    public final Integer invoke() {
        String networkMccStr = this.this$0.getNetworkMccStr();
        if (networkMccStr != null) {
            return Integer.valueOf(Integer.parseInt(networkMccStr));
        }
        return null;
    }
}

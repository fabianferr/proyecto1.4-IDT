package com.wortise.ads;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0013\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0010"}, d2 = {"Lcom/wortise/ads/RequestParameters;", "", "agent", "", "(Ljava/lang/String;)V", "getAgent", "()Ljava/lang/String;", "setAgent", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: RequestParameters.kt */
public final class RequestParameters {
    private String agent;

    public RequestParameters() {
        this((String) null, 1, (DefaultConstructorMarker) null);
    }

    public RequestParameters(String str) {
        this.agent = str;
    }

    public static /* synthetic */ RequestParameters copy$default(RequestParameters requestParameters, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = requestParameters.agent;
        }
        return requestParameters.copy(str);
    }

    public final String component1() {
        return this.agent;
    }

    public final RequestParameters copy(String str) {
        return new RequestParameters(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof RequestParameters) && Intrinsics.areEqual((Object) this.agent, (Object) ((RequestParameters) obj).agent);
    }

    public final String getAgent() {
        return this.agent;
    }

    public int hashCode() {
        String str = this.agent;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public final void setAgent(String str) {
        this.agent = str;
    }

    public String toString() {
        return "RequestParameters(agent=" + this.agent + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RequestParameters(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str);
    }
}

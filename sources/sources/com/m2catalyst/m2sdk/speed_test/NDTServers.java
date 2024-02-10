package com.m2catalyst.m2sdk.speed_test;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/m2catalyst/m2sdk/speed_test/NDTServers;", "", "servers", "", "", "(Ljava/util/List;)V", "getServers", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "m2sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: SpeedTestNDTApiClient.kt */
public final class NDTServers {
    private final List<String> servers;

    public NDTServers() {
        this((List) null, 1, (DefaultConstructorMarker) null);
    }

    public NDTServers(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "servers");
        this.servers = list;
    }

    public static /* synthetic */ NDTServers copy$default(NDTServers nDTServers, List<String> list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = nDTServers.servers;
        }
        return nDTServers.copy(list);
    }

    public final List<String> component1() {
        return this.servers;
    }

    public final NDTServers copy(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "servers");
        return new NDTServers(list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof NDTServers) && Intrinsics.areEqual((Object) this.servers, (Object) ((NDTServers) obj).servers);
    }

    public final List<String> getServers() {
        return this.servers;
    }

    public int hashCode() {
        return this.servers.hashCode();
    }

    public String toString() {
        List<String> list = this.servers;
        return "NDTServers(servers=" + list + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NDTServers(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list);
    }
}

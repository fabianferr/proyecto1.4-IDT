package com.ironsource.mediationsdk.demandOnly;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\bJ'\u0010\u0003\u001a\u0002H\u0004\"\u0004\b\u0000\u0010\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H\u00040\u0006H&¢\u0006\u0002\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/ironsource/mediationsdk/demandOnly/ISEnrichedAdm;", "Lcom/ironsource/mediationsdk/Envelop;", "", "map", "T", "mapper", "Lcom/ironsource/mediationsdk/Mapper;", "(Lcom/ironsource/mediationsdk/Mapper;)Ljava/lang/Object;", "Base", "mediationsdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface o {

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0003H\u0016J'\u0010\u0006\u001a\u0002H\u0007\"\u0004\b\u0000\u0010\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u0002H\u00070\tH\u0016¢\u0006\u0002\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/ironsource/mediationsdk/demandOnly/ISEnrichedAdm$Base;", "Lcom/ironsource/mediationsdk/demandOnly/ISEnrichedAdm;", "rowAdm", "", "(Ljava/lang/String;)V", "content", "map", "T", "mapper", "Lcom/ironsource/mediationsdk/Mapper;", "(Lcom/ironsource/mediationsdk/Mapper;)Ljava/lang/Object;", "mediationsdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a implements o {
        private final String a;

        public a(String str) {
            Intrinsics.checkNotNullParameter(str, "rowAdm");
            this.a = str;
        }

        public final <T> T a(l<String, T> lVar) {
            Intrinsics.checkNotNullParameter(lVar, "mapper");
            return lVar.a(this.a);
        }
    }

    <T> T a(l<String, T> lVar);
}

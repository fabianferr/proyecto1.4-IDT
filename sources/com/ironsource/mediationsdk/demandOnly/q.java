package com.ironsource.mediationsdk.demandOnly;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0004\u0005J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0006"}, d2 = {"Lcom/ironsource/mediationsdk/demandOnly/Plumbus;", "", "value", "", "Base", "Empty", "mediationsdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface q {

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/ironsource/mediationsdk/demandOnly/Plumbus$Base;", "Lcom/ironsource/mediationsdk/demandOnly/Plumbus;", "plumbus", "", "(Ljava/lang/String;)V", "value", "mediationsdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static class a implements q {
        private final String a;

        public a(String str) {
            Intrinsics.checkNotNullParameter(str, "plumbus");
            this.a = str;
        }

        public final String a() {
            return this.a;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/ironsource/mediationsdk/demandOnly/Plumbus$Empty;", "Lcom/ironsource/mediationsdk/demandOnly/Plumbus$Base;", "()V", "mediationsdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b extends a {
        public b() {
            super("");
        }
    }

    String a();
}
